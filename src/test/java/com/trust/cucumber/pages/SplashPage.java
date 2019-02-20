package com.trust.cucumber.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.trust.cucumber.util.Wait;
import net.thucydides.core.pages.components.HtmlTable;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;

import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trust.cucumber.util.Log;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedCondition;
import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;
import static com.trust.cucumber.support.Constants.WHITE;

public class SplashPage extends PageObject {


    public SplashPage(WebDriver driver) {
        super(driver);
    }

    private Wait wait = new Wait(getDriver());



    public void openTechCheck(String env) {
       getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       getDriver().manage().deleteAllCookies();
       getDriver().manage().window().fullscreen();//.maximize();
       Log.info("ENV " + env);
       getDriver().get(env);
       wait.waitForPageLoad();
    }

    @FindBy(css = "#sign-in-btn")
    private WebElementFacade buttonSingIn;

    @FindBy(xpath = "//a[contains(@href,'/support')]" )
	private WebElement NeedProductSupportLink;

	@FindBy(css = "#cengage-link" )
	private WebElement cengageIcon;
	
	@FindBy(css = "#change-region-btn" )
	private WebElementFacade selectRegionButton;
	
	@FindBy(xpath = "//ul[contains(@class,'SplashPage_selectRegionList')]//li" )
	private List <WebElement> regionsSection;
	
	@FindBy(xpath = "//span[text()='Ok']" )
	private WebElement okButton;
	
	@FindBy(xpath = "//span[text()='menu']" )
	private WebElement systemMenuIcon;
	
	@FindBy(xpath = "//ul[contains(@class,'Layout_list')]//a" )
	private List <WebElement> adminMenuOptions;
	
	@FindBy(xpath = "//ul[contains(@class,'Layout_list')]" )
	private WebElement adminMenu;
	
	@FindBy (xpath = "//div[contains(@class,'SplashPage_system_')]")
	private List <WebElementFacade> systemCards;
		
	@FindBy (css = "div.SplashPage_systemsMap_2MfGh")
	private WebElement systemsMap;
	
	@FindBy (xpath = "//div[contains(@class,'SplashPage_group_')]")
	private List <WebElementFacade> groupSections; 
	
	@FindBy (xpath = "//div[contains(@class,'DataTable_table')]/table")
    private List<WebElementFacade> notificationTables;

    @FindBy(xpath ="//div[text()='Other systems']/parent::div[contains(@id,'group')]//div[contains(@class,'DataTable_tableContainer')]/table")
    private WebElement otherSystemsNotificationsTable;

    @FindBy (css = "div.ReactTable table tbody")
    private WebElement noHeadingsTable;

    @FindBy (css = "#institution-menu-button")
    private WebElementFacade instLogin;

    @FindBy (xpath = "//span[contains(@class,'UserProfile_internalBtn_udN2M')]")
    private WebElementFacade internalSwitch;

    @FindBy (css = "#worst-status-btn>span>div>div>div")
    private WebElementFacade worstStatusButton;

    @FindBy(css = "div[class*='SplashPage_statusImg']")
    private List<WebElementFacade> cardsColorsArray;
    @FindBy(xpath = "//div//button//span[contains(text(), 'more_vert')]")
	private WebElementFacade signInCover;

    @FindBy(id = "signIn")
	private WebElementFacade signInHidden;

    @FindBy(css ="div[class*='Banner_banner']>p")
    private WebElementFacade bannerBody;

    @FindBy(css ="#expand-banner")
    private WebElementFacade bannerHeader;

    @FindBy(css ="#tz-selection-btn>span>div")
    private WebElementFacade changeTimezoneButton;

    @FindBy(xpath ="//div[contains(@title,'Select timezone')]//h6")
    private WebElementFacade changeTimezoneForm;

    @FindBy(css ="#single-dropdown-field")
    private WebElementFacade timeZoneInputField;

    @FindBy (css = "span[class*='Flag']")
    private WebElement bannerFlag;

    @FindBy (css = "#notifications_table")
    private WebElement anyNotificationTableOnSplashPage;


	public void clickNeedSupportLink() {
		NeedProductSupportLink.click();		
	}


	public void clickCengageIcon() {
		cengageIcon.click();		
	}

	public void selectRegion(String region) {
		selectRegionButton.click();
		for (WebElement option : regionsSection) {
			if (region.equals(option.getText())) 
				option.click();
		}	
		okButton.click();
		shouldBeVisible(selectRegionButton);
        waitForCondition().until(regionIsUpdated(region));
	}

	//stability fix
    private ExpectedCondition regionIsUpdated(String reg) {
        return (ExpectedCondition<Boolean>) driver -> (selectRegionButton.getText().equalsIgnoreCase(reg));}

	public void selectMenuOption(String menuItem) {
		for (WebElement option : adminMenuOptions) {
			if (menuItem.equals(option.getText())) 
				option.click();
		}	
	}

	public void clickSystemMenuIcon() {
		systemMenuIcon.click();	
	}
	
	public void adminMenuShouldNotBeVisible() {
		shouldNotBeVisible(adminMenu);
	}
			
	public void selectSubMonitor (int monitor, int submonitor) {
		List<WebElementFacade> cardsWithSubMonitors = findAll(By.xpath("//div[contains(@class,'SplashPage_statusRow')]/span//span[1]/ancestor::div[contains(@class,'SplashPage_system_')]"));
		cardsWithSubMonitors.get(monitor).find(By.xpath(".//span//span[1]")).click();
		cardsWithSubMonitors.get(monitor).findElements(By.xpath(".//div/h3")).get(submonitor).click();
	}
			
	public void clickCollapseAllButton() {
		clickOn($("#collapse-all-btn"));	
	}

	public void systemCardsAreNotDisplayed() {
		shouldNotBeVisible(systemsMap);
		}

	public void clickExpandAllButton() {
		clickOn($("#expand-all-btn"));		
	}

	public void systemCardsAreDisplayed() {
		shouldBeVisible(systemsMap);	
	}


	
	public List<String> getSystemCardsNameforGroup() {
		List<WebElementFacade> systems = groupSections.get(0).thenFindAll(By.xpath(".//div[contains(@class,'SplashPage_system_')]"));
		List<String> systemNames = new ArrayList<String>();
		for (WebElementFacade card: systems) {
			if (card.containsElements(By.tagName("p"))) {
				systemNames.add(card.find(By.tagName("p")).getText());
			} else systemNames.add(card.find(By.xpath(".//div[contains(@class,'SplashPage_media_1')]")).getAttribute("title").split("\\.")[0]);
		}
		return systemNames;
	}
	
	public List<String> getSystemNamesFromNotificationTable() {
		List<Map<Object, String>> tableContent = rowsFrom(notificationTables.get(0));
		List<String> systemsList = new ArrayList<String>();
		for (Map<Object, String> row : tableContent) {
			String[] cellValue = row.get("Systems").split(",");
			List<String> systemsInCell = new ArrayList<String>(cellValue.length);
				for (String s:cellValue){
					systemsInCell.add(s.trim());
				}
			systemsList.addAll(systemsInCell);		
		}
		return systemsList;
	}
	
	public void verifyPublicSystemCardsColor() {
		for (WebElementFacade color: systemCards) {
			Assert.assertEquals(WHITE, color.find(By.xpath("(//div[contains(@class,'SplashPage_mediaRow')])")).getCssValue("background-color"));
		}
	}
    public void isCurrentPageSplash(String env) {
        waitForAngularRequestsToFinish();
        Assert.assertEquals(getDriver().getCurrentUrl(), env);
    }
    public void clickOnSystemCardByName(String systemName) {
	    try {
            clickOn($("//div[contains(@title,'" + systemName + "')]"));
        }catch (ElementShouldBeEnabledException e) {
            clickOn(find(By.xpath("//div/p[contains(text(),'" + systemName + "')]")));
        }
    }

    public void navigateToLoginPage() {
		if
				(buttonSingIn.isPresent()) {
			buttonSingIn.click();
		}
		else {
			signInCover.click();
			signInHidden.click();
		}
	}


    public void isLoginValueExpected(String institution) {
        Assert.assertTrue(instLogin.getText().contains(institution));
    }

    public void isLoginButtonAbsent() {
        shouldNotBeVisible(buttonSingIn);
    }

    public void isInternalSwitchAbsent() {
        shouldNotBeVisible(internalSwitch);
    }

    public void clickOnlink(String name) {
        clickOn($("//button[contains(@id,'" + name.toLowerCase() + "-btn')]"));
    }

    public void areOnlyPublicSystemDiplayed() {
	    shouldNotBeVisible(By.xpath("//div[contains(@class, 'SplashPage_internal_1RvCv')]"));
    }

    public void clickButton(String btn) {
	    clickOn($("#" + btn +"-btn"));
    }

    public void verifySystemAndStatusBtnColor() {
        List<String> cardsColors = new ArrayList<String>();
        String[] statusButtonClass = worstStatusButton.getAttribute("class").split(" ",4);
        String statusColor = statusButtonClass[3];
        for(WebElementFacade card:cardsColorsArray){
            String[] temp = card.getAttribute("class").split(" ");
            cardsColors.add(temp[1]);
        }
        Assert.assertTrue(cardsColors.contains(statusColor));
    }

    public void systemCardIsDisplayed(String system, String state) {
	    waitForAngularRequestsToFinish();
	    switch (state) {
            case "not": shouldNotBeVisible(By.xpath("//div[contains(@class, 'SplashPage_system_18pPS')]//p[text()='" + system + "']"));
                break;
            default: shouldBeVisible(By.xpath("//div[contains(@class, 'SplashPage_system_18pPS')]//p[text()='" + system + "']"));
                break;
        }
    }

    public void clickOnBannerHeader(String bannerstate) {
       shouldBeVisible(By.cssSelector("#" + bannerstate + "-banner"));
       clickOn($("#" + bannerstate + "-banner"));
    }

    public void checkBannerState(String bannerstate) {
        shouldBeVisible(By.cssSelector("#" + bannerstate + "-banner"));
    }

    public void checkBannerText(String bannerText) {
	    shouldBeVisible(bannerBody);
        Assert.assertTrue(bannerBody.getText().toLowerCase().contains(bannerText));
    }

    public void checkBannerHeader() {
	   Assert.assertTrue(bannerHeader.getText().contains("Important information"));
    }

    public void checkVisitThisText() {
	    Assert.assertTrue($("#splash-page-description").getText().equalsIgnoreCase("Visit this site any time to view current information on system status and performance information for Cengage products, updated every 5 minutes. Click on a system for more details."));
    }

    public void clickOnTimeZoneButton() {
        shouldBeVisible(changeTimezoneButton);
        clickOn(changeTimezoneButton);
    }

    public void isTimeZoneFormOpened() {
        shouldBeVisible(changeTimezoneForm);
        Assert.assertTrue(changeTimezoneForm.getText().equals("Select timezone"));
    }

    public void setTimeZone(String timezone) {
        replaceValueInfield(timeZoneInputField, timezone);

    }

    private void replaceValueInfield(WebElement element, String value) {
        if(value != null && !value.isEmpty()){
            element.clear();
            element.sendKeys(value);
        }
    }

    public void selectTimezoneInDropdown(String timezone) {
        clickOn($("//div[contains(@id,'downshift')][contains(text(),'"+ timezone + "')]"));

    }

    public void clickBtn() {
	    clickOn($("#modal-button-ok"));
    }

    public void isTimezoneCurrentlySelected(String timezone) {
        shouldBeVisible(changeTimezoneButton);
	    Assert.assertTrue(changeTimezoneButton.getText().contains(timezone));
    }

    public void checkStartAndEndTimeHeadersForNotifTable(String timezone) {
	    shouldBeVisible(By.cssSelector("#start-time-header"));
        shouldBeVisible(By.cssSelector("#end-time-header"));
        Assert.assertTrue($("#start-time-header").getText().contains(timezone));
        Assert.assertTrue($("#end-time-header").getText().contains(timezone));
    }


    public void checkTimezobneAtBottomOfCard(String timezone) {
        Assert.assertTrue($("div[class*='SplashPage_displayTime']").getText().contains(timezone));
    }

    public void checkNotifHeaders(List<String> headers) {
        List<String> actualHeaders = inTable(otherSystemsNotificationsTable).getHeadings();
        List<String> actualHeadersWithoutBrackets = new ArrayList<String>();;
        for (String value: actualHeaders) {
            actualHeadersWithoutBrackets.add(value.replaceAll("\\(([^)]+)\\)", "").trim());
        }

        Assert.assertTrue(actualHeadersWithoutBrackets.containsAll(headers));
    }

    public void checkNotifTableValues(String message, String value, String column) {
        HtmlTable newTable = HtmlTable.inTable(otherSystemsNotificationsTable);
        List<WebElement> matchingRows =  newTable.getRowElementsWhere(the("Message", is(message)),the(column, is(value)));
        Assert.assertTrue(matchingRows.size() == 1);
    }

    public void flagShouldBeVisible() {
	    shouldBeVisible(bannerFlag);
    }

    public void notificationHasOrangeBrickPicture() {
	    shouldBeVisible(By.cssSelector(".orange.brick"));
    }

    public void checkSystemCardStatusAndText(String systemname) {
      WebElement pictureOnCard = find(By.xpath("//div/p[text()='" + systemname + "']/ancestor::div[contains(@class,'SplashPage_mediaRow')]/div"));
        String title = pictureOnCard.getAttribute("title");
        String pictureColor = pictureOnCard.getAttribute("class");
        switch(title){
            case "No Issues": Assert.assertTrue(pictureColor.contains("green"));
                break;
            case "Service disruption": Assert.assertTrue(pictureColor.contains("orange"));
                break;
            case "Service unavailable": Assert.assertTrue(pictureColor.contains("red"));
                break;
            default: Assert.fail();
                break;
        }
    }

    public void bottomOfTheCardHasTextLastUpdated() {
	    shouldBeVisible(By.cssSelector("span[class*= SplashPage_lastUpdatedLabel]"));
    }

    public void progressBarIsVisibleForUser() {
	    shouldBeVisible(By.cssSelector("div[role*=progressbar]"));
    }

    public void checkForLastSyncSecond() {
	    String lastUpdated = find(By.cssSelector("p[class*=LastSync_lastUpdated]")).getText();
	    Assert.assertTrue(lastUpdated.contains("Last sync: "));
	    String[] seconds = find(By.cssSelector("p[class*=LastSync_lastUpdated]>span")).getText().split(" ");
        int intSeconds = Integer.parseInt(seconds[0]);

        Assert.assertTrue(intSeconds < 70);
        Assert.assertTrue(seconds[1].equalsIgnoreCase("seconds"));
        Assert.assertTrue(seconds[2].equalsIgnoreCase("ago"));
    }

    public void userSeesInternalSystems() {
        shouldBeVisible(By.xpath("//div[contains(@class, 'SplashPage_internal_1RvCv')]"));
    }

    public void checkAdminStatusSpots() {
        List<String> cardsColors = new ArrayList<String>();

        String[] publicStatusButton = $("//div[contains(@class,'SplashPage_publicAvatar')]/div").getAttribute("class").split(" ",4);
       String statusColor = publicStatusButton[3];
        String[] internalStatusButton = $("//div[contains(@class,'SplashPage_internalAvatar')]/div").getAttribute("class").split(" ",4);
        String internalStatusColor = internalStatusButton[3];
        for (WebElementFacade card : cardsColorsArray) {
            String[] temp = card.getAttribute("class").split(" ");
            cardsColors.add(temp[1]);
        }
       if(!Objects.equals(statusColor, "green") || !Objects.equals(internalStatusColor, "green")) {
           Assert.assertTrue(cardsColors.contains(statusColor) || cardsColors.contains(internalStatusColor));
       }else{
           Assert.assertTrue(cardsColors.contains(statusColor) && cardsColors.contains(internalStatusColor));
       }
    }

    public void clickEditNotificationButtonOnSplashPage() {
        clickOn($("a[id*='edit-notification']"));
    }

    public void isThereANotificationTable() {
	    shouldNotBeVisible(anyNotificationTableOnSplashPage);
    }
}
	

	
	

