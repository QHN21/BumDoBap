package View;

import Main.GameState;

import java.awt.*;

/**
 * Klasa odpowiedzialna za renderowanie menu
 * Rozszerza klase {@link Renderer}
 */
public class MenuRenderer extends Renderer
{

    public MenuRenderer(int size, int normalSize, int width, int height){
        super(size,normalSize,width,height);
    }

    /**
     * Metoda w zaleznosci od podanego w argumencie stanu i pozycji w menu
     * renderuje odpowiednia grafike
     * @param gameState - stan gry
     * @param position - pozycja
     * @param g - obiekt Graphics
     */
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

    /**
     * Renderuje odpowiedni obraz menu o podanych jako lancuchy znakow opcjach
     * @param g - obiekt Graphics
     * @param position - pozycja w menu
     * @param title - tytul menu
     * @param option1 - opcja 1
     * @param option2 - opcja 2
     * @param option3 - opcja 3
     */
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

    /**
     * Renderuje tabele wynikow po skonczonej rozgrywce
     * @param g - obiekt Graphics
     * @param playerPoints - tabela punktow graczy
     */
    public void renderLeaderboard(Graphics g,int[] playerPoints){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Verdana", Font.PLAIN, scale(40)));
        g.drawString("LeaderBoard",width/4+scale(50),scale(100));
        switch (playerPoints.length){
            case 4:
                g.setColor(Color.pink);
                g.drawString("Player " + Integer.toString(3+1)+ "    "+ Integer.toString(playerPoints[3]), width/4+scale(50), scale(150)+scale(50)*3);
            case 3:
                g.setColor(Color.yellow);
                g.drawString("Player " + Integer.toString(2+1)+ "    "+ Integer.toString(playerPoints[2]), width/4+scale(50), scale(150)+scale(50)*2);
            case 2:
                g.setColor(Color.green);
                g.drawString("Player " + Integer.toString(1+1)+ "    "+ Integer.toString(playerPoints[1]), width/4+scale(50), scale(150)+scale(50)*1);
            default:
                g.setColor(Color.white);
                g.drawString("Player " + Integer.toString(0+1)+ "    "+ Integer.toString(playerPoints[0]), width/4+scale(50), scale(150)+scale(50)*0);
        }
        //for(int i = 0; i < playerPoints.length; i++){
        //    g.drawString("Player " + Integer.toString(i+1)+ "    "+ Integer.toString(playerPoints[i]), width/4+scale(50), scale(150)+scale(50)*i);
        //}
    }
}
