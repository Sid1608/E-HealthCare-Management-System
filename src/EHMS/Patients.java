package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person
{
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
    private int AutoPatientID()
	{
		int id_Patient=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(userID) as 'MaximumID' from Users");
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
		}
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("insert into Users values('"+PatientID+"','"+password+"','"+"Patient"+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return PatientID;
		
	}
    public void PatientRegistration(int pid) 
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup,Address);
 
    }
    public void ShowPatientDetails(int id)
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
    		Statement st=con.createStatement();
    		ResultSet rs=st.executeQuery("Select * from Patients where pid=id");
    		while(rs.next())
    		{
    			//yash
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
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
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//yash
			}
		}
		catch(Exception e)
		{ System.out.println(e);}  
		
    }
    public void BookAppointment(int id) 
    {
    	Appointment ap=new Appointment();
    	ap.BookAppointment(id);  
    	
    }
 
    public void viewAppointment() 
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//yash
			}
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    public void ViewReport()
    {
    	try {
    		Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//yash table ko dekhkar dalde
			}
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    public void Givefeedback(int id) 
    {
    	System.out.println("Give feedback");
    	//String UsersName=;
    	int pid=id;
        System.out.println("Give points to our services out of 10");
        int points=sc.nextInt();
        String Doc_Nature =sc.next();
        String YourComment= sc.next();
        try {
        	
        }
        catch(Exception e)//isko bas table main dalna hain-yash
        {
        	
        }
    	
    }
    public void ChangePassword()
    {
    	//user table main password change karna  - yash
    }
   
    
    
	
}
