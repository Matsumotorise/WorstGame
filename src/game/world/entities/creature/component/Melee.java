package game.world.entities.creature.component;

import game.world.entities.Entity;
import game.world.entities.creature.Creature;
import java.awt.Rectangle;

public class Melee extends CreatureComponent {

  private long deltaAttackTimer, attackTimerFinal;
  private int damage = 1, attackCooldown = 500;
  private boolean cantAttack = true;
  public Melee(Creature creature) {
    super(creature);
  }

  public Melee(Creature creature, int attackCooldown, int damage) {
    super(creature);
    this.attackCooldown = attackCooldown;
    this.damage = damage;
  }

  public void attackBox() {
    //Attack limiter
    deltaAttackTimer += System.currentTimeMillis() - attackTimerFinal;
    attackTimerFinal = System.currentTimeMillis();
    cantAttack = (deltaAttackTimer < attackCooldown);
    if(cantAttack)
      return;

    Rectangle hitBox = creature.getEntityCollision().getCollisionBounds(0, 0);
    Rectangle attackRectangle = new Rectangle();
    double attackSizeMultiplier = 1.1;

    attackRectangle.width = (int) (hitBox.width * attackSizeMultiplier); //arSize
    attackRectangle.height = (int) (hitBox.height * attackSizeMultiplier);//arSize

    //Places attack Rectangle according to arrow keys
    if (creature.getHandler().getKeyManager().isaUp()) {
      attackRectangle.x = (hitBox.x + (hitBox.width - attackRectangle.width) / 2);
      attackRectangle.y = (hitBox.y - attackRectangle.height);
    } else if (creature.getHandler().getKeyManager().isaDown()) {
      attackRectangle.x = (hitBox.x + (hitBox.width - attackRectangle.width) / 2);
      attackRectangle.y = (hitBox.y + attackRectangle.height);
    } else if (creature.getHandler().getKeyManager().isaLeft()) {
      attackRectangle.x = hitBox.x - attackRectangle.width;
      attackRectangle.y = hitBox.y + (hitBox.height - attackRectangle.height) / 2;
    } else if (creature.getHandler().getKeyManager().isaRight()) {
      attackRectangle.x = hitBox.x + hitBox.width;
      attackRectangle.y = hitBox.y + (hitBox.height - attackRectangle.height) / 2;
    } else {
      return;
    }

    deltaAttackTimer = 0;
    for (Entity e : creature.getHandler().getWorld().getEntityManager().getEntities()) {
      if (e.equals(creature))
        continue;

      if (e.getEntityCollision().getCollisionBounds(0, 0).intersects(attackRectangle)) {
        e.hit(damage);
        return;
      }
    }
  }
  public boolean isCantAttack(){
    return cantAttack;
  }
}
