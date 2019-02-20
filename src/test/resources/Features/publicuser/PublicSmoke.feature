Feature: Public Smoke

@Smoke @PublicSmoke
Scenario: Public user goes to external links on Splash page and goes to Status history page
	Given User launches application1
	When User clicks Cengage Internal user button
    And User clicks on hamburger menu button
	Then Admin Menu should not be visible
	When User clicks Collapse all button
	Then System cards are not displayed
	When User clicks Expand all button
	Then System cards are displayed
	And Color for public system cards is white
	When User clicks Cengage icon
	Then Link navigates to https://www.cengage.com/
	When User clicks Need product support link
	Then Link navigates to https://cengageportal.secure.force.com/Support
	When User clicks Aplia system from the menu
	Then Public user should see 4 history bricks in the legend
	When User clicks on Specify date history view
	And User selects first day of the previous month
	Then Status history is displayed
	When User clicks on Last 30 days history view
	And Hover on 1 day brick from the last 30 days
	Then Day status history pop up should be displayed
	 