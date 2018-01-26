package game.world.entities.creature.component;

import game.world.entities.creature.Creature;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation extends CreatureComponent {

  public Animation(Creature creature) {
    super(creature);
  }

  //So, this returns and sets the dimension of the current frame
  public BufferedImage getWalkingDirectionFrame() {

    if (creature.getXMove() < 0) { //Moving left
      setupWalkingHorizontalDimensions();
      return creature.getWleft().getCurrentFrame();
    } else if (creature.getXMove() > 0) { //Moving right
      setupWalkingHorizontalDimensions();
      return creature.getWRight().getCurrentFrame();
    } else if (creature.getYMove() < 0) { //Moving up
      setupWalkingVerticalDimensions();
      return creature.getWup().getCurrentFrame();
    } else { //Standing still or moving down
      setupWalkingVerticalDimensions();
      return creature.getWdown().getCurrentFrame();
    }

  }

  public BufferedImage getRunningDirectionFrame() {

    if (creature.getHandler().getKeyManager().isaLeft() || creature.getXMove() < 0 ) { //Moving
      // or attacking left
      setupRunningHorizontalDimensions();
      return creature.getRleft().getCurrentFrame();
    } else if (creature.getHandler().getKeyManager().isaRight() || creature.getXMove() > 0 ) {
      //Moving or attacking right
      setupRunningHorizontalDimensions();
      return creature.getRright().getCurrentFrame();
    } else if (creature.getHandler().getKeyManager().isaUp() || creature.getYMove() < 0) {
      //Moving or attacking up
      setupRunningVerticalDimensions();
      return creature.getRup().getCurrentFrame();
    } else if (creature.getHandler().getKeyManager().isaDown() || creature.getYMove() > 0) {
      //Moving or attacking down
      setupRunningVerticalDimensions();
      return creature.getRdown().getCurrentFrame();
    } else {
      return creature.getWdown().getCurrentFrame();
    }

  }

  private void setupRunningHorizontalDimensions() {
    creature.setHeight(creature.getRleft().getCurrentHeight());
    creature.setWidth(creature.getRleft().getCurrentWidth());
  }

  private void setupRunningVerticalDimensions() {
    creature.setHeight(creature.getRdown().getCurrentHeight());
    creature.setWidth(creature.getRdown().getCurrentWidth());
  }

  private void setupWalkingHorizontalDimensions() {
    creature.setHeight(creature.getWleft().getCurrentHeight());
    creature.setWidth(creature.getWRight().getCurrentWidth());
  }

  private void setupWalkingVerticalDimensions() {
    creature.setHeight(creature.getWdown().getCurrentHeight());
    creature.setWidth(creature.getWdown().getCurrentWidth());
  }

  public void render(Graphics graphics) {
    if (creature.isSprinting() || (creature.isAttacking() && !creature.getMelee().isCantAttack())) {
      graphics.drawImage(getRunningDirectionFrame(),
          (int) (creature.getX() - creature.getHandler().getGameCamera().getxOffset()),
          (int) (creature.getY() - creature.getHandler().getGameCamera().getyOffset()),
          creature.getWidth(),
          creature.getHeight(),
          null);
    } else {
      graphics.drawImage(getWalkingDirectionFrame(),
          (int) (creature.getX() - creature.getHandler().getGameCamera().getxOffset()),
          (int) (creature.getY() - creature.getHandler().getGameCamera().getyOffset()),
          creature.getWidth(),
          creature.getHeight(),
          null);
    }

  }
}
