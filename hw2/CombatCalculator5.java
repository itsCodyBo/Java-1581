//Top statement: determine the outcome of player's actions in combat against a monster

//Import Scanner
import java.util.Scanner;

//combat calculator 5

public class CombatCalculator5
{
	public static void main(String[] args)
	{
		//Declare variable for user input and initialize with a new Scanner object
		Scanner input = new Scanner(System.in);
		int player_choice;

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
		System.out.printf("%nYou are fighting a %s! %n", monster_name);
		//Print the Monster's Health
		System.out.printf("The monster's HP is: %s %n", monster_health);
		//Print the Hero's health
		System.out.printf("Your HP: %s %n", hero_health);
		//Print the Hero's Magic Power
		System.out.printf("Your MP: %s %n", hero_mp);

		/*Combat Menu Prompt*/
		System.out.printf("%nCombat Options:%n");
		//Print option 1: Sword Attack
		System.out.println("Option 1: Sword Attack");
		//Print option 2: Cast Spell
		System.out.println("Option 2: Cast Spell");
		//Print option 3: Charge Mana
		System.out.println("Option 3: Charge Mana");
		//Print option 4: Run Away
		System.out.println("Option 4: Run Away");
		
		//Prompt player for action by re-assigning first_choice to as player input
		System.out.print("What action do you want to perform? ");
		
		//Declar variable for user input (as number) and acquire value from scanner object
		player_choice = input.nextInt();

		//If player chose option 1, (check with equality operator)
		if (player_choice == 1)
		{
			//calculate damage and update monster health using subtraction
			//Calculation: monster_health - hero_ap
			monster_health = monster_health - hero_ap;
			//print attack text
			System.out.printf("%nYou strike the %s with your sword for %s damage %n",monster_name,hero_ap);
		}
		//Else if player chose option 2,
		else if (player_choice == 2)
		{
			//Calculate the damage and update monster health using division
			//Calculation: monster_health/2
			monster_health = monster_health/2;
			//print spell message:
			System.out.println("You cast the weaken spell on the monster");
		} 
		//Else if player chose option 3,
		else if (player_choice == 3)
		{
			//Increment magic points and update players magic using addition
			//Calculation: new hero magic is older hero magic plus one
			hero_mp = hero_mp +1;
			//print charging message
			System.out.println("You focus and charge your magic power");
		}
		//Else if player chose option 4,
		else if (player_choice == 4)
		{
			//print retreat message
			System.out.println("You run away!");
		}
		//Else the player chose incorrectly
		else
		{
			//print an error message
			System.out.println("I don't understand that command");
		}

		//test for hero_health,hero_mp, hero_ap, monster_health, monster_ap
		System.out.println("This is a test I implemented to make sure the program's math was correct. It was deleted in the following iterations-->");
		System.out.printf("%n-Hero Health:%s%n-Hero MP:%s%n-Hero AP:%s%n-Monster Health:%s%n-Monster AP:%s%n",hero_health,hero_mp,hero_ap,monster_health,monster_ap);

	}

}