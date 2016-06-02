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
	
	
	//**************************************DROP LIST ALL DASHBOARDS***************************************
	//WWregion dropdown
	public By ELEMENT_DASHBOARD_WWREGION_DROPDOWN=By.xpath(".//*[contains(text(),'WW Region')]/..//*[contains(@data-toggle,'dropdown')]");
	//Region dropdown
	public By ELEMENT_DASHBOARD_REGION_DROPDOWN=By.xpath(".//*[contains(text(),'Region')]/..//*[contains(@data-toggle,'dropdown')]");
	//subRegion dropdown
	public By ELEMENT_DASHBOARD_SUBREGION_DROPDOWN=By.xpath(".//*[contains(text(),'SubRegion')]/..//*[contains(@data-toggle,'dropdown')]");
	//Country dropdown
	public By ELEMENT_DASHBOARD_COUNTRY_DROPDOWN=By.xpath(".//*[contains(text(),'Country')]/..//*[contains(@data-toggle,'dropdown')]");
	//BU dropdown
	public By ELEMENT_DASHBOARD_BU_DROPDOWN=By.xpath(".//*[contains(text(),'Business Unit')]/..//*[contains(@data-toggle,'dropdown')]");
	//RTM dropdown
	public By ELEMENT_DASHBOARD_RTM_DROPDOWN=By.xpath(".//*[contains(text(),'RTM/Segment')]/..//*[contains(@data-toggle,'dropdown')]");
	//Sales Rep dropdown
	public By ELEMENT_DASHBOARD_SALESREP_DROPDOWN=By.xpath(".//*[contains(text(),'Sales Rep')]/..//*[contains(@data-toggle,'dropdown')]");
	
	//Dropdown list items
	public String ELEMENT_DASHBOARD_DROPLIST_ITEM=".//*[contains(text(),'$droplist')]/../..//*[contains(text(),'$item')]//input";
	
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
	
	public enum droplist{
		SNAPSHOT,WWREGION,REGION,SUBREGION,COUNTRY,BUSSINESSUNIT,ORDERREVS,PRODUCTLINE,RTMSEGMENT,SALESREP,CHANNEL,CHANNELTYPE;
	}
	/**
	 * Open dropdown list in dashboards
	 * @param list
	 */
	public void goToDroplist(droplist list){
		switch(list){
		case SNAPSHOT:
			break;
		case WWREGION:
			info("Click on WW region dropdown");
			click(ELEMENT_DASHBOARD_WWREGION_DROPDOWN);
			Utils.pause(3000);
			break;
		case REGION:
			info("Click on Region dropdown");
			click(ELEMENT_DASHBOARD_REGION_DROPDOWN);
			Utils.pause(3000);
			break;
		case SUBREGION:
			info("Click on Region dropdown");
			click(ELEMENT_DASHBOARD_SUBREGION_DROPDOWN);
			Utils.pause(3000);
			break;
		case COUNTRY:
			info("Click on Region dropdown");
			click(ELEMENT_DASHBOARD_COUNTRY_DROPDOWN);
			Utils.pause(3000);
			break;
		case BUSSINESSUNIT:
			info("Click on BU dropdown");
			click(ELEMENT_DASHBOARD_BU_DROPDOWN);
			Utils.pause(3000);
			break;
		case ORDERREVS:
			break;
		case PRODUCTLINE:
			break;
		case RTMSEGMENT:
			info("Click on RTM dropdown");
			click(ELEMENT_DASHBOARD_RTM_DROPDOWN);
			Utils.pause(3000);
			break;
		case SALESREP:
			info("Click on Sale Rep dropdown");
			click(ELEMENT_DASHBOARD_SALESREP_DROPDOWN);
			Utils.pause(3000);
			break;
		case CHANNEL:
			break;
		case CHANNELTYPE:
			break;
		default:
			info("Not found this droplist in the dashboard");
			break;
		}
	}
	/**
	 * Verify a item of a dropdown list is shown 
	 * @param droplist
	 * @param item
	 */
	public void verifyDroplist(String droplist,String item){
			info("Verify that the :"+item+" is displayed in the list:"+droplist);
			waitForAndGetElement(ELEMENT_DASHBOARD_DROPLIST_ITEM.replace("$droplist",droplist).replace("$item",item),2000,1);
	}
	/**
	 * Verify that a item is not displayed in the drop list
	 * @param droplist
	 * @param item
	 */
	public void verifyNOTINDroplist(String droplist,String item){
		info("Verify that the :"+item+" isnot displayed in the list:"+droplist);
		waitForElementNotPresent(ELEMENT_DASHBOARD_DROPLIST_ITEM.replace("$droplist",droplist).replace("$item",item),2000,1);
}
	
	/**
	 * Select a item in a droplist
	 * @param droplist
	 * @param item
	 */
	public void selectDroplist(String droplist,String item,Object... params){
		    Boolean isClear=(Boolean)(params.length>0? params[0]:true);
		    if(isClear){
		    	info("Uncheck WW region checkbox");
		    	uncheck(ELEMENT_DASHBOARD_DROPLIST_ITEM.replace("$droplist","WW Region").replace("$item","WW"),2);
		    }
			info("Select:"+item+" on the droplist:"+droplist);
			check(ELEMENT_DASHBOARD_DROPLIST_ITEM.replace("$droplist",droplist).replace("$item",item),2);
			Utils.pause(3000);
	}

}
