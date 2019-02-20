package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.CommonSteps;
import com.trust.cucumber.steps.NotificationPageSteps;
import com.trust.cucumber.util.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.aeonbits.owner.ConfigFactory;

import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class NotificationPageStepDef {
    private Environment testEnvironment  = ConfigFactory.create(Environment.class);

    @Steps
    private NotificationPageSteps notificationPageSteps;

    public String env = testEnvironment.env();
    public String username = testEnvironment.username();
    public String password = testEnvironment.password();
    public String url = testEnvironment.url_db();
    public String username_db = testEnvironment.username_db();
    public String password_db = testEnvironment.password_db();

    @Steps
    CommonSteps commonSteps;

    @When("^Notifications table contains columns$")
    public void displayNotificationsHeaders(List<String> arg) {
        notificationPageSteps.checkTableHeaders(arg);
    }

    @When("^Notifications page contains next quick filters$")
    public void displayQuickFiltersOnNotificationsPage(Map<String, String> arg) {
        notificationPageSteps.checkQuickMultipleFilters(arg);
    }

    @When("User clicks on Show more button on Recently updated quick filter$")
    public void clickOnShowMoreButtonOnRecentlyUpdatedQuickFilter() {
        notificationPageSteps.clickOnShowMoreButtonOnRecentlyUpdatedQuickFilter();
    }

    @Then("^'Recently updated' and 'Recently added' options are displayed$")
    public void verifyOptionsForRecentlyUpdatedQuickFilter() {
        notificationPageSteps.verifyOptionsForRecentlyUpdatedQuickFilter();
    }

    @When("User clicks on Show more button on Recently active quick filter$")
    public void clickOnShowMoreButtonOnRecentlyActiveQuickFilter() {
        notificationPageSteps.clickOnShowMoreButtonOnRecentlyActiveQuickFilter();
    }

    @Then("^'Recently active', 'Currently active' and 'Displaying now' options are displayed$")
    public void verifyOptionsForRecentlyActiveQuickFilter() {
        notificationPageSteps.verifyOptionsForRecentlyActiveQuickFilter();
    }

    @When("User clicks on Show more button on Public quick filter$")
    public void clickOnShowMoreButtonOnPublicQuickFilter() {
        notificationPageSteps.clickOnShowMoreButtonOnPublicQuickFilter();
    }

    @Then("^'Public' and 'All internal' options are displayed$")
    public void verifyOptionsForPublicQuickFilter() {
        notificationPageSteps.verifyOptionsForPublicQuickFilter();
    }

    @And("^Close list of options from quick filter$")
    public void closeQuickFilterOptions() {
        notificationPageSteps.closeQuickFilterOptions();
    }

    @When("User applies Recently updated quick filter$")
    public void applyRecentlyUpdatedQuickFilter() {
        notificationPageSteps.applyRecentlyUpdatedQuickFilter();
    }

    @Then("^Notifications updated within the last 24 hours are displayed$")
    public void verifyRecentlyUpdatedQuickFilterIsApplied() throws ParseException {
        notificationPageSteps.verifyRecentlyUpdatedQuickFilterIsApplied();
    }

    @When("User applies Recently added quick filter$")
    public void applyRecentlyAddedQuickFilter() {
        notificationPageSteps.applyRecentlyAddedQuickFilter();
    }

    @Then("^Notifications created within the last 24 hours are displayed$")
    public void verifyRecentlyAddedQuickFilterIsApplied() throws ParseException {
        notificationPageSteps.verifyRecentlyAddedQuickFilterIsApplied();
    }

    @When("User applies Currently active quick filter$")
    public void applyCurrentlyActiveQuickFilter() {
        notificationPageSteps.applyCurrentlyActiveQuickFilter();
    }

    @Then("^Notifications with the Event time range including the current time are displayed$")
    public void verifyCurrentlyActiveQuickFilterIsApplied() throws ParseException {
        notificationPageSteps.verifyCurrentlyActiveQuickFilterIsApplied();
    }

    @When("User applies Displaying now quick filter$")
    public void applyDisplayingNowQuickFilter() {
        notificationPageSteps.applyDisplayingNowQuickFilter();
    }

    @Then("^Notifications with the Show time range including the current time are displayed$")
    public void verifyDisplayingNowQuickFilterIsApplied() throws ParseException {
        notificationPageSteps.verifyDisplayingNowQuickFilterIsApplied();
    }

    @When("User applies My notifications quick filter$")
    public void applyMyNotificationsQuickFilter() {
        notificationPageSteps.applyMyNotificationsQuickFilter();
    }

    @Then("^Notifications created or updated by (.*) user are displayed$")
    public void verifyMyNotificationsQuickFilterIsApplied(String userName) {
        notificationPageSteps.verifyMyNotificationsQuickFilterIsApplied(userName);
    }

    @When("User applies Not auto-generated quick filter$")
    public void applyNotAutoGeneratedQuickFilter() {
        notificationPageSteps.applyNotAutoGeneratedQuickFilter();
    }

    @Then("^Not auto-generated notifications are displayed$")
    public void verifyNotAutoGeneratedQuickFilterIsApplied() {
        notificationPageSteps.verifyNotAutoGeneratedQuickFilterIsApplied();
    }

    @When("User applies Public quick filter$")
    public void applyPublicQuickFilter() {
        notificationPageSteps.applyPublicQuickFilter();
    }

    @Then("^Notifications with public Access level are displayed$")
    public void verifyPublicQuickFilterIsApplied() {
        notificationPageSteps.verifyPublicQuickFilterIsApplied();
    }

    @When("User applies All internal filter$")
    public void applyAllInternalQuickFilter() {
        notificationPageSteps.applyAllInternalQuickFilter();
    }

    @Then("^Notifications with Admin/Internal/GPT Access level are displayed$")
    public void verifyAllInternalQuickFilterIsApplied() {
        notificationPageSteps.verifyAllInternalQuickFilterIsApplied();
    }

    @When("^User clicks on Manage templates button on Notifications page$")
    public void clickOnManageTemplatesButton() {
        notificationPageSteps.clickOnManageTemplatesButton();
    }

    @Then("^Notification templates page is opened$")
    public void verifyNotificationTemplatesPageIsOpened() {
        notificationPageSteps.verifyNotificationTemplatesPageIsOpened();
    }

    @When("^Notification templates table contains columns$")
    public void displayTemplatesHeaders(List<String> arg) {
        notificationPageSteps.checkTableHeaders(arg);
    }

    @When("^User clicks on New template button$")
    public void clickOnNewTemplateButton() {
        notificationPageSteps.clickOnNewTemplateButton();
    }

    @Then("^Add template pop-up is displayed$")
    public void verifyAddTemplatesPopUpIsOpened() {
        notificationPageSteps.verifyAddTemplatesPopUpIsOpened();
    }

    @When("^User fills in all required fields and saves new template$")
    public void populateNewTemplateFields() {
        notificationPageSteps.switchedEnabledToggle();
        notificationPageSteps.populateNewNotificationTemplateFields("autoTemplate", "Created template");
        notificationPageSteps.clickOkModalButtonIfItIsDisplayed();
    }

    @Then("^Template (.*) is displayed in the table$")
    public void checkTemplateInTable(String templateName) {
        notificationPageSteps.checkTemplateInTable(templateName);
    }

    @When("^User clicks on template (.*) in the table$")
    public void selectTemplateByName(String templateName) {
        notificationPageSteps.selectTemplateByName(templateName);
    }

    @Then("^Update template form is displayed$")
    public void verifyUpdateTemplatePopUpIsOpened() {
        notificationPageSteps.verifyUpdateTemplatePopUpIsOpened();
    }

    @When("^User adds (.*) to Name and Message fields and saves the template$")
    public void updateTemplateNameMessageFields(String update) {
        notificationPageSteps.updateTemplateNameMessageFields(update);
        notificationPageSteps.clickOkModalButtonIfItIsDisplayed();
    }

    @Then("^\"None\" is displayed by default in the template dropdown$")
    public void verifyDefaultValueInTemplateDropdown() {
        notificationPageSteps.verifyDefaultValueInTemplateDropdown();
    }

    @When("^User selects template autoTemplateEdited in the template dropdown$")
    public void selectTemplateInCreateNotificationForm() {
        notificationPageSteps.selectTemplateInCreateNotificationForm();
    }

    @Then("^Created templateEdited text is displayed in the Message field$")
    public void verifyMessageForSetTemplate() {
        notificationPageSteps.verifyMessageForSetTemplate();
    }

    @And("^User discards changes$")
    public void discardChanges() {
        notificationPageSteps.clickCancelButton();
        commonSteps.clickProceedButton();
    }

    @When("^User deletes (.*) template from the table$")
    public void deleteTemplateByName(String templateName) {
        notificationPageSteps.deleteTemplateByName(templateName);
        commonSteps.clickProceedButton();
    }

    @Then("^Template (.*) is removed from table$")
    public void verifyTemplateIsDeleted(String templateName) {
        notificationPageSteps.verifyTemplateIsDeleted(templateName);
    }

    @When("^User verifies that there is no template (.*)$")
    public void verifyThereIsNoTemplate(String templateName) {
        notificationPageSteps.verifyThereIsNoTemplateByName(templateName);
    }

    @When("^User clicks on Back button$")
    public void clickOnBackButton() {
        notificationPageSteps.clickOnBackButton();
    }

    @When("^User clicks on New Notification button on Notifications page$")
    public void clickOnNewNotification() {
        notificationPageSteps.clickOnNewNotification();
    }

    @Then("^Create Notification pop-up is displayed$")
    public void verifyCreateNotificationsPopUpDisplaying() {
        notificationPageSteps.verifyCreateNotificationPopUpIsOpened();
    }

    @When("^User fills in all required fields in Create Notification pop-up, set Event type and saves new notification$")
    public void fellRequiredFieldsNewNotification(Map<String, String> arg) {
        notificationPageSteps.populateNewNotificationFields(arg, 4);
        notificationPageSteps.switchedOverrideToggle();
        notificationPageSteps.clickOnSaveAndCloseButton();
        notificationPageSteps.clickOkModalButtonIfItIsDisplayed();
    }

    @When("^User fills in all required fields in Create Notification pop-up, set PM Event type and saves new notification$")
    public void fellRequiredFieldsNewPMNotification(Map<String, String> arg) {
        notificationPageSteps.populateNewNotificationFields(arg, 1);
        notificationPageSteps.clickOnSaveAndCloseButton();
        notificationPageSteps.clickOkModalButtonIfItIsDisplayed();
    }

    @Then("^Notification (.*) is displayed in the table$")
    public void verifyNewNotificationCreated(String Message) {
        notificationPageSteps.verifyNewNotificationCreated(Message);
    }

    @When("^User clicks on (.*) notification in the table$")
    public void selectNotificationByMessage(String Message) {
        notificationPageSteps.selectNotificationByMessage(Message);
    }

    @Then("^Edit Notification form is displayed$")
    public void verifyEditNotificationPopUpIsOpened() {
        notificationPageSteps.verifyEditNotificationPopUpIsOpened();
    }

    @Then("^Admin has opened Edit Notification form Splash or SH Page$")
    public void verifyEditNotificationPopUpIsOpenedFromSplash() {
        notificationPageSteps.verifyEditNotificationPopUpIsOpenedFromSplash();
    }


    @When("^User selects system with name (.*) for notification$")
    public void selectSystemByNumber(String system) {
        notificationPageSteps.deleteSelectedSystem();
        notificationPageSteps.selectSystemByName(system);
    }

    @When("^User adds system with name (.*) for notification$")
    public void addSystemByNumber(String system) {
        notificationPageSteps.selectSystemByName(system);
    }

    @And("^User adds (.*) to Message field$")
    public void updateNotificationMessageField(String message) {
        notificationPageSteps.clearMessageTextBoxOnCreateNotificationForm();
        notificationPageSteps.updateNotificationMessageField(message);
    }

    @And("^User saves updates$")
    public void saveChanges() {
        notificationPageSteps.clickOnSaveAndCloseButton();
        notificationPageSteps.clickOkModalButtonIfItIsDisplayed();
    }

    @When("^User deletes (.*) notification from the table$")
    public void deleteNotificationByMessage(String Message) {
        notificationPageSteps.deleteNotificationByMessage(Message);
        commonSteps.clickProceedButton();
    }

    @Then("^Notification (.*) is removed from table$")
    public void verifyNotificationIsDeleted(String Message) {
        notificationPageSteps.verifyNotificationIsDeleted(Message);
    }

    @When("^User clicks on Clone notification button for notification$")
    public void clickCloneNotificationButtonByMessage() {
        notificationPageSteps.clickCloneNotificationButtonByMessage();
    }

    @When("^User selects (\\d+) notifications per page$")
    public void setNotificationsPerPage(int notificationsPerPage) {
        notificationPageSteps.setNotificationsPerPage(notificationsPerPage);
    }

    @Then("^(\\d+) notifications are displayed on the page$")
    public void verifyAmountOfNotificationsPerPage(int notificationsPerPage) {
        notificationPageSteps.verifyAmountOfNotificationsPerPage(notificationsPerPage);
    }

    @And("^User resets the table to default state$")
    public void resetToDefaultState() {
        notificationPageSteps.clickOnClearButton();
    }

    @And("^User resets the table to default state and set 5 rows per page$")
    public void resetToDefaultStateAndSet5NotificationsPerPage() {
        notificationPageSteps.clickOnClearButton();
        notificationPageSteps.setNotificationsPerPage(5);
    }

    @When("^User navigates to next page$")
    public void navigateToNextPage() {
        notificationPageSteps.clickOnNextPageButton();
    }

    @Then("^Second page is displayed$")
    public void verifySecondPageIsDisplayed() {
        notificationPageSteps.verifySecondPageIsDisplayed();
    }

    @When("^User navigates to previous page$")
    public void navigateToPreviousPage() {
        notificationPageSteps.clickOnPreviousPageButton();
    }

    @When("^User navigates to last page$")
    public void navigateToLastPage() {
        notificationPageSteps.clickOnLastPageButton();
    }

    @Then("^Last page is displayed$")
    public void verifyLastPageIsDisplayed() {
        notificationPageSteps.verifyLastPageIsDisplayed();
    }

    @And("^Next page and Last page buttons are disabled$")
    public void verifyDisabledButtonsForLastPage(){
        notificationPageSteps.verifyNextPageButtonIsDisabled();
        notificationPageSteps.verifyLastPageButtonIsDisabled();
    }

    @When("^User navigates to first page$")
    public void navigateToFirstPage() {
        notificationPageSteps.clickOnFirstPageButton();
    }

    @Then("^First page is displayed$")
    public void verifyFirstPageIsDisplayed() {
        notificationPageSteps.verifyFirstPageIsDisplayed();
    }

    @And("^First page and Previous page buttons are disabled$")
    public void verifyDisabledButtonsForFirstPage(){
        notificationPageSteps.verifyFirstPageButtonIsDisabled();
        notificationPageSteps.verifyPreviousPageButtonIsDisabled();
    }

    @And("^First page and Previous page buttons are enabled$")
    public void verifyEnabledButtonsForSecondPage(){
        notificationPageSteps.verifyFirstPageButtonIsEnabled();
        notificationPageSteps.verifyPreviousPageButtonIsEnabled();
    }

    @When("^User clears previously downloaded files$")
    public void clearPreviouslyDownloadedFiles() {
        notificationPageSteps.clearPreviouslyDownloadedFiles();
    }

    @And("^User clicks on export to CSV button$")
    public void clickOnExportToCSVButton() {
        notificationPageSteps.clickOnExportToCSVButton();
    }

    @Then("^CSV file with notifications is downloaded$")
    public void verifyCSVFileIsDownloaded() {
        notificationPageSteps.verifyCSVFileIsDownloaded();
    }

    @And("^User removes the downloaded file$")
    public void removeDownloadedCSVFile() {
        notificationPageSteps.clearPreviouslyDownloadedFiles();
    }

    @When("^User filters Notification table by (.*) system$")
    public void setFilterBySystem(String systemName) {
        notificationPageSteps.setValueToSystemDropDown(systemName);
    }

    @Then("^Notifications for (.*) system only are displayed in the table$")
    public void verifyNotificationsAreFilteredBySystem(String systemName) {
        notificationPageSteps.verifyNotificationsAreFilteredBySystem(systemName);
    }

    @When("^User set \"Public\" value to \"Access Level\" dropdown on Notifications page$")
    public void setFilterByPublicAccessLevel() {
        notificationPageSteps.setValueToAccessLevelDropDown(3);
    }

    @Then("^Notifications with public access level only are displayed in the table$")
    public void verifyNotificationsAreFilteredByPublicAccessLevel() {
        notificationPageSteps.verifyNotificationsAreFilteredByPublicAccessLevel();
    }

    @When("^User filters Notification table by Creation time column by current day$")
    public void setFilterByCreationTimeColumn() {
        notificationPageSteps.setValueToCreationTimeColumn();
    }

    @Then("^Created today notifications are displayed in the table$")
    public void verifyCreatedTodayNotificationsAreDisplayed() {
        notificationPageSteps.verifyCreatedTodayNotificationsAreDisplayed();
    }

    @When("^User filters Notification table by Last updated column by current day$")
    public void setFilterByLastUpdatedColumn() {
        notificationPageSteps.setValueToLastUpdatedColumn();
    }

    @Then("^Updated today notifications are displayed in the table$")
    public void verifyUpdatedTodayNotificationsAreDisplayed() {
        notificationPageSteps.verifyUpdatedTodayNotificationsAreDisplayed();
    }

    @When("^User filters Notification table by Event start time column by current day$")
    public void setFilterByEventStartTimeColumn() {
        notificationPageSteps.setValueToEventStartTimeColumn();
    }

    @Then("^Started today notifications are displayed in the table$")
    public void verifyStartedTodayNotificationsAreDisplayed() {
        notificationPageSteps.verifyStartedTodayNotificationsAreDisplayed();
    }

    @When("^User filters Notification table by Event end time column by Unknown$")
    public void setUnknownValueToEventEndTimeColumn() {
        notificationPageSteps.setUnknownValueToEventEndTimeColumn();
    }

    @Then("^Notifications with unknown event end time are displayed in the table$")
    public void verifyNotificationsWithUnknownEventEndTimeAreDisplayed() {
        notificationPageSteps.verifyNotificationsWithUnknownEventTimeAreDisplayed();
    }

    @When("^User filters Notification table by Event end time column by current day$")
    public void setFilterByEventEndTimeColumn() {
        notificationPageSteps.setValueToEventEndTimeColumn();
    }

    @Then("^Ended today notifications are displayed in the table$")
    public void verifyEndedTodayNotificationsAreDisplayed() {
        notificationPageSteps.verifyEndedTodayNotificationsAreDisplayed();
    }

    @When("^User filters Notification table by Created by column by (.*) user$")
    public void setFilterByCreatedByColumn(String userName) {
        notificationPageSteps.setValueToCreatedByColumn(userName);
    }

    @Then("^Notifications created by (.*) user are displayed in the table$")
    public void verifyNotificationsCreatedBySelectedUserAreDisplayed(String userName) {
        notificationPageSteps.verifyNotificationsCreatedBySelectedUserAreDisplayed(userName);
    }

    @When("^User filters Notification table by Updated by column by (.*) user$")
    public void setFilterByUpdatedByColumn(String userName) {
        notificationPageSteps.setValueToUpdatedByColumn(userName);
    }

    @Then("^Notifications updated by (.*) user are displayed in the table$")
    public void verifyNotificationsUpdatedBySelectedUserAreDisplayed(String userName) {
        notificationPageSteps.verifyNotificationsUpdatedBySelectedUserAreDisplayed(userName);
    }

    @When("^User filters Notification table by (\\d+) event type$")
    public void setFilterByEventType(int eventType) {
        notificationPageSteps.setValueToEventTypeFilter(eventType);
    }

    @Then("^Notifications with (.*) event type are displayed in the table$")
    public void verifyNotificationsWithSelectedEventTypeAreDisplayed(String eventType) {
        notificationPageSteps.verifyNotificationsWithSelectedEventTypeAreDisplayed(eventType);
    }

    @When("^User filters Notification table by (.*) message")
    public void setFilterByMessageColumn(String message) {
        notificationPageSteps.setValueToMessageColumn(message);
    }

    @Then("^Notifications with (.*) messages are displayed in the table$")
    public void verifyNotificationsWithSelectedMessageAreDisplayed(String message) {
        notificationPageSteps.verifyNotificationsWithSelectedMessageAreDisplayed(message);
    }

    @When("^User opens \"Select displayed columns\" pop-up$")
    public void openSelectDisplayedColumnsPopUp() {notificationPageSteps.openSelectDisplayedColumnsPopUp();}

    @And("^User deselects (\\d+) column in the \"Select displayed columns\" pop-up$")
    public void deselectColumnInSelectDisplayedColumnsPopUpByIndex(int n) {notificationPageSteps.deselectColumnInSelectDisplayedColumnsPopUpByIndex(n);}

    @Then("^Deselected (.*) column is not displayed in the table$")
    public void verifyDeselectedColumnIsNotDisplayed(String columnName) {notificationPageSteps.verifyDeselectedColumnIsNotDisplayed(columnName);}

    @Then("^Notifications table is sorted by Creation time column in ascending order$")
    public void verifyNotificationsTableIsSortedByCreationTimeAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByCreationTimeAscending();}

    @Then("^Notifications table is sorted by Creation time column in descending order$")
    public void verifyNotificationsTableIsSortedByCreationTimeDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByCreationTimeDescending();}

    @Then("^Notifications table is sorted by Last updated column in ascending order$")
    public void verifyNotificationsTableIsSortedByLastUpdatedAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByLastUpdatedAscending();}

    @Then("^Notifications table is sorted by Last updated column in descending order$")
    public void verifyNotificationsTableIsSortedByLastUpdatedDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByLastUpdatedDescending();}

    //EventStartTime
    @Then("^Notifications table is sorted by Event start time column in ascending order$")
    public void verifyNotificationsTableIsSortedByEventStartTimedAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByEventStartTimeAscending();}

    @Then("^Notifications table is sorted by Event start time column in descending order$")
    public void verifyNotificationsTableIsSortedByEventStartTimeDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByEventStartTimeDescending();}

    //EventEndTime Event end time
    @Then("^Notifications table is sorted by Event end time column in ascending order$")
    public void verifyNotificationsTableIsSortedByEventEndTimedAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByEventEndTimeAscending();}

    @Then("^Notifications table is sorted by Event end time column in descending order$")
    public void verifyNotificationsTableIsSortedByEventEndTimeDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByEventEndTimeDescending();}

    @When("^Scroll Notification table to Message column$")
    public void scrollToMessageColumn() {notificationPageSteps.scrollToMessageColumn();}

    //Show start time ShowStartTime
    @Then("^Notifications table is sorted by Show start time column in ascending order$")
    public void verifyNotificationsTableIsSortedByShowStartTimedAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByShowStartTimeAscending();}

    @Then("^Notifications table is sorted by Show start time column in descending order$")
    public void verifyNotificationsTableIsSortedByShowStartTimeDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByShowStartTimeDescending();}

    //ShowEndTime Show end time

    @Then("^Notifications table is sorted by Show end time time column in ascending order$")
    public void verifyNotificationsTableIsSortedByShowEndTimedAscending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByShowEndTimeAscending();}

    @Then("^Notifications table is sorted by Show end time column in descending order$")
    public void verifyNotificationsTableIsSortedByShowEndTimeDescending() throws ParseException {notificationPageSteps.verifyNotificationsTableIsSortedByShowEndTimeDescending();}

    //Created by
    @Then("^Notifications table is sorted by Created by column in ascending order$")
    public void verifyNotificationsTableIsSortedByCreatedByAscending() {notificationPageSteps.verifyNotificationsTableIsSortedByCreatedByAscending();}

    @Then("^Notifications table is sorted by Created by column in descending order$")
    public void verifyNotificationsTableIsSortedByCreatedByDescending() {notificationPageSteps.verifyNotificationsTableIsSortedByCreatedByDescending();}

    //Updated by
    @Then("^Notifications table is sorted by Updated by column in ascending order$")
    public void verifyNotificationsTableIsSortedByUpdatedByAscending() {notificationPageSteps.verifyNotificationsTableIsSortedByUpdatedByAscending();}

    @Then("^Notifications table is sorted by Updated by column in descending order$")
    public void verifyNotificationsTableIsSortedByUpdatedByDescending() {notificationPageSteps.verifyNotificationsTableIsSortedByUpdatedByDescending();}

    @Then("^Current date with timezone is shown above the dates and times block$")
    public void verifyCurrentDateWithTimezoneIsShown() {notificationPageSteps.verifyCurrentDateWithTimezoneIsShown();}
    
    @Then("^New Notification button is displayed$")
    public void checkNewNotificationButtonIsDisplayed() {
    	notificationPageSteps.checkNewNotificationButtonIsDisplayed();
    }
    
    @Then("^New Notification button isn't displayed$")
    public void checkNewNotificationButtonIsNotDisplayed() {
    	notificationPageSteps.checkNewNotificationButtonIsNotDisplayed();
    }
    
    @Then("^Manage Templates button is displayed$")
    public void checkManageTemplatesButtonIsDisplayed() {
    	notificationPageSteps.checkManageTemplatesButtonIsDisplayed();
    }
    
    @Then("^Manage Templates button isn't displayed$")
    public void checkManageTemplatesButtonIsNotDisplayed() {
    	notificationPageSteps.checkManageTemplatesButtonIsNotDisplayed();
    }
    
    @Then("^Clone Notification button is displayed$")
    public void checkCloneNotificationButtonIsDisplayed() {
    	notificationPageSteps.checkCloneNotificationButtonIsDisplayed();
    }
    
    @Then("^Clone Notification button isn't displayed$")
    public void checkCloneNotificationButtonIsNotDisplayed() {
    	notificationPageSteps.checkCloneNotificationButtonIsNotDisplayed();
    }
    
    @Then("^Delete Notification button is displayed$")
    public void checkDeleteNotificationButtonIsDisplayed() {
    	notificationPageSteps.checkDeleteNotificationButtonIsDisplayed();
    }
    
    @Then("^Delete Notification button isn't displayed$")
    public void checkDeleteNotificationButtonIsNotDisplayed() {
    	notificationPageSteps.checkDeleteNotificationButtonIsNotDisplayed();
    }
    
    @When("^User clicks notification number (.*) in the table$")
    public void clickNotificationByIndex(int index) {
    	notificationPageSteps.clickNotificationByIndex(index);
    }
    
    @Then("^Edit Notification form isn't displayed$")
    public void checkEditNotificationFormIsNotDisplayed() {
    	notificationPageSteps.checkEditNotificationFormIsNotDisplayed();
    }

    @When("^User disables (.*) notification$")
    public void disableNotificationByMessage(String Message) {
        notificationPageSteps.clickEnabledCheckboxNotificationByMessage(Message);
    }

    @When("^User enables (.*) notification$")
    public void enablesNotificationByMessage(String Message) {
        notificationPageSteps.clickEnabledCheckboxNotificationByMessage(Message);
    }

    @Then("^(.*) is (.*) for (\\d+) monitor in db$")
    public void verifyBlackoutValueForMonitor(String column, String value, int monitor) throws Throwable {
        notificationPageSteps.verifyBlackoutValueForMonitor(column, value, monitor,url,username_db,password_db);
    }

    @Then("^(.*) is not null for (\\d+) monitor in the db$")
    public void verifyBlackoutValueNotNullForMonitor(String column, int monitor) throws Throwable {
        notificationPageSteps.verifyBlackoutValueNotNullForMonitor(column, monitor,url,username_db,password_db);
    }

    @Then("^(.*) is null for (\\d+) monitor in the db$")
    public void verifyBlackoutValueNullForMonitor(String column, int monitor) throws Throwable {
        notificationPageSteps.verifyBlackoutValueNullForMonitor(column, monitor,url,username_db,password_db);
    }

    @When("^User changes Event Type from PM to Possible disruption$")
    public void changeEventTypeFromPMToPossibleDisruption(){
        notificationPageSteps.changeEventTypeFromPMToPossibleDisruption();
    }

    @And("^User changes Event Type from Possible disruption to PM$")
    public void changeEventTypeFromPossibleDisruptionToPM(){
        notificationPageSteps.changeEventTypeFromPossibleDisruptionToPM();
    }

    @And("^User sets Event start and Event end times in the past$")
    public void setEventStartEndTimesInThePast(){
        notificationPageSteps.setEventStartEndTimesInThePast();
    }

    @And("^User sets Event start and Event end times in the future$")
    public void setEventStartEndTimesInTheFuture(){
        notificationPageSteps.setEventStartEndTimesInTheFuture();
    }
}