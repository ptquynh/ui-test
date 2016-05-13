package com.tekexperts.pipeline.pipelineManagement.operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.tekexperts.pipeline.common.TestLogger.info;
import com.tekexperts.pipeline.common.PipelineBase;

public class FalloutSummaries extends PipelineBase{

	//Fallout summaries tab
	public By ELEMENT_FALLOUT_FALLOUTSUMMARIES_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/Index']");
	public By ELEMENT_FALLOUT_FALLOUTSUMMARIES_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Fallout Summaries')]");
	//Unassigned Order tab
	public By ELEMENT_FALLOUT_UNASSIGNEDORDERS_TAB=By.xpath(".//*[@id='right-side']//*[@href='/UnassignOrder']");
	public By ELEMENT_FALLOUT_UNASSIGNEDORDERS_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Unassigned Orders')]");
	//No Previous Doc tab
	public By ELEMENT_FALLOUT_NOPREVIOUSDOC_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/NoPreviousDoc']");
	public By ELEMENT_FALLOUT_NOPREVIOUSDOC_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Fallout - No Previous Doc')]");
	//Duplicated Previous tab
	public By ELEMENT_FALLOUT_DUPLICATEDPREVIOUS_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/DuplicatedPreviousDoc']");
	public By ELEMENT_FALLOUT_DUPLICATEDPREVIOUS_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Fallout - Duplicated Previous Doc')]");
	//Negative Orders tab
	public By ELEMENT_FALLOUT_NEGATIVEORDERS_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/NegativeOrder']");
	public By ELEMENT_FALLOUT_NEGATIVEORDERS_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Fallout - Negative Orders')]");
	//Multiple Close Dates tab
	public By ELEMENT_FALLOUT_MULTIPLECLOSEDATES_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/MultiCloseDate']");
	public By ELEMENT_FALLOUT_MULTIPLECLOSEDATES_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Fallout - Multiple Close Dates')]");
	//Not Reconciled tab
	public By ELEMENT_FALLOUT_NOTRECONCILED_TAB=By.xpath(".//*[@id='right-side']//*[@href='/OrphanOrder/NotReconciled']");
	public By ELEMENT_FALLOUT_NOTRECONCILED_TITLE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Not reconciled')]");
	
	public FalloutSummaries(WebDriver dr){
		driver = dr;
	}
	/**
	 * Open Fallout summaries tab
	 */
	public void goToFalloutSummariesTab(){
		info("Open Fallout summaries tab");
		click(ELEMENT_FALLOUT_FALLOUTSUMMARIES_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_FALLOUTSUMMARIES_TITLE,2000,1);
	}
	/**
	 * Open Unassigned Orders tab
	 */
	public void goToUnassignedOrdersTab(){
		info("Open Unassigned Orders tab");
		click(ELEMENT_FALLOUT_UNASSIGNEDORDERS_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_UNASSIGNEDORDERS_TITLE,2000,1);
	}
	/**
	 * Open No previous Doc tab
	 */
	public void goToNoPreviousDocTab(){
		info("Open No Previous Doc tab");
		click(ELEMENT_FALLOUT_NOPREVIOUSDOC_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_NOPREVIOUSDOC_TITLE,2000,1);
	}
	/**
	 * Open Duplicated Previous Doc tab
	 */
	public void goToDuplicatedPreviousDocTab(){
		info("Open Duplicated Previous doc tab");
		click(ELEMENT_FALLOUT_DUPLICATEDPREVIOUS_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_DUPLICATEDPREVIOUS_TITLE,2000,1);
	}
	/**
	 * Open Negative Orders tab
	 */
	public void goToNegativeOrdersTab(){
		info("Open Negative Orders tab");
		click(ELEMENT_FALLOUT_NEGATIVEORDERS_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_NEGATIVEORDERS_TITLE,2000,1);
	}
	/**
	 * Open Multiple Close Dates tab
	 */
	public void goToMultipleCloseDatesTab(){
		info("Open Multiple Close Dates tab");
		click(ELEMENT_FALLOUT_MULTIPLECLOSEDATES_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_MULTIPLECLOSEDATES_TITLE,2000,1);
	}
	/**
	 * Open Not Reconciled tab
	 */
	public void goToNotReconciledTab(){
		info("Open Not Reconciled tab");
		click(ELEMENT_FALLOUT_NOTRECONCILED_TAB);
		waitForAndGetElement(ELEMENT_FALLOUT_NOTRECONCILED_TITLE,2000,1);
	}
}
