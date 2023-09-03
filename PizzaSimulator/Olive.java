import java.awt.Color;
/**
 * This class is for olive and it extends the vegetable 
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Olive extends Vegetable
{
    public static final int calories = 115;
    public static final String description = " juicy olives ";
    public static final Money cost = new Money(0,50);
    
     /**
     * This constructor calls the vegetable constructor
     * 
     * this constructor calls the vegetable constructor with super
     *
     *PRE: none
     *POST: calls constructor
     * @param: none
     * *return: none
     */
    public Olive(Color color) {
        super(description, cost, calories, color);
    }

} 
