Agile course exercise
=====================

You can download the Java project by pressing the ZIP button on top of the page. Once downloaded and unzipped, 
you will find a folder with the following files:

i) src/main/resources/dblp_curated_sample.xml This is an XML document containing information about 
publications and authors. 

ii) src/main/java/XQueryExamples.java This is a java class containing methods that implements methods 
that you can use and adapt for your own stories. In essence, these methods query the XML document in (i).
To do so, XQUERY is used. (XQuery is a language for querying XML documents, just like SQL is for relational 
databases). You are not required to learn in depth XQUERY to be able to implement your stories. If you are 
interested to know more about XQuery you can take a look at [1].

iii) src/test/java/TestXQueryExamples.java This is a java class that contains method implementing JUnit test. 
You can use as a template to implement your own tests.

iv) pom.xml This java project is built using Maven [2]. pom.xml specifies the dependencies, 
in particular the libraries that are needed. If you are familiar with Maven, then you can build the project using
the command "mvn clean, build". If you are not familiar with Maven, then you can simply compile the Java file as 
you are used to do before. In doing so, you will need to download the java library in [3], and include it in 
your classpath.

If you are using Maven, the classpath can be obtained by running the following command from 
the root of the Java project: "mvn dependency:build-classpath"
Using such classpath, you can for example run the main method of the XQueryExamples class in target/classes 
using the follong command: java -classpath ? XQueryExamples, where ? stands for the class path. 
Do not forget to add the current directory by appending the class path with ":." in unix, linux and mac 
(It may be different in Windows).

[1] http://edutechwiki.unige.ch/en/XQuery_tutorial_-_basics
[2] http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
[3] ?





