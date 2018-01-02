package View;

import Model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private View view;

    public KeyInput(View view)
    {
        this.view = view;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        //Player 1 Keys
        if(key == KeyEvent.VK_W) view.keyDownP1[0]=true;
        if(key == KeyEvent.VK_S) view.keyDownP1[1]=true;
        if(key == KeyEvent.VK_A) view.keyDownP1[2]=true;
        if(key == KeyEvent.VK_D) view.keyDownP1[3]=true;
        if(key == KeyEvent.VK_CONTROL) view.keyDownP1[4]=true;

        //Player 2 Keys
        if(key == KeyEvent.VK_UP) view.keyDownP2[0]=true;
        if(key == KeyEvent.VK_DOWN) view.keyDownP2[1]=true;
        if(key == KeyEvent.VK_LEFT) view.keyDownP2[2]=true;
        if(key == KeyEvent.VK_RIGHT) view.keyDownP2[3]=true;
        if(key == KeyEvent.VK_M) view.keyDownP2[4]=true;
    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        //Player 1 Keys
        if(key == KeyEvent.VK_W) view.keyDownP1[0]=false;
        if(key == KeyEvent.VK_S) view.keyDownP1[1]=false;
        if(key == KeyEvent.VK_A) view.keyDownP1[2]=false;
        if(key == KeyEvent.VK_D) view.keyDownP1[3]=false;
        if(key == KeyEvent.VK_CONTROL) view.keyDownP1[4]=false;

        //Player 2 Keys
        if(key == KeyEvent.VK_UP) view.keyDownP2[0]=false;
        if(key == KeyEvent.VK_DOWN) view.keyDownP2[1]=false;
        if(key == KeyEvent.VK_LEFT) view.keyDownP2[2]=false;
        if(key == KeyEvent.VK_RIGHT) view.keyDownP2[3]=false;
        if(key == KeyEvent.VK_M) view.keyDownP2[4]=false;
    }
}
