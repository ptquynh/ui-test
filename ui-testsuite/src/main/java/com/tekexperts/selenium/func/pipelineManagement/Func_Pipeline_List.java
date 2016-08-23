package com.tekexperts.selenium.func.pipelineManagement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.Contracts.status;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_Pipeline_List extends TestConfig{
	/**
	* Test case ID:VAN-1571
	* Test case name:"Update ATR file from Pipeline"
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
	* Test Step 5:"Select a file with data as precondition"
	* Test Data:"Attached file 1 bellow"
	* Expected Result:"The file's name is displayed in the field"
	* Test Step 6:"Click on [Import] button"
	* Expected Result:"The data is shown in the table with Successstatus."
	* Test Step 7:"Go to pipeline list"
	* Expected Result:"The contracts are displayed in the list"
	* Test Step 8:"Logout and login with user A"
	* Test Data:"Username:0001 (RSR role)Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 9:"Click on [Pipeline] link on left menu"
	* Expected Result:"Pipeline list is shown"
	* Test Step 10:"Click on [Import] button and select attached file from local machine"
	* Test Data:"attached file 2 bellow(Change data in [Blue] columns and [Gray] columns of the excel file)Example:*Blue column:[Quote Number] column: ChangeData*Gray column:[Ship To Name]column: ChangeData*Green column is kept because the system will automaticaly calculate these columns"
	* Expected Result:"The file is imported successfully*Only data is changed in [Blue] columns are updated in pipeline list.*Data is changed in [Gray] columns are not updated in the pipeline list."
	 * @throws Exception 
	*/
	@Test
	public void VAN1571_UpdateATRFileFromPipeline() throws Exception{
		info("Prepare data test");
		String userRSR = userData.getIDByArrayTypeRandom(2);
		String userNameRSR = userData.getNameByArrayTypeRandom(2);
		String expDocNbr= getLongRandomNumber();
		String fileName1= fData.getAttachFileByArrayTypeRandom(10);
		String fileName2= fData.getAttachFileByArrayTypeRandom(11);
		String path1=PATH_TESTDATA+fileName1;
		String path2=PATH_TESTDATA+fileName2;
		String nameCol="ExpDocNbr";
		int colExpDocNbr=5;
		int colSaleRep=81;
		int colEployeeID=82;
		int colOpptID=102;
		ArrayList<Integer> listColumn=new ArrayList<Integer>();
		ArrayList<Integer> listRow=new ArrayList<Integer>();
		ArrayList<String> listData=new ArrayList<String>();
		List<String> listDataBeforeUpdate= new ArrayList<String>();
		List<String> listDataAfterUpdate= new ArrayList<String>();
		
		listColumn.add(colExpDocNbr);// exp Doc Nbr field
		listColumn.add(colSaleRep); //Sales rep field
		listColumn.add(colEployeeID); //Employee Id field
		listRow.add(1);
		listData.add(expDocNbr);
		listData.add(userNameRSR);
		listData.add(userRSR);
		atrUpData.updateByArray(path1, defaultSheet,listRow,listColumn, listData,isUseFile);
		atrUpData.updateByArray(path2, defaultSheet,listRow,listColumn, listData, isUseFile);
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
		pipeList.search(nameCol,expDocNbr);
		//Utils.pause(3000);
		//pipeList.checkAllColumnInPipelist(expDocNbr);
		info("Verify that the contract is displayed in the table");
		pipeList.verifyContractInList(expDocNbr);
		listDataBeforeUpdate=pipeList.getData(expDocNbr);
		info("listDataBeforeUpdate:"+listDataBeforeUpdate);
		info("Update Oppt Id for second upload file");
		String opptID=pipeList.getDataFromPipeline(colOpptID-1, expDocNbr);
		atrUpData.update(path2,defaultSheet,1,colOpptID,opptID,isUseFile);
		
		mgLogInOut.signOut();
		mgLogInOut.signIn(userRSR,USER_PASS);
		info("Open pipeline list page");
		navMenu.goToPipeline();
		pipeList.search(nameCol,expDocNbr);
		//Utils.pause(3000);
		//pipeList.checkAllColumnInPipelist(expDocNbr);
		//Utils.pause(3000);
		info("Upload a ATR to execute mass update");
		pipeList.importATR(path2);
		pipeList.search(nameCol,expDocNbr);
		listDataAfterUpdate=pipeList.getData(expDocNbr);
		info("listDataAfterUpdate:"+listDataAfterUpdate);
		info("Verify that only blue field is updated via mass update");
		pipeList.compareData(listDataBeforeUpdate,listDataAfterUpdate);
		
	}
}