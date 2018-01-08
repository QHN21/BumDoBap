package View;

import Main.GameState;

import java.awt.*;

public class MenuRenderer extends Renderer
{

    public MenuRenderer(int size, int normalSize, int width, int height){
        super(size,normalSize,width,height);
    }

    public void render(GameState gameState,int position, Graphics g){
        switch (gameState){
            case Menu:
                renderMenu(g,position,"Rect Rampage","Play","Settings","Exit");
                break;
            case ChoosingNumberOfPlayers:
                renderMenu(g,position,"Choose number of Players","2 Players","3 Players","4 Players");
                break;
            case Settings:
                renderMenu(g,position,"Window Size","Small","Medium","Large");
                break;
            case PauseMenu:
                renderMenu(g,position,"Pause","Continue","Menu","Exit");
                break;
            case EndGame:
                renderMenu(g,position,"The End","Menu","Restart","Exit");
                break;
        }
    }
    public void renderMenu(Graphics g,int position, String title,String option1,String option2,String option3){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.PLAIN, scale(40)));
        g.drawString(title, width/8, scale(50));

        g.drawRect(width/8,height/4,scale(40),scale(40));
        g.drawString(option1, width/4+scale(60), height/4+scale(35));
        g.drawRect(width/8,height/2,scale(40),scale(40));
        g.drawString(option2, width/4+scale(60), height/2+scale(35));
        g.drawRect(width/8,3*height/4,scale(40),scale(40));
        g.drawString(option3, width/4+scale(60), 3*height/4+scale(35));
        g.setColor(Color.white);
        g.fillRect(width/8,(position+1)*height/4,scale(40),scale(40));
    }
    public void renderLeaderboard(Graphics g,int[] playerPoints){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.PLAIN, scale(40)));
        g.drawString("LeaderBoard",width/4+scale(50),scale(100));
        for(int i = 0; i < playerPoints.length; i++){
            g.drawString("Player " + Integer.toString(i+1)+ "    "+ Integer.toString(playerPoints[i]), width/4+scale(50), scale(150)+scale(50)*i);
        }
    }
}
