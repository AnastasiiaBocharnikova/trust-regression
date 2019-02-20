Feature: Status History - Public
  Background: User launches application
    Given User launches application1
    When User clicks Cengage Internal user button
    Then Platform Availability Home Page is opened
    And Internal-public switch is unset to Public value

  @StatusHistory   @PublicStatusHistory
  Scenario: Status History page - sync and description text on 12h, 24h, specify date tabs
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    And User can see last sync time and it's less than 70 sec
    And User is able to see text description
    When  User clicks on expand banner
    Then User sees Banner collapse
    When  User clicks on collapse banner
    Then User sees Banner expand
    And  User sees word banner in banner body
    And Public User doesnt see Add Monitors button
    When User clicks on Last 24h history view
    Then User can see last sync time and it's less than 70 sec
    And User is able to see text description
    When User clicks on Specify date history view
    Then User can see last sync time and it's less than 70 sec
    And User is able to see text description

  @StatusHistory   @PublicStatusHistory
  Scenario: Status History page - sync and description text on 12h, 24h, specify date tabs
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    And User sees 12 rows with bricks
    And User sees 144 bricks on Status History Page
    When User clicks on Last 24h history view
    Then User sees 24 rows with bricks
    And User sees 288 bricks on Status History Page

  @StatusHistory   @PublicStatusHistory
  Scenario: Status History page - legend on Status History
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    And User sees a public legend
    When User clicks on Last 24h history view
    Then User sees a public legend
    When User clicks on Specify date history view
    Then User sees a public legend
    When User clicks on Last 30 days history view
    Then User sees a public legend
    When User clicks on Specify range history view
    And User selects previous day as Start Date range
    Then User sees a public legend

  @StatusHistory   @PublicStatusHistory
  Scenario: Status History page - Notifications in the table on Status History page
    Given User is on Splash page1
    When User clicks on timezone control
    And User enters EST to timezone input field
    And User selects EST timezone from dropdown
    And User clicks Ok button on Select timezone modal form
    Then The EST timezone is currently selected in the app
    When User clicks on $ System 1 - Public System card
    Then Status History Page is opened
    And Notification table on Status History page has following headers
      |Event type|
      |Systems   |
      |Monitor   |
      |Start time|
      |End time  |
      |Message   |
    And Notification table on Status History with $ For public splash auto test message has value $ System 1 - Public in Systems
    And User is able to see EST timezone in Notification table for Start and End date columns


  @StatusHistory   @PublicStatusHistory
  Scenario: Status History page - Check Specify Range tab - popup for a day and text description for the tab
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    When User clicks on Specify range history view
    And User selects previous day as Start Date range
    And Hover on 1 day brick from the last 30 days
    Then Day status history pop up should be displayed
    And User is able to see specify range tab text description

  @StatusHistory   @PublicStatusHistory
    @issue: TRUST-2738
  Scenario: Status History page - Check 30 days view tab
    Given User is on Splash page1
    When User clicks on Aplia System card
    Then Status History Page is opened
    When User clicks on Last 30 days history view
    Then User is able to see 30 days tab text description
    And There are 31 blocks are displayed
    When User clicks one of the 30-days view blocks with day 01
    Then Specify-date tab is selected
    When User selects date in the past by clicking on Specify previous date button
    Then Selected day is displayed in the specify date field on Status History
    And Status history is displayed for specified day
    And Specify next date button is enabled
    And Specify previous date button is enabled

