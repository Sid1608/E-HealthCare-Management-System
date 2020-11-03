package EHMS;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Doctor extends Person
{
	/////////////////////// int DocID;////////////////////
	String Department;
	String Degree;
	int Entry_Charge;
	Scanner sc=new Scanner(System.in);
	public void DoctorRegistration(int docid)
	{
		super.UserInformation();
    	System.out.println("EntryFee");
    	Entry_Charge=sc.nextInt();
    	System.out.println("Degree:");
    	Degree=sc.next();
    	System.out.println("Department:");
    	Department=sc.next();
    	Register reg=new Register();
    	reg.doctor_Registration(docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Degree,Department);
	}

	public void ShowDoctorDetails()
	{
		System.out.println("DoctorID:"+DocID);
		System.out.println("Name:"+First_Name+" "+Last_Name);
		System.out.println("Degree"+Degree);
		System.out.println("Department"+Department);
		System.out.println("Mobile No:"+CN);
		System.out.println("EmailId:"+Email_Address);
	}
	public void viewAppointment()
	{
		
	}
	public void CancelAppointmet()
	{
		
	}
	public void viewPatient()
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Patients");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
	public void viewDoctor()
    {
    	try 
		{
    		Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			Class.forName("com.mysql.jdbc.Driver");
			ResultSet rs=st.executeQuery("select * from Doctors");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			}
		}
		catch(Exception e)
		{ System.out.println(e);}  
		
    }
	public void DiagonisReport() {}
	public void DoctorConfirmation() {}
	public void ViewShedule_appointments() 
	{
		
	}
	public void voidGenerateReport() {}
	
	
	
}
