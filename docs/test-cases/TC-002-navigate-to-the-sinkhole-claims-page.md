# TC-002: Navigate to the Sinkhole Claims page

- **Priority:** P2
- **Status:** Manual only
- **Automation:** Manual only: live production site. An automated scenario exists in `src/test/resources/features/claims-section.feature` ("Navigate to the Sinkhole Claims page"). Not run in this work.

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
