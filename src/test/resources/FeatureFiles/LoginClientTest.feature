Feature: To check whether user is able to login

  Scenario : Client Login
    Given User is able to launch the browser and navigate to Client Portal
    When the client admin enter the credentials and verify the OTP
    Then Get the get the current URL