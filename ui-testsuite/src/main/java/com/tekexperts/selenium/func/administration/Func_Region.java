package com.tekexperts.selenium.func.administration;
import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.organization.Region.treeType;
import com.tekexperts.pipeline.administration.organization.User.filters;
import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome.droplist;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_Region extends TestConfig{
		
	/**
	* Test case ID:VAN-1516
	* Test case name:"Edit a region with leaving required input field"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select an region and click on the region's name link"
	* Expected Result:"Edit region page is shown"
	* Test Step 6:"Leave Name field"
	* Expected Result:"The field is blank"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"A error message is shown as: Name was required."
	* Test Step 8:"Check the region at step 5 in region tree"
	* Expected Result:"All new data at step 6 is not displayed correctly in Region tree"
	*/
	@Test
	public void VAN1516_EditARegionWithLeavingRequiredInputField(){
		info("Edit a region with leaving required input field");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="2";
		String level1="1";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    Utils.pause(3000);
	    
		info("Go to Add page");
		region.goToEditRegion(name);
		info("Edit the region");
		waitForAndGetElement(region.ELEMENT_ADDEDIT_REGION_NAME_FIELD,2000,1).clear();
		region.edit("","",level1, regionType,"", description,false);
		region.save(false);
		String message = mesg.getContentByType(22);
	    info("Display an error message as:Name was required");
	    region.verifyErrorMesg(message);
	}
		
	/**
	* Test case ID:VAN-1515
	* Test case name:"Cancel editing a region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select an region and click on the region's name link"
	* Expected Result:"Edit region page is shown"
	* Test Step 6:"Change data for some fileds"
	* Expected Result:"All new data is changed"
	* Test Step 7:"Click on [Cancel] button"
	* Expected Result:"All changes are not saved"
	* Test Step 8:"Check the region at step 5 in region tree"
	* Expected Result:"All new data at step 6 is not displayed correctly in Region tree"
	*/
	@Test
	public void VAN1515_CancelEditingARegion(){
		info("Cancel editing a region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="2";
		String level1="1";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    
		info("Go to Add page");
		region.goToEditRegion(name);
		info("Edit the region");
		region.edit("","",level1, regionType,"", description,false);
		region.cancel();
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	}
		
	/**
	* Test case ID:VAN-1513
	* Test case name:"Edit a region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select an region and click on the region's name link"
	* Expected Result:"Edit region page is shown"
	* Test Step 6:"Change data for some fileds"
	* Expected Result:"All new data is changed"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check the region at step 5 in region tree"
	* Expected Result:"All new data at step 6 is displayed correctly in Region tree"
	*/
	@Test
	public void VAN1513_EditARegion(){
		info("Edit a region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="2";
		String level1="1";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    
		info("Go to Add page");
		region.goToEditRegion(name);
		info("Edit the region");
		region.edit("","",level1, regionType,"", description);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	}
		
	/**
	* Test case ID:VAN-1514
	* Test case name:"Active a region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select a disabled region and click on the region's name link"
	* Expected Result:"Edit region page is shown"
	* Test Step 6:"Change status to active"
	* Expected Result:"The selected status is displayed in the field"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check the region at step 5 in region tree"
	* Expected Result:"The region is displayed in Region tree with [Active] status"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The new WW region at step 5 is displayed in the list"
	*/
	@Test
	public void VAN1514_ActiveARegion(){
		info("Active a region");
		String name="subregion"+getRandomNumber();
		String status="Disabled";
		String status1="Active";
		String level="2";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    
		info("Go to Add page");
		region.goToEditRegion(name);
		info("Edit the region");
		region.edit("", status1,"", regionType,"", description);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyDroplist("Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyDroplist("Region",name);
	}
		
	/**
	* Test case ID:VAN-1512
	* Test case name:"Disable a region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select an active region and click on the region's name link"
	* Expected Result:"Edit region page is shown"
	* Test Step 6:"Change status to disabled"
	* Expected Result:"The selected status is displayed in the field"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check the region at step 5 in region tree"
	* Expected Result:"The region is displayed in Region tree with disabled status"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The new WW region at step 5 is not displayed in the list"
	*/
	@Test
	public void VAN1512_DisableARegion(){
		info("Disable a region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String status1="Disabled";
		String level="2";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    
		info("Go to Add page");
		region.goToEditRegion(name);
		info("Edit the region");
		region.edit("", status1,"", regionType,"", description);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyNOTINDroplist("Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyNOTINDroplist("Region",name);
	}
		
	/**
	* Test case ID:VAN-1511
	* Test case name:"Add a new disabled sub-region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Fill all required fields with valid data"
	* Test Data:"Name: Region AStatus: [Disabled]Level: 2->4 (when changed level's value
	* Expected Result: parent's values will be auto changed with corresponding value)Parent:AMS (with level=2)Region type: normal"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"The new sub-region at step 6 is displayed in Region tree with correct parent."
	* Test Step 8:"Go to Pipeline list page and check Region list"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new region at step 6 is not displayed in the list"
	*/
	@Test
	public void VAN1511_00_AddANewDisabledSubregion(){
		info("Add a new disabled sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Disabled";
		String level="2";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyNOTINDroplist("Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyNOTINDroplist("Region",name);
	}
	
	@Test
	public void VAN1511_01_AddANewDisabledSubregion(){
		info("Add a new disabled sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Disabled";
		String level="3";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(3);
		String description="";
		String wwregion=regionParentData.getContentByType(regionData.parentIndex);
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",wwregion);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",parent,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.verifyNOTINDroplist("SubRegion",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",wwregion);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",parent,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.verifyNOTINDroplist("SubRegion",name);
	}
	
	@Test
	public void VAN1511_02_AddANewDisabledSubregion(){
		info("Add a new disabled sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="4";
		String regionType="";
		//Get subregion
		String parent=regionData.getContentByArrayTypeRandom(4);
		String description="";
		//Get region
		String regionName=regionParentData.getContentByArrayTypeRandom(regionData.parentIndex);
		//Get WW region
		String supperParrent=regionParentData.getContentByType(regionParentData.parentIndex);
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",supperParrent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",regionName,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.selectDroplist("SubRegion",parent,false);
	    dashboard.goToDroplist(droplist.COUNTRY);
	    dashboard.verifyNOTINDroplist("Country",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",supperParrent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",regionName,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.selectDroplist("SubRegion",parent,false);
	    dashboard.goToDroplist(droplist.COUNTRY);
	    dashboard.verifyNOTINDroplist("Country",name);
	}
		
		
	/**
	* Test case ID:VAN-1510
	* Test case name:"Add a new disabled WW region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Fill all required fields with valid data"
	* Test Data:"Name: Region AStatus: [Disabled]Level: 1 (when select level=1
	* Expected Result: parent filed will be auto changed to WW value)Parent:WWRegion type: normal"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"The new WW region at step 6 is displayed in Region tree with WW parent."
	* Test Step 8:"Go to Pipeline list page and check WW Region list"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The new WW region at step 6 is not displayed in the list"
	*/
	@Test
	public void VAN1510_AddANewDisabledWWRegion(){
		info("Add a new disabled WW region");
		info("Prepate test data");
		String name="region"+getRandomNumber();
		String status="Disabled";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyNOTINDroplist("WW Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyNOTINDroplist("WW Region",name);
	}
		
		/**
		* Test case ID:VAN-1509
		* Test case name:"Cacnel setting a manager and delegate for a region"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [Region] button"
		* Expected Result:"Region page is shown"
		* Test Step 5:"Select a region and click on [Set] link in [Managed By] column"
		* Expected Result:"[Assign manager and delegate] page is shown"
		* Test Step 6:"Select a Business Manager in Manager field"
		* Expected Result:"The name is selected"
		* Test Step 7:"Select a Sale Opts in Delegate field"
		* Expected Result:"The name is selected"
		* Test Step 8:"Click on [Cancel] button"
		* Expected Result:"The region at step 5 is not set managers as selected"
		* Test Step 9:"Check the region in Region tree"
		* Expected Result:"Manager's names at step 6 and 7 are not displayed in [Managed By] column"
		*/
	@Test
	public void VAN1509_CacnelSettingAManagerAndDelegateForARegion(){
		info("Cancel setting a manager and delegate for a region");
		info("Prepare input data");
		String fullName = "user"+getRandomNumber();
		String email = fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String pass=password;
		String confirmPass=password;
		Boolean isView = false;
		Boolean isRandomPass=false;
		String jobTitle="";
		String rtm="";
		String regionText="";
		String telephone="";
		String city ="";
		String country="";
		String status="Active";
		String role=roleData.getContentByType(4);
		
		String fullName1 = "user"+getRandomNumber();
		String email1 = fullName1+"@gmail.com";
		String hpID1=getRandomNumber();
		String role1=roleData.getContentByType(7);
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to User page");
		orgHome.goToUser();
		info("Go to Add User page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName, email, hpID, pass, confirmPass, isView, isRandomPass, jobTitle, rtm, regionText, telephone, city, country, status, role);
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Go to Add User page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName1, email1, hpID1, pass, confirmPass, isView, isRandomPass, jobTitle, rtm, regionText, telephone, city, country, status, role1);
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName1);
		user.verifyUserInTheTable(fullName1);
		info("Add a new subregion");
		String name1="region"+getRandomNumber();
		String status1="Active";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		region.add(name1, status1, level, regionType, parent, description);
		info("Select the region and click on [Set] link in [Managed By] column");
		region.goToManagedBy(name1);
		region.setManagedBy(fullName,fullName1);
		region.cancelManageBy();
		region.verifyNOTManager(name1,fullName);
		region.verifyNOTManager(name1,fullName1);
	}
		
	/**
	* Test case ID:VAN-1508
	* Test case name:"Assign a manager and Delegate for a region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select a region and click on [Set] link in [Managed By] column"
	* Expected Result:"[Assign manager and delegate] page is shown"
	* Test Step 6:"Select a Business Manager in Manager field"
	* Expected Result:"The name is selected"
	* Test Step 7:"Select a Sale Opts in Delegate field"
	* Expected Result:"The name is selected"
	* Test Step 8:"Click on [Assign] button"
	* Expected Result:"The region at step 5 is set managers as selected"
	* Test Step 9:"Check the region in Region tree"
	* Expected Result:"Manager's names at step 6 and 7 are displayed in [Managed By] column"
	* Test Step 10:"Check breadcrumb"
	* Expected Result:"The breadcrumb is displayed with correct direction as: Home->Administration->Organization->Region->Assign manager and delegate"
	* Test Step 11:"Click on a link on the breadcrumb"
	* Expected Result:"Redirect to correct page"
	*/
	@Test
	public void VAN1508_AssignAManagerAndDelegateForARegion(){
		info("Assign a manager and Delegate for a region");
		info("Prepare input data");
		String fullName = "user"+getRandomNumber();
		String email = fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String pass=password;
		String confirmPass=password;
		Boolean isView = false;
		Boolean isRandomPass=false;
		String jobTitle="";
		String rtm="";
		String regionText="";
		String telephone="";
		String city ="";
		String country="";
		String status="Active";
		String role=roleData.getContentByType(4);
		
		String fullName1 = "user"+getRandomNumber();
		String email1 = fullName1+"@gmail.com";
		String hpID1=getRandomNumber();
		String role1=roleData.getContentByType(7);
		
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Go to User page");
		orgHome.goToUser();
		info("Go to Add User page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName, email, hpID, pass, confirmPass, isView, isRandomPass, jobTitle, rtm, regionText, telephone, city, country, status, role);
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName);
		user.verifyUserInTheTable(fullName);
		
		info("Go to Add User page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName1, email1, hpID1, pass, confirmPass, isView, isRandomPass, jobTitle, rtm, regionText, telephone, city, country, status, role1);
		user.save();
		user.searchByStatus(true,false);
		user.searchBy(filters.FULL_NAME,fullName1);
		user.verifyUserInTheTable(fullName1);
		info("Add a new subregion");
		String name1="region"+getRandomNumber();
		String status1="Active";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		region.add(name1, status1, level, regionType, parent, description);
		info("Select the region and click on [Set] link in [Managed By] column");
		region.goToManagedBy(name1);
		region.setManagedBy(fullName,fullName1);
		region.saveManageBy();
		region.verifyManager(name1,fullName);
		region.verifyManager(name1,fullName1);
	}
		
	/**
	* Test case ID:VAN-1507
	* Test case name:"Check displaying data from status drop-list"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Check status drop list by default"
	* Expected Result:"The drop list is displayed with empty value"
	* Test Step 6:"Check data in Region tree"
	* Expected Result:"All active and disabled regions are displayed"
	* Test Step 7:"Select [Active] status"
	* Expected Result:"Only display active regions"
	* Test Step 8:"Select [Disabled] status"
	* Expected Result:"Only display disabled regions"
	* Test Step 9:"Not select any status"
	* Expected Result:"All active and disabled regions are displayed"
	*/
	@Test
	public void VAN1507_CheckDisplayingDataFromStatusDroplist(){
		info("Check displaying data from status drop-list");
		info("Add a new subregion");
		String name1="region"+getRandomNumber();
		String name2="region"+getRandomNumber();
		String status1="Active";
		String status2="Disabled";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		region.add(name1, status1, level, regionType, parent, description);
		info("Go to Add page");
		region.goToAddRegion();
		region.add(name2, status2, level, regionType, parent, description);
		info("Select [Active] status");
		region.searchByStatus("Active");
		info("Only display active regions");
		region.verifyRegionInTheTable(name1);
		region.verifyRegionNOTInTheTable(name2);
		
		info("Select [Disabled] status");
		region.searchByStatus("Disabled");
		info("Only display disabled regions");
		region.verifyRegionNOTInTheTable(name1);
		region.verifyRegionInTheTable(name2);
		
		info("Select All status");
		region.searchByStatus("");
		info("Only display disabled regions");
		region.verifyRegionInTheTable(name1);
		region.verifyRegionInTheTable(name2);
	}
		
	/**
	* Test case ID:VAN-1506
	* Test case name:"Check total number of the sub-regions"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Select a parent region and observer the number of sub-regions"
	* Test Data:"Example: APJ"
	* Expected Result:"Display correct total number of the sub-regions"
	* Test Step 6:"Create a new sub-region for the parent region at step 5"
	* Expected Result:"The new sub-region is created successfully"
	* Test Step 7:"Check total number of the sub-regions again"
	* Expected Result:"The total number of sub-regions is increased 1"
	*/
	@Test
	public void VAN1506_CheckTotalNumberOfTheSubregions(){
		info("Check total number of the sub-regions");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Get the number of sub-regions before updated");
		String oldNumber= region.getSubRegionNumber("AMS");
		info("Add a new subregion");
		String name="region"+getRandomNumber();
		String status="Active";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Go to Add page");
		region.goToAddRegion();
		region.add(name, status, level, regionType, parent, description);
		info("The new region is added to the system");
		region.verifyRegionInTheTable(name);
		info("Verify that sub-region's number is increased");
		String newNumber=region.getSubRegionNumber("AMS");
		info("oldNumber:"+oldNumber);
		info("newNumber:"+newNumber);
		if(!oldNumber.equalsIgnoreCase(newNumber))assert false:"The sub-region's number is not increased";
	}
		
	/**
	* Test case ID:VAN-1505
	* Test case name:"Check expanding/collapsing a node in Region tree"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Check expanding the tree by default"
	* Expected Result:"By default
	* Test Step 6:"Click on a node to collapse"
	* Expected Result:"The node is collapsed"
	* Test Step 7:"Click on the node at step 6 again"
	* Expected Result:"The node is expanded"
	* Test Step 8:"Collapse all nodes in the tree"
	* Expected Result:"All parent nodes are collapsed"
	* Test Step 9:"Refresh or open Region page again"
	* Expected Result:"All parent nodes are expanded"
	*/
	@Test
	public void VAN1505_CheckExpandingcollapsingANodeInRegionTree(){
		info("Check expanding/collapsing a node in Region tree");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Click on a node to collapse");
		region.collapseExpand(treeType.COLLAPSE,"AMS");
		info("Expand the node");
		region.collapseExpand(treeType.EXPAND,"AMS");
		info("Collapse all nodes in the tree");
		region.collapseExpand(treeType.COLLAPSE,"WW");
		info("Expand all nodes in the tree");
		region.collapseExpand(treeType.EXPAND,"WW");
	}
		
	/**
	* Test case ID:VAN-1504
	* Test case name:"Cancel adding a new region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Fill all remain required fields with valid data"
	* Test Data:"Name: Region AStatus: ActiveLevel: 2->4 (when changed level's value
	* Expected Result: parent's values will be auto changed with corresponding value)Parent:AMS (with level=2)Region type: normal"
	* Test Step 7:"Click on [Cancel] button"
	* Expected Result:"The new region at step 6 is not added to the system"
	* Test Step 8:"Check Region list"
	* Expected Result:"The new region at step 6 is not displayed on the tree and in all Region and WW Region drop-list on other screens"
	*/
	@Test
	public void VAN1504_CancelAddingANewRegion(){
		info("Cancel adding a new region");
		info("Prepate test data");
		String name="region"+getRandomNumber();
		String status="Active";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Cancel creating a new region");
		region.add(name, status, level, regionType, parent, description,false);
		region.cancel();
		info("The new region is not added to the system");
		region.verifyRegionNOTInTheTable(name);
		info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyNOTINDroplist("WW Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyNOTINDroplist("WW Region",name);
	}
		
	/**
	* Test case ID:VAN-1503
	* Test case name:"Add a new region with leaving required input field"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Leave Name field"
	* Expected Result:"The field is blank"
	* Test Step 7:"Fill all remain required fields with valid data"
	* Test Data:"Status: ActiveLevel: 2->4 (when changed level's value
	* Expected Result: parent's values will be auto changed with corresponding value)Parent:AMS (with level=2)Region type: normal"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"Display an error message as:Name was required"
	*/
	@Test
	public void VAN1503_AddANewRegionWithLeavingRequiredInputField(){
		info("Add a new region with leaving required input field");
		String message = mesg.getContentByType(22);
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add("","", "", "", "", "",false);
		region.save(false);
	    info("Display an error message as:Name was required");
	    region.verifyErrorMesg(message);
	}
		
	/**
	* Test case ID:VAN-1502
	* Test case name:"Add a new active sub-region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Fill all required fields with valid data"
	* Test Data:"Name: Region AStatus: ActiveLevel: 2->4 (when changed level's value
	* Expected Result: parent's values will be auto changed with corresponding value)Parent:AMS (with level=2)Region type: normal"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"The new sub-region at step 6 is displayed in Region tree with correct parent."
	* Test Step 8:"Go to Pipeline list page and check Region list"
	* Expected Result:"The new region at step 6 is displayed in the list"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new region at step 6 is displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new region at step 6 is displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new region at step 6 is displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new region at step 6 is displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new region at step 6 is displayed in the list"
	*/
	@Test
	public void VAN1502_00_AddANewActiveSubregion(){
		info("Add a new active sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="2";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(2);
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyDroplist("Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",parent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.verifyDroplist("Region",name);
	}
	
	@Test
	public void VAN1502_01_AddANewActiveSubregion(){
		info("Add a new active sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="3";
		String regionType="";
		String parent=regionData.getContentByArrayTypeRandom(3);
		String description="";
		String wwregion=regionParentData.getContentByType(regionData.parentIndex);
		info("parent"+parent);
		info("parentIndex"+regionData.parentIndex);
		info("wwregion"+wwregion);
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",wwregion);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",parent,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.verifyDroplist("SubRegion",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",wwregion);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",parent,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.verifyDroplist("SubRegion",name);
	}
	
	@Test
	public void VAN1502_02_AddANewActiveSubregion(){
		info("Add a new active sub-region");
		info("Prepate test data");
		String name="subregion"+getRandomNumber();
		String status="Active";
		String level="4";
		String regionType="";
		//Get subregion
		String parent=regionData.getContentByArrayTypeRandom(4);
		String description="";
		//Get region
		String regionName=regionParentData.getContentByArrayTypeRandom(regionData.parentIndex);
		//Get WW region
		String supperParrent=regionParentData.getContentByType(regionParentData.parentIndex);
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",supperParrent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",regionName,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.selectDroplist("SubRegion",parent,false);
	    dashboard.goToDroplist(droplist.COUNTRY);
	    dashboard.verifyDroplist("Country",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.selectDroplist("WW Region",supperParrent);
	    dashboard.goToDroplist(droplist.REGION);
	    dashboard.selectDroplist("Region",regionName,false);
	    dashboard.goToDroplist(droplist.SUBREGION);
	    dashboard.selectDroplist("SubRegion",parent,false);
	    dashboard.goToDroplist(droplist.COUNTRY);
	    dashboard.verifyDroplist("Country",name);
	}
		
	/**
	* Test case ID:VAN-1501
	* Test case name:"Add a new active WW region"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add region page is shown"
	* Test Step 6:"Fill all required fields with valid data"
	* Test Data:"Name: Region AStatus: ActiveLevel: 1 (when select level=1
	* Expected Result: parent filed will be auto changed to WW value)Parent:WWRegion type: normal"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"The new WW region at step 6 is displayed in Region tree with WW parent."
	* Test Step 8:"Go to Pipeline list page and check WW Region list"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 13:"Go to Fallout list"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The new WW region at step 6 is displayed in the list"
	*/
	@Test
	public void VAN1501_AddANewActiveWWRegion(){
		info("Add a new active WW region");
		info("Prepate test data");
		String name="region"+getRandomNumber();
		String status="Active";
		String level="1";
		String regionType="";
		String parent="";
		String description="";
		info("Finished preparing test data");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Go to Add page");
		region.goToAddRegion();
		info("Create a new region");
		region.add(name, status, level, regionType, parent, description);
	    info("Verify that the new region is shown in the region table");
	    region.verifyRegionInTheTable(name);
	    info("Go to pipeline dashboard page");
	    navMenu.goToDashboard();
	    dashboard.goToPipelineDashboard();
	    info("Check new region in dropdown list");
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	    
	    info("Go to Summary Dashboard");
	    navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
	    dashboard.goToDroplist(droplist.WWREGION);
	    dashboard.verifyDroplist("WW Region",name);
	    
	}
		
	/**
	* Test case ID:VAN-1500
	* Test case name:"Check breadcrumb on Region page"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Region] button"
	* Expected Result:"Region page is shown"
	* Test Step 5:"Check breadcrumb"
	* Expected Result:"A breadcrumb is displayed with following direction as:Home->Administration->Organization->Region"
	* Test Step 6:"Click on a link on the breadcrumb"
	* Expected Result:"Redirect to correct page"
	*/
	@Test
	public void VAN1500_CheckBreadcrumbOnRegionPage(){
		info("Check breadcrumb on Region page");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Region button");
		orgHome.goToRegion();
		info("Check breadcrumb");
		region.verifyBreadcrumb("Home");
		region.verifyBreadcrumb("Administration");
		region.verifyBreadcrumb("Organization");
		region.verifyBreadcrumb("Region");
		info("Click on a link on the breadcrumb");
		region.clickBreadcrumb("Organization");
		info("Verify that Organization page is shown");
		waitForAndGetElement(orgHome.ELEMENT_ORGANIZATION_REGION_BTN,3000,1);
	}
}