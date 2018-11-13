package game.gfx.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
  //Static Vars

  public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
  public static Tile[] tiles = new Tile[256];
  public static Tile grassTile = new GrassTile(0);
  public static Tile dirtTile = new DirtTile(1);
  public static Tile RockTile = new RockTile(2);

  //Class
  protected final int id;
  protected BufferedImage texture;

  public Tile(BufferedImage texture, int id) {
    this.texture = texture;
    this.id = id;

    tiles[id] = this;
  }

  public void update() {

  }

  public void render(Graphics g, int x, int y) {
    g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);

  }

  public int getId() {
    return id;
  }

  public boolean isWalkable() {
    return true;
  }
}
