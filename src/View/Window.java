package View;

import javax.swing.JFrame;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, MyCanvas myCanvas) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(myCanvas, BorderLayout.CENTER);
        frame.setVisible(true);


    }
}
