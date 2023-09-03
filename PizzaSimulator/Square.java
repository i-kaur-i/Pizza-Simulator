import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * This is the square class and it extends shape
 *
 * @author Iakjot Kaur 
 * @version December 3rd, 2019
 */
public class Square extends Shape
{
   private int height;
   private int width;
   private int sidecount;
   
   public Square(int x, int y, int height, int width){
      super(x,y);
      this.height = height;
      this.width = width;
   }
   
   public int getHeight(){
      return this.height;
   }
   
   public int getWidth(){
       return this.width;
   }
   
   public void setHeight(int h){
       this.height = h;
    }
    
   public void setWidth(int w){
       this.width = w;
   }
   
   public double getArea(){
      return width * height;
   }
   
   public void draw(Graphics g){
      Graphics2D g2d = (Graphics2D) g;
      g.setColor(Color.white);
      g2d.drawRect(getX(),getY(),height,width);
   }
}
