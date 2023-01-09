import java.util.Random;

public class Family extends Character{

    //private members
    private int familySize = 0;
    private int relationLevel = 0;

    // Constructor
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
    public static int generateFamilySize() {
        Random rand = new Random();
        int familySize = 0;
        familySize = rand.nextInt(3) + 2;
        return familySize;
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

    public static int generateSalary(int age){
        Random rand = new Random();
        int salary = 0;
        generateEducation();
        if (generateEducation().charAt(0) == 'M') {
            salary = rand.nextInt(20000)+30000;
        } else if (generateEducation().charAt(0) == 'H') {
            salary = rand.nextInt(20000)+40000;
        }else if(generateEducation().charAt(0) == 'C'){
            salary = rand.nextInt(40000)+60000;
        }
        return salary;
    }

    // public void addAge() {
    //     super.setAge(super.getAge()+1);
    // }

    //ToString
    @Override
    public String toString(){
        return super.toString() + "\n" + "Relation: " +  relationLevel;
    }
}
