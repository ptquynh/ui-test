package com.tekexperts.pipeline.pipelineManagement.operation;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutNotReconciled extends PipelineBase{
	
	 //No display data in the list
	public By ELEMENT_NOTRECONCILED_NO_DISPLAY_DATA=By.xpath(".//*[@id='gvNotReconciedFallout_DXEmptyRow']//*[contains(text(),'No data to display')]");

	public FalloutNotReconciled(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that no data is displayed in the list
	 */
	public void verifyNoDisplayData(){
		info("Verify that no data is displayed in the list");
		waitForAndGetElement(ELEMENT_NOTRECONCILED_NO_DISPLAY_DATA,2000,1);
	}
}
