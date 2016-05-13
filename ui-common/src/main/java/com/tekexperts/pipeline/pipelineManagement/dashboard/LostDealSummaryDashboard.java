package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostDealSummaryDashboard extends PipelineBase{

	//Lost summary tab
	public By ELEMENT_DASHBOARD_LOSTSUMMARY_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByIB']");
		
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTDEALSUMMARY=By.xpath("");
		
	public LostDealSummaryDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Lost summary tab
	 */
	public void goToLostSummaryTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOSTSUMMARY_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostSummaryTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDEALSUMMARY,2000,1);
		info("The dashboard is shown");
	}
}
