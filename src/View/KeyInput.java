package View;

import Main.GameState;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class KeyInput extends KeyAdapter
{
    private View view;
    private Menu menu;
    private GameState gameState;



    public boolean[][] keyboardKeys = {new boolean[5],new boolean[5],new boolean[5],new boolean[5]};
    public boolean[][] menuKeyDown = {new boolean[4],new boolean[4],new boolean[4],new boolean[4],new boolean[4]};


    public KeyInput(View view,GameState gameState, Menu menu)
    {
        this.view = view;
        this.gameState = gameState;
        this.menu = menu;
        glfwInit();
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(gameState == GameState.Game)
        {
            playerKeys(key,KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_CONTROL,keyboardKeys[0],true);
            playerKeys(key,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SHIFT,keyboardKeys[1],true);
            playerKeys(key,KeyEvent.VK_T, KeyEvent.VK_G, KeyEvent.VK_F, KeyEvent.VK_H, KeyEvent.VK_V,keyboardKeys[2],true);
            playerKeys(key,KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_M,keyboardKeys[3],true);

            if (key == KeyEvent.VK_ESCAPE) menu.changeState(GameState.PauseMenu);
        }
        else
        {
            if (key == KeyEvent.VK_UP && !menuKeyDown[4][0])
            {
                menuKeyDown[4][0] = true;
                menu.goUp();
            }
            if (key == KeyEvent.VK_DOWN && !menuKeyDown[4][1])
            {
                menuKeyDown[4][1] = true;
                menu.goDown();
            }
            if (key == KeyEvent.VK_ENTER && !menuKeyDown[4][2])
            {
                menuKeyDown[4][2] = true;
                menu.accept();
            }
            if (key == KeyEvent.VK_ESCAPE && !menuKeyDown[4][3])
            {
                menuKeyDown[4][3] = true;
                menu.goBack();
            }
        }
    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(gameState == GameState.Game)
        {
            playerKeys(key,KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_CONTROL,keyboardKeys[0],false);
            playerKeys(key,KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE,keyboardKeys[1],false);
            playerKeys(key,KeyEvent.VK_T, KeyEvent.VK_G, KeyEvent.VK_F, KeyEvent.VK_H, KeyEvent.VK_V,keyboardKeys[2],false);
            playerKeys(key,KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, KeyEvent.VK_M,keyboardKeys[3],false);
        }
        else
        {
            if (key == KeyEvent.VK_UP && menuKeyDown[4][0]) menuKeyDown[4][0] = false;
            if (key == KeyEvent.VK_DOWN && menuKeyDown[4][1]) menuKeyDown[4][1] = false;
            if (key == KeyEvent.VK_ENTER && menuKeyDown[4][2]) menuKeyDown[4][2] = false;
            if (key == KeyEvent.VK_ESCAPE && menuKeyDown[4][3]) menuKeyDown[4][3] = false;
        }
    }

    public boolean[][] getKeys()
    {

        boolean[][] KeyDown = {new boolean[5],new boolean[5],new boolean[5],new boolean[5]};
        boolean[][] gamepadKeys = {checkGamepadInput(GLFW_JOYSTICK_1),checkGamepadInput(GLFW_JOYSTICK_2),
                checkGamepadInput(GLFW_JOYSTICK_3),checkGamepadInput(GLFW_JOYSTICK_4)};

        for(int k = 0; k < 4;k++)
        {
            for (int i = 0; i < 5; i++)
            {
                if (gamepadKeys[k][i] || keyboardKeys[k][i])
                    KeyDown[k][i] = true;
            }
        }
        return KeyDown;
    }

    private void playerKeys(int key,
                            int k1, int k2, int k3, int k4, int k5,
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
        for(int k = 0; k<5; k++)
        {
            for (int i = 0; i < 4; i++)
            {
                menuKeyDown[k][i] = false;
            }
        }
        for(int k = 0; k < 4; k++)
        {
            for (int i = 0; i < 5; i++)
            {
            keyboardKeys[k][i] =false;
            }
        }
    }
    private boolean[] checkGamepadInput(int joystick){
        boolean [] playerGamepad = new boolean[5];

        if(glfwGetJoystickName(joystick) != null){

            FloatBuffer axes = glfwGetJoystickAxes(joystick);
            ByteBuffer buttons = glfwGetJoystickButtons(joystick);

            if(gameState == GameState.Game)
            {

                if (axes.get(0) < -0.5)
                    playerGamepad[2] = true;
                else if (axes.get(0) > 0.5)
                    playerGamepad[3] = true;


                if (buttons.get(0) == 1 || buttons.get(4) ==1)
                    playerGamepad[0] = true;

                if (buttons.get(1) == 1|| buttons.get(5) ==1)
                    playerGamepad[1] = true;

                if (buttons.get(2) == 1 || axes.get(5) > -0.5)
                    playerGamepad[4] = true;


                if (buttons.get(7) == 1)
                    menu.changeState(GameState.PauseMenu);
            }
            else if(gameState == GameState.Leaderboard) {
                if (buttons.get(7) == 1)
                    menu.accept();
            }
            else
            {
                if(axes.get(1) > 0.5 && !menuKeyDown[joystick][0] ){
                    menuKeyDown[joystick][0] = true;
                    menu.goUp();
                }
                else if (axes.get(1) < -0.5 && !menuKeyDown[joystick][1]){
                    menuKeyDown[joystick][1] = true;
                    menu.goDown();
                }
                else if(axes.get(1) < 0.5 && axes.get(1)> -0.5){
                    menuKeyDown[joystick][0] = false;
                    menuKeyDown[joystick][1] = false;
                }
                if(buttons.get(0) ==1 &&!menuKeyDown[joystick][2]){
                    menuKeyDown[joystick][2] = true;
                    menu.accept();
                }
                else if (buttons.get(0) ==0 && menuKeyDown[joystick][2]){
                    menuKeyDown[joystick][2] = false;
                }
                if(buttons.get(1) == 1&&!menuKeyDown[joystick][3]){
                    menuKeyDown[joystick][3] = true;
                    menu.goBack();
                }
                else if (buttons.get(1) ==0 && menuKeyDown[joystick][3]){
                    menuKeyDown[joystick][3] = false;
                }

            }
        }
        return playerGamepad;
    }
}
