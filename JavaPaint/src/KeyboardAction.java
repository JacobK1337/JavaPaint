import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardAction implements KeyListener {
    private ActionPanel panel;
    KeyboardAction(ActionPanel ins){
        panel = ins;
    }
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyChar()){
            case 'q':
                panel.changeColor(Color.RED);
                break;
            case 'w':
                panel.changeColor(Color.GREEN);
                break;
            case 'e':
                panel.changeColor(Color.BLUE);
                break;
            case 'r':
                panel.changeColor(Color.BLACK);
                break;
            case 't':
                panel.changeColor(Color.WHITE);
                break;
            case 'y':
                panel.changeColor(Color.MAGENTA);
                break;
            case 'u':
                panel.changeColor(panel.getBackground());
                break;
                // Above color declarations;

            case 'a':
                panel.changeDraw(Operation.RECTANGLE);
                break;
            case 's':
                panel.changeDraw(Operation.OVAL);
                break;

            //Above type of brush declaration (square or circle)

            case 'd':
                panel.changeDraw(Operation.RESTART);
                panel.repaint();
                break;

                //Above clear-all function

            case '+':
                panel.increaseSize();
                break;
            case '-':
                panel.decreaseSize();
                break;

                //Above resizing the brush

        }

    }

    @Override
    public void keyReleased(KeyEvent e) { }
}
