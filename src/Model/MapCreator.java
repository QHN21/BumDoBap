package Model;

public class MapCreator {

    Model model;

    public MapCreator(Model model){
        this.model = model;
    }
    public void createMap(int mapNumber) {
        switch (mapNumber){
            case 1:
                createMap1();
        }
    }
    public void createMap1(){
        for(int i = 0; i<30; i++)
            addBrick(i,0);
        for(int i = 0; i<20; i++)
            addBrick(i,0);
        for(int i = 0; i<30; i++)
            addBrick(i,22);
        for(int i = 0; i<20; i++)
            addBrick(i,0);

    }
    private void addBrick(int row, int column){
        model.addBrick(model.SIZE*row,model.SIZE*column);
    }

}


