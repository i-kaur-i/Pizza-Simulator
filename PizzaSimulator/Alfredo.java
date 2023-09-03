
/**
 * Write a description of class Alfredo here.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Alfredo extends Base
{
    public static final int calories = 535;
    public static final String description = "Alredo from the jar ";
    public static final Money cost = new Money(0,25);
    
    
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
    public Alfredo() {
        super(description, cost, calories);
    }
}
