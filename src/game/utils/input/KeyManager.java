package game.utils.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

  private boolean
      up = false, down = false, left = false, right = false,
      aUp = false, aDown = false, aLeft = false, aRight = false,
      esc = false, shift = false, attacking = false;

  private boolean[] keys;

  public KeyManager() {
    keys = new boolean[256];
  }

  public void update() {
    //WASD controls
    up = keys[KeyEvent.VK_W];
    down = keys[KeyEvent.VK_S];
    left = keys[KeyEvent.VK_A];
    right = keys[KeyEvent.VK_D];

    //Arrow keys for attack
    aUp = keys[KeyEvent.VK_UP];
    aDown = keys[KeyEvent.VK_DOWN];
    aLeft = keys[KeyEvent.VK_LEFT];
    aRight = keys[KeyEvent.VK_RIGHT];

    //Misc
    shift = keys[KeyEvent.VK_SHIFT];
    esc = keys[27];
    attacking = (aUp || aDown || aLeft || aRight);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    keys[e.getKeyCode()] = true;
  }

  @Override
  public void keyReleased(KeyEvent e) {
    keys[e.getKeyCode()] = false;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  public boolean isUp() {
    return up;
  }

  public boolean isAttacking() {
    return attacking;
  }

  public boolean isDown() {
    return down;
  }

  public boolean isLeft() {
    return left;
  }
  public boolean isRight() {
    return right;
  }
  public boolean isaUp() {
    return aUp;
  }
  public boolean isaDown() {
    return aDown;
  }
  public boolean isaLeft() {
    return aLeft;
  }
  public boolean isaRight() {
    return aRight;
  }
  public boolean isShift() {
    return shift;
  }
  public boolean isEsc() {
    return esc;
  }
}
