package com.tekexperts.pipeline.administration.pipelineConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class Timeframe extends PipelineBase {

	//Title page
	public By ELEMENT_TIMEFRAME_TITLE=By.xpath("");
	//Label 
	public String ELEMENT_TIMEFRAME_LABEL=".//*[@id='right-side']//*[contains(text(),'$quarter')]/..//*[contains(text(),'$year')]";
	//Fiscal year
	public By ELEMENT_TIMEFRAME_FISCALYEAR_DROPBOX=By.xpath(".//*[@id='FiscalYear']");
	//Quarter
	public By ELEMENT_TIMEFRAME_QUARTER_DROPBOX=By.xpath(".//*[@id='FiscalQuarter']");
	//Set button
	public By ELEMENT_TIMEFRAME_SET_BTN=By.xpath(".//*[@id='form0']//button");
	
	
	public Timeframe(WebDriver dr) {
		driver =dr;
	}
	/**
	 * Change year
	 * @param year
	 */
	public void changeFiscalYear(String year){
		info("Select a new year");
		select(ELEMENT_TIMEFRAME_FISCALYEAR_DROPBOX,year,2);
		Utils.pause(3000);
	}
	/**
	 * Change quarter
	 * @param quarter
	 */
	public void changeQuarter(String quarter){
		info("Select a new quarter");
		select(ELEMENT_TIMEFRAME_QUARTER_DROPBOX,quarter,2);
		Utils.pause(3000);
	}
	/**
	 * Save all changes
	 */
	public void set(){
		info("Click on Set button");
		click(ELEMENT_TIMEFRAME_SET_BTN);
		Utils.pause(3000);
	}
	/**
	 * Verify that the label is updated
	 * @param quarter
	 * @param year
	 */
	public void checkLabel(String quarter,String year){
		info("Verify that the label is shown with correct quarter and year");
		waitForAndGetElement(ELEMENT_TIMEFRAME_LABEL.replace("$quarter",quarter).replace("$year",year));
		info("The label is shown with correct changed data");
	}

}
