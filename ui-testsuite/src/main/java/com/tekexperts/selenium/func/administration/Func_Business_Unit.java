package com.tekexperts.selenium.func.administration;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome.droplist;
public class Func_Business_Unit extends TestConfig{
		
	/**
	* Test case ID:VAN-1543
	* Test case name:"Edit a Business Unit with leaving required input filed"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on a link in Name column"
	* Expected Result:"Edit Business Unit page is shown"
	* Test Step 6:"Leave Name filed"
	* Expected Result:"The field is blank"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"A error message is shown as:Name was required."
	* Test Step 8:"Check BU list"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	*/
	@Test
	public void VAN1543_EditABusinessUnitWithLeavingRequiredInputFiled(){
		info("Edit a Business Unit with leaving required input filed");
		String error = mesg.getContentByType(22);
		String name = "bu"+getRandomNumber();
		String name1 = "";
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Check RTM list");
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
		
		info("Edit a BU");
		bu.goToEditBU(name);
		waitForAndGetElement(bu.ELEMENT_BU_ADDEDIT_NAME_FIELD).clear();
		bu.edit(name1, state, description,false);
		bu.save(false);
		info("Verify that an error is shown");
		bu.verifyErrorMesg(error);
	}
		
	/**
	* Test case ID:VAN-1541
	* Test case name:"Edit an active Business Unit"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on a link in Name column"
	* Expected Result:"Edit Business Unit page is shown"
	* Test Step 6:"Change data in some fields"
	* Test Data:"Name: BU-Test-1Status:[Disabled]"
	* Expected Result:"The fields are changed data as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check Business Unit list"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 14:"Go to Pipeline list"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 15:"Go to Executive Dashboard"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	* Test Step 16:"Go to ABCD page"
	* Expected Result:"The BU at step 6 is not displayed in the list."
	*/
	@Test
	public void VAN1541_EditAnActiveBusinessUnit(){
		info("Edit an active Business Unit");
		String name = "bu"+getRandomNumber();
		String state="";
		String state1="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Check BU list");
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
		
		info("Edit a BU");
		bu.goToEditBU(name);
		bu.edit("", state1, description);
		info("Check BU list");
		bu.searchByName(name);
		bu.searchByStatus(false,false);
		bu.verifyBUInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Executive Dashboard");
		navMenu.goToExecutiveDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to ABCD page");
		navMenu.goToABCD();
		info("The new BU at step 6 is displayed in the drop-down list");
		abcd.verifyNOTINDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1540
	* Test case name:"Check paging control"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Check paging control by default"
	* Expected Result:"The 1st page is select and hightligted*[Next] button is shown*[Previous] button is hided"
	* Test Step 6:"Click on a number of paging control"
	* Expected Result:"Display data with corresponding data of correct page's number"
	* Test Step 7:"Click on [Next] button"
	* Expected Result:"Display data correctly with corresponding data of next page"
	* Test Step 8:"Click on [Previous] button"
	* Expected Result:"Display data correctly with corresponding data of previous page"
	* Test Step 9:"Click at the end of the paging control"
	* Expected Result:"Display data correctly with corresponding data of the last page*[Next] button is hided*[Previous] button still is shown"
	* Test Step 10:"Click at the begin of the paging control"
	* Expected Result:"Display data correctly with corresponding data of the first page*[Next] button is shown*[Previous] button is hided"
	* PENDING: THIS SHOULD BE TESTED BY MANUAL
	*/
	@Test(groups="pending")
	public void VAN1540_CheckPagingControl(){
	}
		
	/**
	* Test case ID:VAN-1539
	* Test case name:"Check paging size"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Check paging size by default"
	* Expected Result:"Display 20 lines/page"
	* Test Step 6:"Select a value in the drop-down list of paging size"
	* Expected Result:"Display data correctly with corresponding page size"
	*/
	@Test
	public void VAN1539_CheckPagingSize(){
		info("Check paging size");
		String[] listSize={"10","20","50","100","200"};
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Business Unitd button");
		orgHome.goToBU();
		info("Change the page size");
		bu.checkPageSize(listSize);
	}
		
	/**
	* Test case ID:VAN-1538
	* Test case name:"Edit a disabled Business Unit"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on a BU's name in Name column"
	* Expected Result:"Edit Business Unit page is shown"
	* Test Step 6:"Change data in some fields"
	* Test Data:"Name: BU-Test-2Status: [Active]"
	* Expected Result:"The fields are changed data as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check Business Unit list"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The BU at step 6 is displayed in the list with correct data as changed"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The BU at step 6 is displayed in the list."
	* Test Step 15:"Go to ABCD page"
	* Expected Result:"The BU at step 6 is displayed in the list."
	*/
	@Test
	public void VAN1538_EditADisabledBusinessUnit(){
		info("Edit a disabled Business Unit");
		String name = "bu"+getRandomNumber();
		String name1 = "bu"+getRandomNumber();
		String state="Disabled";
		String state1="Active";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Check BU list");
		bu.searchByStatus(false,false);
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
		
		info("Edit a BU");
		bu.goToEditBU(name);
		bu.edit(name1, state1, description);
		info("Check BU list");
		bu.searchByStatus(false,false);
		bu.searchByName(name);
		bu.verifyBUNOTInTheTable(name);
		driver.navigate().refresh();
		bu.searchByName(name1);
		bu.verifyBUInTheTable(name1);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyDroplist("Business Unit",name1);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyDroplist("Business Unit",name1);
		info("Go to Executive Dashboard");
		navMenu.goToExecutiveDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyDroplist("Business Unit",name1);
		info("Go to ABCD page");
		navMenu.goToABCD();
		info("The new BU at step 6 is displayed in the drop-down list");
		abcd.verifyDroplist(name1);
	}
		
	/**
	* Test case ID:VAN-1536
	* Test case name:"Check filter by Status"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Type a text in the filter filed of Status column"
	* Expected Result:"The text is input"
	* Test Step 6:"Press Enter key"
	* Expected Result:"Display data correctly with corresponding filter.*if not found
	*/
	@Test
	public void VAN1536_CheckFilterByStatus(){
		info("Check filter by Status");
		String name = "bu"+getRandomNumber();
		String state="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Search by name");
		bu.searchByStatus(false,false);
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
	}
		
	/**
	* Test case ID:VAN-1535
	* Test case name:"Check filter by Name"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Type a text in the filter filed of Name column"
	* Expected Result:"The text is input"
	* Test Step 6:"Press Enter key"
	* Expected Result:"Display data correctly with corresponding filter.*if not found
	*/
	@Test
	public void VAN1535_CheckFilterByName(){
		info("Check filter by Name");
		String name = "bu"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Search by name");
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
	}
		
	/**
	* Test case ID:VAN-1534
	* Test case name:"Cancel adding a new Business Unit"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add Business Unit page is shown"
	* Test Step 6:"Input all required fields"
	* Expected Result:"All data is input"
	* Test Step 7:"Click on [Cancel] button"
	* Expected Result:"The new BU at step 6 is not saved"
	* Test Step 8:"Check Business Unit list"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	* Test Step 9:"Go to Summary Dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	* Test Step 10:"Go to Lost Dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	* Test Step 11:"Go to Renewal Dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	* Test Step 12:"Go to Fallout lists"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	* Test Step 13:"Go to Pipeline list"
	* Expected Result:"The new BU at step 6 is not displayed in the list."
	*/
	@Test
	public void VAN1534_CancelAddingANewBusinessUnit(){
		info("Cancel adding a new Business Unit");
		String name = "bu"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
	    info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description,false);
		bu.cancel();
		info("Check BU list");
		bu.searchByName(name);
		bu.verifyBUNOTInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Executive Dashboard");
		navMenu.goToExecutiveDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to ABCD page");
		navMenu.goToABCD();
		info("The new BU at step 6 is displayed in the drop-down list");
		abcd.verifyNOTINDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1533
	* Test case name:"Add a new Business Unit with leaving required input field"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add RTM page is shown"
	* Test Step 6:"Leave Name field"
	* Expected Result:"The field is blank"
	* Test Step 7:"Select values for other fields"
	* Expected Result:"All values are selected"
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A error message is displayed as:Name was required."
	*/
	@Test
	public void VAN1533_AddANewBusinessUnitWithLeavingRequiredInputField(){
		info("Add a new Business Unit with leaving required input field");
		String message = mesg.getContentByType(22);
		String name = "";
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description,false);
		bu.save(false);
		info("Verify that an error message is shown");
		bu.verifyErrorMesg(message);
	}
		
	/**
	* Test case ID:VAN-1532
	* Test case name:"Add a new disabled Business Unit"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add Business Unit page is shown"
	* Test Step 6:"Input all required field"
	* Test Data:"Name: ADM-TestStatus: [Disabled]"
	* Expected Result:"Display data correctly as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All data is saved"
	* Test Step 8:"Check Business Unit list"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 13:"Go to Executive Dashboard"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	* Test Step 14:"Go to ABCD page"
	* Expected Result:"The new BU at step 6 is not displayed in the list with correct data as input"
	*/
	@Test
	public void VAN1532_AddANewDisabledBusinessUnit(){
		info("Add a new disabled Business Unit");
		String name = "bu"+getRandomNumber();
		String state="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
	    info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Check BU list");
		bu.searchByName(name);
		bu.searchByStatus(false,false);
		bu.verifyBUInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to Executive Dashboard");
		navMenu.goToExecutiveDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyNOTINDroplist("Business Unit",name);
		info("Go to ABCD page");
		navMenu.goToABCD();
		info("The new BU at step 6 is displayed in the drop-down list");
		abcd.verifyNOTINDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1531
	* Test case name:"Add a new active Business Unit"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add Business Unit page is shown"
	* Test Step 6:"Input all required field"
	* Test Data:"Name: ADM-TestStatus: Active"
	* Expected Result:"Display data correctly as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All data is saved"
	* Test Step 8:"Check Business Unit list"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 9:"Go to Pipeline dashboard"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 10:"Go to Summary dashboard"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 11:"Go to Lost dashboard"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 12:"Go to Renewal dashboard"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 14:"Go to Executive Dashboard"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	* Test Step 15:"Go to ABCD page"
	* Expected Result:"The new BU at step 6 is displayed in the list with correct data as input"
	*/
	@Test
	public void VAN1531_AddANewActiveBusinessUnit(){
		info("Add a new active BU");
		String name = "bu"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
	    info("Click on BU button");
		orgHome.goToBU();
		info("Click on Add button");
		bu.goToAddBU();
		info("Input all required filed");
		info("Click on Save button");
		bu.add(name, state, description);
		info("Check BU list");
		bu.searchByName(name);
		bu.verifyBUInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyDroplist("Business Unit",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
	    dashboard.verifyDroplist("Business Unit",name);
		info("Go to Executive Dashboard");
		navMenu.goToExecutiveDashboard();
		info("The new BU at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.BUSSINESSUNIT);
		dashboard.verifyDroplist("Business Unit",name);
		info("Go to ABCD page");
		navMenu.goToABCD();
		info("The new BU at step 6 is displayed in the drop-down list");
		abcd.verifyDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1530
	* Test case name:"Check breadcrumb on Business Unit page"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [Business Unit] button"
	* Expected Result:"Business Unit page is shown"
	* Test Step 5:"Check breadcrumb"
	* Expected Result:"The breadcrumb is displayed with following direction as: Home->Administration->Organization->Business Unit"
	* Test Step 6:"Click on a link on the breadcrumb"
	* Expected Result:"Redirect to correct page"
	*/
	@Test
	public void VAN1530_CheckBreadcrumbOnBusinessUnitPage(){
		info("Check breadcrumb on Business Unit page");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on Business Unit button");
		orgHome.goToBU();
		info("Check breadcrumb");
		bu.verifyBreadcrumb("Home");
		bu.verifyBreadcrumb("Administration");
		bu.verifyBreadcrumb("Organization");
		bu.verifyBreadcrumb("Business Unit");
		info("Click on a link on the breadcrumb");
		bu.clickBreadcrumb("Organization");
		info("Verify that Organization page is shown");
		waitForAndGetElement(orgHome.ELEMENT_ORGANIZATION_REGION_BTN,3000,1);
	}
}