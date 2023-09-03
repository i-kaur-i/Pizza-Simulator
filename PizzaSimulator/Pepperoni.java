
/**
 * This class is for pepperoni and it extends meat
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Pepperoni extends Meat
{
    // instance variables
    public static final int calories = 200;
    public static final String description = "spicy pepperoni";
    public static final Money cost = new Money(0,85);
    
     /**
     * This constructor calls the base
     * 
     * this constructor calls the base with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: none
     * *return: none
     */
    public Pepperoni() {
        super(description, cost, calories);
    }

}
