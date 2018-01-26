package game.world.entities.statics;

import game.Handler;
import game.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;

public class Tree1 extends StaticEntity {

  public Tree1(Handler handler, float x, float y) {
    super(handler, x, y, Assets.tree1.getWidth(), Assets.tree1.getHeight());
  }

  @Override
  public void die() {

  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    g.drawImage(Assets.tree1, (int) (getX() - handler.getGameCamera().getxOffset()),
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

