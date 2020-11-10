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
	public void CreditCardDetails()
	{
		String cardHolderName=input.next();
		int card_no=input.nextInt();
		Date ExpiryDate=input.nextString();
		int cvc=input.nextInt();
		
		
	}
}
