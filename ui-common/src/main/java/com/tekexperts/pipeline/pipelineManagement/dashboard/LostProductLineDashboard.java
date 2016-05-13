package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostProductLineDashboard extends PipelineBase{

	//Product line tab
	public By ELEMENT_DASHBOARD_LOST_PRODUCTLINE_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByProductLine']");
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTPRODUCTLINE=By.xpath("");
		
	public LostProductLineDashboard(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Product line tab
	 */
	public void goToLostProductLineTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOST_PRODUCTLINE_TAB);
		Utils.pause(2000);
	}
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostProductLineTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTPRODUCTLINE,2000,1);
		info("The dashboard is shown");
	}
}
