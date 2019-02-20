package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.CommonSteps;
import com.trust.cucumber.util.Environment;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.aeonbits.owner.ConfigFactory;

import java.util.List;

public class CommonStepDef {

    Environment testEnvironment  = ConfigFactory.create(Environment.class);

    public String env = testEnvironment.env();
    public String username = testEnvironment.username();
    public String password = testEnvironment.password();

    @Steps
    CommonSteps commonSteps;

    @When("^User clicks on (.*) in admin menu$")
    public void userClicksOnAdminMenuOption(String adminMenuOption) {
        commonSteps.clickOnAdminMenuOption(adminMenuOption);
    }

    @Then("^(.*) Page is opened$")
    public void pageIsOpened(String pageName)  {
        commonSteps.isRequiredPageOpened(pageName);
    }

    @When("^User clicks (.*) system from the menu$")
    public void clickSystemFromMenu(String systemName) {
        commonSteps.clickSystemFromMenu(systemName);
    }

    @When("^User selects (.*) system from the menu$")
    public void selectSystemFromMenu(String systemName) {
        commonSteps.selectSystemFromMenu(systemName);
    }

    @When("^User clicks on hamburger menu button$")
    public void isAdminMenuExpanded(){
        commonSteps.clickOnClosedMenuButton();
        }
    @Then("^User is able to see following options in the menu1$")
    public void seeOpetionsInMenu(List<String> arg) {
        commonSteps.areOptionsInMenuVisible(arg);
    }


    @Then("^Menu state is (.*)$") // possible 'close' or 'open'
    public void menuStateIsOpen(String state)   {
        commonSteps.isMenuState(state);
    }

    @When("^User clicks on (.*) from admin menu$")
    public void userClicksOnNotificationsFromAdminMenu(String adminMenuOption) {
        commonSteps.clickOnAdminMenuOption(adminMenuOption);
    }

    @When("^User clicks on home icon$")
    public void clickOnHomeIcon() {
        commonSteps.clickOnHomeIcon();
    }

    @When("^User deletes all cookies$")
    public void userDeletesAllCookies() {
        commonSteps.deleteAllCookies();
    }

        @When("^the user clicks on Login icon$")
    public void theUserClicksOnLoginIcon() throws Throwable {
        commonSteps.clickLogInInstitutionButton();
    }

    @Then("^user sees dropdown button with Exit institution mode text$")
    public void userSeesDropdownButtonWithExitInstitutionModeText() throws Throwable {
        commonSteps.verifyingDropdownMenu();
    }

    @And("^the user clicks on dropdown button$")
    public void theUserClicksOnDropdownButton() throws Throwable {
        commonSteps.clickExitInstitutionModeButton();
    }

    @Then("^there is signin button or sign in button cover$")
    public void thereIsSigninButtonAndInternalPublicSwitch() throws Throwable {
            commonSteps.movingToSplashPageVerifying();
    }

    @When("^User clicks on OK modal button$")
    public void clickOnOKModalButton() {
        commonSteps.clickOnOKModalButton();
    }

    @When("^User clicks on Close button$")
    public void clickOnCloseModalButton() {
        commonSteps.clickOnCloseModalButton();
    }

    @When("^User clicks on KITT link on page$")
    public void clickOnKITTlink() {
        commonSteps.clickOnKITTlink();
    }

    @And("^User clicks on Logout button$")
    public void clickLogoutButton() {
        commonSteps.clickLogoutButton();
    }

    @Then ("^(.*) window is appeared$")
    public void verifyModalWindowIsAppeared(String winTitle) {
        commonSteps.verifyModalWindowIsAppeared(winTitle);
    }

    @Then("^(.*) window is closed$")
    public void selectMonitorsWindowIsClosed(String winTitle ){
        commonSteps.verifyModalWindowIsClosed(winTitle);
    }

    @And("^OK modal button is disabled$")
    public void okModalButtonIsDisabled() {
        commonSteps.verifyOkModalButtonIsDisabled();
    }

    @And("^Internal-public switch is unset to Public value$")
    public void internalPublicSwitchIsUnsetToPublicValue() {
        commonSteps.isinternalPublicSwitchIsUnsetToPublicValue();
    }

    @When("^User clicks Cengage Internal user button$")
    public void clickInternalUserButton() {
        commonSteps.clickInternalUserButton();
    }

    @Then("^Link navigates to (.*)$")
    public void verifyLinkNavigation(String expectedLink) {
        commonSteps.verifyLinkNavigation(expectedLink);
    }

    @And("^User closes toaster$")
    public void userClosesToaster()  {
        commonSteps.clickCloseToasterButton();
    }

    @When("^User clicks browser back button$")
    public void userClicksBrowserBackButton()  {
        commonSteps.userClicksBrowserBackButton();
    }

    @When("^User clicks on (.*) column header$")
    public void clickOnHeader(String header) {
        commonSteps.clickOnHeader(header);
    }

    @When("^User clicks two times on (.*) column header$")
    public void clickOnUsernameColumnHeaderTwoTimes(String header) {
        commonSteps.clickOnHeader(header);
        commonSteps.clickOnHeader(header);
    }

}
