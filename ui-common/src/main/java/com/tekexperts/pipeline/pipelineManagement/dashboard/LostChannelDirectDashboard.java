package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostChannelDirectDashboard extends PipelineBase{

	//Lost channel tab
	public By ELEMENT_DASHBOARD_LOSTCHANNEL_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByChannel']");
		
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOSTBYCHANNEL=By.xpath("");
	
	//Sales Rep dropdown
	public By ELEMENT_DASHBOARD_LOSTBYCHANNEL_SALESREP_DROPDOWN=By.xpath(".//*[@id='right-side']//div[1]/div/button[contains(@class,'dropdown')]");
	public String ELEMENT_DASHBOARD_LOSTBYCHANNEL_SALEREP_ITEM=".//*[@id='right-side']//div[1]/div/ul//*[contains(text(),'$fullName')]";

		
	public LostChannelDirectDashboard(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Lost channel tab
	 */
	public void goToLostChannelTab(){
		info("Click on the tab");
		click(ELEMENT_DASHBOARD_LOSTCHANNEL_TAB);
		Utils.pause(2000);
	}
	
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		goToLostChannelTab();
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTBYCHANNEL,2000,1);
		info("The dashboard is shown");
	}
	 /**
	  * Click on Sale Rep dropdown
	 */
	public void goToSaleRepList(){
		info("Click on Sale Rep dropdown");
		click(ELEMENT_DASHBOARD_LOSTBYCHANNEL_SALESREP_DROPDOWN);
		Utils.pause(3000);
	}
	/**
	 * Verify that a user is Sales rep is shown in the list
	 * @param fullName
	 */
	public void verifySaleRepInList(String fullName){
		goToSaleRepList();
		info("Verify that the sales rep:"+fullName+" is displayed in the list");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOSTBYCHANNEL_SALEREP_ITEM.replace("$fullName",fullName),2000,1);
		info("The user is shown in the list");
	}
}
