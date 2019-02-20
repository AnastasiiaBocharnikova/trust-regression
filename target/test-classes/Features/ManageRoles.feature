Feature: ManageRoles
  Background: User launches application and login1
    Given User launches application1
      When User Navigates to LoginPage1
      And Login with valid admin credentials1
      Then Platform Availability Home Page is opened
	
	@ManageRoles @Regression
	Scenario: Testing Manage roles table, special roles (Guest, Superadmin, Viewer) and creating/updating/deleting role
		When User clicks on hamburger menu button
		And User clicks on Manage Roles from admin menu
		Then Manage Roles Page is opened
		And Manage Roles table contains next headers
			|Name|
			|Notifications|
			|Overrides|
			|Systems|
			|Monitors|
			|Menu|
			|Users|
			|Roles|
			|Notification Templates|
			|Banners|
			|Create systems|
			|Regions|
			|Groups|
			|Drill Down|
			|Admin Stats|
			|FAQ|
			|Change logs|
			|Edit About Page|
			|Institutions|
			|System Lists|
		And Role Guest* is displayed in the table
		And Delete button for Guest* role is displayed as disabled
		And Role Superadmin* is displayed in the table
		And Delete button for Superadmin* role is displayed as disabled
		And Role Viewer* is displayed in the table
		And Delete button for Viewer* role is displayed as disabled
		When User clicks on Notifications permission for Guest* role
 		Then Toaster "This row cannot be edited" is displayed
		When User clicks on Systems permission for Superadmin* role
 		Then Toaster "This row cannot be edited" is displayed
 		When User clicks on Regions permission for Viewer* role
 		Then Toaster "This row cannot be edited" is displayed
		When User clicks Add New Role button
		And Populates new role with autoRole name
		Then Role autoRole is displayed in the table
		When User clicks on Notifications permission for autoRole role
		And User selects Create permission type
		Then Icon add_circle is displayed for Notifications permission for autoRole role
		When User deletes autoRole role from the table
		Then Role autoRole is removed from the table
		
	@ManageRoles @Regression
	Scenario: Testing different permissions for the role (List, Update, Create, Delete) 
		When User clicks on hamburger menu button
		And User clicks on Manage Roles from admin menu
		And User clicks Add New Role button
		And Populates role with autoRole1 name and next permissions
			|Notifications|List|		
			|Menu|Tree|
			|Roles|List|
		Then Role autoRole1 is displayed in the table
		When User clicks on Manage Users from admin menu
		And User filters Manage Users table by auto-test2 username
		Then User with username auto-test2 is displayed in the Manage Users table
		When User clicks on auto-test2 user in the table
		And Select autoRole1 role
   	    And User clicks on OK modal button
   	    And User clicks on Logout button
        Then User Navigates to LoginPage1
        When Login with auto-test2 and Autotest2 credentials
        Then Only next menu options are displayed
           |Notifications|
           |Systems|
           |Manage Roles|
		When User clicks on Notifications from admin menu
    	Then Notifications Page is opened
    	And Notifications table contains columns
      		|ID|
      		|Enabled|
      		|Creation time|
      		|Last updated|
    	And New Notification button isn't displayed
    	And Manage Templates button isn't displayed
    	And Clone Notification button isn't displayed
    	And Delete Notification button isn't displayed
        When User clicks notification number 1 in the table
    	Then Edit Notification form isn't displayed
    	When User clicks on Systems from admin menu
    	Then Systems Page is opened
    	And Add System button isn't displayed
    	And Edit System button isn't displayed
    	And Delete System button isn't displayed
    	When User clicks on Manage Roles from admin menu
		Then Manage Roles Page is opened
		When User clicks on Regions permission for autoRole1 role
		Then List of permission options isn't displayed
		And Delete Role button isn't displayed
		When User clicks on Logout button
		Then User Navigates to LoginPage1
        When Login with auto-test and 2018Auto@! credentials
        And User clicks on Manage Roles from admin menu
        And User clicks on Notifications permission for autoRole1 role
		And User selects Delete permission type
		And User clicks on Systems permission for autoRole1 role
		And User selects Update permission type	
		And User clicks on Create systems permission for autoRole1 role
		And User selects All permission type
		And User clicks on Roles permission for autoRole1 role
		And User selects Update permission type
		And User clicks on Notification Templates permission for autoRole1 role
		And User selects All permission type	
		And User clicks on Logout button
		Then User Navigates to LoginPage1
        When Login with auto-test2 and Autotest2 credentials
		When User clicks on Notifications from admin menu
    	Then Notifications Page is opened
    	And New Notification button is displayed
    	And Manage Templates button is displayed
    	And Clone Notification button is displayed
    	And Delete Notification button is displayed
    	When User clicks notification number 1 in the table
    	Then Edit Notification form is displayed
    	When User saves updates
    	And User clicks on Systems from admin menu
    	Then Systems Page is opened
    	And Add System button is displayed
    	And Edit System button is displayed
    	When User clicks on Manage Roles from admin menu
		Then Manage Roles Page is opened
		When User clicks on Regions permission for autoRole1 role
		Then List of permission options is displayed
		And User selects Update permission type
		When User clicks on Logout button
		Then User Navigates to LoginPage1
        When Login with auto-test and 2018Auto@! credentials
		And User clicks on Manage Roles from admin menu
		And User deletes autoRole1 role from the table
		Then Role autoRole1 is removed from the table