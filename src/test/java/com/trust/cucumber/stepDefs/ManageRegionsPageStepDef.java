package com.trust.cucumber.stepDefs;
import com.trust.cucumber.steps.ManageRegionsPageSteps;
import com.trust.cucumber.pages.NotificationPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class ManageRegionsPageStepDef {
    @Steps
    private ManageRegionsPageSteps manageRegionsPageSteps;
    private NotificationPage notificationPage;

    @When("^User clicks on Region List button$")
    public void clickOnRegionListButton() {
        manageRegionsPageSteps.clickOnRegionListButton();
    }

    @Then("^List of regions page is displayed$")
    public void verifyListOfRegionsFormIsOpened() {
        manageRegionsPageSteps.verifyListOfRegionsFormIsOpened();
    }

    @Then("^List of regions table contains next headers$")
    public void displayListOfRegionsHeaders(List<String> arg) {
        manageRegionsPageSteps.checkTableHeaders(arg);
    }

    @Then("^The table is sorted by Name\\* column in ascending order$")
    public void verifyListOfRegionsTableIsSortedByNameColumnAscending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnAscending(2);}

    @Then("^The table is sorted by Name\\* column in descending order$")
    public void verifyListOfRegionsTableIsSortedByNameColumnDescending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnDescending(2);}

    @Then("^The table is sorted by OID\\* column in ascending order$")
    public void verifyListOfRegionsTableIsSortedByOIDColumnAscending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnAscending(3);}

    @Then("^The table is sorted by OID\\* column in descending order$")
    public void verifyListOfRegionsTableIsSortedByOIDColumnDescending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnDescending(3);}

    @Then("^The table is sorted by Description column in ascending order$")
    public void verifyListOfRegionsTableIsSortedByDescriptionColumnAscending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnAscending(4);}

    @Then("^The table is sorted by Description column in descending order$")
    public void verifyListOfRegionsTableIsSortedByDescriptionColumnDescending() {manageRegionsPageSteps.verifyListOfRegionsTableIsSortedByStringColumnDescending(4);}

    @Then("^All regions are selected for new monitor$")
    public void verifyAllRegionCheckboxesIsSelectedForMonitor() {
        manageRegionsPageSteps.verifyAllRegionCheckboxesIsSelectedForMonitor();
    }

    @Then("^(.*) region is disabled for all systems$")
    public void verifyRegionIsDisabledForSystem(String region) {
        manageRegionsPageSteps.verifyRegionIsDisabledForSystem(region);
    }

    @When("^User clicks on delete button for (.*) region with OID (.*)$")
    public void clickOnDeleteButtonForRegionByNameAndOID(String name, String oid) {
        manageRegionsPageSteps.clickOnDeleteButtonForRegionByNameAndOID(name,oid);
    }

    @Then("^Regions table is (.*) displayed$")
    public void verifyRegionsTableIsDisplayed(String state) {
        manageRegionsPageSteps.verifyRegionsTableIsDisplayed(state);
    }

    @Then("^(.*) button is (.*) displayed on Manage Regions page$")
    public void verifyButtonIsDisplayed(String button, String state) {
        manageRegionsPageSteps.verifyButtonIsDisplayed(button, state);
    }

    @Then("^(.*) column is (.*) displayed on Manage Regions page$")
    public void verifyColumnIsDisplayed(String header, String state) {
        manageRegionsPageSteps.verifyColumnIsDisplayed(header, state);
    }

    @When("^User clicks on (.*) button for Regions table$")
    public void userClicksOnButtonManageRegions(String button) {
        manageRegionsPageSteps.clickOnButton(button);
    }

    @When("^User clicks on (.*) button on List of regions page$")
    public void userClicksOnButtonListOfRegions(String button) {
        manageRegionsPageSteps.clickOnButton(button);
    }

    @When("^Name of aggregated monitor (.*) is emphasized$")
    public void verifyAggregatedMonitorNameStale(String monitor) {
        manageRegionsPageSteps.verifyAggregatedMonitorNameStyle(monitor);
    }

    @Then("^Sub-monitors (.*) and (.*) are displayed on hover in a tooltip for (.*)$")
    public void verifyTooltipTextForAggregatedMonitor(String subMonitor1, String subMonitor2, String aggrMonitor) {
        manageRegionsPageSteps.verifyTooltipTextForAggregatedMonitor(subMonitor1, subMonitor2, aggrMonitor);
    }

    @And("^User deselects AFR column in the \"Select displayed columns\" pop-up$")
    public void deselectColumnInSelectDisplayedColumnsPopUpByIndex() {notificationPage.deselectColumnInSelectDisplayedColumnsPopUpByIndex(2);}

    @When("^User clicks on Aggregate switch$")
    public void clickOnAggregateSwitch() {
        manageRegionsPageSteps.clickOnAggregateSwitch();
    }

    @When("^User expands (.*) system$")
    public void expandSystem(String system) {
        manageRegionsPageSteps.expandSystem(system);
    }

    @Then("^(.*) aggregated monitor is displayed for the system$")
    public void verifyAggrMonitorIsDisplayed(String monitor) {
        manageRegionsPageSteps.verifyAggrMonitorIsDisplayed(monitor);
    }

    @Then("^(.*) monitor is displayed for system$")
    public void verifyMonitorIsDisplayed(String monitor) {
        manageRegionsPageSteps.verifyMonitorIsDisplayed(monitor);
    }

    @When("^All systems are expanded$")
    public void verifyAllSystemsExpanded() {
        manageRegionsPageSteps.verifyAllSystemsExpanded();
    }

    @When("^All systems are collapsed")
    public void verifyAllSystemsCollapsed() {
        manageRegionsPageSteps.verifyAllSystemsCollapsed();
    }

    @Then("^Delete button for United States region with OID USA is displayed as disabled")
    public void verifyDeleteButtonIsDisabledForUSA() {
        manageRegionsPageSteps.verifyDeleteButtonIsDisabledForUSA();
    }

    @When("^User verifies that there is no regions with Name (.*) and with OID (.*)")
    public void verifyNoRegionByNameAndOID(String name, String oid) {
        manageRegionsPageSteps.verifyNoRegionByNameAndOID(name,oid);
    }

    @Then("^Create region form is displayed")
    public void verifyCreateRegionFormIsDisplayed() {
        manageRegionsPageSteps.verifyCreateRegionFormIsDisplayed();
    }

    @When ("^User populates fields in Create region form$")
    public void populateNewRegionFields(Map<String, String> arg) {
        manageRegionsPageSteps.populateNewRegionFields(arg);
    }

    @When("^User clicks on Enabled checkbox in Create region form$")
    public void clickOnEnabledCheckbox() {
        manageRegionsPageSteps.clickOnEnabledCheckbox();
    }

    @Then("^(.*) region with OID (.*) and (.*) description is (.*) displayed on List of regions page$")
    public void checkRegionInListOfRegionsTable(String name, String oid, String description, String state) {
        manageRegionsPageSteps.checkRegionInListOfRegionsTable(name, oid, description, state);
    }

    @Then("^Enabled checkbox is selected for (.*) region$")
    public void verifyEnabledCheckboxIsSelectedForRegion(String region) {
        manageRegionsPageSteps.verifyEnabledCheckboxIsSelectedForRegion(region);
    }

    @Then("^Enabled checkbox is not selected for (.*) region$")
    public void verifyEnabledCheckboxIsNotSelectedForRegion(String region) {
        manageRegionsPageSteps.verifyEnabledCheckboxIsNotSelectedForRegion(region);
    }

    @Then("^(.*) region is selected for all existing monitors$")
    public void verifyRegionIsSelectedForMonitors(String region) {
        manageRegionsPageSteps.verifyRegionIsSelectedForAllMonitors(region);
    }

    @When ("^User updates fields for the region (.*) region with OID (.*) and (.*) description$")
    public void updateRegionFields(String name, String oid, String description,Map<String, String> arg) {
        manageRegionsPageSteps.updateRegionFields(name,oid,description,arg);
    }

    @When("^User clicks on Enabled checkbox for (.*) region$")
    public void clickOnEnabledCheckboxForRegion(String region) {
        manageRegionsPageSteps.clickOnEnabledCheckboxForRegion(region);
    }

    @When("^User clicks on (.*) region for (.*) monitor$")
    public void clickOnRegionCheckboxForMonitor(String region, String monitor) {
        manageRegionsPageSteps.clickOnRegionCheckboxForMonitor(region,monitor);
    }

    @When("^User click on (.*) region for (.*) aggregated monitor$")
    public void clickOnRegionCheckboxForAggrMonitor(String region, String monitor) {
        manageRegionsPageSteps.clickOnRegionCheckboxForAggrMonitor(region,monitor);
    }

    @Then("^(.*) region is selected for (.*) monitor$")
    public void verifyRegionIsSelectedForMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPageSteps.verifyRegionIsSelectedForMonitorInRegionsTable(region,monitor);
    }

    @Then("^Region (.*) is selected for (.*) aggregated monitor$")
    public void verifyRegionIsSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPageSteps.verifyRegionIsSelectedForAggrMonitorInRegionsTable(region,monitor);
    }

    @Then("^(.*) region is not selected for (.*) monitor$")
    public void verifyRegionIsNotSelectedForMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPageSteps.verifyRegionIsNotSelectedForMonitorInRegionsTable(region,monitor);
    }

    @Then("^Region (.*) is not selected for (.*) aggregated monitor$")
    public void verifyRegionIsNotSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPageSteps.verifyRegionIsNotSelectedForAggrMonitorInRegionsTable(region,monitor);
    }

    @Then("^(.*) region is selected for (.*) system$")
    public void verifyRegionIsSelectedForSystemInRegionsTable(String region, String system) {
        manageRegionsPageSteps.verifyRegionIsSelectedForSystemInRegionsTable(region,system);
    }

    @Then("^(.*) region is not selected for (.*) system$")
    public void verifyRegionIsNotSelectedForSystemInRegionsTable(String region, String system) {
        manageRegionsPageSteps.verifyRegionIsNotSelectedForSystemInRegionsTable(region,system);
    }

    @When("^User expands Regions table$")
    public void userExpandsRegionsTable() {
        manageRegionsPageSteps.userExpandsRegionsTable();
    }
}
