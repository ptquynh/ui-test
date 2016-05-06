package com.tekexperts.pipeline.func.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

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
}
