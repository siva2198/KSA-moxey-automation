Feature: Raise Prefund Request
  Background:
    Given User is able to launch the browser and navigate to Client Portal
    When the client admin enter the credentials and verify the OTP

  Scenario: To check whether client able to raise a prefund request
    Then Click on Accounts option
    And Click on Request Prefund button
    Then enter amount, bank reference number,internal reference no,add note, upload document and click on submit