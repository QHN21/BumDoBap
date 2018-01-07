package View;

import Main.GameState;
import Model.Model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter
{
    private View view;
    private Menu menu;
    private GameState gameState;

    public boolean[] keyDownP1 = new boolean[5];
    public boolean[] keyDownP2 = new boolean[5];
    public boolean[] keyDownP3 = new boolean[5];
    public boolean[] keyDownP4 = new boolean[5];
    public boolean Enter;
    public boolean Escape;
    public boolean[] menuKeyDown = new boolean[4];


    public KeyInput(View view,GameState gameState, Menu menu)
    {
        this.view = view;
        this.gameState = gameState;
        this.menu = menu;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(gameState == GameState.Game)
        {

            //Player 1 Keys
            if (key == KeyEvent.VK_W) keyDownP1[0] = true;
            if (key == KeyEvent.VK_S) keyDownP1[1] = true;
            if (key == KeyEvent.VK_A) keyDownP1[2] = true;
            if (key == KeyEvent.VK_D) keyDownP1[3] = true;
            if (key == KeyEvent.VK_CONTROL) keyDownP1[4] = true;

            //Player 2 Keys
            if (key == KeyEvent.VK_UP) keyDownP2[0] = true;
            if (key == KeyEvent.VK_DOWN) keyDownP2[1] = true;
            if (key == KeyEvent.VK_LEFT) keyDownP2[2] = true;
            if (key == KeyEvent.VK_RIGHT) keyDownP2[3] = true;
            if (key == KeyEvent.VK_SPACE) keyDownP2[4] = true;

            //Player 3 Keys
            if (key == KeyEvent.VK_T) keyDownP3[0] = true;
            if (key == KeyEvent.VK_G) keyDownP3[1] = true;
            if (key == KeyEvent.VK_F) keyDownP3[2] = true;
            if (key == KeyEvent.VK_H) keyDownP3[3] = true;
            if (key == KeyEvent.VK_V) keyDownP3[4] = true;

            //Player 4 Keys
            if (key == KeyEvent.VK_I) keyDownP4[0] = true;
            if (key == KeyEvent.VK_K) keyDownP4[1] = true;
            if (key == KeyEvent.VK_J) keyDownP4[2] = true;
            if (key == KeyEvent.VK_L) keyDownP4[3] = true;
            if (key == KeyEvent.VK_M) keyDownP4[4] = true;

            if (key == KeyEvent.VK_ESCAPE) menu.changeState(GameState.PauseMenu);
        }
        else
        {
            if (key == KeyEvent.VK_UP && !menuKeyDown[0])
            {
                menuKeyDown[0] = true;
                menu.goUp();
            }
            if (key == KeyEvent.VK_DOWN && !menuKeyDown[1])
            {
                menuKeyDown[1] = true;
                menu.goDown();
            }
            if (key == KeyEvent.VK_ENTER && !menuKeyDown[2])
            {
                menuKeyDown[2] = true;
                menu.accept();
            }
            if (key == KeyEvent.VK_ESCAPE && !menuKeyDown[3])
            {
                menuKeyDown[3] = true;
                menu.goBack();
            }
        }
    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(gameState == GameState.Game)
        {

            //Player 1 Keys
            if (key == KeyEvent.VK_W) keyDownP1[0] = false;
            if (key == KeyEvent.VK_S) keyDownP1[1] = false;
            if (key == KeyEvent.VK_A) keyDownP1[2] = false;
            if (key == KeyEvent.VK_D) keyDownP1[3] = false;
            if (key == KeyEvent.VK_CONTROL) keyDownP1[4] = false;

            //Player 2 Keys
            if (key == KeyEvent.VK_UP) keyDownP2[0] = false;
            if (key == KeyEvent.VK_DOWN) keyDownP2[1] = false;
            if (key == KeyEvent.VK_LEFT) keyDownP2[2] = false;
            if (key == KeyEvent.VK_RIGHT) keyDownP2[3] = false;
            if (key == KeyEvent.VK_SPACE) keyDownP2[4] = false;

            //Player 3 Keys
            if (key == KeyEvent.VK_T) keyDownP3[0] = false;
            if (key == KeyEvent.VK_G) keyDownP3[1] = false;
            if (key == KeyEvent.VK_F) keyDownP3[2] = false;
            if (key == KeyEvent.VK_H) keyDownP3[3] = false;
            if (key == KeyEvent.VK_V) keyDownP3[4] = false;

            //Player 4 Keys
            if (key == KeyEvent.VK_I) keyDownP4[0] = false;
            if (key == KeyEvent.VK_K) keyDownP4[1] = false;
            if (key == KeyEvent.VK_J) keyDownP4[2] = false;
            if (key == KeyEvent.VK_L) keyDownP4[3] = false;
            if (key == KeyEvent.VK_M) keyDownP4[4] = false;
        }
        else
        {
            if (key == KeyEvent.VK_UP && menuKeyDown[0]) menuKeyDown[0] = false;
            if (key == KeyEvent.VK_DOWN && menuKeyDown[1]) menuKeyDown[1] = false;
            if (key == KeyEvent.VK_ENTER && menuKeyDown[2]) menuKeyDown[2] = false;
            if (key == KeyEvent.VK_ESCAPE && menuKeyDown[3]) menuKeyDown[3] = false;
        }
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

    public void setGameState(GameState gameState){
        this.gameState = gameState;
        if (gameState == GameState.Game){
            resetKeys();
        }
    }
    public void resetKeys(){
        for(int i = 0; i < 4; i++){
            menuKeyDown[i] = false;
        }
        for(int i = 0; i < 5; i++){
            keyDownP1[i] = false;
        }
        for(int i = 0; i < 5; i++){
            keyDownP2[i] = false;
        }
        for(int i = 0; i < 5; i++){
            keyDownP3[i] = false;
        }
        for(int i = 0; i < 5; i++){
            keyDownP4[i] = false;
        }
    }
}
