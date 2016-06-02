package com.tekexperts.selenium.func.others;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekexperts.pipeline.administration.organization.OrganizationHome;
import com.tekexperts.pipeline.administration.organization.User;
import com.tekexperts.pipeline.common.ChangePassword;
import com.tekexperts.pipeline.common.ManageLogInOut;
import com.tekexperts.pipeline.common.NavigationMenu;
import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.UserProfile;
import com.tekexperts.pipeline.common.readData.MessageDatabase;
import com.tekexperts.pipeline.common.readData.RolesDatabase;
import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostBusinessUnitDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostByReasonDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostChannelDirectDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostDealSizeDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostDealSummaryDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostDurationDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostProductLineDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.LostRenewalTypeDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.PipelineDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.RenewalRateDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.SummaryDashboard;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class TestConfig extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	
	UserProfile userPro;
	ChangePassword chagPass;
	OrganizationHome orgaHome;
	User userlist;
	DashboardHome dashboard;
	PipelineDashboard pipeDashboard;
	SummaryDashboard sumDashboard;
	LostBusinessUnitDashboard lostBUDash;
	LostByReasonDashboard lostByReasonDash;
	LostChannelDirectDashboard lostChannelDash;
	LostDealSizeDashboard lostDealSizeDash;
	LostDealSummaryDashboard lostDealSumDash;
	LostDurationDashboard lostDuraDash;
	LostProductLineDashboard lostProDash;
	LostRenewalTypeDashboard lostRenewalDash;
	RenewalRateDashboard renewalDash;
	
	MessageDatabase mesg;
	RolesDatabase roleData;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		mgLogInOut = new ManageLogInOut(driver);
		mgLogInOut.signIn(USER_ROOT, USER_PASS,true);
		
		navMenu = new NavigationMenu(driver);
		userPro = new UserProfile(driver);
		chagPass= new ChangePassword(driver);
		orgaHome = new OrganizationHome(driver);
		userlist = new User(driver);
		dashboard = new DashboardHome(driver);
		pipeDashboard = new PipelineDashboard(driver);
		sumDashboard = new SummaryDashboard(driver);
		lostBUDash = new LostBusinessUnitDashboard(driver);
		lostByReasonDash = new LostByReasonDashboard(driver);
		lostChannelDash= new LostChannelDirectDashboard(driver);
		lostDealSizeDash= new LostDealSizeDashboard(driver);
		lostDealSumDash = new LostDealSummaryDashboard(driver);
		lostDuraDash = new LostDurationDashboard(driver);
		lostProDash = new LostProductLineDashboard(driver);
		lostRenewalDash= new LostRenewalTypeDashboard(driver);
		renewalDash = new RenewalRateDashboard(driver);
		//Get message from Excel
		mesg = new MessageDatabase();
		mesg.setData(messageFilePath,defaultSheet,isUseFile);
		
		roleData =new RolesDatabase();
		roleData.setData(roleFilePath,defaultSheet,isUseFile);
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
