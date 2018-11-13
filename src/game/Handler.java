package game;

import game.gfx.GameCamera;
import game.utils.input.KeyManager;
import game.utils.input.MouseManager;
import game.world.WorldLoader;

public class Handler {

  private Game game;
  private WorldLoader world;

  public Handler(Game game) {
    this.game = game;
  }

  public KeyManager getKeyManager() {
    return game.getKeyManager();
  }

  public GameCamera getGameCamera() {
    return game.getGameCamera();
  }

  public MouseManager getMouseManager() {
    return game.getMouseManager();
  }

  //Getters and Setters
  public int getWidth() {
    return game.getWidth();
  }

  public int getHeight() {
    return game.getHeight();
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public WorldLoader getWorld() {
    return world;
  }

  public void setWorld(WorldLoader world) {
    this.world = world;
  }
}
