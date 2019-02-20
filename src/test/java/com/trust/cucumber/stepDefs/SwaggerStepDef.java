package com.trust.cucumber.stepDefs;

import com.trust.cucumber.pages.SwaggerPage;
import com.trust.cucumber.util.Environment;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aeonbits.owner.ConfigFactory;

import java.util.List;

public class SwaggerStepDef {

    Environment testEnvironment  = ConfigFactory.create(Environment.class);
    public String env = testEnvironment.env();


    SwaggerPage swaggerPage;

	@When("^User opens Swagger page$")
	public void openSwagger() {
		swaggerPage.openSwagger(env);
	}

    @Then("^User is on Swagger page$")
    public void userIsOnSwaggerPage()  {
        swaggerPage.isItSwaggerPage();
    }

    @And("^User is able to see modules on Swagger page$")
    public void userIsAbleToSeeModulesOnSwaggerPage(List<String> modules)  {
        swaggerPage.areModulesVisible(modules);
    }

    @When("^User clicks on GET FAQ operation$")
    public void userClicksOnGETFAQOperation()  {
        swaggerPage.userClicksOnGETFAQOperation();
    }

    @Then("^FAQ operation is expanded$")
    public void faqOperationIsExpanded() {
        swaggerPage.isSectionExpanded();
    }

    @When("^User clicks on Try it out button$")
    public void userClicksOnTryItOutButton() {
        swaggerPage.clickOnTryItOutButton();
    }

    @Then("^Execute button is displayed$")
    public void executeButtonIsDisplayed() {
        swaggerPage.isExecuteButtonDisplayed();

    }

    @When("^User clicks on Execute button$")
    public void userClicksOnExecuteButton() {
        swaggerPage.clickOnExecuteButton();
    }

    @Then("^Swagger returns (\\d+) response code$")
    public void swaggerReturnsResponseCode(String code)  {
        swaggerPage.checkResponseHTTPcode(code);
    }
}
