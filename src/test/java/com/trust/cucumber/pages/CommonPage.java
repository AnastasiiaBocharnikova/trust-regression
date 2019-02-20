package com.trust.cucumber.pages;

import com.trust.cucumber.util.Log;

import com.trust.cucumber.util.Wait;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CommonPage extends PageObject {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    private Wait wait = new Wait(getDriver());

    @FindBy(css = "#open-menu-btn")
    private WebElementFacade hamburgerMenuButton;

    @FindBy(css = "#drawer-open")
    private WebElementFacade menuDrawerOpenElement;

    @FindBy(xpath = "//button/span/span[contains(text(),'home')]")
    private WebElementFacade homeIcon;

    @FindBy(id="institution-menu-button")
    private WebElementFacade logInInstitutionButton;

    @FindBy(xpath = "//div//li[contains(text(), 'Exit institution mode')]")
    private WebElementFacade exitButton;

    @FindBy(id="sign-in-btn")
    private WebElementFacade signInButton;

    @FindBy(css = "#internal-public-switch")
    private WebElementFacade publicInternalSwitcher;

    @FindBy(xpath = "//div//button//span[contains(text(), 'more_vert')]")
    private WebElementFacade signInCover;

    @FindBy(css = "#modal-button-ok")
    private WebElementFacade okModalButton;

    @FindBy(css = "#modal-button-close")
    private WebElementFacade closeModalButton;

    @FindBy(css = "#modal-button-proceed")
    private WebElementFacade proceedModalButton;

    @FindBy (css = "#kitt-link")
    private WebElementFacade kittLink;

    @FindBy(xpath = "//button/span[contains(text(),'Logout')]")
    private WebElementFacade buttonLogout;

    @FindBy(css = "#internal-public-switch[value=unchecked]")
    private WebElementFacade internalPublicSwitchAtPublic;

    @FindAll({
            @FindBy(xpath = "//a[@href='/admin/notifications']/div[text()='Notifications']"),
            @FindBy(xpath = "//a[@href='/admin/systems']/div[text()='Systems']"),
            @FindBy(xpath = "//a[@href='/admin/users']/div[text()='Manage Users']"),
            @FindBy(xpath = "//a[@href='/admin/roles']/div[text()='Manage Roles']"),
            @FindBy(xpath = "//a[@href='/admin/institutions']/div[text()='Institutions']"),
            @FindBy(xpath = "//a[@href='/admin/regions']/div[text()='Manage Regions']"),
            @FindBy(xpath = "//a[@href='/admin/changelogs']/div[text()='Change logs']"),
            @FindBy(xpath = "//a[@href='/about']/div[text()='About']"),
            @FindBy(xpath = "//a[@href='/faq']/div[text()='FAQ']"),
            @FindBy(xpath = "//a[@href='/status']/div/span[contains(text(),'Status')]"),
    })
    private List<WebElementFacade> allAdminMenuOptions;

    @FindBy(xpath = "//span[contains(@class,'internalBtn')]//span[input]" )
    private WebElement internalUserButton;

    public void clickOnAdminMenuOption(String adminMenuOption) {
        switch (adminMenuOption) {
            case "Status":
                clickOn(find(By.xpath("//a/div/span[contains(text(),'" + adminMenuOption + "')]")));
                break;
            default:
                try {
                    clickOn(find(By.xpath("//a/div[contains(text(),'" + adminMenuOption + "')]")));
                }catch (StaleElementReferenceException e){
                    clickOn(find(By.xpath("//a/div[contains(text(),'" + adminMenuOption + "')]")));
                }
        }

    }

    public void isRequiredPageOpened(String pageName) {
        wait.waitForPageLoad();
        Assert.assertTrue(find(By.cssSelector("h3.text-link")).getText().equals(pageName));

    }

    public void clickSystemFromMenu(String systemName) {
        clickOn(find(By.xpath("//div/p[text()='" + systemName + "']")));
    }

    public void clickOnClosedMenuButton() {
        hamburgerMenuButton.click();
    }

    public void isMenuState(String state) {
        shouldBeVisible((By.xpath("//div[contains(@id,'drawer-" + state + "')]")));
    }



    public void areMenuOptionsPresent(List<String> expectedMenuOptions) {
        List<String> adminMenuList = new ArrayList<String>();

        for (WebElementFacade element: allAdminMenuOptions) {
            wait.waitForPageLoad();
            adminMenuList.add(element.getText().replaceAll("\\(([^)]+)\\)","").trim());// removing version number in brackets for 'Status' menu option
        }

        Log.info("Expected Admin Menu options" + expectedMenuOptions);
        Log.info("Actual Admin Menu options" + adminMenuList);
        Assert.assertTrue(adminMenuList.containsAll(expectedMenuOptions));
    }

    public void clickOnHomeIcon() { clickOn(homeIcon); }

    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }

    public void clickCloseToasterButton() {
        try {
            if (isElementVisible(By.xpath("//div[contains(@class,' Toastify__toast')]/button")))
                $("//div[contains(@class,' Toastify__toast')]/button").click();
        }
        catch (ElementNotVisibleException | NoSuchElementException e) {
            Log.debug("Can not click close Toaster Button. Reason: " + e.toString());
        }
    }

	public void clickLogInInstitutionButton()
    {
        clickOn(logInInstitutionButton);
    }

    public void verifyingDropdownMenu() {
        Assert.assertTrue(exitButton.isDisplayed());
        Assert.assertEquals("Exit institution mode", exitButton.getText());
    }

    public void clickExitInstitutionModeButton() {
        clickOn(exitButton);
    }

    public void movingToSplashPageVerifying() {
        Assert.assertTrue(signInCover.isVisible()|signInButton.isVisible());

    }

    public void clickOnOKModalButton() {
        okModalButton.click();
    }

    public void clickOnCloseModalButton() {
        closeModalButton.click();
    }

    public void clickOnProceedButton() {
        proceedModalButton.click();
    }

    public void clickOnKITTlink() {
        kittLink.click();
    }

    public void clickLogoutButton() {
        buttonLogout.click();
    }

    public void isinternalPublicSwitchIsUnsetToPublicValue() {
        wait.waitForPageLoad();
        withTimeoutOf(Duration.ofSeconds(10)).waitForPresenceOf(By.xpath("//span[contains(@class,'internalBtn')]//input[contains(@value,'unchecked')]"));
        $("//span[contains(@class,'internalBtn')]//input[contains(@value,'unchecked')]").shouldBePresent();
    }

    public void clickInternalUserButton() {
        clickOn(internalUserButton);
    }

    public void verifyModalWindowIsAppeared(String winTitle) {
        Assert.assertTrue($("//div//h6[contains(text(),'" + winTitle + "')]").isDisplayed());
    }

    public void verifyModalWindowIsClosed(String winTitle) {
        Assert.assertFalse(($("//div//h6[contains(text(),'" + winTitle + "')]").isCurrentlyVisible()));
    }

    public void verifyOkModalButtonIsDisabled() {
        Assert.assertFalse(okModalButton.isEnabled());
    }

    public void verifyLinkNavigation(String expectedLink) {
        ArrayList<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(1));
        waitABit(1000);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedLink);
        getDriver().close();
        getDriver().switchTo().window(browserTabs.get(0));
    }

    public void userClicksBrowserBackButton() {
        getDriver().navigate().back();
    }

    public void clickOnHeader(String header) {
        waitABit(1000);
        clickOn($("//span[contains(@id,'" + header.toLowerCase() + "-header')]"));
    }
}
