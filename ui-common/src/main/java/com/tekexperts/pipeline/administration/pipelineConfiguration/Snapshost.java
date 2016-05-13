package com.tekexperts.pipeline.administration.pipelineConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.tekexperts.pipeline.common.TestLogger.info;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class Snapshost extends PipelineBase {
    
	//Name field
	public By ELEMENT_SNAPSHOT_NAME_FIELD=By.xpath(".//*[@id='Name']");
	//Date field
	public By ELEMENT_SNAPSHOT_DATE_FIELD=By.xpath(".//*[@id='Milestone']");
	//Add button
	public By ELEMENT_SNAPSHOT_ADD_BTN=By.xpath(".//*[@id='form0']//button[contains(text(),'Add')]");
	//Name filter
	public By ELEMENT_SNAPSHOT_NAME_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol0_I']");
	//Date point filter
	public By ELEMENT_SNAPSHOT_DATEPOINT_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol1_I']");
	//Submitted regions filter
	public By ELEMENT_SNAPSHOT_SUBMITTEDREGION_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol2_I']");
	//Status filter
	public By ELEMENT_SNAPSHOT_STATUS_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol3_I']");
	//Created Date filter
	public By ELEMENT_SNAPSHOT_CREATEDDATE_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol4_I']");
	//By filter
	public By ELEMENT_SNAPSHOT_BY_FILTER=By.xpath(".//*[@id='gvSnapShot_DXFREditorcol5_I']");
	//Delete link
	public String ELEMENT_SNAPSHOT_DELETE_LINK=".//*[@id='gvSnapShot_DXMainTable']//*[contains(text(),'$name')]/../..//*[contains(text(),'Delete')]";
	//Snapshot's name
	public String ELEMENT_SNAPSHOT_NAME_LINK=".//*[@id='gvSnapShot_DXMainTable']//*[contains(text(),'$name')]";
	
	public Snapshost(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Add a new snapshot
	 * @param name
	 * @param date
	 */
	public void add(String name,String date){
		info("Type a new name");
		type(ELEMENT_SNAPSHOT_NAME_FIELD,name,true);
		info("Input a date");
		type(ELEMENT_SNAPSHOT_DATE_FIELD,date,true);
		info("Click on Add button");
		click(ELEMENT_SNAPSHOT_ADD_BTN);
		Utils.pause(3000);
	}
	/**
	 * Search a snapshot by name
	 * @param name
	 */
	public void searchByName(String name){
		info("Type a name in the filter");
		type(ELEMENT_SNAPSHOT_NAME_FILTER,name,true);
		Utils.pause(3000);
	}
	/**
	 * Verify that a snapshot is shown in the table
	 * @param name
	 */
	public void verifySnapshotInTable(String name){
		info("verify that the snapshot is shown in the table");
		waitForAndGetElement(ELEMENT_SNAPSHOT_NAME_LINK.replace("$name",name),3000,1);
		info("The snapshot is shown in the table");
	}

}
