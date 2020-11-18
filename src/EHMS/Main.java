package EHMS;
import EHMS.ConnectionProvider;
import EHMS.Appointment;
import java.sql.*;
import java.util.Scanner;

public class Main 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		System.out.println("\n\t******************************E-HealthCare-Management-Sytem***********************************\n");
		boolean check = false;
		Scanner sc=new Scanner(System.in);
		Admin a=new Admin();
		Patients p=null;
		Doctor d=null;
		Patients[] P=new Patients[10000];
		Doctor[] D=new Doctor[10000];
		while(true)
		{
	        System.out.print("\t**********************************************************************************************\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  1. ADMIN - LOGIN                                                          *\n");
	        System.out.print("\t*                  2. PATIENT - LOGIN                                                        *\n");
	        System.out.print("\t*                  3. DOCTOR - LOGIN                                                         *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  4. REGISTER - PATIENT                                                     *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  5. EXIT                                                                   *\n");
	        System.out.print("\t**********************************************************************************************\n");	
		int choice = sc.nextInt();
		switch (choice)
		{
		    case 1:  // admins portal
		    {  
		    	boolean checkadmin = false;
		    	System.out.println("*****************Welcome to Admins portal***********************");
		    	String un;
		    	String pd;
		    	System.out.print("USERNAME-->");un=sc.next();
		    	System.out.print("Password-->");pd=sc.next();
		    	if((un.compareTo("Siddharth")==0&&pd.compareTo("1234")==0)||(un.compareTo("Yash")==0&&pd.compareTo("1234")==0))
		    	{
		    		while(true)
		    		{
		    	        System.out.print("\t**********************************************************************************************\n");
		    	        System.out.print("\t*                                                                                            *\n");
		    	        System.out.print("\t*                  1.DoctorsList                                                             *\n");
		    	        System.out.print("\t*                  2.PatientsList.                                                           *\n");
		    	        System.out.print("\t*                  3.AddDoctor                                                               *\n");
		    	        System.out.print("\t*                  4.RemoveDoctor                                                            *\n");
		    	        System.out.print("\t*                  5.AppointmentsDetail                                                      *\n");
		    	        System.out.print("\t*                  6.ViewFeedbacks                                                           *\n");
		    	        System.out.print("\t*                  7.LOGOUT                                                                  *\n");
		    	        System.out.print("\t**********************************************************************************************\n");	
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
		    					System.out.println("Enter doctorID!!");
		    					int id=sc.nextInt();
		    					a.RemoveDoctor(id);
		    					break;
		    				}
		    				case 5:
		    				{
	    					  //AppointmentsDetail
		    					a.ViewAppointment();
		    					break;
		    				}
		    				case 6:
		    				{
		    					//TO VIEW FEEDBACK GIVEN BY THE PATIENT//
		    					a.ViewFeedback();
		    					break;
		    				}
		    				case 7:
		    				{
		    					checkadmin = true;
		    					break;
		    					
		    				}
		    			}//end of switch
		    			if(checkadmin)
		    				break;
		    		}//end of while
		    		
		    	}
		    	else
		    		System.out.println("Invalid username or password");
		    	break;
		    }
		    case 2:   //For Patient   
		    {
		    	boolean checkPatient = false;
		    	int flag=0;
		    	System.out.println("*****************Welcome to patient portal***********************");
		    	int id;
		    	String pd;
		    	String userType="Patient";
		    	System.out.print("ID:");id=sc.nextInt();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeQuery("Select * from Users where userID="+id+" && userType='Patient' && Password="+pd+";");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd"+e.getMessage());
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.print("\t**********************************************************************************************\n");
		    	        System.out.print("\t*                                                                                            *\n");
		    	        System.out.print("\t*                  1.ViewProfile                                                             *\n");
		    	        System.out.print("\t*                  2.viewDoctors                                                             *\n");
		    	        System.out.print("\t*                  3.BookAppointments                                                        *\n");
		    	        System.out.print("\t*                  4.ViewReport                                                              *\n");
		    	        System.out.print("\t*                  5.viewAppointments                                                        *\n");
		    	        System.out.print("\t*                  6.ChangePassword                                                          *\n");
		    	        System.out.print("\t*                  7.Give FeedBack                                                           *\n");
		    	        System.out.print("\t*                  8.LOGOUT                                                                  *\n");
		    	        System.out.print("\t**********************************************************************************************\n");
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
		    					P[id].ViewReport(id);
		    				}
		    				case 5:
		    				{
		    					P[id].viewAppointment(id);
		    				}
		    				case 6:
		    				{
		    					P[id].ChangePassword(id);
		    				}
		    				case 7:
		    				{
		    					P[id].Givefeedback(id) ;
		    					
		    				}
		    				case 8:
		    				{
		    					checkPatient = true;
		    					break;
		    				}
		    			}
		    			if(checkPatient)
		    				break;
		    		}//end of while
		    	}
		    	break;
		    }
		    case 3: //For Doctor
		    {
		    	boolean checkDoctor = false;
		    	System.out.println("***************Welcome to Doctors portal******************");
		    	int flag=0;
		    	int id;
		    	String pd;
		    	String userType="Doctor";
		    	System.out.print("DOCTOR - ID : ");id=sc.nextInt();
		    	System.out.print("Password : ");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					st.executeUpdate("Select * from Users where userID="+id+" and userType="+userType+" and Password="+pd+";");
					flag=1;
				}catch(Exception e){
					System.out.println("Not Registerd");
				}
		    	if(flag==1)
		    	{
		    		while(true)
		    		{
		    			System.out.print("\t**********************************************************************************************\n");
		    	        System.out.print("\t*                                                                                            *\n");
		    	        System.out.print("\t*                  1.view_DOCTOR_Profile                                                     *\n");
		    	        System.out.print("\t*                  2.viewAppointments                                                        *\n");
		    	        System.out.print("\t*                  3.DiagonistPatient                                                        *\n");
		    	        System.out.print("\t*                  4.LOGOUT                                                                  *\n");
		    	        System.out.print("\t*                                                                                            *\n");
		    	        System.out.print("\t**********************************************************************************************\n");	
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					D[id].ShowDoctorDetails(id);
		    				}
		    				case 2:
		    				{
		    					D[id].viewAppointment(id);
		    				}
		    				case 3:
		    				{
		    					D[id].DiagonistPatient(id);
		    				}
		    				case 4:
		    				{
		    					checkDoctor = true;
		    					break;
		    				}
		    			}//end of switch.
		    			if(checkDoctor)
		    				break;
		    		}//end of while
		    			break;
		    	}//end of if
			
		    }
		    case 4:   /**For Patient Registration**/
		    {
		    	p=new Patients();
		    	int pid=p.addPatient(P);
		    	System.out.println("****** Fill the following details ******");
		    	p.PatientRegistration(pid);
		    	break;
		    }
		    case 5:
		    {
		    	System.out.println("**THANKS FOR VISITING US - Have A Nice Day**");
		    	check = true;
		    	break;
		    }
		    default :
		    {
		    	System.out.println("** PLEASE CHOOSE AN APPROPRIATE OPTION **");
		    }
		}//end of switch
		if(check)
			break;
		}//end of while loop
	}
}
