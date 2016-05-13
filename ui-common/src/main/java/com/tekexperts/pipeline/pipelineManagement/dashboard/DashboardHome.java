package com.tekexperts.pipeline.pipelineManagement.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class DashboardHome extends PipelineBase{

	//Pipeline button
	public By ELEMENT_DASHBOARD_PIPELINE_BTN=By.xpath(".//*[@id='right-side']//*[@href='/PipelineDashboard']");
	//Summary button
	public By ELEMENT_DASHBOARD_SUMMARY_BTN=By.xpath(".//*[@id='right-side']//*[@href='/PipelineSummaryDashboard/Index']");
	//Lost button
	public By ELEMENT_DASHBOARD_LOST_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByBusiness']");
	//Renewal Rate button
	public By ELEMENT_DASHBOARD_RENEWALRATE_BTN=By.xpath(".//*[@id='right-side']//*[@href='/RenewalRate']");
	
	
	public DashboardHome(WebDriver dr) {
		driver =dr;
	}
	/**
	 * Open pipeline dashboard
	 */
	public void goToPipelineDashboard(){
		info("Click on Pipeline button");
		click(ELEMENT_DASHBOARD_PIPELINE_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open summary dashboard
	 */
	public void goToSummaryDashboard(){
		info("Click on Summary button");
		click(ELEMENT_DASHBOARD_SUMMARY_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open lost dashboard
	 */
	public void goToLostDashboard(){
		info("Click on Lost button");
		click(ELEMENT_DASHBOARD_LOST_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open renewal rate dashboard
	 */
	public void goToRenewalRate(){
		info("Click on Renewal Rate button");
		click(ELEMENT_DASHBOARD_RENEWALRATE_BTN);
		Utils.pause(3000);
	}

}
