package View;

import Main.GameState;

import java.awt.*;

/**
 * Tworzy menu i zajmuje sie jego obsluga
 */
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

    /**
     * Przesuwa menu do gory
     */
    public void goUp(){
        position--;
        if(position<0)
            position = 2;
    }

    /**
     * Przesuwa menu w dol
     */
    public void goDown(){
        position++;
        if(position > 2)
            position = 0;
    }

    /**
     * Akceptuje wybrana opcje w menu
     */
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
            case Leaderboard:
                changeState(GameState.EndGame);
                break;
        }
        position = 0;
    }

    /**
     * Wraca sie do poprzedniej opcji w menu
     */
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

    /**
     * Zmienia stan gry
     * @param gameState
     */
    public void changeState(GameState gameState){
        view.changeGameState(gameState);
    }

    /**
     * Odpowiada za akcje dostepne w menu glownyn
     */
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

    /**
     * Odpowiada za akcje dostepne w menu wybierania graczy
     */
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

    /**
     * Odpowiada za akcje dostepne w menu ustawien
     */
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

    /**
     * Odpowiada za akcje dostepne podczas pauzy w grze
     */
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

    /**
     * Odpowiada za akcje dostepne w menu ekranu koncowego
     */
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
