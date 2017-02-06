//Top statement: determine the outcome of player's actions in combat against a monster

/*Please note: to modify the bonus, I have added a stipulation where, upon landing a succuessful sword attack on the goblin, the player is given
an extra magic point to play with at the end of the round. I have done this because without this advantage it is impossible to beat the goblin in one
on one combat */


//Import Scanner
import java.util.Scanner;

//combat calculator 8

public class CombatCalculatorBonus
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

		


		/*Loop Control*/
		//Declare loop control variable and intitialize it to true
		Boolean combat_on = true; 
		
		//While the loop control variable is true
		while (combat_on == true)
		{
			//print a beginning round banner for formatting//
			System.out.printf("%n**********START ROUND**********%n");
			
			/*Report Combat Stats*/
			//Print the Monster's name
			System.out.printf("%nYou are fighting a %s! %n", monster_name);
			//Print the Monster's Health
			System.out.printf("The MONSTERS'S HEALTH is: %s %n", monster_health);
			//Print the Hero's health
			System.out.printf("Your Health: %s %n", hero_health);
			//Print the Hero's Magic Power
			System.out.printf("Your MAGIC POWER: %s %n", hero_mp);

			/*Combat Menu Prompt*/
			System.out.printf("%nCombat Options: %n");
			//Print option 1: Sword Attack
			System.out.println("Option 1: Sword Attack");
			//Print option 2: Cast Spell
			System.out.println("Option 2: Cast Spell");
			//Print option 3: Charge Mana
			System.out.println("Option 3: Charge Mana");
			//Print option 4: Run Away
			System.out.printf("Option 4: Run Away%n");
		
			//Prompt player for action by re-assigning first_choice to as player input
			System.out.printf("%nWhat action do you want to perform? %n");
		
			//Declare variable for user input (as number) and acquire value from scanner object
			player_choice = input.nextInt();

			//If player chose option 1, (check with equality operator)
			if (player_choice == 1)
			{
				//calculate damage and update monster health using subtraction
				//Calculation: monster_health - hero_ap
				monster_health = monster_health - hero_ap;
				hero_mp = hero_mp + 1;
				//print attack text
				System.out.printf("%nYou strike the %s with your sword for %s damage %n",monster_name,hero_ap);
			}
			//Else if player chose option 2,
			else if (player_choice == 2)
			{
				//If player has 3 or more magic points
				if (hero_mp>=3)
				{
					//Calculate the damage and update monster health using division
					//Calculation: monster_health/2
					monster_health = monster_health/2;
					//Reduce player's mana points by the spell cost using subtraction
					//Calculation: new hero_mp is old hero_mp - 3
					hero_mp = hero_mp -3;
					//print spell message:
					System.out.println("You cast the weaken spell on the monster");
				}
				else 
				{
					//print message for not enough mana
					System.out.println("You don't have enough mana");
				}	
			} 
			//Else if player chose option 3,
			else if (player_choice == 3)
			{
				//Increment magic points and update players magic using addition
				//Calculation: new hero magic is older hero magic plus one
				hero_mp = hero_mp +1;
				//print charging message
				System.out.println("You focus and charge your magic power%n");
			}
			//Else if player chose option 4,
			else if (player_choice == 4)
			{
				//print retreat message
				System.out.println("You run away!");
				//stop combat loop by setting control variable to false
				combat_on = false;
			}
			//Else the player chose incorrectly
			else
			{
				//print an error message
				System.out.println("I don't understand that command");
			}
			
			//have the monster attack the player
			if (hero_health >= 1 && monster_health >= 1)
			{
				//Print monster attack message
				System.out.printf("%nThe %s attcked you and it really hurt!%n",monster_name);
				//Calculate the new hero health by subtracting the hero_health by monster_ap
				hero_health = hero_health - monster_ap;
				//Remind player of current health status an extra time
				System.out.printf("%nYour health is reduced to %s%n",hero_health);
			}
			
			//if monster's health is 0 or below
			if (monster_health <=0)
			{
				//Stop combat loop by setting control variable to false
				//Print victory message
				System.out.printf("You defeated the %s!%n",monster_name);
				combat_on = false;	
			}
			if (hero_health <= 0)
			{
				//stop the combat loop by setting the control variable to false
				//Print failure message
				System.out.printf("%n The %s killed you. Ther is no game over banner. We do not reward failure!%n",monster_name);
				combat_on = false;
			}

			//Print end of round banner
			System.out.printf("%n**********END ROUND**********%n");
		}
	}

}