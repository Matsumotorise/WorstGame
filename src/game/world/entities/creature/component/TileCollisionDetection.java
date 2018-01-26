package game.world.entities.creature.component;

import game.gfx.tiles.Tile;
import game.world.entities.creature.Creature;

public class TileCollisionDetection extends CreatureComponent {

  public TileCollisionDetection(Creature creature) {
    super(creature);
  }

  /*
  Fair warning: Almost unreadable collision detection spaghetti code below
  I don't recommend looking into the blinding abyss of math
  Just take my word that the four corners serve as hitboxes to prevent walking into solid blocks
  */

  private boolean collisionWithTile(int x, int y, Creature creature) {
    return !creature.getHandler().getWorld().getTile(x, y).isWalkable();
  }


  public void moveX() {
    //Moving right
    if (creature.getXMove() > 0) {
      int tmpX =
          (int) (creature.getX() + creature.getXMove() + creature.getBounds().x + creature
              .getBounds().width)
              / Tile.TILE_WIDTH;

      if (!collisionWithTile(tmpX,
          (int) (creature.getY() + creature.getBounds().y) / Tile.TILE_HEIGHT, creature)
          && !collisionWithTile(tmpX,
          (int) (creature.getY() + creature.getBounds().y + creature.getBounds().height)
              / Tile.TILE_HEIGHT,
          creature)) {
////////////Execution line
        creature.setX(creature.getX() + creature.getXMove());

      } else {
        creature
            .setX(tmpX * Tile.TILE_WIDTH - creature.getBounds().x - creature.getBounds().width - 1);
      }
    }
    //Moving left
    else if (creature.getXMove() < 0) {
      int tmpX =
          (int) (creature.getX() + creature.getXMove() + creature.getBounds().x) / Tile.TILE_WIDTH;

      if (!collisionWithTile(tmpX,
          (int) (creature.getY() + creature.getBounds().y) / Tile.TILE_HEIGHT, creature)
          && !collisionWithTile(tmpX,
          (int) (creature.getY() + creature.getBounds().y + creature.getBounds().height)
              / Tile.TILE_HEIGHT,
          creature)) {
//////////////Execution line
        creature.setX(creature.getX() + creature.getXMove());
      } else {
        creature.setX(tmpX * Tile.TILE_WIDTH + Tile.TILE_WIDTH - creature.getBounds().x);
      }
    }
  }

  public void moveY() {
    //Moving up
    if (creature.getYMove() < 0) {
      int tmpY =
          (int) (creature.getY() + creature.getYMove() + creature.getBounds().y) / Tile.TILE_HEIGHT;

      if (!collisionWithTile((int) (creature.getX() + creature.getBounds().x) / Tile.TILE_WIDTH,
          tmpY, creature)
          && !collisionWithTile(
          (int) (creature.getX() + creature.getBounds().x + creature.getBounds().width)
              / Tile.TILE_WIDTH,
          tmpY, creature)) {
//////////Execution line
        creature.setY(creature.getY() + creature.getYMove());
      } else {
        creature.setY(tmpY * Tile.TILE_HEIGHT + Tile.TILE_HEIGHT - creature.getBounds().y);
      }
    }
    //Moving down
    else if (creature.getYMove() > 0) {
      int tmpY =
          (int) (creature.getY() + creature.getYMove() + creature.getBounds().y + creature
              .getBounds().height)
              / Tile.TILE_HEIGHT;

      if (!collisionWithTile((int) (creature.getX() + creature.getBounds().x) / Tile.TILE_WIDTH,
          tmpY, creature)
          && !collisionWithTile(
          (int) (creature.getX() + creature.getBounds().x + creature.getBounds().width)
              / Tile.TILE_WIDTH,
          tmpY, creature)) {
//////////Execution line
        creature.setY(creature.getY() + creature.getYMove());
      } else {
        creature.setY(
            tmpY * Tile.TILE_HEIGHT - creature.getBounds().y - creature.getBounds().height - 1);
      }
    }
  }


}
