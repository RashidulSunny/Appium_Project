Feature: Login Features

  Scenario Outline: Login is unSuccessful with invalid credential
    When user enters username "<username>" and password "<password>"
    And click on login button
    Then user should get error massage "<error>"
    Examples:
      | username        | password        | error                                                        |
      | invalidUserName | secret_sauce    | Username and password do not match any user in this service. |
      | standard_user   | invalidPassword | Username and password do not match any user in this service. |



    Scenario Outline: Login is successful with valid credential

      When user enters username "<username>" and password "<password>"
      And click on login button
      Then user should see product page with title "<title>"
      Examples:

        | username      | password     | title    |
        | standard_user | secret_sauce | PRODUCTS |
