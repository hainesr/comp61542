# Agile course exercise

You can download the Java project by pressing the ZIP button on top of the page. Once downloaded and unzipped, 
you will find a folder with the following files:

1. input/dblp_curated_sample.xml
This is an XML document containing information about publications and authors. 

2. src/XQueryExamples.java
This is a java class containing methods that implements methods 
that you can use and adapt for your own stories. In essence, these methods query the XML document in (i).
To do so, XQUERY is used. (XQuery is a language for querying XML documents, just like SQL is for relational 
databases). You are not required to learn in depth XQUERY to be able to implement your stories. If you are 
interested to know more about XQuery you can take a look at [1].

3. src/TestXQueryExamples.java
This is a java class that contains method implementing JUnit test. 
You can use as a template to implement your own tests.

4. lib/*
This folder contains dependencies for compiling and running the example and the tests.

## Compiling

From the root of the unzipped folder:

    $ javac -classpath lib/junit-4.11.jar:lib/saxon9he.jar src/*.java

## Running the example

From the same place:

    $ java -classpath lib/saxon9he.jar:src/ XQueryExamples

## Running the tests

Again, from the root folder:

    $ java -classpath lib/saxon9he.jar:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar:src/ org.junit.runner.JUnitCore TestXQueryExamples

In this case notice that you are actually running the JUnitCore runner, with your test class as an input to it.

### References

[1] http://edutechwiki.unige.ch/en/XQuery_tutorial_-_basics





