package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class OrderDatabase {
	public ArrayList<String> payerCustomerIdentifier;
	public ArrayList<String> payerCustomerName;
	public ArrayList<String> soldToCustomerIdentifier;
	public ArrayList<String> soldToCustomerName;
	public ArrayList<String> soldToAMIDLevel2Identifier;
	public ArrayList<String> soldToAMIDLevel2Name;
	public ArrayList<String> soldToAMIDLevel4Identifier;
	public ArrayList<String> soldToAMIDLevel4Name;
	public ArrayList<String> shipToAMIDLevel2Identifier;
	public ArrayList<String> shipToAMIDLevel2Name;
	public ArrayList<String> shipToCustomerName;
	public ArrayList<String> profitCenterLevel1Description;
	public ArrayList<String> profitCenterLevel2Description;
	public ArrayList<String> profitCenterLevel3Description;
	public ArrayList<String> profitCenterLevel4Description;
	public ArrayList<String> profitCenterLevel5Description;
	public ArrayList<String> legacySalesOrderIdentifier;
	public ArrayList<String> customerPurchaseOrderIdentifier;
	public ArrayList<String> salesOrderIdentifier;
	public ArrayList<String> financialCloseCalendarDateDDMMYYYYCode;
	public ArrayList<String> financialCloseFiscalYearMonthCode;
	public ArrayList<String> financialCloseFiscalYearQuarterCode;
	public ArrayList<String> salesChannelDescription;
	public ArrayList<String> salesChannelName;
	public ArrayList<String> salesRepresentativeCode;
	public ArrayList<String> salesOrderTypeCode;
	public ArrayList<String> businessAreaCode;
	public ArrayList<String> businessTypeCode;
	public ArrayList<String> businessTypeCodeName;
	public ArrayList<String> businessAreaDescription;
	public ArrayList<String> businessTypeGroupCodeDescription;
	public ArrayList<String> businessGroupDescription;
	public ArrayList<String> manufacturingProductDescription;
	public ArrayList<String> manufacturingProductIdentifier;
	public ArrayList<String> manufacturingProductSalesProductIdentifier;
	public ArrayList<String> sourceSystemName;
	public ArrayList<String> serviceGoodsProductIdentifier;
	public ArrayList<String> netSalesOrderUSDollarAmount;
	public ArrayList<String> grossSalesOrderUSDollarAmount;
	public ArrayList<String> netSalesOrderDocumentCurrencyAmount;
	public ArrayList<String> grossSalesOrderDocumentCurrencyAmount;
	public ArrayList<String> documentExchangeRate;
	public ArrayList<String> localCurrencyCode;
	public ArrayList<String> documentCurrencyCode;
	public ArrayList<String> docCount;
	public ArrayList<String> start;
	public ArrayList<String> end;
	public ArrayList<String> funcLoc;
	public ArrayList<String> said;
	public ArrayList<String> previousDoc;
	public ArrayList<String> billingType;
	public ArrayList<String> sectionInCurrentForecast;
	public ArrayList<String> billingDescription;
	public ArrayList<String> durationDays;
	public ArrayList<String> durationMonths;
	public ArrayList<String> businessUnit;
	public ArrayList<String> pillar;
	public ArrayList<String> family;
	public ArrayList<String> busisnessType;
	public ArrayList<String> invoicing;
	public ArrayList<String> rtsNPASku;
	public ArrayList<String> rtsCheck;
	public ArrayList<String> annualiseYOrN;
	public ArrayList<String> annualisedOrderValueLC;
	public ArrayList<String> annualisedOrderValue$;
	public ArrayList<String> cqRevenue;
	public ArrayList<String> wwRegion;
	public ArrayList<String> subRegionEMEAMgd;
	public ArrayList<String> subRegionEmeaFinanceFormat;
	public ArrayList<String> expiringDoc;
	public ArrayList<String> currentDoc;
	public ArrayList<String> supportLevel;
	public ArrayList<String> assignment;
	public ArrayList<String> rtm;
	public ArrayList<String> atrType;
	public ArrayList<String> falloutCheck1;
	public ArrayList<String> reconciled1;
	public ArrayList<String> falloutcheck2;
	
	public OrderDatabase(ArrayList<String> payerCustomerIdentifier,
			ArrayList<String> payerCustomerName,
			ArrayList<String> soldToCustomerIdentifier,
			ArrayList<String> soldToCustomerName,
			ArrayList<String> soldToAMIDLevel2Identifier,
			ArrayList<String> soldToAMIDLevel2Name,
			ArrayList<String> soldToAMIDLevel4Identifier,
			ArrayList<String> soldToAMIDLevel4Name,
			ArrayList<String> shipToAMIDLevel2Identifier,
			ArrayList<String> shipToAMIDLevel2Name,
			ArrayList<String> shipToCustomerName,
			ArrayList<String> profitCenterLevel1Description,
			ArrayList<String> profitCenterLevel2Description,
			ArrayList<String> profitCenterLevel3Description,
			ArrayList<String> profitCenterLevel4Description,
			ArrayList<String> profitCenterLevel5Description,
			ArrayList<String> legacySalesOrderIdentifier,
			ArrayList<String> customerPurchaseOrderIdentifier,
			ArrayList<String> salesOrderIdentifier,
			ArrayList<String> financialCloseCalendarDateDDMMYYYYCode,
			ArrayList<String> financialCloseFiscalYearMonthCode,
			ArrayList<String> financialCloseFiscalYearQuarterCode,
			ArrayList<String> salesChannelDescription,
			ArrayList<String> salesChannelName,
			ArrayList<String> salesRepresentativeCode,
			ArrayList<String> salesOrderTypeCode,
			ArrayList<String> businessAreaCode,
			ArrayList<String> businessTypeCode,
			ArrayList<String> businessTypeCodeName,
			ArrayList<String> businessAreaDescription,
			ArrayList<String> businessTypeGroupCodeDescription,
			ArrayList<String> businessGroupDescription,
			ArrayList<String> manufacturingProductDescription,
			ArrayList<String> manufacturingProductIdentifier,
			ArrayList<String> manufacturingProductSalesProductIdentifier,
			ArrayList<String> sourceSystemName,
			ArrayList<String> serviceGoodsProductIdentifier,
			ArrayList<String> netSalesOrderUSDollarAmount,
			ArrayList<String> grossSalesOrderUSDollarAmount,
			ArrayList<String> netSalesOrderDocumentCurrencyAmount,
			ArrayList<String> grossSalesOrderDocumentCurrencyAmount,
			ArrayList<String> documentExchangeRate,
			ArrayList<String> localCurrencyCode,
			ArrayList<String> documentCurrencyCode, ArrayList<String> docCount,
			ArrayList<String> start, ArrayList<String> end,
			ArrayList<String> funcLoc, ArrayList<String> said,
			ArrayList<String> previousDoc, ArrayList<String> billingType,
			ArrayList<String> sectionInCurrentForecast,
			ArrayList<String> billingDescription,
			ArrayList<String> durationDays, ArrayList<String> durationMonths,
			ArrayList<String> businessUnit, ArrayList<String> pillar,
			ArrayList<String> family, ArrayList<String> busisnessType,
			ArrayList<String> invoicing, ArrayList<String> rtsNPASku,
			ArrayList<String> rtsCheck, ArrayList<String> annualiseYOrN,
			ArrayList<String> annualisedOrderValueLC,
			ArrayList<String> annualisedOrderValue$,
			ArrayList<String> cqRevenue, ArrayList<String> wwRegion,
			ArrayList<String> subRegionEMEAMgd,
			ArrayList<String> subRegionEmeaFinanceFormat,
			ArrayList<String> expiringDoc, ArrayList<String> currentDoc,
			ArrayList<String> supportLevel, ArrayList<String> assignment,
			ArrayList<String> rtm, ArrayList<String> atrType,
			ArrayList<String> falloutCheck1, ArrayList<String> reconciled1,
			ArrayList<String> falloutcheck2) {

		this.payerCustomerIdentifier = payerCustomerIdentifier;
		this.payerCustomerName = payerCustomerName;
		this.soldToCustomerIdentifier = soldToCustomerIdentifier;
		this.soldToCustomerName = soldToCustomerName;
		this.soldToAMIDLevel2Identifier = soldToAMIDLevel2Identifier;
		this.soldToAMIDLevel2Name = soldToAMIDLevel2Name;
		this.soldToAMIDLevel4Identifier = soldToAMIDLevel4Identifier;
		this.soldToAMIDLevel4Name = soldToAMIDLevel4Name;
		this.shipToAMIDLevel2Identifier = shipToAMIDLevel2Identifier;
		this.shipToAMIDLevel2Name = shipToAMIDLevel2Name;
		this.shipToCustomerName = shipToCustomerName;
		this.profitCenterLevel1Description = profitCenterLevel1Description;
		this.profitCenterLevel2Description = profitCenterLevel2Description;
		this.profitCenterLevel3Description = profitCenterLevel3Description;
		this.profitCenterLevel4Description = profitCenterLevel4Description;
		this.profitCenterLevel5Description = profitCenterLevel5Description;
		this.legacySalesOrderIdentifier = legacySalesOrderIdentifier;
		this.customerPurchaseOrderIdentifier = customerPurchaseOrderIdentifier;
		this.salesOrderIdentifier = salesOrderIdentifier;
		this.financialCloseCalendarDateDDMMYYYYCode = financialCloseCalendarDateDDMMYYYYCode;
		this.financialCloseFiscalYearMonthCode = financialCloseFiscalYearMonthCode;
		this.financialCloseFiscalYearQuarterCode = financialCloseFiscalYearQuarterCode;
		this.salesChannelDescription = salesChannelDescription;
		this.salesChannelName = salesChannelName;
		this.salesRepresentativeCode = salesRepresentativeCode;
		this.salesOrderTypeCode = salesOrderTypeCode;
		this.businessAreaCode = businessAreaCode;
		this.businessTypeCode = businessTypeCode;
		this.businessTypeCodeName = businessTypeCodeName;
		this.businessAreaDescription = businessAreaDescription;
		this.businessTypeGroupCodeDescription = businessGroupDescription;
		this.businessGroupDescription = businessGroupDescription;
		this.manufacturingProductDescription = manufacturingProductDescription;
		this.manufacturingProductIdentifier = manufacturingProductIdentifier;
		this.manufacturingProductSalesProductIdentifier = manufacturingProductSalesProductIdentifier;
		this.sourceSystemName = sourceSystemName;
		this.serviceGoodsProductIdentifier = serviceGoodsProductIdentifier;
		this.netSalesOrderUSDollarAmount = netSalesOrderDocumentCurrencyAmount;
		this.grossSalesOrderUSDollarAmount = grossSalesOrderUSDollarAmount;
		this.netSalesOrderDocumentCurrencyAmount = netSalesOrderDocumentCurrencyAmount;
		this.grossSalesOrderDocumentCurrencyAmount = grossSalesOrderDocumentCurrencyAmount;
		this.documentExchangeRate = documentExchangeRate;
		this.localCurrencyCode = localCurrencyCode;
		this.documentCurrencyCode = documentCurrencyCode;
		this.docCount = docCount;
		this.start = start;
		this.end = end;
		this.funcLoc = funcLoc;
		this.said = said;
		this.previousDoc = previousDoc;
		this.billingType = billingType;
		this.sectionInCurrentForecast = this.billingDescription = billingDescription;
		this.durationDays = durationDays;
		this.durationMonths = durationMonths;
		this.businessUnit = businessUnit;
		this.pillar = pillar;
		this.family = family;
		this.busisnessType = busisnessType;
		this.invoicing = invoicing;
		this.rtsNPASku = rtsNPASku;
		this.rtsCheck = rtsCheck;
		this.annualiseYOrN = annualiseYOrN;
		this.annualisedOrderValueLC = annualisedOrderValueLC;
		this.annualisedOrderValue$ = annualisedOrderValue$;
		this.cqRevenue = cqRevenue;
		this.wwRegion = wwRegion;
		this.subRegionEMEAMgd = subRegionEMEAMgd;
		this.subRegionEmeaFinanceFormat = subRegionEmeaFinanceFormat;
		this.expiringDoc = expiringDoc;
		this.currentDoc = currentDoc;
		this.supportLevel = supportLevel;
		this.assignment = assignment;
		this.rtm = rtm;
		this.atrType = atrType;
		this.falloutCheck1 = falloutCheck1;
		this.reconciled1 = reconciled1;
		this.falloutcheck2 = falloutcheck2;
	}

	/**
	 * Order Database
	 */
	public OrderDatabase() {
		payerCustomerIdentifier = new ArrayList<String>();
		payerCustomerName = new ArrayList<String>();
		soldToCustomerIdentifier = new ArrayList<String>();
		soldToCustomerName = new ArrayList<String>();
		soldToAMIDLevel2Identifier = new ArrayList<String>();
		soldToAMIDLevel2Name = new ArrayList<String>();
		soldToAMIDLevel4Identifier = new ArrayList<String>();
		soldToAMIDLevel4Name = new ArrayList<String>();
		shipToAMIDLevel2Identifier = new ArrayList<String>();
		shipToAMIDLevel2Name = new ArrayList<String>();
		shipToCustomerName = new ArrayList<String>();
		profitCenterLevel1Description = new ArrayList<String>();
		profitCenterLevel2Description = new ArrayList<String>();
		profitCenterLevel3Description = new ArrayList<String>();
		profitCenterLevel4Description = new ArrayList<String>();
		profitCenterLevel5Description = new ArrayList<String>();
		legacySalesOrderIdentifier = new ArrayList<String>();
		customerPurchaseOrderIdentifier = new ArrayList<String>();
		salesOrderIdentifier = new ArrayList<String>();
		financialCloseCalendarDateDDMMYYYYCode = new ArrayList<String>();
		financialCloseFiscalYearMonthCode = new ArrayList<String>();
		financialCloseFiscalYearQuarterCode = new ArrayList<String>();
		salesChannelDescription = new ArrayList<String>();
		salesChannelName = new ArrayList<String>();
		salesRepresentativeCode = new ArrayList<String>();
		salesOrderTypeCode = new ArrayList<String>();
		businessAreaCode = new ArrayList<String>();
		businessTypeCode = new ArrayList<String>();
		businessTypeCodeName = new ArrayList<String>();
		businessAreaDescription = new ArrayList<String>();
		businessTypeGroupCodeDescription = new ArrayList<String>();
		businessGroupDescription = new ArrayList<String>();
		manufacturingProductDescription = new ArrayList<String>();
		manufacturingProductIdentifier = new ArrayList<String>();
		manufacturingProductSalesProductIdentifier = new ArrayList<String>();
		sourceSystemName = new ArrayList<String>();
		serviceGoodsProductIdentifier = new ArrayList<String>();
		netSalesOrderUSDollarAmount = new ArrayList<String>();
		grossSalesOrderUSDollarAmount = new ArrayList<String>();
		netSalesOrderDocumentCurrencyAmount = new ArrayList<String>();
		grossSalesOrderDocumentCurrencyAmount = new ArrayList<String>();
		documentExchangeRate = new ArrayList<String>();
		localCurrencyCode = new ArrayList<String>();
		documentCurrencyCode = new ArrayList<String>();
		docCount = new ArrayList<String>();
		start = new ArrayList<String>();
		end = new ArrayList<String>();
		funcLoc = new ArrayList<String>();
		said = new ArrayList<String>();
		previousDoc = new ArrayList<String>();
		billingType = new ArrayList<String>();
		sectionInCurrentForecast = new ArrayList<String>();
		billingDescription = new ArrayList<String>();
		durationDays = new ArrayList<String>();
		durationMonths = new ArrayList<String>();
		businessUnit = new ArrayList<String>();
		pillar = new ArrayList<String>();
		family = new ArrayList<String>();
		busisnessType = new ArrayList<String>();
		invoicing = new ArrayList<String>();
		rtsNPASku = new ArrayList<String>();
		rtsCheck = new ArrayList<String>();
		annualiseYOrN = new ArrayList<String>();
		annualisedOrderValueLC = new ArrayList<String>();
		annualisedOrderValue$ = new ArrayList<String>();
		cqRevenue = new ArrayList<String>();
		wwRegion = new ArrayList<String>();
		subRegionEMEAMgd = new ArrayList<String>();
		subRegionEmeaFinanceFormat = new ArrayList<String>();
		expiringDoc = new ArrayList<String>();
		currentDoc = new ArrayList<String>();
		supportLevel = new ArrayList<String>();
		assignment = new ArrayList<String>();
		rtm = new ArrayList<String>();
		atrType = new ArrayList<String>();
		falloutCheck1 = new ArrayList<String>();
		reconciled1 = new ArrayList<String>();
		falloutcheck2 = new ArrayList<String>();
	}

	
	/**
	 * Set data
	 * @param dataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setData(String dataFile, String userSheet, Object... opParams)
			throws Exception {
		String[][] testData = DatabaseResource.getDataFromSource(dataFile,
				userSheet, opParams);
		info("dataFile path:" + dataFile);
		for (int i = 0; i < testData.length; i++) {
			info("i:" + i);
			payerCustomerIdentifier.add(testData[i][0]);
			payerCustomerName.add(testData[i][1]);
			soldToCustomerIdentifier.add(testData[i][2]);
			soldToCustomerName.add(testData[i][3]);
			soldToAMIDLevel2Identifier.add(testData[i][4]);
			soldToAMIDLevel2Name.add(testData[i][5]);
			soldToAMIDLevel4Identifier.add(testData[i][6]);
			soldToAMIDLevel4Name.add(testData[i][7]);
			shipToAMIDLevel2Identifier.add(testData[i][8]);
			shipToAMIDLevel2Name.add(testData[i][9]);
			shipToCustomerName.add(testData[i][10]);
			profitCenterLevel1Description.add(testData[i][11]);
			profitCenterLevel2Description.add(testData[i][12]);
			profitCenterLevel3Description.add(testData[i][13]);
			profitCenterLevel4Description.add(testData[i][14]);
			profitCenterLevel5Description.add(testData[i][15]);
			legacySalesOrderIdentifier.add(testData[i][16]);
			customerPurchaseOrderIdentifier.add(testData[i][17]);
			salesOrderIdentifier.add(testData[i][18]);
			financialCloseCalendarDateDDMMYYYYCode.add(testData[i][19]);
			financialCloseFiscalYearMonthCode.add(testData[i][20]);
			financialCloseFiscalYearQuarterCode.add(testData[i][21]);
			salesChannelDescription.add(testData[i][22]);
			salesChannelName.add(testData[i][23]);
			salesRepresentativeCode.add(testData[i][24]);
			salesOrderTypeCode.add(testData[i][25]);
			businessAreaCode.add(testData[i][26]);
			businessTypeCode.add(testData[i][27]);
			businessTypeCodeName.add(testData[i][28]);
			businessAreaDescription.add(testData[i][29]);
			businessTypeGroupCodeDescription.add(testData[i][30]);
			businessGroupDescription.add(testData[i][31]);
			manufacturingProductDescription.add(testData[i][32]);
			manufacturingProductIdentifier.add(testData[i][33]);
			manufacturingProductSalesProductIdentifier.add(testData[i][34]);
			sourceSystemName.add(testData[i][35]);
			serviceGoodsProductIdentifier.add(testData[i][36]);
			netSalesOrderUSDollarAmount.add(testData[i][37]);
			grossSalesOrderUSDollarAmount.add(testData[i][38]);
			netSalesOrderDocumentCurrencyAmount.add(testData[i][39]);
			grossSalesOrderDocumentCurrencyAmount.add(testData[i][40]);
			documentExchangeRate.add(testData[i][41]);
			localCurrencyCode.add(testData[i][42]);
			documentCurrencyCode.add(testData[i][43]);
			docCount.add(testData[i][44]);
			start.add(testData[i][45]);
			end.add(testData[i][46]);
			funcLoc.add(testData[i][47]);
			said.add(testData[i][48]);
			previousDoc.add(testData[i][49]);
			billingType.add(testData[i][50]);
			sectionInCurrentForecast.add(testData[i][51]);
			billingDescription.add(testData[i][52]);
			durationDays.add(testData[i][53]);
			durationMonths.add(testData[i][54]);
			businessUnit.add(testData[i][55]);
			pillar.add(testData[i][56]);
			family.add(testData[i][57]);
			busisnessType.add(testData[i][58]);
			invoicing.add(testData[i][59]);
			rtsNPASku.add(testData[i][60]);
			rtsCheck.add(testData[i][61]);
			annualiseYOrN.add(testData[i][62]);
			annualisedOrderValueLC.add(testData[i][63]);
			annualisedOrderValue$.add(testData[i][64]);
			cqRevenue.add(testData[i][65]);
			wwRegion.add(testData[i][66]);
			subRegionEMEAMgd.add(testData[i][67]);
			subRegionEmeaFinanceFormat.add(testData[i][68]);
			expiringDoc.add(testData[i][69]);
			currentDoc.add(testData[i][70]);
			supportLevel.add(testData[i][71]);
			assignment.add(testData[i][72]);
			rtm.add(testData[i][73]);
			atrType.add(testData[i][74]);
			falloutCheck1.add(testData[i][75]);
			reconciled1.add(testData[i][76]);
			falloutcheck2.add(testData[i][77]);
		}
	}
}
