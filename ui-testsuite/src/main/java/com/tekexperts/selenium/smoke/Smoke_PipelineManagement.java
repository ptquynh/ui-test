package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.common.readData.ATRDatabase;
import com.tekexperts.pipeline.pipelineManagement.operation.UnassignedContracts.UnassignedCol;

public class Smoke_PipelineManagement extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1744
	 * Test case name:Check Unassigned Contracts
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Operation] link
	 * Test Step 4: Click on [Unassigned Contracts]button
	 * Test Step 5: Select some contracts
	 * Test Step 6: Click on [Assign]button
	 * Test Step 7: Assign contracts to RSR
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Operation home page is shown
	 * 4. Unassigned Contracts page is shown
	 * 5. The contracts are selected
	 * 6. Assign page is shown
	 * 7. The contracts are assigned successfully
	 * @throws Exception 
	 */
	@Test
	public void VAN1744_CheckUnassignedContracts() throws Exception{
		String file = fData.getAttachFileByArrayTypeRandom(66);
		//String fileRead = fData.getAttachFileByArrayTypeRandom(63);
		String name = rsrEmployData.getNameByArrayTypeRandom(1);
		
		//Get data of ATR from excel
		//ATRFilePath=null;
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		atrUpData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("expDocNbr:"+expDocNbr);
		info("Name:"+name);
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Go to Unassigned Contracts page");
		operaHome.goToUnassignedATR();
		int i=0;
		Utils.pause(3000);
		unassignATR.searchBy(UnassignedCol.ExpDocNbr,expDocNbr);
		while(!unassignATR.isEmptyList()){
			info("Go to Data Import");
			navMenu.goToDataImport();
			info("Go to ATR page");
			dataImportHome.goToATR();
			info("Import a unassigned contract");
			contract.upload(PATH_TESTDATA, file);
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Unassigned Contracts page");
			operaHome.goToUnassignedATR();
			if(i>5)break;
			i++;
		}
		unassignATR.searchBy(UnassignedCol.ExpDocNbr,expDocNbr);
		info("Select all contracts ");
		unassignATR.selectAllCheckbox();
		info("Open Assign RSR contract");
		unassignATR.goToAssignRSR();
		info("Assign a RSR");
		assignRSR.selectRSR(name);
		assignRSR.assign();
		unassignATR.verifyContractNOTAvailableInTable(expDocNbr);
	}
	
	/**
	 * Test case ID: VAN-1745
	 * Test case name:Check Fallout Orders
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Operation] link
	 * Test Step 4: Click on [Fallout]button
	 * Test Step 5: Click on [Unassigned Order]tab
	 * Test Step 6: Click on [No Previous Doc]tab
	 * Test Step 7: Click on [Duplicated Previous Doc]tab
	 * Test Step 8: Click on [Negative Order]tab
	 * Test Step 9: Click on [Multiple Close Date]tab
	 * Test Step 10: Click on [Not Reconciled]tab
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Operation home page is shown
	 * 4. Fallout Summaries page is shown
	 * 5. Unassigned Order page is shown
	 * 6. No Previous Doc page is shown
	 * 7. Duplicated Previous Doc page is shown
	 * 8. Negative Order page is shown
	 * 9. Multiple Close Date page is shown
	 * 10. Not Reconciled page is shown
	 */
	@Test
	public void VAN1745_CheckFalloutOrders(){
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Go to Fallout Summaries page");
		operaHome.goToFalloutOrders();
		info("FallOut Summaries page is shown");
		waitForAndGetElement(falloutHome.ELEMENT_FALLOUT_FALLOUTSUMMARIES_TITLE,2000,1);
		info("Open Unassigned Order tab");
		falloutHome.goToUnassignedOrdersTab();
		info("Open No Previous Doc");
		falloutHome.goToNoPreviousDocTab();
		info("Open Duplicated Previous Doc tab");
		falloutHome.goToDuplicatedPreviousDocTab();
		info("Opem Negative Orders tab");
		falloutHome.goToNegativeOrdersTab();
		info("Open Multiple Close Dates tab");
		falloutHome.goToMultipleCloseDatesTab();
		info("Open Not Reconciled tab");
		falloutHome.goToNotReconciledTab();
	}
	/**
	 * Test case ID: VAN-1746
	 * Test case name:Check pipeline list
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Pipeline] link
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Pipeline list page is shown. Left menu is hided.
	 */
	@Test
	public void VAN1746_CheckPipelinelist(){
		info("Go to Pipeline list page");
		navMenu.goToPipeline();
		info("Left menu is collapsed");
		waitForAndGetElement(navMenu.ELEMENT_LEFT_MENU_COLLAPSE_STATUS,2000,1);
		info("Pipeline list is shown");
		waitForAndGetElement(pipeList.ELEMENT_PIPELINE_LIST,2000,1);
	}
}
