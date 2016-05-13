package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class LostBusinessUnitDashboard extends PipelineBase{

	//Page title
	public By ELEMENT_DASHBOARD_LOST_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Lost Summary Dashboard')]");
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOST_BUSINESSUNIT=By.xpath("");
	
	public LostBusinessUnitDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOST_PAGE_TITLE,2000,1);
		info("The page is shown");
	}
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOST_BUSINESSUNIT,2000,1);
		info("The dashboard is shown");
	}
	
}
