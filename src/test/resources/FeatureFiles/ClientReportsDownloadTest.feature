Feature: Download All Reports
  To check whether all the Client and client users able to download reports
  Background:
    Given User is able to launch the browser and navigate to Client Portal

    Scenario: Client Admin able to download all the reports
      When the client admin enter the credentials and verify the OTP
      Then User is on the dashboard Page
      And User click on Reports Page
      When User select Account Payouts and clicks on download button
      Then the Account Payouts reports should be downloaded successfully
      When User select Prefund and clicks on download button
      Then the Prefund reports should be downloaded successfully
      When User select Ledger and clicks on download button
      Then the Ledger reports should be downloaded successfully
      When User select Vendor Payments and clicks on download button
      Then the Vendor reports should be downloaded successfully
      When User select Driver Payment requests and clicks on download button
      Then the Driver Payment Request reports should be downloaded successfully
@Smoke
  Scenario: Head of Finance able to download all the reports
    When the Hf enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page
    When User select Account Payouts and clicks on download button
    Then the Account Payouts reports should be downloaded successfully
    When User select Prefund and clicks on download button
    Then the Prefund reports should be downloaded successfully
    When User select Ledger and clicks on download button
    Then the Ledger reports should be downloaded successfully
    When User select Vendor Payments and clicks on download button
    Then the Vendor reports should be downloaded successfully
    When User select Driver Payment requests and clicks on download button
    Then the Driver Payment Request reports should be downloaded successfully

  Scenario: Head of cashier able to download all the reports
    When the HC enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page
    When User select Account Payouts and clicks on download button
    Then the Account Payouts reports should be downloaded successfully
    When User select Prefund and clicks on download button
    Then the Prefund reports should be downloaded successfully
    When User select Ledger and clicks on download button
    Then the Ledger reports should be downloaded successfully
    When User select Vendor Payments and clicks on download button
    Then the Vendor reports should be downloaded successfully
    When User select Driver Payment requests and clicks on download button
    Then the Driver Payment Request reports should be downloaded successfully

  Scenario: Cashier able to download all the reports
    When the Cashier enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page
    When User select Account Payouts and clicks on download button
    Then the Account Payouts reports should be downloaded successfully
    When User select Prefund and clicks on download button
    Then the Prefund reports should be downloaded successfully
    When User select Ledger and clicks on download button
    Then the Ledger reports should be downloaded successfully
    When User select Vendor Payments and clicks on download button
    Then the Vendor reports should be downloaded successfully
    When User select Driver Payment requests and clicks on download button
    Then the Driver Payment Request reports should be downloaded successfully