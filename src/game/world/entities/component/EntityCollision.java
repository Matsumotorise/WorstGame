package game.world.entities.component;

import game.world.entities.Entity;
import java.awt.Rectangle;

public class EntityCollision extends EntityComponent {

  public EntityCollision(Entity entity) {
    super(entity);
  }

  public boolean isCollision(float xOffset, float yOffset) {
    for (Entity e : entity.getHandler().getWorld().getEntityManager().getEntities()) {
      if (entity.equals(e)) {
        continue;
      }
      if (e.getEntityCollision().getCollisionBounds(0f, 0f)
          .intersects(getCollisionBounds(xOffset, yOffset))) {
        return true;
      }
    }
    return false;
  }

  public Rectangle getCollisionBounds(float xOffset, float yOffset) {
    return new Rectangle((int) (entity.getX() + entity.getBounds().x + xOffset),
        (int) (entity.getY() + entity.getBounds().y + yOffset), entity.getBounds().width,
        entity.getBounds().height);
  }
}
