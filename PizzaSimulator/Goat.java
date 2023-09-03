
/**
 * Write a description of class Goat here.
 *
 * @author Iakjot Kaur 
 * @version May 28th, 2020
 */
public class Goat extends Cheese
{
    public static final int calories = 123;
    public static final String description = " Fresh Goat ";
    public static final Money cost = new Money(1,0);
    
   
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
    public Goat() {
        super(description, cost, calories);
    }

}
