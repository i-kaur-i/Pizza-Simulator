import java.awt.Color;
/**
 * This class is for peppers and it extends Vegetable
 *
 * @author Iakjot Kaur 
 * @version May 28th, 2020
 */
public class Pepper extends Vegetable
{   
    // instance variables
    public static final int calories = 50;
    public static final Money cost = new Money(0,55);
    public static final String description = " local grown peppers ";
    
    /**
     * This constructor calls the cheese constructor
     * 
     * this constructor calls the vegetable constructor with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: none
     * *return: none
     */
    public Pepper(Color color) {
        super(description, cost, calories, color);
    }
}
