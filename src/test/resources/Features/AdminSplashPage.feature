Feature: Splash page
  Background: User launches application
    Given User launches application1
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened

  @Splash @AdminSplash
  Scenario: Admin splash page
    When User is on Splash page1
    Then User sees internal systems
    And System $ System 4 - Admin card is  displayed
    And System $ System 3 - GPT card is  displayed
    And System $ System 2 - Internal card is  displayed
    When User clicks on worst-status button on Splash page
    Then Admin sees at least one system with the same color as color of each of two status spots
    And  There is no notification table on the Splash Page
    When User clicks on worst-status button on Splash page
    And Admin click edit notification button on Splash or SH Page
    Then Admin has opened Edit Notification form Splash or SH Page
