package com.tekexperts.selenium.func.others;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekexperts.pipeline.administration.organization.OrganizationHome;
import com.tekexperts.pipeline.administration.organization.User;
import com.tekexperts.pipeline.common.ManageLogInOut;
import com.tekexperts.pipeline.common.NavigationMenu;
import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.readData.MessageDatabase;
import com.tekexperts.pipeline.common.readData.UserDatabase;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class TestConfig_Login extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	MessageDatabase mesg;
	UserDatabase userData;
	OrganizationHome orgaHome;
	User userlist;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		mgLogInOut = new ManageLogInOut(driver);
		navMenu = new NavigationMenu(driver);
		orgaHome = new OrganizationHome(driver);
		userlist = new User(driver);
		
		//Get message from Excel
		mesg = new MessageDatabase();
		mesg.setData(messageFilePath,defaultSheet,isUseFile);
		
		userData= new UserDatabase();
		userData.setUserData(userDataFilePath, defaultSheet, isUseFile);
		
		info("End setUpBeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End setUpBeforeClass");
	}
}
