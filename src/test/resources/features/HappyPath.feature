Feature: Happy path of Juice-Shop

  @SmokeTest
  Scenario: Validate items per page functionality in HomePage
    Given User navigates to Home page
    When User select maximum number of items per page
    Then Home page should display all items