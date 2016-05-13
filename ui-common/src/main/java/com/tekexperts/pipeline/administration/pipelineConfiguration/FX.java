package com.tekexperts.pipeline.administration.pipelineConfiguration;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class FX extends PipelineBase{

	//Choose file btn
	public By ELEMENT_FX_CHOOSEFILE_BTN=By.xpath(".//*[@id='form0']//input[@name='fileUpload']");
	//Month dropbox
	public By ELEMENT_FX_MONTH_DROPBOX=By.xpath(".//*[@id='month']");
	//Year dropbox
	public By ELEMENT_FX_YEAR_DROPBOX=By.xpath(".//*[@id='year']");
	//Import button
	public By ELEMENT_FX_IMPORT_BTN=By.xpath(".//*[@id='form0']//button[contains(text(),'Import')]");
	//FX file name in the table
	public String ELEMENT_FX_FILE_NAME=".//*[@id='gvFxFile_DXMainTable']//*[contains(text(),'$date')]/../..//*[contains(text(),'$file')]";
	//Milestone filter
	public By ELEMENT_FX_MILESTONE_FILER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol1_I']");
	//Status filter
	public By ELEMENT_FX_STATUS_FILTER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol2_I']");
	//File name filter
	public By ELEMENT_FX_FILENAME_FILTER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol3_I']");
	//File size filter
	public By ELEMENT_FX_FILESIZE_FILTER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol4_I']");
	//Upload date filter
	public By ELEMENT_FX_UPLOADDATE_FILTER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol5_I']");
	//Upload By filter
	public By ELEMENT_FX_UPLOADBY_FILTER=By.xpath(".//*[@id='gvFxFile_DXFREditorcol6_I']");
	//Label on header bar
	public String ELEMENT_FX_HEADERBAR_LABEL="//*[@class='navbar-center']//*[contains(text(),'$value')]";
	
	public FX(WebDriver dr) {
		driver =dr;
	}
    /**
     * Upload a FX file
     * @param path
     * @param fileName
     * @param month 
     *             = {Apr,May,Jun,....}
     * @param year
     *             = 3 last years from now as: {2015,2016,2017}
     */
	public void upload(String path, String fileName,String month,String year){
		info("Click on Choose file button");
		waitForAndGetElement(ELEMENT_FX_CHOOSEFILE_BTN).sendKeys(path+fileName);
		if(!month.isEmpty())
			select(ELEMENT_FX_MONTH_DROPBOX,month,2);
		if(!year.isEmpty())
			select(ELEMENT_FX_YEAR_DROPBOX,year,2);
		info("Click on Import button");
		click(ELEMENT_FX_IMPORT_BTN);
		Utils.pause(3000);
	}
	/**
	 * Verify that the file is displayed in the table
	 * @param fileName
	 * @param month
	 * @param year
	 */
	public void checkFile(String fileName,String month,String year){
		info("Verify that the upload file is shown in the table");
		waitForAndGetElement(ELEMENT_FX_FILE_NAME.replace("$date",month+"-"+year).replace("$file",fileName),3000,1);
		info("The file is shown in the table");
	}
	/**
	 * check FX when it is changed
	 * @param date
	 */
	public void checkChangedFX(String date){
		info("Verify that a new FX is changed and displayed on the header bar");
		waitForAndGetElement(ELEMENT_FX_HEADERBAR_LABEL.replace("$value",date),3000,1);
		info("The FX is changed successfully");
	}
	/**
	 * Search a file by file name
	 * @param file
	 */
	public void searchByFileName(String file){
		info("Type a file into File name search field");
		type(ELEMENT_FX_FILENAME_FILTER,file,true);
		Utils.pause(3000);
	}
}
