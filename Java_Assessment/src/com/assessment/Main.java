package com.assessment;
import java.util.Scanner;

public class Main  {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FilesUtility fUtil = new FilesUtility();
		boolean isCloseCalled = false;
		do{
			System.out.println("********************************* Main Menu *********************************");
			System.out.println("Choose the Operation you want to perform:");
			System.out.println("enter 1 to Retrieve the file names in an ascending order");
			System.out.println("enter 2 to Add a file, Delete a file or Search for a file in the Application");
			System.out.println("enter 3 to Close the Application");
			System.out.println("*****************************************************************************");
			int operation=0;
			try{
			 operation=Integer.parseInt(sc.nextLine());
			}catch (Exception e) {
				//do not do anything
			}
			String fileName="";
			switch(operation)
			{
			case 1: 
				fUtil.sortFileNames();
			break;
			case 2:
				boolean continueCurrentContext=true;
				do{
				System.out.println("*********** Business-level Operations Menu ***********");
				System.out.println("Choose the Operation you want to perform:");
				System.out.println("enter 1 to Add a file to the application");
				System.out.println("enter 2 to Delete a file from the application");
				System.out.println("enter 3 to Search a file in the application");
				System.out.println("enter 4 to go back to Main Menu");
				System.out.println("*******************************************************");
				int option=0;
				try{
				option=Integer.parseInt(sc.nextLine());
				}
				catch (Exception e) {
					// do not do anythig
				}
				switch(option)
				{
				case 1: System.out.println("Enter the name of the file you want to add");
				fileName=sc.nextLine();
				fUtil.addFile(fileName);
				break;
				case 2: System.out.println("Enter the name of the file you want to delete");
				fileName=sc.nextLine();
				fUtil.deleteFile(fileName);
				break;

				case 3: System.out.println("Enter the name of the file you want to search for");
				fileName=sc.nextLine();
				fUtil.searchFile(fileName);
				break;

				case 4:	System.out.println("You chose to navigate to Main Menu.");
				continueCurrentContext=false;
				break;
				
				default: System.out.println("you did not choose the valid option.. please try again!");
				break;
				
				}
				
				}while(continueCurrentContext);

				break;

			case 3: System.out.println("You chose to close the Application, Closing the Application..");
			isCloseCalled=true;
			break;
			default: System.out.println("you did not choose the valid option.. please try again!");
			break;
			}

		}while(!isCloseCalled);
		if(sc!=null) sc.close();
		System.out.println("Application Closed Successfully!");
	}

}
