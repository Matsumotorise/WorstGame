package game.world.entities.creature.component;

import game.world.entities.creature.Creature;

public class Speed extends CreatureComponent {

  private float wSpeed, rSpeed;

  public Speed(float wSpeed, float rSpeed, Creature creature) {
    super(creature);
    this.wSpeed = wSpeed;
    this.rSpeed = rSpeed;
  }

  public float getWSpeed() {
    return wSpeed;
  }

  public void setWSpeed(float speed) {
    wSpeed = speed;
  }

  public float getRSpeed() {
    return rSpeed;
  }

  public void setRSpeed(float speed) {
    rSpeed = speed;
  }
}

