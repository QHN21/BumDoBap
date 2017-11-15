package View;
import Model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Model model;

    public KeyInput(Model model){
        this.model=model;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
    }


    public void keyReleased(KeyEvent e) {
    }
}
