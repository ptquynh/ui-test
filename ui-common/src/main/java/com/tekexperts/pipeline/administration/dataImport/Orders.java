package com.tekexperts.pipeline.administration.dataImport;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class Orders extends PipelineBase{

	//Choose file filed
	public By ELEMENT_DATAIMPORT_ORDER_CHOOSEFILE_BTN=By.xpath(".//*[@id='frmImportOrder']//input[@name='fileUpload']");
	//Import button
	public By ELEMENT_DATAIMPORT_ORDER_IMPORT_BTN=By.xpath(".//*[@id='btnImportOrder']");
	//File name filter
	public By ELEMENT_DATAIMPORT_ORDER_FILENAME_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol1_I']");
	//File sixe filter
	public By ELEMENT_DATAIMPORT_ORDER_FILESIZE_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol2_I']");
	//Upload data filter
	public By ELEMENT_DATAIMPORT_ORDER_UPLOADDATA_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol3_I']");
	//Upload by filter
	public By ELEMENT_DATAIMPORT_ORDER_UPLOADBY_FILTER=By.xpath(".//*[@id='gvImportOrder_DXFREditorcol4_I']");
	//View link
	public By ELEMENT_DATAIMPORT_ORDER_VIEW_BTN=By.xpath(".//*[@id='frmImportOrder']//button[contains(text(),'View')]");
	//File name link
	public String ELEMENT_DATAIMPORT_ORDER_FILENAME_LINK=".//*[@id='gvImportOrder_tccell0_1']//*[contains(text(),'$file')]";
		
	public Orders(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Upload a file 
	 * @param path
	 * @param fileName
	 */
	public void upload(String path,String fileName){
		info("Click on Choose file button");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ORDER_CHOOSEFILE_BTN).sendKeys(path+fileName);;
		info("Click on Import button");
		click(ELEMENT_DATAIMPORT_ORDER_IMPORT_BTN);
		info("Verify that the upload file is shown in the table");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ORDER_FILENAME_LINK.replace("$file",fileName),3000,1);
	}
}
