/**
 * This class is about gathering the fraction.
 *
 * In this class, there are 3 constructors storing the numerators and denominators.
 * There are getters and setters so the fraction can change.
 * I have conditions in the setters so the fractions work
 * There is a method to reduce the fraction so you can compare simplified forms.
 * I have a boolean to see if the denominator and numerators match, they if do
 * then they are the same.
 *
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Fraction implements Comparable
{
    // instance variables
    private int numerator;
    private int denominator;

    // default constructor
    public Fraction(){
    }

    /**
     * This method is to initialize the instance variables.
     * 
     * Then I stored the numerator and denominator in seperate variables.
     *
     *PRE: have ints to pass in
     *POST: initializes the variables
     * @param: ints
     * *return: none
     */
    public Fraction(int n, int d){
        this.numerator = n;
        this.denominator = d;
    }

    /**
     * This method is to initialize the instance variables.
     * 
     * Then I stored the numerator and denominator in seperate variables.
     *
     *PRE: have doubles to pass in 
     *POST: initializes the variables
     * @param: double
     * *return: none
     */
    public Fraction(double nn, double nd){
        this.numerator = (int) Math.round(nn);
        this.denominator = (int) Math.round(nd);
    }

    /**
     * This constructor is to copy the fraction
     * 
     * I used the set methods to copy the numerator and denominator
     *
     *PRE: Fraction to pass in
     *POST: initizales the fraction
     * @param: fraction
     * *return: none
     */
    public Fraction(Fraction toCopy){
        setNumerator(toCopy.getNumerator());
        setDenominator(toCopy.getDenominator());
    }

    /**
     * This method is to get the numerator.
     * 
     * I returned the instance variable.
     *
     *PRE: have numerator
     *POST: returns the numerator
     * @param: none
     * *return: none
     */
    public int getNumerator(){
        return this.numerator;
    }

    /**
     * This method is to get the numerator.
     * 
     * I returned the instance variable.
     *
     * @param: none
     * *return: none
     */
    public int getDenominator(){
        return this.denominator;
    }

    /**
     * This method is to set the numerator.
     * 
     * set the instance variable to the parameter passed in
     *
     *PRE: have int to pass in
     *POST: sets the numerator
     * @param: int
     * *return: none
     */
    public void setNumerator(int num){
        this.numerator = num;
    }

    /**
     * This method is to set the denominator
     * 
     * set the instance variable to the parameter passed in
     *
     *PRE: have int to pass in
     *POST: sets the denominator
     * @param: int
     * *return: none
     */
    public void setDenominator(int denominator){
        if(denominator != 0){
            this.denominator = denominator;
        } else if(numerator == 0){
            this.denominator = 0;
        }else if(denominator == 0){
            throw new PizzaException("error");
        }
        else{
            throw new PizzaException("Can't have denominator of 0");
        }
    }

    /**
     * This method is to set the fraction.
     * 
     * The passed in int is stored in the numerator instance variable
     * The passed in int is stored in the denominator only if it doesn't equal zero.
     *
     *PRE: have ints to pass in
     *POST: sets the Fraction
     *
     * @param: int
     * *return: none
     */
    public void setFraction(int theN, int theD){
        this.numerator = theN;
        if(theD == 0){
            System.out.println("Error, denominator can't be zero");
        }
        else{
            this.denominator = theD;
        }
    }

    /**
     * This method is to set the fraction.
     * 
     * The passed in int is stored in the numerator instance variable
     * The passed in int is stored in the denominator only if it doesn't equal zero.
     *
     *PRE: have doubles to pass in 
     *POST: sets the fraction
     *
     * @param: double
     * *return: none
     */
    public void setFraction(double n, double d){
        this.numerator = (int) Math.round(n);
        if(d == 0){
            System.out.println("Error, denominator can't be zero");
        }
        else{
            this.denominator = (int) Math.round(d);
        }
    }

    /**
     * This method is to compare the fraction's and the fraction instance's
     * numerator and denominator.
     * 
     * It returns true if the fraction matches, and false if they are different.
     *
     *PRE: have a Fraction object
     *POST: returns true or false based on equality
     * @param: Fraction
     * *return: boolean
     */
    public boolean equals(Fraction other) {
        if (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator()) {
            return true;
        }
        return false;
    }

    /**
     * This method is to get the greatest common denominator.
     * 
     * If the denominator is zero, I return the passed in in
     * It returns true if the fraction matches, and false if they are different.
     *
     *PRE: have ints
     *POST: returns the greatest common denominator
     * @param: int
     * *return: int
     */
    public int gcd(int n, int d){
        if(d == 0){
            return n;
        }
        return gcd(d, n % d);
    }

    /**
     * This method is to reduce the fraction.
     * 
     * I use the gcd and store it into an int variable
     * Then I stored the numerator and denominator in seperate variables.
     *
     *PRE: none
     *POST: reduced the fraction
     * @param: none
     * *return: none
     */
    public void reduce(){
        int gcdReduced = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcdReduced;
        this.denominator = this.denominator/gcdReduced;

    }

    /**
     * This method is to print the fraction.
     * 
     * returned the numerator over the denominator
     *
     *PRE: none
     *POST: returns the string of a fraction
     * @param: none
     * *return: none
     */
    public String toString(){
        return getNumerator() + "/" + getDenominator();

    }
    
    /**
     * This method is to clone the fraction.
     * 
     * returned the fraction
     *
     *
     * @param: none
     * *return: none
     */
    public Fraction clone(){
        return new Fraction(this);
    }
    
    /**
     * This method is to subtract the fraction
     * 
     * initialzed the numerator and denominator
     * if the denominator and the input denominator are the same i subtracted
     * 
     *
     *
     * @param: object
     * *return: object
     */
    public Fraction subtract(Fraction amt){
        int num = 0;
        int den= 0;
        
        if(getDenominator() == amt.getDenominator()){
            den = getDenominator();
            num = (getNumerator() - amt.getNumerator());
            return new Fraction(num,den);
        }
        else{
            num = (getNumerator() * amt.getDenominator()) - (amt.getNumerator() * getDenominator());
            den = getDenominator() * amt.getDenominator();
            return new Fraction(num,den);
        }
    }
    
    /**
     * This method is to compare
     * 
     * made sure the invairents are followed.
     *
     *
     * @param: object
     * *return: none
     */
    public int compareTo(Object o) {
        if(o == null || !(o instanceof Fraction)){
            throw new PizzaException("invalid input");
        }
        Fraction that = (Fraction) o;
        if(this.equals(that)){
            return 0;
        }
        Fraction temp = this.clone();
        return temp.numerator;
    }

}
