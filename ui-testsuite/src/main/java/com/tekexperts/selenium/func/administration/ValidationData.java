package com.tekexperts.selenium.func.administration;
import static com.tekexperts.pipeline.common.TestLogger.info;

import java.util.ArrayList;

import org.testng.annotations.Test;
public class ValidationData extends TestConfig{
	/**
	 * Get an array error message
	 * @param nbrStart
	 * @param nbrEnd
	 * @param indexErrorType
	 * @return arrayErrors
	 */
	public ArrayList<String> getSourceErrorList(int nbrStart,int nbrEnd,int indexErrorType){
		ArrayList<String> arrayErrors= new ArrayList<String>();
		for (int i = nbrStart; i < nbrEnd+1; i++) {
			String error = mesg.getContentByType(indexErrorType).replace("$N",
					String.valueOf(i));
			arrayErrors.add(error);
		}
		return arrayErrors;
	}
	/**
	 * Get an array error message
	 * @param nbrStart
	 * @param nbrEnd
	 * @return arrayErrors
	 */
	public ArrayList<String> getSourceErrorList(int nbrStart,int nbrEnd){
		ArrayList<String> arrayErrors= new ArrayList<String>();
		for (int i = nbrStart; i < nbrEnd+1; i++) {
			String error=mesg.getContentByType(i);
			arrayErrors.add(error);
		}
		return arrayErrors;
	}
		
		/**
		* Test case ID:VAN-2335
		* Test case name:Check invalid Country and Region fields of EMEA Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2335_CheckInvalidContryAndRegionFieldsOfEMEAContracts(){
			info("Check invalid Country and Region fields of EMEA Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(95);
			ArrayList<String> arrayErrors= getSourceErrorList(2,685,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
			
		}
		/**
		* Test case ID:VAN-2337
		* Test case name:Check invalid Country and Region fields of APJ Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2337_CheckInvalidContryAndRegionFieldsOfAPJContracts(){
			info("Check invalid Country and Region fields of APJ Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(94);
			ArrayList<String> arrayErrors= getSourceErrorList(2,180,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2336
		* Test case name:Check invalid Country and Region fields of AMS Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2336_CheckInvalidContryAndRegionFieldsOfAMSContracts(){
			info("Check invalid Country and Region fields of AMS Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(93);
			ArrayList<String> arrayErrors= getSourceErrorList(2,25,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2334
		* Test case name:Check invalid Country and SubRegion fields of EMEA Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2334_CheckInvalidContryAndSubRegionFieldsOfEMEAContracts(){
			info("Check invalid Contry and SubRegion fields of EMEA Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(92);
			ArrayList<String> arrayErrors= getSourceErrorList(2,3029,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2333
		* Test case name:Check invalid Contry and SubRegion fields of APJ Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2333_CheckInvalidContryAndSubRegionFieldsOfAPJContracts(){
			info("Check invalid Contry and SubRegion fields of APJ Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(91);
			ArrayList<String> arrayErrors= getSourceErrorList(2,180,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2332
		* Test case name:Check invalid Contry and SubRegion fields of AMS Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2332_CheckInvalidContryAndSubRegionFieldsOfAMSContracts(){
			info("Check invalid Contry and SubRegion fields of AMS Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(90);
			ArrayList<String> arrayErrors= getSourceErrorList(2,105,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2324
		* Test case name:Check invalid PL and BU fields of Renewal Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i):Business Unit does not match with the selected PL..]
		*/
		@Test
		public void VAN2324_CheckInvalidPLAndBUFieldsOfRenewalContracts(){
			info("Check invalid PL and BU fields of Renewal Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(89);
			ArrayList<String> arrayErrors= getSourceErrorList(2,135,214);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2323
		* Test case name:Check invalid PL and BU fields of Anniversary Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Show the error message for each rows as:[Row (i):Business Unit does not match with the selected PL..]
		*/
		@Test
		public void VAN2323_CheckInvalidPLAndBUFieldsOfAnniversaryContracts(){
			info("Check invalid PL and BU fields of Anniversary Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(88);
			ArrayList<String> arrayErrors= getSourceErrorList(2,133,214);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2318
		* Test case name:Check valid PL and BU fields of Anniversary Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Not show any error message. All contracts are imported successfully
		*/
		@Test
		public void VAN2318_CheckValidPLAndBUFieldsOfAnniversaryContracts(){
			info("Check valid PL and BU fields of Anniversary Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(87);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.verifyMessageNotification("Contract has been imported successfully");
		}
		/**
		* Test case ID:VAN-2316
		* Test case name:Check valid PL and BU fields of Renewal Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error message
		* Expected Result:Not show any error message. All contracts are imported successfully
		*/
		@Test
		public void VAN2316_CheckValidPLAndBUFieldsOfRenewalContracts(){
			info("Check valid PL and BU fields of Renewal Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(86);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.verifyMessageNotification("Contract has been imported successfully");
		}
		/**
		* Test case ID:VAN-2252
		* Test case name:Check invalid EMEA Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2252_CheckInvalidEMEARegionFields(){
			info("Check invalid EMEA Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(85);
			ArrayList<String> arrayErrors= getSourceErrorList(2,101,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2251
		* Test case name:Check invalid AMS Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2251_CheckInvalidAMSRegionFields(){
			info("Check invalid APJ Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(84);
			ArrayList<String> arrayErrors= getSourceErrorList(2,42,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2250
		* Test case name:Check valid EMEA Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Not show any error message. All contracts are imported successfully
		*/
		@Test
		public void VAN2250_CheckValidEMEARegionFields(){
			info("Check valid EMEA Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(83);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.verifyMessageNotification("Contract has been imported successfully");
		}
		/**
		* Test case ID:VAN-2249
		* Test case name:Check valid AMS Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Not show any error message. All contracts are imported successfully
		*/
		@Test
		public void VAN2249_CheckValidAMSRegionFields(){
			info("Check valid AMS Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(82);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.verifyMessageNotification("Contract has been imported successfully");
		}
		/**
		* Test case ID:VAN-2248
		* Test case name:Check valid APJ Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Not show any error message. All contracts are imported successfully
		*/
		@Test
		public void VAN2248_CheckValidAPJRegionFields(){
			info("Check valid APJ Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(81);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.verifyMessageNotification("Contract has been imported successfully");
		}
		/**
		* Test case ID:VAN-2240
		* Test case name:Check invalid APJ Region fields
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:Show the error message for each rows as:[Row (i): WW Region, Region, Sub Region, Country do not align.]
		*/
		@Test
		public void VAN2240_CheckInvalidAPJRegionFields(){
			info("Check invalid APJ Region fields");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(80);
			ArrayList<String> arrayErrors= getSourceErrorList(2,40,213);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2234
		* Test case name:Check format fields for Anniversary Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:
		* Row 2 : Date Effective is incorrect date time format.
			Row 3 : Date Expire is incorrect date time format.
			Row 4 : Renewal Dt is incorrect date time format.
			Row 5 :[PL] is invalid data.
			Row 5 :Business Unit does not match with the selected PL.
			Row 6 :[ELA] is invalid data.
			Row 7 :[ELA] is invalid data.
			Row 8 :[Global Currency] is invalid data.
			Row 9 :[Doc Currency] is invalid data.
			Row 10 :[Business Unit]] is invalid data.
			Row 10 :Business Unit does not match with the selected PL.
			Row 11 :[Upfront Or Renewa] is invalid data.
			Row 12 :[Upfront Or Renewa] is invalid data.
			Row 13 :[Anniversary Or Renewal] is invalid data.
			Row 14 : Anniversary Date is incorrect date time format.
			Row 15 :[Channel Y Or N] is invalid data.
			Row 16 :[Channel Y Or N] is invalid data.
			Row 17 :[Fiscal Month]] is invalid data.
			Row 18 :[Fiscal Month]] is invalid data.
			Row 19 :[Fiscal Month]] is invalid data.
			Row 20 :[Fiscal Month]] is invalid data.
			Row 21 : Fiscal Quarter is invalid data.
			Row 21 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 22 : Fiscal Quarter is invalid data.
			Row 22 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 23 : Fiscal Quarter is invalid data.
			Row 23 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 24 : Fiscal Year must be number.
			Row 24 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 24 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 25 : Fiscal Year must be from 2000 to 3000.
			Row 25 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 25 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 26 : Fiscal Year must be from 2000 to 3000.
			Row 26 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 26 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 27 : Fiscal Half is invalid data.
			Row 27 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 28 : Fiscal Half is invalid data.
			Row 28 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 29 : Fiscal Half is invalid data.
			Row 29 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 30 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 31 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
			Row 32 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 33 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
			Row 34 :[Employee ID] is invalid data.
			Row 35 :[RTM] is invalid data.
			Row 36 :[Segment] is invalid data.
			Row 37 :[Sub Segment] is invalid data.
			Row 38 :[Support Level] is invalid data.
			Row 39 :[Support Level] is invalid data.
			Row 40 :[Support Level] is invalid data.
			Row 41 :[Support Level] is invalid data.
			Row 43 : [ATR FX] must be number. Please input again
			Row 44 : [ATR Value LCL FX] must be number. Please input again
			Row 45 : [ATR Value USD] must be number. Please input again
			Row 46 : [EOL Value To Remove LCL] must be number. Please input again
			Row 47 : [EOL Value To Remove USD] must be number. Please input again
			Row 48 : [Final ATR Value LCL FX] must be number. Please input again
			Row 49 : [Final ATR Value USD] must be number. Please input again
			Row 52 :[Valid Or Invalid] is invalid data.
			Row 53 :[Valid Or Invalid] is invalid data.
			Row 55 :[Quote Prepaid] is invalid data.
			Row 56 :[Quote Prepaid] is invalid data.
			Row 59 : [RTS Plus Penalty Fee LCL FX] must be number. Please input again
			Row 60 : [Foundation Total LCL FX] must be number. Please input again
			Row 61 :[Quote Currency] is invalid data.
			Row 62 :[Quote Status] is invalid data.
			Row 64 :[Quote Status] is invalid data.
			Row 66 :[Renewal Status] is invalid data.
			Row 68 :[Renewal Status] is invalid data.
			Row 71 :[Renewal Status] is invalid data.
			Row 72 :[Renewal Status] is invalid data.
			Row 74 :[Renewal Status] is invalid data.
			Row 76 : Close Date is incorrect date time format.
			Row 77 :[Po In] is invalid data.
			Row 79 :[Po In] is invalid data.
			Row 81 :[FCST Risk] is invalid data.
			Row 83 :[FCST Risk] is invalid data.
			Row 85 :[Manual REV] is invalid data.
			Row 87 :[Manual REV] is invalid data.
			Row 89 :[Lost Reason] is invalid data.
			Row 90 :[Lost Risk] is invalid data.
			Row 92 :[Lost Risk] is invalid data.
			Row 94 :[Invalid Reason] is invalid data.
			Row 95 :[Underforecast Or Upsell Reason] is invalid data.
			Row 96 :[CAM RISK] is invalid data.
			Row 98 :[CAM RISK] is invalid data.
		*/
		@Test
		public void VAN2234_CheckFormatFieldsForAnniversaryContracts(){
			info("Check format fields for Anniversary Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(79);
			ArrayList<String> arrayErrors= getSourceErrorList(124,212);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2232
		* Test case name:Check format fields for Renewal Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:
		* Row 2 : Date Effective is incorrect date time format.
		Row 3 : Date Expire is incorrect date time format.
		Row 4 : Renewal Dt is incorrect date time format.
		Row 5 :[ELAl] is invalid data.
		Row 6 :[Global Currency] is invalid data.
		Row 7 :[Doc Currency] is invalid data.
		Row 8 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
		Row 9 : Fiscal Quarter is invalid data.
		Row 9 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
		Row 10 : Quarter Year must be in format [Fiscal Year]-[Fiscal Quarter].
		Row 11 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
		Row 12 : Half Year must be in format [Fiscal Year]-[Fiscal Half].
		Row 13 : [ATR FX] must be number. Please input again
		Row 14 : [ATR Value LCL FX] must be number. Please input again
		Row 15 : [ATR Value USD] must be number. Please input again
		Row 16 : [EOL Value To Remove LCL] must be number. Please input again
		Row 17 : [EOL Value To Remove USD] must be number. Please input again
		Row 18 : [Final ATR Value LCL FX] must be number. Please input again
		Row 19 : [Final ATR Value USD] must be number. Please input again
		Row 20 : Quote Start Date is incorrect date time format.
		Row 21 : [Quote End Date] must be greater than [Quote Start Date].
		Row 22 : Quote End Date is incorrect date time format.
		Row 23 : [RTS Plus Penalty Fee LCL FX] must be number. Please input again
		Row 24 : [Foundation Total LCL FX] must be number. Please input again
		Row 25 :[Quote Currency] is invalid data.
		Row 26 :[Quote Status] is invalid data.
		Row 27 :[Renewal Status] is invalid data.
		Row 28 : Close Date is incorrect date time format.
		Row 29 :[Po In] is invalid data.
		Row 30 :[FCST Risk] is invalid data.
		Row 31 :[Manual REV] is invalid data.
		Row 32 :[Lost Risk] is invalid data.
		Row 33 :[Invalid Reason] is invalid data.
		Row 34 :Underforecast Or Upsell Reason is is invalid data. is invalid data.
		Row 35 :[CAM RISK] is invalid data.
		*/
		@Test
		public void VAN2232_CheckFormatFieldsForRenewalContracts(){
			info("Check format fields for Renewal Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(78);
			ArrayList<String> arrayErrors= getSourceErrorList(88,122);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2228
		* Test case name:Check required fields for Anniversary Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:
		* Row 2: Exp Doc Nbr is required
		* Row 3: Date Effective is required
		* Row 4: Date Expire is required
		* Row 5: Renewal Dt is required
		* Row 6: PL is required
		* Row 7: Business Unit is required
		* Row 8: Upfront Or Renewal is required
		* Row 9: Anniversary Or Renewal is required
		* Row 10: Anniversary Date is required
		* Row 11: Channel Y Or N is required
		* Row 12: Fiscal Month is required
		* Row 13: Fiscal Quarter is required
		* Row 14: Fiscal Year is required
		* Row 15: Fiscal Half is required
		* Row 16: Quarter Year is required
		* Row 17: Half Year is required
		* Row 18: Employee ID is required
		* Row 19: RTM is required
		* Row 20: Segment is required
		* Row 21: Sub Segment is required
		* Row 22: Valid Or Invalid is required
		* Row 23: Quote Start Date must be blank
		* Row 24: Quote End Date is must be blank
		* Row 25: Quote Prepaid is required
		* Row 26: Quote Currency is required
		* Row 27: Quote Status is required
		* Row 28: Close Date is required
		* Row 29: Po In is required
		* Row 30: FCST Risk is required
		* Row 31: Manual REV is required
		* Row 32: Lost Risk is required
		*/
		@Test
		public void VAN2228_CheckRequiredFieldsForAnniversaryContracts(){
			info("Check required fields for Anniversary Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(77);
			ArrayList<String> arrayErrors= getSourceErrorList(59,87);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
		/**
		* Test case ID:VAN-2209
		* Test case name:Check required fields for Renewal Contracts
		* Precondition:
		* Test details:
		* Test Step 1:Open the link
		* Test Step 2:Login with an account
		* Test Data:HPID: 2222Pass: Test@123456
		* Expected Result:Home page is shown
		* Test Step 3:Go to ATR import page
		* Expected Result:The page is shown
		* Test Step 4:Import bellow file
		* Expected Result:Cannot import the file.
		* Test Step 5:Check error messages
		* Expected Result:
		* Row 2 : Exp Doc Nb is required
			Row 3 : Date Effective is required
			Row 4 : Date Expire is required
			Row 5 : Renewal Dt is required
			Row 6 :[Upfront Or Renewa] is invalid data.
			Row 7 :[Anniversary Or Renewal] is invalid data.
			Row 8 :[Channel Y Or N] is invalid data.
			Row 9 :[Fiscal Month]] is invalid data.
			Row 11 : Fiscal Year is required
			Row 13 : Quarter Year is required
			Row 14 : Half Year is required
			Row 15 : Employee ID is required
			Row 16 : RTM is requird
			Row 16 :[Segment] is invalid data.
			Row 17 : Segment is required
			Row 18 : Sub Segment is required
			Row 19 : Valid Or Invalid is required
			Row 20 : [Quote Start Date] is required.
			Row 21 : [Quote End Date] is required.
			Row 22 : Quote Prepaid is required
			Row 23 : Quote Currency is required
			Row 24 : Quote Status is required
			Row 25 : Close Date is required
			Row 26 : Po In required
			Row 27 : FCST Risk is required
			Row 28 : Manual REV is required
			Row 29 : Lost Risk is required
			Row 30 :Business Unit is required
			Row 31 : PL is required
			Row 32 : PL is required
			Row 32 :Business Unit is required
			Row 33 : [Quote Start Date] is required.
			Row 33 : [Quote End Date] is required.
		 * @throws Exception 
		*/
		@Test
		public void VAN2209_CheckRequiredFieldsForRenewalContracts() throws Exception{
			info("Check required fields for Renewal Contracts");
			info("Prepare data test");
			String fileName= fData.getAttachFileByArrayTypeRandom(76);
			ArrayList<String> arrayErrors= getSourceErrorList(25,58);
			info("Go to Data import");
			navMenu.goToDataImport();
			dataImportHome.goToATR();
			info("Upload a ATR file");
			contract.upload(PATH_TESTDATA, fileName,false);
			contract.compareErrors(arrayErrors);
		}
}