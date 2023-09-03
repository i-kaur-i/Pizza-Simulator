import java.awt.Color;
/**
 * This class is for the ingredient. It sets the description, cost, and calories.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public abstract class Ingredient implements Comparable
{
    // instance variables for the ingredients attributes
    private String description;
    private Money cost;
    private Color theColor;
    private String colorName;
    private int calories;

    /**
     * This constructor has not arg
     * 
     * default constructor
     *
     *PRE: none
     *POST: none 
     * @param: string, money, int
     * *return: none
     */
    public Ingredient(){
        // default constructor
    }

    /**
     * This constructor initalizes the variables
     * 
     * used the set methods for description, cost, and calories
     *
     *PRE: String, Money, int to pass in
     *POST: sets the description, cost, and calories
     * @param: string, money, int
     * *return: none
     */
    public Ingredient(String description, Money cost, int calories) {
        setDescription(description);
        setCost(cost);
        setCalories(calories);
    }

    /**
     * This constructor initalizes the variables
     * 
     * used the set methods for description, cost, and calories and added
     * color
     *
     *PRE: String, Money, int, Color to pass in
     *POST: sets the description, cost, calroies, and color
     * @param: string, money, int, color
     * *return: none
     */
    public Ingredient(String description, Money cost, int calories, Color color) {
        setColor(color);
        setDescription(description + " that are " + colorName);
        setCost(cost);
        setCalories(calories);
    }

    /**
     * This method is to set the description 
     * 
     * set the instance variable of description to the passed in string
     *
     *PRE: string to pass in
     *POST: sets the desctiption
     * @param: string
     * *return: none
     */
    public void setDescription(String d){
        description = d;
    }

    /**
     * This method is to get the description 
     * 
     * returned the instance variable description
     *
     *PRE: none
     *POST: returns the description as a string
     * @param: none
     * *return: none
     */
    public String getDescription(){
        return description;
    }

    /**
     * This method is to get the color
     * 
     * returned the instance variable color
     *
     *PRE: none
     *POST: returns the color
     * @param: none
     * *return: none
     */
    public Color getColor() {
        return theColor;
    }
    
    /**
     * This method is to sset the color 
     * 
     * sets the color based on the numbers 
     *
     *PRE: color object
     *POST: sets the color
     * @param: none
     * *return: none
     */
    public void setColor(Color that){
        theColor = that;
        
        if(theColor.getRed() == 255 && theColor.getGreen() == 0 && theColor.getBlue() == 0) {
            colorName = "red";
        }
        else if(theColor.getRed() == 0 && theColor.getGreen() == 255 && theColor.getBlue() == 0) {
            colorName = "green";
        } else{
            colorName = "black";
        }
    }

    /**
     * This method is to get the cost 
     * 
     * returned the instance variable cost 
     *
     *PRE: none
     *POST: returns the cost
     * @param: none
     * *return: none
     */
    public Money getCost() { 
        return cost;
    }

    /**
     * This method is to set the cost 
     * 
     * made sure the object wasn't null and was an instance of money and then
     * set the money and cost or else I threw an exceptiom
     *
     *PRE: have an object
     *POST: sets the cost of the object
     * @param: object
     * *return: none
     */
    public void setCost(Object ob){
        if(ob != null && (ob instanceof Money)){
            Money m = (Money) ob;
            cost = m;
        }else{
            throw new PizzaException("Invalid Cost");
        }
    }

    /**
     * This method is to set the calories
     * 
     * made sure the invairents were followed and then set the calories
     * to the passed in int or else i threw an exception
     *
     *PRE: have int passed in
     *POST: sets the calroies
     * @param: int
     * *return: none
     */
    public void setCalories(int c) {
        if(c > 0){
            calories = c;
        }
        else{
            throw new PizzaException("Invalid calories");
        }
    }

    /**
     * This method is to get the calories 
     * 
     * returned the instance variable calories
     *
     *PRE: none
     *POST: returns the calories
     * @param: none
     * *return: none
     */
    public int getCalories() { 
        return calories;
    }

    /**
     * This method is to compare based on cost
     * 
     * used the money compare to function
     *
     *PRE: have an object
     *POST: comapres object by cost
     * @param: object
     * *return: none
     */
    public int compareTo(Object ob) {
        if(ob == null || !(ob instanceof Ingredient)){
            throw new PizzaException("error");
        }
        return this.cost.compareTo(((Ingredient) ob).cost);
    }
    
    /**
     * This method is to check if the object is equal 
     * 
     * made sure to follow the invairents and then
     * comapred the cost, calories, and description
     *
     *PRE: Object to pass in
     *POST: true or false of object
     * @param: none
     * *return: none
     */
    public boolean equals(Object ob){
        if(ob == null){
            throw new PizzaException("error");
        }
        if(!(ob instanceof Ingredient)){
            throw new PizzaException("error");
        }
        Ingredient other = (Ingredient) ob;
        return this.cost.equals(other.cost) && this.calories == other.calories && this.description.equals(other.description);
    }

    /**
     * This method is to print the message
     * 
     * stored the desciption, calories and cost in a variable and returned it
     *
     *PRE: none
     *POST: returns the description, calories, and cost of the ingredient as a string
     * @param: none
     * *return: string
     */
    public String toString(){
        String retVal = "";
        retVal += getDescription() + "(" + getCalories() + " calories; " + getCost() + ")";
        return retVal;
    }

}
