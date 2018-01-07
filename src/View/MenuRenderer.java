package View;

import Main.GameState;

import java.awt.*;

public class MenuRenderer
{
    View view;

    public MenuRenderer(View view){
        this.view = view;
    }

    public void render(GameState gameState,int position, Graphics g){
        switch (gameState){
            case Menu:
                renderMenu(g,position);
                break;
            case ChoosingNumberOfPlayers:
                renderChoosingNumberOfPlayers(g,position);
                break;
            case Settings:
                renderSettings(g,position);
                break;
            case PauseMenu:
                renderPauseMenu(g,position);
                break;
            case EndGame:
                renderEndGame(g,position);
                break;
        }
    }
    public void renderMenu(Graphics g,int position){
        g.setColor(Color.BLACK);
        g.drawRect(200,100,40,40);
        g.drawRect(200,200,40,40);
        g.drawRect(200,300,40,40);
        g.setColor(Color.white);
        g.fillRect(200,(position+1)*100,40,40);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("Menu", 200, 50);
    }
    public void renderChoosingNumberOfPlayers(Graphics g,int position){
        g.setColor(Color.BLACK);
        g.drawRect(200,200,40,40);
        g.drawRect(200,300,40,40);
        g.drawRect(200,400,40,40);
        g.setColor(Color.white);
        g.fillRect(200,(position+2)*100,40,40);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("Choose Number Of Players", 200, 50);
    }

    public void renderSettings(Graphics g,int position){
        g.setColor(Color.BLACK);
        g.drawRect(200,200,40,40);
        g.drawRect(200,300,40,40);
        g.drawRect(200,400,40,40);
        g.setColor(Color.white);
        g.fillRect(200,(position+2)*100,40,40);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("Settings", 200, 50);
    }

    public void renderPauseMenu(Graphics g,int position){
        g.setColor(Color.BLACK);
        g.drawRect(200,200,40,40);
        g.drawRect(200,300,40,40);
        g.drawRect(200,400,40,40);
        g.setColor(Color.white);
        g.fillRect(200,(position+2)*100,40,40);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("Pause Menu", 200, 50);
    }

    public void renderEndGame(Graphics g,int position){
        g.setColor(Color.BLACK);
        g.drawRect(200,200,40,40);
        g.drawRect(200,300,40,40);
        g.drawRect(200,400,40,40);
        g.setColor(Color.white);
        g.fillRect(200,(position+2)*100,40,40);
        g.setFont(new Font("Verdana", Font.PLAIN, 20));
        g.drawString("END GAME", 200, 50);
    }
}
