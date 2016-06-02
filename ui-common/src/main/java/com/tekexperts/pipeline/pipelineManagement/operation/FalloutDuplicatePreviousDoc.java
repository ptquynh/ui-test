package com.tekexperts.pipeline.pipelineManagement.operation;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutDuplicatePreviousDoc extends PipelineBase{

	//No display data in the list
	public By ELEMENT_DUPLIPREVIOUSDOC_NO_DISPLAY_DATA=By.xpath(".//*[@id='gvDuplicatedPreviousFallout_DXEmptyRow']//*[contains(text(),'No data to display')]");
	
	public String ELEMENT_DUPLIPREVIOUSDOC_DATA=".//*[contains(@id,'gvDuplicatedPreviousFallout_DXDataRow')]//*[text()='$content']";
	
	public FalloutDuplicatePreviousDoc(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that no data is displayed in the list
	 */
	public void verifyNoDisplayData(){
		info("Verify that no data is displayed in the list");
		waitForAndGetElement(ELEMENT_DUPLIPREVIOUSDOC_NO_DISPLAY_DATA,2000,1);
	}
	
	/**
	 * Verify data of a order
	 * @param content
	 */
	public void verifyData(String content){
		info("Verify that the content of order is shown in the list");
		waitForAndGetElement(ELEMENT_DUPLIPREVIOUSDOC_DATA.replace("$content",content), 3000,1);
	}
}
