# ITSM Ticketing QA Automation Suite

Hey! Welcome to my QA automation portfolio project. 

I built this project to demonstrate a complete, end-to-end Quality Assurance lifecycle for an IT Service Management (ITSM) platform. Since real ITSM environments (like ServiceNow or Jira Service Desk) are difficult to expose publicly, I've simulated the testing environment using public demo sites and mock APIs to showcase my testing approach.

## What's in here?

This repository is split into two main areas: **Manual Testing** and **Automated Testing**.

### 1. Manual Testing (`/manual-testing`)
Before writing any code, I designed 25 comprehensive manual test cases in `TestCases.csv`. These cover:
* Valid/Invalid Login scenarios
* Incident Management (ticket creation, updating priorities, resolving)
* SLA Management (breach validation)
* Negative & Boundary testing

I also included a professional `Defect_Reports.md` file simulating how I would log UI, Backend, and Security bugs if I encountered them during manual execution.

### 2. Automated Testing
The automation suite is built using **Java + Selenium WebDriver + REST Assured + TestNG**.

* **UI Automation (`src/test/java/ui`)**: I used the OrangeHRM demo site to write 10 robust Selenium tests simulating ITSM portal navigation (login, dashboard interactions, search, and logout). The tests run in headless mode for CI/CD compatibility.
* **API Automation (`src/test/java/api`)**: I used REST Assured against the `reqres.in` mock API to demonstrate backend testing. It covers standard enterprise CRUD operations (`GET`, `POST`, `PUT`, `DELETE`) and negative testing (handling 404s).

## Tech Stack
* **Language:** Java 17
* **Build Tool:** Maven
* **UI Automation:** Selenium WebDriver
* **API Automation:** REST Assured
* **Test Runner:** TestNG

## How to run the tests locally

1. Clone this repository.
2. Make sure you have Java 17 and Maven installed on your machine.
3. Open your terminal at the root of the project.
4. Run the following command:
   ```bash
   mvn clean test
   ```
5. Once the tests finish, you can view the TestNG HTML report generated inside the `target/surefire-reports` folder.
