Feature: To check whether user is able to login
  Scenario : Client Login
    Given User is able to launch the browser and navigate to Client Portal
    When User enters the Username and Password and OTP
    Then Get the get the current URL