public class NewCharacter{
	private String name;
	private int health;
	private int attackPower;

	public NewCharacter(String name,int health,int attackPower){
		this.name = name;
		this.health=health;
		this.attackPower=attackPower;
	}//end newCharacter constructor

	public int takeDamage(int damage){
		this.health = this.health - damage;
		return health;
	}//end takeDamage

	public String getName(){
		return this.name;
	}//end getName

	public int getAttackPower(){
		return this.attackPower;
	}//end getAttackPower

	public int getHealth(){
		return this.health;
	}//end get health

	public void setHealth(int newHealth){
		this.health=this.health+newHealth;
	}//end set health

	@Override
    public String toString(){
      return "Name: " + this.name + "Health: "+this.health + "AP: " + this.attackPower;
    }//end toString method
}//end public class newCharacter