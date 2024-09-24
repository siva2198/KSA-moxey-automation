Feature: Client Login Functionality
  As a client user
  I want to log in to the system
  So that I can access the dashboard

@Smoke
  Scenario: User successfully logs in with valid credentials
    Given User is able to launch the browser and navigate to Client Portal
    When the client admin enter the credentials and verify the OTP
    Then User is on the dashboard Page
