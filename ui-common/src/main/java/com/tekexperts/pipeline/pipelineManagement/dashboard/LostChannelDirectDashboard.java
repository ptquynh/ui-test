package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostChannelDirectDashboard extends PipelineBase{

	//Lost channel tab
	public By ELEMENT_DASHBOARD_LOSTCHANNEL_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByChannel']");
		
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTBYCHANNEL=By.xpath("");
		
	public LostChannelDirectDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Lost channel tab
	 */
	public void goToLostChannelTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOSTCHANNEL_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostChannelTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTBYCHANNEL,2000,1);
		info("The dashboard is shown");
	}
}
