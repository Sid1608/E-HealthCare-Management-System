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
    int addPatient() 
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
		}
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("insert into Users values('"+password+"','"+PatientID+"','"+"Patient"+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return PatientID;
		
	}
    /***********************************************************************************************/
    public void PatientRegistration(int pid) /*This method add details of the patient in the patient table of ehms database*/
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
    /***********************************************************************************************/ 
    public void ShowPatientDetails(int id)
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Patients where PatientID="+id);
    		while(rs.next())
    		{
    			System.out.println("PatientID: "+rs.getInt(1));
    			System.out.println("Name: "+rs.getString(2)+" "+rs.getString(3));
    			System.out.println(""+rs.getString(8));
    			System.out.println(""+rs.getString(9));
    			System.out.println(" "+rs.getString(5));
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
		{ System.out.println("EXCEPTION OCCURS");}  
		
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
//    		DBTablePrinter.printTable(con, "");
//			con.close();
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }
    /***********************************************************************************************/  
    public void ViewReport(int id)
    {
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
				System.out.print("\t* Bill_Amount :       "+rs.getInt(7)+"                          \n");
				System.out.print("\t* PaymentStatus :     "+rs.getString(8)+"                       \n");
				System.out.print("\t*************************************************************\n");	
			}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    }
    /***********************************************************************************************/     
    public void ChangePassword(int id)
    {
    	System.out.println("** Enter New Password **");
    	String NewPassword=sc.next();
    	try 
    	{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("UPDATE  Users set Password = "+NewPassword+"where userID = "+id);
			System.out.println("** Password Updated Successfully **");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
    /***********************************************************************************************/ 
    public void Givefeedback(int id) 
    {
    	System.out.println("*********Thank You For Visiting Us*********");
    	System.out.println("*********Your Feedback meant a lot to us*********");
    	System.out.println("*********Please Fill The Following Feedback Form*********");
    	int pid=id;
    	System.out.println("Patient Id:"+pid);
    	System.out.println("Please Give points to our services out of 10 :");
    	int points=sc.nextInt();
    	System.out.println("Nature Of The Doctor");
    	String Doc_Nature =sc.next();
    	System.out.println("Enter Your Location In (country,state) Form");
    	String Location = sc.next();
    	System.out.println("Enter Your Feedback Please :");
    	String YourComment= sc.next();
    	try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO feedback VALUES ('"+pid+"','"+points+"','"+Doc_Nature+"','"+Location+"','"+YourComment+"')");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
    }
	
}
