package com.tekexperts.pipeline.common;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationMenu extends PipelineBase {
	 //********************LEFT MENU*****************\\
    //Administration-->Left Menu
	public By ELEMENT_LEFT_MENU_ORGANIZATION = By.xpath(".//*[@href='/ControlPanel/Account']");
	public By ELEMENT_LEFT_MENU_DATA_IMPORT = By.xpath(".//*[@href='/ControlPanel/ImportData']");
	public By ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION = By.xpath(".//*[@href='/ControlPanel/PipelineBoard']");
	
	//Business Managerment-->Left Menu
	public By ELEMENT_LEFT_MENU_EXECUTIVE_DASHBOARD =By.xpath(".//*[@href='/Executive']");
	public By ELEMENT_LEFT_MENU_KPI_DASHBOARD =By.xpath(".//*[@href='/KPI']");
	public By ELEMENT_LEFT_MENU_ABCD = By.xpath(".//*[@href='/ABCD']");
	
	//Pipeline Management-->Left Menu
	public By ELEMENT_LEFT_MENU_DAHSBOARD = By.xpath(".//*[@href='/ControlPanel/Dashboard']");
	public By ELEMENT_LEFT_MENU_OPERATION = By.xpath(".//*[@href='/ControlPanel/Operation']");
	public By ELEMENT_LEFT_MENU_PIPELINE = By.xpath(".//*[@href='/Pipeline']");
	public By ELEMENT_LEFT_MENU_HISTORICAL_DATA = By.xpath(".//*[@href='/HistoricalContract']");
	
	//************************NAVIGATION BAR************************************\\	
	//Logo
	public By ELEMENT_NAVIGATION_BAR_LOGO=By.xpath(".//*[@id='logo-panel']/img");
	//Expand or Collapse menu
	public By ELEMENT_NAVIGATION_BAR_EXPAND_COLLAPSE_BTN= By.xpath(".//*[@id='btn-toggle-slidebar']");
	//Current quarter Label
	public String ELEMENT_NAVIGATION_BAR_CURRENTQUARTER_LABEL=".//*[@id='currentQuarterAndYear'][contains(text(),'$value')]";
	//Current FX
	public String ELEMENT_NAVIGATION_BAR_CURRENTFX_LABEL="//*[@class='navbar-center']//*[contains(text(),'$value')]";
	//Logged in as [userName]
	public String ELEMENT_NAVIGATION_BAR_LOGGED_IN_LABEL="//*[contains(@class,'navbar-nav')]//*[contains(text(),'$value')]";
	//Notification
	public By ELEMENT_NAVIGATION_BAR_NOTIFICATION_ICON=By.xpath(".//*[@id='notification']");
	//User profile
	public By ELEMENT_NAVIGATION_BAR_USER_PROFILE_ICON=By.xpath("//*[@title='Profile']/i");
	
	public NavigationMenu(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Organization
	 */
	public void goToOrganization(){
	    info("Go to Organization page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_ORGANIZATION);
				break;
			}
			click(ELEMENT_LEFT_MENU_ORGANIZATION);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_ORGANIZATION, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_ORGANIZATION + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_ORGANIZATION);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
	/**
	 * Open Data import page
	 */
	public void goToDataImport(){
		info("Go to Data Import page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_DATA_IMPORT);
				break;
			}
			click(ELEMENT_LEFT_MENU_DATA_IMPORT);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_DATA_IMPORT, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_DATA_IMPORT + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_DATA_IMPORT);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
	/**
	 * Open Pipeline configuration page
	 */
	public void goToPipelineConfigurattion(){
		info("Go to Pipeline Configuration page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION);
				break;
			}
			click(ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_PIPELINE_CONFIGURATION);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
	/**
	 * Open Dashboard page
	 */
	public void goToDashboard(){
		info("Go to Dashboard page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_DAHSBOARD);
				break;
			}
			click(ELEMENT_LEFT_MENU_DAHSBOARD);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_DAHSBOARD, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_DAHSBOARD + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_DAHSBOARD);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
	/**
	 * Open Operation page
	 */
	public void goToOperation(){
		info("Go to Operation page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_OPERATION);
				break;
			}
			click(ELEMENT_LEFT_MENU_OPERATION);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_OPERATION, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_OPERATION + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_OPERATION);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
	/**
	 * Open Pipeline page
	 */
	public void goToPipeline(){
		info("Go to Pipeline page");
		for(int repeat=0;; repeat ++){
			if (repeat > 1){
				mouseOverAndClick(ELEMENT_LEFT_MENU_PIPELINE);
				break;
			}
			click(ELEMENT_LEFT_MENU_PIPELINE);
			if (waitForAndGetElement(ELEMENT_LEFT_MENU_PIPELINE, 5000, 0) != null){
				info("Element " + ELEMENT_LEFT_MENU_PIPELINE + "... is displayed");
				break;
			}
			info("Retry...[" + repeat + "]");
			driver.navigate().refresh();
		}
		click(ELEMENT_LEFT_MENU_PIPELINE);
		Utils.pause(3000);
		info("The page is opened sucessfully");
	}
}
