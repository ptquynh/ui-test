package com.tekexperts.pipeline.administration.dataImport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class DataImportHome extends PipelineBase{
	
	//ATR button
	public By ELEMENT_DATAIMPORT_ATR_BTN=By.xpath(".//*[@id='right-side']//*[@href='/ImportContract/ImportContract']");
	//Order Report button
	public By ELEMENT_DATAIMPORT_ORDER_REPORT_BTN=By.xpath(".//*[@id='right-side']//*[@href='/ImportOrder/ImportOrder']");
	//Assignment Rules button
	public By ELEMENT_DATAIMPORT_ASSIGNMENTRULES_BTN=By.xpath(".//*[@id='right-side']//*[@href='/AssignmentRule']");

	public DataImportHome(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open ATR page
	 */
	public void goToATR(){
		info("Open ATR page");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_BTN,3000,1);
		click(ELEMENT_DATAIMPORT_ATR_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open Order Report page
	 */
	public void goToOrderReport(){
		info("Open Order Report page");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ORDER_REPORT_BTN,3000,1);
		click(ELEMENT_DATAIMPORT_ORDER_REPORT_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open Assignment Rules page
	 */
	public void goToAssignmentRules(){
		info("Open Assignment Rules page");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ASSIGNMENTRULES_BTN,3000,1);
		click(ELEMENT_DATAIMPORT_ASSIGNMENTRULES_BTN);
		Utils.pause(3000);
	}
}
