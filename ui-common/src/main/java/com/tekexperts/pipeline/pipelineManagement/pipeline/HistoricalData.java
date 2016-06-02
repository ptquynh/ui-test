package com.tekexperts.pipeline.pipelineManagement.pipeline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class HistoricalData extends PipelineBase {

	//Page title
	public By ELEMENT_HISTORICAL_DATA_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Historical Data')]");
	//All check box
	public By ELEMENT_HISTORICAL_DATA_ALL_CHECKBOX=By.xpath(".//*[@id='GridView_DXSelAllBtn0_D']//input");
	//Assign Button
	public By ELEMENT_HISTORICAL_DATA_ASSIGN_BTN=By.xpath(".//*[@id='btnAssign']");
	
	public HistoricalData(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Verify the page title
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_HISTORICAL_DATA_PAGE_TITLE, 2000,1);
	}
	/**
	 * Select all checkbox
	 */
	public void allCheckbox(){
		info("Check all checkbox");
		check(ELEMENT_HISTORICAL_DATA_ALL_CHECKBOX, 2);
		Utils.pause(3000);
	}
	/**
	 * Open assign RSR page
	 */
	public void goToAssignRSR(){
		info("Click on Assign button");
		click(ELEMENT_HISTORICAL_DATA_ASSIGN_BTN);
		Utils.pause(3000);
	}

}
