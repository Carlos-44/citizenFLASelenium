Feature: Claims Section Navigation
  As a visitor to the Citizens Florida website
  I want to be able to navigate to claims-related pages
  So that I can access claims information and services

  Background:
    Given I am on the Citizens Florida home page
    And I have opened the Claims navigation menu

  Scenario: Navigate to the Report a Claim page
    When I click the "Report a Claim" menu item
    Then the current URL should be "https://www.citizensfla.com/report-a-claim"

  Scenario: Navigate to the Sinkhole Claims page
    When I click the "Sinkhole Claims" menu item
    Then the current URL should be "https://www.citizensfla.com/sinkhole-claims"

  Scenario: Navigate to the Loss Inspection page
    When I click the "Loss Inspection" menu item
    Then the current URL should be "https://www.citizensfla.com/loss-inspection"

  Scenario: Navigate to the Insurance Fraud page
    When I click the "Insurance Fraud" menu item
    Then the current URL should be "https://www.citizensfla.com/insurance-fraud"

  Scenario: Navigate to the Contact Citizens First page
    When I click the "Contact Citizens First" menu item
    Then the current URL should be "https://www.citizensfla.com/call-citizens-first"
