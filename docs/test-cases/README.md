# Test cases: traceability

One manual test-case file per scenario, generated from the Gherkin feature files in `src/test/resources/features`. Every case is **Manual only: live production site**. The tests target https://www.citizensfla.com, a real insurer's public website. Matching TestNG tests are in `src/test/java/tests/`. Running them would also need Java and Maven, which aren\x27t installed.

| TC ID | Status | Automation file | Manual file |
|---|---|---|---|
| TC-001 | Manual only | `src/test/resources/features/claims-section.feature` | [TC-001-navigate-to-the-report-a-claim.md](TC-001-navigate-to-the-report-a-claim.md) |
| TC-002 | Manual only | `src/test/resources/features/claims-section.feature` | [TC-002-navigate-to-the-sinkhole-claims-page.md](TC-002-navigate-to-the-sinkhole-claims-page.md) |
| TC-003 | Manual only | `src/test/resources/features/claims-section.feature` | [TC-003-navigate-to-the-loss-inspection-page.md](TC-003-navigate-to-the-loss-inspection-page.md) |
| TC-004 | Manual only | `src/test/resources/features/claims-section.feature` | [TC-004-navigate-to-the-insurance-fraud-page.md](TC-004-navigate-to-the-insurance-fraud-page.md) |
| TC-005 | Manual only | `src/test/resources/features/claims-section.feature` | [TC-005-navigate-to-the-contact-citizens-first.md](TC-005-navigate-to-the-contact-citizens-first.md) |
| TC-006 | Manual only | `src/test/resources/features/footer-links.feature` | [TC-006-navigate-to-the-terms-and-conditions.md](TC-006-navigate-to-the-terms-and-conditions.md) |
| TC-007 | Manual only | `src/test/resources/features/footer-links.feature` | [TC-007-navigate-to-the-privacy-policy-page.md](TC-007-navigate-to-the-privacy-policy-page.md) |
| TC-008 | Manual only | `src/test/resources/features/footer-links.feature` | [TC-008-navigate-to-the-site-map-page.md](TC-008-navigate-to-the-site-map-page.md) |
| TC-009 | Manual only | `src/test/resources/features/footer-links.feature` | [TC-009-navigate-to-the-accessibility-page.md](TC-009-navigate-to-the-accessibility-page.md) |

Totals: 9 test cases — 0 Automated, 9 Manual only, 0 Not started.
