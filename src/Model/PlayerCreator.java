package Model;

import Main.ID;

public class PlayerCreator {

    Model model;

    public PlayerCreator(Model model){
        this.model = model;

    }
    public void createPlayers(int numberOfPlayers){
        switch(numberOfPlayers){
            case 2:
                model.addPlayer(new Player(32, 32, ID.Player1,model));
                model.addPlayer(new Player(750, 32, ID.Player2,model));
                break;
            case 3:
                model.addPlayer(new Player(32, 32, ID.Player1,model));
                model.addPlayer(new Player(750, 32, ID.Player2,model));
                model.addPlayer(new Player(32, 368, ID.Player3,model));
                break;
            case 4:
                model.addPlayer(new Player(32, 32, ID.Player1,model));
                model.addPlayer(new Player(750, 32, ID.Player2,model));
                model.addPlayer(new Player(32, 368, ID.Player3,model));
                model.addPlayer(new Player(750, 368, ID.Player4,model));
                break;
        }
    }
}
