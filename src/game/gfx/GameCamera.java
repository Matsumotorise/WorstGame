package game.gfx;

import game.Handler;
import game.gfx.tiles.Tile;
import game.world.entities.Entity;

public class GameCamera {

  private float xOffset, yOffset;
  private Handler handler;

  private int rightEnd, bottomEnd;

  public GameCamera(Handler handler, float xOffset, float yOffset) {
    this.handler = handler;
    this.xOffset = xOffset;
    this.yOffset = yOffset;

    bottomEnd = handler.getWorld().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
    rightEnd = handler.getWorld().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
  }

  public void centerOnEntity(Entity e) {
    xOffset = e.getX() - (handler.getWidth() - e.getWidth()) / 2;
    yOffset = e.getY() - (handler.getHeight() - e.getHeight()) / 2;
    checkWorldVoid();
  }

  private void checkWorldVoid() {
    //Horizontal check
    if (xOffset < 0) {
      xOffset = 0;
    } else if (rightEnd < xOffset) {
      xOffset = rightEnd;
    }
    //Vertical Check
    if (yOffset < 0) {
      yOffset = 0;
    } else if (bottomEnd < yOffset) {
      yOffset = bottomEnd;
    }

  }

  //Getters
  public float getxOffset() {
    return xOffset;
  }

  public float getyOffset() {
    return yOffset;
  }
}
