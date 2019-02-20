package com.trust.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {

    WebDriver driver;


    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class*=Feedback_feedbackPage_LN9Qw]")
    private WebElement feedbackText;

    @FindBy(css = "[class*=Feedback_feedbackPage_LN9Qw] > p > a")
    private WebElement supportLink;

    @FindBy(css = "textarea")
    private WebElement feedbackTextArea;

    @FindBy(id = "policy_understood_checkbox")
    private WebElement policy_understood_checkbox;

    @FindBy(id = "feedback_submit_btn")
    private WebElement feedbackSubmitButton;

    @FindBy(id = "agreement_text")
    private WebElement agreementText;


    public void checkDescriptionText() {
        Assert.assertTrue("Seems that text has changed on Feedback page", feedbackText.getText().contains("Please only use this form to give feedback on the Techcheck system itself.  If you need help with another product, such as MindTap, WebAssign, Cnow, Aplia, or others, please use  Cengage customer support service instead."));
    }

    public void clickOnCengageCustomerSupport() {
        supportLink.click();
    }

    public void fillInText() {
        feedbackTextArea.sendKeys("AutoTest");
    }

    public void clickOnCheckBoxOnFeedbackPage() {
        Assert.assertEquals("I have read and understood that this form is for feedback on Techcheck system only",agreementText.getText());
        policy_understood_checkbox.click();
    }

    public void checkSubmitButtonState() {
        Assert.assertTrue(!feedbackSubmitButton.getAttribute("tabindex").equals("-1")); //-1 tabindex when button is disabled
    }
}
