package com.trust.cucumber.steps;

import com.trust.cucumber.pages.ManageRegionsPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ManageRegionsPageSteps extends PageObject {
    private ManageRegionsPage manageRegionsPage;

    @Step
    public void clickOnRegionListButton() {
        manageRegionsPage.clickOnRegionListButton();
    }

    @Step
    public void verifyListOfRegionsFormIsOpened() {
        manageRegionsPage.verifyListOfRegionsFormIsOpened();
    }

    @Step
    public void checkTableHeaders(List<String> expectedHeaders) {
        List<String> actualHeaders = manageRegionsPage.getHeadersFromTable();
        expectedHeaders.forEach(name -> Assert.assertTrue(actualHeaders.contains(name)));
    }

    @Step
    public void verifyListOfRegionsTableIsSortedByStringColumnAscending(int columnNumber) {
        manageRegionsPage.verifyListOfRegionsTableIsSortedByStringColumnAscending(columnNumber);
    }

    @Step
    public void verifyListOfRegionsTableIsSortedByStringColumnDescending(int columnNumber) {
        manageRegionsPage.verifyListOfRegionsTableIsSortedByStringColumnDescending(columnNumber);
    }

    @Step
    public void verifyAllRegionCheckboxesIsSelectedForMonitor() {
        manageRegionsPage.verifyAllRegionCheckboxesIsSelectedForMonitor();
    }

    @Step
    public void verifyRegionIsDisabledForSystem(String region) {
        manageRegionsPage.verifyRegionIsDisabledForSystem(region);
    }

    @Step
    public void verifyRegionIsSelectedForAllMonitors(String region) {
        manageRegionsPage.verifyRegionIsSelectedForAllMonitors(region);
    }

    @Step
    public void verifyRegionsTableIsDisplayed(String state) {
        manageRegionsPage.verifyRegionsTableIsDisplayed(state);
    }

    @Step
    public void verifyButtonIsDisplayed(String button, String state) {
        manageRegionsPage.verifyButtonIsDisplayed(button, state);
    }

    @Step
    public void verifyColumnIsDisplayed(String header, String state) {
        manageRegionsPage.verifyColumnIsDisplayed(header, state);
    }

    @Step
    public void clickOnButton(String button) {
        manageRegionsPage.clickOnButton(button);
    }

    @Step
    public void verifyAggregatedMonitorNameStyle(String monitor) {
        manageRegionsPage.verifyAggregatedMonitorNameStyle(monitor);
    }

    @Step
    public void verifyTooltipTextForAggregatedMonitor(String subMonitor1, String subMonitor2, String aggrMonitor) {
        manageRegionsPage.verifyTooltipTextForAggregatedMonitor(subMonitor1, subMonitor2, aggrMonitor);
    }

    @Step
    public void clickOnAggregateSwitch() {
        manageRegionsPage.clickOnAggregateSwitch();
    }

    @Step
    public void expandSystem(String system$) {
        manageRegionsPage.expandSystem(system$);
    }

    @Step
    public void verifyAggrMonitorIsDisplayed(String monitor) {
        manageRegionsPage.verifyAggrMonitorIsDisplayed(monitor);
    }

    @Step
    public void verifyMonitorIsDisplayed(String monitor) {
        manageRegionsPage.verifyMonitorIsDisplayed(monitor);
    }

    @Step
    public void verifyAllSystemsExpanded() {
        manageRegionsPage.verifyAllSystemsExpanded();
    }

    @Step
    public void verifyAllSystemsCollapsed() {
        manageRegionsPage.verifyAllSystemsCollapsed();
    }

    @Step
    public void verifyDeleteButtonIsDisabledForUSA() {
        manageRegionsPage.verifyDeleteButtonIsDisabledForUSA();
    }

    @Step
    public void clickOnDeleteButtonForRegionByNameAndOID(String name, String oid) {
        manageRegionsPage.clickOnDeleteButtonForRegionByNameAndOID(name,oid);
    }

    @Step
    public void verifyNoRegionByNameAndOID(String name, String oid) {
        manageRegionsPage.verifyNoRegionByNameAndOID(name,oid);
    }

    @Step
    public void verifyCreateRegionFormIsDisplayed() {
        manageRegionsPage.verifyCreateRegionFormIsDisplayed();
    }

    @Step
    public void populateNewRegionFields(Map<String, String> fields) {
        manageRegionsPage.populateNewRegionFields(fields);
    }

    @Step
    public void clickOnEnabledCheckbox() {
        manageRegionsPage.clickOnEnabledCheckbox();
    }

    @Step
    public void checkRegionInListOfRegionsTable(String name, String oid, String description, String state) {
        manageRegionsPage.checkRegionInListOfRegionsTable(name, oid, description, state);
    }

    @Step
    public void verifyEnabledCheckboxIsSelectedForRegion(String region) {
        manageRegionsPage.verifyEnabledCheckboxIsSelectedForRegion(region);
    }

    @Step
    public void verifyEnabledCheckboxIsNotSelectedForRegion(String region) {
        manageRegionsPage.verifyEnabledCheckboxIsNotSelectedForRegion(region);
    }

    @Step
    public void updateRegionFields(String name, String oid, String description,Map<String, String> arg) {
        manageRegionsPage.updateRegionFields(name,oid,description,arg);
    }

    @Step
    public void clickOnEnabledCheckboxForRegion(String region) {
        manageRegionsPage.clickOnEnabledCheckboxForRegion(region);
    }

    @Step
    public void clickOnRegionCheckboxForMonitor(String region, String monitor) {
        manageRegionsPage.clickOnRegionCheckboxForMonitor(region,monitor);
    }

    @Step
    public void clickOnRegionCheckboxForAggrMonitor(String region, String monitor) {
        manageRegionsPage.clickOnRegionCheckboxForAggrMonitor(region,monitor);
    }

    @Step
    public void verifyRegionIsSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPage.verifyRegionIsSelectedForAggrMonitorInRegionsTable(region,monitor);
    }

    @Step
    public void verifyRegionIsSelectedForMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPage.verifyRegionIsSelectedForMonitorInRegionsTable(region,monitor);
    }

    @Step
    public void verifyRegionIsNotSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPage.verifyRegionIsNotSelectedForAggrMonitorInRegionsTable(region,monitor);
    }

    @Step
    public void verifyRegionIsNotSelectedForMonitorInRegionsTable(String region, String monitor) {
        manageRegionsPage.verifyRegionIsNotSelectedForMonitorInRegionsTable(region,monitor);
    }

    @Step
    public void verifyRegionIsSelectedForSystemInRegionsTable(String region, String system) {
        manageRegionsPage.verifyRegionIsSelectedForSystemInRegionsTable(region,system);
    }

    @Step
    public void verifyRegionIsNotSelectedForSystemInRegionsTable(String region, String system) {
        manageRegionsPage.verifyRegionIsNotSelectedForSystemInRegionsTable(region,system);
    }

    @Step
    public void userExpandsRegionsTable() {
        manageRegionsPage.userExpandsRegionsTable();
    }
}
