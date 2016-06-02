package com.tekexperts.pipeline.BusinessManagement;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class ABCD extends PipelineBase{

	//Page title
	public By ELEMENT_ABCD_TITLE_PAGE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'ABCD')]");
	
	//Business Unit 
	public By ELEMENT_BU_DROPDOWN=By.xpath(".//*[@id='ddlBusinessUnit']");
	//Dropdown list items
	public String ELEMENT_BU_DROPLIST_ITEM=".//*[@id='ddlBusinessUnit']//*[contains(text(),'$name')]";
	
	public ABCD(WebDriver dr) {
		driver=dr;
	}

	
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_ABCD_TITLE_PAGE,2000,1);
		info("The page is shown");
	}
	/**
	 * Open business unit dropdown
	 */
	public void goToBUDroplist(){
		info("Click on the dropdown");
		click(ELEMENT_BU_DROPDOWN);
		Utils.pause(3000);
	}
	
	/**
	 * Verify a item of a dropdown list is shown 
	 * @param droplist
	 * @param item
	 */
	public void verifyDroplist(String name){
			info("Verify that the :"+name+" is displayed in the list:");
			waitForAndGetElement(ELEMENT_BU_DROPLIST_ITEM.replace("$name",name),2000,1);
	}
	/**
	 * Verify that a item is not displayed in the drop list
	 * @param droplist
	 * @param item
	 */
	public void verifyNOTINDroplist(String name){
		info("Verify that the :"+name+" is not displayed in the list:");
		waitForElementNotPresent(ELEMENT_BU_DROPLIST_ITEM.replace("$name",name),2000,1);
}
}
