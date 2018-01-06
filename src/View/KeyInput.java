package View;

import Model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private View view;

    public boolean[] keyDownP1 = new boolean[5];
    public boolean[] keyDownP2 = new boolean[5];
    public boolean[] keyDownP3 = new boolean[5];
    public boolean[] keyDownP4 = new boolean[5];
    public boolean Enter;
    public boolean Escape;



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

        //Player 3 Keys
        if(key == KeyEvent.VK_T) keyDownP3[0]=true;
        if(key == KeyEvent.VK_G) keyDownP3[1]=true;
        if(key == KeyEvent.VK_F) keyDownP3[2]=true;
        if(key == KeyEvent.VK_H) keyDownP3[3]=true;
        if(key == KeyEvent.VK_V) keyDownP3[4]=true;

        //Player 4 Keys
        if(key == KeyEvent.VK_I) keyDownP4[0]=true;
        if(key == KeyEvent.VK_K) keyDownP4[1]=true;
        if(key == KeyEvent.VK_J) keyDownP4[2]=true;
        if(key == KeyEvent.VK_L) keyDownP4[3]=true;
        if(key == KeyEvent.VK_M) keyDownP4[4]=true;

        if(key == KeyEvent.VK_ESCAPE) view.pause();
        if(key == KeyEvent.VK_ENTER) view.play();
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

        //Player 3 Keys
        if(key == KeyEvent.VK_T) keyDownP3[0]=false;
        if(key == KeyEvent.VK_G) keyDownP3[1]=false;
        if(key == KeyEvent.VK_F) keyDownP3[2]=false;
        if(key == KeyEvent.VK_H) keyDownP3[3]=false;
        if(key == KeyEvent.VK_V) keyDownP3[4]=false;

        //Player 4 Keys
        if(key == KeyEvent.VK_I) keyDownP4[0]=false;
        if(key == KeyEvent.VK_K) keyDownP4[1]=false;
        if(key == KeyEvent.VK_J) keyDownP4[2]=false;
        if(key == KeyEvent.VK_L) keyDownP4[3]=false;
        if(key == KeyEvent.VK_M) keyDownP4[4]=false;

    }

    public boolean[][] getKeys()
    {
        boolean[][] KeyDown = {keyDownP1,keyDownP2,keyDownP3,keyDownP4};
        return KeyDown;
    }

    private void playerKeys(KeyEvent key,
                            KeyEvent k1, KeyEvent k2, KeyEvent k3, KeyEvent k4, KeyEvent k5,
                            boolean[] keyDown, boolean value){
        if(key == k1) keyDown[0]=value;
        if(key == k2) keyDown[1]=value;
        if(key == k3) keyDown[2]=value;
        if(key == k4) keyDown[3]=value;
        if(key == k5) keyDown[4]=value;
    }
}
