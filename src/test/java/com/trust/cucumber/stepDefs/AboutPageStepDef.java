package com.trust.cucumber.stepDefs;

import com.trust.cucumber.pages.AboutPage;
import com.trust.cucumber.pages.CommonPage;
import com.trust.cucumber.pages.FeedbackPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;

public class AboutPageStepDef {

    private AboutPage aboutPage;
    private FeedbackPage feedbackPage;
    private CommonPage commonPage;




    @And("^User clicks on (.*) button on About Page$")
    public void clickOnButtonOnAboutPage(String button){
        aboutPage.clickOnButtonOnAboutPage(button);

    }

    @When("^User enters current date value to edit form$")
    public void userEntersValueToEditForm() {
        String aboutPageValue = aboutPage.enterValueToEditAboutPageForm();
        Serenity.setSessionVariable("aboutPageValueChanged").to(aboutPageValue);
    }

    @Then("^User is able to see current date value on About Page$")
    public void userIsAbleToSeeCurrentDateValueOnAboutPage() {
        String currentValueFromAboutPage = aboutPage.getAboutPageText();
        String aboutPageValueChanged = Serenity.sessionVariableCalled("aboutPageValueChanged");
        Assert.assertEquals(currentValueFromAboutPage, aboutPageValueChanged);
    }

    @Then("^User cannot see (.*) button")
    public void userCannotSeeButtonAnymore(String button) {
        aboutPage.isButtonNotVisible(button);
    }

    @And("^User can see (.*) button$")
    public void userCanSeeButton(String button) {
        aboutPage.isButtonVisible(button);
    }

    @When("^User clicks on Help Improve link on About Page to Navigate to FeedBack Page$")
    public void userClickOnHelpTechcheckLinkOnAboutPage() {
        commonPage.clickCloseToasterButton();
        feedbackPage = aboutPage.clickOnLinkOnAboutPage();
    }

    @And("^User can see text description for Feedback Page$")
    public void userCanSeeTextDescriptionForFeedbackPage() {
        feedbackPage.checkDescriptionText();
    }

    @When("^User clicks on Cengage customer support service link on Feedback page$")
    public void userClicksOnCengageCustomerSupportServiceLinkOnFeedbackPage() {
        feedbackPage.clickOnCengageCustomerSupport();
    }

    @When("^User fills in test text to a Feedback form$")
    public void userFillsInTestTextToAFeedbackForm() {
        feedbackPage.fillInText();
    }

    @And("^User agrees with policy agreement$")
    public void userAgreesWithPolicyAgreement() {
        feedbackPage.clickOnCheckBoxOnFeedbackPage();
    }

    @Then("^Submit button becomes enabled$")
    public void submitButtonBecomesEnabled()  {
        feedbackPage.checkSubmitButtonState();
    }

    @And("^User selects (.*) option in the (.*) dropdown on About page editor toolbar$")
    public void selectOptionInDropDownInAboutEditor(String option, String dropdown) {
        aboutPage.selectOptionInDropDownInAboutEditor(option, dropdown);
    }

    @Then("^(.*) is selected in the (.*) dropdown on About page editor$")
    public void verifySelectedOptionInEditorOnAboutPage(String option, String dropdown) {
        aboutPage.isOptionSelectedInEditorOnAboutPage(option, dropdown);
    }

    @When("^User clicks on (.*) button in the editor toolbar on About Page$")
    public void clicksTheButtonOnEditor(String button) {
        aboutPage.clicksTheButtonOnEditor(button);
    }

    @Then("^(.*) button is selected on About Page$")
    public void verifyTheButtonIsSelectedOnAboutPageEditor(String button) {
        aboutPage.verifyTheButtonIsSelectedOnAboutPageEditor(button);
    }

    @When("^User selects value in editor form on About Page$")
    public void userSelectsValueInEditorFormOnAboutPage()  {
        aboutPage.selectValueInEditorFormOnAboutPage();
    }
}
