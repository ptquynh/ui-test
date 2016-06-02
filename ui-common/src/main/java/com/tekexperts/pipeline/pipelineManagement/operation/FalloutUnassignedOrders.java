package com.tekexperts.pipeline.pipelineManagement.operation;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class FalloutUnassignedOrders extends PipelineBase{
	
     //No display data in the list
	public By ELEMENT_UNASSIGNEDORDER_NO_DISPLAY_DATA=By.xpath(".//*[@id='UnassignOrder_DXEmptyRow']//*[contains(text(),'No data to display')]");
	
	//*************************FILTERS****************************\\
	//Previous doc
	public By ELEMENT_UNASSIGNEDORDER_PREVDOC_FILTER=By.xpath(".//*[@id='UnassignOrder_DXFREditorcol8_I']");
	
	//business Unit
	public By ELEMENT_UNASSIGNEDORDER_BU_FILTER=By.xpath(".//*[@id='UnassignOrder_DXFREditorcol11_I']");
	
	//business area
	public By ELEMENT_UNASSIGNEDORDER_BA_FILTER=By.xpath(".//*[@id='UnassignOrder_DXFREditorcol7_I']");
	
	//REGION
	public By ELEMENT_UNASSIGNEDORDER_REGION_FILTER=By.xpath(".//*[@id='UnassignOrder_DXFREditorcol10_I']");
	
	
	//*****************************UNASSIGNED ORDERS******************************\\
	public String ELEMENT_UNASSIGNEDORDER_RULE1=".//*[contains(@id,'UnassignOrder_DXDataRow')]/..//*[text()='$bu']/..//*[text()='$pro']/..//*[text()='$country']";
	public String ELEMENT_UNASSIGNEDORDER_RULE2=".//*[contains(@id,'UnassignOrder_DXDataRow')]/..//*[text()='$bu']/..//*[text()='$country']";
	
	//Paging size
	public String ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX_ITEM=".//*[contains(@id,'UnassignOrder_DXPagerBottom_PSP_DXI')]//*[text()='$size']";
	public By ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX_INPUT=By.xpath(".//*[@id='UnassignOrder_DXPagerBottom_PSI");
	public By ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX=By.xpath(".//*[@id='UnassignOrder_DXPagerBottom_DDB']");
	public By ELEMENT_UNASSIGNEDORDER_TABLE=By.xpath(".//*[contains(@id,'UnassignOrder_DXData')]");
	
	public FalloutUnassignedOrders(WebDriver dr){
		driver = dr;
	}
	
	
	/**
	 * Verify that a order is shown in the list
	 * @param bu
	 * @param country
	 * @param product
	 */
	public void verifyUnassignRule(String bu,String country,String product){
		   if(!bu.isEmpty()&& !country.isEmpty()&& !product.isEmpty()){
			   info("Verify that a order has business unit as:"+bu+ "belong to the country:"+country+" has product line as:"+product+" is displayed in the list");
				waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_RULE1
						.replace("$bu",bu)
						.replace("$pro",product)
						.replace("$country",country));
		   }
		   if(!bu.isEmpty()&& !country.isEmpty()&& product.isEmpty()){
			   info("Verify that a order has business unit as:"+bu+ "belong to the country:"+country+" is displayed in the list");
				waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_RULE2
						.replace("$bu",bu)
						.replace("$country",country));
		   }
	}
	
	public void verifyNOTUnassignRule(String bu,String country,String product){
		   if(!bu.isEmpty()&& !country.isEmpty()&& !product.isEmpty()){
			   info("Verify that a order has business unit as:"+bu+ "belong to the country:"+country+" has product line as:"+product+" is not displayed in the list");
				waitForElementNotPresent(ELEMENT_UNASSIGNEDORDER_RULE1
						.replace("$bu",bu)
						.replace("$pro",product)
						.replace("$country",country));
		   }
		   if(!bu.isEmpty()&& !country.isEmpty()&& product.isEmpty()){
			   info("Verify that a order has business unit as:"+bu+ "belong to the country:"+country+" is not displayed in the list");
			   waitForElementNotPresent(ELEMENT_UNASSIGNEDORDER_RULE2
						.replace("$bu",bu)
						.replace("$country",country));
		   }
	}
	
	public enum filterUnassigned{
		PREVIOUS_DOC,BUSSINESS_UNIT,BUSINESS_AREA,REGION;
	}
	/**
	 * Filter data in Unassigned orders tab
	 * @param filterCol
	 * @param text
	 */
	public void filterBy(filterUnassigned filterCol,String text){
		Actions act = new Actions(this.driver);
		switch(filterCol){
		case PREVIOUS_DOC:
			info("Filter data by Previous number");
			act.moveToElement(this.driver.findElement(ELEMENT_UNASSIGNEDORDER_PREVDOC_FILTER)).perform();
			type(ELEMENT_UNASSIGNEDORDER_PREVDOC_FILTER,text,true);
			Utils.pause(3000);
			break;
		case BUSSINESS_UNIT:
			info("Filter data by Business Unit");
			act.moveToElement(this.driver.findElement(ELEMENT_UNASSIGNEDORDER_BU_FILTER)).perform();
			type(ELEMENT_UNASSIGNEDORDER_BU_FILTER,text,true);
			Utils.pause(3000);
			break;
		case BUSINESS_AREA:
			info("Filter data by Product line");
			act.moveToElement(this.driver.findElement(ELEMENT_UNASSIGNEDORDER_BA_FILTER)).perform();
			type(ELEMENT_UNASSIGNEDORDER_BA_FILTER,text,true);
			Utils.pause(3000);
			break;
		case REGION:
			info("Filter data by Region");
			act.moveToElement(this.driver.findElement(ELEMENT_UNASSIGNEDORDER_REGION_FILTER)).perform();
			type(ELEMENT_UNASSIGNEDORDER_REGION_FILTER,text,true);
			Utils.pause(3000);
			break;
		default:
			info("Not found the column.");
			break;
		}
	}
	
	/**
	 * Verify paging size
	 * @param list
	 */
	public void checkPageSize(String[] list){
		for(String el:list){
			int j=Integer.parseInt(el);
			int defaultValue=getDefaulPageSize();
			if(defaultValue!=j){
				changePageSize(el);
				int i=getNumberRow();
				if(i<defaultValue && i>j)assert false:"The page size is not correct";
			}
		}
	}
	
	/**
	 * Get default value of page size
	 * @return default value
	 */
	public Integer getDefaulPageSize(){
		info("Get default value of the page size");
		String defaultValue=waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX_INPUT).getAttribute("value").toString();
		return Integer.parseInt(defaultValue);
		
	}
	
	/**
	 * count the row in the table
	 * @return the number of data is shown
	 */
	public Integer getNumberRow(){
		info("Get all curren rows are displaying in the table");
		return driver.findElements(ELEMENT_UNASSIGNEDORDER_TABLE).size();
		
	}
	
	/**
	 * Change page size
	 * @param size
	 */
	public void changePageSize(String size){
		info("Click on the dropbox page size");
		waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX,2000,1).click();
		Utils.pause(3000);
		info("Select the number:"+size+" in the dropbox");
		waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_PAGESIZE_DROPBOX_ITEM.replace("$size",size),2000,1).click();
		Utils.pause(3000);
	}
	/**
	 * Verify that no data is displayed in the list
	 */
	public void verifyNoDisplayData(){
		info("Verify that no data is displayed in the list");
		waitForAndGetElement(ELEMENT_UNASSIGNEDORDER_NO_DISPLAY_DATA,2000,1);
	}
	
}
