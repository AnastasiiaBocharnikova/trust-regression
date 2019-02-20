package com.trust.cucumber.steps;

import com.trust.cucumber.pages.ManageUsersPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ManageUsersPageSteps {

	private ManageUsersPage manageUsersPage;

	@Step
	public void checkTableHeaders(List<String> expectedHeaders) {
		List<String> actualHeaders = manageUsersPage.getHeadersFromTable();
		expectedHeaders.forEach(name -> Assert.assertTrue(actualHeaders.contains(name)));
	}

	@Step
	public void clickOnBulkUserCreationButton() {
		manageUsersPage.clickOnBulkUserCreationButton();
	}

	@Step
	public void verifyBulkUserCreationPopUpIsOpened() {
		manageUsersPage.verifyBulkUserCreationPopUpIsOpened();
	}

	@Step
	public void selectCsvFile(String fileName) {
		manageUsersPage.uploadCsvFile(fileName);
	}

	@Step
	public void verifyFileIsSuccessfullySelected() {
		manageUsersPage.verifyFileIsSuccessfullySelected();
	}

	@Step
	public void clickOnSubmitUploadButton() {
		manageUsersPage.clickOnSubmitUploadButton();
	}

	@Step
	public void verifyUsersHaveBeenCreatedText() {
		manageUsersPage.verifyUsersHaveBeenCreatedText();
	}

	@Step
	public void clickOnCloseBulkUsersModalButton() {
		manageUsersPage.clickOnCloseBulkUsersModalButton();
	}

    @Step
    public void setValueToUsernameField(String username) {
        manageUsersPage.setValueToUsernameField(username);
    }

    @Step
    public void checkUserByUsernameInTable(String username) {
        manageUsersPage.checkUserByUsernameInTable(username);
    }

    @Step
    public void deleteUserByUsername(String username) {
        manageUsersPage.deleteUserByUsername(username);
    }

    @Step
    public void checkUserIsDeleted(String username) {
        manageUsersPage.checkUserIsDeleted(username);
    }

    @Step
    public void setFilterByFirstName(String firstName) {
        manageUsersPage.setFilterByFirstName(firstName);
    }

    @Step
    public void checkUsersFirstNameInTable(String firstName) {
        manageUsersPage.checkUsersFirstNameInTable(firstName);
    }

    @Step
    public void setFilterByLastName(String lastName) {
        manageUsersPage.setFilterByLastName(lastName);
    }

    @Step
    public void checkUsersLastNameInTable(String lastName) {
        manageUsersPage.checkUsersLastNameInTable(lastName);
    }

    @Step
    public void setValueToEmailField(String email) {
        manageUsersPage.setValueToEmailField(email);
    }

    @Step
    public void checkUserByEmailInTable(String email) {
        manageUsersPage.checkUserByEmailInTable(email);
    }

    @Step
    public void setValueToRoleField(String role) {
        manageUsersPage.setValueToRolesField(role);
    }

    @Step
    public void checkUserByRoleInTable(String role) {
        manageUsersPage.checkUserByRoleInTable(role);
    }

    @Step
    public void clickOnRolesSystemsListsSwitchButton() {
        manageUsersPage.clickOnRolesSystemsListsSwitchButton();
    }

    @Step
    public void setValueToSystemField(String system) {
        manageUsersPage.setValueToSystemField(system);
    }

    @Step
    public void checkUserBySystemInTable(String system) {
        manageUsersPage.checkUserBySystemInTable(system);
    }

    @Step
    public void clickOnNewUsersButton() {
        manageUsersPage.clickOnNewUsersButton();
    }

    @Step
    public void verifyCreateUserPopUpIsOpened() {
        manageUsersPage.verifyCreateUserPopUpIsOpened();
    }

    @Step
    public void populateNewUserFields(Map<String, String> fields) {
        manageUsersPage.populateNewUserFields(fields);
    }

    @Step
    public void verifyThereIsNoUserByUsername(String username) {
        manageUsersPage.setValueToUsernameField(username);
        manageUsersPage.verifyThereIsNoUserByUsername(username);
    }

    @Step
    public void verifyThereIsNoUserByEmail(String email) {
        manageUsersPage.setValueToEmailField(email);
        manageUsersPage.verifyThereIsNoUserByEmail(email);
    }

    @Step
    public void selectUsernameByName(String username) {
        manageUsersPage.selectUsernameByName(username);
    }

    @Step
    public void verifyEditUserPopUpIsOpened() {
        manageUsersPage.verifyEditUserPopUpIsOpened();
    }

    @Step
    public void checkUsernameFieldIsDisabled() {
        manageUsersPage.checkUsernameFieldIsDisabled();
    }

    @Step
    public void checkUsernameFieldText(String value) {
        manageUsersPage.checkUsernameFieldText(value);
    }

    @Step
    public void checkEmailFieldText(String value) {
        manageUsersPage.checkEmailFieldText(value);
    }

    @Step
    public void clickOnDeleteUsersRoleButton() {
        manageUsersPage.clickOnDeleteUsersRoleButton();
    }

    @Step
    public void selectRoleAndSystemSearch(String role, String systemName) {
        manageUsersPage.selectRole(role);
        manageUsersPage.selectSystem(systemName);
    }

    @Step
    public void checkDisabledButtonsForSuperadmin() {
        manageUsersPage.checkEnabledCheckboxIsDisabled();
        manageUsersPage.checkDeleteButtonIsDisabled();
        manageUsersPage.checkCloneButtonIsDisabled();
    }

    @Step
    public void checkToasterForSuperadmin(String text) {
        manageUsersPage.verifyToasterIsDisplayed(text);
    }

    @Step
    public void checkDisabledButtonsForSpecialRoles() {
        manageUsersPage.checkEnabledCheckboxIsDisabled();
        manageUsersPage.checkDeleteButtonIsDisabled();
    }

    @Step
    public void checkDisabledButtonsForuestAndInternalRolesInEditPopUp() {
        manageUsersPage.checkEnabledToggleIsDisabled();
        manageUsersPage.checkGuestRoleIsDisabled();
    }

    @Step
    public void checkEnabledToggleIsDisabledForSlackbotInEditPopUp() {
        manageUsersPage.checkEnabledToggleIsDisabled();
    }

    @Step
    public void checkEmailInTheTable(String username, String value) {
        manageUsersPage.checkEmailForUsernameInTheTable(username,value);
    }

    @Step
    public void checkRolesInTheTable(String username, String value) {
        manageUsersPage.checkRolesForUsernameInTheTable(username,value);
    }

    @Step
    public void clickOnCloneButton() {
        manageUsersPage.clickOnCloneButton();
    }

    @Step
    public void checkErrorMessagesForUsernameAndEmail() {
        manageUsersPage.checkErrorMessageForUsername();
        manageUsersPage.checkErrorMessageForEmail();
    }

    @Step
    public void verifyManageUsersTableIsSortedByUsernameAscending() {
        manageUsersPage.verifyManageUsersTableIsSortedByUsernameAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByUsernameDescending() {
        manageUsersPage.verifyManageUsersTableIsSortedByUsernameDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByFirstNameAscending() {
        manageUsersPage.verifyManageUsersTableIsSortedByFirstNameAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByFirstNameDescending() {
        manageUsersPage.verifyManageUsersTableIsSortedByFirstNameDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByMiddleInitialAscending() {
        manageUsersPage.verifyManageUsersTableIsSortedByMiddleInitialAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByMiddleInitialDescending() {
        manageUsersPage.verifyManageUsersTableIsSortedByMiddleInitialDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByLastNameAscending() {
        manageUsersPage.verifyManageUsersTableIsSortedByLastNameAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByLastNameDescending() {
        manageUsersPage.verifyManageUsersTableIsSortedByLastNameDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByEmailAscending() {
        manageUsersPage.verifyManageUsersTableIsSortedByEmailAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByEmailDescending() {
        manageUsersPage.verifyManageUsersTableIsSortedByEmailDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByCreationTimeAscending() throws ParseException {
        manageUsersPage.verifyManageUsersTableIsSortedByCreationTimeAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByCreationTimeDescending() throws ParseException {
        manageUsersPage.verifyManageUsersTableIsSortedByCreationTimeDescending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByLastUpdatedAscending() throws ParseException {
        manageUsersPage.verifyManageUsersTableIsSortedByLastUpdatedAscending();
    }

    @Step
    public void verifyManageUsersTableIsSortedByLastUpdatedDescending() throws ParseException {
        manageUsersPage.verifyManageUsersTableIsSortedByLastUpdatedDescending();
    }

    @Step
    public void clickOnChangePasswordButton() {
        manageUsersPage.clickOnChangePasswordButton();
    }

    @Step
    public void verifyPasswordRepeatPasswordFieldsAreDisplayed() {
        manageUsersPage.verifyPasswordRepeatPasswordFieldsAreDisplayed();
    }

    @Step
    public void verifyShowPasswordCheckboxIsNotSelected() {
        manageUsersPage.verifyShowPasswordCheckboxIsNotSelected();
    }

    @Step
    public void verifyShowPasswordCheckboxIsSelected() {
        manageUsersPage.verifyShowPasswordCheckboxIsSelected();
    }

    @Step
    public void populateValueToPasswordField(String value) {
        manageUsersPage.populateValueToPasswordField(value);
    }

    @Step
    public void populateValueToPasswordRepeatField(String value) {
        manageUsersPage.populateValueToPasswordRepeatField(value);
    }

    @Step
    public void verifyThisPasswordIsNotAllowedError() {
        manageUsersPage.verifyFirstMessageForPasswordFields("This password is not allowed");
    }

    @Step
    public void verifyRequiredErrorForRepeatPasswordField(){
        manageUsersPage.verifySecondMessageForPasswordFields("Required");
    }

    @Step
    public void verifyMinimum8CharactersMessageForPasswordField(){
        manageUsersPage.verifyFirstMessageForPasswordFields("Minimum 8 characters");
    }

    @Step
    public void verifyShouldHaveAtLeastOneUppercaseCharacterMessageForPasswordField(){
        manageUsersPage.verifySecondMessageForPasswordFields("Should have at least one uppercase character");
    }

    @Step
    public void verifyShouldHaveAtLeastOneLowercaseCharacterMessageForPasswordField(){
        manageUsersPage.verifyThirdMessageForPasswordFields("Should have at least one lowercase character");
    }

    @Step
    public void verifyShouldHaveAtLeastOneNumberMessageForPasswordField(){
        manageUsersPage.verifyFourthMessageForPasswordFields("Should have at least one number");
    }

    @Step
    public void verifyStatus(int n, String status) {
        manageUsersPage.verifyStatus(n,status);
    }

    @Step
    public void clickOnShowPasswordCheckbox() {
        manageUsersPage.clickOnShowPasswordCheckbox();
    }

    @Step
    public void verifyPasswordTypeOfPasswordAndRepeatPasswordFields() {
        manageUsersPage.verifyTypeOfPasswordTextField("password");
        manageUsersPage.verifyTypeOfRepeatPasswordTextField("password");
    }

    @Step
    public void verifyTextTypeOfPasswordAndRepeatPasswordFields() {
        manageUsersPage.verifyTypeOfPasswordTextField("text");
        manageUsersPage.verifyTypeOfRepeatPasswordTextField("text");
    }

    @Step
    public void verifyThisPasswordAndRepeatPasswordNotMatchError() {
        manageUsersPage.verifySecondMessageForPasswordFields("Your password and confirmation password do not match");
    }

    @Step
    public void clickOnProfileButton() {
        manageUsersPage.clickOnProfileButton();
    }

    @Step
    public void verifyProfilePopUpIsOpened() {
        manageUsersPage.verifyProfilePopUpIsOpened();
    }

    @Step
    public void verifyGreenCheckMarkForPasswordFieldIsDisplayed() {
        manageUsersPage.verifyGreenCheckMarkForPasswordFieldIsDisplayed();
    }

    @Step
    public void verifyGreenCheckMarkForRepeatPasswordFieldIsDisplayed() {
        manageUsersPage.verifyGreenCheckMarkForRepeatPasswordFieldIsDisplayed();
    }

    @Step
    public void userNavigatesToEmail() throws IOException, MessagingException {
        manageUsersPage.getEmail();
    }

    @Step
    public void checkFromEmail() throws IOException, MessagingException{
        manageUsersPage.checkFromEmail();
    }

    @Step
    public void checkSubjectEmail() throws IOException, MessagingException {
        manageUsersPage.checkSubjectEmail();
    }

    @Step
    public void checkFullNameEmail() throws IOException, MessagingException {
        manageUsersPage.checkFullNameEmail();
    }

    @Step
    public void checkUsernameInEmail(String username) throws IOException, MessagingException {
        manageUsersPage.checkUsernameInEmail(username);
    }

    @Step
    public void checkActivationLinkFromEmail() throws IOException, MessagingException {
        manageUsersPage.checkActivationLinkFromEmail();
    }

    @Step
    public void openActivationLinkFromEmail() throws IOException, MessagingException {
        manageUsersPage.openActivationLinkFromEmail();
    }

    @Step
    public void verifyFirstLoginPageIsDisplayed() throws IOException, MessagingException {
        manageUsersPage.verifyFirstLoginPageIsDisplayed();
    }

    @Step
    public void verifyPleaseChangeYourPasswordText() {
        manageUsersPage.verifyPleaseChangeYourPasswordText();
    }

    @Step
    public void selectRole(String role) {
        manageUsersPage.selectRole(role);
    }
}
