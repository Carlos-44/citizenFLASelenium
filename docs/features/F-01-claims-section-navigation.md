# F-01: Claims Section Navigation
Status: Draft

## Summary (2 to 3 sentences)
Covers "Claims Section Navigation" on https://www.citizensfla.com, a public website. The behavior is read from `src/test/resources/features/claims-section.feature` [INFERRED: there's no product spec].

## User story
As a visitor to the Citizens Florida website I want to be able to navigate to claims-related pages So that I can access claims information and services

## Preconditions
- I am on the Citizens Florida home page.
- I have opened the Claims navigation menu.

## Functional requirements (FR-NN)
- FR-01: Navigate to the Report a Claim page.
- FR-02: Navigate to the Sinkhole Claims page.
- FR-03: Navigate to the Loss Inspection page.
- FR-04: Navigate to the Insurance Fraud page.
- FR-05: Navigate to the Contact Citizens First page.

## Acceptance criteria (AC-NN, each one testable)
- AC-01: Navigate to the Report a Claim page: the current URL should be "https://www.citizensfla.com/report-a-claim".
- AC-02: Navigate to the Sinkhole Claims page: the current URL should be "https://www.citizensfla.com/sinkhole-claims".
- AC-03: Navigate to the Loss Inspection page: the current URL should be "https://www.citizensfla.com/loss-inspection".
- AC-04: Navigate to the Insurance Fraud page: the current URL should be "https://www.citizensfla.com/insurance-fraud".
- AC-05: Navigate to the Contact Citizens First page: the current URL should be "https://www.citizensfla.com/call-citizens-first".

## Out of scope
- Any page content beyond what the scenarios check. Signed-in areas.

## Open questions
- Open question: the site is a live third-party production site, so its markup and URLs can change without notice.

## Source files this feature touches
- src/test/resources/features/claims-section.feature
- src/test/java/tests/ (TestNG)
