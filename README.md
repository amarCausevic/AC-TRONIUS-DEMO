# AC-TRONIUS-DEMO
 
# Commands
```
#Run E2E and API test
command: mvn clean test  -Denvironment=PROD

#Run locust
Proceed to folder local-performance
command: locust
```

## Framework

### e2e user scenarios for Sauce Demo page
* Cucumber
* junit-platform
* chrome-driver
* Selenium
* Selenide
* Cucumber report
  
I have chosen cucumber with junit-platform also Selenium with Selenide for quick webdriver access and chrome-driver as main driver for executing the e2e scenarios, I have opted out for some kind of Page Object project framework in sence that I've AO (Action Page Object), SO(Selector Page Object) and DO(Definition steps Page Object). Utils folder provides different utilities for development of test cases.

![image](https://github.com/user-attachments/assets/6dde9da1-3338-4ec9-b5dc-35ce7e96ffb4) ![image](https://github.com/user-attachments/assets/036876b3-96a2-4014-aab3-7839126de924)

I have chosen BDD style meaning feature file contains all scenarios and steps that are related to this case. For assertion I've used junit Assertions class which gives us a quick hardcore checks while comparing values.

Flow that I have choosen for e2e scenario:
* User login into page
* User checks if it has landed on dashboard page
* User will random click, before that all values will be saved into session storage for further validation
* User clicks on random item and proceeds to item details page
* User will verifiy if correct data is displayed to user
* User will add item to cart
* User will click on cart button user lands on cart page and validates that correct data is displayed
* User clicks on proceed button which will land user on checkout page where user sets customer data
* User proceeds to final page and verifies:
  * Item price
  * Subtotal price
  * Tax
  * Total price (IS CALCULATED SINCE RANDOM ITEM IS CLICKED)
* User clicks on finish button and lands on confirmation page which is validated
* User clicks on Back to Home button user verifies if it has landed on Dashboard page

### API testing scenarios for JSONPlaceholder page
* Rest-assured on top of the cucumber
* Cucumber report

Simple framework where you can define request body and send different methods.

![image](https://github.com/user-attachments/assets/8fefe06e-d537-43af-9001-69055b790ae8)

Flow that I have choosen for api testing scenario:
* User will retrive all posts that are available:
  * Response schema is validated
  * Response data is mapped into DTO and verified
  * Correct status is validated
 
* User will add new post:
  * Response schema is validated
  * Response data is mapped into DTO and verified
  * Correct status is validated
 
* User will update newly created post:
  * Response schema is validated
  * Correct status is validated
 
*  User will delete newly created post:
  * Correct status is validated

### Load performance testing for Blaze Demo
*Locust

For load performance I have chosen locust framework, quick simple example where I simulate 50 users that will access different endpoint, with html report to show us results of the run.

#Setting up enviroment
## Project
You will need to checkout this project, and simple build and rebuild will download all dependencies for testing framework.

## Config
Config file in resources folder contains all properties that are used accross all project where need ofcourse. 
For reading and setting confif I have used import org.aeonbits.owner dependency which provides quick setup and defining all properties. 

Default environmnet variable is set to PROD. 

## Locust
Simple pip3 install locust will install locust framework to your local machine. 
locust conf file has been added to the project were you can set different values:

```
headless = true
users = 50
spawn-rate = 1
host = "https://blazedemo.com"
run-time = 30s
logfile=demo_report.log
html=Load_Performance.html
```

This configuration will simulate 50 user running abd executing requests to 4 different endpoints. Also log and report file will be created once results are in.

Add python to module if you are using intellij idea as shown in the screenshot below:

![image](https://github.com/user-attachments/assets/44b2562f-fcb4-4735-b02f-55c2e120a12a)

And also SDK for Python should be define so locust lib is present;

![image](https://github.com/user-attachments/assets/d1c6af56-1966-43c9-a43b-8b724f6f7ab3)

## Web Driver
For this project I am using chrome driver which can be installed with brew. As brew install chrome-driver. Latest driver needs to be used if you are using chrome versio 130.0

# Reports
## Cucumber report for API and E2E scenarios
As seen from the report below no issue has been found during the execution. Report can be found in root of the project in folder cucumber-report

![image](https://github.com/user-attachments/assets/b7101233-238f-4bde-9617-183f3691e16c)

## Locust report
As seen from the report below there has been issue with adding wrong URL which has been cought during performance testing, also there was connection reset error which happened during GET execution of home page. Response time does not vary to much it stays the same all around 300 - 400ms.

Test was run 30 seconds simulating 50 user.

![image](https://github.com/user-attachments/assets/3f3bf535-d47c-4cea-9227-999dafac4817)
![image](https://github.com/user-attachments/assets/828046a1-fdd2-4bf1-83bf-c351bb93b6cf)
![image](https://github.com/user-attachments/assets/b876d8b5-4dbe-40d1-9809-97e6e3ddc9a5)

# POSTMAN COLLECTION
Postman collection has been added to this repository for JSONPlaceholder website. Use JSON Placeholder.postman_collection.json to import to your postman collection.
File name: JSON Placeholder.postman_collection.json

![image](https://github.com/user-attachments/assets/284ef956-a1a9-4a31-bbcd-cc9cc2b058d5)





