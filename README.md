# Custom String Framework Implementation
The project is a custom implementation of the String Framework where a local http server was developed. Few operations were implemented to simulate the regular behavior of the framework and the server.

To check some of the resources access to the next URLs:
* To check the homepage click [here](https://powerful-chamber-98560.herokuapp.com)
* To check some of the 50 uploaded images click [here](https://powerful-chamber-98560.herokuapp.com/png/File1.png)
* To check the JavaScript example click [here](https://powerful-chamber-98560.herokuapp.com/example.js)

## Badges

To see this project deployed in Heroku [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://powerful-chamber-98560.herokuapp.com)

Continous Integration [![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://circleci.com/gh/srubianof/AREP-LAB-3)
## Getting Started
The following steps are required in order to get a copy of the project, be able to run it and perform tests.
### Prerequisites
You need to have installed the next software to successfully run the project:

* Java recommended Java 8
* Maven
* Git
### Installing
This a step by step guide that will tell you how to get a copy of the project and how to execute
        
First get a copy of the repository
```
git clone https://github.com/srubianof/AREP-LAB-3.git
```
Once the project is downloaded in your machine, you can build it with the next command
```
mvn package
```

## Test execution
 In order to run the test you have to keep in mind that you must have downloaded the repository and have opened a new terminal in the project folder.
 
 To execute the tests you have to type the following command:
 
 ```
mvn test
```
## Program execution
Before you run the program please keep in mind that this program needs the name of the file where the set of numbers are located including the extension.

For a proper execution of the project type in the terminal the following commands:

```
mvn clean install
```

With the help of Heroku, deploy the website locally for development propuses
```
heroku local web
```

## Built With
* Java 8
* Git - Version-control system
* [Maven](https://maven.apache.org) - Dependency Management
## Javadoc

The complete documentation of the project can be found [here](https://srubianof.github.io/arep-lab-3-docs/).

The complete report of the activity can be found [here](https://www.overleaf.com/read/bknqvyzwxkgc)


In order to generate the documentation type the following commands in the terminal:
* This generates a html with the javadoc
```
mvn javadoc:javadoc
```
* This generates a site for the project where the project's reports are included.
```
mvn site
```
* This opens the site where the documentation is located
```
mvn site:run
```


## Author

[**Santiago Rubiano Fierro**](https://github.com/srubianof) Software Engineering Student

## License

 This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/srubianof/AREP-LAB-1/blob/master/LICENSE) file for details.