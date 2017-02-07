# Testing-Github-API

Project is a mini library for handling GitHub API. It produces an interactive page that uses the GitHub API to demonstrate the variety of programming languages 
of NASA's public repositories. 

Technologies used:<ul>
Java<br />
Lombok to save myself writing boilerplate code<br />
HTTP libraries (Spring's HTTP library)<br />
JUnit to test Jackson's object mapping<br />
GitHub API with basic authentication<br />
</ul>

Web frameworks:
<ul>
Spring Boot for backend (Spring web)<br />
For HTML I am planning to use https://mdbootstrap.com/javascript/charts/ for pie charts for the repositories<br />
</ul>

In order to get the project up and running copy src/main/resources/application.properties.template<br /> 
to<br />
src/main/resources/application.properties<br />
next fill in your user authentication credentials.<br />
At this point the project this code will let you to collect all the repositories and all the languages.<br />
Next step will be to prepare a mini domain report class which will help holding data. <br />
This is the Maven project and holds all Maven's conventions.<br /> 
JUnit tests were written to confirm JSON that comes back from GitHub gets correctly mapped. 

