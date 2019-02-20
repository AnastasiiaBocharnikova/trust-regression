package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.LoginSteps;
import com.trust.cucumber.util.Environment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import org.aeonbits.owner.ConfigFactory;

public class LoginStepDef {

	Environment testEnvironment  = ConfigFactory.create(Environment.class);


	@Steps
    LoginSteps userLogsIn;



	public String env = testEnvironment.env();
	public String username = testEnvironment.username();
	public String password = testEnvironment.password();


	@Given("^User launches application1$")
	public void instantiate() {
        userLogsIn.launchapp(env);
	}

	@When("^User Navigates to LoginPage1$")
	public void openLoginPage() {userLogsIn.goToLoginPage();}

	@And("^Login with valid admin credentials1$")
	public void loginApp() {
        userLogsIn.loginApp(username, password);
		}

	@And("^Login with (.*) and (.*) credentials$")
	public void loginAppWithCred(String username, String password) {
		userLogsIn.loginApp(username, password);
	}
}


