package com.trust.cucumber.stepDefs;

import net.thucydides.core.annotations.Steps;

import com.trust.cucumber.steps.PerformancePageSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PerformancePageStepDef {
	
	@Steps
	PerformancePageSteps perf;
	
	
	@Then("^Performance page is displayed$")
	public void verifyPerformancePage() {
		perf.verifyPerformancePage();
	}
	
	@Then("^Current date is displayed by default$")
	public void verifyDefaultPerformanceDateIsCurrentDate() {
		perf.verifyDefaultPerformanceDateIsCurrentDate();
	}
	
	@When("^User clicks Performance button$")
	public void clickPerformanceButton() {
		perf.clickPerformanceButton();
	}
	
	@When("^User clicks Status History button$")
	public void clickStatusHistoryButton() {
		perf.clickStatusHistoryButton();
	}
	
	@Then("^Last 24h view is displayed")
	public void verify24HViewIsDispalyed() {
		perf.verify24HViewIsDispalyed();
	}

	@Then("^Specified day is displayed for the same date$")
	public void compareSpecifiedDayWithOtherPage() {
		perf.compareSpecifiedDayWithOtherPage(); 	
	}
	
	@Then("^Selected start day for range is displayed$")
	public void compareSpecifiedStartDayWithOtherPage() {
		perf.compareSpecifiedStartDayWithOtherPage(); 	
	}
	
	@Then("^Performance history for system (.*) and monitor (.*) text is displayed$")
	public void verifyPerformanceHistoryForText(String system, String monitor)  {
		perf.verifyPerformanceHistoryForText(system, monitor);
	}

	@Then ("^Performance and Status History buttons are displayed$")
	public void checkPerformanceAndStatusHistoryButtonsAreDisplayed () {
		perf.checkPerformanceAndStatusHistoryButtonsAreDisplayed();
	}

    @Then ("^The text description contains (.*) institution name and info that times are in UTC$")
    public void checkTextDescriptionContainsInstitutionNameAndInfoTimesInUTC (String institutionName) {
    	perf.checkTextDescriptionContainsInstitutionNameAndInfoTimesInUTC(institutionName);
    }

    @Then ("^Specify next date button is disabled$")
    public void checkSpecifyNextDateButtonDisabled() {
    	perf.checkSpecifyNextDateButtonDisabled();
    }

    @Then ("^Specify next date button is enabled$")
    public void checkSpecifyNextDateButtonEnabled() {
    	perf.checkSpecifyNextDateButtonEnabled();
    }

    @When ("^User selects date in the past using date picker$")
    public void setPreviousDateByDatePicker() {
    	perf.setPreviousDateByDatePicker();
    }

    @Then ("^Selected day is displayed in the specify date field on perf page$")
    public void checkSelectedDayIsDisplayedInTheSpecifyDateField() {
    	perf.checkSelectedDayIsDisplayedInTheSpecifyDateField();
    }

    @Then ("^Performance chart for selected date is displayed$")
    public void checkPerformanceChartForSelectedDateIsDisplayed() {
    	perf.checkPerformanceChartForSelectedDateIsDisplayed();
    }

    @When ("^User clicks on Today button$")
    public void clickOnSetTodayDateButton() {
    	perf.clickOnSetTodayDateButton();
    }

    @Then ("^Performance chart for current date is displayed$")
    public void checkPerformanceChartForCurrentDateIsDisplayed() {
    	perf.checkPerformanceChartForCurrentDateIsDisplayed();
    }

}
