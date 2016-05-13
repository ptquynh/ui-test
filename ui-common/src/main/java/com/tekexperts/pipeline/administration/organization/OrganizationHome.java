package com.tekexperts.pipeline.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class OrganizationHome extends PipelineBase{
	//Region button
	public By ELEMENT_ORGANIZATION_REGION_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Region']");
	//RTM button
	public By ELEMENT_ORGANIZATION_RTM_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Team']");
	//Business Unit button
	public By ELEMENT_ORGANIZATION_BUSINESSUNIT_BTN=By.xpath(".//*[@id='right-side']//*[@href='/BusinessUnit']");
	//USER button
	public By ELEMENT_ORGANIZATION_USER_BTN=By.xpath(".//*[@id='right-side']//*[@href='/User']");
	
	public OrganizationHome(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Region page
	 */
	public void goToRegion(){
		info("Click on Region button");
		click(ELEMENT_ORGANIZATION_REGION_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open RTM page
	 */
	public void goToRTM(){
		info("Click on RTM button");
		click(ELEMENT_ORGANIZATION_RTM_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open User page
	 */
	public void goToUser(){
		info("Click on USER button");
		click(ELEMENT_ORGANIZATION_USER_BTN);
		Utils.pause(3000);
	}
	/**
	 * Open Business Unit
	 */
	public void goToBU(){
		info("Click on Business Unit button");
		click(ELEMENT_ORGANIZATION_BUSINESSUNIT_BTN);
		Utils.pause(3000);
	}
}
