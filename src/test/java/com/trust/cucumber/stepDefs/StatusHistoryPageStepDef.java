package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.StatusHistoryPageSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.text.ParseException;
import java.util.List;

public class StatusHistoryPageStepDef {

	@Steps
    StatusHistoryPageSteps userOnStatusHistory;


	@Then("^Public user should see 4 history bricks in the legend$")
	public void publicUserStatusHistoryBricks() {
        userOnStatusHistory.shouldSeeNextBricks();
        userOnStatusHistory.shouldSeeNextBricks();
	}

	@When("^User clicks on (.*) history view$")
	public void clickHistoryViewButton(String buttonName){
		userOnStatusHistory.clickHistoryViewButton(buttonName);
	}

	@When("^User selects first day of the previous month$")
	public void specifyDate() {
        userOnStatusHistory.selectFirstDayOfThePreviousMonth();
	}

	@When("^Hover on (.*) day brick from the last 30 days$")
	public void hoverOnParticularDay(int dayIndex) {
        userOnStatusHistory.hoverOnParticularDay(dayIndex);
	}

	@Then("^Day status history pop up should be displayed$")
	public void dayStatusPopUpIsDisplayed() {
        userOnStatusHistory.dayStatusPopUpIsDisplayed();
	}

	@Then("^Status history is displayed for specified day$")
	public void specifiedDayStatusHistoryIsDisplayed() {
		userOnStatusHistory.specifiedDayStatusHistoryIsDisplayed();
	}

    @Then("^Status History page is opened$")
    public void statusHistoryPageIsOpened()  {
        userOnStatusHistory.isPageOpened();
    }

   @And("^Status history for (.*) system is displayed on the page$")
    public void statusHistoryFor$SystemAdminIsDisplayedOnThePage(String systemName)  {
        userOnStatusHistory.isSystemTextDisplayed(systemName);
    }
    @Then("^Status history is displayed$")
    public void statusHistoryIsDisplayed() {
        userOnStatusHistory.dayStatusHistoryIsDisplayed();
    }

    @When("^User clicks on drilldown brick$")
    public void userClicksOnDrilldownBrick()  {
        userOnStatusHistory.clickOnBrick();
    }

    @Then("^Drill down is opened$")
    public void drillDownIsOpened() {
        userOnStatusHistory.isDrilldownOpened();
    }

    @And("^User is able to see element$")
    public void userIsAbleToSeeElement(List<String> elements) {
        userOnStatusHistory.areElementsAvailable(elements);
    }

    @When("^User clicks (.*) button on the form$")
    public void userClicksOkButton(String button) {
        userOnStatusHistory.clickOnButton(button);
    }

    @When("^User selects previous day as Start Date range$")
    public void clickSelectStartDate() {
    	userOnStatusHistory.clickSelectStartDate();
    }


    @And("^User is able to see text description$")
    public void userIsAbleToSeeTextDescription()  {
        userOnStatusHistory.userIsAbleToSeeTextDescription();
    }

    @And("^User sees (\\d+) rows with bricks$")
    public void userSeesRowsWithBricks(int rows)  {
        userOnStatusHistory.areRowsvisible(rows);
    }

    @And("^User sees (\\d+) bricks on Status History Page$")
    public void userSeesBricksOnStatusHistoryPage(int bricks) {
        userOnStatusHistory.areBricksVisible(bricks);
    }

    @And("^User sees a public legend$")
    public void userSeesALegend()  {
        userOnStatusHistory.userSeesAPublicLegend();
    }

    @And("^Notification table on Status History page has following headers$")
    public void notificationTableHasFollowingHeaders(List<String> headers) {
        userOnStatusHistory.checkNotifHeaders(headers);
    }


    @And("^Notification table on Status History with (.*) message has value (.*) in (.*)$")
    public void checkNotifTableValues(String message, String value, String column){
        userOnStatusHistory.checkNotifTableValues(message, value, column);
    }

    @And("^User is able to see specify range tab text description$")
    public void userIsAbleToSeeSpecifyDateTabTextDescription()  {
        userOnStatusHistory.userIsAbleToSeeSpecifyDateTabTextDescription();
    }

    @Then("^User is able to see 30 days tab text description$")
    public void userIsAbleToSeeDaysTabTextDescription(){
        userOnStatusHistory.userIsAbleToSee30DaysTabTextDescription();
    }

    @And("^There are (\\d+) blocks are displayed$")
    public void thereAreBlocksAreDisplayed(int blocks) {
        userOnStatusHistory.thereAreBlocksAreDisplayed(blocks);
    }

    @And("^User clicks one of the 30-days view blocks with day (.*)$")
    public void userClicksOneOfTheDaysViewBlocksWithDay(String day) {
        userOnStatusHistory.userClicksOneOfTheDaysViewBlocksWithDay(day);
    }

    @Then("^(.*) tab is selected$")
    public void tabIsSelected(String tab)  {
        userOnStatusHistory.tabIsSelected(tab);
    }

    @Then ("^Specify previous date button is enabled")
    public void checkSpecifyPreviousDateButtonEnabled() {
        userOnStatusHistory.checkSpecifyPreviousDateButtonEnabled();
    }

    @When ("^User selects date in the past by clicking on Specify previous date button")
    public void clickOnSpecifyPreviousDateButton() {
        userOnStatusHistory.clickOnSpecifyPreviousDateButton();
    }

    @And("^User sees an admin legend$")
    public void userSeesAnAdminLegend() {
        userOnStatusHistory.isAdminLegendShown();
    }

    @When("^User navigates to Monitor link$")
    public void userNavigatesToMonitorLink() {
        userOnStatusHistory.userNavigatesToMonitorLink();
    }

    @And("^Raw Data table has following headers$")
    public void rawDataTableHasFollowingHeaders(List<String> headers) {
        userOnStatusHistory.checkHeaderForRawTable(headers);
    }

    @And("^Business Logic table has following headers$")
    public void businessLogicTableHasFollowingHeaders(List<String> headers) {
        userOnStatusHistory.checkBusinessLogicTableHeaders(headers);
    }

    @And("^Drill down Notification table has following headers$")
    public void drillDownNotificationTableHasFollowingHeaders(List<String> headers)  {
        userOnStatusHistory.checkNotifDrillDownTableHeaders(headers);
    }

    @When("^User expands Monitor table$")
    public void userExpandsMonitorTable() {
        userOnStatusHistory.expandMonitorTable();
    }

    @Then("^Monitor table has following headers$")
    public void monitorTableHasFollowingHeaders(List<String> headers) {
        userOnStatusHistory.checkMonitorTableHeders(headers);
    }

    @And("^Following values are present in the monitor table in (.*) column$")
    public void followingValuesArePresentInTheTable(String column, List<String> values) {
        userOnStatusHistory.checkValuesInSHTable(column, values);
    }

    @And("^Business Logic table has (.*) value in (.*) column$")
    public void BusinessLogicTableHasValueInColumn(String value, String column) {
        userOnStatusHistory.isValuePresentInColumnForRawDataTable(value, column);
    }

    @When("^User click drill down back button$")
    public void userClickDrillDownBackButton() {
        userOnStatusHistory.clickDrilldownBack();
    }

    @Then("^Drill down datetime changed to minus 5 mins$")
    public void drillDownDatetimeChangedToMinusMins() throws ParseException {
        userOnStatusHistory.checkDrillDownDateTime();
    }

    @When("^Admin click edit notification button on Drilldown modal form$")
    public void adminClickEditNotificationButtonOnDrilldownModalForm(){
        userOnStatusHistory.clickDrilldownEditNotif();
    }

	@When("^User sees and clicks Add monitors button$")
	public void userSeesAndClicksAddMonitorsButton() {
        userOnStatusHistory.verifyAndClickAddMonitorsButton();
	}


	@When("^User clicks on checkbox with \"([^\"]*)\" monitor$")
	public void userClicksOnCheckboxWithMonitor(String monitorTitle)  {
        userOnStatusHistory.clickOnMonitorCheckBox(monitorTitle);
	}

	@And("^chosen \"([^\"]*)\" with Service ID (\\d+) monitor is in the list$")
	public void chosenMonitorIsInTheList(String monitorTitle, String monitorID) {
        userOnStatusHistory.monitorIsInTheList(monitorTitle, monitorID);
	}

	@And("^(.*) tab is not visible$")
	public void andTabsAreNotVisible(String tabName){
        userOnStatusHistory.tabIsNotVisible(tabName);
	}


	@And("^checkbox for ([^\"]*) monitor is selected and not editable$")
	public void checkboxForMonitorIsSelectedAndNotEditable(String monitorTitle) {
        userOnStatusHistory.checkBoxForMonitorIsSelectedAndNotEditable(monitorTitle);
	}

	@Then("^there are (\\d+) sections in the status bar$")
	public void thereAreSectionsInTheStatusBar(int amountSections) {
        userOnStatusHistory.amountOfSectionsInTheStatusBar(amountSections);
	}

	@And("^Choose date field is displayed$")
	public void chooseDateFieldIsDisplayed(){
        userOnStatusHistory.verifyChooseDateFieldIsDisplayed();
	}

	@And("^Status history for monitor (.*) is displayed on the page$")
	public void statusHistoryForMonitorIsDisplayedOnThePage(String monitorTitle){
        userOnStatusHistory.verifyStatusHistoryForSingleMonitorIsDisplayed(monitorTitle);
	}

	@And("^User verifies and clicks ([^\"]*) button in the window$")
	public void userVerifiesResetButtonIsInTheWindow(String button){
        userOnStatusHistory.verifyingResetClearButton(button);
	}

	@Then("^checkbox for \"([^\"]*)\" monitor is not selected$")
	public void checkboxForMonitorIsDisabled(String monitorTitle) {
        userOnStatusHistory.checkBoxForMonitorIsNotSelected(monitorTitle);
	}

	@Then("^no active checkbox is in the list$")
	public void noActiveCheckboxIsInTheList() {
        userOnStatusHistory.verifyNoSelectedCheckBox();
	}

    @And("^Public User doesnt see Add Monitors button$")
    public void publicUserDoesntSeeAddMonitorsButton()  {
        userOnStatusHistory.isNotVisibleAddMonitors();
    }

    @When("^User clicks on (\\d+) link on Multiple Monitors view$")
    public void userClicksOnLinkOnMultipleMonitorsView(String link) {
        userOnStatusHistory.userClicksOnLinkOnMultipleMonitorsView(link);
    }


    @Then("^Multiple Monitors view is opened$")
    public void multipleMonitorsViewIsOpened() {
        userOnStatusHistory.checkIfMultipleMonitorsViewIsOpened();
    }

    @Then ("^Selected day is displayed in the specify date field on Status History$")
    public void checkSelectedDayIsDisplayedInTheSpecifyDateField() {
        userOnStatusHistory.checkSelectedDayIsDisplayedInTheSpecifyDateField();
    }
}
