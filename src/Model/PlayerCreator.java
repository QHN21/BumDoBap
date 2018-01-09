package Model;

import Main.ID;

/**
 * Klasa odpowiada za tworzenie graczy
 */
public class PlayerCreator {

    Model model;

    public PlayerCreator(Model model){
        this.model = model;

    }

    /**
     * Metoda odpowiada za stworzenie odpowiedniej liczby graczy
     * i dodanie ich do modelu w zaleznosci od liczby podanej w argumencie
     * @param numberOfPlayers - liczba graczy ktora nalezy stworzyc
     */
    public void createPlayers(int numberOfPlayers){
        switch(numberOfPlayers){
            case 2:
                model.addPlayer(new Player(32, 32,true, ID.Player1,model));
                model.addPlayer(new Player(750, 32,false, ID.Player2,model));
                break;
            case 3:
                model.addPlayer(new Player(32, 32, true, ID.Player1,model));
                model.addPlayer(new Player(750, 32, false, ID.Player2,model));
                model.addPlayer(new Player(32, 368, true, ID.Player3,model));
                break;
            case 4:
                model.addPlayer(new Player(32, 32, true, ID.Player1,model));
                model.addPlayer(new Player(750, 32, false,ID.Player2,model));
                model.addPlayer(new Player(32, 368,true, ID.Player3,model));
                model.addPlayer(new Player(750, 368, false,ID.Player4,model));
                break;
        }
    }
}
