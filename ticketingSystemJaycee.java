import java.util.Scanner;
public class ticketBooth {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// initializing the seat plan
        final int rows = 3; // fix value of rows
        int cols;
        char[][] seats;

        System.out.print("Enter number of columns: ");
        cols = scanner.nextInt();

        seats = new char[rows][cols];

        // initializing the seat letters for occupying seats
        char seatLetter = 'A'; // Initializing the seat into letter to understand precisely the seat plan

        for (int index = 0; index < seats.length; index++) {
            for (int indexTwo = 0; indexTwo < seats[index].length; indexTwo++) {
                seats[index][indexTwo] = seatLetter++;
            }
            seatLetter = 'A'; // reset the seat letter for next row
        }

        int totalSales = 0;
        boolean[][] occupiedSeats = new boolean[rows][cols];

        int choice;

        //Main Menu
        do { 
            System.out.println("\nMENU:");
            System.out.println("1. Assign seats");
            System.out.println("2. Exit");
            System.out.print("\nYour choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSEAT PLAN:");
                    System.out.println("Row #1 = VIP (1000 each)");
                    System.out.println("Row #2 = PATRON (500 each)");
                    System.out.println("Row #3 = GENERAL ADMISSION (200 each)");
                    System.out.println();
                    for (int index = 0; index < seats.length; index++) {
                        System.out.print((index + 1) + "  ");
                        for (int indexTwo = 0; indexTwo < seats[index].length; indexTwo++) {
                            if (occupiedSeats[index][indexTwo]) {
                                System.out.print("X  ");
                            } else {
                                System.out.print(seats[index][indexTwo] + "  ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.print("\nEnter seat (e.g. 3A, 2A): ");
                    String seatInput = scanner.next().toUpperCase();
                    int row = seatInput.charAt(0) - '1'; // converting row number
                    int col = seatInput.charAt(1) - 'A'; // converting column letter

                    if (row >= 0 && row < rows && col >= 0 && col < cols) {
                        if (!occupiedSeats[row][col]) {
                            occupiedSeats[row][col] = true;
                            int tickPrice = getTickPrice(row); // getting price of tickets into method named "getTickPrice"
                            totalSales += tickPrice; // calculating
                            System.out.println("The seat is successfully booked!");
                            System.out.println("Total price: " + tickPrice );
                        } else {
                            System.out.println("The seat is already taken! Please choose another seat ");
                        }
                    } else {
                        System.out.println("Invalid seat! Please choose a valid seat (e.g. 3A, 2A)");
                    }
                    break;

                case 2:
                    System.out.println("END OF THE PROGRAM");
                    System.out.println("\nTotal sales:" + totalSales);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 2); // the program should loop unless this statement will be true
    }

    
    // method for the prices of the tickets
    private static int getTickPrice(int row) {
        switch (row) {
            case 0: // row index 0 price
                return 1000; // VIP
            case 1: // row index 1 price
                return 500; // Patron
            case 2: // row index 2 price
                return 200; // General Admission
            default:
                return 0;
        }
    }
}

	


