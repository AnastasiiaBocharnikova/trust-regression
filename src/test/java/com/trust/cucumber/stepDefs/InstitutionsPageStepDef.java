package com.trust.cucumber.stepDefs;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

import com.trust.cucumber.steps.CommonSteps;
import com.trust.cucumber.steps.InstitutionsPageSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InstitutionsPageStepDef {
	
	@Steps
	InstitutionsPageSteps inst;
	
    @Steps
    CommonSteps commonSteps;
		
	@When("^Institutions table contains next headers$")
	public void displayHeaders(List<String> arg) {
		inst.checkInstitutionTableHeaders(arg);
	}
	
	@When ("^User clicks New Institution button$")
	public void clickNewInstitutionButton() {
		inst.clickNewInstitutionButton();
	}

	@When ("^User populates institution fields with next values$")
	public void populateNewInstitutionFields(Map<String, String> arg) {
		inst.populateNewInstitutionFields(arg);
		inst.clickOkModalButton();
	}
	
	@Then ("^Toaster institution (.*) was (.*) is displayed")
	public void verifyToasterIsDisplayed(String institutionName, String status) {
		inst.verifyToasterIsDisplayed(institutionName, status);
		commonSteps.clickCloseToasterButton();
	}
	
	@Then ("^Institution (.*) is displayed in the table$")
	public void checkInstitutionInTable(String shortName) {
		inst.checkInstitutionInTable(shortName);
	}
	
	@When ("^User clicks on (.*) institution in the table$")
	public void selectInstitutionByShortName(String shortName) {
		inst.selectInstitutionByShortName(shortName);
	}
	
	@When ("^User updates institution fields to the next values$")
	public void updateInstitutionFields(Map<String, String> arg) {
		inst.populateNewInstitutionFields(arg);
		inst.clickOkModalButton();
	}
	
	@When ("^User deletes (.*) institution from the table$")
	public void deleteInstitutionByShortName(String shortName) {
		inst.deleteInstitutionByShortName(shortName);
		inst.clickProceedButton();
	}
	
	@Then ("^Institution (.*) is removed from table$")
	public void checkInstitutionIsRemovedFromTable (String shortName) {
		inst.checkInstitutionIsRemoved(shortName);
	}

	@When("^User verifies that there is no institution (.*)$")
	public void verifyThereIsNoInstitutionByName(String institutionName) {
		inst.verifyThereIsNoInstitutionByName(institutionName);
	}

    @And("^Institution (.*) has (.*) value in (.*) column$")
    public void checkInstHasSomevalueInTable(String institution, String value, String column) {
        inst.checkValueInTheTable(institution,value,column);
    }

    @When("^User navigates to (.*) institution Сustom Splash Page$")
    public void userNavigatesToInstitutionCustomSplashPage(String institution)  {
        inst.goToCustomSplashPage(institution);
    }
}
