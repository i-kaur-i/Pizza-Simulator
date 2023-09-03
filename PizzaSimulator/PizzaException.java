
/**
 * This class extends the RuntimeException and has two methods
 * for a message
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class PizzaException extends RuntimeException
{   /**
     * This method is to print the message
     * 
     * called the super class
     *
     *PRE: none
     *POST: constructor called
     * @param: none
     * *return: none
     */
    public PizzaException() {
        super();
    }
    
    /**
     * This method is to print the message 
     * 
     * called the super class and printed the message passed in
     *
     *PRE: string passed in
     *POST: constructor called with string
     * @param: none
     * *return: none
     */
    public PizzaException(String m){
        super(m);
    }

}
