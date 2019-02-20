package com.trust.cucumber.steps;

import com.trust.cucumber.pages.FAQPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

/**
 * Created by shein on 9/11/2018.
 */
public class FAQPageSteps extends PageObject {
    private FAQPage faqPage;

    @Step
    public void userClicksOnCollapsedIconsOnAllSections() throws Exception {
        faqPage.userClicksOnCollapsedIconsOnAllSections();
    }

    @Step
    public void allSectionsAreCollapsed() {
        faqPage.allSectionsAreCollapsed();
    }

    @Step
    public void questionsAreNotDisplayed() {
        faqPage.questionsAreNotDisplayed();
    }

    @Step
    public void clickButton(String button) {
        faqPage.clickButton(button);
    }

    @Step
    public void verifySectionFormIsDisplayed() {
        faqPage.verifySectionFormIsDisplayed();
    }

    @Step
    public void setSectionName(String sectionName) {
        faqPage.setSectionName(sectionName);
    }

    @Step
    public void verifySectionIsDisplayed(String section, String state) {
        faqPage.verifySectionIsDisplayed(section, state);
    }

    @Step
    public void clickOnButtonInSection(String button, String section) {
        faqPage.clickOnButtonInSection(button, section);
    }

    @Step
    public void verifyQuestionFormIsDisplayed() {
        faqPage.verifyQuestionFormIsDisplayed();
    }

    @Step
    public void populateQuestionForm(String question, String accessLevel, String answer) {
        faqPage.populateQuestionForm(question, accessLevel, answer);
    }

    @Step
    public void populateTitleAndAccessLevelToQuestionForm(String question, String accessLevel) {
        faqPage.populateTitleAndAccessLevelToQuestionForm(question, accessLevel);
    }

    @Step
    public void movesCursorIntoEditorTextbox() {
        faqPage.movesCursorIntoEditorTextbox();
    }

    @Step
    public void populateAnswerInQuestionForm(String answer) {
        faqPage.populateAnswerInQuestionForm(answer);
    }

    @Step
    public void verifyQuestionIsDisplayed(String question, String state) {
        faqPage.verifyQuestionIsDisplayed(question, state);
    }

    @Step
    public void verifyAnswerIsDisplayed(String answer, String state) {
        faqPage.verifyAnswerIsDisplayed(answer, state);
    }

    @Step
    public void verifyButtonIsDisplayed(String button, String state) {
        faqPage.verifyButtonIsDisplayed(button, state);
    }

    @Step
    public void verifyButtonsAreDisplayedForAllSections(String button) {
        faqPage.verifyButtonsAreDisplayedForAllSections(button);
    }

    @Step
    public void verifyButtonsAreDisplayedForAllQuestions(String button) {
        faqPage.verifyButtonsAreDisplayedForAllQuestions(button);
    }

    @Step
    public void checkAccessLevelOptionsFAQ(List<String> expectedOptions) {
        List<String> actualOptions = faqPage.getAccessLevelOptionsFAQ();
        Assert.assertTrue(actualOptions.equals(expectedOptions));
    }

    @Step
    public void clickOnButtonInQuestion(String button, String question) {
        faqPage.clickOnButtonInQuestion(button, question);
    }

    @Step
    public void expandQuestion(String question) {
        faqPage.expandQuestion(question);
    }

    @Step
    public void expandSection(String section) {
        faqPage.expandSection(section);
    }

    @Step
    public void clickOnProceedButton() {
        faqPage.clickOnProceedButton();
    }

    @Step
    public void verifyQuestionWithAnswerIsDisplayed(String question, String answer) {
        faqPage.verifyQuestionWithAnswerIsDisplayed(question, answer);
    }

    @Step
    public void expandAllQuestion() {
        faqPage.expandAllQuestion();
    }

    @Step
    public void clicksOnFormattingButton(String button) {
        faqPage.clicksOnFormattingButton(button);
    }

    @Step
    public void verifyFormattingButtonIsSelected(String button) {
        faqPage.verifyFormattingButtonIsSelected(button);
    }

    @Step
    public void selectOptionInDropDownInEditor(String option, String dropdown) {
        faqPage.selectOptionInDropDownInEditor(option, dropdown);
    }

    @Step
    public void verifySelectedOptionInDropDownInEditor(String option, String dropdown) {
        faqPage.verifySelectedOptionInDropDownInEditor(option, dropdown);
    }

    @Step
    public void verifyAnswerFormatting(String answer) {
        faqPage.verifyAnswerFormatting(answer);
    }
}
