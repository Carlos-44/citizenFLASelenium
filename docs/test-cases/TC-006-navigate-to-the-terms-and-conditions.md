# TC-006: Navigate to the Terms and Conditions page

- **Priority:** P2
- **Status:** Manual only
- **Automation:** Manual only: live production site. An automated scenario exists in `src/test/resources/features/footer-links.feature` ("Navigate to the Terms and Conditions page"). Not run in this work.

## Preconditions
- https://www.citizensfla.com is reachable.
- I am on the Citizens Florida home page.

## Test data
- Values as written in the scenario steps.

## Steps
| # | Action | Expected result |
|---|---|---|
| 1 | I click the "Terms & Conditions" footer link. | The page title should contain "Terms & Conditions"; the page source should contain "Terms & Conditions". |

**Pass criteria:** The page title should contain "Terms & Conditions"; the page source should contain "Terms & Conditions".
