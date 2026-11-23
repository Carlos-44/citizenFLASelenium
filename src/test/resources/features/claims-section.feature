Feature: Claims Section Navigation
  As a visitor to the Citizens Florida website
  I want to be able to navigate to claims-related pages
  So that I can access claims information and services

  Background:
    Given I am on the Citizens Florida home page
    And I have opened the Claims navigation menu

  Scenario: [TC-001] Navigate to the Report a Claim page
    When I click the "Report a Claim" menu item
    Then the current URL should be "https://www.citizensfla.com/report-a-claim"

  Scenario: [TC-002] Navigate to the Sinkhole Claims page
    When I click the "Sinkhole Claims" menu item
    Then the current URL should be "https://www.citizensfla.com/sinkhole-claims"

  Scenario: [TC-003] Navigate to the Loss Inspection page
    When I click the "Loss Inspection" menu item
    Then the current URL should be "https://www.citizensfla.com/loss-inspection"

  Scenario: [TC-004] Navigate to the Insurance Fraud page
    When I click the "Insurance Fraud" menu item
    Then the current URL should be "https://www.citizensfla.com/insurance-fraud"

  Scenario: [TC-005] Navigate to the Contact Citizens First page
    When I click the "Contact Citizens First" menu item
    Then the current URL should be "https://www.citizensfla.com/call-citizens-first"
