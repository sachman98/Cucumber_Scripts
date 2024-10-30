Feature: Login functionality test for practice site

Background:
Given the browser is launched
And the user is on Test Login Page
#Given Read data from Excel file

  @login1@positive
  Scenario: Successful login with valid credentials
    Given user enters valid username and password
    And user clicks the submit button
    Then verify user lands on sucessful login message page  
    And the page should contain the successful login message 
    And verify the Log out button should be displayed on the sucessful login message page

	@login1@negative
  Scenario Outline: Unsuccessful login with invalid credentials
    Given user enters invalid "<username>" and "<password>"
    And user clicks the submit button
    And Verify error message is displayed
    Then Verify error message text is "<error message>"
    
Examples:
|username      |password          |error message            |
|incorrectUser |Password123       |Your username is invalid!|
|student       |incorrectPassword |Your password is invalid!|
|              |                  |Your username is invalid!|


    
    
 