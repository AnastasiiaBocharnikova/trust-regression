package com.trust.cucumber.pages;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.components.HtmlTable;

import com.trust.cucumber.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.thucydides.core.matchers.BeanMatcherAsserts.shouldMatch;
import static net.thucydides.core.matchers.BeanMatchers.each;
import static net.thucydides.core.matchers.BeanMatchers.the;
import static net.thucydides.core.pages.components.HtmlTable.inTable;
import static org.hamcrest.Matchers.*;
import javax.mail.*;

public class ManageUsersPage extends PageObject {

	@FindBy(css = "div.ReactTable table")
	private WebElement manageUsersTable;

    @FindBy (css = "div.ReactTable table tbody")
    private WebElement noHeadingsTable;

	@FindBy(css = "#new-users-btn")
	private WebElement newUsersButton;

	@FindBy(css = "#new-bulk-users-btn")
	private WebElement bulkUserCreationButton;

	@FindBy(css = "#upload-csv-btn")
	private WebElement uploadCsvButton;

    @FindBy(css = "#submit-upload-btn")
    private WebElement submitUploadButton;

    @FindBy(css = "#close-bulk-users-modal")
    private WebElement closeBulkUsersModalButton;

    @FindBy (css = "button[id*='delete-user']")
    private WebElement deleteUserButton;

    @FindBy(css = "#modal-button-proceed")
    private WebElement proceedModalButton;

    @FindBy(css = "#user_name-filter-field")
    private WebElement usernameFilterField;

    @FindBy(css = "#first_name-filter-field")
    private WebElement firstNameFilterField;

    @FindBy(css = "#last_name-filter-field")
    private WebElement lastNameFilterField;

    @FindBy(css = "#email-filter-field")
    private WebElement emailFilterField;

    @FindBy(xpath = "//text()[.='\u200B']/ancestor::div[1]")
    private WebElement rolesFilterField;

    @FindBy(css = "#roles-lists-switch")
    private WebElement rolesSystemsListsSwitchButton;

    @FindBy(css = "#systems-list-field")
    private WebElement systemsListFilterField;

    @FindBy(css = "#username-field")
    private WebElement usernameField;

    @FindBy(css = "#email-field")
    private WebElement emailField;

    @FindBy(css = "#first-name-field")
    private WebElement firstNameField;

    @FindBy(css = "#last-name-field")
    private WebElement lastNameField;

    @FindBy(css = "#middle-initial-field")
    private WebElement middleInitialField;

    @FindBy(css = "#add-new-users-role")
    private WebElement addNewUsersRoleButton;

    @FindBy(css = "#delete-users-role")
    private WebElement deleteUsersRoleButton;

    @FindBy (css = "div[id*='downshift']")
    private List<WebElementFacade>multipleDropDownOptions;

    @FindBy(css = "div.Toastify__toast-body")
    private WebElementFacade toasterSection;

    @FindBy (xpath = "//td[2]")
    private List<WebElementFacade> listOfUsernameColumn;

    @FindBy (xpath = "//td[3]")
    private List<WebElementFacade> listOfFirstNameColumn;

    @FindBy (xpath = "//td[4]")
    private List<WebElementFacade> listOfMiddleInitialColumn;

    @FindBy (xpath = "//td[5]")
    private List<WebElementFacade> listOfLastNameColumn;

    @FindBy (xpath = "//td[6]")
    private List<WebElementFacade> listOfEmailColumn;

    @FindBy (xpath = "//td[7]")
    private List<WebElementFacade> listOfRolesColumn;

    @FindBy (xpath = "//td[8]")
    private List<WebElementFacade> listOfCreationTimeColumn;

    @FindBy (xpath = "//td[9]")
    private List<WebElementFacade> listOfLastUpdatedColumn;

    @FindBy(css = "#change-pass-btn")
    private WebElement changePasswordButton;

    @FindBy(css = "#pass-field")
    private WebElement passwordTextField;

    @FindBy(css = "#repeat-pass-field")
    private WebElement repeatPasswordTextField;

    @FindBy(css = "#password")
    private WebElement passwordTextFieldProfile;

    @FindBy(css = "#repeatPassword")
    private WebElement repeatPasswordTextFieldProfile;

    @FindBy(xpath = "//input[@id='show-pass-value']")
    private WebElement showPasswordCheckbox;

    @FindBy (xpath = "//div[contains(@class,'PasswordField_passwordControl_2pTfp')]//p")
    private List<WebElementFacade> listOfMessagesForPasswordFields;

    @FindBy (xpath = "//div[contains(@class,'PasswordField_passwordControl_2pTfp')]//span[contains(text(), 'check')]")
    private List<WebElementFacade> listOfGreenGreenCheckMarkForPasswordFields;

    @FindBy(css = "#profile-btn")
    private WebElement profileButton;

    private final String[] customHeadersManageUsers = new String[]{"Enabled","Username","First Name","Middle Initial", "Last Name", "Email", "Roles", "Creation time", "Last updated"};

	public ManageUsersPage(WebDriver driver) {
		super(driver);
	}

	public List<String> getHeadersFromTable() {
		return inTable(manageUsersTable).getHeadings();
	}

    private List <Map> getTableWithoutEmptyRows() {
        return HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable).
                getRows().stream().filter(row -> !row.containsValue(" ")).collect(Collectors.toList());
    }

    public void clickOnBulkUserCreationButton() {
        bulkUserCreationButton.click();
    }

    public void uploadCsvFile(String fileName) // copying, pasting and clicking on Upload CSV button in one method for stable focusing
    {
        StringSelection ss = new StringSelection(fileName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        uploadCsvButton.click();
        waitABit(2000);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {e.printStackTrace();}
    }

	public void clickOnNewUsersButton() {
		newUsersButton.click();
	}

    public void verifyCreateUserPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/users/new"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().contains("Create User"));
    }

    public void clickOnProfileButton() {
        profileButton.click();
    }

    public void verifyProfilePopUpIsOpened() {
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6")).getText().contains("Profile"));
    }

    public void clickOnSubmitUploadButton() {
        submitUploadButton.click();
    }

    private void clickOnProceedButton() {
        proceedModalButton.click();
    }

    public void clickOnCloseBulkUsersModalButton() {
        closeBulkUsersModalButton.click();
    }

    public void verifyBulkUserCreationPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/users/bulk"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h2")).getText().contains("Bulk user creation"));
    }

    public void verifyFileIsSuccessfullySelected() {
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h1")).getText()
                .contains("Success! Here is the list of users, that would be created. Press submit to create them."));
    }

    public void verifyUsersHaveBeenCreatedText() {
        Assert.assertTrue(getDriver().findElement(By.xpath("//div[@class='BulkUserCreation_success_3YPRp']//h2")).getText()
                .contains("Users have been created!"));
    }

    public void checkUserByUsernameInTable(String username) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        newTable.shouldHaveRowElementsWhere(the("Username", is(username)));
        shouldMatch(newTable.getRows().stream().
                        filter(row -> !row.containsValue(" ")).collect(Collectors.toList()),
                each("Username").isDifferent(), each("Email").isDifferent());
    }

    public void deleteUserByUsername(String username) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        newTable.findFirstRowWhere(the("Username", is(username))).
                    findElement(By.cssSelector("button[id*='delete-user']")).click();
    }

    public void checkUserIsDeleted (String username) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        newTable.shouldNotHaveRowElementsWhere(the("Username", is(username)));
    }

    public void verifyThereIsNoUserByUsername(String username) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        waitABit(2000);
        if(newTable.containsRowElementsWhere(the("Username", is(username)))) {
            newTable.findFirstRowWhere(the("Username", is(username))).
                    findElement(By.cssSelector("button[id*='delete-user']")).click();
            clickOnProceedButton();
        }
    }

    public void verifyThereIsNoUserByEmail(String email) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        if(newTable.containsRowElementsWhere(the("Email", is(email)))) {
            newTable.findFirstRowWhere(the("Email", is(email))).
                    findElement(By.cssSelector("button[id*='delete-user']")).click();
            clickOnProceedButton();
        }
    }

    private void replaceValueInfield(WebElement element, String value) {
        if(value != null && !value.isEmpty()){
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            element.sendKeys(Keys.BACK_SPACE);
            element.clear();
            element.sendKeys(value);
        }
    }

    public void populateNewUserFields(Map<String, String> user) {
        replaceValueInfield(usernameField, user.get("Username"));
        replaceValueInfield(emailField, user.get("Email"));
        replaceValueInfield(firstNameField, user.get("First Name"));
        replaceValueInfield(lastNameField, user.get("Last Name"));
        replaceValueInfield(middleInitialField, user.get("Middle Initial"));
        selectRole(user.get("Role"));
    }

    private void clickOnAddNewUsersRoleButton() {
        addNewUsersRoleButton.click();
    }

    public void selectRole(String role) {
        if (!Objects.equals(role, "") && role != null) {
            clickOnAddNewUsersRoleButton();
            $("//input[@type='text'][@placeholder='Select role']").click();
            waitFor("//div[contains(@class,'Search_suggestionContainer_3Gnz9')]/div/div[contains(text(),'" + role + "')]");
            element(By.xpath("//div[contains(@class,'Search_suggestionContainer_3Gnz9')]/div/div[contains(text(),'" + role + "')]")).click();
        }
    }

    public void selectSystem(String system) {
        if (!Objects.equals(system, "") && system != null) {
            $("//input[@type='text'][@placeholder='Select system lists']").click();
            element(By.xpath("//div[contains(@class,'Search_suggestionContainer_3Gnz9')]/div/div[contains(text(),'" + system + "')]")).click();
        }
    }

    public void selectUsernameByName(String username) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        List<WebElement> rowCells = newTable.findFirstRowWhere(the("Username", is(username))).findElements(By.xpath("./td"));
        rowCells.get(Arrays.asList(customHeadersManageUsers).indexOf("Username")).click();
    }

    public void verifyEditUserPopUpIsOpened() {
        Assert.assertTrue(getDriver().getCurrentUrl().contains("/admin/users/"));
        Assert.assertTrue(getDriver().findElement(By.xpath("//div//h6/span")).getText().equals("Edit User"));
    }

    public void checkUsernameFieldIsDisabled() {
        Assert.assertFalse($("//input[@name='user_name']").isEnabled());
    }

    public void checkUsernameFieldText(String username) {
        Assert.assertTrue($("//input[@name='user_name']").getAttribute("value").equals(username));
    }

    public void checkEmailFieldText(String email) {
        Assert.assertTrue($("//input[@name='email']").getAttribute("value").equals(email));
    }

    public void clickOnDeleteUsersRoleButton() {
        deleteUsersRoleButton.click();
    }

    public void checkEnabledCheckboxIsDisabled() {
        Assert.assertFalse($("#enabled-checkbox-0").isEnabled());
    }

    public void checkDeleteButtonIsDisabled() {
        Assert.assertFalse($("#delete-user-0").isEnabled());
    }

    public void checkCloneButtonIsDisabled() {
        Assert.assertFalse($("#clone-user-0").isEnabled());
    }

    public void verifyToasterIsDisplayed (String text) {
        Assert.assertTrue(toasterSection.isDisplayed());
        Assert.assertTrue(toasterSection.getText().equals(text));
    }

    public void checkEnabledToggleIsDisabled() {
        Assert.assertFalse($("#enabled-field").isEnabled());
    }

    public void checkGuestRoleIsDisabled() {
        Assert.assertFalse($("//input[@type='text'][@placeholder='Guest']").isEnabled());
    }

    public void checkEmailForUsernameInTheTable(String username, String email) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        newTable.shouldHaveRowElementsWhere(the("Username", is(username)),the("Email", is(email)));
    }

    public void checkRolesForUsernameInTheTable(String username, String role) {
        HtmlTable newTable = HtmlTable.withColumns(customHeadersManageUsers).inTable(noHeadingsTable);
        newTable.shouldHaveRowElementsWhere(the("Username", is(username)),the("Roles", containsString(role)));
    }

    public void clickOnCloneButton() {
        $("#clone-user-0").click();
    }

    public void checkErrorMessageForUsername() {
        Assert.assertTrue($("#username-field-helper-text").isDisplayed());
        Assert.assertTrue($("#username-field-helper-text").getText().equals("Please change the username (it has to be unique)"));
    }

    public void checkErrorMessageForEmail() {
        Assert.assertTrue($("#email-field-helper-text").isDisplayed());
        Assert.assertTrue($("#email-field-helper-text").getText().equals("Please change the email (it has to be unique)"));
    }

    public void clickOnRolesSystemsListsSwitchButton() {
        rolesSystemsListsSwitchButton.click();
    }

    private void setValueToTextFilterField(WebElement element, String text) {
	    waitFor(element);
        element.click();
        element.sendKeys(text);
    }

    private void checkByFilterInTheTable(List<WebElementFacade> list, String value) {
        for (int i = 0; i < getTableWithoutEmptyRows().size(); i++) {
            Log.info(list.get(i).getText());
            Assert.assertTrue(list.get(i).getText().contains(value));
        }
    }

    public void setValueToUsernameField(String username) {
        setValueToTextFilterField(usernameFilterField, username);
    }

    public void setFilterByFirstName(String firstName) {
        setValueToTextFilterField(firstNameFilterField, firstName);
    }

    public void checkUsersFirstNameInTable(String firstName) {
        checkByFilterInTheTable(listOfFirstNameColumn, firstName);
    }

    public void setFilterByLastName(String lastName) {
        setValueToTextFilterField(lastNameFilterField, lastName);
    }

    public void checkUsersLastNameInTable(String lastName) {
        checkByFilterInTheTable(listOfLastNameColumn, lastName);
    }

    public void setValueToEmailField(String email) {
        setValueToTextFilterField(emailFilterField, email);
    }

    public void checkUserByEmailInTable(String email) {
        checkByFilterInTheTable(listOfEmailColumn, email);
    }

    public void setValueToRolesField (String role) {
        rolesFilterField.click();
        element(By.xpath("//div[@role='document']//li[contains(text(),'" + role + "')]")).click();
    }

    public void checkUserByRoleInTable(String role) {
        checkByFilterInTheTable(listOfRolesColumn, role);
    }

    public void setValueToSystemField(String system) {
        setValueToTextFilterField(systemsListFilterField, system);
    }

    public void checkUserBySystemInTable(String system) {
        checkByFilterInTheTable(listOfRolesColumn, system);
    }

    //Sorting
    private void verifyManageUsersTableIsSortedByDateColumnAscending(List <WebElementFacade> list) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            String firstDate = list.get(i).getText();
            String secondDate = list.get(i+1).getText();
            Date date1 = dateFormat.parse(firstDate);
            Date date2 = dateFormat.parse(secondDate);
            Assert.assertTrue((date1.compareTo(date2)<0)||(date1.equals(date2)));
        }
    }

    private void verifyManageUsersTableIsSortedByDateColumnDescending(List <WebElementFacade> list) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy, MMM d, hh:mm a");

        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            String firstDate = list.get(i).getText();
            String secondDate = list.get(i+1).getText();
            Date date1 = dateFormat.parse(firstDate);
            Date date2 = dateFormat.parse(secondDate);
            Assert.assertTrue((date1.compareTo(date2)>0)||(date1.equals(date2)));
        }
    }

    private void verifyManageUsersTableIsSortedByStringColumnAscending(List <WebElementFacade> list) {
        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
                Assert.assertTrue((list.get(i).getText().compareTo(list.get(i + 1).getText()) < 0) || (list.get(i).getText().equals(list.get(i + 1).getText())));
        }
    }

    private void verifyManageUsersTableIsSortedByStringColumnDescending (List <WebElementFacade> list) {
        for (int i = 0; i < getTableWithoutEmptyRows().size()-1; i++) {
            Assert.assertTrue((list.get(i).getText().toLowerCase().compareTo(list.get(i+1).getText())>0)||(list.get(i).getText().toLowerCase().equals(list.get(i+1).getText())));
        }
    }

    public void verifyManageUsersTableIsSortedByUsernameAscending() {
        verifyManageUsersTableIsSortedByStringColumnAscending(listOfUsernameColumn);
    }

    public void verifyManageUsersTableIsSortedByUsernameDescending() {
        verifyManageUsersTableIsSortedByStringColumnDescending(listOfUsernameColumn);
    }

    public void verifyManageUsersTableIsSortedByFirstNameAscending() {
        verifyManageUsersTableIsSortedByStringColumnAscending(listOfFirstNameColumn);
    }

    public void verifyManageUsersTableIsSortedByFirstNameDescending() {
        verifyManageUsersTableIsSortedByStringColumnDescending(listOfFirstNameColumn);
    }

    public void verifyManageUsersTableIsSortedByMiddleInitialAscending() {
        verifyManageUsersTableIsSortedByStringColumnAscending(listOfMiddleInitialColumn);
    }

    public void verifyManageUsersTableIsSortedByMiddleInitialDescending() {
        verifyManageUsersTableIsSortedByStringColumnDescending(listOfMiddleInitialColumn);
    }

    public void verifyManageUsersTableIsSortedByLastNameAscending() {
        verifyManageUsersTableIsSortedByStringColumnAscending(listOfLastNameColumn);
    }

    public void verifyManageUsersTableIsSortedByLastNameDescending() {
        verifyManageUsersTableIsSortedByStringColumnDescending(listOfLastNameColumn);
    }

    public void verifyManageUsersTableIsSortedByEmailAscending() {
        verifyManageUsersTableIsSortedByStringColumnAscending(listOfEmailColumn);
    }

    public void verifyManageUsersTableIsSortedByEmailDescending() {
        verifyManageUsersTableIsSortedByStringColumnDescending(listOfEmailColumn);
    }

    public void verifyManageUsersTableIsSortedByCreationTimeAscending() throws ParseException {
        verifyManageUsersTableIsSortedByDateColumnAscending(listOfCreationTimeColumn);
    }

    public void verifyManageUsersTableIsSortedByCreationTimeDescending() throws ParseException {
        verifyManageUsersTableIsSortedByDateColumnDescending(listOfCreationTimeColumn);
    }

    public void verifyManageUsersTableIsSortedByLastUpdatedAscending() throws ParseException {
        verifyManageUsersTableIsSortedByDateColumnAscending(listOfLastUpdatedColumn);
    }

    public void verifyManageUsersTableIsSortedByLastUpdatedDescending() throws ParseException {
        verifyManageUsersTableIsSortedByDateColumnDescending(listOfLastUpdatedColumn);
    }

    public void clickOnChangePasswordButton() {
        changePasswordButton.click();
    }

    public void verifyPasswordRepeatPasswordFieldsAreDisplayed() {
        Assert.assertTrue(passwordTextField.isDisplayed());
        Assert.assertTrue(repeatPasswordTextField.isDisplayed());
    }

    public void verifyShowPasswordCheckboxIsNotSelected() {
        Assert.assertEquals(false, $("//input[@id='show-pass-value']").isSelected());
    }

    public void verifyShowPasswordCheckboxIsSelected() {
        Assert.assertEquals(true, $("//input[@id='show-pass-value']").isSelected());
    }

    public void populateValueToPasswordField(String value) {
	    replaceValueInfield(passwordTextField,value);
    }

    public void populateValueToPasswordRepeatField(String value) {
        replaceValueInfield(repeatPasswordTextField,value);
    }

    private void verifyErrorMessage(WebElement element,String message) {
        Assert.assertTrue(element.getText().contains(message));
    }

    public void verifyFirstMessageForPasswordFields(String message) {
        verifyErrorMessage(listOfMessagesForPasswordFields.get(0),message);
    }

    public void verifySecondMessageForPasswordFields(String message) {
        verifyErrorMessage(listOfMessagesForPasswordFields.get(1),message);
    }

    public void verifyThirdMessageForPasswordFields(String message) {
        verifyErrorMessage(listOfMessagesForPasswordFields.get(2),message);
    }

    public void verifyFourthMessageForPasswordFields(String message) {
        verifyErrorMessage(listOfMessagesForPasswordFields.get(3),message);
    }

    public void verifyStatus(int n, String status) {
        Assert.assertTrue(listOfMessagesForPasswordFields.get(n).getAttribute("class").contains(status));
    }

    public void clickOnShowPasswordCheckbox() {
        $("//input[@id='show-pass-value']").click();
    }

    public void verifyTypeOfPasswordTextField(String type) {
        Assert.assertTrue(passwordTextField.getAttribute("type").equals(type));
    }

    public void verifyTypeOfRepeatPasswordTextField(String type) {
        Assert.assertTrue(repeatPasswordTextField.getAttribute("type").equals(type));
    }

    public void verifyGreenCheckMarkForPasswordFieldIsDisplayed() {
        Assert.assertTrue(listOfGreenGreenCheckMarkForPasswordFields.get(0).isDisplayed());
    }

    public void verifyGreenCheckMarkForRepeatPasswordFieldIsDisplayed() {
        Assert.assertTrue(listOfGreenGreenCheckMarkForPasswordFields.get(1).isDisplayed());
    }

    public Message getEmail () throws IOException, MessagingException {
        String userEmail = "tcautouser1@gmail.com";
        String password = "Pas$w0rd1";
        String host = "imap.gmail.com";

        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props);
        Store store = session.getStore();

        //connect to mail server
        store.connect(host, userEmail, password);

        //get INBOX folder
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        // the oldest email will have 1 number
        Message m = inbox.getMessage(inbox.getMessageCount());
        return m;
    }

    private String getActivationLinkFromEmail (String textEmail) {
        int startIndex = textEmail.indexOf("href=");
        int endIndex = textEmail.indexOf("> link");
        return textEmail.substring(startIndex+6, endIndex-2);
    }

    private String getEmailText() throws IOException, MessagingException {
        return getEmail().getContent().toString();
    }

    private String getEmailSubject() throws IOException, MessagingException {
        Log.info("Subject: "+getEmail().getSubject());
        return getEmail().getSubject();
    }

    private String getEmailFrom() throws IOException, MessagingException {
        Log.info("From: "+getEmail().getFrom()[0]);
        return String.valueOf(getEmail().getFrom()[0]);
    }

    public void checkFromEmail() throws IOException, MessagingException {
        Assert.assertTrue(getEmailFrom().equals("TechCheck <trust@cengage.com>"));
    }

    public void checkSubjectEmail() throws IOException, MessagingException {
        Assert.assertTrue(getEmailSubject().equals("Welcome to Techcheck!"));
    }

    public void checkFullNameEmail() throws IOException, MessagingException {
        Assert.assertTrue(getEmailText().contains("Hi auto1 auto3 auto2"));
    }

    public void checkUsernameInEmail(String username) throws IOException, MessagingException {
        Log.info("Email's body: "+getEmail().getContent().toString());
        Assert.assertTrue(getEmailText().contains("The user <b>"+username+"</b> has been created in the Techcheck system."));
    }

    public void checkActivationLinkFromEmail() throws IOException, MessagingException {
        Log.info(getEmail().getContent().toString());
        Assert.assertTrue(getActivationLinkFromEmail(getEmail().getContent().toString()).contains(".cengage.com/users/activation/"));
    }

    public void openActivationLinkFromEmail() throws IOException, MessagingException {
        getDriver().get(getActivationLinkFromEmail(getEmail().getContent().toString()));
    }

    public void verifyFirstLoginPageIsDisplayed() throws IOException, MessagingException {
        Assert.assertTrue(getDriver().getCurrentUrl().equals(getActivationLinkFromEmail(getEmail().getContent().toString())));
    }

    public void verifyPleaseChangeYourPasswordText() {
        Assert.assertTrue(getDriver().findElement(By.xpath("//p[@class='Profile_errorField_2Kgce']")).getText()
                .contains("Please change your password"));
    }
}
