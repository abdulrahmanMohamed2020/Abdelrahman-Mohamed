# Automation-Google Search
Some automated test cases for Google search
## The main Frameworks included in the project:
* Selenium Webdriver
* TestNG
* Allure Report
* Commons IO
## Project Design:
* Page Object Model (POM) design pattern
* Fluent design approach (method chaining)
* Have a supporting Core package in src/main/java file path, named **"core"** that includes Capabilities classes which serve as a core engine for the project
## How to check the execution log and open the latest execution reports from GitHub Actions:
* You need to be logged in to GitHub as a prerequisite
* Open the GitHub Actions tab
* Open the latest workflow run from the list
## How to run the project main test cases locally:
* Can find the test cases in the src/test/java folder
* To start the execution, please make sure that the "execution.type" property is "Local" if you are running locally then right-click on the test suite XML file and click Run As >> TestNG Suit
* After executing, you can easily generate the **Allure Report** by opening a command-line terminal on the project 
root path and type 
```
mvn allure:serve
```
(needs to be able to execute mvn commands);
