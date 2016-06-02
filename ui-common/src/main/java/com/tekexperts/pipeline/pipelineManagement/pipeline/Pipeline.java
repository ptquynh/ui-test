package com.tekexperts.pipeline.pipelineManagement.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class Pipeline extends PipelineBase{
    //Mass update
	public By ELEMENT_PIPELINE_LIST_CHOOSE_BTN=By.xpath(".//*[@id='frmMassupdate']//input[@name='fileUpload']");
	public By ELEMENT_PIPELINE_LIST_MASSUPDATE_IMPORT_BTN=By.xpath(".//*[@id='btnImportMassUpdate']");
	
	//Pipeline list
	public By ELEMENT_PIPELINE_LIST=By.xpath(".//*[@id='gvPipeline']");
	public String ELEMENT_PIPELINE_DATA_ROW=".//*[@id='gvPipeline_DXDataRow$number']";
	public String ELEMENT_PIPELINE_COLUMN_CONTENT=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[@col-index='$number'][contains(text(),'$content')]";
	public String ELEMENT_PIPELINE_COLUMN_CONTENT_2=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[@col-index='$number'][contains(text(),'$content1')]/..//*[contains(text(),'$content2')]";
	public String ELEMENT_PIPELINE_COLUMN_HEADER_LABEL=".//*[@id='gvPipeline_DXHeadersRow$number']//*[contains(text(),'$label')]";
	
	//Import button
	public By ELEMENT_PIPELINE_LIST_IMPORT_BTN=By.xpath(".//*[@id='btnImport']");
	//Pipeline list content
	public String ELEMENT_PIPELINE_LIST_DATA=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$data')]";
	//Oppt ID data of a contract
	public String ELEMENT_PIPELINE_LIST_OPPTYID=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[contains(@id,'cell_OpptyID')]";
	public String ELEMENT_PIPELINE_LIST_LOSTREASON=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[contains(@id,'cell_LostReason')]";
	public String ELEMENT_PIPELINE_LIST_SHIPTONAME=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[contains(@id,'cell_ShipToName')]";
	public String ELEMENT_PIPELINE_LIST_DATA_BY_COL_INDEX=".//*[@id='gvPipeline_DXMainTable']//*[contains(text(),'$contract')]/..//*[@col-index='$number']";
	
	//Display setting button
	public By ELEMENT_PIPELINE_LIST_DISPLAYSETTING_BTN=By.xpath(".//*[@id='btnDisplaySetting']");
	
	//Notification message box
	public String ELEMENT_PIPELINE_LIST_NOTIFCATION_MESSAGE=".//*[@id='NotificationBox'][contains(text(),'$message')]";
	
	//************************************DISPLAY SETTING PAGE***********************\\
	public By ELEMENT_DISPLAY_SETTING_TITLE_PAGE=By.xpath(".//*[@id='right-side']//h1[contains(text(),'Custom display settings for Pipeline')]");
	public By ELEMENT_DISPLAY_SETTING_ALLCOLUMN_CHECKBOX=By.xpath(".//input[@id='ckAllColumns']");
	
	//Save all change button
	public By ELEMENT_DISPLAY_SETTING_SAVECHANGES_BTN=By.xpath(".//*[@id='btnSave']");
	//Back to pipeline list button
	public By ELEMENT_DISPLAY_SETTING_BACKTOPIPELINE_BTN =By.xpath(".//*[@id='btnBack']");
	
	//************************************FILTER*************************************\
	// filter column
	public String ELEMENT_PIPELINE_LIST_BY_COLUMN_INDEX_FILTER=".//*[@id='gvPipeline_DXFREditorcol$number_I']";
	public String ELEMENT_PIPELINE_LIST_BY_DROPLIST=".//*[@id='gvPipeline_DXFREditorcol$number_DDD_L_D']";
	public String ELEMENT_PIPELINE_LIST_DROPLIST_ITEM=".//*[contains(@id,'gvPipeline_DXFREditorcol$number')][contains(text(),'$item')]";
	
	public String ELEMENT_PIPELINE_ARROW_DROPDOWN=".//*[@id='gvPipeline_DXFREditorcol$number_B-1']";
	public String ELEMETN_PIPELINE_CALENDAR_DAY=".//*[@id='gvPipeline_DXFREditorcol$number_DDD_C_mt']//*[text()='$day']";
	
	public Pipeline(WebDriver dr) {
		driver=dr;
	}
	/**
	 * Search a contract by columns
	 * @param numberCol
	 * @param value
	 */
	public void search(int numberCol,String value){
		Actions act = new Actions(this.driver);
		act.moveToElement(this.driver.findElement(By.xpath(ELEMENT_PIPELINE_LIST_BY_COLUMN_INDEX_FILTER
				.replace("$number",String.valueOf(numberCol))))).perform();
		info("Type "+value+" into the field");
		type(ELEMENT_PIPELINE_LIST_BY_COLUMN_INDEX_FILTER
				.replace("$number",String.valueOf(numberCol)),value,true);
		//act.sendKeys(Keys.ENTER).perform();
		info("Finished filtering");
		Utils.pause(3000);
	}
	/**
	 * Searh data by date
	 * @param numberCol
	 * @param value
	 */
	public void searchDate(int numberCol,String value){
		Actions act = new Actions(this.driver);
		act.moveToElement(this.driver.findElement(By.xpath(ELEMENT_PIPELINE_LIST_BY_COLUMN_INDEX_FILTER
				.replace("$number",String.valueOf(numberCol))))).perform();
		info("Click on dropdown");
		waitForAndGetElement(ELEMENT_PIPELINE_ARROW_DROPDOWN.replace("$number",String.valueOf(numberCol)),3000,1).click();
		info("Select a day");
		waitForAndGetElement(ELEMETN_PIPELINE_CALENDAR_DAY
				.replace("$number",String.valueOf(numberCol))
				.replace("$day", value),3000,1).click();
		Utils.pause(3000);
		
	}
	/**
	 * Verify a item is shown in droplist of a filter column
	 * @param numberCol
	 * @param item
	 */
	public void verifyDroplist(int numberCol,String item){
		info("Verify that the "+item+" is shown");
		driver.findElement(By.xpath(ELEMENT_PIPELINE_LIST_DROPLIST_ITEM
				.replace("$number",String.valueOf(numberCol))
				.replace("$item",item)));
		Utils.pause(3000);
	}
	/**
	 * Verify that a item isnot shown in RTM droplist
	 * @param numberCol
	 * @param item
	 */
	public void verifyNOTINDroplist(int numberCol,String item){
		info("Verify that the "+item+" is shown");
		waitForElementNotPresent(ELEMENT_PIPELINE_LIST_DROPLIST_ITEM
				.replace("$number",String.valueOf(numberCol))
				.replace("$item",item),2000,1);
		Utils.pause(3000);
	}
	/**
	 * Verify that a contract in the list
	 * @param value
	 */
	public void verifyContractInList(String value){
		info("Verify that the contract has the data: "+value+" is displayed in the list");
		waitForAndGetElement(ELEMENT_PIPELINE_LIST_DATA.replace("$data",value),3000,1);
	}
	/**
	 * Get data of a contract from pipeline list
	 * @param numberCol
	 * @param contract
	 * @return text
	 */
	public String getDataFromPipeline(int numberCol,String contract){
		info("Get data from pipeline list of a contracts");
		String text=null;
		info("Get the text's value of the column:"+numberCol+"");
		text =waitForAndGetElement(ELEMENT_PIPELINE_LIST_DATA_BY_COL_INDEX
				.replace("$contract",contract)
				.replace("$number",String.valueOf(numberCol))).getText();
		info("The text of the column:"+numberCol+" is:"+text);
		info("Finished getting data");
		Boolean isEmpty= text==null || text.trim().length()==0;
		if(isEmpty)text=null;
		return text;
	}
	
	/**
	 * Import a ATR via Mass update from pipeline list
	 * @param path
	 */
	public void importATR(String path){
		info("Click on Import button");
		click(ELEMENT_PIPELINE_LIST_IMPORT_BTN);
		info("Verify that the Mass Update popup is shown");
		info("Click on Choose file button");
		info("path+fileName:"+path);
		waitForAndGetElement(ELEMENT_PIPELINE_LIST_CHOOSE_BTN).sendKeys(path);
		info("Click on Import button");
		click(ELEMENT_PIPELINE_LIST_MASSUPDATE_IMPORT_BTN);
		waitForElementNotPresent(ELEMENT_PIPELINE_LIST_MASSUPDATE_IMPORT_BTN,3000,1);
		info("Mass update popup is closed");
		Utils.pause(3000);
	}
	/**
	 * Define color for column
	 */
	public enum color{
		GRAY,BLUE,VIOLET,GREEN;
	}
	/**
	 * Compare date with only 2 texts
	 * @param oldText
	 * @param newText
	 * @param color
	 */
	public void compareData(String oldText,String newText,color color){
		switch(color){
		case BLUE:
			if(!oldText.equalsIgnoreCase(newText))assert true;
			else {
				info("The old text:"+oldText);
				info("The new text:"+newText);
				assert false:"The blue field is not updated via mass update";
			}
			break;
		case GRAY:
			if(!oldText.equalsIgnoreCase(newText))
				assert false:"The gray field is updated via mass update";
			else assert true;
			break;
		case VIOLET:
			break;
		case GREEN:
			break;
		default:
			info("Not color that you need in this list.");
			break;
		}
	}
	/**
	 * Compare data 
	 * @param list1
	 * @param list2
	 */
	public void compareData(List<String> list1,List<String> list2){
		info("list1.size():"+list1.size());
		for(int i=0;i<list1.size();i++){
			if(i<64||(i>65 && i<81)||(i>81 && i<97)||(i>148 && i<152)||i==158){
				 info("Gray list1.get("+i+"):"+list1.get(i));
				 info("Gray list2.get("+i+"):"+list2.get(i));
				 compareData(list1.get(i),list2.get(i), color.GRAY);
			}
			  
			if(i==64||i==65||(i>99 && i<107)||(i>108 && i<113)
					||i==114||i==115||(i>116 && i<124)||(i>150 && i<154)){
				    info("Blue list1.get("+i+"):"+list1.get(i));
				    info("Bule list2.get("+i+"):"+list2.get(i));
					compareData(list1.get(i),list2.get(i), color.BLUE);
			}
		}
		
	}
	/**
	 * Compare data from 2 array lists
	 * @param list1
	 * @param list2
	 */
	public void compareData(List<String> list1,List<String> list2, Object... opParams){
		Boolean isGrayCol = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		Boolean isBlueCol = (Boolean)(opParams.length > 1 ? opParams[1]: true);
		Boolean isGreenCol = (Boolean)(opParams.length > 2 ? opParams[2]: true);
		Boolean isVioletCol = (Boolean)(opParams.length > 3 ? opParams[3]: true);
		for(int i=1;i<list1.size();i++){
			if(isGrayCol){
				info("Compare 2 data for gray column");
				compareData(list1.get(i),list2.get(i), color.GRAY);
			}
			if(isBlueCol){
				info("Compare 2 data for blue column");
				compareData(list1.get(i),list2.get(i), color.BLUE);
			}
			if(isGreenCol){
				info("Compare 2 data for green column");
				compareData(list1.get(i),list2.get(i), color.GREEN);
			}
			if(isVioletCol){
				info("Compare 2 data for violet column");
				compareData(list1.get(i),list2.get(i), color.VIOLET);
			}
		}
	}
	/**
	 * Compare 2 data has same
	 * @param oldText
	 * @param newText
	 */
	public void compareData(String oldText,String newText){
		if(!oldText.equalsIgnoreCase(newText)){
			info(oldText+"\n");
			info(newText+"\n");
			assert false:"The field has same data";
		}
		else {
			info(oldText+"\n");
			info(newText+"\n");
			assert true;
		}
	}
	/**
	 * compare 2 numbers
	 * @param number1
	 * @param number2
	 */
	public void compareNumber(double number1,double number2){
		if(number1!=number2){
			info("number1false:"+number1);
			info("number2false:"+number2);
			assert false:"The field has same data";
		}
		else {
			info("number1true:"+number1);
			info("number2true:"+number2);
			assert true;
		}
	}
	
	/**
	 * Get all data of a contract on pipeline list without Sale Reps and Employee Id columns
	 * @param expDocNbr
	 */
	public List<String> getData(String expDocNbr){
		List<String> list= new ArrayList<String>();
		info("Get all data of a contract on the pipeline list");
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			 if(i!=82 && i!=83 && i!=84){
				 info("i:"+i);
				String data=getDataFromPipeline(i,expDocNbr);
				list.add(data);
			 }
		}
		info("list data on Pipeline list:");
		Utils.pause(3000);
		return list;
	}
	/**
	 * Get data of all gray column
	 * @param expDocNbr
	 * @return list
	 */
	public List<String> getDataOfGrayColumn(String expDocNbr){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			if((i>0 && i<65)||(i>66 && i<82)||(i>84 && i<101)||(i>151 && i<154)||i==160){
				String data=getDataFromPipeline(i,expDocNbr);
				list.add(data);
			}
		}
		return list;
	}
	/**
	 * Get all data of all blue column
	 * @param expDocNbr
	 * @return list
	 */
	public List<String> getDataOfBlueColumn(String expDocNbr){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			if(i==65||i==66||i!=82||i!=83||i==84||(i>102 && i<110)||(i>112 && i<116)
					||i==118||i==119||(i>120 && i<127)||(i>154 && i<158)){
				String data=getDataFromPipeline(i,expDocNbr);
				list.add(data);
			}
		}
		return list;
	}
	/**
	 * Get data of all Green column
	 * @param expDocNbr
	 * @return list
	 */
	public List<String> getDataOfGreenColumn(String expDocNbr){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			if(i==102||i==111||i==112||i==117||i==120||(i>127 && i<144)
					||i==150||i==151||i==158||i==159){
				String data=getDataFromPipeline(i,expDocNbr);
				list.add(data);
			}
		}
		return list;
	}
	/**
	 * Get all data of all violet column
	 * @param expDocNbr
	 * @return list
	 */
	public List<String> getDataOfVioletColumn(String expDocNbr){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			if(i>143 && i<149){
				String data=getDataFromPipeline(i,expDocNbr);
				list.add(data);
			}
		}
		return list;
	}
	/**
	 * Get all data of a contract after updated
	 * @param expDocNbr
	 */
	public List<String> getDataAfterUpload(String expDocNbr){
		List<String> list= new ArrayList<String>();
		for(int i=1;i<TOTAL_COLUMN_ATR+1;i++){
			  if(i!=82 || i!=83){
				  String data=getDataFromPipeline(i,expDocNbr);
					list.add(data);
			  }
		}
		return list;
	}
	/**
	 * OPen Display setting page
	 */
	public void goToDisplaySetting(){
		info("Click on the Display Setting button");
		click(ELEMENT_PIPELINE_LIST_DISPLAYSETTING_BTN);
		waitForAndGetElement(ELEMENT_DISPLAY_SETTING_TITLE_PAGE,3000,1);
		info("Display setting page is shown");
	}
	/**
	 * Select or Unselect all column checkbox
	 */
	public void clickOnAllColumnCheckbox(){
		info("Click on All column checkbox");
		WebElement el = this.driver.findElement(By.xpath(".//*[@id='tab_1']/div[1]/div/label/span"));
		el.click();
		//waitForAndGetElement(ELEMENT_DISPLAY_SETTING_ALLCOLUMN_CHECKBOX,3000,1).click();
		info("Click on Save changes button");
		click(ELEMENT_DISPLAY_SETTING_SAVECHANGES_BTN);
		Utils.pause(3000);
	}
	/**
	 * Back to pipeline list from display setting page
	 */
	 public void goToBackToPipelist(){
		 info("Click on Back to Pipeline list");
		 click(ELEMENT_DISPLAY_SETTING_BACKTOPIPELINE_BTN);
		 waitForAndGetElement(ELEMENT_PIPELINE_LIST_DISPLAYSETTING_BTN,3000,1);
		 info("The pipelist is display");
	 }
	 /**
	  * Verify that all column in the pipeline list is shown
	  * @param expDocNbr
	  * @return isAllColumn
	  */
	 public void checkAllColumnInPipelist(String expDocNbr){
		 Boolean isAllColumn = null;
			 if(waitForAndGetElement(ELEMENT_PIPELINE_LIST_DATA_BY_COL_INDEX
					 .replace("$contract",expDocNbr)
					 .replace("$number",String.valueOf(1)),2000,0)==null){
				 isAllColumn=false;
			 }else 
				 isAllColumn=true;
		 if(!isAllColumn){
			    info("Go to Display setting page");
				goToDisplaySetting();
				info("Check all column checkbox");
				clickOnAllColumnCheckbox();
				goToBackToPipelist();
		 }
	 }
	 /**
	  * Verify that a notification message is shown
	  * @param message
	  */
	 public void verifyNotifcationMessage(String message){
		 info("Verify that a notificaiton message is shown");
		 waitForAndGetElement(ELEMENT_PIPELINE_LIST_NOTIFCATION_MESSAGE.replace("$message",message),2000,1);
	 }
	 /**
	  * Get a number data from Pipeline list
	  * @param numCol
	  * @param expDocNbr
	  * @return number
	  */
	 public double getDataNumber(int numCol,String expDocNbr){
		 String txt=getDataFromPipeline(numCol, expDocNbr);
			double number=0;
			if(txt==null)
				info("number of "+numCol+":"+number);
			else{
				number=Math.round(Double.parseDouble(getDataFromPipeline(numCol, expDocNbr).replace(",","."))*1000);
				info("number of "+numCol+":"+number);
			}
		return number;
		 
	 }
	 /**
	  * Verify the content of a column
	  * @param numberCol
	  * @param expDocNbr
	  * @param content
	  */
	 public void verifyData(int numberCol,String expDocNbr,String content){
		 info("Verify that the content:"+content+" of the column:"+numberCol+" of the contract:"+expDocNbr);
		 waitForAndGetElement(ELEMENT_PIPELINE_COLUMN_CONTENT
				 .replace("$contract",expDocNbr)
				 .replace("$number", String.valueOf(numberCol))
				 .replace("$content",content),3000,1);
	 }
	 /**
	  * Verify the content of a contracts by 2 paramters
	  * @param numberCol
	  * @param expDocNbr
	  * @param content
	  * @param text
	  */
	 public void verifyData(int numberCol,String expDocNbr,String content,String text){
		 info("Verify that the content:"+content+" of the column:"+numberCol+" of the contract:"+expDocNbr);
		 waitForAndGetElement(ELEMENT_PIPELINE_COLUMN_CONTENT_2
				 .replace("$contract",expDocNbr)
				 .replace("$number", String.valueOf(numberCol))
				 .replace("$content1",content)
				 .replace("$content2", text),3000,1);
	 }
	 /**
	  * Verify that the header is shown correctly
	  * @param colNbr
	  * @param colLabel
	  */
	 public void verifyHeader(String colNbr,String colLabel){
		 info("Verify the column's header is shown correctly in pipeline list");
		 waitForAndGetElement(ELEMENT_PIPELINE_COLUMN_HEADER_LABEL
				 .replace("$number",colNbr)
				 .replace("$label",colLabel),3000,1);
	 }
	 
}
