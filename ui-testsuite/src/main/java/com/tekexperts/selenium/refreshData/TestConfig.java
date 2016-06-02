package com.tekexperts.selenium.refreshData;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekexperts.pipeline.BusinessManagement.ABCD;
import com.tekexperts.pipeline.BusinessManagement.ExecutiveDashboard;
import com.tekexperts.pipeline.administration.dataImport.AssignmentRules;
import com.tekexperts.pipeline.administration.dataImport.Contracts;
import com.tekexperts.pipeline.administration.dataImport.DataImportHome;
import com.tekexperts.pipeline.administration.dataImport.Orders;
import com.tekexperts.pipeline.administration.organization.BusinessUnit;
import com.tekexperts.pipeline.administration.organization.OrganizationHome;
import com.tekexperts.pipeline.administration.organization.RTM;
import com.tekexperts.pipeline.administration.organization.Region;
import com.tekexperts.pipeline.administration.organization.User;
import com.tekexperts.pipeline.administration.pipelineConfiguration.FX;
import com.tekexperts.pipeline.administration.pipelineConfiguration.PipelineConfiguration;
import com.tekexperts.pipeline.administration.pipelineConfiguration.Snapshost;
import com.tekexperts.pipeline.administration.pipelineConfiguration.Timeframe;
import com.tekexperts.pipeline.common.ManageLogInOut;
import com.tekexperts.pipeline.common.NavigationMenu;
import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.readData.ATRDatabase;
import com.tekexperts.pipeline.common.readData.UpdateDatabase;
import com.tekexperts.pipeline.common.readData.AssignmentRulesDatabase;
import com.tekexperts.pipeline.common.readData.AttachmentFileDatabase;
import com.tekexperts.pipeline.common.readData.MessageDatabase;
import com.tekexperts.pipeline.common.readData.OrderDatabase;
import com.tekexperts.pipeline.common.readData.RSREmployeesDatabase;
import com.tekexperts.pipeline.common.readData.RegionDatabase;
import com.tekexperts.pipeline.common.readData.RegionParentDatabase;
import com.tekexperts.pipeline.common.readData.RolesDatabase;
import com.tekexperts.pipeline.common.readData.UserDatabase;
import com.tekexperts.pipeline.pipelineManagement.dashboard.DashboardHome;
import com.tekexperts.pipeline.pipelineManagement.dashboard.PipelineDashboard;
import com.tekexperts.pipeline.pipelineManagement.dashboard.SummaryDashboard;
import com.tekexperts.pipeline.pipelineManagement.operation.AssignRSR;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutHome;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutUnassignedOrders;
import com.tekexperts.pipeline.pipelineManagement.operation.OperationHome;
import com.tekexperts.pipeline.pipelineManagement.operation.UnassignedContracts;
import com.tekexperts.pipeline.pipelineManagement.pipeline.HistoricalData;
import com.tekexperts.pipeline.pipelineManagement.pipeline.Pipeline;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class TestConfig extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	
	OrganizationHome orgHome;
	Region region;
	RTM rtm;
	User user;
	BusinessUnit bu;
	ExecutiveDashboard exeDash;
	ABCD abcd;
	
	DataImportHome dataImportHome;
	Contracts contract;
	Orders order;
	AssignmentRules assignRule;
	
	PipelineConfiguration pipeConfig;
	FX fx;
	Snapshost snapshot;
	Timeframe timeFrame;
	
	Pipeline pipeList;
	DashboardHome dashboard;
	PipelineDashboard pipeDash;
	SummaryDashboard sumDash;
	OperationHome opeHome;
	UnassignedContracts unassignATR;
	AssignRSR assignRSR;
	HistoricalData histori;
	FalloutUnassignedOrders falloutOrders;
	FalloutHome falloutSumOrders;
	
	//DataDriven
	AttachmentFileDatabase fData;
	MessageDatabase mesg;
	AssignmentRulesDatabase assignData;
	UserDatabase userData;
	UpdateDatabase upData;
	ATRDatabase atrData;
	OrderDatabase orderData;
	RSREmployeesDatabase rsrData;
	RolesDatabase roleData;
	RegionDatabase regionData;
	RegionParentDatabase regionParentData;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		mgLogInOut = new ManageLogInOut(driver);
		mgLogInOut.signIn(USER_ROOT, USER_PASS,true);
		
		navMenu = new NavigationMenu(driver);
		orgHome = new OrganizationHome(driver);
		region = new Region(driver);
		rtm = new RTM(driver);
		user = new User(driver);
		bu = new BusinessUnit(driver);
		abcd =new ABCD(driver);
		
		dataImportHome = new DataImportHome(driver);
		contract = new Contracts(driver);
		order = new Orders(driver);
		assignRule = new AssignmentRules(driver);
		
		pipeConfig = new PipelineConfiguration(driver);
		fx= new FX(driver);
		snapshot = new Snapshost(driver);
		timeFrame = new Timeframe(driver);
		
		pipeList = new Pipeline(driver);
		dashboard = new DashboardHome(driver);
		pipeDash = new PipelineDashboard(driver);
		sumDash = new SummaryDashboard(driver);
		opeHome = new OperationHome(driver);
		unassignATR = new UnassignedContracts(driver);
		assignRSR = new AssignRSR(driver);
		histori= new HistoricalData(driver);
		exeDash = new ExecutiveDashboard(driver);
		
		dataImportHome = new DataImportHome(driver);
		contract = new Contracts(driver);
		falloutOrders = new FalloutUnassignedOrders(driver);
		falloutSumOrders = new FalloutHome(driver);
		
		//Get attached file data from Excel
		fData = new AttachmentFileDatabase();
		fData.setData(attachmentFilePath,defaultSheet,isUseFile);
		
		//Get message from Excel
		mesg = new MessageDatabase();
		mesg.setData(messageFilePath,defaultSheet,isUseFile);
		
		//Get assignment rule from excel
		assignData = new AssignmentRulesDatabase();
		assignData.setData(assignRuleFilePath,defaultSheet,isUseFile);
		
		//Get data from excel
		upData = new UpdateDatabase();
		atrData = new ATRDatabase();
		
		//Get data user from excel
		userData = new UserDatabase();
		userData.setUserData(userDataFilePath, defaultSheet, isUseFile);
		
		rsrData = new RSREmployeesDatabase();
		rsrData.setData(rsrEmployFilePath, defaultSheet, isUseFile);
		
		//Region data from excel
		regionData = new RegionDatabase();
		regionData.setData(regionDataFilePath, defaultSheet, isUseFile);
		//Region parent data from excel
		regionParentData= new RegionParentDatabase();
		regionParentData.setData(regionParentDataFilePath, defaultSheet, isUseFile);
		
		//Role data from excel
		roleData = new RolesDatabase();
		roleData.setData(roleFilePath, defaultSheet, isUseFile);
		
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
