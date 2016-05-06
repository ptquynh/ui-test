package com.tekexperts.pipeline.common.readData;

import java.util.ArrayList;

public class UserDatabase {
	public ArrayList<Integer> type;
	public ArrayList<String> email;
	public ArrayList<String> password;
	public ArrayList<String> fullname;
	public ArrayList<String> hpid;
	public ArrayList<String> role;

	
	/**
	 * Get user's information
	 * @param type
	 * @param fullname
	 * @param role
	 * @param email
	 * @param hpid
	 * @param password
	 */
	public UserDatabase(ArrayList<Integer> type, ArrayList<String> fullname, 
			ArrayList<String> role, ArrayList<String> email,ArrayList<String> hpid,ArrayList<String> password){
		this.type = type;
		this.fullname = fullname;
		this.password = password;
		this.email=email;
		this.hpid=hpid;
		this.role=role;
	}

	/**
	 * UserDatabase
	 */
	public UserDatabase(){
		type  = new ArrayList<Integer>();
		fullname  = new ArrayList<String>();
		password  = new ArrayList<String>();
		email  = new ArrayList<String>();
		role  = new ArrayList<String>();
		hpid=new ArrayList<String>();
	}

	
	/**
	 * setUserData
	 * @param userDataFile
	 * @param userSheet
	 * @param opParams
	 * @throws Exception
	 */
	public void setUserData(String userDataFile, String userSheet, Object... opParams) throws Exception{
		String[][] testData = DatabaseResource.getDataFromSource(userDataFile,userSheet,opParams);
		for(int i = 0; i<testData.length; i++)
		{	
			type.add(Integer.valueOf(testData[i][0]));
			fullname.add(testData[i][1]);
			role.add(testData[i][2]);
			email.add(testData[i][3]);
			hpid.add(testData[i][4]);
			password.add(testData[i][5]);
		}
	}
	
	/**
	 * Get Full name By Index
	 * @param index
	 * @return fullname.get(index)
	 */
	public String getFullNameByIndex(int index){
		return fullname.get(index);
	}

	/**
	 * Get role by index
	 * @param index
	 * @return getRoleByIndex(int index)
	 */
	public String getRoleByIndex(int index){
		return role.get(index);
	}
}
