package com.tekexperts.pipeline.pipelineManagement.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class AssignRSR extends PipelineBase{

	//Assign button
	public By ELEMENT_ASSIGNRSR_ASSIGN_BTN=By.xpath(".//*[@id='btnAssign']");
	//Cancel button
	public By ELEMENT_ASSIGNRSR_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[contains(text(),'Cancel')]");
	//Employees dropbox
	public By ELEMENT_ASSIGNRSR_EMPLOYEES_DROPBOX=By.xpath(".//*[@id='ddlEmployees']");
	public String ELEMENT_ASSIGNSRSR_EMPLOYEES_NAME=".//*[@id='ddlEmployees']//*[contains(text(),'$name')]";
	
	public AssignRSR(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Select a RSR in the dropbox
	 * @param name
	 */
	public void selectRSR(String name){
		info("Select a RSR in the dropbox");
		selectNotByOption(ELEMENT_ASSIGNRSR_EMPLOYEES_DROPBOX, ELEMENT_ASSIGNSRSR_EMPLOYEES_NAME.replace("$name",name));
		//waitForAndGetElement(ELEMENT_ASSIGNRSR_EMPLOYEES_DROPBOX,2000,1).click();
		//waitForAndGetElement(ELEMENT_ASSIGNSRSR_EMPLOYEES_NAME.replace("$name",name),2000,1).click();
		Utils.pause(3000);
	}
	/**
	 * Assign a RSR to selected contracts
	 */
	public void assign(){
		info("Click on Assign button");
		click(ELEMENT_ASSIGNRSR_ASSIGN_BTN);
		waitForElementNotPresent(ELEMENT_ASSIGNRSR_ASSIGN_BTN,2000,1);
	}
	/**
	 * Cancel assigning a RSR to selected contracts
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_ASSIGNRSR_CANCEL_BTN);
		waitForElementNotPresent(ELEMENT_ASSIGNRSR_CANCEL_BTN,2000,1);
	}

}
