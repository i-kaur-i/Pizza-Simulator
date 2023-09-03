
/**
 * This class is for the mozzarella and it extends cheese
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Mozzarella extends Cheese
{
    // instance variables
    public static final int calories = 113;
    public static final Money cost = new Money(0,65);
    public static final String description = " Fresh Mozzarella ";
    
     /**
     * This constructor calls the cheese constructor
     * 
     * this constructor calls the cheese constructor with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: none
     * *return: none
     */
    public Mozzarella() {
        super(description, cost, calories);
    }
}
