package com.tekexperts.selenium.func.administration;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.Contracts.contractFilter;
import com.tekexperts.pipeline.administration.dataImport.Contracts.status;
import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.common.readData.ATRDatabase;
import com.tekexperts.pipeline.pipelineManagement.operation.UnassignedContracts.UnassignedCol;
import com.tekexperts.pipeline.pipelineManagement.pipeline.Pipeline.color;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_ATR extends TestConfig{
		
		/**
		* Test case ID:VAN-1667
		* Test case name:"Import ATR with existed Oppotunity ID in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"The contracts will be inserted into the system as a new contract."
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		* Test Step 9:"Export this contract"
		* Expected Result:"A excel file with the contract at step 5 is downloaded"
		* Test Step 10:"Verify Oppt ID of the contract at step 9"
		* Expected Result:"A Oppt ID will be automatically created in [Oppt ID] of the contract."
		* Test Step 11:"Change some thing in the contract"
		* Test Data:"Example: Update [Document Type] column"
		* Expected Result:"The file is updated"
		* Test Step 12:"Go to [ATR import] and import the contract at step 10"
		* Expected Result:"The contract is imported successfully"
		* Test Step 13:"Go to Pipeline list and search the contract at step 12"
		* Expected Result:"The contract is updated with new changs."
		 * @throws Exception 
		*/
	@Test
	public void VAN1667_ImportATRWithExistedOppotunityIDInTheSystem() throws Exception{
		info("Import ATR with existed Oppotunity ID in the system");
		info("Prepare data test");
		int colExpDocNbr=5;
		int colOpptID=102;
		String expDocNbr= getLongRandomNumber();
		String fileName1= fData.getAttachFileByArrayTypeRandom(70);
		String fileName2= fData.getAttachFileByArrayTypeRandom(71);
		String path1=PATH_TESTDATA+fileName1;
		String path2=PATH_TESTDATA+fileName2;
		upData.update(path1, defaultSheet,1,colExpDocNbr,expDocNbr, isUseFile);
		upData.update(path2,defaultSheet,1,colExpDocNbr,expDocNbr,isUseFile);
		info("Finished data test");
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
		
		info("Open pipeline list page");
		navMenu.goToPipeline();
		pipeList.search(colExpDocNbr,expDocNbr);
		Utils.pause(3000);
		pipeList.checkAllColumnInPipelist(expDocNbr);
		info("Verify that the contract is displayed in the table");
		pipeList.verifyContractInList(expDocNbr);
		info("Get quote number of the contract before updated");
		String quoteNumber1=pipeList.getDataFromPipeline(104,expDocNbr);
		info("Update Oppt Id for second upload file");
		String opptID=pipeList.getDataFromPipeline(colOpptID-1, expDocNbr);
		upData.update(path2,defaultSheet,1,colOpptID,opptID,isUseFile);
		
		info("Go to Data import page");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Upload ATR file");
		contract.upload(PATH_TESTDATA, fileName2);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully");
		contract.checkStatus(status.SUCCESS, expDocNbr);
		
		info("Open pipeline list page");
		navMenu.goToPipeline();
		pipeList.search(colExpDocNbr,expDocNbr);
		Utils.pause(3000);
		info("Verify that the contract is displayed in the table");
		pipeList.verifyContractInList(expDocNbr);
		info("Get quote number of the contract before updated");
		String quoteNumber2=pipeList.getDataFromPipeline(104,expDocNbr);
		info("Compare data after update");
		pipeList.compareData(quoteNumber1,quoteNumber2, color.BLUE);
	}
		
		/**
		* Test case ID:VAN-1666
		* Test case name:"Import ATR with no blank and no existed Oppotunity ID"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"A error message is displayed as: OpptID does not exist in the Contract. Please check again."
		* Test Step 7:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1666_ImportATRWithNoBlankAndNoExistedOppotunityID() throws Exception{
		info("Import ATR with no blank and no existed Oppotunity ID");
		String message = mesg.getContentByType(21);
		String file = fData.getAttachFileByArrayTypeRandom(22);
		String path1=PATH_TESTDATA+file;
		String expDocNbr= getLongRandomNumber();
		upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file,false);
		info("A error message is displayed as: OpptID does not exist in the Contract. Please check again.");
		contract.verifyMessageNotification(message);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1665
		* Test case name:"Import ATR with blank Oppotunity ID"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"The contracts will be inserted into the system as a new contract."
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1665_ImportATRWithBlankOppotunityID() throws Exception{
		info("Import ATR with blank Oppotunity ID");
		String file = fData.getAttachFileByArrayTypeRandom(14);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with Success status");
		contract.checkStatus(status.SUCCESS, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1664
		* Test case name:"Import ATR with existed Region/Business Unit/RTM in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"In [Status] column
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1664_ImportATRWithExistedRegionBusinessUnitRTMInTheSystem() throws Exception{
		info("Import ATR with existed Region/Business Unit/RTM in the system");
		String file = fData.getAttachFileByArrayTypeRandom(20);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with No RTM Unit status");
		contract.checkStatus(status.NORTM, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1663
		* Test case name:"Import ATR with only existed Region and Business Unit in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"In [Status] column
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1663_ImportATRWithOnlyExistedRegionAndBusinessUnitInTheSystem() throws Exception{
		info("Import ATR with only existed Region and Business Unit in the system");
		String file = fData.getAttachFileByArrayTypeRandom(19);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with No Business Unit status");
		contract.checkStatus(status.NOBUSINESSUNIT, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1662
		* Test case name:"Import ATR with only existed RTM in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"In [Status] column
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1662_ImportATRWithOnlyExistedRTMInTheSystem() throws Exception{
		info("Import ATR with only existed RTM in the system");
		String file = fData.getAttachFileByArrayTypeRandom(21);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with No Business Unit status");
		contract.checkStatus(status.NOBUSINESSUNIT, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1661
		* Test case name:"Import ATR with only existed Business Unit in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"In [Status] column
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1661_ImportATRWithOnlyExistedBusinessUnitInTheSystem() throws Exception{
		info("Import ATR with only existed Business Unit in the system");
		String file = fData.getAttachFileByArrayTypeRandom(19);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with No Business Unit status");
		contract.checkStatus(status.NOBUSINESSUNIT, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1660
		* Test case name:"Import ATR with only existed Region in the system"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the upload file at step 5"
		* Expected Result:"In [Status] column, display a status as:{color:red}No Region{color}
		* Test Step 8:"Go to Pipeline list"
		* Expected Result:"The contract is not added to the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1660_ImportATRWithOnlyExistedRegionInTheSystem() throws Exception{
		info("Import ATR with only existed Region in the system");
		String file = fData.getAttachFileByArrayTypeRandom(18);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file);
		info("Open detail contract");
		contract.goToViewDetail();
		info("Verify the contract is imported successfully with No Region status");
		contract.checkStatus(status.NOREGION, expDocNbr);
		info("Go to Pipeline list");
		navMenu.goToPipeline();
		pipeList.search(5,expDocNbr);
	}
		
		/**
		* Test case ID:VAN-1659
		* Test case name:"Import ATR with blank Region/RTM/Business Unit"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"A error message is displayed as: Region/BU/RTM is blank. Please check."
		 * @throws Exception 
		*/
	@Test
	public void VAN1659_ImportATRWithBlankRegionRTMBusinessUnit() throws Exception{
		info("Import ATR with blank Region/RTM/Business Unit");
		String message = mesg.getContentByType(20);
		String file = fData.getAttachFileByArrayTypeRandom(15);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("Go to Data Import");
		navMenu.goToDataImport();
		info("Go to ATR page");
		dataImportHome.goToATR();
		info("Import a unassigned contract");
		contract.upload(PATH_TESTDATA, file,false);
		contract.verifyMessageNotification(message);
	}
		
		/**
		* Test case ID:VAN-1657
		* Test case name:"Unassign a Contract"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Import a contract"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 7:"Click on [Unassigned Contracts] button"
		* Expected Result:"Unassigned RSR page is shown"
		* Test Step 8:"Check Unassigned Contracts list"
		* Expected Result:"The contact is not displayed in the list"
		 * @throws Exception 
		*/
	@Test
	public void VAN1657_UnassignAContract() throws Exception{
		info("Unassign a Contract");
		String file = fData.getAttachFileByArrayTypeRandom(66);
		String name = rsrData.getNameByArrayTypeRandom(1);
		ATRFilePath = PATH_TESTDATA+file;
		ATRDatabase atrData= new ATRDatabase();
		atrData.setData(ATRFilePath,defaultSheet,isUseFile);
		String expDocNbr= getLongRandomNumber();
		upData.update(ATRFilePath, defaultSheet,1,5,expDocNbr, isUseFile);
		info("expDocNbr:"+expDocNbr);
		info("Name:"+name);
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Go to Unassigned Contracts page");
		opeHome.goToUnassignedATR();
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
			opeHome.goToUnassignedATR();
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
		* Test case ID:VAN-1581
		* Test case name:"Check Delete All Contracts button"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Scroll to the end of the page"
		* Expected Result:"[Delete All Contracts] button is displayed"
		* Test Step 6:"Go to Product page"
		* Test Data:"Product environment:[1]http://c9w20077.itcs.hp.com/----------------------------------------------------------------------------------------[1] [1]http://c9w20077.itcs.hp.com/----------------------------------------------------------------------------------------[1] http://c9w20077.itcs.hp.com/"
		* Expected Result:"The login page is shown"
		* Test Step 7:"Login with admin account and go to ATR import page"
		* Test Data:"Admin account: 6666/Test@123456"
		* Expected Result:"[Delete All Contracts] button is not displayed"
		* PENDING CASE: THIS CASE SHOULD BE TESTED BY MANUAL
		*/
	@Test(groups="pending")
	public void VAN1581_CheckDeleteAllContractsButton(){
	}
		
		/**
		* Test case ID:VAN-1580
		* Test case name:"Check Reset Contracts button"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Scroll to the end of the page"
		* Expected Result:"[Reset Contracts] button is displayed"
		* Test Step 6:"Go to Product page"
		* Test Data:"Product environment:[1]http://c9w20077.itcs.hp.com/----------------------------------------------------------------------------------------[1] [1]http://c9w20077.itcs.hp.com/----------------------------------------------------------------------------------------[1] http://c9w20077.itcs.hp.com/"
		* Expected Result:"The login page is shown"
		* Test Step 7:"Login with admin account and go to ATR import page"
		* Test Data:"Admin account: 6666/Test@123456"
		* Expected Result:"[Reset Contracts] button is not displayed"
		* PENDING: THIS CASE SHOULB BE TESTED BY MANUAL
		*/
	@Test(groups="pending")
	public void VAN1580_CheckResetContractsButton(){
	}
		
		/**
		* Test case ID:VAN-1579
		* Test case name:"Check data after imported from ATR"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The data is imported succesfully"
		* Test Step 7:"Click on [View] link in the table of the imported file"
		* Expected Result:"The detail contracts are displayed"
		* Test Step 8:"Check data of the contracts"
		* Expected Result:"All data in the columns are displayed correctly with data in the excel file"
		 * @throws Exception 
		*/
		@Test
		public void VAN1579_CheckDataAfterImportedFromATR() throws Exception{
			info("Check data after imported from ATR");
			info("Prepare data test");
			int colExpDocNbr=5;
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(69);
			String path1=PATH_TESTDATA+fileName1;
			upData.update(path1, defaultSheet,1,colExpDocNbr,expDocNbr, isUseFile);
			atrData.setData(path1, defaultSheet, isUseFile);
			List<String>list1=atrData.getViewDetailList();
			info("list1:"+list1);
			info("Finished data test");
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
			info("Verify that all default columns are displayed");
			contract.verifyDefaultColumns();
			info("All data in the columns are displayed correctly with data in the excel file");
			List<String>list2=contract.getContentAllColumns();
			info("list1:"+list1);
			info("list2:"+list2);
			info("Verify the data of all columns");
			if(!equalLists(list1, list2)) assert false:"The data is not equal";
		}
		/**
		* Test case ID:VAN-1575
		* Test case name:"Update ""WON"" contracts from Pipeline with normal user"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A account"
		* Test Data:"HPID: 0002Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file 1 bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The data is shown in the table with Successstatus."
		* Test Step 7:"Go to pipeline list"
		* Expected Result:"The contracts are displayed in the list"
		* Test Step 8:"Logout and login with a normal user"
		* Expected Result:"Home page is shown"
		* Test Step 9:"Go to Pipeline list page"
		* Expected Result:"The page is shown"
		* Test Step 10:"Click on [Import] button"
		* Test Data:"attached file 2 bellow"
		* Expected Result:"The file is not imported successfully*A error message is shown as:The excel file format incorrected. Please check again."
		* Test Step 11:"Go to pipeline list"
		* Expected Result:"The data with new changes is not updated"
		 * @throws Exception 
		*/
		@Test
		public void VAN1575_UpdateWONContractsFromPipelineWithNormalUser() throws Exception{
			info("Update 'WON' contracts from Pipeline with normal user");
			info("Prepare data test");
			String message = mesg.getContentByType(19);
			String userRSR = userData.getIDByArrayTypeRandom(2);
			String userNameRSR = userData.getNameByArrayTypeRandom(2);
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(67);
			String fileName2= fData.getAttachFileByArrayTypeRandom(68);
			String path1=PATH_TESTDATA+fileName1;
			String path2=PATH_TESTDATA+fileName2;
			
			int colExpDocNbr=5;
			int colSaleRep=81;
			int colEployeeID=82;
			int colOpptID=102;
			ArrayList<Integer> listColumn=new ArrayList<Integer>();
			ArrayList<Integer> listRow=new ArrayList<Integer>();
			ArrayList<String> listData=new ArrayList<String>();
			
			listColumn.add(colExpDocNbr);// exp Doc Nbr field
			listColumn.add(colSaleRep); //Sales rep field
			listColumn.add(colEployeeID); //Employee Id field
			listRow.add(1);
			listData.add(expDocNbr);
			listData.add(userNameRSR);
			listData.add(userRSR);
			upData.updateByArray(path1, defaultSheet,listRow,listColumn, listData,isUseFile);
			upData.updateByArray(path2, defaultSheet,listRow,listColumn, listData, isUseFile);
			info("Finished data test");
			
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
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			pipeList.checkAllColumnInPipelist(expDocNbr);
			info("Verify that the contract is displayed in the table");
			pipeList.verifyContractInList(expDocNbr);
			info("Update Oppt Id for second upload file");
			String opptID=pipeList.getDataFromPipeline(colOpptID-1, expDocNbr);
			upData.update(path2,defaultSheet,1,colOpptID,opptID,isUseFile);
			
			mgLogInOut.signOut();
			mgLogInOut.signIn(userRSR,USER_PASS);
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			info("Upload a ATR to execute mass update");
			pipeList.importATR(path2);
			info("A error message is shown as:The excel file format incorrected. Please check again.");
			pipeList.verifyNotifcationMessage(message);
		}
		
		/**
		* Test case ID:VAN-1576
		* Test case name:"Update ""WON"" contracts from Pipeline with manager users"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A account"
		* Test Data:"HPID: 0002Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file 1 bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The data is shown in the table with Successstatus."
		* Test Step 7:"Go to pipeline list"
		* Expected Result:"The contracts are displayed in the list"
		* Test Step 8:"Click on [Import] button"
		* Test Data:"attached file 2 bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to pipeline list"
		* Expected Result:"The data with new changes is updated"
		 * @throws Exception 
		*/
		@Test
		public void VAN1576_UpdateWONContractsFromPipelineWithManagerUsers() throws Exception{
			info("Update 'WON' contracts from Pipeline with manager users");
			info("Prepare data test");
			String userRSR = userData.getIDByArrayTypeRandom(3);
			String userNameRSR = userData.getNameByArrayTypeRandom(3);
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(67);
			String fileName2= fData.getAttachFileByArrayTypeRandom(68);
			String path1=PATH_TESTDATA+fileName1;
			String path2=PATH_TESTDATA+fileName2;
			
			int colExpDocNbr=5;
			int colSaleRep=81;
			int colEployeeID=82;
			int colOpptID=102;
			ArrayList<Integer> listColumn=new ArrayList<Integer>();
			ArrayList<Integer> listRow=new ArrayList<Integer>();
			ArrayList<String> listData=new ArrayList<String>();
			
			listColumn.add(colExpDocNbr);// exp Doc Nbr field
			listColumn.add(colSaleRep); //Sales rep field
			listColumn.add(colEployeeID); //Employee Id field
			listRow.add(1);
			listData.add(expDocNbr);
			listData.add(userNameRSR);
			listData.add(userRSR);
			upData.updateByArray(path1, defaultSheet,listRow,listColumn, listData,isUseFile);
			upData.updateByArray(path2, defaultSheet,listRow,listColumn, listData, isUseFile);
			info("Finished data test");
			
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
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			pipeList.checkAllColumnInPipelist(expDocNbr);
			info("Verify that the contract is displayed in the table");
			pipeList.verifyContractInList(expDocNbr);
			info("Get quote number of the contract before updated");
			String quoteNumber1=pipeList.getDataFromPipeline(104,expDocNbr);
			info("Update Oppt Id for second upload file");
			String opptID=pipeList.getDataFromPipeline(colOpptID-1, expDocNbr);
			upData.update(path2,defaultSheet,1,colOpptID,opptID,isUseFile);
			
			mgLogInOut.signOut();
			mgLogInOut.signIn(userRSR,USER_PASS);
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			info("Verify that the contract is displayed in the table");
			pipeList.verifyContractInList(expDocNbr);
			info("Get quote number of the contract after updated");
			String quoteNumber2=pipeList.getDataFromPipeline(104,expDocNbr);
			info("Compare data after update");
			pipeList.compareData(quoteNumber1,quoteNumber2, color.BLUE);
		}
		/**
		* Test case ID:VAN-1573
		* Test case name:"Update ""WON"" contracts from ATR import"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A account"
		* Test Data:"HPID: 0002Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file 1 bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The data is shown in the table with Successstatus."
		* Test Step 7:"Go to pipeline list"
		* Expected Result:"The contracts are displayed in the list"
		* Test Step 8:"Go to ATR import page again"
		* Expected Result:"The page is shown"
		* Test Step 9:"Select a file data"
		* Test Data:"Attached file 2 bellow"
		* Expected Result:"The file is selected from local machine"
		* Test Step 10:"Click on [Import] button"
		* Expected Result:"The file is imported successfully*All changed data is updated"
		* Test Step 11:"Go to pipeline list"
		* Expected Result:"The data with new changes is displayed"
		 * @throws Exception 
		*/
		@Test
		public void VAN1573_UpdateWONContractsFromATRImport() throws Exception{
			info("Update 'WON' contracts from ATR import");
			info("Prepare data test");
			int colExpDocNbr=5;
			int colOpptID=102;
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(67);
			String fileName2= fData.getAttachFileByArrayTypeRandom(68);
			String path1=PATH_TESTDATA+fileName1;
			String path2=PATH_TESTDATA+fileName2;
			upData.update(path1, defaultSheet,1,colExpDocNbr,expDocNbr, isUseFile);
			upData.update(path2,defaultSheet,1,colExpDocNbr,expDocNbr,isUseFile);
			info("Finished data test");
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
			
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			pipeList.checkAllColumnInPipelist(expDocNbr);
			info("Verify that the contract is displayed in the table");
			pipeList.verifyContractInList(expDocNbr);
			info("Get quote number of the contract before updated");
			String quoteNumber1=pipeList.getDataFromPipeline(104,expDocNbr);
			info("Update Oppt Id for second upload file");
			String opptID=pipeList.getDataFromPipeline(colOpptID-1, expDocNbr);
			upData.update(path2,defaultSheet,1,colOpptID,opptID,isUseFile);
			
			info("Go to Data import page");
			navMenu.goToDataImport();
			info("Go to ATR page");
			dataImportHome.goToATR();
			info("Upload ATR file");
			contract.upload(PATH_TESTDATA, fileName2);
			info("Open detail contract");
			contract.goToViewDetail();
			info("Verify the contract is imported successfully");
			contract.checkStatus(status.SUCCESS, expDocNbr);
			
			info("Open pipeline list page");
			navMenu.goToPipeline();
			pipeList.search(colExpDocNbr,expDocNbr);
			Utils.pause(3000);
			info("Verify that the contract is displayed in the table");
			pipeList.verifyContractInList(expDocNbr);
			info("Get quote number of the contract before updated");
			String quoteNumber2=pipeList.getDataFromPipeline(104,expDocNbr);
			info("Compare data after update");
			pipeList.compareData(quoteNumber1,quoteNumber2, color.BLUE);
		}
		/**
		* Test case ID:VAN-1569
		* Test case name:"Import ATR with ""Insert Duplicated Key"" Status"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of upload file at step 5"
		* Expected Result:"The data is shown in the table with Insert Duplicated Keystatus."
		* Test Step 8:"Go to pipeline list"
		* Expected Result:"The duplicated data is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1569_ImportATRWithInsertDuplicatedKeyStatus() throws Exception{
			info("Import ATR with 'Insert Duplicated Key' Status");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(10);
			String path1=PATH_TESTDATA+fileName1;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Finished data test");
			info("Go to Data import page");
			navMenu.goToDataImport();
			info("Go to ATR page");
			dataImportHome.goToATR();
			info("Upload ATR file");
			contract.upload(PATH_TESTDATA, fileName1);
			Utils.pause(3000);
			contract.upload(PATH_TESTDATA, fileName1);
			Utils.pause(3000);
			info("Open detail contract");
			contract.goToViewDetail();
			info("Verify the contract is imported successfully with duplicated status");
			contract.checkStatus(status.DUPLICATE, expDocNbr);
		}
		/**
		* Test case ID:VAN-1568
		* Test case name:"Import ATR with ""Success"" status"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file with data as precondition"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The data is shown in the table with ""Success"" status."
		* Test Step 7:"Go to pipeline list"
		* Expected Result:"The data is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1568_ImportATRWithSuccessStatus() throws Exception{
			info("Import ATR with 'Success' status");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(10);
			String path1=PATH_TESTDATA+fileName1;
			
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Finished data test");
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
		}
		
		/**
		* Test case ID:VAN-1567
		* Test case name:"Check paging control"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Check paging control by default"
		* Expected Result:"Display data of 1st page*Highlight number 1 in the paging control*[Next] arrow is displayed*[Previous] arrow is hided"
		* Test Step 6:"Click on a number in the paging control"
		* Expected Result:"Display data correctly with corresponding number"
		* Test Step 7:"Click on [Next] button"
		* Expected Result:"Display data correctly with corresponding next page"
		* Test Step 8:"Click on [Previous] button"
		* Expected Result:"Display data correctly with corresponding previous page"
		* Test Step 9:"Click at the end of the paging control"
		* Expected Result:"Display correct data of last page"
		* Test Step 10:"Click at the beginning of the paging control"
		* Expected Result:"Display correct data of first page"
		* PENDING: THIS CASE SHOULD BE TESTED BY MANUAL
		*/
		@Test(groups="pending")
		public void VAN1567_CheckPagingControl(){
		}
		/**
		* Test case ID:VAN-1566
		* Test case name:"Check paging size"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Check paging size by default"
		* Expected Result:"Display 50 lines/page"
		* Test Step 6:"Select a value in the drop-down list"
		* Expected Result:"Display the data correctly with corresponding selected value"
		*/
		@Test
		public void VAN1566_CheckPagingSize(){
			info("Check paging size");
			String[] listSize={"10","20","50","100","200"};
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			Utils.pause(3000);
			info("Change the page size");
			contract.checkPageSize(listSize);
		}
		/**
		* Test case ID:VAN-1565
		* Test case name:"Check multi-filters"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Type some texts in some columns"
		* Test Data:"Example: file name
		* Expected Result: upload date
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		 * @throws Exception 
		*/
		@Test
		public void VAN1565_CheckMultifilters() throws Exception{
			info("Check multi-filters");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileName);
			Utils.pause(3000);
			String date = getCurrentDate("MMM d yyyy");
			contract.searchBy(contractFilter.UPLOAD_BY,USER_ROOT_FULLNAME);
			contract.searchBy(contractFilter.UPLOAD_DATE,date);
			contract.searchBy(contractFilter.FILE_SIZE,"13");
			contract.verifyContractInTable(fileName);
		}
		/**
		* Test case ID:VAN-1564
		* Test case name:"Check filter by Upload By"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Type a text in the filter field of [Upload By] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		 * @throws Exception 
		*/
		@Test
		public void VAN1564_CheckFilterByUploadBy() throws Exception{
			info("Check filter by Upload By");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileName);
			Utils.pause(3000);
			contract.searchBy(contractFilter.UPLOAD_BY,USER_ROOT_FULLNAME);
			contract.verifyContractInTable(fileName);
		}
		/**
		* Test case ID:VAN-1563
		* Test case name:"Check filter by Upload date"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Type a text in the filter field of [Upload date] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		 * @throws Exception 
		*/
		@Test
		public void VAN1563_CheckFilterByUploadDate() throws Exception{
			info("Check filter by Upload date");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileName);
			Utils.pause(3000);
			String date = getCurrentDate("MMM d yyyy");
			contract.searchBy(contractFilter.UPLOAD_DATE,date);
			contract.verifyContractInTable(fileName);
		}
		/**
		* Test case ID:VAN-1562
		* Test case name:"Check filter by file size"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Type a text in the filter field of [File Size] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		 * @throws Exception 
		*/
		@Test
		public void VAN1562_CheckFilterByFileSize() throws Exception{
			info("Check filter by file size");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileName);
			Utils.pause(3000);
			contract.searchBy(contractFilter.FILE_SIZE,"13");
			contract.verifyContractInTable(fileName);
		}
		/**
		* Test case ID:VAN-1561
		* Test case name:"Check filter by file name"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Type a text in the filter field of [File Name] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display data correctly with corresponding filter*if not found
		 * @throws Exception 
		*/
		@Test
		public void VAN1561_CheckFilterByFileName() throws Exception{
			info("Check filter by file name");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileName);
			Utils.pause(3000);
			contract.searchBy(contractFilter.FILE_NAME,fileName);
			contract.verifyContractInTable(fileName);
		}
		/**
		* Test case ID:VAN-1560
		* Test case name:"Check information after imported a file"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Check file size"
		* Expected Result:"Display correct file's size"
		* Test Step 6:"Check upload date"
		* Expected Result:"Display correct upload date with correct format that is set in User's profile*if in user's profile not set format date
		* Test Step 7:"Check Upload by"
		* Expected Result:"Display correct username that upload the file"
		* PENDING: THIS SHOULD BE TESTED BY MANUAL
		*/
		@Test(groups="pending")
		public void VAN1560_CheckInformationAfterImportedAFile(){
			
		}
		
		/**
		* Test case ID:VAN-1559
		* Test case name:"Download a ATR file"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Click on a file's name in [File Name] column"
		* Expected Result:"The file is downloaded with correct data and name to local machine"
		 * @throws Exception 
		*/
		@Test
		public void VAN1559_DownloadAATRFile() throws Exception{
			info("Download a ATR file");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileName);
			Utils.pause(3000);
			info("Check the download file");
			contract.download();
		}
		/**
		* Test case ID:VAN-1558
		* Test case name:"View detail a imported file"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a excel file with correct template"
		* Test Data:"Take the attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully"
		* Test Step 7:"Click on [View] link of the file at step 6 in the table"
		* Expected Result:"Contract view detail page is shown"
		 * @throws Exception 
		*/
		@Test
		public void VAN1558_ViewDetailAImportedFile() throws Exception{
			info("View detail a imported file");
			info("Import ATR with 'Success' status");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName1= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName1;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Finished data test");
			info("Go to Data import page");
			navMenu.goToDataImport();
			info("Go to ATR page");
			dataImportHome.goToATR();
			info("Upload ATR file");
			contract.upload(PATH_TESTDATA, fileName1);
			info("Open detail contract and verify that view detail page is shown");
			contract.goToViewDetail();
		}
		/**
		* Test case ID:VAN-1557
		* Test case name:"Import ATR with incorrect file's format"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a file that is not excel file"
		* Test Data:"pdf file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"A error message is displayed as: The ConnectionString property has not been initialized."
		*/
		@Test
		public void VAN1557_ImportATRWithIncorrectFilesFormat(){
			info("Import ATR with incorrect file's format");
			String name = fData.getAttachFileByArrayTypeRandom(62);
			String message=mesg.getContentByType(17);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a incorrect ATR file");
			contract.upload(PATH_TESTDATA, name,false);
			contract.verifyMessageNotification(message);
		}
		
		/**
		* Test case ID:VAN-1554
		* Test case name:"Import ATR with correct file's format"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Select a excel file with correct template"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the upload field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully*The file's name is displayed in the table"
		 * @throws Exception 
		*/
		
		@Test
		public void VAN1554_ImportATRWithCorrectFilesFormat() throws Exception{
			info("Import ATR with correct file's format");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileName= fData.getAttachFileByArrayTypeRandom(9);
			String path1=PATH_TESTDATA+fileName;
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileName);
		}
		
		/**
		* Test case ID:VAN-1552
		* Test case name:"Check breadcrumb on ATR page"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [ATR] button"
		* Expected Result:"ATR page is shown"
		* Test Step 5:"Check breadcrumb"
		* Expected Result:"The breadcrumb is shown as: Home->Administration->Data Import->ATR"
		* Test Step 6:"Click on a link on the breadcrumb"
		* Expected Result:"Redirect to correct page"
		* PENDING: THIS SHOULD BE TESTED BY MANUAL
		*/
		@Test(groups="pending")
		public void VAN1552_CheckBreadcrumbOnATRPage(){
		}
}