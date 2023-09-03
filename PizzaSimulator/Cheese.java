
/**
 * This class is for the cheese and it extends ingredient
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Cheese extends Ingredient
{
     /**
     * This constructor calls the base
     * 
     * this constructor calls the base with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: string, money, int
     * *return: none
     */
    public Cheese(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
}
