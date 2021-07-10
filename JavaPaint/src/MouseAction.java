import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseAction implements MouseListener {
    private ActionPanel panel;
    private boolean holding;
    MouseAction(ActionPanel ins){
        panel = ins; holding = false;

    }
    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mousePressed(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            holding = true;
            if(panel.getCurrentDraw() == Operation.NONE) panel.changeDraw(Operation.RECTANGLE); // default brush is rectangle-shaped

            //Below simple threading to draw in real-time

            Thread thread = new Thread(new Runnable(){

                @Override
                public void run() {
                    try{
                        while(holding){
                            Point tempPoint = new Point(MouseInfo.getPointerInfo().getLocation());
                            SwingUtilities.convertPointFromScreen(tempPoint, e.getComponent()); //Getting the fixed coordinates of a mouse in JFrame window;
                            panel.changeXY( (int) tempPoint.getX(), (int) tempPoint.getY());
                            panel.repaint();
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        holding = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }


}
