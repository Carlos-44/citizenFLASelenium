# TC-008: Navigate to the Site Map page

- **Priority:** P2
- **Status:** Manual only
- **Automation:** Manual only: live production site. An automated scenario exists in `src/test/resources/features/footer-links.feature` ("Navigate to the Site Map page"). Not run in this work.

## Preconditions
- https://www.citizensfla.com is reachable.
- I am on the Citizens Florida home page.

## Test data
- Values as written in the scenario steps.

## Steps
| # | Action | Expected result |
|---|---|---|
| 1 | I click the "Site Map" footer link. | The page title should contain "Site Map"; the page source should contain "Site Map". |

**Pass criteria:** The page title should contain "Site Map"; the page source should contain "Site Map".
