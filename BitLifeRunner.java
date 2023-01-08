import java.util.Scanner;
import java.util.Random;

public class BitLifeRunner {
    public static void main(String[] args) {
        // 1. Create a character at age 0 with the user inputted name 
        //     2. Generate a mother, father, siblings w Random Names. Create an object array that reps family memberss
        //     3. Generate random relationLevel (0-100) will be rrandomized (create a random int array to generate relationLevel for all the characters)
        //     4. Generate random key stat level (ha,he,IQ,lo)
        //     5. Balance = 0;
        //     6. Occupation = baby
        //     7. A menu to age, who to interact, activities

        Scanner scan = new Scanner(System.in);
        String mainCharacterName = " ";
        System.out.println("Enter your name");
        mainCharacterName = scan.nextLine();
        int familySize = 0;
        familySize = Family.generateFamilySize();       // save the generated position of family (2-4)
        Family[] family = new Family[familySize+1];
        int randomHa = 0;
        int randomHe = 0;
        int randomIQ = 0;
        int randomLooks = 0;
        int randomRelationLevel = 0;
        int randomAge = 0;
        int randomSalary = 0;

        // Generating main characters and family member' stats
        for (int i = 0; i < familySize; i++) {    
            switch (i) {
                case 0:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    family[i] = new Family(mainCharacterName, 0, 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, 0);
                    break;
                case 1:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    family[i] = new Family("Father", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 2:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    family[i] = new Family("Mother", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 3:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    family[i] = new Family("Sibling " + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 4:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(1);
                    family[i] = new Family("Sibling" + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
            }
        }
    
    // Game Methods
        gameMenu(family, scan);
        displayFamily(family, familySize);
    }

    // Runner Methods
    public static void displayFamily(Character[] characters, int familySize) {
        for (int i = 1; i < familySize; i++) {
            System.out.println("\n" + characters[i].toString());
        }
    }
    public static void checkProfile(Character[] characters) {
        System.out.println("\n" + characters[0].toString());
    }


    // Create the menu to interact with the game
    public static void gameMenu(Family[] family, Scanner scan) {
        boolean hasDied = false;
        int option = -1; // keep track of the player input 
       System.out.println("\n" + "Name: " + family[0].getName() + "\t Balance: " + family[0].getBalance() + "\t Age:" + family[0].getAge());  
        while (hasDied == false) {
            System.out.println("\n" + "1. Check Profile" + "\t 2. View Assets" + "\t\t 3. +Age" + "\t 4. Relationships" + "\t 5. Activities" + "\n\n" + "Select your option");
            option = scan.nextInt();
            switch (option) {
                case 1: 
                    checkProfile(family);
                    break;
                case 2: 
                    System.out.println("Incomplete");
                    break;
                case 3: 
                    System.out.println("Incomplete");
                    break;
                case 4: 
                    displayFamily(family, option);
                    break;
                case 5:
                    System.out.println("Incomplete");
                    break;
            }
        }
    }
}
