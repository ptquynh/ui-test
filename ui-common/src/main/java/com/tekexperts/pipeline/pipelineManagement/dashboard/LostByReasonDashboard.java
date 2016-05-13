package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostByReasonDashboard extends PipelineBase{

	//Lost reason tab
	public By ELEMENT_DASHBOARD_LOSTREASON_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByIB']");
	
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTBYREASON=By.xpath("");
		
		
	public LostByReasonDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Lost reason tab
	 */
	public void goToLostReasonTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOSTREASON_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostReasonTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTBYREASON,2000,1);
		info("The dashboard is shown");
	}
}
