package game.world.entities.statics;

import game.Handler;
import game.world.entities.Entity;

public abstract class StaticEntity extends Entity {

  public StaticEntity(Handler handler, float x, float y, int width, int height) {
    super(handler, x, y, width, height);
  }
}


