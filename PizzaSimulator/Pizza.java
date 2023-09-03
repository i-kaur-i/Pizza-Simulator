import java.awt.Color;
/**
 * This class is for the pizza and it has attributes of the
 * pizza and methods that make a pizza. The pizza class implements PizzaComparable
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Pizza implements PizzaComparable
{
    private Money price = new Money(0,0);
    private Fraction size = new Fraction();
    private Shape myShape;
    private int calories;
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private Fraction remainingSize = new Fraction(1,1);

    /**
     * This constructor is to make a pizza
     * 
     * random shapes,amounts, bases, cheese are added. Then the toppings are
     * added to the pizza while keeping track of the ingredients and price
     *
     *PRE: none
     *POST: creating pizza
     * @param: none
     * *return: none
     */
    public Pizza() {
        //circle or square
        if(Math.random() > 0.5){
            Circle cir = new Circle(2,3,4);
            myShape = cir;
        }
        else{
            Square sh = new Square(2,2,2,2);
            myShape = sh;
        }

        setShape(myShape);

        //base
        Ingredient s;
        if(Math.random() > 0.5){
            ingredients.add(new Alfredo());
        }
        else{
            ingredients.add(new Marinara());
        }
        addIngredient(s);

        //cheese
        Ingredient cheese;
        if(Math.random() < 0.5){
            ingredients.add(new Mozzarella());
        }
        else{
            ingredients.add(new Goat());
        }
        addIngredient(cheese);

        double veggie = Math.random();
        ingredients.add( new Pepper(Color.GREEN));

        Ingredient meat;
        if(Math.random() > 2){
            ingredients.add(new Pepperoni());
        }
        else{
            ingredients.add(new Sausage());
        }
        addIngredient(meat);

        int ingredientDoll = 0;
        int ingredientCents = 0;
        int currCents = 0;
        int currDollars = 0;


    }
    
    /**
     * This method is to get the cost
     * 
     * returned the price 
     *
     *PRE: have Money
     *POST: returns the cost
     * @param: none
     * *return: Money
     */
    public Money getCost(){
        return price.clone();
    }

    /**
     * This method is to get the calories 
     * 
     * returned the instance variable calories
     *
     *PRE: have calories
     *POST: return the calories
     * @param: none
     * *return: int
     */
    public int getCalories(){
        return calories;
    }

    /**
     * This method is to get the remaining area of the pizza
     * 
     * got the numerator and denominator of the fraction of pizza and then
     * divided the numerator and denominator and stored it in a variable
     * and then returned the the area of my shape with the fraction that was remaining
     *
     *PRE: none
     *POST: returns the remaining area
     * @param: none
     * *return: none
     */
    public double getRemainingArea(){
        double denom = (double) size.getDenominator();
        double num = (double) size.getNumerator();
        double amountAvail = num/denom;

        return myShape.getArea() * amountAvail;
    }
    
    /**
     * This method is to get the remaning size of the Fraction
     * 
     * returned the instance variable of remainingSize
     *
     *PRE:have a Fraction of size
     *POST: returns the remaining size
     * @param: none
     * *return: int
     */
    public Fraction getRemaining(){
        return remainingSize; 
    }
    
    /**
     * This method is to get the calories 
     * 
     * returned the instance variable calories
     *
     *PRE: have a Fraction
     *POST: sets the remaining size 
     * @param: none
     * *return: int
     */
    public void setRemaining(Fraction f){
        if(f.compareTo(new Fraction(0,0)) == -1){
            throw new PizzaException("error");
        } 
        if(f.compareTo(new Fraction(1,1)) == 1){
            throw new PizzaException("error");
        }
        this.remainingSize = f;

    }

    /**
     * This method is to set the shape 
     * 
     * used the clone method to set the shape to myShape
     *
     *PRE: have a shape
     *post: sets the shape
     * @param: Shape
     * *return: none
     */
    public void setShape(Shape s) {
        myShape = (Shape)s.clone();
    }

    /**
     * This method is to get the shape 
     * 
     * used the clone method to get the shape 
     *
     *PRE: have a shape
     *POST: gets the shape
     * @param: none
     * *return: Shape
     */
    public Shape getShape() {
        return (Shape) myShape.clone();
    }
    
    /**
     * This method is to clone the pizza
     * 
     * used a try catch block to check any invarients and used parent constructor
     * of clone
     *
     *PRE: none
     *POST: clone
     * @param: none
     * *return: Pizza
     */
    public Pizza clone(){
        Pizza piz;
        try{
            piz = (Pizza) super.clone();
            return piz;
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    /**
     * This method is to add Ingredient
     * 
     * if the object passed in is null then I threw an error 
     * if it wasn't I added the object to ingredients, calories, and price updated
     *
     *PRE: have an ingredient to add
     *POST: updates the indegredients. calories, and price
     * @param: none
     * *return: int
     */
    public void addIngredient(Ingredient a){
        if(a == null){
            throw new PizzaException("error");
        }
        ingredients.add(a);
        calories += a.getCalories();
        price.add(a.getCost());

    }

    /**
     * This method is to get the fraction 
     * 
     * returned size
     *
     *PRE: have a Graction
     *POST: returns the fraction
     * @param: none
     * *return: Fraction
     */
    public Fraction getFraction(){
        return remainingSize;
    }

    /**
     * This method is to set the fraction 
     * 
     * used the set methods of numerator and denominator to set the fraction
     *
     *PRE: have ints to pass in 
     *POST: sets the fraction
     * @param: int
     * *return: none
     */
    public void setFraction(int num, int denom){
        size.setNumerator(num);
        size.setDenominator(denom);
    }
    
    /**
     * This method is to eat some of the pizza by passing in a Fraction
     * 
     * stored the fraction as a new fraction with the remaining size subtracted with the amount
     * and then stored it. 
     *
     *PRE: Fraction
     *POST: eat the pizza and hsve the remaining size 
     * @param: Fraction
     * *return: none
     */
    public void eatSomePizza(Fraction amt){
        if(remainingSize.getNumerator() == 0){
            throw new PizzaException("error");
        }
        if(amt.getNumerator() < 0){
            throw new PizzaException("error");
        }
        Fraction remain = new Fraction(remainingSize.subtract(amt));
        remainingSize = remain;

    }
    
    /**
     * This method is to comapre the object by price 
     * 
     * made sure the invarients are followed and then comapred the objects
     * with the costs, if not followed, threw an error
     *
     *PRE: have an object
     *POST: comapres the object by price
     * @param: object
     * *return: int 
     */
    public int compareTo(Object o) {
        if(o != null && o instanceof Pizza){
            Pizza that = (Pizza) o;
            return this.getCost().compareTo(that.getCost());
        }
        else{
            throw new PizzaException("Invalid");
        }
    }
    
    /**
     * This method is to comapre the object  by size 
     * 
     * made sure the invarients are followed and then comapred the objects
     * with the size, if not followed, threw an error
     *
     *PRE: have an object
     *POST: comapres the object by size
     * @param: object
     * *return: int 
     */
    public int compareToBySize(Object ob){
        Pizza other = (Pizza) ob;
        if(ob != null || (ob instanceof Pizza)){
            return (int)(this.getRemainingArea() - other.getRemainingArea());
           
        }else{
            throw new PizzaException("error");
        }
    }
    
    /**
     * This method is to comapre the object by calories
     * 
     * made sure the invarients are followed and then comapred the objects
     * with the calories, if not followed, threw an error
     *
     *PRE: have an object
     *POST: comapres the object by calories
     * @param: object
     * *return: int 
     */
    public int compareToByCalories(Object o){
        if(o == null || !(o instanceof Pizza)){
           throw new PizzaException("error");
        } 
        else{
            Pizza other = (Pizza) o;
            return this.calories - other.calories;
        }
    }
  
    /**
     * This method is to print out the information about pizza  
     * 
     * stored the message and looped through the ingredients 
     * and then I returned the message
     *
     *PRE: none
     *POST: returns the message as a string
     * @param: none
     * *return: String
     */
    public String toString(){
        String message = "the cost of the pizza is " + price + "\nthe calories are " + calories + "\nsize of pizza is " + getRemainingArea() + "\nwith ingredients:\n";
        for(int i=0; i < ingredients.size(); i++){
            message += ingredients.get(i) + "\n";
        }
        return message; 
    }

}
