import java.awt.Color;


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

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void boxBounce(int coloredBalls)
    {
        if (coloredBalls <10 || coloredBalls >100) {
            System.out.print("There should be between 10 and 100 balls!");
            return;
        }
  
        myCanvas.setVisible(true);
        
        //setting box boundaries
        int boxRight = 550;
        int boxTop = 50;
        int boxLeft = 50;
        int boxBottom = 400;
        
        // draw the ground
        myCanvas.setForegroundColor(Color.BLUE);
        
        myCanvas.drawLine(boxLeft, boxTop, boxRight, boxTop);
        
        myCanvas.drawLine(boxLeft, boxTop, boxLeft, boxBottom);
        
        myCanvas.drawLine(boxRight, boxTop, boxRight, boxBottom);
        
        myCanvas.drawLine(boxLeft, boxBottom, boxRight, boxBottom);
        
        //Creating an array for the balls
        BoxBall[] halloballs = new BoxBall[coloredBalls];
        // create and show the balls
        for (int b = 0; b < coloredBalls; b++ ){
            Color color = (b % 2 == 0) ? Color.BLACK: Color.YELLOW;
            //Randomizing the color based on odd and even. If it is even then green
            //if it is odd then red
            halloballs[b] = new BoxBall (20, color, boxLeft, boxRight, boxTop, boxBottom);
        }
        
        while (true) {
            myCanvas.wait(50); // small delay
             for(BoxBall ball : halloballs){
                 ball.move(myCanvas);
                 
                 //Setting it so that the canvas redraws itself when the balls hit the walls
                myCanvas.setForegroundColor(Color.BLUE);
        
                myCanvas.drawLine(boxLeft, boxTop, boxRight, boxTop);
        
                myCanvas.drawLine(boxLeft, boxTop, boxLeft, boxBottom);
        
                myCanvas.drawLine(boxRight, boxTop, boxRight, boxBottom);
        
                myCanvas.drawLine(boxLeft, boxBottom, boxRight, boxBottom);
             }
            
            }
        }
    }

