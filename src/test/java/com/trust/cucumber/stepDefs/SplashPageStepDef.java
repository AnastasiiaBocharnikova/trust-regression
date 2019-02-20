package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.SplashPageSteps;

import com.trust.cucumber.util.Environment;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.aeonbits.owner.ConfigFactory;
import java.util.List;

public class SplashPageStepDef {

    Environment testEnvironment  = ConfigFactory.create(Environment.class);

    public String env = testEnvironment.env();
    public String username = testEnvironment.username();
    public String password = testEnvironment.password();


    @Steps
	SplashPageSteps userOnSplashPage;


	@When("^User clicks Need product support link$")
	public void clickNeedSupportLink() {
        userOnSplashPage.clickNeedSupportLink();
	}
	
	@When("^User clicks Cengage icon$")
	public void clickCengageIcon() {
        userOnSplashPage.clickCengageIcon();
	}
		
	@Then("^User selects (.*) region$")
	public void selectRegion(String region) {
        userOnSplashPage.selectRegion(region);
	}
	
	@When("^User clicks System Menu icon$")
	public void clickSystemMenuIcon() {
        userOnSplashPage.clickSystemMenuIcon();
	}
	
	@When("User selects (.*) menu option$")
	public void selectMenuOption(String menuItem) {
        userOnSplashPage.selectMenuOption(menuItem);
	}
	
	@Then("Admin Menu should not be visible$")
	public void adminMenuShouldNotBeVisible() {
        userOnSplashPage.adminMenuShouldNotBeVisible();
	}
		
	@And("^User selects (.*) monitor and (.*) submonitor for it$")
	public void selectSubMonitor(int monitor, int submonitor) {
        userOnSplashPage.selectSubMonitor(monitor, submonitor);
	}
	
	@When("^User clicks Collapse all button$")
	public void clickCollapseAllButton() {
        userOnSplashPage.clickCollapseAllButton();
	}
	
	@Then("^System cards are not displayed$")
	public void systemCardsAreNotDisplayed() {
        userOnSplashPage.systemCardsAreNotDisplayed();
	}
	
	@When("^User clicks Expand all button$")
	public void clickExpandAllButton() {
        userOnSplashPage.clickExpandeAllButton();
	}
	
	@Then("^System cards are displayed$")
	public void systemCardsAreDisplayed() {
        userOnSplashPage.systemCardsAreDisplayed();
	}

    //@TODO do we use it?
	@Then("^Only system names for certain group are displayed in notifications section$")
	public void verifySystemNamesforNotifications() {
        userOnSplashPage.verifySystemNamesforNotifications();
	}
	
	@Then("^Color for public system cards is white$")
	public void verifyPublicSystemCardsColor() {
        userOnSplashPage.verifyPublicSystemCardsColor();
	}

    @Given("^User is on Splash page1$")
    public void isOnSplashPage(){ userOnSplashPage.checkCurrentPageIsSplash(env); }


    @When("^User clicks on (.*) System card$")
    public void userClicksOnMindTapSystemCard(String systemName) {
        userOnSplashPage.clickOnSystemCard(systemName);
    }

    @Then("^Splash page is displayed$")
    public void splashPageIsDisplayed()  {
        userOnSplashPage.checkCurrentPageIsSplash(env);
    }


    @And("^Login icon has (.*) as user name$")
    public void loginIconHasAutoInstAsUserName(String institution) {
        userOnSplashPage.isLoginValueExpected(institution);

    }

    @And("^There is no login button and internal-public switch$")
    public void thereIsNoLoginButtonAndInternalPublicSwitch(){
        userOnSplashPage.isLoginButtonAbsent();
        userOnSplashPage.isInternalSwitchAbsent();
    }

    @When("^User clicks on (.*) link$")
    public void userClicksOnLink(String name) {
        userOnSplashPage.clickOnlink(name);
    }

    @Then("^User doesn't see internal systems$")
    public void areOnlyPublicSystemDiplayed() { userOnSplashPage.areOnlyPublicSystemDiplayed(); }

    @When("^User clicks on (.*) button on Splash page$")
    public void userClicksOnWorstStatusButton(String btn)  {
        userOnSplashPage.clickButton(btn);
    }

    @Then("^User sees at least one system with the same color as color of worst status button$")
    public void verifySystemAndStatusBtnColor()  { userOnSplashPage.verifySystemAndStatusBtnColor(); }


    @Then("^System (.*) card is (.*) displayed$")
    public void systemCardIsDisplayed(String system, String state) {
        userOnSplashPage.systemCardIsDisplayed(system, state);

    }

    @And("^User clicks on (.*) banner$")
    public void userClicksOnBanner(String bannerstate) {
        userOnSplashPage.clickOnBannerHeader(bannerstate);

    }


    @Then("^User sees Banner (.*)")
    public void userSeesBannerState(String bannerstate) {
        userOnSplashPage.checkBannerState(bannerstate);

    }

    @And("^User sees word (.*) in banner body$")
    public void userSeesWordInBannerBody(String bannerText) {
        userOnSplashPage.checkBannerText(bannerText);
    }

    @And("^User sees Important Information in Banner header$")
    public void userSeesImportantInformationInBannerHeader()  {
        userOnSplashPage.checkBannerHeader();
    }

    @Then("^Expected  welcoming text is displayed - Visit this$")
    public void expectedWelcomingTextIsDisplayedVisitThis()  {
        userOnSplashPage.checkVisitThisText();
    }

    @When("^User clicks on timezone control$")
    public void userClicksOnTimezoneControl()  {
        userOnSplashPage.clickOnTimeZoneButton();
    }

    @Then("^Select timezone popup is opened$")
    public void selectTimezonePopupIsOpened()  {
        userOnSplashPage.isTimeZoneFormOpened();
    }

    @When("^User enters (.*) to timezone input field$")
    public void userEntersTimezoneInputField(String timezone) {
        userOnSplashPage.setTimeZone(timezone);
    }

    @And("^User selects (.*) timezone from dropdown$")
    public void userSelectsTimezoneFromDropdown(String timezone)  {
        userOnSplashPage.selectTimezoneInDropdown(timezone);
    }

    @And("^User clicks Ok button on Select timezone modal form$")
    public void userClicksOkButtonOnSelectTimezoneModalForm() {
        userOnSplashPage.clickBtn();
    }

    @Then("^The (.*) timezone is currently selected in the app$")
    public void isTimezoneCurrentlySelectedInTheApp(String timezone)  {
        userOnSplashPage.isTimezoneCurrentlySelected(timezone);

    }

    @And("^User is able to see (.*) timezone in Notification table for Start and End date columns$")
    public void checkStartAndEndTimeHeadersForNotifTable(String timezone) {
        userOnSplashPage.checkStartAndEndTimeHeadersForNotifTable(timezone);
    }

    @And("^Timezone at bottom of card is set to (.*)$")
    public void checkTimezoneAtBottomOfCard(String timezone)  {
        userOnSplashPage.checkTimezoneAtBottomOfCard(timezone);
    }

    @Then("^User is able to see notifications table for system (.*)$")
    public void userIsAbleToSeeNotificationsTableForSystem$SystemPublic(String system) {

    }

    @And("^Notification table has following headers$")
    public void notificationTableHasFollowingHeaders(List<String> headers) {
        userOnSplashPage.checkNotifHeaders(headers);
    }

    @And("^Notification with (.*) message has value (.*) in (.*)$")
    public void checkNotifTableValues(String message, String value, String column){
        userOnSplashPage.checkNotifTableValues(message, value, column);
    }

    @And("^User sees banner flag on the page$")
    public void userSeesBannerFlagOnThePage()  {
        userOnSplashPage.flagShouldBeVisible();
    }

    @And("^Notification has orange brick picture$")
    public void notificationHasOrangeBrickPicture() {
        userOnSplashPage.notificationHasOrangeBrickPicture();
    }

    @Then("^System card for (.*) has appropriate to its status picture and text$")
    public void systemCardFor$SystemPublicHasAppropriateToItsStatusPictureAndText(String systemname)   {
        userOnSplashPage.checkSystemCardStatusAndText(systemname);
    }

    @And("^Bottom of a card has text Last updated$")
    public void bottomOfTheCardHasTextLastUpdated(){
        userOnSplashPage.bottomOfTheCardHasTextLastUpdated();
    }

    @And("^Progress bar is visible for user$")
    public void progressBarIsVisibleForUser()  {
        userOnSplashPage.progressBarIsVisibleForUser();

    }

    @And("^User can see last sync time and it's less than 70 sec$")
    public void userCanSeeLastSyncTimeAndItSLesThanSec()  {
        userOnSplashPage.checkForLastSyncSecond();
    }

    @Then("^User sees internal systems$")
    public void userSeesInternalSystems() {
        userOnSplashPage.userSeesInternalSystems();
    }

    @Then("^Admin sees at least one system with the same color as color of each of two status spots$")
    public void adminSeesAtLeastOneSystemWithTheSameColorAsColorOfEachOfTwoStatusSpots() {
        userOnSplashPage.checkAdminStatusSpots();
    }

    @When("^Admin click edit notification button on Splash or SH Page$")
    public void adminClickEditNotificationButtonOnSplashPage() {
        userOnSplashPage.clickEditNotificationButtonOnSplashPage();
    }


    @And("^There is no notification table on the Splash Page$")
    public void thereIsNoNotificationTableOnTheSplashPage(){
        userOnSplashPage.isThereANotificationTable();
    }
}

