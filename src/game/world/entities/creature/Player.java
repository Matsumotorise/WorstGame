package game.world.entities.creature;

import game.Handler;
import game.gfx.Assets;
import game.world.entities.creature.component.KeyMovement;
import game.world.entities.creature.component.Melee;
import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature {

  //KeyMovement
  private KeyMovement keyMovement;

  public Player(Handler handler, float x, float y) {
    super(handler, x, y, 98, 98, 4.0f, 5.5f, Assets.playerFrame);
    keyMovement = new KeyMovement(this);
  }

  @Override
  public void drop() {
    System.out.println("Death has occurred");
  }

  @Override
  public void update() {
    for (int i = 0; i < 4; i++) {
      Assets.playerFrame.get(0).get(i).update();
      Assets.playerFrame.get(1).get(i).update();
    }

    keyMovement.getInput();
    keyMovement.move();
    handler.getGameCamera().centerOnEntity(this);
    getMelee().attackBox();
  }

  @Override
  public void render(Graphics g) {
    animation.render(g);

  }

  @Override
  protected void setHitbox() {
    bounds.width = 34;
    bounds.height = 42;
    bounds.x = 30;
    bounds.y = 51;
  }

  @Override
  protected void showHitbox(Graphics g) {
    g.setColor(Color.red);
    g.fillRect((int) (getX() + bounds.x - handler.getGameCamera().getxOffset()),
        (int) (getY() + bounds.y - handler.getGameCamera().getyOffset()), bounds.width,
        bounds.height);
  }
}


