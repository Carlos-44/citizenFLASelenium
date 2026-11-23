# TC-007: Navigate to the Privacy Policy page

- **Priority:** P2
- **Linked criteria:** F-02 AC-02 ([F-02](../features/F-02-footer-links-navigation.md))
- **Status:** Automated
- **Automation:** src/test/java/tests/FooterLinksTest.java — "[TC-007] Navigate to the Privacy Policy page"

## Preconditions
- https://www.citizensfla.com is reachable.
- I am on the Citizens Florida home page.

## Test data
- Values as written in the scenario steps.

## Steps
| # | Action | Expected result |
|---|---|---|
| 1 | I click the "Privacy Policy" footer link. | The page title should contain "Privacy Policy"; the page source should contain "Privacy Policy". |

**Pass criteria:** The page title should contain "Privacy Policy"; the page source should contain "Privacy Policy".

## Notes
- Passed locally 2026-11-23 with `mvn test` (Temurin 17.0.21.1, Maven 3.9.16, Edge headless): TestNG 9/9 and Cucumber 9/9, BUILD SUCCESS.
- Also automated as the Cucumber scenario "[TC-007] Navigate to the Privacy Policy page" in `src/test/resources/features/footer-links.feature`.
