package com.trust.cucumber.steps;

import com.trust.cucumber.pages.StatusHistoryPage;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.BeanMatcher;
import org.junit.Assert;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static com.trust.cucumber.support.Constants.*;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;

public class StatusHistoryPageSteps {

	StatusHistoryPage statusHistoryPage;
	
	@Step
	public void shouldSeeNextBricks(BeanMatcher... matchers) {	
		Map<String, String> historyBricks = statusHistoryPage.getStatusHistoryBricks();
		Assert.assertEquals(historyBricks.size(), 4);
		shouldMatch(historyBricks, the("No issues", is(GREEN)),
				the("Planned maintenance", is(STRIPED)),
				the("Service disruption", is(ORANGE)),
				the("Service unavailable", is(RED)));
	}
	
	@Step
	public void clickHistoryViewButton(String tabName) {
		statusHistoryPage.clickHistoryViewButton(tabName);
	}
	
	@Step
	public void selectFirstDayOfThePreviousMonth() {
		statusHistoryPage.selectFirstDayOfThePreviousMonth();
		Serenity.setSessionVariable("selectedDate").to(statusHistoryPage.getSelectedDate());
		
	}
	
	@Step
	public void hoverOnParticularDay(int dayIndex) {
		statusHistoryPage.hoverOnParticularDay(dayIndex);
	}
	
	@Step
	public void dayStatusPopUpIsDisplayed() {
		statusHistoryPage.dayStatusPopUpIsDisplayed();
	}
	
	@Step
	public void specifiedDayStatusHistoryIsDisplayed() {
        statusHistoryPage.dayStatusHistoryIsDisplayed();
		statusHistoryPage.specifiedDayStatusHistoryIsDisplayed();
	}

	@Step
	public void isPageOpened() {
		statusHistoryPage.isStatusHistoryPageOpened();
	}

	@Step
	public void isSystemTextDisplayed(String systemName) {
		statusHistoryPage.isSHTextDisplayed(systemName);
	}

	@Step
	public void dayStatusHistoryIsDisplayed() {
		statusHistoryPage.dayStatusHistoryIsDisplayed();
	}

	@Step
	public void clickOnBrick() {
		statusHistoryPage.clickOnBrick();
	}

	@Step
	public void isDrilldownOpened() {
		statusHistoryPage.isDrilldownOpened();
	}

	@Step
	public void areElementsAvailable(List<String> elements) {
		statusHistoryPage.areElementsAvailable(elements);
	}

	@Step
	public void clickOnButton(String button) {
		statusHistoryPage.clickOnButton(button);
	}

	@Step
	public void clickSelectStartDate() {
		statusHistoryPage.clickSelectStartDate();
		Serenity.setSessionVariable("selectedStartDate").to(statusHistoryPage.getSelectedStartDate());
	}

	@Step
	public void verifyAndClickAddMonitorsButton() {
		statusHistoryPage.verifyAndClickAddMonitorsButton();
	}


    public void userIsAbleToSeeTextDescription() {
	    statusHistoryPage.userIsAbleToSeeTextDescription();
    }

    public void areRowsvisible(int rows) {
        statusHistoryPage.areRowsvisible(rows);
    }

    public void areBricksVisible(int bricks) {
        statusHistoryPage.areRowsVisible(bricks);
    }

    public void userSeesAPublicLegend() {
	    statusHistoryPage.isPublicLegendVisible();
    }

    public void checkNotifHeaders(List<String> headers) {
        statusHistoryPage.checkNotifHeaders(headers);
    }

    public void checkNotifTableValues(String message, String value, String column) {
	    statusHistoryPage.checkNotifTableValues(message, value, column);
    }

    public void userIsAbleToSeeSpecifyDateTabTextDescription() {
        statusHistoryPage.userIsAbleToSeeSpecifyDateTabTextDescription();
    }

    public void userIsAbleToSee30DaysTabTextDescription() {
	    statusHistoryPage.userIsAbleToSee30DaysTabTextDescription();
    }

    public void thereAreBlocksAreDisplayed(int blocks) {
        statusHistoryPage.thereAreBlocksAreDisplayed(blocks);
    }

    public void userClicksOneOfTheDaysViewBlocksWithDay(String day) {
        statusHistoryPage.userClicksOneOfTheDaysViewBlocksWithDay(day);
    }

    @Step
    public void checkSpecifyPreviousDateButtonEnabled() {
        statusHistoryPage.checkSpecifyPreviousDateButtonEnabled();
    }

    @Step
    public void clickOnSpecifyPreviousDateButton() {
        statusHistoryPage.clickOnSpecifyPreviousDateButton();
        Serenity.setSessionVariable("selectedDate").to(statusHistoryPage.getSelectedDate());
    }
    public void tabIsSelected(String tab) {
        statusHistoryPage.tabIsSelected(tab);
    }

    public void isAdminLegendShown() {
        statusHistoryPage.isAdminLegendShown();
    }

    public void userNavigatesToMonitorLink() {
        statusHistoryPage.userNavigatesToMonitorLink();
    }

    public void checkHeaderForRawTable(List<String> headers) {
        statusHistoryPage.checkHeaderForRawTable(headers);
    }

    public void checkBusinessLogicTableHeaders(List<String> headers) {
        statusHistoryPage.checkBusinessLogicTableHeaders(headers);
    }

    public void checkNotifDrillDownTableHeaders(List<String> headers) {
        statusHistoryPage.checkNotifDrillDownTableHeaders(headers);
    }

    public void expandMonitorTable() {
        statusHistoryPage.expandMonitorTable();
    }

    public void checkMonitorTableHeders(List<String> headers) {
        statusHistoryPage.checkMonitorTableHeders(headers);
    }

    public void checkValuesInSHTable(String column, List<String> values) {
        statusHistoryPage.checkValuesInSHTable(column, values);
    }

    public void isValuePresentInColumnForRawDataTable(String value, String column) {
        statusHistoryPage.isValuePresentInColumnForRawDataTable(value, column);
    }

    public void clickDrilldownBack() {
        Serenity.setSessionVariable("beforeDrilldownDate").to(statusHistoryPage.getDrilldownDate());
        statusHistoryPage.clickDrilldownBack();
    }

    public void checkDrillDownDateTime() throws ParseException {
        Serenity.setSessionVariable("afterDrilldownDate").to(statusHistoryPage.getDrilldownDate());
        String afterDrilldownDate  = Serenity.sessionVariableCalled("afterDrilldownDate").toString();
        String beforeDrilldownDate = Serenity.sessionVariableCalled("beforeDrilldownDate").toString();
        statusHistoryPage.checkDrillDownDateTime(beforeDrilldownDate, afterDrilldownDate);
    }

    public void clickDrilldownEditNotif() {
        statusHistoryPage.clickDrilldownEditNotif();
    }


	@Step
	public void clickOnMonitorCheckBox(String monitorTitle) {
		statusHistoryPage.clickOnMonitorCheckBox(monitorTitle);
	}

	@Step
	public void monitorIsInTheList(String monitorTitle, String monitorID) {
		statusHistoryPage.monitorIsInTheList(monitorTitle, monitorID);
	}

	@Step
	public void tabIsNotVisible(String tabName) {
		statusHistoryPage.tabIsNotVisible(tabName);
	}

	@Step
	public void checkBoxForMonitorIsSelectedAndNotEditable(String monitorTitle) {
		statusHistoryPage.checkBoxForMonitorIsSelectedAndNotEditable(monitorTitle);
	}

	@Step
	public void amountOfSectionsInTheStatusBar(int amountSections) {
		statusHistoryPage.amountOfSectionsInTheStatusBar(amountSections);
	}

	@Step
	public void verifyChooseDateFieldIsDisplayed() {
		statusHistoryPage.verifyChooseDateFieldIsDisplayed();
	}

	@Step
	public void verifyStatusHistoryForSingleMonitorIsDisplayed(String monitorTitle) {
		statusHistoryPage.verifyStatusHistoryForSingleMonitorIsDisplayed(monitorTitle);
	}

	@Step
	public void verifyingResetClearButton(String button) {
		statusHistoryPage.verifyingResetClearButton(button);
	}

	@Step
	public void checkBoxForMonitorIsNotSelected(String monitorTitle) {
		statusHistoryPage.checkBoxForMonitorIsNotSelected(monitorTitle);
	}

	@Step
	public void verifyNoSelectedCheckBox() {
		statusHistoryPage.verifyNoSelectedCheckBox();
	}

    public void isNotVisibleAddMonitors() {
        statusHistoryPage.isNotVisibleAddMonitors();
    }

    public void userClicksOnLinkOnMultipleMonitorsView(String link) {
	    statusHistoryPage.userClicksOnLinkOnMultipleMonitorsView(link);
    }

    public void checkIfMultipleMonitorsViewIsOpened() {
        statusHistoryPage.checkIfMultipleMonitorsViewIsOpened();
    }


    @Step
    public void checkSelectedDayIsDisplayedInTheSpecifyDateField() {
        statusHistoryPage.checkSelectedDayIsDisplayedInTheSpecifyDateField();
    }
}