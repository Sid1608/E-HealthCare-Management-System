package EHMS;
import EHMS.ConnectionProvider;
import java.sql.*;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("*************E-HealthCare-Management-Sytem*************");
		Scanner sc=new Scanner(System.in);
		Admin a=new Admin();
		Patients p=null;
		Doctor d=null;
		Appointment[] pat_app=new Appointment[10000];
		Appointment[] doc_app=new Appointment[10000];
		Patients[] P=new Patients[10000];
		Doctor[] D=new Doctor[10000];
		while(true)//this is to inform you that 
		{
		System.out.println("1.AdminLogin\n 2.PatientLogin.\n3.DoctorLogin \n4.Patient-SignUp");		
		int choice = sc.nextInt();
		switch (choice)
		{
		    case 1:  // admins portal
		    {   
		    	System.out.println("************Welcome to Admins portal************");
		    	String un;
		    	String pd;
		    	System.out.print("USERNAME-->");un=sc.next();
		    	System.out.print("Password-->");pd=sc.next();
		    	if((un.compareTo("Siddharth")==0&&pd.compareTo("1234")==0)||(un.compareTo("Yash")==0&&pd.compareTo("1234")==0))
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.viewDoctors\n2.viewPatients.\n3.addDoctor\n4.removePatient\n5.RemoveDoctor\n6.viewAppointments\n7.viewPaymentDetils\n8.updateDoctorsdetails\n9.UpdatePatientDetails");
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
		    					int Id=a.addDoctor();
		    					d=new Doctor();
		    					d.DoctorRegistration(Id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					System.out.println("Enter doctor_ID!!");
		    					int id=sc.nextInt();
		    					a.RemoveDoctor(id);
		    					break;
		    				}
		    				case 5:
		    				{
		    					System.out.println("Enter Patient_ID!!");
		    					int id=sc.nextInt();
		    					a.RemovePatient(id);
		    					break;
		    				}
		    				case 6:
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
					st.executeQuery("Select * from Users where userID=id && userType='Patient' && Password=pd");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd"+e.getMessage());
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.ViewProfile\n2.viewDoctors.\n3.BookAppointments\n4.CancelAppointment\n5.PayBill\n6.ViewReport\n7.viewAppointments\n.ChangePassword\n.Logout");
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
		    					
		    					P[id].BookAppointment(id);
		    					
		    				}
		    				case 4:
		    				{
		    				
		    				}
		    				case 5:
		    				{
		    					
		    				}
		    				case 6:
		    				{
		    					
		    				}
		    				case 7:
		    				{
		    					
		    				}
		    				case 8:
		    				{
		    					
		    				}
		    			}
		    		}
		    	}
		    	break;
		    	
		    }
		    case 3: //For Doctor
		    {
		    	System.out.println("Welcome to Doctor's portal");
		    	int flag=0;
		    	int id;
		    	String pd;
		    	String userType="Doctor";
		    	System.out.print("USERNAME:");id=sc.nextInt();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd");
				}
		    	finally {
		    		System.out.println(" Succesfully Logged In !! ");
		    	}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.println("1.viewProfile\n2.viewAppointments.\n3.cancelAppointments\n4Logout");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					D[id].ShowDoctorDetails(id);
		    				}
		    				case 2:
		    				{
		    					
		    				}
		    			}
		    		}
		    	}
		    	break;
		    	
		    }
		    case 4: 
		    {
		    	p=new Patients();
		    	int pid=p.addPatient();
		    	System.out.println("Fill the following details");
		    	p.PatientRegistration(pid);
		    	
		    	break;
		    }
		    case 5:
		    {
		    	
		    }
		}
		}

	}

}
