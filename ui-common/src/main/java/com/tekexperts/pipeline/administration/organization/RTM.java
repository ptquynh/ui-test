package com.tekexperts.pipeline.administration.organization;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class RTM extends PipelineBase{
	//RTM page title
	public By ELEMENT_RTM_TITLE = By.xpath(".//*[@id='right-side']//h1[contains(text(),'RTM')]");
	//Breadcrumb
	public String ELEMENT_RTM_BREADCRUMB_LINKS=".//*[@id='right-side']//ol[@class='breadcrumb']//*[contains(text(),'$link')]";
	//Add button
	public By ELEMENT_RTM_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Team/Create?Length=4']");
	//Name filter field
	public By ELEMENT_RTM_NAME_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol1_I']");
	//Status filter field
	public By ELEMENT_RTM_STATUS_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_I']");
	public By ELEMENT_RTM_STATUS_DROPLIST=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_D']");
  	public By ELEMENT_RTM_STATUS_ACTIVE=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI1T0']");
	public By ELEMENT_RTM_STATUS_DISABLE=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI2T0']");
	public By ELEMENT_RTM_STATUS_ALL=By.xpath(".//*[@id='gvTeam_DXFREditorcol2_DDD_L_LBI0T0']");
	//Description filter field
	public By ELEMENT_RTM_DESCRIPTION_FILTER=By.xpath(".//*[@id='gvTeam_DXFREditorcol3_I']");
	//Edit a RTM
	public String ELEMENT_RTM_NAME_LINK=".//*[@id='gvTeam_DXMainTable']//*[contains(text(),'$name')]";
	//Error message
	public String ELEMENT_ERROR_MESSAGE=".//*[@id='validationSummary']//*[contains(text(),'$error')]";
	
	//Pagging size
	public String ELEMENT_RTM_PAGESIZE_DROPBOX_ITEM=".//*[contains(@id,'gvTeam_DXPagerBottom_PSP_DXI')]//*[text()='$size']";
	public By ELEMENT_RTM_PAGESIZE_DROPBOX_INPUT=By.xpath(".//*[@id='gvTeam_DXPagerBottom_PSI']");
	public By ELEMENT_RTM_PAGESIZE_DROPBOX=By.xpath(".//*[@id='gvTeam_DXPagerBottom_PSB']");
	public By ELEMENT_RTM_TABLE=By.xpath(".//*[contains(@id,'gvTeam_DXData')]");
	
	//******************ADD/EDIT RTM****************************************\\
	//ADD RTM page title
	public By ELEMENT_ADD_RTM_TITLE = By.xpath(".//*[@id='right-side']//h1[contains(text(),'Add RTM')]");
	//EDIT RTM page title
	public By ELEMENT_EDIT_RTM_TITLE = By.xpath(".//*[@id='right-side']//h1[contains(text(),'Edit RTM')]");
	//Name field
	public By ELEMENT_RTM_ADDEDIT_NAME_FIELD=By.xpath(".//*[@id='Name']");
	//State field
	public By ELEMENT_RTM_ADDEDIT_STATE_FIELD=By.xpath(".//*[@id='Status']");
	//Description
	public By ELEMENT_RTM_ADDEDIT_DESCRIPTION_FIELD=By.xpath(".//*[@id='Description']");
	//Cancel button
	public By ELEMENT_RTM_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_RTM_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	public RTM(WebDriver dr){
		driver = dr;
	}
	
	/**
	 * Open Add RTM page
	 */
	public void goToAddRTM(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_RTM_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_RTM_ADD_BTN);
		info("Add region page is shown");
		waitForAndGetElement(ELEMENT_ADD_RTM_TITLE,3000,1);
	}
	/**
	 * Open Edit page
	 * @param name
	 */
	public void goToEditRTM(String name){
		info("Click on a rtm link");
		click(ELEMENT_RTM_NAME_LINK.replace("$name",name));
		info("Verify that Edit page is shown");
		waitForAndGetElement(ELEMENT_EDIT_RTM_TITLE,2000,1);
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_RTM_ADDEDIT_CANCEL_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_RTM_TITLE,3000,1);
	}
	/**
	 * Verify that a RTM is shown in the table
	 * @param name
	 */
	public void verifyRTMInTheTable(String name){
		info("Verify that the RTM is shown in the table");
		waitForAndGetElement(ELEMENT_RTM_NAME_LINK.replace("$name",name),3000,1);
		info("The RTM is shown in the table");
	}
	
	/**
	 * Verify that a RTM isnot shown in the table
	 * @param name
	 */
	public void verifyRTMNOTInTheTable(String name){
		info("Verify that the RTM isnot shown in the table");
		waitForElementNotPresent(ELEMENT_RTM_NAME_LINK.replace("$name",name),3000,1);
		info("The RTM is shown in the table");
	}
	/**
	 * Search a RTM by name
	 * @param name
	 */
	public void searchByName(String name){
		info("Search a rtm in the table by name");
		type(ELEMENT_RTM_NAME_FILTER,name,true);
		Utils.pause(3000);
	}
	/**
	 * Search  a rtm by description
	 * @param des
	 */
	public void searchByDes(String des){
		info("Search a rtm in the table by description");
		type(ELEMENT_RTM_DESCRIPTION_FILTER,des,true);
		Utils.pause(3000);
	}
	/**
	 * Search a RTM by status
	 * @param isActive
	 * @param isAll
	 */
	public void searchByStatus(Boolean isActive, Boolean isAll){
		info("Search a BU in the table by status");
		waitForAndGetElement(ELEMENT_RTM_STATUS_FILTER).click();
		waitForAndGetElement(ELEMENT_RTM_STATUS_DROPLIST,3000,1,2);
		info("Status drop list is shown");
		if(!isActive)
			waitForAndGetElement(ELEMENT_RTM_STATUS_DISABLE).click();
		if(isAll)
			waitForAndGetElement(ELEMENT_RTM_STATUS_ALL).click();
		Utils.pause(3000);
	}
	
	/**
	 * Verify that a link is shown in the breadcrumb
	 * @param link
	 */
	public void verifyBreadcrumb(String link){
		info("Verify that a link:"+link+" is displayed in the breadcrumb");
		waitForAndGetElement(ELEMENT_RTM_BREADCRUMB_LINKS.replace("$link",link),3000,1);
	}
	/**
	 * Click on a link on the breadcrumb
	 * @param link
	 */
	public void clickBreadcrumb(String link){
		info("Click on a link:"+link+" is displayed in the breadcrumb");
		click(ELEMENT_RTM_BREADCRUMB_LINKS.replace("$link",link));
		Utils.pause(3000);
	}
	/**
	 * Add a new RTM
	 * @param name
	 * @param state
	 * @param description
	 * @param params
	 */
	public void add(String name,String state,String description,Object... params){
		Boolean isSave =(Boolean)(params.length>0?params[0]:true);
		if(!name.isEmpty()){
			info("Input a name");
			type(ELEMENT_RTM_ADDEDIT_NAME_FIELD,name,true);
		}
		if(!state.isEmpty()){
			info("Select a state");
			select(ELEMENT_RTM_ADDEDIT_STATE_FIELD,state,2);
		}
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_RTM_ADDEDIT_DESCRIPTION_FIELD,description,true);
		}
		if(isSave){
			info("Click on Save button");
			save();
		}
	}
	/**
	 * Save all changes
	 * @param params
	 */
	public void save(Object... params){
		Boolean isVerify =(Boolean)(params.length>0?params[0]:true);
		info("Click on Save button");
		click(ELEMENT_RTM_ADDEDIT_SAVE_BTN);
		if(isVerify)
			waitForAndGetElement(ELEMENT_RTM_TITLE,3000,1);
		Utils.pause(3000);
	}
	/**
	 * Edit a RTM
	 * @param name
	 * @param state
	 * @param description
	 * @param params
	 */
	public void edit(String name,String state,String description,Object... params){
		Boolean isSave =(Boolean)(params.length>0?params[0]:true);
		if(!name.isEmpty()){
			info("Input a name");
			type(ELEMENT_RTM_ADDEDIT_NAME_FIELD,name,true);
		}
		if(!state.isEmpty()){
			info("Select a state");
			select(ELEMENT_RTM_ADDEDIT_STATE_FIELD,state,2);
		}
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_RTM_ADDEDIT_DESCRIPTION_FIELD,description,true);
		}
		if(isSave){
			info("Click on Save button");
			save();
		}
	}
	/**
	 * Verify that a error message is shown
	 * @param error
	 */
	public void verifyErrorMesg(String error){
		info("Verify that a error message as:"+error+" is shown");
		waitForAndGetElement(ELEMENT_ERROR_MESSAGE.replace("$error",error),2000,1);
		info("Verify that still stay at Add reigon page");
		waitForAndGetElement(ELEMENT_RTM_ADDEDIT_SAVE_BTN,2000,1);
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
				info("i:"+i);
				info("j:"+j);
				info("default:"+defaultValue);
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
		String defaultValue=waitForAndGetElement(ELEMENT_RTM_PAGESIZE_DROPBOX_INPUT).getAttribute("value").toString();
		return Integer.parseInt(defaultValue);
		
	}
	
	/**
	 * count the row in the table
	 * @return the number of data is shown
	 */
	public Integer getNumberRow(){
		info("Get all curren rows are displaying in the table");
		return driver.findElements(ELEMENT_RTM_TABLE).size();
		
	}
	
	/**
	 * Change page size
	 * @param size
	 */
	public void changePageSize(String size){
		info("Click on the dropbox page size");
		waitForAndGetElement(ELEMENT_RTM_PAGESIZE_DROPBOX,2000,1).click();
		Utils.pause(3000);
		info("Select the number:"+size+" in the dropbox");
		waitForAndGetElement(ELEMENT_RTM_PAGESIZE_DROPBOX_ITEM.replace("$size",size),2000,1).click();
		Utils.pause(3000);
	}
	
}
