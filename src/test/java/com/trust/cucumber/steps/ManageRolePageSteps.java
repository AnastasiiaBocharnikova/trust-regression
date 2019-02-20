package com.trust.cucumber.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;

import com.trust.cucumber.pages.ManageRolesPage;

public class ManageRolePageSteps {

	ManageRolesPage roles;
	
	
	@Step
	public void clickAddNewRoleButton() {
		roles.clickAddNewRoleButton();		
	}
	
	@Step
	public void selectPermissionTypeForOption(String optionName, String permissionType) {
		roles.selectPermissionTypeForOption(optionName, permissionType);
		
	}
	
	@Step
	public void selectPermissionForEachOption() {
		roles.selectPermissionForEachOption();		
	}
	
	@Step
	public void populateRoleName(String roleName) {
		roles.populateRoleName(roleName);
	}
	
	@Step
	public void clickOkButton() {
		roles.clickOkButton();
	}
	
	@Step
	public void checkRoleInTable(String roleName) {
		roles.checkRoleInTable(roleName);		
	}
	
    @Step
	public void checkManageRolesHeadersFromTable(List<String> expectedHeaders) {
    	List<String> actualHeaders = roles.getHeadersForManageRolesTable();
    	Assert.assertTrue(actualHeaders.equals(expectedHeaders));	
	}
    
    @Step
	public void checkRoleIsNotEditable(String roleName) {
		roles.checkRoleIsNotEditable(roleName);		
	}
    
    @Step
    public void selectPermissionType(String permissionType) {
    	roles.selectPermissionType(permissionType);
    }
    
    @Step
	public void selectPermissionforRole(String permission, String roleName) {
		roles.selectPermissionforRole(permission, roleName);		
	}
    
    @Step
	public void clickDeleteIconForRole(String roleName) {
		roles.clickDeleteIconForRole(roleName);	
	}
    
    @Step
    public void populatePermissionWithValues(Map<String, String> permission) {
    	roles.populatePermissionWithValues(permission);
    }
    
    @Step
	public void checkPermissionOptionsListIsDisplayed() {
		roles.checkPermissionOptionsListIsDisplayed();		
	}
    
    @Step
	public void checkPermissionOptionsListIsNotDisplayed() {
		roles.checkPermissionOptionsListIsNotDisplayed();	
	}
    
    @Step
	public void checkDeleteRoleButtonIsNotDisplayed() {
		roles.checkDeleteRoleButtonIsNotDisplayed();		
	}
    
    @Step 
	public void checkRoleIsRemovedFromTable(String roleName) {
    	roles.checkRoleIsRemoved(roleName);;		
    }
    
    @Step
	public void checkPermissionIconForRole(String permissionIcon,String permission, String roleName) {
		roles.checkPermissionIconForRole(permissionIcon, permission, roleName);		
	}
    
    @Step
	public void verifyMenuOptions(List<String> expectedMenuOptions) {
		roles.verifyMenuOptions(expectedMenuOptions);		
	}
}