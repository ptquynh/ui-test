package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;
import java.util.Random;

import static com.tekexperts.pipeline.common.TestLogger.info;
public class RegionParentDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> content;
	public ArrayList<Integer> supperParent;
	public int parentIndex;

	
	/**
	 * Get message
	 * @param type
	 * @param content
	 */
	public RegionParentDatabase(ArrayList<Integer> type,ArrayList<Integer> supperParent, ArrayList<String> content,int parentIndex){
		this.type = type;
		this.supperParent = supperParent;
		this.content = content;
		this.parentIndex=parentIndex;
	}

	/**
	 * UserDatabase
	 */
	public RegionParentDatabase(){
		type  = new ArrayList<Integer>();
		supperParent  = new ArrayList<Integer>();
		content  = new ArrayList<String>();
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
			content.add(testData[i][1]);
			supperParent.add(Integer.valueOf(testData[i][2]));
		}
	}
	
	/**
	 * Get content by index
	 * @param index
	 * @return content
	 */
	public String getContentByIndex(int index){
		return content.get(index);
	}
	/**
	 * Get content by type
	 * @param type
	 * @return newContent
	 */
	public String getContentByType(int type){
		String newContent="";
		for(int i = 0; i<this.type.size(); i++)
		{	
			if(this.type.get(i) == type) {
				newContent=content.get(i);
			}
		}
		return newContent;
		
	}
	
	/**
	 * Get content with random array type
	 * @param type
	 * @return content
	 */
	public String getContentByArrayTypeRandom(int...type){
		ArrayList<String> array = new ArrayList<String>();
		ArrayList<Integer> arrayIndex = new ArrayList<Integer>();
		parentIndex=0;
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					array.add(this.content.get(i));
					arrayIndex.add(this.supperParent.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(array.size());
		parentIndex = arrayIndex.get(index);
		String content = array.get(index);
		info("The content is: "+content);
		return content;
	}
}
