package com.trust.cucumber.stepDefs;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import com.trust.cucumber.steps.SystemsPageSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SystemPageStepDef {
	
	@Steps
	SystemsPageSteps system;
		
	@When("^User clicks Add group button$")
	public void clickAddGroupButton() {
		system.clickAddGroupButton();
	}
	
	@Then("^Group form is displayed$")
	public void verifyGroupFormIsDisplayed() {
		system.verifyGroupFormIsDisplayed();
	}
	
	@When("^User populates form with (.*) name$")
	public void populateGroupForm(String groupName) {
		system.populateGroupForm(groupName);
	}
	
	@Then("^Group (.*) is displayed on the page$")
	public void verifyGroupIsDisplayed(String groupName) {
		system.verifyGroupIsDisplayed(groupName);
	}
	
	@When("^User clicks Add System for (.*) group$")
	public void clickAddSystemForSpecificGroup(String groupName) {
		system.clickAddSystemForSpecificGroup(groupName);
	}
	
	@When("^User deletes (.*) group$")
	public void deleteSpecificGroup(String groupName) {
		system.clickDeleteIconForSpecificGroup(groupName);
		system.clickProceedModalButton();
	}
	
	@Then("^Create system form is displayed$")
	public void verifyCreateSystemFormIsDisplayed() {
		system.verifyCreateSystemFormIsDisplayed();
	}
	
	@When("^User populates system form with (.*) name and (.*) access level$")
	public void populateNewSystemForm(String systemName, String accessLevel) {
		system.populateNewSystemForm(systemName, accessLevel);
		system.clickOkModalButton();
	}
	
	@When("^User updates system form with (.*) name and (.*) access level$")
	public void updateSystemForm(String systemName, String accessLevel) {
		system.clickEnabledSystemCheckbox();
		system.clearSystemNameFied();
		system.populateNewSystemForm(systemName, accessLevel);
		system.populateDescriptionSystemField();
		system.clickOkModalButton();
	}
	
	@Then("^System (.*) is displayed on the page$")
	public void verifySystemIsDisplayed(String systemName) {
		system.verifySystemIsDisplayed(systemName);
	}
	
	@When("^User clicks Enabled icon for (.*) system$")
	public void clickEnabledIconForSpecificSystem(String systemName) {
		system.clickEnabledIconForSpecificSystem(systemName);
	}
	
	@When("^User clicks Add Monitor for (.*) system$")
	public void clickAddMonitorForSpecificSystem(String systemName) {
		system.clickAddMonitorForSpecificSystem(systemName);
	}
	
	@When("^User clicks update icon for (.*) system$")
	public void clickUpdateIconForSpecificSystem(String systemName) {
		system.clickUpdateIconForSpecificSystem(systemName);
	}
	
	@When("^User deletes (.*) system$")
	public void deleteSpecificSystem(String systemName) {
		system.clickDeleteIconForSpecificSystem(systemName);
		system.clickProceedModalButton();
	}
	
	@Then("^Create monitor form is displayed$")
	public void verifyCreateMonitorFormIsDisplayed() {
		system.verifyCreateMonitorFormIsDisplayed();
	}
	
	@When("^User populates monitor form$")
	public void populateNewMonitorForm(Map<String, String> monitor) {
		system.populateNewMonitorForm(monitor);
		system.clickOkModalButton();
	}
	
	@Then("^Monitor (.*) is displayed on the page$")
	public void verifyMonitorIsDisplayed(String monitorName) {
		system.verifyMonitorIsDisplayed(monitorName);
	}
	
	@When("^User updates monitor form$")
	public void updateMonitorForm(Map<String, String> monitor) {
		system.clickEnabledMonitorCheckbox();
		system.clearMonitorNameAndExternalID();
		system.populateNewMonitorForm(monitor);
		system.populateMonitorDescription();
		system.clickOkModalButton();
	}
	
	@When("^User searches for (.*) entries$")
	public void searchForEnries(String searchString) {
		system.searchForEnries(searchString);
	}
	
	@Then("^Only entries with (.*) are displayed$")
	public void verifySearchResults(String searchString) {
		system.verifySearchResults(searchString);
	}
	
	@When("^User clears search field$")
	public void clearSearchField() {
		system.clearSearchField();
	}
		
	@Then("^Edit system form is displayed$")
	public void verifyEditSystemFormIsDisplayed() {
		system.verifyEditSystemFormIsDisplayed();
	}
	
	@Then("^Next access level options are displayed$")
	public void checkAccessLevelOptions(List<String> arg) {
		system.checkAccessLevelOptions(arg);
	}
	
	@When("^User clicks Create Monitor button$")
	public void clickCreateMonitorButton() {
		system.clickCreateMonitorButton();
	}
	
	@Then("^(\\d+) monitors are displayed for (.*) system$")
	public void verifyMonitorsAmountForSystem(int expectedAmount, String systemName) {
		system.verifyMonitorsAmountForSystem(expectedAmount, systemName);
	}
	
	@When("^User populates aggregated monitor form$")
	public void populateAggregatedMonitorForm() {
		system.populateMonitorName("Aggregated");
		system.clickAggregatedIcon();
		system.selectAllSubMonitorsForAggregation();
		system.clickOkModalButton();
	}
	
	@When("^User clicks Expand All icon$")
	public void clickExpandAllButton() {
		system.clickExpandAllButton();
	}
	
	@Then("^Group sections are collapsed$")
	public void verifyGroupSectionsAreCollapsed() {
		system.verifyGroupSectionsAreCollapsed();
	}
	
	@When("^User clicks Show/Hide headers icon$")
	public void clickShowHeadersIcon() {
		system.clickShowHeadersIcon();
	}
	
	@Then("^Next system headers are displayed$")
	public void checkSystemHeadersFromTable(List<String> arg) {
		system.checkSystemHeadersFromTable(arg);
	}
	
	@Then("^Next monitor headers are displayed$")
	public void checkMonitorHeadersFromTable(List<String> arg) {
		system.checkMonitorHeadersFromTable(arg);
	}
	
	@When("^User clicks Expand/Collapse icon for (.*) monitor$")
	public void clickExpandIconForSpecificMonitor(String monitorName) {
		system.clickExpandIconForSpecificMonitor(monitorName);
	}
	
	@When("^User clicks Enabled icon for (.*) monitor$")
	public void clickEnabledIconForSpecificMonitor(String monitorName) {
		system.clickEnabledIconForSpecificMonitor(monitorName);
	}
		
	@When("^User clicks Update icon for (.*) monitor$")
	public void clickUpdateIconForSpecificMonitor(String monitorName) {
		system.clickUpdateIconForSpecificMonitor(monitorName);
	}
			
	@Then("^Sub-monitors are displayed for aggregated monitor$")
	public void verifySubMonitorsAreDisplayed() {
		system.verifySubMonitorsAreDisplayed();
	}
	
	@Then("^Sub-monitors are not displayed for aggregated monitor$")
	public void verifySubMonitorsAreNotDisplayed() {
		system.verifySubMonitorsAreNotDisplayed();
	}
	
	@When("^User selects (.*) region for search$")
	public void selectRegionForSearch(String region) {
		system.selectRegionForSearch(region);
	}
	
	@When("^User clicks Show Regions button$")
	public void clickShowRegionsButton() {
		system.clickShowRegionsButton();
	}
	
	@When("^Deselect (.*) region for monitor$")
	public void selectRegionForSpecificMonitor(String region) {
		system.selectRegionForMonitor(region);
		system.clickOkModalButton();
	}
	
	@Then("^System (.*) is displayed as enabled$")
	public void checkSystemIsEnabled(String systemName) {
		system.checkSystemIsEnabled(systemName);
	}
	
	@Then("^System (.*) is displayed as disabled$")
	public void checkSystemIsDisabled(String systemName) {
		system.checkSystemIsDisabled(systemName);
	}
	
	@When("^User clears Select Region field$")
	public void clearRegionField() {
		system.clearRegionField();
	}
	
	@When("^User deletes (.*) monitor$")
	public void deleteSpecificMonitor(String monitorName) {
		system.clickDeleteIconForSpecificMonitor(monitorName);
		system.clickProceedModalButton();
	}
	
	@When("^User clicks Previous icon$")
	public void clickPreviousIcon() {
		system.clickPreviousIcon();
	}
	
	@Then("^Number of editing system is decreased$")
	public void checkEditingNumberIsDecreased() {
		system.checkEditingNumberIsDecreased();
	}
	
	@When("^User clicks Next icon$")
	public void clickNextIcon() {
		system.clickNextIcon();
	}
	
	@Then("^Number of editing system is increased$")
	public void checkEditingNumberIsIncreased() {
		system.checkEditingNumberIsIncreased();
	}
	
	@Then("^Delete icon is disabled for (.*) system$")
	public void checkDeleteIconIsDisabledForSystem(String systemName) {
		system.checkDeleteIconIsDisabledForSystem(systemName);
	}
	
	@When("^User hovers on delete icon for (.*) system$")
	public void hoverOnDeleteIconForSystem(String systemName) {
		system.hoverOnDeleteIconForSystem(systemName);
	}
	
	@Then("^Tooltip for delete icon is displayed$")
	public void verifyTooltipIsDisplayed() {
		system.verifyTooltipIsDisplayed();
	}
	
	@Then("^Access level field is disabled$")
	public void checkAccessLevelFieldIsDisabled() {
		system.checkAccessLevelFieldIsDisabled();
	}
	
	@When("^User hovers on access level field$")
	public void hoverOnAccessLevelField() {
		system.hoverOnAccessLevelField();
	}
	
	@Then("^Tooltip about non-editing access level is displayed$")
	public void verifyAccessLevelTooltipIsDisplayed() {
		system.verifyAccessLevelTooltipIsDisplayed();
		system.clickCloseModalButton();
	}
	
	@When("^User updates name for (.*) group to (.*)$")
	public void deleteSpecificMonitor(String groupName, String updatedName) {
		system.clickUpdateIconForSpecificGroup(groupName);
		system.clearGroupNameField();
		system.populateGroupForm(updatedName);
	}
	
	@Then("^Toaster about (.*) action is displayed$")
	public void commonToasterVerification(String action) {
		system.checkToasterIsDisplayed(action);
		system.clickCloseToasterButton();
	}
	
	@When("^User clicks Expand button depending on sections displaying$")
	public void checkingExpandAllStatus() {
		system.checkingExpandAllStatus();
	}

	@Then("^Add System button isn't displayed$")
	public void verifyAddSystemIconIsNotDisplayed() {
		system.verifyAddSystemIconIsNotDisplayed();
	}

	@Then("^Add System button is displayed$")
	public void verifyAddSystemIconIsDisplayed() {
		system.verifyAddSystemIconIsDisplayed();
	}

	@Then("^Edit System button isn't displayed$")
	public void verifyEditSystemIconIsNotDisplayed() {
		system.verifyEditSystemIconIsNotDisplayed();
	}

	@Then("^Edit System button is displayed$")
	public void verifyEditSystemIconIsDisplayed() {
		system.verifyEditSystemIconIsDisplayed();
	}

	@Then("^Delete System button isn't displayed$")
	public void verifyDeleteSystemIconIsNotDisplayed() {
		system.verifyDeleteSystemIconIsNotDisplayed();
	}

	@Then("^Delete System button is displayed$")
	public void verifyDeleteSystemIconIsDisplayed() {
		system.verifyDeleteSystemIconIsDisplayed();
	}

    @Then("^Edit monitor form is displayed$")
    public void editMonitorFormIsDisplayed()  {
	    system.editMonitorFormIsDisplayed();
    }

	@And("^User clicks on Add Logo button and selects (.*) image$")
	public void selectLogoForSystem(String fileName) {
		system.selectLogoForSystem(fileName);
	}
}
