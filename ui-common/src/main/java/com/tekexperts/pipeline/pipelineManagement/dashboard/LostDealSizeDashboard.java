package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostDealSizeDashboard extends PipelineBase{

	//Lost deal size tab
	public By ELEMENT_DASHBOARD_LOST_DEALSIZE_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByDealSize']");
		
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTDEALSIZE=By.xpath("");
		
		
	public LostDealSizeDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open lost deal size tab
	 */
	public void goToLostDealSizeTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOST_DEALSIZE_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostDealSizeTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDEALSIZE,2000,1);
		info("The dashboard is shown");
	}
}
