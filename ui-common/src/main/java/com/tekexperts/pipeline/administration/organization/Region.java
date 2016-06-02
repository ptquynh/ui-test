package com.tekexperts.pipeline.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class Region extends PipelineBase{
	//*********************HOME PAGE*******************************\\
	//Region home page title
	public By ELEMENT_REGION_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Region')]");
	//Select dropbox
	public By ELEMENT_REGION_STATUS_DROPBOX=By.xpath(".//*[@id='ddlStatus']");
	//Add button
	public By ELEMENT_REGION_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/Region/Create?Length=6']");
    //Edit a region
	public String ELEMENT_REGION_NAME_LINK=".//*[contains(@id,'tlRegion')]//*[contains(text(),'$region')]";
	//Assign manager and Delegate
	public String ELEMENT_REGION_MANAGED_BY_LINK=".//*[contains(text(),'$region')]/../..//*[contains(@class,'dxtl__B0')][5]/a";
	public String ELEMENT_REGION_MANAGED_BY_NAME=".//*[contains(text(),'$region')]/../..//*[contains(text(),'$name')]";
	
	//Breadcrumb
	public String ELEMENT_REGION_BREADCRUMB_LINKS=".//*[@id='right-side']//ol[@class='breadcrumb']//*[contains(text(),'$link')]";
	//Tree
	public String ELEMENT_REGION_COLLAPSE_NODE=".//*[contains(text(),'$node')]/../..//img[contains(@alt,'[Collapse]')]";
	public String ELEMENT_REGION_EXPAND_NODE=".//*[contains(text(),'$node')]/../..//img[contains(@alt,'[Expand]')]";
	
	//Sub-regions's number
	public String ELEMENT_REGION_SUBREGION_NUMBER=".//*[contains(text(),'$node')]/../..//*[contains(@class,'dxtl__B0')][4]";
	
	//*********************ADD/EDIT REGION*******************************\\
	//Add region title
	public By ELEMETN_ADD_REGION_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Add region')]");
	//Edit region titel
	public By ELEMETN_EDIT_REGION_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Edit region')]");
	//Name field
	public By ELEMENT_ADDEDIT_REGION_NAME_FIELD=By.xpath(".//*[@id='Name']");
	//Status dropbox
	public By ELEMENT_ADDEDIT_REGION_STATUS_DROPBOX=By.xpath(".//*[@id='Status']");
	//Level field
	public By ELEMENT_ADDEDIT_REGION_LEVEL_FIELD=By.xpath(".//*[@id='ddlLevel']");
	//Parent dropbox
	public By ELEMENT_ADDEDIT_REGION_PARENT_DROPBOX=By.xpath(".//*[@id='select2-ddlParent-container']");
	public By ELEMENT_ADDEDIT_REGION_PARENT_INPUT=By.xpath("//*[contains(@class,'select2-search__field')]");
	//Region type
	public By ELEMENT_ADDEDIT_REGION_REGION_TYPE_DROPBOX=By.xpath(".//*[@id='ddlRegionType']");
	//Description
	public By ELEMENT_ADDEDIT_REGION_DESCRIPTION_TEXTBOX=By.xpath(".//*[@id='Description']");
	//Cancel button
	public By ELEMENT_ADDEDIT_REGION_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_ADDEDIT_REGION_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	//Error message
	public String ELEMENT_ERROR_MESSAGE=".//*[@id='validationSummary']//*[contains(text(),'$error')]";
	
	//************************Assign manager and Delegate*************************\\
	//Manager filed
	public By ELEMENT_ASSIGN_REGION_MANAGER_FIELD=By.xpath(".//*[@id='select2-ddlManager-container']");
	//Delegate field
	public By ELEMENT_ASSIGN_REGION_DELEGATE_FIELD=By.xpath(".//*[@id='select2-ddlDelegateManager-container']");
	//Item
	public String ELEMENT_ASSIGN_REGION_DELEGATE_MANAGER_NAME=".//*[contains(@id,'select2-ddlManager-result')][contains(text(),'$email')]";
	public String ELEMENT_ASSIGN_REGION_DELEGATE_DELEGATE_NAME=".//*[contains(@id,'select2-ddlDelegateManager-result')][contains(text(),'$email')]";
	//Cancel button
	public By ELEMENT_ASSIGN_REGION_CANCEL_BTN=By.xpath(".//*[@id='assignDelegateForm']//button[1]");
	//Save button
	public By ELEMENT_ASSIGN_REGION_SAVE_BTN=By.xpath(".//*[@id='assignDelegateForm']//button[2]");
	
	public Region(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Add region page
	 */
	public void goToAddRegion(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_REGION_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_REGION_ADD_BTN);
		info("Add region page is shown");
		waitForAndGetElement(ELEMETN_ADD_REGION_TITLE,3000,1);
	}
	/**
	 * Add a new region
	 * @param name
	 * @param status
	 * @param level
	 * @param regionType
	 * @param parent
	 * @param description
	 */
	public void add(String name,String status,String level,String regionType,String parent,String description,Object... params){
		Boolean isSave=(Boolean)(params.length>0? params[0]:true);
		if(!name.isEmpty()){
			info("Input a new name");
			type(ELEMENT_ADDEDIT_REGION_NAME_FIELD,name,true);
		}
		if(!status.isEmpty()){
			info("Input a status");
			select(ELEMENT_ADDEDIT_REGION_STATUS_DROPBOX,status,2);
		}
		if(!level.isEmpty()){
			info("Input a level");
			select(ELEMENT_ADDEDIT_REGION_LEVEL_FIELD,level,2);
		}
		if(!regionType.isEmpty()){
			info("Input a region type");
			select(ELEMENT_ADDEDIT_REGION_REGION_TYPE_DROPBOX,regionType,2);
		}
		if(!parent.isEmpty()){
			info("Input a parent");
			waitForAndGetElement(ELEMENT_ADDEDIT_REGION_PARENT_DROPBOX,2000,1).click();
			type(ELEMENT_ADDEDIT_REGION_PARENT_INPUT,parent,true);
			waitForAndGetElement(ELEMENT_ADDEDIT_REGION_PARENT_INPUT).sendKeys(Keys.ENTER);
		}
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_ADDEDIT_REGION_DESCRIPTION_TEXTBOX,description,true);
		}
		if(isSave)
		   save();
	}
	/**
	 * Open Edit region page
	 * @param region
	 */
	public void goToEditRegion(String region){
		info("Click on the region");
		click(ELEMENT_REGION_NAME_LINK.replace("$region",region));
		info("Edit region page is shown");
		waitForAndGetElement(ELEMETN_EDIT_REGION_TITLE,3000,1);
	}
	/**
	 * Edit a region
	 * @param name
	 * @param status
	 * @param level
	 * @param regionType
	 * @param parent
	 * @param description
	 * @param params
	 */
	public void edit(String name,String status,String level,String regionType,String parent,String description,Object... params){
		Boolean isSave=(Boolean)(params.length>0? params[0]:true);
		if(!name.isEmpty()){
			info("Input a new name");
			type(ELEMENT_ADDEDIT_REGION_NAME_FIELD,name,true);
		}
		if(!status.isEmpty()){
			info("Input a status");
			select(ELEMENT_ADDEDIT_REGION_STATUS_DROPBOX,status,2);
		}
		if(!level.isEmpty()){
			info("Input a level");
			select(ELEMENT_ADDEDIT_REGION_LEVEL_FIELD,level,2);
		}
		if(!regionType.isEmpty()){
			info("Input a region type");
			select(ELEMENT_ADDEDIT_REGION_REGION_TYPE_DROPBOX,regionType,2);
		}
		if(!parent.isEmpty()){
			info("Input a parent");
			waitForAndGetElement(ELEMENT_ADDEDIT_REGION_PARENT_DROPBOX,2000,1).click();
			type(ELEMENT_ADDEDIT_REGION_PARENT_INPUT,parent,true);
			waitForAndGetElement(ELEMENT_ADDEDIT_REGION_PARENT_INPUT).sendKeys(Keys.ENTER);
		}
		if(!description.isEmpty()){
			info("Input a description");
			type(ELEMENT_ADDEDIT_REGION_DESCRIPTION_TEXTBOX,description,true);
		}
		if(isSave)
		   save();
	}
	/**
	 * Save all changes
	 */
	public void save(Object... params){
		Boolean isVerify=(Boolean)(params.length>0? params[0]:true);
		info("Click on Save button");
		click(ELEMENT_ADDEDIT_REGION_SAVE_BTN);
		Utils.pause(3000);
		if(isVerify){
			info("Verify that Region home page is shown");
			waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
		}
		
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_ADDEDIT_REGION_CANCEL_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
	}
	/**
	 * Verify that the region is shown in the table
	 * @param region
	 * @param isActive
	 */
	public void verifyRegionInTheTable(String region){
		info("Verify that the region is shown in the table");
		waitForAndGetElement(ELEMENT_REGION_NAME_LINK.replace("$region",region),3000,1);
		info("The region is shown in the table");
	}
	/**
	 * Verify that a region is not shown in the region table
	 * @param region
	 */
	public void verifyRegionNOTInTheTable(String region){
		info("Verify that the region isnot shown in the table");
		waitForElementNotPresent(ELEMENT_REGION_NAME_LINK.replace("$region",region),3000,1);
	}
	
	/**
	 * Search by status
	 * @param option
	 */
	public void searchByStatus(String option){
		info("Select a status");
		select(ELEMENT_REGION_STATUS_DROPBOX,option,2);	
		Utils.pause(3000);
	}
	/**
	 * Verify that a link is shown in the breadcrumb
	 * @param link
	 */
	public void verifyBreadcrumb(String link){
		info("Verify that a link:"+link+" is displayed in the breadcrumb");
		waitForAndGetElement(ELEMENT_REGION_BREADCRUMB_LINKS.replace("$link",link),3000,1);
	}
	/**
	 * Click on a link on the breadcrumb
	 * @param link
	 */
	public void clickBreadcrumb(String link){
		info("Click on a link:"+link+" is displayed in the breadcrumb");
		click(ELEMENT_REGION_BREADCRUMB_LINKS.replace("$link",link));
		Utils.pause(3000);
	}
	/**
	 * Verify that a error message is shown
	 * @param error
	 */
	public void verifyErrorMesg(String error){
		info("Verify that a error message as:"+error+" is shown");
		waitForAndGetElement(ELEMENT_ERROR_MESSAGE.replace("$error",error),2000,1);
		info("Verify that still stay at Add reigon page");
		waitForAndGetElement(ELEMENT_ADDEDIT_REGION_NAME_FIELD,2000,1);
	}
	
	public enum treeType{COLLAPSE,EXPAND};
	/**
	 * Expand or collapse a node on the region tree
	 * @param type
	 * @param node
	 */
	public void collapseExpand(treeType type,String node){
		switch(type){
		case COLLAPSE:
			info("Collapse the node");
			click(ELEMENT_REGION_COLLAPSE_NODE.replace("$node",node));
			waitForAndGetElement(ELEMENT_REGION_EXPAND_NODE.replace("$node",node),2000,1);
			break;
		case EXPAND:
			info("Expand the node");
			click(ELEMENT_REGION_EXPAND_NODE.replace("$node",node));
			waitForAndGetElement(ELEMENT_REGION_COLLAPSE_NODE.replace("$node",node),2000,1);
			break;
		default:
			info("Not found this type.");
			break;
		}
	}
	/**
	 * Get the number of sub-regions
	 * @param node
	 * @return number
	 */
	public String getSubRegionNumber(String node){
		String number=waitForAndGetElement(ELEMENT_REGION_SUBREGION_NUMBER.replace("$node",node),2000,1).getText();
		return number;
	}
	/**
	 * Open Managed by page
	 * @param region
	 */
	public void goToManagedBy(String region){
		info("Click on the link");
		click(ELEMENT_REGION_MANAGED_BY_LINK.replace("$region",region));
		info("Verify that Assign manager and Delegate page is shown ");
		waitForAndGetElement(ELEMENT_ASSIGN_REGION_MANAGER_FIELD,2000,1);
	}
	/**
	 * Set Manager
	 * @param manager
	 *               =are Business Managers and administrator roles
	 * @param delegate
	 *               = are Sales Opt role
	 */
	public void setManagedBy(String manager,String delegate){
		if(!manager.isEmpty()){
			click(ELEMENT_ASSIGN_REGION_MANAGER_FIELD);
			click(ELEMENT_ASSIGN_REGION_DELEGATE_MANAGER_NAME.replace("$email",manager));
		}
		if(!delegate.isEmpty()){
			click(ELEMENT_ASSIGN_REGION_DELEGATE_FIELD);
			click(ELEMENT_ASSIGN_REGION_DELEGATE_DELEGATE_NAME.replace("$email",delegate));
		}
		Utils.pause(3000);
	}
	/**
	 * Verify that a manager is set for a region
	 * @param region
	 * @param name
	 */
	public void verifyManager(String region, String name){
		info("Verify that user:"+ name+" is set for the region:"+region);
		waitForAndGetElement(ELEMENT_REGION_MANAGED_BY_NAME.replace("$region",region).replace("$name",name),2000,1);
	}
	/**
	 * Verify that a manager is not set for a region
	 * @param region
	 * @param name
	 */
	public void verifyNOTManager(String region, String name){
		info("Verify that user:"+ name+" isnot set for the region:"+region);
		waitForElementNotPresent(ELEMENT_REGION_MANAGED_BY_NAME.replace("$region",region).replace("$name",name),2000,1);
	}
	/**
	 * Save all changes of Manager by page
	 */
	public void saveManageBy(){
		info("click on the button");
		click(ELEMENT_ASSIGN_REGION_SAVE_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
	}
	/**
	 * Cancel all changes of Manager by page
	 */
	public void cancelManageBy(){
		info("click on the button");
		click(ELEMENT_ASSIGN_REGION_CANCEL_BTN);
		info("Verify that Region home page is shown");
		waitForAndGetElement(ELEMENT_REGION_TITLE,3000,1);
	}
	
}
