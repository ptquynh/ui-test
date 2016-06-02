package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class RenewalRateDashboard extends PipelineBase{

	//Page title
	public By ELEMENT_DASHBOARD_RENEWALRATE_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Renewal Rate Summary')]");
	
	//Sales Rep dropdown
	public By ELEMENT_DASHBOARD_RENEWALRATE_SALESREP_DROPDOWN=By.xpath(".//*[contains(@class,'fixSelect2Width')][2]//div[2]//button[contains(@class,'dropdown')]");
	public String ELEMENT_DASHBOARD_RENEWALRATE_SALEREP_ITEM=".//*[contains(@class,'fixSelect2Width')][2]//div[2]//ul//*[contains(text(),'$fullName')]";
	
	
	public RenewalRateDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_RENEWALRATE_PAGE_TITLE,2000,1);
		info("The page is shown");
	}

	/**
	 * Click on Sale Rep dropdown
	 */
	public void goToSaleRepList(){
		info("Click on Sale Rep dropdown");
		click(ELEMENT_DASHBOARD_RENEWALRATE_SALESREP_DROPDOWN);
		Utils.pause(3000);
	}
	/**
	 * Verify that a user is Sales rep is shown in the list
	 * @param fullName
	 */
	public void verifySaleRepInList(String fullName){
		goToSaleRepList();
		info("Verify that the sales rep:"+fullName+" is displayed in the list");
		waitForAndGetElement(ELEMENT_DASHBOARD_RENEWALRATE_SALEREP_ITEM.replace("$fullName",fullName),2000,1);
		info("The user is shown in the list");
	}
}
