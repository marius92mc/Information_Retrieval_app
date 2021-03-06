//package org.apache.lucene.demo;
/*
004 * Licensed to the Apache Software Foundation (ASF) under one or more
005 * contributor license agreements.  See the NOTICE file distributed with
006 * this work for additional information regarding copyright ownership.
007 * The ASF licenses this file to You under the Apache License, Version 2.0
008 * (the "License"); you may not use this file except in compliance with
009 * the License.  You may obtain a copy of the License at
010 *
011 *     http://www.apache.org/licenses/LICENSE-2.0
012 *
013 * Unless required by applicable law or agreed to in writing, software
014 * distributed under the License is distributed on an "AS IS" BASIS,
015 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
016 * See the License for the specific language governing permissions and
017 * limitations under the License.
018 */
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.StringTokenizer;

//import org.apache.tika.parser.html.HtmlParser;

/** Index all text files under a directory.
  * <p>
  * This is a command-line application demonstrating simple Lucene indexing.
  * Run it with no command-line arguments for usage information.
 */
public class IndexFiles {
  private static String fileContent;
  private static boolean docsWithDescription = false;
  private static int nrOfWordsInDescription = 10;

  private IndexFiles() {}

  /** Index all text files under a directory. */
  public static void main(String[] args)  {
    String usage = "java org.apache.lucene.demo.IndexFiles"
                 + " [-index INDEX_PATH] [-docs DOCS_PATH] [-update]\n\n"
                 + "This indexes the documents in DOCS_PATH, creating a Lucene index"
                 + "in INDEX_PATH that can be searched with SearchFiles";
    String indexPath = "index";
    String docsPath = null;
    boolean create = true;
    
    for (int i = 0; i < args.length; i++)  {
      if ("-index".equals(args[i]))  {
        indexPath = args[i+1];
        i++;
      } 
      else 
          if ("-docs".equals(args[i]))  {
            docsPath = args[i+1];
            i++;
          } 
          else 
              if ("-update".equals(args[i]))  {
                create = false;
              }
              else
                  if ("-description".equals(args[i])) {
                      docsWithDescription = true;
                  }
    } /* for */

    if (docsPath == null)  {
      System.err.println("Usage: " + usage);
      System.exit(1);
    }

    final Path docDir = Paths.get(docsPath);
    
    if (!Files.isReadable(docDir))  {
      System.out.println("Document directory '" + docDir.toAbsolutePath()+ 
                         "' does not exist or is not readable, please check the path");
      System.exit(1);
    }
    
    Date start = new Date();
    try  {
      System.out.println("Indexing to directory '" + indexPath + "'...");

      Directory dir = FSDirectory.open(Paths.get(indexPath));

      //-----
      //-----



      RomanianAnalyzerWithoutDiacritics analyzer = new RomanianAnalyzerWithoutDiacritics();
                                                          // builds an analyzer
                                                          // with the default stopwords 

      IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

      /* Print the default stopword set 
      Set<String> stop_words = new HashSet<String>();
      Iterator iter = RomanianAnalyzer.getDefaultStopSet().iterator();
      
      int i = 0;
      while (iter.hasNext()) {
          char[] stop_word = (char[]) iter.next();
          i++;
          System.out.println(i);
          System.out.println(stop_word);
      }
       */

      if (create)  {
        // Create a new index in the directory, removing any
        // previously indexed documents:
        iwc.setOpenMode(OpenMode.CREATE);
      } 
      else  {
        // Add new documents to an existing index:
        iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
      }

      // Optional: for better indexing performance, if you
      // are indexing many documents, increase the RAM
      // buffer.  But if you do this, increase the max heap
      // size to the JVM (eg add -Xmx512m or -Xmx1g):
      //
      // iwc.setRAMBufferSizeMB(256.0);

      IndexWriter writer = new IndexWriter(dir, iwc);
      indexDocs(writer, docDir);

         // NOTE: if you want to maximize search performance,
      // you can optionally call forceMerge here.  This can be
      // a terribly costly operation, so generally it's only
      // worth it when your index is relatively static (ie
      // you're done adding documents to it):
      //
      // writer.forceMerge(1);

      writer.close();

      Date end = new Date();
      System.out.println(end.getTime() - start.getTime() + 
                         " total milliseconds");

    } /* try */ 
    catch (IOException e)  {
      System.out.println(" caught a " + e.getClass() +
       "\n with message: " + e.getMessage());
    }
  }

    public static String replaceDiacritics(String textFile) throws IOException {

        TokenStream tokenStream = new StandardTokenizer();

        ((Tokenizer) tokenStream).setReader(new StringReader(textFile.trim()));
        tokenStream = new ASCIIFoldingFilter(tokenStream);

        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        tokenStream.reset();

        StringBuilder sb = new StringBuilder();

        while (tokenStream.incrementToken()) {
            char[] term = charTermAttribute.toString().toCharArray();

            ((ASCIIFoldingFilter) tokenStream).foldToASCII(term,term.length);
            sb.append(term);
            sb.append(" ");

        } /* while */

        return sb.toString();
    }

    public static String documentType(String file) {
        String fileType = "Undetermined";
        try {
            final URL url = new URL("file://" + file);
            final URLConnection connection = url.openConnection();
            fileType = connection.getContentType();
        }
        catch (MalformedURLException badUrlEx) {
            System.out.println("ERROR: Bad URL - " + badUrlEx);
        }

        catch (IOException ioEx) {
            System.out.println("Cannot access URLConnection - " + ioEx);
        }

        return fileType;
    }


    /**
   * Indexes the given file using the given writer, or if a directory is given,
   * recurses over files and directories found under the given directory.
   * 
   * NOTE: This method indexes one document per input file.  This is slow.  For good
   * throughput, put multiple documents into your input file(s).  An example of this is
   * in the benchmark module, which can create "line doc" files, one document per line,
   * using the
   * <a href="../../../../../contrib-benchmark/org/apache/lucene/benchmark/byTask/tasks/WriteLineDocTask.html"
   * >WriteLineDocTask</a>.
   *  
   * @param writer Writer to the index where the given file/dir info will be stored
   * @param path The file to index, or the directory to recurse into to find files to index
   * @throws IOException If there is a low-level I/O error
   */
  static void indexDocs(final IndexWriter writer, Path path) throws IOException  {
    if (Files.isDirectory(path))  {
       Files.walkFileTree(path, new SimpleFileVisitor<Path>()  {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {
                try  {
                    indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
                } /* try */
                catch (IOException ignore)  {
                    // don't index files that can't be read.
                } /* catch */
                return FileVisitResult.CONTINUE;
            }
         });
    } 
    else  {
      indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
    }
  }

  /** Indexes a single document */
  static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException {
      try (InputStream stream = Files.newInputStream(file)) {
          try {
              Document doc = new Document();

              Field pathField = new StringField("path", file.toString(), Field.Store.YES);

              doc.add(pathField);
              // Add the last modified date of the file a field named "modified".
              // Use a LongField that is indexed (i.e. efficiently filterable with
              // NumericRangeFilter).  This indexes to milli-second resolution, which
              // is often too fine.  You could instead create a number based on
              // year/month/day/hour/minutes/seconds, down the resolution you require.
              // For example the long value 2011021714 would mean
              // February 17, 2011, 2-3 PM.
              doc.add(new LongField("modified", lastModified, Field.Store.NO));

              doc.add(new TextField("contents", indexTIKA(stream), Field.Store.YES)); // http://oak.cs.ucla.edu/cs144/projects/lucene/ maybe it should ne Field.Store.NO
              doc.add(new TextField("filename", file.toString(), Field.Store.YES));

              if (docsWithDescription) {
                  String description = getDescriptionFromFile(fileContent);
                  TextField descriptionField = new TextField("description",
                          description,
                          Field.Store.NO);
                  descriptionField.setBoost(3);
                  doc.add(descriptionField);
              } /* if (docsWithDescription) */

              if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
                  // New index, so we just add the document (no old document can be there):
                  System.out.println("adding " + file);
                  writer.addDocument(doc);
              }
              else {
                  // Existing index (an old copy of this document may have been indexed) so
                  // we use updateDocument instead to replace the old one matching the exact
                  // path, if present:
                  System.out.println("updating " + file);
                  writer.updateDocument(new Term("path", file.toString()), doc);
              }
          } /* try */
          catch (Exception e) {
              System.out.println("error in indexing" + (file.toString()));
          }
      }
  }

   public static String indexTIKA(InputStream inStream) throws IOException {

      ContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      AutoDetectParser parser = new AutoDetectParser();
      ParseContext context = new ParseContext();
      try {
          parser.parse(inStream, handler, metadata, context);
      } catch (SAXException | TikaException e) {
          System.out.println("Tika autodetect parser error.");
          e.printStackTrace();
      }

      return handler.toString();
    }

    public static String getDescriptionFromFile(String fileContent) {
        StringTokenizer st = new StringTokenizer(fileContent);
        StringBuilder description = new StringBuilder();

        for (int i = 0; i < nrOfWordsInDescription && st.hasMoreTokens(); i++) {
            description.append(st.nextToken().toString());
            description.append(" ");
        }

        return description.toString();
    }
}
