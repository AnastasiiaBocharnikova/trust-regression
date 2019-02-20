package com.trust.cucumber.steps;

import java.util.List;
import java.util.Map;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import com.trust.cucumber.pages.InstitutionsPage;

public class InstitutionsPageSteps {
	
    InstitutionsPage institutionPage;
    
    @Step
    public void verifyToasterIsDisplayed(String institutionName, String status) {
    	institutionPage.verifyToasterIsDisplayed(institutionName, status);
    }
    
    @Step
    public void checkInstitutionTableHeaders(List<String> expectedHeaders) {
    	List<String> actualHeaders = institutionPage.getHeadersFromInstitutionsTable();
    	expectedHeaders.forEach(name -> Assert.assertTrue(actualHeaders.contains(name)));   	
    }
    
    @Step
    public void clickNewInstitutionButton() {
    	institutionPage.clickNewInstitutionButton();
    }

    @Step
    public void populateNewInstitutionFields(Map<String, String> fields) {
    	institutionPage.populateNewInstitutionFields(fields);
    }

    
    @Step
    public void clickOkModalButton() {
    	institutionPage.clickOkModalButton();
    }
    
    @Step
	public void checkInstitutionInTable(String shortName) {
		institutionPage.checkInstitutionInTable(shortName);		
	}
    
    @Step
	public void selectInstitutionByShortName(String shortName) {
		institutionPage.selectInstitutionByShortName(shortName);		
	}
        
    @Step
	public void deleteInstitutionByShortName(String shortName) {
		institutionPage.deleteInstitutionByShortName(shortName);		
	}
    
    @Step
	public void clickProceedButton() {
	    institutionPage.clickProceedButton();
	}
    
    @Step
    public void checkInstitutionIsRemoved (String shortName) {
    	institutionPage.checkInstitutionIsRemoved(shortName);
    }
    
    @Step
    public void verifyThereIsNoInstitutionByName(String institutionName) {
        institutionPage.verifyThereIsNoInstitutionByName(institutionName);
    }
    
    @Step
    public void checkValueInTheTable(String institution, String value, String column) {
        institutionPage.checkValueInTheTable(institution, value, column);
    }
    
    @Step
    public void goToCustomSplashPage(String institution) {
        institutionPage.goToCustomSplashPage(institution);
    }
}
