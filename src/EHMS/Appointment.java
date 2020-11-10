package EHMS;

import java.util.Scanner;

public class Appointment 
{
	private  int Apid;
	private int pid;
	private static int temp;
	private String Problem;
	String Doctor_Name;
	String Doctor_Type;
	String AppStatus="Pending";
	static
	{
		temp=1;
	}
	Scanner sc=new Scanner(System.in);
	private static int generateAppno()
	{
		return ++temp;
	}
	public void BookAppointment(int id)
	{
		Apid=generateAppno();
		System.out.println("Appointment ID:"+Apid);
		pid=id;
		System.out.println("Patient ID:"+pid);
		System.out.println("Enter your Problem:");
		Problem=sc.next();
//		Doctor_Name=AssignDoctor();	
		System.out.println("DoctorName:"+Doctor_Name);
		int d;
		System.out.println("Enter 1 to confirm");
		d=sc.nextInt();
		if(d==1)
		{
			ConfirmAppointment();
		}
		
		
	}
//	String AssignDoctor()
//	{
//		System.out.println("Choose Doctor Type According to yout problem!!");
//		System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n.7General_Phsysicist");
//		int ch=sc.nextInt();
//		switch(ch)
//		{
//			case 1:
//			{
//				Doctor_Type="Eyes";
//				
//			}
//			case 2:
//			{
//				Doctor_Type="Ear";
//			}
//			case 3:
//			{
//				Doctor_Type="Heart";
//			}
//			case 4:
//			{
//				Doctor_Type="Bone";
//			}
//			case 5:
//			{
//				Doctor_Type="Lungs";
//			}
//			case 6:
//			{
//				Doctor_Type="Kidney";
//			}
//			case 7:
//			{
//				Doctor_Type="General_Physicist";
//			}
//		}
//	}
	public void Appointment_Status() 
	{
		try {
			
		}catch() {
			
		}
	}
	
	public void ConfirmAppointment()//Add all details into appointment database
	{
		
//			System.out.println("Appointment conirmed");
//			try
//			{
//				
//			}
//			catch()
//			{
//				
//			}
		
	}
}
      