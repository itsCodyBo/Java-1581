import java.util.Scanner;
import java.util.Random;

public class DungeonHero {
	public static void main(String[] args) {

		//instance of DungeonCrawler needed to create instance of dungeon
		//DungeonCrawler dungeonCrawler = new DungeonCrawler();
		//instance of dungeon
		Dungeon dungeon = new Dungeon();

		//initialize goblin and palyer1 classes
		Player player1 = new Player("hero",100,25,50);
		Monster goblin = new Monster("goblin",100,15,100);
		

		//set current room to getRoom0 method
		Room currentRoom = dungeon.getRoom0();
		boolean quitGame = false;



		while ( quitGame != true){

			//print current room
			System.out.println("*********You are in"+" "+ currentRoom.getDescription()+"*********");

			//print out all availble exits. how to do with getExits???
			if (currentRoom.getNorth() == null) {
				System.out.println("\n(-) No North Exit");
			}
			else{

				System.out.println("\n(1) Exit North ");
			}
			if (currentRoom.getSouth() == null) {
				System.out.println("\n(-)No South Exit");
			}
			else{
				System.out.println("\n(2) Exit South ");
			}
			if (currentRoom.getEast() == null) {
				System.out.println("\n(-) No East Exit");
			}
			else{
				System.out.println("\n(3) Exit East ");
			}
			if (currentRoom.getWest() ==null){
				System.out.println("\n(-) No West Exit");
			}
			else{
				System.out.println("\n(4) Exit West");
			}

			//prompt user to input direction or 0 to quit
			System.out.println("***INSTRUCTIONS: ****");
			System.out.println("\nEnter 1 for North, 2 for South, 3 for East, 4 for West or 0 to quit!\n");
			Scanner sc = new Scanner(System.in);
			Random rand = new Random();
			int userInput = sc.nextInt();

			if (userInput==1){
				if (currentRoom.getNorth()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end if
				else{
					int chanceEncounter = rand.nextInt(100)+1;
					if (chanceEncounter>=60){
						System.out.println("You encountered a goblin sauce!");
						while(player1.getHealth()>=0 && goblin.getHealth()>=0){
							player1.takeTurn(goblin);
							goblin.attack(player1);
							System.out.printf("\n**Your health is %s\n**Your mana is %s\n**Your XP is %s",player1.getHealth(),player1.getMana(),player1.getXp());
							System.out.printf("\nThe Monster's Health is %s",goblin.getHealth());

							if (player1.getHealth()<=0){
								System.out.println("\nYOU DIED!");
								quitGame=true;
							}//end player dies if statemnt
							else if (goblin.getHealth()<=0){
								System.out.println("\nCONGRATS YOU RECKED THAT DUDE !!!!!!!!");
							}//end goblin dies else if
						}//end while loop
					}//end chanceEncounter if
					currentRoom = currentRoom.getNorth();
				}//end else
			}//end first if userInput==1
			else if (userInput==2) {
				if (currentRoom.getSouth()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end userInput==2 if
				else {
					int chanceEncounter = rand.nextInt(100)+1;
					if (chanceEncounter>=60){
						System.out.println("You encountered a goblin sauce!");
						while(player1.getHealth()>=0 && goblin.getHealth()>=0){
							player1.takeTurn(goblin);
							goblin.attack(player1);
							System.out.printf("\n**Your health is %s\n**Your mana is %s\n**Your XP is %s",player1.getHealth(),player1.getMana(),player1.getXp());
							System.out.printf("\nThe Monster's Health is %s",goblin.getHealth());

							if (player1.getHealth()<=0){
								System.out.println("\nYOU DIED!");
								quitGame=true;
							}//end player dies if statemnt
							else if (goblin.getHealth()<=0){
								System.out.println("\nCONGRATS YOU RECKED THAT DUDE !!!!!!!!");
							}//end goblin dies else if
						}//end while loop
					}//end chanceEncounter if
					currentRoom=currentRoom.getSouth();
				}//end userInput==2 else	
			}//end first elif userInput ==2
			else if (userInput ==3){
				if (currentRoom.getEast()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end third userinput==3 if
				else {
					int chanceEncounter = rand.nextInt(100)+1;
					if (chanceEncounter>=60){
						System.out.println("You encountered a goblin sauce!");
						while(player1.getHealth()>=0 && goblin.getHealth()>=0){
							player1.takeTurn(goblin);
							goblin.attack(player1);
							System.out.printf("\n**Your health is %s\n**Your mana is %s\n**Your XP is %s",player1.getHealth(),player1.getMana(),player1.getXp());
							System.out.printf("\nThe Monster's Health is %s",goblin.getHealth());

							if (player1.getHealth()<=0){
								System.out.println("\nYOU DIED!");
								quitGame=true;
							}//end player dies if statemnt
							else if (goblin.getHealth()<=0){
								System.out.println("\nCONGRATS YOU RECKED THAT DUDE !!!!!!!!");
							}//end goblin dies else if
						}//end while loop
					}//end chanceEncounter if
					currentRoom=currentRoom.getEast();
				}//end userInput==3 else
			}//end third elif userInput ==3
			else if (userInput==4){
				if (currentRoom.getWest()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end fourth if
				else{
					int chanceEncounter = rand.nextInt(100)+1;
					if (chanceEncounter>=60){
						System.out.println("You encountered a goblin sauce!");
						while(player1.getHealth()>=0 && goblin.getHealth()>=0){
							player1.takeTurn(goblin);
							goblin.attack(player1);
							System.out.printf("\n**Your health is %s\n**Your mana is %s\n**Your XP is %s",player1.getHealth(),player1.getMana(),player1.getXp());
							System.out.printf("\nThe Monster's Health is %s",goblin.getHealth());

							if (player1.getHealth()<=0){
								System.out.println("\nYOU DIED!");
								quitGame=true;
							}//end player dies if statemnt
							else if (goblin.getHealth()<=0){
								System.out.println("\nCONGRATS YOU RECKED THAT DUDE !!!!!!!!");
							}//end goblin dies else if
						}//end while loop
					}//end chanceEncounter if
					currentRoom=currentRoom.getWest();
				}//end fourth else
			}//end fourth elif
			else if (userInput==0){
				System.out.println("Thanks for playing my game!!!");
				quitGame=true;
			}
			else {
				System.out.println("Not a valid input");
			}//end final else

		}//end while
	}//end main method


}//end main class DungeonCrawler
