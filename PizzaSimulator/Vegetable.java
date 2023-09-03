import java.awt.Color;
/**
 * This class is for the vegetables 
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Vegetable extends Ingredient
{
    // instance variable 
    Color theColor;
    
     /**
     * This constructor calls the base
     * 
     * this constructor calls the base with super with description, money,
     * int, and color
     *
     *PRE: none
     *POST: calls constructor
     * @param: string, money, int, color
     * *return: none
     */
    public Vegetable(String description, Money cost, int calories, Color color) {
        super(description, cost, calories, color);
    }
    
    /**
     * This method is to get the color
     * 
     * returned the instance variable theColor
     *
     *PRE: none
     *POST: returns the color
     * @param: none
     * *return: Color
     */
    public Color getColor() {
        return theColor;
    }
    
     /**
     * This method is to set the color
     * 
     * made sure the object is an instance of color and then set the
     * variables or else threw an exception
     *
     *PRE: have object to pass in
     *POST: sets the color 
     * @param: object
     * *return: none
     */
    public void setColor(Object o){
        if(o != null && o instanceof Color){
            Color that = (Color) o;
            theColor = that;
        }else{
            throw new PizzaException("Invalid color");
        }

    }
    
     /**
     * This method is to check if the object is equal to vegetable
     * 
     * made sure the object is an instance of vegetable and then returned true or false
     * based off if the color was the same
     * 
     * PRE: have object to pass in
     * POST: true or false based on equality
     * @param: object
     * *return: boolean
     */
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Vegetable)){
            throw new PizzaException("Invalid color");
        }
        Vegetable that = (Vegetable) o;
        if(this.theColor == that.theColor){
            return true;
        }
        else{
            return false;
        }
    }

}
