Feature: Status
  Background: User launches application and login
    Given User launches application1

  @StatusPage @StatusPageAdmin
  Scenario: Verification of Status page for users with AdminStats permissions
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    And User clicks on hamburger menu button
    And User clicks on Status from admin menu
    Then Status Page is opened
    And Status page contains info about
      |API version|
      |Code revision version|
      |Last commit sha|
      |Current branch|
      |Current Server Date|
      |KPI Backend|
      |KPI API Url|
      |Instance started at|
      |Last deploy|
      |Direct nodes access:|
    And There is no empty value in the second column
    And The same version is displayed in admin menu, API version and Code revision version
    And There are direct links to nodes
    When User clicks on the 1 link to individual nodes
    Then Platform Availability Home Page is opened
    When User closes the individual node tab
    And User clicks on the 2 link to individual nodes
    Then Platform Availability Home Page is opened

  @StatusPage @StatusPagePublic
  Scenario: Verification of Status page for users without AdminStats permissions
    And User clicks Cengage Internal user button
    And User clicks on hamburger menu button
    Then Admin Menu should not be visible
    When User navigates to Status page by link
    Then Status page contains info about
      |API version|
      |Code revision version|
      |Current Server Date|
      |KPI Backend|
    And There is no empty value in the second column
