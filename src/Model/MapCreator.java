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
        createSpawns();
        createShelf(2,14,6);
        createShelf(45,14,6);

        createShelf(14,11,6);
        addBrick(19,10);

        createShelf(14,17,6);
        addBrick(19,16);

        createShelf(33,11,6);
        addBrick(33,10);

        createShelf(33,17,6);
        addBrick(33,16);

        createShelf(16,6,21);
        addBrick(19,5);
        addBrick(33,5);

        createShelf(16,22,21);
        addBrick(19,21);
        addBrick(33,21);
    }
    private void addBrick(int column, int row){
        model.addBrick(model.SIZE*(column-1),model.SIZE*(row-1));
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
        createShelf(1,1,51);
        createShelf(1,27,51);
        createColumn(1,2,25);
        createColumn(51,2,25);
    }
    private void createSpawns()  {
        createShelf(2,6,3);
        createShelf(48,6,3);
        createShelf(2,22,3);
        createShelf(48,22,3);
        createColumn(7,2,5);
        createColumn(45,2,5);
        createColumn(7,22,5);
        createColumn(45,22,5);
    }
}


