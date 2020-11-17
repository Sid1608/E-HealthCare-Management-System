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
	private int AutoReportID()
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
	public void DiagonistReport(int pid,int appid,int docid)
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
		}
		
	}
	public void GenerateReport()//yash
	{
		try {
			Connection con=ConnectionProvider.getCon();
			Statement st=con.createStatement();
			//ResultSet rs=st.executeUpdate("");//     Yash//
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
