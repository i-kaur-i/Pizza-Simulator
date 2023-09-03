
import java.io.Serializable;
/**
 * The money class is to represent how much money
 * you have in total. Two variables are used to keep track of
 * the dollars and cents. The cents and dollars will always be 
 * positive and the cents can't exceed 99.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Money implements Comparable<Money>, Cloneable, Serializable
{
    // instance variables
    private int dollars;
    private int cents;
    
     /**
     * This method is to initalize the dollars.
     * 
     * I made sure the dollars passed is larger or equal to zero.
     * And then I set it to the int being passed. If the condition isn't 
     * true, an error message is displayed.
     * I initalzed the cents to zero.
     *
     *PRE: int to pass in
     *POST: initializes variables
     * @param: int
     * *return: none
     */
    public Money(int doll){
         if(doll >= 0){
            this.dollars = doll;
        }
        else{
            System.out.println("Error dollars have to be positive or 0");
            return;
        }
        this.cents = 0;
    }
    
     /**
     * This method is to initalize the dollars and cents.
     * 
     * I made sure that the dollars being passed in is greater or equal to zero.
     * And then I initalized it, if not then I showed an error message. 
     * I made sure that the cents are between zero and 99 and then initalized it.
     *
     *PRE: ints to pass in for dollar and cent
     *POST: initialzes varibales
     * @param: int
     * *return: none
     */
    public Money(int doll, int cent){
        dollars = doll;
        if(cents > 99){
           dollars +=1;
           cents = cents -100;
        }
        else{
           cents = cent;
        }
    }
    
    /**
     * This method is to set the dollars and cents to the money object being passed in.
     * 
     * I made sure the money object isn't null and an instance of money, and
     * if it wasn't, then I initialzed the dollars and cents to the money object.
     * Showed an error message if the condition wasn't true.
     *
     *PRE: have money object to pass in
     *POST: intializes the Money
     * @param: Object
     * *return: none
     */
    public Money(Money other){
        if(other !=null && other instanceof Money == true){
            dollars = other.dollars;
            cents = other.cents;
        }
        else{
            System.out.println("Error");
            return;
        }
    }
    
    /**
     * This method is to set the dollars
     * 
     * checked invarients and set the dollars
     *
     *PRE: int passed in
     *POST: sets the dollars
     * @param: none
     * *return: none
     */
    public void setDollars(int dollars){
         if(dollars >= 0){
            this.dollars = dollars;
        }else{
            return;
        }
    }
    
    /**
     * This method is to set the cents
     * 
     * checked invarients and set the cents
     *
     *PRE: int passed in
     *POST: sets the cents
     * @param: none
     * *return: none
     */
     public void setCents(int c){
        if(c >=0 && c <= 99){
            this.cents = c;
        }else{
            return;
        }
    }
    
     /**
     * This method is to set the money, so the dollars and cents.
     * 
     * In order to set the money, first I made sure the invarients were met.
     * Like the dollar has to be equal to zero or greater than zero.
     * The cents have to be between zero and 99.
     * If the conditions are met, then I used the dollar and cent set methods
     * to set the dollars and cents being passed in.
     * 
     *PRE: have ints to pass in
     *POST: sets the money
     * @param: Object
     * *return: none
     */
    public void setMoney(int doll, int c){
        if(doll >= 0){
            setDollars(doll);
        }
        else{
            System.out.println("Error dollars have to be positive or 0");
            return;
        }

        if(c >= 0 && c <= 99){
            setCents(c);  
        }else{
            System.out.println("Error cents have to be positive or 0 and less than 99");
            return;
        }
    }
    
    /**
     * This method is to get the cents.
     * 
     * I returned the cents from the instance variable
     *
     *PRE: none
     *POST: returns the cents
     * @param: none
     * *return: int
     */
    public int getCents(){
       return cents;
    }
    
    /**
     * This method is to get the dollars.
     * 
     * I returned the dollars from the instance variable. 
     *
     *PRE: none
     *POST: returns the dollars
     * @param: none
     * *return: int
     */
    public int getDollars(){
        return dollars;
    }
    
    /**
     * This method is to get the money.
     * 
     * I returned the dollars and cents.
     *
     *PRE: none
     *POST: returns the money as double
     * @param: none
     * *return: double
     */
    public double getMoney(){
       return dollars + cents/100;
    }
    
    /**
     * This method is to add the dollars to existing dollars. 
     * 
     * I added the int being passed in to the current dollars and then
     * made it equal to that.
     *
     *PRE: int passed in
     *POST: adds to the dollars
     * @param: int
     * *return: none
     */
    public void add(int d){
       dollars += d;
    }
    
     /**
     * This method is to add the dollars and cents to the existing dollars.
     * 
     * I added the ints being passed in to either the dollars and cents that
     * are already there. And then I made it the current.
     *
     *PRE: ints passed in
     *POST: adds to the dollars and cents
     * @param: int
     * *return: none
     */
     public void add(int dol, int cents){
        dollars += dol;
        cents += cents;
    }
    
     /**
     * This method is to add the money object.
     * 
     * First I made sure the condition is met and then added to the
     * current dollar and cents. I added to the object to the current
     * dollar and cents as well and made it the current.
     *
     *PRE: money object to pass in
     *POST" adds to the dollars and cents
     * @param: Oject
     * *return: none
     */
      public void add(Money other){
        if(cents > 99){
            this.dollars +=1;
            this.cents += this.cents % 100;
        }
        this.dollars += other.dollars;
        this.cents += other.cents;
    }
    
    /**
     * This method is to check if the moneys are equal to each other.
     * 
     *  I made sure the dollars and the object dollar, the cents and the 
     *  object cents are equal to each othr, then I returned true.
     *  If its not then I returned false.
     *
     *PRE: money object to pass in
     *POST: true or false based on equality
     * @param: Object
     * *return: boolean
     */
     public boolean equals(Money o){
        Money other = (Money) o;
        if(this.getDollars() == o.getDollars() && this.getCents() == o.getCents()){
            return true;
        }else{
            return false;
        }

    }
    
    /**
     * This method is to print out the money.
     * 
     * I returned the get money method to get the dollars and cents.
     * And then added the money symbol next to it.
     *
     *PRE: none
     *POST: returns the money as a string
     * @param: none
     * *return: String
     */
    public String toString(){
        return "$ " + getMoney(); 
    }
    
     /**
     * This method is to compare the money
     * 
     * I compared the class data with the money object data to see if they
     * matched and then returned the money.
     *
     *PRE: money object to compare
     *POST: comapres the money object by class
     * @param: object
     * *return: int
     */
    @Override
    public int compareTo(Money m){
       if(getClass() != m.getClass()){
          throw new IllegalArgumentException();
       }
       return Double.compare(m.getMoney(),getMoney());
    }
    
     /**
     * This method is to clone the money
     * 
     * Used a try and catch statement to clone the money and to catch any 
     * errors along the way.
     *
     *PRE: none
     *POST:clones
     * @param: object
     * *return: int
     */
    public Money clone(){
       Money mon;
       try{
          mon = (Money) super.clone();
          return mon;
       }catch(CloneNotSupportedException e) {
          e.printStackTrace();
          throw new RuntimeException();
       }
    }
}
