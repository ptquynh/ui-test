package com.tekexperts.selenium.func.pipelineManagement;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.Contracts.status;
public class Func_Unassign_Contracts extends TestConfig {
	/**
	* Test case ID:VAN-1546
	* Test case name:"Check Assign RSR list"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with an admin account or an manager account"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Operation] link on the left menu"
	* Expected Result:"Operation page is shown"
	* Test Step 4:"Click on [Unassigned Contracts] button"
	* Expected Result:"Unassign RSR page is shown"
	* Test Step 5:"Select a or some contracts"
	* Expected Result:"The contracts are selected"
	* Test Step 6:"Click on [Assign] button"
	* Expected Result:"[Assign RSR] page is shown"
	* Test Step 7:"Click on RSR drop-down"
	* Expected Result:"Only list all users that have RSR role in the system"
	 * @throws Exception 
	*/
	@Test
	public void VAN1546_CheckAssignRSRList() throws Exception{
		info("Prepare data Test");
		String expDocNbr= getLongRandomNumber();
		String userNameRSR = userData.getNameByArrayTypeRandom(1);
		String fileName1= fData.getAttachFileByArrayTypeRandom(66);
		String path1=PATH_TESTDATA+fileName1;
		
		int colExpDocNbr=5;
		atrUpData.update(path1, defaultSheet, 1,colExpDocNbr,expDocNbr,isUseFile);
		info("Go to Data import page");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Upload ATR file");
		contract.upload(PATH_TESTDATA, fileName1);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully");
		contract.checkStatus(status.SUCCESS, expDocNbr);
		
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Open Unassigned Contracts page");
		operaHome.goToUnassignedATR();
		info("Select the contract");
		unassignATR.selectAllCheckbox();
		info("Click on Assign button");
		unassignATR.goToAssignRSR();
		info("Only list all users that have RSR role in the system");
		assignRSR.verifyUserIsNotAvailabile(userNameRSR);
	}
}