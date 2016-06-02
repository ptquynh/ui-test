package com.tekexperts.pipeline.administration.dataImport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class AssignmentRules extends PipelineBase{

	//Delete link of first row
	public By ELEMENT_ASSIGNMENTRULE_DELETE_LINK=By.xpath(".//*[@id='gvAssignmentRule_tccell0_11']/a");
	public By ELEMENT_ASSIGNMENTRULE_DELETE_CONFIRM_POPUP=By.xpath(".//*[@id='confirm']/div/div");
	public By ELEMENT_ASSIGNMENTRULE_DELETE_CONFIRM_POPUP_YES_BTN=By.xpath(".//*[@id='confirm']//*[@id='btnConfirmSubmit']");
	public By ELEMENT_ASSIGNMENTRULE_NO_DATA=By.xpath(".//*[@id='gvAssignmentRule_DXEmptyRow']//*[contains(text(),'No data to display')]");
	
	//Assignment Rule page title
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Assignment rule')]");
	//Add button
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/AssignmentRule/Create?Length=14']");
	//****************************BREADCRUMB************************************************\\
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_BREADCRUMB_DATAIMPORT=By.xpath(".//*[@id='right-side']//*[@href='/ControlPanel/Account']");
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_BREADCRUMB_ADMINISTRATION=By.xpath(".//*[@id='right-side']//*[@href='/'][contains(text(),'Administration')]");
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_BREADCRUMB_HOME=By.xpath(".//*[@id='right-side']//*[@href='/'][contains(text(),'Home')]");
	//***************************ADD/EDIT ASSIGNMENT RULE************************************\\
	//Super region field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_SUPERREGION=By.xpath(".//*[@id='form0']//*[contains(@aria-labelledby,'ddlSupperRegion')]");
	public String ELEMENT_ASSIGNMENTRULE_ADEDIT_SUPERREION_ITEMS=".//*[contains(@id,'ddlSupperRegion')][contains(text(),'$value')]";
	//Region field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_REGION=By.xpath(".//*[@id='form0']//*[contains(@aria-labelledby,'ddlRegion')]");
	public String ELEMENT_ASSIGNMENTRULE_ADDEDIT_REGION_ITEMS=".//*[contains(@id,'ddlRegion')][contains(text(),'$value')]";
	//Country field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_COUNTRY=By.xpath(".//*[@id='form0']//*[contains(@aria-labelledby,'ddCountry')]");
	public String ELEMENT_ASSIGNMENTRULE_ADDEDIT_COUNTRY_ITEMS=".//*[contains(@id,'ddCountry')][contains(text(),'$value')]";
	//Business Unit field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_BU=By.xpath(".//*[@id='form0']//*[contains(@aria-labelledby,'ddlBusinessUnit')]");
	public String ELEMENT_ASSIGNMENTRULE_ADDEDIT_BU_ITEMS=".//*[contains(@id,'ddlBusinessUnit')][contains(text(),'$value')]";
	//Product line field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_PL=By.xpath(".//*[@id='ProductLine']");
	//Ship To AMID field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_SHIPTOAMID=By.xpath(".//*[@id='ShipToAMID']");
	//Sold To AMID LEVEL 2 field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_SOLDTOAMIDLEVEL2=By.xpath(".//*[@id='SoldToAMIDLevel2']");
	//Customer Name ship To field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_CUSTOMERNAMESHIPTO=By.xpath(".//*[@id='CustomerNameShipTo']");
	//Customer Name sold To field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_CUSTOMERNAMESOLDTO=By.xpath(".//*[@id='CustomerNameSoldTo']");
	//Assign To field
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_ASSIGNTO=By.xpath(".//*[@id='form0']//*[contains(@aria-labelledby,'ddlUser')]");
	public String ELEMENT_ASSIGNMENTRULE_ADDEDIT_ASSIGNTO_ITEMS=".//*[contains(@id,'ddlUser')][contains(text(),'$value')]";
	//Save button
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	//Cancel button
	public By ELEMENT_ASSIGNMENTRULE_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	
	//****************************************FILTERS************************************\\
	//Ship to AMID filter
	public By ELEMENT_ASSIGNMENT_SHIPTOAMID_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol5_I']");
	//Assign to filter
	public By ELEMENT_ASSIGNMENT_ASSIGNTO_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol9_I']");
	public By ELEMENT_ASSIGNMENT_SUPERREGION_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol0_I']");
	public By ELEMENT_ASSIGNMENT_REGION_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol1_I']");
	public By ELEMENT_ASSIGNMENT_COUNTRY_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol2_I']");
	public By ELEMENT_ASSIGNMENT_BU_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol3_I']");
	public By ELEMENT_ASSIGNMENT_PL_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol4_I']");
	public By ELEMENT_ASSIGNMENT_SOLDTOAMIDLEVEL2_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol6_I']");
	public By ELEMENT_ASSIGNMENT_CUSTOMERNAMESHIPTO_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol7_I']");
	public By ELEMENT_ASSIGNMENT_CUSTOMERNAMESOLDTO_FILTER=By.xpath(".//*[@id='gvAssignmentRule_DXFREditorcol8_I']");
	
	
	
	public String ELEMENT_ASSIGNMENT_IN_TABLE=".//*[@id='gvAssignmentRule_DXMainTable']//*[contains(text(),'$name')]";
	public String ELEMENT_ASSIGNMENT_INFO_IN_TABLE=".//*[@id='gvAssignmentRule_DXMainTable']//*[contains(text(),'$text')]";
	
	//Notification message
	public By ELEMENT_ASSIGNMENT_NOTIFICATION_MESG_SUCCESS=By.xpath(".//*[@id='NotificationBox'][contains(text(),'Successfully')]");
	
	public AssignmentRules(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Add Assignment Rule page
	 */
	public void goToAddRule(){
		info("Click on Add Assginment Rule page");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ASSIGNMENTRULE_ADD_BTN,3000,1);
		click(ELEMENT_DATAIMPORT_ASSIGNMENTRULE_ADD_BTN);
		info("Verify that Add Assignment rule page is shown");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ASSIGNMENTRULE_TITLE,3000,1);
	}
	/**
	 * Add a new assignment rule
	 * @param superRegion
	 * @param region
	 * @param country
	 * @param businessUnit
	 * @param productLine
	 * @param shipToAMID
	 * @param soldToAMIDLevel2
	 * @param customerNameSoldTo
	 * @param assignTo
	 */
	public void add(String superRegion,String region,String country,String businessUnit,
			String productLine,String shipToAMID,String soldToAMIDLevel2,String customerNameShipTo,
			String customerNameSoldTo,String assignTo,Object... params){
		Boolean isVerify =(Boolean)(params.length>0?params[0]:true);
		if(!superRegion.isEmpty()|| superRegion!=null)
			selectNotByOption(ELEMENT_ASSIGNMENTRULE_ADDEDIT_SUPERREGION,
					ELEMENT_ASSIGNMENTRULE_ADEDIT_SUPERREION_ITEMS.replace("$value",superRegion));
		if(!region.isEmpty())
			selectNotByOption(ELEMENT_ASSIGNMENTRULE_ADDEDIT_REGION,
					ELEMENT_ASSIGNMENTRULE_ADDEDIT_REGION_ITEMS.replace("$value",region));
		if(!country.isEmpty())
			selectNotByOption(ELEMENT_ASSIGNMENTRULE_ADDEDIT_COUNTRY,
					ELEMENT_ASSIGNMENTRULE_ADDEDIT_COUNTRY_ITEMS.replace("$value",country));
		if(!businessUnit.isEmpty())
			selectNotByOption(ELEMENT_ASSIGNMENTRULE_ADDEDIT_BU,
					ELEMENT_ASSIGNMENTRULE_ADDEDIT_BU_ITEMS.replace("$value",businessUnit));
		if(!productLine.isEmpty())
			type(ELEMENT_ASSIGNMENTRULE_ADDEDIT_PL,productLine,true);
		if(!shipToAMID.isEmpty())
			type(ELEMENT_ASSIGNMENTRULE_ADDEDIT_SHIPTOAMID,shipToAMID,true);
		if(!soldToAMIDLevel2.isEmpty())
			type(ELEMENT_ASSIGNMENTRULE_ADDEDIT_SOLDTOAMIDLEVEL2,soldToAMIDLevel2,true);
		if(!customerNameShipTo.isEmpty())
			type(ELEMENT_ASSIGNMENTRULE_ADDEDIT_CUSTOMERNAMESHIPTO,customerNameShipTo,true);
		if(!customerNameSoldTo.isEmpty())
			type(ELEMENT_ASSIGNMENTRULE_ADDEDIT_CUSTOMERNAMESOLDTO,customerNameSoldTo,true);
		if(!assignTo.isEmpty())
			selectNotByOption(ELEMENT_ASSIGNMENTRULE_ADDEDIT_ASSIGNTO,
					ELEMENT_ASSIGNMENTRULE_ADDEDIT_ASSIGNTO_ITEMS.replace("$value",assignTo));
		if(isVerify)
		   save();
	}
	/**
	 * Save all changes
	 */
	public void save(){
		info("Click on Save button");
		click(ELEMENT_ASSIGNMENTRULE_ADDEDIT_SAVE_BTN);
		info("Verify that the Assignment rule hom page is shown");
		waitForElementNotPresent(ELEMENT_ASSIGNMENTRULE_ADDEDIT_SAVE_BTN,3000,1);
	}
	
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_ASSIGNMENTRULE_ADDEDIT_CANCEL_BTN);
		info("Verify that the Assignment rule hom page is shown");
		waitForElementNotPresent(ELEMENT_ASSIGNMENTRULE_ADDEDIT_CANCEL_BTN,3000,1);
	}
	public enum assignmentCol{
		SUPPER_REGION,REGION,COUNTRY_NAME,BUSINESS_UNIT,PRODUCT_LINE,SHIPTO_AMID,SOLDTO_AMIDLEVEL2,
		CUSTOMER_NAMESHIPTO,CUSTOMER_NAMESOLDTO,ASSIGNTO;
	}
	/**
	 * Search
	 * @param col
	 * @param searchText
	 */
	public void searchBy(assignmentCol col,String searchText){
		switch(col){
		case SUPPER_REGION:
			info("Type super region");
			type(ELEMENT_ASSIGNMENT_SUPERREGION_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case REGION:
			info("Type region");
			type(ELEMENT_ASSIGNMENT_REGION_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case COUNTRY_NAME:
			info("Type country");
			type(ELEMENT_ASSIGNMENT_COUNTRY_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case BUSINESS_UNIT:
			info("Type business Unit");
			type(ELEMENT_ASSIGNMENT_BU_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case PRODUCT_LINE:
			info("Type Product line");
			type(ELEMENT_ASSIGNMENT_PL_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case SHIPTO_AMID:
			info("Type ship to AMID");
			type(ELEMENT_ASSIGNMENT_SHIPTOAMID_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case SOLDTO_AMIDLEVEL2:
			info("Type sold AMID level 2");
			type(ELEMENT_ASSIGNMENT_SOLDTOAMIDLEVEL2_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case CUSTOMER_NAMESHIPTO:
			info("Type customer name ship to");
			type(ELEMENT_ASSIGNMENT_CUSTOMERNAMESHIPTO_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case CUSTOMER_NAMESOLDTO:
			info("Type customer name sold to");
			type(ELEMENT_ASSIGNMENT_CUSTOMERNAMESOLDTO_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case ASSIGNTO:
			info("Type a rsr user");
			type(ELEMENT_ASSIGNMENT_ASSIGNTO_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		default:
			info("This col is not availabled");
			break;
		}
	}
	/**
	 * Verify that success mesage is shown
	 */
	public void verifyNotiMesgSuccess(){
		info("Success mesage is shown");
		waitForAndGetElement(ELEMENT_ASSIGNMENT_NOTIFICATION_MESG_SUCCESS,3000,1);
		info("The mesage is shown");
	}
	
	/**
	 * Verify that an assignment rule is shown in the table
	 * @param name
	 */
	public void verifyAssignRuleInTheTable(String name){
		info("Verify that an assignment rule is shown in the table");
		waitForAndGetElement(ELEMENT_ASSIGNMENT_IN_TABLE.replace("$name",name),6000,1);
		info("The assignment rule is shown in the table");
	}
	/**
	 * Verify that a info of an assignment rule is shown in the table
	 * @param text
	 */
	public void verifyInfo(String text){
		info("Verify that the text:"+text+" is shown in the table of an assignment rule");
		waitForAndGetElement(ELEMENT_ASSIGNMENT_INFO_IN_TABLE.replace("$text",text),3000,1);
	}
	/**
	 * Go to Data import page from the breadcrumb
	 */
	public void goToDataImport(){
		info("Go to Data import from the breadcrumb");
		click(ELEMENT_DATAIMPORT_ASSIGNMENTRULE_BREADCRUMB_DATAIMPORT);
		Utils.pause(3000);
	}
	/**
	 * Delete a rule
	 */
	public void delete(){
		info("Click on Delete link");
		click(ELEMENT_ASSIGNMENTRULE_DELETE_LINK);
		info("Confirm popup is shown");
		waitForAndGetElement(ELEMENT_ASSIGNMENTRULE_DELETE_CONFIRM_POPUP, 2000,1);
		info("Click on Yes button");
		click(ELEMENT_ASSIGNMENTRULE_DELETE_CONFIRM_POPUP_YES_BTN);
		waitForElementNotPresent(ELEMENT_ASSIGNMENTRULE_DELETE_CONFIRM_POPUP, 2000,1);
	}
	
}
