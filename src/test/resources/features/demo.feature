Feature: calculation

  Background: 
    Given I login into the application

  @Smoke @Regression @Calc
  Scenario: calculate two values and verify
    Given I have two integer values 10 and 20
    When I added both number
    Then I verify result is 30

	@Regression @Calc
  Scenario Outline: Data calculate two values and verify
    Given I have two integer values <firstValue> and <secondValue>
    When I added both number
    Then I verify result is <result>

    Examples: 
      | firstValue | secondValue | result |
      |         10 |          20 |     30 |
      |         15 |          15 |     30 |
      |         15 |          20 |     35 |
      |         30 |          25 |     30 |
      |          1 |          15 |     16 |
