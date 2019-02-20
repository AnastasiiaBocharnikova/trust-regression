package com.trust.cucumber.pages;

import com.trust.cucumber.util.Log;
import com.trust.cucumber.util.Wait;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.each;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class StatusHistoryPage extends PageObject {

    public StatusHistoryPage(WebDriver driver) {
        super(driver);
    }

    private Wait wait = new Wait(getDriver());


    @FindBy (css = "div.StatusHistory_item_3DsV8")
    private List <WebElementFacade> statusBricks;

    @FindBy (css = "#sh-specific-date")
    private WebElementFacade specifyDateField;

    @FindBy (xpath = "//div[contains(@class,'MonthView_dayZoomPopover')]/div")
    private WebElementFacade dayStatusPopup;

    @FindBy (xpath = "//div[contains(@class,'HourView_wall_1LQC9')]")
    private WebElementFacade dayViewSection;

    @FindBy (xpath = "//a[contains(@class,'green HourView_brick_3GaEE')]")
    private  WebElementFacade brickElement;

    @FindBy (xpath = "//div[contains(@id,'drilldown-title')]")
    private WebElementFacade drillDownHeader;

    @FindBy (css = "#sh-range-start-date")
    private WebElementFacade specifyStartDateField;

    @FindBy (css = "div[class*='HourView_row']")
    private List<WebElementFacade> allBrickRows;

    @FindBy (xpath = "//div[contains(@class,'_dayContainer') and not (contains(@class,'_dayHidden'))]")
    private List<WebElementFacade> allBlocks;

	@FindBy (id = "select-multi-monitors")
	private WebElementFacade addMonitorsButton;

	private final String[] customHeaders = new String[]{"System / Monitor","Service ID","Status"};

	@FindBy (xpath = "//tbody")
	private WebElement noHeadingsMonitorTable;

	@FindBy (id="sh-specific-date")
    private WebElementFacade specificDateField;

	@FindBy (id = "sh-specific-date-back")
    private WebElementFacade calendarPreviousArrow;

	@FindBy (xpath = "//div//button//span[contains(text(), '1')]")
    private WebElementFacade firstDay;

	@FindBy (xpath = "//div//h6")
    private WebElementFacade monitorTitleHeader;

	@FindBy (xpath = "//div//fieldset//label/span")
    private List<WebElementFacade> checkBoxesInTheList;

	@FindBy (css = "#modal-button-clear-all")
    private WebElementFacade clearAllButton;

	@FindBy (css="#modal-button-reset")
    private WebElementFacade resetButton;

    @FindBy (css = "a[class*='HourView_brick']")
    private List<WebElementFacade> allBricks;

    @FindBy (css = ".ReactTable>.DataTable_tableContainer_JUqZJ>table")
    private WebElement notificationTable;

    @FindBy (css = "#sh-specific-date-back")
    private WebElement specifyPreviousDateButton;

    @FindBy (css = "[class*=DrillDown_drilldownSectionInner]>.ReactTable>div>table")
    private WebElement rawDataTable;

    @FindBy (css = "[class*=DrillDown_drilldownSectionInner]>table")
    private WebElement businessTable;

    @FindBy (css = "div[class*= DrillDown_drillDownRoot] div[class*=NotificationsTable_notifications]>.ReactTable table")
    private WebElement notifTableOnDrillDown;

    @FindBy (css = "tr >td .ReactTable")
    private WebElement monitorTable;

    public void isStatusHistoryPageOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/status-history/"));
        Assert.assertTrue(find(By.cssSelector("h3.text-link")).getText().equals("Status History"));
    }

    public void checkSpecifyPreviousDateButtonEnabled() {
        Assert.assertTrue(specifyPreviousDateButton.isEnabled());
    }

    public void clickOnSpecifyPreviousDateButton() {
        specifyPreviousDateButton.click();
    }

    public Map<String, String> getStatusHistoryBricks() {
        Map<String,String> statuses = new HashMap<String,String>();
        for (WebElementFacade brick: statusBricks) {
            String status = brick.find(By.cssSelector("div.StatusHistory_title_2C01Z")).getText();
            String statusColor = brick.findBy("./div[contains(@class,'brick')]").getCssValue("background-color");
            statuses.put(status, statusColor);
        }
        return statuses;
    }

    public void clickHistoryViewButton(String buttonName) {
        clickOn($("//div[contains(@class,'StatusHistory_tabsContainer')]//button//span[text()='" + buttonName + "']"));
        wait.waitForPageLoad();
    }

    public void selectFirstDayOfThePreviousMonth() {
        String beforeDate = specifyDateField.getText();
        clickOn(specifyDateField);
        clickOn($("//span[text()='keyboard_arrow_left']"));
        waitFor("//button//span[text()='1']");
        $("//button//span[text()='1']").waitUntilClickable();
        clickOn($("//button//span[text()='1']"));
        specifyDateField.shouldBeVisible();
        Assert.assertNotSame(beforeDate,specifyDateField.getText());
    }

    public void hoverOnParticularDay(int dayIndex) {
        waitForAbsenceOf("div.Spinner_spinner_3DxLh");
        List<WebElementFacade> days = findAll("//div[contains(@class,'_dayContainer') and not (contains(@class,'_dayHidden'))]");
        withAction().moveToElement(days.get(dayIndex)).perform();
        waitFor(dayStatusPopup);
    }

    public void dayStatusPopUpIsDisplayed() {
        int dayIndex = 1;//@TODO <-- this is stability fix || make here more clear passing of arg
        waitForAbsenceOf("div.Spinner_spinner_3DxLh");
        List<WebElementFacade> days = findAll("//div[contains(@class,'_dayContainer') and not (contains(@class,'_dayHidden'))]");
        withAction().moveToElement(days.get(dayIndex)).build().perform();
        Assert.assertTrue(dayStatusPopup.isDisplayed());
    }

    public void dayStatusHistoryIsDisplayed() {
        try {
            wait.waitForPageLoad();
            waitFor(dayViewSection);
            dayViewSection.shouldBePresent();
        }catch (TimeoutException e){
            wait.waitForPageLoad();
            dayViewSection.shouldBePresent();
        }
    }

    public void specifiedDayStatusHistoryIsDisplayed() {
        try {
            wait.waitForPageLoad();
            withTimeoutOf(Duration.ofSeconds(30)).waitForAbsenceOf("[class*=spinner]");
            dayViewSection.shouldBePresent();
        }catch (TimeoutException e){
            withTimeoutOf(Duration.ofSeconds(30)).waitForAbsenceOf("[class*=spinner]");
            dayViewSection.shouldBePresent();
        }
        String dayLabel = dayViewSection.find(By.xpath(".//h3[(contains(@class,'hidden'))]")).getAttribute("innerHTML");
        Log.info(dayLabel);
        Log.info(specifyDateField.getValue());
        Assert.assertTrue(specifyDateField.getValue().contains(dayLabel));
    }

    public void isSHTextDisplayed(String systemName) {
        shouldBeVisible(By.xpath("//h6[contains(text()[1],'Status')]"));
        shouldBeVisible(By.xpath("//h6[contains(text()[2],'history for')]"));
        shouldBeVisible(By.xpath("//h6/span/div[contains(text(),'" + systemName + "')]"));
    }

    public void clickOnBrick() {
        shouldBeVisible(brickElement);
        clickOn(brickElement);
    }

    public void isDrilldownOpened() {
        shouldBeVisible(drillDownHeader);
    }

    public void areElementsAvailable(List<String> elements) {
        for(String element:elements){
            shouldBeVisible(By.xpath("//div[contains(text(),'" + element + "')]"));
        }
    }

    public void clickOnButton(String button) {
        clickOn(element(By.xpath("//button/span[contains(text(),'" + button + "')]")));
    }

    public String getSelectedDate() {
        return specifyDateField.getValue();
    }

    public void clickSelectStartDate() {
        specifyStartDateField.click();
    }

    public String getSelectedStartDate() {
        //TODO describe this passing of day 1 of month in Gherkin
        clickOn($("//span[text()='1']"));
        return specifyStartDateField.getValue();
    }

    public void userIsAbleToSeeTextDescription() {
        Assert.assertTrue($("p[class*='HourView_description']").getText().equalsIgnoreCase("Platform availability is reported in five minute increments, with each hour presented as a single row and the five minute block availability status for that specific hour presented horizontally."));
    }

    public void areRowsvisible(int rows) {
        int rowsplus = rows + 1; // there  may be expected extra row, to check that
        waitForAngularRequestsToFinish();
        Assert.assertTrue("There is different amount of brick rows than " + rows,allBrickRows.size() == rows || allBrickRows.size() == rowsplus);
    }

    public void areRowsVisible(int bricks) {
        int bricksplus = bricks + 12; // there  may be expected extra row, to check that
        waitForAngularRequestsToFinish();
        Assert.assertTrue("There is different amount of bricks than " + bricks,allBricks.size() == bricks || allBricks.size() == bricksplus);
    }

    public void isPublicLegendVisible() {
        //TODO add here verification for not seeing admin/internal legend when public-switch is fixed with state
        shouldBeVisible(By.cssSelector("div[class*='StatusHistory_legend']"));
        String green = $("//div[contains(@class,'green StatusHistory_brick_')]/parent::div/div[2]").getText();
        Assert.assertEquals(green, "No issues");

        WebElement orange = $("//div[contains(@class,'orange StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(orange.getText(), "Service disruption");

        WebElement red = $("//div[contains(@class,'red StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(red.getText(), "Service unavailable");

        WebElement maint = $("//div[contains(@class,'plannedMaintenance StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(maint.getText(), "Planned maintenance");
    }


    public void checkNotifHeaders(List<String> headers) {
        checkHeaders(headers, notificationTable);
    }

    //Move to general class
    private void checkHeaders(List<String> headers, WebElement table) {
        List<String> actualHeaders = inTable(table).getHeadings();
        List<String> actualHeadersWithoutBrackets = new ArrayList<String>();
        for (String value: actualHeaders) {
            if(!value.isEmpty()) {
                actualHeadersWithoutBrackets.add(value.replaceAll("\\(([^)]+)\\)", "").trim());
            }
        }
        Assert.assertEquals(actualHeadersWithoutBrackets, headers);
    }

    public void checkNotifTableValues(String message, String value, String column) {
        HtmlTable newTable = HtmlTable.inTable(notificationTable);
        List<WebElement> matchingRows =  newTable.getRowElementsWhere(the("Message", is(message)),the(column, is(value)));
        Assert.assertTrue(matchingRows.size() == 1);
    }

    public void userIsAbleToSeeSpecifyDateTabTextDescription() {
        Assert.assertTrue($("div[class*='MonthView_monthView']>p").getText().equalsIgnoreCase("This is a calendar day view of the range of dates specified above, with representation of the lowest status grade for any 20 minute block in a specific day. To identify what time of day, or the length of the service interruption, simply hover over the day of interest. Click on the day to see additional report details for that day."));
    }

    public void userIsAbleToSee30DaysTabTextDescription() {
        Assert.assertEquals($("div[class*='MonthView_monthView']>p").getText(),"This is a calendar day view of the last 30 days with representation of the lowest status grade for any 20 minute block in a specific day. To identify what time of day, or the length of the service interruption, simply hover over the day of interest. Click on the day to see additional report details for that day.");
    }

    public void thereAreBlocksAreDisplayed(int blocks) {
        waitForAngularRequestsToFinish();
        Assert.assertTrue("There is different amount of blocks than " + blocks,allBlocks.size() == blocks);

    }

    public void userClicksOneOfTheDaysViewBlocksWithDay(String day) {
        clickOn($("//div[contains(@class,'MonthView_dayContainer') and not (contains(@class,'_dayHidden'))]/a"));
    }

    public void tabIsSelected(String tab) {
        shouldBeVisible((By.cssSelector("#tab-" + tab + ",[aria-selected~=true]")));
    }

    public void isAdminLegendShown() {
        shouldBeVisible(By.cssSelector("div[class*='StatusHistory_legend']"));
        String green = $("//div[contains(@class,'green StatusHistory_brick_')]/parent::div/div[2]").getText();
        Assert.assertEquals(green, "No issues");

        WebElement orange = $("//div[contains(@class,'orange StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(orange.getText(), "Service disruption");

        WebElement red = $("//div[contains(@class,'red StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(red.getText(), "Service unavailable");

        WebElement maint = $("//div[contains(@class,'plannedMaintenance StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(maint.getText(), "Planned maintenance");

        WebElement _yellow = $("//div[contains(@class,'_yellow StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(_yellow.getText(), "Possible disruption (not customer-facing)");

        WebElement grey = $("//div[contains(@class,'grey StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(grey.getText(), "Missing data");

        WebElement _black = $("//div[contains(@class,'_black StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(_black.getText(), "Blackout");

        WebElement _indeterminate = $("//div[contains(@class,'_indeterminate StatusHistory_brick_')]/parent::div/div[2]");
        Assert.assertEquals(_indeterminate.getText(), "Indeterminate");
    }

    public void userNavigatesToMonitorLink() {
        shouldBeVisible(By.cssSelector("#monitor-system-tree-link"));
        clickOn($("#monitor-system-tree-link"));
    }

    public void checkHeaderForRawTable(List<String> headers) {
        checkHeaders(headers, rawDataTable);
    }

    public void checkBusinessLogicTableHeaders(List<String> headers) {
        checkHeaders(headers, businessTable);
    }

    public void checkNotifDrillDownTableHeaders(List<String> headers) {
        checkHeaders(headers, notifTableOnDrillDown);
    }

    public void expandMonitorTable() {
        clickOn($("[id*=show-more-btn]"));
    }

    public void checkMonitorTableHeders(List<String> headers) {
        checkHeaders(headers, monitorTable);
    }

    public void checkValuesInSHTable(String column, List<String> values) {
        WebElement monitorTable1 = find(By.cssSelector("tr >td .ReactTable"));
        try {
            for (String value : values) {
                boolean flag = HtmlTable.inTable(monitorTable1).containsRowElementsWhere(the(column, is(value)));
                Assert.assertTrue("Table for column " + column + " doesn't contain " + value, flag);
            }
        }catch(StaleElementReferenceException ignored){

        }
    }

    public void isValuePresentInColumnForRawDataTable(String value, String column) {
        checkValueInColumn(businessTable, value, column);
    }

    private void checkValueInColumn(WebElement table, String value, String column) {
        HtmlTable newTable = HtmlTable.inTable(table);
        List<WebElement> matchingRows =  newTable.getRowElementsWhere(the(column, containsString(value)));
        Assert.assertTrue(matchingRows.size() == 1);
    }

    public void clickDrilldownBack() {
        clickOn($("#drilldown-button-back"));
    }

    public String getDrilldownDate() {
        return $("#drilldown-title>h6").getText();
    }

    public void checkDrillDownDateTime(String beforeDrilldownDate, String afterDrilldownDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy, MMM dd, hh:mm aaa");
        Date dateBefore = sdf.parse(beforeDrilldownDate);
        Date dateAfter = sdf.parse(afterDrilldownDate);
        Minutes result = Minutes.minutesBetween(new DateTime(dateAfter), new DateTime(dateBefore));
        Assert.assertEquals(result, Minutes.minutes(5));
    }

    public void clickDrilldownEditNotif() {
        clickOn($("div[class*= DrillDown_drillDownModal] a[id*='edit-notification']"));
    }

	public void verifyAndClickAddMonitorsButton() {

		addMonitorsButton.waitUntilClickable();
		Assert.assertTrue(addMonitorsButton.isDisplayed());
    	clickOn(addMonitorsButton);
	}

	public void clickOnMonitorCheckBox(String monitorTitle) {
    	WebElementFacade monitorCheckBox = element(By.xpath("//span[contains(text(),'" + monitorTitle + "')]/preceding-sibling::span"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", monitorCheckBox);
        clickOn(monitorCheckBox);
    }

	public void monitorIsInTheList(String monitorTitle, String monitorID) {

		HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsMonitorTable);
		newTable.shouldHaveRowElementsWhere(the("System / Monitor", is(monitorTitle)));
		newTable.shouldHaveRowElementsWhere(the("Service ID", is(monitorID)));
		shouldMatch(newTable.getRows().stream().
						filter(row ->row.containsValue(" ")!= true).collect(Collectors.toList()),
				each("Service ID").isDifferent());
	}

	public void tabIsNotVisible(String tabName) {
		Assert.assertFalse(($("//span[contains(text(), '" + tabName + "')]").isCurrentlyVisible()));
	}

	public void checkBoxForMonitorIsSelectedAndNotEditable(String monitorTitle) {
		WebElement monitorCheckBox = element(By.xpath("//span[contains(text(),'" + monitorTitle + "')]/preceding-sibling::span"));
		Assert.assertEquals("-1", monitorCheckBox.getAttribute("tabindex"));
	}

	public void amountOfSectionsInTheStatusBar(int amountSections) {
		List<WebElementFacade> actualAmountOfSections = findAll("//div[@class='DayStatusBar_hourWrapper_1Kz9m']");
		withTimeoutOf(Duration.ofSeconds(5)).waitFor(actualAmountOfSections);
		int amount = actualAmountOfSections.size();
		Log.info(String.valueOf(amount));
        Log.info(String.valueOf(amountSections));
        Assert.assertTrue(amount == amountSections || amount == (amountSections - 3));
	}

	public void verifyChooseDateFieldIsDisplayed() {
		Assert.assertTrue(specificDateField.isDisplayed());
	}

	public void verifyStatusHistoryForSingleMonitorIsDisplayed(String monitorTitle) {
    	String actualTitle = monitorTitleHeader.getText();
		Assert.assertEquals(("Status history for \n" + monitorTitle),actualTitle);
	}

	public void verifyingResetClearButton(String button) {
		if (button.equals("Reset")) {
			Assert.assertTrue(resetButton.isEnabled());
			resetButton.click();
		} else if (button.equals("Clear all")) {
			Assert.assertTrue(clearAllButton.isEnabled());
			clearAllButton.click();
		}
	}

	public void checkBoxForMonitorIsNotSelected(String monitorTitle) {
		WebElementFacade monitorCheckBox = element(By.xpath("//span[contains(text(),'" + monitorTitle + "')]/preceding-sibling::span"));
		Assert.assertFalse(monitorCheckBox.isSelected());
	}

	public void verifyNoSelectedCheckBox() {
        for (WebElementFacade element: checkBoxesInTheList) {
            Assert.assertFalse(element.isSelected());
        }
	}

    public void isNotVisibleAddMonitors() {
        shouldNotBeVisible(By.cssSelector("#select-multi-monitors"));
    }

    public void userClicksOnLinkOnMultipleMonitorsView(String link) {
        clickOn($("//a[contains(text(), '" + link + "')]"));
    }

    public void checkIfMultipleMonitorsViewIsOpened() {
        shouldBeVisible(By.xpath("//h6[contains(text(), 'Status history for multiple monitors')]"));
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
        getDriver().navigate().refresh();  // this is needed because of TRUST-2738
        waitFor(specifyDateField);
        Assert.assertTrue(specifyDateField.getAttribute("value").contains(selectedDateValue));
    }
}

