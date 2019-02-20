package com.trust.cucumber.pages;

import java.util.*;
import java.util.stream.Collectors;

import com.trust.cucumber.util.Environment;
import com.trust.cucumber.util.Log;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.matchers.BeanMatchers.each;
import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static org.hamcrest.Matchers.is;

public class InstitutionsPage extends PageObject {

    private Environment testEnvironment  = ConfigFactory.create(Environment.class);

    private String env = testEnvironment.env();

	@FindBy(css = "#new-institutions-btn")
	private WebElement newInstitutionButton;
	
	@FindBy (css = "div.ReactTable table")
	private WebElement institutionsTable;		
	
	@FindBy (css = "div.ReactTable table tbody")
	private WebElement noHeadingsTable;
	
	@FindBy (css = "#name-field")
	private WebElement institutionNameTextBox;
	
	@FindBy (css = "#shortname-field")
	private WebElement shortNameTextBox;
	
	@FindBy (css = "#entity-id-field")
	private WebElement entityIdTextBox;

    @FindBy (css = "#device-field-0")
    private WebElement deviceTextBox;
	
	@FindBy (css = "#contact-name-field-0")
	private WebElement contactNameTextBox;
	
	@FindBy (css = "#email-field-0")
	private WebElement emailTextBox;

	@FindBy (css = "div.Search_suggestionContainer_3Gnz9>div>div")
	private List <WebElementFacade> autocompleteOptions;
	
	@FindBy(css = "#modal-button-proceed")
	private WebElement proceedModalButton;
		
	@FindBy(css = "div.Toastify__toast-body")
	private WebElementFacade toasterSection;
		
	private final String[] customHeaders = new String[]{"Details Button","Name","Short Name","Entity ID", "Devices", "Systems", "Contacts", "Delete button"};
	
	public List<String> getHeadersFromInstitutionsTable() {
		return inTable(institutionsTable).getHeadings();
	}
	
	public void clickNewInstitutionButton() {
		newInstitutionButton.click();
	}

	public void populateNewInstitutionFields(Map<String, String> institution) {
	    replaceValueInfield(institutionNameTextBox, institution.get("Name"));
        replaceValueInfield(shortNameTextBox,institution.get("Short name"));
        replaceValueInfield(entityIdTextBox,institution.get("Entity ID"));
        replaceValueInfield(deviceTextBox,institution.get("Devices"));
        selectSystemThroughAutocompleteSearch(institution.get("Systems"));
        replaceValueInfield(contactNameTextBox,institution.get("Contact name"));
        replaceValueInfield(emailTextBox,institution.get("Contact email"));
	}

    private void replaceValueInfield(WebElement element, String value) {
        if(value != null && !value.isEmpty()){
            element.clear();
            element.sendKeys(value);
        }
    }
	
	public void clickOkModalButton() {
		$("#modal-button-ok").click();
	}

    private void selectSystemThroughAutocompleteSearch(String system) {
	    Log.info(system);
        if (!Objects.equals(system, "") && system != null) {
            $("#systems-field").sendKeys(system);
            element(By.xpath("//div[contains(@class,'Search_suggestionContainer_3Gnz9')]/div/div[contains(text(),'" + system + "')]")).click();
        }
    }
		
	public void checkInstitutionInTable(String shortName) {
		HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
		newTable.shouldHaveRowElementsWhere(the("Short Name", is(shortName)));
		shouldMatch(newTable.getRows().stream().
				filter(row ->row.containsValue(" ")!= true).collect(Collectors.toList()),
					each("Short Name").isDifferent(), each("Entity ID").isDifferent());
	}
	
	public void selectInstitutionByShortName(String shortName) {
		HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
		List<WebElement> rowCells = newTable.findFirstRowWhere(the("Short Name", is(shortName))).findElements(By.xpath("./td"));
		rowCells.get(Arrays.asList(customHeaders).indexOf("Short Name")).click();
	}
		
	public void deleteInstitutionByShortName(String shortName) {
		HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
		newTable.findFirstRowWhere(the("Short Name", is(shortName))).
			findElement(By.cssSelector("div.DataTable_actionWrap_2XTGV button")).click();
	}
	
	public void clickProceedButton() {
		proceedModalButton.click();
	}
	
	public void checkInstitutionIsRemoved (String shortName) {
		HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
		newTable.shouldNotHaveRowElementsWhere(the("Short Name", is(shortName)));
	}
	
	public void verifyToasterIsDisplayed (String institutionName, String status) {
		Assert.assertTrue(toasterSection.isDisplayed());
		Assert.assertTrue(toasterSection.getText().equals("Institution '" + institutionName + "' was " + status));	
	}
	
    public void verifyThereIsNoInstitutionByName(String institutionName) {
        HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
        if(newTable.containsRowElementsWhere(the("Name", is(institutionName)))) {
            newTable.findFirstRowWhere(the("Name", is(institutionName))).
                    findElement(By.cssSelector("div.DataTable_actionWrap_2XTGV button")).click();
            clickProceedButton();
        }
    }

    public void checkValueInTheTable(String institution, String value, String column) {
        HtmlTable newTable = HtmlTable.withColumns(customHeaders).inTable(noHeadingsTable);
        List<WebElement> matchingRows =  newTable.getRowElementsWhere(the("Name", is(institution)),the(column, is(value) ));
        Assert.assertTrue(matchingRows.size() == 1);
    }

    public void goToCustomSplashPage(String institution) {
        getDriver().get(env + "i/" + institution);
    }
}
