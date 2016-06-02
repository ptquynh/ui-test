package com.tekexperts.pipeline.common.readData;

import static com.tekexperts.pipeline.common.TestLogger.info;

import java.util.ArrayList;
import java.util.Random;

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
		for(int i = 1; i<testData.length; i++)
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
	
	/**
	 * Get HPID by random
	 * @param type
	 * @return
	 */
	public String getIDByArrayTypeRandom(int...type){
		ArrayList<String> arrayID = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayID.add(this.hpid.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayID.size());
		String attachID = arrayID.get(index);
		info("AttachID is: "+attachID);
		return attachID;
	}
	
	/**
	 * Get username by random
	 * @param type
	 * @return names
	 */
	public String getNameByArrayTypeRandom(int...type){
		ArrayList<String> arrayName = new ArrayList<String>();
		Random randomGenerator = new Random();
		for (int j = 0; j<type.length; j++){
			for(int i = 0; i<this.type.size(); i++)
			{	
				if(this.type.get(i) == type[j]) {
					arrayName.add(this.fullname.get(i));
				}
			}
		}
		int index = randomGenerator.nextInt(arrayName.size());
		String attachName = arrayName.get(index);
		info("AttachName is: "+attachName);
		return attachName;
	}
}
