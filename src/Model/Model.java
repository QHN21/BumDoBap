package Model;

import java.awt.*;
import java.util.LinkedList;

/**
 * Class: Model
 * Creator: Marcin Kuchenbecker
 * Date: 06.11.2017
 * Description:
 * -Creates Model
 */
public class Model {
    public Model() {
        createPlayer(100,100);
        createPlayer(200,300);
    }
    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object){
        this.objects.add(object);
    }
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
    public void createPlayer(int x,int y){
        addObject(new Player(x,y,ID.Player));
    }
}
