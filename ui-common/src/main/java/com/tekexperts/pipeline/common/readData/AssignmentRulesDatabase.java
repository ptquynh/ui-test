package com.tekexperts.pipeline.common.readData;
import java.util.ArrayList;

public class AssignmentRulesDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> superRegion;
	public ArrayList<String> region;
	public ArrayList<String> country;
	public ArrayList<String> businessUnit;
	public ArrayList<String> productLine;
	public ArrayList<String> shipToAMID;
	public ArrayList<String> soldToMID;
	public ArrayList<String> customerNameShipTo;
	public ArrayList<String> customerNameSoldTo;
	public ArrayList<String> assignTo;

	/**
	 * Assignment rule database
	 * @param type
	 * @param superRegion
	 * @param region
	 * @param country
	 * @param businessUnit
	 * @param productLine
	 * @param shipToAMID
	 * @param soldToMID
	 * @param customerNameShipTo
	 * @param customerNameSoldTo
	 * @param assignTo
	 */
	public AssignmentRulesDatabase(ArrayList<Integer> type, ArrayList<String> superRegion,
		   ArrayList<String> region,ArrayList<String> country,ArrayList<String> businessUnit,
		   ArrayList<String> productLine,ArrayList<String> shipToAMID,ArrayList<String> soldToMID,
		   ArrayList<String> customerNameShipTo,ArrayList<String> customerNameSoldTo,ArrayList<String> assignTo){
		this.type = type;
		this.superRegion = superRegion;
		this.region=region;
		this.country=country;
		this.businessUnit=businessUnit;
		this.productLine=productLine;
		this.shipToAMID=shipToAMID;
		this.soldToMID=soldToMID;
		this.customerNameShipTo=customerNameShipTo;
		this.customerNameSoldTo=customerNameSoldTo;
		this.assignTo=assignTo;
	}

	/**
	 * Assignment rules data
	 */
	public AssignmentRulesDatabase(){
		type  = new ArrayList<Integer>();
		superRegion  = new ArrayList<String>();
		region  = new ArrayList<String>();
		country  = new ArrayList<String>();
		businessUnit  = new ArrayList<String>();
		productLine = new ArrayList<String>();
		shipToAMID  = new ArrayList<String>();
		soldToMID  = new ArrayList<String>();
		customerNameShipTo  = new ArrayList<String>();
		customerNameSoldTo  = new ArrayList<String>();
		assignTo  = new ArrayList<String>();
	}

	/**
	 * set data
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setData(String dataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(dataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			superRegion.add(testData[i][1]);
			region.add(testData[i][2]);
			country.add(testData[i][3]);
			businessUnit.add(testData[i][4]);
			productLine.add(testData[i][5]);
			shipToAMID.add(testData[i][6]);
			soldToMID.add(testData[i][7]);
			customerNameShipTo.add(testData[i][8]);
			customerNameSoldTo.add(testData[i][9]);
			assignTo.add(testData[i][10]);
		}
	}
    /**
     * Get value of super region column
     * @param type
     * @return text
     */
	public String getSuperRegionByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=superRegion.get(i);
		}
		return text;
	}
	
	/**
     * Get value of region column
     * @param type
     * @return text
     */
	public String getRegionByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=region.get(i);
		}
		return text;
	}
	/**
     * Get value of country column
     * @param type
     * @return text
     */
	public String getCountryByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=country.get(i);
		}
		return text;
	}
	/**
     * Get value of product line column
     * @param type
     * @return text
     */
	public String getProductLineByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=productLine.get(i);
		}
		return text;
	}
	/**
     * Get value of business Unit column
     * @param type
     * @return text
     */
	public String getBusinessUnitByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=businessUnit.get(i);
		}
		return text;
	}
	/**
     * Get value of ship to AMID column
     * @param type
     * @return text
     */
	public String getShipToAMIDByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=shipToAMID.get(i);
		}
		return text;
	}
	/**
     * Get value of soldToAMID column
     * @param type
     * @return text
     */
	public String getSoldToAMIDByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=soldToMID.get(i);
		}
		return text;
	}
	/**
     * Get value of customer Name Ship To column
     * @param type
     * @return text
     */
	public String getCustomerNameShipToByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=customerNameShipTo.get(i);
		}
		return text;
	}
	/**
     * Get value of customer Name Sold To column
     * @param type
     * @return text
     */
	public String getcustomerNameSoldToByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=customerNameSoldTo.get(i);
		}
		return text;
	}
	/**
     * Get value of assign To column
     * @param type
     * @return text
     */
	public String getAssignToByType(int type){
		String text="";
		for(int i = 0; i<this.type.size(); i++)
		{
			if(this.type.get(i) == type)
				text=assignTo.get(i);
		}
		return text;
	}
}
