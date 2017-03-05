//Top Statement: A game where the player creates a character and uses it to	battle random monsters.

/*We have three Main Goals in this script:

1. Create a hero method that allows players to "build" their hero by allocating skill points
2. Randomly generate a goblic, troll or orc. Each should have its own base states plus a random range modifier.
3. Run a combat algorithim method that allows players to melee attack, magic attack, charge mana or flee. The method should only
   break if the player/goblin dies or chooses to flee.

 */

//Import Scanner so we can take input from the user later
import java.util.Scanner;
import java.util.Random;

//Combat Simulator

public class CombatSim {

	//create class variables for hero stats
	//create new variables for the hero's stats and set them at 0 to start
	public static int heroHealth = 0;
	public static int heroAttack = 0;
	public static int heroMp = 0;

	//create class variables for monster stats
	public static String monsterName;
	public static int monsterHealth=0;
	public static int monsterAttack=0;
	public static int monsterHealthModifier = 0;
	public static int monsterAttackModifier = 0;
	
	//create class variables for the combat choice we will use later
	public static int combatChoice;

	public static void main(String[] args)
	{
	
		//run createHero method
		createHero();



		//print a beginning round banner for formatting//
		System.out.printf("%n**********START ROUND**********%n");

		//run createMonster method
		createMonster();


		//run combat algo
		runCombat();
	
	} //end main method

	//create a new class method for creating a hero
	public static void createHero() {

		//set starting allocation points to 20
		int spendingPoints = 20;
		
		//Declare variable for user input and initialize with a new Scanner object
		Scanner input = new Scanner(System.in);
		int playerChoice;

		//on one line, print out health, magic and attack
		System.out.printf("%n  Health:%s - Attack:%s - Magic:%s%n", heroHealth,heroAttack,heroMp);
		//print the user what they can purchase (3 options)
		System.out.printf("1) +10 Health%n2) +1 Attack%n3) +3 Magic Power%n");
		//print out remaining spending points
		System.out.printf("You have %s points to spend - Choose an option from above:%n",spendingPoints);
		
		//create a while loop that prompts the player for his choice, allocates the points, and keeps looping until the points are spent
		while (spendingPoints>=0) {
			//prompt user for input. If user input is 1, increase heroHealth by 10 and decrease spending points by 1
			playerChoice = input.nextInt();

			//print out remaining spending points
			System.out.printf("You have %s points to spend:%n",spendingPoints);
			
			//if player  choose option 1, add 10 to the heroHealth total and subtract one spending point. Continue the loop.
			if (playerChoice ==1) {
				heroHealth = heroHealth + 10;
				spendingPoints = spendingPoints -1;
				//on one line, print out health, magic and attack
				System.out.printf("%n  Health:%s - Attack:%s - Magic:%s%n", heroHealth,heroAttack,heroMp);
				//print the user what they can purchase (3 options)
				System.out.printf("1) +10 Health%n2) +1 Attack%n3) +3 Magic Power%n");
			}//end first if statement

			//if player choice equals 2, +1 attack and -1 spending points
			else if (playerChoice==2) {
				heroAttack = heroAttack + 1;
				spendingPoints = spendingPoints -1;
				//on one line, print out health, magic and attack
				System.out.printf("%n  Health:%s - Attack:%s - Magic:%s%n", heroHealth,heroAttack,heroMp);
				//print the user what they can purchase (3 options)
				System.out.printf("1) +10 Health%n2) +1 Attack%n3) +3 Magic Power%n");
			}//end second if statement

			//if player choose option 3, +3 magic and -1 speinding point
			else if (playerChoice==3) {
				heroMp = heroMp + 3;
				spendingPoints = spendingPoints -1;
				//on one line, print out health, magic and attack
				System.out.printf("%n  Health:%s - Attack:%s - Magic:%s%n", heroHealth,heroAttack,heroMp);
				//print the user what they can purchase (3 options)
				System.out.printf("1) +10 Health%n2) +1 Attack%n3) +3 Magic Power%n");
			}//end third if statement

			else if (spendingPoints ==0) {
				System.out.println("You have 0 points left to spend");
				break;
			} //ends loop when spending points are finished

			//Exception handling for incorrect input
			else {
				System.out.println("Not a valid option. Enter a number 1-3:");
			}//end exception handling
		}//end while loop
	}//end createHero

	//Create a new class method for generating a new monster
	public static void createMonster() {

		//generate a random integer 1-3 that we will use to choose between orc, goblins and trolls
		Random rand = new Random();
		int monsterNumberGenerator = rand.nextInt((3-1)+1)+1;
		
		//test to prin t out our random int
		//System.out.println(monsterNumberGenerator);

		//Use a selection statement to decide which monster to generate
		if (monsterNumberGenerator == 1) {
			monsterName = "goblin";
			monsterHealthModifier = rand.nextInt((24-1)+1)+1;
			monsterAttackModifier = rand.nextInt((4-1)+1)+1;
			monsterHealth = 75 + monsterHealthModifier;
			monsterAttack=8 + monsterAttackModifier;
			System.out.printf("%nYou encountered a %s%n",monsterName);
		}

		else if (monsterNumberGenerator==2){
			monsterName = "orc";
			monsterHealthModifier = rand.nextInt((24-1)+1)+1;
			monsterAttackModifier = rand.nextInt((4-1)+1)+1;
			monsterHealth = 100+monsterHealthModifier;
			monsterAttack=12 + monsterAttackModifier;
			System.out.printf("%nYou encountered a %s%n",monsterName);
		}

		else if (monsterNumberGenerator==3){
			monsterName = "troll";
			monsterHealthModifier = rand.nextInt((49-1)+1)+1;
			monsterAttackModifier = rand.nextInt((4-1)+1)+1;
			monsterHealth = 150+monsterHealthModifier;
			monsterAttack=15+monsterAttackModifier;
			System.out.printf("%nYou encountered a %s%n",monsterName);
		}

		else {
			System.out.println("error with monster generator");
		}
	}//end create monster
	
	//create a method to handle the combat algo
	public static void runCombat() {
		//The hero stats will go here
		System.out.printf("%nYour Hero Stats:%nHealth:%s%nAttack:%s%nMagic:%s%n",heroHealth,heroAttack,heroMp);

		//print out monster stats
		System.out.printf("The %s has an attack of %s and %s health!%n",monsterName,monsterAttack,monsterHealth);


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
		
		while (monsterHealth >=1 && heroHealth>=1) { 
			//Prompt player for action by re-assigning first_choice to as player input
			System.out.printf("%nWhat action do you want to perform? %n");
			//Declare variable for user input (as number) and acquire value from scanner object
			Scanner keyboard = new Scanner(System.in);
			combatChoice = keyboard.nextInt();
			//if selection
			if (combatChoice == 1) {
				meleeOption();
			}//end if
			else if (combatChoice==2) {
				magicAttack();
			}//end else statement 
			else if (combatChoice==3) {
				magicRecharge();
			}
			else if (combatChoice==4) {
				runAway();
				break;
			}
			else {
				System.out.println("Not a valid option. Choose 1-4");
			}
		}//end while loop

		if (monsterHealth<=0) {
			monsterHealth == 0;
			System.out.println("***You killed the monster!***");
		}//end if statement to kill monster
		else if (heroHealth<=0) {
			heroHealth == 0;
			System.out.println("***YOU DIED***");
		}
	}//end runCombat

	public static void meleeOption() {
		int meleeDamage = heroAttack;
		monsterHealth = monsterHealth - heroAttack;
		System.out.printf("You dealt %s damage to the monster%nThe monster's health is now %s!%n",heroAttack,monsterHealth);
		if (monsterHealth >= 1) {
			heroHealth = heroHealth - monsterAttack;
			System.out.printf("The monster attacked you! Your health was reduced to %s%n",heroHealth);
		}//end if statement
		else if (monsterHealth <= 0) {
			System.out.printf("You killed the monster!%n");
		}//end else if
		else {
			System.out.println("error");
		}//end else
	}//end meleeOption method


	public static void magicAttack() {
		if (heroMp>=6) {
			monsterHealth = monsterHealth/2;
			heroMp = heroMp - 3;
			System.out.printf("You cast a spell that reduced The monster's health to %s!%n",monsterHealth);
			
			//if monster is still alive have it attack the player
			if (monsterHealth >= 1) {
				heroHealth = heroHealth - monsterAttack;
				System.out.printf("The monster attacked you! Your health was reduced to %s%n",heroHealth);
			}//end if statement
			
			else if (monsterHealth <= 0) {
				System.out.printf("You killed the monster!%n");
			}//end else if
			else {
				System.out.println("error");
			}//end else for error	
		}// end first if statement in magicAttack
		
		else if (heroMp<6) {
			System.out.println("You don't have enough mana. try recharging");
		}//end else if
		
		else {
			System.out.println("Magic error");
		}//end else
	}//end magicAttack
	
	public static void magicRecharge(){
		heroMp = heroMp + 3;
		System.out.printf("You charged your Mana. Your magic power is now %s%n", heroMp);

		//if monster is still alive have it attack the player
		if (monsterHealth >= 1) {
			heroHealth = heroHealth - monsterAttack;
			System.out.printf("The monster attacked you! Your health was reduced to %s%n",heroHealth);
		}//end if statement
		else if (monsterHealth<=0) {
			System.out.printf("You killed the monster!%n");
		}//end else if
		else {
			System.out.println("Recharge error");
		}//end else
	}//end magicRecharge

	public static void runAway() {
		System.out.println("You ran away like a pansy! This game does not reward failure!");
	}//end runAway

	}//end combatSim