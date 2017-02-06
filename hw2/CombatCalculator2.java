//Top statement: determine the outcome of player's actions in combat against a monster

public class CombatCalculator2 
{
	public static void main(String[] args)
	{
		/*Monster data variables*/
		//Declare variable for monster's name and intialize it to "goblin"
		String monster_name = "goblin";
		//Declare variable for monster's health and initialize it to 100
		int monster_health = 100;
		//Declare variable for monster's attack power and initialize it to 15
		int monster_ap = 15;

		/*Hero data variables*/
		//Declare variable for Hero's health and initialize it t0 100
		int hero_health = 100;
		//Declare variable for Hero's attack power and initialize it to 12
		int hero_ap = 12;
		//Declare variable for Hero's magic power and initialize it to 0
		int hero_mp = 0;

		/*Report Combat Stats*/
		//Print the Monster's name
		System.out.printf("you are fighting a %s! %n", monster_name);
		//Print the Monster's Health
		System.out.printf("The monster's HP is: %s %n", monster_health);
		//Print the Hero's health
		System.out.printf("Your HP: %s %n", hero_health);
		//Print the Hero's Magic Power
		System.out.printf("Your MP: %s %n", hero_mp);
	}

}