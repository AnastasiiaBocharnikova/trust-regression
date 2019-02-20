package com.trust.cucumber.pages;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.trust.cucumber.util.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;

public class ManageRolesPage extends PageObject {

    public ManageRolesPage(WebDriver driver) {
        super(driver);
    }

    Wait wait = new Wait(getDriver());
	
	@FindBy(css = "div.Roles_permissionsContainer_sE0uz")
	private WebElementFacade permissionsSection;
	
	@FindBy (css = "div.ReactTable table tbody")
	private WebElement noHeadingsTable;
		
	public void clickAddNewRoleButton () {
		((JavascriptExecutor) this.getDriver()).executeScript("window.scrollBy(0,-250)", "");
		$("#add-role-btn").click();
	}
		
	public List<String> getHeadersForManageRolesTable() {
		return findAll(By.xpath("//thead[contains(@class,' -header')]//th/span/div[text()]"))
				.stream()
				.map(header -> header.getText())
				.collect(Collectors.toList());
	}
	
	private String[] getCustomHeaders() {
		List<String> customHeaders = getHeadersForManageRolesTable();
		customHeaders.add("Delete icon");
			return customHeaders.toArray(new String[0]);			
	}
	
	private HtmlTable getManageRoleTable(){
		return HtmlTable.withColumns(getCustomHeaders()).inTable(noHeadingsTable);
	}
	
	public void selectPermissionType(String permissionType) {
		for (WebElementFacade option : findAll(".//li//p[contains(@class,'permission-options')]")) {
			if (permissionType.equals(option.getText())) { 
				option.click();
				break;
			}
		}
	}
	
	public void selectPermissionTypeForOption(String optionName, String permissionType) {
		permissionsSection.findBy(".//div/p[text()= '" + optionName + "']/parent::div")
			.findBy(By.tagName("button")).click();
		selectPermissionType(permissionType);
	}
	
	public void populatePermissionWithValues(Map<String, String> permission ) {
		permission.entrySet().forEach(p -> {permissionsSection.findBy(".//div/p[text()= '" + p.getKey() + "']/parent::div")
												.findBy(By.tagName("button")).click();
											selectPermissionType(p.getValue());
											waitABit(300);});
	}
		
	public void selectPermissionForEachOption() {
		findAll(By.xpath("//div[contains(@class,'editPermissionSelect')]"))
			.forEach(option -> {option.findBy(By.xpath(".//button")).click();
					findAll(".//li//p[contains(@class,'permission-options')]").get(1).click();
					waitABit(300);});
			}
	
	public void populateRoleName(String roleName) {
		$("#name-field").sendKeys(roleName);
	}
	
	public void clickOkButton() {
		$("#submit-role-btn").click();
	}
	
	public void checkRoleInTable(String roleName) {
		getManageRoleTable().shouldHaveRowElementsWhere(the("Name", is(roleName)));
	}
	
	public void checkRoleIsRemoved(String roleName) {
		getManageRoleTable().shouldNotHaveRowElementsWhere(the("Name", is(roleName)));
	}

	public void checkRoleIsNotEditable(String roleName) {
		Assert.assertNotNull(getManageRoleTable().findFirstRowWhere(the("Name", is(roleName)))
				.findElement(By.xpath(".//button[contains(@id,'delete-role')]")).getAttribute("disabled"));		
	}
	
	public void selectPermissionforRole (String permission, String roleName) {
		int permissionIndex = getHeadersForManageRolesTable().indexOf(permission)+1;
		Actions action = new Actions(getDriver());
		action.doubleClick(getManageRoleTable().findFirstRowWhere(the("Name", is(roleName)))
						.findElement(By.xpath(".//td[" + permissionIndex + "]//button"))).perform();	
	}
	
	public void clickDeleteIconForRole (String roleName) {
		getManageRoleTable().findFirstRowWhere(the("Name", is(roleName)))
			.findElement(By.xpath(".//button[contains(@id,'delete-role')]")).click();
	}
	
	public void checkPermissionOptionsListIsDisplayed() {
		shouldBeVisible(By.xpath("//ul[contains(@role,'listbox')]"));
	}
	
	public void checkPermissionOptionsListIsNotDisplayed() {
		shouldNotBeVisible(By.xpath("//ul[contains(@role,'listbox')]"));
	}
	
	public void checkDeleteRoleButtonIsNotDisplayed() {
		shouldNotBeVisible(By.xpath("//button[contains(@id,'delete-role')]"));
	}
	
	public void checkPermissionIconForRole(String permissionIcon,String permission, String roleName) {
		int permissionIndex = getHeadersForManageRolesTable().indexOf(permission)+1;
		String actualIcon =  getManageRoleTable().findFirstRowWhere(the("Name", is(roleName)))
			.findElement(By.xpath(".//td[" + permissionIndex + "]//button/span/span")).getText();
		Assert.assertEquals(permissionIcon, actualIcon);
	}
	
	public void verifyMenuOptions(List<String> expectedMenuOptions) {
        wait.waitForPageLoad();
		List<String> actualMenuOptions = findAll(By.xpath("//ul[contains(@class,'Layout_list_3IzPb')]/a/div"))
										.stream()
										.map(header -> header.getText())
										.collect(Collectors.toList());
		Assert.assertEquals(actualMenuOptions,expectedMenuOptions);
	}
	
	
}