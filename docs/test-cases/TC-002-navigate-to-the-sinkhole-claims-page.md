# TC-002: Navigate to the Sinkhole Claims page

- **Priority:** P2
- **Linked criteria:** F-01 AC-02 ([F-01](../features/F-01-claims-section-navigation.md))
- **Status:** Automated
- **Automation:** src/test/java/tests/ClaimsSectionTest.java — "[TC-002] Navigate to the Sinkhole Claims page"

## Preconditions
- https://www.citizensfla.com is reachable.
- I am on the Citizens Florida home page.
- I have opened the Claims navigation menu.

## Test data
- Values as written in the scenario steps.

## Steps
| # | Action | Expected result |
|---|---|---|
| 1 | I click the "Sinkhole Claims" menu item. | The current URL should be "https://www.citizensfla.com/sinkhole-claims". |

**Pass criteria:** The current URL should be "https://www.citizensfla.com/sinkhole-claims".

## Notes
- Passed locally 2026-11-23 with `mvn test` (Temurin 17.0.21.1, Maven 3.9.16, Edge headless): TestNG 9/9 and Cucumber 9/9, BUILD SUCCESS.
- Also automated as the Cucumber scenario "[TC-002] Navigate to the Sinkhole Claims page" in `src/test/resources/features/claims-section.feature`.
