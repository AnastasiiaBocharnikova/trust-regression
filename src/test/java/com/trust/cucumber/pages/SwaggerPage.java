package com.trust.cucumber.pages;

import com.trust.cucumber.util.Log;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SwaggerPage extends PageObject{

    WebDriver driver;

    public SwaggerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement header;

    @FindAll(@FindBy(css = ".opblock-tag>a>span"))
    private List<WebElement> allModulesArray;

    @FindBy(css = "#operations-Faq-get_faq")
    private WebElement getFAQoperation;

    @FindBy(css = ".try-out>button")
    private WebElement tryItOutButton;

    @FindBy(css = ".execute-wrapper>button")
    private WebElement executeButton;

    @FindBy(css = ".response>td[class=\"col response-col_status\"]")
    private WebElement responseCode;



    public void openSwagger(String env) {
        getDriver().get(env + "swagger");
    }

    public void isItSwaggerPage() {
        Assert.assertTrue(header.getText().contains("Techcheck API"));
    }

    public void areModulesVisible(List<String> expectedModules) {
        List<String> modulesNamesList = new ArrayList<String>();

        for (WebElement element: allModulesArray) {
            modulesNamesList.add(element.getText().trim());
        }

        Log.info("Expected Swagger modules: " + expectedModules);
        Log.info("Actual Swagger modules: " + modulesNamesList);

        Assert.assertTrue(modulesNamesList.containsAll(expectedModules));

    }

    public void userClicksOnGETFAQOperation() {
        clickOn(getFAQoperation);
    }

    public void isSectionExpanded() {
        Assert.assertTrue("FAQ section is not expanded", getFAQoperation.getAttribute("class").contains("is-open"));
    }

    public void clickOnTryItOutButton() {
        clickOn(tryItOutButton);
    }

    public void isExecuteButtonDisplayed() {
        shouldBeVisible(executeButton);
    }


    public void clickOnExecuteButton() {
        clickOn(executeButton);
    }

    public void checkResponseHTTPcode(String code) {
        Assert.assertTrue(responseCode.getText().contains(code));

    }
}
