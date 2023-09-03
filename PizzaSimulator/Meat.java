
/**
 * This class is for the meat that uses the super class
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Meat extends Ingredient
{   
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
    public Meat(String description, Money cost, int calories) {
        super(description, cost, calories);
    }
}
