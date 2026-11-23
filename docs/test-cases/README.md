# Test cases: traceability

One manual test-case file per test case. Each is automated twice: as a TestNG test in `src/test/java/tests/` (its `description` starts with the TC ID) and as a Cucumber scenario in `src/test/resources/features/` (its name starts with the TC ID). The tests target https://www.citizensfla.com, a public site (Carlos's own practice project, stated 2026-11-23).

| TC ID | Feature | Status | Automation file — test name | Manual file |
|---|---|---|---|---|
| TC-001 | [F-01](../features/F-01-claims-section-navigation.md) | Automated | `src/test/java/tests/ClaimsSectionTest.java` — [TC-001] Navigate to the Report a Claim page | [TC-001-navigate-to-the-report-a-claim.md](TC-001-navigate-to-the-report-a-claim.md) |
| TC-002 | [F-01](../features/F-01-claims-section-navigation.md) | Automated | `src/test/java/tests/ClaimsSectionTest.java` — [TC-002] Navigate to the Sinkhole Claims page | [TC-002-navigate-to-the-sinkhole-claims-page.md](TC-002-navigate-to-the-sinkhole-claims-page.md) |
| TC-003 | [F-01](../features/F-01-claims-section-navigation.md) | Automated | `src/test/java/tests/ClaimsSectionTest.java` — [TC-003] Navigate to the Loss Inspection page | [TC-003-navigate-to-the-loss-inspection-page.md](TC-003-navigate-to-the-loss-inspection-page.md) |
| TC-004 | [F-01](../features/F-01-claims-section-navigation.md) | Automated | `src/test/java/tests/ClaimsSectionTest.java` — [TC-004] Navigate to the Insurance Fraud page | [TC-004-navigate-to-the-insurance-fraud-page.md](TC-004-navigate-to-the-insurance-fraud-page.md) |
| TC-005 | [F-01](../features/F-01-claims-section-navigation.md) | Automated | `src/test/java/tests/ClaimsSectionTest.java` — [TC-005] Navigate to the Contact Citizens First page | [TC-005-navigate-to-the-contact-citizens-first.md](TC-005-navigate-to-the-contact-citizens-first.md) |
| TC-006 | [F-02](../features/F-02-footer-links-navigation.md) | Automated | `src/test/java/tests/FooterLinksTest.java` — [TC-006] Navigate to the Terms and Conditions page | [TC-006-navigate-to-the-terms-and-conditions.md](TC-006-navigate-to-the-terms-and-conditions.md) |
| TC-007 | [F-02](../features/F-02-footer-links-navigation.md) | Automated | `src/test/java/tests/FooterLinksTest.java` — [TC-007] Navigate to the Privacy Policy page | [TC-007-navigate-to-the-privacy-policy-page.md](TC-007-navigate-to-the-privacy-policy-page.md) |
| TC-008 | [F-02](../features/F-02-footer-links-navigation.md) | Automated | `src/test/java/tests/FooterLinksTest.java` — [TC-008] Navigate to the Site Map page | [TC-008-navigate-to-the-site-map-page.md](TC-008-navigate-to-the-site-map-page.md) |
| TC-009 | [F-02](../features/F-02-footer-links-navigation.md) | Automated | `src/test/java/tests/FooterLinksTest.java` — [TC-009] Navigate to the Accessibility page | [TC-009-navigate-to-the-accessibility-page.md](TC-009-navigate-to-the-accessibility-page.md) |

Totals: 9 test cases — 9 Automated, 0 Manual only, 0 Not started.
