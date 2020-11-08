package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person
{
	private int PatientID;
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
    private void generatePatientID()
	{
		
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery("Select MAX(UserID) from Users where userType is Patient");
			rs.next();
			rs.getInt("MAX(UserID)");
//			if(rs.getInt("MAX(UserID)"))
//				return 1;
//			else
//				return id+1;
				
			
		}catch(Exception e)
		{
			
		}
	}
    public void addPatient() 
	{
		PatientID=generatePatientID();
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
			st.executeUpdate("insert into Users values('"+PatientID+"','"+password+"','"+"Patient"+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		//return PatientID;
		
	}
    public void PatientRegistration(int pid) 
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup);
 
    }
    public void ShowPatientDetails(int id)
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Patients where pid=id");
    		while(rs.next())
    		{
    			
    		}
    	}
    	catch(Exception e)
    	{
    		
    	}
	}
    public void viewDoctor()
    {
    	try 
		{
    		Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
		}
		catch(Exception e)
		{ System.out.println(e);}  
		
    }
    public void BookAppointment() 
    {
    	Appointment ap=new Appointment();
    	
    	
    	
    }
    public void viewAppointment() 
    {
    	
    }
    public void GetPatientStatus() 
    {
    	
    }
    public void ViewReport()
    {
    	
    }
    
    
    public void assignDoctor() 
    {
    	
    }
    public void billpayment() {}
    public void Givefeedback() {}//feedback form banega
   
    
    
	
}
