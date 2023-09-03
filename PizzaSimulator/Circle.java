import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This class is to build and draw a circle. I used the radius to 
 * make the circle and then caluclated the area. This is from the lab.
 *
 * @author Iakjot Kaur
 * @version May 28th, 2020
 */
public class Circle extends Shape
{   
    // instance variable
    private int radius;

    /**
     * This constructor is to initalize the circle variable and to use the super class.
     * 
     * I passed in parameters and used the super class.
     * And then I set the set radius method to set the radius.
     *
     *PRE: ints for parameters
     *POST: initialzes variables
     * @param: int
     * *return: none
     */
    public Circle(int x, int y, int radius){
        super(x,y);
        setRadius(radius);
    }

    /**
     * This method is to get the radius of the circle.
     * 
     * I returned the instance variable of the radius.
     *
     *PRE: none
     *POST: returns the radius
     * @param: none
     * *return: double
     */
    public double getRadius(){
        return radius;
    }

    /**
     * This method is to set the radius of the circle.
     * 
     * I set the instance variable radius to the parameter passed in.
     *
     *PRE: int to pass in
     *POST: sets the radius
     * @param: int
     * *return: none
     */
    public void setRadius(int r){
        this.radius = r;
    }

    /**
     * This method is to get the area of the circle.
     * 
     * I used PI and multiplied it by the radius twice.
     *
     *PRE: none
     *POST: returns the area
     * @param: none
     * *return: double
     */
    public double getArea(){
        return Math.PI * (radius * radius);
    }

    /**
     * This method is to draw the circle.
     * 
     * I made an object and then used the draw oval 
     * and passed in the radius and the x,y to get the shape of the circle.
     *
     *PRE: object
     *POST: draws
     * @param: object
     * *return: none
     */
    public void draw(Graphics g){
        Graphics2D gg = (Graphics2D) g;
        gg.drawOval(getX(),getY(), radius,radius);
    }
}
