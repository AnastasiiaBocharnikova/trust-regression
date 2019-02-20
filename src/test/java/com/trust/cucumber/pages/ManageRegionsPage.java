package com.trust.cucumber.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.components.HtmlTable;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.is;

public class ManageRegionsPage extends PageObject {

    @FindBy (xpath = "//div[@title='List of regions']//table")
    private WebElementFacade listOfRegionsTable;

    @FindBy (xpath = "//div[@title='List of regions']//table//tbody")
    private WebElementFacade noHeadingsListOfRegionsTable;

    @FindBy(xpath = "//*[@id='monitors-header']/ancestor::table")
    private WebElementFacade regionsTable;

    @FindBy(css = "#name-field")
    private WebElement nameField;

    @FindBy(css = "#oid-field")
    private WebElement oidField;

    @FindBy(css = "#description-filed")
    private WebElement descriptionField;

    public List<String> getHeadersFromTable() {
        return inTable(listOfRegionsTable).getHeadings();
    }

    private final String[] customHeadersListOfRegions = new String[]{"On", "Name*", "OID*", "Description", "Delete button"};

    public void clickOnRegionListButton() {
        clickOn($("#regions-list-link"));
    }

    public void verifyListOfRegionsFormIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/regions/list"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().equals("List of regions"));
    }

    public void verifyListOfRegionsTableIsSortedByStringColumnAscending(int columnNumber) {
        List <WebElementFacade> list = findAll(By.xpath("//div[@title='List of regions']//td["+columnNumber+"]"));
        for (int i = 0; i < list.size()-1; i++) {
            Assert.assertTrue((list.get(i).getText().compareTo(list.get(i+1).getText())<0)||(list.get(i).getText().equals(list.get(i+1).getText())));
        }
    }

    public void verifyListOfRegionsTableIsSortedByStringColumnDescending(int columnNumber) {
        List <WebElementFacade> list = findAll(By.xpath("//div[@title='List of regions']//td["+columnNumber+"]"));
        for (int i = 0; i < list.size()-1; i++) {
            Assert.assertTrue((list.get(i).getText().compareTo(list.get(i+1).getText())>0)||(list.get(i).getText().equals(list.get(i+1).getText())));
        }
    }

    public void verifyAllRegionCheckboxesIsSelectedForMonitor() {
        List<WebElement> listRegionCheckboxes = regionsTable.findElements(By.xpath(".//tr//input"));
        for (int i = 0; i < listRegionCheckboxes.size(); i++) {
            Assert.assertTrue(listRegionCheckboxes.get(i).isSelected());
        }
    }

    public void verifyRegionIsDisabledForSystem(String region) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).
                collect(Collectors.toList());
        Assert.assertTrue(regionsTable.findElements(By.xpath(".//tr//button[@id='system-region-icon']")).get(regions.indexOf(region)).getAttribute("style").equals("color: rgb(66, 66, 66);"));
        Assert.assertTrue(regionsTable.findElements(By.xpath(".//tr//button[@id='system-region-icon']")).get(regions.indexOf(region)).findElement(By.xpath(".//span[text()]")).getText().equals("check_circle"));
    }

    public void verifyRegionIsSelectedForAllMonitors(String region) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).
                collect(Collectors.toList());
         Assert.assertTrue(regionsTable.findElements(By.xpath(".//tr//input")).get(regions.indexOf(region)).isSelected());
    }

    public void verifyRegionsTableIsDisplayed(String state) {
        switch (state) {
            case "not": shouldNotBeVisible(regionsTable);
                break;
            default: shouldBeVisible(regionsTable);
                break;
        }
    }

    public void verifyButtonIsDisplayed(String button, String state) {
        switch (state) {
            case "not": shouldNotBeVisible(By.cssSelector("#" + button +"-btn"));
                break;
            default: shouldBeVisible(By.cssSelector("#" + button +"-btn"));
                break;
        }
    }

    public void verifyColumnIsDisplayed(String header, String state)   {
        switch (state) {
            case "not": shouldNotBeVisible(By.xpath("//span[contains(@id,'" + header.toLowerCase() + "-header')]"));
                break;
            default: shouldBeVisible(By.xpath("//span[contains(@id,'" + header.toLowerCase() + "-header')]"));
                break;
        }
    }

    public void clickOnButton(String button) {
        clickOn($("#" + button +"-btn"));
    }

    public void verifyAggregatedMonitorNameStyle(String monitor) {
        Assert.assertTrue($("//div[text()='" + monitor + "']").isDisplayed());
        Assert.assertTrue($("//div[text()='" + monitor + "']").getCssValue("font-style").equals("italic"));
        Assert.assertTrue($("//div[text()='" + monitor + "']").getCssValue("font-weight").equals("700"));
    }

    public void verifyTooltipTextForAggregatedMonitor(String subMonitor1, String subMonitor2, String aggrMonitor) {
        Assert.assertTrue($("//div[text()='" + aggrMonitor + "']").getAttribute("title").equals(subMonitor1+", "+subMonitor2)||$("//div[text()='" + aggrMonitor + "']").getAttribute("title").equals(subMonitor2+", "+subMonitor1));
    }

    public void clickOnAggregateSwitch() {
        clickOn($("#aggregate-switch"));
    }

    public void expandSystem(String system) {
        $("//span[contains(text(), '" + system + "')]").click();
    }

    public void verifyAggrMonitorIsDisplayed(String monitor) {
        Assert.assertTrue($("//div[text()='" + monitor + "']").isDisplayed());
    }

    public void verifyMonitorIsDisplayed(String monitor) {
        Assert.assertTrue($("//td[text()='" + monitor + "']").isDisplayed());
    }

    public void verifyAllSystemsExpanded() {
        List <WebElementFacade> listOfButtons = findAll(By.cssSelector("#show-more-btn-undefined"));
        List <WebElementFacade> listOfExpandedSystems = findAll(By.xpath("//button[contains(@class,'DataTable_expandOpen_3OvhC')]"));
        Assert.assertTrue(listOfButtons.size()==listOfExpandedSystems.size());
    }

    public void verifyAllSystemsCollapsed() {
        shouldNotBeVisible(By.xpath("//button[contains(@class,'DataTable_expandOpen_3OvhC')]"));
    }

    public void verifyDeleteButtonIsDisabledForUSA() {
        Assert.assertFalse($("//div[@title='List of regions']//table//td[text()='USA']/ancestor::tr/td[5]//button").isEnabled());
    }

    public void verifyCreateRegionFormIsDisplayed() {
        shouldBeVisible(By.xpath("//form[@id='region-form']"));
    }

    private void populateValueInField(WebElement element, String value) {
        element.sendKeys(value);
    }

    private void replaceValueInField(String oldValue, String value) {
        Actions action = new Actions (getDriver());
        action.moveToElement(findBy("//td[text()='"+oldValue+"']")).doubleClick().build().perform();
        WebElement element = findBy("//input[@value='"+oldValue+"']");
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.BACK_SPACE);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void clickOnEnabledCheckbox() {
        clickOn($("#enabled-field"));
    }

    public void populateNewRegionFields(Map<String, String> user) {
        populateValueInField(nameField, user.get("Name"));
        populateValueInField(oidField, user.get("OID"));
        populateValueInField(descriptionField, user.get("Description"));
    }

    public void updateRegionFields(String name, String oid, String description, Map<String, String> user) {
        replaceValueInField(name, user.get("Name"));
        replaceValueInField(oid, user.get("OID"));
        replaceValueInField(description, user.get("Description"));
    }

    public void checkRegionInListOfRegionsTable(String name, String oid, String description, String state) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
        switch (state) {
            case "not": newTable.shouldNotHaveRowElementsWhere(the("Name*", is(name)), the("OID*", is(oid)), the("Description", is(description)));
                break;
            default: newTable.shouldHaveRowElementsWhere(the("Name*", is(name)), the("OID*", is(oid)), the("Description", is(description)));
                break;
        }
    }

    public void verifyNoRegionByNameAndOID(String name, String oid) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
        if(newTable.containsRowElementsWhere(the("Name*", is(name)), the("OID*", is(oid)))) {
            newTable.findFirstRowWhere(the("Name*", is(name)), the("OID*", is(oid))).
                    findElement(By.cssSelector("button[id*='delete-region']")).click();
            $("#modal-button-proceed").click();
        }
    }

    public void clickOnDeleteButtonForRegionByNameAndOID(String name, String oid) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
        newTable.findFirstRowWhere(the("Name*", is(name)), the("OID*", is(oid))).
                findElement(By.cssSelector("button[id*='delete-region']")).click();
    }

    public void verifyEnabledCheckboxIsSelectedForRegion(String name) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
            Assert.assertTrue(newTable.findFirstRowWhere(the("Name*", is(name))).findElement(By.cssSelector("input[id*='on-checkbox']")).isSelected());
    }

    public void verifyEnabledCheckboxIsNotSelectedForRegion(String name) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
        Assert.assertFalse(newTable.findFirstRowWhere(the("Name*", is(name))).findElement(By.cssSelector("input[id*='on-checkbox']")).isSelected());
    }

    public void clickOnEnabledCheckboxForRegion(String name) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersListOfRegions).inTable(noHeadingsListOfRegionsTable);
        newTable.findFirstRowWhere(the("Name*", is(name))).findElement(By.cssSelector("input[id*='on-checkbox']")).click();
    }

    public void clickOnRegionCheckboxForAggrMonitor(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        $("//div[text()='" + monitor + "']/ancestor::tr").findElements(By.xpath(".//input")).get(regions.indexOf(region)).click();
    }

    public void clickOnRegionCheckboxForMonitor(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        $("//td[text()='" + monitor + "']/ancestor::tr").findElements(By.xpath(".//input")).get(regions.indexOf(region)).click();
    }

    public void verifyRegionIsNotSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement aggMonitorRow = findBy("//*[@id='monitors-header']/ancestor::table//div[text()='" + monitor + "']/ancestor::tr");
        Assert.assertFalse(aggMonitorRow.findElements(By.xpath(".//input")).get(regions.indexOf(region)).isSelected());
    }

    public void verifyRegionIsNotSelectedForMonitorInRegionsTable(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement monitorRow = findBy("//*[@id='monitors-header']/ancestor::table//td[text()='" + monitor + "']/ancestor::tr");
        Assert.assertFalse(monitorRow.findElements(By.xpath(".//input")).get(regions.indexOf(region)).isSelected());
    }

    public void verifyRegionIsSelectedForAggrMonitorInRegionsTable(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement aggMonitorRow = findBy("//*[@id='monitors-header']/ancestor::table//div[text()='" + monitor + "']/ancestor::tr");
        Assert.assertTrue(aggMonitorRow.findElements(By.xpath(".//input")).get(regions.indexOf(region)).isSelected());
    }

    public void verifyRegionIsSelectedForMonitorInRegionsTable(String region, String monitor) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement monitorRow = findBy("//*[@id='monitors-header']/ancestor::table//td[text()='" + monitor + "']/ancestor::tr");
        Assert.assertTrue(monitorRow.findElements(By.xpath(".//input")).get(regions.indexOf(region)).isSelected());
    }

    public void verifyRegionIsSelectedForSystemInRegionsTable(String region, String system) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement systemRow = findBy("//*[@id='monitors-header']/ancestor::table//span[contains(text(), '" + system + "')]/ancestor::tr");
        Assert.assertTrue(systemRow.findElements(By.xpath(".//button[@id='system-region-icon']")).get(regions.indexOf(region)).
                findElement(By.xpath(".//span[text()]")).getText().equals("check_circle"));
        Assert.assertTrue(systemRow.findElements(By.xpath(".//button[@id='system-region-icon']")).get(regions.indexOf(region)).
                getAttribute("style").equals("color: rgb(21, 101, 192);"));
    }

    public void verifyRegionIsNotSelectedForSystemInRegionsTable(String region, String system) {
        List<String> regions = inTable(regionsTable).getHeadings().stream().
                filter(e -> e.matches("[A-Z]{2,}")).collect(Collectors.toList());
        WebElement systemRow = findBy("//*[@id='monitors-header']/ancestor::table//span[contains(text(), '" + system + "')]/ancestor::tr");
        Assert.assertTrue(systemRow.findElements(By.xpath(".//button[@id='system-region-icon']")).get(regions.indexOf(region)).
                findElement(By.xpath(".//span[text()]")).getText().equals("highlight_off"));
        Assert.assertTrue(systemRow.findElements(By.xpath(".//button[@id='system-region-icon']")).get(regions.indexOf(region)).
                getAttribute("style").equals("color: rgb(66, 66, 66);"));
    }

    public void userExpandsRegionsTable() {
        clickOn($("//span[text()=' keyboard_arrow_right ']"));
    }
}
