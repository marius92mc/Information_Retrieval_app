# Information_Retrieval_app

#### Application for Information Retrieval course

<br />
---
#####Using Makefile

######Compile sample_basic_example - from sample_basic_example directory type:
    $ make

#####Run sample_basic_example - from sample_basic_example directory type:
    $ java -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar:../lucene-5.0.0/lib_made/poi-scratchpad-3.11.jar:../lucene-5.0.0/lib_made/poi-3.11.jar:../lucene-5.0.0/lib_made/poi-ooxml-3.11.jar:../lucene-5.0.0/lib_made/xmlbeans-2.4.0.jar:../lucene-5.0.0/lib_made/ooxml-schemas-1.0.jar:../lucene-5.0.0/lib_made/commons-logging-1.2.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar SearchFiles
    
######Clean
	$ make clean

<br />

######Compile sample_basic_example - from sample_basic_example directory type: 
	$ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar:../lucene-5.0.0/lib_made/poi-scratchpad-3.11.jar:../lucene-5.0.0/lib_made/poi-3.11.jar:../lucene-5.0.0/lib_made/poi-ooxml-3.11.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar RomanianAnalyzerWithoutDiacritics.java

	$ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar:../lucene-5.0.0/lib_made/poi-scratchpad-3.11.jar:../lucene-5.0.0/lib_made/poi-3.11.jar:../lucene-5.0.0/lib_made/poi-ooxml-3.11.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar IndexFiles.java

	$ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar:../lucene-5.0.0/lib_made/poi-scratchpad-3.11.jar:../lucene-5.0.0/lib_made/poi-3.11.jar:../lucene-5.0.0/lib_made/poi-ooxml-3.11.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar SearchFiles.java


#####Run sample_basic_example - from sample_basic_example directory type:
    $ java -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar:../lucene-5.0.0/lib_made/poi-scratchpad-3.11.jar:../lucene-5.0.0/lib_made/poi-3.11.jar:../lucene-5.0.0/lib_made/poi-ooxml-3.11.jar:../lucene-5.0.0/lib_made/xmlbeans-2.4.0.jar:../lucene-5.0.0/lib_made/ooxml-schemas-1.0.jar:../lucene-5.0.0/lib_made/commons-logging-1.2.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/commons-lang3-3.1.jar:../lucene-5.0.0/lib_made/commons-lang3-3.4.jar SearchFiles

---
<br />
    <h5> Info: </h5> 
    <ul> 
        <li> 
             For running the Indexer, we also have to provide 
             the index as "-index index" and the directory with
             the files to be indexed "-docs documents". 
        </li>
        <li> 
            [Lucene FAQ](https://wiki.apache.org/lucene-java/LuceneFAQ#How_can_I_index_PDF_documents.3F) 
        </li>
    </ul>              

<br />
    
