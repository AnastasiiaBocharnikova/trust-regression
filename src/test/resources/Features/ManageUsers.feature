Feature: Manage Users

Background: User launches application and login
	Given User launches application1
	When User Navigates to LoginPage1
	And Login with valid admin credentials1

   @ManageUsers
   Scenario: Verification KITT link on the Manage Users page
	  When User clicks on hamburger menu button
	  And User clicks on Manage Users from admin menu
	  Then Manage Users Page is opened
	  When User clicks on KITT link on page
	  Then Link navigates to http://critinc.cengage.com/Login.aspx?ReturnUrl=%2fdefault.aspx

  @ManageUsers
  Scenario: Verifications of columns and Show column chooser on the Manage Users page
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    And Manage Users table contains columns
      |Enabled|
      |Username|
      |First Name|
      |Middle Initial|
      |Last Name|
      |Email|
      |Roles|
      |Creation time|
      |Last updated|
  #Show column chooser
      When User opens "Select displayed columns" pop-up
      And User deselects 3 column in the "Select displayed columns" pop-up
      Then Deselected First Name column is not displayed in the table

  @ManageUsers
  Scenario: Sorting Manage Users table
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened

    #Username
    When User resets the table to default state and set 5 rows per page
    And User clicks on Username column header
    Then The table is sorted by Username column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Username column header
    Then The table is sorted by Username column in descending order

    #First Name
    When User resets the table to default state and set 5 rows per page
    And User clicks on First-Name column header
    Then The table is sorted by First Name column in descending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on First-Name column header
    Then The table is sorted by First Name column in ascending order

    #Middle Initial
    When User resets the table to default state and set 5 rows per page
    And User clicks on Middle-Initial column header
    Then The table is sorted by Middle Initial column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Middle-Initial column header
    Then The table is sorted by Middle Initial column in descending order

    #Last Name
    When User resets the table to default state and set 5 rows per page
    And User clicks on Last-Name column header
    Then The table is sorted by Last Name column in descending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Last-Name column header
    Then The table is sorted by Last Name column in ascending order

    #Email
    When User resets the table to default state and set 5 rows per page
    And User clicks on Email column header
    Then The table is sorted by Email column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Email column header
    Then The table is sorted by Email column in descending order

    #Creation time
    When User resets the table to default state and set 5 rows per page
    And User clicks on Creation-time column header
    Then The table is sorted by Creation time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Creation-time column header
    Then The table is sorted by Creation time column in descending order

    #Last updated
    When User resets the table to default state and set 5 rows per page
    And User clicks on Last-updated column header
    Then The table is sorted by Last updated column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Last-updated column header
    Then The table is sorted by Last updated column in descending order

  @ManageUsers
  Scenario: Filtering Manage Users table
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened

    #Username
    When User resets the table to default state
    And User filters Manage Users table by auto-test username
    Then User with username auto-test is displayed in the Manage Users table

    #First Name
    When User resets the table to default state
    And User filters Manage Users table by Cengage First Name
    Then Users with First Name Cengage are displayed in the Manage Users table

    #Last Name
    When User resets the table to default state
    And User filters Manage Users table by Internal Last Name
    Then Users with Last Name Internal are displayed in the Manage Users table

    #Email
    When User resets the table to default state
    And User filters Manage Users table by tcautouser1+auto1@gmail.com email
    Then User with email tcautouser1+auto1@gmail.com is displayed in the Manage Users table

    #Roles
    When User resets the table to default state and set 5 rows per page
    And User filters Manage Users table by Guest role
    Then Users with role Guest are displayed in the Manage Users table

    #System
    When User resets the table to default state and set 5 rows per page
    And Switch to Select systems list in Roles column
    And User filters Manage Users table by GPT system
    Then Users with system GPT are displayed in the Manage Users table

  @ManageUsers
  Scenario: Verify special users
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened

    #supersdmin
    When User filters Manage Users table by superadmin username
    Then User with username superadmin is displayed in the Manage Users table
    And Enabled checkbox, Delete and Clone buttons are disabled for superadmin user
    And User superadmin contains Superadmin(All systems) value in Roles column
    When User clicks on superadmin user in the table
    Then Toaster "User 'superadmin' cannot be edited" is displayed

    #guest
    When User resets the table to default state
    And User filters Manage Users table by guest username
    Then User with username guest is displayed in the Manage Users table
    And Enabled checkbox and Delete button are disabled for guest user
    And User guest contains Guest(All systems) value in Roles column
    And User guest contains Viewer(Public) value in Roles column
    When User clicks on guest user in the table
    Then Edit User pop-up is displayed
    And Username guest is displayed
    And Enabled toggle and Guest role are disabled for guest user
    And User clicks on OK modal button

    #cengageinternal
    When User resets the table to default state
    And User filters Manage Users table by cengageinternal username
    Then User with username cengageinternal is displayed in the Manage Users table
    And Enabled checkbox and Delete button are disabled for cengageinternal user
    And User cengageinternal contains Viewer(Internal) value in Roles column
    And User cengageinternal contains Internal(All systems) value in Roles column
    And User cengageinternal contains Guest(All systems) value in Roles column
    When User clicks on cengageinternal user in the table
    Then Edit User pop-up is displayed
    And Username cengageinternal is displayed
    And Enabled toggle and Guest role are disabled for cengageinternal user
    And User clicks on OK modal button

    #slackbot
    When User resets the table to default state
    And User filters Manage Users table by slackbot username
    Then User with username slackbot is displayed in the Manage Users table
    And Enabled checkbox and Delete button are disabled for slackbot user
    And User slackbot contains Viewer(GPT) value in Roles column
    When User clicks on slackbot user in the table
    Then Edit User pop-up is displayed
    And Username slackbot is displayed
    And Enabled toggle is disabled for slackbot user
    And User clicks on OK modal button

  @ManageUsers
  Scenario: Create, edit, clone, delete user
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    When Verify that there is no user with username auto-testing and email tcautouser1+auto@gmail.com
    And User resets the table to default state
    And Verify that there is no user with username auto-testing and email tcautouser1+edited@gmail.com
    And User resets the table to default state
    And Verify that there is no user with username auto-cloning and email tcautouser1+clone@gmail.com
    And User resets the table to default state

    And User clicks on New User button on the Manage Users page
    Then Create User pop-up is displayed
    When User populates fields in Create User pop-up
      |Username|auto-testing|
      |Email|tcautouser1+auto@gmail.com|
      |First Name|auto|
      |Last Name|auto|
      |Middle Initial|auto|
      |Role|Admin|
    And User clicks on OK modal button
    And User resets the table to default state
    And User filters Manage Users table by auto-testing username
    Then User with username auto-testing is displayed in the Manage Users table
    And User auto-testing has tcautouser1+auto@gmail.com value in Email column
    And User auto-testing contains Admin(All systems) value in Roles column

    When User clicks on auto-testing user in the table
    Then Edit User pop-up is displayed
    And Username field is disabled
    When User updates fields in Edit User pop-up
      |Email|tcautouser1+edited@gmail.com|
      |First Name|autoEdited|
      |Last Name|autoEdited|
      |Middle Initial|autoEdited|
    And Delete previously selected role
    And Select Notifications Manager role with $ System 1 - Public system
    And User clicks on OK modal button
    Then User auto-testing has tcautouser1+edited@gmail.com value in Email column
    And User auto-testing contains Notifications Manager($ System 1 - Public) value in Roles column

    When User clicks on Clone user button
    Then Create User pop-up is displayed
    And Error messages are displayed for the Username and Email fields
    When User populates fields in Create User pop-up
      |Username|auto-cloning|
      |Email|tcautouser1+clone@gmail.com|
      |First Name|Clone|
      |Last Name|Clone|
      |Middle Initial|Clone|
    And User clicks on OK modal button
    And User resets the table to default state
    And User filters Manage Users table by auto-cloning username
    Then User with username auto-cloning is displayed in the Manage Users table

    When User deletes auto-cloning user from the table
    Then User auto-cloning is deleted from table

    When User resets the table to default state
    And User filters Manage Users table by auto-testing username
    And User deletes auto-testing user from the table
    Then User auto-testing is deleted from table

  @ManageUsers
  Scenario: Change password, password verification and login with new password, opening Profile
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened

    When Verify that there is no user with username auto-test-passwords and email tcautouser1+passw@gmail.com
    And User clicks on New User button on the Manage Users page
    Then Create User pop-up is displayed
    When User populates fields in Create User pop-up
      |Username|auto-test-passwords|
      |Email|tcautouser1+passw@gmail.com|
    And User clicks on OK modal button

    And User resets the table to default state
    And User filters Manage Users table by auto-test-passwords username
    Then User with username auto-test-passwords is displayed in the Manage Users table
    When User clicks on auto-test-passwords user in the table
    Then Edit User pop-up is displayed
    When User clicks on Change Password button
    Then Password and Repeat password fields are displayed
    And Show Password checkbox is not selected by default

    When User clicks on Show Password checkbox
    Then Show Password checkbox is selected
    And Password and Repeat password fields have text type

    When User clicks on Show Password checkbox
    Then Show Password checkbox is unselected
    And Password and Repeat password fields have password type

    When User populates Cengage1 value to the Password field
    And User clicks on Show Password checkbox
    And User clicks on OK modal button
    Then 'This password is not allowed' error is displayed under the Password field
    And 'Required' error is displayed under the Repeat password field

    When User populates Password1 value to the Password field
    And User clicks on OK modal button
    Then 'This password is not allowed' error is displayed under the Password field
    And 'Required' error is displayed under the Repeat password field

    When User populates 1 value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has fail status
    And 'Should have at least one uppercase character' verification has fail status
    And 'Should have at least one lowercase character' verification has fail status
    And 'Should have at least one number' verification has success status

    When User populates p value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has fail status
    And 'Should have at least one uppercase character' verification has fail status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has fail status

    When User populates P value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has fail status
    And 'Should have at least one uppercase character' verification has success status
    And 'Should have at least one lowercase character' verification has fail status
    And 'Should have at least one number' verification has fail status

    When User populates pass1 value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has fail status
    And 'Should have at least one uppercase character' verification has fail status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has success status

    When User populates Pass1 value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has fail status
    And 'Should have at least one uppercase character' verification has success status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has success status

    When User populates password value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has success status
    And 'Should have at least one uppercase character' verification has fail status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has fail status

    When User populates Password value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has success status
    And 'Should have at least one uppercase character' verification has success status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has fail status

    When User populates password3 value to the Password field
    And User clicks on OK modal button
    Then 'Minimum 8 characters' verification has success status
    And 'Should have at least one uppercase character' verification has fail status
    And 'Should have at least one lowercase character' verification has success status
    And 'Should have at least one number' verification has success status

    When User populates Qwerty123 value to the Password field
    And User populates Qwerty234 value to the Repeat password field
    And User clicks on OK modal button
    Then 'Your password and confirmation password do not match' error is displayed under the Repeat password field

    When User populates Qwerty123 value to the Password field
    And User populates Qwerty123 value to the Repeat password field
    And User clicks on Show Password checkbox
    Then Green check mark is displayed in the Password field
    And Green check mark is displayed in the Repeat password field

    When User clicks on OK modal button
    Then Toaster "User 'auto-test-passwords' was updated" is displayed

    When User clicks on Logout button
    And User Navigates to LoginPage1
    And Login with auto-test-passwords and Qwerty123 credentials
    And User clicks on the Profile button
    Then Profile pop-up is displayed
    And Username auto-test-passwords is displayed
    And Username field is disabled
    And User has tcautouser1+passw@gmail.com email

    When User clicks on Close button
    And User clicks on Logout button
    And User Navigates to LoginPage1
    And Login with valid admin credentials1
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    When User resets the table to default state
    And User filters Manage Users table by auto-test-passwords username
    And User deletes auto-test-passwords user from the table
    Then User auto-test-passwords is deleted from table

  @ManageUsers
  Scenario: Pagination - Navigation to first, previous, next and last pages
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened

    When User navigates to next page
    Then Second page is displayed
    And First page and Previous page buttons are enabled

    When User navigates to previous page
    Then First page is displayed
    And First page and Previous page buttons are disabled

    When User navigates to last page
    Then Last page is displayed
    And Next page and Last page buttons are disabled

    When User navigates to first page
    Then First page is displayed
    And First page and Previous page buttons are disabled

  @ManageUsers
  Scenario: Verification first login using activation link from email
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    When Verify that there is no user with username autotestingemail and email tcautouser1+email@gmail.com
    And User resets the table to default state

    And User clicks on New User button on the Manage Users page
    Then Create User pop-up is displayed
    When User populates fields in Create User pop-up
      |Username|autotestingemail|
      |Email|tcautouser1+email@gmail.com|
      |First Name|auto1|
      |Last Name|auto2|
      |Middle Initial|auto3|
      |Role|Admin|
    And User clicks on OK modal button
    And User resets the table to default state
    And User filters Manage Users table by autotestingemail username
    Then User with username autotestingemail is displayed in the Manage Users table
    And User autotestingemail has tcautouser1+email@gmail.com value in Email column
    And User autotestingemail contains Admin(All systems) value in Roles column

    When User navigates to email and opens the last email from Inbox folder
    And Email is From 'TechCheck <trust@cengage.com>'
    And Email has subject 'Welcome to Techcheck!'
    And Email contains 'Hi <First Name> <Middle Initial> <Last Name>'
    And Email contains text that user with username autotestingemail has been created in the Techcheck system
    And Email contains an activation link for first login
    When User opens the activation link
    Then First Login Page / Profile page is displayed
    And 'Please change your password' text is displayed
    Then Password and Repeat password fields are displayed
    And Show Password checkbox is not selected by default

    When User populates Qwerty123 value to the Password field
    And User populates Qwerty123 value to the Repeat password field
    And User clicks on OK modal button

    And User clicks on Logout button
    And User Navigates to LoginPage1
    And Login with valid admin credentials1
    #next line for AWS envs (without -2)
    And User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    When User resets the table to default state
    And User filters Manage Users table by autotestingemail username
    And User deletes autotestingemail user from the table
    Then User autotestingemail is deleted from table

  @ManageUsersJ @UploadCSV
  #error in the Jenkins, local - OK
  Scenario: Verification creating a new user using Bulk user creation
    When User clicks on hamburger menu button
    And User clicks on Manage Users from admin menu
    Then Manage Users Page is opened
    When Verify that there is no user with username auto-username and email tcautouser1+csv@gmail.com
    And User resets the table to default state
    When User clicks on Bulk user creation button
    Then Bulk user creation pop-up is displayed
    When User clicks on Upload CSV button and selects auto-test.csv file
    Then The file is successfully selected without invalid users
    When User clicks on Submit Upload button
    Then 'Users have been created!' is displayed
    When User closes Bulk user creation pop-up
    And User filters Manage Users table by auto-username username
    Then User with username auto-username is displayed in the Manage Users table
    When User deletes auto-username user from the table
    Then User auto-username is deleted from table
