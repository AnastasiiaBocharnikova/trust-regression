Feature: Notifications

  Background: User launches application and login
    Given User launches application1
    When User Navigates to LoginPage1
    And Login with valid admin credentials1

  @NotificationsV
  Scenario: Verification KITT link on the Notifications page
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened
    When User clicks on KITT link on page
    Then Link navigates to http://critinc.cengage.com/Login.aspx?ReturnUrl=%2fdefault.aspx

  @Notifications
  Scenario: Verifications of columns and quick filters on Notification page
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened
    Then Notifications table contains columns
      |ID|
      |Enabled|
      |Creation time|
      |Last updated|
      |Systems|
      |Access Level|
      |Event start time|
      |Event end time|
      |Show start time|
      |Show end time|
      |Created by|
      |Updated by|
      |Event type|
      |Override|
      |Message|

    #Show column chooser
    When User opens "Select displayed columns" pop-up
    And User deselects 3 column in the "Select displayed columns" pop-up
    Then Deselected Creation time column is not displayed in the table

   #quick filters
     And Notifications page contains next quick filters
      |1|Recently updated|
      |2|Recently active|
      |3|My notifications|
      |4|Not auto-generated|
      |5|Public|

    When User clicks on Show more button on Recently updated quick filter
    Then 'Recently updated' and 'Recently added' options are displayed
    And Close list of options from quick filter

    When User clicks on Show more button on Recently active quick filter
    Then 'Recently active', 'Currently active' and 'Displaying now' options are displayed
    And Close list of options from quick filter

    When User clicks on Show more button on Public quick filter
    Then 'Public' and 'All internal' options are displayed
    And Close list of options from quick filter

    When User resets the table to default state and set 5 rows per page
    And User applies Recently updated quick filter
    Then Notifications updated within the last 24 hours are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies Recently added quick filter
    Then Notifications created within the last 24 hours are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies Currently active quick filter
    Then Notifications with the Event time range including the current time are displayed
    #Event start time is before current date and Event end time is after current date or Unknown

    When User resets the table to default state and set 5 rows per page
    And User applies Displaying now quick filter
    Then Notifications with the Show time range including the current time are displayed
    #Show start time is before current date/time and Show end time is after current date/time or Unknown are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies My notifications quick filter
    Then Notifications created or updated by auto-test user are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies Not auto-generated quick filter
    Then Not auto-generated notifications are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies Public quick filter
    Then Notifications with public Access level are displayed

    When User resets the table to default state and set 5 rows per page
    And User applies All internal filter
    Then Notifications with Admin/Internal/GPT Access level are displayed

  @Notifications
  Scenario: Filtering Notifications table
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Creation time column by current day
    Then Created today notifications are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Last updated column by current day
    Then Updated today notifications are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by CNOW system
    Then Notifications for CNOW system only are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User set "Public" value to "Access Level" dropdown on Notifications page
    Then Notifications with public access level only are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Event start time column by current day
    Then Started today notifications are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Event end time column by Unknown
    Then Notifications with unknown event end time are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Event end time column by current day
    Then Ended today notifications are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Created by column by auto-test user
    Then Notifications created by auto-test user are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by Updated by column by auto-test user
    Then Notifications updated by auto-test user are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by 4 event type
    Then Notifications with Service disruption event type are displayed in the table

    When User resets the table to default state and set 5 rows per page
    And User filters Notification table by CNOW message
    Then Notifications with CNOW messages are displayed in the table

  @Notifications
  Scenario: Sorting Notifications table
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened

    #Creation time
    When User resets the table to default state and set 5 rows per page
    And User clicks on Creation-time column header
    Then Notifications table is sorted by Creation time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Creation-time column header
    Then Notifications table is sorted by Creation time column in descending order

    #Last updated
    When User resets the table to default state and set 5 rows per page
    And User clicks on Last-updated column header
    Then Notifications table is sorted by Last updated column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Last-updated column header
    Then Notifications table is sorted by Last updated column in descending order

    #Event start time
    When User resets the table to default state and set 5 rows per page
    And User clicks on Event-start-time column header
    Then Notifications table is sorted by Event start time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Event-start-time column header
    Then Notifications table is sorted by Event start time column in descending order

    #Event end time
    When User resets the table to default state and set 5 rows per page
    And User clicks on Event-end-time column header
    Then Notifications table is sorted by Event end time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And User clicks two times on Event-end-time column header
    Then Notifications table is sorted by Event end time column in descending order

    #Show start time
    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks on Show-start-time column header
    Then Notifications table is sorted by Show start time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks two times on Show-start-time column header
    Then Notifications table is sorted by Show start time column in descending order

    #Show end time
    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks on Show-end-time column header
    Then Notifications table is sorted by Show end time time column in ascending order

    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks two times on Show-end-time column header
    Then Notifications table is sorted by Show end time column in descending order

    #Created by
    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks on Created-by column header
    Then Notifications table is sorted by Created by column in ascending order

    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks two times on Created-by column header
    Then Notifications table is sorted by Created by column in descending order

    #Updated by
    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks on Updated-by column header
    Then Notifications table is sorted by Updated by column in ascending order

    When User resets the table to default state and set 5 rows per page
    And Scroll Notification table to Message column
    And User clicks two times on Updated-by column header
    Then Notifications table is sorted by Updated by column in descending order

  @Notifications
  Scenario: Verification template table, create, update, select in create Notification form, delete template
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened
    When User clicks on Manage templates button on Notifications page
    Then Notification templates page is opened
    And Notification templates table contains columns
     |Enabled|
     |Name|
     |Message|
     |Created at|
     |Created by|
     |Updated at|
     |Updated by|

    When User verifies that there is no template autoTemplate
    And User verifies that there is no template autoTemplateEdited

    When User clicks on New template button
    Then Add template pop-up is displayed
    When User fills in all required fields and saves new template
    Then Template autoTemplate is displayed in the table
    When User clicks on template autoTemplate in the table
    Then Update template form is displayed
    When User adds Edited to Name and Message fields and saves the template
    Then Template autoTemplateEdited is displayed in the table

    When User clicks on Back button
    Then Notifications Page is opened
    When User clicks on New Notification button on Notifications page
    Then "None" is displayed by default in the template dropdown
    When User selects template autoTemplateEdited in the template dropdown
    Then Created templateEdited text is displayed in the Message field
    And User discards changes

    When User clicks on Manage templates button on Notifications page
    When User deletes autoTemplateEdited template from the table
    Then Template autoTemplateEdited is removed from table

  @Notifications
  Scenario: Create, edit, clone, delete notification
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened
    When User clicks on New Notification button on Notifications page
    Then Create Notification pop-up is displayed
    And Current date with timezone is shown above the dates and times block
    When User fills in all required fields in Create Notification pop-up, set Event type and saves new notification
      |System|$ System 1 - Public|
      |Message| auto-test|
    Then Notification auto-test is displayed in the table

    When User clicks on auto-test notification in the table
    Then Edit Notification form is displayed
    And Current date with timezone is shown above the dates and times block
    When User selects system with name Aplia for notification
    And User adds Edited to Message field
    And User saves updates
    Then Notification Edited is displayed in the table
    When User deletes  Edited notification from the table
    Then Notification Edited is removed from table

    When User clicks on Clone notification button for notification
    Then Create Notification pop-up is displayed
    When User adds Cloned to Message field
    And User saves updates
    Then Notification Cloned is displayed in the table

    When User deletes  Cloned notification from the table
    Then Notification Cloned is removed from table

  @Notifications
  Scenario: Pagination - Rows per page
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened

    When User resets the table to default state
    And User selects 5 notifications per page
    Then 5 notifications are displayed on the page

    When User resets the table to default state
    And User selects 10 notifications per page
    Then 10 notifications are displayed on the page

    When User resets the table to default state
    And User selects 20 notifications per page
    Then 20 notifications are displayed on the page

    When User resets the table to default state
    And User selects 25 notifications per page
    Then 25 notifications are displayed on the page

    When User resets the table to default state
    And User selects 50 notifications per page
    Then 50 notifications are displayed on the page

    When User resets the table to default state
    And User selects 100 notifications per page
    Then 100 notifications are displayed on the page

  @Notifications
  Scenario: Pagination - Navigation to first, previous, next and last pages
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened

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

  @Download
  Scenario: Export to csv on Notifications page
    When User clicks on hamburger menu button
    And User clicks on Notifications from admin menu
    Then Notifications Page is opened
    When User clears previously downloaded files
    And User clicks on export to CSV button
    Then CSV file with notifications is downloaded
    And User removes the downloaded file