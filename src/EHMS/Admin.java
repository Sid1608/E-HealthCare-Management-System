package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.*;
public class Admin extends Person
{
	
	Scanner sc =new Scanner(System.in);
	private  int docid;
	private static int temp;
	static
	{
		temp=1;
	}
	private static int generateDoctorID()
	{
		return ++temp;
	}
//	private void generatePatientID()
//	{
//		
//		try
//		{
//			Connection con=ConnectionProvider.getCon();
//			Statement st=con.createStatement();
//		
//			ResultSet rs=st.executeQuery("Select MAX(UserID) from Users where userType='Patient'");
//			rs.next();
//			rs.getInt("MAX(UserID)");
////			if(rs.getInt("MAX(UserID)"))
////				return 1;
////			else
////				return id+1;
//				
//			
//		}catch(Exception e)
//		{
//			
//		}
//	}
	public int addDoctor()
	{
		int DoctorID=generateDoctorID();
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
			st.executeUpdate("insert into Users values('"+DoctorID+"','"+password+"','"+"Doctor"+"')");
			System.out.println("Registered Succesfully!!");
		}catch(Exception e){
			System.out.println("Please enter data in correct format!!");
		}
		return DoctorID;
	}
	public void viewDoctors()
	{
		System.out.println("Enter 1 to view all Doctors 2 to view Doctor by id");
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
			st.close();
			con.close();
		}
		catch(Exception e)
		{ System.out.println(e);}  
		

	}
	public void viewPatients()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			String query="select * from Patients";
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void RemoveDoctor(int id) 
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("");
			System.out.println("Removed Succesfully");
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void RemovePatient(int id) 
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("");
			System.out.println("Removed Succesfullu");
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void viewPatientReport() {}//admin can view all the patient reports
	//public void GenerateDoctorSalary() {}
	public void ViewDoctorShedule() {}
	public void ViewFeedback() //admin can view all the feedback
	{
		
	}
	public void viewAppointment() 
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
		}catch(Exception e)
		{
			
		}
	}//admin can view all the appointment
	public void GenerateBill() {}
	public void ViewPaymentDetails() {}//admin can view all the paid bills list

}
