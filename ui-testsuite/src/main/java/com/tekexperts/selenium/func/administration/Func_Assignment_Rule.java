package com.tekexperts.selenium.func.administration;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.AssignmentRules.assignmentCol;
public class Func_Assignment_Rule extends TestConfig{
		
	/**
	* Test case ID:VAN-1600
	* Test case name:"Add a new Assignment rule"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with user A"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Data Import] link on the left menu"
	* Expected Result:"Data Import Home page is shown"
	* Test Step 4:"Click on [Assignment Rules] button"
	* Expected Result:"Assignment Rules page is shown"
	* Test Step 5:"Click on [Assign to] drop box"
	* Expected Result:"A drop list with all RSR users is displayed*This list only displayed RSR role"
	* Test Step 6:"Select a RSR in the list"
	* Expected Result:"RSR's name is selected"
	* Test Step 7:"Fill data all remain fields"
	* Expected Result:"The data is input to all remain field."
	* Test Step 8:"Click on [Save] button"
	* Expected Result:"A new Assignment rule with correct input data is created and displayed in the table"
	*/
	@Test
	public void VAN1600_AddANewAssignmentRule(){
		info("Prepare input data");
		String superRegion =assignData.getSuperRegionByType(1);
		String region=assignData.getRegionByType(1);
		String country=assignData.getCountryByType(1);
		String businessUnit=assignData.getBusinessUnitByType(1);
		String productLine=assignData.getProductLineByType(1);
		String shipToAMID=assignData.getShipToAMIDByType(1)+getRandomString();
		String soldToAMIDLevel2=assignData.getSoldToAMIDByType(1)+getRandomString();
		String customerNameShipTo=assignData.getCustomerNameShipToByType(1)+getRandomString();
		String customerNameSoldTo=assignData.getcustomerNameSoldToByType(1)+getRandomString();
		String assignTo=assignData.getAssignToByType(1);
		
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		info("Go to Add Assignment Rules page");
		assignRule.goToAddRule();
		info("Add a new assignment rule");
		assignRule.add(superRegion, region, country, businessUnit, productLine, 
				shipToAMID, soldToAMIDLevel2, customerNameShipTo, customerNameSoldTo, assignTo);
		info("Verify that the new assigment rule is displayed in the table");
		assignRule.searchBy(assignmentCol.SHIPTO_AMID,shipToAMID);
		assignRule.verifyInfo(superRegion);
		assignRule.verifyInfo(region);
		assignRule.verifyInfo(country);
		assignRule.verifyInfo(businessUnit);
		assignRule.verifyInfo(productLine);
		assignRule.verifyInfo(shipToAMID);
		assignRule.verifyInfo(soldToAMIDLevel2);
		assignRule.verifyInfo(customerNameShipTo);
		assignRule.verifyInfo(customerNameSoldTo);
		assignRule.verifyInfo(assignTo);
	}
		
	/**
	* Test case ID:VAN-1598
	* Test case name:"Check breadcrumb on Assignment Rules"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with user A"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Data Import] link on the left menu"
	* Expected Result:"Data Import Home page is shown"
	* Test Step 4:"Click on [Assignment Rules] button"
	* Expected Result:"Assignment Rules page is shown"
	* Test Step 5:"Check breadcrumb"
	* Expected Result:"The breadcrumb is shown as: Home->Administration->Data Import->Assignment rule"
	* Test Step 6:"Click on a link on the breadcrumb"
	* Expected Result:"Redirect to correct page"
	*/
	@Test
	public void VAN1598_CheckBreadcrumbOnAssignmentRules(){
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		info("Go to Data Import page");
		assignRule.goToDataImport();
		info("Verify that Data impage page is shown");
		waitForAndGetElement(dataImportHome.ELEMENT_DATAIMPORT_ASSIGNMENTRULES_BTN,3000,1);
	}
}