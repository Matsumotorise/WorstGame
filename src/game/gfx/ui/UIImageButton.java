package game.gfx.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

  private BufferedImage[] images;
  private IClickListener clicker;

  public UIImageButton(float x, float y, int width, int height, BufferedImage[] images,
      IClickListener clicker) {
    super(x, y, width, height);
    this.clicker = clicker;
    this.images = images;
  }

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics g) {
    if (isHovering()) {
      g.drawImage(images[1], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
    } else {
      g.drawImage(images[0], (int) getX(), (int) getY(), getWidth(), getHeight(), null);
    }
  }

  @Override
  public void onClick() {
    clicker.onClick();
  }

}
