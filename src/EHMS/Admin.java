package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.*;
public class Admin extends Person
{

	Scanner sc =new Scanner(System.in);
	private int AutoDoctorID()
	{
		int docid=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(UserID) as NextUserID from Users where userType='Doctor'");
			rs.next();
			docid = rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return docid+1;
	}
	public int addDoctor()/*This Method add doctor in the system. Admin will Add Doctor*/
	{
		int DoctorID=AutoDoctorID();
		String password;
		String cpd;
		System.out.println("Doctor ID:"+DoctorID);
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
			st.executeUpdate("insert into Users values('"+DoctorID+"','"+"Doctor"+"','"+password+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return DoctorID;
	}
	public void viewDoctors()/*Admin can view all the Doctor detail*/
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();/*getting connection*/
			DBTablePrinter.printTable(con, "Doctors");
			con.close();
		}
		catch(Exception e)
		{ 
			System.out.println("EXCEPTION OCCURS");
		}  
	}
	public void viewPatients()/*Admin can view all the patients detail*/
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Patients");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
	public void RemoveDoctor(int id)/*Admin can remove doctor */
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("delete  from Doctors where DoctorID = "+id);
			System.out.println("Doctor Removed Succesfully!!");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS"+e.getMessage());}  
	}
	
	public void ViewFeedback() //To view Feedback given by Patients. Admin can view all the feedback details//
	{
		try 
		{ 
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "feedback");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}	
	}
	
	public void ViewAppointment()/*To view all the all the appointments taking place */
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Appointments");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
		
	}  
	public void ViewReports()
	{
		Report r=new Report();
		r.ShowReport();
	}
}
