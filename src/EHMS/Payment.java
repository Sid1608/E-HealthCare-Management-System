package EHMS;

import java.util.Date;
import java.util.Scanner;

public class Payment 
{
	Scanner input=new Scanner(System.in);
	int pmid;
	int amount;
	int pid;
	int appid;
	int docid;
	public String CreditCardDetails()
	{
		String Status;
		String cardHolderName=input.next();
		int card_no=input.nextInt();
		Date ExpiryDate=input.nextString();
		int cvc=input.nextInt();
		System.out.println("Enter 1 to confirm Payment!!!")
		int x=sc.nextInt();
		if(x==1)
			Status=ConfirmPayment();
		else
			System.out.println("Your Appointment is cancelled");
		
		
	}
	public String ConfirmPayment()
	{
		System.out.println("Your Payment is confirmed");
		return "Payed";
	}
}
