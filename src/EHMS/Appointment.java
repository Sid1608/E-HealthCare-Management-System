package EHMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Appointment 
{
	private  int Apid,pid,choosedID;
	private String Problem;
	String Doctor_Name;
	String Doctor_Type;
	String AppStatus="Pending";
	String payment_status;
	int docFees;
	Scanner sc=new Scanner(System.in);
	private int AutoAppointmentID()
	{
		int appID=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(AppointmentID) from Appointments");
			rs.next();
			appID = rs.getInt(1);
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
		
		/*choosing doctor */
		ChooseDoctor();
		
		//conforming the doctor --
		int d;
		System.out.println("\t** Enter 1 to confirm **");
		d=sc.nextInt();
		if(d==1)
		{
			ConfirmAppointment();
		}	
	}

	void ChooseDoctor()
	{
		System.out.println("*** Choose Doctor Type According to your problem!! ***");
		System.out.print("\t**********************************************************************************************\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t*                  1.Eyes_Specialist                                                         *\n");
        System.out.print("\t*                  2.EAR_Specialist                                                          *\n");
        System.out.print("\t*                  3.Heart_Specialist                                                        *\n");
        System.out.print("\t*                  4.Bones_Specialist                                                        *\n");
        System.out.print("\t*                  5.Lungs_Specialist                                                        *\n");
        System.out.print("\t*                  6.Kidney_Specialist                                                       *\n");
        System.out.print("\t*                  7.General_Phsysicist                                                      *\n");
        System.out.print("\t*                                                                                            *\n");
        System.out.print("\t**********************************************************************************************\n");	
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
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Heart'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Bone'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Lungs'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='Kidney'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
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
					ResultSet rs=st.executeQuery("select * from Doctors where Doctor_Type='General_Physicist'");
					while(rs.next())
					{
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t* Email_ID :      "+rs.getString(10)+"                     *\n");
						System.out.print("\t* Qualification : "+rs.getString(8)+"                      *\n");
						System.out.print("\t************************************************************\n");	
					}
					System.out.println("\t*** Enter the doctor-id which you want to choose ***");
					choosedID = sc.nextInt();
					System.out.println("\t***   BELOW IS YOUR Appointed_Doctor Detail ***");
					ResultSet Rs=st.executeQuery("select * from Doctors where DoctorID = "+choosedID);
					while(Rs.next())
					{
						docFees = rs.getInt(7);
						Doctor_Name = rs.getString(2);
						System.out.print("\t************************************************************\n");
						System.out.print("\t* Doctor_ID :     "+rs.getInt(1)+"                         *\n");
						System.out.print("\t* Name :          "+rs.getString(2)+" "+rs.getString(3)+"  *\n");
						System.out.print("\t* Entry_Charge :  "+rs.getInt(7)+"                         *\n");
						System.out.print("\t************************************************************\n");
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			default :
		    {
		    	System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
		    }
		}
	}
	
	String GetDoctorName(int docID)
	{
		String DoctorName = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorName = rs.getString(2);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorName;
	}
	
	
	//to return doctor type.
	String GetDoctorType(int docID)
	{
		String DoctorType = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorType = rs.getString(9);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorType;
	}
	
	//return qualification of Doctor
	String GetDoctorQualification(int docID)
	{
		String DoctorQualification = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorQualification = rs.getString(8);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorQualification;
	}
	
	//return doctor Fees
	int GetDoctorFees(int docID)
	{
		int  DoctorFees = 0;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorFees = rs.getInt(7);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorFees;	
	}
	
	
	
	public String billpayment(int fee)
    {
    	Payment p=new Payment();
    	System.out.println("Doctor-Fees:"+fee);
    	System.out.println("** Enter the credit card details Below **");
    	String status=p.CreditCardDetails(fee);
    	return status;
    }
	
	public void ConfirmAppointment()//Add all details into appointment database
	{
			
			payment_status=billpayment(docFees);
			if(payment_status=="Payed")
			{
				System.out.println("Appointment confirmed");
				try
				{
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("INSERT INTO Appointments VALUES ('"+Apid+"','"+Problem+"','"+pid+"','"+GetDoctorName(choosedID)+"','"+choosedID+"','"+GetDoctorType(choosedID)+"','"+GetDoctorQualification(choosedID)+"','"+GetDoctorFees(choosedID)+"','"+payment_status+"')");
				}
				catch(Exception e)
				{
					System.out.println("EXCEPTION OCCURS");
				}
			}
			else
			{
				System.out.println("***  Your Appointment is cancelled  ****");
			}

	}
}