package com.tekexperts.pipeline.pipelineManagement.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import static com.tekexperts.pipeline.common.TestLogger.info;

public class PipelineDashboard extends PipelineBase{

	//Page title
	public By ELEMENT_DASHBOARD_PIPELINE_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Pipeline Dashboard')]");
	
	
	public PipelineDashboard(WebDriver dr){
		driver = dr;
	}
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_PIPELINE_PAGE_TITLE,2000,1);
		info("The page is shown");
	}
}
