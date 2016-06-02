package com.tekexperts.pipeline.pipelineManagement.operation;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutNegativeOrders extends PipelineBase{
	
	 //No display data in the list
	public By ELEMENT_NEGATIVEORDER_NO_DISPLAY_DATA=By.xpath(".//*[@id='gvNegativeOrderFallout_DXEmptyRow']//*[contains(text(),'No data to display')]");
	public String ELEMENT_NEGATIVEORDER_DATA=".//*[contains(@id,'gvNegativeOrderFallout_DXDataRow')]//*[text()='$content']";
	
	public FalloutNegativeOrders(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that no data is displayed in the list
	 */
	public void verifyNoDisplayData(){
		info("Verify that no data is displayed in the list");
		waitForAndGetElement(ELEMENT_NEGATIVEORDER_NO_DISPLAY_DATA,2000,1);
	}
	
	/**
	 * Verify data of a order
	 * @param content
	 */
	public void verifyData(String content){
		info("Verify that the content of order is shown in the list");
		waitForAndGetElement(ELEMENT_NEGATIVEORDER_DATA.replace("$content",content), 3000,1);
	}
}
