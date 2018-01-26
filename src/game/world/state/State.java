package game.world.state;

import game.Handler;
import java.awt.Graphics;

public abstract class State {


  ////////////////////////////State manager
  private static State currentState = null;
  protected Handler handler;

  public State(Handler handler) {
    this.handler = handler;
  }
  ///////////////////////////////////

  public static State getState() {
    return currentState;
  }

  public static void setState(State currentState) {
    State.currentState = currentState;
  }

  public abstract void render(Graphics g);

  public abstract void update();

}
