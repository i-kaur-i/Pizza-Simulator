/**
 * This class is about creating an arraylist to store
 * and remove objects.
 * 
 * It has methods to check if the spots are empty or full.
 * It also has a method to find what object you are looking
 * for by the index and you can get an index of the object.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class ArrayList<p>
{   
    // instance variables
    private int max = 100;
    private Object[] arrayL = new Object[max];
    private int numElem = 0;

    /**
     * This method is to put objects in the array by an index.
     * 
     * If the index is less than 0 or nothing inputed then there is an error.
     * If the index inputed is larger than the array then I resize it to
     * make it work.
     * If the array has nothing in it, then the object gets added
     * and the element gets updated.
     *
     *PRE: have object and index
     *POST: inserts the object to the arrayList at a certain index
     * @param: object, int
     * *return: none
     */
    public void insert(p obj, int index){
       Object val = 0;
       if(index < 0){
            throw new PizzaException("error");
        }
       if( obj == null){
            throw new PizzaException("error");
        } 
      
       if( index > arrayL.length){
            Object[] tempArrayL = new Object[index +1];
            for(int i=0; i < arrayL.length; i++){
                tempArrayL[i] = arrayL[i];
            }
            arrayL = tempArrayL;
            numElem = index;
            for(int i=0; i < size(); i++){
                arrayL[i+1] = arrayL[i];
            }
            arrayL[index] = val;
            numElem++;  
            
        }

       if(arrayL[index] == null){
            arrayL[index] = obj;
            numElem++;
        }
        else{
            arrayL[index] = obj;   
        }

    }
    
    /**
     * This method is to add
     * 
     *used insert method to add the object and the element
     *
     *PRE: have an object
     *POST: adds the object 
     * @param: p
     * return: none
     */
    public void add(p o){
        insert(o, numElem);
    }

    /**
     * This method is to remoce the object from the array.
     * 
     * When the index is less than zero, then there is an error.
     * When there is space available at that index then there is an error.
     * Created a temp object to store the information 
     * then looped through and expanded the index
     * If the array has nothing in it then I subtracted the element count.
     * Then I returned the temp array.
     *
     *PRE: index
     *POST: removes the object at a certain index
     * @param: int
     * *return: Object
     */

    public Object remove(int index){
        if( index <0){
            System.out.println("error");
            return null;
        }
        else if(arrayL[index] == null){
            System.out.println("error");
            return null;
        }

        Object tempObj = arrayL[index];
        numElem = index;
        for(int i=0; i<size()-1; i++){
            arrayL[index] = arrayL[index + 1];
        }

        arrayL[index] = null;
        numElem--; 

        return tempObj;
    }

    /**
     * This method is to get the size of the array.
     * 
     * I returned the length of the array.
     *
     *PRE: have an arrayList
     *POST: return the length of the array 
     * @param: none
     * *return: int
     */

    public int size(){
        return this.arrayL.length;
    }

    /**
     * This method is to print out the objects with commas.
     * 
     * Started off with the temp string and then looped through the array.
     * When the spot in the array is not taken, I add it to the list
     * and then I return it.
     *
     *PRE: have an array filled with objects
     *POST: return the temp string 
     * @param: none
     * *return: String
     */

    public String toString(){
        String tempObj = "";
        for(int i=0; i<arrayL.length;i++){
            if(arrayL[i] != null){
                tempObj+= arrayL[i] + " , ";
            }
            else{
                return "";
            }
        }
        return tempObj;
    }

    /**
     * This method is to check if the array is empty.
     * 
     * Started with 2 counters, one for true count the other for false.
     * looped through the array and if the spot is available
     * then I incremented the true count(c), if its not available, then
     * I incremented the false count (count).
     * Then I made sure the counts were more than zero.
     *
     *PRE: have an array
     *POST: return true or false based on if the array is empty or not
     * @param: none
     * *return: boolean
     */

    public boolean isEmpty(){
        int count=0;
        int c=0;
        for(int i=0; i<size();i++){
            if(arrayL[i] == null){
                c++;
            }
            else{
                count++;
            }
        }

        if( c < 0){
            return false;
        }
        else{
            return true; 
        }
    }

    /**
     * This method is to find the index of the object.
     * 
     * I started with creating a variable to keep track.
     * Then I looped through the array to find where the inputted 
     * object is located and if found, I stored it in the tracker.
     * If not found then I returned -1.
     *
     *PRE: have an array full of objects and make sure the object is in the array
     *POST: return the index of where the object is located in the array.
     * @param: Object
     * *return: int
     */

    public int indexOf(Object ob){
        int t = 0;
        for(int i=0; i<arrayL.length;i++){
            if(arrayL[i] == ob){
                t = i;
            }
            else{
                t= -1;
            }
        }
        return t;
    }

    /**
     * This method is to check if the objects are equal to each other.
     * 
     * I made sure the object was an instance of the class and if that was true,
     * I made an object of the class and used that to compare
     * the sizes of the objects and looped through to see if 
     * the elements match. If they don't then I returned false.
     *
     *PRE: have an object
     *POST: return true or false based on the check for matching.
     * @param: Object
     * *return: boolean
     */

    public boolean equals(Object other){
        if(other instanceof ArrayList == true){
            ArrayList theObj = (ArrayList) other;
            if(theObj.size() == this.size()){
                for(int i=0; i<= size(); i++){
                    if(this.arrayL[i] == theObj.arrayL[i]){
                        return true;
                    }else{
                        return false;
                    } 
                }
            }
        }
        else{
            return false;
        }
        return false; 
    }

    /**
     * This method is to get the index of the object.
     * 
     * If the array index is there and less than the elements then
     * I return the index but if its not then it is out of
     * bounds.
     *
     *PRE: have a valid Pizza to find
     *POST: return the Pizza based on the index
     * @param: int
     * *return: Object[]
     */

    public Pizza get(int index){
        if(arrayL[index] != null && index < numElem){
            return (Pizza) arrayL[index];
        }
        else{
            System.out.println("Index is out of bounds.");
            return null;
        }
    }
    
    /**
     * This method is to set the Pizza object at a certain index
     * 
     *Followed the invairents and threw an error. If there is no error then I 
     *stored and got the index into the arraylist
     *
     *PRE: have a pizza and an index
     *POST: sets the pizza
     * @param: Pizza, int
     * return: Pizza
     */
    public Pizza set(Pizza object, int index){
        if(index<0 || index > numElem){
            throw new RuntimeException("error");
        }
        Pizza elem = get(index);
        arrayL[index] = object;
        return elem;
    }
    
    /**
     * This method is to get the object at an index passed in. 
     * 
     * I made sure the invairents were followed and if they were
     * I returned the arraylist object based on the index. 
     *
     *PRE: have an object and index to pass in
     *POST: find the object at the index
     * @param: int
     * return: Object
     */
    public Object objectAt(int index){
        if(index < numElem){
            return arrayL[index];
        }else{
            throw new IllegalArgumentException();
        }
    }
    
   
}
