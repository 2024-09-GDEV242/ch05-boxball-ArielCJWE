import java.awt.Color;
import java.util.Random;

/**
 * Class BouncingBall - a graphical ball that observes the effect of gravity. The ball
 * has the ability to move. Details of movement are determined by the ball itself. It
 * will fall downwards, accelerating with time due to the effect of gravity, and bounce
 * upward again when hitting the ground.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Ariel Wong-Edwin
 *
 * @version 2024.10.20
 */

public class BoxBall
{

    private Color color;
    private int diameter;
    private int x; //x position in the box
    private int y; //y position in the box
    private int ySpeediness;     // initial vertical speed
    private int xSpeediness;    //intial horizontal speed
    //Boundaries for creating the box!
    private int boxTop;
    private int boxBottom;
    private int boxLeft;        
    private int boxRight;
    
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param boxleft, boxright, boxtop, boxdown for the boundaries in the box
     * @param diameter  the diameter (in pixels) of the ball
     * @param Color  the color of the ball
     */
    public BoxBall(int diameter, Color color, int left, int right, int top, int bottom) {
        this.diameter = diameter;
        this.color = color;
        this.boxLeft = left;
        this.boxRight = right;
        this.boxTop = top;
        this.boxBottom = bottom;

        Random rand = new Random();
        x = rand.nextInt(right - left - diameter) + left;
        y = rand.nextInt(bottom - top - diameter) + top;
        xSpeediness = rand.nextInt(5) + 1; // Random horizontal speed (1 to 5)
        ySpeediness = rand.nextInt(5) + 1; // Random vertical speed (1 to 5)
        if (rand.nextBoolean()) xSpeediness = -xSpeediness; // Randomize direction
        if (rand.nextBoolean()) ySpeediness = -ySpeediness;
    }


    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move(Canvas canvas) {
        // Erase current position
        canvas.eraseCircle(x, y, diameter);

        // Update position
        x += xSpeediness;
        
        y += ySpeediness;

        // Bounce off walls
        if (x < boxLeft || x > boxRight - diameter) xSpeediness = -xSpeediness;
        
        if (y < boxTop || y > boxBottom - diameter) ySpeediness = -ySpeediness;

        // Draw at new position
        canvas.setForegroundColor(color);
        
        canvas.fillCircle(x, y, diameter);
    }    

}
