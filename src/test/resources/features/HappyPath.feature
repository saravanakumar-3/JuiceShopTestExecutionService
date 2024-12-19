Feature: Happy path of Juice-Shop

  @SmokeTest
  Scenario: Validate items per page functionality in HomePage
    Given User navigates to Home page
    When User select maximum number of items per page
    Then Home page should display all 37 items

  @SystemTest
  Scenario: Validate product popup and review section
    Given User navigates to Home page
    When User clicks the product no 1
    Then Product popup should be displayed
    And User expands the review section
    Then Reviews should be displayed
