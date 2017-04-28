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
		this.north=north;
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