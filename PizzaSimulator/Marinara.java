
/**
 * Write a description of class Marinara here.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Marinara extends Base
{
    public static final int calories = 65;
    public static final String description = " Marinara from the jar ";
    public static final Money cost = new Money(0,30);
    
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
    public Marinara() {
        super(description, cost, calories);
    }
}
