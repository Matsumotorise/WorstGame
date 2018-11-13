package game.world.entities;

import game.Handler;
import game.world.entities.creature.Player;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class EntityManager {

  private Handler handler;
  private Player player;
  private List<Entity> entities;

  private Comparator<Entity> renderOrder = (o1, o2) -> {
    if (o1.getY() + o1.getHeight() < o2.getX() + o2.getHeight()) {
      return -1;
    }
    return 1;
  };

  //ArrayList vs LinkedList?
  //More CPU vs More Memory consumption

  public EntityManager(Handler handler, Player player) {
    this.handler = handler;
    this.player = player;
    entities = new ArrayList<>();
    addEntity(player);
  }

  public void update() {
    Iterator<Entity> iterator = entities.iterator();
    while (iterator.hasNext()) {
      Entity e = iterator.next();
      e.update();
      //Kill if not active
      if (!e.isActive())
        iterator.remove();
    }
  }

  public void render(Graphics g) {
    Iterator<Entity> iterator = entities.iterator();
    while (iterator.hasNext()) {
      Entity e = iterator.next();
      e.render(g);
    }

    entities.sort(renderOrder);
  }

  //Getters and Setters
  public void addEntity(Entity e) {
    entities.add(e);
  }
  public List<Entity> getEntities() {
    return entities;
  }

  public Player getPlayer() {
    return player;
  }

}
