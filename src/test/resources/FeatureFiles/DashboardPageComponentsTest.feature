Feature: Validate Dashboard Components

  Scenario: Get the available prefund amount
    Given User is able to launch the browser and navigate to Client Portal
    When User enters the Username and Password and OTP
    Then User is on the dashboard Page
    Then get the current available prefund balance

  Scenario: Get the dashboard title
    Given User is able to launch the browser and navigate to Client Portal
    When User enters the Username and Password and OTP
    Then User is on the dashboard Page
    Then Page title should be "Dasboard"

