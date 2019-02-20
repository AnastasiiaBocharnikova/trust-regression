package com.trust.cucumber.steps;

import com.trust.cucumber.pages.LaunchAndLogin;

import net.thucydides.core.annotations.Step;

public class LaunchAndLoginPageSteps {

	LaunchAndLogin cf;

	@Step
	public void launchapp() {
		cf.launchApplication();
	}
	
	@Step
	public void clickSignInButton() {
		cf.clickSignInButton();
	}

	@Step
	public void loginApp() {
		cf.loginApp();
	}
	
	@Step
	public void login(String userName, String password) {
		cf.loginNew(userName, password);
	}


	@Step
	public void defaultPageSplash() {
		cf.defaultPageSplash();
	}
}
