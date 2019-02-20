package com.trust.cucumber.pages;

import com.trust.cucumber.util.Log;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(headerLoginPage).waitUntilVisible();
        Log.info("On login page");
    }
    @FindBy(xpath = "//h3[contains(text(), 'Login')]")
    private WebElementFacade headerLoginPage;

    @FindBy(xpath = "(//div[@class='LoginForm_loginForm_1JLJo']//..//span[text()='Sign In'])")
    private WebElementFacade buttonSingIn;

    @FindBy(name = "userName")
    private WebElementFacade userNameTextBox;

    @FindBy(xpath = "//button/span[contains(text(),'Logout')]")
    private WebElementFacade buttonLogout;

    @FindBy(name = "password")
    private WebElementFacade passwordTextBox;

    @FindBy(xpath = "/span[contains(@class,'internalBtn')]//span[input]")
    private WebElement internalUserButton;

    public void loginApp(String username,String password){
        typeInto(userNameTextBox, username);
        typeInto(passwordTextBox, password);
        buttonSingIn.click();
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(buttonLogout);
    }

    public boolean singinButtonIsVisible() {
        return element(buttonSingIn).isVisible();
    }
    
    public void clickLogoutButton() {
    	buttonLogout.click();
    }
}
