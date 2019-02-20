package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.LaunchAndLoginPageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LaunchAndLoginPageStepDef {
	
	@Steps
	LaunchAndLoginPageSteps cfs;

	@Given("^User launches application$")
	public void instantiate() {
		cfs.launchapp();
	}

	@And("^Login with valid admin credentials$")
	public void loginApp() {
			cfs.loginApp();
		}

	@And("^Splash page is displayed by default for admin users")
	public void defaultPage() {
		cfs.defaultPageSplash();
		}
	
	@And("^Login with (.*) username and (.*) password$")
	public void loginApp(String userName, String password) {
		cfs.clickSignInButton();
		cfs.login(userName, password);
	}
}


