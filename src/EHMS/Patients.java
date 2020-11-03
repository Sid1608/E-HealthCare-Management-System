package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Register;
import java.sql.*;

import java.util.Scanner;
public class Patients extends Person
{
	Scanner sc=new Scanner(System.in);
    String BloodGroup ;
    public void PatientRegistration(int pid) 
    {
  
    	super.UserInformation();
    	System.out.println("BloodGroup:");
    	BloodGroup=sc.next();
    	Register reg=new Register();
    	reg.patient_Registration(pid,First_Name,Last_Name,Gender,CN,age,Email_Address);
 
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
