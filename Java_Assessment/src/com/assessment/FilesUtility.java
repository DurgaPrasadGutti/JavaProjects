package com.assessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FilesUtility {
	static String Folder=System.getProperty("user.dir")+"//AppFolder//";
	public void addFile(String fileName)
	{
		try{
			File file = new File(Folder+fileName);
			
			if(file.createNewFile())
			{
				FileWriter fr = new FileWriter(file);
				fr.write("This file is created on "+ Calendar.getInstance().getTime());
				System.out.println("** File:"+fileName+" created successfully..");
				if(fr!=null)
				fr.close();
			}
			else
			{
				System.err.println("File:"+fileName+" already exist");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Exception Occurred while creating the file "+fileName);
		} catch (IOException e) {
			System.err.println("Exception Occurred while creating the file "+fileName);
		}
	}
	
	public void sortFileNames()
	{
		File file = new File(Folder);
		try{
		String[] fileNames = file.list();
		if(fileNames.length==0)
		{
			System.out.println("** There are no files to display..");
		}else
		{
			//Bubble sort in Ascending Order- ignoring case sensitivity
			for(int i=0;i<fileNames.length;i++)
			{
				for(int j=i;j<fileNames.length;j++)
				{
					if(fileNames[i].compareToIgnoreCase(fileNames[j])>0)
					{
						String temp=fileNames[i];
						fileNames[i]=fileNames[j];
						fileNames[j]=temp;
					}
				}
			}
			System.out.println("** please find below the list of files present in the Application");
			for(String fileName : fileNames)
			{
				System.out.println(fileName);
			}
		}
		}catch (Exception e) {
			System.err.println("Exception occurred while trying to display the files");
		}
	}
	

	public void deleteFile(String fileName)
	{
		File file = new File(Folder+fileName);
		try{
		if(file.exists())
		{
			file.delete();
			
			if(!file.exists())
			{
				System.out.println("** File:"+fileName+" deleted successfully..");
			}else
			{
				System.err.println("File:"+fileName+" not deleted");
			}
		}else
		{
			System.err.println("File:"+fileName+" does not exist");
		}
		}catch (Exception e) {
			System.err.println("Exception occurred while trying to delete the File:"+fileName);
		}
		
		
	}

	public void searchFile(String fileName)
	{
		File file = new File(Folder+fileName);
		try{
		if(file.exists())
		{
			System.out.println("** File:"+fileName+" found successfully..");
		}else
		{
			System.err.println("File:"+fileName+" not found");
		}
		}catch (Exception e) {
			System.err.println("Exception occurred while trying to Search for the File:"+fileName);
		}
	}
}
