package EHMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Report
{
	Scanner input=new Scanner(System.in);
	private int RepId;
	private int pid;
	private int appid;
	private int docid;
	private String MedicinePrescribed;
	private String DoctorsComment;
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
		RepId=AutoReportID();
		System.out.println("ReportID--"+RepId);
		this.pid=pid;
		System.out.println("PatientID--"+pid);
		this.appid=appid;
		System.out.println("AppointmentID--"+appid);
		this.docid=docid;
		System.out.println("DoctorID--"+docid);
		System.out.println("Prescribed medicine to patient--");
		MedicinePrescribed=input.nextLine();
		System.out.println("Additional Information--");
		DoctorsComment=input.nextLine();
		System.out.println("Enter 1 to Generate Report--");
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
	public void GenerateReport()/**/
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO Reports VALUES ('"+RepId+"','"+appid+"','"+pid+"','"+docid+"','"+MedicinePrescribed+"','"+DoctorsComment+"')");
			System.out.println("Report Generated Succesfully!!!");
			ChangeStatus();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	private void ChangeStatus()//changes the status of appointment from pending to completed
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			st.executeUpdate("UPDATE Appointments SET Appointment_Status='Completed' WHERE AppointmentID="+appid);
		}
		catch(Exception e)
		{
			System.out.println("e.getMessage()");
		}
	}
	/***********************************************************************************************/ 
	public void ShowReport()/*Shows all reports that are being generated*/
	{
		try 
		{
			Connection con=ConnectionProvider.getCon();
			DBTablePrinter.printTable(con, "Reports");
		}
		catch(Exception e)
		{ System.out.println("EXCEPTION OCCURS"+e.getMessage());}  
	}
	/***********************************************************************************************/ 
}