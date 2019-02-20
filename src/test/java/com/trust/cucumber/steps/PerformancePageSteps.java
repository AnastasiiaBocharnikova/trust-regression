package com.trust.cucumber.steps;

import com.trust.cucumber.util.Log;
import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import com.trust.cucumber.pages.PerformancePage;
import com.trust.cucumber.pages.StatusHistoryPage;

import java.util.Calendar;
import java.util.Date;

public class PerformancePageSteps {
	
	PerformancePage performancePage;
	StatusHistoryPage statusHistoryPage;
	
	@Step
	public void verifyPerformancePage() {
		performancePage.performancePageIsDisplayed();	
	}
	
	@Step
	public void verifyDefaultPerformanceDateIsCurrentDate() {
		performancePage.verifyDefaultPerformanceDateIsCurrentDate();		
	}
	
	@Step
	public void clickStatusHistoryButton() {
		performancePage.clickStatusHistoryButton();
	}
	
	@Step
	public void clickPerformanceButton() {
		performancePage.clickPerformanceButton();
	}
	
	@Step
	public void verify24HViewIsDispalyed() {
		performancePage.verify24HViewIsDispalyed();
	}

	@Step
	public void compareSpecifiedDayWithOtherPage() {
		String actualSelectedDate = statusHistoryPage.getSelectedDate();
		Assert.assertEquals(actualSelectedDate,Serenity.sessionVariableCalled("selectedDate"));
	}
	
	@Step
	public void compareSpecifiedStartDayWithOtherPage() {
		String actualSelectedDate = statusHistoryPage.getSelectedDate();
		Assert.assertEquals(actualSelectedDate,Serenity.sessionVariableCalled("selectedStartDate"));		
	}
	
    @Step
    public void verifyPerformanceHistoryForText(String system, String monitor) {
    	performancePage.verifyPerformanceHistoryForText(system, monitor);
    }

    @Step
    public void checkPerformanceAndStatusHistoryButtonsAreDisplayed() {
    	performancePage.checkStatusHistoryButtonIsDisplayed();
    	performancePage.checkPerformanceButtonIsDisplayed();
    }

    @Step
    public void checkTextDescriptionContainsInstitutionNameAndInfoTimesInUTC(String institutionName) {
    	performancePage.checkTextDescriptionContainsInstitutionNameAndInfoTimesInUTC(institutionName);
    }

    @Step
    public void checkSpecifyNextDateButtonDisabled() {
    	performancePage.checkSpecifyNextDateButtonDisabled();
    }

    @Step
    public void checkSpecifyNextDateButtonEnabled() {
    	performancePage.checkSpecifyNextDateButtonEnabled();
    }

    @Step
    public void setPreviousDateByDatePicker() {
    	performancePage.setPreviousDateByDatePicker();
    }

    @Step
    public void checkSelectedDayIsDisplayedInTheSpecifyDateField() {
    	performancePage.checkSelectedDayIsDisplayedInTheSpecifyDateField();
    }

    @Step
    public void checkPerformanceChartForSelectedDateIsDisplayed() {
    	performancePage.checkPerformanceChartForSelectedDateIsDisplayed();
    }

    @Step
    public void clickOnSetTodayDateButton() {
    	performancePage.clickOnSetTodayDateButton();
    }

    @Step
    public void checkPerformanceChartForCurrentDateIsDisplayed() {
    	performancePage.checkPerformanceChartForCurrentDateIsDisplayed();
    }


}
