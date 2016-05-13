package com.tekexperts.selenium.smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tekexperts.pipeline.BusinessManagement.ABCD;
import com.tekexperts.pipeline.BusinessManagement.ExecutiveDashboard;
import com.tekexperts.pipeline.BusinessManagement.KPIsDashboard;
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
import com.tekexperts.pipeline.common.readData.AssignmentRulesDatabase;
import com.tekexperts.pipeline.common.readData.AttachmentFileDatabase;
import com.tekexperts.pipeline.common.readData.MessageDatabase;
import com.tekexperts.pipeline.common.readData.RSREmployeesDatabase;
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
import com.tekexperts.pipeline.pipelineManagement.operation.AssignRSR;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutDuplicatePreviousDoc;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutSummaries;
import com.tekexperts.pipeline.pipelineManagement.operation.FalloutUnassignedOrders;
import com.tekexperts.pipeline.pipelineManagement.operation.OperationHome;
import com.tekexperts.pipeline.pipelineManagement.operation.UnassignedContracts;
import com.tekexperts.pipeline.pipelineManagement.pipeline.HistoricalData;
import com.tekexperts.pipeline.pipelineManagement.pipeline.Pipeline;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class TestConfig_Smoke extends PipelineBase {
	ManageLogInOut mgLogInOut;
	NavigationMenu navMenu;
	
	ExecutiveDashboard exeDashboard;
	KPIsDashboard kpiDashboard;
	ABCD abcd;
	
	OrganizationHome orgHome;
	Region region;
	RTM rtm;
	User user;
	BusinessUnit bu;
	
	DataImportHome dataImportHome;
	Contracts contract;
	Orders order;
	AssignmentRules assignRule;
	
	PipelineConfiguration pipeConfig;
	FX fx;
	Snapshost snapshot;
	Timeframe timeFrame;
	
	DashboardHome dashHome;
	PipelineDashboard pipeDash;
	SummaryDashboard sumDash;
	RenewalRateDashboard renewalDash;
	LostBusinessUnitDashboard lostBU;
	LostByReasonDashboard lostReason;
	LostChannelDirectDashboard lostChannel;
	LostDealSizeDashboard lostSize;
	LostDealSummaryDashboard lostSummary;
	LostDurationDashboard lostDuration;
	LostProductLineDashboard lostPL;
	LostRenewalTypeDashboard lostRenewal;
	
	OperationHome operaHome;
	UnassignedContracts unassignATR;
	FalloutUnassignedOrders falloutUnassignOrder;
	FalloutDuplicatePreviousDoc falloutDupPrev;
	FalloutSummaries falloutSummaries;
	AssignRSR assignRSR;
	Pipeline pipeList;
	HistoricalData hisData;
	
	//DataDriven
	AttachmentFileDatabase fData;
	MessageDatabase mesg;
	RSREmployeesDatabase rsrEmployData;
	AssignmentRulesDatabase assignData;
	
	@BeforeMethod
	public void setUpBeforeMethod() throws Exception{
		info("Start setUpBeforeMethod");
		initSeleniumTest();
		getDefaultUserPass(userDataFilePath,defaultSheet,isUseFile);
		mgLogInOut = new ManageLogInOut(driver);
		mgLogInOut.signIn(USER_ROOT, USER_PASS,true);
		
		navMenu = new NavigationMenu(driver);
		exeDashboard = new ExecutiveDashboard(driver);
		kpiDashboard = new KPIsDashboard(driver);
		abcd = new ABCD(driver);
		
		orgHome = new OrganizationHome(driver);
		region = new Region(driver);
		rtm = new RTM(driver);
		user = new User(driver);
		bu = new BusinessUnit(driver);
		
		dataImportHome = new DataImportHome(driver);
		contract = new Contracts(driver);
		order = new Orders(driver);
		assignRule = new AssignmentRules(driver);
		
		pipeConfig = new PipelineConfiguration(driver);
		fx= new FX(driver);
		snapshot = new Snapshost(driver);
		timeFrame = new Timeframe(driver);
		
		dashHome=new DashboardHome(driver);
		pipeDash = new PipelineDashboard(driver);
		sumDash = new SummaryDashboard(driver);
		renewalDash = new RenewalRateDashboard(driver);
		lostBU = new LostBusinessUnitDashboard(driver);
		lostReason = new LostByReasonDashboard(driver);
		lostChannel = new LostChannelDirectDashboard(driver);
		lostSize = new LostDealSizeDashboard(driver);
		lostSummary = new LostDealSummaryDashboard(driver);
		lostDuration = new LostDurationDashboard(driver);
		lostPL = new LostProductLineDashboard(driver);
		lostRenewal = new LostRenewalTypeDashboard(driver);
		
		operaHome = new OperationHome(driver);
		unassignATR = new UnassignedContracts(driver);
		falloutUnassignOrder= new FalloutUnassignedOrders(driver);
		falloutDupPrev = new FalloutDuplicatePreviousDoc(driver);
		falloutSummaries = new FalloutSummaries(driver);
		dataImportHome = new DataImportHome(driver);
		contract = new Contracts(driver);
		assignRSR = new AssignRSR(driver);
		pipeList = new Pipeline(driver);
		hisData = new HistoricalData(driver);
		
		//Get attached file data from Excel
		fData = new AttachmentFileDatabase();
		fData.setAttachFileData(attachmentFilePath,defaultSheet,isUseFile);
		
		//Get message from Excel
		mesg = new MessageDatabase();
		mesg.setData(messageFilePath,defaultSheet,isUseFile);
		
		//Get assignment rule from excel
		assignData = new AssignmentRulesDatabase();
		assignData.setData(assignRuleFilePath,defaultSheet,isUseFile);
		
		//Get employess name
		rsrEmployData = new RSREmployeesDatabase();
		rsrEmployData.setData(rsrEmployFilePath,defaultSheet,isUseFile);
				
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
