import java.util.Scanner;
/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 *
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 *
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {
    /*
     *  TODO: Data definitions here. 
     */
    ArrayList<Pizza> pizza = new ArrayList();
    private int pizzaCount = 0;
    /**
     * The console interface is defined in the start method
     * You can exit or extend the code below to accomplish all of
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';
        Scanner foo = new Scanner(System.in);
        while(true) {
            displayAllPizzas();
            displayInstructions();
            //foo.nextChar() doesn't exist, so now what?
            selection = foo.nextLine().substring(0,1).toCharArray()[0];
            switch(selection) {
                case 'A':   
                case 'a': System.out.println("Adding a random pizza to the ArrayList<Pizza>");
                //todo: 
                addRandomPizza();
                break;
                case 'H':   
                case 'h':    System.out.println("Adding one hundred random pizzas to the ArrayList<Pizza>.");
                //todo:
                for(int i=0; i < 100; i++){
                    addRandomPizza();
                }
                break;                   
                case 'E':   
                case 'e':    System.out.println("Eating a fraction of a pizza. How much? (a/b)");
                //todo:pizza eating code here
                eatSomePizza(foo);
                break;           
                case 'P':   
                case 'p':     System.out.println("Sorting pizzas by (P)rice");
                //todo:
                sortByPrice();
                break;   
                case 'S':   
                case 's':     System.out.println("Sorting pizzas by (S)ize");
                //todo:
                sortByPrice();
                break;         
                case 'C':   
                case 'c':      System.out.println("Sorting pizzas by (C)alories");
                //todo
                sortByCalories();
                break;
                case 'B':
                case 'b':    System.out.println("(B) inary search over pizzas by calories(int). Sorting first. What calorie are you looking for?");
                //todo:
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                //todo:
                System.exit(0);
                //break;
                default:    System.out.println("Unrecognized input - try again");
            }
        }
    }
    
    /**
     * This method is to eat the pizza 
     * 
     * made sure to check the invarients and asked the user to
     * enter how much they would like to eat and stored the information
     *
     *PRE: scanner
     *POST: eats the pizza
     * @param: Scanner
     * *return: none 
     */
    private void eatSomePizza(Scanner keys) {
        //todo:

        if(pizza.size() == 0){
            System.out.println("no pizzas");
            return;
        }
        System.out.println("enter the index of pizza you want to eat");
        System.out.println("the valid indexes are 0- " + (pizza.size() -1) + ")");

        int indexPizza = keys.nextInt();
        keys.nextLine();

        if(indexPizza >= pizza.size()){
            System.out.println("error, not a valid index");
            return;
        }
        if(indexPizza < 0){
            System.out.println("error, not a valid index");
            return;
        }
        Pizza pizz = pizza.get(indexPizza);

        System.out.println("\n enter the fraction amount of pizza you want to eat from the remaining pizza ");
        String input = keys.nextLine();

        String[] numSplit = input.split("/");
        int num = Integer.parseInt(numSplit[0]);
        int den = Integer.parseInt(numSplit[1]);

        Pizza t = null;

        try{
            t = (Pizza) pizza.objectAt(indexPizza);
            t.eatSomePizza(new Fraction(num,den));
            System.out.println("eating " + input);
            if(t.getRemaining().getNumerator() == 0){
                pizza.remove(indexPizza);
                pizzaCount--;
            }else{
                System.out.println("remaining pizza: " + t.getRemaining());
            }
        }catch(PizzaException e){
            throw new PizzaException();
        }

    }

    /**
     * This method is to add random pizza
     * 
     * used the add method to add a new pizza
     *
     *PRE: none
     *POST: adds random pizza
     * @param: none
     * *return: none
     */
    private void addRandomPizza() {
        //todo:  
        pizza.add(new Pizza());
    }

    /**
     * This method is to display all of the pizzas
     * 
     * looped through the array list
     *
     *PRE: have pizzas 
     *POST: displays all the pizzas
     * @param: none
     * *return: none
     */
    private void displayAllPizzas() {
        //todo:
        for(int i=0; i<pizza.size(); i++){
            System.out.println(pizza.get(i));
        }
    }
    
    /**
     * This method is to sort the pizzas by price  
     * 
     * looped through the pizza and then made a nested loop to compare
     * it with the smallest price to find the smalled price 
     * and then I stored and set the pizza
     *
     *PRE: none
     *POST: sorts the pizza by price
     * @param: none
     * *return: none
     */
    private void sortByPrice() { 
        //todo:
        for(int i=0; i< pizza.size(); i++){
            int small = i;
            for(int j =i; j < pizza.size(); j++){
                if(pizza.get(j).compareTo(pizza.get(small)) == -1){
                    small = j;
                }
            }
            Pizza t = pizza.set(pizza.get(small), i);
            pizza.set(t,small);
        }

    }
    
    /**
     * This method is to sort the pizzas by size  
     * 
     * looped through the pizza and then made a nested loop to compare
     * it with the smallest size to find the smalled size 
     * and then I stored and set the pizza
     *
     *PRE: none
     *POST: sorts the pizza by size
     * @param: none
     * *return: none
     */
    private void sortBySize() {
        //todo:
        for(int i=0; i< pizza.size(); i++){
            int small = i;
            for(int j =i; j < pizza.size(); j++){
                if(pizza.get(j).compareToBySize(pizza.get(small)) == 1){
                    small = j;
                }
            }
            Pizza t = pizza.set(pizza.get(small), i);
            pizza.set(t,small);
        }

    }
    
    /**
     * This method is to sort the pizzas by calories
     * 
     * looped through the pizza and then made a nested loop to compare
     * it with the smallest calories to find the smalled calories
     * and then I stored and set the pizza
     *
     *PRE: none
     *POST: sorts the pizza by calories
     * @param: none
     * *return: none
     */
    private void sortByCalories() {
        //todo:
        for(int i=0; i< pizza.size(); i++){
            int small = i;
            for(int j =i; j < pizza.size(); j++){
                if(pizza.get(j).compareToByCalories(pizza.get(small)) == -1){
                    small = j;
                }
            }
            Pizza t = pizza.set(pizza.get(small), i);
            pizza.set(t,small);
        }

    }
    
    /**
     * This method is to do a binary search by calories 
     * 
     * set all my variables that I need 
     * and made a while loop to find the middle
     *
     *PRE: none
     *POST: sorts the pizza by price
     * @param: none
     * *return: none
     */
    private int binarySearchByCalories(int cals) {
        if(pizza.size() == 0) {
            return -1;
        } else if(pizza.size() == 1) {
            return pizza.get(0).getCalories() == cals ? 0 : -1;
        }
        
        int high = pizza.size() - 1;
        int low  = 0;
        
        while(low <= high) {
            int mid = (high + low) / 2;
            int middleCals  = pizza.get(mid).getCalories();
            
            if(middleCals > cals) {
                high = mid - 1;
            } else if(middleCals == cals) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        
       
        if(pizza.get(pizza.size() - 1).getCalories() == cals) {
            return pizza.size() - 1;
        }
        
        return -1;
    }
    private static final String instructions = "-----------------------\nWelcome to PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza\nBONUS ROUND - QuickSorting pizzas by (F)raction\nQuickSort pizzas by (P)rice\nQuickSort pizzas by (S)ize\nQuickSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(R)everse order of pizzas with a stack\n(Q)uit\n";

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */

    // private static final String instructions = "-----------------------\nWelcome to
    //PizzaManager\n-----------------------\n(A)dd a random pizza\nAdd a (H)undred random
    //pizzas\n(E)at a fraction of a pizza\nSort pizzas by (P)rice\nSort pizzas by (S)ize\
    //nSort pizzas by (C)alories\n(B)inary Search pizzas by calories\n(Q)uit\n";
    private void displayInstructions() {
        System.out.println(instructions);   
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}

