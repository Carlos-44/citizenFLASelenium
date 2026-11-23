# F-02: Footer Links Navigation
Status: Draft

## Summary (2 to 3 sentences)
Covers "Footer Links Navigation" on https://www.citizensfla.com, a public website. The behavior is read from `src/test/resources/features/footer-links.feature` [INFERRED: there's no product spec].

## User story
As a visitor to the Citizens Florida website I want to be able to click footer links So that I can navigate to important policy and accessibility pages

## Preconditions
- I am on the Citizens Florida home page.

## Functional requirements (FR-NN)
- FR-01: Navigate to the Terms and Conditions page.
- FR-02: Navigate to the Privacy Policy page.
- FR-03: Navigate to the Site Map page.
- FR-04: Navigate to the Accessibility page.

## Acceptance criteria (AC-NN, each one testable)
- AC-01: Navigate to the Terms and Conditions page: the page title should contain "Terms & Conditions"; the page source should contain "Terms & Conditions".
- AC-02: Navigate to the Privacy Policy page: the page title should contain "Privacy Policy"; the page source should contain "Privacy Policy".
- AC-03: Navigate to the Site Map page: the page title should contain "Site Map"; the page source should contain "Site Map".
- AC-04: Navigate to the Accessibility page: the page title should contain "Accessibility"; the page source should contain "Accessibility".

## Out of scope
- Any page content beyond what the scenarios check. Signed-in areas.

## Open questions
- Open question: the site is a live third-party production site, so its markup and URLs can change without notice.

## Source files this feature touches
- src/test/resources/features/footer-links.feature
- src/test/java/tests/ (TestNG)
