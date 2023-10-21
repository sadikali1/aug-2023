Feature: Orange Hrl application login

  @Smoke @Regression @HRM @Login
  Scenario: Verify user login successfully
    Given I navigated url on browser
    When I enter user name into user input field
    And I enter password in password filed
    And I click on login button
    Then I verify user login successfully
    And Verify all menus option
      | Header      | 
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
