import java.util.Scanner;

public class Player extends NewCharacter {

	private int mana=50;
	private int xp=0;
	Scanner reader = new Scanner(System.in);


	//constructor
	public Player(String name, int health, int attackPower, int mana) {
		super(name, health, attackPower);
	
	}//end Player constructor


	public void attack(Monster theMonster){ 
		theMonster.takeDamage(super.getAttackPower());
	}//end attack

	public void castSpell(Monster theMonster){
		if (mana>=50){
			System.out.println("\n###You cast a spell! The Monster's HP was cut in Half!");
			mana = mana - 50;
			theMonster.takeDamage(theMonster.getHealth()/2);
		}//end mana if
		else{
			System.out.println("You don't have enough mana :(");
		}
	}

	public void chargeMana(){
		mana = mana + 25;
	}//end chargeMana

	public int getMana(){
		return mana;
	}//end getMana

	public int getXp(){
		return xp;
	}

	public void setXp(int xp){
		int level = 1;
		xp = this.xp + xp;
		if (xp >= 100){
			level = level +1;
			xp =0;
			System.out.printf("\nCongrats! You leveled up to %s",level);
		}
		else{
			System.out.printf("\nXP increased to %s",xp);
		}
	}//end set xp

	public void takeTurn(Monster theMonster){
		System.out.println("\nEnter a number: ");
		int userChoice = reader.nextInt();
		
		if (userChoice == 1){
			System.out.println("\n###You attacked the monster!");
			theMonster.takeDamage(super.getAttackPower());
		}//end userChoice 1
		else if (userChoice == 2){
			castSpell(theMonster);
		}//end userChoice 2
		else if (userChoice==3){
			mana = mana +25;
			System.out.printf("\n###You increased your mana by +25!!!",mana);
		}//end userChoice 3
		else if (userChoice == 4) {
			boolean userEndGame=true;
		}//end userChoice 4
		else{
			System.out.println("()()()()()()()Not a valid choice");
		}



		System.out.printf("\nYour health is %s\nYour mana is %s\nYour XP is %s\n***End round***",super.getHealth(),mana,xp);
	}//end TakeTurn


}//end public class player