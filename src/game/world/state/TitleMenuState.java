package game.world.state;

import game.Handler;
import game.gfx.Assets;
import game.gfx.ui.UIImageButton;
import game.gfx.ui.UIManager;
import java.awt.Color;
import java.awt.Graphics;

public class TitleMenuState extends State {

  private UIManager uiManager;

  public TitleMenuState(Handler handler) {
    super(handler);
    this.uiManager = new UIManager(handler);

    handler.getMouseManager().setUIManager(uiManager);

    //Start button clickListener onClick override
    int buttonWidth = 128, buttonHeight = 64;
    uiManager.addObject(
        new UIImageButton((handler.getGame().getWidth() - buttonWidth) / 2,
            (handler.getGame().getHeight() - buttonHeight) / 2,
            buttonWidth, buttonHeight, Assets.btnStart, () -> {
          handler.getMouseManager().setUIManager(null);
          State.setState(handler.getGame().getGameState());
        }));
  }

  @Override
  public void render(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillOval(handler.getMouseManager().getX() - 50, handler.getMouseManager().getY() - 25, 100,
        50);
    uiManager.render(g);
  }

  @Override
  public void update() {
    if (handler.getMouseManager().isRightPressed()) {
      State.setState(handler.getGame().getGameState());
    }

    System.out.println(
        "X: " + handler.getMouseManager().getX() + "\nY: " + handler.getMouseManager().getY());
    uiManager.update();
  }
}
