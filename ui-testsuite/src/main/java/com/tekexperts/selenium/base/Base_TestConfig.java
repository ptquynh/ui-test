package com.tekexperts.selenium.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tekexperts.pipeline.common.ManageLogInOut;
import com.tekexperts.pipeline.common.NavigationMenu;
import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.readData.AttachmentFileDatabase;
import static com.tekexperts.pipeline.common.TestLogger.info;

public class Base_TestConfig extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	AttachmentFileDatabase fData;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		mgLogInOut = new ManageLogInOut(driver);
		navMenu = new NavigationMenu(driver);
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		info("USER_ROOT:"+USER_ROOT);
		mgLogInOut.signIn(USER_ROOT, USER_PASS);
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile);
		info("End setUpBeforeMethod");
	}
	
	@AfterMethod
	public void afterMethod(){
		info("Start afterMethod");
		driver.manage().deleteAllCookies();
		driver.quit();
		info("End setUpBeforeClass");
	}
	
	@Test
	public void test_01(){
		
	}
}
