package com.trust.cucumber.pages;

import java.io.File;

import java.text.ParseException;

import com.trust.cucumber.util.Log;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static net.thucydides.core.matchers.BeanMatcherAsserts.*;
import static net.thucydides.core.matchers.BeanMatchers.each;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.*;

public class NotificationPage extends PageObject {

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.ReactTable table")
    private WebElement notificationsTable;

    @FindBy (css = "div.ReactTable table tbody")
    private WebElement noHeadingsTable;

    @FindBy (css = "div.ReactTable table thead")
    private WebElement headingsTable;

    @FindBy(css = "#export-to-csv-link")
    private WebElement exportToCSVLink;

    @FindBy(css = "#new-notifications-btn")
    private WebElement newNotificationsButton;

    @FindBy(css = "#manage-templates-btn")
    private WebElement manageTemplatesButton;

    @FindBy(xpath = "//span[text()='New template']")
    private WebElement newTemplatesButton;

    @FindBy(css = "#name-field")
    private WebElement templateNameTextBox;

    @FindBy (css = "div.ManageNotification_templatesSelect_3PUCb div div div")
    private WebElementFacade templateDropDown;

    @FindBy (xpath="//li[text()='autoTemplateEdited']")
    private WebElementFacade templateAutoTemplateEdited;

    @FindBy(xpath = "//div[@class='DraftEditor-editorContainer']")
    private WebElement editorTextBox;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement messageTextBox;

    @FindBy(xpath = "//div[@role='textbox']//span[@data-text]")
    private WebElement textOfMessageTextBox;

    @FindBy(css = "#start-time-field")
    private WebElementFacade startTimeField;

    @FindBy(css = "#copy-start-time-to-show-btn")
    private WebElement copyStartTimeToShownEndButton;

    @FindBy(css = "#end-time-field")
    private WebElementFacade endTimeField;

    @FindBy(css = "#copy-end-tine-to-start-btn")
    private WebElement copyEndTimeToShownEndButton;

    @FindBy(css = "#systems-field")
    private WebElement systemDropDown;

    @FindBy (css = "div.Search_suggestionContainer_3Gnz9>div>div")
    private List <WebElementFacade> systemDropDownOptions;

    @FindBy (xpath = "//div[@class='ManageNotification_formField_27xnW']//text()[.='\u200B']/ancestor::div[1]")
    private WebElement eventTypeDropDown;

    @FindBy (xpath = "//ul[@role='listbox']/li")
    private List <WebElementFacade> dropDownOptions;

    @FindBy (xpath = "//div[text()='Message']")
    private WebElementFacade messageColumn;

    @FindBy (css = "button[id*='delete-notification']")
    private WebElement deleteNotificationButton;

    @FindBy (xpath = "//span[text()='OK']", timeoutInSeconds = "1")
    private WebElement okPickerButton;

    @FindBy(css = "#modal-button-proceed")
    private WebElementFacade proceedModalButton;

    @FindBy(css = "#modal-button-close")
    private WebElementFacade closeModalButton;

    @FindBy(css = "#clear-btn")
    private WebElementFacade clearButton;

    @FindBy(xpath = "//div[@class='DataTable_tableContainer_JUqZJ']//tbody/tr")
    private WebElement amountOfNotificationOnPage;

    @FindBy(css = "#first-page-btn")
    private WebElementFacade firstPageButton;

    @FindBy(css = "#previous-page-btn")
    private WebElementFacade previousPageButton;

    @FindBy(css = "#next-page-btn")
    private WebElementFacade nextPageButton;

    @FindBy(css = "#last-page-btn")
    private WebElementFacade lastPageButton;

    @FindBy (css = "#systems-filter-dropdown")
    private WebElementFacade systemsFilterDropdown;

    @FindBy (css = "div[id*='downshift']")
    private List<WebElementFacade>multipleDropDownOptions;

    @FindBy (xpath = "//text()[.='\u200B']/ancestor::div[1]")
    private WebElementFacade accessLevelDropdown;

    @FindBy(css = "input[id=creation-time-filter]") // #creation-time-filter has 2 results
    private WebElementFacade creationTimeFilter;

    @FindBy(css = "input[id=last-updated-filter]") // #last-updated-filter has 2 results
    private WebElementFacade lastUpdatedFilter;

    @FindBy(css = "#event-start-time-filter")
    private WebElementFacade eventStartTimeFilter;

    @FindBy(xpath = "//th[9]/div/div")
    private WebElementFacade eventEndTimeFilter;

    @FindBy (css = "#created-by")
    private WebElementFacade createdByFilter;

    @FindBy (css = "#updated-by")
    private WebElementFacade updatedByFilter;

    @FindBy(css = "input[id=event-type-filter-dropdown]")
    private WebElementFacade eventTypeFilter;

    @FindBy(css = "#work-filter")
    private WebElementFacade messageFilter;

    @FindBy(xpath = "//th[9]//span[contains(text(),'all_inclusive')]")
    private WebElementFacade unknownEventEndTimeButton;

    @FindBy(xpath = "//th[11]//span[contains(text(),'all_inclusive')]")
    private WebElementFacade unknownShowEndTimeButton;

    @FindBy (css = "td div[class*='brick']")
    private List<WebElementFacade> listOfBricksInEventTypeColumn;

    @FindBy (xpath = "//td[6]")
    private List<WebElementFacade> listOfSystemsInTheColumn;

    @FindBy (xpath = "//td[7]")
    private List<WebElementFacade> listOfAccessLevelsInTheColumn;

    @FindBy (xpath = "//div[@role='document']//label//input")
    private List<WebElementFacade> selectDisplayedColumnsCheckboxesList;

   @FindBy (xpath = "//td[4]//div")
    private List<WebElementFacade> listOfCreationTimeColumn;

    @FindBy (xpath = "//td[5]//div")
    private List<WebElementFacade> listOfLastUpdateColumn;

    @FindBy (xpath = "//td[8]//div")
    private List<WebElementFacade> listOfEventStartTimeColumn;

    @FindBy (xpath = "//td[9]//div")
    private List<WebElementFacade> listOfEventEndTimeColumn;

    @FindBy (xpath = "//td[10]//div")
    private List<WebElementFacade> listOfShowStartTimeColumn;

    @FindBy (xpath = "//td[11]//div")
    private List<WebElementFacade> listOfShowEndTimeColumn;

    @FindBy (xpath = "//td[12]")
    private List<WebElementFacade> listOfCreatedByColumn;

    @FindBy (xpath = "//td[13]")
    private List<WebElementFacade> listOfUpdatedByColumn;

    @FindBy (xpath = "//td[16]")
    private List<WebElementFacade> listOfMessageColumn;

    @FindBy (xpath = "//td[3]")
    private List<WebElementFacade> listOfTemplateNameColumn;

    @FindBy (xpath = "//div[@class='Notifications_quickFilters_2Hhza']/div/span[1]")
    private List<WebElementFacade> quickMultipleFiltersList;

    @FindBy (xpath = "//div[@class='Notifications_quickFilters_2Hhza']/button/span[1]")
    private List<WebElementFacade> quickSingleFiltersList;

    @FindBy (xpath = "//span[contains(text(),'more_vert')]")
    private List<WebElementFacade> listOfShowMoreButtons;

    @FindBy (xpath = "//li[@role='menuitem']")
    private List<WebElementFacade> listOfOptionsInShowMoreButtons;

    private final String[] customHeadersTemplates = new String[]{"Details Button", "Enabled", "Name", "Message", "Created at", "Created by", "Updated at", "Updated by", "Delete button"};

    private final String[] customHeadersNotifications = new String[]{"Details Button", "ID", "Enabled", "Creation time", "Last updated", "Systems", "Access Level", "Event start time", "Event end time", "Show start time", "Show end time", "Created by", "Updated by", "Event type", "Override", "Message", "Delete and Clone buttons"};

    private static String downloadPath = "C:\\Users\\qaadmin\\Downloads"; //change "qaadmin" to username

    private static String getTextNode(WebElement e) {
        String text = e.getText().trim();
        List<WebElement> children = e.findElements(By.xpath("./*"));
        for (WebElement child : children) {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }

    private List <Map> getTableWithoutEmptyRows() {
        return HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable).
                getRows().stream().filter(row -> row.containsValue(" ") != true).collect(Collectors.toList());
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<String> getHeadersFromTable() {
        return inTable(notificationsTable).getHeadings();
    }

    public void verifyQuickMultipleFilters(Map<String, String> template) {
        Assert.assertTrue(getTextNode(quickMultipleFiltersList.get(0)).equalsIgnoreCase(template.get("1")));
        Assert.assertTrue(getTextNode(quickMultipleFiltersList.get(1)).equalsIgnoreCase(template.get("2")));
        Assert.assertTrue(getTextNode(quickMultipleFiltersList.get(2)).equalsIgnoreCase(template.get("5")));

        Assert.assertTrue(quickSingleFiltersList.get(0).getText().equalsIgnoreCase(template.get("3")));
        Assert.assertTrue(quickSingleFiltersList.get(1).getText().equalsIgnoreCase(template.get("4")));
    }

    public void clickOnShowMoreButtonQuickFilter(int n) {
        listOfShowMoreButtons.get(n).click();
    }

    public void closeQuickFilterOptions() {
        listOfOptionsInShowMoreButtons.get(0).click();
    }

    public void verifyOptionsForRecentlyUpdatedQuickFilter() {
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(0).getText().equalsIgnoreCase("Recently updated"));
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(1).getText().equalsIgnoreCase("Recently added"));
    }

    public void verifyOptionsForRecentlyActiveQuickFilter() {
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(0).getText().equalsIgnoreCase("Recently active"));
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(1).getText().equalsIgnoreCase("Currently active"));
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(2).getText().equalsIgnoreCase("Displaying now"));
    }

    public void verifyOptionsForPublicQuickFilter() {
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(0).getText().equalsIgnoreCase("Public"));
        Assert.assertTrue(listOfOptionsInShowMoreButtons.get(1).getText().equalsIgnoreCase("All internal"));
    }

    //Recently updated - Last updated in last 24h
    public void applyRecentlyUpdatedQuickFilter() {
        quickMultipleFiltersList.get(0).click();
    }

    public void verifyRecentlyUpdatedQuickFilterIsApplied() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        Date currentDate = new Date();
        Date startDateTime = DateFormat.getDateTimeInstance().getCalendar().getTime();
        startDateTime.setTime(startDateTime.getTime() - (24*60*60*1000)); //get last 24h

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Date lastUpdateDate = dateFormat.parse(listOfLastUpdateColumn.get(i).getText());

            Assert.assertTrue(((lastUpdateDate.compareTo(currentDate)<0)||(lastUpdateDate.equals(currentDate)))
            && ((lastUpdateDate.compareTo(startDateTime)>0)||(lastUpdateDate.equals(startDateTime))));
        }
    }

    //Recently added - creation time in last 24h
    public void applyRecentlyAddedQuickFilter() {
        clickOnShowMoreButtonQuickFilter(0);
        listOfOptionsInShowMoreButtons.get(1).click();
    }

    public void verifyRecentlyAddedQuickFilterIsApplied() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        Date currentDate = new Date();
        Date startDateTime = DateFormat.getDateTimeInstance().getCalendar().getTime();
        startDateTime.setTime(startDateTime.getTime() - (24*60*60*1000)); //get last 24h

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Date creationDate = dateFormat.parse(listOfCreationTimeColumn.get(i).getText());

            Assert.assertTrue(((creationDate.compareTo(currentDate)<0)||(creationDate.equals(currentDate)))
                    && ((creationDate.compareTo(startDateTime)>0)||(creationDate.equals(startDateTime))));
        }
    }

    //Currently active - Event start time is before current date and Event end time is after current date or Unknown
    public void applyCurrentlyActiveQuickFilter() {
        clickOnShowMoreButtonQuickFilter(1);
        listOfOptionsInShowMoreButtons.get(1).click();
    }

    public void verifyCurrentlyActiveQuickFilterIsApplied() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");
        Date currentDate = new Date();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Date eventStartDate = dateFormat.parse(listOfEventStartTimeColumn.get(i).getText());
            Assert.assertTrue((eventStartDate.compareTo(currentDate)<0)||(eventStartDate.equals(currentDate)));

            if (!listOfEventEndTimeColumn.get(i).getText().equals("Unknown")) {
                Date eventEndDate = dateFormat.parse(listOfEventEndTimeColumn.get(i).getText());
                Assert.assertTrue((eventEndDate.compareTo(currentDate)>0)||(eventEndDate.equals(currentDate)));
            }
        }
    }

    // Displaying now - Show start time is before current date and Show end time is after current date or Unknown
    public void applyDisplayingNowQuickFilter() {
        clickOnShowMoreButtonQuickFilter(1);
        listOfOptionsInShowMoreButtons.get(2).click();
    }

    public void verifyDisplayingNowQuickFilterIsApplied() throws ParseException{
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");
        Date currentDate = new Date();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Date showStartDate = dateFormat.parse(listOfShowStartTimeColumn.get(i).getText());
            Assert.assertTrue((showStartDate.compareTo(currentDate) < 0) || (showStartDate.equals(currentDate)));

            if (!listOfShowEndTimeColumn.get(i).getText().equals("Unknown")) {
                Date showEndDate = dateFormat.parse(listOfShowEndTimeColumn.get(i).getText());
                Assert.assertTrue((showEndDate.compareTo(currentDate) > 0) || (showEndDate.equals(currentDate)));
            }
        }
    }

    //My notifications - Created by or Updated by current user
    public void applyMyNotificationsQuickFilter() {
        quickSingleFiltersList.get(0).click();
    }

    public void verifyMyNotificationsQuickFilterIsApplied(String userName) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfCreatedByColumn.get(i).getText().equals(userName)||
                    listOfUpdatedByColumn.get(i).getText().equals(userName));
        }
    }

    //Not auto-generated - Created by is not System
    public void applyNotAutoGeneratedQuickFilter() {
        quickSingleFiltersList.get(1).click();
    }

    public void verifyNotAutoGeneratedQuickFilterIsApplied() {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertFalse(listOfCreatedByColumn.get(i).getText().equals("System"));
        }
    }

    //Public - Access level is Public
    public void applyPublicQuickFilter() {
         quickMultipleFiltersList.get(2).click();
    }

    public void verifyPublicQuickFilterIsApplied() {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfAccessLevelsInTheColumn.get(i).getText().equals("Public"));
        }
    }

    //All internal - Access level is Admin/Internal/GPT
    public void applyAllInternalQuickFilter() {
        clickOnShowMoreButtonQuickFilter(2);
        listOfOptionsInShowMoreButtons.get(1).click();
    }

    public void verifyAllInternalQuickFilterIsApplied() {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfAccessLevelsInTheColumn.get(i).getText().equals("Admin")||
                    listOfAccessLevelsInTheColumn.get(i).getText().equals("Internal")||
                    listOfAccessLevelsInTheColumn.get(i).getText().equals("GPT"));
        }
    }

    public void clickOnManageTemplatesButton() {
        manageTemplatesButton.click();
    }

    public void verifyNotificationTemplatesPageIsOpened()
    {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/templates"));
        Assert.assertTrue(find(By.cssSelector("h3.text-link")).getText().equals("Notification templates"));
    }

    public void clickOnNewTemplateButton() {
        waitFor(newTemplatesButton).isEnabled();
        newTemplatesButton.click();
    }

    public void verifyAddTemplatesPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/templates/new"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().contains("Create template"));
    }

    public void switchedEnabledToggle() {
        $("#enabled-field").click();
    }

    public void populateNewNotificationTemplateFields(String name, String message) {
        templateNameTextBox.sendKeys(name);
        editorTextBox.click();
        messageTextBox.sendKeys(message);
    }

    public void clickOkModalButtonIfItIsDisplayed() {
       List <WebElementFacade> okButton= findAll("#modal-button-ok");
        if (okButton.size() > 0) {
            $("#modal-button-ok").click();
        }
        else {
            Log.info("There is no OK modal button");
        }
    }

    public void checkTemplateInTable(String Name) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersTemplates).inTable(noHeadingsTable);
        newTable.shouldHaveRowElementsWhere(the("Name", is(Name)));
        shouldMatch(newTable.getRows().stream().
                        filter(row -> !row.containsValue(" ")).collect(Collectors.toList()),
                each("Name").isDifferent());
    }

    public void selectTemplateByName(String templateName) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersTemplates).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere(the("Name", is(templateName))).findElements(By.xpath("./td"));
        rowCells.get(Arrays.asList(customHeadersTemplates).indexOf("Name")).click();
    }

    public void verifyUpdateTemplatePopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/templates/"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().contains("Edit template"));
    }

    public void updateTemplateNameMessageFields(String update) {
        templateNameTextBox.sendKeys(update);
        editorTextBox.click();
        messageTextBox.sendKeys(update);
    }

    public void verifyDefaultValueInTemplateDropdown() {
        Assert.assertTrue(templateDropDown.getText().contains("None"));
    }

    public void selectTemplateInCreateNotificationForm() {
        templateDropDown.click();
        templateAutoTemplateEdited.click();
    }

    public void verifyMessageForSetTemplate() {
        Assert.assertTrue(editorTextBox.getText().contains("Created templateEdited"));
    }

    public void deleteTemplateByName(String templateName) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersTemplates).inTable(noHeadingsTable);
        newTable.findFirstRowWhere(the("Name", is(templateName))).
                findElement(By.cssSelector("div.DataTable_actionWrap_2XTGV button")).click();
    }

    public void verifyTemplateIsDeleted (String templateName) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertFalse(listOfTemplateNameColumn.get(i).getText().equals(templateName));
        }
    }

    public void verifyThereIsNoTemplateByName(String templateName) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersTemplates).inTable(noHeadingsTable);
        if(newTable.containsRowElementsWhere(the("Name", is(templateName)))) {
            newTable.findFirstRowWhere(the("Name", is(templateName))).
                    findElement(By.cssSelector("div.DataTable_actionWrap_2XTGV button")).click();
            clickProceedButton();
        }
    }

    public void clickOnBackButton() {
        $("//span[text()=' arrow_back ']").click();
    }

    public void clickOnNewNotification() {
        newNotificationsButton.click();
    }

    public void verifyCreateNotificationPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/new"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().contains("Create Notification"));
    }

    public void populateNewNotificationFields(Map<String, String> template, int type)
    {
        selectSystem(template.get("System"));
        setEventType(type);
        setEventEndTime();
        clickOnCopyEndTimeToShowEndTime();
        withTimeoutOf(2000, TimeUnit.MILLISECONDS).waitFor(editorTextBox);
        editorTextBox.click();
        messageTextBox.sendKeys(template.get("Message"));
    }

    public void selectSystem(String systemName) {
        $(systemDropDown).click();
        for (int i = 0; i < multipleDropDownOptions.size(); i++) {
            if (multipleDropDownOptions.get(i).getText().equals(systemName)) {
                multipleDropDownOptions.get(i).click();
            }
        }
    }

    private void setEventType(int index) {
        $(eventTypeDropDown).click();
        dropDownOptions.get(index).click();
    }

    public void changeEventTypeFromPMToPossibleDisruption() {
        $("//div[@class='ManageNotification_formField_27xnW']//div[@title='Planned Maintenance']").click();
        dropDownOptions.get(3).click();
    }

    public void changeEventTypeFromPossibleDisruptionToPM() {
        $("//div[@class='ManageNotification_formField_27xnW']//div[@title='Possible disruption']").click();
        dropDownOptions.get(1).click();
    }

    public void updateNotificationMessageField (String message) {
        editorTextBox.click();
        messageTextBox.sendKeys(message);
    }

    private void setEventEndTime()
    {
        waitABit(300); // waiting while the transparent block is disappeared
        endTimeField.click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[text()='keyboard_arrow_right']");
        $("//span[text()='keyboard_arrow_right']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//button//span[text()='1']");
        $("//button//span[text()='1']").click();
        $("//span[text()='OK']").click();
    }

    public void setEventTimesInThePast()
    {
        waitABit(300); // waiting while the transparent block is disappeared
        startTimeField.click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[text()='keyboard_arrow_left']");
        $("//span[text()='keyboard_arrow_left']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//button//span[text()='1']");
        $("//button//span[text()='1']").click();
        $("//span[text()='OK']").click();
        clickOnCopyStartTimeToShowEndTime();

        endTimeField.click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[text()='keyboard_arrow_left']");
        $("//span[text()='keyboard_arrow_left']").click();
        $("//span[text()='keyboard_arrow_left']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//button//span[text()='2']");
        $("//button//span[text()='2']").click();
        $("//span[text()='OK']").click();
        clickOnCopyEndTimeToShowEndTime();
    }

    public void setEventTimesInTheFuture()
    {
        waitABit(300); // waiting while the transparent block is disappeared
        startTimeField.click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[1][text()='keyboard_arrow_right']");
        $("//span[1][text()='keyboard_arrow_right']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[1][text()='keyboard_arrow_right']");
        $("//span[1][text()='keyboard_arrow_right']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//button//span[text()='1']");
        $("//button//span[text()='1']").click();
        $("//span[text()='OK']").click();
        clickOnCopyStartTimeToShowEndTime();

        endTimeField.click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[1][text()='keyboard_arrow_right']");
        $("//span[1][text()='keyboard_arrow_right']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//span[1][text()='keyboard_arrow_right']");
        $("//span[1][text()='keyboard_arrow_right']").click();
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor("//button//span[text()='2']");
        $("//button//span[text()='2']").click();
        $("//span[text()='OK']").click();
        clickOnCopyEndTimeToShowEndTime();
    }

    private void clickOnCopyEndTimeToShowEndTime()
    {
        waitForRenderedElementsToDisappear(By.xpath("//div[@role='menu']"));
        copyEndTimeToShownEndButton.click();
    }

    private void clickOnCopyStartTimeToShowEndTime()
    {
        waitForRenderedElementsToDisappear(By.xpath("//div[@role='menu']"));
        copyStartTimeToShownEndButton.click();
    }

    public void switchedOverrideToggle() {
        $("#override-field").click();
    }

    public void clickOnSaveAndCloseButton() {
        $("#modal-button-save-and-close").click();
    }

    public void verifyNewNotificationCreated(String message) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        newTable.shouldHaveRowElementsWhere(the("Message", containsString(message)));
    }

    public void selectNotificationByMessage(String Message){
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere(the("Message", is(Message))).findElements(By.xpath("//td//..//p"));
        rowCells.get(0).click();
    }

    public void verifyEditNotificationPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6/span")).getText().equals("Notification"));
    }

    public void verifyEditNotificationPopUpIsOpenedFromSplash() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/notifications/"));
            Assert.assertTrue(getDriver().findElement(By.xpath("//div/h6")).getText().equals("Notification") || getDriver().findElement(By.xpath("//div//h6/span")).getText().equals("Notification"));
    }

    public void deleteSelectedSystem() {
        $("//div[@role='button'][1]//*[name()='svg']").click();
    }

    public void deleteNotificationByMessage(String Message) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere(the("Message", is(Message))).findElements(By.cssSelector("button[id*='delete-notification']"));
        rowCells.get(0).click();
    }

    public void verifyNotificationIsDeleted(String message) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        newTable.shouldNotHaveRowElementsWhere(the("Message", is(message)));
    }

    public void clickCloneNotificationButtonByMessage() {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere().findElements(By.cssSelector("button[id*='clone-notification']"));
        rowCells.get(0).click();
    }

    private void clickProceedButton() {
        proceedModalButton.click();
    }

    public void clickCancelButton() {
        closeModalButton.click();
    }

    public void clickOnClearButton() {
        clearButton.click();
    }

    public void clearMessageTextBoxOnCreateNotificationForm() {
        textOfMessageTextBox.clear();
    }

    public void setNotificationsPerPage(int setNotificationsPerPage) {
        waitABit(1000); //added for stability
        $("//div[text()='10']").click();
        $("//li[text()='"+setNotificationsPerPage+"']").click();
    }

    public void verifyAmountOfNotificationsPerPage(int notificationsPerPage) {
        List<WebElementFacade> amountNotifications = findAll("//div[@class='DataTable_tableContainer_JUqZJ']//tbody/tr");
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(amountNotifications);
        int amount = amountNotifications.size();
        Assert.assertTrue(amount==notificationsPerPage);
    }

    public void clickOnNextPageButton() {
        getDriver().navigate().refresh();
        nextPageButton.click();
    }

    public void verifySecondPageIsDisplayed() {
        Assert.assertTrue($("//span[contains(text(), '11-20 of ')]").isDisplayed());
    }

    public void clickOnPreviousPageButton() {
        previousPageButton.click();
    }

    public void clickOnLastPageButton() {
        lastPageButton.click();
    }

    public void verifyLastPageIsDisplayed() {
        String rows = $("//div[@class='DataTable_pagination_3_gUg']//span[contains(text(), ' of ')]").getText();
        String[] parts = rows.split("of ");
        String current  = parts[0];
        String totalAmount = parts[1];

        Assert.assertTrue(current.contains(totalAmount));
    }

    public void clickOnFirstPageButton() {
        firstPageButton.click();
    }

    public void verifyFirstPageIsDisplayed() {
        Assert.assertTrue($("//span[contains(text(), '1-10 of ')]").isDisplayed());
    }

    public void verifyNextPageButtonIsDisabled() {
        Assert.assertFalse(nextPageButton.isEnabled());
    }

    public void verifyLastPageButtonIsDisabled() {
        Assert.assertFalse(lastPageButton.isEnabled());
    }

    public void verifyFirstPageButtonIsDisabled() {
        Assert.assertFalse(firstPageButton.isEnabled());
    }

    public void verifyPreviousPageButtonIsDisabled() {
        Assert.assertFalse(previousPageButton.isEnabled());
    }

    public void verifyFirstPageButtonIsEnabled() {
        Assert.assertTrue(firstPageButton.isEnabled());
    }

    public void verifyPreviousPageButtonIsEnabled() {
        Assert.assertTrue(previousPageButton.isEnabled());
    }

    public void clickOnExportToCSVButton() {
        exportToCSVLink.click();
    }

    public void verifyCSVFileIsDownloaded() {
        File getLatestFile = getLatestFileFromDir(downloadPath);
        String fileName = getLatestFile.getName();
        Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".csv"));
        Assert.assertTrue("Downloaded file name is not matching with expected file name", fileName.contains("notifications_"));
        Assert.assertTrue(getLatestFile.length()>0);
    }

    public void clearPreviouslyDownloadedFiles() {
        clearFiles(downloadPath,"notifications_");
    }

    private boolean isFileDownloaded_Ext(String dirPath, String ext) {
        boolean flag = false;
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().contains(ext)) {
                flag = true;
            }
        }
        return flag;
    }

    private File getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    private void clearFiles(String dirPath, String fileName) {
        File dir = new File(dirPath);
        File[] dirContents = dir.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().contains(fileName)) {
                dirContents[i].delete();
            }
        }
    }

    private String getCurrentDate () {
        DateFormat dateFormat = new SimpleDateFormat("MMM d");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setValueToCreationTimeColumn () {
        creationTimeFilter.click();
        $("//span[text()='OK']").click();
    }

    public void verifyCreatedTodayNotificationsAreDisplayed () {
        String currentDate = getCurrentDate ();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfCreationTimeColumn.get(i).getText().contains(currentDate));
        }
    }

    public void setValueToLastUpdatedColumn () {
        lastUpdatedFilter.click();
        $("//span[text()='OK']").click();
    }

    public void verifyUpdatedTodayNotificationsAreDisplayed () {
        String currentDate = getCurrentDate ();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfLastUpdateColumn.get(i).getText().contains(currentDate));
        }
    }

    public void setValueToSystemDropDown(String systemName) {
        systemsFilterDropdown.click();
        for (int i = 0; i < multipleDropDownOptions.size(); i++) {
            if (multipleDropDownOptions.get(i).getText().equals(systemName)) {
                multipleDropDownOptions.get(i).click();
            }
        }
    }

    public void verifyNotificationsAreFilteredBySystem(String systemName) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfSystemsInTheColumn.get(i).getText().contains(systemName)||listOfSystemsInTheColumn.get(i).getText().equals("All Systems"));
        }
    }

    public void setValueToAccessLevelDropDown(int accessLevel) {
        accessLevelDropdown.click();
        dropDownOptions.get(accessLevel).click();
    }

    public void verifyNotificationsAreFilteredByPublicAccessLevel() {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfAccessLevelsInTheColumn.get(i).getText().equals("Public"));
        }
    }

    public void setValueToEventStartTimeColumn () {
        eventStartTimeFilter.click();
        $("//span[text()='OK']").click();
    }

    public void verifyStartedTodayNotificationsAreDisplayed () {
        String currentDate = getCurrentDate ();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfEventStartTimeColumn.get(i).getText().contains(currentDate));
        }
    }

    public void setUnknownValueToEventEndTimeColumn () {
        unknownEventEndTimeButton.click();
    }

    public void verifyNotificationsWithUnknownEventTimeAreDisplayed () {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfEventEndTimeColumn.get(i).getText().equals("Unknown"));
        }
    }

    public void setValueToEventEndTimeColumn () {
        eventEndTimeFilter.click();
        $("//span[text()='OK']").click();
    }

    public void verifyEndedTodayNotificationsAreDisplayed () {
        String currentDate = getCurrentDate ();

        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfEventEndTimeColumn.get(i).getText().contains(currentDate));
        }
    }

    public void setValueToCreatedByColumn(String userName) {
        createdByFilter.click();
        createdByFilter.sendKeys(userName);
        multipleDropDownOptions.get(0).click();
    }

    public void verifyNotificationsCreatedBySelectedUserAreDisplayed(String userName) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfCreatedByColumn.get(i).getText().equals(userName));
        }
    }

    public void setValueToUpdatedByColumn(String userName) {
        updatedByFilter.click();
        updatedByFilter.sendKeys(userName);
        multipleDropDownOptions.get(0).click();
    }

    public void verifyNotificationsUpdatedBySelectedUserAreDisplayed(String userName) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfUpdatedByColumn.get(i).getText().equals(userName));
        }
    }

    public void setValueToEventTypeFilter(int eventType) {
        eventTypeFilter.click();
        multipleDropDownOptions.get(eventType).click();
    }

    public void verifyNotificationsWithSelectedEventTypeAreDisplayed(String eventType) {
        for (int i = 0; i < listOfBricksInEventTypeColumn.size(); i++) {
            Assert.assertTrue(listOfBricksInEventTypeColumn.get(i).getAttribute("title").equals(eventType));
        }
    }

    public void setValueToMessageColumn(String message) {
        messageFilter.click();
        messageFilter.sendKeys(message);
    }

    public void verifyNotificationsWithSelectedMessageAreDisplayed(String message) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Assert.assertTrue(listOfMessageColumn.get(i).getText().contains(message));
        }
    }

    public void clickOnShowColumnChooserLink() {
        $("#show-column-chooser-link").click();
    }

    public void deselectColumnInSelectDisplayedColumnsPopUpByIndex(int n) {
        List<WebElementFacade> listColumnNamesPopUp = findAll("//div[@role='document']//label//input");
        listColumnNamesPopUp.get(n-1).click();
        $("//span[text()='Ok']").click();
    }

    public void verifyDeselectedColumnIsNotDisplayed(String columnName) {
        String actualHeaders = headingsTable.getText();
        Assert.assertFalse(actualHeaders.contains(columnName));
    }

    //Sorting
    private void verifyNotificationsTableIsSortedByDateColumnAscending(List <WebElementFacade> list) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            String firstDate = list.get(i).getText();
            String secondDate = list.get(i+1).getText();
            Date date1 = dateFormat.parse(firstDate);
            Date date2 = dateFormat.parse(secondDate);
            Assert.assertTrue((date1.compareTo(date2)<0)||(date1.equals(date2)));
        }
    }

    private void verifyNotificationsTableIsSortedByDateColumnDescending(List <WebElementFacade> list) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            String firstDate = list.get(i).getText();
            String secondDate = list.get(i+1).getText();
            Date date1 = dateFormat.parse(firstDate);
            Date date2 = dateFormat.parse(secondDate);
            Assert.assertTrue((date1.compareTo(date2)>0)||(date1.equals(date2)));
        }
    }

    private void verifyNotificationsTableIsSortedByStringColumnAscending(List <WebElementFacade> list) {
        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            Assert.assertTrue((list.get(i).getText().compareTo(list.get(i+1).getText())<0)||(list.get(i).getText().equals(list.get(i+1).getText())));
        }
    }

    private void verifyNotificationsTableIsSortedByStringColumnDescending(List <WebElementFacade> list) {
        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            Assert.assertTrue((list.get(i).getText().compareTo(list.get(i+1).getText())>0)||(list.get(i).getText().equals(list.get(i+1).getText())));
        }
    }

    //CreationTime
    public void verifyNotificationsTableIsSortedByCreationTimeAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfCreationTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfCreationTimeColumn);
    }

    public void verifyNotificationsTableIsSortedByCreationTimeDescending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfCreationTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnDescending(listOfCreationTimeColumn);
    }

    //LastUpdated
    public void verifyNotificationsTableIsSortedByLastUpdatedAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfLastUpdateColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfLastUpdateColumn);
    }

    public void verifyNotificationsTableIsSortedByLastUpdatedDescending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfLastUpdateColumn);
        verifyNotificationsTableIsSortedByDateColumnDescending(listOfLastUpdateColumn);
    }

    //EventStarTime
    public void verifyNotificationsTableIsSortedByEventStartTimeAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfEventStartTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfEventStartTimeColumn);
    }

    public void verifyNotificationsTableIsSortedByEventStartTimeDescending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfEventStartTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnDescending(listOfEventStartTimeColumn);
    }

    //EventEndTime
    public void verifyNotificationsTableIsSortedByEventEndTimeAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfEventEndTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfEventEndTimeColumn);
    }

    public void verifyNotificationsTableIsSortedByEventEndTimeDescending() {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfEventEndTimeColumn);

        List <Map> tableWithoutUnknownRows = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable).
                getRows().stream().filter(row -> !row.containsValue("Unknown")).collect(Collectors.toList());

        for (int i = 0; i < tableWithoutUnknownRows.size()-1; i++) {
            Assert.assertTrue((listOfEventEndTimeColumn.get(i).getText().compareTo(listOfEventEndTimeColumn.get(i+1).getText())>0)
                    ||(listOfEventEndTimeColumn.get(i).getText().equals(listOfEventEndTimeColumn.get(i+1).getText())));
        }
    }

    public void scrollToMessageColumn() {
        //scroll to message because after reset to default state hint is displayed and some headers are not clickable
        scrollToElement(messageColumn);
    }

    //Show start time
    public void verifyNotificationsTableIsSortedByShowStartTimeAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfShowStartTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfShowStartTimeColumn);
    }

    public void verifyNotificationsTableIsSortedByShowStartTimeDescending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfShowStartTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnDescending(listOfShowStartTimeColumn);
    }

    //Show end time
    public void verifyNotificationsTableIsSortedByShowEndTimeAscending() throws ParseException {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfShowEndTimeColumn);
        verifyNotificationsTableIsSortedByDateColumnAscending(listOfShowEndTimeColumn);
    }

    public void verifyNotificationsTableIsSortedByShowEndTimeDescending() {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfShowEndTimeColumn);

        List <Map> tableWithoutUnknownRows = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable).
                getRows().stream().filter(row -> !row.containsValue("Unknown")).collect(Collectors.toList());

        for (int i = 0; i < tableWithoutUnknownRows.size()-1; i++) {
            Assert.assertTrue((listOfShowEndTimeColumn.get(i).getText().compareTo(listOfShowEndTimeColumn.get(i + 1).getText()) > 0)
                    || (listOfShowEndTimeColumn.get(i).getText().equals(listOfShowEndTimeColumn.get(i + 1).getText())));
        }
    }

    //Created by
    public void verifyNotificationsTableIsSortedByCreatedByAscending() {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfCreatedByColumn);
        verifyNotificationsTableIsSortedByStringColumnAscending(listOfCreatedByColumn);
    }

    public void verifyNotificationsTableIsSortedByCreatedByDescending() {
        withTimeoutOf(1000, TimeUnit.MILLISECONDS).waitFor(listOfCreatedByColumn);
        verifyNotificationsTableIsSortedByStringColumnDescending(listOfCreatedByColumn);
    }

    //Updated by
    public void verifyNotificationsTableIsSortedByUpdatedByAscending() {
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(listOfUpdatedByColumn);
        verifyNotificationsTableIsSortedByStringColumnAscending(listOfUpdatedByColumn);
    }

    public void verifyNotificationsTableIsSortedByUpdatedByDescending() {
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(listOfUpdatedByColumn);
        verifyNotificationsTableIsSortedByStringColumnDescending(listOfUpdatedByColumn);
    }

    //Story TRUST-2595
    private Date getStartTime(){
        Date startDateTime = new Date();
        startDateTime.setTime(startDateTime.getTime() - (60*1000)); //start is (currentTime-1min)
        return startDateTime;
    }

    private Date getEndTime(){
        Date endDateTime = new Date();
        endDateTime.setTime(endDateTime.getTime() + (60*1000)); //end is (currentTime+1min)
        return endDateTime;
    }

    public void verifyCurrentDateWithTimezoneIsShown() {
        String currentTimeWithTimezone = $("//div[@class='ManageNotification_userTime_1eyg3']//div").getText();
        DateFormat dateFormat = new SimpleDateFormat("hh:mm a zzz");

        Date date = new Date();
        String currentTime = dateFormat.format(date);

        String startTime = dateFormat.format(getStartTime());
        String endTime = dateFormat.format(getEndTime());

        Log.info(startTime); // currentTime-1min
        Log.info(currentTime); //currentTime
        Log.info(endTime); //currentTime+1min
        Log.info(currentTimeWithTimezone); //time in the form

        Assert.assertTrue(currentTimeWithTimezone.equalsIgnoreCase(startTime)||currentTimeWithTimezone.equalsIgnoreCase(currentTime)
                ||currentTimeWithTimezone.equalsIgnoreCase(endTime));

    }
    
    public void checkNewNotificationButtonIsDisplayed() {
    	shouldBeVisible(newNotificationsButton);
    }
    
    public void checkNewNotificationButtonIsNotDisplayed() {
    	shouldNotBeVisible(newNotificationsButton);
    }
    
    public void checkManageTemplatesButtonIsDisplayed() {
    	shouldBeVisible(manageTemplatesButton);
    }
    
    public void checkManageTemplatesButtonIsNotDisplayed() {
    	shouldNotBeVisible(manageTemplatesButton);
    }
    
    public void clickNotificationByIndex(int notificationIndex) {
    	listOfCreationTimeColumn.get(notificationIndex-1).click();
    }
    
    public void checkCloneButtonIsDisplayed() {
    	shouldBeVisible(By.cssSelector("button[id*='clone-notification']")); 	
    }
    
    public void checkCloneButtonIsNotDisplayed() {
    	shouldNotBeVisible(By.cssSelector("button[id*='clone-notification']")); 	
    }
    
    public void checkDeleteNotificationButtonIsDisplayed() {
    	shouldBeVisible(deleteNotificationButton); 	
    }
    
    public void checkDeleteNotificationButtonIsNotDisplayed() {
    	shouldNotBeVisible(deleteNotificationButton); 	
    }
    
    public void verifyEditNotificationFormIsNotDisplayed() {
    	shouldNotBeVisible(By.cssSelector("#notification-form"));
    }

    public void clickEnabledCheckboxNotificationByMessage(String Message) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersNotifications).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere(the("Message", is(Message))).findElements(By.cssSelector("input[id*='enabled-checkbox']"));
        rowCells.get(0).click();
    }
}
