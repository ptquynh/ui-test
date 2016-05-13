package com.tekexperts.pipeline.BusinessManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;

public class ExecutiveDashboard extends PipelineBase{

	//Page title
	public By ELEMENT_EXECUTIVE_DASBOARD_TITLE_PAGE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Executive Dashboard')]");
	
	
	public ExecutiveDashboard(WebDriver dr) {
		driver =dr;
	}
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_EXECUTIVE_DASBOARD_TITLE_PAGE,2000,1);
		info("The page is shown");
	}

}
