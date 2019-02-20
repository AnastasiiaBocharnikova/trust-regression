package com.trust.cucumber.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trust.cucumber.util.Environment;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PerformancePage extends PageObject {
	
	public PerformancePage(WebDriver driver) {
		super(driver);
	}
	
    Environment testEnvironment  = ConfigFactory.create(Environment.class);
	
	@FindBy (xpath = "//button//span[text()='Performance']")
	private WebElementFacade performanceButton;
	
	@FindBy (xpath = "//button//span[text()='Status History']")
	private WebElementFacade statusHistoryButton;
	
	@FindBy (css = "#sh-specific-date")
	private WebElementFacade specifyDateField;
		
    @FindBy (css = "#sh-specific-date-next")
    private WebElement setNextDateButton;
    
	@FindBy (css = "#set-today-time-btn")
	private WebElement setTodayDateButton;

	@FindBy (css = "#tab-last-24h")
	private WebElementFacade last24HButton;

	@FindBy (css = "div.HourView_row_1p24X")
	private List <WebElementFacade> hourViewRows;
	
    @FindBy(css = "h6 span")
    private WebElement performanceHistoryForText;

    @FindBy(css = "div.StatusHistory_tabs_3SBUi p")
    private WebElement descriptionText;

    @FindBy(css = "img[alt='monitor-performance-chart']")
    private WebElement performanceChart;
	
	public void performancePageIsDisplayed() {
		Assert.assertTrue(getDriver().getCurrentUrl().toString().contains("performance"));
		Assert.assertTrue(find(By.cssSelector("h3.text-link")).getText().equals("Performance History"));
	}
	
	public void verifyDefaultPerformanceDateIsCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy");
		String actualDate = specifyDateField.getValue();
		String expectedDate = dateFormat.format(new Date());
		Assert.assertEquals(actualDate, expectedDate);
	}
	
	public void clickStatusHistoryButton() {
		statusHistoryButton.click();
	}
	
	public void clickPerformanceButton() {
		performanceButton.click();
	}
	
	public void verify24HViewIsDispalyed() {
		Assert.assertTrue(getDriver().getCurrentUrl().contains("24h"));
		Assert.assertTrue(last24HButton.getAttribute("aria-selected").equals("true"));
		Assert.assertTrue(hourViewRows.size() == 25);
	}

    public void verifyPerformanceHistoryForText(String system, String monitor) {
        Assert.assertTrue(performanceHistoryForText.getText().equals(system + " \\ " + monitor));
    }

    public void checkStatusHistoryButtonIsDisplayed() {
        Assert.assertTrue(statusHistoryButton.isDisplayed());
    }

    public void checkPerformanceButtonIsDisplayed() {
        Assert.assertTrue(performanceButton.isDisplayed());
    }
    
    public void checkTextDescriptionContainsInstitutionNameAndInfoTimesInUTC(String institutionName) {
        Assert.assertTrue(descriptionText.getText().contains(institutionName));
        Assert.assertTrue(descriptionText.getText().contains("The times on horizontal axis are in UTC."));
    }
    
    public void checkPerformanceChartForSelectedDateIsDisplayed() {
        String selectedDateValue = getSelectedDateInDatePicker();
        String[] parts = selectedDateValue.split(" ");
        String selectedMonth = parts[0];
        String selectedDay = parts[1];
        Assert.assertTrue(performanceChart.getAttribute("src").contains(selectedMonth+"%20"+selectedDay)||performanceChart.getAttribute("src").contains(selectedMonth+"%200"+selectedDay));
    }
    
    public void checkPerformanceChartForCurrentDateIsDisplayed() {
        Assert.assertTrue(performanceChart.getAttribute("src").startsWith(testEnvironment.env()+"api/monitors/"));
        Assert.assertTrue(performanceChart.getAttribute("src").endsWith("/performance/chart.svg"));
    }
    
    public void checkSpecifyNextDateButtonDisabled() {
        Assert.assertFalse(setNextDateButton.isEnabled());
    }

    public void checkSpecifyNextDateButtonEnabled() {
        Assert.assertTrue(setNextDateButton.isEnabled());
    }


    public void setPreviousDateByDatePicker() {
    	specifyDateField.click();
        waitFor("//span[text()='keyboard_arrow_left']");
        $("//span[text()='keyboard_arrow_left']").click();
        waitFor("//button//span[text()='16']");
        $("//button//span[text()='16']").click();
    }

    private String getSelectedDateInDatePicker() {
        waitFor(specifyDateField);
        specifyDateField.click();
        String rows = $("div h4").getText();
        String[] parts = rows.split(", ");
        String selectedDate = parts[1];
        $("//span[text()='OK']").click();
        return selectedDate;
    }

    public void checkSelectedDayIsDisplayedInTheSpecifyDateField() {
        String selectedDateValue = getSelectedDateInDatePicker();
        waitFor(specifyDateField);
        Assert.assertTrue(specifyDateField.getAttribute("value").contains(selectedDateValue));
    }

    public void clickOnSetTodayDateButton() {
        setTodayDateButton.click();
    }
}