package com.trust.cucumber.stepDefs;

import com.trust.cucumber.steps.CommonSteps;
import com.trust.cucumber.steps.ManageUsersPageSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ManageUsersPageStepDef {

	@Steps
	ManageUsersPageSteps manageUsersPageSteps;

    @Steps
    CommonSteps commonSteps;

	@Then("^Manage Users table contains columns$")
	public void displayManageUsersHeaders(List<String> arg) {
		manageUsersPageSteps.checkTableHeaders(arg);
	}

	@When("^User clicks on Bulk user creation button$")
	public void clickOnBulkUserCreationButton() {
		manageUsersPageSteps.clickOnBulkUserCreationButton();
	}

	@Then("^Bulk user creation pop-up is displayed$")
	public void verifyBulkUserCreationPopUpIsOpened() {
		manageUsersPageSteps.verifyBulkUserCreationPopUpIsOpened();
	}

	@When("^User clicks on Upload CSV button and selects (.*) file$")
	public void selectCsvFile(String fileName) {
		manageUsersPageSteps.selectCsvFile(fileName);
	}

	@Then("^The file is successfully selected without invalid users$")
	public void verifyFileIsSuccessfullySelected() {
		manageUsersPageSteps.verifyFileIsSuccessfullySelected();
	}

	@When("^User clicks on Submit Upload button$")
	public void clickOnSubmitUploadButton() {
		manageUsersPageSteps.clickOnSubmitUploadButton();
	}

	@Then("^'Users have been created!' is displayed$")
	public void verifyUsersHaveBeenCreatedText() {
		manageUsersPageSteps.verifyUsersHaveBeenCreatedText();
	}

	@When("^User closes Bulk user creation pop-up$")
	public void clickOnCloseBulkUsersModalButton() {
		manageUsersPageSteps.clickOnCloseBulkUsersModalButton();
	}

	@When("^User filters Manage Users table by (.*) username$")
	public void setFilterByUsername(String username) {
		manageUsersPageSteps.setValueToUsernameField(username);
	}

	@Then("^User with username (.*) is displayed in the Manage Users table$")
	public void checkUserByUsernameInTable(String username) {
		manageUsersPageSteps.checkUserByUsernameInTable(username);
	}

    @When("^User filters Manage Users table by (.*) First Name$")
    public void setFilterByFirstName(String firstName) {
        manageUsersPageSteps.setFilterByFirstName(firstName);
    }

    @Then("^Users with First Name (.*) are displayed in the Manage Users table$")
    public void checkUsersFirstNameInTable(String firstName) {
        manageUsersPageSteps.checkUsersFirstNameInTable(firstName);
    }

    @When("^User filters Manage Users table by (.*) Last Name$")
    public void setFilterByLastName(String lastName) {
        manageUsersPageSteps.setFilterByLastName(lastName);
    }

    @Then("^Users with Last Name (.*) are displayed in the Manage Users table$")
    public void checkUsersLastNameInTable(String lastName) {
        manageUsersPageSteps.checkUsersLastNameInTable(lastName);
    }

    @When("^User filters Manage Users table by (.*) email$")
    public void setFilterByEmail(String email) {
        manageUsersPageSteps.setValueToEmailField(email);
    }

    @Then("^User with email (.*) is displayed in the Manage Users table$")
    public void checkUserByEmailInTable(String email) {
        manageUsersPageSteps.checkUserByEmailInTable(email);
    }

    @When("^User filters Manage Users table by (.*) role$")
    public void setFilterByRole(String role) {
        manageUsersPageSteps.setValueToRoleField(role);
    }

    @Then("^Users with role (.*) are displayed in the Manage Users table$")
    public void checkUserByRoleInTable(String role) {
        manageUsersPageSteps.checkUserByRoleInTable(role);
    }

    @When("^Switch to Select systems list in Roles column$")
    public void clickOnRolesSystemsListsSwitchButton() {
        manageUsersPageSteps.clickOnRolesSystemsListsSwitchButton();
    }

    @When("^User filters Manage Users table by (.*) system$")
    public void setFilterBySystem(String system) {
        manageUsersPageSteps.setValueToSystemField(system);
    }

    @Then("^Users with system (.*) are displayed in the Manage Users table$")
    public void checkUserBySystemInTable(String system) {
        manageUsersPageSteps.checkUserBySystemInTable(system);
    }

	@When("^User deletes (.*) user from the table$")
	public void deleteUserByUsername(String username) {
		manageUsersPageSteps.deleteUserByUsername(username);
		commonSteps.clickProceedButton();
	}

	@Then("^User (.*) is deleted from table$")
	public void checkUserIsDeleted(String username) {
		manageUsersPageSteps.checkUserIsDeleted(username);
	}

	@When("^User clicks on New User button on the Manage Users page$")
	public void clickOnNewUsersButton() {
		manageUsersPageSteps.clickOnNewUsersButton();
	}

    @Then("^Create User pop-up is displayed$")
    public void verifyCreateUserPopUpIsOpened() {
        manageUsersPageSteps.verifyCreateUserPopUpIsOpened();
    }

    @When ("^User populates fields in Create User pop-up$")
    public void populateNewUserFields(Map<String, String> arg) {
        manageUsersPageSteps.populateNewUserFields(arg);
    }

    @When("^Verify that there is no user with username (.*) and email (.*)$")
    public void verifyThereIsNoUserByUsernameAndEmail(String username, String email) {
        manageUsersPageSteps.verifyThereIsNoUserByUsername(username);
        manageUsersPageSteps.verifyThereIsNoUserByEmail(email);
    }

    @When("User clicks on (.*) user in the table$")
    public void clickOnUserByUsername(String username) {
        manageUsersPageSteps.selectUsernameByName(username);
    }

    @Then("^Edit User pop-up is displayed$")
    public void verifyEditUserPopUpIsOpened() {
        manageUsersPageSteps.verifyEditUserPopUpIsOpened();
    }

    @Then("^Username field is disabled$")
    public void checkUsernameFieldIsDisabled() {
        manageUsersPageSteps.checkUsernameFieldIsDisabled();
    }

    @Then("^Username (.*) is displayed$")
    public void checkUsernameFieldText(String value) {
        manageUsersPageSteps.checkUsernameFieldText(value);
    }

    @Then("^User has (.*) email$")
    public void checkEmailFieldText(String value) {
        manageUsersPageSteps.checkEmailFieldText(value);
    }

    @When ("^User updates fields in Edit User pop-up$")
    public void updateUserFields(Map<String, String> arg) {
        manageUsersPageSteps.populateNewUserFields(arg);
    }

    @When("^Delete previously selected role$")
    public void clickOnDeleteUsersRoleButton() {
        manageUsersPageSteps.clickOnDeleteUsersRoleButton();
    }

    @When("^Select (.*) role with (.*) system$")
    public void selectRoleAndSystemSearch(String role, String systemName) {
        manageUsersPageSteps.selectRoleAndSystemSearch(role,systemName);
    }

    @When("^Enabled checkbox, Delete and Clone buttons are disabled for superadmin user$")
    public void checkDisabledButtonsForSuperadmin() {
        manageUsersPageSteps.checkDisabledButtonsForSuperadmin();
    }

    @Then("^Toaster \"(.*)\" is displayed$")
    public void checkToasterForSuperadmin(String text) {
        manageUsersPageSteps.checkToasterForSuperadmin(text);
    }

    @Then("^Enabled checkbox and Delete button are disabled for guest user$")
    public void checkDisabledButtonsForGuest() {
        manageUsersPageSteps.checkDisabledButtonsForSpecialRoles();
    }

    @Then("^Enabled toggle and Guest role are disabled for guest user$")
    public void checkDisabledButtonsForGuestInEditPopUp() {
        manageUsersPageSteps.checkDisabledButtonsForuestAndInternalRolesInEditPopUp();
    }

    @Then("^Enabled checkbox and Delete button are disabled for cengageinternal user$")
    public void checkDisabledButtonsForCengageinternal() {
        manageUsersPageSteps.checkDisabledButtonsForSpecialRoles();
    }

    @Then("^Enabled toggle and Guest role are disabled for cengageinternal user$")
    public void checkDisabledButtonsForInternalInEditPopUp() {
        manageUsersPageSteps.checkDisabledButtonsForuestAndInternalRolesInEditPopUp();
    }

    @Then("^Enabled checkbox and Delete button are disabled for slackbot user$")
    public void checkDisabledButtonsForSlackbot() {
        manageUsersPageSteps.checkDisabledButtonsForSpecialRoles();
    }

    @Then("^Enabled toggle is disabled for slackbot user$")
    public void checkEnabledToggleIsDisabledForSlackbotInEditPopUp() {
        manageUsersPageSteps.checkEnabledToggleIsDisabledForSlackbotInEditPopUp();
    }

    @And("^User (.*) has (.*) value in Email column$")
    public void checkEmailInTheTable(String username, String value) {
        manageUsersPageSteps.checkEmailInTheTable(username,value);
    }

    @And("^User (.*) contains (.*) value in Roles column$")
    public void checkRolesInTheTable(String username, String value) {
        manageUsersPageSteps.checkRolesInTheTable(username,value);
    }

    @When("^User clicks on Clone user button$")
    public void clickOnCloneButton() {
        manageUsersPageSteps.clickOnCloneButton();
    }

    @And("^Error messages are displayed for the Username and Email fields$")
    public void checkErrorMessagesForUsernameAndEmail() {
        manageUsersPageSteps.checkErrorMessagesForUsernameAndEmail();
    }

    @Then("^The table is sorted by Username column in ascending order$")
    public void verifyManageUsersTableIsSortedByUsernameAscending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByUsernameAscending();
    }

    @Then("^The table is sorted by Username column in descending order$")
    public void verifyManageUsersTableIsSortedByUsernameDescending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByUsernameDescending();
    }

    @Then("^The table is sorted by First Name column in ascending order$")
    public void verifyManageUsersTableIsSortedByFirstNameAscending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByFirstNameAscending();
    }

    @Then("^The table is sorted by First Name column in descending order$")
    public void verifyManageUsersTableIsSortedByFirstNameDescending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByFirstNameDescending();
    }

    @Then("^The table is sorted by Middle Initial column in ascending order$")
    public void verifyManageUsersTableIsSortedByMiddleInitialAscending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByMiddleInitialAscending();
    }

    @Then("^The table is sorted by Middle Initial column in descending order$")
    public void verifyManageUsersTableIsSortedByMiddleInitialDescending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByMiddleInitialDescending();
    }

    @Then("^The table is sorted by Last Name column in ascending order$")
    public void verifyManageUsersTableIsSortedByLastNameAscending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByLastNameAscending();
    }

    @Then("^The table is sorted by Last Name column in descending order$")
    public void verifyManageUsersTableIsSortedByLastNameDescending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByLastNameDescending();
    }

    @Then("^The table is sorted by Email column in ascending order$")
    public void verifyManageUsersTableIsSortedByEmailAscending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByEmailAscending();
    }

    @Then("^The table is sorted by Email column in descending order$")
    public void verifyManageUsersTableIsSortedByEmailDescending() {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByEmailDescending();
    }

    @Then("^The table is sorted by Creation time column in ascending order$")
    public void verifyManageUsersTableIsSortedByCreationTimeAscending() throws ParseException {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByCreationTimeAscending();
    }

    @Then("^The table is sorted by Creation time column in descending order$")
    public void verifyManageUsersTableIsSortedByCreationTimeDescending() throws ParseException {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByCreationTimeDescending();
    }

    @Then("^The table is sorted by Last updated column in ascending order$")
    public void verifyManageUsersTableIsSortedByLastUpdatedAscending() throws ParseException {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByLastUpdatedAscending();
    }

    @Then("^The table is sorted by Last updated column in descending order$")
    public void verifyManageUsersTableIsSortedByLastUpdatedDescending() throws ParseException {
        manageUsersPageSteps.verifyManageUsersTableIsSortedByLastUpdatedDescending();
    }

    @When("^User clicks on Change Password button$")
    public void clickOnChangePasswordButton() {
        manageUsersPageSteps.clickOnChangePasswordButton();
    }

    @Then("^Password and Repeat password fields are displayed$")
    public void verifyPasswordRepeatPasswordFieldsAreDisplayed() {
        manageUsersPageSteps.verifyPasswordRepeatPasswordFieldsAreDisplayed();
    }

    @Then("^Show Password checkbox is not selected by default$")
    public void verifyShowPasswordCheckboxIsNotSelected(){
        manageUsersPageSteps.verifyShowPasswordCheckboxIsNotSelected();
    }

    @When("^User populates (.*) value to the Password field$")
    public void populateValueToPasswordField(String value) {
        manageUsersPageSteps.populateValueToPasswordField(value);
    }

    @When("^User populates (.*) value to the Repeat password field$")
    public void populateValueToRepeatPasswordField(String value) {
        manageUsersPageSteps.populateValueToPasswordRepeatField(value);
    }

    @Then("^'This password is not allowed' error is displayed under the Password field$")
    public void verifyThisPasswordIsNotAllowedError(){
        manageUsersPageSteps.verifyThisPasswordIsNotAllowedError();
    }

    @And("^'Required' error is displayed under the Repeat password field$")
    public void verifyRequiredErrorForRepeatPasswordField(){
        manageUsersPageSteps.verifyRequiredErrorForRepeatPasswordField();
    }

    @Then("^'Minimum 8 characters' verification has fail status$")
    public void verifyMin8CharactersVerificationFail(){
        manageUsersPageSteps.verifyMinimum8CharactersMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(0,"fail");
    }

    @Then("^'Minimum 8 characters' verification has success status$")
    public void verifyMin8CharactersVerificationSuccess(){
        manageUsersPageSteps.verifyMinimum8CharactersMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(0,"success");
    }

    @And("^'Should have at least one uppercase character' verification has fail status$")
    public void verifyAtLeastOneUppercaseCharacterVerificationFail(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneUppercaseCharacterMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(1,"fail");
    }

    @And("^'Should have at least one uppercase character' verification has success status")
    public void verifyAtLeastOneUppercaseCharacterVerificationSuccess(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneUppercaseCharacterMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(1,"success");
    }

    @And("^'Should have at least one lowercase character' verification has fail status$")
    public void verifyAtLeastOneLowercaseCharacterVerificationFail(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneLowercaseCharacterMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(2,"fail");
    }

    @And("^'Should have at least one lowercase character' verification has success status")
    public void verifyAtLeastOneLowercaseCharacterVerificationSuccess(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneLowercaseCharacterMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(2,"success");
    }

    @And("^'Should have at least one number' verification has fail status$")
    public void verifyAtLeastOneNumberVerificationFail(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneNumberMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(3,"fail");
    }

    @And("^'Should have at least one number' verification has success status")
    public void verifyAtLeastOneNumberVerificationSuccess(){
        manageUsersPageSteps.verifyShouldHaveAtLeastOneNumberMessageForPasswordField();
        manageUsersPageSteps.verifyStatus(3,"success");
    }

    @When("^User clicks on Show Password checkbox$")
    public void clickOnShowPasswordCheckbox() {
        manageUsersPageSteps.clickOnShowPasswordCheckbox();
    }

    @Then("^Show Password checkbox is selected$")
    public void verifyShowPasswordCheckboxIsSelected() {
        manageUsersPageSteps.verifyShowPasswordCheckboxIsSelected();
    }

    @And("^Password and Repeat password fields have password type$")
    public void verifyPasswordTypeOfPasswordAndRepeatPasswordFields(){
        manageUsersPageSteps.verifyPasswordTypeOfPasswordAndRepeatPasswordFields();
    }

    @Then("^Show Password checkbox is unselected$")
    public void verifyShowPasswordCheckboxIsUnSelected() {
        manageUsersPageSteps.verifyShowPasswordCheckboxIsNotSelected();
    }

    @And("^Password and Repeat password fields have text type$")
    public void verifyTextTypeOfPasswordAndRepeatPasswordFields(){
        manageUsersPageSteps.verifyTextTypeOfPasswordAndRepeatPasswordFields();
    }

    @Then("^'Your password and confirmation password do not match' error is displayed under the Repeat password field$")
    public void verifyThisPasswordAndRepeatPasswordNotMatchError(){
        manageUsersPageSteps.verifyThisPasswordAndRepeatPasswordNotMatchError();
    }

    @Then("^Green check mark is displayed in the Password field$")
    public void verifyGreenCheckMarkForPasswordField(){
        manageUsersPageSteps.verifyGreenCheckMarkForPasswordFieldIsDisplayed();
    }

    @And("^Green check mark is displayed in the Repeat password field$")
    public void verifyGreenCheckMarkForRepeatPasswordField(){
        manageUsersPageSteps.verifyGreenCheckMarkForRepeatPasswordFieldIsDisplayed();
    }

    @When("^User clicks on the Profile button$")
    public void clickOnProfileButton() {
        manageUsersPageSteps.clickOnProfileButton();
    }

    @Then("^Profile pop-up is displayed$")
    public void verifyProfilePopUpIsOpened() {
        manageUsersPageSteps.verifyProfilePopUpIsOpened();
    }

    @When("^User navigates to email and opens the last email from Inbox folder$")
    public void userNavigatesToEmail() throws IOException, MessagingException {
        manageUsersPageSteps.userNavigatesToEmail();
    }

    @And("^Email is From 'TechCheck <trust@cengage.com>'$")
    public void checkFromEmail() throws IOException, MessagingException {
        manageUsersPageSteps.checkFromEmail();
    }

    @And("^Email has subject 'Welcome to Techcheck!'$")
    public void checkSubjectEmail() throws IOException, MessagingException {
        manageUsersPageSteps.checkSubjectEmail();
    }

    @And("^Email contains 'Hi <First Name> <Middle Initial> <Last Name>'$")
    public void checkFullNameEmail() throws IOException, MessagingException {
        manageUsersPageSteps.checkFullNameEmail();
    }

    @And("^Email contains text that user with username (.*) has been created in the Techcheck system$")
    public void checkUsernameInEmail(String value) throws IOException, MessagingException {
        manageUsersPageSteps.checkUsernameInEmail(value);
    }

    @And("^Email contains an activation link for first login$")
    public void checkActivationLinkFromEmail() throws IOException, MessagingException {
        manageUsersPageSteps.checkActivationLinkFromEmail();
    }

    @And("^User opens the activation link$")
    public void openActivationLinkFromEmail() throws IOException, MessagingException {
        manageUsersPageSteps.openActivationLinkFromEmail();
    }

    @Then("^First Login Page / Profile page is displayed$")
    public void verifyFirstLoginPageIsDisplayed() throws IOException, MessagingException {
        manageUsersPageSteps.verifyFirstLoginPageIsDisplayed();
    }

    @And("^'Please change your password' text is displayed$")
    public void verifyPleaseChangeYourPasswordText() {
        manageUsersPageSteps.verifyPleaseChangeYourPasswordText();
    }

    @When("^Select (.*) role$")
    public void selectRole(String value) {
        manageUsersPageSteps.selectRole(value);
    }
}