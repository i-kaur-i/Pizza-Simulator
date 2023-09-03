
/**
 * This class is for the sausage and it extends meat
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Sausage extends Meat
{
    // instance variables
    public static final int calories = 229;
    public static final Money cost = new Money(1,05);
    public static final String description = " Italian sausage ";
    
     /**
     * This constructor calls the meat constructor
     * 
     * this constructor calls the meat contructor with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: none
     * *return: none
     */
    public Sausage() {
        super(description, cost, calories);
    }

}
