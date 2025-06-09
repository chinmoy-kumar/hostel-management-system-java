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
	private String uname;
	private String upass;
	
	private File myfile;
	private FileWriter fwrite;
	private Scanner sc;
	
	public Data()
	{
		
	}
	
	public Data(String uname,String upass)
	{
		this.uname=uname;
		this.upass=upass;
	}
	
	public void setUserName(String uname)
	{
		this.uname=uname;
	}
	
	public void setUserPass(String upass)
	{
		this.upass=upass;
	}
	
	public String getUserName()
	{
		return uname;
	}
	
	public String getUserPass()
	{
		return upass;
	}
	
	public void addData()
	{
		try
		{
			myfile=new File("./Data.txt");
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
	
	public boolean getData(String username,String userpass)
	{
		boolean flag=false;
		try
		{
			myfile=new File("./Data.txt");
			sc=new Scanner(myfile);
			
			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String[] value=line.split("\t");
				if (value.length >= 2 && value[0].equals(username) && value[1].equals(userpass)) {

				//if(value[0].equals(username)&&value[1].equals(userpass))
				{
					flag=true;
				}
			}
			
		}}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
			return flag;
	}
	
}