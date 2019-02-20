Feature: Status History - Admin
  Background: User launches application
    Given User launches application1
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened

  @StatusHistory   @AdminStatusHistory
  Scenario: Admin Status History page - Admin legend, edit notification
    Given User is on Splash page1
    When User clicks on $ System 4 - Admin System card
    Then Status History Page is opened
    And Status history is displayed
    And User sees an admin legend
    When Admin click edit notification button on Splash or SH Page
    Then Admin has opened Edit Notification form Splash or SH Page


  @StatusHistory   @AdminStatusHistory
  Scenario: Admin Status History page - Navigation on monitor link
    Given User is on Splash page1
    When User clicks on $ System 1 - Public System card
    Then Status History Page is opened
    And Status history is displayed
    When User navigates to Monitor link
    Then Edit monitor form is displayed

  @StatusHistory   @AdminStatusHistory
  Scenario: Admin Status History page - Drill down tables, edit notif, click on back button
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    And Status history for Aplia system is displayed on the page
    When User clicks on drilldown brick
    Then Drill down is opened
    And Raw Data table has following headers
      |Monitor name|
      |Service Id  |
      |Locations OK|
      |Health      |
      |Worst time  |
      |Average time|
      |Best time   |
      |Monitor date|
      |Last updated date|
    And Business Logic table has following headers
      |Rule      |
      |Status    |
    And Drill down Notification table has following headers
      |Enabled   |
      |Event type|
      |Override  |
      |Systems   |
      |Start time|
      |End time  |
      |Message   |
    When User expands Monitor table
    Then Monitor table has following headers
      |Location name     |
      |Status            |
      |Server Time       |
      |Network Time      |
      |Browser Time      |
      |Total Time        |
      |Monitor date      |
      |Last modified date|
    And Following values are present in the monitor table in Location name column
      |anexia-miami        |
      |anexia-atlanta      |
      |anexia-chicago      |
      |anexia-denver       |
      |aws-us-east-1       |
      |anexia-new-york-city|
      |anexia-los-angeles  |
    And Business Logic table has Monitor health and status: value in Rule column
    When User click drill down back button
    Then Drill down datetime changed to minus 5 mins
    When Admin click edit notification button on Drilldown modal form
    Then Admin has opened Edit Notification form Splash or SH Page

  @StatusHistory @MultipleMonitors @AdminStatusHistory
  Scenario: Multiple monitors
    When User clicks on Aplia System card
    Then Status History Page is opened
    When User sees and clicks Add monitors button
    Then Select monitors window is appeared
    And checkbox for Aplia \ Aplia (1032) monitor is selected and not editable
    When User clicks on checkbox with "MindTap \ MindTap (1009)" monitor
    And User clicks on checkbox with "Questia \ Questia (1046)" monitor
    And User clicks on OK modal button
    Then Select monitors window is closed
    When User clicks on 1009 link on Multiple Monitors view
    Then Status history for monitor MindTap \ MindTap (1009) is displayed on the page
    When User clicks browser back button
    Then Multiple Monitors view is opened
    And chosen "MindTap / MindTap" with Service ID 1009 monitor is in the list
    And chosen "Questia / Questia" with Service ID 1046 monitor is in the list
    And chosen "Aplia / Aplia" with Service ID 1032 monitor is in the list
    And Last 30 days tab is not visible
    And Specify range tab is not visible
    When User clicks on Last 24h history view
    Then last-24  tab is selected
    And there are 75 sections in the status bar
    And chosen "MindTap / MindTap" with Service ID 1009 monitor is in the list
    And chosen "Questia / Questia" with Service ID 1046 monitor is in the list
    And chosen "Aplia / Aplia" with Service ID 1032 monitor is in the list
    When User clicks on Specify date history view
    Then specify-date  tab is selected
    And Current date is displayed by default
    When User selects date in the past by clicking on Specify previous date button
    Then Choose date field is displayed
    When User selects first day of the previous month
    Then there are 72 sections in the status bar
    And chosen "MindTap / MindTap" with Service ID 1009 monitor is in the list
    And chosen "Questia / Questia" with Service ID 1046 monitor is in the list
    And chosen "Aplia / Aplia" with Service ID 1032 monitor is in the list
    When User clicks on Last 12h history view
    Then last-12  tab is selected
    And there are 39 sections in the status bar
    When User sees and clicks Add monitors button
    Then Select monitors window is appeared
    When User clicks on checkbox with "MindTap \ MindTap (1009)" monitor
    And User clicks on checkbox with "Aplia \ Aplia (1032)" monitor
    Then checkbox for Questia \ Questia (1046) monitor is selected and not editable
    When User clicks on OK modal button
    Then Select monitors window is closed
    And Status history for monitor Questia \ Questia (1046) is displayed on the page
    When User sees and clicks Add monitors button
    Then Select monitors window is appeared
    When User clicks on checkbox with "MindTap \ MindTap (1009)" monitor
    And User clicks on checkbox with "Aplia \ Aplia (1032)" monitor
    And User verifies and clicks Reset button in the window
    Then checkbox for "MindTap \ MindTap (1009)" monitor is not selected
    And checkbox for "Aplia \ Aplia (1032)" monitor is not selected
    And checkbox for Questia \ Questia (1046) monitor is selected and not editable
    When User clicks on checkbox with "MindTap \ MindTap (1009)" monitor
    And User clicks on checkbox with "Aplia \ Aplia (1032)" monitor
    And User clicks on OK modal button
    Then Select monitors window is closed
    When User sees and clicks Add monitors button
    And User verifies and clicks Clear all button in the window
    Then no active checkbox is in the list
    And OK modal button is disabled