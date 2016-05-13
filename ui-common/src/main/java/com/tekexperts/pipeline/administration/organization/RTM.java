package com.tekexperts.pipeline.administration.organization;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class RTM extends PipelineBase{
	//RTM page title
	public By ELEMENT_RTM_TITLE = By.xpath(".//*[@id='right-side']//h1[contains(text(),'RTM')]");
	//Add button
	public By ELEMENT_RTM_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Team/Create?Length=4']");
	//Name filter field
	public By ELEMENT_RTM_NAME_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol1_I']");
	//Status filter field
	public By ELEMENT_RTM_STATUS_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_I']");
	public By ELEMENT_RTM_STATUS_DROPLIST=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_D']");
  	public By ELEMENT_RTM_STATUS_ACTIVE=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI1T0']");
	public By ELEMENT_RTM_STATUS_DISABLE=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI2T0']");
	public By ELEMENT_RTM_STATUS_ALL=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI0T0']");
	//Description filter field
	public By ELEMENT_RTM_DESCRIPTION_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol3_I']");
	//Edit a RTM
	public String ELEMENT_RTM_NAME_LINK=".//*[@id='gvTeam_DXMainTable']//*[contains(text(),'$name')]";
	
	//******************ADD/EDIT RTM****************************************\\
	//ADD RTM page title
	public By ELEMENT_ADD_RTM_TITLE = By.xpath(".//*[@id='right-side']//h1[contains(text(),'Add RTM')]");
	//Name field
	public By ELEMENT_RTM_ADDEDIT_NAME_FIELD=By.xpath(".//*[@id='Name']");
	//State field
	public By ELEMENT_RTM_ADDEDIT_STATE_FIELD=By.xpath(".//*[@id='Status']");
	//Description
	public By ELEMENT_RTM_ADDEDIT_DESCRIPTION_FIELD=By.xpath(".//*[@id='Description']");
	//Cancel button
	public By ELEMENT_RTM_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_RTM_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	public RTM(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Add RTM page
	 */
	public void goToAddRTM(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_RTM_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_RTM_ADD_BTN);
		info("Add region page is shown");
		waitForAndGetElement(ELEMENT_ADD_RTM_TITLE,3000,1);
	}
	/**
	 * Add a new RTM
	 * @param name
	 * @param state
	 * @param description
	 */
	public void add(String name,String state,String description){
		info("Input a new name");
		type(ELEMENT_RTM_ADDEDIT_NAME_FIELD,name,true);
		info("Input a state");
		selectNotByOption(ELEMENT_RTM_ADDEDIT_STATE_FIELD,state);
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_RTM_ADDEDIT_DESCRIPTION_FIELD,description,true);
		}
		save();
	}
	/**
	 * Save all changes
	 */
	public void save(){
		info("Click on Save button");
		click(ELEMENT_RTM_ADDEDIT_SAVE_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_RTM_TITLE,3000,1);
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_RTM_ADDEDIT_CANCEL_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_RTM_TITLE,3000,1);
	}
	/**
	 * Verify that a RTM is shown in the table
	 * @param name
	 */
	public void verifyRTMInTheTable(String name){
		info("Verify that the RTM is shown in the table");
		waitForAndGetElement(ELEMENT_RTM_NAME_LINK.replace("$name",name),3000,1);
		info("The RTM is shown in the table");
	}
	/**
	 * Search a RTM by name
	 * @param name
	 */
	public void searchByName(String name){
		info("Search a user in the table");
		type(ELEMENT_RTM_NAME_FILTER,name,true);
		Utils.pause(3000);
	}
	/**
	 * Search a RTM by status
	 * @param isActive
	 * @param isAll
	 */
	public void searchByStatus(Boolean isActive, Boolean isAll){
		info("Search a BU in the table by status");
		waitForAndGetElement(ELEMENT_RTM_STATUS_FILTER).click();
		waitForAndGetElement(ELEMENT_RTM_STATUS_DROPLIST,3000,1,2);
		info("Status drop list is shown");
		if(!isActive)
			waitForAndGetElement(ELEMENT_RTM_STATUS_DISABLE).click();
		if(isAll)
			waitForAndGetElement(ELEMENT_RTM_STATUS_ALL).click();
		Utils.pause(3000);
	}
}
