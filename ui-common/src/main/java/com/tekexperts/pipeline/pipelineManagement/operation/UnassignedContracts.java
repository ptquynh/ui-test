package com.tekexperts.pipeline.pipelineManagement.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class UnassignedContracts extends PipelineBase{

	//Empty unassigned contracts list
	public By ELEMENT_UNASSIGNEDCONTRACT_EMPTY_LIST=By.xpath(".//*[@id='UnassignRSR_DXEmptyRow']//*[contains(text(),'No data to display')]");
	//Contact in the table
	public String ELEMENT_UNASSIGNEDCONTRACT_INFO=".//*[@id='UnassignRSR_DXMainTable']//*[contains(text(),'$value')]";
	//All checkbox
	public By ELEMENT_UNASSIGNEDCONTRACT_ALL_CHECKBOX_UNCHECKED=By.xpath(".//input[@id='UnassignRSR_DXSelAllBtn0'][@value='U']");
	public By ELEMENT_UNASSIGNEDCONTRACT_ALL_CHECKBOX_CHECKED=By.xpath(".//input[@id='UnassignRSR_DXSelAllBtn0'][@value='C']");
	
	//Assign button
	public By ELEMENT_UNASSIGNEDCONTRACT_ASSIGN_BTN=By.xpath(".//*[@id='btnUpdateForSelectedItem']");
	
	public UnassignedContracts(WebDriver dr){
		driver = dr;
	}
	/**
	 * Check the list is empty or not
	 * @return false or true
	 */
	public boolean isEmptyList(){
		info("Verify that the lis is empty");
		if (waitForAndGetElement(ELEMENT_UNASSIGNEDCONTRACT_EMPTY_LIST,2000,0)==null)
			return true;
		else return false;
	}
	/**
	 * Check and uncheck the all checkbox
	 */
	public void selectAllCheckbox(){
		info("Click on All checkbox");
		if(waitForAndGetElement(ELEMENT_UNASSIGNEDCONTRACT_ALL_CHECKBOX_CHECKED,2000,0)==null)
		    check(ELEMENT_UNASSIGNEDCONTRACT_ALL_CHECKBOX_UNCHECKED,2);
		else check(ELEMENT_UNASSIGNEDCONTRACT_ALL_CHECKBOX_CHECKED,2);
		
	}
	/**
	 * Open Assign RSR page
	 */
	public void goToAssignRSR(){
		info("Click on Assign button");
		click(ELEMENT_UNASSIGNEDCONTRACT_ASSIGN_BTN);
		Utils.pause(2000);
	}
	/**
	 * Verify that a contract is NOT availabled in the table
	 * @param info
	 */
	public void verifyContractNOTAvailableInTable(String info){
		info("Verify that the contract is not available in the table");
		waitForElementNotPresent(ELEMENT_UNASSIGNEDCONTRACT_INFO.replace("$value", info),2000,1);
		info("The contract is not availabled in the table");
	}
	
}
