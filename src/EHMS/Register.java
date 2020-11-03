package EHMS;
import EHMS.*;
import java.sql.*;

public class Register 
{

	public void patient_Registration(int pid,String fn,String ln,String G,String cn,int age,String Eid,String BloodGroup)
	{
		//int pid=1;
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Patients VALUES ('"+pid+"','"+fn+"','"+ln+"','"+G+"','"+cn+"','"+age+"','"+Eid+"','"+BloodGroup+"')");
			System.out.println("Registered Succesfully!!");
		}
		catch(Exception e)
		{ System.out.println(e);}  

		

	}
	public void doctor_Registration(int docid,String fn,String ln,String G,String cn,int age,int ec,String Dg,String dp)
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			int count=st.executeUpdate("INSERT INTO Doctors(First_Name, Last_Name, Gender, ContactNumber,Age,Entry_Charge,Degree,Deparment) VALUES (fn,ln,G,cn,age,ec,dg,dp)");
			System.out.println(count+"row/s affected");
		}
		catch(Exception e)
		{ System.out.println(e);}  
	}
}
