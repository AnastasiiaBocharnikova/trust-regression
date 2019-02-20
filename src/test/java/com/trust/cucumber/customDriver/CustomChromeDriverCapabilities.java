package com.trust.cucumber.customDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.thucydides.core.webdriver.DriverSource;

public class CustomChromeDriverCapabilities implements DriverSource {
	WebDriver driver;
	
	public WebDriver newDriver() {
		System.setProperty("webdriver.chrome.driver", "src//test//resources//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public boolean takesScreenshots() {
		return true;
	}

}
