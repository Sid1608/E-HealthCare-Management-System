package EHMS;
import EHMS.*;
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
		while(true)
		{
	        System.out.print("\t**********************************************************************************************\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  1. ADMIN - LOGIN                                                          *\n");
	        System.out.print("\t*                  2. PATIENT - LOGIN                                                        *\n");
	        System.out.print("\t*                  3. DOCTOR - LOGIN                                                         *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  4. PATIENT-SIGN-UP                                                        *\n");
	        System.out.print("\t*                                                                                            *\n");
	        System.out.print("\t*                  5. EXIT                                                                   *\n");
	        System.out.print("\t**********************************************************************************************\n");	
		int choice = sc.nextInt();
		switch (choice)
		{
		    case 1:  // Admins portal
		    {  
		    	boolean checkadmin = false;
		    	System.out.println("*****************Welcome to Admins portal***********************");
		    	String un;
		    	String pd;
		    	System.out.print("USERNAME-->");un=sc.next();
		    	System.out.print("Password-->");pd=sc.next();
		    	if((un.compareTo("abc")==0&&pd.compareTo("1234")==0)||(un.compareTo("xyz")==0&&pd.compareTo("1234")==0))
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
		    	        System.out.print("\t*                  7.ViewReports                                                             *\n");
		    	        System.out.print("\t*                  8.LOGOUT                                                                  *\n");
		    	        System.out.print("\t**********************************************************************************************\n");	
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					/*To view all doctor detail*/
		    					a.viewDoctors();
		    					break;
		    				}
		    				case 2:
		    				{
		    					/*To view all Patient Detail*/
		    					a.viewPatients();
		    					break;
		    				}
		    				case 3:
		    				{
		    					/*To add new doctor*/
		    					int Id=a.addDoctor();
		    					d=new Doctor();
		    					d.DoctorRegistration(Id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					/*To Remove Doctor*/
		    					System.out.println("Enter doctorID!!");
		    					int id=sc.nextInt();
		    					a.RemoveDoctor(id);
		    					break;
		    				}
		    				case 5:
		    				{
	    					  //Appointments
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
		    					//TO VIEW FEEDBACK GIVEN BY THE PATIENT//
		    					a.ViewReports();
		    					break;
		    				}
		    				case 8:
		    				{
		    					checkadmin = true;
		    					break;
		    					
		    				}
		    				default:
		    				{
		    					System.out.println("Please Choose An Appropriate Option!!!");
		    				}
		    			}//end of switch
		    			if(checkadmin)
		    				break;
		    		}//end of while
		    		
		    	}
		    	else
		    		System.out.println("Invalid Username or Password");
		    	break;
		    }
		    /***********************************************************************************************/ 
		    case 2:   //For Patient   
		    {
		    	boolean checkPatient = false;
		    	int flag=0;
		    	System.out.println("*****************Welcome to patient portal***********************");
		    	int id;
		    	String pd;
		    	System.out.print("ID:");id=sc.nextInt();
		    	System.out.print("Password:");pd=sc.next();
		    	try {
					Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("Select * from Users");
					while(rs.next()) {
						if(rs.getInt(1)==id && rs.getString(2).compareTo("Patient")==0 && (rs.getString(3).compareTo(pd)==0 ))
						{
							flag=1;
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
		    	if(flag==1)
		    	{
		    		p=new Patients();
		    		while(true)
		    		{
		    			System.out.print("\t**********************************************************************************************\n");
		    	        System.out.print("\t*                                                                                            *\n");
		    	        System.out.print("\t*                  1.ViewProfile                                                             *\n");
		    	        System.out.print("\t*                  2.viewDoctors                                                             *\n");
		    	        System.out.print("\t*                  3.BookAppointments                                                        *\n");
		    	        System.out.print("\t*                  4.ViewReport                                                              *\n");
		    	        System.out.print("\t*                  5.viewAppointments                                                        *\n");
		    	        System.out.print("\t*                  6.viewCompletedAppointments                                               *\n");
		    	        System.out.print("\t*                  7.Give FeedBack                                                           *\n");
		    	        System.out.print("\t*                  8.LOGOUT                                                                  *\n");
		    	        System.out.print("\t**********************************************************************************************\n");
		    			int ch=sc.nextInt();
		    			switch(ch)
		    			{
		    				case 1:
		    				{
		    					p.ShowPatientDetails(id);
		    					break;
		    				}
		    				case 2:
		    				{
		    					p.viewDoctor();
		    					break;
		    				}
		    				case 3:
		    				{
		    					p.BookAppointment(id);
		    					break;
		    					
		    				}
		    				case 4:
		    				{
		    					p.ViewReport(id);
		    					break;
		    				}
		    				case 5:
		    				{
		    					p.viewAppointment(id);
		    					break;
		    				}
		    				case 6:
		    				{
		    					p.AppointmentHistory(id) ;
		    					break;
		    				}
		    				case 7:
		    				{
		    					p.Givefeedback(id) ;
		    					break;
		    					
		    				}
		    				case 8:
		    				{
		    					checkPatient = true;
		    					break;
		    				}
		    				default:
		    				{
		    					System.out.println("Please Choose An Appropriate Option!!!");
		    				}
		    			}
		    			if(checkPatient)
		    				break;
		    		}
		    	}
		    	else
	    		{
	    			System.out.println("Invali UserID or password!!!");
	    		}
		    	break;
		    }
		    /***********************************************************************************************/ 		    
		    case 3: //For Doctor
		    {
		    	boolean checkDoctor = false;
		    	System.out.println("***************Welcome to Doctors portal******************");
		    	int flag=0;
		    	int id;
		    	String pd;
		    	System.out.print("DOCTOR - ID : ");id=sc.nextInt();
		    	System.out.print("Password : ");pd=sc.next();
		    	try {
		    		Connection con=ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("Select * from Users");
					while(rs.next()) {
						if(rs.getInt(1)==id && rs.getString(2).compareTo("Doctor")==0 && (rs.getString(3).compareTo(pd)==0 )){
							flag=1;
						}
					}
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
		    					d=new Doctor();
		    					d.ShowDoctorDetails(id);
		    					break;
		    				}
		    				case 2:
		    				{
		    					d=new Doctor();
		    					d.viewAppointment(id);
		    					break;
		    				}
		    				case 3:
		    				{
		    					d=new Doctor();
		    					d.DiagonistPatient(id);
		    					break;
		    				}
		    				case 4:
		    				{
		    					checkDoctor = true;
		    					break;
		    				}
		    				default:
		    				{
		    					System.out.println("Select Approprate option");
		    				}
		    			}//end of switch.
		    			if(checkDoctor)
		    				break;
		    		}//end of while
		    			break;
		    	}//end of if
		    	else {
		    		System.out.println("Invalid Username or Password!!!");
		    	}
		    	break;
		    }
		    /***********************************************************************************************/ 
		    case 4:   /**For Patient Registration**/
		    {
		    	p=new Patients();
		    	int pid=p.addPatient();
		    	System.out.println("*** Fill the following details ***");
		    	p.PatientRegistration(pid);//Patient Registration Form//
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
