import java.util.Random;

public class Monster extends NewCharacter {

	int xp=25;
	Random rand = new Random();

	public Monster(String name, int health, int attackPower,int xp){
		super(name,health,attackPower);
	}//end constructor

	public void attack(Player thePlayer){ 
		int chanceHit = rand.nextInt(100)+1;
		if (chanceHit >= 80){
			System.out.println("\n###The monster missed!");
		}
		else {
			thePlayer.takeDamage(super.getAttackPower());
			System.out.println("\n###The monster attacked!");
		}
	}//end attack




}//end NewCharacter class