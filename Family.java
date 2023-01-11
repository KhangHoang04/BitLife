import java.util.Random;

public class Family extends Character{  

    //private members
    private int familySize = 0;
    private int relationLevel = 0;

    // Constructor
    // Takes all the private members and methods from the character class 
    public Family(String name, int age, double balance, int salary, String maritalStatus, String education,
    int happiness, int health, int IQ, int looks, int relationLevel) {
        super(name, age, balance, salary, maritalStatus, education, happiness, health, IQ, looks);
        this.relationLevel = relationLevel;
    }

    // Getter Methods
    public int getFamilySize() {
        return familySize;
    }
    
    public int getRelationLevel(){
        return relationLevel;
    }
    
    public static String getMaritalStatus(int i) {
        String maritalStatus = " ";
        if(generateAge(i) > 16){
            maritalStatus = "Married";
        }else{
            maritalStatus = "Single";
        }
        return maritalStatus;
    }
    
    // Setter Methods
    public void setFamilySize(int familySize) {
        this.familySize = familySize;
    }
    
    public void setRelationLevel(int relationLevel) {
        this.relationLevel = relationLevel;
    }
    
    // Methods
    // Generate a number from 2-5 to represent to make random amount of family members in a family
    public static int generateFamilySize() {
        Random rand = new Random();
        int familySize = 0;
        familySize = rand.nextInt(3) + 2;
        return familySize;
    }

    // generates random age within a range of ages depending on character role
    public static int generateAge(int i) { 
        Random rand = new Random();
        int age = 0;
        // i represent the placement of the families object array
        if (i >= 0 && i <= 2) {  // Generate mother and father age range 
            age = rand.nextInt(25)+18;
        } else {
            age = rand.nextInt(4)-2;  // Generate siblings age range 
        }
        return age;
    }

    // generates random highest education level for characters
    public static String generateEducation() {
        Random rand = new Random();
        String education = " ";
        if (rand.nextInt(4) == 0) { // 1/4 chance of being middle school graduate 
            education = "Middle School";
        } else if (rand.nextInt(4) == 1) {  // 1/4 chance of of being a High School graduate
            education = "High School";
        } else {
            education = "College";// 1/2 chance of being a college graduate
        }
        return education;
    }

    // generates a random salary from a range depending on education
    public static int generateSalary(int age){
        Random rand = new Random();
        int salary = 0;
        generateEducation();
        if (generateEducation().charAt(0) == 'M') {// Middle School
            salary = rand.nextInt(20000)+30000;
        } else if (generateEducation().charAt(0) == 'H') {// High School
            salary = rand.nextInt(20000)+40000;
        }else if(generateEducation().charAt(0) == 'C'){// College
            salary = rand.nextInt(40000)+60000;
        }
        return salary;
    }

    //ToString
    @Override
    public String toString(){
        return super.toString() + "\n" + "Relation: " +  relationLevel;
    }
}
