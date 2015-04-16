# Information_Retrieval_app

#### Application for Information Retrieval course

<br />
---
#####Using Makefile

######Compile sample_basic_example - from sample_basic_example directory type:
    $ make

#####Run sample_basic_example - from sample_basic_example directory type:
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles
    
######Clean
	$ make clean

<br />

######Compile sample_basic_example - from sample_basic_example directory type: 
    $ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar IndexFiles.java
    $ javac -classpath .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles.java 

#####Run sample_basic_example - from sample_basic_example directory type:
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar IndexFiles -index index -docs documents
    $ java -cp .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar SearchFiles

---
<br />
    <h5> Info: </h5> 
    <ul> 
        <li> For running the Indexer, we also have to provide 
             the index as "-index index" and the directory with
             the files to be indexed "-docs documents". 
        </li>
    </ul>              

<br />
    
