package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;

public class UpdateDatabase {
	/**
	 * UserDatabase
	 */
	public UpdateDatabase(){
	}
	/**
	 * Update many contracts
	 * @param coList
	 * @param valueList
	 * @param row
	 * @param dataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void updateByArray(String dataFile, String userSheet,ArrayList<Integer> row,ArrayList<Integer> coList,
			ArrayList<String> valueList,Object... opParams)throws Exception {
		DatabaseResource.writeDataFromSource(dataFile, userSheet, row, coList,
				valueList, opParams);
	}
	/**
	 * Update a contract
	 * @param dataFile
	 * @param userSheet
	 * @param row
	 * @param col
	 * @param value
	 * @param opParams
	 * @throws Exception
	 */
	public void update(String dataFile, String userSheet, int row, int col,
			String value, Object... opParams) throws Exception {
		DatabaseResource.writeDataFromSource(dataFile, userSheet, row, col,
				value, opParams);
	}
}
