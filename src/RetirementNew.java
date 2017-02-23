//Justin Schnee/Kevin Castro Lab Sec 22

import java.util.Scanner; // Utility to accept input from user
public class RetirementNew {

 
	public static void main(String [] args) {
		// Declare variables
		double requiredMonthlyIncome, monthlySSI, monthlySavingsWorking;
		double savingsMonthlyIncome, neededSavings, annualInterestRetired;
		double monthlyInterest, annualInterestWorking;
		int yearsRetired, yearsWorking, monthsRetired, monthsWorking;
		
		// Declare constants
		final int MONTHSPERYEAR = 12;
		final double ONE = 1.0;
		
		// Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		// Prompt user for variables needed to compute total savings amount
		System.out.print("Enter number of years in retirement: ");
		yearsRetired = input.nextInt();
		
		System.out.print("Enter annual percentage rate " +
		                 "expected during retirement: ");
		annualInterestRetired = input.nextDouble();
		
		while(annualInterestRetired>3||annualInterestRetired<0)
		{
			System.out.print("Please enter number between 0 and 3 ");
				annualInterestRetired = input.nextDouble();
		}
		
		System.out.print("Enter expected monthly Social Security Income (SSI): ");
		monthlySSI = input.nextDouble();
		
		
		System.out.print("Enter desired retirement monthly income: ");
		requiredMonthlyIncome = input.nextDouble();
		
		// Compute total savings amount needed => neededSavings
		monthlyInterest = (annualInterestRetired / 100.0)/ MONTHSPERYEAR;
		monthsRetired = MONTHSPERYEAR * yearsRetired;
		savingsMonthlyIncome = requiredMonthlyIncome - monthlySSI;
		neededSavings = (savingsMonthlyIncome / monthlyInterest) *
				(ONE - ONE / Math.pow((ONE + monthlyInterest), monthsRetired));
		
		// Prompt user for variables needed to compute monthly savings amount

		System.out.print("Enter number of working years before retirement: ");
		yearsWorking = input.nextInt();
		
		
		System.out.print("Enter annual percentage rate expected while working: ");
		annualInterestWorking = input.nextDouble();
		
		while(annualInterestWorking>20||annualInterestWorking<0)
		{
			System.out.print("Please enter a number between 0 and 20 ");
			annualInterestWorking = input.nextDouble();
		}
		
		// Compute monthly savings amount => monthlySavings
		monthlyInterest = (annualInterestWorking / 100.0) / MONTHSPERYEAR;
		monthsWorking = MONTHSPERYEAR * yearsWorking;
		monthlySavingsWorking = (neededSavings * monthlyInterest) / 
				(Math.pow((ONE + monthlyInterest), monthsWorking) - ONE);
		
		// Display results
		System.out.println(" ");
		System.out.println("Save Each Month: $" +
		        (int)(monthlySavingsWorking * 100) / 100.0);
		System.out.println("Years to Work: " + yearsWorking);
		System.out.println("Annual Return: " + annualInterestWorking);
		System.out.println(" ");
		System.out.println("What you need saved: " + 
				(int)(neededSavings * 100) / 100.0);
		System.out.println(" ");
		System.out.println("Years Retired: " + yearsRetired);
		System.out.println("Annual Return: " + annualInterestRetired);
		System.out.println("Required Income: " + 
		        (int)(requiredMonthlyIncome * 100) / 100.0);
		System.out.println("Monthly SSI: " + (int)(monthlySSI * 100) / 100.0);
   
	}

}
