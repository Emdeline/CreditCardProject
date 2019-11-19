import java.io.File;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreditCard

	{
		static long validCard = (long) 5424180123456789.;
		static long invalidCard = (long) 542418012345685.;
		
		static long[] creditCardNumbers = new long[16];
		
		static long card = validCard;
		static long inCard = invalidCard;
		
		public static void main(String[] args) throws IOException
			{
				Scanner file = new Scanner(new File("CreditCardNumbers"));

				strippingNumbers();
				doublingNumbers();
				originalDoubled();
				creditNumber = file.hasNextLong();
			}

		private static void strippingNumbers()
			{			
					for (int c = creditCardNumbers.length - 1; c >= 0; c--)
						{
							long endingDigit = card % 10;	
							card /= 10;
							
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
								long newDigg = (creditCardNumbers[dc] % 10) + (creditCardNumbers[dc] / 10);
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
		
		private static void readingCard()
			{
				
			}

	}
