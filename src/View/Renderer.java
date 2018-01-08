package View;

public class Renderer
{
    protected int size;
    protected int normalSize;
    protected int height;
    protected int width;
    public Renderer(int size, int normalSize, int width, int height){
        this.size = size;
        this.normalSize = normalSize;
        this.width = width;
        this.height = height;
    }

    protected int scale(int x){
        return (int)(x * this.size / this.normalSize);
    }

    public void resize(int size, int width, int height){
        this.size = size;
        this.width = width;
        this.height = height;
    }
}
