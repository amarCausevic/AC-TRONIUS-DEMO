# AC-TRONIUS-DEMO

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
