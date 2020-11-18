package EHMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Report
{
	Scanner input=new Scanner(System.in);
	int RepId;
	int pid;
	int appid;
	int docid;
	String MedicinePrescribed;
	String DoctorsComment;
	/***********************************************************************************************/ 
	private int AutoReportID()/**/
	{
		int repID=0;
		try{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(ReportId) as NextUserID from Reports");
			rs.next();
			repID=rs.getInt(1);
			if(rs.wasNull())
			{
				return 1;
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return repID+1;
	}
	/***********************************************************************************************/ 
	public void DiagonistReport(int pid,int appid,int docid)/*This Method*/
	{
		this.pid=pid;
		this.appid=appid;
		this.docid=docid;
		System.out.println("Prescribed medicine to patient:");
		MedicinePrescribed=input.next();
		System.out.println("Additional Information::");
		DoctorsComment=input.next();
		System.out.println("Enter 1 to Generate Report::");
		int x=input.nextInt();
		if(x==1)
		{
			GenerateReport();
			ShowReport();
		}
		else
		{
			System.out.println("** Enter Appropriate Details Please **");	
		}
	}
	/***********************************************************************************************/ 
	int GetDoctorFees(int docID)/**/
	{
		int  DoctorFees = 0;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Doctors where DoctorID="+docID);
			while(rs.next())
			{
				DoctorFees = rs.getInt(7);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return DoctorFees;	
	}
	/***********************************************************************************************/ 
	String GetStatus(int docID)/**/
	{
		String status = null;
		try
		{
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from Appointments where DoctorID="+docID);
			while(rs.next())
			{
				status = rs.getString(9);
			}	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return status;
	}
	/***********************************************************************************************/ 
	public void GenerateReport()/**/
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Reports VALUES ('"+AutoReportID()+"','"+appid+"','"+pid+"','"+docid+"','"+MedicinePrescribed+"','"+DoctorsComment+"','"+GetDoctorFees(docid)+"','"+GetStatus(docid)+"')");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	/***********************************************************************************************/ 
	public void ShowReport()/**/
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Reports");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS");}  
	}
	/***********************************************************************************************/ 
}