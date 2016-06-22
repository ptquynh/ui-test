package com.tekexperts.pipeline.administration.organization;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

public class User extends PipelineBase{
	//User page title
	public By ELEMENT_USER_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'User')]");
    //Add button
	public By ELEMENT_USER_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/User/Create?Length=4']");
	//Edit a user
	public String ELEMENT_USER_FULLNAME_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]";
	//Unset credential
	public String ELEMENT_USER_CREDENTIAL_UNSET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Unset')]";
	//Set credential
	public String ELEMENT_USER_CREDENTIAL_SET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Set')]";
	//Set/Unset credential without fullName
	public By ELEMENT_USER_CREDENTIAL_SETORUNSET_LINK=By.xpath(".//*[@id='gvUser_DXMainTable']//*[contains(@href,'/User/Credential')]");
	//Reset link
	public String ELEMENT_USER_RESET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Reset')]";
	//Change password link
	public String ELEMENT_USER_CHANGEPASS_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/..//*[contains(text(),'Change')]";
	//User information
	public String ELEMENT_USER_INFORMATION=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'$text')]";
	
	//****************************ADD/EDIT USER**********************************\\
	//Edit User page title
	public By ELEMENT_USER_EDIT_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Edit user')]");
	//Add User page title
	public By ELEMENT_USER_ADD_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Create user')]");
	//Full Name field
	public By ELEMENT_USER_ADDEDIT_FULLNAME_FIELD=By.xpath(".//*[@id='FullName']");
	//Email field
	public By ELEMENT_USER_ADDEDIT_EMAIL_FIELD=By.xpath(".//*[@id='Email']");
	//HPID field
	public By ELEMENT_USER_ADDEDIT_HPID_FIELD=By.xpath(".//*[@id='HPID']");
	//Password field
	public By ELEMENT_USER_ADD_PASSWORD_FIELD=By.xpath(".//*[@id='txtPassword']");
	//Confirm password
	public By ELEMENT_USER_ADD_CONFIRM_FIELD=By.xpath(".//*[@id='txtConfirmPassword']");
	//View checkbox
	public By ELEMENT_USER_ADD_VIEW_CHECKBOX=By.xpath(".//input[@id='ckViewPassword']");
	//Random password
	public By ELEMENT_USER_ADD_RANDOMPASS_BTN=By.xpath(".//*[@id='btnGeneratePassword']");
	//Job title field
	public By ELEMENT_USER_ADDEDIT_JOBTITLE_FIELD=By.xpath(".//*[@id='ddlJobTitle']");
	//RTM field
	public By ELEMENT_USER_ADDEDIT_RTM_FIELD=By.xpath(".//*[@id='Department']");
	//Region field
	public By ELEMENT_USER_ADDEDIT_REGION_FIELD=By.xpath(".//*[@id='Region']");
	//Telephone field
	public By ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD=By.xpath(".//*[@id='Telephone']");
	//City field
	public By ELEMENT_USER_ADDEDIT_CITY_FIELD=By.xpath(".//*[@id='City']");
	//Country field
	public By ELEMENT_USER_ADDEDIT_COUNTRY_FIELD=By.xpath(".//*[@id='Country']");
	//Status field
	public By ELEMENT_USER_ADDEDIT_STATUS_DROPBOX=By.xpath(".//*[@id='Status']");
	//Role field
	public By ELEMENT_USER_ADDEDIT_ROLE_DROPBOX=By.xpath(".//*[@id='RoleID']");
	//Cancel button
	public By ELEMENT_USER_ADDEDIT_CANCEL_BTN=By.xpath(".//*[@id='form0']//*[contains(@class,'box-footer')]//button[1]");
	//Save button
	public By ELEMENT_USER_ADDEDIT_SAVE_BTN=By.xpath(".//*[@id='form0']//*[contains(@class,'box-footer')]//button[2]");
	//Row in the table
	public By ELEMENT_USER_TABLE_ROW=By.xpath(".//*[contains(@id,'gvUser_DXData')]");
	//Dropdown page size
	public By ELEMENT_USER_TABLE_PAGESIZE_DROPBOX=By.xpath(".//*[@id='gvUser_DXPagerBottom_DDB']");
	public String ELEMENT_USER_TABLE_PAGESIZE_DROPBOX_ITEM=".//*[contains(@id,'gvUser_DXPagerBottom_PSP_DXI')]//*[text()='$size']";
	public String ELEMENT_USER_TABLE_PAGESIZE_SELECTED_ITEM=".//*[@id='gvUser_DXPagerBottom_PSI'][@value='$size']";
	public By ELEMENT_USER_TABLE_PAGESIZE_DROPBOX_INPUT=By.xpath(".//*[@id='gvUser_DXPagerBottom_PSI']");
	
	//****************************SET CREDENTIAL*****************************\\
	//Set credential page title
	public By ELEMENT_USER_SET_CREDENTIAL_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Set Credential')]");
	//Region dropbox
	public By ELEMENT_USER_CREDENTIAL_REGION_DROPBOX=By.xpath(".//*[@id='select2-ddlRegion-container']");
	public String ELEMENT_USER_CREDENTIAL_REGION_ITEM=".//*[@id='select2-ddlRegion-results']//*[contains(text(),'$name')]";
	public String ELEMENT_USER_CREDENTIAL_REGION_ITEM_SELECTED=".//*[@id='select2-ddlRegion-container'][contains(text(),'$name')]";
	//RTM dropbox
	public By ELEMENT_USER_CREDENTIAL_RTM_DROPBOX=By.xpath(".//*[@id='select2-ddlTeam-container']");
	public String ELEMENT_USER_CREDENTIAL_RTM_ITEM=".//*[@id='select2-ddlTeam-results']//*[contains(text(),'$name')]";
	public String ELEMENT_USER_CREDENTIAL_RTM_ITEM_SELECTED=".//*[@id='select2-ddlTeam-container'][contains(text(),'$name')]";
	//Business Unit dropbox
	public By ELEMENT_USER_CREDENTIAL_BU_DROPBOX=By.xpath(".//*[@id='select2-ddlBusinessUnit-container']");
	public String ELEMENT_USER_CREDENTIAL_BU_ITEM=".//*[@id='select2-ddlBusinessUnit-results']//*[contains(text(),'$name')]";
	public String ELEMENT_USER_CREDENTIAL_BU_ITEM_SELECTED=".//*[@id='select2-ddlBusinessUnit-container'][contains(text(),'$name')]";
	//Cancel button
	public By ELEMENT_USER_CREDENTIAL_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Set button
	public By ELEMENT_USER_CREDENTIAL_SET_BTN=By.xpath(".//*[@id='form0']//button[2]");
	//Region filter
	public By ELEMENT_USER_CREDENTIAL_REGION_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol2_I']");
	//RTM fiter
	public By ELEMENT_USER_CREDENTIAL_RTM_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol3_I']");
	//Business Unit filter
	public By ELEMENT_USER_CREDENTIAL_BUSINESS_UNIT_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol4_I']");
	//Set Date filter
	public By ELEMENT_USER_CREDENTIAL_SET_DATE_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol5_I']");
	//Set By filter
	public By ELEMENT_USER_CREDENTIAL_SET_BY_FILTER=By.xpath(".//*[@id='gvCredential_DXFREditorcol6_I']");
	//Unset
	public String ELEMENT_USER_CREDENTIAL_UNSET=".//*[@id='gvCredential']//*[contains(text(),'$region')]/..//*[contains(text(),'$rtm')]/..//*[contains(text(),'$business')]/..//*[contains(text(),'Unset')]";
	//Content of Set credential table
	public String ELEMENT_USER_CREDENTIAL_TABLE_TEXT=".//*[@id='gvCredential_DXMainTable']//*[contains(text(),'$text')]";
	//Confirm popup
	public By ELEMENT_USER_CONFIRM_POPUP_OK_BTN=By.xpath(".//*[@id='confirm']//*[@id='btnConfirmSubmit']");
	
	//****************************CHANGE PASSWORD*****************************\\
	//OK button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_OK_BTN=By.xpath(".//*[@id='btnConfirmSubmit']");
	//No button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_NO_BTN=By.xpath(".//*[@id='gvUser']//*[contains(@class,'modal-footer')]//button[text()='No']");
	//Close button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_CLOSE_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-header')]//button");
	//New password filed
	public By ELEMENT_CHANGEPASS_NEWPASSWORD_FIELD=By.xpath(".//*[@id='NewPassword']");
	//Confirm new password filed
	public By ELEMENT_CHANGEPASS_CONFIRMNEWPASS_FIELD=By.xpath(".//*[@id='ConfirmNewPassword']");
	//Cancel button
	public By ELEMENT_CHANGEPASS_CANCEL_BTN=By.xpath(".//*[@id='form0']//button[1]");
	//Save button
	public By ELEMENT_CHANGEPASS_SAVE_BTN=By.xpath(".//*[@id='form0']//button[2]");
	
	//**********************************FILTER FIELDS*****************************\\
	//Full Name field filter
	public By ELEMENT_USER_FULLNAME_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol1_I']");
	//Status field filter
	public By ELEMENT_USER_STATUS_FILTER_ACTIVE=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI1T0']");
	public By ELEMENT_USER_STATUS_FILTER_DISABLE=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI2T0']");
	public By ELEMENT_USER_STATUS_FILTER_ALL=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_LBI0T0']");
	public By ELEMENT_USER_STATUS_FILTER_ARROW=By.xpath(".//input[@id='gvUser_DXFREditorcol7_I']");
	public By ELEMENT_USER_STATUS_FILTER_DROPLIST=By.xpath(".//*[@id='gvUser_DXFREditorcol7_DDD_L_D']");
	
	//Role filter
	public By ELEMENT_USER_ROLE_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol2_I']");
	//Email filter
	public By ELEMENT_USER_EMAIL_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol3_I']");
	//hpid FILTER
	public By ELEMENT_USER_HPID_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol4_I']");
	//REGION FILTER
	public By ELEMENT_USER_REGION_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol6_I']");
	//LOGIN COUNT FILTER
	public By ELEMENT_USER_LOGINCOUNT_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol8_I']");
	//LAST LOGIN DATE FILTER
	public By ELEMENT_USER_LASTLOGINDATE_FILTER=By.xpath(".//*[@id='gvUser_DXFREditorcol9_I']");
	
	//error mess
	public String ELEMENT_NOTIFICATION_MESSAGE=".//*[@id='NotificationBox'][contains(text(),'$message')]";
	public String ELEMENT_ERROR_MESSAGE=".//*[@id='validationSummary']//*[contains(text(),\"$error\")]";
	
	public User(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Add user page
	 */
	public void goToAddUser(){
		info("Verify that Add button is shown");
		waitForAndGetElement(ELEMENT_USER_ADD_BTN,3000,1);
		info("Click on Add button");
		click(ELEMENT_USER_ADD_BTN);
		info("Add User page is shown");
		waitForAndGetElement(ELEMENT_USER_ADD_TITLE,3000,1);
	}
	/**
	 * Add a new user
	 * @param fullName
	 * @param email
	 * @param hpID
	 * @param pass
	 * @param confirmPass
	 * @param isView
	 * @param isRandomPass
	 * @param jobTitle
	 * @param rtm
	 * @param region
	 * @param telephone
	 * @param city
	 * @param country
	 * @param status
	 * @param role
	 */
	public void add(String fullName,String email,String hpID,String pass,String confirmPass,
			boolean isView,boolean isRandomPass,String jobTitle,String rtm,String region,String telephone,
			String city,String country,String status,String role){
		if(!fullName.isEmpty()){
			info("Type full Name");
			type(ELEMENT_USER_ADDEDIT_FULLNAME_FIELD,fullName,true);
		}
		if(!email.isEmpty()){
			info("Type email");
			type(ELEMENT_USER_ADDEDIT_EMAIL_FIELD,email,true);
		}
		if(!hpID.isEmpty()){
			info("Type HPID");
			type(ELEMENT_USER_ADDEDIT_HPID_FIELD,hpID,true);
		}
		if(!pass.isEmpty()){
			info("Type a new password");
			type(ELEMENT_USER_ADD_PASSWORD_FIELD,pass,true);
		}
		if(!confirmPass.isEmpty()){
			info("Type a confirm password");
			type(ELEMENT_USER_ADD_CONFIRM_FIELD,confirmPass,true);
		}
		if(isView){
			info("Check on View checkbox");
			check(ELEMENT_USER_ADD_VIEW_CHECKBOX,2);
		}
		if(isRandomPass){
			info("Click on Random Password button");
			click(ELEMENT_USER_ADD_RANDOMPASS_BTN);
			info("Get random password");
			USER_RANDOM_PASSWORD =getRandomPass();
		}
		if(!jobTitle.isEmpty()){
			info("Select a job title");
			select(ELEMENT_USER_ADDEDIT_JOBTITLE_FIELD,jobTitle,2);
		}
		if(!rtm.isEmpty()){
			info("Select a RTM");
			select(ELEMENT_USER_ADDEDIT_RTM_FIELD,rtm,2);
		}
		if(!region.isEmpty()){
			info("Type a region");
			type(ELEMENT_USER_ADDEDIT_REGION_FIELD,region,true);
		}
		if(!telephone.isEmpty()){
			info("Type a telephone");
			type(ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD,telephone,true);
		}
		if(!city.isEmpty()){
			info("Type a city");
			type(ELEMENT_USER_ADDEDIT_CITY_FIELD,city,true);
		}
		if(!country.isEmpty()){
			info("Type a country");
			type(ELEMENT_USER_ADDEDIT_COUNTRY_FIELD,country,true);
		}
		if(!status.isEmpty()){
			info("Select a status");
			select(ELEMENT_USER_ADDEDIT_STATUS_DROPBOX,status,2);
		}
		if(!role.isEmpty()){
			info("Select a role");
			select(ELEMENT_USER_ADDEDIT_ROLE_DROPBOX,role,2);
		}
	}
	/**
	 * Get Random password
	 * @return randomPass
	 */
	public String getRandomPass(){
		String randomPass=waitForAndGetElement(ELEMENT_USER_ADD_PASSWORD_FIELD).getText();
		info("Random password:"+randomPass);
		return randomPass;
		
	}
	/**
	 * Save all changes
	 */
	public void save(Object... params){
		Boolean isVerify=(Boolean)(params.length>0?params[0]:true);
		info("Click on Save button");
		click(ELEMENT_USER_ADDEDIT_SAVE_BTN);
		if(isVerify){
			info("Verify that User home page is shown");
			waitForAndGetElement(ELEMENT_USER_TITLE,2000,1);
		}
	}
	/**
	 * Cancel all changes
	 */
	public void cancel(){
		info("Click on Cancel button");
		click(ELEMENT_USER_ADDEDIT_CANCEL_BTN);
		info("Verify that User home page is shown");
		waitForAndGetElement(ELEMENT_USER_TITLE,3000,1);
	}
	
	/**
	 * Verify that a user is shown in the table
	 * @param user
	 */
	public void verifyUserInTheTable(String user){
		info("Verify that the user is shown in the table");
		waitForAndGetElement(ELEMENT_USER_FULLNAME_LINK.replace("$fullname",user),3000,1);
		info("The user is shown in the table");
	}
	/**
	 * Verify that a user is not shown in the table
	 * @param user
	 */
	public void verifyNOTUserInTheTable(String user){
		info("Verify that the user is shown in the table");
		waitForElementNotPresent(ELEMENT_USER_FULLNAME_LINK.replace("$fullname",user),3000,1);
		info("The user is shown in the table");
	}
	
	public enum filters{
		FULL_NAME,ROLE,EMAIL,HPID,REGION,LOGIN_COUNT,LAST_LOGIN_DATE;
	}
	/**
	 * Search user's information
	 * @param filter
	 * @param textSearch
	 */
	public void searchBy(filters filter,String textSearch){
		switch(filter){
		case FULL_NAME:
			info("Search by full name in the table");
			type(ELEMENT_USER_FULLNAME_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case ROLE:
			info("Search by role in the table");
			type(ELEMENT_USER_ROLE_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case EMAIL:
			info("Search by email in the table");
			type(ELEMENT_USER_EMAIL_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case HPID:
			info("Search by hpid in the table");
			type(ELEMENT_USER_HPID_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case REGION:
			info("Search by region in the table");
			type(ELEMENT_USER_REGION_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case LOGIN_COUNT:
			info("Search by login count in the table");
			type(ELEMENT_USER_LOGINCOUNT_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		case LAST_LOGIN_DATE:
			info("Search by login count in the table");
			type(ELEMENT_USER_LASTLOGINDATE_FILTER,textSearch,true);
			Utils.pause(3000);
			break;
		default:
			info("No the field to filter");
			break;
		}
	}
	
	/**
	 * Search a user by status
	 * @param isActive
	 * @param isAll
	 */
	public void searchByStatus(Boolean isActive, Boolean isAll){
		info("Search a user in the table by status");
		waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_ARROW).click();
		waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_DROPLIST,3000,1,2);
		info("Status drop list is shown");
		if(!isActive)
			waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_DISABLE).click();
		if(isAll)
			waitForAndGetElement(ELEMENT_USER_STATUS_FILTER_ALL).click();
		Utils.pause(3000);
	}
	/**
	 * Open Edit page
	 * @param fullName
	 */
	public void goToEdit(String fullName){
		info("Click on Full name link");
		click(ELEMENT_USER_FULLNAME_LINK.replace("$fullname",fullName));
		waitForAndGetElement(ELEMENT_USER_EDIT_TITLE,3000,1);
	}
	/**
	 * Edit a user
	 * @param fullName
	 * @param email
	 * @param hpID
	 * @param jobTitle
	 * @param rtm
	 * @param region
	 * @param telephone
	 * @param city
	 * @param country
	 * @param status
	 * @param role
	 */
	public void edit(String fullName,String email,String hpID,String jobTitle,String rtm,String region,String telephone,
			String city,String country,String status,String role){
		if(!fullName.isEmpty()){
			info("Edit full name");
			type(ELEMENT_USER_ADDEDIT_FULLNAME_FIELD,fullName,true);
		}
		if(!email.isEmpty()){
			info("Edit email");
			type(ELEMENT_USER_ADDEDIT_EMAIL_FIELD,email,true);
		}
		if(!hpID.isEmpty()){
			info("Edit HPID");
			type(ELEMENT_USER_ADDEDIT_HPID_FIELD,hpID,true);
		}
		if(!jobTitle.isEmpty()){
			info("Edit job Title");
			select(ELEMENT_USER_ADDEDIT_JOBTITLE_FIELD,jobTitle,2);
		}
		if(!rtm.isEmpty()){
			info("Edit RTM");
			select(ELEMENT_USER_ADDEDIT_RTM_FIELD,rtm,2);
		}
		if(!region.isEmpty()){
			info("Edit Region");
			type(ELEMENT_USER_ADDEDIT_REGION_FIELD,region,true);
		}
		if(!telephone.isEmpty()){
			info("Edit telephone");
			type(ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD,telephone,true);
		}
		if(!city.isEmpty()){
			info("Edit city");
			type(ELEMENT_USER_ADDEDIT_CITY_FIELD,city,true);
		}
		if(!country.isEmpty()){
			info("Edit country");
			type(ELEMENT_USER_ADDEDIT_COUNTRY_FIELD,country,true);
		}
		if(!status.isEmpty()){
			info("Edit status");
			select(ELEMENT_USER_ADDEDIT_STATUS_DROPBOX,status,2);
		}
		if(!role.isEmpty()){
			info("Edit role");
			select(ELEMENT_USER_ADDEDIT_ROLE_DROPBOX,role,2);
		}
	}
	/**
	 * Open Set credentail page
	 * @param fullName
	 */
	public void goToSetCredential(String fullName){
		info("Search the user");
		searchBy(filters.FULL_NAME,fullName);
		info("Click on Set link of the user has:"+fullName);
		click(ELEMENT_USER_CREDENTIAL_SETORUNSET_LINK);
		waitForAndGetElement(ELEMENT_USER_SET_CREDENTIAL_TITLE,3000,1);
		info("Set credential page is shown");
	}
	/**
	 * Verify that the Credential link is not displayed
	 * @param fullName
	 */
	public void verifyNOTCredentialLink(String fullName){
		info("Search the user");
		searchBy(filters.FULL_NAME,fullName);
		info("Verify that the user has not SET/UNSET link");
		waitForElementNotPresent(ELEMENT_USER_CREDENTIAL_SETORUNSET_LINK,2000,1);
	}
	/**
	 * Set a credential for a user
	 * @param region
	 * @param rtm
	 * @param businessUnit
	 */
	public void setCredential(String region,String rtm,String businessUnit,Object... params){
		Boolean isVerify = (Boolean)(params.length>0 ? params[0]:false);
		if(!region.isEmpty()&& !rtm.isEmpty() && !businessUnit.isEmpty() ){
			int i=0,j=0,k=0;
			WebElement el=waitForAndGetElement(ELEMENT_USER_CREDENTIAL_REGION_ITEM_SELECTED
					.replace("$name",region),2000,0);
			while(el!=null){
				if(i>5)break;
				info("Select a region:"+region);
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_REGION_DROPBOX,2000,1).click();
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_REGION_ITEM.replace("$name",region));
				i++;
			}
			WebElement el1=waitForAndGetElement(ELEMENT_USER_CREDENTIAL_RTM_ITEM_SELECTED
					.replace("$name",rtm),2000,0);
			while(el1!=null){
				if(j>5)break;
				info("Select a RTM:"+rtm);
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_RTM_DROPBOX,2000,1).click();
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_RTM_ITEM.replace("$name",rtm));
				j++;
			}
			WebElement el2=waitForAndGetElement(ELEMENT_USER_CREDENTIAL_BU_ITEM_SELECTED
					.replace("$name",businessUnit),2000,0);
			while(el2!=null){
				if(k>5)break;
				info("Select a business Unit:"+businessUnit);
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_BU_DROPBOX,2000,1).click();
				waitForAndGetElement(ELEMENT_USER_CREDENTIAL_BU_ITEM.replace("$name",businessUnit));
			    k++;
			}
	  }
		setBtn();
		if(isVerify){
			info("Verify that the credential is added successfully");
			if(!region.isEmpty()&& !rtm.isEmpty() && !businessUnit.isEmpty())
				verifyCredential(region,rtm,businessUnit);
			else verifyCredential("WW","ALL","ALL");
		}
	}
	/**
	 * Un-set an credential
	 * @param region
	 * @param rtm
	 * @param business
	 */
	public void unSetCredential(String region,String rtm,String business,Object... params){
		Boolean isVerify=(Boolean)(params.length>0?params[0]:true);
		if(!region.isEmpty()&&!rtm.isEmpty()&&!business.isEmpty()){
			info("Click on Unset link");
			click(ELEMENT_USER_CREDENTIAL_UNSET.replace("$region",region)
					.replace("$rtm",rtm)
					.replace("$business",business));
			Utils.pause(2000);
		}else {
			click(ELEMENT_USER_CREDENTIAL_UNSET.replace("$region","WW")
					.replace("$rtm","All")
					.replace("$business","All"));
			Utils.pause(2000);
		}
		waitForAndGetElement(ELEMENT_USER_CONFIRM_POPUP_OK_BTN,3000,1);
		click(ELEMENT_USER_CONFIRM_POPUP_OK_BTN);
		Utils.pause(3000);
		if(isVerify){
			info("Verify that the credential is unset");
			if(!region.isEmpty()&&!rtm.isEmpty()&&!business.isEmpty())
				verifyNOTCredential(region,rtm,business);
			else verifyNOTCredential("WW","All","All");
		}
			
	}
	/**
	 * Click on Set button of Credential page
	 */
	public void setBtn(){
		info("Click on Set button of Credential page");
		click(ELEMENT_USER_CREDENTIAL_SET_BTN);
		Utils.pause(3000);
	}
	/**
	 * Click on Cancel button
	 */
	public void cancelBtn(){
		info("Click on Cancel button of Credential page");
		click(ELEMENT_USER_CREDENTIAL_CANCEL_BTN);
		Utils.pause(3000);
	}
	
	/**
	 * Verify that a credential is added to a user
	 * @param text
	 *             is Region or RTM or Business Unit or SetDate or Set By in the table
	 */
	public void verifyCredential(String region,String rtm,String business){
		info("Verify that a credential is added to the user");
		waitForAndGetElement(ELEMENT_USER_CREDENTIAL_UNSET.replace("$region",region)
				.replace("$rtm",rtm)
				.replace("$business",business),3000,1);
		info("The credential is added successfully");
	}
	/**
	 * Verify that an credential is not shown in the table
	 * @param region
	 * @param rtm
	 * @param business
	 */
	public void verifyNOTCredential(String region,String rtm,String business){
		info("Verify that a credential is added to the user");
		waitForElementNotPresent(ELEMENT_USER_CREDENTIAL_UNSET.replace("$region",region)
				.replace("$rtm",rtm)
				.replace("$business",business),3000,1);
		info("The credential is added successfully");
	}
	
	
	/**
	 * list some fields of ADD/EDIT page
	 */
	public enum fields{
		FULL_NAME,EMAIL,HPID,REGION,TELEPHONE,CITY,COUNTRY;
	}
	/**
	 * Clear field's data
	 * @param field
	 */
	public void clear(fields field){
		switch(field){
		case FULL_NAME:
			info("Clear full name field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_FULLNAME_FIELD,2000,1).clear();
			break;
		case EMAIL:
			info("Clear email field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_EMAIL_FIELD,2000,1).clear();
			break;
		case HPID:
			info("Clear hpid field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_HPID_FIELD,2000,1).clear();
			break;
		case REGION:
			info("Clear region filed");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_REGION_FIELD,2000,1).clear();
			break;
		case TELEPHONE:
			info("Clear telephone field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_TELEPHONE_FIELD,2000,1).clear();
			break;
		case CITY:
			info("Clear city field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_CITY_FIELD, 2000,1).clear();
			break;
		case COUNTRY:
			info("Clear country field");
			waitForAndGetElement(ELEMENT_USER_ADDEDIT_COUNTRY_FIELD, 2000,1).clear();
			break;
		default:
			info("The field is not availabled.");
			break;
		}
	}
	/**
	 * Verify notification message
	 * @param message
	 */
	public void verifyNotifcationMessage(String message){
		info("Verify that the notifcation message:"+message+" is shown");
		waitForAndGetElement(ELEMENT_NOTIFICATION_MESSAGE.replace("$message",message),2000,1);
	}
	/**
	 * Verify an error message
	 * @param error
	 */
	public void verifyErrorMessage(String error){
		info("Verify that an error message:"+error+" is shown");
		waitForAndGetElement(ELEMENT_ERROR_MESSAGE.replace("$error",error),2000,1);
	}
	/**
	 * Verify that an error message is not shown
	 * @param error
	 */
	public void verifyNOTErrorMessage(String error){
		info("Verify that an error message:"+error+" isnot shown");
		waitForElementNotPresent(ELEMENT_ERROR_MESSAGE.replace("$error",error),2000,1);
	}
	/**
	 * Verify that a user has a info in the table
	 * @param fullName
	 * @param info
	 */
	public void verifyUserHASInforInTable(String fullName,String info){
		info("Verify that a user has info:"+info+" is displayed in the table");
		waitForAndGetElement(ELEMENT_USER_INFORMATION.replace("$fullname",fullName).replace("$text",info),2000,1);
	}
	/**
	 * Verify that a user has not a info in the table
	 * @param fullName
	 * @param info
	 */
	public void verifyUserNOTInforInTable(String fullName,String info){
		info("Verify that a user has info:"+info+" is displayed in the table");
		waitForElementNotPresent(ELEMENT_USER_INFORMATION.replace("$fullname",fullName).replace("$text",info),2000,1);
	}
	/**
	 * count the row in the table
	 * @return the number of data is shown
	 */
	public Integer getNumberRow(){
		info("Get all curren rows are displaying in the table");
		return driver.findElements(ELEMENT_USER_TABLE_ROW).size();
		
	}
	/**
	 * Get default value of page size
	 * @return default value
	 */
	public Integer getDefaulPageSize(){
		info("Get default value of the page size");
		String defaultValue=waitForAndGetElement(ELEMENT_USER_TABLE_PAGESIZE_DROPBOX_INPUT).getAttribute("value").toString();
		return Integer.parseInt(defaultValue);
		
	}
	
	/**
	 * Change page size
	 * @param size
	 */
	public void changePageSize(String size){
		info("Click on the dropbox page size");
		waitForAndGetElement(ELEMENT_USER_TABLE_PAGESIZE_DROPBOX,2000,1).click();
		Utils.pause(3000);
		info("Select the number:"+size+" in the dropbox");
		waitForAndGetElement(ELEMENT_USER_TABLE_PAGESIZE_DROPBOX_ITEM.replace("$size",size),2000,1).click();
		Utils.pause(3000);
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
	 * Change pass from Admin
	 * @param newPass
	 * @param confirmPass
	 */
	public void changePass(String fullName,String newPass,String confirmPass){
		info("Click on the Change link");
		click(ELEMENT_USER_CHANGEPASS_LINK.replace("$fullname",fullName));
		info("Click on OK button");
		waitForAndGetElement(ELEMENT_CHANGEPASS_CONFIRMPOPUP_OK_BTN,2000,1);
		click(ELEMENT_CHANGEPASS_CONFIRMPOPUP_OK_BTN);
		info("Veify that Change password page is shown");
		waitForAndGetElement(ELEMENT_CHANGEPASS_NEWPASSWORD_FIELD,2000,1);
		if(!newPass.isEmpty())
			type(ELEMENT_CHANGEPASS_NEWPASSWORD_FIELD,newPass,true);
		if(!confirmPass.isEmpty())
			type(ELEMENT_CHANGEPASS_CONFIRMNEWPASS_FIELD,newPass,true);
		
	}
	/**
	 * Save all changes for Change password page
	 */
	public void saveChangePass(Object...params){
		Boolean isVerify=(Boolean)(params.length>0? params[0]:true);
		info("Click on Save button");
		click(ELEMENT_CHANGEPASS_SAVE_BTN);
		if(isVerify)
			waitForElementNotPresent(ELEMENT_CHANGEPASS_SAVE_BTN,3000,1);
		Utils.pause(3000);
	}
	/**
	 * Cancel all changes on changes password
	 */
	public void cancelChangePass(Object...params){
		Boolean isVerify=(Boolean)(params.length>0? params[0]:true);
		info("Click on Cancel button");
		click(ELEMENT_CHANGEPASS_CANCEL_BTN);
		if(isVerify)
			waitForElementNotPresent(ELEMENT_CHANGEPASS_CANCEL_BTN,3000,1);
		Utils.pause(3000);
	}
	
}
