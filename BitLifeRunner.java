import java.util.Scanner;
import java.util.Random;

public class BitLifeRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        String mainCharacterName = " ";
        System.out.println("Enter your name");
        mainCharacterName = scan.nextLine();
        int familySize = 0;
        familySize = Family.generateFamilySize();       // save the generated position of family (2-4
        Character[] characters = new Character[1];
        Family[] families = new Family[familySize+1];
        int randomHa = 0;
        int randomHe = 0;
        int randomIQ = 0;
        int randomLooks = 0;
        int randomRelationLevel = 0;
        int randomAge = 0;
        int randomSalary = 0;

        // Generating main characters and family member' stats
        for (int i = 0; i < familySize+1; i++) {    
            switch (i) {
                case 0:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    characters[i] = new Character(mainCharacterName, 0, 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 1:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    families[i-1] = new Family("Father", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 2:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    families[i-1] = new Family("Mother", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 3:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    families[i-1] = new Family("Sibling " + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 4:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    families[i-1] = new Family("Sibling" + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
            }
        }

        // Running the BitLife Game
        boolean hasDied = false;
        int option = -1; // keep track of the player input 
        while (hasDied == false) {
            System.out.println("\n" + "Name: " + characters[0].getName() + "\t Balance: " + characters[0].getBalance() + "\t Age: " + characters[0].getAge());  
            System.out.println("\n" + "1. Check Profile" + "\t 2. View Assets" + "\t\t 3. +Age " + "\t 4. Relationships" + "\t 5. Activities" + "\n\n" + "Select your option");
            option = scan.nextInt();
            switch (option) {
                case 1: 
                    checkProfile(characters);
                    break;
                case 2: 
                    System.out.println("Incomplete");
                    break;
                case 3: 
                    addAge(characters, families);
                    break;
                case 4: 
                    displayFamily(families, familySize);
                    interactFamily(families, familySize, scan, rand); // Ask us who to interact with and display the different option of interaction 
                    break;
                case 5:
                    System.out.println("Incomplete");
                    break;
            }
        }
    }
    
    // Runner Methods
    public static void checkProfile(Character[] characters) {
        System.out.println("\n" + characters[0].toString());
    }

    public static void addAge(Character[] characters, Family[] families) {
        for (int i = 0; i < characters.length; i++) {
            characters[i].addAge();
        }
        for (int i = 0; i < families.length-1; i++) {
            families[i].addAge();
        }
        checkProfile(characters);
    }

    public static void displayFamily(Family[] families, int familySize) {
        for (int i = 0; i < familySize; i++) {
            System.out.println("\n" + families[i].toString());
        }
    }

    public static void interactFamily(Family[] families, int familySize, Scanner scan, Random rand) {
        int chooseFam = 0;
        int chooseInteract = 0;
        boolean wantToBack = false;
        System.out.println("\nWho do you want to interact with?"); 
        for (int i = 0; i < familySize; i++) {
            System.out.println(i + ". " + families[i].getName());
        }

        chooseFam = scan.nextInt();
        while (wantToBack == false) {
        System.out.println("\nHow do you want to interact? \n1. Compliment \n2. Back");
        chooseInteract = scan.nextInt();
            System.out.println("\n1. Compliment \n2. Back");
            switch (chooseInteract) {
                case 1: 
                    if (generateOutcome(families, chooseFam, rand) == true) {
                        families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()+5);
                        System.out.println(families[chooseFam].getName() + " is flattered by your compliment. +5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
                    } else {
                        families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()-5);
                        System.out.println(families[chooseFam].getName() + " was not flattered by your compliment. -5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
                    }
                    break;
                case 2:
                    wantToBack = true;
                    break;     
            }
        }
    }

    public static boolean generateOutcome(Family[] families, int chooseFam, Random rand) {
        int chance = -1;
        boolean success = false;
        chance = rand.nextInt(101);
        if (chance <= families[chooseFam].getRelationLevel()) {
            success = true;
        } else {
            success = false;
        }
    return success;
    }
}
