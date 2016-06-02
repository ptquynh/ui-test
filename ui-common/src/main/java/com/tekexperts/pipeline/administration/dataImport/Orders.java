package com.tekexperts.pipeline.administration.dataImport;

import static com.tekexperts.pipeline.common.TestLogger.info;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class Orders extends PipelineBase{
	//Columns
	public String ELEMENT_ORDER_VIEWDETAIL_CONTENT_COL=".//*[contains(@id,'gvOrder_DXDataRow')]//td[$col]";
	public By ELEMENT_ORDER_VIEWDETAIL_CONTENT_NUMBER_COL=By.xpath(".//*[contains(@id,'gvOrder_DXDataRow0')]//td");
	//Breadcrumb
	public String ELEMENT_ORDER_BREADCRUMB_LINKS=".//*[@id='right-side']//ol[@class='breadcrumb']//*[contains(text(),'$link')]";
	
	//View detail order
	public By ELEMENT_ORDER_VIEW_BTN=By.xpath(".//*[@id='frmImportOrder']//*[contains(@onclick,'/ImportOrder/Orders')]");
	public By ELEMENT_ORDER_VIEWDETAIL_VIEW_BTN=By.xpath(".//*[@id='btnViewg']");
	//View detail page title
	public By ELEMENT_ORDER_VIEWDEAIL_TABLE=By.xpath(".//*[@id='gvOrder']");
	
	//Content of columns
	public String ELEMENT_ORDER_VIEWDETAIL_CONTENT=".//*[contains(@id,'gvOrder_DXDataRow')]//td[$col][contains(text(),'$text')]";

	//Export button
	public By ELEMENT_ORDER_VIEWDETAIL_EXPORT_BTN=By.xpath(".//*[@id='btnExport']");

	//Choose file filed
	public By ELEMENT_ORDER_CHOOSEFILE_BTN=By.xpath(".//*[@id='frmImportOrder']//input[@name='fileUpload']");
	//Import button
	public By ELEMENT_ORDER_IMPORT_BTN=By.xpath(".//*[@id='btnImportOrder']");
	//File name filter
	public By ELEMENT_ORDER_FILENAME_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol1_I']");
	//File sixe filter
	public By ELEMENT_ORDER_FILESIZE_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol2_I']");
	//Upload data filter
	public By ELEMENT_ORDER_UPLOADDATE_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol3_I']");
	//Upload by filter
	public By ELEMENT_ORDER_UPLOADBY_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol4_I']");
	//File name link
	public String ELEMENT_ORDER_FILENAME_LINK=".//*[@id='gvImportOrder_DXMainTable']//*[contains(text(),'$file')]";
	
	//Paging size
	public String ELEMENT_ORDER_PAGESIZE_DROPBOX_ITEM=".//*[contains(@id,'gvImportOrder_DXPagerBottom_PSP_DXI')]//*[text()='$size']";
	public By ELEMENT_ORDER_PAGESIZE_DROPBOX_INPUT=By.xpath(".//*[@id='gvImportOrder_DXPagerBottom_PSI']");
	public By ELEMENT_ORDER_PAGESIZE_DROPBOX=By.xpath(".//*[@id='gvImportOrder_DXPagerBottom_DDB']");
	public By ELEMENT_ORDER_TABLE=By.xpath(".//*[contains(@id,'gvImportOrder_DXData')]");
	
	//Delete data button
	public By ELEMENT_ORDER_DELETE_DATA_BTN=By.xpath(".//*[@id='btnDeletedata']");
	
	//Confirm popup
	public By ELEMENT_ORDER_CONFIRM_DELETE_OK_BTN=By.xpath("//*[@class='jconfirm-box']//button[1]");
	public By ELEMENT_ORDER_NO_DISPLAY_DATA=By.xpath(".//*[@id='gvImportOrder_DXEmptyRow']//*[contains(text(),'No data to display')]");
	
	//**************************FILTER DROPDOWN*********************************\\
	//ww REGION dropbox
	public String ELEMENT_ORDER_VIEWDETAIL_WWREGION_DEFAULT=".//*[@id='ddlWWWRegion']//*[@selected='selected'][contains(text(),'$value')]";
	public By ELEMENT_ORDER_WWREGION_DROPBOX=By.xpath(".//*[@id='ddlWWWRegion']");
	//Region dropbox
	public By ELEMENT_ORDER_REGION_DROPBOX=By.xpath(".//*[@id='form0']//*[contains(text(),'Region')]/..//button[@data-toggle='dropdown']");
	//Business Unit dropbox
	public By ELEMENT_ORDER_BU_DROPBOX=By.xpath(".//*[@id='form0']//*[contains(text(),'Business Unit')]/..//button[@data-toggle='dropdown']");
	//Dropdown list items
	public String ELEMENT_ORDER_VIEWDETAIL_DROPLIST_ITEM=".//*[contains(text(),'$droplist')]/../..//*[contains(text(),'$item')]//input";
	
	//******************************FILTER IN VIEW DETAIL PAGE**************************\\
	//Previous number filter
	public By ELEMENT_ORDER_VIEWDETAIL_PREVIOUS_NBR=By.xpath(".//*[@id='gvOrder_DXFREditorcol46_I']");
	//Business Unit filter
	public By ELEMENT_ORDER_VIEWDETAIL_BU=By.xpath(".//*[@id='gvOrder_DXFREditorcol52_I']");
	//Business Area Code filter
	public By ELEMENT_ORDER_VIEWDETAIL_BA=By.xpath(".//*[@id='gvOrder_DXFREditorcol26_I']");
	//Region filter
	public By ELEMENT_ORDER_VIEWDETAIL_REGION=By.xpath(".//*[@id='gvOrder_DXFREditorcol68_I']");
	
	//**********************************Assign verify*******************\\
	public String ELEMENT_ORDER_VIEWDETAIL_ASSIGN=".//*[contains(@id,'gvOrder_DXDataRow')]//*[text()='$prev']/..//*[text()='$bu']/..//*[text()='$region']/..//*[text()='$user']";
	public String ELEMENT_ORDER_VIEWDETAIL_ASSIGN_2=".//*[contains(@id,'gvOrder_DXDataRow')]//*[text()='$prev']/..//*[text()='$bu']/..//*[text()='$region']/..//*[contains(text(),'$profitLevel5')]/..//*[text()='$user']";
	public String ELEMENT_ORDER_VIEWDETAIL_ASSIGN_3=".//*[contains(@id,'gvOrder_DXDataRow')]//*[text()='$prev']/..//*[text()='$bu']/..//*[text()='$user']";
	public String ELEMENT_ORDER_VIEWDETAIL_ASSIGN_4=".//*[contains(@id,'gvOrder_DXDataRow')]//*[text()='$prev']/..//*[text()='$bu']/..//*[text()='$pro']/..//*[text()='$user']";
	
	public Orders(WebDriver dr){
		driver = dr;
	}
	/**
	 * Verify WWregion default is shown
	 * @param value
	 */
	public void verifyWWRegionDefault(String value){
		info("Verify that WWRegion default is "+ value);
		waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_WWREGION_DEFAULT.replace("$value",value), 2000,1);
	}
	
	/**
	 * Upload a file 
	 * @param path
	 * @param fileName
	 */
	public void upload(String path,String fileName,Object... params){
		Boolean isVerify=(Boolean)(params.length>0?params[0]:true);
		info("Click on Choose file button");
		info("path:"+path);
		info("fileName:"+fileName);
		info("path+fileName:"+path+fileName);
		waitForAndGetElement(ELEMENT_ORDER_CHOOSEFILE_BTN).sendKeys(path+fileName);
		info("Click on Import button");
		click(ELEMENT_ORDER_IMPORT_BTN);
		if(isVerify){
			info("Verify that the upload file is shown in the table");
			waitForAndGetElement(ELEMENT_ORDER_FILENAME_LINK.replace("$file",fileName),3000,1);
		}
		Utils.pause(3000);
	}
	
	/**
	 * Verify that a link is shown in the breadcrumb
	 * @param link
	 */
	public void verifyBreadcrumb(String link){
		info("Verify that a link:"+link+" is displayed in the breadcrumb");
		waitForAndGetElement(ELEMENT_ORDER_BREADCRUMB_LINKS.replace("$link",link),3000,1);
	}
	/**
	 * Click on a link on the breadcrumb
	 * @param link
	 */
	public void clickBreadcrumb(String link){
		info("Click on a link:"+link+" is displayed in the breadcrumb");
		click(ELEMENT_ORDER_BREADCRUMB_LINKS.replace("$link",link));
		Utils.pause(3000);
	}
	/**
	 * Define column filters for contract list
	 */
	public enum orderFilter{
		FILE_NAME,FILE_SIZE,UPLOAD_DATE,UPLOAD_BY;
	}
	
	/**
	 * Filter contract
	 * @param col
	 * @param searchText
	 */
	public void searchBy(orderFilter col,String searchText){
		switch(col){
		case FILE_NAME:
			info("Search by file name column");
			type(ELEMENT_ORDER_FILENAME_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case FILE_SIZE:
			info("Search by file size column");
			type(ELEMENT_ORDER_FILESIZE_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case UPLOAD_DATE:
			info("Search by upload date column");
			type(ELEMENT_ORDER_UPLOADDATE_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case UPLOAD_BY:
			info("Search by upload by column");
			type(ELEMENT_ORDER_UPLOADBY_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		default:
			info("Not found the column in the table");
			break;
		}
	}
	/**
	 * Verify that a order is shown in the table
	 * @param fileName
	 * @param params
	 */
	public void verifyOrderInTable(String fileName,Object... params){
		Boolean isShown=(Boolean)(params.length>0? params[0]:true);
		if(isShown){
			info("Verify that the upload file is shown in the table");
			info("importedFile:"+fileName);
			waitForAndGetElement(ELEMENT_ORDER_FILENAME_LINK.replace("$file",fileName),3000,1);
		}else{
			info("Verify that the file is not shown in the table");
			waitForElementNotPresent(ELEMENT_ORDER_FILENAME_LINK.replace("$file",fileName),3000,1);
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
		String defaultValue=waitForAndGetElement(ELEMENT_ORDER_PAGESIZE_DROPBOX_INPUT).getAttribute("value").toString();
		return Integer.parseInt(defaultValue);
		
	}
	
	/**
	 * count the row in the table
	 * @return the number of data is shown
	 */
	public Integer getNumberRow(){
		info("Get all curren rows are displaying in the table");
		return driver.findElements(ELEMENT_ORDER_TABLE).size();
		
	}
	
	/**
	 * Change page size
	 * @param size
	 */
	public void changePageSize(String size){
		info("Click on the dropbox page size");
		waitForAndGetElement(ELEMENT_ORDER_PAGESIZE_DROPBOX,2000,1).click();
		Utils.pause(3000);
		info("Select the number:"+size+" in the dropbox");
		waitForAndGetElement(ELEMENT_ORDER_PAGESIZE_DROPBOX_ITEM.replace("$size",size),2000,1).click();
		Utils.pause(3000);
	}
	
	/**
	 * Open detail first contract
	 */
	public void goToViewDetail(){
		info("Click on View button");
		click(ELEMENT_ORDER_VIEW_BTN);
		waitForAndGetElement(ELEMENT_ORDER_VIEWDEAIL_TABLE,3000,1);
		info("View detail page is shown");
	}
	/**
	 * Export the order
	 */
	public void export(){
		info("Click on Export button");
		click(ELEMENT_ORDER_VIEWDETAIL_EXPORT_BTN);
		Utils.pause(3000);
	}
	
	public enum filterDroplist{WWREGION,REGION,BUSINESS_UNIT};
	/**
	 * Select a value in dropdown list filter
	 * @param droplist
	 * @param value
	 */
	public void selectDropbox(filterDroplist droplist,String value,Object... params){
		Boolean isClear=(Boolean)(params.length>0? params[0]:true);
		switch(droplist){
		case WWREGION:
			info("Select a WWRegion");
			select(ELEMENT_ORDER_WWREGION_DROPBOX,value,2);
			Utils.pause(3000);
			break;
		case REGION:
			info("Select a Region");
			click(ELEMENT_ORDER_REGION_DROPBOX);
			Utils.pause(3000);
		    if(isClear){
		    	info("Uncheck All checkbox");
		    	uncheck(ELEMENT_ORDER_VIEWDETAIL_DROPLIST_ITEM.replace("$droplist","Region").replace("$item","All"),2);
		    }
			info("Select:"+value+" on the droplist:"+droplist);
			check(ELEMENT_ORDER_VIEWDETAIL_DROPLIST_ITEM.replace("$droplist","Region").replace("$item",value),2);
			Utils.pause(3000);
			break;
		case BUSINESS_UNIT:
			info("Select a Business Unit");
			click(ELEMENT_ORDER_BU_DROPBOX);
			Utils.pause(3000);
			info("Select:"+value+" on the droplist:"+droplist);
			check(ELEMENT_ORDER_VIEWDETAIL_DROPLIST_ITEM.replace("$droplist","Business Unit").replace("$item",value),2);
			Utils.pause(3000);
			break;
		default:
			info("Not found the droplist");
			break;
		}
		
	}
	/**
	 * Click on View button
	 */
	public void view(){
		info("Click on View button");
		click(ELEMENT_ORDER_VIEWDETAIL_VIEW_BTN);
		Utils.pause(3000);
	}
	
	/**
	 * Get all content of all columns in View detail page
	 * @return list
	 */
	public List<String> getContentAllColumns(){
		List<String> list= new ArrayList<String>();
		List<WebElement> listCol= this.driver.findElements(ELEMENT_ORDER_VIEWDETAIL_CONTENT_NUMBER_COL);
		info("listCol.size():"+listCol.size());
		for(int i=1;i<listCol.size();i++){
			info("i:"+i);
			if(i<(listCol.size()-4) || i==(listCol.size()-1) ){
				info("i1:"+i);
				String el=waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_CONTENT_COL
						.replace("$col",String.valueOf(i))).getText();
				if((el.contains("/") && el.contains("AM")) ||(el.contains("/") && el.contains("PM"))){
					String[] smallList=el.split(" ");
					el=smallList[0];
				}
				list.add(el);
			}
		}
			
		return list;
		
	}
	
	/**
	 * Verify the content of a column
	 * @param colNumber
	 * @param content
	 */
	public void verifyContentColumns(int colNumber,String content){
		info("Verify that the content of the columns:"+colNumber+" is shown with the content:"+content);
		waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_CONTENT
				.replace("$col",String.valueOf(colNumber)).replace("$text",content),2000,1);
	}
	/**
	 * Verify that a order is assigned to a user
	 * @param prev
	 * @param bu
	 * @param region
	 * @param country
	 * @param product
	 * @param assign
	 */
	public void verifyAssignRule(String prev,String bu,String region,String country,String product,String assign){
	   if(!bu.isEmpty()&& !region.isEmpty()&& country.isEmpty()&& product.isEmpty()){
		   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" is assinged to:"+assign);
			waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_ASSIGN
					.replace("$prev",prev)
					.replace("$bu",bu)
					.replace("$region",region)
					.replace("$user",assign));
	   }
	   if(!bu.isEmpty()&& !region.isEmpty()&& !country.isEmpty()&& product.isEmpty()){
		   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
		   		+ "the country as:"+country+" is assinged to:"+assign);
			waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_2
					.replace("$prev",prev)
					.replace("$bu",bu)
					.replace("$region",region)
					.replace("$profitLevel5",country)
					.replace("$user",assign));
	   }
	   
	   if(!bu.isEmpty()&& region.isEmpty()&& country.isEmpty()&& product.isEmpty()){
		   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
		   		+ "the country as:"+country+" is assinged to:"+assign);
			waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_3
					.replace("$prev",prev)
					.replace("$bu",bu)
					.replace("$user",assign));
	   }
	   
	   if(!bu.isEmpty()&& !product.isEmpty()&& region.isEmpty()&& country.isEmpty()){
		   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
		   		+ "the country as:"+country+" is assinged to:"+assign);
			waitForAndGetElement(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_4
					.replace("$prev",prev)
					.replace("$bu",bu)
					.replace("$pro",product)
					.replace("$user",assign));
	   }
		
	}
	/**
	 * Verify that a order is unassigned to a user
	 * @param prev
	 * @param bu
	 * @param region
	 * @param country
	 * @param product
	 * @param assign
	 */
	public void verifyNOTAssignRule(String prev,String bu,String region,String country,String product,String assign){
		   if(!bu.isEmpty()&& !region.isEmpty()&& country.isEmpty()&& product.isEmpty()){
			   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" is not assinged to:"+assign);
				waitForElementNotPresent(ELEMENT_ORDER_VIEWDETAIL_ASSIGN
						.replace("$prev",prev)
						.replace("$bu",bu)
						.replace("$region",region)
						.replace("$user",assign));
		   }
		   if(!bu.isEmpty()&& !region.isEmpty()&& !country.isEmpty()&& product.isEmpty()){
			   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
			   		+ "the country as:"+country+" is not assinged to:"+assign);
			   waitForElementNotPresent(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_2
						.replace("$prev",prev)
						.replace("$bu",bu)
						.replace("$region",region)
						.replace("$profitLevel5",country)
						.replace("$user",assign));
		   }
		   
		   if(!bu.isEmpty()&& region.isEmpty()&& country.isEmpty()&& product.isEmpty()){
			   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
			   		+ "the country as:"+country+" is not assinged to:"+assign);
			   waitForElementNotPresent(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_3
						.replace("$prev",prev)
						.replace("$bu",bu)
						.replace("$user",assign));
		   }
		   
		   if(!bu.isEmpty()&& !product.isEmpty()&& region.isEmpty()&& country.isEmpty()){
			   info("Verify that a order has previous doc:"+prev+" with a business unit as:"+bu+ "belong to Region:"+region+" of"
			   		+ "the country as:"+country+" is not assinged to:"+assign);
			   waitForElementNotPresent(ELEMENT_ORDER_VIEWDETAIL_ASSIGN_4
						.replace("$prev",prev)
						.replace("$bu",bu)
						.replace("$pro",product)
						.replace("$user",assign));
		   }
			
		}
	
	public enum filterViewDetail{
		PREVIOUS_DOC,BUSSINESS_UNIT,BUSINESS_AREA,REGION;
	}
	/**
	 * Filter data in View detail page
	 * @param filterCol
	 * @param text
	 */
	public void filterBy(filterViewDetail filterCol,String text){
		Actions act = new Actions(this.driver);
		switch(filterCol){
		case PREVIOUS_DOC:
			info("Filter data by Previous number");
			act.moveToElement(this.driver.findElement(ELEMENT_ORDER_VIEWDETAIL_PREVIOUS_NBR)).perform();
			type(ELEMENT_ORDER_VIEWDETAIL_PREVIOUS_NBR,text,true);
			Utils.pause(3000);
			break;
		case BUSSINESS_UNIT:
			info("Filter data by Business Unit");
			act.moveToElement(this.driver.findElement(ELEMENT_ORDER_VIEWDETAIL_BU)).perform();
			type(ELEMENT_ORDER_VIEWDETAIL_BU,text,true);
			Utils.pause(3000);
			break;
		case BUSINESS_AREA:
			info("Filter data by Product line");
			act.moveToElement(this.driver.findElement(ELEMENT_ORDER_VIEWDETAIL_BA)).perform();
			type(ELEMENT_ORDER_VIEWDETAIL_BA,text,true);
			Utils.pause(3000);
			break;
		case REGION:
			info("Filter data by Region");
			act.moveToElement(this.driver.findElement(ELEMENT_ORDER_VIEWDETAIL_REGION)).perform();
			type(ELEMENT_ORDER_VIEWDETAIL_REGION,text,true);
			Utils.pause(3000);
			break;
		default:
			info("Not found the column.");
			break;
		}
	}
	/**
	 * Verify that all data is deleted
	 * @param params
	 */
	public void delete(Object... params){
		Boolean isVerify=(Boolean)(params.length>0?params[0]:true);
		info("Click on Delete Data button");
		click(ELEMENT_ORDER_DELETE_DATA_BTN);
		waitForAndGetElement(ELEMENT_ORDER_CONFIRM_DELETE_OK_BTN,2000,1);
		click(ELEMENT_ORDER_CONFIRM_DELETE_OK_BTN);
		waitForElementNotPresent(ELEMENT_ORDER_CONFIRM_DELETE_OK_BTN,2000,1);
		if(isVerify){
			info("Verify that all data is deleted succefully");
			waitForAndGetElement(ELEMENT_ORDER_NO_DISPLAY_DATA,2000,1);
		}
	}
	
}
