package game.gfx.tiles;

import game.gfx.Assets;

public class RockTile extends Tile {

  public RockTile(int id) {
    super(Assets.Tiles[2], id);
  }

  @Override
  public boolean isWalkable() {
    return false;
  }
}
