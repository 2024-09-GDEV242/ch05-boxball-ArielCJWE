import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;


/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Ariel Wong-Edwin
 * @version 2024.10.20
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private Random rands;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        rands = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void boxBounce(int coloredBalls)
    {
        if (coloredBalls <10 || coloredBalls >50) {
            System.out.print("There should be between 10 and 50 balls!");
            return;
        }
  
        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        int boxRight = 100;
        int boxTop = 400;
        int boxLeft = 50;
        int boxBottom = 450;
        
        myCanvas.drawLine(boxLeft, boxTop, boxRight, boxTop);
        
        myCanvas.drawLine(boxLeft, boxTop, boxLeft, boxBottom);
        
        myCanvas.drawLine(boxRight, boxTop, boxRight, boxBottom);
        
        myCanvas.drawLine(boxLeft, boxBottom, boxRight, boxBottom);
        
        BouncingBall[] balls = new BouncingBall[coloredBalls];
        
        // create and show the balls
        for (int b = 0; b < coloredBalls; b++ ){
            int xPos = rands.nextInt(boxRight - boxLeft - 20) + boxLeft;
            int yPos = rands.nextInt(boxBottom - boxTop - 20) + boxTop;
            int diameter = rands.nextInt(10) + 5;
            //Randomizing the color based on odd and even. If it is even then green
            //if it is odd then red
            Color color = (b % 2 == 0)? Color.GREEN : Color.RED;
            
            balls[b] = new BouncingBall(xPos, yPos, diameter, color,200, myCanvas, boxTop, boxRight, boxLeft, boxBottom);
        }
        
        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50); // small delay
             for(BouncingBall ball : balls){
                 ball.move();
             }
            
            }
        }
    }

