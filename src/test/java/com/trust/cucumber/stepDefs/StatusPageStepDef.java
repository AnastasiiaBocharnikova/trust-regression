package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.StatusPageSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;

/**
 * Created by shein on 8/17/2018.
 */
public class StatusPageStepDef {
    @Steps
    private StatusPageSteps statusPageSteps;

    @And("^Status page contains info about$")
    public void verifyFirstColumn(List<String> arg) {
        statusPageSteps.verifyFirstColumn(arg);
    }

    @And("^The same version is displayed in admin menu, API version and Code revision version$")
    public void compareVersionsInAdminMenuAPIVersionAndCodeRevisionVersion() {
        statusPageSteps.compareVersionsInAdminMenuAPIVersionAndCodeRevisionVersion();
    }

    @When("^User navigates to Status page by link$")
    public void navigatesToStatusPageByLink() {
        statusPageSteps.navigatesToStatusPageByLink();
    }

    @And("^There is no empty value in the second column$")
    public void verifyNoEmptyValueInTheSecondColumn() {
        statusPageSteps.verifyNoEmptyValueInTheSecondColumn();
    }

    @And("^There are direct links to nodes$")
    public void verifyDirectLinksToNodes() {
        statusPageSteps.verifyDirectLinksToNodes();
    }
    @When("User clicks on the (\\d+) link to individual nodes$")
    public void clickOnIndividualNodeLink(int node) {
        statusPageSteps.clickOnIndividualNodeLink(node);
    }

    @When("User closes the individual node tab$")
    public void closeTab() {
        statusPageSteps.closeTab();
    }
}
