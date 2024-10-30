Feature: Fill contact Us form

  @contact
  Scenario Outline: Contact Us scenario with different data
    Given the user navigates to the contact page
    When the user fills the form from the given sheetname "<sheetname>" and rownumber <rownumber>
    And the user clicks on submit button 
    Then verify the message "Success! Your details have been submitted successfully." is displayed

    Examples: 
      |sheetname  | rownumber | 
      | sheet1    |     0     | 
      | sheet1    |     1     | 
