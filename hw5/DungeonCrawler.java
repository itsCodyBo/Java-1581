import java.util.Scanner;

public class DungeonCrawler {
	public static void main(String[] args) {
		//test print
		System.out.println("test");
		DungeonCrawler dungeonCrawler = new DungeonCrawler();
		Dungeon dungeon = dungeonCrawler.new Dungeon();
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
			int userInput = sc.nextInt();

			if (userInput==1){
				if (currentRoom.getNorth()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end if
				else{
					currentRoom = currentRoom.getNorth();
				}//end else
			}//end first if userInput==1
			else if (userInput==2) {
				if (currentRoom.getSouth()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end userInput==2 if
				else {
					currentRoom=currentRoom.getSouth();
				}//end userInput==2 else	
			}//end first elif userInput ==2
			else if (userInput ==3){
				if (currentRoom.getEast()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end third userinput==3 if
				else {
					currentRoom=currentRoom.getEast();
				}//end userInput==3 else
			}//end third elif userInput ==3
			else if (userInput==4){
				if (currentRoom.getWest()==null){
					System.out.println("\nNo valid Exit, choose again\n");
				}//end fourth if
				else{
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

public class Room {
	//instance variables we will need
	private String description;
	private Room north;
	private Room south;
	private Room east;
	private Room west;

	//constructor
	public Room(String description) {
		//set the description
		this.description = description;


	}//end constructor

	public void setNorth(Room north) {
		this.north = north;
	}//end set north

	public void setSouth(Room south) {
		this.south=south;
	}//end set south
	public void setEast(Room east){
		this.east=east;
	}//set east
	public void setWest(Room west){
		this.west=west;
	}//end set west

	public void setExits(Room north, Room south ,Room east, Room west){
		this.north = north;
		this.south=south;
		this.east=east;
		this.west=west;
	}//end setExits

	public Room getNorth() {
		return this.north;
	}//end get north
	public Room getSouth(){
		return this.south;
	}//end getSouth
	public Room getEast(){
		return this.east;
	}//end getEast
	public Room getWest(){
		return this.west;
	}//end getWest

	public String getDescription(){
		return this.description;
	}//end getDescription

	public String getExits(){
		return "North:"+north.toString()+"South:"+south.toString()+"East:"+east.toString()+"West:"+west.toString();
	}//end getExits

	@Override
    public String toString(){
      return "Current Room: "+getDescription()+
             "\nExits: "+getExits()+"\n";
    }//end toString method


}//end public class Room

public class Dungeon {
	//create cell 1 and its exits
	private Room cellOne = new Room("cell one");
	private Room cellTwo = new Room("cell two");
	private Room cellThree = new Room("cell three");
	private Room cellFour = new Room("cell four");
	private Room guardHouse = new Room("guard house");
	private Room northHall = new Room("north hall");
	private Room southHall = new Room("balcony");

	public Dungeon() {
		cellOne.setExits(null,null,northHall,null);
		cellTwo.setExits(null,null,southHall,null);
		cellThree.setExits(null,null,null,northHall);
		cellFour.setExits(null,null,null,southHall);
		guardHouse.setExits(null,northHall,null,null);
		northHall.setExits(guardHouse,southHall,cellThree,cellOne);
		southHall.setExits(northHall,null,cellFour,cellTwo);
	}//end Dungeon constructor

	public Room getRoom0(){
		return cellOne;
	}//end getRoom0

}//end public class Dungeon


}//end main class DungeonCrawler