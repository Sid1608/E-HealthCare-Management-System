package EHMS;

import java.util.Date;
import java.util.Scanner;

public class Payment 
{
	Scanner input=new Scanner(System.in);
//	int pmid;
//	int amount;
//	int pid;
//	int appid;
//	int docid;
	public String CreditCardDetails()
	{
		String Status;
		String cardHolderName=input.next();
		int card_no=input.nextInt();
		String ExpiryDate=input.toString();
		int cvc=input.nextInt();
		System.out.println("Enter 1 to confirm Payment!!!");
		int x=input.nextInt();
		if(x==1)
		{
			System.out.println("Your Payment is confirmed");
			return "Payed";
//			Status=ConfirmPayment();
//			return Status;
		}
		else
		{
			System.out.println("Your Appointment is cancelled");
			return "Cancelled";
		}
		
		
	}
}
