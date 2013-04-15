package com.code.others;

import java.util.Comparator;


public class User 
{
private String mname="";
private String lname="";
private String fname="";

public User(String fname, String lname){
	this.fname = fname;
	this.lname = lname;
}

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

	
public static final String USER_NAME = "User Name";


	public static Comparator<User> fNameComparator = new Comparator<User>() {

		@Override
		public int compare(User u1, User u2) {
			
			return u1.getFname().compareTo(u2.getFname());
		}
	};
	
	
}  // User ends...