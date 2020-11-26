 //***********************************PATIENT-CLASS***********************************//
package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person//patient class Inheriting from person class//
{
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
    /***********************************************************************************************/ 
    private int AutoPatientID()///This Method of Patient Class Generates the id of patient 
	{
		int id_Patient=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(userID) as 'NextPatientID' from Users");
			rs.next();
			id_Patient= rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return id_Patient+1;
	}
    /***********************************************************************************************/
    public int addPatient() 
	{
		int PatientID=AutoPatientID();
		String password;
		String cpd;
		System.out.println("Patient ID:"+PatientID);
		System.out.println("Enter Password:");
		password=sc.next();
		while(true)
		{
			System.out.println("Confirm Password");
			cpd=sc.next();
			if(password.compareTo(cpd)==0)
					break;
			else
			{
				System.out.println("Your Password is not matching!!!");
				System.out.println("*\tRE-ENTER The Password*");
			}
		}
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("insert into Users values('"+PatientID+"','"+"Patient"+"','"+password+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return PatientID;
		
	}
    /***********************************************************************************************/
    public void PatientRegistration(int pid) /*This method add details of the patient in the patient table of EHMS database*/
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
    /***********************************************************************************************/ 
    public void ShowPatientDetails(int id)/*This method all details of the patient*/
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Patients where PatientID="+id);
    		while(rs.next())
    		{ 
    			System.out.println("PatientID:      "+rs.getInt(1));
    			System.out.println("Name:           "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println("Blood-Group:    "+rs.getString(8));
    			System.out.println("Address:        "+rs.getString(9));
    			System.out.println("Contact-Number: "+rs.getString(5));
    			System.out.print("\t********************\n");
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
	}  
    /***********************************************************************************************/
    
    public void viewDoctor()
    {
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Doctors");
			con.close();
		}
		catch(Exception e)
		{ 
			System.out.println("EXCEPTION OCCURS"+e.getMessage());
		}  
		
    }
    /***********************************************************************************************/  
    public void BookAppointment(int id) 
    {
    	Appointment ap=new Appointment();
    	ap.BookAppointment(id);  
    	
    }
    /***********************************************************************************************/     
    public void viewAppointment(int id) 
    {
    	int t=0;
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from  Appointments where PatientID="+id);
    		while(rs.next())
    		{
	    			t++;
	    			System.out.println("\t*** APPOINTMENT - NUMBER : "+t);
					System.out.print("\t* Appointment_ID : "+rs.getInt(1)+"                          \n");
					System.out.print("\t* Problem  :       "+rs.getString(2)+"                       \n");
					System.out.print("\t* PatientId :      "+rs.getInt(3)+"                          \n");
					System.out.print("\t* Doctor_Id :      "+rs.getInt(5)+"                          \n");
					System.out.print("\t* DoctorFees :     "+rs.getString(8)+"                       \n");
					System.out.print("\t* PaymentStatus :  "+rs.getString(9)+"                       \n");
					System.out.print("\t*************************************************************\n");	
    		}
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		if(t==0)
		{
			System.out.println("*******You Currently Have No Appointments********");
			System.out.println("Enter 3 To Book Appointment!!");
		}
    	
    }
    public void AppointmentHistory(int id) 
    {
    	int t=0;
		try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from  Appointments where PatientID="+id);
    		while(rs.next())
    		{
    			if(rs.getString(10).compareTo("Completed")==0)
    			{
	    			t++;
	    			System.out.println("\t*** APPOINTMENT - NUMBER : "+t);
					System.out.print("\t* Appointment_ID : "+rs.getInt(1)+"                          \n");
					System.out.print("\t* Problem  :       "+rs.getString(2)+"                       \n");
					System.out.print("\t* PatientId :      "+rs.getInt(3)+"                          \n");
					System.out.print("\t* Doctor_Id :      "+rs.getInt(5)+"                          \n");
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
		{
			System.out.println("*******You Have No Past Appointments********");
		}
    	
    }
    /***********************************************************************************************/  
    public void ViewReport(int id)
    {
    	int checkReport=0;
    	try {
    		Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Reports where PatientID = "+id);
			while(rs.next())
			{
				System.out.print("\t* ReportID  :         "+rs.getInt(1)+"                          \n");
				System.out.print("\t* Appointment_ID :    "+rs.getInt(2)+"                          \n");
				System.out.print("\t* PatientId :         "+rs.getInt(3)+"                          \n");
				System.out.print("\t* Doctor_Id :         "+rs.getInt(4)+"                          \n");
				System.out.print("\t* MedicinePrescribed :"+rs.getString(5)+"                       \n");
				System.out.print("\t* Doctor's Message:"+rs.getString(6)+"                          \n");
				System.out.print("\t*************************************************************\n");	
				checkReport++;
			}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	if(checkReport==0)
    			System.out.println("*************************You Have No Report Generated**********************************");
    	
    }
    /***********************************************************************************************/ 
    public void Givefeedback(int id) /*To give Feedback*/
    {
    	System.out.println("*********Please Fill The Following Feedback Form*********");
    	int pid=id;
    	System.out.println("Patient Id:"+pid);
    	System.out.println("Please Give points to our services out of 10 :");
    	int points=sc.nextInt();
    	System.out.println("Nature Of The Doctor");
    	String Doc_Nature = sc.next();
    	Doc_Nature +=sc.nextLine();
    	System.out.println("Enter Your Address below");
    	String Location = sc.next();
    	Location +=sc.nextLine();
    	System.out.println("Your Comment:");
    	String YourComment = sc.next();
    	YourComment +=sc.nextLine();
    	try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO feedback VALUES ('"+pid+"','"+points+"','"+Doc_Nature+"','"+Location+"','"+YourComment+"')");
			System.out.println("-->>Thank You For Visiting Us<<--");
	    	System.out.println("-->>Your Feedback Meant a lot to Us<<--");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
    /***********************************************************************************************/ 
	
}
