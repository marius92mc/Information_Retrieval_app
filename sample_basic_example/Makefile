#
# Makefile for compiling IndexFiles.java and SearchFiles.java 
#

# define a makefile variable for the java compiler
#
JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
CLASSPATH = .:../lucene-5.0.0/lib_made/lucene-core-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-analyzers-common-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-queryparser-5.0.0.jar:../lucene-5.0.0/lib_made/lucene-demo-5.0.0.jar:../lucene-5.0.0/lib_made/pdfbox-1.8.9.jar:../lucene-5.0.0/lib_made/fontbox-1.8.2.jar

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: RomanianAnalyzerWithoutDiacritics.class    \
         IndexFiles.class                           \
         SearchFiles.class              

# this target entry builds the IndexFiles class
# the IndexFiles.class file is dependent on the IndexFiles.java file
# and the rule associated with this entry gives the command to create it
#
RomanianAnalyzerWithoutDiacritics.class: RomanianAnalyzerWithoutDiacritics.java
	$(JCC) -classpath $(CLASSPATH) $<

	@echo ""

IndexFiles.class: IndexFiles.java
	$(JCC) -classpath $(CLASSPATH) $<
	
	@echo ""

SearchFiles.class: SearchFiles.java
	$(JCC) -classpath $(CLASSPATH) $<
	
	@echo ""

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class
