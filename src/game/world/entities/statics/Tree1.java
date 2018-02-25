package game.world.entities.statics;

import game.Handler;
import game.gfx.Assets;
import game.item.Item;
import java.awt.Color;
import java.awt.Graphics;

public class Tree1 extends StaticEntity {

  public Tree1(Handler handler, float x, float y) {
    super(handler, x, y, Assets.Tiles[3].getWidth(), Assets.Tiles[3].getHeight());
  }

  @Override
  public void drop() {
    handler.getWorld().getItemManager().addItem(Item.wood.createNew(
        (int) (getX() + getWidth() / 2 + Math.random() * 50),
        (int) (getY() + getHeight() / 2 + Math.random() * 50)));
  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    g.drawImage(Assets.Tiles[3], (int) (getX() - handler.getGameCamera().getxOffset()),
        (int) (getY() - handler.getGameCamera().getyOffset()), getWidth(), getHeight(), null);
  }

  @Override
  protected void setHitbox() {
    return;
  }

  @Override
  protected void showHitbox(Graphics g) {
    g.setColor(Color.red);
    g.fillRect((int) (getX() + bounds.x - handler.getGameCamera().getxOffset()),
        (int) (getY() + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
        bounds.height);
  }

}

