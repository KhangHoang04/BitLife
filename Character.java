import java.util.Random;

public class Character {
    // All the key variables of a character
    private String name;
    private int age;
    private String[] occupation;
    private double balance;
    private int salary;
    private String maritalStatus;
    private String education;
    private String[] relationshipNames;
    private String[] relationshipStatus;
    private int happiness;
    private int health;
    private int IQ;
    private int looks;

    public Character() {
        name = "";
        age = 0;
        balance = 0.00;
        salary = 0;
        maritalStatus = "Single";
        education = "";
        happiness = 0;
        health = 0;
        IQ = 0;
        looks = 0;
    }

    public Character(String name, int age, double balance, int salary, String maritalStatus, String education,
            int happiness, int health, int IQ, int looks) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.salary = salary;
        this.maritalStatus = maritalStatus;
        this.education = education;
        this.happiness = happiness;
        this.health = health;
        this.IQ = IQ;
        this.looks = looks;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String[] getOccupation() {
        return occupation;
    }

    public double getBalance() {
        return balance;
    }

    public int getSalary(){
        return salary;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getEducation() {
        return education;
    }

    public String[] getRelationshipNames() {
        return relationshipNames;
    }

    public String[] getRelationshipStatus() {
        return relationshipStatus;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public int getIQ() {
        return IQ;
    }

    public int getLooks() {
        return looks;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String[] occupation) {
        this.occupation = occupation;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setRelationshipNames(String[] relationshipNames) {
        this.relationshipNames = relationshipNames;
    }

    public void setRelationshipStatus(String[] relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    public void setLooks(int looks) {
        this.looks = looks;
    }

    //methods
    public void addAge(){
        age++;
    }

    public static int generateStat() {
        Random rand = new Random();
        int stat = 0;
        stat = rand.nextInt(101);
        return stat;
    }
    
    public String toString() {
        return "Name: " + name + "\n" + "Age: " + age + "\n" + "Balance: $" + balance + "\n" + "Salary: $" + salary + "\n" + "Marital Status: " + maritalStatus + "\n" + "Education: " + education + "\n" + "Happiness: " + happiness + "\n" + "Health: " + health + "\n" + "IQ: " + IQ + "\n" + "Look: " + looks;
    }

}
