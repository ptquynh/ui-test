package com.tekexperts.selenium.func.pipelineManagement;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.common.Utils;
import com.tekexperts.pipeline.common.PipelineSetting.tabType;
public class Func_Pipeline_Setting extends TestConfig{
		
		/**
		* Test case ID:VAN-1454
		* Test case name:"Reset to default in all tabs"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Visibility and Orders] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check some columns"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Open [Group By] tab"
		* Expected Result:"The tab is shown"
		* Test Step 7:"Check some visible columns at step 5 (no more than 3 columns)"
		* Expected Result:"The columns are checked"
		* Test Step 8:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 9:"Check/Unchecked some visible columns at step 5"
		* Expected Result:"The columns are checked or unchecked"
		* Test Step 10:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 11:"Go to Pipeline list page"
		* Expected Result:"The columns at step 5 are displayed in the list
		* Test Step 12:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 13:"Click on [Reset to default] button"
		* Expected Result:"The columns at step 5
		* Test Step 14:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 15:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 5 are not displayed
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pendings")
		public void VAN1454_ResetToDefaultInAllTabs(){
		}
		
		/**
		* Test case ID:VAN-1453
		* Test case name:"Reset to default in Visibility and Orders tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Visibility and Orders] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check some columns"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The columns at step 5 are displayed in the list"
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Visibility and Orders] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Click on [Reset to default] button"
		* Expected Result:"The columns at step 5 are not checked and only default columns are checked as default"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 10 are not displayed. Only display default columns"
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pendings")
		public void VAN1453_ResetToDefaultInVisibilityAndOrdersTab(){
		}
		
		/**
		* Test case ID:VAN-1452
		* Test case name:"Reset to default for visible columns in Group By tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Group By] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check some visible columns"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The columns at step 5 are displayed and grouped correctly."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Group By] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Click on [Reset to default] button"
		* Expected Result:"The columns are not checked and all is reset to default"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 10 are displayed and not grouped."
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pendings")
		public void VAN1452_ResetToDefaultForVisibleColumnsInGroupByTab(){
		}
		/**
		* Test case ID:VAN-1451
		* Test case name:"Reset to default for visible columns in Summary tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check some visible columns"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The columns at step 5 are displayed and summarized correctly at the bottom of the list."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Click on [Reset to default] button"
		* Expected Result:"The columns are not checked and all is reset to default"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 10 are displayed and not summarized at the bottom of the list."
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pendings")
		public void VAN1451_ResetToDefaultForVisibleColumnsInSummaryTab(){
		}
		/**
		* Test case ID:VAN-1449
		* Test case name:"Check/Uncheck  an invisible single columns in Summary tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check an invisible column"
		* Expected Result:"The column is checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The column at step 5 is not displayed and not summarized correctly at the bottom of the list."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck the column at step 5"
		* Expected Result:"The column is not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The column at step 10 is not displayed
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pending")
		public void VAN1449_CheckUncheckAnInvisibleSingleColumnsInSummaryTab(){
		}
		/**
		* Test case ID:VAN-1450
		* Test case name:"Check/Uncheck  invisible multi-columns in Summary tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check some invisible columns"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The columns at step 5 are not displayed and not summarized correctly at the bottom of the list."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck the columns at step 5"
		* Expected Result:"The columns are not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 10 are not displayed and not summarized at the bottom of the list."
		*  PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pending")
		public void VAN1450_CheckUncheckInvisibleMulticolumnsInSummaryTab(){
		}
		/**
		* Test case ID:VAN-1447
		* Test case name:"Check/Uncheck  a visible single columns in Summary tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check a visible column"
		* Expected Result:"The column is checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The column at step 5 is summarized correctly at the bottom of the list."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck the column at step 5"
		* Expected Result:"The column is not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"The column at step 10 is still displayed
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pending")
		public void VAN1447_CheckUncheckAVisibleSingleColumnsInSummaryTab(){
		}
		/**
		* Test case ID:VAN-1446
		* Test case name:"Check/Uncheck  All columns in Summary tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 5:"Check on [All] checkbox"
		* Expected Result:"The checkboxes are checked*[Save Changes] button is shown"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"All selected visible columns are summarized correctly at the bottom of the list.*All selected invisible columns at step 5 are not displayed and not summarized at the bottom of the list."
		* Test Step 8:"Go to [Pipeline Setting] page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Summary] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck All checkboxes"
		* Expected Result:"All checkboxes are not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page again"
		* Expected Result:"All selected visible columns at step 10 are still displayed
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pendings")
		public void VAN1446_CheckUncheckAllColumnsInSummaryTab(){
		}
		/**
		* Test case ID:VAN-1445
		* Test case name:"Change orders for visible columns in Group By tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Group By] tab"
		* Expected Result:"Group By tab is shown"
		* Test Step 5:"Check some invisible columns (no more than 3 columns)"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Move positions of columns at steps 5"
		* Expected Result:"The positions are changed as be moved"
		* Test Step 7:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 8:"Go to Pipeline list page"
		* Expected Result:"The columns are displayed and grouped by orders correctly in the list"
		* PENDING: CANNOT RUN AUTO FOR THIS CASE BECAUSE CANNOT DEFINE LOCATOR
		*/
		@Test(groups="pending")
		public void VAN1445_ChangeOrdersForVisibleColumnsInGroupByTab(){
			
		}
		/**
		* Test case ID:VAN-1444
		* Test case name:"Group/Ungroup invisible columns in Group By tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Group By] tab"
		* Expected Result:"Group By tab is shown"
		* Test Step 5:"Check some invisible columns (no more than 3 columns)"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"The columns are not displayed and grouped in the list"
		* Test Step 8:"Go to Pipeline setting page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Group By] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck columns at steps 5"
		* Expected Result:"All columns are not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page"
		* Expected Result:"The columns at step 10 are not displayed and grouped."
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1444_GroupUngroupInvisibleColumnsInGroupByTab(){
		}
		/**
		* Test case ID:VAN-1443
		* Test case name:"Group/Ungroup visible columns in Group By tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Group By] tab"
		* Expected Result:"Group By tab is shown"
		* Test Step 5:"Check some visible columns (no more than 3 columns)"
		* Expected Result:"The columns are checked"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 7:"Go to Pipeline list page"
		* Expected Result:"All data in selected columns are grouped correctly"
		* Test Step 8:"Go to Pipeline setting page"
		* Expected Result:"The page is shown"
		* Test Step 9:"Open [Group By] tab"
		* Expected Result:"The tab is shown"
		* Test Step 10:"Uncheck columns at steps 5"
		* Expected Result:"All columns are not checked"
		* Test Step 11:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 12:"Go to Pipeline list page"
		* Expected Result:"All data in selected columns are not grouped"
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1443_GroupUngroupVisibleColumnsInGroupByTab(){
		}
		/**
		* Test case ID:VAN-1442
		* Test case name:"Check  All checkboxes in Group By tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to [Pipeline Setting] page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Open [Group By] tab"
		* Expected Result:"Group By tab is shown"
		* Test Step 5:"Check on [All] checkbox"
		* Expected Result:"The checkboxes are checked*[Save Changes] button is shown"
		* Test Step 6:"Click on [Save Changes] button"
		* Expected Result:"A error message is shown as: ""You can't choose more than 3 group columns."""
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1442_CheckAllCheckboxesInGroupByTab(){
		}
		/**
		* Test case ID:VAN-1441
		* Test case name:"Check/Uncheck multi-checkboxes in Visibility and Order tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to Pipeline Setting page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Check multi-checkboxes"
		* Expected Result:"The checkboxes are checked"
		* Test Step 5:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 6:"Go to Pipeline list page"
		* Expected Result:"The columns at step 4 is shown with corresponding color"
		* Test Step 7:"Go to Pipeline Setting page again"
		* Expected Result:"The page is shown"
		* Test Step 8:"Uncheck the checkboxes at step 4"
		* Expected Result:"The checkboxes are unchecked"
		* Test Step 9:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 10:"Go to Pipeline list page again"
		* Expected Result:"The columns at step 4 is not shown."
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1441_CheckUncheckMulticheckboxesInVisibilityAndOrderTab(){
		}
		/**
		* Test case ID:VAN-1440
		* Test case name:"Check/Uncheck a signle checkbox in Visibility and Order tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to Pipeline Setting page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Check a checkbox"
		* Expected Result:"The checkbox is checked"
		* Test Step 5:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 6:"Go to Pipeline list page"
		* Expected Result:"The column at step 4 is shown with corresponding color"
		* Test Step 7:"Go to Pipeline Setting page again"
		* Expected Result:"The page is shown"
		* Test Step 8:"Uncheck the checkbox at step 4"
		* Expected Result:"The checkbox is unchecked"
		* Test Step 9:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 10:"Go to Pipeline list page again"
		* Expected Result:"The column at step 4 is not shown."
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1440_CheckUncheckASignleCheckboxInVisibilityAndOrderTab(){
		}
		/**
		* Test case ID:VAN-1439
		* Test case name:"Check/Uncheck All checkboxes in Visibility and Order tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to Pipeline Setting page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Check on [All] checkbox"
		* Expected Result:"The checkbox is checked*[Save Changes] button is shown"
		* Test Step 5:"Click on [Save Changes] button"
		* Expected Result:"All check-boxes are checked"
		* Test Step 6:"Go to Pipeline list page"
		* Expected Result:"All columns are shown with corresponding color"
		* Test Step 7:"Go to [Pipeline Setting page] page"
		* Expected Result:"Pipeline Setting page is shown"
		* Test Step 8:"Uncheck [All] checkbox"
		* Expected Result:"All checkboxes are un-checked"
		* Test Step 9:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved*Only default columns are checked"
		* Test Step 10:"Go to Pipeline list page"
		* Expected Result:"Only show default columns"
		* PENDING: THIS CASE CANNOT CHECK AUTO BECAUSE LOCATOR CANNOT DEFINED
		*/
		@Test(groups="pending")
		public void VAN1439_CheckUncheckAllCheckboxesInVisibilityAndOrderTab(){
		}
		/**
		* Test case ID:VAN-1438
		* Test case name:"Check change orders in Visibility and Order tab"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"Go to Pipeline Setting page"
		* Test Data:"From Profile page or From Pipeline list page"
		* Expected Result:"Pipeline setting page is shown*By default
		* Test Step 4:"Move positions of selected columns"
		* Expected Result:"The positions are changed as be moved"
		* Test Step 5:"Click on [Save Changes] button"
		* Expected Result:"All changes are saved"
		* Test Step 6:"Go to Pipeline list page"
		* Expected Result:"The new positions at step 4 are shown correctly."
		*/
		@Test
		public void VAN1438_CheckChangeOrdersInVisibilityAndOrderTab(){
			info("Check change orders in Visibility and Order tab");
			info("Go to Profile page");
			navMenu.goToUserProfile();
			info("Click on [Pipeline Setting] link");
			userPro.goToPipelineSetting();
			String header1= pipeSetting.getLabel(tabType.VISIBILITY,"1");
			String header2= pipeSetting.getLabel(tabType.VISIBILITY,"2");
			dragObject(pipeSetting.ELEMENT_PIPELINESETTING_VISIBILITY_ITEM.replace("$number","1"),
					pipeSetting.ELEMENT_PIPELINESETTING_VISIBILITY_ITEM.replace("$number","2"));
			Utils.pause(3000);
			pipeSetting.save();
			pipeSetting.verifyOrderColIsChange(tabType.VISIBILITY,"1",header2);
			pipeSetting.verifyOrderColIsChange(tabType.VISIBILITY,"2",header1);
			
			info("Go to the pipeline list");
			pipeSetting.clickBreadcrumb("Pipeline");
			info("Verify that Pipeline page is shown");
			waitForAndGetElement(pipeList.ELEMENT_PIPELINE_LIST,3000,1);
			pipeList.verifyHeader("0",header2);
			
			navMenu.goToUserProfile();
			info("Click on [Pipeline Setting] link");
			userPro.goToPipelineSetting();
			dragObject(pipeSetting.ELEMENT_PIPELINESETTING_VISIBILITY_ITEM.replace("$number","1"),
					pipeSetting.ELEMENT_PIPELINESETTING_VISIBILITY_ITEM.replace("$number","2"));
			Utils.pause(3000);
			pipeSetting.save();
			pipeSetting.verifyOrderColIsChange(tabType.VISIBILITY,"1",header1);
			pipeSetting.verifyOrderColIsChange(tabType.VISIBILITY,"2",header2);
			
		}
		/**
		* Test case ID:VAN-1437
		* Test case name:"Check breadcrumb on Pipeline Setting page"
		* Precondition:
		* Test details:
		* Test Step 1:"Go to <test_environment>"
		* Test Step 2:"Login with an account"
		* Test Data:"HPID: 2222Pass: Test@123456"
		* Expected Result:"Home page is shown"
		* Test Step 3:"From navigation bar
		* Test Data: click on [Profile] icon"
		* Test Step 4:"Click on [Pipeline Setting] link on the left menu or Go to [Pipeline] page and Click on [Display Setting] button"
		* Expected Result:"Display a direction as: Home->Pipeline Management->Pipeline->Settings
		* * By default, the left menu is hided
		* * If from Profile page, click on [Expand/Collapse] button, the left menu of profile page is shown.
		* * If from Pipeline list page, click on [Expand/Collapse] button, the left menu of pipeline is shown.
		* Test Step 5:"Click on a link on Breadcrumb"
		* Test Data:"Example: Click on Home link"
		* Expected Result:"Display correct page that is selected. For example here
		*/
		@Test
		public void VAN1437_CheckBreadcrumbOnPipelineSettingPage(){
			info("Check breadcrumb on Pipeline Setting page");
			info("Go to Profile page");
			navMenu.goToUserProfile();
			info("Click on [Pipeline Setting] link");
			userPro.goToPipelineSetting();
			info("Check breadcrumb");
			pipeSetting.verifyBreadcrumb("Home");
			pipeSetting.verifyBreadcrumb("Pipeline Management",true);
			pipeSetting.verifyBreadcrumb("Pipeline");
			pipeSetting.verifyBreadcrumb("Settings");
			info("Click on a link on the breadcrumb");
			pipeSetting.clickBreadcrumb("Pipeline");
			info("Verify that Pipeline page is shown");
			waitForAndGetElement(pipeList.ELEMENT_PIPELINE_LIST,3000,1);
		}
}