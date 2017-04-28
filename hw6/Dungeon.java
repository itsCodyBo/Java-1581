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