package com.trust.cucumber.pages;

import static net.thucydides.core.pages.components.HtmlTable.inTable;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javafx.stage.FileChooser;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;

import com.trust.cucumber.util.Log;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.w3c.dom.html.HTMLInputElement;

public class SystemsPage extends PageObject {
	
	@FindBy(css = "#add-group-btn")
	private WebElement addGroupButton;
	
	@FindBy(css = "#tree-group-form")
	private WebElementFacade groupForm;
	
	@FindBy(css = "div.rst__node li")
	private List<WebElementFacade> groupSections;
	
	@FindBy(xpath = "//table[contains(@class,' SystemTree_systemRow')]")
	private List<WebElementFacade> systemSections;
	
	@FindBy(xpath = "//div[contains(@class,'floatingModal')]")
	private WebElementFacade createOrEditSystemForm;
	
	@FindBy (css = "div.Search_suggestionContainer_3Gnz9>div>div")
	private List <WebElementFacade> autoSuggestOptions;
	
	@FindBy(css = "#monitor-form")
	private WebElementFacade createOrEditMonitorForm;
		
	@FindBy(xpath = "//table[contains(@class,' SystemTree_monitorRow')]")
	private List<WebElementFacade> monitorSections;
	
	@FindBy(xpath = "//*[@id='monitors-header']/ancestor::table")
	private WebElementFacade regionsTable;
	
	@FindBy(css = "div.Toastify__toast-body")
	private WebElementFacade toasterSection;

	@FindBy(css = "button.imageUpload_addImage_QDzLj")
	private WebElementFacade uploadLogoButton;

	@FindBy(xpath = "//input[@class='imageUpload_uploadImage_3PPjF']")
	private WebElementFacade uploadLogo;

	public void clickAddGroupButton() {
		addGroupButton.click();		
	}

	public void verifyGroupFormIsDisplayed() {
		Assert.assertTrue(groupForm.isDisplayed());
		Assert.assertTrue(groupForm.findBy("h4").getText().equals("Group"));	
	}

	public void populateGroupForm(String groupName) {
		groupForm.findBy("#group-name-field").sendKeys(groupName);
		groupForm.findBy("#submit-group-btn").click();		
	}
	
	public void clearGroupNameField() {
		groupForm.findBy("#group-name-field").clear();
	}

	public void verifyGroupIsDisplayed(String groupName) {		
		List<String> sectionNames = groupSections.stream()
				.map(e -> e.find(By.tagName("p")).getText()).collect(Collectors.toList());
		Assert.assertTrue(sectionNames.contains(groupName));	
	}
	
	public void clickExpandAllButton() {
		$("#expand-all-switch").click();
	}
	
	public WebElementFacade getGroupSectionByName(String groupName) {
		return groupSections.stream()
				.filter(e -> e.find(By.tagName("p")).getText().equals(groupName)).findFirst().get();
	}
	
	public void clickAddSystemForSpecificGroup(String groupName) {
		getGroupSectionByName(groupName).findBy(".//span[text()=' add ']").click();;
	}
	
	public void clickDeleteIconForSpecificGroup(String groupName) {
		getGroupSectionByName(groupName).findBy(".//span[text()=' delete ']").click();
	}
	
	public void clickExpandSystemForSpecificGroup(String groupName) {
		getGroupSectionByName(groupName).findBy(".//span[text()='keyboard_arrow_down']").click();;
	}
	
	public void clickUpdateIconForSpecificGroup(String groupName) {
		getGroupSectionByName(groupName).findBy(".//button[contains(@id,'edit-group')]").click();;
	}
		
	public void verifyCreateSystemFormIsDisplayed() {
		Assert.assertTrue(createOrEditSystemForm.isDisplayed());
		Assert.assertTrue(createOrEditSystemForm.find(By.tagName("h6")).getText().equals("Create System"));
	}
	
	public void populateNewSystemForm(String systemName, String accessLevel) {
		$("#system-name-field").sendKeys(systemName);
		selectAccessLevelOption(accessLevel);
	}
	
	public void clearSystemNameFied() {
		$("#system-name-field").clear();
	}
	
	public void clickEnabledSystemCheckbox() {
		$("#system-enabled-field").click();
	}
	
	public void populateDescriptionSystemField() {
		$("#system-description-field").sendKeys("Testing system");
	}
	
	public void clickOkModalButton() {
		$("#modal-button-ok").click();
	}
	
	public void clickCloseModalButton() {
		$("#modal-button-close").click();
	}
	
	public void verifySystemIsDisplayed(String systemName) {
		shouldBeVisible(By.xpath("//td[contains(@title,'" + systemName + "')]"));		
	}
	
	public WebElementFacade getSystemSectionByName(String systemName) {
		return systemSections.stream().filter(e -> e.containsText(systemName)).findFirst().get();
	}
	
	public void clickAddMonitorForSpecificSystem(String systemName) {
		getSystemSectionByName(systemName).findBy(".//span[text()=' add ']").click();
	}
	
	public void clickUpdateIconForSpecificSystem(String systemName) {
		getSystemSectionByName(systemName).findBy(".//span[text()=' mode_edit ']").click();
	}
	
	public void clickDeleteIconForSpecificSystem(String systemName) {
		getSystemSectionByName(systemName).findBy(".//span[text()=' delete ']").click();
	}
	
	public void clickEnabledIconForSpecificSystem(String systemName) {
		getSystemSectionByName(systemName).findBy(".//input[contains(@id,'enable-system')]").click();
	}

	public void verifyCreateMonitorFormIsDisplayed() {
		Assert.assertTrue(createOrEditMonitorForm.isDisplayed());
		Assert.assertTrue(find(By.tagName("h6")).getText().equals("Create Monitor"));
	}
	
	public void populateMonitorName(String monitorName) {
		$("#monitor-name-field").sendKeys(monitorName);
	}
	
	public void populateMonitorDescription() {
		$("#monitor-description-field").sendKeys("Monitor Description");
	}
	
	public void clickEnabledMonitorCheckbox() {
		$("#monitor-enabled-field").click();
	}
		
	public void populateNewMonitorForm(Map<String, String> monitor) {
		populateMonitorName(monitor.get("Name"));
		createOrEditMonitorForm.findBy("#autocomplete-field").click();
		createOrEditMonitorForm.findBy("#autocomplete-field").sendKeys(monitor.get("External ID"));
		autoSuggestOptions.get(0).click();	
	}
	
	public void clearMonitorNameAndExternalID() {
		$("#monitor-name-field").clear();
		createOrEditMonitorForm.findBy("#autocomplete-field").clear();
	}
	
	public void verifyMonitorIsDisplayed(String monitorName) {
		Assert.assertTrue(monitorSections.stream().anyMatch(e  -> e.containsText(monitorName)));	
	}
	
	public WebElementFacade getMonitorSectionByName(String monitorName) {
		return monitorSections.stream().filter(e -> e.containsText(monitorName)).findFirst().get();
	}
	
	public void clickDeleteIconForSpecificMonitor(String monitorName) {
		getMonitorSectionByName(monitorName).findBy(".//span[text()=' delete ']").click();
	}
	
	public void clickExpandIconForSpecificMonitor(String monitorName) {
		getMonitorSectionByName(monitorName).findBy(".//span[contains(@id,'expand-monitor')]").click();;
	}
	
	public void clickEnabledIconForSpecificMonitor(String monitorName) {
		getMonitorSectionByName(monitorName).findBy(".//input[contains(@id,'enable-monitor')]").click();
	}
	
	public void clickUpdateIconForSpecificMonitor(String monitorName) {
		getMonitorSectionByName(monitorName).findBy(".//button[contains(@id,'edit-monitor')]").click();
	}
	
	public void selectOptionFromAutocompleteField(String optionName) {
		$("#autocomplete-field").click();
		$("#autocomplete-field").sendKeys(optionName);
		autoSuggestOptions.get(0).click();	
	}
	
	public void verifySearchResults(String searchString) {
		monitorSections.forEach(monitor -> Assert.assertTrue(monitor.getText().toLowerCase().contains(searchString.toLowerCase())));
	}
	
	public void clearSearchField() {
		$("#autocomplete-field").clear();
	}
	
	public void verifyEditSystemFormIsDisplayed() {
		Assert.assertTrue(createOrEditSystemForm.isDisplayed());
		Assert.assertTrue(createOrEditSystemForm.findBy(".//h6/span").getText().equals("Edit System"));
	}
	
	public List<String> getAccessLevelOptions () {
		$("#single-dropdown-field").click();
		return autoSuggestOptions.stream().map(e -> e.getText()).collect(Collectors.toList());
	}
	
	public void selectAccessLevelOption (String accessLevel) {
		$("#single-dropdown-field").click();
		for (WebElementFacade option : autoSuggestOptions) {

			if (accessLevel.equals(option.getText())) {
				option.click();
				break;
			}
		}	
	} 
	
	public void clickCreateMonitorButton() {
		$("#create-monitor-btn").click();
	}
	
	public int getMonitorsAmountForSpecificSystem(String systemName) {
		return Integer.parseInt(getSystemSectionByName(systemName).findBy(".//td[5]").getText());		
	}
	
	public void clickAggregatedIcon() {
		$("#monitor-is_aggregated-field").click();
	}
	
	public void selectAllSubMonitorsForAggregation() {
		int monitorsAmount = createOrEditMonitorForm.findElements(By.xpath(".//table//tbody/tr")).size();
		for (int i = 1; i <= monitorsAmount; i++)
			createOrEditMonitorForm.find(By.xpath(".//tbody//tr[" + i + "]//input")).click();		
	}
	
	public void verifyGroupSectionsAreCollapsed() {
		groupSections.forEach(group -> shouldBeVisible(group));
		systemSections.forEach(system -> shouldNotBeVisible(system));
		monitorSections.forEach(monitor -> shouldNotBeVisible(monitor));		
	}

	public void clickShowHeadersIcon() {
		$("#show-headers-switch").click();		
	}
	
	public List<String> getSystemHeadersFromTable() {
		List<String> result = new ArrayList<String>();
	    for (String str : inTable(systemSections.get(0)).getHeadings()) {

	    	if (str != null && !str.isEmpty()) {
	            result.add(str);
	        }
	    }
	    return result;
	}
	
	public List<String> getMonitorHeadersFromTable() {
		List<String> result = new ArrayList<String>();
	    for (String str : inTable(monitorSections.get(0)).getHeadings()) {
	        if (str != null && !str.isEmpty()) {
	            result.add(str);
	        }
	    }
	    return result;
	}

	public void verifySubMonitorsAreDisplayed() {
		findAll("//tr[contains(@class,'aggregatedRow')]").forEach(row -> shouldBeVisible(row));
	}
	
	public void verifySubMonitorsAreNotDisplayed() {
		findAll("//tr[contains(@class,'aggregatedRow')]").forEach(row -> shouldNotBeVisible(row));	
	}
	
	public void selectRegionForSearch(String region) {
		$("#regions-select").click();
		$("#regions-select").sendKeys(region);
		autoSuggestOptions.get(0).click();	
	}
	
	public void clickShowRegionsButton() {
		$("#show-regions-btn").click();
	}
		
	public void selectRegionForMonitor(String region) {
		List<String> regions = inTable(regionsTable).getHeadings().stream().
				filter(e -> e.matches("[A-Z]{2,}")).
					collect(Collectors.toList());
		regionsTable.findElements(By.xpath(".//tr//input")).get(regions.indexOf(region)).click();
	}
	
	public void checkSystemSectionIsDisabled(String systemName) {
		Assert.assertNotNull(getSystemSectionByName(systemName).getAttribute("disabled"));
	}
	
	public void checkSystemSectionIsEnabled(String systemName) {
		Assert.assertTrue(getSystemSectionByName(systemName).isEnabled());
	}
	
	public void clearRegionField() {
		$("//button//span[text()=' clear ']").click();
	}
	
	public void clickProceedModalButton() {
		$("#modal-button-proceed").click();
	}
	
	public int getEditingSystemNumber() {
		List<Integer> systemsAmount = new ArrayList<>();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(findBy("//h6").getText());
		while (matcher.find())
			 systemsAmount.add(Integer.parseInt(matcher.group()));
		return systemsAmount.get(0);		
	}
	
	public void clickPreviousIcon() {
		$("#stepper-back-btn").click();
	}
	
	public void clickNextIcon() {
		$("#stepper-next-btn").click();
	}
	
	public void checkDeleteIconIsDisabledForSystem (String systemName) {
		getDriver().navigate().refresh();
		Assert.assertNotNull(getSystemSectionByName(systemName).
				findBy(".//button[contains(@id,'delete-system')]").getAttribute("disabled"));
	}
	
	public void hoverOnDeleteIconForSystem (String systemName) {
		withAction().moveToElement(getSystemSectionByName(systemName).
				findBy(".//button[contains(@id,'delete-system')]")).perform();
	}
	
	public void verifyDeleteIconTooltipIsDisplayed() {
		Assert.assertTrue($("#system-row").isDisplayed());
		Assert.assertTrue($("#system-row").getText().
				equals("This system is associated with an institution and cannot be deleted"));
	}
	
	public void checkAccessLevelFieldIsDisabled() {
		Assert.assertNotNull($("#single-dropdown-field").getAttribute("disabled"));
	}
	
	public void hoverOnAccessLevelField () {
		withAction().moveToElement($("#single-dropdown-field")).perform();
	}
	
	public void verifyAccessLevelTooltipIsDisplayed() {
		Assert.assertTrue($("#system-access_level-field").isDisplayed());
		Assert.assertTrue($("#system-access_level-field").getText().
				equals("This system is associated with an institution and cannot be made non-public"));
	}
	
	public void checkToasterIsDisplayed (String status) {
		Assert.assertTrue(toasterSection.isDisplayed());
		Assert.assertTrue(toasterSection.getText().contains(status));
	}
	
	public void clickCloseToasterButton() {
		try {
			if ($("//div[contains(@class,' Toastify__toast')]/button").isDisplayed())
				$("//div[contains(@class,' Toastify__toast')]/button").click();
		}
		catch (ElementNotVisibleException e) {
			Log.debug("Can not click close Toaster Button. Reason: " + e.toString());			
		}			
	}
		
	public void checkingExpandAllStatus() {
		if (systemSections.size()>0) {
			clickExpandAllButton();		
		}
	}
	
	public void verifyAddSystemIconIsDisplayed() {
		shouldBeVisible(By.xpath(".//button[contains(@id,'add-system')]"));
	}
	
	public void verifyAddSystemIconIsNotDisplayed() {
		shouldNotBeVisible(By.xpath(".//button[contains(@id,'add-system')]"));
	}
	
	public void verifyEditSystemIconIsDisplayed() {
		shouldBeVisible(By.xpath("//button[contains(@id,'edit-system')]"));
	}
	
	public void verifyEditSystemIconIsNotDisplayed() {
		shouldNotBeVisible(By.xpath("//button[contains(@id,'edit-system')]"));
	}
	
	public void verifyDeleteSystemIconIsDisplayed() {
		shouldBeVisible(By.xpath("//button[contains(@id,'delete-system')]"));
	}
	
	public void verifyDeleteSystemIconIsNotDisplayed() {
		shouldNotBeVisible(By.xpath("//button[contains(@id,'delete-system')]"));
	}

    public void editMonitorFormIsDisplayed() {
        Assert.assertTrue(createOrEditMonitorForm.isDisplayed());
        Assert.assertTrue(find(By.xpath("//h6/span")).getText().equals("Edit Monitor"));
    }


	public void uploadLogoForSystem(String fileName) {
		StringSelection ss = new StringSelection("src/test/resources/" + fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		File photo = new File("src/test/resources/" + fileName);
		uploadLogoButton.click();
//     	uploadLogo.sendKeys(photo.getAbsolutePath());

		waitABit(2000);
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_SLASH);
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}




