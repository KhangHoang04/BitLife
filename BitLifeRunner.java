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

        // To Do List
        // 1) Fix the siblings age compared to parent age
        // 2) Fix education, salary, balance
        // 3) Make marital status change depending on age 
        Scanner scan = new Scanner(System.in);
        String mainCharacterName = " ";
        System.out.println("Enter your name");
        mainCharacterName = scan.nextLine();
        Character[] characters = new Character[5];
        int randomHa = 0;
        int randomHe = 0;
        int randomIQ = 0;
        int randomLooks = 0;
        int randomAge = 0;
        int randomSalary = 0;
        int familySize = 0;
        familySize = generateFamilySize();

        for (int i = 0; i < familySize + 1; i++) {    
            switch (i) {
                case 0:
                    randomHa = generateStat();
                    randomHe = generateStat();
                    randomIQ = generateStat();
                    randomLooks = generateStat();
                    characters[i] = new Character(mainCharacterName, 0, 0.00, 0, getMaritalStatus(i), "None", randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 1:
                    randomHa = generateStat();
                    randomHe = generateStat();
                    randomIQ = generateStat();
                    randomLooks = generateStat();
                    randomAge = generateAge(1);
                    characters[i] = new Character("Father", generateAge(i), generateSalary(generateAge(i)), generateSalary(generateAge(i)), getMaritalStatus(i), generateEducation(), randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 2:
                    randomHa = generateStat();
                    randomHe = generateStat();
                    randomIQ = generateStat();
                    randomLooks = generateStat();
                    randomAge = generateAge(1);
                    characters[i] = new Character("Mother", generateAge(i), generateSalary(generateAge(i)), generateSalary(generateAge(i)), getMaritalStatus(i), generateEducation(), randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 3:
                    randomHa = generateStat();
                    randomHe = generateStat();
                    randomIQ = generateStat();
                    randomLooks = generateStat();
                    randomAge = generateAge(1);
                    characters[i] = new Character("Sibling " + (i-2), generateAge(i), generateSalary(generateAge(i)), generateSalary(generateAge(i)), getMaritalStatus(i), generateEducation(), randomHa, randomHe, randomIQ, randomLooks);
                    break;
                case 4:
                    randomHa = generateStat();
                    randomHe = generateStat();
                    randomIQ = generateStat();  
                    randomLooks = generateStat();
                    randomAge = generateAge(1);
                    characters[i] = new Character("Sibling" + (i-2), generateAge(i), generateSalary(generateAge(i)), generateSalary(generateAge(i)), getMaritalStatus(i), generateEducation(), randomHa, randomHe, randomIQ, randomLooks);
                    break;
            }
        }
        checkProfile(characters, familySize);



    }

    private static String getMaritalStatus(int i) {
        String maritalStatus = " ";
        if(generateAge(i) > 16){
            maritalStatus = "Married";
        }else{
            maritalStatus = "Single";
        }
        return maritalStatus;
    }

    public static int generateStat() {
        Random rand = new Random();
        int stat = 0;
        stat = rand.nextInt(101);
        return stat;
    }

    public static void checkProfile(Character[] characters, int familySize) {
        for (int i = 0; i < familySize + 1; i++) {
            System.out.println("\n" + characters[i].toString());
        }
    }

    public static int generateAge(int i) {
        Random rand = new Random();
        int age = 0;
        if (i > 0 && i < 3) {  // i represent the placement of the character array
            age = rand.nextInt(25)+18;
        } else if (i == 0) {
            age = 0;
        } else {
            age = rand.nextInt(3);
        }
        return age;
    }

    public static int generateSalary(int age){
        Random rand = new Random();
        int salary = 0;
        generateEducation();
        if (generateEducation().charAt(0) == 'M') {
            salary = rand.nextInt(20000)+30000;
        } else if (generateEducation().charAt(0) == 'H') {
            salary = rand.nextInt(20000)+40000;
        }else{
            salary = rand.nextInt(40000)+60000;
        }
        return salary;
    }

    public static String generateEducation() {
        Random rand = new Random();
        String education = " ";
        if (rand.nextInt(4) == 0) {
            education = "Middle School";
        } else if (rand.nextInt(4) == 1) {
            education = "High School";
        } else {
            education = "College";
        }
        return education;
    }
    // 0 Middle School (1/4)
        // ($30,000 - $50,000)
    // 1 High School (1/4)
        // ($40,000 - $60,000)
    // 2 or 3 College (1/2)
        // ($60,000 - $100,000)

    public static int generateFamilySize() {
        Random rand = new Random();
        int familySize = 0;
        familySize = rand.nextInt(3) + 2;
        return familySize;
    }
}
