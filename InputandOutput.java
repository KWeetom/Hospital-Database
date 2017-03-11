package MedicalDatabase;

import java.util.NoSuchElementException;
import java.util.Scanner;

import java.io.*;

//This class will handle the initial read of patient data
//Also will be able to save new data to file or change data

public class InputandOutput {

	private String name;
	private String ID;
	private String address;
	private int height;
	private float weight;
	private String DOB ;
	private String initialVisit;
	private String lastVisit;
	public boolean value;
	
	public int checkLines()
	{
		
		//FileInputStream in = null;
		Scanner in = null;
		String filename = "src\\MedicalDatabase\\PatientData.txt";
	
	
		int cur = 0;
		
		try
		{
			in =  new Scanner(new File(filename));
			in.useDelimiter(",");
			
			while(in.hasNextLine())
			{	
				cur++;
				in.nextLine();
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
			System.exit(0);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No new Line Exception");
			System.exit(0);
		
		}	
		
		return cur;
	}
	
	public void loadData(int num)
	{
		
		//FileInputStream in = null;
		Scanner in = null;
		String filename = "src\\MedicalDatabase\\PatientData.txt";
		String[] patientvariables = new String[8];
		
		int cur = 0;
		
		try
		{
			in =  new Scanner(new File(filename));
			in.useDelimiter(",");
			
			while(in.hasNextLine())
			{
								
				
				String nextLine = in.nextLine();
			
				if(cur == num)
				{
					for(int i = 0; i <8 ; i++)
					{
						patientvariables = nextLine.split(",");
						//System.out.println(patientvariables[i]);
						
					}
				break;
				}
				cur++;
			}
			
			name = patientvariables[0].trim();
			ID =  patientvariables[1].trim();
			address=  patientvariables[2].trim();
			height= Integer.parseInt( patientvariables[3].trim());
			weight=  Float.parseFloat(patientvariables[4].trim());
			DOB =  patientvariables[5];
			initialVisit =  patientvariables[6];
			lastVisit=  patientvariables[7];
		
			in.close();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
			System.exit(0);
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("No new Line Exception");
			System.exit(0);
		}
	}

	public void clearFile()
	{
		FileWriter clear = null;
		String filename = "src\\MedicalDatabase\\PatientData.txt";
		
		String content;
		
		try
		{
			clear = new FileWriter(new File(filename),false);
			
			clear.write("");
			clear.close();

		}
		catch(IOException e)
		{
			System.out.println("IO Exception");
		}
		finally
		{
		}
		
	}
	
	public void saveData(LList target)
	{
		FileWriter save = null;
		String filename = "src\\MedicalDatabase\\PatientData.txt";
		
		String content = "";
		
		try
		{
			save = new FileWriter(new File(filename),true);
			target.curr = target.head;
			while(target.curr != null)
			{	
				content = target.curr.getData().ToStringL();
				save.write(content);
				save.write("\n");
				target.curr = target.curr.next;
			}
			
			save.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Exception");
		}
		
	}
	
	public Patient getData()
	{
		return new Patient(name, ID, address, height, weight, DOB, initialVisit, lastVisit);
	}
	
	

}

