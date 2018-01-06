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
        createShelf(44,14,6);
        createShelf(16,6,20);
        createShelf(16,22,20);
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
        createShelf(1,1,50);
        createShelf(1,27,50);
        createColumn(1,2,25);
        createColumn(50,2,25);
    }
    private void createSpawns()  {
        createShelf(2,6,3);
        createShelf(47,6,3);
        createShelf(2,22,3);
        createShelf(47,22,3);
        createColumn(7,2,5);
        createColumn(44,2,5);
        createColumn(7,22,5);
        createColumn(44,22,5);
    }
}


