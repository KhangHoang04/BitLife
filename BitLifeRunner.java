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
        Family[] families = new Family[familySize];
        int randomHa = 0;
        int randomHe = 0;
        int randomIQ = 0;
        int randomLooks = 0;
        int randomRelationLevel = 0;
        int randomAge = 0;
        int randomSalary = 0;
        int[] ageActionLimit = new int[5]; // index 1 = compliment, index 2...

        // Generating main characters and family member' stats
        for (int i = 0; i < familySize+1; i++) {    // Stopping the creation when we reach the limit of family size  
            switch (i) {
                case 0:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    characters[i] = new Character(mainCharacterName, 0, 0.00, 0, "Single", "None", randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 1:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(i);
                    families[0] = new Family("Father", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 2:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(i);
                    families[1] = new Family("Mother", Family.generateAge(i), Family.generateSalary(Family.generateAge(i)), Family.generateSalary(Family.generateAge(i)), Family.getMaritalStatus(i), Family.generateEducation(), randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 3:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(i);
                    families[2] = new Family("Sibling " + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
                case 4:
                    randomHa = Character.generateStat();
                    randomHe = Character.generateStat();
                    randomIQ = Character.generateStat();
                    randomLooks = Character.generateStat();
                    randomAge = Family.generateAge(i);
                    families[3] = new Family("Sibling " + (i-2), Family.generateAge(i), 0.00, 0, Family.getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks, Family.generateStat());
                    break;
            }
        }
    
        // Run the BitLife Game 
        BitLifeGame(scan, rand, characters, families, ageActionLimit, familySize);
    }

    // BitLife Game Method
    public static void BitLifeGame(Scanner scan, Random rand, Character[] characters, Family[] families, int[] ageActionLimit, int familySize) {
            boolean hasDied = false;
            int option = -1; // keep track of the player input
            while (hasDied == false) { // Stop the game once the main character dies 
                System.out.println("\n" + "Name: " + characters[0].getName() + "\t Balance: " + characters[0].getBalance() + "\t Age: " + characters[0].getAge());  
                System.out.println("\n" + "1. Check Profile" + "\t 2. View Assets" + "\t\t 3. +Age " + "\t 4. Relationships" + "\t 5. Activities" + "\n\n" + "Select your option");
                // user input is option it will then be validated if it is an integer
                option = validateInput(option, scan);
                switch (option) {
                    case 1: 
                        checkProfile(characters);
                        break;
                    case 2: 
                        break;
                    case 3: 
                        addAge(characters, families, ageActionLimit);
                        hasDied = calcDeathMain(characters, rand);
                        familySize = calcDeathFam(families, rand, familySize);
                        break;
                    case 4: 
                        displayFamily(families, familySize, scan, rand, ageActionLimit);
                        // Ask us who to interact with and display the different option of interaction 
                        break;
                    case 5:
                        System.out.println("Incomplete");
                        break;
                    default://if user entered an integer but not in range
                        System.out.println("Invalid range");
                        break;
                }
            }
        }

    // Input validation 
    public static int validateInput(int option, Scanner scan){
        boolean valid = false;
        while (valid == false) {//keeps looping until user enters an int
            if (scan.hasNextInt()) {//checks if it is an int
                option = scan.nextInt();// takes in the int
                valid = true;
            } else {
                System.out.println("Please enter a valid integer");
                scan.next();//user retry
                break;
            }
        }
        return option;
    }   

    // Display the stats of the main character 
    public static void checkProfile(Character[] characters) {
        System.out.println("\n" + characters[0].toString());
    }

    // Increase the age of all the character, families, and reset the ageActionLimit to 0
    public static void addAge(Character[] characters, Family[] families, int[] ageActionLimit) {
        for (int i = 0; i < characters.length; i++) {
            characters[i].addAge();
        }
        for (int i = 0; i < families.length; i++) {
            families[i].addAge();
        }
        for (int i = 0; i < ageActionLimit.length; i++) {
            ageActionLimit[i] = 0;
        }
    }

    // Display the stats of all the families member
    public static void displayFamily(Family[] families, int familySize, Scanner scan, Random rand, int[] ageActionLimit) {
        if (familySize == 0) {
            System.out.println("You are paying vistit to your families...");
        } else {
            for (int i = 0; i < familySize; i++) {
                System.out.println("\n" + families[i].toString());
            }
        interactFamily(families, familySize, scan, rand, ageActionLimit);
        }
    }

    // let the user interact with family members through a menu of selected family members with different activities to increase/decrease relationshiplvl
    public static void interactFamily(Family[] families, int familySize, Scanner scan, Random rand, int[] ageActionLimit) {
        int chooseFam = 0;
        int chooseInteract = 0;
        boolean inRange = false;
        boolean wantToBack = false;
        System.out.println("\nWho do you want to interact with?");// asks question
        for (int i = 0; i < familySize; i++) {
            System.out.println(i + ". " + families[i].getName());// print out name
        }
        while (inRange == false) {
            chooseFam = validateInput(chooseFam, scan);// checks if who you want to interact with is an int
            if (chooseFam < familySize) {// int has to be within range
                inRange = true;// stops the loop
            } else {
                System.out.println("Invalid range"); 
                System.out.println("\nWho do you want to interact with?");
                for (int i = 0; i < familySize; i++) {//the family user can interact with pops up to show what the user can pick within the range
                    System.out.println(i + ". " + families[i].getName());
                }
            }
        }

        //loops until user inputs a valid integer and is in range
        while (wantToBack == false) {
        System.out.println("\nHow do you want to interact? \n1. Compliment \n2. Conversation \n3. Insult \n4. Spend Time \n5. Back");
        chooseInteract = validateInput(chooseInteract, scan);
            switch (chooseInteract) {
                case 1: // Compliment action 
                    giveCompliment(ageActionLimit, families, chooseFam, rand, families);
                    break;
                case 2: // Conversation action
                    haveConversation(ageActionLimit, families, chooseFam);
                    break;
                case 3: 

                case 4: 
                    spendTime(ageActionLimit, families, chooseFam);
                    break;
                case 5:
                    wantToBack = true;
                    break;  
                default:
                    System.out.println("Invalid range");
                    break;   
            }
        }
    }

    //compliments family members and increase/decrease relationlvl based on current relationlvl probability
    public static void giveCompliment(int[] ageActionLimit, Family[] families, int chooseFam, Random rand, Character[] characters) {
        if (ageActionLimit[0] < 5) {//in one year, you can only give 5 compiments
            // If it works
            if (generateOutcome(families, chooseFam, rand) == true && families[chooseFam].getRelationLevel() < 95) {
                families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()+5);
                System.out.println(families[chooseFam].getName() + " is flattered by your compliment. +5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
            } else if (generateOutcome(families, chooseFam, rand) == true && families[chooseFam].getRelationLevel() >= 95) {
                families[chooseFam].setRelationLevel(100);
                System.out.println(families[chooseFam].getName() + " is flattered by your compliment. You have reached the highest relation level --> " + families[chooseFam].getRelationLevel());
            }   
            // If it doesn't work
            if (generateOutcome(families, chooseFam, rand) == false && families[chooseFam].getRelationLevel() > 5) {
                families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()-5);
                System.out.println(families[chooseFam].getName() + " was not flattered by your compliment. -5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
            } else if (generateOutcome(families, chooseFam, rand) == false && families[chooseFam].getRelationLevel() <= 5) {
                families[chooseFam].setRelationLevel(0);
                System.out.println(families[chooseFam].getName() + " was not flattered by your compliment. You have reached the lowest relation level --> " + families[chooseFam].getRelationLevel());
            }
            ageActionLimit[0]++;//increments the ageActionLimit to cap amount of compliments you have each year
        } else {
            System.out.println("You have given enough compliments at this age, try again next year");
        }
    }
    
    // conversation method increases relationlvl to family members
    public static void haveConversation(int [] ageActionLimit, Family[] families, int chooseFam){
        if(ageActionLimit[1] < 2){ //only allowed to have two conversations per age
            //relationlvl should not exceed 100
            if(families[chooseFam].getRelationLevel() < 95){
                families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()+5);
                System.out.println(families[chooseFam].getName() + " is pleased with your conversation. +5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
                ageActionLimit[1]++;

            }else if(families[chooseFam].getRelationLevel() >= 95){
                families[chooseFam].setRelationLevel(100);
                System.out.println(families[chooseFam].getName() + " is pleased with your conversation. You have reached your maximum relation level. Relation level: 100");
                ageActionLimit[1]++;
            }
        }else{
            System.out.println("You have ran out of topics this year, try again next year.");
        }
    }

    // +spendTime() : void 
    // - increased relationLevel by 5%
    // - limit to once per age
    public static void spendTime(int[] ageActionLimit, Family[] families, int chooseFam) {
        if(ageActionLimit[3] < 1){ 
            //relationlvl should not exceed 100
            if(families[chooseFam].getRelationLevel() < 95){
                families[chooseFam].setRelationLevel(families[chooseFam].getRelationLevel()+5);
                System.out.println(families[chooseFam].getName() + " enjoyed spending time with you. +5 to RelationLevel --> " + families[chooseFam].getRelationLevel());
                ageActionLimit[3]++;

            }else if(families[chooseFam].getRelationLevel() >= 95){
                families[chooseFam].setRelationLevel(100);
                System.out.println(families[chooseFam].getName() + " enjoyed spending time with you. You have reached your maximum relation level. Relation level: 100");
                ageActionLimit[3]++;
            }
        }else{
            System.out.println("You are too busy right now, try again next year.");
        }
    }


    // use this method to calculate the chance of actions succeeding in increasing relationlvl
    public static boolean generateOutcome(Family[] families, int chooseFam, Random rand) {
        int chance = -1;
        boolean success = false;
        chance = rand.nextInt(101);
        if (chance <= families[chooseFam].getRelationLevel()) {//if random number from 0-100 is less than/equal to current relationlvl of family mem, you add relationlvl points to current status
            success = true;
        } else {
            success = false;
        }
    return success;
    }

    // calculate the chance of death for the main character
    public static boolean calcDeathMain(Character[] characters, Random rand){
        boolean hasDied = false;
        for (int i = 0; i < characters.length; i++) {
            if (rand.nextInt(5000) <= characters[i].getAge()) {// with every year older, character is more likely to die
                System.out.println("You have died");
                hasDied = true;
            }
        }
        return hasDied;
    }

    // Calculate the chance of death for each of the families member
    public static int calcDeathFam(Family[] families, Random rand, int familySize) {
        for (int j = 0; j < familySize; j++) {
            if (rand.nextInt(3000) <= families[j].getAge()) {
                System.out.println(families[j].getName() + " has died");
                familySize = adjustFamily(families, j, familySize);
            }
        }
        return familySize;
    }

    // Adjust the family object after a death
    public static int adjustFamily(Family[] families, int index, int familySize) {
        if (familySize > 1) {
            Family[] familiesCopy = new Family[familySize-1];
            if (index == 0) {   // Remove the first family member
                System.arraycopy(families, 1, familiesCopy, 0, familySize-1);
                for (int i = 0; i < familiesCopy.length; i++) {
                    families[i] = familiesCopy[i];
                }
            }
            else if (index == familySize-1) { // Remove the last family member
                System.arraycopy(families, 0, familiesCopy, 0, index);
                for (int i = 0; i < familiesCopy.length; i++) {
                    families[i] = familiesCopy[i];
                }  
            } 
            else {  // Father Mother Sib1 Sib2 ---> Take Mother --> Father Sib1 Sib2            
                System.arraycopy(families, 0, familiesCopy, 0, index);
                for (int i = index; i < familiesCopy.length; i++) {
                    familiesCopy[i] = families[i+1]; 
                }  
                for (int i = 0; i < familiesCopy.length; i++) {
                    families[i] = familiesCopy[i];
                }  
            } 
        }
        if (familySize > 0) {
            familySize--;   
        }
        return familySize;



    }
}
