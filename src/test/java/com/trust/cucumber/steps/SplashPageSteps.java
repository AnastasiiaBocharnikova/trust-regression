package com.trust.cucumber.steps;

import java.util.List;
import org.junit.Assert;
import com.trust.cucumber.pages.SplashPage;


public class SplashPageSteps {

	SplashPage splashPage;

	public void clickNeedSupportLink() {
		splashPage.clickNeedSupportLink();
	}

	public void clickCengageIcon() {
		splashPage.clickCengageIcon();
	}
		
	public void selectRegion(String region) {
		splashPage.selectRegion(region);
	}
	
	public void clickSystemMenuIcon() {
		splashPage.clickSystemMenuIcon();
	}
		
	public void selectMenuOption(String menuItem) {
		splashPage.selectMenuOption(menuItem);
	}
	
	public void adminMenuShouldNotBeVisible() {
		splashPage.adminMenuShouldNotBeVisible();
	}
	
	public void selectSubMonitor(int monitor, int submonitor) {
		splashPage.selectSubMonitor(monitor, submonitor);
	}
	
	public void clickCollapseAllButton() {
		splashPage.clickCollapseAllButton();
	}
	
	public void systemCardsAreNotDisplayed() {
		splashPage.systemCardsAreNotDisplayed();
	}

	public void clickExpandeAllButton() {
		splashPage.clickExpandAllButton();
	}
	
	public void systemCardsAreDisplayed() {
		splashPage.systemCardsAreDisplayed();
	}

		
	public void verifySystemNamesforNotifications() {
		List<String> systemNames = splashPage.getSystemCardsNameforGroup();
		List<String> resultNames = splashPage.getSystemNamesFromNotificationTable();
		resultNames.forEach(name -> Assert.assertTrue(systemNames.contains(name)));
		
	}
	
	public void verifyPublicSystemCardsColor() {
		splashPage.verifyPublicSystemCardsColor();
	}

    public void checkCurrentPageIsSplash(String env) {
        splashPage.isCurrentPageSplash(env);
    }

    public void clickOnSystemCard(String systemName) {
        splashPage.clickOnSystemCardByName(systemName);
    }

    public void isLoginValueExpected(String institution) {
	    splashPage.isLoginValueExpected(institution);
    }

    public void isLoginButtonAbsent() {
        splashPage.isLoginButtonAbsent();
    }

    public void isInternalSwitchAbsent() {
	    splashPage.isInternalSwitchAbsent();
    }

    public void clickOnlink(String name) {
	    splashPage.clickOnlink(name);
    }

    public void areOnlyPublicSystemDiplayed() {
	    splashPage.areOnlyPublicSystemDiplayed();
    }

    public void clickButton(String btn) {
	    splashPage.clickButton(btn);
    }
    public void verifySystemAndStatusBtnColor() {
	    splashPage.verifySystemAndStatusBtnColor();
    }
    public void systemCardIsDisplayed(String system, String state) {
        splashPage.systemCardIsDisplayed(system, state);
    }
    public void clickOnBannerHeader(String bannerstate) {
        splashPage.clickOnBannerHeader(bannerstate);
    }
    public void checkBannerState(String bannerstate) {
        splashPage.checkBannerState(bannerstate);
    }
    public void checkBannerText(String bannerText) {
	    splashPage.checkBannerText(bannerText);
    }
    public void checkBannerHeader() {
	    splashPage.checkBannerHeader();
    }
    public void checkVisitThisText() {
	    splashPage.checkVisitThisText();
    }
    public void clickOnTimeZoneButton() {
        splashPage.clickOnTimeZoneButton();
    }
    public void isTimeZoneFormOpened() {
	    splashPage.isTimeZoneFormOpened();
    }
    public void setTimeZone(String timezone) {
	    splashPage.setTimeZone(timezone);
    }
    public void selectTimezoneInDropdown(String timezone) {
	    splashPage.selectTimezoneInDropdown(timezone);
    }
    public void clickBtn() {
        splashPage.clickBtn();
    }
    public void isTimezoneCurrentlySelected(String timezone) {
	    splashPage.isTimezoneCurrentlySelected(timezone);
    }
    public void checkStartAndEndTimeHeadersForNotifTable(String timezone) {
	    splashPage.checkStartAndEndTimeHeadersForNotifTable(timezone);
    }
    public void checkTimezoneAtBottomOfCard(String timezone) {
	    splashPage.checkTimezobneAtBottomOfCard(timezone);
    }
    public void checkNotifHeaders(List<String> headers) {
        splashPage.checkNotifHeaders(headers);
    }
    public void checkNotifTableValues(String message, String value, String column) {
	    splashPage.checkNotifTableValues(message, value, column);
    }
    public void flagShouldBeVisible() {
	    splashPage.flagShouldBeVisible();
    }
    public void notificationHasOrangeBrickPicture() {
	    splashPage.notificationHasOrangeBrickPicture();
    }

    public void checkSystemCardStatusAndText(String systemname) {
        splashPage.checkSystemCardStatusAndText(systemname);
    }

    public void bottomOfTheCardHasTextLastUpdated() {
        splashPage.bottomOfTheCardHasTextLastUpdated();
    }

    public void progressBarIsVisibleForUser() {
	    splashPage.progressBarIsVisibleForUser();
    }

    public void checkForLastSyncSecond() {
	    splashPage.checkForLastSyncSecond();
    }

    public void userSeesInternalSystems() {
        splashPage.userSeesInternalSystems();
    }

    public void checkAdminStatusSpots() {
	    splashPage.checkAdminStatusSpots();
    }

    public void clickEditNotificationButtonOnSplashPage() {
	    splashPage.clickEditNotificationButtonOnSplashPage();
    }


    public void isThereANotificationTable() {
	    splashPage.isThereANotificationTable();
    }
}
