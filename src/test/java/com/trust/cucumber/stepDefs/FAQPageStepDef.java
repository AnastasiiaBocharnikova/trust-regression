package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.FAQPageSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by shein on 9/11/2018.
 */
public class FAQPageStepDef {
    @Steps
    private FAQPageSteps faqPageSteps;

    @When("^User clicks on collapsed icons on all sections$")
    public void userClicksOnCollapsedIconsOnAllSections() throws Exception {
        faqPageSteps.userClicksOnCollapsedIconsOnAllSections();
    }

    @Then("^All sections are collapsed$")
    public void allSectionsAreCollapsed() {
        faqPageSteps.allSectionsAreCollapsed();
    }


    @And("^Questions are not displayed$")
    public void questionsAreNotDisplayed() {
        faqPageSteps.questionsAreNotDisplayed();
    }

    @When("^User clicks on (.*) button on FAQ page$")
    public void userClicksOnWorstStatusButton(String button) {
        faqPageSteps.clickButton(button);
    }

    @Then("^Section form is displayed$")
    public void verifySectionFormIsDisplayed()  {
        faqPageSteps.verifySectionFormIsDisplayed();
    }

    @When("^User enters (.*) to section name input field$")
    public void userEntersTimezoneInputField(String sectionName) {
        faqPageSteps.setSectionName(sectionName);
    }

    @Then("^(.*) section is (.*) displayed on FAQ page$")
    public void verifySectionIsDisplayed(String section, String state) {
        faqPageSteps.verifySectionIsDisplayed(section, state);
    }

    @When("^User clicks on (.*) button for (.*) section$")
    public void clickOnButtonInSection(String button, String section) {
        faqPageSteps.clickOnButtonInSection(button, section);
    }

    @Then("^Question form is displayed$")
    public void verifyQuestionFormIsDisplayed() {
        faqPageSteps.verifyQuestionFormIsDisplayed();
    }

    @Then("^Next access level options are displayed in the Question form$")
    public void checkAccessLevelOptionsFAQ(List<String> arg) {
        faqPageSteps.checkAccessLevelOptionsFAQ(arg);
    }

    @When("^User populates Question form with (.*) Question, (.*) Access level and (.*) Answer$")
    public void populateQuestionForm(String question, String accessLevel, String answer) {
        faqPageSteps.populateQuestionForm(question, accessLevel, answer);
    }

    @When("^User populates Question form with (.*) Question, (.*) Access level$")
    public void populateTitleAndAccessLevelToQuestionForm(String question, String accessLevel) {
        faqPageSteps.populateTitleAndAccessLevelToQuestionForm(question, accessLevel);
    }

    @When("^User moves cursor into editor textbox$")
    public void movesCursorIntoEditorTextbox() {
        faqPageSteps.movesCursorIntoEditorTextbox();
    }

    @When("^User populates (.*) Answer to Question form$")
    public void populateAnswerInQuestionForm(String answer) {
        faqPageSteps.populateAnswerInQuestionForm(answer);
    }

    @Then("^(.*) question is (.*) displayed on FAQ page$")
    public void verifyQuestionIsDisplayed(String question, String state) {
        faqPageSteps.verifyQuestionIsDisplayed(question, state);
    }

    @Then("^(.*) answer is (.*) displayed on FAQ page$")
    public void verifyAnswerIsDisplayed(String answer, String state) {
        faqPageSteps.verifyAnswerIsDisplayed(answer, state);
    }

    @Then("^(.*) button is (.*) displayed on FAQ page$")
    public void verifyButtonIsDisplayed(String button, String state) {
        faqPageSteps.verifyButtonIsDisplayed(button, state);
    }

    @Then("^(.*) buttons are displayed for all sections on FAQ page$")
    public void verifyButtonsAreDisplayedForAllSections(String button) {
        faqPageSteps.verifyButtonsAreDisplayedForAllSections(button);
    }

    @Then("^(.*) buttons are displayed for all questions on FAQ page$")
    public void verifyButtonsAreDisplayedForAllQuestions(String button) {
        faqPageSteps.verifyButtonsAreDisplayedForAllQuestions(button);
    }

    @When("^User clicks on (.*) button for (.*) question")
    public void clickOnButtonInQuestion(String button, String question) {
        faqPageSteps.clickOnButtonInQuestion(button, question);
    }

    @When("^User expands the (.*) question$")
    public void expandQuestion(String question) {
        faqPageSteps.expandQuestion(question);
    }

    @When("^User expands the (.*) section")
    public void expandSection(String section) {
        faqPageSteps.expandSection(section);
    }

    @And("^User clicks on Proceed modal button$")
    public void userClicksOnProceedModalButton() {
        faqPageSteps.clickOnProceedButton();
    }

    @And("^(.*) question with answer (.*) is displayed$")
    public void verifyQuestionWithAnswerIsDisplayed(String question, String answer) {
        faqPageSteps.verifyQuestionWithAnswerIsDisplayed(question, answer);
    }

    @And("^User expands all questions on FAQ page$")
    public void expandAllQuestion() {
        faqPageSteps.expandAllQuestion();
    }

    @When("^User clicks on (.*) button in the editor toolbar$")
    public void clicksOnFormattingButton(String button) {
        faqPageSteps.clicksOnFormattingButton(button);
    }

    @Then("^(.*) button is selected$")
    public void verifyFormattingButtonIsSelected(String button) {
        faqPageSteps.verifyFormattingButtonIsSelected(button);
    }

    @When("^User selects (.*) option in the (.*) dropdown on the editor toolbar$")
    public void selectOptionInDropDownInEditor(String option, String dropdown) {
        faqPageSteps.selectOptionInDropDownInEditor(option, dropdown);
    }

    @When("^(.*) is selected in the (.*) dropdown$")
    public void verifySelectedOptionInDropDownInEditor(String option, String dropdown) {
        faqPageSteps.verifySelectedOptionInDropDownInEditor(option, dropdown);
    }

    @Then("^Formatted answer \"(.*)\" is displayed$")
    public void verifyAnswerFormatting(String answer) {
        faqPageSteps.verifyAnswerFormatting(answer);
    }
}
