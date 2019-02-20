Feature: Swagger

  @Swagger @SwaggerSmoke
  Scenario: Smoke - identify that Swagger can be loaded
    Given User launches application1
    When User opens Swagger page
    Then User is on Swagger page
    And User is able to see modules on Swagger page
      |Faq          |
      |Feedback     |
      |Monitors     |
      |Notifications|
      |Regions      |
      |Roles        |
      |Status       |
      |Sync         |
      |Systems      |
      |Templates    |
      |Users        |
      |CDN          |
      |Changelogs   |
      |Groups       |
      |Institutions |
      |My           |
      |Template     |


  @Swagger
  Scenario: Execute one Get request
    Given User launches application1
    When User opens Swagger page
    Then User is on Swagger page
    When User clicks on GET FAQ operation
    Then FAQ operation is expanded
    When User clicks on Try it out button
    Then Execute button is displayed
    When User clicks on Execute button
    Then Swagger returns 200 response code