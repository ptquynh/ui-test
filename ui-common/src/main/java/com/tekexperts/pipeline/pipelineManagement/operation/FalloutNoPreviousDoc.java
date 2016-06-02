package com.tekexperts.pipeline.pipelineManagement.operation;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutNoPreviousDoc extends PipelineBase{
	
	 //No display data in the list
	public By ELEMENT_NOPREVIOUSDOC_NO_DISPLAY_DATA=By.xpath(".//*[@id='gvNoPreviousFallout_DXEmptyRow']//*[contains(text(),'No data to display')]");

	public String ELEMENT_NOPREVIOUSDOC_DATA=".//*[contains(@id,'gvNoPreviousFallout_DXDataRow')]//*[text()='$content']";
	public FalloutNoPreviousDoc(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that no data is displayed in the list
	 */
	public void verifyNoDisplayData(){
		info("Verify that no data is displayed in the list");
		waitForAndGetElement(ELEMENT_NOPREVIOUSDOC_NO_DISPLAY_DATA,2000,1);
	}
	/**
	 * Verify data of a order
	 * @param content
	 */
	public void verifyData(String content){
		info("Verify that the content of order is shown in the list");
		waitForAndGetElement(ELEMENT_NOPREVIOUSDOC_DATA.replace("$content",content), 3000,1);
	}
}
