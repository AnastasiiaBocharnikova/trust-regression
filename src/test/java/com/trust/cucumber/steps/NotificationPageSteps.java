package com.trust.cucumber.steps;

import com.trust.cucumber.pages.NotificationPage;
import com.trust.cucumber.util.ConnectToDB;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class NotificationPageSteps {

    private NotificationPage notificationPage;
    private ConnectToDB connectToDB;

    @Step
    public void checkTableHeaders(List<String> expectedHeaders) {
        List<String> actualHeaders = notificationPage.getHeadersFromTable();
        expectedHeaders.forEach(name -> Assert.assertTrue(actualHeaders.contains(name)));
    }

    @Step
    public void checkQuickMultipleFilters(Map<String, String> expectedQuickFilters) {
        notificationPage.verifyQuickMultipleFilters(expectedQuickFilters);
    }

    @Step
    public void clickOnShowMoreButtonOnRecentlyUpdatedQuickFilter() {
        notificationPage.clickOnShowMoreButtonQuickFilter(0);
    }

    @Step
    public void verifyOptionsForRecentlyUpdatedQuickFilter() {
        notificationPage.verifyOptionsForRecentlyUpdatedQuickFilter();
    }

    @Step
    public void clickOnShowMoreButtonOnRecentlyActiveQuickFilter() {
        notificationPage.clickOnShowMoreButtonQuickFilter(1);
    }

    @Step
    public void verifyOptionsForRecentlyActiveQuickFilter() {
        notificationPage.verifyOptionsForRecentlyActiveQuickFilter();
    }

    @Step
    public void clickOnShowMoreButtonOnPublicQuickFilter() {
        notificationPage.clickOnShowMoreButtonQuickFilter(2);
    }

    @Step
    public void verifyOptionsForPublicQuickFilter() {
        notificationPage.verifyOptionsForPublicQuickFilter();
    }

    @Step
    public void closeQuickFilterOptions() {
        notificationPage.closeQuickFilterOptions();
    }

    @Step
    public void applyRecentlyUpdatedQuickFilter() {
        notificationPage.applyRecentlyUpdatedQuickFilter();
    }

    @Step
    public void verifyRecentlyUpdatedQuickFilterIsApplied() throws ParseException {
        notificationPage.verifyRecentlyUpdatedQuickFilterIsApplied();
    }

    @Step
    public void applyRecentlyAddedQuickFilter() {
        notificationPage.applyRecentlyAddedQuickFilter();
    }

    @Step
    public void verifyRecentlyAddedQuickFilterIsApplied() throws ParseException {
        notificationPage.verifyRecentlyAddedQuickFilterIsApplied();
    }

    @Step
    public void applyCurrentlyActiveQuickFilter() {
        notificationPage.applyCurrentlyActiveQuickFilter();
    }

    @Step
    public void verifyCurrentlyActiveQuickFilterIsApplied() throws ParseException {
        notificationPage.verifyCurrentlyActiveQuickFilterIsApplied();
    }

    @Step
    public void applyDisplayingNowQuickFilter() {
        notificationPage.applyDisplayingNowQuickFilter();
    }

    @Step
    public void verifyDisplayingNowQuickFilterIsApplied() throws ParseException {
        notificationPage.verifyDisplayingNowQuickFilterIsApplied();
    }

    @Step
    public void applyMyNotificationsQuickFilter() {
        notificationPage.applyMyNotificationsQuickFilter();
    }

    @Step
    public void verifyMyNotificationsQuickFilterIsApplied(String userName) {
        notificationPage.verifyMyNotificationsQuickFilterIsApplied(userName);
    }

    @Step
    public void applyNotAutoGeneratedQuickFilter() {
        notificationPage.applyNotAutoGeneratedQuickFilter();
    }

    @Step
    public void verifyNotAutoGeneratedQuickFilterIsApplied() {
        notificationPage.verifyNotAutoGeneratedQuickFilterIsApplied();
    }

    @Step
    public void applyPublicQuickFilter() {
        notificationPage.applyPublicQuickFilter();
    }

    @Step
    public void verifyPublicQuickFilterIsApplied() {
        notificationPage.verifyPublicQuickFilterIsApplied();
    }

    @Step
    public void applyAllInternalQuickFilter() {
        notificationPage.applyAllInternalQuickFilter();
    }

    @Step
    public void verifyAllInternalQuickFilterIsApplied() {
        notificationPage.verifyAllInternalQuickFilterIsApplied();
    }

    @Step
    public void clickOnManageTemplatesButton() {
        notificationPage.clickOnManageTemplatesButton();
    }

    @Step
    public void verifyNotificationTemplatesPageIsOpened() {
        notificationPage.verifyNotificationTemplatesPageIsOpened();
    }

    @Step
    public void clickOnNewTemplateButton() {
        notificationPage.clickOnNewTemplateButton();
    }

    @Step
    public void verifyAddTemplatesPopUpIsOpened() {
        notificationPage.verifyAddTemplatesPopUpIsOpened();
    }

    @Step
    public void switchedEnabledToggle() {
        notificationPage.switchedEnabledToggle();
    }

    @Step
    public void populateNewNotificationTemplateFields(String name, String message) {
        notificationPage.populateNewNotificationTemplateFields(name, message);
    }

    @Step
    public void clickOkModalButtonIfItIsDisplayed() {
        notificationPage.clickOkModalButtonIfItIsDisplayed();
    }

    @Step
    public void checkTemplateInTable(String templateName) {
        notificationPage.checkTemplateInTable(templateName);
    }

    @Step
    public void selectTemplateByName(String templateName) {
        notificationPage.selectTemplateByName(templateName);
    }

    @Step
    public void verifyUpdateTemplatePopUpIsOpened() {
        notificationPage.verifyUpdateTemplatePopUpIsOpened();
    }

    @Step
    public void updateTemplateNameMessageFields(String update) {
        notificationPage.updateTemplateNameMessageFields(update);
    }

    @Step
    public void verifyDefaultValueInTemplateDropdown() {
        notificationPage.verifyDefaultValueInTemplateDropdown();
    }

    @Step
    public void selectTemplateInCreateNotificationForm() {
        notificationPage.selectTemplateInCreateNotificationForm();
    }

    @Step
    public void verifyMessageForSetTemplate() {
        notificationPage.verifyMessageForSetTemplate();
    }

    @Step
    public void deleteTemplateByName(String templateName) {
        notificationPage.deleteTemplateByName(templateName);
    }

    @Step
    public void verifyTemplateIsDeleted(String templateName) {
        notificationPage.verifyTemplateIsDeleted(templateName);
    }

    @Step
    public void verifyThereIsNoTemplateByName(String templateName) {
        notificationPage.verifyThereIsNoTemplateByName(templateName);
    }

    @Step
    public void clickOnBackButton() {
        notificationPage.clickOnBackButton();
    }

    @Step
    public void clickOnNewNotification() {
        notificationPage.clickOnNewNotification();
    }

    @Step
    public void verifyCreateNotificationPopUpIsOpened() {
        notificationPage.verifyCreateNotificationPopUpIsOpened();
    }

    @Step
    public void switchedOverrideToggle() {
        notificationPage.switchedOverrideToggle();
    }

    @Step
    public void populateNewNotificationFields(Map<String, String> fields, int type) {
        notificationPage.populateNewNotificationFields(fields, type);
    }

    @Step
    public void clickOnSaveAndCloseButton() {
        notificationPage.clickOnSaveAndCloseButton();
    }

    @Step
    public void verifyNewNotificationCreated(String Message) {
        notificationPage.verifyNewNotificationCreated(Message);
    }

    @Step
    public void selectNotificationByMessage(String Message) {

        notificationPage.selectNotificationByMessage(Message);
    }

    @Step
    public void deleteSelectedSystem() {
        notificationPage.deleteSelectedSystem();
    }

    @Step
    public void selectSystemByName(String system) {
        notificationPage.selectSystem(system);
    }

    @Step
    public void verifyEditNotificationPopUpIsOpened() {
        notificationPage.verifyEditNotificationPopUpIsOpened();
    }

    @Step
    public void verifyEditNotificationPopUpIsOpenedFromSplash() {
        notificationPage.verifyEditNotificationPopUpIsOpenedFromSplash();
    }

    @Step
    public void updateNotificationMessageField(String message) {
        notificationPage.updateNotificationMessageField(message);
    }

    @Step
    public void clearMessageTextBoxOnCreateNotificationForm() {
        notificationPage.clearMessageTextBoxOnCreateNotificationForm();
    }

    @Step
    public void deleteNotificationByMessage(String message) {
        notificationPage.deleteNotificationByMessage(message);
    }

    @Step
    public void clickCancelButton() {
        notificationPage.clickCancelButton();
    }

    @Step
    public void verifyNotificationIsDeleted(String message) {
        notificationPage.verifyNotificationIsDeleted(message);
    }

    @Step
    public void clickCloneNotificationButtonByMessage() {
        notificationPage.clickCloneNotificationButtonByMessage();
    }

    @Step
    public void setNotificationsPerPage(int notificationsPerPage) {
        notificationPage.setNotificationsPerPage(notificationsPerPage);
    }

    @Step
    public void verifyAmountOfNotificationsPerPage(int notificationsPerPage) {
        notificationPage.verifyAmountOfNotificationsPerPage(notificationsPerPage);
    }

    @Step
    public void clickOnClearButton() {
        notificationPage.clickOnClearButton();
    }

    @Step
    public void clickOnNextPageButton() {
        notificationPage.clickOnNextPageButton();
    }

    @Step
    public void verifySecondPageIsDisplayed() {
        notificationPage.verifySecondPageIsDisplayed();
    }

    @Step
    public void clickOnPreviousPageButton() {
        notificationPage.clickOnPreviousPageButton();
    }

    @Step
    public void clickOnLastPageButton() {
        notificationPage.clickOnLastPageButton();
    }

    @Step
    public void verifyLastPageIsDisplayed() {
        notificationPage.verifyLastPageIsDisplayed();
    }

    @Step
    public void clickOnFirstPageButton() {
        notificationPage.clickOnFirstPageButton();
    }

    @Step
    public void verifyFirstPageIsDisplayed() {
        notificationPage.verifyFirstPageIsDisplayed();
    }

    @Step
    public void verifyNextPageButtonIsDisabled() {
        notificationPage.verifyNextPageButtonIsDisabled();
    }

    @Step
    public void verifyLastPageButtonIsDisabled() {
        notificationPage.verifyLastPageButtonIsDisabled();
    }

    @Step
    public void verifyFirstPageButtonIsDisabled() {
        notificationPage.verifyFirstPageButtonIsDisabled();
    }

    @Step
    public void verifyPreviousPageButtonIsDisabled() {
        notificationPage.verifyPreviousPageButtonIsDisabled();
    }

    @Step
    public void verifyFirstPageButtonIsEnabled() {
        notificationPage.verifyFirstPageButtonIsEnabled();
    }

    @Step
    public void verifyPreviousPageButtonIsEnabled() {
        notificationPage.verifyPreviousPageButtonIsEnabled();
    }

    @Step
    public void clickOnExportToCSVButton() {
        notificationPage.clickOnExportToCSVButton();
    }

    @Step
    public void verifyCSVFileIsDownloaded() {
        notificationPage.verifyCSVFileIsDownloaded();
    }

    @Step
    public void clearPreviouslyDownloadedFiles() {
        notificationPage.clearPreviouslyDownloadedFiles();
    }

    @Step
    public void setValueToSystemDropDown(String systemName) {
        notificationPage.setValueToSystemDropDown(systemName);
    }

    @Step
    public void verifyNotificationsAreFilteredBySystem(String systemName) {
        notificationPage.verifyNotificationsAreFilteredBySystem(systemName);
    }

    @Step
    public void setValueToAccessLevelDropDown(int accessLevel) {
        notificationPage.setValueToAccessLevelDropDown(accessLevel);
    }

    @Step
    public void verifyNotificationsAreFilteredByPublicAccessLevel() {
        notificationPage.verifyNotificationsAreFilteredByPublicAccessLevel();
    }

    @Step
    public void setValueToCreationTimeColumn() {
        notificationPage.setValueToCreationTimeColumn();
    }

    @Step
    public void verifyCreatedTodayNotificationsAreDisplayed() {
        notificationPage.verifyCreatedTodayNotificationsAreDisplayed();
    }

    @Step
    public void setValueToLastUpdatedColumn() {
        notificationPage.setValueToLastUpdatedColumn();
    }

    @Step
    public void verifyUpdatedTodayNotificationsAreDisplayed() {
        notificationPage.verifyUpdatedTodayNotificationsAreDisplayed();
    }

    @Step
    public void setValueToEventStartTimeColumn() {
        notificationPage.setValueToEventStartTimeColumn();
    }

    @Step
    public void verifyStartedTodayNotificationsAreDisplayed() {
        notificationPage.verifyStartedTodayNotificationsAreDisplayed();
    }

    @Step
    public void setUnknownValueToEventEndTimeColumn() {
        notificationPage.setUnknownValueToEventEndTimeColumn();
    }

    @Step
    public void verifyNotificationsWithUnknownEventTimeAreDisplayed() {
        notificationPage.verifyNotificationsWithUnknownEventTimeAreDisplayed();
    }

    @Step
    public void setValueToEventEndTimeColumn() {
        notificationPage.setValueToEventEndTimeColumn();
    }

    @Step
    public void verifyEndedTodayNotificationsAreDisplayed() {
        notificationPage.verifyEndedTodayNotificationsAreDisplayed();
    }

    @Step
    public void setValueToCreatedByColumn(String userName) {
        notificationPage.setValueToCreatedByColumn(userName);
    }

    @Step
    public void verifyNotificationsCreatedBySelectedUserAreDisplayed(String userName) {
        notificationPage.verifyNotificationsCreatedBySelectedUserAreDisplayed(userName);
    }

    @Step
    public void setValueToUpdatedByColumn(String userName) {
        notificationPage.setValueToUpdatedByColumn(userName);
    }

    @Step
    public void verifyNotificationsUpdatedBySelectedUserAreDisplayed(String userName) {
        notificationPage.verifyNotificationsUpdatedBySelectedUserAreDisplayed(userName);
    }

    @Step
    public void setValueToEventTypeFilter(int eventType) {
        notificationPage.setValueToEventTypeFilter(eventType);
    }

    @Step
    public void verifyNotificationsWithSelectedEventTypeAreDisplayed(String eventType) {
        notificationPage.verifyNotificationsWithSelectedEventTypeAreDisplayed(eventType);
    }

    @Step
    public void setValueToMessageColumn(String message) {
        notificationPage.setValueToMessageColumn(message);
    }

    @Step
    public void verifyNotificationsWithSelectedMessageAreDisplayed(String message) {
        notificationPage.verifyNotificationsWithSelectedMessageAreDisplayed(message);
    }

    @Step
    public void openSelectDisplayedColumnsPopUp() {
        notificationPage.clickOnShowColumnChooserLink();
    }

    @Step
    public void deselectColumnInSelectDisplayedColumnsPopUpByIndex(int n) {
        notificationPage.deselectColumnInSelectDisplayedColumnsPopUpByIndex(n);
    }

    @Step
    public void verifyDeselectedColumnIsNotDisplayed(String columnName) {
        notificationPage.verifyDeselectedColumnIsNotDisplayed(columnName);
    }

   @Step
    public void verifyNotificationsTableIsSortedByCreationTimeAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByCreationTimeAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByCreationTimeDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByCreationTimeDescending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByLastUpdatedAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByLastUpdatedAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByLastUpdatedDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByLastUpdatedDescending();
    }

    //EventStartTime
    @Step
    public void verifyNotificationsTableIsSortedByEventStartTimeAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByEventStartTimeAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByEventStartTimeDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByEventStartTimeDescending();
    }

    //EventEndTime Event end time //unknown descending?
    @Step
    public void verifyNotificationsTableIsSortedByEventEndTimeAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByEventEndTimeAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByEventEndTimeDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByEventEndTimeDescending();
    }

    @Step
    public void scrollToMessageColumn() {
        notificationPage.scrollToMessageColumn();
    }

    //ShowStartTime Show start time
    @Step
    public void verifyNotificationsTableIsSortedByShowStartTimeAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByShowStartTimeAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByShowStartTimeDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByShowStartTimeDescending();
    }

    //ShowEndTime Show end time //unknown descending?
    @Step
    public void verifyNotificationsTableIsSortedByShowEndTimeAscending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByShowEndTimeAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByShowEndTimeDescending() throws ParseException {
        notificationPage.verifyNotificationsTableIsSortedByShowEndTimeDescending();
    }

    //Created by
    @Step
    public void verifyNotificationsTableIsSortedByCreatedByAscending() {
        notificationPage.verifyNotificationsTableIsSortedByCreatedByAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByCreatedByDescending() {
        notificationPage.verifyNotificationsTableIsSortedByCreatedByDescending();
    }

    //Updated by
    @Step
    public void verifyNotificationsTableIsSortedByUpdatedByAscending() {
        notificationPage.verifyNotificationsTableIsSortedByUpdatedByAscending();
    }

    @Step
    public void verifyNotificationsTableIsSortedByUpdatedByDescending() {
        notificationPage.verifyNotificationsTableIsSortedByUpdatedByDescending();
    }

    @Step
    public void verifyCurrentDateWithTimezoneIsShown() {
        notificationPage.verifyCurrentDateWithTimezoneIsShown();
    }
    
    @Step
	public void checkNewNotificationButtonIsDisplayed() {
		notificationPage.checkNewNotificationButtonIsDisplayed();		
	}
    
    @Step
	public void checkNewNotificationButtonIsNotDisplayed() {
		notificationPage.checkNewNotificationButtonIsNotDisplayed();		
	}
    
    @Step
	public void checkManageTemplatesButtonIsDisplayed() {
		notificationPage.checkManageTemplatesButtonIsDisplayed();		
	}
    
    @Step
	public void checkManageTemplatesButtonIsNotDisplayed() {
		notificationPage.checkManageTemplatesButtonIsNotDisplayed();		
	}
    
    @Step
	public void checkCloneNotificationButtonIsDisplayed() {
		notificationPage.checkCloneButtonIsDisplayed();		
	}
    
    @Step
	public void checkCloneNotificationButtonIsNotDisplayed() {
		notificationPage.checkCloneButtonIsNotDisplayed();		
	}
    
    @Step
	public void checkDeleteNotificationButtonIsDisplayed() {
		notificationPage.checkDeleteNotificationButtonIsDisplayed();		
	}
    
    @Step
	public void checkDeleteNotificationButtonIsNotDisplayed() {
		notificationPage.checkDeleteNotificationButtonIsNotDisplayed();	
	}
    
    @Step
	public void clickNotificationByIndex(int index) {
		notificationPage.clickNotificationByIndex(index);
		
	}
    
    @Step
	public void checkEditNotificationFormIsNotDisplayed() {
    	notificationPage.verifyEditNotificationFormIsNotDisplayed();		
	}

    @Step
    public void clickEnabledCheckboxNotificationByMessage(String message) {
        notificationPage.clickEnabledCheckboxNotificationByMessage(message);
    }

    @Step
    public void verifyBlackoutValueForMonitor(String column, String value, int monitor, String url, String username_db, String password_db) throws Exception {
        connectToDB = new ConnectToDB();
        connectToDB.verifyBlackoutValueForMonitor(value, monitor, column,url,username_db,password_db);
    }

    @Step
    public void verifyBlackoutValueNotNullForMonitor(String column, int monitor, String url, String username_db, String password_db) throws Exception{
        connectToDB = new ConnectToDB();
        connectToDB.verifyBlackoutValueNotNullForMonitor(monitor, column,url,username_db,password_db);
    }

    @Step
    public void verifyBlackoutValueNullForMonitor(String column, int monitor, String url, String username_db, String password_db) throws Exception{
        connectToDB = new ConnectToDB();
        connectToDB.verifyBlackoutValueNullForMonitor(monitor,column,url,username_db,password_db);
    }

    @Step
    public void changeEventTypeFromPMToPossibleDisruption() {
        notificationPage.changeEventTypeFromPMToPossibleDisruption();
    }

    @Step
    public void changeEventTypeFromPossibleDisruptionToPM() {
        notificationPage.changeEventTypeFromPossibleDisruptionToPM();
    }

    @Step
    public void setEventStartEndTimesInThePast() {
        notificationPage.setEventTimesInThePast();
    }

    @Step
    public void setEventStartEndTimesInTheFuture() {
        notificationPage.setEventTimesInTheFuture();
    }
}