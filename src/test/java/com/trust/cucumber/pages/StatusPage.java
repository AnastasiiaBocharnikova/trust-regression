package com.trust.cucumber.pages;

import com.trust.cucumber.util.Environment;
import com.trust.cucumber.util.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shein on 8/17/2018.
 */
public class StatusPage extends PageObject {
    private Environment testEnvironment  = ConfigFactory.create(Environment.class);

    public StatusPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[1]")
    private List<WebElementFacade> listOfElementsFirstColumn;

    @FindBy(xpath = "//td[2]")
    private List<WebElementFacade> listOfElementsSecondColumn;

    @FindBy(xpath = "//td[2]//a[contains(text(),'.cloud.')]")
    private List<WebElementFacade> listOfLinksToNodes;

    public String env = testEnvironment.env();

    public void navigatesToStatusPageByLink() {
        getDriver().get(env+"status");
    }

    public List<String> getListOfElementsFirstColumn() {
        return listOfElementsFirstColumn.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void compareVersionsInAdminMenuAPIVersionAndCodeRevisionVersion() {
        String API_Version = listOfElementsSecondColumn.get(0).getText();
        String CodeRevisionVersion = listOfElementsSecondColumn.get(1).getText();
        String versionInAdminMenu = $("//a/div/span[contains(text(),'Status')]/span").getText();
        Assert.assertTrue(versionInAdminMenu.contains(API_Version));
        Assert.assertTrue(versionInAdminMenu.contains(CodeRevisionVersion));
    }

    public void verifyNoEmptyValueInTheSecondColumn() {
        List<String> listOfSecondColumn = listOfElementsSecondColumn.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        Assert.assertFalse((listOfSecondColumn.contains(""))||(listOfSecondColumn.contains(null)));
    }

    public void verifyDirectLinksToNodesAreNotEmpty () {
        Assert.assertNotNull(listOfLinksToNodes);
    }

    public void clickOnIndividualNodeLink (int node) {
        listOfLinksToNodes.get(node-1).click();
        ArrayList<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(1));
        System.out.println("Url : " + getDriver().getCurrentUrl());
    }

    public void closeTab() {
        ArrayList<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().close();
        getDriver().switchTo().window(browserTabs.get(0));
    }
}
