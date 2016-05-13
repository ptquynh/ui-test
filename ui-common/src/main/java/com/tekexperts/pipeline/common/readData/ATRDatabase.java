package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;
import static com.tekexperts.pipeline.common.TestLogger.info;
public class ATRDatabase {
	public ArrayList<String> trad;
	public ArrayList<String> wwRegion;
	public ArrayList<String> region;
	public ArrayList<String> subRegion;
	public ArrayList<String> country;
	public ArrayList<String> expDocNb;
	public ArrayList<String> soldToAMID4ID;
	public ArrayList<String> soldToAMID4Name;
	public ArrayList<String> soldToAMID3ID;
	public ArrayList<String> soldToAMID3Name;
	public ArrayList<String> soldToAMID2ID;
	public ArrayList<String> soldToaMID2Name;
	public ArrayList<String> shipToID;
	public ArrayList<String> shipToName;
	public ArrayList<String> swstPartyEng;
	public ArrayList<String> swstPartyStreet;
	public ArrayList<String> swstPartyAddr2;
	public ArrayList<String> swstPartyAddr3;
	public ArrayList<String> swstPartyAddr4;
	public ArrayList<String> swstPartyCountry;
	public ArrayList<String> swstPartyRegion;
	public ArrayList<String> swstPartyPostalCode;
	public ArrayList<String> dateEffective;
	public ArrayList<String> dateExpire;
	public ArrayList<String> duration;
	public ArrayList<String> hdrLifecyleStatus;
	public ArrayList<String> poEndDt;
	public ArrayList<String> renewalDt;
	public ArrayList<String> said;
	public ArrayList<String> groupContractNb;
	public ArrayList<String> supportGroupID;
	public ArrayList<String> ampLink;
	public ArrayList<String> ampID;
	public ArrayList<String> documentType;
	public ArrayList<String> funcLoc;
	public ArrayList<String> pl;
	public ArrayList<String> cancRsn;
	public ArrayList<String> cancRsnDecs;
	public ArrayList<String> upfrontOrderNb;
	public ArrayList<String> extendedCustPoNbr;
	public ArrayList<String> userStatus;
	public ArrayList<String> salesMetricCodeHd;
	public ArrayList<String> cstm;
	public ArrayList<String> ela;
	public ArrayList<String> globalCurrency;
	public ArrayList<String> docCurrency;
	public ArrayList<String> spSiteID;
	public ArrayList<String> soldToPartyName;
	public ArrayList<String> spStreet;
	public ArrayList<String> spCity;
	public ArrayList<String> spState;
	public ArrayList<String> spPostalCode;
	public ArrayList<String> spTelephone;
	public ArrayList<String> custBillToContract;
	public ArrayList<String> custOrderContract;
	public ArrayList<String> custInvoiceContract;
	public ArrayList<String> nextDocumentNbr;
	public ArrayList<String> previousDocumentNbr;
	public ArrayList<String> excl;
	public ArrayList<String> texcl;
	public ArrayList<String> distributor;
	public ArrayList<String> reseller;
	public ArrayList<String> businessUnit;
	public ArrayList<String> billingCycle;
	public ArrayList<String> upfrontOrRenewal;
	public ArrayList<String> anniversaryOrRenewal;
	public ArrayList<String> anniversaryDate;
	public ArrayList<String> channelYOrN;
	public ArrayList<String> channelType;
	public ArrayList<String> fiscalMonth;
	public ArrayList<String> fiscalQuarter;
	public ArrayList<String> fiscalYear;
	public ArrayList<String> fiscalHalf;
	public ArrayList<String> quarterYear;
	public ArrayList<String> halfYear;
	public ArrayList<String> cleanSoldToAmid2ID;
	public ArrayList<String> cleanSoldToAmid2Name;
	public ArrayList<String> salesRep;
	public ArrayList<String> employeeID;
	public ArrayList<String> rtm;
	public ArrayList<String> segment;
	public ArrayList<String> subSegment;
	public ArrayList<String> cleanShipToAmid2ID;
	public ArrayList<String> cleanShipToAmid2Name;
	public ArrayList<String> supportLevel;
	public ArrayList<String> swOrTsMixed;
	public ArrayList<String> hardwareShipToInfoEnglish;
	public ArrayList<String> hardwareShipToInfoNonEnglish;
	public ArrayList<String> soldToNameNonEnglish;
	public ArrayList<String> atrFx;
	public ArrayList<String> atrValueLCLFX;
	public ArrayList<String> atrValueUSD;
	public ArrayList<String> eolValueToRemoveLCL;
	public ArrayList<String> eolValueToRemoveUSD;
	public ArrayList<String> finalATRValueLCLFX;
	public ArrayList<String> finalATRValueUSD;
	public ArrayList<String> validORInvalid;
	public ArrayList<String> validReason;
	public ArrayList<String> opptID;
	public ArrayList<String> atrType;
	public ArrayList<String> newFuncLoc;
	public ArrayList<String> quoteNumber;
	public ArrayList<String> quoteSupportLevel;
	public ArrayList<String> quoteStartDate;
	public ArrayList<String> quoteEndDate;
	public ArrayList<String> quotePrepaid;
	public ArrayList<String> rtsPlusPenaltyFeeLCLFX;
	public ArrayList<String> foundationTotalLCLFX;
	public ArrayList<String> totalQuoteLCLFX;
	public ArrayList<String> totalFCSTLCLFX;
	public ArrayList<String> quoteCurrency;
	public ArrayList<String> quoteStatus;
	public ArrayList<String> renewalStatus;
	public ArrayList<String> closeDate;
	public ArrayList<String> fcstStatus;
	public ArrayList<String> poIn;
	public ArrayList<String> fcstRisk;
	public ArrayList<String> manualRev;
	public ArrayList<String> lostReason;
	public ArrayList<String> lostRisk;
	public ArrayList<String> invalidReason;
	public ArrayList<String> comments;
	public ArrayList<String> underforecastOrUpsell;
	public ArrayList<String> underforecastOrUpsellReason;
	public ArrayList<String> rtsPlusPenaltyFeeUSD;
	public ArrayList<String> foundationUSD;
	public ArrayList<String> totalContractValueUSD;
	public ArrayList<String> totalFCSTValueUSD;
	public ArrayList<String> annualisedFoundationLCLFX;
	public ArrayList<String> annualisedFoundationUSD;
	public ArrayList<String> currentFX;
	public ArrayList<String> overdueCheck;
	public ArrayList<String> closeDateCalculated;
	public ArrayList<String> renewalStatusCalculated;
	public ArrayList<String> validForCQ;
	public ArrayList<String> totalCQRevsUSD;
	public ArrayList<String> month1CQRevsUSD;
	public ArrayList<String> month2CQRevsUSD;
	public ArrayList<String> month3CQRevsUSD;
	public ArrayList<String> selectableRevenueCalcUSD;
	public ArrayList<String> salesOrderIdentifier;
	public ArrayList<String> legacySalesOrderIdentifier;
	public ArrayList<String> documentCurrencyCode;
	public ArrayList<String> salesOrderIdentifierSL;
	public ArrayList<String> customerPurchaseOrderIdentifier;
	public ArrayList<String> fcstDoc;
	public ArrayList<String> modifiedBy;
	public ArrayList<String> modifiedDate;
	public ArrayList<String> camName;
	public ArrayList<String> camEmployeeID;
	public ArrayList<String> camType;
	public ArrayList<String> camRisk;
	public ArrayList<String> camComments;
	public ArrayList<String> flexcareCODE;
	public ArrayList<String> flexcareYN;
	public ArrayList<String> onTimeRR;
	public ArrayList<String> campaignName;

	/**
	 * Setup ATR database
	 * @param trad
	 * @param wwRegion
	 * @param region
	 * @param subRegion
	 * @param country
	 * @param expDocNb
	 * @param soldToAMID4ID
	 * @param soldToAMID4Name
	 * @param soldToAMID3ID
	 * @param soldToAMID3Name
	 * @param soldToAMID2ID
	 * @param soldToaMID2Name
	 * @param shipToID
	 * @param shipToName
	 * @param swstPartyEng
	 * @param swstPartyStreet
	 * @param swstPartyAddr2
	 * @param swstPartyAddr3
	 * @param swstPartyAddr4
	 * @param swstPartyCountry
	 * @param swstPartyRegion
	 * @param swstPartyPostalCode
	 * @param dateEffective
	 * @param dateExpire
	 * @param duration
	 * @param hdrLifecyleStatus
	 * @param poEndDt
	 * @param renewalDt
	 * @param said
	 * @param groupContractNb
	 * @param supportGroupID
	 * @param ampLink
	 * @param ampID
	 * @param documentType
	 * @param funcLoc
	 * @param pl
	 * @param cancRsn
	 * @param cancRsnDecs
	 * @param upfrontOrderNb
	 * @param extendedCustPoNbr
	 * @param userStatus
	 * @param salesMetricCodeHd
	 * @param cstm
	 * @param ela
	 * @param globalCurrency
	 * @param docCurrency
	 * @param spSiteID
	 * @param soldToPartyName
	 * @param spStreet
	 * @param spCity
	 * @param spState
	 * @param spPostalCode
	 * @param spTelephone
	 * @param custBillToContract
	 * @param custOrderContract
	 * @param custInvoiceContract
	 * @param nextDocumentNbr
	 * @param previousDocumentNbr
	 * @param excl
	 * @param texcl
	 * @param distributor
	 * @param reseller
	 * @param businessUnit
	 * @param billingCycle
	 * @param upfrontOrRenewal
	 * @param anniversaryOrRenewal
	 * @param anniversaryDate
	 * @param channelYOrN
	 * @param channelType
	 * @param fiscalMonth
	 * @param fiscalQuarter
	 * @param fiscalYear
	 * @param fiscalHalf
	 * @param quarterYear
	 * @param halfYear
	 * @param cleanSoldToAmid2ID
	 * @param cleanSoldToAmid2Name
	 * @param salesRep
	 * @param employeeID
	 * @param rtm
	 * @param segment
	 * @param subSegment
	 * @param cleanShipToAmid2ID
	 * @param cleanShipToAmid2Name
	 * @param supportLevel
	 * @param swOrTsMixed
	 * @param hardwareShipToInfoEnglish
	 * @param hardwareShipToInfoNonEnglish
	 * @param soldToNameNonEnglish
	 * @param atrFx
	 * @param atrValueLCLFX
	 * @param atrValueUSD
	 * @param eolValueToRemoveLCL
	 * @param eolValueToRemoveUSD
	 * @param finalATRValueLCLFX
	 * @param finalATRValueUSD
	 * @param validORInvalid
	 * @param validReason
	 * @param opptID
	 * @param atrType
	 * @param newFuncLoc
	 * @param quoteNumber
	 * @param quoteSupportLevel
	 * @param quoteStartDate
	 * @param quoteEndDate
	 * @param quotePrepaid
	 * @param rtsPlusPenaltyFeeLCLFX
	 * @param foundationTotalLCLFX
	 * @param totalQuoteLCLFX
	 * @param totalFCSTLCLFX
	 * @param quoteCurrency
	 * @param quoteStatus
	 * @param renewalStatus
	 * @param closeDate
	 * @param fcstStatus
	 * @param poIn
	 * @param fcstRisk
	 * @param manualRev
	 * @param lostReason
	 * @param lostRisk
	 * @param invalidReason
	 * @param comments
	 * @param underforecastOrUpsell
	 * @param underforecastOrUpsellReason
	 * @param rtsPlusPenaltyFeeUSD
	 * @param foundationUSD
	 * @param totalContractValueUSD
	 * @param totalFCSTValueUSD
	 * @param annualisedFoundationLCLFX
	 * @param annualisedFoundationUSD
	 * @param currentFX
	 * @param overdueCheck
	 * @param closeDateCalculated
	 * @param renewalStatusCalculated
	 * @param validForCQ
	 * @param totalCQRevsUSD
	 * @param month1CQRevsUSD
	 * @param month2CQRevsUSD
	 * @param month3CQRevsUSD
	 * @param selectableRevenueCalcUSD
	 * @param salesOrderIdentifier
	 * @param legacySalesOrderIdentifier
	 * @param documentCurrencyCode
	 * @param salesOrderIdentifierSL
	 * @param customerPurchaseOrderIdentifier
	 * @param fcstDoc
	 * @param modifiedBy
	 * @param modifiedDate
	 * @param camName
	 * @param camEmployeeID
	 * @param camType
	 * @param camRisk
	 * @param camComments
	 * @param flexcareCODE
	 * @param flexcareYN
	 * @param onTimeRR
	 * @param campaignName
	 */
	public ATRDatabase(ArrayList<String> trad, ArrayList<String> wwRegion,
			ArrayList<String> region, ArrayList<String> subRegion,
			ArrayList<String> country, ArrayList<String> expDocNb,
			ArrayList<String> soldToAMID4ID, ArrayList<String> soldToAMID4Name,
			ArrayList<String> soldToAMID3ID, ArrayList<String> soldToAMID3Name,
			ArrayList<String> soldToAMID2ID, ArrayList<String> soldToaMID2Name,
			ArrayList<String> shipToID, ArrayList<String> shipToName,
			ArrayList<String> swstPartyEng, ArrayList<String> swstPartyStreet,
			ArrayList<String> swstPartyAddr2, ArrayList<String> swstPartyAddr3,
			ArrayList<String> swstPartyAddr4,
			ArrayList<String> swstPartyCountry,
			ArrayList<String> swstPartyRegion,
			ArrayList<String> swstPartyPostalCode,
			ArrayList<String> dateEffective, ArrayList<String> dateExpire,
			ArrayList<String> duration, ArrayList<String> hdrLifecyleStatus,
			ArrayList<String> poEndDt, ArrayList<String> renewalDt,
			ArrayList<String> said, ArrayList<String> groupContractNb,
			ArrayList<String> supportGroupID, ArrayList<String> ampLink,
			ArrayList<String> ampID, ArrayList<String> documentType,
			ArrayList<String> funcLoc, ArrayList<String> pl,
			ArrayList<String> cancRsn, ArrayList<String> cancRsnDecs,
			ArrayList<String> upfrontOrderNb,
			ArrayList<String> extendedCustPoNbr, ArrayList<String> userStatus,
			ArrayList<String> salesMetricCodeHd, ArrayList<String> cstm,
			ArrayList<String> ela, ArrayList<String> globalCurrency,
			ArrayList<String> docCurrency, ArrayList<String> spSiteID,
			ArrayList<String> soldToPartyName, ArrayList<String> spStreet,
			ArrayList<String> spCity, ArrayList<String> spState,
			ArrayList<String> spPostalCode, ArrayList<String> spTelephone,
			ArrayList<String> custBillToContract,
			ArrayList<String> custOrderContract,
			ArrayList<String> custInvoiceContract,
			ArrayList<String> nextDocumentNbr,
			ArrayList<String> previousDocumentNbr, ArrayList<String> excl,
			ArrayList<String> texcl, ArrayList<String> distributor,
			ArrayList<String> reseller, ArrayList<String> businessUnit,
			ArrayList<String> billingCycle, ArrayList<String> upfrontOrRenewal,
			ArrayList<String> anniversaryOrRenewal,
			ArrayList<String> anniversaryDate, ArrayList<String> channelYOrN,
			ArrayList<String> channelType, ArrayList<String> fiscalMonth,
			ArrayList<String> fiscalQuarter, ArrayList<String> fiscalYear,
			ArrayList<String> fiscalHalf, ArrayList<String> quarterYear,
			ArrayList<String> halfYear, ArrayList<String> cleanSoldToAmid2ID,
			ArrayList<String> cleanSoldToAmid2Name, ArrayList<String> salesRep,
			ArrayList<String> employeeID, ArrayList<String> rtm,
			ArrayList<String> segment, ArrayList<String> subSegment,
			ArrayList<String> cleanShipToAmid2ID,
			ArrayList<String> cleanShipToAmid2Name,
			ArrayList<String> supportLevel, ArrayList<String> swOrTsMixed,
			ArrayList<String> hardwareShipToInfoEnglish,
			ArrayList<String> hardwareShipToInfoNonEnglish,
			ArrayList<String> soldToNameNonEnglish, ArrayList<String> atrFx,
			ArrayList<String> atrValueLCLFX, ArrayList<String> atrValueUSD,
			ArrayList<String> eolValueToRemoveLCL,
			ArrayList<String> eolValueToRemoveUSD,
			ArrayList<String> finalATRValueLCLFX,
			ArrayList<String> finalATRValueUSD,
			ArrayList<String> validORInvalid, ArrayList<String> validReason,
			ArrayList<String> opptID, ArrayList<String> atrType,
			ArrayList<String> newFuncLoc, ArrayList<String> quoteNumber,
			ArrayList<String> quoteSupportLevel,
			ArrayList<String> quoteStartDate, ArrayList<String> quoteEndDate,
			ArrayList<String> quotePrepaid,
			ArrayList<String> rtsPlusPenaltyFeeLCLFX,
			ArrayList<String> foundationTotalLCLFX,
			ArrayList<String> totalQuoteLCLFX,
			ArrayList<String> totalFCSTLCLFX, ArrayList<String> quoteCurrency,
			ArrayList<String> quoteStatus, ArrayList<String> renewalStatus,
			ArrayList<String> closeDate, ArrayList<String> fcstStatus,
			ArrayList<String> poIn, ArrayList<String> fcstRisk,
			ArrayList<String> manualRev, ArrayList<String> lostReason,
			ArrayList<String> lostRisk, ArrayList<String> invalidReason,
			ArrayList<String> comments,
			ArrayList<String> underforecastOrUpsell,
			ArrayList<String> underforecastOrUpsellReason,
			ArrayList<String> rtsPlusPenaltyFeeUSD,
			ArrayList<String> foundationUSD,
			ArrayList<String> totalContractValueUSD,
			ArrayList<String> totalFCSTValueUSD,
			ArrayList<String> annualisedFoundationLCLFX,
			ArrayList<String> annualisedFoundationUSD,
			ArrayList<String> currentFX, ArrayList<String> overdueCheck,
			ArrayList<String> closeDateCalculated,
			ArrayList<String> renewalStatusCalculated,
			ArrayList<String> validForCQ, ArrayList<String> totalCQRevsUSD,
			ArrayList<String> month1CQRevsUSD,
			ArrayList<String> month2CQRevsUSD,
			ArrayList<String> month3CQRevsUSD,
			ArrayList<String> selectableRevenueCalcUSD,
			ArrayList<String> salesOrderIdentifier,
			ArrayList<String> legacySalesOrderIdentifier,
			ArrayList<String> documentCurrencyCode,
			ArrayList<String> salesOrderIdentifierSL,
			ArrayList<String> customerPurchaseOrderIdentifier,
			ArrayList<String> fcstDoc, ArrayList<String> modifiedBy,
			ArrayList<String> modifiedDate, ArrayList<String> camName,
			ArrayList<String> camEmployeeID, ArrayList<String> camType,
			ArrayList<String> camRisk, ArrayList<String> camComments,
			ArrayList<String> flexcareCODE, ArrayList<String> flexcareYN,
			ArrayList<String> onTimeRR, ArrayList<String> campaignName) {
		
		 this.trad=trad;
		 this.wwRegion=wwRegion;
		 this.region=region;
		 this.subRegion=subRegion;
		 this.country=country;
		 this.expDocNb=expDocNb;
		 this.soldToAMID4ID=soldToAMID4ID;
		 this.soldToAMID4Name=soldToAMID4Name;
		 this.soldToAMID3ID=soldToAMID3ID;
		 this.soldToAMID3Name=soldToAMID3Name;
		 this.soldToAMID2ID=soldToAMID2ID;
		 this.soldToaMID2Name=soldToaMID2Name;
		 this.shipToID=shipToID;
		 this.shipToName=shipToName;
		 this.swstPartyEng=swstPartyEng;
		 this.swstPartyStreet=swstPartyStreet;
		 this.swstPartyAddr2=swstPartyAddr2;
		 this.swstPartyAddr3=swstPartyAddr3;
		 this.swstPartyAddr4=swstPartyAddr4;
		 this.swstPartyCountry=swstPartyCountry;
		 this.swstPartyRegion=swstPartyRegion;
		 this.swstPartyPostalCode=swstPartyPostalCode;
		 this.dateEffective=dateEffective;
		 this.dateExpire=dateExpire;
		 this.duration=duration;
		 this.hdrLifecyleStatus=hdrLifecyleStatus;
		 this.poEndDt=poEndDt;
		 this.renewalDt=renewalDt;
		 this.said=said;
		 this.groupContractNb=groupContractNb;
		 this.supportGroupID=supportGroupID;
		 this.ampLink=ampLink;
		 this.ampID=ampID;
		 this.documentType=documentType;
		 this.funcLoc=funcLoc;
		 this.pl=pl;
		 this.cancRsn=cancRsn;
		 this.cancRsnDecs=cancRsnDecs;
		 this.upfrontOrderNb=upfrontOrderNb;
		 this.extendedCustPoNbr=extendedCustPoNbr;
		 this.userStatus=userStatus;
		 this.salesMetricCodeHd=salesMetricCodeHd;
		 this.cstm=cstm;
		 this.ela=ela;
		 this.globalCurrency=globalCurrency;
		 this.docCurrency=docCurrency;
		 this.spSiteID=spSiteID;
		 this.soldToPartyName=soldToPartyName;
		 this.spStreet=spStreet;
		 this.spCity=spCity;
		 this.spState=spState;
		 this.spPostalCode=spPostalCode;
		 this.spTelephone=spTelephone;
		 this.custBillToContract=custBillToContract;
		 this.custOrderContract=custOrderContract;
		 this.custInvoiceContract=custInvoiceContract;
		 this.nextDocumentNbr=nextDocumentNbr;
		 this.previousDocumentNbr=previousDocumentNbr;
		 this.excl=excl;
		 this.texcl=texcl;
		 this.distributor=distributor;
		 this.reseller=reseller;
		 this.businessUnit=businessUnit;
		 this.billingCycle=billingCycle;
		 this.upfrontOrRenewal=upfrontOrRenewal;
		 this.anniversaryOrRenewal=anniversaryOrRenewal;
		 this.anniversaryDate=anniversaryDate;
		 this.channelYOrN=channelYOrN;
		 this.channelType=channelType;
		 this.fiscalMonth=fiscalMonth;
		 this.fiscalQuarter=fiscalQuarter;
		 this.fiscalYear=fiscalYear;
		 this.fiscalHalf=fiscalHalf;
		 this.quarterYear=quarterYear;
		 this.halfYear=halfYear;
		 this.cleanSoldToAmid2ID=cleanSoldToAmid2ID;
		 this.cleanSoldToAmid2Name=cleanSoldToAmid2Name;
		 this.salesRep=salesRep;
		 this.employeeID=employeeID;
		 this.rtm=rtm;
		 this.segment=segment;
		 this.subSegment=subSegment;
		 this.cleanShipToAmid2ID=cleanShipToAmid2ID;
		 this.cleanShipToAmid2Name=cleanShipToAmid2Name;
		 this.supportLevel=supportLevel;
		 this.swOrTsMixed=swOrTsMixed;
		 this.hardwareShipToInfoEnglish=hardwareShipToInfoEnglish;
		 this.hardwareShipToInfoNonEnglish=hardwareShipToInfoNonEnglish;
		 this.soldToNameNonEnglish=soldToNameNonEnglish;
		 this.atrFx=atrFx;
		 this.atrValueLCLFX=atrValueLCLFX;
		 this.atrValueUSD=atrValueUSD;
		 this.eolValueToRemoveLCL=eolValueToRemoveLCL;
		 this.eolValueToRemoveUSD=eolValueToRemoveUSD;
		 this.finalATRValueLCLFX=finalATRValueLCLFX;
		 this.finalATRValueUSD=finalATRValueUSD;
		 this.validORInvalid=validORInvalid;
		 this.validReason=validReason;
		 this.opptID=opptID;
		 this.atrType=atrType;
		 this.newFuncLoc=newFuncLoc;
		 this.quoteNumber=quoteNumber;
		 this.quoteSupportLevel=quoteSupportLevel;
		 this.quoteStartDate=quoteStartDate;
		 this.quoteEndDate=quoteEndDate;
		 this.quotePrepaid=quotePrepaid;
		 this.rtsPlusPenaltyFeeLCLFX=rtsPlusPenaltyFeeLCLFX;
		 this.foundationTotalLCLFX=foundationTotalLCLFX;
		 this.totalQuoteLCLFX=totalQuoteLCLFX;
		 this.totalFCSTLCLFX=totalFCSTLCLFX;
		 this.quoteCurrency=quoteCurrency;
		 this.quoteStatus=quoteStatus;
		 this.renewalStatus=renewalStatus;
		 this.closeDate=closeDate;
		 this.fcstStatus=fcstStatus;
		 this.poIn=poIn;
		 this.fcstRisk=fcstRisk;
		 this.manualRev=manualRev;
		 this.lostReason=lostReason;
		 this.lostRisk=lostRisk;
		 this.invalidReason=invalidReason;
		 this.comments=comments;
		 this.underforecastOrUpsell=underforecastOrUpsell;
		 this.underforecastOrUpsellReason=underforecastOrUpsellReason;
		 this.rtsPlusPenaltyFeeUSD=rtsPlusPenaltyFeeLCLFX;
		 this.foundationUSD=foundationUSD;
		 this.totalContractValueUSD=totalContractValueUSD;
		 this.totalFCSTValueUSD=totalFCSTValueUSD;
		 this.annualisedFoundationLCLFX=annualisedFoundationLCLFX;
		 this.annualisedFoundationUSD=annualisedFoundationUSD;
		 this.currentFX=currentFX;
		 this.overdueCheck=overdueCheck;
		 this.closeDateCalculated=closeDateCalculated;
		 this.renewalStatusCalculated=renewalStatusCalculated;
		 this.validForCQ=validForCQ;
		 this.totalCQRevsUSD=totalCQRevsUSD;
		 this.month1CQRevsUSD=month1CQRevsUSD;
		 this.month2CQRevsUSD=month2CQRevsUSD;
		 this.month3CQRevsUSD=month3CQRevsUSD;
		 this.selectableRevenueCalcUSD=selectableRevenueCalcUSD;
		 this.salesOrderIdentifier=salesOrderIdentifier;
		 this.legacySalesOrderIdentifier=legacySalesOrderIdentifier;
		 this.documentCurrencyCode=documentCurrencyCode;
		 this.salesOrderIdentifierSL=salesOrderIdentifierSL;
		 this.customerPurchaseOrderIdentifier=customerPurchaseOrderIdentifier;
		 this.fcstDoc=fcstDoc;
		 this.modifiedBy=modifiedBy;
		 this.modifiedDate=modifiedDate;
		 this.camName=camName;
		 this.camEmployeeID=camEmployeeID;
		 this.camType=camType;
		 this.camRisk=camRisk;
		 this.camComments=camComments;
		 this.flexcareCODE=flexcareCODE;
		 this.flexcareYN=flexcareYN;
		 this.onTimeRR=onTimeRR;
		 this.campaignName=campaignName;
	}

	/**
	 * UserDatabase
	 */
	public ATRDatabase(){
		 trad= new ArrayList<String>();
		 wwRegion= new ArrayList<String>();
		 region= new ArrayList<String>();
		 subRegion= new ArrayList<String>();
		 country= new ArrayList<String>();
		 expDocNb= new ArrayList<String>();
		 soldToAMID4ID= new ArrayList<String>();
		 soldToAMID4Name= new ArrayList<String>();
		 soldToAMID3ID= new ArrayList<String>();
		 soldToAMID3Name= new ArrayList<String>();
		 soldToAMID2ID= new ArrayList<String>();
		 soldToaMID2Name= new ArrayList<String>();
		 shipToID= new ArrayList<String>();
		 shipToName=new ArrayList<String>();
		 swstPartyEng= new ArrayList<String>();
		 swstPartyStreet= new ArrayList<String>();
		 swstPartyAddr2= new ArrayList<String>();
		 swstPartyAddr3=new ArrayList<String>();
		 swstPartyAddr4= new ArrayList<String>();
		 swstPartyCountry= new ArrayList<String>();
		 swstPartyRegion= new ArrayList<String>();
		 swstPartyPostalCode= new ArrayList<String>();
		 dateEffective= new ArrayList<String>();
		 dateExpire= new ArrayList<String>();
		 duration= new ArrayList<String>();
		 hdrLifecyleStatus= new ArrayList<String>();
		 poEndDt= new ArrayList<String>();
		 renewalDt= new ArrayList<String>();
		 said= new ArrayList<String>();
		 groupContractNb= new ArrayList<String>();
		 supportGroupID= new ArrayList<String>();
		 ampLink= new ArrayList<String>();
		 ampID= new ArrayList<String>();
		 documentType= new ArrayList<String>();
		 funcLoc= new ArrayList<String>();
		 pl= new ArrayList<String>();
		 cancRsn= new ArrayList<String>();
		 cancRsnDecs= new ArrayList<String>();
		 upfrontOrderNb= new ArrayList<String>();
		 extendedCustPoNbr= new ArrayList<String>();
		 userStatus= new ArrayList<String>();
		 salesMetricCodeHd= new ArrayList<String>();
		 cstm= new ArrayList<String>();
		 ela= new ArrayList<String>();
		 globalCurrency= new ArrayList<String>();
		 docCurrency= new ArrayList<String>();
		 spSiteID= new ArrayList<String>();
		 soldToPartyName= new ArrayList<String>();
		 spStreet= new ArrayList<String>();
		 spCity= new ArrayList<String>();
		 spState= new ArrayList<String>();
		 spPostalCode= new ArrayList<String>();
		 spTelephone= new ArrayList<String>();
		 custBillToContract= new ArrayList<String>();
		 custOrderContract= new ArrayList<String>();
		 custInvoiceContract= new ArrayList<String>();
		 nextDocumentNbr= new ArrayList<String>();
		 previousDocumentNbr= new ArrayList<String>();
		 excl= new ArrayList<String>();
		 texcl= new ArrayList<String>();
		 distributor= new ArrayList<String>();
		 reseller= new ArrayList<String>();
		 businessUnit= new ArrayList<String>();
		 billingCycle= new ArrayList<String>();
		 upfrontOrRenewal= new ArrayList<String>();
		 anniversaryOrRenewal= new ArrayList<String>();
		 anniversaryDate= new ArrayList<String>();
		 channelYOrN= new ArrayList<String>();
		 channelType= new ArrayList<String>();
		 fiscalMonth= new ArrayList<String>();
		 fiscalQuarter= new ArrayList<String>();
		 fiscalYear= new ArrayList<String>();
		 fiscalHalf= new ArrayList<String>();
		 quarterYear= new ArrayList<String>();
		 halfYear= new ArrayList<String>();
		 cleanSoldToAmid2ID= new ArrayList<String>();
		 cleanSoldToAmid2Name= new ArrayList<String>();
		 salesRep= new ArrayList<String>();
		 employeeID= new ArrayList<String>();
		 rtm= new ArrayList<String>();
		 segment= new ArrayList<String>();
		 subSegment= new ArrayList<String>();
		 cleanShipToAmid2ID= new ArrayList<String>();
		 cleanShipToAmid2Name= new ArrayList<String>();
		 supportLevel= new ArrayList<String>();
		 swOrTsMixed= new ArrayList<String>();
		 hardwareShipToInfoEnglish= new ArrayList<String>();
		 hardwareShipToInfoNonEnglish= new ArrayList<String>();
		 soldToNameNonEnglish= new ArrayList<String>();
		 atrFx= new ArrayList<String>();
		 atrValueLCLFX= new ArrayList<String>();
		 atrValueUSD= new ArrayList<String>();
		 eolValueToRemoveLCL= new ArrayList<String>();
		 eolValueToRemoveUSD= new ArrayList<String>();
		 finalATRValueLCLFX= new ArrayList<String>();
		 finalATRValueUSD= new ArrayList<String>();
		 validORInvalid= new ArrayList<String>();
		 validReason= new ArrayList<String>();
		 opptID= new ArrayList<String>();
		 atrType= new ArrayList<String>();
		 newFuncLoc= new ArrayList<String>();
		 quoteNumber= new ArrayList<String>();
		 quoteSupportLevel= new ArrayList<String>();
		 quoteStartDate= new ArrayList<String>();
		 quoteEndDate= new ArrayList<String>();
		 quotePrepaid= new ArrayList<String>();
		 rtsPlusPenaltyFeeLCLFX= new ArrayList<String>();
		 foundationTotalLCLFX= new ArrayList<String>();
		 totalQuoteLCLFX= new ArrayList<String>();
		 totalFCSTLCLFX= new ArrayList<String>();
		 quoteCurrency= new ArrayList<String>();
		 quoteStatus= new ArrayList<String>();
		 renewalStatus= new ArrayList<String>();
		 closeDate= new ArrayList<String>();
		 fcstStatus= new ArrayList<String>();
		 poIn= new ArrayList<String>();
		 fcstRisk= new ArrayList<String>();
		 manualRev= new ArrayList<String>();
		 lostReason= new ArrayList<String>();
		 lostRisk= new ArrayList<String>();
		 invalidReason= new ArrayList<String>();
		 comments= new ArrayList<String>();
		 underforecastOrUpsell= new ArrayList<String>();
		 underforecastOrUpsellReason= new ArrayList<String>();
		 rtsPlusPenaltyFeeUSD= new ArrayList<String>();
		 foundationUSD= new ArrayList<String>();
		 totalContractValueUSD= new ArrayList<String>();
		 totalFCSTValueUSD= new ArrayList<String>();
		 annualisedFoundationLCLFX= new ArrayList<String>();
		 annualisedFoundationUSD= new ArrayList<String>();
		 currentFX= new ArrayList<String>();
		 overdueCheck= new ArrayList<String>();
		 closeDateCalculated= new ArrayList<String>();
		 renewalStatusCalculated= new ArrayList<String>();
		 validForCQ= new ArrayList<String>();
		 totalCQRevsUSD= new ArrayList<String>();
		 month1CQRevsUSD= new ArrayList<String>();
		 month2CQRevsUSD= new ArrayList<String>();
		 month3CQRevsUSD= new ArrayList<String>();
		 selectableRevenueCalcUSD= new ArrayList<String>();
		 salesOrderIdentifier= new ArrayList<String>();
		 legacySalesOrderIdentifier= new ArrayList<String>();
		 documentCurrencyCode= new ArrayList<String>();
		 salesOrderIdentifierSL= new ArrayList<String>();
		 customerPurchaseOrderIdentifier= new ArrayList<String>();
		 fcstDoc= new ArrayList<String>();
		 modifiedBy= new ArrayList<String>();
		 modifiedDate= new ArrayList<String>();
		 camName= new ArrayList<String>();
		 camEmployeeID= new ArrayList<String>();
		 camType= new ArrayList<String>();
		 camRisk= new ArrayList<String>();
		 camComments= new ArrayList<String>();
		 flexcareCODE= new ArrayList<String>();
		 flexcareYN= new ArrayList<String>();
		 onTimeRR= new ArrayList<String>();
		 campaignName= new ArrayList<String>();
	}

	
	/**
	 * Set data
	 * @param dataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setData(String dataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(dataFile,userSheet,opParams);
		info("dataFile path:"+dataFile);
		for(int i = 0; i<testData.length; i++)
		{	
			info("i:"+i);
			trad.add(testData[i][0]);
			wwRegion.add(testData[i][1]);
			region.add(testData[i][2]);
			subRegion.add(testData[i][3]);
			country.add(testData[i][4]);
			expDocNb.add(testData[i][5]);
			soldToAMID4ID.add(testData[i][6]);
			soldToAMID4Name.add(testData[i][7]);
			soldToAMID3ID.add(testData[i][8]);
			soldToAMID3Name.add(testData[i][9]);
			soldToAMID2ID.add(testData[i][10]);
			soldToaMID2Name.add(testData[i][11]);
			shipToID.add(testData[i][12]);
			shipToName.add(testData[i][13]);
			swstPartyEng.add(testData[i][14]);
			swstPartyStreet.add(testData[i][15]);
			swstPartyAddr2.add(testData[i][16]);
			swstPartyAddr3.add(testData[i][17]);
			swstPartyAddr4.add(testData[i][18]);
			swstPartyCountry.add(testData[i][19]);
			swstPartyRegion.add(testData[i][20]);
			swstPartyPostalCode.add(testData[i][21]);
			dateEffective.add(testData[i][22]);
			dateExpire.add(testData[i][23]);
			duration.add(testData[i][24]);
			hdrLifecyleStatus.add(testData[i][25]);
			poEndDt.add(testData[i][26]);
			renewalDt.add(testData[i][27]);
			said.add(testData[i][28]);
			groupContractNb.add(testData[i][29]);
			supportGroupID.add(testData[i][30]);
			ampLink.add(testData[i][31]);
			ampID.add(testData[i][32]);
			documentType.add(testData[i][33]);
			funcLoc.add(testData[i][34]);
			pl.add(testData[i][35]);
			cancRsn.add(testData[i][36]);
			cancRsnDecs.add(testData[i][37]);
			upfrontOrderNb.add(testData[i][38]);
			extendedCustPoNbr.add(testData[i][39]);
			userStatus.add(testData[i][40]);
			salesMetricCodeHd.add(testData[i][41]);
			cstm.add(testData[i][42]);
			ela.add(testData[i][43]);
			globalCurrency.add(testData[i][44]);
			docCurrency.add(testData[i][45]);
			spSiteID.add(testData[i][46]);
			soldToPartyName.add(testData[i][47]);
			spStreet.add(testData[i][48]);
			spCity.add(testData[i][49]);
			spState.add(testData[i][50]);
			spPostalCode.add(testData[i][51]);
			spTelephone.add(testData[i][52]);
			custBillToContract.add(testData[i][53]);
			custOrderContract.add(testData[i][54]);
			custInvoiceContract.add(testData[i][55]);
			nextDocumentNbr.add(testData[i][56]);
			previousDocumentNbr.add(testData[i][57]);
			excl.add(testData[i][58]);
			texcl.add(testData[i][59]);
			distributor.add(testData[i][60]);
			reseller.add(testData[i][61]);
			businessUnit.add(testData[i][62]);
			billingCycle.add(testData[i][63]);
			upfrontOrRenewal.add(testData[i][64]);
			anniversaryOrRenewal.add(testData[i][65]);
			anniversaryDate.add(testData[i][66]);
			channelYOrN.add(testData[i][67]);
			channelType.add(testData[i][68]);
			fiscalMonth.add(testData[i][69]);
			fiscalQuarter.add(testData[i][70]);
			fiscalYear.add(testData[i][71]);
			fiscalHalf.add(testData[i][72]);
			quarterYear.add(testData[i][73]);
			halfYear.add(testData[i][74]);
			cleanSoldToAmid2ID.add(testData[i][75]);
			cleanSoldToAmid2Name.add(testData[i][76]);
			salesRep.add(testData[i][77]);
			employeeID.add(testData[i][78]);
			rtm.add(testData[i][79]);
			segment.add(testData[i][80]);
			subSegment.add(testData[i][81]);
			cleanShipToAmid2ID.add(testData[i][82]);
			cleanShipToAmid2Name.add(testData[i][83]);
			supportLevel.add(testData[i][84]);
			swOrTsMixed.add(testData[i][85]);
			hardwareShipToInfoEnglish.add(testData[i][86]);
			hardwareShipToInfoNonEnglish.add(testData[i][87]);
			soldToNameNonEnglish.add(testData[i][88]);
			atrFx.add(testData[i][89]);
			atrValueLCLFX.add(testData[i][90]);
			atrValueUSD.add(testData[i][91]);
			eolValueToRemoveLCL.add(testData[i][92]);
			eolValueToRemoveUSD.add(testData[i][93]);
			finalATRValueLCLFX.add(testData[i][94]);
			finalATRValueUSD.add(testData[i][95]);
			validORInvalid.add(testData[i][96]);
			validReason.add(testData[i][97]);
			opptID.add(testData[i][98]);
			atrType.add(testData[i][99]);
			newFuncLoc.add(testData[i][100]);
			quoteNumber.add(testData[i][101]);
			quoteSupportLevel.add(testData[i][102]);
			quoteStartDate.add(testData[i][103]);
			quoteEndDate.add(testData[i][104]);
			quotePrepaid.add(testData[i][105]);
			rtsPlusPenaltyFeeLCLFX.add(testData[i][106]);
			foundationTotalLCLFX.add(testData[i][107]);
			totalQuoteLCLFX.add(testData[i][108]);
			totalFCSTLCLFX.add(testData[i][109]);
			quoteCurrency.add(testData[i][110]);
			quoteStatus.add(testData[i][111]);
			renewalStatus.add(testData[i][112]);
			closeDate.add(testData[i][113]);
			fcstStatus.add(testData[i][114]);
			poIn.add(testData[i][115]);
			fcstRisk.add(testData[i][116]);
			manualRev.add(testData[i][117]);
			lostReason.add(testData[i][118]);
			lostRisk.add(testData[i][119]);
			invalidReason.add(testData[i][120]);
			comments.add(testData[i][121]);
			underforecastOrUpsell.add(testData[i][122]);
			underforecastOrUpsellReason.add(testData[i][123]);
			rtsPlusPenaltyFeeUSD.add(testData[i][124]);
			foundationUSD.add(testData[i][125]);
			totalContractValueUSD.add(testData[i][126]);
			totalFCSTValueUSD.add(testData[i][127]);
			annualisedFoundationLCLFX.add(testData[i][128]);
			annualisedFoundationUSD.add(testData[i][129]);
			currentFX.add(testData[i][130]);
			overdueCheck.add(testData[i][131]);
			closeDateCalculated.add(testData[i][132]);
			renewalStatusCalculated.add(testData[i][133]);
			validForCQ.add(testData[i][134]);
			totalCQRevsUSD.add(testData[i][135]);
			month1CQRevsUSD.add(testData[i][136]);
			month2CQRevsUSD.add(testData[i][137]);
			month3CQRevsUSD.add(testData[i][138]);
			selectableRevenueCalcUSD.add(testData[i][139]);
			salesOrderIdentifier.add(testData[i][140]);
			legacySalesOrderIdentifier.add(testData[i][141]);
			documentCurrencyCode.add(testData[i][142]);
			salesOrderIdentifierSL.add(testData[i][143]);
			customerPurchaseOrderIdentifier.add(testData[i][144]);
			fcstDoc.add(testData[i][145]);
			modifiedBy.add(testData[i][146]);
			modifiedDate.add(testData[i][147]);
			camName.add(testData[i][148]);
			camEmployeeID.add(testData[i][149]);
			camType.add(testData[i][150]);
			camRisk.add(testData[i][151]);
			camComments.add(testData[i][152]);
			flexcareCODE.add(testData[i][153]);
			flexcareYN.add(testData[i][154]);
			onTimeRR.add(testData[i][155]);
			campaignName.add(testData[i][156]);
		}
	}
}
