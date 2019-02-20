Feature: Institutions
  Background: User launches application and login1
    Given User launches application1
      When User Navigates to LoginPage1
      And Login with valid admin credentials1
      Then Platform Availability Home Page is opened
	
	@Institutions @Regression
	Scenario: Testing institutions create, update, delete
		When User clicks on hamburger menu button
		And User clicks on Institutions from admin menu
		Then Institutions Page is opened
		And Institutions table contains next headers
			|Name|
			|Short name|
			|Entity ID|
			|Devices|
			|Systems|
			|Contacts|
		When User verifies that there is no institution autoInst
		When User clicks New Institution button
		Then Create Institution window is appeared
		When User populates institution fields with next values
			|Name| autoInst|
			|Short name| auto|
			|Entity ID| 2128506|
			|Devices| auto|
			|Contact name| broker|
			|Contact email| auto@broker.com|
		Then Institution auto is displayed in the table
        And Institution autoInst has No systems value in Systems column
        When User verifies that there is no institution autoUpdate
		And User clicks on auto institution in the table
		Then Edit Institution window is appeared
		When User updates institution fields to the next values
			|Name| autoUpdate|
			|Short name| update|
			|Entity ID| 12345upd|
			|Devices| autoUpdated|
            |Systems| WebAssign|
			|Contact name| new|
			|Contact email| auto@update.com|
		Then Institution update is displayed in the table
		When User deletes update institution from the table
		Then Institution update is removed from table

  @Institutions @Regression
  Scenario: Testing institutions navigation to usual status history from custom splash page
	  When User clicks on hamburger menu button
	  And User clicks on Institutions from admin menu
      Then Institutions Page is opened
      When User clicks New Institution button
      Then Create Institution window is appeared
      When User populates institution fields with next values
        |Name| autoInst1|
        |Short name| auto1|
        |Entity ID| poiuyt|
        |Devices||
        |Systems|Aplia|
        |Contact name| contact1|
        |Contact email| auto@contact1.com|
      Then Institution auto1 is displayed in the table
      When User navigates to auto1 institution Сustom Splash Page
      Then Platform Availability Home Page is opened
      And Login icon has autoInst1 as user name
      When User clicks on Aplia System card
      Then Status History Page is opened
      And Login icon has autoInst1 as user name
      When User clicks on home icon
      Then Platform Availability Home Page is opened
      And Login icon has autoInst1 as user name
      And Admin Menu should not be visible
      And There is no login button and internal-public switch
      And the user clicks on Login icon
      Then user sees dropdown button with Exit institution mode text
      And the user clicks on dropdown button
      Then Platform Availability Home Page is opened
      And there is signin button or sign in button cover
      And User Navigates to LoginPage1
      And Login with valid admin credentials1
      Then Platform Availability Home Page is opened
      When User clicks on Institutions from admin menu
      Then Institutions Page is opened
      When User deletes auto1 institution from the table
      Then Institution auto1 is removed from table

  @Institutions @Regression
  Scenario: Testing institutions links for custom splash page
		When User clicks on hamburger menu button
		And User clicks on Institutions from admin menu
        Then Institutions Page is opened
        When User clicks New Institution button
        Then Create Institution window is appeared
        When User populates institution fields with next values
             |Name| autoInst2|
             |Short name| auto2|
             |Entity ID| sjfhsd|
             |Devices||
             |Systems|Aplia|
             |Contact name| contact|
             |Contact email| auto2@contact.com|
        Then Institution auto2 is displayed in the table
        When User navigates to auto2 institution Сustom Splash Page
        Then Platform Availability Home Page is opened
        And System cards are displayed
        And Color for public system cards is white
        When User clicks Cengage icon
        Then Link navigates to https://www.cengage.com/
        When User clicks Need product support link
        Then Link navigates to https://cengageportal.secure.force.com/Support
        When User clicks on FAQ link
        Then FAQ Page is opened
        When User clicks on home icon
        Then Platform Availability Home Page is opened
        When User clicks on About link
        Then About Techcheck Page is opened
        When User deletes all cookies
        And User launches application1
        And User Navigates to LoginPage1
        And Login with valid admin credentials1
        Then Platform Availability Home Page is opened
        When User clicks on Institutions from admin menu
        Then Institutions Page is opened
        When User deletes auto2 institution from the table
        Then Institution auto2 is removed from table

  @Institutions @PerformanceHistory @Regression
  Scenario: Performance history page for institutions
      When User navigates to perf2491 institution Сustom Splash Page
      Then Platform Availability Home Page is opened
      When User clicks on Questia System card
      Then Performance History Page is opened
      And Login icon has Performance History as user name
      And Performance history for system Questia and monitor Questia text is displayed
      And Performance and Status History buttons are displayed
      And The text description contains Performance History institution name and info that times are in UTC
      And Current date is displayed by default
      And Specify next date button is disabled
      And Specify previous date button is enabled

      When User selects date in the past using date picker
      Then Selected day is displayed in the specify date field on Status History
      And Specify next date button is enabled
      And Specify previous date button is enabled
      And Performance chart for selected date is displayed


    When User clicks on Today button
      Then Selected day is displayed in the specify date field on Status History
      And Specify next date button is disabled
      And Specify previous date button is enabled
      And Performance chart for current date is displayed

      When User selects date in the past by clicking on Specify previous date button
      Then Selected day is displayed in the specify date field on Status History
      And Specify next date button is enabled
      And Specify previous date button is enabled
      And Performance chart for selected date is displayed


  	@Institutions @PerformanceHistory @Regression
  	Scenario: Testing navigation between Performance and Status History pages (TRUST-2492)
		When User navigates to perf2491 institution Сustom Splash Page
		Then Platform Availability Home Page is opened
		When User clicks on Questia System card
		Then Performance page is displayed
		And Current date is displayed by default
		When User clicks Status History button
        Then Last 24h view is displayed
        When User clicks on Specify date history view
		And User selects first day of the previous month
		Then Status history is displayed for specified day
		When User clicks Performance button
		Then Specified day is displayed for the same date
		When User selects date in the past by clicking on Specify previous date button
		And User clicks Status History button
		Then Status history is displayed for specified day
		And Specified day is displayed for the same date
        When User clicks on Last 30 days history view
		And User clicks Performance button
		Then Performance page is displayed
		And Current date is displayed by default
		When User clicks Status History button
        When User clicks on Last 12h history view
		And User clicks Performance button
		Then Performance page is displayed
		And Current date is displayed by default
		When User clicks Status History button
        And User clicks on Specify range history view
		And User selects previous day as Start Date range
		And User clicks Performance button
		Then Selected start day for range is displayed 
		