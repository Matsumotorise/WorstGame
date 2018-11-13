package game.utils.input;

import game.gfx.ui.UIManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

  private boolean leftPressed, rightPressed;
  private int x, y;
  //Bad style, temp uiMan
  private UIManager uiManager;

  public MouseManager() {

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      leftPressed = true;
    }
    if (e.getButton() == MouseEvent.BUTTON3) {
      rightPressed = true;
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == MouseEvent.BUTTON1) {
      leftPressed = false;
    }
    if (e.getButton() == MouseEvent.BUTTON3) {
      rightPressed = false;
    }
    if (uiManager != null) {
      uiManager.onMouseRelease(e);
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    if (uiManager != null) {
      uiManager.onMouseMove(e);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  //Getters and Setters//
  public void setUIManager(UIManager uiManager) {
    this.uiManager = uiManager;
  }

  public boolean isLeftPressed() {
    return leftPressed;
  }

  public boolean isRightPressed() {
    return rightPressed;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
