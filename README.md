# ITSM Software Testing & Automation Suite

## 1. Project Overview
This repository contains a comprehensive Quality Assurance (QA) testing suite designed to demonstrate an end-to-end testing lifecycle for IT Service Management (ITSM) workflows. It includes Manual Testing Documentation, UI Automation (using a public demo site), and API Automation.

## 2. Problem Statement
Enterprise applications require rigorous testing to ensure stability across multiple layers (UI and API). The objective is to establish a robust QA framework that covers manual test case design, defect tracking, and automated execution of functional and regression scenarios.

## 3. QA Objectives
* Formulate meaningful manual test cases based on ITSM scenarios.
* Track defects using professional reporting standards.
* Automate UI flows to ensure functionality using Selenium WebDriver.
* Automate Backend/API testing to validate data integrity using REST Assured.
* Consolidate test execution and reporting using TestNG.

## 4. Testing Strategy
1.  **Manual Testing:** Test Plan, Excel-based test scenarios, and markdown defect reports.
2.  **UI Automation:** Selenium scripts executing core functional tests on a public demo web application to demonstrate reusable QA automation techniques.
3.  **API Automation:** REST Assured tests simulating enterprise backend operations (GET, POST, PUT, DELETE).
4.  **Reporting:** Automated HTML reports generated via TestNG.

## 5. Technology Stack
*   **Language:** Java
*   **Build Tool:** Maven
*   **UI Automation:** Selenium WebDriver
*   **API Automation:** REST Assured
*   **Test Framework:** TestNG
*   **Version Control:** Git & GitHub

## 6. Manual Testing
The `Manual_Testing_Docs` folder contains `TestCases.csv` which covers 25 comprehensive test cases categorized into:
* Login Testing
* Incident Management (Functional)
* SLA Validation
* Negative & Boundary Testing
* Regression Scenarios

## 7. UI Automation
Located in `automation/src/test/java/ui/`. We utilize the Page Object Model (POM) concept and TestNG annotations to run 10 automated browser tests using Selenium WebDriver, validating:
* Authentication flows
* Dashboard rendering
* Navigation and Menu interactions

## 8. API Automation
Located in `automation/src/test/java/api/`. We use REST Assured to hit an enterprise mock backend (reqres.in) to validate:
* `GET` (Fetch user details)
* `POST` (Create new user)
* `PUT` (Update user status)
* `DELETE` (Remove user)
* `Negative` (404 Not Found handling)

## 9. Defect Tracking & Reporting
The repository includes simulated Defect Reports (`Defect_Reports.md`) capturing standard bug lifecycle tracking. Upon executing the TestNG suite, an automated HTML report is generated inside the `reports/` directory highlighting pass/fail metrics.

## 10. How to Run Locally
1. Clone this repository.
2. Ensure you have Java 17+ and Maven installed.
3. Navigate to the `automation` folder in your terminal.
4. Run the following command:
   ```bash
   mvn clean test
   ```
5. Check the `target/surefire-reports` folder for the generated TestNG results.
