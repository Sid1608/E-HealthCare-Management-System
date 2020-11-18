package EHMS;
import EHMS.*;
import java.sql.*;

public class Register 
{

	public void patient_Registration(int pid,String fn,String ln,String G,String cn,int age,String Eid,String BloodGroup,String Address)
	{
		//int pid=1;
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Patients VALUES ('"+pid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+Eid+"','"+BloodGroup+"','"+Address+"')");
			System.out.println("Registered Succesfully!!");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());}  

		//pid,First_Name,Last_Name,Gender,CN,age,Email_Address,BloodGroup

	}
	public void doctor_Registration(int docid,String fn,String ln,String G,String cn,int age,int ec,String Q,String dt,String ed)
	{
		//docid,First_Name,Last_Name,Gender,CN,age,Entry_Charge,Qualification,Doctor_Type,Email_Address
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Doctors VALUES ('"+docid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+ec+"','"+Q+"','"+dt+"','"+ed+"')");
			System.out.println("Doctor Added Successully");
		}
		catch(Exception e)
		{ System.out.println(e.getMessage());}  
	}
}
