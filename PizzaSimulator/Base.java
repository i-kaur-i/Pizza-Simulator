
/**
 * This class is for the base of the pizza and it extends the ingredient 
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Base extends Ingredient
{   
    /**
     * This constructor makes the base
     * 
     * this constructor calls the super class Ingredient's constructor 
     *
     *PRE: none
     *POST: calls constructor
     * @param: string, money, int
     * *return: none
     */
    public Base(String description, Money cost, int calories) {
        super(description, cost, calories);
    }

}
