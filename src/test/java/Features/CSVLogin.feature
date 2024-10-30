Feature: Login functionality test for csv practice 

Background:
Given the user has launched the web browser

@CSV
  Scenario Outline: Login with CSV data
    Given the user in the login page
    When user reads data from csv
    Then user enters username and password
    
   

