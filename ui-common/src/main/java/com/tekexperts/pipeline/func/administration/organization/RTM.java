package com.tekexperts.pipeline.func.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class RTM extends PipelineBase{
	//Add button
	public By ELEMENT_RTM_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Team/Create?Length=4']");
	//Name filter field
	public By ELEMENT_RTM_NAME_FIELD=By.xpath(".//*[@id='gvTeam_DXFREditorcol1']//td");
	//Status filter field
	public By ELEMENT_RTM_STATUS_FIELD=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_I']");
	//Description filter field
	public By ELEMENT_RTM_DESCRIPTION_FIELD=By.xpath(".//*[@id='gvTeam_DXFREditorcol3_I']");
	//Edit a RTM
	public String ELEMENT_RTM_EDIT_LINK=".//*[@id='gvTeam_DXMainTable']//*[contains(text(),'$name')]";
	
	//******************ADD/EDIT RTM****************************************\\
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
}
