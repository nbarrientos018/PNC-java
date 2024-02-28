import java.util.Scanner;
public class arrayExercise {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean rerun = true;
		while (rerun) {
			int size, occuringNum = 0, element = 0;
			
			System.out.print("Enter size of array: ");
			size = scan.nextInt();
			
			int [] arrayN = new int [size];
			System.out.println();
		
			for (int index = 0; index < arrayN.length; index++) {
				System.out.print("Enter array #" + (index + 1) + ": ");
				arrayN[index] = scan.nextInt();
			}
			System.out.println("Array numbers are: ");
			for (int index = 0; index < arrayN.length; index++){
				System.out.print("[" + arrayN[index] + "]" + " ");
			}
			for (int index = 0; index < arrayN.length; index++) {
				int count = 1;
				for (int indexTwo = index + 1; indexTwo < arrayN.length; indexTwo++ ) {
					if (arrayN[index] == arrayN[indexTwo]) {
						count++;
					}
				}
				if (occuringNum < count) {
					occuringNum = count;
					element = arrayN[index];
				}
			}
			System.out.println("\nThis number is most occuring number: " + element);
			
          	System.out.println("Do you want to do it again? Y/N");
          	char ans = scan.next().charAt(0);
          
          	if(ans == 'y' || ans == 'Y'){
              rerun = true;
              System.out.println("RESTART!!");
            } else if (ans == 'N' || ans == 'n'){
              rerun = false;
            }
          
		}	
	}
}
