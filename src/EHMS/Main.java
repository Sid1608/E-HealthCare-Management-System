package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("******************************E-HealthCare-Management-Sytem**********************************");
		Scanner sc=new Scanner(System.in);
		Admin a=new Admin();
		Patients p=null;
		Doctor d=null;
		Appointment[] pat_app=new Appointment[10000];
		Appointment[] doc_app=new Appointment[10000];
		Patients[] P=new Patients[10000];
		Doctor[] D=new Doctor[10000];
		while(true)
		{
		System.out.println("1.AdminLogin\n 2.DoctorLogin.\n3.PatientLogin \n");
		int choice = sc.nextInt();
		switch (choice)
		{
		    case 1:  // admins portal
		    {
		    	System.out.println("***********Welcome to Admins portal******************");
		    	String un;
		    	String pd;
		    	System.out.print("USERNAME-->");un=sc.next();
		    	System.out.print("Password-->");pd=sc.next();
		    	if((un.compareTo("Siddharth")==0&&pd.compareTo("1234")==0)||(un.compareTo("Yash")==0&&pd.compareTo("1234")==0))
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.ViewDoctors\n2.ViewPatients.\n3.AddPatient\n4.AddDoctor\n5.RemovePatient\n6.RemoveDoctor\n7.viewAppointments\n8.viewPaymentDetils\n9.updateDoctorsdetails\n10.UpdatePatientDetails");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					a.viewDoctors();
		    					break;
		    				}
		    				case 2:
		    				{
		    					a.viewPatients();
		    					break;
		    				}
		    				case 3:
		    				{
		    					int id=a.addPatient();
		    			    	//p=new Patients();
		    					//p.PatientRegistration(id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					int Id=a.addDoctor();
		    					d=new Doctor();
		    					d.DoctorRegistration(Id);
		    					break;
		    				}
		    				case 5:
		    				{
		    					System.out.println("Enter doctorID!!");
		    					int id=sc.nextInt();
		    					a.RemoveDoctor(id);
		    					break;
		    				}
		    				case 6:
		    				{
		    					System.out.println("Enter doctorID!!");
		    					int id=sc.nextInt();
		    					a.RemovePatient(id);
		    					break;
		    				}
		    				case 7:
		    				{
		    					break;
		    				}
		    			}
		    		}

		    	}
		    	else
		    		System.out.println("Invalid username or password");
		    	break;
		    }
		    case 2:   //For Patient
		    {
		    	int flag=0;
		    	System.out.println("*****************Welcome to patient portal*****************");
		    	int id;
		    	String pd;
		    	String userType="Patient";
		    	System.out.print("ID:");id=sc.nextInt();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("Select * from where ");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd"+e.getMessage());
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.ViewProfile\n 2.viewDoctors.\n3.BookAppointments\n4.CancelAppointment\n5.PayBill\n6.ViewReport\n7.viewAppointments\n.ChangePassword\n.Logout");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					P[id].ShowPatientDetails(id);
		    				}
		    				case 2:
		    				{
		    					P[id].viewDoctor();
		    				}
		    				case 3:
		    				{

		    					pat_app[id].book

		    				}
		    				case 4:
		    				{

		    				}
		    				case 5:
		    				{

		    				}
		    			}
		    		}
		    	}
		    	break;

		    }
		    case 3: //For Doctor
		    {
		    	System.out.println("Welcome to Doctors portal");
		    	int flag=0;
		    	String un;
		    	String pd;
		    	String userType="Doctor";
		    	System.out.print("USERNAME:");un=sc.next();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd");
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.View profile\n 2.viewAppointments.\n3.Cancel Appointments\n4.\n5.\n6.\n7.view Appointments\n.8Logout");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{

		    				}
		    			}
		    		}
		    	}
		    	break;

		    }
		    case 4:
		    {
		    	break;
		    }
		}
		}

	}

}
