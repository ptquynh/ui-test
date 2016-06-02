package com.tekexperts.selenium.func.administration;
import org.testng.annotations.Test;

import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome.droplist;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_RTM extends TestConfig{
		
		/**
		* Test case ID:VAN-1542
		* Test case name:"Edit a disabled RTM"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Organization] link on the left menu"
		* Expected Result:"Organization page is shown"
		* Test Step 4:"Click on [RTM] button"
		* Expected Result:"RTM page is shown"
		* Test Step 5:"Click on a link in Name column"
		* Expected Result:"Edit Business Unit page is shown"
		* Test Step 6:"Change data in some fields"
		* Test Data:"Name: RTM-Test-2Status: [Active]"
		* Expected Result:"The fields are changed data as input"
		* Test Step 7:"Click on [Save] button"
		* Expected Result:"All changes are saved"
		* Test Step 8:"Check Business Unit list"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 9:"Go to Pipeline Dashboard"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 10:"Go to Summary Dashboard"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 11:"Go to Lost Dashboard"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 12:"Go to Renewal Dashboard"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 13:"Go to Fallout lists"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 14:"Go to Pipeline list"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 15:"Go to Historical Data and Open Assign to RSR page"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		* Test Step 16:"Go to Operation page"
		* Expected Result:"The data at step 6 is displayed in the list with correct data as changed"
		*/
	@Test
	public void VAN1542_EditADisabledRTM(){
		info("Edit a disabled RTM");
		String name = "rtm"+getRandomNumber();
		String name1 = "rtm"+getRandomNumber();
		String state="Disabled";
		String state1="Active";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByStatus(false,false);
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		
		info("Edit a RTM");
		rtm.goToEditRTM(name);
		rtm.edit(name1, state1, description);
		info("Check RTM list");
		rtm.searchByStatus(false,false);
		rtm.searchByName(name);
		rtm.verifyRTMNOTInTheTable(name);
		driver.navigate().refresh();
		rtm.searchByName(name1);
		rtm.verifyRTMInTheTable(name1);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name1);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name1);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		info("The new RTM at step 6 is displayed in the drop-down list in RTM column");
		Utils.pause(3000);
		pipeList.verifyDroplist(83,name1);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 is displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyRTMDroplist(name1);
	}
		
	/**
	* Test case ID:VAN-1529
	* Test case name:"Check paging control"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
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
	* PENDING: THIS CASE SHOULD BE TESTED BY MANUAL
	*/
	@Test(groups="pending")
	public void VAN1529_CheckPagingControl(){
	}
		
	/**
	* Test case ID:VAN-1528
	* Test case name:"Check paging size"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Check paging size by default"
	* Expected Result:"Display 20 lines/page"
	* Test Step 6:"Select a value in the drop-down list of paging size"
	* Expected Result:"Display data correctly with corresponding page size"
	*/
	@Test
	public void VAN1528_CheckPagingSize(){
		info("Check paging size");
		String[] listSize={"10","20","50","100","200"};
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Change the page size");
		rtm.checkPageSize(listSize);
	}
		
	/**
	* Test case ID:VAN-1527
	* Test case name:"Edit a RTM with leaving required input filed"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on a RTM's name in Name column"
	* Expected Result:"Edit RTM page is shown"
	* Test Step 6:"Leave Name filed"
	* Expected Result:"The field is blank"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"A error message is shown as:Name was required."
	* Test Step 8:"Check RTM list"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	*/
	@Test
	public void VAN1527_EditARTMWithLeavingRequiredInputFiled(){
		info("Edit a RTM with leaving required input filed");
		String error = mesg.getContentByType(22);
		String name = "rtm"+getRandomNumber();
		String name1 = "";
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		
		info("Edit a RTM");
		rtm.goToEditRTM(name);
		waitForAndGetElement(rtm.ELEMENT_RTM_ADDEDIT_NAME_FIELD).clear();
		rtm.edit(name1, state, description,false);
		rtm.save(false);
		info("Verify that an error is shown");
		rtm.verifyErrorMesg(error);
	}
		
	/**
	* Test case ID:VAN-1526
	* Test case name:"Cancel editing a RTM"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on a RTM's name in Name column"
	* Expected Result:"Edit RTM page is shown"
	* Test Step 6:"Change data in some fields"
	* Expected Result:"The fields are changed data as input"
	* Test Step 7:"Click on [Cancel] button"
	* Expected Result:"All changes are not saved"
	* Test Step 8:"Check RTM list"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 14:"Go to Pipeline list"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 15:"Go to Historical Data and Open Assign to RSR page"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	*/
	@Test
	public void VAN1526_CancelEditingARTM(){
		info("Cancel editing a RTM");
		String name = "rtm"+getRandomNumber();
		String name1 = "rtm"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		
		info("Cancel editting the rtm");
		rtm.goToEditRTM(name);
		rtm.edit(name1, state, description,false);
		rtm.cancel();
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		Utils.pause(3000);
		info("The new RTM at step 6 isnot displayed in the drop-down list in RTM column");
		pipeList.verifyDroplist(83,name);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyRTMDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1525
	* Test case name:"Edit an active RTM"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on a RTM's name in Name column"
	* Expected Result:"Edit RTM page is shown"
	* Test Step 6:"Change data in some fields"
	* Test Data:"Name: RTM-Test-1Status:[Disabled]"
	* Expected Result:"The fields are changed data as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All changes are saved"
	* Test Step 8:"Check RTM list"
	* Expected Result:"The RTM at step 6 is displayed in the list with correct data as changed"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 14:"Go to Pipeline list"
	* Expected Result:"The RTM at step 6 is not displayed in the list."
	* Test Step 15:"Go to Historical Data and Open Assign to RSR page"
	* Expected Result:"The RTM at step 6 is not displayed in the drop-down list."
	*/
	@Test
	public void VAN1525_EditAnActiveRTM(){
		info("Edit an active RTM");
		String name = "rtm"+getRandomNumber();
		String name1 = "rtm"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		
		info("Edit a RTM");
		rtm.goToEditRTM(name);
		rtm.edit(name1, state, description);
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMNOTInTheTable(name);
		driver.navigate().refresh();
		rtm.searchByName(name1);
		rtm.verifyRTMInTheTable(name1);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name1);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name1);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		Utils.pause(3000);
		info("The new RTM at step 6 is displayed in the drop-down list in RTM column");
		pipeList.verifyDroplist(83,name1);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 is displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyRTMDroplist(name1);
	}
		
	/**
	* Test case ID:VAN-1524
	* Test case name:"Check filter by Description"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Type a text in the filter filed of Description column"
	* Expected Result:"The text is input"
	* Test Step 6:"Press Enter key"
	* Expected Result:"Display data correctly with corresponding filter.*if not found
	*/
	@Test
	public void VAN1524_CheckFilterByDescription(){
		info("Check filter by Status");
		String name = "rtm"+getRandomNumber();
		String state="";
		String description="This is for testing"+getRandomNumber();
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Search by name");
		rtm.searchByDes(description);
		rtm.verifyRTMInTheTable(name);
	}
		
	/**
	* Test case ID:VAN-1523
	* Test case name:"Check filter by Status"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Type a text in the filter filed of Status column"
	* Expected Result:"The text is input"
	* Test Step 6:"Press Enter key"
	* Expected Result:"Display data correctly with corresponding filter.*if not found
	*/
	@Test
	public void VAN1523_CheckFilterByStatus(){
		info("Check filter by Status");
		String name = "rtm"+getRandomNumber();
		String state="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Search by name");
		rtm.searchByStatus(false,false);
		rtm.verifyRTMInTheTable(name);
	}
		
	/**
	* Test case ID:VAN-1522
	* Test case name:"Check filter by Name"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Type a text in the filter filed of Name column"
	* Expected Result:"The text is input"
	* Test Step 6:"Press Enter key"
	* Expected Result:"Display data correctly with corresponding filter.*if not found
	*/
	@Test
	public void VAN1522_CheckFilterByName(){
		info("Check filter by Name");
		String name = "rtm"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Search by name");
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
	}
		
	/**
	* Test case ID:VAN-1521
	* Test case name:"Cancel adding a new RTM"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add RTM page is shown"
	* Test Step 6:"Input all required fields"
	* Expected Result:"All data is input"
	* Test Step 7:"Click on [Cancel] button"
	* Expected Result:"The new RTM at step 6 is not saved"
	* Test Step 8:"Check RTM list"
	* Expected Result:"The new RTM at step 6 is not displayed in the list."
	* Test Step 9:"Go to Summary Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 10:"Go to Lost Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 11:"Go to Renewal Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 12:"Go to Fallout lists"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 13:"Go to Pipeline list"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list in RTM column"
	* Test Step 14:"Go to Historical Data and Open Assign to RSR page"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	*/
	@Test
	public void VAN1521_CancelAddingANewRTM(){
		info("Cancel adding a new RTM");
		String name = "rtm"+getRandomNumber();
		String state="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description,false);
		rtm.cancel();
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMNOTInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyNOTINDroplist("RTM/Segment",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyNOTINDroplist("RTM/Segment",name);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		Utils.pause(3000);
		info("The new RTM at step 6 isnot displayed in the drop-down list in RTM column");
		pipeList.verifyNOTINDroplist(83,name);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyNOTINRTMDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1520
	* Test case name:"Add a new RTM with leaving required input field"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
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
	public void VAN1520_AddANewRTMWithLeavingRequiredInputField(){
		info("Add a new RTM with leaving required input field");
		String message = mesg.getContentByType(22);
		String name = "";
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description,false);
		rtm.save(false);
		info("Verify that an error message is shown");
		rtm.verifyErrorMesg(message);
	}
		
	/**
	* Test case ID:VAN-1519
	* Test case name:"Add a new disabled RTM"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add RTM page is shown"
	* Test Step 6:"Input all required field"
	* Test Data:"Name: RSRStatus: [Disabled]"
	* Expected Result:"Display data correctly as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All data is saved"
	* Test Step 8:"Check RTM list"
	* Expected Result:"The new RTM at step 6 is displayed in the list with correct data as input"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	* Test Step 14:"Go to Pipeline list"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list in RTM column"
	* Test Step 15:"Go to Historical Data and open Assign to RSR page"
	* Expected Result:"The new RTM at step 6 is not displayed in the drop-down list"
	*/
	@Test
	public void VAN1519_AddANewDisabledRTM(){
		info("Add a new disabled RTM");
		String name = "rtm"+getRandomNumber();
		String state="Disabled";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByStatus(false,false);
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyNOTINDroplist("RTM/Segment",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 isnot displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyNOTINDroplist("RTM/Segment",name);
		info("Go to Pipeline list");
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		Utils.pause(3000);
		info("The new RTM at step 6 is displayed in the drop-down list in RTM column");
		pipeList.verifyNOTINDroplist(83,name);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 is displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyNOTINRTMDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1518
	* Test case name:"Add a new active RTM"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Click on [Add] button"
	* Expected Result:"Add RTM page is shown"
	* Test Step 6:"Input all required field"
	* Test Data:"Name: RSRStatus: Active"
	* Expected Result:"Display data correctly as input"
	* Test Step 7:"Click on [Save] button"
	* Expected Result:"All data is saved"
	* Test Step 8:"Check RTM list"
	* Expected Result:"The new RTM at step 6 is displayed in the list with correct data as input"
	* Test Step 9:"Go to Pipeline Dashboard"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	* Test Step 10:"Go to Summary Dashboard"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	* Test Step 11:"Go to Lost Dashboard"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	* Test Step 12:"Go to Renewal Dashboard"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	* Test Step 13:"Go to Fallout lists"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	* Test Step 14:"Go to Pipeline list"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list in RTM column"
	* Test Step 15:"Go to Historical Data and open Assign to RSR page"
	* Expected Result:"The new RTM at step 6 is displayed in the drop-down list"
	*/
	@Test
	public void VAN1518_AddANewActiveRTM(){
		info("Add a new active RTM");
		String name = "rtm"+getRandomNumber();
		String state="";
		String description="";
		info("Go to Organization page");
		navMenu.goToOrganization();
	    info("Click on RTM button");
		orgHome.goToRTM();
		info("Click on Add button");
		rtm.goToAddRTM();
		info("Input all required filed");
		info("Click on Save button");
		rtm.add(name, state, description);
		info("Check RTM list");
		rtm.searchByName(name);
		rtm.verifyRTMInTheTable(name);
		info("Go to Pipeline dashboard");
		navMenu.goToDashboard();
		dashboard.goToPipelineDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name);
		info("Go to Summary Dashboard");
		navMenu.goToDashboard();
	    dashboard.goToSummaryDashboard();
		info("The new RTM at step 6 is displayed in the drop-down list");
		dashboard.goToDroplist(droplist.RTMSEGMENT);
	    dashboard.verifyDroplist("RTM/Segment",name);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		Utils.pause(3000);
		info("The new RTM at step 6 is displayed in the drop-down list in RTM column");
		pipeList.verifyDroplist(83,name);
		info("Go to historical Data and open Assign to RSR page");
		navMenu.expandCollapseMenu();
		navMenu.goToHistoricalData();
		info("The new RTM at step 6 is displayed in the drop-down list");
		histori.allCheckbox();
		histori.goToAssignRSR();
		assignRSR.goToRTMList();
		assignRSR.verifyRTMDroplist(name);
	}
		
	/**
	* Test case ID:VAN-1517
	* Test case name:"Check breadcrumb on RTM page"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with admin account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Organization] link on the left menu"
	* Expected Result:"Organization page is shown"
	* Test Step 4:"Click on [RTM] button"
	* Expected Result:"RTM page is shown"
	* Test Step 5:"Check breadcrumb"
	* Expected Result:"The breadcrumb is displayed with following direction as: Home->Administration->Organization->RTM"
	* Test Step 6:"Click on a link on the breadcrumb"
	* Expected Result:"Redirect to correct page"
	*/
	@Test
	public void VAN1517_CheckBreadcrumbOnRTMPage(){
		info("Check breadcrumb on RTM page");
		info("Go to Organization page");
		navMenu.goToOrganization();
		info("Click on RTM button");
		orgHome.goToRTM();
		info("Check breadcrumb");
		rtm.verifyBreadcrumb("Home");
		rtm.verifyBreadcrumb("Administration");
		rtm.verifyBreadcrumb("Organization");
		rtm.verifyBreadcrumb("RTM");
		info("Click on a link on the breadcrumb");
		rtm.clickBreadcrumb("Organization");
		info("Verify that Organization page is shown");
		waitForAndGetElement(orgHome.ELEMENT_ORGANIZATION_REGION_BTN,3000,1);
	}
}