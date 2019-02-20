package com.trust.cucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AboutPage extends PageObject{

    WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".public-DraftStyleDefault-block > span > span")
    private WebElement editForm;

    public void clickOnButtonOnAboutPage(String button) {
        clickOn($("#" + button + "-btn"));
    }

    public String enterValueToEditAboutPageForm() {
        String currentDate = getCurrentDate();
        String valueToEnter = "auto" + currentDate;
        Actions actions = new Actions(getDriver());
        actions.moveToElement(editForm);
        actions.click();
        actions.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),valueToEnter);
        actions.build().perform();
        return valueToEnter;
    }

    private String getCurrentDate () {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getAboutPageText() {
        return find(By.cssSelector("#about-page-text")).getText();
    }

    public void isButtonNotVisible(String button) {
        shouldNotBeVisible(By.cssSelector("#" + button + "-btn"));
    }

    public void isButtonVisible(String button) {
        shouldBeVisible(By.cssSelector("#" + button + "-btn"));
    }

    public FeedbackPage clickOnLinkOnAboutPage() {
        clickOn($("#help-techcheck-btn"));
        return new FeedbackPage(driver);
    }

    public void selectOptionInDropDownInAboutEditor(String option, String dropdown) {
        $("//a[@title='" + dropdown + "']").click();
        $("//ul/li[text()='" + option + "']").click();
    }

    public void isOptionSelectedInEditorOnAboutPage(String option, String dropdown) {
        shouldBeVisible(By.xpath("//a[@title='" + dropdown + "']/span[text()='" + option + "']"));
    }

    public void clicksTheButtonOnEditor(String button) {
        $("//div[@title='" + button + "']").click();
    }

    public void verifyTheButtonIsSelectedOnAboutPageEditor(String button) {
        shouldBeVisible(By.xpath("//div[@title='" + button + "'][@aria-selected='true']"));
    }

    public void selectValueInEditorFormOnAboutPage() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(editForm);
        actions.click();
        actions.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
        actions.build().perform();
    }
}
