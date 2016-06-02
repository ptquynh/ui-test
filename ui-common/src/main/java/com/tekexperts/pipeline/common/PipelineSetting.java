package com.tekexperts.pipeline.common;
import static com.tekexperts.pipeline.common.TestLogger.info;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PipelineSetting extends PipelineBase {
	//Breadcrumb
	public By ELEMENT_PIPELINESETTING_BREADCRUMB_HOME=By.xpath(".//*[@id='right-side']//a[@href='/'][contains(text(),'Home')]");
	public String ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS=".//*[@id='right-side']//ol[@class='breadcrumb']//*[contains(text(),'$link')]";
	public String ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS_2=".//*[@id='right-side']//ol[@class='breadcrumb']//*[text()='$link']";
	
	//Pipeline setting list
	public String ELEMENT_PIPELINESETTING_VISIBILITY_ITEM=".//*[@id='list-data']/li[$number]/i";
	public String ELEMENT_PIPELINESETTING_VISIBILITY_COLUMN=".//*[@id='list-data']/li[$number]";
	public String ELEMENT_PIPELINESETTING_VISIBILITY_LABEL_ITEM=".//*[@id='list-data']/li[$number]/i/..//*[contains(text(),'$label')]";
	
	//Group by tab
	public By ELEMENT_PIPELINESETTING_GROUPBY_TAB=By.xpath(".//*[@href='#tab_2']");
	public By ELMEENT_PIPELINESETTING_GROUPBY_TITLE=By.xpath(".//*[@id='list-data-group']//h2[contains(text(),'Contract')]");
	public String ELEMENT_PIPELINESETTING_GROUPBY_ITEM=".//*[@id='list-data-group']//li[$number]/i";
	public String ELEMENT_PIPELINESETTING_GROUPBY_COLUMN=".//*[@id='list-data-group']//li[$number]";
	public String ELEMENT_PIPELINESETTING_GROUPBY_LABEL_ITEM=".//*[@id='list-data-group']//li[$number]/i/..//*[contains(text(),'$label')]";
	
	//Save changes
	public By ELEMENT_PIPELINE_SAVE_CHANGES_BTN=By.xpath(".//*[@id='btnSave']");
	
	public PipelineSetting(WebDriver dr){
		driver = dr;
	}
	/**
	 * Return to Home page from Breadcrumb
	 */
	public void returnToHomeFromBreadcrumb(){
		info("Click on Home link on Breadcrumb");
		click(ELEMENT_PIPELINESETTING_BREADCRUMB_HOME);
		Utils.pause(3000);
	}
	
	/**
	 * Verify that a link is shown in the breadcrumb
	 * @param link
	 * @param params
	 */
	public void verifyBreadcrumb(String link,Object... params){
		Boolean isOtherLocator=(Boolean)(params.length>0?params[0]:true);
		info("Verify that a link:"+link+" is displayed in the breadcrumb");
		if(isOtherLocator){
			waitForAndGetElement(ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS.replace("$link",link),3000,1);
		}else waitForAndGetElement(ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS_2.replace("$link",link),3000,1);
	}
	
	/**
	 * Click on a link on the breadcrumb
	 * @param link
	 * @param params
	 */
	public void clickBreadcrumb(String link,Object... params){
		info("Click on a link:"+link+" is displayed in the breadcrumb");
		Boolean isOtherLocator=(Boolean)(params.length>0?params[0]:false);
		if(isOtherLocator){
			click(ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS.replace("$link",link));
		}else 
			click(ELEMENT_PIPELINESETTING_BREADCRUMB_LINKS_2.replace("$link",link));
		Utils.pause(3000);
	}
	/**
	 * Click on save changes button
	 */
	public void save(){
		info("Click on save button");
		click(ELEMENT_PIPELINE_SAVE_CHANGES_BTN);
		Utils.pause(3000);
	}
	
	public enum tabType{
		VISIBILITY,GROUPBY,SUMMARY;
	}
	/**
	 * Verify that the column's position is changed
	 * @param colNbr
	 * @param colLabel
	 */
	public void verifyOrderColIsChange(tabType type,String colNbr,String colLabel){
		info("Verify that the column is changed the position");
		switch(type){
			case VISIBILITY:
				waitForAndGetElement(ELEMENT_PIPELINESETTING_VISIBILITY_LABEL_ITEM
						.replace("$number",colNbr)
						.replace("$label",colLabel),3000,1);
				break;
			case GROUPBY:
				waitForAndGetElement(ELEMENT_PIPELINESETTING_GROUPBY_LABEL_ITEM
						.replace("$number",colNbr)
						.replace("$label",colLabel),3000,1);
				break;
			case SUMMARY:
				break;
			default:
				info("Not found the tab");
				break;
		}
	}
	/**
	 * Get header's name of the column
	 * @param colNbr
	 * @return text
	 */
	public String getLabel(tabType type,String colNbr){
		info("Get header's name of the column");
		String text=null;
		switch(type){
		case VISIBILITY:
			text=waitForAndGetElement(ELEMENT_PIPELINESETTING_VISIBILITY_COLUMN.replace("$number",colNbr),2000,1).getText();
			while(text.charAt(0)==' ') text=text.substring(1);
			break;
		case GROUPBY:
			text=waitForAndGetElement(ELEMENT_PIPELINESETTING_GROUPBY_COLUMN.replace("$number",colNbr),2000,1).getText();
			while(text.charAt(0)==' ') text=text.substring(1);
			break;
		case SUMMARY:
			break;
		default:
			info("Not found the label");
			break;
		}
		info("text:"+text);
		return text;
	}
	/**
	 * Open group by tab
	 */
	public void goToGroupByTab(){
		info("Open group by tab");
		click(ELEMENT_PIPELINESETTING_GROUPBY_TAB);
		waitForAndGetElement(ELMEENT_PIPELINESETTING_GROUPBY_TITLE,2000,1);
		Utils.pause(3000);
	}
	
}
