
package EHMS;

import java.util.*;

public class Payment 
{
	Scanner input=new Scanner(System.in);
	public String CreditCardDetails(int fee)
	{
		String Status;
		System.out.println("Enter Amount:"+fee);
		System.out.println("Enter CARD-HOLDER Name : ");
		String cardHolderName=input.next();
		System.out.println("Enter CARD-NUMBER : ");
		int card_no=input.nextInt();
		System.out.println("Enter EXPIRY DATE : ");
		String ExpiryDate=input.toString();
		System.out.println("Enter CVC number of CARD : ");
		int cvc=input.nextInt();
		System.out.println("*** Enter 1 to confirm Payment ***");
		int x=input.nextInt();
		if(x==1)
		{
			System.out.println("Your Payment is confirmed");
			return "Payed";
		}
		else
		{
			System.out.println("Your Appointment is cancelled");
			return "NotPayed";
		}
	}
}
