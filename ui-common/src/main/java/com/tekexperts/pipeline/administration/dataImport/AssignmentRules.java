package com.tekexperts.pipeline.administration.dataImport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class AssignmentRules extends PipelineBase{

	//Assignment Rule page title
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Assignment rule')]");
	//Add button
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULE_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/AssignmentRule/Create?Length=14']");
	
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
	
	
	
	public String ELEMENT_ASSIGNMENT_IN_TABLE=".//*[@id='gvAssignmentRule_DXMainTable']//*[contains(text(),'$name')]";
	
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
			String customerNameSoldTo,
			String assignTo){
		if(!superRegion.isEmpty())
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
	
	public void searchBySuperRegion(String name){
		
	}
	
	public void searchByRegion(String name){
		
	}
	
	public void searchByCountry(String name){
		
	}
	
	public void searchByBusinessUnit(String name){
		
	}
	/**
	 * Search an assignment rule by ship to AMID
	 * @param name
	 */
	public void searchByShipToAMID(String name){
		info("Type ship to AMID");
		type(ELEMENT_ASSIGNMENT_SHIPTOAMID_FILTER,name,true);
		Utils.pause(3000);
	}
	/**
	 * Verify that an assignment rule is shown in the table
	 * @param name
	 */
	public void verifyAssignRuleInTheTable(String name){
		info("Verify that an assignment rule is shown in the table");
		waitForAndGetElement(ELEMENT_ASSIGNMENT_IN_TABLE.replace("$name",name),3000,1);
		info("The assignment rule is shown in the table");
	}
}
