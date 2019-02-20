package com.trust.cucumber.steps;

import com.trust.cucumber.pages.CommonPage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class CommonSteps {
    CommonPage commonPage;

    @Step
    public void clickOnAdminMenuOption(String adminMenuOption) {
        commonPage.clickOnAdminMenuOption(adminMenuOption);
    }

    @Step
    public void isRequiredPageOpened(String pageName) {
        commonPage.isRequiredPageOpened(pageName);
    }

    @Step
    public void clickSystemFromMenu(String systemName) {
        commonPage.clickSystemFromMenu(systemName);
    }

    @Step
    public void areOptionsInMenuVisible(List<String> arg) {
        commonPage.areMenuOptionsPresent(arg);

    }

    @Step
    public void clickOnClosedMenuButton() {
        commonPage.clickOnClosedMenuButton();
    }

    @Step
    public void isMenuState(String state) {
        commonPage.isMenuState(state);
    }

    @Step
    public void selectSystemFromMenu(String systemName) {
        commonPage.clickSystemFromMenu(systemName);
    }

    @Step
    public void clickOnHomeIcon() {
        commonPage.clickOnHomeIcon();
    }

    @Step
    public void deleteAllCookies() {
        commonPage.deleteAllCookies();
    }

    @Step
    public void clickCloseToasterButton() {
        commonPage.clickCloseToasterButton();
    }

    @Step
    public void clickLogInInstitutionButton() {
        commonPage.clickLogInInstitutionButton();
    }

    public void verifyingDropdownMenu() {
        commonPage.verifyingDropdownMenu();
    }

    public void clickExitInstitutionModeButton() {
        commonPage.clickExitInstitutionModeButton();
    }

    public void movingToSplashPageVerifying() {
        commonPage.movingToSplashPageVerifying();
    }

    @Step
    public void clickOnOKModalButton() {
        commonPage.clickOnOKModalButton();
    }

    @Step
    public void clickOnCloseModalButton() {
        commonPage.clickOnCloseModalButton();
    }

    @Step
    public void clickProceedButton() {
        commonPage.clickOnProceedButton();
    }

    @Step
    public void clickOnKITTlink() {
        commonPage.clickOnKITTlink();
    }

    @Step
    public void clickLogoutButton() {
        commonPage.clickLogoutButton();
    }

    @Step
    public void verifyModalWindowIsAppeared(String winTitle) {
        commonPage.verifyModalWindowIsAppeared(winTitle);
    }

    @Step
    public void verifyModalWindowIsClosed(String winTitle) {
        commonPage.verifyModalWindowIsClosed(winTitle);
    }

    @Step
    public void verifyOkModalButtonIsDisabled() {
        commonPage.verifyOkModalButtonIsDisabled();
    }

    public void isinternalPublicSwitchIsUnsetToPublicValue() {
        commonPage.isinternalPublicSwitchIsUnsetToPublicValue();
    }

    public void clickInternalUserButton() {
        commonPage.clickInternalUserButton();
    }

    public void verifyLinkNavigation(String expectedLink) {
        commonPage.verifyLinkNavigation(expectedLink);
    }

    public void userClicksBrowserBackButton() {
        commonPage.userClicksBrowserBackButton();
    }

    @Step
    public void clickOnHeader(String header) {
        commonPage.clickOnHeader(header);
    }
}