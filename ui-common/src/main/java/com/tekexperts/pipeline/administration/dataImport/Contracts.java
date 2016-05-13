package com.tekexperts.pipeline.administration.dataImport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;

import static com.tekexperts.pipeline.common.TestLogger.info;

public class Contracts extends PipelineBase{
	
	//Choose file filed
	public By ELEMENT_DATAIMPORT_ATR_CHOOSEFILE_BTN=By.xpath(".//*[@id='frmImportContract']//input[@name='fileUpload']");
	//Import button
	public By ELEMENT_DATAIMPORT_ATR_IMPORT_BTN=By.xpath(".//*[@id='btnImportContract']");
	//File name filter
	public By ELEMENT_DATAIMPORT_ATR_FILENAME_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol2_I']");
	//File sixe filter
	public By ELEMENT_DATAIMPORT_ATR_FILESIZE_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol3_I']");
	//Upload data filter
	public By ELEMENT_DATAIMPORT_ATR_UPLOADDATA_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol4_I']");
	//Upload by filter
	public By ELEMENT_DATAIMPORT_ATR_UPLOADBY_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol5_I']");
	//View link
	public String ELEMENT_DATAIMPORT_ATR_VIEW_LINK=".//*[@id='gvImportContract_DXMainTable']//*[contains(text(),'$file')]/../..//*[contains(text(),'View')]";
	//File name link
	public String ELEMENT_DATAIMPORT_ATR_FILENAME_LINK=".//*[@id='gvImportContract_DXMainTable']//*[contains(text(),'$file')]";
	
	//***********************VIEW DETAIL*****************************\\
	//Status filter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_FILTER=By.xpath("");
	//IB type filter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_IBTYPE_FILTER=By.xpath("");
	//WW Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_WWREGION_FILTER=By.xpath("");
	//Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_REGION_FILTER=By.xpath("");
	//Sub Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBREGION_FILTER=By.xpath("");
	//Country
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_COUNTRY_FILTER=By.xpath("");
	//Exp Doc Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXPDOCNBR_FILTER=By.xpath("");
	//Sold to AMD 4 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD4NAME_FILTER=By.xpath("");
	//Sold to AMD 3 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD3NAME_FILTER=By.xpath("");
	//Sold to AMD 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD2NAME_FILTER=By.xpath("");
	//Ship to AMD 4 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD4NAME_FILTER=By.xpath("");
	//Ship to AMD 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD2NAME_FILTER=By.xpath("");
	//Ship to Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTONAME_FILTER=By.xpath("");
	//Date Expire
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEXPIRE_FILTER=By.xpath("");
	//Date Effective
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEFFECTIVE_FILTER=By.xpath("");
	//Duration
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DURATION_FILTER=By.xpath("");
	//Hdr Lifecycle Status
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HDRLIFCYCLESTATUS_FILTER=By.xpath("");
	//PO End Dt
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_POENDDT_FILTER=By.xpath("");
	//Renewal Dt
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RENEWALDT_FILTER=By.xpath("");
	//SAID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SAID_FILTER=By.xpath("");
	//Group Contract Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPCONTRACTNBR_FILTER=By.xpath("");
	//Support Group ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPID_FILTER=By.xpath("");
	//Amp link
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPLINK_FILTER=By.xpath("");
	//AMP ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPID_FILTER=By.xpath("");
	//Document Type
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCUMENTTYPE_FILTER=By.xpath("");
	//Func Loc 
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FUNCLOC_FILTER=By.xpath("");
	//PL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PL_FILTER=By.xpath("");
	//Canc Rsn
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSN_FILTER=By.xpath("");
	//Canc Rsn Decs
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSNDECS_FILTER=By.xpath("");
	//Upfront Order Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTORDERNBR_FILTER=By.xpath("");
	//Extended Cust Po Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXTENDEDCUSTPONBR_FILTER=By.xpath("");
	//User status
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_USERSTATUS_FILTER=By.xpath("");
	//Sales Metric Code Hdr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESMETRICCCODEHDR_FILTER=By.xpath("");
	//CSTM
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CSTM_FILTER=By.xpath("");
	//ELA
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ELA_FILTER=By.xpath("");
	//Global Currency
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GLOBALCURRENCY_FILTER=By.xpath("");
	//Doc Currency
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCCURRENCY_FILTER=By.xpath("");
	//Sp Site ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SPSITEID_FILTER=By.xpath("");
	//Sold to Party Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOPARTYNAME_FILTER=By.xpath("");
	//Cust Bill To Contact
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTBILLTOCONTACT_FILTER=By.xpath("");
	//Cust Invoice Contact
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTINVOICECONTACT_FILTER=By.xpath("");
	//Next Document Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_NEXTDOCUMENTNBR_FILTER=By.xpath("");
	//Previous Document Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PREVIOUSDOCUMENTNBR_FILTER=By.xpath("");
	//EXCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXCL_FILTER=By.xpath("");
	//T EXCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_TEXCL_FILTER=By.xpath("");
	//Distributor
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DISTRIBUTOR_FILTER=By.xpath("");
	//Reseller
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RESELLER_FILTER=By.xpath("");
	//Business Unit
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BUSINESSUNIT_FILTER=By.xpath("");
	//Billing Cycle
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BILLINGCYCLE_FILTER=By.xpath("");
	//Upfront of Renewal
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTOFRENEWAL_FILTER=By.xpath("");
	//Anniversary or Renewal
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYORRENEWAL_FILTER=By.xpath("");
	//Anniversary Date
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYDATE=By.xpath("");
	//Channel Y Or N
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELYORN_FILTER=By.xpath("");
	//Channel Type
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELTYPE_FILTER=By.xpath("");
	//Fiscal Month
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALMONTH_FILTER=By.xpath("");
	//Fiscal Quarter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALQUARTER_FILTER=By.xpath("");
	//Fiscal Half
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALHALF_FILTER=By.xpath("");
	//Quarter Year
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_QUARTERYEAR_FILTER=By.xpath("");
	//Half Year
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HALFYEAR_FILTER=By.xpath("");
	//Clean Sold To Amid 2ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2ID_FILTER=By.xpath("");
	//Clean Sold To Amid 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2NAME_FILTER=By.xpath("");
	//Sales Rep
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESREP_FILTER=By.xpath("");
	//Employee ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EMPLOYEEID_FILTER=By.xpath("");
	//RTM
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RTM_FILTER=By.xpath("");
	//Segment
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SEGMENT_FILTER=By.xpath("");
	//Sub Segment
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBSEGMENT_FILTER=By.xpath("");
	//Clean Ship to Amid 2 ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2ID_FILTER=By.xpath("");
	//Clean Ship to Amid 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2NAME_FILTER=By.xpath("");
	//Support Level
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUPPORTLEVEL_FILTER=By.xpath("");
	//SW or TS Mixed
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SWORTSMIXED_FILTER=By.xpath("");
	//Sold To Name Non English
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTONAMENONENGLISH_FILTER=By.xpath("");
	//ATR FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRFX_FILTER=By.xpath("");
	//ATR Value LCL FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUELCLFX_FILTER=By.xpath("");
	//ATR Value usd
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUEUSD_FILTER=By.xpath("");
	//EOL Value To Remove LCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVELCL_FILTER=By.xpath("");
	//EOL Value To Remove USD
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVEUSD_FILTER=By.xpath("");
	//Final ATR Value USD
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUEUSD_FILTER=By.xpath("");
	//Final ATR Value LCL FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUELCLFX_FILTER=By.xpath("");
	//Valid OR Invalid
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDORINVALID_FILTER=By.xpath("");
	//Valid Reason
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDREASON_FILTER=By.xpath("");
		
	public Contracts(WebDriver dr){
		driver = dr;
	}
	/**
	 * Upload a file 
	 * @param path
	 * @param fileName
	 */
	public void upload(String path,String fileName){
		info("Click on Choose file button");
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_CHOOSEFILE_BTN).sendKeys(path+fileName);;
		info("Click on Import button");
		click(ELEMENT_DATAIMPORT_ATR_IMPORT_BTN);
		info("Verify that the upload file is shown in the table");
		String[] preNameFile=fileName.split("\\.");
		String currentDate=getCurrentDate("yyyyMMdd");
		String importedFile=preNameFile[0]+currentDate;
		info("importedFile:"+importedFile);
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_FILENAME_LINK.replace("$file",importedFile),3000,1);
	}
}
