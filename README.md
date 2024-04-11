# BDD Cucumber Framework with Java

To demonstrate the framework used sample project that contains ui tests for saucedemo page
https://www.saucedemo.com/

## Dependencies

*  JDK 17
* cucumber-java (version 7.13.0): Dependency for Cucumber Java implementation.  
* cucumber-testng (version 7.13.0): Dependency for integrating Cucumber with TestNG.  
* cucumber-picocontainer (version 7.13.0): Dependency for Cucumber PicoContainer, used for dependency injection.  
* webdrivermanager (version 5.4.0): Dependency for managing WebDriver binaries automatically.  
* extentreports (version 5.0.9): Dependency for ExtentReports, a reporting library for test results.  
* extentreports-cucumber7-adapter (version 1.13.0): Dependency for integrating ExtentReports with Cucumber 7.  
* commons-io (version 2.13.0): Dependency for Apache Commons IO, a library for handling common I/O operations.  
* selenium-java (version 4.10.0): Dependency for Selenium WebDriver, used for browser automation.  

## Detailed Framework Notes:
cucumberOptions - The @CucumberOptions annotation is used to specify various configuration options for Cucumber. TestRunner contains parallel execution of tests all at once, and FailedTestRunner is used to rerun only the failed tests.

* features - Contains feature files.   
* pages - Contains actions or implementation of the pages and also object repository.  
* stepDefinition - Contains definitions of steps and TestHooks to perform @before and @after operations.  
* utilities - Contains the TestBase class and other utility functions.  
* resources - Handles extent reports and global properties (browser, URL details, etc.).
 
## Running Tests

* run `mvn clean install -DskipTests`
* run `mvn test`

## Framework Structure

```
src/test/java
|
├───cucumberOptions
│   │  
│   ├───FailedTestRunner.java
│   ├───TestRunner.java
│   │       
├───features   
│   │       
│   ├───SauceDemoCartManagement.feature       
│   │       
├───Pages
│   │
│   ├───CartPage.java
│   ├───InventoryPage.java    
│   ├───LoginPage.java     
│   ├───PageObjectManager.java
│   │
├───stepDefinitions
│   │
│   ├───SauceDemoCartSteps.java
│   ├───SauceDemoInventorySteps.java    
│   ├───SauceDemoLoginSteps.java     
│   ├───TestHooks.java
│   │
├───Utilities
│   │
│   ├───GenericUtils.java
│   ├───TestBase.java    
│   ├───TestContextSetup.java     
│   │


src/test/resources
|
├───CucumberOptions
│   │  
│   ├───extent.properties
│   ├───global.properties
│   │       

```