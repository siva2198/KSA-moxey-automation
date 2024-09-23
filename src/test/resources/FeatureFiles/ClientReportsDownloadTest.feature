Feature: Download All Reports
  To check whether all the Client and client users able to download reports
  Background:
    Given User is able to launch the browser and navigate to Client Portal

    Scenario : Client Admin able to download all the reports
      When the client admin enter the credentials and verify the OTP
      Then User is on the dashboard Page
      And User click on Reports Page

      When User select Account Payouts and clicks on download button
      Then the reports should be downloaded successfully

      When User select Prefund and clicks on download button
      Then the reports should be downloaded successfully

      When User select Ledger and clicks on download button
      Then the reports should be downloaded successfully

      When User select B2B Payments and clicks on download button
      Then the reports should be downloaded successfully

      When User select Driver Payment requests and clicks on download button
      Then the reports should be downloaded successfully

  Scenario : Client Admin able to download all the reports
    When the Hf enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page


    When User select Account Payouts and clicks on download button
    Then the reports should be downloaded successfully

    When User select Prefund and clicks on download button
    Then the reports should be downloaded successfully

    When User select Ledger and clicks on download button
    Then the reports should be downloaded successfully

    When User select B2B Payments and clicks on download button
    Then the reports should be downloaded successfully

    When User select Driver Payment requests and clicks on download button
    Then the reports should be downloaded successfully

  Scenario : Client Admin able to download all the reports
    When the HC enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page

    When User select Account Payouts and clicks on download button
    Then the reports should be downloaded successfully

    When User select Prefund and clicks on download button
    Then the reports should be downloaded successfully

    When User select Ledger and clicks on download button
    Then the reports should be downloaded successfully

    When User select B2B Payments and clicks on download button
    Then the reports should be downloaded successfully

    When User select Driver Payment requests and clicks on download button
    Then the reports should be downloaded successfully

  Scenario : Client Admin able to download all the reports
    When the client admin enter the credentials and verify the OTP
    Then User is on the dashboard Page
    And User click on Reports Page

    When User select Account Payouts and clicks on download button
    Then the reports should be downloaded successfully

    When User select Prefund and clicks on download button
    Then the reports should be downloaded successfully

    When User select Ledger and clicks on download button
    Then the reports should be downloaded successfully

    When User select B2B Payments and clicks on download button
    Then the reports should be downloaded successfully

    When User select Driver Payment requests and clicks on download button
    Then the reports should be downloaded successfully