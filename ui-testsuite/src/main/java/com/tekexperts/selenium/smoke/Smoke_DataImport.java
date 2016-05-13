package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

public class Smoke_DataImport extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1733
	 * Test case name: Import a ATR file successfully
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Data Import] link
	 * Test Step 4: Click on [ATR]button
	 * Test Step 5: Click on [Choose file] button
	 * Test Step 6: Select a valid file
	 * Test Step 7: Click on [Import] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Data Import page is shown
	 * 4. ATR page is shown
	 * 5. A popup to select a upload file is open
	 * 6. The file's name is displayed in the upload file filed
	 * 7. The file is upload successfully and displayed in the table
	 */
	@Test
	public void VAN1733_ImportATRSuccessfully(){
		info("Prepare input data");
		String name = fData.getAttachFileByArrayTypeRandom(9);
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Upload a contract file");
		contract.upload(PATH_TESTDATA, name);
	}
	
	/**
	 * Test case ID: VAN-1734
	 * Test case name: Import a Order file successfully
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Data Import] link
	 * Test Step 4: Click on [Order Report]button
	 * Test Step 5: Click on [Choose file] button
	 * Test Step 6: Select a valid file
	 * Test Step 7: Click on [Import] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Data Import page is shown
	 * 4. Order page is shown
	 * 5. A popup to select a upload file is open
	 * 6. The file's name is displayed in the upload file filed
	 * 7. The file is upload successfully and displayed in the table
	 */
	@Test
	public void VAN1734_ImportOrderSuccessfully(){
		info("Prepare input data");
		String name = fData.getAttachFileByArrayTypeRandom(37);
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Order page");
		dataImportHome.goToOrderReport();
		info("Upload a order file");
		order.upload(PATH_TESTDATA, name);
	}
	
	/**
	 * Test case ID: VAN-1735
	 * Test case name: Create an assignment rule
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Data Import] link
	 * Test Step 4: Click on [Assignment Rules]button
	 * Test Step 5: Click on [Add] button
	 * Test Step 6: Input all required field
	 * Test Step 7: Click on [Save] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Data Import page is shown
	 * 4. Assignment Rules age is shown
	 * 5. Add Assignment Rules page is shown
	 * 6. All data is input
	 * 7. New Assignment Rule is shown in the table
	 */
	@Test
	public void VAN1735_CreateAnAssignmentRule(){
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
		assignRule.searchByShipToAMID(shipToAMID);
		assignRule.verifyAssignRuleInTheTable(shipToAMID);
	}
}
