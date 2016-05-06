package com.tekexperts.pipeline.func.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class Region extends PipelineBase{
	//*********************HOME PAGE*******************************\\
	//Select dropbox
	public By ELEMENT_REGION_STATUS_DROPBOX=By.xpath(".//*[@id='ddlStatus']");
	//Add button
	public By ELEMENT_REGION_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Region/Create?Length=6']");
    //Edit a region
	public String ELEMENT_REGION_EDIT=".//*[contains(@id,'tlRegion')]//*[contains(text(),'$region')]";
	//Assign manager and Delegate
	public String ELEMENT_REGION_MANAGED_BY_LINK=".//*[@id='tlRegion_D']//*[contains(text(),'$region')]/../..//*[contains(text(),'$managed')]";
	
	//*********************ADD/EDIT REGION*******************************\\
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
}
