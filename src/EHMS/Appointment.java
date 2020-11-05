package EHMS;

import java.util.Scanner;

public class Appointment 
{
	private  int Apid;
	private int pid;
	private static int temp;
	private String Problem;
	String Doctor_Name;
	String Doctor_Department;
	static
	{
		temp=1;
	}
	Scanner sc=new Scanner(System.in);
	private static int generateAccno()
	{
		return ++temp;
	}
//	Appointment()
//	{
//		
//	}
	public void BookAppointment(int id)
	{
		System.out.println("Enter your Disease:");
		Problem=sc.next();
		Doctor_Name=AssignDoctor();	
	}
	String AssignDoctor()
	{
		System.out.println("Choose your problem related to!!");
		System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Brain\n5.\n6.\n7.\n.\n.");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1;
			{
				
			}
			case2:
			{
				
			}
		}
	}
	public void Appointment_Status() 
	{
		
	}
	
	public void ConfirmAppointment()//Add all details into appointment database
	{
		int d;
		System.out.println("Enter 1 to confirm");
		d=sc.nextInt();
		if(d==1)
		{
			System.out.println("Appointment conirmed");
			try
			{
				
			}catch()
			{
				
			}
		}
		else
		{
			
		}
	}
}
      