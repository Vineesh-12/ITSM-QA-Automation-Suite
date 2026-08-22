# QA Test Plan: ITSM Testing Suite

## 1. Introduction
This document outlines the testing strategy, objectives, and scope for the ITSM Software Testing & Automation Suite.

## 2. Scope
### 2.1 In Scope
*   **Manual Testing:** Designing functional and regression test scenarios for ITSM flows (Login, Incident Creation, Ticket Status, SLA validation).
*   **UI Automation:** End-to-end flow automation of key application scenarios using a public demo web application.
*   **API Automation:** Testing a public REST API covering standard CRUD operations (GET, POST, PUT, DELETE).

### 2.2 Out of Scope
*   Performance and Load Testing
*   Security and Penetration Testing
*   Database Testing

## 3. Test Environment
*   **OS:** Windows / Linux
*   **Browser:** Google Chrome (latest version)
*   **Tools:** Java, Selenium WebDriver, REST Assured, TestNG, Maven

## 4. Testing Approach
*   **Functional Testing:** Ensure each module works as per requirements.
*   **Negative Testing:** Validate application behavior against invalid inputs.
*   **Regression Testing:** Ensure existing functionalities are not broken by new changes.

## 5. Defect Management
Defects will be logged with proper severity, priority, replication steps, and expected/actual outcomes.
