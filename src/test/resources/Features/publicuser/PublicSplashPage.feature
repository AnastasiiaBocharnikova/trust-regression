Feature: Splash page
  Background: User launches application
    Given User launches application1
    When User clicks Cengage Internal user button
    Then Platform Availability Home Page is opened
    And Internal-public switch is unset to Public value

  @Splash   @PublicSplash
  Scenario: Public user splash page - non-internal cards, worst-status button, regions, banner, FAQ and About pages
    When User is on Splash page1
    Then User doesn't see internal systems
    When User clicks on worst-status button on Splash page
    Then User sees at least one system with the same color as color of worst status button
    And  There is no notification table on the Splash Page
    When User clicks on worst-status button on Splash page
    And  User clicks on expand banner
    Then User sees Banner collapse
    When  User clicks on collapse banner
    Then User sees Banner expand
    And  User sees word banner in banner body
    And User sees Important Information in Banner header
    And User sees banner flag on the page
    When User selects Africa region
    Then System $ System 1 - Public card is not displayed
    When User selects United States region
    Then System $ System 1 - Public card is  displayed
    When User clicks on FAQ link
    Then FAQ Page is opened
    When User clicks on home icon
    Then Platform Availability Home Page is opened
    When User clicks on About link
    Then About Techcheck Page is opened

    @Splash @PublicSplash
    Scenario: Public user splash page -  time zone and description text on splash page
      When User is on Splash page1
      Then Expected  welcoming text is displayed - Visit this
      And User clicks on timezone control
      Then Select timezone popup is opened
      When User enters EST to timezone input field
      And User selects EST timezone from dropdown
      And User clicks Ok button on Select timezone modal form
      Then The EST timezone is currently selected in the app
      And User is able to see EST timezone in Notification table for Start and End date columns
      And Timezone at bottom of card is set to EST

    @Splash @PublicSplash
    Scenario: Public user splash page -  Notification table in other systems section
      When User is on Splash page1
      Then Notification table has following headers
          |Event type|
          |Systems   |
          |Start time|
          |End time  |
          |Message   |
      And Notification with $ For public splash auto test message has value $ System 1 - Public in Systems
      And Notification has orange brick picture

  @Splash @PublicSplash
  Scenario: Public user splash page -  System card text and status color check, sync check, non-public systems aren't visible
    When User is on Splash page1
    Then System card for $ System 1 - Public has appropriate to its status picture and text
    And Bottom of a card has text Last updated
    And Progress bar is visible for user
    And User can see last sync time and it's less than 70 sec
    And System $ System 4 - Admin card is not displayed
    And System $ System 3 - GPT card is not displayed
    And System $ System 2 - Internal card is not displayed