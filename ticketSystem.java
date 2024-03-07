import java.util.Scanner;

public class ticketSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int column = 0, seatType, seatCol, totalSale = 0, currentTotal = 0, totalTicketCount = 0;
		boolean progCycle = true;

		System.out.print("Enter column number: ");
		column = scan.nextInt();

		int[][] seatArray = new int[3][column];

		while (progCycle) {

//			if (stopCounter == 3 * column) {
//				System.out.println("Sorry, no more tickets available!");
//				System.out.println("Total sale for today: " + totalSale);
//				progCycle = false;
//			}

			// general menu display
			System.out.println("WELCOME! TICKET RESERVATION");
			System.out.println("TYPE OF SEAT / TICKET PRICE");
			System.out.println("     VIP           1000    ");
			System.out.println("   PATRON          500     ");
			System.out.println(" GENERAL AD        200     \n");

			// display of the array of seats
			System.out.println("\n SEATS MARKED WITH X IS OCCUPIED!! \n");
			for (int row = 0; row < 3; row++) {
				if (row == 0) {
					System.out.println("VIP SEATS");
				} else if (row == 1) {
					System.out.println("PATRON SEATS");
				} else if (row == 2) {
					System.out.println("GENERAL ADMISSION SEATS");
				}

				// determines if the cell is occupied or not
				for (int col = 0; col < seatArray[row].length; col++) {
					if (seatArray[row][col] == 1) {
						System.out.print("[   occupied   ]");
					} else {
						System.out.print("[  available!  ]");
					}
				}
				System.out.println();
			}
			System.out.print("How many tickets do you wanna buy?");
			int ticketCount = scan.nextInt();

			while (ticketCount != 0) {
//				// seat input
//				
				System.out.println();

				System.out.println("Select type:\n 1 = VIP \n 2 = PATRON \n 3 = GENERAL ADMISSION ");
				seatType = scan.nextInt();
				
				//pricing
				if (seatType == 1) {
					totalSale += 1000;
					currentTotal += 1000;
				} else if (seatType == 2) {
					totalSale += 500;
					currentTotal += 500;
				} else if (seatType == 3) {
					totalSale += 200;
					currentTotal += 200;
				}

				//display
				for (int row = 0; row < 3; row++) {
					if (row == 0) {
						System.out.println("VIP SEATS");
					} else if (row == 1) {
						System.out.println("PATRON SEATS");
					} else if (row == 2) {
						System.out.println("GENERAL ADMISSION SEATS");
					}

					// determines if the cell is occupied or not
					for (int col = 0; col < seatArray[row].length; col++) {
						if (seatArray[row][col] == 1) {
							System.out.print("[   occupied   ]");
						} else {
							System.out.print("[  available!  ]");
						}
						
					}
				}

				System.out.println();
				System.out.println("Select seat number: ");
				seatCol = scan.nextInt();

				seatArray[seatType - 1][seatCol - 1] = 1;
				totalTicketCount++;
				// redisplay of the seats of array now marked with X when seat is occupied

				ticketCount--;

			}
				System.out.println("Your total amount is: " + currentTotal);
				if (totalTicketCount < 3 * column) {
					System.out.println("\n\n Would you like to buy another seat? Y/N");
					char buyAgain = scan.next().charAt(0);
					if (buyAgain == 'y' || buyAgain == 'Y') {
						progCycle = true;
					} else if (buyAgain == 'n' || buyAgain == 'N') {
						System.out.println("Your total amount is " + currentTotal);
						currentTotal = 0;
						if (totalTicketCount >= 3 * column) {
							progCycle = false;
						} else {
							continue;
						}
					}
				} else {
					System.out.println("Total earnings " + totalSale);
				}
//
//			for (int row = 0; row < 3; row++) {
//				for (int col = 0; col < seatArray[row].length-1; col++) {
//					stopCounter += seatArray[row][column];
//				}
//			}

			}

		}

	}
}
