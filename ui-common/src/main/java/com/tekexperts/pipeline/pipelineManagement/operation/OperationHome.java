package com.tekexperts.pipeline.pipelineManagement.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class OperationHome extends PipelineBase{

	//Unassigned Contracts button
	public By ELEMENT_UNASSIGNEDCONTRACT_BTN=By.xpath(".//*[@id='right-side']//*[@href='/UnassignRSR']");
	//Fallout Orders
	public By ELEMENT_FALLOUTORDERS_BTN=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder']");
	
	public OperationHome(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Open Unassigned contracts page
	 */
	public void goToUnassignedATR(){
	 info("Click on Unassigned Contract button");
	 click(ELEMENT_UNASSIGNEDCONTRACT_BTN);
	 Utils.pause(2000);
	}
	/**
	 * Open Fallout Orders page
	 */
	public void goToFalloutOrders(){
	 info("Click on Fallout Orders button");
	 click(ELEMENT_FALLOUTORDERS_BTN);
	 Utils.pause(2000);
	}

}
