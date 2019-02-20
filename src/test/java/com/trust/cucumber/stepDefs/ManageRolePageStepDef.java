package com.trust.cucumber.stepDefs;

import java.util.List;
import java.util.Map;

import com.trust.cucumber.steps.CommonSteps;
import com.trust.cucumber.steps.ManageRolePageSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ManageRolePageStepDef {
	
	@Steps
	ManageRolePageSteps role ;
	
	@Steps
	CommonSteps common;
	

	@When("^User clicks Add New Role button$")
	public void clickAddNewRoleButton(){
		role.clickAddNewRoleButton();
	}
	
	@When("^Selects for (.*) option (.*) permission$")
	public void selectPermissionTypeForOption(String optionName, String permissionType ){
		role.selectPermissionTypeForOption(optionName, permissionType);
	}
	
	@When("^Populates new role with (.*) name$")
	public void selectPermissionForEachOption(String roleName) {
		role.populateRoleName(roleName);
		role.selectPermissionForEachOption();
		role.clickOkButton();
	}
	
	@Then("^Role (.*) is displayed in the table$")
	public void verifyRoleNameisDisplayed(String roleName) {
		role.checkRoleInTable(roleName);
	}
	
	@Then("^Manage Roles table contains next headers$")
	public void checkManageRolesHeadersFromTable(List<String> arg) {
		role.checkManageRolesHeadersFromTable(arg);
	}
	
	@Then("^Delete button for (.*) role is displayed as disabled$")
	public void checkRoleIsNotEditable(String roleName) {
		role.checkRoleIsNotEditable(roleName);
	}
	
	@When("^User clicks on (.*) permission for (.*) role$")
	public void selectPermissionforRole(String permission, String roleName) {
		role.selectPermissionforRole(permission, roleName);
	}
	
	@When("^User selects (.*) permission type$")
	public void selectPermissionType(String permissionType) {
		role.selectPermissionType(permissionType);
	}
	
	@When("^User deletes (.*) role from the table$")
	public void deleteRole(String roleName) {
		role.clickDeleteIconForRole(roleName);
		common.clickProceedButton();
	}
	
	@When("^Populates role with (.*) name and next permissions$")
	public void populateRoleWithPermissions(String roleName, Map<String,String> permission) {
		role.populateRoleName(roleName);
		role.populatePermissionWithValues(permission);
		role.clickOkButton();
	}
	
	@Then("^List of permission options is displayed$")
	public void checkPermissionOptionsListIsDisplayed() {
		role.checkPermissionOptionsListIsDisplayed();
	}
	
	@Then("^List of permission options isn't displayed$")
	public void checkPermissionOptionsListIsNotDisplayed() {
		role.checkPermissionOptionsListIsNotDisplayed();
	}
	
	@Then("^Delete Role button isn't displayed$")
	public void checkDeleteRoleButtonIsNotDisplayed() {
		role.checkDeleteRoleButtonIsNotDisplayed();
	}
	
	@Then("^Role (.*) is removed from the table$")
	public void verifyRoleIsRemovedFromTable(String roleName) {
		role.checkRoleIsRemovedFromTable(roleName);
	}
	
	@Then("^Icon (.*) is displayed for (.*) permission for (.*) role$")
	public void checkPermissionIconForRole(String permissionIcon, String permission, String roleName) {
		role.checkPermissionIconForRole(permissionIcon, permission, roleName );
	}
	
	@Then("^Only next menu options are displayed$")
	public void verifyMenuOptions(List<String> expectedMenuOptions) {
		role.verifyMenuOptions(expectedMenuOptions);
	}
}