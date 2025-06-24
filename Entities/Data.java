package Entities;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Frames.*;
import java.util.*;
import java.io.*;

public class Data
{
	private String uname,upass,dob, gender, blood, contact, address, varsity, gname, gcontact;
	
	private File myfile,myfile2;
	private FileWriter fwrite,fwrite2;
	private Scanner sc;
	
	public Data()
	{
		
	}
	
	public Data(String uname,String upass)
	{
		this.uname=uname;
		this.upass=upass;
	}
	
	public Data(String uname,String upass,String dob,String gender,String blood,String contact,
	 String address,String varsity,String gname,String gcontact)
	{
		this.uname=uname;
		this.upass=upass;
		this.dob=dob;
		this.gender=gender;
		this.blood=blood;
		this.contact=contact;
		this.address=address;
		this.varsity=varsity;
		this.gname=gname;
		this.gcontact=gcontact;
		
		
	}
	
	
	

	public void setUserName(String uname)
	{
		this.uname=uname;
	}
	
	public void setUserPass(String upass)
	{
		this.upass=upass;
	}
	
	
	public void setUserDob(String dob)
	{
		this.dob=dob;
	}
	
	public void setUserGender(String gender)
	{
		this.gender=gender;
	}
	
	public void setUserBlood(String blood)
	{
		this.blood=blood;
	}
	
	public void setUserContact(String contact)
	{
		this.contact=contact;
	}
	
	public void setUserAddress(String address)
	{
		this.address=address;
	}
	
	public void setUserVarsity(String varsity)
	{
		this.varsity=varsity;
	}
	
	public void setUserGname(String gname)
	{
		this.gname=gname;
	}
	
	public void setUserGcontact(String gcontact)
	{
		this.gcontact=gcontact;
	}
	
	
	
	
	public String getUserName()
	{
		return uname;
	}
	
	public String getUserPass()
	{
		return upass;
	}
	
	
	public String getUserDob()
	{
		return dob;
	}
	public String getUserGender()
	{
		return gender;
	}
	
	public String getUserBlood()
	{
		return blood;
	}
	public String getUserContact()
	{
		return contact;
	}
	public String getUserAddress()
	{
		return address;
	}
	public String getUserVarsity()
	{
		return varsity;
	}
	public String getUserGname()
	{
		return gname;
	}
	public String getUserGcontact()
	{
		return gcontact;
	}
	
	
	public void addLoginData()
	{
		try
		{
			myfile=new File("./Data/Data.txt");
			myfile.createNewFile();
			fwrite=new FileWriter(myfile,true);
			
			fwrite.write(getUserName()+"\t");
			fwrite.write(getUserPass()+"\n");
			
			fwrite.flush();
			fwrite.close();
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	public void addFullRegData()
	{
		try
		{
			myfile2=new File("./Data/regsData.txt");
			myfile2.createNewFile();
			fwrite2=new FileWriter(myfile2,true);
			
			fwrite2.write(getUserName()+"\t");
			fwrite2.write(getUserPass()+"\t");
			fwrite2.write(getUserDob()+"\t");
			fwrite2.write(getUserGender()+"\t");
			fwrite2.write(getUserBlood()+"\t");
			fwrite2.write(getUserContact()+"\t");
			fwrite2.write(getUserAddress()+"\t");
			fwrite2.write(getUserVarsity()+"\t");
			fwrite2.write(getUserGname()+"\t");
			fwrite2.write(getUserGcontact()+"\n");
			
			
			fwrite2.flush();
			fwrite2.close();
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
	
	public boolean getData(String username,String userpass)
	{
		boolean flag=false;
		try
		{
			myfile=new File("./Data/Data.txt");
			sc=new Scanner(myfile);
			
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String[] value=line.split("\t");
				if (value.length >= 2 && value[0].equals(username) && value[1].equals(userpass)) {

				if(value[0].equals(username)&&value[1].equals(userpass))
				{
					flag=true;
				}
			}
			
		}
	}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
			return flag;
	}
	
}