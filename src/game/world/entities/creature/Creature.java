package game.world.entities.creature;

import game.Handler;
import game.gfx.Animator;
import game.world.entities.Entity;
import game.world.entities.creature.component.Animation;
import game.world.entities.creature.component.Melee;
import game.world.entities.creature.component.Speed;
import game.world.entities.creature.component.TileCollisionDetection;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Entity {

  //FINALS
  Animation animation;
  //Components
  private TileCollisionDetection tileCollisionDetection;
  private Animator wUp, wDown, wLeft, wRight;
  private Animator rUp, rDown, rLeft, rRight;
  private Speed speed;
  private boolean isAttacking = false;
  private Melee melee;
  //Variables
  private float xMove;
  private float yMove;
  private boolean isSprinting;

  Creature(Handler handler, float x, float y, int width, int height, float wSpeed, float rSpeed,
      List<List<Animator>> animationFrame) {

    super(handler, x, y, width, height);
    ArrayList<Animator> wFrame, rFrame;
    wFrame = (ArrayList<Animator>) animationFrame.get(0);
    rFrame = (ArrayList<Animator>) animationFrame.get(1);

    wUp = wFrame.get(0);
    wDown = wFrame.get(1);
    wLeft = wFrame.get(2);
    wRight = wFrame.get(3);

    rUp = rFrame.get(0);
    rDown = rFrame.get(1);
    rLeft = rFrame.get(2);
    rRight = rFrame.get(3);

    speed = new Speed(wSpeed, rSpeed, this);
    melee = new Melee(this, 400, 2);
    animation = new Animation(this);
    tileCollisionDetection = new TileCollisionDetection(this);
    xMove = 0;
    yMove = 0;
    isSprinting = false;
    melee = new Melee(this, 400, 2);
  }

  Creature(Handler handler, List<Animator> animationFrame, float x, float y, int width, int height,
      float wSpeed, float rSpeed) {
    super(handler, x, y, width, height);
    ArrayList<Animator> wFrame;
    wFrame = (ArrayList<Animator>) animationFrame;

    wUp = wFrame.get(0);
    wDown = wFrame.get(1);
    wLeft = wFrame.get(2);
    wRight = wFrame.get(3);
    speed = new Speed(wSpeed, rSpeed, this);
    animation = new Animation(this);
    tileCollisionDetection = new TileCollisionDetection(this);
    xMove = 0;
    yMove = 0;
    isSprinting = false;
  }

  ///////////GETTERS AND SETTERS
  public boolean isAttacking() {
    return isAttacking;
  }
  public void setAttacking(boolean attacking) {
    isAttacking = attacking;
  }

  public Melee getMelee(){
    return melee;
  }
  public void setMelee(Melee m){
    melee = m;
  }
  public boolean isSprinting() {
    return isSprinting;
  }

  public void setSprinting(boolean sprinting) {
    isSprinting = sprinting;
  }

  public TileCollisionDetection getTileCollisionDetection() {
    return tileCollisionDetection;
  }

  public Animator getWup() {
    return wUp;
  }

  public Animator getWdown() {
    return wDown;
  }

  public Animator getWleft() {
    return wLeft;
  }

  public Animator getWRight() {
    return wRight;
  }

  public Animator getRup() {
    return rUp;
  }

  public Animator getRdown() {
    return rDown;
  }

  public Animator getRleft() {
    return rLeft;
  }

  public Animator getRright() {
    return rRight;
  }

  public Handler getHandler() {
    return handler;
  }

  public float getXMove() {
    return xMove;
  }

  public void setXMove(float xMove) {
    this.xMove = xMove;
  }

  public float getYMove() {
    return yMove;
  }

  public void setYMove(float yMove) {
    this.yMove = yMove;
  }

  public Speed getSpeed() {
    return speed;
  }

  public void setSpeed(float speed) {
    this.speed.setWSpeed(speed);
  }

}
