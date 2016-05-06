package com.tekexperts.pipeline.func.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class BusinessUnit extends PipelineBase {
	//Add button
	public By ELEMENT_BUSINESSUNIT_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/BusinessUnit/Create?Length=12']");
	//Edit a Business Unit
    public String ELEMENT_BUSINESSUNIT_EDIT_LINK=".//*[@id='gvBusinessUnit_tccell0_1']//*[contains(text(),'$name')]";
   //Name filter field
  	public By ELEMENT_RTM_NAME_FIELD=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol1_I']");
  	//Status filter field
  	public By ELEMENT_RTM_STATUS_FIELD=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol2_I']");
  	//Description filter field
  	public By ELEMENT_RTM_DESCRIPTION_FIELD=By.xpath(".//*[@id='gvBusinessUnit_DXFREditorcol3_I']");
  	
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
}
