package com.tekexperts.selenium.smoke;

import static com.tekexperts.pipeline.common.TestLogger.info;

import org.testng.annotations.Test;

public class Smoke_PipelineConfiguration extends TestConfig_Smoke{
	/**
	 * Test case ID: VAN-1736
	 * Test case name: Check Timeframe
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Pipeline Configuration] link
	 * Test Step 4: Click on [Time Frame]button
	 * Test Step 5: Change some thing
	 * Test Step 6: Input all required field
	 * Test Step 7: Click on [Set] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Pipeline configuration page is shown
	 * 4. TimeFramge page is shown
	 * 5. The new data is selected
	 * 6. The changed data is saved successfully
	 */
	@Test
	public void VAN1736_CheckTimeFrame(){
		info("Prepare input data");
		String quarter="Quarter 3";
		String year=getCurrentDate("YY");
		info("Year:"+year);
		info("Go to Pipeline Configuration page");
		navMenu.goToPipelineConfigurattion();
		info("Go to TimeFrame page");
		pipeConfig.goToTimeFrame();
		info("Change some thing");
		timeFrame.changeQuarter(quarter);
		info("Save all changes");
		timeFrame.set();
		info("Verify that the changed data is saved successfully");
		timeFrame.checkLabel(quarter, "");
	}

	/**
	 * Test case ID: VAN-1737
	 * Test case name: Check FX
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Pipeline Configuration] link
	 * Test Step 4: Click on [FX]button
	 * Test Step 5: Upload a FX file
	 * Test Step 6: Click on [Import] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Pipeline configuration page is shown
	 * 4. FX page is shown
	 * 5. The file's name is displayed in the upload field
	 * 6. The file is upload successfully
	 */
	@Test
	public void VAN1737_CheckFX(){
		String file = fData.getAttachFileByArrayTypeRandom(65);
		String month ="May";
		String year = "2016";
		info("Go to Pipeline Configuration page");
		navMenu.goToPipelineConfigurattion();
		info("Go to FX page");
		pipeConfig.goToFX();
		info("Upload a FX file");
		fx.upload(PATH_TESTDATA, file,month,year);
		info("Search the file");
		fx.searchByFileName(file);
		info("Verify that the file is uploaded successfully");
		fx.checkFile(file, month,"16");
	}
	/**
	 * Test case ID: VAN-1738
	 * Test case name: Check Snapshot
	 * Precondition: User A has an account in the system
	 * Test details:
	 * Test Step 1: Open the link http://10.12.14.205:8089/
	 * Test Step 2: Login with an admin account
	 * Test Step 3: Click on [Pipeline Configuration] link
	 * Test Step 4: Click on [Snapshot]button
	 * Test Step 5: Add a new snapshot
	 * Test Step 6: Click on [Add] button
	 * Expected:
	 * 1. Sign in page is shown
	 * 2. Home page is shown
	 * 3. Pipeline configuration page is shown
	 * 4. Snapshot page is shown
	 * 5,6. A new snapshot is added to the table
	 */
	@Test
	public void VAN1738_CheckSnapshot(){
		info("Prepare input data");
		String name = "test"+getRandomNumber();
		String date=getCurrentDate("MM/dd/yyyy");
		info("Go to Pipeline Configuration page");
		navMenu.goToPipelineConfigurattion();
		info("Go to Snapshot page");
		pipeConfig.goToSnapshot();
		int i=0;
		while(snapshot.isHasSnapshotRequired()){
		  snapshot.delete("Required");
		  if(i>5)break;
		  i++;	
		}
		info("Add a new snapshot");
		snapshot.add(name, date);
		info("Verify that the snapshot is saved successfully");
		snapshot.searchByName(name);
		snapshot.verifySnapshotInTable(name);
	}
}
