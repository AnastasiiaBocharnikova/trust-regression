package com.trust.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.trust.cucumber.util.Log;

public class LaunchAndLogin extends PageObject {
	
	String username = "auto-test";
	String password = "2018Auto@!";
	String env = "https://techcheck-stage2.cengage.com/";

	public LaunchAndLogin (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Sign In')]" )
	private List <WebElement> signInButton;
	
	@FindBy(name = "userName" )
	private WebElement userNameTextBox;
	
	@FindBy(name = "password" )
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//span[contains(@class,'internalBtn')]//span[input]" )
	private WebElement internalUserButton;

	public void launchApplication() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(env);
	}
	
	public void clickSignInButton() {
		signInButton.get(0).click();
	}
	
	public void loginNew(String username,String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		signInButton.get(2).click();		
	}


	public void login(String user, String pass) {
		clickOn($("//span[contains(text(), 'Sign In')]"));
		Log.info("Clicked on Sign In button");
		typeInto($("//input[@name='userName']"), user);
		typeInto($("//input[@name='password']"), pass);
		clickOn($("(//div[@class='LoginForm_loginForm_1JLJo']//..//span[text()='Sign In'])"));
		Log.info("Clicked on Sign In button in the Login Form");
        waitABit(4000);
		Assert.assertEquals("[FAILED]: User did NOT login the application", "You are successfully logged in",
				$("//button[text()='✖']//..//div[1][text()='You are successfully logged in']").getText());
		Log.info("Successfully logged into the application");
	}

	public void loginApp() {
		login(username,password);
	}

	public void defaultPageSplash() {
		Log.info("Verify default page");
		System.out.println("Url : " + getDriver().getCurrentUrl());
		//Assert.assertEquals(getDriver().getCurrentUrl().toString(), "https://techcheck-qa2.cengage.com/");
		Assert.assertEquals(getDriver().getCurrentUrl(), env);
		Log.info("Splash page is displayed as default page for users");
	}


}

  


