# ITSM Defect Reports

This document contains simulated defect reports demonstrating the standard bug lifecycle tracking within an ITSM environment.

---

### BUG-001
**Title:** Ticket priority does not update on the dashboard after modification without a manual page refresh.

**Severity:** Medium  
**Priority:** High  
**Status:** Open  
**Reported By:** QA Automation  
**Environment:** Staging / Chrome v116  

**Preconditions:**
* User is logged into the ITSM portal.
* At least one open Incident ticket exists assigned to the user.

**Steps to Reproduce:**
1. Navigate to the main Dashboard.
2. Click on an existing open ticket (e.g., INC-1024).
3. In the ticket details view, change the Priority dropdown from 'Low' to 'Critical'.
4. Click 'Save'.
5. Return to the main Dashboard via the navigation menu.

**Expected Result:**
The dashboard should instantly reflect the new 'Critical' priority for the ticket in the list view.

**Actual Result:**
The priority remains displayed as 'Low' on the dashboard. It only updates to 'Critical' if the user manually hits F5 to refresh the browser.

---

### BUG-002
**Title:** Internal Server Error (HTTP 500) when uploading a valid .pdf attachment larger than 20MB.

**Severity:** High  
**Priority:** Medium  
**Status:** In Progress  
**Reported By:** QA Automation  
**Environment:** Staging / API Backend  

**Preconditions:**
* User is in the ticket creation or ticket update view.
* User has a valid PDF file sized exactly 22MB.

**Steps to Reproduce:**
1. Open any existing Incident ticket.
2. Click the 'Attach File' icon.
3. Select a 22MB `.pdf` file.
4. Click 'Upload'.

**Expected Result:**
The system should either upload the file successfully (if max size is >20MB) or return a graceful user-friendly error message stating "File size exceeds maximum limit of 20MB".

**Actual Result:**
The UI spins indefinitely. Checking the network tab reveals the backend API returned an `HTTP 500 Internal Server Error` and crashed the attachment service momentarily.

---

### BUG-003
**Title:** Standard users can edit 'Closed' tickets by manipulating the URL parameters.

**Severity:** Critical  
**Priority:** Critical  
**Status:** Under Review  
**Reported By:** QA Automation  
**Environment:** Staging / Security Testing  

**Preconditions:**
* User has standard 'Requester' privileges (not Admin).
* Ticket INC-999 is in 'Closed' status.

**Steps to Reproduce:**
1. Log in as a standard user.
2. Navigate to a closed ticket (e.g., `https://demo-itsm.com/ticket/view?id=999`). Notice all fields are read-only as expected.
3. Manually change the URL in the address bar from `/view?id=999` to `/edit?id=999` and hit Enter.
4. Modify the ticket description.
5. Click Save.

**Expected Result:**
The server should reject the request with an `HTTP 403 Forbidden` error and redirect the user back to the view mode.

**Actual Result:**
The system allows the user to access the edit form for a closed ticket and successfully saves the modified description to the database, violating ITSM audit compliance.
