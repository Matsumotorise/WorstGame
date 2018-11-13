package game.world.state;

import game.Handler;
import game.world.WorldLoader;
import java.awt.Graphics;

public class GameState extends State {

  private WorldLoader world;

  public GameState(Handler handler) {
    super(handler);
    world = new WorldLoader(handler, "res/worlds/World2.txt");
    handler.setWorld(world);

  }

  @Override
  public void render(Graphics g) {
    world.render(g);
  }

  @Override
  public void update() {
    world.update();
  }
}
