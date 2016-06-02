package com.tekexperts.selenium.refreshData;

import org.testng.annotations.Test;

import com.tekexperts.pipeline.administration.dataImport.AssignmentRules.assignmentCol;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class Refresh_Assignment_Rules extends TestConfig  {

	@Test
	public void deleteAMSAssignmentRules(){
		info("Delete all assignment rules that cannot be duplicated");
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		String[] buList={"Solution","Platform"};
			info("region:"+region);
			for(String bu:buList){
				info("bu:"+bu);
				info("element:"+waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,2000,0));
				while(waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,2000,0)==null){
					assignRule.searchBy(assignmentCol.SUPPER_REGION,"AMS");
					assignRule.searchBy(assignmentCol.BUSINESS_UNIT,bu);
					if(waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,2000,0)!=null){
						this.driver.navigate().refresh();
						break;
					}
					assignRule.delete();
			   }
			}
	}
	
	@Test
	public void deleteAPJAssignmentRules() {
		info("Delete all assignment rules that cannot be duplicated");
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		info("region:" + region);
		info("bu:" + bu);
		while (waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,
				2000, 0) == null) {
			assignRule.searchBy(assignmentCol.SUPPER_REGION, "APJ");
			assignRule.searchBy(assignmentCol.BUSINESS_UNIT,"ESP");
			if (waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,
					2000, 0) != null) {
				this.driver.navigate().refresh();
				break;
			}
			assignRule.delete();
		}
	}
	
	@Test
	public void deleteAPJHasRegionAssignmentRules() {
		info("Delete all assignment rules that cannot be duplicated");
		info("Go to Data Import page");
		navMenu.goToDataImport();
		info("Go to Assignment Rules page");
		dataImportHome.goToAssignmentRules();
		info("region:" + region);
		info("bu:" + bu);
		String[] country={"Malaysia","Singapore","Bhutan","Thailand","Japan","China","Taiwan","Korea","India","Australia"};
		String[] region={"Malaysia","Singapore","Ro SEA","Ro SEA","Japan","China","Taiwan","Korea","India","SOUTH PACIFIC"};
			for(int i=0;i<region.length;i++){
				while (waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,
						2000, 0) == null) {
					assignRule.searchBy(assignmentCol.SUPPER_REGION, "APJ");
					assignRule.searchBy(assignmentCol.REGION,region[i]);
					assignRule.searchBy(assignmentCol.COUNTRY_NAME,country[i]);
					assignRule.searchBy(assignmentCol.BUSINESS_UNIT,"Platform");
					if (waitForAndGetElement(assignRule.ELEMENT_ASSIGNMENTRULE_NO_DATA,
							2000, 0) != null) {
						this.driver.navigate().refresh();
						break;
					}
					assignRule.delete();
				}
			}
	}
}
