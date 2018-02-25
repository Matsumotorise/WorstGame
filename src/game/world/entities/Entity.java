package game.world.entities;

import game.Handler;
import game.world.entities.component.Cord;
import game.world.entities.component.EntityCollision;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

  private final static int DEFAULT_HEALTH = 10;

  protected Handler handler;
  protected Rectangle bounds;
  private boolean active = true;
  private Cord pt;
  private Dimension dim;
  private EntityCollision entityCollision;
  private int hp;

  public Entity(Handler handler, float x, float y, int width, int height) {
    this.handler = handler;

    //Components
    entityCollision = new EntityCollision(this);

    //Properties
    pt = new Cord(x, y);
    dim = new Dimension(width, height);
    bounds = new Rectangle(0, 0, width, height);
    hp = DEFAULT_HEALTH;
    setHitbox();
  }

  public void hit(int a) {
    hp -= a;
    if (hp <= 0) {
      active = false;
      die();
    }
  }

  public void die(){
    active = false;
    drop();
  }
  public abstract void drop();
  protected abstract void setHitbox();
  protected abstract void showHitbox(Graphics g);

  //Getters and Setters
  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public EntityCollision getEntityCollision() {
    return entityCollision;
  }
  public Handler getHandler() {
    return handler;
  }
  public float getX() {
    return pt.getX();
  }
  public void setX(float x) {
    pt.setX(x);
  }
  public float getY() {
    return (pt.getY());
  }
  public void setY(float y) {
    pt.setY(y);
  }
  public int getWidth() {
    return ((int) dim.getWidth());
  }
  public void setWidth(int width) {
    dim.setSize(width, dim.getHeight());
  }
  public int getHeight() {
    return ((int) dim.getHeight());
  }
  public void setHeight(int height) {
    dim.setSize(dim.getWidth(), height);
  }
  public Rectangle getBounds() {
    return bounds;
  }
  public abstract void update();
  public abstract void render(Graphics g);
}
