Feature: Systems
  	Background: User launches application and login1
    	Given User launches application1
     	When User Navigates to LoginPage1
      	And Login with valid admin credentials1
      	Then Platform Availability Home Page is opened
		
	@Systems
	Scenario: General verifications to check creating, updating and deleting entities
		When User clicks on hamburger menu button
		And User clicks on Systems from admin menu
		Then Systems Page is opened
		When User clicks Show/Hide headers icon
		Then Next system headers are displayed
			|On|
			|System name|
			|Access level|
			|Monitors|
		And Next monitor headers are displayed
			|On|
			|Monitor name|
			|ID|
		When User clicks Show/Hide headers icon
		And User searches for MindTap entries
		Then Only entries with MindTap are displayed
		When User clears search field
		And User clicks Expand All icon
		Then Group sections are collapsed
		When User clicks Add group button
		Then Group form is displayed
		When User populates form with autoGroup name
		Then Group autoGroup is displayed on the page
		When User updates name for autoGroup group to updatedGroup
		Then Group updatedGroup is displayed on the page	
		When User clicks Add System for updatedGroup group
		Then Create system form is displayed
		And Next access level options are displayed
			|Admin|
			|GPT|
			|Internal|
			|Public|
		When User populates system form with autoSystems name and Admin access level
		Then System autoSystems is displayed on the page
		When User clicks Enabled icon for autoSystems system
		And User clicks update icon for autoSystems system
		And User updates system form with updatedSystems name and Public access level
		Then System updatedSystems is displayed on the page			
		When User clicks Add Monitor for updatedSystems system
		Then Create monitor form is displayed
		When User populates monitor form
			|Name|autoMonitor|
			|External ID|1009|
			|Description|Monitor description|
		Then Monitor autoMonitor is displayed on the page
		When User clicks update icon for updatedSystems system
		Then Edit system form is displayed
		When User clicks Previous icon
		Then Number of editing system is decreased
		When User clicks Next icon
		Then Number of editing system is increased
		When User clicks Create Monitor button
		Then Create monitor form is displayed
		When User populates monitor form
			|Name|autoMonitor2|
			|External ID|Aplia|
			|Description|Monitor description|
		Then Monitor autoMonitor2 is displayed on the page
		And 2 monitors are displayed for updatedSystems system
		When User clicks Enabled icon for autoMonitor monitor
		And User clicks Update icon for autoMonitor monitor
		And User updates monitor form		
			|Name|updated|
			|External ID|1034|
			|Description|Updated description|
		Then Monitor updated is displayed on the page
		And User deletes updated monitor
		And User deletes autoMonitor2 monitor
		And User deletes updatedSystems system
		And User deletes updatedGroup group
				
	@Systems
	Scenario: Checking filtering by region
		When User clicks on hamburger menu button
		And User clicks on Systems from admin menu
		Then Systems Page is opened
		When User clicks Expand button depending on sections displaying
		And User clicks Add group button
		And User populates form with autoGroup name
		Then Group autoGroup is displayed on the page
		When User clicks Add System for autoGroup group
		And User populates system form with autoSystems name and Internal access level
		Then System autoSystems is displayed on the page
		When User clicks Add Monitor for autoSystems system
		And User populates monitor form
			|Name|regionTest|
			|External ID|1009|
			|Description|Monitor description|
		Then Monitor regionTest is displayed on the page	
		When User selects Africa region for search
		Then System autoSystems is displayed as enabled	 
		When User clicks Update icon for regionTest monitor
		And User clicks Show Regions button
		And Deselect AFR region for monitor
		Then System autoSystems is displayed as disabled
		When User clears Select Region field
		And User deletes regionTest monitor
		And User deletes autoSystems system
		And User deletes autoGroup group
		
	@Systems
	Scenario: Creating aggregated monitor
		When User clicks on hamburger menu button
		And User clicks on Systems from admin menu
		Then Systems Page is opened
		When User clicks Expand button depending on sections displaying
		And User clicks Add group button
		And User populates form with autoAggrGroup name
		Then Group autoAggrGroup is displayed on the page
		When User clicks Add System for autoAggrGroup group
		And User populates system form with autoSystems name and GPT access level
		Then System autoSystems is displayed on the page
		When User clicks Add Monitor for autoSystems system
		And User populates monitor form
			|Name|aggregation1Test|
			|External ID|1009|
			|Description|Monitor description|
		Then Monitor aggregation1Test is displayed on the page
		When User clicks Add Monitor for autoSystems system
		And User populates monitor form
			|Name|aggregation2Test|
			|External ID|1046|
			|Description|Monitor description|
		Then Monitor aggregation2Test is displayed on the page
		When User clicks Add Monitor for autoSystems system
		Then Create monitor form is displayed
		When User populates aggregated monitor form
		Then Monitor Aggregated is displayed on the page
		And Sub-monitors are displayed for aggregated monitor
		And 1 monitors are displayed for autoSystems system
		When User clicks Expand/Collapse icon for Aggregated monitor
		Then Sub-monitors are not displayed for aggregated monitor
		When User deletes Aggregated monitor
		Then 2 monitors are displayed for autoSystems system
		When User deletes aggregation1Test monitor
		And User deletes aggregation2Test monitor
		And User deletes autoSystems system
		And User deletes autoAggrGroup group
		
	@Systems
	Scenario: Public system can't be deleted with associated institution (TRUST-2116)
		When User clicks on hamburger menu button
		And User clicks on Systems from admin menu
		And User clicks Expand button depending on sections displaying
		And User clicks Add group button
		And User populates form with instGroup name
		Then Group instGroup is displayed on the page
		When User clicks Add System for instGroup group
		And User populates system form with instSystems name and Public access level
		Then System instSystems is displayed on the page
		When User clicks Add Monitor for instSystems system
		And User populates monitor form
			|Name|monitorTest|
			|External ID|1009|
			|Description|Monitor description|
		Then Monitor monitorTest is displayed on the page
		When User clicks on Institutions from admin menu
		And User clicks New Institution button
		And User populates institution fields with next values
			|Name| 2116Inst|
			|Short name| auto2116|
			|Entity ID| 2116|
			|Systems| instSystems|
			|Contact name| broker|
			|Contact email| auto@broker.com|
		Then Institution auto2116 is displayed in the table
		When User clicks on Systems from admin menu
		Then Delete icon is disabled for instSystems system
		When User hovers on delete icon for instSystems system
		Then Tooltip for delete icon is displayed
		When User clicks update icon for instSystems system
		Then Access level field is disabled
		When User hovers on access level field
		Then Tooltip about non-editing access level is displayed
		When User clicks on Institutions from admin menu
		And User deletes auto2116 institution from the table
		Then Institution auto2116 is removed from table
		When User clicks on Systems from admin menu
		And User deletes monitorTest monitor
		And User deletes instSystems system
		And User deletes instGroup group

	@Systems @Nastya
	Scenario: Uploading file for a system
		When User clicks on hamburger menu button
		And User clicks on Systems from admin menu
		Then Systems Page is opened

    	When User clicks Expand button depending on sections displaying
  		And User clicks Add group button
  		And User populates form with autoUploadGroup name
		Then Group autoUploadGroup is displayed on the page

		When User clicks Add System for autoUploadGroup group
  		And User populates system form with uploadSystems name and GPT access level
  		Then System uploadSystems is displayed on the page

		When User clicks update icon for uploadSystems system
		Then Edit system form is displayed

		When User clicks on Add Logo button and selects pathbrite-square image
		Then System uploadSystems is displayed on the page

		When User deletes uploadSystems system
		And User deletes autoUploadGroup group
		Then System uploadSystems is removed
		And Group autoUploadGroup is removed



		    