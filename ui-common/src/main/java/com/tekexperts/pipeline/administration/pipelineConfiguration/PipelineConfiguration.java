package com.tekexperts.pipeline.administration.pipelineConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class PipelineConfiguration extends PipelineBase{
	//Timeframe button
	public By ELEMENT_PIPELINECONFIGURATION_TIMEFRAME_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Timeframe']");
	//FX button
	public By ELEMENT_PIPELINECONFIGURATION_FX_BTN=By.xpath(".//*[@id='right-side']//*[@href='/FX']");
	//Snapshot button
	public By ELEMENT_PIPELINECONFIGURATION_SNAPSHOTS_BTN=By.xpath(".//*[@id='right-side']//*[@href='/AdminSnapshot']");
	
	public PipelineConfiguration(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Timeframe page
	 */
	public void goToTimeFrame(){
		info("Click on Timeframe button");
		click(ELEMENT_PIPELINECONFIGURATION_TIMEFRAME_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open FX page
	 */
	public void goToFX(){
		info("Click on FX button");
		click(ELEMENT_PIPELINECONFIGURATION_FX_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open Snapshot
	 */
	public void goToSnapshot(){
		info("Click on Snapshot button");
		click(ELEMENT_PIPELINECONFIGURATION_SNAPSHOTS_BTN);
		Utils.pause(3000);
	}
}
