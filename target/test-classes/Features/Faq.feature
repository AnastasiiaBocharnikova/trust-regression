Feature: FAQ
  Background: User launches application and login1
    Given User launches application1


  @FAQ
  Scenario: General verifications to check creating, updating and deleting section and question
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened
    When User clicks on hamburger menu button
    And User clicks on FAQ from admin menu
    Then FAQ Page is opened
    When User clicks on collapsed icons on all sections
    Then All sections are collapsed
    And Questions are not displayed
    When User clicks on add-section button on FAQ page
    Then Section form is displayed
    When User enters AutoSection to section name input field
    And User clicks on save-form button on FAQ page
    Then AutoSection section is  displayed on FAQ page
    When User clicks on edit-section button for AutoSection section
    Then Section form is displayed
    When User enters UpdatedSection to section name input field
    And User clicks on save-form button on FAQ page
    Then UpdatedSection section is  displayed on FAQ page
    When User clicks on add-question button for UpdatedSection section
    Then Question form is displayed
    And Next access level options are displayed in the Question form
    	|Admin|
    	|GPT|
    	|Internal|
    	|Public|
    When User populates Question form with autoQuestion Question, Admin Access level and auto Answer
    And User clicks on OK modal button
    Then autoQuestion question is  displayed on FAQ page
    When User expands the autoQuestion question
    Then auto answer is  displayed on FAQ page
    When User clicks on edit-question button for autoQuestion question
    Then Question form is displayed
    When User populates Question form with updatedQuestion Question, Public Access level and Answer Answer
    And User clicks on OK modal button
    Then updatedQuestion question is  displayed on FAQ page
    And autoAnswer answer is  displayed on FAQ page
    When User clicks on delete-question button for updatedQuestion question
    And User clicks on Proceed modal button
    Then updatedQuestion question is not displayed on FAQ page
    When User clicks on delete-section button for UpdatedSection section
    And User clicks on Proceed modal button
    Then UpdatedSection section is not displayed on FAQ page

  @FAQ @FAQ_permissions
  Scenario: Verification of displaying questions to user according to permission Admin
#  FAQ:Admin - allows to view and manage all FAQs
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened
    When User clicks on FAQ link
    Then FAQ Page is opened
    When User clicks on collapsed icons on all sections
    Then add-section button is  displayed on FAQ page
    And add-question buttons are displayed for all sections on FAQ page
    And edit-section buttons are displayed for all sections on FAQ page
    And delete-section buttons are displayed for all sections on FAQ page
    When User expands the $ Section Automation section
    And User expands all questions on FAQ page
    Then edit-question buttons are displayed for all questions on FAQ page
    And delete-question buttons are displayed for all questions on FAQ page
    And $ AutoQuestionAdmin question with answer AutoAnswerAdmin is displayed
    And $ AutoQuestionGPT question with answer AutoAnswerGPT is displayed
    And $ AutoQuestionInternal question with answer AutoAnswerInternal is displayed
    And $ AutoQuestionPublic question with answer AutoAnswerPublic is displayed

  @FAQ @FAQ_permissions
  Scenario: Verification of displaying questions to user according to permission GPT
#  FAQ:GPT - allows to only view the FAQ questions & answers up to GPT level
    Then User Navigates to LoginPage1
    When Login with gpt_auto and Gpttest1 credentials
    When User clicks on FAQ link
    Then FAQ Page is opened
    When User clicks on collapsed icons on all sections
    Then add-section button is not displayed on FAQ page
    And add-question button is not displayed on FAQ page
    And edit-section button is not displayed on FAQ page
    And delete-section button is not displayed on FAQ page
    When User expands the $ Section Automation section
    And User expands all questions on FAQ page
    Then edit-question button is not displayed on FAQ page
    And delete-question button is not displayed on FAQ page
    And $ AutoQuestionAdmin question is not displayed on FAQ page
    And $ AutoQuestionGPT question with answer AutoAnswerGPT is displayed
    And $ AutoQuestionInternal question with answer AutoAnswerInternal is displayed
    And $ AutoQuestionPublic question with answer AutoAnswerPublic is displayed

  @FAQ @FAQ_permissions
  Scenario: Verification of displaying questions to user according to permission Internal
#  FAQ:Internal - allows to only view the FAQ questions & answers up to Internal level
    When User clicks on FAQ link
    And FAQ Page is opened
    When User clicks on collapsed icons on all sections
    Then add-section button is not displayed on FAQ page
    And add-question button is not displayed on FAQ page
    And edit-section button is not displayed on FAQ page
    And delete-section button is not displayed on FAQ page
    When User expands the $ Section Automation section
    And User expands all questions on FAQ page
    Then edit-question button is not displayed on FAQ page
    And delete-question button is not displayed on FAQ page
    And $ AutoQuestionAdmin question is not displayed on FAQ page
    And $ AutoQuestionGPT question is not displayed on FAQ page
    And $ AutoQuestionInternal question with answer AutoAnswerInternal is displayed
    And $ AutoQuestionPublic question with answer AutoAnswerPublic is displayed

  @FAQ @FAQ_permissions
  Scenario: Verification of displaying questions to user according to permission Public
#  FAQ:Public - allows to only view the FAQ questions & answers of Public level
    When User clicks Cengage Internal user button
    When User clicks on FAQ link
    And FAQ Page is opened
    When User clicks on collapsed icons on all sections
    Then add-section button is not displayed on FAQ page
    And add-question button is not displayed on FAQ page
    And edit-section button is not displayed on FAQ page
    And delete-section button is not displayed on FAQ page
    When User expands the $ Section Automation section
    And User expands all questions on FAQ page
    Then edit-question button is not displayed on FAQ page
    And delete-question button is not displayed on FAQ page
    And $ AutoQuestionAdmin question is not displayed on FAQ page
    And $ AutoQuestionGPT question is not displayed on FAQ page
    And $ AutoQuestionInternal question is not displayed on FAQ page
    And $ AutoQuestionPublic question with answer AutoAnswerPublic is displayed

  @FAQ @FAQ_editor
  Scenario: General verification of Editor in the Question form on FAQ page
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened
    When User clicks on hamburger menu button
    And User clicks on FAQ from admin menu
    Then FAQ Page is opened
    When User clicks on collapsed icons on all sections
    And User clicks on add-question button for $ Section Automation section
    Then Question form is displayed
    When User populates Question form with autoFormatting Question, Admin Access level
    And User selects H2 option in the Block Type dropdown on the editor toolbar
    Then H2 is selected in the Block Type dropdown
    When User clicks on Center button in the editor toolbar
    Then Center button is selected
    When User moves cursor into editor textbox
    And User selects 18 option in the Font Size dropdown on the editor toolbar
    Then 18 is selected in the Font Size dropdown
    When User clicks on Bold button in the editor toolbar
    Then Bold button is selected
    When User clicks on Italic button in the editor toolbar
    Then Italic button is selected
    When User clicks on Underline button in the editor toolbar
    Then Underline button is selected
    When User clicks on Strikethrough button in the editor toolbar
    Then Strikethrough button is selected
    When User populates testFormatting Answer to Question form
    And User clicks on OK modal button
    And User expands the $ Section Automation section
    And User expands all questions on FAQ page
    Then Formatted answer "testFormatting" is displayed
    When User clicks on delete-question button for autoFormatting question
    And User clicks on Proceed modal button
    Then autoFormatting question is not displayed on FAQ page
