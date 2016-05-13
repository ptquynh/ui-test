package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostDurationDashboard extends PipelineBase{

	//Lost durattion tab
	public By ELEMENT_DASHBOARD_LOSTDURATION_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByDuration']");
			
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTDURATION=By.xpath("");
		
	public LostDurationDashboard(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Lost Duration tab
	 */
	public void goToLostChannelTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOSTDURATION_TAB);
		Utils.pause(2000);
	}
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDURATION,2000,1);
		info("The dashboard is shown");
	}
}
