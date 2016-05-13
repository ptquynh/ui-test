package com.tekexperts.pipeline.administration.organization;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class BusinessUnit extends PipelineBase {
	//Business Unit page's title
	public By ELEMENT_BUSINESSUNIT_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Business Unit')]");
	//Add button
	public By ELEMENT_BUSINESSUNIT_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/BusinessUnit/Create?Length=12']");
	//Edit a Business Unit
    public String ELEMENT_BUSINESSUNIT_NAME_LINK=".//*[@id='gvBusinessUnit_tccell0_1']//*[contains(text(),'$name')]";
   //Name filter field
  	public By ELEMENT_BU_NAME_FILTER=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol1_I']");
  	//Status filter field
  	public By ELEMENT_BU_STATUS_FILTER=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_I']");
  	public By ELEMENT_BU_STATUS_DROPLIST=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_DDD_L_D']");
  	public By ELEMENT_BU_STATUS_ACTIVE=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_DDD_L_LBI1T0']");
	public By ELEMENT_BU_STATUS_DISABLE=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_DDD_L_LBI2T0']");
	public By ELEMENT_BU_STATUS_ALL=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_DDD_L_LBI0T0']");
  	//Description filter field
  	public By ELEMENT_BU_DESCRIPTION_FILTER=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol3_I']");
  	
  	//*************ADD/EDIT BUSINESS UNIT*************************************************\\
    //Name field
  	public By ELEMENT_BU_ADDEDIT_NAME_FIELD=By.xpath(".//*[@id='Name']");
  	//State field
  	public By ELEMENT_BU_ADDEDIT_STATE_FIELD=By.xpath(".//*[@id='Status']");
  	//Description
  	public By ELEMENT_BU_ADDEDIT_DESCRIPTION_FIELD=By.xpath(".//*[@id='Description']");
  	//Cancel button
  	public By ELEMENT_BU_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
  	//Save button
  	public By ELEMENT_BU_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
  	
  	public BusinessUnit(WebDriver dr){
		driver = dr;
	}
  	/**
  	 * Open Business Unit page
  	 */
  	public void goToAddBU(){
  		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_BUSINESSUNIT_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_BUSINESSUNIT_ADD_BTN);
		info("Add BU page is shown");
		waitForAndGetElement(ELEMENT_BUSINESSUNIT_TITLE,3000,1);
  	}
  	
  	/**
	 * Add a new business unit
	 * @param name
	 * @param state
	 * @param description
	 */
	public void add(String name,String state,String description){
		info("Input a new name");
		type(ELEMENT_BU_ADDEDIT_NAME_FIELD,name,true);
		info("Input a status");
		selectNotByOption(ELEMENT_BU_ADDEDIT_STATE_FIELD,state);
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_BU_ADDEDIT_DESCRIPTION_FIELD,description,true);
		}
		save();
		
	}
	/**
	 * Save all changes
	 */
	public void save(){
		info("Click on Save button");
		click(ELEMENT_BU_ADDEDIT_SAVE_BTN);
		info("Verify that Business Unit home page is shown");
		waitForAndGetElement(ELEMENT_BUSINESSUNIT_TITLE,3000,1);
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Save button");
		click(ELEMENT_BU_ADDEDIT_CANCEL_BTN);
		info("Verify that Business Unit home page is shown");
		waitForAndGetElement(ELEMENT_BUSINESSUNIT_TITLE,3000,1);
	}
	
	/**
	 * Verify that a business unit is shown in the table
	 * @param name
	 */
	public void verifyBUInTheTable(String name){
		info("Verify that the BU is shown in the table");
		waitForAndGetElement(ELEMENT_BUSINESSUNIT_NAME_LINK.replace("$name",name),3000,1);
		info("The BU is shown in the table");
	}
	/**
	 * Search a BU by name
	 * @param name
	 */
	public void searchByName(String name){
		info("Search a user in the table");
		type(ELEMENT_BU_NAME_FILTER,name,true);
		Utils.pause(3000);
	}
	/**
	 * Search a BU by status
	 * @param isActive
	 * @param isAll
	 */
	public void searchByStatus(Boolean isActive, Boolean isAll){
		info("Search a BU in the table by status");
		waitForAndGetElement(ELEMENT_BU_STATUS_FILTER).click();
		waitForAndGetElement(ELEMENT_BU_STATUS_DROPLIST,3000,1,2);
		info("Status drop list is shown");
		if(!isActive)
			waitForAndGetElement(ELEMENT_BU_STATUS_DISABLE).click();
		if(isAll)
			waitForAndGetElement(ELEMENT_BU_STATUS_ALL).click();
		Utils.pause(3000);
	}
}
