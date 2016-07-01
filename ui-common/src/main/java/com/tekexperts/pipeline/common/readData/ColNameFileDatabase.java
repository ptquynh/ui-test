package com.tekexperts.pipeline.common.readData;
import static com.tekexperts.pipeline.common.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

public class ColNameFileDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> name;
	public ArrayList<String> color;
	
	/***
	 * Code to define color
	 * 1: gray
	 * 2: blue
	 * 3: violet
	 * 4. Green
	 */

	/**
	 * ColName
	 * @param type
	 * @param name
	 * @param color
	 */
	public ColNameFileDatabase(ArrayList<Integer> type, ArrayList<String> name,ArrayList<String> color){
		this.type = type;
		this.name = name;
		this.color=color;
	}

	
	public ColNameFileDatabase(){
		type  = new ArrayList<Integer>();
		name  = new ArrayList<String>();
		color  = new ArrayList<String>();
	}

	/**
	 * set data
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 1; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			name.add(testData[i][1]);
			color.add(testData[i][2]);
		}
	}

	/**
	 * Get name by index
	 * @param index
	 * @return name.get(index)
	 */
	public String getNameByIndex(int index){
		return name.get(index);
	}
	
	/**
	 * Get file name random
	 * @return attachFile
	 */
	public String getNameRandom(){
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(this.name.size());
		String attachFile = this.name.get(index);
		return attachFile;
	}

	/**
	 * Get name by type
	 * @param type
	 * @return array
	 */
	public ArrayList<String> getArrayNameByType(int type){
		ArrayList<String> array = new ArrayList<String>();
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				array.add(this.name.get(i));
			}
		}
		return array;
	}

	/**
	 * Get name by array type
	 * @param type
	 * @return 
	 */
	public ArrayList<String> getArrayNameByArrayType(int...type){
		ArrayList<String> array= new ArrayList<String>();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.name.get(i));
				}
			}
		}
		return array;
	}

	/**
	 * Get name by random type
	 * @param type
	 * @return name
	 */
	public String getNameByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.name.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(name.size());
		String name = array.get(index);
		info("Array is: "+array);
		return name;
	}
}
