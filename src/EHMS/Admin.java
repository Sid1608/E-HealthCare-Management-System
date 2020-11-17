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
//			rs.getInt(1);
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
	public int addDoctor()
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
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//yash isko bharde table ko dekhkar
			}
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
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//Yash
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
			st.executeUpdate("");//    yash 
			System.out.println("Removed Succesfully");
		}
		catch(Exception e)
		{ System.out.println(e);}
	}
	public void viewPatientReport() 
	{
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.execute("");//yash 
			System.out.println("Removed Succesfully");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void ViewFeedback() //admin can view all the feedback
	{
		try {   //yash
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void viewAppointment()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));//yash isko bharde table ko dekhkar
			}
			
		}catch(Exception e)
		{

		}
	}

}
