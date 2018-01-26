package game.world.entities.creature.component;

import game.world.entities.creature.Creature;

public class KeyMovement extends CreatureComponent {

  public KeyMovement(Creature creature) {
    super(creature);
  }

  public void move() {
    if (!creature.getEntityCollision().isCollision(creature.getXMove(), 0f)) {
      creature.getTileCollisionDetection().moveX();
    }
    if (!creature.getEntityCollision().isCollision(0f, creature.getYMove())) {
      creature.getTileCollisionDetection().moveY();
    }
  }

  public void getInput() {
    creature.setXMove(0);
    creature.setYMove(0);

    if (creature.getHandler().getKeyManager().isShift()) {
      creature.setSprinting(true);
    } else {
      creature.setSprinting(false);
    }
    if (creature.getHandler().getKeyManager().isAttacking()){
      creature.setAttacking(true);
    } else {
      creature.setAttacking(false);
    }

    if (creature.isSprinting()) {
      if (creature.getHandler().getKeyManager().isUp()) {
        creature.setYMove(-creature.getSpeed().getRSpeed());
      }

      if (creature.getHandler().getKeyManager().isDown()) {
        creature.setYMove(creature.getSpeed().getRSpeed());
      }

      if (creature.getHandler().getKeyManager().isLeft()) {
        creature.setXMove(-creature.getSpeed().getRSpeed());
      }

      if (creature.getHandler().getKeyManager().isRight()) {
        creature.setXMove(creature.getSpeed().getRSpeed());
      }
    } else {
      if (creature.getHandler().getKeyManager().isUp()) {
        creature.setYMove(-creature.getSpeed().getWSpeed());
      }

      if (creature.getHandler().getKeyManager().isDown()) {
        creature.setYMove(creature.getSpeed().getWSpeed());
      }

      if (creature.getHandler().getKeyManager().isLeft()) {
        creature.setXMove(-creature.getSpeed().getWSpeed());
      }

      if (creature.getHandler().getKeyManager().isRight()) {
        creature.setXMove(creature.getSpeed().getWSpeed());
      }
    }
  }

}
