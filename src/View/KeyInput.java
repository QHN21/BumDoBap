package View;

import Model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    View view;

    boolean[] keyDownP1 = new boolean[5];
    boolean[] keyDownP2 = new boolean[5];

    public KeyInput(View view)
    {
        this.view = view;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        //Player 1 Keys
        if(key == KeyEvent.VK_W) keyDownP1[0]=true;
        if(key == KeyEvent.VK_S) keyDownP1[1]=true;
        if(key == KeyEvent.VK_A) keyDownP1[2]=true;
        if(key == KeyEvent.VK_D) keyDownP1[3]=true;
        if(key == KeyEvent.VK_CONTROL) keyDownP1[4]=true;

        //Player 2 Keys
        if(key == KeyEvent.VK_UP) keyDownP2[0]=true;
        if(key == KeyEvent.VK_DOWN) keyDownP2[1]=true;
        if(key == KeyEvent.VK_LEFT) keyDownP2[2]=true;
        if(key == KeyEvent.VK_RIGHT) keyDownP2[3]=true;
        if(key == KeyEvent.VK_SPACE) keyDownP2[4]=true;
    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        //Player 1 Keys
        if(key == KeyEvent.VK_W) keyDownP1[0]=false;
        if(key == KeyEvent.VK_S) keyDownP1[1]=false;
        if(key == KeyEvent.VK_A) keyDownP1[2]=false;
        if(key == KeyEvent.VK_D) keyDownP1[3]=false;
        if(key == KeyEvent.VK_CONTROL) keyDownP1[4]=false;

        //Player 2 Keys
        if(key == KeyEvent.VK_UP) keyDownP2[0]=false;
        if(key == KeyEvent.VK_DOWN) keyDownP2[1]=false;
        if(key == KeyEvent.VK_LEFT) keyDownP2[2]=false;
        if(key == KeyEvent.VK_RIGHT) keyDownP2[3]=false;
        if(key == KeyEvent.VK_SPACE) keyDownP2[4]=false;
    }
}
