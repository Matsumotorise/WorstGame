package game.item;

import game.Handler;
import game.gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Item {
  //Handler
  public static Item[] items = new Item[4];

  public static Item wood = new Item(Assets.Items[0], "Wooden Stick", 0);

  //Class

  public static final int IWID = 32, IHEI = 32, PICKED_UP = -1;

  protected Handler handler;
  protected BufferedImage texture;
  protected String name;
  protected final int id;
                  //Number of said Item
  protected int x, y, count;

  public Item(BufferedImage texture, String name, int id) {
    this.texture = texture;
    this.name = name;
    this.id = id;
    count = 1;

    items[id] = this;
  }

  public void update(){}

  public void render(Graphics g){
    if(handler != null) {
      render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera()
          .getyOffset()));
    }
  }

  public void render(Graphics g, int x, int y){
    g.drawImage(texture, x, y, IWID, IHEI, null);
  }

  public Item createNew(int x, int y){
    Item i = new Item(texture, name, id);
    i.setPosition(x, y);
    return i;
  }

  public void setPosition(int x, int y){
    setX(x);
    setY(y);
  }

  //Getters and Setters
  public Handler getHandler() {
    return handler;
  }
  public void setHandler(Handler handler) {
    this.handler = handler;
  }
  public BufferedImage getTexture() {
    return texture;
  }
  public void setTexture(BufferedImage texture) {
    this.texture = texture;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getId() {
    return id;
  }
  public int getX() {
    return x;
  }
  public void setX(int x) {
    this.x = x;
  }
  public int getY() {
    return y;
  }
  public void setY(int y) {
    this.y = y;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
}
