Feature: Admin smoke
	Background: User launches application and login1
		Given User launches application1
		When User Navigates to LoginPage1
		And Login with valid admin credentials1
		Then Platform Availability Home Page is opened

    @Smoke @AdminSmoke
	Scenario: Admin User is able to go to Status History page for public and admin systems
      Given User is on Splash page1
      When User clicks on Aplia System card
      Then Status History Page is opened
      When User clicks on hamburger menu button
      Then Menu state is open
      When User clicks $ System 4 - Admin system from the menu
      Then Status History Page is opened
      And Status history for $ System 4 - Admin system is displayed on the page
      When User clicks on drilldown brick
      Then Drill down is opened
      And User is able to see element
      |Raw Data|
      |Business logic|
      When User clicks Close button on the form
      Then Status history is displayed
      When User clicks on Last 24h history view
      Then Status history is displayed
      When User clicks on home icon
      Then Platform Availability Home Page is opened

    @Smoke @AdminSmoke
    Scenario: Admin is able to access all pages from admin menu
      Given User is on Splash page1
      When User clicks on hamburger menu button
      Then User is able to see following options in the menu1
        |Notifications|
        |Systems|
        |Manage Users|
        |Manage Roles|
        |Institutions|
        |Manage Regions|
        |Change logs|
        |About|
        |FAQ|
        |Status|
      When User clicks on Notifications in admin menu
      Then Notifications Page is opened
      When User clicks on Systems in admin menu
      Then Systems Page is opened
      When User clicks on Manage Users in admin menu
      Then Manage Users Page is opened
      When User clicks on Manage Roles in admin menu
      Then Manage Roles Page is opened
      When User clicks on Institutions in admin menu
      Then Institutions Page is opened
      When User clicks on Manage Regions in admin menu
      Then Manage Regions Page is opened
      When User clicks on Change logs in admin menu
      Then Change logs Page is opened
      When User clicks on About in admin menu
      Then About Techcheck Page is opened
      When User clicks on FAQ in admin menu
      Then FAQ Page is opened
      When User clicks on Status in admin menu
      Then Status Page is opened

