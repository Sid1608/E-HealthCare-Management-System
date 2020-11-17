package EHMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Appointment 
{
	private  int Apid;
	private int pid;
	private String Problem;
	String Doctor_Name;
	String Doctor_Type;
	int docFees;
	String Appointment_Status="Pending";
	String payment_status;
	Scanner sc=new Scanner(System.in);
	private int AutoAppointmentID()
	{
		int appID=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(AppointmentID) from Appointments");
			rs.next();
			rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return appID+1;
	}
	public void BookAppointment(int id)

	{
		Apid=AutoAppointmentID();
		System.out.println("Appointment ID:"+Apid);
		pid=id;
		System.out.println("Patient ID:"+pid);
		System.out.println("Enter your Problem:");
		Problem=sc.next();
		int docid=ChooseDoctor();	
		Doctor_Name=GetDoctorName(docid);
		docFees=GetDoctorFees(docid);
		System.out.println("DoctorName:"+Doctor_Name);
		int d;
		System.out.println("Enter 1 to confirm");
		d=sc.nextInt();
		if(d==1)
		{
			ConfirmAppointment();
		}
		else 
		{
			System.out.println("Your appointmenet cancelled");
		}
		
		
	}

	int ChooseDoctor()
	{
		System.out.println("Choose Doctor Type According to yout problem!!");
		System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n.7General_Phsysicist");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
			{
				Doctor_Type="Eyes";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 2:
			{
				Doctor_Type="Ear";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Ear'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 3:
			{
				Doctor_Type="Heart";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 4:
			{
				Doctor_Type="Bone";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 5:
			{
				Doctor_Type="Lungs";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 6:
			{
				Doctor_Type="Kidney";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			case 7:
			{
				Doctor_Type="General_Physicist";
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Eyes'");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10)+"  "+rs.getString(11)+"  "+rs.getString(12));
					}
					System.out.println("Enter the doc id which you want to choose!!!!");
					int did=sc.nextInt();
					return did;
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	String GetDoctorName(int docID)//yash
	{
		///yaha table banakar doctor ka naam return karwade
	}
	int GetDoctorFees(int docID)//yash
	{
		//yaha fees retrun karw dena
	}
	public String billpayment(int fee)
    {
    	Payment p=new Payment();
    	System.out.println("Doctor-Fees:"+fee);
    	System.out.println("Enter the credit card detaisl!!1");
    	String status=p.CreditCardDetails(fee);
    	return status;
    }
	public void ConfirmAppointment()//Add all details into appointment database//yash
	{
			payment_status=billpayment(docFees);
	//	yeh sab table main dal dena ,doctor vo hi appointment lega jisme PAYment status=payed hoga
			System.out.println("Appointment confirmed");
			try
			{
				Connection con=ConnectionProvider.getCon();
				Statement st=con.createStatement();
				st.executeUpdate("insert int o");
				

			}
			catch(Exception e)
			{
				System.out.println("");
			}

	}
}
      