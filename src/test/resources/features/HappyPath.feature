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

  @SystemTest
  Scenario: Validate User Registration page error messages, registration and login functionalities
    Given User navigates to User Registration page
    When User leave all field empty with entering any input after clicking
    Then Validation message should be displayed in all respective fields
    And User enters valid information in all fields and Registers
    Then User should be navigated to Login page
    And User should be able to login with credentials registered previously

  @SystemTest
  Scenario: Validate basket and payment functionality
    Given User completes Registration and Login successfully
    When User add items to Basket and item count reflected correctly
    And User clicks on Your Basket
    Then All items added are displayed in basket
    And Total price is updated when item quantity is increased or decreased or deleted
    Then User clicks on checkout and navigated to Select Address page
    And User clicks on create new address and navigated to create address page
    And User adds new address and clicks on submit
    Then User click on continue after selecting address and navigated to delivery method page
    And User click on continue after selecting delivery speed and navigated to payment page
    And User click on continue after adding card details and navigated to order summary page
    And User click on 'Place your order and pay' and navigated to order completion page
