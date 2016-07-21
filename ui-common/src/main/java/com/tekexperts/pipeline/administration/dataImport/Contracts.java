package com.tekexperts.pipeline.administration.dataImport;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.tekexperts.pipeline.common.PipelineBase;
import com.tekexperts.pipeline.common.Utils;

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
	public By ELEMENT_DATAIMPORT_ATR_UPLOADDATE_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol4_I']");
	//Upload by filter
	public By ELEMENT_DATAIMPORT_ATR_UPLOADBY_FILTER=By.xpath(".//*[@id='gvImportContract_DXFREditorcol5_I']");
	//View link
	public String ELEMENT_DATAIMPORT_ATR_VIEW_LINK=".//*[@id='gvImportContract_DXMainTable']//*[contains(text(),'$file')]/../..//*[contains(text(),'View')]";
	//First view link
	public By ELEMENT_DATAIMPORT_ATR_FIRST_VIEW_LINK=By.xpath(".//*[@id='gvImportContract_tccell0_1']/a");
	//File name link
	public String ELEMENT_DATAIMPORT_ATR_FILENAME_LINK=".//*[@id='gvImportContract_DXMainTable']//*[contains(text(),'$file')]";
	//First uploaded file
	public By ELEMENT_DATAIMPORT_ATR_FIRST_UPLOADFILE=By.xpath(".//*[@id='gvImportContract_tccell0_2']/a");
	//Notification message
	public String ELEMENT_DATAIMPORT_NOTIFICATIONBOX_MESSAGE=".//*[@id='NotificationBox'][contains(text(),'$message')]";
	//Paging size
	public String ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX_ITEM=".//*[contains(@id,'gvImportContract_DXPagerBottom_PSP_DXI')]//*[text()='$size']";
	public By ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX_INPUT=By.xpath(".//*[@id='gvImportContract_DXPagerBottom_PSI']");
	public By ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX=By.xpath(".//*[@id='gvImportContract_DXPagerBottom_DDB']");
	public By ELEMENT_DATEIMPORT_TABLE=By.xpath(".//*[contains(@id,'gvImportContract_DXData')]");
	
	//***********************VIEW DETAIL*****************************\\
	//View detail page title
	public By ELEMENT_DATAIMPORT_ATR_VIEWDEAIL_TABLE=By.xpath(".//*[@id='gvTempContractDataUpload']");
	//Content of columns
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CONTENT=".//*[contains(@id,'gvTempContractDataUpload_DXDataRow')]/td[$col][contains(text(),'$text')]";
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CONTENT_COL=".//*[contains(@id,'gvTempContractDataUpload_DXDataRow')]/td[$col]";
	//Contract has Success status
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT=".//*[@id='gvTempContractDataUpload_DXMainTable']//*[contains(text(),'$expDocNbr')]/..//*[contains(text(),'Success')]";
	//Contract has No Region status
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NOREGION=".//*[@id='gvTempContractDataUpload_DXMainTable']//*[contains(text(),'$expDocNbr')]/..//*[contains(text(),'No Region')]";
	//Contract has Duplicate key status
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_DUPLICATE=".//*[@id='gvTempContractDataUpload_DXMainTable']//*[contains(text(),'$expDocNbr')]/..//*[contains(text(),'Insert Duplicated Key')]";
	//Contract has NO BU status
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NOBUSINESSUNIT=".//*[@id='gvTempContractDataUpload_DXMainTable']//*[contains(text(),'$expDocNbr')]/..//*[contains(text(),'No Business Unit')]";
	//Contract has NO RTM status
	public String ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NORTM=".//*[@id='gvTempContractDataUpload_DXMainTable']//*[contains(text(),'$expDocNbr')]/..//*[contains(text(),'No RTM')]";
	//Status filter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol0_I']");
	//IB type filter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_IBTYPE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol1_I']");
	//WW Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_WWREGION_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol2_I']");
	//Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_REGION_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol3_I']");
	//Sub Region
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBREGION_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol4_I']");
	//Country
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_COUNTRY_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol5_I']");
	//Exp Doc Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXPDOCNBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol6_I']");
	//Sold to AMD 4 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD4NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol7_I']");
	//Sold to AMD 3 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD3NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol8_I']");
	//Sold to AMD 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD2NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol9_I']");
	//Ship to AMD 4 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD4NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol10_I']");
	//Ship to AMD 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD2NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol11_I']");
	//Ship to Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTONAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol12_I']");
	//Date Expire
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEXPIRE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol13_I']");
	//Date Effective
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEFFECTIVE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol14_I']");
	//Duration
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DURATION_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol15_I']");
	//Hdr Lifecycle Status
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HDRLIFCYCLESTATUS_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol16_I']");
	//PO End Dt
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_POENDDT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol17_I']");
	//Renewal Dt
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RENEWALDT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol18_I']");
	//SAID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SAID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol19_I']");
	//Group Contract Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPCONTRACTNBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol20_I']");
	//Support Group ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol21_I']");
	//Amp link
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPLINK_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol22_I']");
	//AMP ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol23_I']");
	//Document Type
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCUMENTTYPE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol24_I']");
	//Func Loc 
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FUNCLOC_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol25_I']");
	//PL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol26_I']");
	//Canc Rsn
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSN_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol27_I']");
	//Canc Rsn Decs
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSNDECS_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol28_I']");
	//Upfront Order Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTORDERNBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol29_I']");
	//Extended Cust Po Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXTENDEDCUSTPONBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol30_I']");
	//User status
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_USERSTATUS_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol31_I']");
	//Sales Metric Code Hdr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESMETRICCCODEHDR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol32_I']");
	//CSTM
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CSTM_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol33_I']");
	//ELA
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ELA_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol34_I']");
	//Global Currency
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GLOBALCURRENCY_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol35_I']");
	//Doc Currency
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCCURRENCY_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol36_I']");
	//Sp Site ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SPSITEID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol37_I']");
	//Sold to Party Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOPARTYNAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol38_I']");
	//Cust Bill To Contact
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTBILLTOCONTACT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol39_I']");
	//Cust Bill To Contact
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTORDERTOCONTACT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol40_I']");
	//Cust Invoice Contact
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTINVOICECONTACT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol41_I']");
	//Next Document Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_NEXTDOCUMENTNBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol42_I']");
	//Previous Document Nbr
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PREVIOUSDOCUMENTNBR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol43_I']");
	//EXCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXCL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol44_I']");
	//T EXCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_TEXCL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol45_I']");
	//Distributor
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DISTRIBUTOR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol46_I']");
	//Reseller
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RESELLER_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol47_I']");
	//Business Unit
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BUSINESSUNIT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol48_I']");
	//Billing Cycle
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BILLINGCYCLE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol49_I']");
	//Upfront of Renewal
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTOFRENEWAL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol50_I']");
	//Anniversary or Renewal
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYORRENEWAL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol51_I']");
	//Anniversary Date
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYDATE=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol52_I']");
	//Channel Y Or N
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELYORN_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol53_I']");
	//Channel Type
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELTYPE_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol54_I']");
	//Fiscal Month
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALMONTH_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol55_I']");
	//Fiscal Quarter
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALQUARTER_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol56_I']");
	//Fiscal YEAR
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALYEAR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol57_I']");
	//Fiscal Half
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALHALF_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol58_I']");
	//Quarter Year
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_QUARTERYEAR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol59_I']");
	//Half Year
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HALFYEAR_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol60_I']");
	//Clean Sold To Amid 2ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2ID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol61_I']");
	//Clean Sold To Amid 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol62_I']");
	//Sales Rep
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESREP_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol63_I']");
	//Employee ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EMPLOYEEID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol64_I']");
	//RTM
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RTM_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol65_I']");
	//Segment
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SEGMENT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol66_I']");
	//Sub Segment
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBSEGMENT_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol67_I']");
	//Clean Ship to Amid 2 ID
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2ID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol68_I']");
	//Clean Ship to Amid 2 Name
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2NAME_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol69_I']");
	//Support Level
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUPPORTLEVEL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol70_I']");
	//SW or TS Mixed
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SWORTSMIXED_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol71_I']");
	//Sold To Name Non English
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTONAMENONENGLISH_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol72_I']");
	//ATR FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRFX_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol73_I']");
	//ATR Value LCL FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUELCLFX_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol74_I']");
	//ATR Value usd
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUEUSD_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol75_I']");
	//EOL Value To Remove LCL
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVELCL_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol76_I']");
	//EOL Value To Remove USD
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVEUSD_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol77_I']");
	//Final ATR Value USD
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUEUSD_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol78_I']");
	//Final ATR Value LCL FX
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUELCLFX_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol79_I']");
	//Valid OR Invalid
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDORINVALID_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol80_I']");
	//Valid Reason
	public By ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDREASON_FILTER=By.xpath(".//*[@id='gvTempContractDataUpload_DXFREditorcol81_I']");
		
	public Contracts(WebDriver dr){
		driver = dr;
	}
	/**
	 * Verify default columns that are displayed in View Detail table
	 */
	public void verifyDefaultColumns(){
		 info("Status filter");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_FILTER,2000,1);
			info("IB type filter");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_IBTYPE_FILTER,2000,1);
			info("WW Region");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_WWREGION_FILTER,2000,1);
			info("Region");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_REGION_FILTER,2000,1);
			info("Sub Region");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBREGION_FILTER,2000,1);
			info("Country");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_COUNTRY_FILTER,2000,1);
			info("Exp Doc Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXPDOCNBR_FILTER,2000,1);
			info("Sold to AMD 4 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD4NAME_FILTER,2000,1);
			info("Sold to AMD 3 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD3NAME_FILTER,2000,1);
			info("Sold to AMD 2 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOAMD2NAME_FILTER,2000,1);
			info("Ship to AMD 4 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD4NAME_FILTER,2000,1);
			info("Ship to AMD 2 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTOAMD2NAME_FILTER,2000,1);
			info("Ship to Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SHIPTONAME_FILTER,2000,1);
			info("Date Expire");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEXPIRE_FILTER,2000,1);
			info("Date Effective");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DATEEFFECTIVE_FILTER,2000,1);
			info("Duration");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DURATION_FILTER,2000,1);
			info("Hdr Lifecycle Status");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HDRLIFCYCLESTATUS_FILTER,2000,1);
			info("PO End Dt");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_POENDDT_FILTER,2000,1);
			info("Renewal Dt");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RENEWALDT_FILTER,2000,1);
			info("SAID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SAID_FILTER,2000,1);
			info("Group Contract Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPCONTRACTNBR_FILTER,2000,1);
			info("Support Group ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GROUPID_FILTER,2000,1);
			info("Amp link");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPLINK_FILTER,2000,1);
			info("AMP ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_AMPID_FILTER,2000,1);
			info("Document Type");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCUMENTTYPE_FILTER,2000,1);
			info("Func Loc ");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FUNCLOC_FILTER,2000,1);
			info("PL");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PL_FILTER,2000,1);
			info("Canc Rsn");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSN_FILTER,2000,1);
			info("Canc Rsn Decs");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CANCRSNDECS_FILTER,2000,1);
			info("Upfront Order Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTORDERNBR_FILTER,2000,1);
			info("Extended Cust Po Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXTENDEDCUSTPONBR_FILTER,2000,1);
			info("User status");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_USERSTATUS_FILTER,2000,1);
			info("Sales Metric Code Hdr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESMETRICCCODEHDR_FILTER,2000,1);
			info("CSTM");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CSTM_FILTER,2000,1);
			info("ELA");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ELA_FILTER,2000,1);
			info("Global Currency");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_GLOBALCURRENCY_FILTER,2000,1);
			info("Doc Currency");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DOCCURRENCY_FILTER,2000,1);
			info("Sp Site ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SPSITEID_FILTER,2000,1);
			info("Sold to Party Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTOPARTYNAME_FILTER,2000,1);
			info("Cust Bill To Contact");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTBILLTOCONTACT_FILTER,2000,1);
			info("Cust Order To Contact");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTORDERTOCONTACT_FILTER,2000,1);
			info("Cust Invoice Contact");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CUSTINVOICECONTACT_FILTER,2000,1);
			info("Next Document Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_NEXTDOCUMENTNBR_FILTER,2000,1);
			info("Previous Document Nbr");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_PREVIOUSDOCUMENTNBR_FILTER,2000,1);
			info("EXCL");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EXCL_FILTER,2000,1);
			info("T EXCL");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_TEXCL_FILTER,2000,1);
			info("Distributor");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_DISTRIBUTOR_FILTER,2000,1);
			info("Reseller");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RESELLER_FILTER,2000,1);
			info("Business Unit");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BUSINESSUNIT_FILTER,2000,1);
			info("Billing Cycle");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_BILLINGCYCLE_FILTER,2000,1);
			info("Upfront of Renewal");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_UPFRONTOFRENEWAL_FILTER,2000,1);
			info("Anniversary or Renewal");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYORRENEWAL_FILTER,2000,1);
			info("Anniversary Date");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ANNIVERSARYDATE,2000,1);
			info("Channel Y Or N");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELYORN_FILTER,2000,1);
			info("Channel Type");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CHANNELTYPE_FILTER,2000,1);
			info("Fiscal Month");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALMONTH_FILTER,2000,1);
			info("Fiscal Quarter");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALQUARTER_FILTER,2000,1);
			info("Fiscal YEAR");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALYEAR_FILTER,2000,1);
			info("Fiscal Half");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FISCALHALF_FILTER,2000,1);
			info("Quarter Year");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_QUARTERYEAR_FILTER,2000,1);
			info("Half Year");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_HALFYEAR_FILTER,2000,1);
			info("Clean Sold To Amid 2ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2ID_FILTER,2000,1);
			info("Clean Sold To Amid 2 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSOLDTOAMID2NAME_FILTER,2000,1);
			info("Sales Rep");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SALESREP_FILTER,2000,1);
			info("Employee ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EMPLOYEEID_FILTER,2000,1);
			info("RTM");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_RTM_FILTER,2000,1);
			info("Segment");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SEGMENT_FILTER,2000,1);
			info("Sub Segment");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUBSEGMENT_FILTER,2000,1);
			info("Clean Ship to Amid 2 ID");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2ID_FILTER,2000,1);
			info("Clean Ship to Amid 2 Name");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CLEANSHIPTOAMID2NAME_FILTER,2000,1);
			info("Support Level");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SUPPORTLEVEL_FILTER,2000,1);
			info("SW or TS Mixed");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SWORTSMIXED_FILTER,2000,1);
			info("Sold To Name Non English");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_SOLDTONAMENONENGLISH_FILTER,2000,1);
			info("ATR FX");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRFX_FILTER,2000,1);
			info("ATR Value LCL FX");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUELCLFX_FILTER,2000,1);
			info("ATR Value usd");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_ATRVALUEUSD_FILTER,2000,1);
			info("EOL Value To Remove LCL");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVELCL_FILTER,2000,1);
			info("EOL Value To Remove USD");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_EOLVALUETOREMOVEUSD_FILTER,2000,1);
			info("Final ATR Value USD");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUEUSD_FILTER,2000,1);
			info("Final ATR Value LCL FX");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_FINALATRVALUELCLFX_FILTER,2000,1);
			info("Valid OR Invalid");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDORINVALID_FILTER,2000,1);
			info("Valid Reason");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_VALIDREASON_FILTER,2000,1);
	}
	/**
	 * Verify the content of a column
	 * @param colNumber
	 * @param content
	 */
	public void verifyContentColumns(String colNumber,String content){
		info("Verify that the content of the columns:"+colNumber+" is shown with the content:"+content);
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CONTENT
				.replace("$col",colNumber).replace("$text",content),2000,1);
	}
	/**
	 * Get all content of all columns in View detail page
	 * @return list
	 */
	public List<String> getContentAllColumns(){
		List<String> list= new ArrayList<String>();
		for(int i=2;i<83;i++){
			String el=waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_CONTENT_COL
					.replace("$col",String.valueOf(i))).getText();
			if((el.contains("/") && el.contains("AM")) ||(el.contains("/") && el.contains("PM"))){
				String[] smallList=el.split(" ");
				el=smallList[0];
			}
			if(el.isEmpty()|| el.equals(" "))
				list.add("null");
			else list.add(el);
			
		}
			
		return list;
		
	}
	/**
	 * Upload a file 
	 * @param path
	 * @param fileName
	 * @param params
	 */
	public void upload(String path,String fileName,Object... params){
		Boolean isVerify= (Boolean)(params.length>0?params[0]:true);
		info("Click on Choose file button");
		info("path+fileName:"+path+fileName);
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_CHOOSEFILE_BTN).sendKeys(path+fileName);
		info("Click on Import button");
		click(ELEMENT_DATAIMPORT_ATR_IMPORT_BTN);
		Utils.pause(3000);
		if(isVerify)
			verifyContractInTable(fileName);
	}
	
	/**
	 * Verify that a contract is shown in the table
	 * @param fileName
	 * @param params
	 */
	public void verifyContractInTable(String fileName,Object... params){
		Boolean isShown=(Boolean)(params.length>0? params[0]:true);
		String[] preNameFile=fileName.split("\\.");
		String currentDate=getCurrentDate("yyyyMMdd");
		String importedFile=preNameFile[0]+currentDate;
		if(isShown){
			info("Verify that the upload file is shown in the table");
			info("importedFile:"+importedFile);
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_FILENAME_LINK.replace("$file",importedFile),3000,1);
		}else{
			info("Verify that the file is not shown in the table");
			waitForElementNotPresent(ELEMENT_DATAIMPORT_ATR_FILENAME_LINK.replace("$file",importedFile),3000,1);
		}
		
	}
	/**
	 * Download a file
	 */
	public void download(){
		info("Click on the first file on the table");
		String getFileName=waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_FIRST_UPLOADFILE,2000,1).getText();
		info("getFileName"+getFileName);
		click(ELEMENT_DATAIMPORT_ATR_FIRST_UPLOADFILE);
		info("Check the downloaded file");
		Boolean isHasFile=checkFileExisted(getFileName);
		if(!isHasFile)assert false:"Cannot download the file";
		
	}
	/**
	 * Open detail first contract
	 */
	public void goToViewDetail(){
		info("Click on View link of the first contract");
		click(ELEMENT_DATAIMPORT_ATR_FIRST_VIEW_LINK);
		waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDEAIL_TABLE,3000,1);
		info("View detail page is shown");
	}
	
	public enum status{
		SUCCESS,DUPLICATE,NOREGION,NOBUSINESSUNIT,NORTM;
	}
	/**
	 * Verify the status in View detail
	 * @param status
	 * @param expDocNbr
	 */
	public void checkStatus(status status,String expDocNbr){
		switch(status){
		case SUCCESS:
			info("Verify that a contact has Success status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT.replace("$expDocNbr",expDocNbr),3000,1);
			break;
		case DUPLICATE:
			info("Verify that a contact has Insert duplicate Key status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_DUPLICATE.replace("$expDocNbr",expDocNbr),3000,1);
			break;
		case NOREGION:
			info("Verify that a contact has No Region status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NOREGION.replace("$expDocNbr",expDocNbr),3000,1);
			break;
		case NOBUSINESSUNIT:
			info("Verify that a contact has No BU status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NOBUSINESSUNIT.replace("$expDocNbr",expDocNbr),3000,1);
			break;
		case NORTM:
			info("Verify that a contact has No RTM status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT_NORTM.replace("$expDocNbr",expDocNbr),3000,1);
			break;
		default:
			info("This status is not availabled");
			break;
		}
	}
	
	
	/**
	 * Verify that many contracts have Success status after imported successfully
	 * @param expDocNbrList
	 */
	public void checkSuccessATR(ArrayList<String> expDocNbrList){
		for(int i=0;i<expDocNbrList.size();i++){
			info("Verify that the contact:"+expDocNbrList.get(i)+" has Success status after import successfully");
			waitForAndGetElement(ELEMENT_DATAIMPORT_ATR_VIEWDETAIL_STATUS_CONTRACT.replace("$expDocNbr",expDocNbrList.get(i)),3000,1);
		}
	}
	/**
	 * Compare array error messages
	 * @param sourcelist
	 */
	public void compareErrors(ArrayList<String> sourcelist){
		String text = driver.findElement(By.xpath(".//*[@id='NotificationBox']")).getText();
		String[] realList=text.split("\n");
		for(int i=0;i<realList.length;i++){
			info("realList:"+realList[i]);
			info("sourcelist:"+sourcelist.get(i));
			String errorMesg=realList[i].trim();
			if(!errorMesg.equalsIgnoreCase(sourcelist.get(i))) {
				info("realList is not equal:"+realList[i]);
				info("sourcelist is not equal:"+sourcelist.get(i));
				assert false;
			}
		}
	}
	
	/**
	 * Check the message on notificaiton box
	 * @param message
	 */
	public void verifyMessageNotification(String message){
		info("The message:"+message+" is shown");
		waitForAndGetElement(ELEMENT_DATAIMPORT_NOTIFICATIONBOX_MESSAGE.replace("$message",message),2000,1);
		info("The message is shown successfully");
	}
	/**
	 * Define column filters for contract list
	 */
	public enum contractFilter{
		FILE_NAME,FILE_SIZE,UPLOAD_DATE,UPLOAD_BY;
	}
	
	/**
	 * Filter contract
	 * @param col
	 * @param searchText
	 */
	public void searchBy(contractFilter col,String searchText){
		switch(col){
		case FILE_NAME:
			info("Search by file name column");
			type(ELEMENT_DATAIMPORT_ATR_FILENAME_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case FILE_SIZE:
			info("Search by file size column");
			type(ELEMENT_DATAIMPORT_ATR_FILESIZE_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case UPLOAD_DATE:
			info("Search by upload date column");
			type(ELEMENT_DATAIMPORT_ATR_UPLOADDATE_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		case UPLOAD_BY:
			info("Search by upload by column");
			type(ELEMENT_DATAIMPORT_ATR_UPLOADBY_FILTER,searchText,true);
			Utils.pause(3000);
			break;
		default:
			info("Not found the column in the table");
			break;
		}
	}
	/**
	 * Verify paging size
	 * @param list
	 */
	public void checkPageSize(String[] list){
		for(String el:list){
			int j=Integer.parseInt(el);
			int defaultValue=getDefaulPageSize();
			if(defaultValue!=j){
				changePageSize(el);
				int i=getNumberRow();
				if(i<defaultValue && i>j)assert false:"The page size is not correct";
			}
		}
	}
	
	/**
	 * Get default value of page size
	 * @return default value
	 */
	public Integer getDefaulPageSize(){
		info("Get default value of the page size");
		String defaultValue=waitForAndGetElement(ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX_INPUT).getAttribute("value").toString();
		return Integer.parseInt(defaultValue);
		
	}
	
	/**
	 * count the row in the table
	 * @return the number of data is shown
	 */
	public Integer getNumberRow(){
		info("Get all curren rows are displaying in the table");
		return driver.findElements(ELEMENT_DATEIMPORT_TABLE).size();
		
	}
	
	/**
	 * Change page size
	 * @param size
	 */
	public void changePageSize(String size){
		info("Click on the dropbox page size");
		waitForAndGetElement(ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX,2000,1).click();
		Utils.pause(3000);
		info("Select the number:"+size+" in the dropbox");
		waitForAndGetElement(ELEMENT_DATAIMPORT_PAGESIZE_DROPBOX_ITEM.replace("$size",size),2000,1).click();
		Utils.pause(3000);
	}
}
