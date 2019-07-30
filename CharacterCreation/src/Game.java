import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);
	
	private final String[] characterClasses = {"Warrior", "Knight", "Wanderer", "Thief", "Bandit", "Hunter", "Sorcerer", "Pyromancer", "Cleric", "Deprived"};
	private final String[] characterGenders = {"Male", "Female", "Other"};
	private final String[] characterGifts = {"Divine Blessing", "Black Firebomb", "Twin Humanity", "Binoculars", "Pendant", "Master Key", "Tiny Being's Ring", "Old Witch's Ring", "No Gift"};
	private final int[] characterLevels = {4, 5, 3, 5, 4, 4, 3, 1, 2, 6};
	
	// class description strings and string array
	private final String warriorDesc = "Fearless warrior. Weapon expert. High strength, dexterity.";
	private final String knightDesc = "Low-ranking knight, High HP, solid armor. Not easily toppled.";
	private final String wandererDesc = "Aimless wanderer. Wields scimitar. High Dexterity.";
	private final String thiefDesc = "Guilt-ridden thief with quiet footsteps. High dexterity. Has Master Key by default.";
	private final String banditDesc = "Savage bandit. High strength. Wields heavy battleaxe.";
	private final String hunterDesc = "Bow-wielding hunter. Can handle close range byt vulnerable to magic.";
	private final String sorcererDesc = "Sorcerer of Vinheim. Dragon school. Casts soul sorceries.";
	private final String pyromancerDesc = "Great swamp pyromancer. Casts fire spells. Wields a hand axe.";
	private final String clericDesc = "Cleric on pilgrimage. Wields a mace. Casts healing miracles.";
	private final String deprivedDesc = "Unclothed enigma. Only armed with club and old plank shield.";
	private final String[] classDescriptions = {warriorDesc, knightDesc, wandererDesc, thiefDesc, banditDesc, hunterDesc, sorcererDesc, pyromancerDesc, clericDesc, deprivedDesc};
	
	// gift description strings and string array
	private final String divineDesc = "Holy water from Godess Gwynevere. Fully restores HP and undo irregularities.";
	private final String blackDesc = "Black bisque urn filled with black powder. Explodes, inflicting fire damage.";
	private final String twinDesc = "Rare tiny black sprite found on corpses. Very unusual twin humanity.";
	private final String binocularsDesc = "Binoculars made of brass. Use to peer at distant scenery.";
	private final String pendantDesc = "A simple pendant with no effect.";
	private final String masterDesc = "This universal key opens any basic lock.";
	private final String tinyDesc = "Ring made of an ancient tiny red jewel. Grants small increase to HP.";
	private final String oldDesc = "Old ring from an old witch. Engraved minutely with indecipherable script, but seemingly useless.";
	private final String noDesc = "No gift will be selected.";
	private final String[] giftDescriptions = {divineDesc, blackDesc, twinDesc, binocularsDesc, pendantDesc, masterDesc, tinyDesc, oldDesc, noDesc};
	
	private String characterName;
	private int characterGender;
	private int characterClass;
	private int characterGift;
	private int characterLevel;
	private boolean validChoice = false;
	
	public Game() {
		System.out.println("Character Creation Application");
		
		setCharacterName();
		setCharacterGender();
		setCharacterClass();
		setCharacterGift();
		displayCharacter();
		startGame();
	}
	
	private void setCharacterName() {
		// set character name and check a name was entered
		String sub;
		
		do {
			System.out.print("\nEnter the character name>>");
			characterName = scan.nextLine();
			
			if(!characterName.isEmpty()) {
				validChoice = true;
			} else {
				System.out.println("Please enter a name");
			}
			
		} while(!validChoice);
		
		// format name
		sub = characterName.toLowerCase();
		characterName = characterName.substring(0, 1).toUpperCase() + sub.substring(1, sub.length());
			
		validChoice = false;
		}
	
	private void setCharacterGender() {
		// Set gender and check for a valid entry
		String entry;
		boolean validGender = false;
		
		System.out.print("\nCharacter genders: ");
		
		for(int x = 0; x < characterGenders.length; ++x) {
			System.out.print((x + 1) + ". " + characterGenders[x] + " ");
		}
		
		// loop until number is entered and valid
		do {
			// loop until a number is entered
			do {
				System.out.print("\nEnter a number for character gender >>");
				entry = scan.nextLine();
				try {
					characterGender = Integer.parseInt(entry);
					validGender = true;
				} catch (Exception e) {
					System.out.println("Please enter a number");
				}
			} while(!validGender);
			
			// check that entry is valid
			if(characterGender >= 1 && characterGender <= characterGenders.length) {
				validChoice = true;
				characterGender--; // decrement for array index
			} else {
				System.out.println("Please enter a valid number");
			}
			
		} while(!validChoice);
		
		validChoice = false;
	}
	
	private void setCharacterClass() {
		// set class and check for a valid entry
		String entry;
		boolean validClass = false;
		
		System.out.println("\nCharacter classes: ");
		
		for(int x = 0; x < characterClasses.length; ++x) {
			System.out.println((x + 1) + ". " + characterClasses[x] + " - " + "Level: " + characterLevels[x]);
		}
		
		// loop until number is entered and valid
		do {
			// loop until a number is entered
			do {
				System.out.print("Enter a number for character class >>");
				entry = scan.nextLine();
				try {
					characterClass = Integer.parseInt(entry);
					validClass = true;
				} catch (Exception e) {
					System.out.println("Please enter a number");
				}
			} while(!validClass);
			
			// check that entry is valid 
			if(characterClass >= 1 && characterClass <= characterClasses.length) {
				characterClass--; // decrement for array index
				System.out.println(classDescriptions[characterClass]);
				System.out.print("Is this the class you want? y/n >>");
				entry = scan.nextLine();
				
				if(entry.equals("y") || entry.equals("Y")) {
					validChoice = true;
					characterLevel = characterLevels[characterClass];
				} else if(!entry.equals("n") && !entry.equals("N")) {
					System.out.println("Please enter a valid response");
				}
				
			} else {
				System.out.println("Please enter a valid number");
			}
			
		} while(!validChoice);
		
		validChoice = false;
	}
	
	private void setCharacterGift() {
		String entry;
		boolean validGift = false;
		
		System.out.println("\nCharacter gifts:");
		
		for(int x = 0; x < characterGifts.length; ++x) {
			System.out.println((x + 1) + ": " + characterGifts[x]);
		}
		
		// loop until number is entered and valid
		do {
			// loop until a number is entered
			do {
				System.out.print("Enter a number for character gift >>");
				entry = scan.nextLine();
				try {
					characterGift = Integer.parseInt(entry);
					validGift = true;
				} catch (Exception e) {
					System.out.println("Please enter a number");
				}
			} while(!validGift);
			
			// check that valid number is entered
			if(characterGift >= 1 && characterGift <= characterGifts.length) {
				characterGift--; // decrement for array index
				System.out.println(giftDescriptions[characterGift]);
				System.out.print("Is this the gift you want? y/n >>");
				entry = scan.nextLine();
				
				if(entry.equals("y") || entry.equals("Y")) {
					validChoice = true;
				} else if(!entry.equals("n") && !entry.equals("N")) {
					System.out.println("Please enter a valid response");
				}
				
			} else {
				System.out.println("Please enter a valid number");
			}
			
		} while(!validChoice);
		
		validChoice = false;
			
	}
	
	public String getCharacterName() {
		return characterName;
	}
	
	public String getCharacterGender() {
		return characterGenders[characterGender];
	}
	
	public String getCharacterClass() {
		return characterClasses[characterClass];
	}
	
	public String getCharacterGift() {
		return characterGifts[characterGift];
	}
	
	public int getCharacterLevel() {
		return characterLevel;
	}
	
	private void displayCharacter() {
		// display all character information
		System.out.println("\nName: " + getCharacterName());
		System.out.println("Gender: " + getCharacterGender());
		System.out.println("Class: " + getCharacterClass());
		System.out.println("Level: " + getCharacterLevel());
		System.out.println("Gift: " + getCharacterGift());
	}
	
	private void startGame() {
		System.out.println("\n" + getCharacterName() + " sits alone, in a dark and decaying cell. As an undead cursed with the darksign, you have \nbeen doomed to await the end of the world while slowly losing your mind. You have lost track of how much time you have been in isolation here.");
	}

}
