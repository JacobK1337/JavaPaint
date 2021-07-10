import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Window(){
        this.setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(new ActionPanel(this));

        this.setVisible(true);

    }

}
