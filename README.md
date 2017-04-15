# Information Retrieval App

Application for Information Retrieval course

<br />

## Build

    $ cd src/ 
    $ make

## Run 

    $ cd src/
    $ java -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/tika-app-1.8.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles 

## Clean

    $ cd src/
    $ make clean


In case you have to run the java classes on documents 
with description, then add these to the run commands above:
- at *indexing*: replace `-docs documents` with 
  `-docs documents_with_description -description` 
- at *searching*: use `-raw -description`


For running the Indexer, we also have to provide 
the index as `-index index` and the directory with
the files to be indexed like `-docs documents`. 


[Lucene FAQ](https://wiki.apache.org/lucene-java/LuceneFAQ#How_can_I_index_PDF_documents.3F) 

    
