package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;
import java.util.Random;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class RSREmployeesDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> name;

	
	/**
	 * Get employees
	 * @param type
	 * @param name
	 */
	public RSREmployeesDatabase(ArrayList<Integer> type, ArrayList<String> name){
		this.type = type;
		this.name = name;
	}

	/**
	 * UserDatabase
	 */
	public RSREmployeesDatabase(){
		type  = new ArrayList<Integer>();
		name  = new ArrayList<String>();
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
		for(int i = 1; i<testData.length; i++)
		{	
			info("i:"+i);
			type.add(Integer.valueOf(testData[i][0]));
			name.add(testData[i][1]);
		}
	}
	
	/**
	 * Get name by index
	 * @param index
	 * @return name
	 */
	public String getnameByIndex(int index){
		return name.get(index);
	}
	/**
	 * Get name by type
	 * @param type
	 * @return newname
	 */
	public String getnameByType(int type){
		String newname="";
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newname=name.get(i);
			}
		}
		return newname;
		
	}
	
	/**
	 * Get name with random array type
	 * @param type
	 * @return name
	 */
	public String getNameByArrayTypeRandom(int...type){
		ArrayList<String> arrayName = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayName.add(this.name.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayName.size());
		String name= arrayName.get(index);
		return name;
	}
}
