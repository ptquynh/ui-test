package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;

//import com.tekexperts.pipeline.common.pipelineBase;

public class DatabaseResource {
	//static pipelineBase ppBase = new pipelineBase();
	public static String[][] getDataFromSource(String userDataFile, String userSheet, Object... opParams) throws Exception{
		Boolean isUseFile = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		String jdbcDriver = (String)(opParams.length > 1 ? opParams[1]: "");
		String dbUrl = (String)(opParams.length > 2 ? opParams[2]: "");
		String user = (String)(opParams.length > 3 ? opParams[3]: "");
		String pass = (String)(opParams.length > 4 ? opParams[4]: "");
		String sqlDb = (String)(opParams.length > 5 ? opParams[5]: "");
		String[][] arrayData = null;
		if(isUseFile){
			ExcelUtils.setExcelFile(userDataFile,userSheet);
			arrayData = ExcelUtils.getData();
		}
		else{
			DatabaseUtils.connectDatabase(jdbcDriver, dbUrl, user, pass);
			arrayData=DatabaseUtils.getData(sqlDb);
		}
		return arrayData;
	}
	/**
	 * Update data in existing excel file for many contracts
	 * @param userDataFile
	 * @param userSheet
	 * @param rowList
	 * @param cellNum
	 * @param updateValue
	 * @param opParams
	 * @throws Exception
	 */
	public static void writeDataFromSource(String userDataFile,String userSheet,ArrayList<Integer> rowList, 
			ArrayList<Integer> cellNum,ArrayList<String> updateValue, Object... opParams) throws Exception{
		Boolean isUseFile = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		if(isUseFile){
			ExcelUtils.setExcelFile(userDataFile,userSheet);
			ExcelUtils.writeData(userDataFile,rowList,cellNum,updateValue);
		}
	}
	/**
	 * Update data in existing excel file for one contracts
	 * @param userDataFile
	 * @param userSheet
	 * @param row
	 * @param cellNum
	 * @param updateValue
	 * @param opParams
	 * @throws Exception
	 */
	public static void writeDataFromSource(String userDataFile,String userSheet,int row, 
			int cellNum,String updateValue, Object... opParams) throws Exception{
		Boolean isUseFile = (Boolean)(opParams.length > 0 ? opParams[0]: true);
		if(isUseFile){
			ExcelUtils.setExcelFile(userDataFile,userSheet);
			ExcelUtils.writeData(userDataFile,row,cellNum,updateValue);
		}
	}
	
}
