import java.util.Arrays;
import java.util.Scanner;





public class TextMap {
	
	//named constant numer-of-rooms
	int numberOfrooms=6;

	//set control variable
	static int controlVar = 1;

	//Named constants for directions
	static int north = 0;
	static int south = 1;
	static int east=2;
	static int west = 3;

	
	//first, create a string array for the room descriptions. Only one dimension
	static String[] roomQuote = {"North Hallway","Cell 1","Cell 2","Cell 3","Cell 4","Guard House","South Hallway, Exit to the South"};
	
	//next, create a multi-dimensional array in java for our room exits
	static int[][] roomExits = {
			{5,6,3,1},
			{-1,-1,0,-1},
			{-1,-1,0,-1},
			{-1,-1,-1,0},
			{-1,-1,-1,0},
			{-1,0,-1,-1},
			{0,-2,4,2}
	};//end multi-dimensional roomExits array

	//player starts in cell 1
	static String currentPlayerLocation = roomQuote[0];
	static int locationIndexNumber = 0;



	public static void main (String[] args) {


		while (controlVar != 0) {
			//print the current player location
			System.out.printf("%nYou are currently in %s%n",currentPlayerLocation);

			//Get user input on direction
			System.out.printf("%nWhat direction do you want to go? Type North, South, East or West (Type q to quit)%n");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			boolean hasKey = false;
			int returnedNumber =0;

			if (input.equalsIgnoreCase("q")) {
				System.out.println("You choose to quit");
				controlVar = 0;
			}//end first if statement
			
			else if (input.equalsIgnoreCase("north")) {
				returnedNumber = roomExits[locationIndexNumber][north];
				if(returnedNumber==-1){
					System.out.println("There is no door in that direction");
				}// end first sub if statement
				else {
					currentPlayerLocation=roomQuote[returnedNumber];
					locationIndexNumber = returnedNumber;
					System.out.printf("%nYou moved to %s%n", roomQuote[returnedNumber]);
				}//end first sub else
			}//end first elif north if statement
			
			else if (input.equalsIgnoreCase("south")) {
				returnedNumber = roomExits[locationIndexNumber][south];
				if(returnedNumber==-1){
					System.out.println("There is no door in that direction");
				}// end first sub if statement
				else if(returnedNumber==-2){
					
						System.out.println("You used the key and exited the jail!");
						controlVar=0;
					}//end else if 
				else {
					currentPlayerLocation=roomQuote[returnedNumber];
					locationIndexNumber = returnedNumber;
					System.out.printf("You moved to %s%n", roomQuote[returnedNumber]);
				}//end second sub else
			}//end second(south) elif if statement
			
			else if (input.equalsIgnoreCase("east")) {
				returnedNumber = roomExits[locationIndexNumber][east];
				if(returnedNumber==-1){
					System.out.println("There is no door in that direction");
				}// end third sub if statement
				else {
					currentPlayerLocation=roomQuote[returnedNumber];
					locationIndexNumber = returnedNumber;
					System.out.printf("%nYou moved to %s%n", roomQuote[returnedNumber]);
				}//end third sub else
			}//end third elif (east) if statement
			
			else if (input.equalsIgnoreCase("west")) {
				returnedNumber = roomExits[locationIndexNumber][west];
				if(returnedNumber==-1){
					System.out.println("There is no door in that direction");
				}// end fourth sub if statement
				else {
					currentPlayerLocation=roomQuote[returnedNumber];
					locationIndexNumber = returnedNumber;
					System.out.printf("%nYou moved to %s%n", roomQuote[returnedNumber]);
				}//end fourth sub else
			}//end fourth elif (west) if statement
			
			else {
				System.out.println("Error - incorrect input homeboy (Or girl. We don't discriminate.");
			}//end else exception handling
		}//end while loop

	}//end main method
}//end TextMap method