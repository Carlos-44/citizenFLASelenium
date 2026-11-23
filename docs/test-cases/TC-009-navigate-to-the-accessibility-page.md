# TC-009: Navigate to the Accessibility page

- **Priority:** P2
- **Linked criteria:** F-02 AC-04 ([F-02](../features/F-02-footer-links-navigation.md))
- **Status:** Automated
- **Automation:** src/test/java/tests/FooterLinksTest.java — "[TC-009] Navigate to the Accessibility page"

## Preconditions
- https://www.citizensfla.com is reachable.
- I am on the Citizens Florida home page.

## Test data
- Values as written in the scenario steps.

## Steps
| # | Action | Expected result |
|---|---|---|
| 1 | I click the "Accessibility" footer link. | The page title should contain "Accessibility"; the page source should contain "Accessibility". |

**Pass criteria:** The page title should contain "Accessibility"; the page source should contain "Accessibility".

## Notes
- Passed locally 2026-11-23 with `mvn test` (Temurin 17.0.21.1, Maven 3.9.16, Edge headless): TestNG 9/9 and Cucumber 9/9, BUILD SUCCESS.
- Also automated as the Cucumber scenario "[TC-009] Navigate to the Accessibility page" in `src/test/resources/features/footer-links.feature`.
