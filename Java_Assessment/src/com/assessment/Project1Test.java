package com.assessment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Project1Test {
	static String Folder=System.getProperty("user.dir")+"//AppFolder//";
	public void addFile(String fileName)
	{
		try{
			File file = new File(Folder+fileName);
			if(file.exists())
			{
				System.err.println("File:"+fileName+" already exist..");
			}else
			{
				FileWriter fr = new FileWriter(file);
				if(file.exists())
				{
					System.out.println("File:"+fileName+" created successfully..");
				}else
				{

					System.err.println("File:"+fileName+" not created..");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Exception Occurred while creating the file "+fileName);
		} catch (IOException e) {
			System.err.println("Exception Occurred while creating the file "+fileName);
		}
	}

	public void deleteFile(String fileName)
	{
		File file = new File(Folder+fileName);
		file.delete();
		if(!file.exists())
		{
			System.out.println("File:"+fileName+" deleted successfully..");
		}else
		{
			System.err.println("File:"+fileName+" not deleted");
		}
	}

	public void searchFile(String fileName)
	{
		File file = new File(Folder+fileName);
		if(file.exists())
		{
			System.out.println("File:"+fileName+" found successfully..");
		}else
		{
			System.err.println("File:"+fileName+" not found");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Project1Test test = new Project1Test();
		do{
			System.out.println("Choose the Operation you want to perform from the list");
			System.out.println("enter 1 to Add a file to the application");
			System.out.println("enter 2 to Delete a file from the application");
			System.out.println("enter 3 to Search a file from the application");
			System.out.println("enter any other key to exit the application");
			int operation=Integer.parseInt(sc.nextLine());
			String fileName="";
			switch(operation)
			{
			case 1: System.out.println("Enter the name of the file you want to add");
			fileName=sc.nextLine();
			test.addFile(fileName);
			break;
			case 2: System.out.println("Enter the name of the file you want to delete");
			fileName=sc.nextLine();
			test.deleteFile(fileName);
			break;

			case 3: System.out.println("Enter the name of the file you want to search for");
			fileName=sc.nextLine();
			test.searchFile(fileName);
			break;

			default:	System.out.println("You chose to Exit the Application.");
			System.exit(0);
			System.out.println("Exitted Successfully...");
			break;


			}

		}while(true);


	}

}
