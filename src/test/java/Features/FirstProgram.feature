Feature: Login into application

Background:
Given the setup is completed
When the user launches the browsers
Then the navigates to the link

@SmokeTest @RegressionTest
Scenario Outline: Default login process

Given the user is landed in the landing page
When the user login into the application with username "<username>" and password "<password>"
Then validate the username is displayed
And the user is logged out

Examples:
	|username |password    |
	|admin	  |newadmin    |
	|12admin12|newadmin1212|
	
	



	
	
	

