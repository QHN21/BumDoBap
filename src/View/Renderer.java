package View;

/**
 * Klasa bazowa wszystkich Rendererow w view
 */
public class Renderer
{
    protected int size;
    protected int normalSize;
    protected int height;
    protected int width;

    /**
     * Konstruktor otrzymuje jako parametry
     * @param size - rozmiar obiektow
     * @param normalSize - normalny rozmiar obiektow wg. ktorego skaluje
     * @param width - szerokosc okna
     * @param height - wysokosc okna
     */
    public Renderer(int size, int normalSize, int width, int height){
        this.size = size;
        this.normalSize = normalSize;
        this.width = width;
        this.height = height;
    }

    /**
     * Odpowiada za skalowanie obiektow w grze
     * @param x - wartosc w int
     * @return
     */
    protected int scale(int x){
        return (int)(x * this.size / this.normalSize);
    }

    /**
     * Zmienia parametry
     * @param size - rozmiar obiektow
     * @param width - szerokosc okna
     * @param height - wysokosc okna
     */
    public void resize(int size, int width, int height){
        this.size = size;
        this.width = width;
        this.height = height;
    }
}
