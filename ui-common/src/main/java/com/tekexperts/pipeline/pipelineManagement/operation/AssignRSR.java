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
	//RTM dropbox
	public By ELEMENT_ASSIGNRSR_RTM_DROPBOX=By.xpath(".//*[@id='select2-teamId-container']");
	public String ELEMENT_ASSIGNRSR_RTM_ITEM=".//*[@id='select2-teamId-results']//*[contains(text(),'$name')]";
	
	public AssignRSR(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Select a RSR in the dropbox
	 * @param name
	 *            == fullname
	 */
	public void selectRSR(String name){
		info("Select a RSR in the dropbox");
		selectNotByOption(ELEMENT_ASSIGNRSR_EMPLOYEES_DROPBOX, ELEMENT_ASSIGNSRSR_EMPLOYEES_NAME.replace("$name",name));
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
	/**
	 * Verify a user is not availabled in the RSR list
	 * @param fullName
	 */
	public void verifyUserIsNotAvailabile(String fullName){
		info("Verify that a user is not availabled in the RSR list");
		waitForElementNotPresent(ELEMENT_ASSIGNSRSR_EMPLOYEES_NAME.replace("$name",fullName),3000,1);
	}
	/**
	 * Verify that a item is shown in RTM droplist
	 * @param item
	 */
	public void verifyRTMDroplist(String item){
		info("Verify that the "+item+" is shown in the list");
		waitForAndGetElement(ELEMENT_ASSIGNRSR_RTM_ITEM.replace("$name",item),2000,1);
	}
	/**
	 * Verify that a item is not shown in RTM droplist
	 * @param item
	 */
	public void verifyNOTINRTMDroplist(String item){
		info("Verify that the "+item+" is shown in the list");
		waitForElementNotPresent(ELEMENT_ASSIGNRSR_RTM_ITEM.replace("$name",item),2000,1);
	}
    /**
     * Open RTM list
     */
	public void goToRTMList(){
		info("Open RTM list");
		waitForAndGetElement(ELEMENT_ASSIGNRSR_RTM_DROPBOX,2000,1).click();
		Utils.pause(3000);
	}
}
