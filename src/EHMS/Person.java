package EHMS;
import java.util.Date;
import java.util.Scanner;
public class Person 
{
	protected String First_Name;
	protected String Last_Name;
	protected String Email_Address;
	protected String Gender;
	protected int age;
	protected Date DOB;
	protected String CN;
	protected String city;
	protected String state;
	protected String Country;
	protected String Address;
	protected Date RegistrationDate;
	Scanner sc=new Scanner(System.in);
	protected void UserInformation()
	{
    	System.out.println("Enter the following Details");
    	System.out.println("First Name:");
    	First_Name=sc.next();
    	System.out.println("Last Name:");
    	Last_Name=sc.next();
    	System.out.println("Email Address:");
    	Email_Address=sc.next();
    	System.out.println("Gender:");
    	Gender=sc.next();
    	System.out.println("Age:");
    	age=sc.nextInt();
    	System.out.println("Contact Number:");
    	CN=sc.next();
    	System.out.println("City:");
    	city=sc.next();
    	System.out.println("State:");
    	state=sc.next();
    	System.out.println("Country:");
    	Country=sc.next();
    	System.out.println("Address:");
    	Address=sc.next();
    	//sc.close();
	}
	//void ShowUserDetails()
	//{
	//	System.out.println("PatientID:"+PatientID);
		//System.out.println("Name:"+First_Name+" "+Last_Name);
		//System.out.println("Gender"+Gender);
		//System.out.println("Mobile No:"+CN);
		//System.out.println("EmailId:"+Email_Address);
		//System.out.println("DOB:"+DOB);
		//System.out.println("Age:"+age);
		//System.out.println("Address:"+Address);
	//}
	
	
	
}
