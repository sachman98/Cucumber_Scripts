Feature: Fill student registration form

Background:
Given the environment setup is completed
When the user launches the web browsers
Then the navigates to the given link
  

  @sachit
  Scenario: Enter the details for student registration form
    Given the user is on the landing page        
    And user enters "firstname" in firstname field and "lastname" in lastname field
    And user enters the email "sac@gmail.com" in email field
    And clicks on gender radio button
    And enters the mobile number "98978767798" 
    And select the date of birth 
    And enter subjects in subjects field
    And clicks on checkbox for hobbies
   ## And uploads a file from local drive
   ## Then validates the file has been uploaded 
    And user enters address in address field
    And user selects state from dropdown 	
    #Then validates city dropdrown 
    And user clicks on submit button
    #Then validates the form review page is displayed
    And the browsers is closed
    

 
