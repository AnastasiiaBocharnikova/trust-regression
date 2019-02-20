package com.trust.cucumber.steps;

import com.trust.cucumber.pages.StatusPage;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

/**
 * Created by shein on 8/17/2018.
 */
public class StatusPageSteps extends PageObject {
    private StatusPage statusPage;

    @Step
    public void verifyFirstColumn(List<String> expectedList) {
        List<String> actualHeaders = statusPage.getListOfElementsFirstColumn();
        expectedList.forEach(name -> Assert.assertTrue(actualHeaders.contains(name)));
    }

    @Step
    public void compareVersionsInAdminMenuAPIVersionAndCodeRevisionVersion() {
        statusPage.compareVersionsInAdminMenuAPIVersionAndCodeRevisionVersion();
    }

    @Step
    public void navigatesToStatusPageByLink() {
        statusPage.navigatesToStatusPageByLink();
    }

    @Step
    public void verifyNoEmptyValueInTheSecondColumn() {
        statusPage.verifyNoEmptyValueInTheSecondColumn();
    }

    @Step
    public void verifyDirectLinksToNodes() {
        statusPage.verifyDirectLinksToNodesAreNotEmpty();
    }

    @Step
    public void clickOnIndividualNodeLink(int node) {
        statusPage.clickOnIndividualNodeLink(node);
    }

    @Step
    public void closeTab() {
        statusPage.closeTab();
    }
}
