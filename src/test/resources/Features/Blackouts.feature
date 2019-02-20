Feature: Blackouts Smoke

  Background: User launches application and login
    Given User launches application1
    When User Navigates to LoginPage1
    And Login with valid admin credentials1

@Blackouts
Scenario: Blackouts Smoke
  When User clicks on hamburger menu button
  And User clicks on Notifications from admin menu
  Then Notifications Page is opened

  When User clicks on New Notification button on Notifications page
  Then Create Notification pop-up is displayed
  When User fills in all required fields in Create Notification pop-up, set PM Event type and saves new notification
  |System|$Blackouts_1401|
  |Message|PM-test|
  Then Notification PM-test is displayed in the table

  And BLACKOUT_ENABLED is true for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1401 monitor in the db
  And BLACKOUT_END_DATE is not null for 1401 monitor in the db

  When User disables PM-test notification
  Then Toaster "Blackouts were removed for 1 monitor in the KPI db" is displayed
  And BLACKOUT_ENABLED is false for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1401 monitor in the db
  And BLACKOUT_END_DATE is null for 1401 monitor in the db

  #System with two monitors 1046 and 1032
  When User enables PM-test notification
  Then Toaster "Blackouts were updated for 1 monitor in the KPI db" is displayed
  When User clicks on PM-test notification in the table
  And User selects system with name $Blackouts_1046_1032 for notification
  And User saves updates
  Then BLACKOUT_ENABLED is false for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1401 monitor in the db
  And BLACKOUT_END_DATE is null for 1401 monitor in the db

  And BLACKOUT_ENABLED is true for 1046 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1046 monitor in the db
  And BLACKOUT_END_DATE is not null for 1046 monitor in the db

  And BLACKOUT_ENABLED is true for 1032 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1032 monitor in the db
  And BLACKOUT_END_DATE is not null for 1032 monitor in the db

  #Aggregated monitor 1037 and 1038
  When User clicks on PM-test notification in the table
  And User selects system with name $Blackouts_aggr for notification
  And User saves updates
  Then BLACKOUT_ENABLED is false for 1046 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1046 monitor in the db
  And BLACKOUT_END_DATE is null for 1046 monitor in the db

  And BLACKOUT_ENABLED is false for 1032 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1032 monitor in the db
  And BLACKOUT_END_DATE is null for 1032 monitor in the db

  And BLACKOUT_ENABLED is true for 1037 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1037 monitor in the db
  And BLACKOUT_END_DATE is not null for 1037 monitor in the db

  And BLACKOUT_ENABLED is true for 1038 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1038 monitor in the db
  And BLACKOUT_END_DATE is not null for 1038 monitor in the db

  #Change Event type from PM to Possible disruption and vice versa
  When User clicks on PM-test notification in the table
  And User selects system with name $Blackouts_1401 for notification
  And User saves updates
  Then BLACKOUT_ENABLED is true for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1401 monitor in the db
  And BLACKOUT_END_DATE is not null for 1401 monitor in the db

  When User clicks on PM-test notification in the table
  And User changes Event Type from PM to Possible disruption
  And User saves updates
  Then BLACKOUT_ENABLED is false for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1401 monitor in the db
  And BLACKOUT_END_DATE is null for 1401 monitor in the db

  When User clicks on PM-test notification in the table
  And User changes Event Type from Possible disruption to PM
  And User saves updates
  Then BLACKOUT_ENABLED is true for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1401 monitor in the db
  And BLACKOUT_END_DATE is not null for 1401 monitor in the db

  #Set Event start/end times in the past and in the future
  When User clicks on PM-test notification in the table
  And User sets Event start and Event end times in the past
  And User saves updates

  Then BLACKOUT_ENABLED is false for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1401 monitor in the db
  And BLACKOUT_END_DATE is null for 1401 monitor in the db

  When User clicks on PM-test notification in the table
  And User sets Event start and Event end times in the future
  And User saves updates

  Then BLACKOUT_ENABLED is true for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is not null for 1401 monitor in the db
  And BLACKOUT_END_DATE is not null for 1401 monitor in the db

  #Delete PM notification
  When User deletes PM-test notification from the table
  Then Notification PM-test is removed from table
  And BLACKOUT_ENABLED is false for 1401 monitor in db
  And BLACKOUT_BEGIN_DATE is null for 1401 monitor in the db
  And BLACKOUT_END_DATE is null for 1401 monitor in the db
