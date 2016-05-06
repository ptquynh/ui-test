package com.tekexperts.pipeline.func.administration.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

public class User extends PipelineBase{
    //Add button
	public By ELEMENT_USER_ADD_BTN=By.xpath(".//*[@id='right-side']//*[@href='/User/Create?Length=4']");
	//Edit a user
	public String ELEMENT_USER_FULLNAME_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]";
	//Unset credential
	public String ELEMENT_USER_CREDENTIAL_UNSET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Unset')]";
	//Set credential
	public String ELEMENT_USER_CREDENTIAL_SET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Set')]";
	//Reset link
	public String ELEMENT_USER_RESET_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Reset')]";
	//Change password link
	public String ELEMENT_USER_CHANGEPASS_LINK=".//*[@id='gvUser_DXMainTable']//*[contains(text(),'$fullname')]/../..//*[contains(text(),'Change')]";
	
	//****************************ADD/EDIT USER**********************************\\
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
	
	//****************************SET CREDENTIAL*****************************\\
	//Region dropbox
	public By ELEMENT_USER_CREDENTIAL_REGION_DROPBOX=By.xpath(".//*[@id='select2-ddlRegion-container']");
	//RTM dropbox
	public By ELEMENT_USER_CREDENTIAL_RTM_DROPBOX=By.xpath(".//*[@id='gvCredential_DXFREditorcol3_I']");
	//Business Unit dropbox
	public By ELEMENT_USER_CREDENTIAL_BUSINESSUNIT_DROPBOX=By.xpath(".//*[@id='select2-ddlBusinessUnit-container']");
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
	public String ELEMENT_USER_CREDENTIAL_UNSET=".//*[@id='gvCredential']//*[contains(text(),'$region')]/..//*[contains(text(),'Unset')]";
	
	//****************************CHANGE PASSWORD*****************************\\
	//OK button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_OK_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-footer')]//button[2]");
	//No button on confirm popup
	public By ELEMENT_CHANGEPASS_CONFIRMPOPUP_NO_BTN=By.xpath(".//*[@id='confirm']//*[contains(@class,'modal-footer')]//button[1]");
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
	
	public User(WebDriver dr){
		driver = dr;
	}
}
