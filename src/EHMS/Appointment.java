package EHMS;

public class Appointment 
{
	private  int Apid;
	private static int temp;
	private String Problem;
	static
	{
		temp=1;
	}
	private static int generateAccno()
	{
		return ++temp;
	}
	Appointment()
	{
		
	}
	String Doctor_Name;
	String Doctor_Department;
	public void Appointment_Status() {}
	public void ViewDoctorAvailiblity() {}
	public void Select_Doctor() {}
	public void viewProblem() {}
	public void Generate_AID() {}
}
      