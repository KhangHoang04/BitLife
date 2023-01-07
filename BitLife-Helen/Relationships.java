import java.util.Random;

public class Relationships extends Character{
    // Private member
    private int relationLevel;

    //constructors
    public Relationships(){
        super();
        relationLevel = 0;
    }
    public Relationships(int relationLevel){
        this.relationLevel = relationLevel;
    }

    // Getter methods
    public int getRelationshipLevel() {
        return relationLevel;
    }

    // Setter methods
    public void setRelationshipLevel(int relationLevel) {
        this.relationLevel = relationLevel;
    }

    public void checkRelationship() { // Display Parents --> Siblings --> Girl/Boyfriends --> Friends with their relationship status
        
    }
            +generateFamily() : void 
            +checkRelationship() : void // Display Parents --> Siblings --> Girl/Boyfriends --> Friends with their relationship status (overview check on relation)
            +checkRelationProfile() : void // Display the character name, age, marital status, education, occupation, key stats
            +askForMoney() : void // Give the main character 1/100 of the character money with an equal chance to the relation level
                if passed, decreased the relationLevel by 7% 
                if failed, decreased the relationLevel by 12%
                limit to once per age 
            +compliment() : void // equal chance to passed based relationLevel
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


}
