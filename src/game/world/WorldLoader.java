package game.world;

import game.Handler;
import game.gfx.tiles.Tile;
import game.item.ItemManager;
import game.utils.Utils;
import game.world.entities.EntityManager;
import game.world.entities.creature.OneThreeSeven;
import game.world.entities.creature.Player;
import game.world.entities.statics.Tree1;
import java.awt.Graphics;

public class WorldLoader {

  private int width, height;
  private int spawnX, spawnY;
  private int[][] map;
  private Handler handler;
  //Entities
  private EntityManager entityManager;
  //Items
  private ItemManager itemManager;

  public WorldLoader(Handler handler, String path) {
    this.handler = handler;

    entityManager = new EntityManager(handler, new Player(handler, 0, 0));
    loadWorld(path);
    itemManager = new ItemManager(handler);

    //NPCs
    entityManager.addEntity(new OneThreeSeven(handler, (float) (64 * 16.75), 0, 2, 3));

    //Statics
    entityManager.addEntity(new Tree1(handler, 64 * 13, 64 * 7));

    entityManager.getPlayer().setX(spawnX * 64);
    entityManager.getPlayer().setY(spawnY * 64);

  }

  public void update() {
    itemManager.update();
    entityManager.update();
  }

  public void render(Graphics g) {
    //Render only what you can see
    int xStart, xEnd, yStart, yEnd;
    xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
    xEnd = (int) Math
        .min(width,
            (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
    yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
    yEnd = (int) Math
        .min(height,
            (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

    //WorldLoader render loop
    for (int y = yStart; y < yEnd; y++) {
      for (int x = xStart; x < xEnd; x++) {
        getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
            (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));

      }
    }
    //Item
    itemManager.render(g);
    //Entity
    entityManager.render(g);
  }

  public Tile getTile(int x, int y) {

    if (x < 0 || y < 0 || x >= width || y >= height) {
      return Tile.grassTile;
    }

    Tile t = Tile.tiles[map[x][y]];
    if (t == null) {
      return Tile.dirtTile;
    }

    return t;

  }

  private void loadWorld(String path) {
    String file = Utils.loadFileAsString(path);
    String[] tokens = file.split("\\s+");

    width = Utils.parseInt(tokens[0]);
    height = Utils.parseInt(tokens[1]);
    spawnX = Utils.parseInt(tokens[2]);
    spawnY = Utils.parseInt(tokens[3]);

    map = new int[width][height];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        map[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
      }
    }
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public Handler getHandler() {
    return handler;
  }

  public ItemManager getItemManager() {
    return itemManager;
  }

  public int getSpawnX() {
    return spawnX;
  }

  public int getSpawnY() {
    return spawnY;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}


