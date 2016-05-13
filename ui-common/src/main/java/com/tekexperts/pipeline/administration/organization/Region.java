package com.tekexperts.pipeline.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import static com.tekexperts.pipeline.common.TestLogger.info;

public class Region extends PipelineBase{
	//*********************HOME PAGE*******************************\\
	//Region home page title
	public By ELEMENT_REGION_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Region')]");
	//Select dropbox
	public By ELEMENT_REGION_STATUS_DROPBOX=By.xpath(".//*[@id='ddlStatus']");
	//Add button
	public By ELEMENT_REGION_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Region/Create?Length=6']");
    //Edit a region
	public String ELEMENT_REGION_NAME_LINK=".//*[contains(@id,'tlRegion')]//*[contains(text(),'$region')]";
	//Assign manager and Delegate
	public String ELEMENT_REGION_MANAGED_BY_LINK=".//*[@id='tlRegion_D']//*[contains(text(),'$region')]/../..//*[contains(text(),'$managed')]";
	
	//*********************ADD/EDIT REGION*******************************\\
	//Add region title
	public By ELEMETN_ADD_REGION_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Add region')]");
	//Name field
	public By ELEMENT_ADDEDIT_REGION_NAME_FIELD=By.xpath(".//*[@id='Name']");
	//Status dropbox
	public By ELEMENT_ADDEDIT_REGION_STATUS_DROPBOX=By.xpath(".//*[@id='Status']");
	//Level field
	public By ELEMENT_ADDEDIT_REGION_LEVEL_FIELD=By.xpath(".//*[@id='ddlLevel']");
	//Parent dropbox
	public By ELEMENT_ADDEDIT_REGION_PARENT_DROPBOX=By.xpath(".//*[@id='select2-ddlParent-container']");
	//Region type
	public By ELEMENT_ADDEDIT_REGION_REGION_TYPE_DROPBOX=By.xpath(".//*[@id='ddlRegionType']");
	//Description
	public By ELEMENT_ADDEDIT_REGION_DESCRIPTION_TEXTBOX=By.xpath(".//*[@id='Description']");
	//Cancel button
	public By ELEMENT_ADDEDIT_REGION_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_ADDEDIT_REGION_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	//************************Assign manager and Delegate*************************\\
	//Manager filed
	public By ELEMENT_ASSIGN_REGION_MANAGER_FIELD=By.xpath(".//*[@id='select2-ddlManager-container']");
	//Delegate field
	public By ELEMENT_ASSIGN_REGION_DELEGATE_FIELD=By.xpath(".//*[@id='select2-ddlDelegateManager-container']");
	//Cancel button
	public By ELEMENT_ASSIGN_REGION_CANCEL_BTN=By.xpath(".//*[@id='assignDelegateForm']//button[1]");
	//Save button
	public By ELEMENT_ASSIGN_REGION_SAVE_BTN=By.xpath(".//*[@id='assignDelegateForm']//button[2]");
	
	public Region(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Add region page
	 */
	public void goToAddRegion(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_REGION_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_REGION_ADD_BTN);
		info("Add region page is shown");
		waitForAndGetElement(ELEMETN_ADD_REGION_TITLE,3000,1);
	}
	/**
	 * Add a new region
	 * @param name
	 * @param status
	 * @param level
	 * @param regionType
	 * @param parent
	 * @param description
	 */
	public void add(String name,String status,String level,String regionType,String parent,String description){
		info("Input a new name");
		type(ELEMENT_ADDEDIT_REGION_NAME_FIELD,name,true);
		info("Input a status");
		selectNotByOption(ELEMENT_ADDEDIT_REGION_STATUS_DROPBOX,status);
		if(!level.isEmpty()){
			info("Input a level");
			selectNotByOption(ELEMENT_ADDEDIT_REGION_LEVEL_FIELD,level);
		}
		if(!regionType.isEmpty()){
			info("Input a region type");
			selectNotByOption(ELEMENT_ADDEDIT_REGION_REGION_TYPE_DROPBOX,regionType);
		}
		if(!parent.isEmpty()){
			info("Input a parent");
			selectNotByOption(ELEMENT_ADDEDIT_REGION_PARENT_DROPBOX,parent);
		}
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_ADDEDIT_REGION_DESCRIPTION_TEXTBOX,description,true);
		}
		save();
		
	}
	/**
	 * Save all changes
	 */
	public void save(){
		info("Click on Save button");
		click(ELEMENT_ADDEDIT_REGION_SAVE_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_ADDEDIT_REGION_CANCEL_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
	}
	/**
	 * Verify that the region is shown in the table
	 * @param region
	 * @param isActive
	 */
	public void verifyRegionInTheTable(String region,Boolean isActive){
		info("Verify that the region is shown in the table");
		if(!isActive){
			select(ELEMENT_REGION_STATUS_DROPBOX,"Disabled",2);
		}
		waitForAndGetElement(ELEMENT_REGION_NAME_LINK.replace("$region",region),3000,1);
		info("The region is shown in the table");
	}
}
