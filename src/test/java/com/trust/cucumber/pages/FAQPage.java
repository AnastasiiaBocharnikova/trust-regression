package com.trust.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

/**
 * Created by shein on 9/11/2018.
 */
public class FAQPage extends PageObject {
    @FindBy(css = "#section-form-name-field")
    private WebElementFacade sectionFormNameField;

    @FindBy (css = "#expand-section")
    private List<WebElementFacade> expandCollapseSectionButtons;

    @FindBy (xpath = "//div[contains(@class,'Faq_sectionNode_1o_au')]")
    private List<WebElementFacade> listOfFAQSections;

    @FindBy (xpath = "//div[contains(@class,'Faq_expandedPanelTitle_3-KPa')]")
    private List<WebElementFacade> listOfQuestions;

    @FindBy (css = "div.Search_suggestionContainer_3Gnz9>div>div")
    private List <WebElementFacade> autoSuggestOptions;

    @FindBy (xpath = "//button[@aria-expanded='false']")
    private List <WebElementFacade> listOfCollapsedQuestions;

    @FindBy(xpath = "//div[@class='DraftEditor-editorContainer']")
    private WebElement editorTextBox;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement messageTextBox;

    private void replaceValueInfield(WebElement element, String value) {
        if(value != null && !value.isEmpty()){
            element.clear();
            element.sendKeys(value);
        }
    }

    public void userClicksOnCollapsedIconsOnAllSections() {
       for (int i = 0; i < listOfFAQSections.size(); i++) {
           if (expandCollapseSectionButtons.get(i).getText().contains("keyboard_arrow_up")) {
               expandCollapseSectionButtons.get(i).click();
           }
       }
    }

    public void allSectionsAreCollapsed() {
        findAll("//span[text()='keyboard_arrow_down']").forEach(arrowDown -> shouldBeVisible(arrowDown));
        findAll("//span[text()='keyboard_arrow_up']").forEach(arrowUp -> shouldBeVisible(arrowUp));
    }

    public void questionsAreNotDisplayed() {
        Assert.assertFalse(listOfQuestions.size()>0);
    }

    public void clickButton(String button) {
        clickOn($("#" + button +"-btn"));
    }

    public void verifySectionFormIsDisplayed() {
        shouldBeVisible(By.xpath("//form[@id='section-form']"));
    }

    public void setSectionName(String sectionName) {
        replaceValueInfield(sectionFormNameField, sectionName);
    }

    public List<String> getAccessLevelOptionsFAQ () {
        $("#access-level-field").click();
        return autoSuggestOptions.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void selectAccessLevelOptionFAQ (String accessLevel) {
        $("#access-level-field").click();
        for (WebElementFacade option : autoSuggestOptions) {
            if (accessLevel.equals(option.getText())) {
                option.click();
                break;
            }
        }
    }

    public void verifySectionIsDisplayed(String section, String state) {
        switch (state) {
            case "not": shouldNotBeVisible(By.xpath("//div[contains(@class,'Faq_sectionNode_1o_au')]//p[text()='" + section + "']"));
                break;
            default: shouldBeVisible(By.xpath("//div[contains(@class,'Faq_sectionNode_1o_au')]//p[text()='" + section + "']"));
                break;
        }
    }

    public void clickOnButtonInSection(String button, String section) {
        clickOn(find(By.xpath("//div[contains(@class,'Faq_sectionNode_1o_au')]//p[text()='" + section + "']/following-sibling::div/button[@id='" + button +"-btn']")));
    }

    public void verifyQuestionFormIsDisplayed() {
        shouldBeVisible(By.xpath("//h6[contains(text(),'Question')]"));
    }

    public void populateQuestionForm(String question, String accessLevel, String answer) {
        replaceValueInfield($("#question-field"),question);
        selectAccessLevelOptionFAQ(accessLevel);
        editorTextBox.click();
        replaceValueInfield(messageTextBox,answer);
    }

    public void populateTitleAndAccessLevelToQuestionForm(String question, String accessLevel) {
        replaceValueInfield($("#question-field"),question);
        selectAccessLevelOptionFAQ(accessLevel);
    }

    public void movesCursorIntoEditorTextbox() {
        editorTextBox.click();
    }

    public void populateAnswerInQuestionForm(String answer) {
        replaceValueInfield(messageTextBox,answer);
    }

    public void verifyQuestionIsDisplayed(String question, String state) {
        switch (state) {
            case "not": shouldNotBeVisible(By.xpath("//span[@class='Faq_question_1Bqlt'][text()='" + question + "']"));
                break;
            default: shouldBeVisible(By.xpath("//span[@class='Faq_question_1Bqlt'][text()='" + question + "']"));
                break;
        }
    }

    public void verifyAnswerIsDisplayed(String answer, String state) {
        switch (state) {
            case "not": shouldNotBeVisible(By.xpath("//div[@class='Faq_answer_1PnRB']//p[text()='" + answer + "']"));
                break;
            default: shouldBeVisible(By.xpath("//div[@class='Faq_answer_1PnRB']//p[text()='" + answer + "']"));
                break;
        }
    }

    public void verifyQuestionWithAnswerIsDisplayed(String question, String answer) {
        shouldBeVisible(By.xpath("//span[@class='Faq_question_1Bqlt'][text()='" + question + "']//ancestor::div/div[contains(@id, 'panel')]//div[@class='Faq_answer_1PnRB']//p[text()='" + answer + "']"));
    }

    public void verifyButtonIsDisplayed(String button, String state) {
        switch (state) {
            case "not": shouldNotBeVisible(By.cssSelector("#" + button +"-btn"));
                break;
            default: shouldBeVisible(By.cssSelector("#" + button +"-btn"));
                break;
        }
    }

    public void verifyButtonsAreDisplayedForAllSections(String button) {
        List <WebElementFacade> buttons = findAll("#" + button +"-btn");
        Assert.assertTrue(buttons.size() == listOfFAQSections.size());
    }

    public void verifyButtonsAreDisplayedForAllQuestions(String button) {
        List <WebElementFacade> buttons = findAll("#" + button +"-btn");
        Assert.assertTrue(buttons.size() == listOfQuestions.size());
    }

    public void clickOnButtonInQuestion(String button, String question) {
        clickOn(find(By.xpath("//div[contains(@class,'Faq_expandedPanelTitle_3-KPa')]//span[text()='" + question + "']/following-sibling::div/button[@id='" + button +"-btn']")));
    }

    public void expandQuestion(String question) {
        if ($("//button[@aria-expanded='false']/following-sibling::div/span[text()='" + question + "']").isDisplayed()) {
            $("//button[@aria-expanded='false']/following-sibling::div/span[text()='" + question + "']").click();
        }
    }

    public void expandAllQuestion() {
        listOfCollapsedQuestions.forEach(WebElementFacade::click);
    }

    public void expandSection(String section) {
        if ($("//span[@id='expand-section'][text()='keyboard_arrow_down']/following-sibling::p[text()='" + section + "']").isDisplayed()) {
            $("//span[@id='expand-section'][text()='keyboard_arrow_down']/following-sibling::p[text()='" + section + "']").click();
        }
        else
            fail();
    }

    public void clickOnProceedButton() {
        $("#modal-button-proceed").click();
    }

    public void clicksOnFormattingButton(String button) {
        $("//div[@title='"+button+"']").click();
    }

    public void verifyFormattingButtonIsSelected(String button) {
        shouldBeVisible(By.xpath("//div[@title='"+button+"'][@aria-selected='true']"));
    }

    public void selectOptionInDropDownInEditor(String option, String dropdown) {
        $("//a[@title='"+dropdown+"']").click();
        $("//li[text()='"+option+"']").click();
    }

    public void verifySelectedOptionInDropDownInEditor(String option, String dropdown) {
        shouldBeVisible(By.xpath("//a[@title='"+dropdown+"']/span[text()='"+option+"']"));
    }

    public void verifyAnswerFormatting(String answer) {
        shouldBeVisible(By.xpath("//div[@class='Faq_answer_1PnRB']/h2[@style='text-align:center;']/span[@style='font-size: 18px;']/del/strong/em/ins[text()='"+answer+"']"));
    }
}
