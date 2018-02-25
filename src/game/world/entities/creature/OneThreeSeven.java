package game.world.entities.creature;

import game.Handler;
import game.gfx.Animator;
import game.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class OneThreeSeven extends Creature {

  public OneThreeSeven(Handler handler, float x, float y, float wSpeed, float rSpeed) {
    super(handler, Assets.F137, x, y,
        Assets.F137.get(0).getCurrentWidth(),
        Assets.F137.get(0).getCurrentWidth(),
        wSpeed, rSpeed);
  }

  @Override
  public void drop() {

  }

  @Override
  public void update() {
    Iterator<Animator> iterator = Assets.F137.iterator();
    while (iterator.hasNext()) {
      Animator a = iterator.next();
      a.update();
    }
  }

  @Override
  public void render(Graphics g) {
    animation.render(g);
  }

  @Override
  protected void setHitbox() {
    bounds.width = 39;
    bounds.height = 49;
    bounds.x = 27;
    bounds.y = 42;
  }

  @Override
  protected void showHitbox(Graphics g) {
    g.setColor(Color.red);
    g.fillRect((int) (getX() + bounds.x - handler.getGameCamera().getxOffset()),
        (int) (getY() + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
        bounds.height);
  }


}
