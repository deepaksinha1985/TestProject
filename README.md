# Rest API Automation Framework
Created Maven Rest API Automation framework to automate the rest api and validate the responses accordingly.
This framework is extendable , reusable and easy to use.

## Concept Included
* Common api interaction methods
* Commonly used test utility methods and classes
* Externalised test configuration
* User Friendly report

## Tools
* maven
* testng
* Rest Assured
* extent report
* java
* github
* eclipse

## Pre-requisite installation
* java
* Maven
* Path setup for java and Maven to Environment Variable
* Git hub signup
* eclipse

## Problem Statement
API = https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false

### Acceptance Criteria:

* Name = "Carbon credits"
* CanRelist = true
* The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"

## Solution
Developed Maven Rest API framework and validated the acceptance criteria.
Included advance reporting feature.

## Execution Process

### Pre-requisite.

* import the git hub project into eclipse (local machine)
* Make sure all software should be installed as mention above and path setup

### Execution via eclipse

* Select ApiDetail.xml file and do right click and go to run as -> TestNG Suite
* TestNG completion details displayed at console side
* Go to ExtentReport and open report.html file to browser


### Execution via Command line argument

* Launch run comman window (window+R) type cmd and press OK
* cd {project path} eg C:\Users\Deepak\git\TestProject\api 
* mvn clean test
* After execution go to C:\Users\Deepak\git\TestProject\api\ExtentReport folder and open report.html file to any browser.


## Things to do more 
* log4j implementation
* Pass parameters from xml file to testng 
* Add Generic method for all rest api methods














