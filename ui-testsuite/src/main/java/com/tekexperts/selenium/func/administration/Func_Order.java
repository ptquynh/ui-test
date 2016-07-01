package com.tekexperts.selenium.func.administration;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.Orders.filterDroplist;
import com.tekexperts.pipeline.administration.dataImport.Orders.filterViewDetail;
import com.tekexperts.pipeline.administration.dataImport.Orders.orderFilter;
import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.common.readData.OrderDatabase;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutUnassignedOrders.filterUnassigned;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Func_Order extends TestConfig{
	/**
	* Test case ID:VAN-2138
	* Test case name:"Assign a Order by EMEA/SOLD TO assignment rules"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with user A"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Data Import] link on the left menu"
	* Expected Result:"Data Import Home page is shown"
	* Test Step 4:"Click on [Order Import] button"
	* Expected Result:"Order page is shown"
	* Test Step 5:"Import a Order file"
	* Test Data:"Attached file bellow"
	* Expected Result:"The file is imported successfully"
	* Test Step 6:"Click on [View] button"
	* Expected Result:"All data in the columns is displayed with correct data in the excel"
	* Test Step 7:"Check [Assignment] column"
	* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
	* Test Step 8:"Check [RTM] column"
	* Expected Result:"This column is blank"
	* Test Step 9:"Check [ATR type] column"
	* Expected Result:"This column is blank"
	* Test Step 10:"Check data in all remain columns"
	* Expected Result:"All data is displayed correctly as in the excel file"
	* Test Step 11:"Click on [Operation] link on the left menu"
	* Expected Result:"Operation page home is shown"
	* Test Step 12:"Click on [Fallout Orders] button"
	* Expected Result:"Fallout Summaries page is shown"
	* Test Step 13:"Click on [Unassigned Orders] tab"
	* Expected Result:"The tab's content is shown"
	* Test Step 14:"Check Unassigned Orders list"
	* Expected Result:"The order is not displayed in the list"
	 * @throws Exception 
	*/
	@Test
	public void VAN2138_AssignAOrderByEMEASOLDTOAssignmentRules() throws Exception{
		info("Assign a Order by EMEA/SOLD TO assignment rules");
		info("Create assignment rules");
		info("Create a new rsr user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(5);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgHome.goToUser();
		info("Go to Add user page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		user.save();
		Utils.pause(3000);
		
		info("Update Sold to column in Order file");
		ArrayList<Integer>rowList=new ArrayList<Integer>();
		ArrayList<Integer>colList=new ArrayList<Integer>();
		ArrayList<String>valueList=new ArrayList<String>();
		String soldToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
		String shipToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
		String prevDoc=getLongRandomNumber();
		for(int i=1;i<7;i++)rowList.add(i);
		colList.add(4);
		colList.add(8);
		colList.add(49);
		valueList.add(soldToAMIDLevel2ID);
		valueList.add(shipToAMIDLevel2ID);
		valueList.add(prevDoc);
		String fileOrder= fData.getAttachFileByArrayTypeRandom(75);
		String path2=PATH_TESTDATA+fileOrder;
		upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
		
		String fileAssignRule=assignRuleFilePath;
		info("Update sold to and ship to column for rules from 76->81");
		ArrayList<Integer>rowList2=new ArrayList<Integer>();
		ArrayList<Integer>colList2=new ArrayList<Integer>();
		ArrayList<String>valueList2=new ArrayList<String>();
		for(int i=76;i<82;i++)rowList2.add(i);
		colList2.add(7);
		valueList2.add(soldToAMIDLevel2ID);
		upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
		
		info("Update assign to column for rules from 76->81");
		ArrayList<Integer>rowList1=new ArrayList<Integer>();
		ArrayList<Integer>colList1=new ArrayList<Integer>();
		ArrayList<String>valueList1=new ArrayList<String>();
		for(int i=76;i<82;i++)rowList1.add(i);
		colList1.add(10);
		valueList1.add(fullName);
		upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
		assignData.setData(fileAssignRule,defaultSheet,isUseFile);
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		
		ArrayList<String>superregionList=new ArrayList<String>();
		ArrayList<String>regionList=new ArrayList<String>();
		ArrayList<String>countryList=new ArrayList<String>();
		ArrayList<String>businessList=new ArrayList<String>();
		ArrayList<String>productList=new ArrayList<String>();
		ArrayList<String>shipToList=new ArrayList<String>();
		ArrayList<String>soldToList=new ArrayList<String>();
		ArrayList<String>customeShipList=new ArrayList<String>();
		ArrayList<String>customeSoldList=new ArrayList<String>();
		for(int i=76;i<82;i++){
			info("Create rule:"+i);
			superregionList.add(assignData.getSuperRegionByType(i));
			regionList.add(assignData.getRegionByType(i));
			countryList.add(assignData.getCountryByType(i));
			businessList.add(assignData.getBusinessUnitByType(i));
			productList.add(assignData.getProductLineByType(i));
			shipToList.add(assignData.getShipToAMIDByType(i));
			soldToList.add(assignData.getSoldToAMIDByType(i));
			customeShipList.add(assignData.getCustomerNameShipToByType(i));
			customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
			String assignTo=assignData.getAssignToByType(i);
			info("Go to Add Assignment Rules page");
			assignRule.goToAddRule();
			info("Add a new assignment rule");
			assignRule.add(
					assignData.getSuperRegionByType(i), 
					assignData.getRegionByType(i), 
					assignData.getCountryByType(i), 
					assignData.getBusinessUnitByType(i), 
					assignData.getProductLineByType(i), 
					assignData.getShipToAMIDByType(i), 
					assignData.getSoldToAMIDByType(i), 
					assignData.getCustomerNameShipToByType(i), 
					assignData.getcustomerNameSoldToByType(i), 
					assignTo);
			info("Verify that the new assigment rule is added successfully");
			assignRule.verifyNotiMesgSuccess();
			
		}
		
		info("Go to Order page");
		navMenu.goToDataImport();
		dataImportHome.goToOrderReport();
		info("Upload a order file");
		order.upload(PATH_TESTDATA, fileOrder);
		info("Go to view detail");
		order.goToViewDetail();
		
		order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
		for(int j=0;j<superregionList.size();j++)
			order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
		
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Go to Fallout Order");
		opeHome.goToFalloutOrders();
		info("Go to Unassigned Orders tab");
		falloutHomepage.goToUnassignedOrdersTab();
		info("Verify that the orders is displayed in the list");
		falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
		for(int j=0;j<superregionList.size();j++)
		   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
	}
	
	/**
	* Test case ID:VAN-2133
	* Test case name:"Assign a Order by EMEA/SHIP TO assignment rules"
	* Precondition:
	* Test details:
	* Test Step 1:"Go to <test_environment>"
	* Test Step 2:"Login with user A"
	* Test Data:"HPID: 2222Pass: Test@123456"
	* Expected Result:"Home page is shown"
	* Test Step 3:"Click on [Data Import] link on the left menu"
	* Expected Result:"Data Import Home page is shown"
	* Test Step 4:"Click on [Order Import] button"
	* Expected Result:"Order page is shown"
	* Test Step 5:"Import a Order file"
	* Test Data:"Attached file bellow"
	* Expected Result:"The file is imported successfully"
	* Test Step 6:"Click on [View] button"
	* Expected Result:"All data in the columns is displayed with correct data in the excel"
	* Test Step 7:"Check [Assignment] column"
	* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
	* Test Step 8:"Check [RTM] column"
	* Expected Result:"This column is blank"
	* Test Step 9:"Check [ATR type] column"
	* Expected Result:"This column is blank"
	* Test Step 10:"Check data in all remain columns"
	* Expected Result:"All data is displayed correctly as in the excel file"
	* Test Step 11:"Click on [Operation] link on the left menu"
	* Expected Result:"Operation page home is shown"
	* Test Step 12:"Click on [Fallout Orders] button"
	* Expected Result:"Fallout Summaries page is shown"
	* Test Step 13:"Click on [Unassigned Orders] tab"
	* Expected Result:"The tab's content is shown"
	* Test Step 14:"Check Unassigned Orders list"
	* Expected Result:"The order is not displayed in the list"
	 * @throws Exception 
	*/
	@Test
	public void VAN2133_AssignAOrderByEMEASOLDTOAssignmentRules() throws Exception{
		info("Assign a Order by EMEA/SOLD TO assignment rules");
		info("Create assignment rules");
		info("Create a new rsr user");
		String fullName="user"+getRandomNumber();
		String email =fullName+"@gmail.com";
		String hpID=getRandomNumber();
		String telephone=getRandomNumber();
		String city=getRandomString();
		String country=getRandomString();
		String region =getRandomString();
		String role = roleData.getContentByType(5);
		info("Go to Organization home page");
		navMenu.goToOrganization();
		info("Go to User list page");
		orgHome.goToUser();
		info("Go to Add user page");
		user.goToAddUser();
		info("Add a new user");
		user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
		user.save();
		Utils.pause(3000);
		
		info("Update Sold to  and ship tocolumn in Order file");
		ArrayList<Integer>rowList=new ArrayList<Integer>();
		ArrayList<Integer>colList=new ArrayList<Integer>();
		ArrayList<String>valueList=new ArrayList<String>();
		String soldToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
		String shipToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
		String prevDoc=getLongRandomNumber();
		for(int i=1;i<7;i++)rowList.add(i);
		colList.add(4);
		colList.add(8);
		colList.add(49);
		valueList.add(soldToAMIDLevel2ID);
		valueList.add(shipToAMIDLevel2ID);
		valueList.add(prevDoc);
		String fileOrder= fData.getAttachFileByArrayTypeRandom(75);
		String path2=PATH_TESTDATA+fileOrder;
		upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
		
		String fileAssignRule=assignRuleFilePath;
		info("Update sold to and ship to column for rules from 70->76");
		ArrayList<Integer>rowList2=new ArrayList<Integer>();
		ArrayList<Integer>colList2=new ArrayList<Integer>();
		ArrayList<String>valueList2=new ArrayList<String>();
		for(int i=70;i<76;i++)rowList2.add(i);
		colList2.add(6);
		valueList2.add(shipToAMIDLevel2ID);
		upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
		
		info("Update assign to column for rules from 70->76");
		ArrayList<Integer>rowList1=new ArrayList<Integer>();
		ArrayList<Integer>colList1=new ArrayList<Integer>();
		ArrayList<String>valueList1=new ArrayList<String>();
		for(int i=70;i<76;i++)rowList1.add(i);
		colList1.add(10);
		valueList1.add(fullName);
		upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
		assignData.setData(fileAssignRule,defaultSheet,isUseFile);
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		
		ArrayList<String>superregionList=new ArrayList<String>();
		ArrayList<String>regionList=new ArrayList<String>();
		ArrayList<String>countryList=new ArrayList<String>();
		ArrayList<String>businessList=new ArrayList<String>();
		ArrayList<String>productList=new ArrayList<String>();
		ArrayList<String>shipToList=new ArrayList<String>();
		ArrayList<String>soldToList=new ArrayList<String>();
		ArrayList<String>customeShipList=new ArrayList<String>();
		ArrayList<String>customeSoldList=new ArrayList<String>();
		for(int i=70;i<76;i++){
			info("Create rule:"+i);
			superregionList.add(assignData.getSuperRegionByType(i));
			regionList.add(assignData.getRegionByType(i));
			countryList.add(assignData.getCountryByType(i));
			businessList.add(assignData.getBusinessUnitByType(i));
			productList.add(assignData.getProductLineByType(i));
			shipToList.add(assignData.getShipToAMIDByType(i));
			soldToList.add(assignData.getSoldToAMIDByType(i));
			customeShipList.add(assignData.getCustomerNameShipToByType(i));
			customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
			String assignTo=assignData.getAssignToByType(i);
			info("Go to Add Assignment Rules page");
			assignRule.goToAddRule();
			info("Add a new assignment rule");
			assignRule.add(
					assignData.getSuperRegionByType(i), 
					assignData.getRegionByType(i), 
					assignData.getCountryByType(i), 
					assignData.getBusinessUnitByType(i), 
					assignData.getProductLineByType(i), 
					assignData.getShipToAMIDByType(i), 
					assignData.getSoldToAMIDByType(i), 
					assignData.getCustomerNameShipToByType(i), 
					assignData.getcustomerNameSoldToByType(i), 
					assignTo);
			info("Verify that the new assigment rule is added successfully");
			assignRule.verifyNotiMesgSuccess();
			
		}
		
		info("Go to Order page");
		navMenu.goToDataImport();
		dataImportHome.goToOrderReport();
		info("Upload a order file");
		order.upload(PATH_TESTDATA, fileOrder);
		info("Go to view detail");
		order.goToViewDetail();
		
		order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
		for(int j=0;j<superregionList.size();j++)
			order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
		
		info("Go to Operation page");
		navMenu.goToOperation();
		info("Go to Fallout Order");
		opeHome.goToFalloutOrders();
		info("Go to Unassigned Orders tab");
		falloutHomepage.goToUnassignedOrdersTab();
		info("Verify that the orders is displayed in the list");
		falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
		for(int j=0;j<superregionList.size();j++)
		   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
	}
		
		/**
		* Test case ID:VAN-1695
		* Test case name:"Fallout check with Negative Order"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Order_FalloutCheck_NegativeOrder"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to View detail imported Order at step 8"
		* Expected Result:"The order is assigned normanly"
		* Test Step 10:"Go to Pipeline list"
		* Expected Result:"The page is shown"
		* Test Step 11:"Find the contracts by Order.[Sales Order Indentifier]"
		* Expected Result:"Order.[Sales Order Identifier] is not shown in the column"
		* Test Step 12:"Go to [Operation] page"
		* Expected Result:"The page is shown"
		* Test Step 13:"Go to [Fallout Summaries] tab"
		* Expected Result:"The order at step 8 is calculated in [Fallout - Negative Orders] row"
		* Test Step 14:"Go to [Negative Order] tab"
		* Expected Result:"The combined orders at step 8 is shown in the list with correct data."
		 * @throws Exception 
		*/
		@Test
		public void VAN1695_FalloutCheckWithNegativeOrder() throws Exception{
			info("Fallout check with Negative Order");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String funLoc= getLongRandomNumber();
			String saleID1= getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(74);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(48);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(5);
			colList.add(38);
			valueList.add(expDocNbr);
			valueList.add(funLoc);
			upData.updateByArray(path1, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(1);
			colList2.add(18);
			colList2.add(47);
			valueList2.add(saleID1);
			valueList2.add(funLoc);
			upData.updateByArray(path2, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList3=new ArrayList<Integer>();
			ArrayList<Integer>colList3=new ArrayList<Integer>();
			ArrayList<String>valueList3=new ArrayList<String>();
			rowList3.add(2);
			colList3.add(18);
			colList3.add(47);
			valueList3.add(saleID1);
			valueList3.add(funLoc);
			upData.updateByArray(path2, defaultSheet,rowList3, colList3, valueList3, isUseFile);
			
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Net Sales Order US Dollar Amount from Order file");
			String netSalesOrderUSDollarAmount1=orderData.netSalesOrderUSDollarAmount.get(0);
			String netSalesOrderUSDollarAmount2=orderData.netSalesOrderUSDollarAmount.get(1);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			order.delete();
			Utils.pause(3000);
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR1=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR1:"+saleOrderIDATR1);
			
			info("Go to Operation page");
			navMenu.expandCollapseMenu();
			navMenu.goToOperation();
			opeHome.goToFalloutOrders();
			
			info("Verify that the money of No previous Doc is shown in the list");
			int totalNetSalesOrderUSDollarAmount=Integer.parseInt(netSalesOrderUSDollarAmount1)+
					Integer.parseInt(netSalesOrderUSDollarAmount2);
			String total=String.valueOf(totalNetSalesOrderUSDollarAmount).replace("-","");
			falloutHomepage.verifyData("Fallout - Negative Order","($"+total+".00)");
			info("Open Negative Order tab");
			falloutHomepage.goToNegativeOrdersTab();
			info("Verify that the order is shown in the tab's content");
			fallNegaOrders.verifyData(saleID1);
			if(saleOrderIDATR1!=null) assert false;
		}
		/**
		* Test case ID:VAN-1694
		* Test case name:"Fallout check with Duplicate Prev Doc Number"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Order_FalloutCheck_ByDuplicatedPreviousDoc"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to View detail imported Order at step 8"
		* Expected Result:"The order is assigned normanly"
		* Test Step 10:"Go to Pipeline list"
		* Expected Result:"The page is shown"
		* Test Step 11:"Find the contracts by [Sales Order Indentifier]"
		* Expected Result:"Order.[Sales Order Identifier] is not shown in the column"
		* Test Step 12:"Go to [Operation] page"
		* Expected Result:"The page is shown"
		* Test Step 13:"Go to [Fallout Summaries] tab"
		* Expected Result:"The order at step 8 is calculated in [Fallout - Duplicate Previous Doc] row"
		* Test Step 14:"Go to [Duplicated Previous Doc] tab"
		* Expected Result:"The order at step 8 is shown in the list with correct data"
		 * @throws Exception 
		*/
		@Test
		public void VAN1694_FalloutCheckWithDuplicatePrevDocNumber() throws Exception{
			info("Fallout check with Duplicate Prev Doc Number");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String expDocNbr1= getLongRandomNumber();
			String funLoc= getLongRandomNumber();
			String prevDoc= getLongRandomNumber();
			String saleID1= getLongRandomNumber();
			String saleID2= getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(73);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(46);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(5);
			colList.add(38);
			valueList.add(expDocNbr);
			valueList.add(funLoc);
			upData.updateByArray(path1, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(2);
			colList1.add(5);
			colList1.add(38);
			valueList1.add(expDocNbr1);
			valueList1.add(funLoc);
			upData.updateByArray(path1, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(1);
			colList2.add(18);
			colList2.add(47);
			colList2.add(49);
			valueList2.add(saleID1);
			valueList2.add(funLoc);
			valueList2.add(prevDoc);
			upData.updateByArray(path2, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList3=new ArrayList<Integer>();
			ArrayList<Integer>colList3=new ArrayList<Integer>();
			ArrayList<String>valueList3=new ArrayList<String>();
			rowList3.add(2);
			colList3.add(18);
			colList3.add(47);
			colList3.add(49);
			valueList3.add(saleID2);
			valueList3.add(funLoc);
			valueList3.add(prevDoc);
			upData.updateByArray(path2, defaultSheet,rowList3, colList3, valueList3, isUseFile);
			
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Net Sales Order US Dollar Amount from Order file");
			String netSalesOrderUSDollarAmount1=orderData.netSalesOrderUSDollarAmount.get(0);
			String netSalesOrderUSDollarAmount2=orderData.netSalesOrderUSDollarAmount.get(1);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			order.delete();
			Utils.pause(3000);
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR1=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR1:"+saleOrderIDATR1);
			
			this.driver.navigate().refresh();
			pipeList.search(5,expDocNbr1);
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR2=pipeList.getDataFromPipeline(144, expDocNbr1);
			info("saleOrderIDATR2:"+saleOrderIDATR2);
			
			info("Go to Operation page");
			navMenu.expandCollapseMenu();
			navMenu.goToOperation();
			opeHome.goToFalloutOrders();
			
			info("Verify that the money of No previous Doc is shown in the list");
			double totalNetSalesOrderUSDollarAmount=Double.parseDouble(netSalesOrderUSDollarAmount1)+
					Double.parseDouble(netSalesOrderUSDollarAmount2);
			String total=String.valueOf(totalNetSalesOrderUSDollarAmount);
			StringBuffer str= new StringBuffer(total);
			str.insert(1,",");
			falloutHomepage.verifyData("Fallout - Duplicate Previous Doc","$"+str.toString());
			info("Open Duplicated Previous Doc tab");
			falloutHomepage.goToDuplicatedPreviousDocTab();
			info("Verify that the order is shown in the tab's content");
			falloutDupPrevDoc.verifyData(saleID1);
			falloutDupPrevDoc.verifyData(saleID2);
			if(saleOrderIDATR1!=null) assert false;
			if(saleOrderIDATR2!=null) assert false;
		}
		/**
		* Test case ID:VAN-1692
		* Test case name:"Fallout check with No Previous Doc"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Order_FalloutCheck_ByNoPreviousDoc"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to View detail imported Order at step 8"
		* Expected Result:"The order is assigned normanly"
		* Test Step 10:"Go to Pipeline list"
		* Expected Result:"The page is shown"
		* Test Step 11:"Find the contracts by [Sales Order Indentifier]"
		* Expected Result:"Order.[Sales Order Identifier] is not shown in the column"
		* Test Step 12:"Go to [Operation] page/ Fallout Orders"
		* Expected Result:"The page is shown"
		* Test Step 13:"Go to [No Previous Doc] tab"
		* Expected Result:"The order at step 8 is shown in the list"
		* Test Step 14:"Go to [Fallout Summaries] tab"
		* Expected Result:"The order at step 8 is calculated in [Fallout - No Previous Doc] row"
		 * @throws Exception 
		*/
		@Test
		public void VAN1692_FalloutCheckWithNoPreviousDoc() throws Exception{
			info("Fallout check with No Previous Doc");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String funLoc= getLongRandomNumber();
			String saleID= getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(47);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(5);
			colList.add(38);
			valueList.add(expDocNbr);
			valueList.add(funLoc);
			upData.updateByArray(path1, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(18);
			colList1.add(47);
			valueList1.add(saleID);
			valueList1.add(funLoc);
			upData.updateByArray(path2, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Net Sales Order US Dollar Amount from Order file");
			String netSalesOrderUSDollarAmount=orderData.netSalesOrderUSDollarAmount.get(0);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			order.delete();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR:"+saleOrderIDATR);
			
			info("Go to Operation page");
			navMenu.expandCollapseMenu();
			navMenu.goToOperation();
			opeHome.goToFalloutOrders();
			
			info("Verify that the money of No previous Doc is shown in the list");
			falloutHomepage.verifyData("Fallout - No Previous Doc","$"+netSalesOrderUSDollarAmount);
			info("Open No previous tab");
			falloutHomepage.goToNoPreviousDocTab();
			info("Verify that the order is shown in the No previous tab");
			fallNoPrevDoc.verifyData(saleID);
			if(saleOrderIDATR==null) assert true;
			
		}
		/**
		* Test case ID:VAN-1686
		* Test case name:"Multiple close date with total amount is zero"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Import_Orders_Import_Reconciled"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list"
		* Expected Result:"Pipeline list is shown"
		* Test Step 10:"Find orders that are dummy line by Sales Order Identifier"
		* Expected Result:"The order is reconciled with correct contract"
		* Test Step 11:"Go to [Order Reports] button"
		* Expected Result:"the page is shown"
		* Test Step 12:"Import the order"
		* Test Data:"Attached Order file bellow: Import_Orders_SumZero"
		* Expected Result:"The file is imported successfully"
		* Test Step 13:"Go to Pipeline list"
		* Expected Result:"The page is shown"
		* Test Step 14:"Find the contracts by [Sales Order Indentifier]"
		* Expected Result:"The contract
		* PENDING: THIS FEATURE WILL BE REMOVE IN THE FUTURE
		*/
		@Test(groups="pending")
		public void VAN1686_MultipleCloseDateWithTotalAmountIsZero(){
		}
		/**
		* Test case ID:VAN-1683
		* Test case name:"Dummy line if order was reconciled before"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow:ATR_Imported_DummyLine"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Import_Orders_Import_Reconciled"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list"
		* Expected Result:"Pipeline list is shown"
		* Test Step 10:"Find orders that are dummy line by Sales Order Identifier"
		* Expected Result:"The order is reconciled with correct contract"
		* Test Step 11:"Go to [Order Reports] button"
		* Expected Result:"the page is shown"
		* Test Step 12:"Import the order"
		* Test Data:"Attached Order file bellow: Import_Orders_Import_DummyLine"
		* Expected Result:"The file is imported successfully"
		* Test Step 13:"Go to Pipeline list"
		* Expected Result:"The page is shown"
		* Test Step 14:"Find orders that are dummy line by Sales Order Identifier"
		* Expected Result:"2 orders at step 12 is shown in this list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1683_DummyLineIfOrderWasReconciledBefore() throws Exception{
			info("Dummy line if order was reconciled before");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String firstDateCurrentMonth= getFirstDayOfMonth("dd/MM/yyyy");
			info("firstDateCurrentMonth:"+firstDateCurrentMonth);
			String currentDate= getCurrentDate("dd/MM/yyyy");
			info("currentDate:"+currentDate);
			String lastDateCurrentMonth=getLastDayOfMonth("dd/MM/yyyy");
			info("lastDateCurrentMonth:"+lastDateCurrentMonth);
			String fileATR= fData.getAttachFileByArrayTypeRandom(3);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(28);
			String fileOrder2= fData.getAttachFileByArrayTypeRandom(27);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			String path3=PATH_TESTDATA+fileOrder2;
			
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(19);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(firstDateCurrentMonth);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Financial Close Calendar Date from Order file1");
			String financialCloseCalendarDate1=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(18);
			colList1.add(19);
			colList1.add(49);
			valueList1.add(expDocNbr);
			valueList1.add(currentDate);
			valueList1.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(2);
			colList2.add(18);
			colList2.add(19);
			colList2.add(49);
			valueList2.add(expDocNbr);
			valueList2.add(lastDateCurrentMonth);
			valueList2.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			OrderDatabase orderData = new OrderDatabase();
			orderData.setData(path3, defaultSheet, isUseFile);
			
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate2=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			String financialCloseCalendarDate3=orderData.financialCloseCalendarDateDDMMYYYYCode.get(1);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(143,expDocNbr);
			
			String comment="Reversal";
			
			info("Compare date after reconciled");
			pipeList.verifyData(116, expDocNbr, financialCloseCalendarDate1,comment);
			
			info("Verify that all order are merged to one dumyline");
			waitForAndGetElement(pipeList.ELEMENT_PIPELINE_DATA_ROW.replace("$number","0"),2000,1);
			waitForElementNotPresent(pipeList.ELEMENT_PIPELINE_DATA_ROW.replace("$number","1"),2000,1);
			
			info("Go to Data import");
			navMenu.expandCollapseMenu();
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder2);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(143,expDocNbr);
			
			String commentDumyline="dummy line generated by system";
			info("Compare date after reconciled");
			pipeList.verifyData(116, expDocNbr, financialCloseCalendarDate1,comment);
			pipeList.verifyData(116, expDocNbr, financialCloseCalendarDate2,commentDumyline);
			pipeList.verifyData(116, expDocNbr, financialCloseCalendarDate3,commentDumyline);
			
		}
		/**
		* Test case ID:VAN-1682
		* Test case name:"Dummy line if order was not reconciled before"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list"
		* Expected Result:"Pipeline list is shown"
		* Test Step 10:"Find orders that are dummy line by Sales Order Identifier"
		* Expected Result:"All 3 orders are mapping to one order with close date of oldest order."
		 * @throws Exception 
		*/
		@Test
		public void VAN1682_DummyLineIfOrderWasNotReconciledBefore() throws Exception{
			info("Dummy line if order was not reconciled before");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String firstDateCurrentMonth= getFirstDayOfMonth("dd/MM/yyyy");
			info("firstDateCurrentMonth:"+firstDateCurrentMonth);
			String currentDate= getCurrentDate("dd/MM/yyyy");
			info("currentDate:"+currentDate);
			
			String fileATR= fData.getAttachFileByArrayTypeRandom(3);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(27);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(19);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(firstDateCurrentMonth);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(2);
			colList1.add(18);
			colList1.add(19);
			colList1.add(49);
			valueList1.add(expDocNbr);
			valueList1.add(currentDate);
			valueList1.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate1=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			String financialCloseCalendarDate2=orderData.financialCloseCalendarDateDDMMYYYYCode.get(1);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(143,expDocNbr);
			
			info("Get Close Date from Pipeline list");
			String closeDateATR=pipeList.getDataFromPipeline(116, expDocNbr);
			info("closeDateATR:"+closeDateATR);
			info("financialCloseCalendarDate1:"+financialCloseCalendarDate1);
			info("financialCloseCalendarDate2:"+financialCloseCalendarDate2);
			
			info("Get Quote Prepaid from Pipeline list");
			String commentATR=pipeList.getDataFromPipeline(125, expDocNbr);
			String commentDumyline="dummy line generated by system";
			info("commentATR:"+commentATR);
			
			
			info("Compare date after reconciled");
			pipeList.compareData(closeDateATR,financialCloseCalendarDate1);
			pipeList.compareData(commentATR,commentDumyline);
			
			info("Verify that all order are merged to one dumyline");
			waitForAndGetElement(pipeList.ELEMENT_PIPELINE_DATA_ROW.replace("$number","0"),2000,1);
			waitForElementNotPresent(pipeList.ELEMENT_PIPELINE_DATA_ROW.replace("$number","1"),2000,1);
			
		}
		/**
		* Test case ID:VAN-1681
		* Test case name:"Not reconciled with Multiple close dates"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipleline"
		* Expected Result:"The page is shown"
		* Test Step 10:"Find the contract at step 5"
		* Expected Result:"The contact is shown in pipeline list"
		* Test Step 11:"Find ATR.[Sale Order Identifier]column"
		* Expected Result:"Not any orders ID have Order.[Sale Order Identifier] is displayed in this column"
		* Test Step 12:"Click on [Operation] link"
		* Expected Result:"The page is shown"
		* Test Step 13:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout summaries page is shown"
		* Test Step 14:"Click on [Multiple Close Dates] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 15:"Check the orders are imported at step 8"
		* Expected Result:"The orders are displayed in the list"
		* PENDING: THIS CASE WILL BE REMOVED IN THE FEATURE.
		*/
		@Test(groups="pending")
		public void VAN1681_NotReconciledWithMultipleCloseDates(){
		}
		/**
		* Test case ID:VAN-1676
		* Test case name:"Reconcile many Orders with ATR renewal"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow: Import_Orders_Renewal_Reconciled_1"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list and find the contract at step 5"
		* Expected Result:"Pipeline list is shown and The contract is shown in the list"
		* Test Step 10:"ATR.[Sale Order Identifier]"
		* Test Data:1231313
		* Expected Result:"Order.[Sale Order Identifier]"
		* Test Step 11:"ATR.[Renewal Status] column"
		* Test Data:WON
		* Expected Result:"this column is marked as ""WON"""
		* Test Step 12:"ATR.[Renewal Status Calculated]"
		* Test Data:WON
		* Expected Result:"this column is marked as ""WON"""
		* Test Step 13:"Go to [Data Import] page again"
		* Expected Result:"The page is shown"
		* Test Step 14:"Go to [Order Report] page"
		* Expected Result:"The page is shown"
		* Test Step 15:"Import a Order file"
		* Test Data:"Attached Order file bellow: Import_Orders_Renewal_Reconciled_2"
		* Expected Result:"The file is imported successfully"
		* Test Step 16:"Go to Pipeline page again"
		* Expected Result:"The page is shown"
		* Test Step 17:"Find the contract at step 5"
		* Expected Result:"The contract is shown in the pipeline list"
		* Test Step 18:"ATR.[Closed Date]"
		* Expected Result:"Order.[Financial Close Calendar Date]is oldest data of the orders"
		* Test Step 19:"ATR.[Quote Prepaid]"
		* Expected Result:"Order.[Billing Description]of first order that is imported"
		* Test Step 20:"ATR.[Legacy Sales Order]"
		* Expected Result:"Order.[Legacy Sales Order]of first order that is imported"
		* Test Step 21:"ATR.[Customer Purchase Order Identifier]"
		* Expected Result:"Order.[Customer Purchase Order Identifier]of first order that is imported"
		* Test Step 22:"ATR.[Document Currency Code]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Currency Code]"
		* Test Step 23:"ATR.[Quote Currency]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Currency Code]"
		* Test Step 24:"ATR.[Quote Start Date]"
		* Expected Result:"Order.[Start]of first order that is imported"
		* Test Step 25:"ATR.[Quote End Date]"
		* Expected Result:"Order.[End]of first order that is imported"
		* Test Step 26:"ATR.[RTS Plus Penalty Fee LCL FX]"
		* Test Data:10
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount] with Order.[RTS/NPA Sku] is marked as ""Yes"""
		* Test Step 27:"ATR.[RTS Plus Penalty Fee USD]"
		* Test Data:7
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount] with Order.[RTS/NPA Sku] is marked as ""Yes"""
		* Test Step 28:"ATR.[Foundation Total LCL FX]"
		* Test Data:"109
		* Expected Result:846"
		* Test Step 29:"ATR.[Current FX ]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Exchange Rate]"
		* Test Step 30:"ATR.[Foundation USD]"
		* Test Data:"77
		* Expected Result:662"
		* Test Step 31:"ATR.[Annualised Foundation LCL FX]"
		* Test Data:"109
		* Expected Result:846"
		* Test Step 32:"ATR.[Annualised Foundation USD]"
		* Test Data:"77
		* Expected Result:662"
		* Test Step 33:"ATR.[Valid for CQ]"
		* Expected Result:"this column will be marked as ""Valid"""
		* Test Step 34:"ATR.[Modified By]"
		* Expected Result:"the one who uploaded order report"
		* Test Step 35:"ATR.[Modified Date]"
		* Expected Result:"the date on which order report is uploaded"
		 * @throws Exception 
		*/
		@Test
		public void VAN1676_ReconcileManyOrdersWithATRRenewal() throws Exception{
			info("Reconcile many Orders with ATR renewal");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String firstDateCurrentMonth= getFirstDayOfMonth("dd/MM/yyyy");
			info("firstDateCurrentMonth:"+firstDateCurrentMonth);
			String midleDateCurrentMonth= getMiddleDayOfMonth("dd/MM/yyyy");
			info("MidleDateCurrentMonth:"+midleDateCurrentMonth);
			String currentDate=getCurrentDate("dd/MM/yyyy");
			info("currentDate:"+currentDate);
			String lastDateCurrentMonth= getLastDayOfMonth("dd/MM/yyyy");
			info("LastDateCurrentMonth:"+lastDateCurrentMonth);
			
			String fileATR= fData.getAttachFileByArrayTypeRandom(23);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(72);
			String fileOrder2= fData.getAttachFileByArrayTypeRandom(31);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			String path3=PATH_TESTDATA+fileOrder2;
			
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(19);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(firstDateCurrentMonth);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get data from Order file 1");
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate1=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			
			info("Get Billing Description from Order file");
			String billingDes1=orderData.billingDescription.get(0);
			
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID1=orderData.legacySalesOrderIdentifier.get(0);
			
			info("Get Customer Purchase Order Identifier from Order file");
			String customerPurchaseOrderID1=orderData.customerPurchaseOrderIdentifier.get(0);
			
			info("Get Document Currency Code from Order file");
			String documentCurrencyCode1=orderData.documentCurrencyCode.get(0);
			
			info("Get Start date from Order file");
			String[]dateStartList1=orderData.start.get(0).split("/");
			String startDate1=dateStartList1[1]+"/"+dateStartList1[0]+"/"+dateStartList1[2];
			
			info("Get End date from Order file");
			String[]dateEndList1=orderData.end.get(0).split("/");
			String endDate1=dateEndList1[1]+"/"+dateEndList1[0]+"/"+dateEndList1[2];
			
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount1 = orderData.getDataNumberNoConvert(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount1 = orderData.getDataNumberNoConvert(orderData.netSalesOrderUSDollarAmount.get(0));
			
			info("Get SUM Annualised Order Value LC from Order file");
			double annualisedOrderValueLC1=orderData.getDataNumberNoConvert(orderData.annualisedOrderValueLC.get(0));
			
			info("Get SUM Annualised Order Value $ from Order file");
			double annualisedOrderValue$1=orderData.getDataNumberNoConvert(orderData.annualisedOrderValue$.get(0));
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR:"+saleOrderIDATR);
			info("expDocNbr:"+expDocNbr);
			
			info("Get Renewal Status from Pipeline list");
			String renewalStatusATR=pipeList.getDataFromPipeline(115, expDocNbr);
			info("renewalStatusATR:"+renewalStatusATR);
			
			info("Get Renewal Status Caculated from Pipeline list");
			String renewalStatusCaculatedATR=pipeList.getDataFromPipeline(137, expDocNbr);
			info("renewalStatusCaculatedATR:"+renewalStatusCaculatedATR);
			
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(18);
			colList1.add(19);
			colList1.add(49);
			valueList1.add(expDocNbr);
			valueList1.add(midleDateCurrentMonth);
			valueList1.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(2);
			colList2.add(18);
			colList2.add(19);
			colList2.add(49);
			valueList2.add(expDocNbr);
			valueList2.add(currentDate);
			valueList2.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList3=new ArrayList<Integer>();
			ArrayList<Integer>colList3=new ArrayList<Integer>();
			ArrayList<String>valueList3=new ArrayList<String>();
			rowList3.add(3);
			colList3.add(18);
			colList3.add(19);
			colList3.add(49);
			valueList3.add(expDocNbr);
			valueList3.add(lastDateCurrentMonth);
			valueList3.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList3, colList3, valueList3, isUseFile);
			orderData = new OrderDatabase();
			orderData.setData(path3, defaultSheet, isUseFile);
			
			
			info("Get data from Order file 2");
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate2=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			String financialCloseCalendarDate3=orderData.financialCloseCalendarDateDDMMYYYYCode.get(1);
			String financialCloseCalendarDate4=orderData.financialCloseCalendarDateDDMMYYYYCode.get(2);
			info("financialCloseCalendarDate2:"+financialCloseCalendarDate2);
			info("financialCloseCalendarDate3:"+financialCloseCalendarDate3);
			info("financialCloseCalendarDate4:"+financialCloseCalendarDate4);
			info("Get Billing Description from Order file");
			String billingDes2=orderData.billingDescription.get(0);
			String billingDes3=orderData.billingDescription.get(1);
			String billingDes4=orderData.billingDescription.get(2);
			info("billingDes2:"+billingDes2);
			info("billingDes3:"+billingDes3);
			info("billingDes4:"+billingDes4);
			info("Get Customer Purchase Order Identifier from Order file");
			String customerPurchaseOrderID2=orderData.customerPurchaseOrderIdentifier.get(0);
			String customerPurchaseOrderID3=orderData.customerPurchaseOrderIdentifier.get(1);
			String customerPurchaseOrderID4=orderData.customerPurchaseOrderIdentifier.get(2);
			info("customerPurchaseOrderID2:"+customerPurchaseOrderID2);
			info("customerPurchaseOrderID2:"+customerPurchaseOrderID3);
			info("customerPurchaseOrderID2:"+customerPurchaseOrderID4);
			
			info("Get Start date from Order file");
			String[]dateStartList2=orderData.start.get(0).split("/");
			String[]dateStartList3=orderData.start.get(1).split("/");
			String[]dateStartList4=orderData.start.get(2).split("/");
			String startDate2=dateStartList2[1]+"/"+dateStartList2[0]+"/"+dateStartList2[2];
			String startDate3=dateStartList3[1]+"/"+dateStartList3[0]+"/"+dateStartList2[2];
			String startDate4=dateStartList4[1]+"/"+dateStartList4[0]+"/"+dateStartList4[2];
			
			info("Get End date from Order file");
			String[]dateEndList2=orderData.end.get(0).split("/");
			String[]dateEndList3=orderData.end.get(1).split("/");
			String[]dateEndList4=orderData.end.get(2).split("/");
			String endDate2=dateEndList2[1]+"/"+dateEndList2[0]+"/"+dateEndList2[2];
			String endDate3=dateEndList3[1]+"/"+dateEndList3[0]+"/"+dateEndList3[2];
			String endDate4=dateEndList4[1]+"/"+dateEndList4[0]+"/"+dateEndList4[2];
			
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID2=orderData.legacySalesOrderIdentifier.get(0);
			String legacySalesOrderID3=orderData.legacySalesOrderIdentifier.get(1);
			String legacySalesOrderID4=orderData.legacySalesOrderIdentifier.get(2);
			info("legacySalesOrderID2:"+legacySalesOrderID2);
			info("legacySalesOrderID3:"+legacySalesOrderID3);
			info("legacySalesOrderID4:"+legacySalesOrderID4);
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount2 = orderData.getDataOriginNumber(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			double netSalesOrderDocCurrencyAmount3 = orderData.getDataOriginNumber(orderData.netSalesOrderDocumentCurrencyAmount.get(1));
			double netSalesOrderDocCurrencyAmount4 = orderData.getDataOriginNumber(orderData.netSalesOrderDocumentCurrencyAmount.get(2));
			info("netSalesOrderDocCurrencyAmount2:"+netSalesOrderDocCurrencyAmount2);
			info("netSalesOrderDocCurrencyAmount3:"+netSalesOrderDocCurrencyAmount3);
			info("netSalesOrderDocCurrencyAmount4:"+netSalesOrderDocCurrencyAmount4);
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount2 = orderData.getDataOriginNumber(orderData.netSalesOrderUSDollarAmount.get(0));
			double netSalesOrderUSDollarAmount3 = orderData.getDataOriginNumber(orderData.netSalesOrderUSDollarAmount.get(1));
			double netSalesOrderUSDollarAmount4 = orderData.getDataOriginNumber(orderData.netSalesOrderUSDollarAmount.get(2));
			info("netSalesOrderUSDollarAmount2:"+netSalesOrderUSDollarAmount2);
			info("netSalesOrderUSDollarAmount3:"+netSalesOrderUSDollarAmount3);
			info("netSalesOrderUSDollarAmount4:"+netSalesOrderUSDollarAmount4);
			
			info("Get SUM Annualised Order Value LC from Order file");
			double annualisedOrderValueLC2=orderData.getDataOriginNumber(orderData.annualisedOrderValueLC.get(0));
			double annualisedOrderValueLC3=orderData.getDataOriginNumber(orderData.annualisedOrderValueLC.get(1));
			double annualisedOrderValueLC4=orderData.getDataOriginNumber(orderData.annualisedOrderValueLC.get(2));
			
			info("Get SUM Annualised Order Value $ from Order file");
			double annualisedOrderValue$2=orderData.getDataOriginNumber(orderData.annualisedOrderValue$.get(0));
			double annualisedOrderValue$3=orderData.getDataOriginNumber(orderData.annualisedOrderValue$.get(1));
			double annualisedOrderValue$4=orderData.getDataOriginNumber(orderData.annualisedOrderValue$.get(2));
			
			
			info("Go to Data import");
			navMenu.expandCollapseMenu();
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder2);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Close Date from Pipeline list");
			String closeDateATR=pipeList.getDataFromPipeline(116, expDocNbr);
			info("closeDateATR:"+closeDateATR);
			info("financialCloseCalendarDate1:"+financialCloseCalendarDate1);
			info("financialCloseCalendarDate2:"+financialCloseCalendarDate2);
			info("financialCloseCalendarDate3:"+financialCloseCalendarDate3);
			info("financialCloseCalendarDate4:"+financialCloseCalendarDate4);
			
			info("Get Quote Prepaid from Pipeline list");
			String quotePrepaidATR=pipeList.getDataFromPipeline(108, expDocNbr);
			info("quotePrepaidATR:"+quotePrepaidATR);
			info("billingDes1:"+billingDes1);
			
			info("Get Legacy Sales Order Identifier from Pipeline list");
			String legacySalesOrderIDATR=pipeList.getDataFromPipeline(145, expDocNbr);
			info("legacySalesOrderIDATR:"+legacySalesOrderIDATR);
			info("legacySalesOrderID1:"+legacySalesOrderID1);
			
			info("Get Customer Purchase Order Identifier from Pipeline list");
			String customerPuchaseOrderIDATR=pipeList.getDataFromPipeline(148, expDocNbr);
			info("customerPuchaseOrderIDATR:"+customerPuchaseOrderIDATR);
			info("customerPurchaseOrderID1:"+customerPurchaseOrderID1);
			
			info("Get Quote Currency from Pipeline list");
			String quoteCurrencyATR=pipeList.getDataFromPipeline(113, expDocNbr);
			info("quoteCurrencyATR:"+quoteCurrencyATR);
			info("documentCurrencyCode1:"+documentCurrencyCode1);
			
			info("Get Quote Start date from Pipeline list");
			String quoteStartATR=pipeList.getDataFromPipeline(106, expDocNbr);
			info("quoteStartATR:"+quoteStartATR);
			info("startDate1:"+startDate1);
			info("startDate2:"+startDate2);
			info("startDate3:"+startDate3);
			info("startDate4:"+startDate4);
			
			info("Get Quote End date from Pipeline list");
			String quoteEndtATR=pipeList.getDataFromPipeline(107, expDocNbr);
			info("quoteEndtATR:"+quoteEndtATR);
			info("endDate1:"+endDate1);
			info("endDate2:"+endDate2);
			info("endDate3:"+endDate3);
			info("endDate4:"+endDate4);
			
			info("Get RTS Plus Penalty Fee LCL FX from Pipeline list");
			double rtsPlusPenaltyFeeLCLFXATR=pipeList.getDataNumber(109, expDocNbr);
			double totalNetSalesOrderDocCurrencyAmountYes=Math.round(netSalesOrderDocCurrencyAmount1+netSalesOrderDocCurrencyAmount3)*1000;
			info("rtsPlusPenaltyFeeLCLFXATR:"+rtsPlusPenaltyFeeLCLFXATR);
			info("netSalesOrderDocCurrencyAmount1:"+netSalesOrderDocCurrencyAmount1);
			info("netSalesOrderDocCurrencyAmount3:"+netSalesOrderDocCurrencyAmount3);
			info("totalNetSalesOrderDocCurrencyAmountYes:"+totalNetSalesOrderDocCurrencyAmountYes);
			
			info("Get RTS Plus Penalty Fee USD from Pipeline list");
			double rtsPlusPenaltyFeeUSD=pipeList.getDataNumber(128, expDocNbr);
			double totalNetSalesOrderUSDollarAmountYes=Math.round(netSalesOrderUSDollarAmount1+netSalesOrderUSDollarAmount3)*1000;
			info("rtsPlusPenaltyFeeUSD:"+rtsPlusPenaltyFeeUSD);
			info("netSalesOrderUSDollarAmount1:"+netSalesOrderUSDollarAmount1);
			info("netSalesOrderUSDollarAmount1:"+netSalesOrderUSDollarAmount3);
			info("totalNetSalesOrderUSDollarAmountYes:"+totalNetSalesOrderUSDollarAmountYes);
			
			info("Get Foundation Total LCL FX from Pipeline list");
			double foundationTotalLCLFXATR=pipeList.getDataNumber(110, expDocNbr);
			double totalNetSalesOrderDocCurrencyAmountNo=Math.round(netSalesOrderDocCurrencyAmount2+netSalesOrderDocCurrencyAmount4);
			info("foundationTotalLCLFXATR:"+foundationTotalLCLFXATR);
			info("netSalesOrderDocCurrencyAmount2:"+netSalesOrderDocCurrencyAmount2);
			info("netSalesOrderDocCurrencyAmount4:"+netSalesOrderDocCurrencyAmount4);
			info("totalNetSalesOrderDocCurrencyAmountNo:"+totalNetSalesOrderDocCurrencyAmountNo);
			
			info("Get Annualised Foundation LCL FX from Pipeline list");
			double annualisedFoundationLCLFXATR=pipeList.getDataNumber(132, expDocNbr);
			double totalAnnualisedOrderValueLC=Math.round(annualisedOrderValueLC1+annualisedOrderValueLC2+annualisedOrderValueLC3+annualisedOrderValueLC4);
			info("annualisedFoundationLCLFXATR:"+annualisedFoundationLCLFXATR);
			info("annualisedOrderValueLC1:"+annualisedOrderValueLC1);
			info("annualisedOrderValueLC2:"+annualisedOrderValueLC2);
			info("annualisedOrderValueLC3:"+annualisedOrderValueLC3);
			info("annualisedOrderValueLC4:"+annualisedOrderValueLC4);
			info("totalAnnualisedOrderValueLC:"+totalAnnualisedOrderValueLC);
			
			info("Get Foundation USD from Pipeline list");
			double foundationUSDATR=pipeList.getDataNumber(129, expDocNbr);
			double totalNetSalesOrderUSDollarAmountNo=Math.round(netSalesOrderUSDollarAmount2+netSalesOrderUSDollarAmount4);
			info("foundationUSDATR:"+foundationUSDATR);
			info("netSalesOrderUSDollarAmount2:"+netSalesOrderUSDollarAmount2);
			info("netSalesOrderUSDollarAmount4:"+netSalesOrderUSDollarAmount4);
			info("totalNetSalesOrderUSDollarAmountNo:"+totalNetSalesOrderUSDollarAmountNo);
			
			info("Get Annualised Foundation USD from Pipeline list");
			double annualisedFoundationUSDATR=pipeList.getDataNumber(133, expDocNbr);
			double totalAnnualisedOrderValue$=Math.round(annualisedOrderValue$1+annualisedOrderValue$2+annualisedOrderValue$3+annualisedOrderValue$4);
			info("annualisedFoundationUSDATR:"+annualisedFoundationUSDATR);
			info("annualisedOrderValue$1:"+annualisedOrderValue$1);
			info("annualisedOrderValue$2:"+annualisedOrderValue$2);
			info("annualisedOrderValue$3:"+annualisedOrderValue$3);
			info("annualisedOrderValue$4:"+annualisedOrderValue$4);
			info("totalAnnualisedOrderValue$:"+totalAnnualisedOrderValue$);
			
			info("Get Valid for CQ from Pipeline list");
			String validForCQATR=pipeList.getDataFromPipeline(138,expDocNbr);
			info("validForCQATR:"+validForCQATR);
			
			info("Compare date after reconciled");
			pipeList.compareData(saleOrderIDATR,expDocNbr);
			pipeList.compareData(renewalStatusATR,"WON");
			pipeList.compareData(renewalStatusCaculatedATR,"WON");
			pipeList.compareData(closeDateATR,financialCloseCalendarDate1);
			pipeList.compareData(quotePrepaidATR,billingDes1);
			pipeList.compareData(legacySalesOrderIDATR,legacySalesOrderID2);
			pipeList.compareData(customerPuchaseOrderIDATR,customerPurchaseOrderID2);
			pipeList.compareData(documentCurrencyCode1,documentCurrencyCode1);
			pipeList.compareData(quoteCurrencyATR,documentCurrencyCode1);
			pipeList.compareData(quoteStartATR,startDate1);
			pipeList.compareData(quoteEndtATR,endDate1);
			pipeList.compareNumber(foundationTotalLCLFXATR,totalNetSalesOrderDocCurrencyAmountNo);
			pipeList.compareNumber(annualisedFoundationLCLFXATR,totalAnnualisedOrderValueLC);
			pipeList.compareNumber(foundationUSDATR,totalNetSalesOrderUSDollarAmountNo);
			pipeList.compareNumber(rtsPlusPenaltyFeeLCLFXATR,totalNetSalesOrderDocCurrencyAmountYes);
			pipeList.compareNumber(rtsPlusPenaltyFeeUSD,totalNetSalesOrderUSDollarAmountYes);
			pipeList.compareNumber(annualisedFoundationUSDATR,totalAnnualisedOrderValue$);
			pipeList.compareData(validForCQATR,"VALID");
		}
		/**
		* Test case ID:VAN-1675
		* Test case name:"Reconcile many Orders with ATR anniversary"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached file bellow: Import_Orders_Export_Multiple_Reconciled_1"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list and find the contract at step 5"
		* Expected Result:"Pipeline list is shown and The contract is shown in the list"
		* Test Step 10:"ATR.[Sale Order Identifier]"
		* Expected Result:"Order.[Sale Order Identifier]"
		* Test Step 11:"Order.[Renewal Status]"
		* Expected Result:"This column is marked as ""WON"""
		* Test Step 12:"Order.[Renewal Status Calculated]"
		* Expected Result:"This column is marked as ""WON"""
		* Test Step 13:"Go to [Data Import] again"
		* Expected Result:"The page is shown"
		* Test Step 14:"Click on [Order Reports] button"
		* Expected Result:"Order page is shown"
		* Test Step 15:"Import a Order file"
		* Test Data:"Attached Oder file bellow: Import_Orders_Export_Multiple_Reconciled_2"
		* Expected Result:"The file is imported successfully"
		* Test Step 16:"Go to the Pipeline list again"
		* Expected Result:"The page is shown"
		* Test Step 17:"Find the contract at step 5"
		* Expected Result:"The contract is shown in pipeline list"
		* Test Step 18:"ATR.[Closed Date]"
		* Expected Result:"Order.[Financial Close Calendar Date] is oldest date of the orders are imported"
		* Test Step 19:"ATR.[Quote Prepaid]"
		* Expected Result:"Order.[Billing Description] of first order that is imported"
		* Test Step 20:"ATR.[Legacy Sales Order Identifier]"
		* Expected Result:"Order.[Legacy Sales Order Identifier] of first order that is imported"
		* Test Step 21:"ATR.[Customer Purchase Order Identifier]"
		* Expected Result:"Order.[Customer Purchase Order Identifier]of first order that is imported"
		* Test Step 22:"ATR.[Quote Currency]"
		* Expected Result:"Order.[Document Currency Code]of first order that is imported"
		* Test Step 23:"ATR.[Foundation Total LCL FX]"
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount]"
		* Test Step 24:"ATR.[Annualised Foundation LCL FX]"
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount]."
		* Test Step 25:"ATR.[Foundation USD]"
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount]."
		* Test Step 26:"ATR.[Annualised Foundation USD]"
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount]."
		* Test Step 27:"ATR.[Current FX]"
		* Expected Result:"Order.[Document Exchange Rate]of first order that is imported"
		* Test Step 28:"ATR.[Total FCST LCL FX]"
		* Expected Result:"ATR.[Total Quote LCL FX]"
		* Test Step 29:"ATR.[Total FCST Value USD]"
		* Expected Result:"ATR.[Total Contract Value USD]"
		* Test Step 30:"ATR.[Valid for CQ]"
		* Expected Result:"this column will be marked as ""Valid"""
		* Test Step 31:"ATR.[Modified By]"
		* Expected Result:"the one who uploaded order report"
		* Test Step 32:"ATR.[Modified Date]"
		* Expected Result:"the date on which order report is uploaded"
		 * @throws Exception 
		*/
		@Test
		public void VAN1675_ReconcileManyOrdersWithATRAnniversary() throws Exception{
			info("Reconcile many Orders with ATR anniversary");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String firstDateCurrentMonth= getFirstDayOfMonth("dd/MM/yyyy");
			info("firstDateCurrentMonth:"+firstDateCurrentMonth);
			String midleDateCurrentMonth= getCurrentDate("dd/MM/yyyy");
			info("MidleDateCurrentMonth:"+midleDateCurrentMonth);
			String lastDateCurrentMonth= getLastDayOfMonth("dd/MM/yyyy");
			info("LastDateCurrentMonth:"+lastDateCurrentMonth);
			
			String fileATR= fData.getAttachFileByArrayTypeRandom(12);
			String fileOrder1= fData.getAttachFileByArrayTypeRandom(25);
			String fileOrder2= fData.getAttachFileByArrayTypeRandom(26);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder1;
			String path3=PATH_TESTDATA+fileOrder2;
			
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			
			info("Update exp doc number for Order file 1");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(19);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(firstDateCurrentMonth);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get data from Order file 1");
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate1=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			
			info("Get Billing Description from Order file");
			String billingDes1=orderData.billingDescription.get(0);
			
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID1=orderData.legacySalesOrderIdentifier.get(0);
			
			info("Get Customer Purchase Order Identifier from Order file");
			String customerPurchaseOrderID1=orderData.customerPurchaseOrderIdentifier.get(0);
			
			info("Get Document Currency Code from Order file");
			String documentCurrencyCode1=orderData.documentCurrencyCode.get(0);
			
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount1 = orderData.getDataNumberNoConvert(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount1 = orderData.getDataNumberNoConvert(orderData.netSalesOrderUSDollarAmount.get(0));
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder1);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR:"+saleOrderIDATR);
			info("expDocNbr:"+expDocNbr);
			
			info("Get Renewal Status from Pipeline list");
			String renewalStatusATR=pipeList.getDataFromPipeline(115, expDocNbr);
			info("renewalStatusATR:"+renewalStatusATR);
			
			info("Get Renewal Status Caculated from Pipeline list");
			String renewalStatusCaculatedATR=pipeList.getDataFromPipeline(137, expDocNbr);
			info("renewalStatusCaculatedATR:"+renewalStatusCaculatedATR);
			
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(18);
			colList1.add(19);
			colList1.add(49);
			valueList1.add(expDocNbr);
			valueList1.add(midleDateCurrentMonth);
			valueList1.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update exp doc number for Order file 2");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(2);
			colList2.add(18);
			colList2.add(19);
			colList2.add(49);
			valueList2.add(expDocNbr);
			valueList2.add(lastDateCurrentMonth);
			valueList2.add(expDocNbr);
			upData.updateByArray(path3, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			orderData = new OrderDatabase();
			orderData.setData(path3, defaultSheet, isUseFile);
			
			
			info("Get data from Order file 2");
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate2=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			String financialCloseCalendarDate3=orderData.financialCloseCalendarDateDDMMYYYYCode.get(1);
			info("Get Billing Description from Order file");
			String billingDes2=orderData.billingDescription.get(0);
			String billingDes3=orderData.billingDescription.get(1);
			info("billingDes2:"+billingDes2);
			info("billingDes3:"+billingDes3);
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID2=orderData.legacySalesOrderIdentifier.get(0);
			String legacySalesOrderID3=orderData.legacySalesOrderIdentifier.get(1);
			info("legacySalesOrderID2:"+legacySalesOrderID2);
			info("legacySalesOrderID3:"+legacySalesOrderID3);
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount2 = orderData.getDataNumberNoConvert(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			double netSalesOrderDocCurrencyAmount3 = orderData.getDataNumberNoConvert(orderData.netSalesOrderDocumentCurrencyAmount.get(1));
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount2 = orderData.getDataNumberNoConvert(orderData.netSalesOrderUSDollarAmount.get(0));
			double netSalesOrderUSDollarAmount3 = orderData.getDataNumberNoConvert(orderData.netSalesOrderUSDollarAmount.get(1));
			
			
			info("Go to Data import");
			navMenu.expandCollapseMenu();
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder2);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Close Date from Pipeline list");
			String closeDateATR=pipeList.getDataFromPipeline(116, expDocNbr);
			info("closeDateATR:"+closeDateATR);
			info("financialCloseCalendarDate1:"+financialCloseCalendarDate1);
			info("financialCloseCalendarDate2:"+financialCloseCalendarDate2);
			info("financialCloseCalendarDate3:"+financialCloseCalendarDate3);
			
			info("Get Quote Prepaid from Pipeline list");
			String quotePrepaidATR=pipeList.getDataFromPipeline(108, expDocNbr);
			info("quotePrepaidATR:"+quotePrepaidATR);
			info("billingDes1:"+billingDes1);
			
			info("Get Legacy Sales Order Identifier from Pipeline list");
			String legacySalesOrderIDATR=pipeList.getDataFromPipeline(145, expDocNbr);
			info("legacySalesOrderIDATR:"+legacySalesOrderIDATR);
			info("legacySalesOrderID1:"+legacySalesOrderID1);
			
			info("Get Customer Purchase Order Identifier from Pipeline list");
			String customerPuchaseOrderIDATR=pipeList.getDataFromPipeline(148, expDocNbr);
			info("customerPuchaseOrderIDATR:"+customerPuchaseOrderIDATR);
			info("customerPurchaseOrderID1:"+customerPurchaseOrderID1);
			
			info("Get Quote Currency from Pipeline list");
			String quoteCurrencyATR=pipeList.getDataFromPipeline(113, expDocNbr);
			info("quoteCurrencyATR:"+quoteCurrencyATR);
			info("documentCurrencyCode1:"+documentCurrencyCode1);
			
			info("Get Foundation Total LCL FX from Pipeline list");
			double foundationTotalLCLFXATR=pipeList.getDataNumber(110, expDocNbr);
			info("foundationTotalLCLFXATR:"+foundationTotalLCLFXATR);
			info("netSalesOrderDocCurrencyAmount1:"+netSalesOrderDocCurrencyAmount1);
			info("netSalesOrderDocCurrencyAmount2:"+netSalesOrderDocCurrencyAmount2);
			info("netSalesOrderDocCurrencyAmount3:"+netSalesOrderDocCurrencyAmount3);
			
			info("Get Annualised Foundation LCL FX from Pipeline list");
			double annualisedFoundationLCLFXATR=pipeList.getDataNumber(132, expDocNbr);
			info("annualisedFoundationLCLFXATR:"+annualisedFoundationLCLFXATR);
			info("netSalesOrderDocCurrencyAmount1:"+netSalesOrderDocCurrencyAmount1);
			info("netSalesOrderDocCurrencyAmount2:"+netSalesOrderDocCurrencyAmount2);
			info("netSalesOrderDocCurrencyAmount3:"+netSalesOrderDocCurrencyAmount3);
			
			double totalNetSalesOrderDocCurrencyAmount=netSalesOrderDocCurrencyAmount1
					+netSalesOrderDocCurrencyAmount2
					+netSalesOrderDocCurrencyAmount3;
			info("totalNetSalesOrderDocCurrencyAmount:"+totalNetSalesOrderDocCurrencyAmount);
			
			info("Get Foundation USD from Pipeline list");
			double foundationUSDATR=pipeList.getDataNumber(129, expDocNbr);
			info("foundationUSDATR:"+foundationUSDATR);
			info("netSalesOrderUSDollarAmount1:"+netSalesOrderUSDollarAmount1);
			info("netSalesOrderUSDollarAmount2:"+netSalesOrderUSDollarAmount2);
			info("netSalesOrderUSDollarAmount3:"+netSalesOrderUSDollarAmount3);
			
			info("Get Annualised Foundation USD from Pipeline list");
			double annualisedFoundationUSDATR=pipeList.getDataNumber(133, expDocNbr);
			info("annualisedFoundationUSDATR:"+annualisedFoundationUSDATR);
			info("netSalesOrderUSDollarAmount1:"+netSalesOrderUSDollarAmount1);
			info("netSalesOrderUSDollarAmount2:"+netSalesOrderUSDollarAmount2);
			info("netSalesOrderUSDollarAmount3:"+netSalesOrderUSDollarAmount3);
			
			double totalNetSalesOrderUSDollarAmount=netSalesOrderUSDollarAmount1
					+netSalesOrderUSDollarAmount2
					+netSalesOrderUSDollarAmount3;
			
			info("totalNetSalesOrderUSDollarAmount:"+totalNetSalesOrderUSDollarAmount);
			
			info("Get Total FCST LCL FX from Pipeline list");
			double totalFCSTLCLFXATR=pipeList.getDataNumber(112, expDocNbr);
			info("totalFCSTLCLFXATR:"+totalFCSTLCLFXATR);
			
			info("Get Total Quote LCL FX from Pipeline list");
			double totalQuoteLCLFXATR=pipeList.getDataNumber(111, expDocNbr);
			info("totalQuoteLCLFXATR:"+totalQuoteLCLFXATR);
			
			info("Get Total FCST Value USD from Pipeline list");
			double totalFCSTValueUSDATR=pipeList.getDataNumber(131, expDocNbr);
			info("totalFCSTValueUSDATR:"+totalFCSTValueUSDATR);
			
			info("Get Total Contract Value USD from Pipeline list");
			double totalContractValueUSDATR=pipeList.getDataNumber(130, expDocNbr);
			info("totalContractValueUSDATR:"+totalContractValueUSDATR);
			
			info("Get Valid for CQ from Pipeline list");
			String validForCQATR=pipeList.getDataFromPipeline(138,expDocNbr);
			info("validForCQATR:"+validForCQATR);
			
			info("Compare date after reconciled");
			pipeList.compareData(saleOrderIDATR,expDocNbr);
			pipeList.compareData(renewalStatusATR,"WON");
			pipeList.compareData(renewalStatusCaculatedATR,"WON");
			pipeList.compareData(closeDateATR,financialCloseCalendarDate1);
			pipeList.compareData(quotePrepaidATR,billingDes1);
			pipeList.compareData(legacySalesOrderIDATR,legacySalesOrderID1);
			pipeList.compareData(customerPuchaseOrderIDATR,customerPurchaseOrderID1);
			pipeList.compareData(quoteCurrencyATR,documentCurrencyCode1);
			pipeList.compareNumber(foundationTotalLCLFXATR,totalNetSalesOrderDocCurrencyAmount);
			pipeList.compareNumber(annualisedFoundationLCLFXATR,totalNetSalesOrderDocCurrencyAmount);
			pipeList.compareNumber(foundationUSDATR,totalNetSalesOrderUSDollarAmount);
			pipeList.compareNumber(annualisedFoundationUSDATR,totalNetSalesOrderUSDollarAmount);
			pipeList.compareNumber(totalFCSTLCLFXATR,totalQuoteLCLFXATR);
			pipeList.compareNumber(totalFCSTValueUSDATR,totalContractValueUSDATR);
			pipeList.compareData(validForCQATR,"VALID");
		}
		/**
		* Test case ID:VAN-1671
		* Test case name:"Delete all imported orders"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [Delete data] button"
		* Expected Result:"A confirm popup is shown"
		* Test Step 7:"Click on [OK] button"
		* Expected Result:"All imported Orders are deleted.*All fallout and unassigned orders list also are deleted.*Still stay at the Order page"
		* Test Step 8:"Click on [Cancel] button"
		* Expected Result:"All imported Order will be kept.*All fallout and unassigned orders are kept.*Still stay at the Order page"
		*/
		@Test
		public void VAN1671_DeleteAllImportedOrders(){
			info("Delete all imported orders");
			String fileOrder= fData.getAttachFileByArrayTypeRandom(30);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder);
			Utils.pause(3000);
			
			info("Delete all data");
			order.delete();
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout page");
			opeHome.goToFalloutOrders();
			info("Check Fallout summaries page");
			falloutHomepage.verifyTotalFalloutSummaries("$0.00");
			falloutHomepage.verifyTotalFalloutSummaries("0.00 %");
			falloutHomepage.verifyTotalFalloutSummaries("0");
			
			info("Go to Unassigned Order tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that all data is deleted");
			falloutUnassignedOrders.verifyNoDisplayData();
			
			info("Go to No Previous Doc tab");
			falloutHomepage.goToNoPreviousDocTab();
			info("Verify that all data is deleted");
			fallNoPrevDoc.verifyNoDisplayData();
			
			info("Go to Dupl. Previous Doc tab");
			falloutHomepage.goToDuplicatedPreviousDocTab();
			info("Verify that all data is deleted");
			falloutDupPrevDoc.verifyNoDisplayData();
			
			info("Go to Negative order tab");
			falloutHomepage.goToNegativeOrdersTab();
			info("Verify that all data is deleted");
			fallNegaOrders.verifyNoDisplayData();
			
			info("Go to Multi. close Date tab");
			falloutHomepage.goToMultipleCloseDatesTab();
			info("Verify that all data is deleted");
			fallMultiCloseDate.verifyNoDisplayData();
			
			info("Go to Not Reconciled tab");
			falloutHomepage.goToNotReconciledTab();
			info("Verify that all data is deleted");
			fallNoReconciled.verifyNoDisplayData();
		}
		/**
		* Test case ID:VAN-1670
		* Test case name:"Reconcile a Order with ATR renewal"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list and find the contract at step 5"
		* Expected Result:"Pipeline list is shown and The contract is shown in the list"
		* Test Step 10:"ATR.[Sale Order Identifier]"
		* Test Data:2142853621
		* Expected Result:"Order.[Sale Order Identifier]"
		* Test Step 11:"ATR.[Renewal Status] column"
		* Test Data:WON
		* Expected Result:"this column is marked as ""WON"""
		* Test Step 12:"ATR.[Renewal Status Calculated]"
		* Test Data:WON
		* Expected Result:"this column is marked as ""WON"""
		* Test Step 13:"ATR.[Closed Date]"
		* Test Data:24/02/2016
		* Expected Result:"Order.[Financial Close Calendar Date]"
		* Test Step 14:"ATR.[Quote Prepaid]"
		* Test Data:Yes
		* Expected Result:"Order.[Billing Description]"
		* Test Step 15:"ATR.[Legacy Sales Order]"
		* Test Data:902142853621
		* Expected Result:"Order.[Legacy Sales Order]"
		* Test Step 16:"ATR.[Customer Purchase Order Identifier]"
		* Test Data:"Chantelle Klasema"
		* Expected Result:"Order.[Customer Purchase Order Identifier]"
		* Test Step 17:"ATR.[Document Currency Code]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Currency Code]"
		* Test Step 18:"ATR.[Quote Currency]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Currency Code]"
		* Test Step 19:"ATR.[Quote Start Date]"
		* Test Data:01/05/2016
		* Expected Result:Order.[Start]
		* Test Step 20:"ATR.[Quote End Date]"
		* Test Data:30/09/2016
		* Expected Result:Order.[End]
		* Test Step 21:"ATR.[RTS Plus Penalty Fee LCL FX]"
		* Test Data:10
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount] with Order.[RTS/NPA Sku] is marked as ""Yes"""
		* Test Step 22:"ATR.[RTS Plus Penalty Fee USD]"
		* Test Data:7
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount] with Order.[RTS/NPA Sku] is marked as ""Yes"""
		* Test Step 23:"ATR.[Foundation Total LCL FX]"
		* Test Data:Empty
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount] with Order.[RTS/NPA Sku] is marked as ""No"""
		* Test Step 24:"ATR.[Current FX ]"
		* Test Data:AUD
		* Expected Result:"Order.[Document Exchange Rate]"
		* Test Step 25:"ATR.[Foundation USD]"
		* Test Data:0
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount] with Order.[RTS/NPA Sku] is marked as ""No"""
		* Test Step 26:"ATR.[Annualised Foundation LCL FX]"
		* Test Data:0
		* Expected Result:"SUM Order.[Annualised Order Value LC]"
		* Test Step 27:"ATR.[Annualised Foundation USD]"
		* Test Data:0
		* Expected Result:"SUM Order.[Annualised Order Value $]"
		* Test Step 28:"ATR.[Valid for CQ]"
		* Expected Result:"this column will be marked as ""Valid"""
		* Test Step 29:"ATR.[Modified By]"
		* Expected Result:"the one who uploaded order report"
		* Test Step 30:"ATR.[Modified Date]"
		* Expected Result:"the date on which order report is uploaded"
		 * @throws Exception 
		*/
		@Test
		public void VAN1670_ReconcileAOrderWithATRRenewal() throws Exception{
			info("Reconcile a Order with ATR renewal");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String currentDate= getCurrentDate("dd/MM/yyyy");
			String fileATR= fData.getAttachFileByArrayTypeRandom(23);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(30);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(19);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(currentDate);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			
			info("Get Billing Description from Order file");
			String billingDes=orderData.billingDescription.get(0);
			
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID=orderData.legacySalesOrderIdentifier.get(0);
			
			info("Get Customer Purchase Order Identifier from Order file");
			String customerPurchaseOrderID=orderData.customerPurchaseOrderIdentifier.get(0);
			
			info("Get Document Currency Code from Order file");
			String documentCurrencyCode=orderData.documentCurrencyCode.get(0);
			
			info("Get Start date from Order file");
			String[]dateStartList=orderData.start.get(0).split("/");
			String startDate=dateStartList[1]+"/"+dateStartList[0]+"/"+dateStartList[2];
			
			info("Get End date from Order file");
			String[]dateEndList=orderData.end.get(0).split("/");
			String endDate=dateEndList[1]+"/"+dateEndList[0]+"/"+dateEndList[2];
			
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount=orderData.getDataNumber(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount=orderData.getDataNumber(orderData.netSalesOrderUSDollarAmount.get(0));
			
			info("Get SUM Annualised Order Value LC from Order file");
			double annualisedOrderValueLC=orderData.getDataNumberNoConvert(orderData.annualisedOrderValueLC.get(0));
			
			info("Get SUM Annualised Order Value $ from Order file");
			double annualisedOrderValue$=orderData.getDataNumberNoConvert(orderData.annualisedOrderValue$.get(0));
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR:"+saleOrderIDATR);
			info("expDocNbr:"+expDocNbr);
			
			info("Get Renewal Status from Pipeline list");
			String renewalStatusATR=pipeList.getDataFromPipeline(115, expDocNbr);
			info("renewalStatusATR:"+renewalStatusATR);
			
			info("Get Renewal Status Caculated from Pipeline list");
			String renewalStatusCaculatedATR=pipeList.getDataFromPipeline(137, expDocNbr);
			info("renewalStatusCaculatedATR:"+renewalStatusCaculatedATR);
			
			info("Get Close Date from Pipeline list");
			String closeDateATR=pipeList.getDataFromPipeline(116, expDocNbr);
			info("closeDateATR:"+closeDateATR);
			info("financialCloseCalendarDate:"+financialCloseCalendarDate);
			
			info("Get Quote Prepaid from Pipeline list");
			String quotePrepaidATR=pipeList.getDataFromPipeline(108, expDocNbr);
			info("quotePrepaidATR:"+quotePrepaidATR);
			info("billingDes:"+billingDes);
			
			info("Get Legacy Sales Order Identifier from Pipeline list");
			String legacySalesOrderIDATR=pipeList.getDataFromPipeline(145, expDocNbr);
			info("legacySalesOrderIDATR:"+legacySalesOrderIDATR);
			info("legacySalesOrderID:"+legacySalesOrderID);
			
			info("Get Customer Purchase Order Identifier from Pipeline list");
			String customerPuchaseOrderIDATR=pipeList.getDataFromPipeline(148, expDocNbr);
			info("customerPuchaseOrderIDATR:"+customerPuchaseOrderIDATR);
			info("customerPurchaseOrderID:"+customerPurchaseOrderID);
			
			info("Get Document Currency Code from Pipeline list");
			String docCurrencyCodeATR=pipeList.getDataFromPipeline(146, expDocNbr);
			info("docCurrencyCodeATR:"+docCurrencyCodeATR);
			info("documentCurrencyCode:"+documentCurrencyCode);
			
			info("Get Quote Currency from Pipeline list");
			String quoteCurrencyATR=pipeList.getDataFromPipeline(113, expDocNbr);
			info("quoteCurrencyATR:"+quoteCurrencyATR);
			info("documentCurrencyCode:"+documentCurrencyCode);
			
			info("Get Quote Start date from Pipeline list");
			String quoteStartATR=pipeList.getDataFromPipeline(106, expDocNbr);
			info("quoteStartATR:"+quoteStartATR);
			info("startDate:"+startDate);
			
			info("Get Quote End date from Pipeline list");
			String quoteEndtATR=pipeList.getDataFromPipeline(107, expDocNbr);
			info("quoteEndtATR:"+quoteEndtATR);
			info("endDate:"+endDate);
			
			info("Get RTS Plus Penalty Fee LCL FX from Pipeline list");
			double rtsPlusPenaltyFeeLCLFXATR=pipeList.getDataNumber(109, expDocNbr);
			info("rtsPlusPenaltyFeeLCLFXATR:"+rtsPlusPenaltyFeeLCLFXATR);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderDocCurrencyAmount);
			
			info("Get RTS Plus Penalty Fee USD from Pipeline list");
			double rtsPlusPenaltyFeeUSD=pipeList.getDataNumber(128, expDocNbr);
			info("rtsPlusPenaltyFeeUSD:"+rtsPlusPenaltyFeeUSD);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderUSDollarAmount);
			
			info("Get Foundation Total LCL FX from Pipeline list");
			double foundationTotalLCLFXATR=pipeList.getDataNumber(110, expDocNbr);
			info("foundationTotalLCLFXATR:"+foundationTotalLCLFXATR);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderDocCurrencyAmount);
			
			info("Get Annualised Foundation LCL FX from Pipeline list");
			double annualisedFoundationLCLFXATR=pipeList.getDataNumber(132, expDocNbr);
			info("annualisedFoundationLCLFXATR:"+annualisedFoundationLCLFXATR);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderDocCurrencyAmount);
			
			info("Get Foundation USD from Pipeline list");
			double foundationUSDATR=pipeList.getDataNumber(129, expDocNbr);
			info("foundationUSDATR:"+foundationUSDATR);
			info("netSalesOrderUSDollarAmount:"+netSalesOrderUSDollarAmount);
			
			info("Get Annualised Foundation USD from Pipeline list");
			double annualisedFoundationUSDATR=pipeList.getDataNumber(133, expDocNbr);
			info("annualisedFoundationUSDATR:"+annualisedFoundationUSDATR);
			info("netSalesOrderUSDollarAmount:"+netSalesOrderUSDollarAmount);
			
			info("Get Valid for CQ from Pipeline list");
			String validForCQATR=pipeList.getDataFromPipeline(138,expDocNbr);
			info("validForCQATR:"+validForCQATR);
			
			
			info("Compare date after reconciled");
			pipeList.compareData(saleOrderIDATR,expDocNbr);
			pipeList.compareData(renewalStatusATR,"WON");
			pipeList.compareData(renewalStatusCaculatedATR,"WON");
			pipeList.compareData(closeDateATR,financialCloseCalendarDate);
			pipeList.compareData(quotePrepaidATR,billingDes);
			pipeList.compareData(legacySalesOrderIDATR,legacySalesOrderID);
			pipeList.compareData(customerPuchaseOrderIDATR,customerPurchaseOrderID);
			pipeList.compareData(docCurrencyCodeATR,documentCurrencyCode);
			pipeList.compareData(quoteCurrencyATR,documentCurrencyCode);
			pipeList.compareData(quoteStartATR,startDate);
			pipeList.compareData(quoteEndtATR,endDate);
			pipeList.compareNumber(rtsPlusPenaltyFeeLCLFXATR,netSalesOrderDocCurrencyAmount);
			pipeList.compareNumber(rtsPlusPenaltyFeeUSD,netSalesOrderUSDollarAmount);
			pipeList.compareNumber(foundationTotalLCLFXATR,0.0);
			pipeList.compareNumber(annualisedFoundationLCLFXATR,annualisedOrderValueLC);
			pipeList.compareNumber(foundationUSDATR,0.0);
			pipeList.compareNumber(annualisedFoundationUSDATR,annualisedOrderValue$);
			pipeList.compareData(validForCQATR,"VALID");
		}
		/**
		* Test case ID:VAN-1668
		* Test case name:"Reconcile a Order with ATR anniversary"
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
		* Test Step 5:"Import ATR file"
		* Test Data:"Attached ATR file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Go to [Data Import] page"
		* Expected Result:"The page is shown"
		* Test Step 7:"Click on [Order Report] button"
		* Expected Result:"Order import page is shown"
		* Test Step 8:"Import Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 9:"Go to Pipeline list and find the contract at step 5"
		* Expected Result:"Pipeline list is shown and The contract is shown in the list"
		* Test Step 10:"ATR.[Sale Order Identifier]"
		* Expected Result:"Order.[Sale Order Identifier]"
		* Test Step 11:"Order.[Renewal Status]"
		* Expected Result:"This column is marked as ""WON"""
		* Test Step 12:"Order.[Renewal Status Calculated]"
		* Expected Result:"This column is marked as ""WON"""
		* Test Step 13:"ATR.[Closed Date]"
		* Expected Result:"Order.[Financial Close Calendar Date]"
		* Test Step 14:"ATR.[Quote Prepaid]"
		* Expected Result:"Order.[Billing Description]"
		* Test Step 15:"ATR.[Legacy Sales Order Identifier]"
		* Expected Result:"Order.[Legacy Sales Order Identifier]"
		* Test Step 16:"ATR.[Customer Purchase Order Identifier]"
		* Expected Result:"Order.[Customer Purchase Order Identifier]"
		* Test Step 17:"ATR.[Quote Currency]"
		* Expected Result:"Order.[Document Currency Code]"
		* Test Step 18:"ATR.[Foundation Total LCL FX]"
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount]"
		* Test Step 19:"ATR.[Annualised Foundation LCL FX]"
		* Expected Result:"SUM Order.[Net Sales Order Document Currency Amount]."
		* Test Step 20:"ATR.[Foundation USD]"
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount]."
		* Test Step 21:"ATR.[Annualised Foundation USD]"
		* Expected Result:"SUM Order.[Net Sales Order US Dollar Amount]."
		* Test Step 22:"ATR.[Current FX]"
		* Expected Result:"Order.[Document Exchange Rate]"
		* Test Step 23:"ATR.[Total FCST LCL FX]"
		* Expected Result:"ATR.[Total Quote LCL FX]"
		* Test Step 24:"ATR.[Total FCST Value USD]"
		* Expected Result:"ATR.[Total Contract Value USD]"
		 * @throws Exception 
		*/
		@Test
		public void VAN1668_ReconcileAOrderWithATRAnniversary() throws Exception{
			info("Reconcile a Order with ATR anniversary");
			info("Prepare data test");
			String expDocNbr= getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(13);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(24);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,expDocNbr, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(18);
			colList.add(49);
			valueList.add(expDocNbr);
			valueList.add(expDocNbr);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			orderData.setData(path2, defaultSheet, isUseFile);
			
			info("Get Sales Order Indentifier from Order file");
			info("Get Financial Close Calendar Date from Order file");
			String financialCloseCalendarDate=orderData.financialCloseCalendarDateDDMMYYYYCode.get(0);
			info("Get Billing Description from Order file");
			String billingDes=orderData.billingDescription.get(0);
			info("Get Legacy Sales Order Identifier from Order file");
			String legacySalesOrderID=orderData.legacySalesOrderIdentifier.get(0);
			info("Get Customer Purchase Order Identifier from Order file");
			String customerPurchaseOrderID=orderData.customerPurchaseOrderIdentifier.get(0);
			info("Get Document Currency Code from Order file");
			String documentCurrencyCode=orderData.documentCurrencyCode.get(0);
			info("Get SUM Net Sales Order Document Currency Amount from Order file");
			double netSalesOrderDocCurrencyAmount = orderData.getDataNumberNoConvert(orderData.netSalesOrderDocumentCurrencyAmount.get(0));
			info("Get SUM Net Sales Order US Dollar Amount from Order file");
			double netSalesOrderUSDollarAmount = orderData.getDataNumberNoConvert(orderData.netSalesOrderUSDollarAmount.get(0));
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA,fileATR);
			Utils.pause(3000);
			
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,fileOrder);
			Utils.pause(3000);
			
			info("Go to Pipeline list");
			navMenu.goToPipeline();
			pipeList.search(5,expDocNbr);
			
			info("Get Sale Order Indentifier from Pipeline list");
			String saleOrderIDATR=pipeList.getDataFromPipeline(144, expDocNbr);
			info("saleOrderIDATR:"+saleOrderIDATR);
			info("expDocNbr:"+expDocNbr);
			
			info("Get Renewal Status from Pipeline list");
			String renewalStatusATR=pipeList.getDataFromPipeline(115, expDocNbr);
			info("renewalStatusATR:"+renewalStatusATR);
			
			info("Get Renewal Status Caculated from Pipeline list");
			String renewalStatusCaculatedATR=pipeList.getDataFromPipeline(137, expDocNbr);
			info("renewalStatusCaculatedATR:"+renewalStatusCaculatedATR);
			
			info("Get Close Date from Pipeline list");
			String closeDateATR=pipeList.getDataFromPipeline(116, expDocNbr);
			info("closeDateATR:"+closeDateATR);
			info("financialCloseCalendarDate:"+financialCloseCalendarDate);
			
			info("Get Quote Prepaid from Pipeline list");
			String quotePrepaidATR=pipeList.getDataFromPipeline(108, expDocNbr);
			info("quotePrepaidATR:"+quotePrepaidATR);
			info("billingDes:"+billingDes);
			
			info("Get Legacy Sales Order Identifier from Pipeline list");
			String legacySalesOrderIDATR=pipeList.getDataFromPipeline(145, expDocNbr);
			info("legacySalesOrderIDATR:"+legacySalesOrderIDATR);
			info("legacySalesOrderID:"+legacySalesOrderID);
			
			info("Get Customer Purchase Order Identifier from Pipeline list");
			String customerPuchaseOrderIDATR=pipeList.getDataFromPipeline(148, expDocNbr);
			info("customerPuchaseOrderIDATR:"+customerPuchaseOrderIDATR);
			info("customerPurchaseOrderID:"+customerPurchaseOrderID);
			
			info("Get Quote Currency from Pipeline list");
			String quoteCurrencyATR=pipeList.getDataFromPipeline(113, expDocNbr);
			info("quoteCurrencyATR:"+quoteCurrencyATR);
			info("documentCurrencyCode:"+documentCurrencyCode);
			
			info("Get Foundation Total LCL FX from Pipeline list");
			double foundationTotalLCLFXATR=pipeList.getDataNumber(110, expDocNbr);
			info("foundationTotalLCLFXATR:"+foundationTotalLCLFXATR);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderDocCurrencyAmount);
			
			info("Get Annualised Foundation LCL FX from Pipeline list");
			double annualisedFoundationLCLFXATR=pipeList.getDataNumber(132, expDocNbr);
			info("annualisedFoundationLCLFXATR:"+annualisedFoundationLCLFXATR);
			info("netSalesOrderDocCurrencyAmount:"+netSalesOrderDocCurrencyAmount);
			
			info("Get Foundation USD from Pipeline list");
			double foundationUSDATR=pipeList.getDataNumber(129, expDocNbr);
			info("foundationUSDATR:"+foundationUSDATR);
			info("netSalesOrderUSDollarAmount:"+netSalesOrderUSDollarAmount);
			
			info("Get Annualised Foundation USD from Pipeline list");
			double annualisedFoundationUSDATR=pipeList.getDataNumber(133, expDocNbr);
			info("annualisedFoundationUSDATR:"+annualisedFoundationUSDATR);
			info("netSalesOrderUSDollarAmount:"+netSalesOrderUSDollarAmount);
			
			info("Get Total FCST LCL FX from Pipeline list");
			double totalFCSTLCLFXATR=pipeList.getDataNumber(112, expDocNbr);
			info("totalFCSTLCLFXATR:"+totalFCSTLCLFXATR);
			
			info("Get Total Quote LCL FX from Pipeline list");
			double totalQuoteLCLFXATR=pipeList.getDataNumber(111, expDocNbr);
			info("totalQuoteLCLFXATR:"+totalQuoteLCLFXATR);
			
			info("Get Total FCST Value USD from Pipeline list");
			double totalFCSTValueUSDATR=pipeList.getDataNumber(131, expDocNbr);
			info("totalFCSTValueUSDATR:"+totalFCSTValueUSDATR);
			
			info("Get Total Contract Value USD from Pipeline list");
			double totalContractValueUSDATR=pipeList.getDataNumber(130, expDocNbr);
			info("totalContractValueUSDATR:"+totalContractValueUSDATR);
			
			info("Compare date after reconciled");
			pipeList.compareData(saleOrderIDATR,expDocNbr);
			pipeList.compareData(renewalStatusATR,"WON");
			pipeList.compareData(renewalStatusCaculatedATR,"WON");
			pipeList.compareData(closeDateATR,financialCloseCalendarDate);
			pipeList.compareData(quotePrepaidATR,billingDes);
			pipeList.compareData(legacySalesOrderIDATR,legacySalesOrderID);
			pipeList.compareData(customerPuchaseOrderIDATR,customerPurchaseOrderID);
			pipeList.compareData(quoteCurrencyATR,documentCurrencyCode);
			pipeList.compareNumber(foundationTotalLCLFXATR,netSalesOrderDocCurrencyAmount);
			pipeList.compareNumber(annualisedFoundationLCLFXATR,netSalesOrderDocCurrencyAmount);
			pipeList.compareNumber(foundationUSDATR,netSalesOrderUSDollarAmount);
			pipeList.compareNumber(annualisedFoundationUSDATR,netSalesOrderUSDollarAmount);
			pipeList.compareNumber(totalFCSTLCLFXATR,totalQuoteLCLFXATR);
			pipeList.compareNumber(totalFCSTValueUSDATR,totalContractValueUSDATR);
		}
		/**
		* Test case ID:VAN-1656
		* Test case name:"Unassign a Order by APJ/KOREA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1656_UnassignAOrderByAPJKOREAAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/KOREA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			String customerShip_1=getRandomString()+getRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(42);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 67->69");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=67;i<70;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip_1);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Go to Data Import page");
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=67;i<70;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1655
		* Test case name:"Unassign a Order by APJ/VERTICA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1655_UnassignAOrderByAPJVERTICAAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/VERTICA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			String customerShip_1=getRandomString()+getRandomNumber();
			for(int i=1;i<14;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(59);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 57->60");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=57;i<61;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip_1);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update assign to column for rules from 61->66");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=61;i<67;i++)rowList2.add(i);
			colList2.add(10);
			valueList2.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Go to Data Import page");
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=57;i<67;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add("");
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1654
		* Test case name:"Unassign a Order by APJ/SEA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1654_UnassignAOrderByAPJSEAAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/SEA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			String customerShip_1=getRandomString()+getRandomNumber();
			for(int i=1;i<31;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(57);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 33->57");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=33;i<57;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip_1);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=33;i<57;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			falloutUnassignedOrders.changePageSize("50");
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		
		/**
		* Test case ID:VAN-1653
		* Test case name:"Unassign a Order by APJ/ESP assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1653_UnassignAOrderByAPJESPAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/ESP assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<15;i++)rowList.add(i);
			colList.add(49);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(54);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 24->33");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=24;i<33;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=24;i<33;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1652
		* Test case name:"Unassign a Order by APJ/INDIA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1652_UnassignAOrderByAPJINDIAAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/INDIA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String shipToCustomerName_1=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(10);
			colList.add(49);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(55);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=21;i<24;i++)rowList2.add(i);
			colList2.add(8);
			valueList2.add(shipToCustomerName_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=21;i<24;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=21;i<24;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
			
		}
		/**
		* Test case ID:VAN-1651
		* Test case name:"Unassign a Order by APJ/SOUTH PACIFIC assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1651_UnassignAOrderByAPJSOUTHPACIFICAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/SOUTH PACIFIC assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String soldToCustomerName=getRandomString()+getLongRandomNumber();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<5;i++)rowList.add(i);
			colList.add(3);
			colList.add(10);
			colList.add(49);
			valueList.add(soldToCustomerName);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(58);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			String soldToCustomerName_1=getRandomString()+getLongRandomNumber();
			String shipToCustomerName_1=getRandomString()+getLongRandomNumber();
			for(int i=14;i<18;i++)rowList2.add(i);
			colList2.add(8);
			colList2.add(9);
			valueList2.add(shipToCustomerName_1);
			valueList2.add(soldToCustomerName_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=14;i<18;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=14;i<18;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1650
		* Test case name:"Unassign a Order by APJ/CHINA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1650_UnassignAOrderByAPJCHINAAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/CHINA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String shipToCustomerName_1=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(10);
			colList.add(49);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(53);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=18;i<21;i++)rowList2.add(i);
			colList2.add(8);
			valueList2.add(shipToCustomerName_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=18;i<21;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=18;i<21;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1647
		* Test case name:"Unassign a Order by APJ/JAPAN assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1647_UnassignAOrderByAPJJAPANAssignmentRules() throws Exception{
			info("Unassign a Order by APJ/JAPAN assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String soldToCustomerName=getRandomString()+getLongRandomNumber();
			String soldToCustomerName_1=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<5;i++)rowList.add(i);
			colList.add(3);
			colList.add(49);
			valueList.add(soldToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(52);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 10->13");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=10;i<14;i++)rowList2.add(i);
			colList2.add(9);
			valueList2.add(soldToCustomerName_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 10->13");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=10;i<14;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=10;i<14;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1638
		* Test case name:"Unassign a Order by AMS assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"This column is blank"
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1638_UnassignAOrderByAMSAssignmentRules() throws Exception{
			info("Unassign a Order by AMS assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToAMID2ID=getLongRandomNumber();
			String soldToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
			String shipToAMID2ID_1=getLongRandomNumber();
			String soldToAMIDLevel2ID_1=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<9;i++)rowList.add(i);
			colList.add(4);
			colList.add(8);
			colList.add(49);
			valueList.add(soldToAMIDLevel2ID);
			valueList.add(shipToAMID2ID);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(51);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to column for rules from 2->3");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(2);
			rowList2.add(3);
			colList2.add(7);
			valueList2.add(soldToAMIDLevel2ID_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update ship to column for rules from 6->9");
			ArrayList<Integer>rowList3=new ArrayList<Integer>();
			ArrayList<Integer>colList3=new ArrayList<Integer>();
			ArrayList<String>valueList3=new ArrayList<String>();
			for(int i=6;i<10;i++)rowList3.add(i);
			colList3.add(6);
			valueList3.add(shipToAMID2ID_1);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList3, colList3, valueList3, isUseFile);
			
			
			info("Update assign to column for rules from 2->9");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=2;i<10;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=2;i<10;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyNOTAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
			
		}
		/**
		* Test case ID:VAN-1637
		* Test case name:"Assign a Order by APJ/KOREA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1637_AssignAOrderByAPJKOREAAssignmentRules() throws Exception{
			info("Assign a Order by APJ/KOREA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(42);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 67->69");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=67;i<70;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Go to Data Import page");
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=67;i<70;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1636
		* Test case name:"Assign a Order by APJ/VERTICA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		*/
		@Test
		public void VAN1636_AssignAOrderByAPJVERTICAAssignmentRules() throws Exception{
			info("Assign a Order by APJ/VERTICA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			for(int i=1;i<14;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(45);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 57->60");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=57;i<61;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			
			info("Update assign to column for rules from 61->66");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=61;i<67;i++)rowList2.add(i);
			colList2.add(10);
			valueList2.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Go to Data Import page");
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=57;i<67;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
			
		}
		/**
		* Test case ID:VAN-1631
		* Test case name:"Assign a Order by APJ/SEA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1631_AssignAOrderByAPJSEAAssignmentRules() throws Exception{
			info("Assign a Order by APJ/SEA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",
					region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			String customerShip=getRandomString()+getRandomNumber();
			for(int i=1;i<31;i++)rowList.add(i);
			colList.add(49);
			colList.add(10);
			valueList.add(prevDoc);
			valueList.add(customerShip);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(43);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 33->57");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=33;i<57;i++)rowList1.add(i);
			colList1.add(8);
			colList1.add(10);
			valueList1.add(customerShip);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=33;i<57;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1630
		* Test case name:"Assign a Order by APJ/ESP assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1630_AssignAOrderByAPJESPAssignmentRules() throws Exception{
			info("Assign a Order by APJ/ESP assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<15;i++)rowList.add(i);
			colList.add(49);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(40);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update assign to column for rules from 24->33");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=24;i<33;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=24;i<33;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1629
		* Test case name:"Assign a Order by APJ/INDIA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1629_AssignAOrderByAPJINDIAAssignmentRules() throws Exception{
			info("Assign a Order by APJ/INDIA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(10);
			colList.add(49);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(41);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=21;i<24;i++)rowList2.add(i);
			colList2.add(8);
			valueList2.add(shipToCustomerName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=21;i<24;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=21;i<24;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
			
		}
		/**
		* Test case ID:VAN-1626
		* Test case name:"Assign a Order by APJ/SOUTH PACIFIC assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1626_AssignAOrderByAPJSOUTHPACIFICAssignmentRules() throws Exception{
			info("Assign a Order by APJ/SOUTH PACIFIC assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String soldToCustomerName=getRandomString()+getLongRandomNumber();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<5;i++)rowList.add(i);
			colList.add(3);
			colList.add(10);
			colList.add(49);
			valueList.add(soldToCustomerName);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(44);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=14;i<18;i++)rowList2.add(i);
			colList2.add(8);
			colList2.add(9);
			valueList2.add(shipToCustomerName);
			valueList2.add(soldToCustomerName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=14;i<18;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=14;i<18;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		
		/**
		* Test case ID:VAN-1628
		* Test case name:"Assign a Order by APJ/CHINA assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1628_AssignAOrderByAPJCHINAAssignmentRules() throws Exception{
			info("Assign a Order by APJ/CHINA assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToCustomerName=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<4;i++)rowList.add(i);
			colList.add(10);
			colList.add(49);
			valueList.add(shipToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(39);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 14->17");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=18;i<21;i++)rowList2.add(i);
			colList2.add(8);
			valueList2.add(shipToCustomerName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 14->17");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=18;i<21;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=18;i<21;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1625
		* Test case name:"Assign a Order by APJ/JAPAN assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1625_AssignAOrderByAPJJAPANAssignmentRules() throws Exception{
			info("Assign a Order by APJ/JAPAN assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String soldToCustomerName=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<5;i++)rowList.add(i);
			colList.add(3);
			colList.add(49);
			valueList.add(soldToCustomerName);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(38);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to customer name column for rules from 10->13");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			for(int i=10;i<14;i++)rowList2.add(i);
			colList2.add(9);
			valueList2.add(soldToCustomerName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update assign to column for rules from 10->13");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=10;i<14;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=10;i<14;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1612
		* Test case name:"Assign a Order by AMS assignment rules"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check [Assignment] column"
		* Expected Result:"Display correct username that is set in corresponding Assignment Rules."
		* Test Step 8:"Check [RTM] column"
		* Expected Result:"This column is blank"
		* Test Step 9:"Check [ATR type] column"
		* Expected Result:"This column is blank"
		* Test Step 10:"Check data in all remain columns"
		* Expected Result:"All data is displayed correctly as in the excel file"
		* Test Step 11:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 12:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 13:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 14:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1612_AssignAOrderByAMSAssignmentRules() throws Exception{
			info("Assign a Order by AMS assignment rules");
			info("Create assignment rules");
			info("Create a new rsr user");
			String fullName="user"+getRandomNumber();
			String email =fullName+"@gmail.com";
			String hpID=getRandomNumber();
			String telephone=getRandomNumber();
			String city=getRandomString();
			String country=getRandomString();
			String region =getRandomString();
			String role = roleData.getContentByType(5);
			info("Go to Organization home page");
			navMenu.goToOrganization();
			info("Go to User list page");
			orgHome.goToUser();
			info("Go to Add user page");
			user.goToAddUser();
			info("Add a new user");
			user.add(fullName, email, hpID,USER_PASS, USER_PASS,false,false,"", "",region, telephone,city,country,"",role);
			user.save();
			Utils.pause(3000);
			
			info("Update Ship to and Sold to column in Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			String shipToAMID2ID=getLongRandomNumber();
			String soldToAMIDLevel2ID=getRandomString()+getLongRandomNumber();
			String prevDoc=getLongRandomNumber();
			for(int i=1;i<9;i++)rowList.add(i);
			colList.add(4);
			colList.add(8);
			colList.add(49);
			valueList.add(soldToAMIDLevel2ID);
			valueList.add(shipToAMID2ID);
			valueList.add(prevDoc);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(33);
			String path2=PATH_TESTDATA+fileOrder;
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			String fileAssignRule=assignRuleFilePath;
			info("Update sold to column for rules from 2->3");
			ArrayList<Integer>rowList2=new ArrayList<Integer>();
			ArrayList<Integer>colList2=new ArrayList<Integer>();
			ArrayList<String>valueList2=new ArrayList<String>();
			rowList2.add(2);
			rowList2.add(3);
			colList2.add(7);
			valueList2.add(soldToAMIDLevel2ID);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList2, colList2, valueList2, isUseFile);
			
			info("Update ship to column for rules from 6->9");
			ArrayList<Integer>rowList3=new ArrayList<Integer>();
			ArrayList<Integer>colList3=new ArrayList<Integer>();
			ArrayList<String>valueList3=new ArrayList<String>();
			for(int i=6;i<10;i++)rowList3.add(i);
			colList3.add(6);
			valueList3.add(shipToAMID2ID);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList3, colList3, valueList3, isUseFile);
			
			
			info("Update assign to column for rules from 2->9");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			for(int i=2;i<10;i++)rowList1.add(i);
			colList1.add(10);
			valueList1.add(fullName);
			upData.updateByArray(fileAssignRule, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			assignData.setData(fileAssignRule,defaultSheet,isUseFile);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Go to Assignment Rules page");
			dataImportHome.goToAssignmentRules();
			
			ArrayList<String>superregionList=new ArrayList<String>();
			ArrayList<String>regionList=new ArrayList<String>();
			ArrayList<String>countryList=new ArrayList<String>();
			ArrayList<String>businessList=new ArrayList<String>();
			ArrayList<String>productList=new ArrayList<String>();
			ArrayList<String>shipToList=new ArrayList<String>();
			ArrayList<String>soldToList=new ArrayList<String>();
			ArrayList<String>customeShipList=new ArrayList<String>();
			ArrayList<String>customeSoldList=new ArrayList<String>();
			for(int i=2;i<10;i++){
				info("Create rule:"+i);
				superregionList.add(assignData.getSuperRegionByType(i));
				regionList.add(assignData.getRegionByType(i));
				countryList.add(assignData.getCountryByType(i));
				businessList.add(assignData.getBusinessUnitByType(i));
				productList.add(assignData.getProductLineByType(i));
				shipToList.add(assignData.getShipToAMIDByType(i));
				soldToList.add(assignData.getSoldToAMIDByType(i));
				customeShipList.add(assignData.getCustomerNameShipToByType(i));
				customeSoldList.add(assignData.getcustomerNameSoldToByType(i));
				String assignTo=assignData.getAssignToByType(i);
				info("Go to Add Assignment Rules page");
				assignRule.goToAddRule();
				info("Add a new assignment rule");
				assignRule.add(
						assignData.getSuperRegionByType(i), 
						assignData.getRegionByType(i), 
						assignData.getCountryByType(i), 
						assignData.getBusinessUnitByType(i), 
						assignData.getProductLineByType(i), 
						assignData.getShipToAMIDByType(i), 
						assignData.getSoldToAMIDByType(i), 
						assignData.getCustomerNameShipToByType(i), 
						assignData.getcustomerNameSoldToByType(i), 
						assignTo);
				info("Verify that the new assigment rule is added successfully");
				assignRule.verifyNotiMesgSuccess();
				
			}
			
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
				order.verifyAssignRule(prevDoc,businessList.get(j),regionList.get(j),countryList.get(j),productList.get(j),fullName);
			
			info("Go to Operation page");
			navMenu.goToOperation();
			info("Go to Fallout Order");
			opeHome.goToFalloutOrders();
			info("Go to Unassigned Orders tab");
			falloutHomepage.goToUnassignedOrdersTab();
			info("Verify that the orders is displayed in the list");
			falloutUnassignedOrders.filterBy(filterUnassigned.PREVIOUS_DOC,prevDoc);
			for(int j=0;j<superregionList.size();j++)
			   falloutUnassignedOrders.verifyNOTUnassignRule(businessList.get(j),countryList.get(j),productList.get(j));
		}
		/**
		* Test case ID:VAN-1611
		* Test case name:"Check priority levels among Func Loc and SAID to assign a Order"
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
		* Test Step 6:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 7:"Import a Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 8:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 9:"Check priority level"
		* Expected Result:"The system will check with [Func Loc] of the Order and Contract"
		* Test Step 10:"Check [Assignment] column"
		* Expected Result:"Display [Sale Rep] value in the contract"
		* Test Step 11:"Check [RTM] column"
		* Expected Result:"Display [RTM] value in the contract"
		* Test Step 12:"Check [ATR type] column"
		* Expected Result:"The columns is blank"
		* Test Step 13:"Check data in all remain columns"
		* Expected Result:"All data is displayed as in the excel Order file"
		* Test Step 14:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 15:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 16:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 17:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1611_CheckPriorityLevelsAmongFuncLocAndSAIDToAssignAOrder() throws Exception{
			info("Check priority levels among Func Loc and SAID to assign a Order");
			info("Prepare data test");
			String exprDocNbr=getLongRandomNumber();
			String prevDoc= getLongRandomNumber();
			String funcLoc="ABCD"+getRandomNumber();
			String said=getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(37);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(5);
			colList1.add(32);
			colList1.add(38);
			valueList1.add(exprDocNbr);
			valueList1.add(said);
			valueList1.add(funcLoc);
			upData.updateByArray(path1, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(49);
			colList.add(47);
			colList.add(48);
			valueList.add(prevDoc);
			valueList.add(funcLoc);
			valueList.add(said);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Get RSR's name from ATR file");
			atrData.setData(path1,defaultSheet,isUseFile);
			String rsr=atrData.salesRep.get(0);
			String rtm=atrData.rtm.get(0);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileATR);
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			order.verifyContentColumns(65, rsr);
			order.verifyContentColumns(66, rtm);
		}
		/**
		* Test case ID:VAN-1610
		* Test case name:"Check priority levels among Previous Doc
		* Precondition:
		* Test details:
		* Test Step 1793:1
		* Test Step 1794:2
		* Test Data:"Login with user A"
		* Expected Result:"HPID: 2222Pass: Test@123456"
		* Test Step 1795:3
		* Test Data:"Click on [Data Import] link on the left menu"
		* Test Step 1796:4
		* Test Data:"Click on [ATR] button"
		* Test Step 1797:5
		* Test Data:"Import a contract"
		* Expected Result:"Attached ATR file bellow"
		* Test Step 1798:6
		* Test Data:"Click on [Order Import] button"
		* Test Step 1799:7
		* Test Data:"Import a Order file"
		* Expected Result:"Attached Order file bellow"
		* Test Step 1800:8
		* Test Data:"Click on [View] button"
		* Test Step 1827:9
		* Test Data:"Check priority level"
		* Test Step 1801:10
		* Test Data:"Check [Assignment] column"
		* Test Step 1802:11
		* Test Data:"Check [RTM] column"
		* Test Step 1803:12
		* Test Data:"Check [ATR type] column"
		* Test Step 1804:13
		* Test Data:"Check data in all remain columns"
		* Test Step 1805:14
		* Test Data:"Click on [Operation] link on the left menu"
		* Test Step 1806:15
		* Test Data:"Click on [Fallout Orders] button"
		* Test Step 1807:16
		* Test Data:"Click on [Unassigned Orders] tab"
		* Test Step 1808:17
		* Test Data:"Check Unassigned Orders list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1610_CheckPriorityLevelsAmongPreviousDoc() throws Exception{
			info("Check priority levels among Previous Doc, Func Loc and SAID to assign a Order");
			info("Prepare data test");
			String prevDoc= getLongRandomNumber();
			String funcLoc="ABCD"+getRandomNumber();
			String said=getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(37);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(5);
			colList1.add(32);
			colList1.add(38);
			valueList1.add(prevDoc);
			valueList1.add(said);
			valueList1.add(funcLoc);
			upData.updateByArray(path1, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(49);
			colList.add(47);
			colList.add(48);
			valueList.add(prevDoc);
			valueList.add(funcLoc);
			valueList.add(said);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Get RSR's name from ATR file");
			atrData.setData(path1,defaultSheet,isUseFile);
			String rsr=atrData.salesRep.get(0);
			String rtm=atrData.rtm.get(0);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileATR);
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			order.verifyContentColumns(65, rsr);
			order.verifyContentColumns(66, rtm);
		}
		/**
		* Test case ID:VAN-1609
		* Test case name:"Assign a Order by SAID"
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
		* Test Step 6:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 7:"Import a Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 8:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 9:"Check [Assignment] column"
		* Expected Result:"Display [Sale Rep] value in the contract"
		* Test Step 10:"Check [RTM] column"
		* Expected Result:"Display [RTM] value in the contract"
		* Test Step 11:"Check [ATR type] column"
		* Expected Result:"The column is blank"
		* Test Step 12:"Check remain columns"
		* Expected Result:"All data in the remain column is displayed correctly as in the excel Order file"
		* Test Step 13:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 14:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 15:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 16:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1609_AssignAOrderBySAID() throws Exception{
			info("Assign a Order by SAID");
			info("Prepare data test");
			String exprDocNbr=getLongRandomNumber();
			String prevDoc= getLongRandomNumber();
			String funcLoc="ABCD"+getRandomNumber();
			String said=getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(36);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(5);
			colList1.add(32);
			valueList1.add(exprDocNbr);
			valueList1.add(said);
			upData.updateByArray(path1, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(49);
			colList.add(47);
			colList.add(48);
			valueList.add(prevDoc);
			valueList.add(funcLoc);
			valueList.add(said);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Get RSR's name from ATR file");
			atrData.setData(path1,defaultSheet,isUseFile);
			String rsr=atrData.salesRep.get(0);
			String rtm=atrData.rtm.get(0);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileATR);
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			order.verifyContentColumns(65, rsr);
			order.verifyContentColumns(66, rtm);
		}
		/**
		* Test case ID:VAN-1608
		* Test case name:"Assign a Order by Funcational Locator"
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
		* Test Step 6:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 7:"Import a Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 8:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 9:"Check [Assignment] column"
		* Expected Result:"Display [Sale Rep] value in the contract"
		* Test Step 10:"Check [RTM] column"
		* Expected Result:"Display [RTM] value in the contract"
		* Test Step 11:"Check [ATR type] column"
		* Expected Result:"The column is blank"
		* Test Step 12:"Check remain columns"
		* Expected Result:"All data in the remain column is displayed correctly as in the excel Order file"
		* Test Step 13:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 14:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 15:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 16:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1608_AssignAOrderByFuncationalLocator() throws Exception{
			info("Assign a Order by Funcational Locator");
			info("Prepare data test");
			String exprDocNbr=getLongRandomNumber();
			String prevDoc= getLongRandomNumber();
			String funcLoc="ABCD"+getRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(34);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Update exp doc number for ATR file");
			ArrayList<Integer>rowList1=new ArrayList<Integer>();
			ArrayList<Integer>colList1=new ArrayList<Integer>();
			ArrayList<String>valueList1=new ArrayList<String>();
			rowList1.add(1);
			colList1.add(5);
			colList1.add(38);
			valueList1.add(exprDocNbr);
			valueList1.add(funcLoc);
			upData.updateByArray(path1, defaultSheet,rowList1, colList1, valueList1, isUseFile);
			info("Update exp doc number for Order file");
			ArrayList<Integer>rowList=new ArrayList<Integer>();
			ArrayList<Integer>colList=new ArrayList<Integer>();
			ArrayList<String>valueList=new ArrayList<String>();
			rowList.add(1);
			colList.add(49);
			colList.add(47);
			valueList.add(prevDoc);
			valueList.add(funcLoc);
			upData.updateByArray(path2, defaultSheet,rowList, colList, valueList, isUseFile);
			
			info("Get RSR's name from ATR file");
			atrData.setData(path1,defaultSheet,isUseFile);
			String rsr=atrData.salesRep.get(0);
			String rtm=atrData.rtm.get(0);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileATR);
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			order.verifyContentColumns(65, rsr);
			order.verifyContentColumns(66, rtm);
		}
		/**
		* Test case ID:VAN-1607
		* Test case name:"Assign a Order by Previous Doc Number"
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
		* Test Step 6:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 7:"Import a Order file"
		* Test Data:"Attached Order file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 8:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 9:"Check [Assignment] column"
		* Expected Result:"Display [Sale Rep] value in the contract"
		* Test Step 10:"Check [RTM] column"
		* Expected Result:"Display [RTM] value in the contract"
		* Test Step 11:"Check [ATR type] column"
		* Expected Result:"Display [ATR Type] value in the contract after be re-calculated by the system at the moment time"
		* Test Step 12:"Check data in all remain columns"
		* Expected Result:"All data is displayed as in the excel Order file"
		* Test Step 13:"Click on [Operation] link on the left menu"
		* Expected Result:"Operation page home is shown"
		* Test Step 14:"Click on [Fallout Orders] button"
		* Expected Result:"Fallout Summaries page is shown"
		* Test Step 15:"Click on [Unassigned Orders] tab"
		* Expected Result:"The tab's content is shown"
		* Test Step 16:"Check Unassigned Orders list"
		* Expected Result:"The order is not displayed in the list"
		 * @throws Exception 
		*/
		@Test
		public void VAN1607_AssignAOrderByPreviousDocNumber() throws Exception{
			info("Assign a Order by Previous Doc Number");
			info("Prepare data test");
			String prevDoc= getLongRandomNumber();
			String fileATR= fData.getAttachFileByArrayTypeRandom(9);
			String fileOrder= fData.getAttachFileByArrayTypeRandom(35);
			String path1=PATH_TESTDATA+fileATR;
			String path2=PATH_TESTDATA+fileOrder;
			info("Get RSR's name from ATR file");
			atrData.setData(path1,defaultSheet,isUseFile);
			String rsr=atrData.salesRep.get(0);
			String rtm=atrData.rtm.get(0);
			info("Update exp doc number for ATR file");
			upData.update(path1, defaultSheet,1,5,prevDoc, isUseFile);
			info("Update exp doc number for Order file");
			upData.update(path2, defaultSheet,1,49,prevDoc, isUseFile);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a correct ATR file");
			contract.upload(PATH_TESTDATA, fileATR);
			info("Go to Order page");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA, fileOrder);
			info("Go to view detail");
			order.goToViewDetail();
			order.filterBy(filterViewDetail.PREVIOUS_DOC,prevDoc);
			order.verifyContentColumns(65, rsr);
			order.verifyContentColumns(66, rtm);
		}
		/**
		* Test case ID:VAN-1596
		* Test case name:"Export a imported Order"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Click on [Export] button"
		* Expected Result:"A excel file is exported with all correct data."
		* PENDING: THIS SHOULD BE TESTED BY MANUAL. THIS FUNCTION CAN BE REMOVED.
		* 
		*/
		@Test(groups="pending")
		public void VAN1596_ExportAImportedOrder() throws Exception{
			/*info("Export a imported Order");
			String file= fData.getAttachFileByArrayTypeRandom(50);
			info("Get all data of  some columns in excel file");
			orderData = new OrderDatabase();
			orderData.setData(PATH_TESTDATA+file, defaultSheet, isUseFile);
			List<String>list1=orderData.getViewDetailList(0);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_NAME,file);
			order.verifyOrderInTable(file);
			info("Open detail order and verify that view detail page is shown");
			order.goToViewDetail();
			info("Display [WW] value in the dropbox");
			order.verifyWWRegionDefault("WW");
			info("Select a value in the drop-list of [WW Region] dropbox");
			order.selectDropbox(filterDroplist.WWREGION,"AMS");
			order.view();
			info("Get all data of all columns in View detail page");
			List<String>list2=order.getContentAllColumns();
			info("list1:"+list1);
			info("list2:"+list2);
			String currentDate=getCurrentDate("yyyyMMddHHmm");
			String fileDownloadName="1619_"+currentDate+"_Orders_Export.xlsx";
			info("Export the order");
			order.export();
			info("Verify that a file is download to the local");
		    checkFileExisted(fileDownloadName);
		    orderData = new OrderDatabase();
		    orderData.setData(PATH_DOWNLOADFOLER+fileDownloadName, defaultSheet, isUseFile);
			List<String>list3=orderData.getViewDetailList(0);
			info("All data is displayed with corresponding selected value at step 8");
			if(!equalLists(list2, list3)) assert false:"The data is not equal";*/
		}
		/**
		* Test case ID:VAN-1595
		* Test case name:"Check filter data by Business Unit in detail imported order"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check Region by default"
		* Expected Result:"No value is displayed in the drop box"
		* Test Step 8:"Select a value in the drop-list of [Business Unit] dropbox"
		* Test Data:Example:ADM
		* Expected Result:"The new value is selected"
		* Test Step 9:"Click on [View] button"
		* Expected Result:"All data is displayed with corresponding selected values at step 8 and 9"
		 * @throws Exception 
		*/
		@Test
		public void VAN1595_CheckFilterDataByBusinessUnitInDetailImportedOrder() throws Exception{
			info("Check filter data by Business Unit in detail imported order");
			String file= fData.getAttachFileByArrayTypeRandom(50);
			info("Get all data of  some columns in excel file");
			orderData = new OrderDatabase();
			orderData.setData(PATH_TESTDATA+file, defaultSheet, isUseFile);
			List<String>list1=orderData.getViewDetailList(0);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_NAME,file);
			order.verifyOrderInTable(file);
			info("Open detail order and verify that view detail page is shown");
			order.goToViewDetail();
			info("Display [WW] value in the dropbox");
			order.verifyWWRegionDefault("WW");
			info("Select a value in the drop-list of [WW Region] dropbox");
			order.selectDropbox(filterDroplist.BUSINESS_UNIT,"ADM");
			order.view();
			info("Get all data of all columns in View detail page");
			List<String>list2=order.getContentAllColumns();
			info("list1:"+list1);
			info("list2:"+list2);
			info("All data is displayed with corresponding selected value at step 8");
			if(!equalLists(list1, list2)) assert false:"The data is not equal";
		}
		/**
		* Test case ID:VAN-1594
		* Test case name:"Check filter data by Region in detail imported order"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check Region by default"
		* Expected Result:"No value is displayed in the drop box"
		* Test Step 8:"Select a value in the drop-list of [WW Region] dropbox"
		* Test Data:Example:AMS
		* Expected Result:"The new value is selected"
		* Test Step 9:"Select one or many values in the drop list of [Region]"
		* Expected Result:"The new value(s) is(are) selected"
		* Test Step 10:"Click on [View] button"
		* Expected Result:"All data is displayed with corresponding selected values at step 8 and 9"
		 * @throws Exception 
		*/
		@Test
		public void VAN1594_CheckFilterDataByRegionInDetailImportedOrder() throws Exception{
			info("Check filter data by Region in detail imported order");
			String file= fData.getAttachFileByArrayTypeRandom(50);
			info("Get all data of  some columns in excel file");
			orderData = new OrderDatabase();
			orderData.setData(PATH_TESTDATA+file, defaultSheet, isUseFile);
			List<String>list1=orderData.getViewDetailList(0);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_NAME,file);
			order.verifyOrderInTable(file);
			info("Open detail order and verify that view detail page is shown");
			order.goToViewDetail();
			info("Display [WW] value in the dropbox");
			order.verifyWWRegionDefault("WW");
			info("Select a value in the drop-list of [WW Region] dropbox");
			order.selectDropbox(filterDroplist.WWREGION,"AMS");
			order.selectDropbox(filterDroplist.REGION,"North America");
			order.view();
			info("Get all data of all columns in View detail page");
			List<String>list2=order.getContentAllColumns();
			info("list1:"+list1);
			info("list2:"+list2);
			info("All data is displayed with corresponding selected value at step 8");
			if(!equalLists(list1, list2)) assert false:"The data is not equal";
		}
		/**
		* Test case ID:VAN-1593
		* Test case name:"Check filter data by WW Region in detail imported order"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* Test Step 7:"Check WW region by default"
		* Expected Result:"Display [WW] value in the dropbox"
		* Test Step 8:"Select a value in the drop-list of [WW Region] dropbox"
		* Expected Result:"The new value is selected"
		* Test Step 9:"Click on [View] button"
		* Expected Result:"All data is displayed with corresponding selected value at step 8"
		 * @throws Exception 
		*/
		@Test
		public void VAN1593_CheckFilterDataByWWRegionInDetailImportedOrder() throws Exception{
			info("Check filter data by WW Region in detail imported order");
			String file= fData.getAttachFileByArrayTypeRandom(50);
			info("Get all data of  some columns in excel file");
			orderData = new OrderDatabase();
			orderData.setData(PATH_TESTDATA+file, defaultSheet, isUseFile);
			List<String>list1=orderData.getViewDetailList(0);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_NAME,file);
			order.verifyOrderInTable(file);
			info("Open detail order and verify that view detail page is shown");
			order.goToViewDetail();
			info("Display [WW] value in the dropbox");
			order.verifyWWRegionDefault("WW");
			info("Select a value in the drop-list of [WW Region] dropbox");
			order.selectDropbox(filterDroplist.WWREGION,"AMS");
			order.view();
			info("Get all data of all columns in View detail page");
			List<String>list2=order.getContentAllColumns();
			info("list1:"+list1);
			info("list2:"+list2);
			info("All data is displayed with corresponding selected value at step 8");
			if(!equalLists(list1, list2)) assert false:"The data is not equal";
		}
		/**
		* Test case ID:VAN-1592
		* Test case name:"View detail imported Orders"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Import a Order file"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file is imported successfully"
		* Test Step 6:"Click on [View] button"
		* Expected Result:"All data in the columns is displayed with correct data in the excel"
		* 
		*/
		@Test
		public void VAN1592_ViewDetailImportedOrders(){
			info("View detail a imported file");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Finished data test");
			info("Go to Data import page");
			navMenu.goToDataImport();
			info("Go to Order page");
			dataImportHome.goToOrderReport();
			info("Upload Order file");
			order.upload(PATH_TESTDATA, file);
			info("Open detail order and verify that view detail page is shown");
			order.goToViewDetail();
		}
		/**
		* Test case ID:VAN-1590
		* Test case name:"Check paging control"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Check paging control by default"
		* Expected Result:"Display the data of the 1st page*Highlight number 1 on the paging control*[Next] arrow is displayed*[Previous] arrow is hided"
		* Test Step 6:"Click on a number on the paging control"
		* Expected Result:"Display data correctly with corresponding page"
		* Test Step 7:"Click on [next] arrow"
		* Expected Result:"Display data correctly with corresponding next page"
		* Test Step 8:"Click on [previous] arrow"
		* Expected Result:"Display data correctly with corresponding previous page"
		* Test Step 9:"Go to at the end of the paging control"
		* Expected Result:"Display data correctly with corresponding last page*[Previous] arrow still is displayed*[Next] arrow is hided"
		* Test Step 10:"Go to at beginning of the paging control"
		* Expected Result:"Display data correctly with corresponding first page*[Previous] arrow is hided*[Next] arrow is still displayed"
		* PENDING: THIS CASE SHOULD BE TESTED BY MANUAL
		*/
		@Test(groups="pending")
		public void VAN1590_CheckPagingControl(){
		}
		/**
		* Test case ID:VAN-1589
		* Test case name:"Check paging size"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Check page size by default"
		* Expected Result:"Display 20 items/page"
		* Test Step 6:"Select a value in the drop list"
		* Expected Result:"Display the data correctly with corresponding selected value"
		*/
		@Test
		public void VAN1589_CheckPagingSize(){
			info("Check paging size");
			String[] listSize={"10","20","50","100","200"};
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			Utils.pause(3000);
			info("Change the page size");
			order.checkPageSize(listSize);
		}
		/**
		* Test case ID:VAN-1588
		* Test case name:"Filter by multi-columns"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Type some texts in filter fields of some columns"
		* Expected Result:"The texts are displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data with corresponding typed text"
		*/
		@Test
		public void VAN1588_FilterByMulticolumns(){
			info("Filter by multi-columns");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			String date = getCurrentDate("MMM d yyyy HH:mm a");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_SIZE,"10");
			order.searchBy(orderFilter.UPLOAD_DATE,date);
			order.searchBy(orderFilter.UPLOAD_BY,USER_ROOT_FULLNAME);
			order.verifyOrderInTable(file);
		}
		/**
		* Test case ID:VAN-1587
		* Test case name:"Filter a file by Upload By"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an admin account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Type a text in filter field of [Upload By] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data with corresponding typed text"
		*/
		@Test
		public void VAN1587_FilterAFileByUploadBy(){
			info("Filter a file by Upload By");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.UPLOAD_BY,USER_ROOT_FULLNAME);
			order.verifyOrderInTable(file);
		}
		
		/**
		* Test case ID:VAN-1586
		* Test case name:"Filter a file by Upload date"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Type a text in filter field of [Upload date] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data with corresponding typed text"
		*/
		@Test
		public void VAN1586_FilterAFileByUploadDate(){
			info("Filter a file by Upload By");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			String date = getCurrentDate("MMM dd yyyy HH:mm a");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.UPLOAD_DATE,date);
			order.verifyOrderInTable(file);
		}
		/**
		* Test case ID:VAN-1585
		* Test case name:"Filter a file by File size"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Type a text in filter field of [File Size] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data with corresponding typed text"
		*/
		@Test
		public void VAN1585_FilterAFileByFileSize(){
			info("Filter a file by File size");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			order.searchBy(orderFilter.FILE_SIZE,"10");
			order.verifyOrderInTable(file);
		}
		/**
		* Test case ID:VAN-1584
		* Test case name:"Filter a file by File Name"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Type a text in filter field of [File Name] column"
		* Expected Result:"The text is displayed in the field"
		* Test Step 6:"Press Enter key"
		* Expected Result:"Display the data with corresponding typed text"
		*/
		@Test
		public void VAN1584_FilterAFileByFileName(){
			info("Filter a file by File Name");
			String file = fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Upload a order file");
			order.upload(PATH_TESTDATA,file);
			
			info("Search the file by filename");
			order.searchBy(orderFilter.FILE_NAME,file);
			order.verifyOrderInTable(file);
		}
		
		/**
		* Test case ID:VAN-1583
		* Test case name:"Upload a Order with a correct file"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Click on [Choose file] button and select a file from local machine"
		* Test Data:"Attached file bellow"
		* Expected Result:"The file's name is displayed in the field"
		* Test Step 6:"Click on [Import] button"
		* Expected Result:"The file is imported successfully*The file's name is displayed in the table"
		* Test Step 7:"Check data after imported"
		* Expected Result:"All data in the columns are displayed correctly as in the excel file"
		*/
		@Test
		public void VAN1583_UploadAOrderWithACorrectFile(){
			info("Upload a Order with a correct file");
			String file= fData.getAttachFileByArrayTypeRandom(37);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToOrderReport();
			order.delete();
			info("Upload a correct Order file");
			order.upload(PATH_TESTDATA,file);
			Utils.pause(3000);
		}
		/**
		* Test case ID:VAN-1582
		* Test case name:"Check Breadcrumb on Order Report page"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with user A"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Click on [Data Import] link on the left menu"
		* Expected Result:"Data Import Home page is shown"
		* Test Step 4:"Click on [Order Import] button"
		* Expected Result:"Order page is shown"
		* Test Step 5:"Check breadcrumb"
		* Expected Result:"The breadcrumb is displayed as:Home->Administration->Data Import->Order"
		* Test Step 6:"Click on a link in the breadcrumb"
		* Expected Result:"Redirects to correct page"
		*/
		@Test
		public void VAN1582_CheckBreadcrumbOnOrderReportPage(){
			info("Check Breadcrumb on Order Report page");
			info("Go to Data Import page");
			navMenu.goToDataImport();
			info("Click on Order button");
			dataImportHome.goToOrderReport();
			info("Check breadcrumb");
			order.verifyBreadcrumb("Home");
			order.verifyBreadcrumb("Administration");
			order.verifyBreadcrumb("Data Import");
			order.verifyBreadcrumb("Order");
			info("Click on a link on the breadcrumb");
			order.clickBreadcrumb("Data Import");
			info("Verify that Data Import page is shown");
			waitForAndGetElement(dataImportHome.ELEMENT_DATAIMPORT_ORDER_REPORT_BTN,3000,1);
		}
}