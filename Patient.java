package MedicalDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Patient {
	
	private String name;
	private String ID;
	private String address;
	private int height;
	private float weight;
	private Date DOB ;
	private Date initialVisit;
	private Date lastVisit;
	
	//Default Constructor
	public Patient()
	{
		this.name = "Kadeem Weetom";
		this.ID = "0000001";
		this.address = "123 Random Rd";
		this.height = 67;
		this.weight = 175;
		
		SetDOB("01/22/1996");
		SetInitialVisit("03/15/2003");
		SetLastVist("05/03/2015");
	}
	
	//Constructor with inputs. sets the variables
	public Patient(String name, String ID, String address, int height, float weight, String DOB, String Ivist, String Lvist)
	{
		this.name = name;
		this.ID = ID;
		this.address = address;
		this.height = height;
		this.weight = weight;
		
		SetDOB(DOB);
		SetInitialVisit(Ivist);
		SetLastVist(Lvist);
	}
	
	//function to provide the users age when compared to their birthday
	public int GetAge()
	{
		long todaydate = System.currentTimeMillis();
		
		Calendar DOBcal = Calendar.getInstance();
		DOBcal.setTimeInMillis(DOB.getTime());
		
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(todaydate);
		
		int age = today.get(Calendar.YEAR) - DOBcal.get(Calendar.YEAR);
		System.out.println(age);
		
		return age;
		
	}
	//Use age method to calculate years since 1st visit
	public int GetTimeAsPatient()
	{
		int timeAsPatient;
		long todaydate = System.currentTimeMillis();
		
		Calendar InitVisit = Calendar.getInstance();
		InitVisit.setTimeInMillis(initialVisit.getTime());
		
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(todaydate);
		
		timeAsPatient = today.get(Calendar.YEAR) - InitVisit.get(Calendar.YEAR);
		System.out.println(timeAsPatient);
		
		
		return timeAsPatient;
	}
	//Use age method to calculate years since last visit
	public int GetTimeSinceLastVist()
	{
		long todaydate = System.currentTimeMillis();
		
		int yearslastvisit;
		Calendar Lvist = Calendar.getInstance();
		Lvist.setTimeInMillis(lastVisit.getTime());
		
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(todaydate);
		
		yearslastvisit = today.get(Calendar.YEAR) - Lvist.get(Calendar.YEAR);
		System.out.println(yearslastvisit);
		
		return yearslastvisit;
	}
	
	//Setters for variables
	public void SetName(String name)
	{
		this.name = name;
	}
	public void SetID(String id)
	{
		this.ID = id;
	}
	public void SetAddress(String address)
	{
		this.address = address;
	}
	public void SetHeight(int height)
	{
		this.height = height;
	}
	public void SetWeight(Float weight)
	{
		this.weight = weight;
	}
	public void SetDOB(String DOB)
	{
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			
			this.DOB = dFormat.parse(DOB);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SetInitialVisit(String ivisit)
	{

		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			
			this.initialVisit = dFormat.parse(ivisit);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void SetLastVist(String lvisit)
	{

		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			
			this.lastVisit = dFormat.parse(lvisit);
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Getters for variables
	public String GetName()
	{
		return name;
	}
	public String GetID()
	{
		return ID;
	}
	public String GetAddress()
	{
		return address;
	}
	public int GetHeight()
	{
		return height;
	}
	public float GetWeight()
	{
		return weight;
	}
	public Date GetDOB()
	{
		return DOB;
		
	}
	public Date GetInitialVisit()
	{
		
		return initialVisit;
	}
	public Date GetLastVisit()
	{
		return lastVisit;
	}

	
	public String ToStringS()
	{
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");

//		System.out.printf("Name: %s \nId: %s \nAddress: %s \nHeight: %d \nWeight: %f "
//				+ "\nDate of Birth: %s  \nInitial Visit Date: %s \nLast Visit Date: %s",
//				name, ID, address, height, weight, DOB.toString(), initialVisit.toString(), lastVisit.toString() );
//			
		
		String text = String.format("Name: %s \nId: %s \nAddress: %s \nHeight: %d \nWeight: %.2f "
				+ "\nDate of Birth: %s  \nInitial Visit Date: %s \nLast Visit Date: %s",
				name, ID, address, height, weight, dFormat.format(DOB),dFormat.format(initialVisit), dFormat.format(lastVisit) );
	
		return text;
	}

	public String ToStringL()
	{
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");

		String text = String.format(" %s ,%s ,%s ,%d ,%.2f ,%s  ,%s ,%s",
				name, ID, address, height, weight, dFormat.format(DOB),dFormat.format(initialVisit), dFormat.format(lastVisit) );
	
		return text;
	}
	public String[] ToStringA()
	{
		SimpleDateFormat dFormat = new SimpleDateFormat("MM/dd/yyyy");
		String[] arraydata = {name,address,ID,Integer.toString(height),Float.toString(weight), dFormat.format(DOB).toString(),dFormat.format(initialVisit).toString(),dFormat.format(lastVisit).toString()};
		return arraydata;
	}
	
}

