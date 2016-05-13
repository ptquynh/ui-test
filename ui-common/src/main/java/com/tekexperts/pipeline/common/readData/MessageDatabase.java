package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;
import static com.tekexperts.pipeline.common.TestLogger.info;
public class MessageDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> content;

	
	/**
	 * Get message
	 * @param type
	 * @param content
	 */
	public MessageDatabase(ArrayList<Integer> type, ArrayList<String> content){
		this.type = type;
		this.content = content;
	}

	/**
	 * UserDatabase
	 */
	public MessageDatabase(){
		type  = new ArrayList<Integer>();
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
		for(int i = 0; i<testData.length; i++)
		{	
			info("i:"+i);
			type.add(Integer.valueOf(testData[i][0]));
			content.add(testData[i][1]);
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
}
