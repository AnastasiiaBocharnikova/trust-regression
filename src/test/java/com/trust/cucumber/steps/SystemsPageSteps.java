package com.trust.cucumber.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import com.trust.cucumber.pages.SystemsPage;

public class SystemsPageSteps {
	
    SystemsPage systemsPage;
       
    @Step
	public void clickAddGroupButton() {
		systemsPage.clickAddGroupButton();		
	}
    
    @Step
	public void verifyGroupFormIsDisplayed() {
		systemsPage.verifyGroupFormIsDisplayed();		
	}
    
    @Step
    public void populateGroupForm(String groupName) {
    	systemsPage.populateGroupForm(groupName);
    }
    
    @Step
    public void clearGroupNameField() {
    	systemsPage.clearGroupNameField();
    }
    
    @Step
	public void verifyGroupIsDisplayed(String groupName) {
		systemsPage.verifyGroupIsDisplayed(groupName);	
	}
    
    @Step
    public void clickAddSystemForSpecificGroup(String groupName) {
    	systemsPage.clickAddSystemForSpecificGroup(groupName);
    }
    
    @Step
    public void clickDeleteIconForSpecificGroup(String groupName) {
    	systemsPage.clickDeleteIconForSpecificGroup(groupName);
    }
    
    @Step
    public void clickUpdateIconForSpecificGroup(String groupName) {
    	systemsPage.clickUpdateIconForSpecificGroup(groupName);
    }
    
    @Step
    public void clickExpandAllButton() {
    	systemsPage.clickExpandAllButton();
    }
    
    @Step
	public void verifyCreateSystemFormIsDisplayed() {
		systemsPage.verifyCreateSystemFormIsDisplayed();		
	}
    
    @Step
    public void populateNewSystemForm(String systemName, String accessLevel) {
    	systemsPage.populateNewSystemForm(systemName, accessLevel);
    }
    
    @Step
    public void clearSystemNameFied() {
    	systemsPage.clearSystemNameFied();
    }
    
    @Step
    public void clickOkModalButton() {
    	systemsPage.clickOkModalButton();
    }
    
    @Step
    public void clickCloseModalButton() {
    	systemsPage.clickCloseModalButton();
    }
    
    @Step
    public void verifySystemIsDisplayed(String systemName) {
    	systemsPage.verifySystemIsDisplayed(systemName);
    }
    
    @Step
	public void clickAddMonitorForSpecificSystem(String systemName) {
		systemsPage.clickAddMonitorForSpecificSystem(systemName);	
	}
    
    @Step
    public void clickDeleteIconForSpecificSystem(String systemName) {
    	systemsPage.clickDeleteIconForSpecificSystem(systemName);
    }
    
    @Step
    public void clickEnabledIconForSpecificSystem(String systemName) {
    	systemsPage.clickEnabledIconForSpecificSystem(systemName);
    }
    
    @Step
	public void verifyCreateMonitorFormIsDisplayed() {
		systemsPage.verifyCreateMonitorFormIsDisplayed();		
	}
    
    @Step
    public void populateMonitorName(String monitorName) {
    	systemsPage.populateMonitorName(monitorName);
    }
    
    @Step
	public void populateNewMonitorForm(Map<String, String> monitor) {
		systemsPage.populateNewMonitorForm(monitor);	
	}
    
    @Step
    public void clearMonitorNameAndExternalID() {
    	systemsPage.clearMonitorNameAndExternalID();
    }
    
    @Step
    public void clickEnabledSystemCheckbox() {
    	systemsPage.clickEnabledSystemCheckbox();
    }
    
    @Step
    public void clickEnabledMonitorCheckbox() {
    	systemsPage.clickEnabledMonitorCheckbox();
    }
    
    @Step
    public void populateMonitorDescription() {
    	systemsPage.populateMonitorDescription();
    }
    
    @Step
    public void populateDescriptionSystemField() {
    	systemsPage.populateDescriptionSystemField();
    }
    
    @Step
	public void verifyMonitorIsDisplayed(String monitorName) {
		systemsPage.verifyMonitorIsDisplayed(monitorName);		
	}
    
    @Step
	public void searchForEnries(String searchString) {
		systemsPage.selectOptionFromAutocompleteField(searchString);		
	}
    
    @Step
	public void verifySearchResults(String searchString) {
		systemsPage.verifySearchResults(searchString);	
	}

    @Step
    public void clearSearchField() {
		systemsPage.clearSearchField();		
	}
    
    @Step
	public void clickUpdateIconForSpecificSystem(String systemName) {
		systemsPage.clickUpdateIconForSpecificSystem(systemName);	
	}
    
    @Step
	public void verifyEditSystemFormIsDisplayed() {
		systemsPage.verifyEditSystemFormIsDisplayed();		
	}
    
    @Step
	public void checkAccessLevelOptions(List<String> expectedOptions) {
    	List<String> actualOptions = systemsPage.getAccessLevelOptions();
    	Assert.assertTrue(actualOptions.equals(expectedOptions));	
	}
    
    @Step
	public void clickCreateMonitorButton() {
		systemsPage.clickCreateMonitorButton();
		
	}
    
    @Step
	public void verifyMonitorsAmountForSystem(int expectedAmount, String systemName) {
		Assert.assertEquals(expectedAmount, systemsPage.getMonitorsAmountForSpecificSystem(systemName));		
	}
    
    @Step
    public void clickAggregatedIcon() {
    	systemsPage.clickAggregatedIcon();
    }
    
    @Step
    public void selectAllSubMonitorsForAggregation() {
    	systemsPage.selectAllSubMonitorsForAggregation();
    }
    
    @Step
	public void verifyGroupSectionsAreCollapsed() {
		systemsPage.verifyGroupSectionsAreCollapsed();		
	}
    
    @Step
	public void clickShowHeadersIcon() {
		systemsPage.clickShowHeadersIcon();
	}
        
    @Step
	public void checkSystemHeadersFromTable(List<String> expectedHeaders) {
    	List<String> actualHeaders = systemsPage.getSystemHeadersFromTable();
    	Assert.assertTrue(actualHeaders.equals(expectedHeaders));	
	}
    
    @Step
	public void checkMonitorHeadersFromTable(List<String> expectedHeaders) {
    	List<String> actualHeaders = systemsPage.getMonitorHeadersFromTable();
    	Assert.assertTrue(actualHeaders.equals(expectedHeaders));	
	}
    
    @Step
	public void clickExpandIconForSpecificMonitor(String monitorName) {
		systemsPage.clickExpandIconForSpecificMonitor(monitorName);	
	}
    
    @Step
	public void verifySubMonitorsAreDisplayed() {
		systemsPage.verifySubMonitorsAreDisplayed();		
	}
    
    @Step
	public void verifySubMonitorsAreNotDisplayed() {
		systemsPage.verifySubMonitorsAreNotDisplayed();		
	}
    
    @Step
	public void selectRegionForSearch(String region) {
		systemsPage.selectRegionForSearch(region);		
	}
    
    @Step
    public void clickShowRegionsButton() {
    	systemsPage.clickShowRegionsButton();
    }
    
    @Step
	public void selectRegionForMonitor(String region) {
		systemsPage.selectRegionForMonitor(region);		
	}
    
    @Step
	public void checkSystemIsEnabled(String systemName) {
		systemsPage.checkSystemSectionIsEnabled(systemName);		
	}
    
    @Step
	public void checkSystemIsDisabled(String systemName) {
		systemsPage.checkSystemSectionIsDisabled(systemName);		
	}
    
    @Step
	public void clearRegionField() {
		systemsPage.clearRegionField();	
	}
    
    @Step
    public void clickDeleteIconForSpecificMonitor(String monitorName) {
    	systemsPage.clickDeleteIconForSpecificMonitor(monitorName);
    }
    
    @Step
    public void clickEnabledIconForSpecificMonitor(String monitorName) {
    	systemsPage.clickEnabledIconForSpecificMonitor(monitorName);
    }
    
    @Step
    public void clickUpdateIconForSpecificMonitor(String monitorName) {
    	systemsPage.clickUpdateIconForSpecificMonitor(monitorName);
    }
        
    @Step
    public void clickProceedModalButton() {
    	systemsPage.clickProceedModalButton();
    }
        
    @Step
    public void clickPreviousIcon() {
    	Serenity.setSessionVariable("editingNumber").to(systemsPage.getEditingSystemNumber());
    	systemsPage.clickPreviousIcon();   	
    }
    
    @Step
    public void clickNextIcon() {
    	Serenity.setSessionVariable("editingNumber").to(systemsPage.getEditingSystemNumber());
    	systemsPage.clickNextIcon();   	
    }
    
    @Step
    public void checkEditingNumberIsDecreased() {
    	int previousValue = Serenity.sessionVariableCalled("editingNumber");
    	Assert.assertEquals(previousValue, systemsPage.getEditingSystemNumber()+1);
    }
    
    @Step
    public void checkEditingNumberIsIncreased() {
    	int previousValue = Serenity.sessionVariableCalled("editingNumber");
    	Assert.assertEquals(previousValue, systemsPage.getEditingSystemNumber()-1);
    }
    
    @Step
    public void checkDeleteIconIsDisabledForSystem(String systemName) {
    	systemsPage.checkDeleteIconIsDisabledForSystem(systemName);
    }
    
    @Step
	public void hoverOnDeleteIconForSystem(String systemName) {
		systemsPage.hoverOnDeleteIconForSystem(systemName);	
	}
    
    @Step
	public void verifyTooltipIsDisplayed() {
		systemsPage.verifyDeleteIconTooltipIsDisplayed();	
	}
    
    @Step
	public void checkAccessLevelFieldIsDisabled() {
		systemsPage.checkAccessLevelFieldIsDisabled();		
	}
    
    @Step
	public void hoverOnAccessLevelField() {
		systemsPage.hoverOnAccessLevelField();	
	}
    
    @Step
	public void verifyAccessLevelTooltipIsDisplayed() {
		systemsPage.verifyAccessLevelTooltipIsDisplayed();	
	}
    
    @Step
    public void checkToasterIsDisplayed(String status) {
    	systemsPage.checkToasterIsDisplayed(status);
    }
    
    @Step
    public void checkingExpandAllStatus() {
    	systemsPage.checkingExpandAllStatus();
    }
    
    @Step
    public void clickCloseToasterButton() {
    	systemsPage.clickCloseToasterButton();
    }
    
    @Step
	public void verifyAddSystemIconIsNotDisplayed() {
		systemsPage.verifyAddSystemIconIsNotDisplayed();	
	}
    
    @Step
	public void verifyAddSystemIconIsDisplayed() {
		systemsPage.verifyAddSystemIconIsDisplayed();	
	}
    
    @Step
	public void verifyEditSystemIconIsNotDisplayed() {
		systemsPage.verifyEditSystemIconIsNotDisplayed();		
	}
    
    @Step
	public void verifyEditSystemIconIsDisplayed() {
		systemsPage.verifyEditSystemIconIsDisplayed();		
	}
    
    @Step
	public void verifyDeleteSystemIconIsNotDisplayed() {
		systemsPage.verifyDeleteSystemIconIsNotDisplayed();		
	}
    
    @Step
	public void verifyDeleteSystemIconIsDisplayed() {
		systemsPage.verifyDeleteSystemIconIsDisplayed();		
	}


    public void editMonitorFormIsDisplayed() {
        systemsPage.editMonitorFormIsDisplayed();
    }

	@Step
	public void selectLogoForSystem(String fileName) {
    	systemsPage.uploadLogoForSystem(fileName);
	}
}
