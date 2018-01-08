package Model;
/**
 * Kreator map w programie
 * w planach rozbudowanie o dodatkowe mapy
 */
public class MapCreator {

    Model model;

    public MapCreator(Model model){
        this.model = model;
    }

    /**
     * Tworzy mape o numerze podanym w argumencie
     * @param mapNumber - numer mapy
     */
    public void createMap(int mapNumber) {
        switch (mapNumber){
            case 1:
                createMap1();
        }
    }

    /**
     * Tworzy mape nr 1
     * wykorzystujac metody
     * createBounds()
     * createSpawns()
     * createShelf()
     * createColumn()
     * addBrick()
     */
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

        addBrick(19,26);
        addBrick(33,26
        );
    }

    /**
     * Metoda dodaje cegielke do mapy i umieszcza ja w modelu
     * jako parametry przyjmuje wsporzedne cegielki podane jako
     * numer kolumny i wiersza
     * @param column numer kolumny
     * @param row numer wiersza
     */
    private void addBrick(int column, int row){
        model.addBrick(model.SIZE*(column-1),model.SIZE*(row-1));
    }

    /**
     * Tworzy polke cegielek o podanej szerokosci
     * zaczynajac od cegielki o podanych wspolrzednych
     * i kolejne dodajac po prawej stronie
     * @param column - numer kolumny
     * @param row - numer wiersza
     * @param width - szerokosc
     */
    private void createShelf(int column, int row, int width){
        for(int i = column; i < column + width; i++)
            addBrick(i,row);
    }

    /**
     * Tworzy kolumne o podanej wysokosci
     * zaczynajac o cegielki o podanych wspolrzednych
     * i kolejne dodajac w dol
     * @param column - numer kolumny
     * @param row - numer wiersza
     * @param height - wysokosc
     */
    private void createColumn(int column, int row, int height){
        for(int i = row; i < row + height; i++)
            addBrick(column,i);
    }

    /**
     * Tworzy obramowanie mapy
     */
    private void createBounds() {
        createShelf(1,1,51);
        createShelf(1,27,51);
        createColumn(1,2,25);
        createColumn(51,2,25);
    }

    /**
     * tworzy spawny graczy
     */
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


