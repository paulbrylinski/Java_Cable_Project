//AUTHOR: Paul Brylinski
//PURPOSE: This program is set up for a cable company to charge
//the correct prices based on customer plan and payment choices.

package com.github.brylinski;

import java.util.Scanner;

public class BrylinskiMainClass
{

	// Constants
	public static final String PLAN_NAME_A = "EcoPlan (45+ channels)";
	public static final String PLAN_NAME_B = "DigitalPlan (140+ channels)";
	public static final String PLAN_NAME_C = "HDPlan (220+ channels)";
	public static final String PLAN_NAME_QUIT = "Quit";
	public static final double PLAN_PRICE_A = 19.99;
	public static final double PLAN_PRICE_B = 49.99;
	public static final double PLAN_PRICE_C = 59.99;
	public static final String UPGRADE_NAME_A = "High Speed Internet (75 Mbps)";
	public static final String UPGRADE_NAME_B = "Voice Over IP (75 Mbps)";
	public static final String UPGRADE_NAME_C = "All additional options";
	public static final String UPGRADE_NAME_D = "No Upgraded options";
	public static final double UPGRADE_PRICE_A = 24.99;
	public static final double UPGRADE_PRICE_B = 34.99;
	public static final double UPGRADE_PRICE_C = 59.98;
	public static final double UPGRADE_PRICE_D = 0.00;
	public static final String PAYMENT_NAME_A = "Credit Card";
	public static final String PAYMENT_NAME_B = "Debit Card";
	public static final String PAYMENT_NAME_C = "Cash";
	public static final double PAYMENT_FEE_A = 0.03;
	public static final double PAYMENT_FEE_B = 0.02;
	public static final double PAYMENT_FEE_C = 0.0;

	public static void main(String[] args)

	{

		// Introduction Scanner
		Scanner input = new Scanner(System.in);

		// Declaration and Initialization Statements
		String userName = "";
		char planSelection = ' ';
		char upgradeSelection = ' ';
		char paymentSelection = ' ';
		String planName = "";
		String upgradeName = "";
		String paymentName = "";
		double planCost = 0.0;
		double upgradeCost = 0.0;
		double paymentFee = 0.0;
		double paymentFeeAmount = 0.0;
		double orderTotal = 0.0;
		int planCountA = 0;
		int planCountB = 0;
		int planCountC = 0;
		int upgradeCountA = 0;
		int upgradeCountB = 0;
		int upgradeCountC = 0;
		int upgradeCountD = 0;
		int paymentTypeCountA = 0;
		int paymentTypeCountB = 0;
		int paymentTypeCountC = 0;
		int totalCountSales = 0;
		double grandTotalSales = 0.0;

		displayWelcomeBanner();

		// Prime read of userName
		userName = getUserName(input);

		// Prime Read of planSelection
		planSelection = validatePlanSelection(input);

		while (planSelection != 'Q') 
		{// open validate
			upgradeSelection = validateUpgradeSelection(input);
			paymentSelection = validatePaymentSelection(input);

			// PROCESS SELECTION
			if (planSelection == 'A') 
			{
				planName = PLAN_NAME_A;
				planCost = PLAN_PRICE_A;
				planCountA++;
			}
			else if (planSelection == 'B') 
			{
				planName = PLAN_NAME_B;
				planCost = PLAN_PRICE_B;
				planCountB++;
			}
			else 
			{
				planName = PLAN_NAME_C;
				planCost = PLAN_PRICE_B;
				planCountC++;
			}

			if (upgradeSelection == 'A') 
			{
				upgradeName = UPGRADE_NAME_A;
				upgradeCost = UPGRADE_PRICE_A;
				upgradeCountA++;
			}
			else if (upgradeSelection == 'B') 
			{
				upgradeName = UPGRADE_NAME_B;
				upgradeCost = UPGRADE_PRICE_B;
				upgradeCountB++;
			}
			else if (upgradeSelection == 'C') 
			{
				upgradeName = UPGRADE_NAME_C;
				upgradeCost = UPGRADE_PRICE_C;
				upgradeCountC++;
			}
			else 
			{
				upgradeName = UPGRADE_NAME_D;
				upgradeCost = UPGRADE_PRICE_D;
				upgradeCountD++;
			}

			// PROCESS SELECTION

			if (paymentSelection == 'A') 
			{
				paymentName = PAYMENT_NAME_A;
				paymentFee = PAYMENT_FEE_A;
				paymentTypeCountA++;
			}
			else if (paymentSelection == 'B') 
			{
				paymentName = PAYMENT_NAME_B;
				paymentFee = PAYMENT_FEE_B;
				paymentTypeCountB++;
			}
			else 
			{
				paymentName = PAYMENT_NAME_C;
				paymentFee = PAYMENT_FEE_C;
				paymentTypeCountC++;
			}

			// Rest of Process
			paymentFeeAmount = (planCost + upgradeCost) * paymentFee;
			orderTotal = planCost + upgradeCost + paymentFeeAmount;
			totalCountSales++;
			grandTotalSales = totalCountSales * orderTotal;

			displayOrderReport(planName, planCost, upgradeName, upgradeCost, paymentName, paymentFee, paymentFeeAmount,
					orderTotal);

			// update read of planSelection
			planSelection = validatePlanSelection(input);

		} // end of validate statements

		// if statement for planCounter
		if (totalCountSales > 0) 
		{

			displayFinalReport(userName, planCountA, planCountB, planCountC, upgradeCountA, upgradeCountB,
					upgradeCountC, upgradeCountD, paymentTypeCountA, paymentTypeCountB, paymentTypeCountC,
					totalCountSales, grandTotalSales);
		}

		displayFarewellBanner();

		// Close Scanner
		input.close();

	}// end of main class

	public static void displayWelcomeBanner() 
	{
		System.out.println("Welcome to the plan selection tool.");
		System.out.println("This program allows the ablity to pick cable and internet");
		System.out.println("plans and keep up with all counts & total sales.");
	}

	public static void displayFarewellBanner() 
	{
		System.out.printf("Thanks For Using the plan selection tool.\n");
		System.out.printf("As always, we appreciate your business!\n");
		System.out.printf("Visit Our Website at www.bettercableandinternet.com\n");
	}

	public static void displayPlanMenu() 
	{// begin plan menu
		System.out.printf("-------------------------------------------------------\n");
		System.out.printf("MAIN MENU\n");
		System.out.printf("%-6s%-40s%-1s%5.2f\n", "[A]", PLAN_NAME_A, "$", PLAN_PRICE_A);
		System.out.printf("%-6s%-40s%-1s%5.2f\n", "[B]", PLAN_NAME_B, "$", PLAN_PRICE_B);
		System.out.printf("%-6s%-40s%-1s%5.2f\n", "[C]", PLAN_NAME_C, "$", PLAN_PRICE_C);
		System.out.printf("%-6s%2s\n", "[Q]", PLAN_NAME_QUIT);
		System.out.printf("-------------------------------------------------------\n");
		System.out.print("Enter Your Selection Here: ");
	}

	public static void displayUpgradeMenu() 
	{
		System.out.printf("-------------------------------------------------------\n");
		System.out.printf("UPGRADE MENU\n");
		System.out.printf("%-6s%-38s%-1s%7.2f\n", "[A]", UPGRADE_NAME_A, "$", UPGRADE_PRICE_A);
		System.out.printf("%-6s%-38s%-1s%7.2f\n", "[B]", UPGRADE_NAME_B, "$", UPGRADE_PRICE_B);
		System.out.printf("%-6s%-38s%-1s%7.2f\n", "[C]", UPGRADE_NAME_C, "$", UPGRADE_PRICE_C);
		System.out.printf("%-6s%-38s%-1s%7.2f\n", "[D]", UPGRADE_NAME_D, "$", UPGRADE_PRICE_D);
		System.out.printf("-------------------------------------------------------\n");

		System.out.print("Enter Your Selection Here: ");
	}

	public static void displayPaymentMenu() 
	{
		System.out.printf("-------------------------------------------------------\n");
		System.out.printf("TRANSPORTATION MENU\n");
		System.out.printf("%-6s%-35s%2s%4.1f%6s\n", "[A]", PAYMENT_NAME_A, "@", PAYMENT_FEE_A * 100, "% Fee");
		System.out.printf("%-6s%-35s%2s%4.1f%6s\n", "[B]", PAYMENT_NAME_B, "@", PAYMENT_FEE_B * 100, "% Fee");
		System.out.printf("%-6s%-35s%2s%4.1f%6s\n", "[C]", PAYMENT_NAME_C, "@", PAYMENT_FEE_C * 100, "% Fee");
		System.out.printf("-------------------------------------------------------\n");

		System.out.print("Enter Your Selection Here: ");
	}// end menu

	public static void displayOrderReport(String borrowedplanName, double borrowedPlanCost, String borrowedUpgradeName,
			double borrowedUpgradeCost, String borrowedPaymentName, double borrowedPaymentFee,
			double borrowedPaymentFeeAmount, double borrowedOrderTotal) 
	{// begin order report

		// OUTPUT
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("ORDER REPORT\n");
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-25s%1s\n", "Selection Name:", borrowedplanName);
		System.out.printf("%-25s%1s%8.2f\n", "Price:", "$", borrowedPlanCost);
		System.out.println();
		System.out.printf("%-25s%1s\n", "Upgrade Name:", borrowedUpgradeName);
		System.out.printf("%-25s%1s%8.2f\n", "Upgrade Price:", "$", borrowedUpgradeCost);
		System.out.println();
		System.out.printf("%-25s%1s\n", "Payment Type Name:", borrowedPaymentName);
		System.out.printf("%-25s%1s%7.1f%1s\n", "Payment Fee Rate:", "", borrowedPaymentFee * 100, "%");
		System.out.printf("%-25s%1s%8.2f\n", "Payment Fee Amount:", "$", borrowedPaymentFeeAmount);
		System.out.println();
		System.out.printf("%-25s%1s%8.2f\n", "Order total:", "$", borrowedOrderTotal);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
	}

	// finalReport Menu
	public static void displayFinalReport(String borrowedUserName, int borrowedPlanCountA, int borrowedPlanCountB,
			int borrowedPlanCountC, int borrowedUpgradeCountA, int borrowedUpgradeCountB, int borrowedUpgradeCountC,
			int borrowedUpgradeCountD, int borrowedPaymentTypeCountA, int borrowedPaymentTypeCountB,
			int borrowedPaymentTypeCountC, int borrowedTotalCountSales, double borrowedGrandTotalSales) 
	{// begin final
																											// report

		// OUTPUT
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("FINAL REPORT\n");
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-30s%9s\n", "Traveler Name", borrowedUserName);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-30s\n", "Count of selections:");
		System.out.printf("%-30s%-1s%8s\n", PLAN_NAME_A, "", borrowedPlanCountA);
		System.out.printf("%-30s%-1s%8s\n", PLAN_NAME_B, "", borrowedPlanCountB);
		System.out.printf("%-30s%-1s%8s\n", PLAN_NAME_C, "", borrowedPlanCountC);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-30s\n", "Count of upgrades:");
		System.out.printf("%-30s%-1s%8s\n", UPGRADE_NAME_A, "", borrowedUpgradeCountA);
		System.out.printf("%-30s%-1s%8s\n", UPGRADE_NAME_B, "", borrowedUpgradeCountB);
		System.out.printf("%-30s%-1s%8s\n", UPGRADE_NAME_C, "", borrowedUpgradeCountC);
		System.out.printf("%-30s%-1s%8s\n", UPGRADE_NAME_D, "", borrowedUpgradeCountD);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-30s\n", "Count of payment types:");
		System.out.printf("%-30s%-1s%8s\n", PAYMENT_NAME_A, "", borrowedPaymentTypeCountA);
		System.out.printf("%-30s%-1s%8s\n", PAYMENT_NAME_B, "", borrowedPaymentTypeCountB);
		System.out.printf("%-30s%-1s%8s\n", PAYMENT_NAME_C, "", borrowedPaymentTypeCountC);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
		System.out.printf("%-30s%-1s%8s\n", "Total count of sales:", "", borrowedTotalCountSales);
		System.out.printf("%-30s%-1s%8.2f\n", "Grand total of sales:", "$", borrowedGrandTotalSales);
		System.out.printf("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
	}// end of final report

	// Begin VR Methods
	public static String getUserName(Scanner borrowedInput) 
	{
		System.out.print("Enter Your Username: ");
		return borrowedInput.nextLine();
	}// end userName VR method

	// VR method for planSelection
	public static char validatePlanSelection(Scanner borrowedInput) 
	{// scanner declared, opening planSelection
																
		char localSelection = ' ';
		displayPlanMenu();
		localSelection = borrowedInput.next().toUpperCase().charAt(0);

		// While
		while (localSelection != 'A' && localSelection != 'B' && localSelection != 'C' && localSelection != 'Q') 
		{
			// invalid selection - new loop
			System.out.printf("---- Invalid Selection ----\n");
			// update read
			displayPlanMenu();
			localSelection = borrowedInput.next().toUpperCase().charAt(0);
		}
		return localSelection;
	}// end of VR method

	// VR method for upgradeSelection
	public static char validateUpgradeSelection(Scanner borrowedInput) 
	{
		char localSelection = ' ';
		displayUpgradeMenu();
		localSelection = borrowedInput.next().toUpperCase().charAt(0);

		while (localSelection != 'A' && localSelection != 'B' && localSelection != 'C' && localSelection != 'D') 
		{

			// invalid selection - new loop
			System.out.printf("---- Invalid Selection ----\n");

			displayUpgradeMenu();
			localSelection = borrowedInput.next().toUpperCase().charAt(0);
		} // end while loop
		return localSelection;
	}// end of VR method

	// VR method for paymentSelection
	public static char validatePaymentSelection(Scanner borrowedInput) 
	{// scanner declared, opening paymentSelection
									
		char localSelection = ' ';
		displayPaymentMenu();
		localSelection = borrowedInput.next().toUpperCase().charAt(0);

		// While
		while (localSelection != 'A' && localSelection != 'B' && localSelection != 'C') 
		{// begin while curly brace

			// invalid selection - new loop
			System.out.printf("---- Invalid Selection ----\n");
			// update read
			displayPaymentMenu();
			localSelection = borrowedInput.next().toUpperCase().charAt(0);
		} // end while loop
		return localSelection;
	}// end of VR method

}
