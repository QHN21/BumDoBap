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
        createBounds();
        createShelf(1,5,3);
        createColumn(6,1,5);


    }
    private void addBrick(int column, int row){
        model.addBrick(model.SIZE*column,model.SIZE*row);
    }
    private void createShelf(int column, int row, int width){
        for(int i = column; i < column + width; i++)
            addBrick(i,row);
    }
    private void createColumn(int column, int row, int height){
        for(int i = row; i < row + height; i++)
            addBrick(column,i);
    }
    private void createBounds() {
        createShelf(0,0,50);
        createShelf(0,29,50);
        createColumn(0,1,29);
        createColumn(49,1,29);
        /*for(int i = 0; i<77; i++)
            addBrick(i,0);
        for(int i = 0; i<77; i++)
            addBrick(i,41);
        for(int i = 1; i<41; i++)
            addBrick(0,i);
        for(int i = 1; i<41; i++)
            addBrick(76,i);*/
    }
}


