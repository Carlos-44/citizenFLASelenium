Feature: Footer Links Navigation
  As a visitor to the Citizens Florida website
  I want to be able to click footer links
  So that I can navigate to important policy and accessibility pages

  Background:
    Given I am on the Citizens Florida home page

  Scenario: [TC-006] Navigate to the Terms and Conditions page
    When I click the "Terms & Conditions" footer link
    Then the page title should contain "Terms & Conditions"
    And the page source should contain "Terms & Conditions"

  Scenario: [TC-007] Navigate to the Privacy Policy page
    When I click the "Privacy Policy" footer link
    Then the page title should contain "Privacy Policy"
    And the page source should contain "Privacy Policy"

  Scenario: [TC-008] Navigate to the Site Map page
    When I click the "Site Map" footer link
    Then the page title should contain "Site Map"
    And the page source should contain "Site Map"

  Scenario: [TC-009] Navigate to the Accessibility page
    When I click the "Accessibility" footer link
    Then the page title should contain "Accessibility"
    And the page source should contain "Accessibility"
