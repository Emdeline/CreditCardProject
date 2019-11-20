
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCard

	{
		static long cardNumber; 
		static long validCard = (long) 5424180123456789.;
		static long invalidCard = (long) 542418012345685.;
		
		static long[] creditCardNumbers = new long[16];
		
		static long vcard = validCard;
		static long inCard = invalidCard;
		
		static int counter = 0;
		
		public static void main(String[] args) throws IOException
			{
				Scanner file = new Scanner(new File("CreditCardNumbers"));

			  while(file.hasNext())
			   {	  
				 cardNumber = file.nextLong();
				 strippingNumbers();
				 doublingNumbers();
				 originalDoubled();
				 countValidCard();
				
			   }
			  System.out.println("The number of valid cards are " + counter);
			  System.out.println("The number of invalid cards are " + (99 - counter));
				
			}
		
		private static void strippingNumbers()
			{			
					for (int c = creditCardNumbers.length - 1; c >= 0; c--)
						{
							long endingDigit = cardNumber % 10;	
							cardNumber /= 10;
							
							creditCardNumbers[c] = endingDigit;

						}
								
			}
		
		private static void doublingNumbers()
			{
				for (int dc = 0; dc < creditCardNumbers.length; dc += 2)
					{
						creditCardNumbers[dc] *= 2;
						
						if(creditCardNumbers[dc] >= 10)
							{
								long newDigg = (creditCardNumbers[dc] / 10) + (creditCardNumbers[dc] % 10);
								creditCardNumbers[dc] = newDigg;
							}

					}
				
			}
		
		private static void originalDoubled()
			{
				int sum = 0;
				
				for (int adc = 0; adc < creditCardNumbers.length; adc++)
					{
						sum += creditCardNumbers[adc];
					}
				
				if(sum % 10 == 0)
					{
						System.out.println("Your card is valid");
					}
				else
					{
						System.out.println("Your card is not valid. Good-bye.");
					}
			}
		
			

		private static void countValidCard()
			{
				int sum = 0;
				
				for (long vc : creditCardNumbers)
					{
						sum += (int)vc;
					}
				if(sum % 10 == 0)
					{
						counter++;
					}
			}
		
		
	}
