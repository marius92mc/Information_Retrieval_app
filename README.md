# Information_Retrieval_app

Application for Information Retrieval course

<br />

## Build

### Using Makefile

Compile sample_basic_example - from sample_basic_example directory type:
    
    $ make

Run 

    $ cd sample_basic_example
    $ java -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles    

Clean
	
    $ make clean

<br />

Compile sample_basic_example:
 
  	$ cd sample_basic_example
    $ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar RomanianAnalyzerWithoutDiacritics.java
  	$ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar IndexFiles.java
  	$ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar SearchFiles.java


Run sample_basic_example - from sample_basic_example directory type:

    $ java -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles

<br />
    <p>
        <ul> In case you have to run the java classes on documents 
        with description, then add these to the run commands above:
            <li> at indexing: replace `-docs documents` with 
                `-docs documents_with_description -description` 
            </li>
            <li> at searching: `-raw -description`
            </li>
         </ul>
    </p>

---
<br />
 

- For running the Indexer, we also have to provide 
the index as "-index index" and the directory with
the files to be indexed "-docs documents". 
</li>
   
[Lucene FAQ](https://wiki.apache.org/lucene-java/LuceneFAQ#How_can_I_index_PDF_documents.3F) 

<br />
    
