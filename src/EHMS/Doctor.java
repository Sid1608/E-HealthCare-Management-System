/**********************************************************|Doctor Class|*********************************************************/
package EHMS;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Doctor extends Person
{
	int docid;//DoctorID
	String Doctor_Type;//Type of doctor
	String Qualification;//
	int Entry_Charge;
	Scanner sc=new Scanner(System.in);
	/***********************************************************************************************/ 
	public void DoctorRegistration(int docid)
	{
		System.out.println("Enter the following Details");
		this.docid=docid;
		System.out.println("Doctor ID "+docid);
		super.UserInformation();
    	System.out.println("EntryFee");
    	Entry_Charge=sc.nextInt();
    	System.out.println("Qualification:");
    	Qualification=sc.next();
    	System.out.println("Doctor_Type:");
    	System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n7.General_Physicist");
    	int ch=sc.nextInt();
    	switch(ch)
		{
			case 1:
			{
				Doctor_Type="Eyes";
				break;
			}
			case 2:
			{
				Doctor_Type="Ear";
				break;
			}
			case 3:
			{
				Doctor_Type="Heart";
				break;
			}
			case 4:
			{
				Doctor_Type="Bone";
				break;
			}

			case 5:
			{
				Doctor_Type="Lungs";
				break;
			}
			case 6:
			{
				Doctor_Type="Kidney";
				break;
			}
			case 7:
			{
				Doctor_Type="General Physicist";
				break;
			}
			default:
			{
				System.out.println("Select Appropriate option");
			}
				
		}
		Register reg=new Register();
    	reg.doctor_Registration(docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Qualification,Doctor_Type,Email_Address);//change the database
	}
	/***********************************************************************************************/ 
	public void ShowDoctorDetails(int d)//This function Show All Details Of the doctor//
	{
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Doctors where DoctorID="+d);
    		while(rs.next())
    		{
    			System.out.println("DoctorID:     "+rs.getInt(1));
    			System.out.println("Name:         "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("Qualification "+rs.getString(8));
    			System.out.println("Department    "+rs.getString(9));
    			System.out.println("Contact No:   "+rs.getString(5));
    			System.out.println("EmailId:      "+rs.getString(10));
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	/***********************************************************************************************/ 
	public void viewAppointment(int docid)
	{
		int t=0;
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from  Appointments where DoctorID="+docid);
    		while(rs.next())
    		{
    			if(rs.getString(9).compareTo("Payed")==0&&rs.getString(10).compareTo("Pending")==0)
    			{
	    			t++;
	    			System.out.println("\t*** APPOINTMENT - NUMBER : "+t);
					System.out.print("\t* Appointment_ID : "+rs.getInt(1)+"                          \n");
					System.out.print("\t* Problem  :       "+rs.getString(2)+"                       \n");
					System.out.print("\t* PatientId :      "+rs.getInt(3)+"                          \n");
					System.out.print("\t* DoctorFees :     "+rs.getString(8)+"                       \n");
					System.out.print("\t* PaymentStatus :  "+rs.getString(9)+"                       \n");
					System.out.print("\t*************************************************************\n");	
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		if(t==0)
			System.out.println("You Currently Don't Have Any Appointment");
	}
	/***********************************************************************************************/ 
	int Appointment_checker(int appid,int docid)
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("Select * from Appointments where DoctorID="+docid);
			while(rs.next())
			{
				if(rs.getInt(1)==appid)
					return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	/***********************************************************************************************/
	public void DiagonistPatient(int id)//Check patient//
	{
		while(true)
		{
			System.out.println("Enter Appointment_Id of the patient which you want to check!!");
			int appid=sc.nextInt();
			int f=Appointment_checker(appid,id);
			if(f==1)
			{
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeQuery("Select * from Appointments where AppointmentID="+id);
					int pid=GetPatientID(appid);
					Report rp=new Report();
					rp.DiagonistReport(pid,appid,id);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				break;
			}
			else
			{
				System.out.println("******Wrong appointmentID****");
				//boolean leave=false;
				System.out.println("Enter 1 to leave!!!");
				if(sc.nextInt()==1)
					break;
				
			}
		}
		
	}
	/***********************************************************************************************/ 
	private int GetPatientID(int appid)
	{
		int pid=0;
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Appointments where AppointmentID="+appid);
			while(rs.next())
			{
				pid=rs.getInt(3);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pid;
	}
	 /***********************************************************************************************/ 
}
