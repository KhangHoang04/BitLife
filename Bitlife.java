/* Helen Gao
 * 1/4/22
 */

 public class Bitlife{
    public static void main(String[] args) {
        /*



        Character Main Class
            -name : String
            -age : int
            -balance : double
            -maritalStatus: String
            - private String[] occupation; --> set later
            -education: String
            -relationshipName : String[]    --> Set Later
            -relationshipStatus: int[] // 1 mother, 2 father, 3 siblings, 4 girlfriend/boyfriend, 5 spouse, 6 friend, 7 bestfriend, 8 coworker, 9 boss --> Set Later
            -happiness : int 
            -health : int
            -IQ : int
            -looks : int

            +addAge()
            -----------
        Runner class 
            1. Create a character at age 0 with the user inputted name 
            2. Generate a mother, father, siblings w Random Names. Create an object array that reps family memberss
            3. Generate random relationLevel (0-100) will be rrandomized (create a random int array to generate relationLevel for all the characters)
            4. Generate random key stat level (ha,he,IQ,lo)
            5. Balance = 0;
            6. Occupation = baby
            7. A menu to age, who to interact, activities
        
        Relationships Subclass inherit Character class (include getter/setter)
            -relationLevel : int 
            -----------
            +checkRelationship() : void // Display Parents --> Siblings --> Girl/Boyfriends --> Friends with their relationship status
            +checkProfile() : void // Display the character name, age, marital status, education, occupation, key stats
            +askForMoney() : void // Give the main character 1/100 of the character money with an equal chance to the relation level
                if passed, decreased the relationLevel by 7% 
                if failed, decreased the relationLevel by 12%
                limit to once per age 
            +compliment() : void // equal chance to passed based relationLevel (relation level is 47% --> passed = 47% failed = 100 - relation level) --> RandomNextInt() --> 0-100 (0-47 passed or 47-100 failed)
                if passed, increased the relationLevel by 5%
                if failed, decreased the relationLevel by 5%
                limit to once per age
            +conversation() : void // increase relationLevel by 5%
                limit to twice per age
            +giftMoney() : void // decrease main character balance and increased character balance
                gift $5 --> increased relationLevel by 5% 
                gift $50 --> increased relationLevel by 7% 
                gift $500 --> increased relationLevel by 10% 
                limit to once per age 
            +insult() : void // decrease the relationLevel based on the current relationLevel
                decrease the relationLevel by 1/5 of the current relationLevel)
                chance to get hurt if relationship is not family/co-worker
                limit to once per age 
            +movieTheater() : void // generate random Movie Title and Genre
                success rate = relationLevel
                if passed, increased the relationLevel by 7%
                if failed, decreased the relationLevel by 7%
                limit to once per age
            +spendTime() : void 
                increased relationLevel by 5%
                limit to once per age

        Occupation
        -occuptation : int[] // list of number with corresponding job title 
            
        Profile subclass inherit Character
        - Display all of our data on the character 
        - Apply it to the side characters 
        
        Activities
        */ 
    
    }
}

