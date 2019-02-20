package com.trust.cucumber.steps;

import com.trust.cucumber.pages.SplashPage;
import com.trust.cucumber.pages.LoginPage;

import net.thucydides.core.annotations.Step;


/**
 * Created by Tatyana B on 5/16/18.
 */
public class LoginSteps {

    LoginPage loginPage;
    SplashPage splashPage;
    


    @Step
    public void launchapp(String env) {
        splashPage.openTechCheck(env);

    }

    @Step
    public void loginApp(String username, String password) {
        loginPage.loginApp(username,password);

    }

    @Step
    public void goToLoginPage() {
        splashPage.navigateToLoginPage();
        loginPage.singinButtonIsVisible();
    }
}
