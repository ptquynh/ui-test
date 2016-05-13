package com.tekexperts.pipeline.BusinessManagement;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class ABCD extends PipelineBase{

	//Page title
	public By ELEMENT_ABCD_TITLE_PAGE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'ABCD')]");
	
	
	public ABCD(WebDriver dr) {
		driver=dr;
	}

	
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_ABCD_TITLE_PAGE,2000,1);
		info("The page is shown");
	}
}
