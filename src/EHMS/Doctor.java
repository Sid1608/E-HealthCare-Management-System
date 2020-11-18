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
				Doctor_Type="Heart/Lungs";
				break;
			}
			case 4:
			{
				Doctor_Type="Bone";
				break;
			}
			case 5:
			{
				Doctor_Type="Kidney";
				break;
			}
			case 6:
			{
				Doctor_Type="General Physicist";
				break;
			}
			default:
			{
				System.out.println("");
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
    			System.out.println("DoctorID: "+rs.getInt(1));
    			System.out.println("Name: "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("Qualification "+rs.getString(8));
    			System.out.println("Department "+rs.getString(9));
    			System.out.println("Contact No: "+rs.getString(5));
    			System.out.println("EmailId: "+rs.getString(10));
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
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}
	/***********************************************************************************************/ 
//	public void DiagonistPatient(int id)
//	{
//		System.out.println("Enter the Appointment_Id of the patient which you want to check!!");
//		int appid=sc.nextInt();
//		try
//		{
//			Connection con=ConnectionProvider.getCon();
//			Statement st=con.createStatement();
//			st.executeQuery("Select * from Appointment where AppointmentID=appid and Payment_Status='Payed' and Appointment_Status='Pending'");
//			Report rp=new Report();
//			rp.DiagonistReport(id,appid,docid);
//		}catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		
//	}
	/***********************************************************************************************/ 
	public void DiagonistPatient(int id)
	{
		System.out.println("Enter the Appointment_Id of the patient which you want to check!!");
		int appid=sc.nextInt();
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeQuery("Select * from Appointment where AppointmentID="+appid+" and Payment_Status='Payed' and Appointment_Status='Pending'");
			Report rp=new Report();
			rp.DiagonistReport(id,appid,docid);  //idhr error aa skti hai sayhad .... id vala glt hoga sice hmne entry as parameter (int id) liya hai jo ki doctorid bta ti hai.....
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	/***********************************************************************************************/ 

}
