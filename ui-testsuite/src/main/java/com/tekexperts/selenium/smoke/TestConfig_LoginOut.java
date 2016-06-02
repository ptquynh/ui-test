package com.tekexperts.selenium.smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekexperts.pipeline.common.ManageLogInOut;
import com.tekexperts.pipeline.common.NavigationMenu;
import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.readData.MessageDatabase;
import static com.tekexperts.pipeline.common.TestLogger.info;

public class TestConfig_LoginOut extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	//DataDriven
	MessageDatabase mesg;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		mgLogInOut = new ManageLogInOut(driver);
		navMenu = new NavigationMenu(driver);
		//Get message from Excel
		mesg = new MessageDatabase();
		mesg.setData(messageFilePath,defaultSheet,isUseFile);
		
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
