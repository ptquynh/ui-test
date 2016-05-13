package com.tekexperts.pipeline.pipelineManagement.pipeline;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.tekexperts.pipeline.common.TestLogger.info;
import com.tekexperts.pipeline.common.PipelineBase;

public class HistoricalData extends PipelineBase {

	//Page title
	public By ELEMENT_HISTORICAL_DATA_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Historical Data')]");
	
	public HistoricalData(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Verify the page title
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_HISTORICAL_DATA_PAGE_TITLE, 2000,1);
	}

}
