import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private MouseAction mouseAction;
    private int mouseX, mouseY;
    private KeyboardAction keyboardAction;
    private Color rectColor = Color.RED;
    private Operation currentDraw;
    private int SIZE;
    private Window window;

    ActionPanel(Window win){

        mouseAction = new MouseAction(this);
        keyboardAction = new KeyboardAction(this);

        setLayout(null);
        addMouseListener(mouseAction);
        addKeyListener(keyboardAction);

        window = win;
        SIZE = 15;
        currentDraw = Operation.NONE;

        setFocusable(true);



    }

    public void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(rectColor);

            if(currentDraw == Operation.RECTANGLE){

                g2D.drawRect(mouseX , mouseY , SIZE, SIZE);
                g2D.fillRect(mouseX , mouseY , SIZE, SIZE);

            }
            if(currentDraw == Operation.OVAL){

                g2D.drawOval(mouseX, mouseY, SIZE, SIZE);
                g2D.fillOval(mouseX , mouseY , SIZE, SIZE);

            }
            if(currentDraw == Operation.RESTART){
                g2D.setColor(getBackground());
                g2D.drawRect(0,0, getWidth(), getHeight());
                g2D.fillRect(0, 0, getWidth(), getHeight());
                //A way to clear the board is to draw a rectangle with the size of the panel and then fill it with default background color.

                currentDraw = Operation.RECTANGLE;
                g2D.setColor(rectColor);
            }

        }


    public void changeXY(int newX, int newY){
        mouseX = newX;
        mouseY = newY;
    }
    public void changeColor(Color newColor){
        rectColor = newColor;
    }
    public void changeDraw(Operation choice){
        currentDraw = choice;
    }
    public Operation getCurrentDraw() {return currentDraw;}

    public void increaseSize(){ if(SIZE < 100) SIZE += 15; }

    public void decreaseSize(){if(SIZE > 15) SIZE -= 15;}

}
