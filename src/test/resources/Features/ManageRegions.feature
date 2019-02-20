Feature: Manage Regions page
  Background: User launches application
    Given User launches application1
    When User Navigates to LoginPage1
    And Login with valid admin credentials1
    Then Platform Availability Home Page is opened

  @ManageRegions
  Scenario: Verification KITT link on the Manage Regions page
    When User clicks on hamburger menu button
    And User clicks on Manage Regions from admin menu
    Then Manage Regions Page is opened
    When User clicks on KITT link on page
    Then Link navigates to http://critinc.cengage.com/Login.aspx?ReturnUrl=%2fdefault.aspx

  @ManageRegions
  Scenario: General verification Manage Regions page - Aggregate switch, displaying aggregated monitors, Expand/Collapse all buttons, systems column, deselecting column
    When User clicks on hamburger menu button
    And User clicks on Manage Regions from admin menu
    Then Manage Regions Page is opened
    And expand-all button is not displayed on Manage Regions page
    And collapse-all button is not displayed on Manage Regions page
    And System column is not displayed on Manage Regions page
    And Name of aggregated monitor $autoRegionAggrMonitor is emphasized
    And Sub-monitors autoRegion1 and autoRegion2 are displayed on hover in a tooltip for $autoRegionAggrMonitor
    When User opens "Select displayed columns" pop-up
    And User deselects AFR column in the "Select displayed columns" pop-up
    Then AFR column is not displayed on Manage Regions page
    And User resets the table to default state
    When User clicks on Aggregate switch
    Then System column is  displayed on Manage Regions page
    When User clicks on expand-all button for Regions table
    Then All systems are expanded
    When User clicks on collapse-all button for Regions table
    Then All systems are collapsed
    When User clicks on System column header
    And User expands $ Auto Regions system
    Then $autoRegionAggrMonitor aggregated monitor is displayed for the system
    And $autoRegionMonitor monitor is displayed for system

  @ManageRegions
  Scenario: Verification of create, edit, delete region
    When User clicks on hamburger menu button
    And User clicks on Manage Regions from admin menu
    Then Manage Regions Page is opened
    When User clicks on Region List button
    Then List of regions page is displayed
    And List of regions table contains next headers
         |On|
         |Name*|
         |OID*|
         |Description|
    And Delete button for United States region with OID USA is displayed as disabled
    When User verifies that there is no regions with Name autoRegion and with OID AUTO
    And User verifies that there is no regions with Name updatedRegion and with OID UPD
    And User clicks on add-region button on List of regions page
    Then Create region form is displayed
    When User populates fields in Create region form
       |Name|autoRegion|
       |OID|AUTO|
       |Description|autoDescription|
    And User clicks on Enabled checkbox in Create region form
    And User clicks on save-region button on List of regions page
    Then autoRegion region with OID AUTO and autoDescription description is  displayed on List of regions page
    And Enabled checkbox is selected for autoRegion region
    When User clicks on OK modal button
    Then AUTO region is selected for all existing monitors
    When User clicks on Region List button
    And User updates fields for the region autoRegion region with OID AUTO and autoDescription description
       |Name|updatedRegion|
       |OID|UPD|
       |Description|updatedDescription|
    Then updatedRegion region with OID UPD and updatedDescription description is  displayed on List of regions page
    When User clicks on Enabled checkbox for updatedRegion region
    Then Enabled checkbox is not selected for updatedRegion region
    When User clicks on OK modal button
    And User clicks on Aggregate switch
    Then UPD region is disabled for all systems
    When User clicks on Region List button
    And User clicks on delete button for updatedRegion region with OID UPD
    And User clicks on Proceed modal button
    Then updatedRegion region with OID UPD and updatedDescription description is not displayed on List of regions page

  @ManageRegions
  Scenario: Verification of selecting/deselecting region in the Manage Regions table
    When User clicks on hamburger menu button
    And User clicks on Manage Regions from admin menu
    Then Manage Regions Page is opened
    When User clicks on Aggregate switch
    And User clicks on System column header
    And User clicks on expand-all button for Regions table
    Then Region AFR is selected for $autoRegionAggrMonitor aggregated monitor
    And AFR region is selected for $autoRegionMonitor monitor
    When User click on AFR region for $autoRegionAggrMonitor aggregated monitor
    Then AFR region is selected for $ Auto Regions system
    And Region AFR is not selected for $autoRegionAggrMonitor aggregated monitor
    And AFR region is selected for $autoRegionMonitor monitor
    When User clicks on AFR region for $autoRegionMonitor monitor
    Then AFR region is not selected for $ Auto Regions system
    And Region AFR is not selected for $autoRegionAggrMonitor aggregated monitor
    And AFR region is not selected for $autoRegionMonitor monitor
    When User click on AFR region for $autoRegionAggrMonitor aggregated monitor
    And User clicks on AFR region for $autoRegionMonitor monitor

  @ManageRegions
  Scenario: Sorting List of regions table
     When User clicks on hamburger menu button
     And User clicks on Manage Regions from admin menu
     Then Manage Regions Page is opened
     When User clicks on Region List button
     Then List of regions page is displayed

     #Name*
     When User clicks on Name* column header
     Then The table is sorted by Name* column in ascending order
     When User clicks on Name* column header
     Then The table is sorted by Name* column in descending order

     #OID*
     When User clicks on OID* column header
     Then The table is sorted by OID* column in ascending order
     When User clicks on OID* column header
     Then The table is sorted by OID* column in descending order

     #Description
     When User clicks on Description column header
     Then The table is sorted by Description column in ascending order
     When User clicks on Description column header
     Then The table is sorted by Description column in descending order

  @ManageRegions
  Scenario: Checking Regions table for monitors and systems on Systems page
    When User clicks on hamburger menu button
    And User clicks on Systems from admin menu
    Then Systems Page is opened
    When User clicks Expand button depending on sections displaying
    And User clicks Add group button
    And User populates form with regionGroup name
    And User clicks Add System for regionGroup group
    And User populates system form with regionSystems name and Internal access level
    And User clicks Add Monitor for regionSystems system
    And User populates monitor form
      |Name|regionTest|
      |External ID|1009|
      |Description|Monitor description|
    Then Monitor regionTest is displayed on the page
    When User clicks Update icon for regionTest monitor
    And User clicks on show-regions button for Regions table
    Then Regions table is  displayed
    And All regions are selected for new monitor
    When Deselect AFR region for monitor
    And User clicks Update icon for regionTest monitor
    And User clicks on show-regions button for Regions table
    Then AFR region is not selected for regionTest monitor
    When User clicks on show-regions button for Regions table
    Then Regions table is not displayed
    When User clicks on OK modal button
    And User clicks update icon for regionSystems system
    And User clicks on show-regions button for Regions table
    Then Regions table is  displayed
    And AFR region is not selected for regionSystems system
    When User expands Regions table
    Then AFR region is not selected for regionTest monitor
    When User clicks on show-regions button for Regions table
    Then Regions table is not displayed
    When User clicks on OK modal button
    And User deletes regionTest monitor
    And User deletes regionSystems system
    And User deletes regionGroup group
