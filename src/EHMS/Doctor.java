package EHMS;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Doctor extends Person
{
	int docid;
	String Doctor_Type;
	String Qualification;
	int Entry_Charge;
	Scanner sc=new Scanner(System.in);
	public void DoctorRegistration(int docid)
	{
		System.out.println("Enter the following Details");
		this.docid=docid;
		System.out.println("Doctor ID "+docid);
		super.UserInformation();
    	System.out.println("EntryFee");
    	Entry_Charge=sc.nextInt();
    	System.out.println("Qualification:");
    	Qualification=sc.next();
    	System.out.println("Doctor_Type:");
    	System.out.println("1.Eyes\n 2.EAR.\n3.Heart\n4.Bone\n5.Lungs\n6.Kidney\n7.General_Physicist");
    	int ch=sc.nextInt();
    	switch(ch)
		{
			case 1:
			{
				Doctor_Type="Eyes";
			}
			case 2:
			{
				Doctor_Type="Ear";
			}
			case 3:
			{
				Doctor_Type="Heart";
			}
			case 4:
			{
				Doctor_Type="Bone";
			}
			case 5:
			{
				Doctor_Type="Lungs";
			}
			case 6:
			{
				Doctor_Type="Kidney";
			}
			case 7:
			{
				Doctor_Type="General Physicist";
			}
		}
		Register reg=new Register();
    	reg.doctor_Registration(docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Qualification,Doctor_Type,Email_Address);//change the database
	}

	public void ShowDoctorDetails(int d)
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
	public void viewAppointment()
	{
		
	}
//	public void CancelAppointmet()
//	{
//		
//	}
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
