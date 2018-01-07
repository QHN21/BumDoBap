package View;

import Main.GameState;

import java.awt.*;

public class Menu
{
    View view;

    GameState gameState;

    int position;
    int numberOfPlayers;

    public Menu(View view){
        this.view = view;
        this.gameState = GameState.Menu;
        this.position = 0;
    }


    public void goUp(){
        position--;
        if(position<0)
            position = 2;
    }
    public void goDown(){
        position++;
        if(position > 2)
            position = 0;
    }
    public void accept(){
        switch (this.gameState){
            case Menu:
                menuActions();
                break;
            case ChoosingNumberOfPlayers:
                choosingNumberOfPlayersActions();
                break;
            case Settings:
                settingsActions();
                break;
            case PauseMenu:
                pauseMenuActions();
                break;
            case EndGame:
                endGameActions();
                break;
        }
        position = 0;
    }
    public void goBack(){
        switch (this.gameState){
            case Menu:
                break;
            case ChoosingNumberOfPlayers:
                changeState(GameState.Menu);
                break;
            case Settings:
                changeState(GameState.Menu);
                break;
            case PauseMenu:
                changeState(GameState.Game);
                break;
            case EndGame:
                changeState(GameState.Menu);
                break;
        }
        position = 0;
    }
    public void changeState(GameState gameState){
        view.changeGameState(gameState);
    }

    private void menuActions(){
        if(position == 0){
            changeState(GameState.ChoosingNumberOfPlayers);
        }
        if(position == 1){
            changeState(GameState.Settings);
        }
        if(position == 2){
            view.exit();
        }
    }

    private void choosingNumberOfPlayersActions(){
        if(position == 0){
            numberOfPlayers = 2;
            view.createGame(numberOfPlayers);
            changeState(GameState.Game);
        }
        if(position == 1){
            numberOfPlayers = 3;
            view.createGame(numberOfPlayers);
            changeState(GameState.Game);

        }
        if(position == 2){
            numberOfPlayers = 4;
            view.createGame(numberOfPlayers);
            changeState(GameState.Game);
        }
    }

    private void settingsActions(){
        if(position == 0){
            view.resize(16);
        }
        if(position == 1){
            view.resize(24);
        }
        if(position == 2){
            view.resize(31);
        }
    }

    private void pauseMenuActions(){
        if(position == 0){
            changeState(GameState.Game);
        }
        if(position == 1){
            changeState(GameState.Menu);
        }
        if(position == 2){
            view.exit();
        }
    }

    private void endGameActions(){
        if(position == 0){
            changeState(GameState.Menu);
        }
        if(position == 1){
            view.createGame(numberOfPlayers);
            changeState(GameState.Game);
        }
        if(position == 2){
            view.exit();
        }
    }
    public int getPosition(){
        return position;
    }
    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }
}
