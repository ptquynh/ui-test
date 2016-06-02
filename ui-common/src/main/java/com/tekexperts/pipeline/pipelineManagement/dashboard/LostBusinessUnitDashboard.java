package com.tekexperts.pipeline.pipelineManagement.dashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class LostBusinessUnitDashboard extends PipelineBase{

	//Page title
	public By ELEMENT_DASHBOARD_LOST_PAGE_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Lost Summary Dashboard')]");
	//Dashboard form
	public By ELEMENT_DASHBOARD_LOST_BUSINESSUNIT=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByBusiness')]");
	public By ELEMENT_DASHBOARD_LOSTRENEWALTYPE=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByRenewalType')]");
	public By ELEMENT_DASHBOARD_LOSTREASON=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByIB')]");
	public By ELEMENT_DASHBOARD_LOSTCHANNEL=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByChannel')]");
	public By ELEMENT_DASHBOARD_LOSTDEALSIZE=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByDealSize')]");
	public By ELEMENT_DASHBOARD_LOSTDURATION=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByDuration')]");
	public By ELEMENT_DASHBOARD_LOSTDEALSUMMARY=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostDealSummary')]");
	public By ELEMENT_DASHBOARD_LOSTPRODUCTLINE=By.xpath(".//*[@id='form0'][contains(@action,'/Lost/LostByProductLine')]");
	//Lost Bussiness Unit tab
	public By ELEMENT_DASHBOARD_LOST_BU_TAB=By.xpath(".//*[@id='right-side']//*[contains(@href,'/Lost/LostByBusiness')]");
	//Lost reason tab
	public By ELEMENT_DASHBOARD_LOSTREASON_TAB=By.xpath(".//*[@id='right-side']//*[contains(@href,'/Lost/LostByIB')]");
	//Lost channel tab
	public By ELEMENT_DASHBOARD_LOSTCHANNEL_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByChannel']");
	//Lost deal size tab
	public By ELEMENT_DASHBOARD_LOSTDEALSIZE_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByDealSize']");
	//Lost summary tab
	public By ELEMENT_DASHBOARD_LOSTDEALSUMMARY_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostDealSummary']");
	//Lost durattion tab
	public By ELEMENT_DASHBOARD_LOSTDURATION_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByDuration']");
	//Product line tab
	public By ELEMENT_DASHBOARD_LOSTPRODUCTLINE_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByProductLine']");								
	//Lost renewal type tab
	public By ELEMENT_DASHBOARD_LOSTRENEWALTYPE_TAB=By.xpath(".//*[@id='right-side']//*[@href='/Lost/LostByRenewalType']");
				
	//Sales Rep dropdown
	public By ELEMENT_DASHBOARD_BU_SALESREP_DROPDOWN=By.xpath(".//*[@id='right-side']//div[1]/div/button[contains(@class,'dropdown')]");
	public String ELEMENT_DASHBOARD_BU_SALEREP_ITEM=".//*[@id='right-side']//div[1]/div/ul//*[contains(text(),'$fullName')]";

	public LostBusinessUnitDashboard(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Bu dashboard
	 */
	public void goToBUDashboard(){
		info("Open Lost Bussiness Unit Dashboard");
		click(ELEMENT_DASHBOARD_LOST_BU_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOST_BUSINESSUNIT,2000,1);
	}
	/**
	 * Open Product line dashboard
	 */
	public void goToProductLineDashboard(){
		info("Open Lost Product line Dashboard");
		click(ELEMENT_DASHBOARD_LOSTPRODUCTLINE_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTPRODUCTLINE,2000,1);
	}
	/**
	 * Open Lost by reason dashboard
	 */
	public void goToByReasonDashboard(){
		info("Open Lost By reason Dashboard");
		click(ELEMENT_DASHBOARD_LOSTREASON_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTREASON,2000,1);
	}
	/**
	 * Open Renewal Type dashboard
	 */
	public void goToRenewalTypeDashboard(){
		info("Open Lost Renewal Type Dashboard");
		click(ELEMENT_DASHBOARD_LOSTRENEWALTYPE_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTRENEWALTYPE,2000,1);
	}
	/**
	 * Open Lost Channel dashboard
	 */
	public void goToChannelDashboard(){
		info("Open Lost Channel Dashboard");
		click(ELEMENT_DASHBOARD_LOSTCHANNEL_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTCHANNEL,2000,1);
	}
	/**
	 * Open Duration dashboard
	 */
	public void goToDurationDashboard(){
		info("Open Lost Duration Dashboard");
		click(ELEMENT_DASHBOARD_LOSTDURATION_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDURATION,2000,1);
	}
	/**
	 * Open Lost Deal Size dashboard
	 */
	public void goToDealSizeDashboard(){
		info("Open Lost Deal Size Dashboard");
		click(ELEMENT_DASHBOARD_LOSTDEALSIZE_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDEALSIZE,2000,1);
	}
	/**
	 * Open Lost Deal Summary dashboard
	 */
	public void goToDealSummaryDashboard(){
		info("Open Lost Deal Summary Dashboard");
		click(ELEMENT_DASHBOARD_LOSTDEALSUMMARY_TAB);
	    waitForAndGetElement(ELEMENT_DASHBOARD_LOSTDEALSUMMARY,2000,1);
	}
	
	/**
	 * Verify that the page title is shown
	 */
	public void verifyPageTitle(){
		info("Verify that the page title is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOST_PAGE_TITLE,2000,1);
		info("The page is shown");
	}
	/**
	 * Verify that the dashboard is shown
	 */
	public void verifyDashboard(){
		info("Verify that the dashboard is shown");
		waitForAndGetElement(ELEMENT_DASHBOARD_LOST_BUSINESSUNIT,2000,1);
		info("The dashboard is shown");
	}
	
	 /**
	  * Click on Sale Rep dropdown
	 */
	public void goToSaleRepList(){
		info("Click on Sale Rep dropdown");
		click(ELEMENT_DASHBOARD_BU_SALESREP_DROPDOWN);
		Utils.pause(3000);
	}
	/**
	 * Verify that a user is Sales rep is shown in the list
	 * @param fullName
	 */
	public void verifySaleRepInList(String fullName){
		goToSaleRepList();
		info("Verify that the sales rep:"+fullName+" is displayed in the list");
		waitForAndGetElement(ELEMENT_DASHBOARD_BU_SALEREP_ITEM.replace("$fullName",fullName),2000,1);
		info("The user is shown in the list");
	}
	
}
