Feature: About Page for Admin and Public
  Background: User launches application
    Given User launches application1

  @AboutPage
  Scenario: Admin edits about page and then public should verify this change
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened
    When User clicks on About link
    Then About Techcheck Page is opened
    And User clicks on edit-about button on About Page
    When User enters current date value to edit form
    And User clicks on save-about button on About Page
    Then User cannot see save-about button
    And User can see edit-about button
    When User clicks on home icon
    Then Platform Availability Home Page is opened
    When User clicks on Logout button
    And  User clicks Cengage Internal user button
    And User clicks on About link
    Then About Techcheck Page is opened
    And User is able to see current date value on About Page
    And User cannot see edit-about button

  @AboutPage
  Scenario: Public user navigates to feedback page through about page and verify links and other controls there
    When  User clicks Cengage Internal user button
    And User clicks on About link
    Then About Techcheck Page is opened
    When User closes toaster
    And User clicks on Help Improve link on About Page to Navigate to FeedBack Page
    Then Feedback Page is opened
    And User can see text description for Feedback Page
    When User clicks on Cengage customer support service link on Feedback page
    Then Link navigates to https://cengageportal.secure.force.com/Support
    When User fills in test text to a Feedback form
    And User agrees with policy agreement
    Then Submit button becomes enabled

  @AboutPage
  Scenario: Admin edits about page - editor buttons work
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened
    When User clicks on About link
    Then About Techcheck Page is opened
    And User clicks on edit-about button on About Page
    When User enters current date value to edit form
    And User selects H2 option in the Block Type dropdown on About page editor toolbar
    Then H2 is selected in the Block Type dropdown on About page editor
    When User clicks on Center button in the editor toolbar on About Page
    Then Center button is selected on About Page
    When User selects value in editor form on About Page
    And User selects 14 option in the Font Size dropdown on About page editor toolbar
    Then 14 is selected in the Font Size dropdown on About page editor
    When User clicks on Bold button in the editor toolbar on About Page
    Then Bold button is selected on About Page
    When User clicks on Italic button in the editor toolbar on About Page
    Then Italic button is selected on About Page
    When User clicks on Underline button in the editor toolbar on About Page
    Then Underline button is selected on About Page
    When User clicks on Strikethrough button in the editor toolbar on About Page
    Then Strikethrough button is selected on About Page