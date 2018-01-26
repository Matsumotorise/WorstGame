package game.gfx;

import java.awt.image.BufferedImage;

public class Animator {

  private int index;
  private int speed;
  private BufferedImage[] frames;
  //Timing
  private long initial, delta;

  public Animator(int speedMili, BufferedImage[] frames) {
    speed = speedMili;
    this.frames = frames;
    index = 0;
    initial = System.currentTimeMillis();
  }

  public void update() {
    delta += System.currentTimeMillis() - initial;
    initial = System.currentTimeMillis();

    if (delta > speed) {
      delta = 0;
      index++;
      if (index >= frames.length) {
        index = 0;
      }
    }
  }

  public BufferedImage getCurrentFrame() {
    return frames[index];
  }

  public int getCurrentWidth() {
    return frames[index].getWidth();
  }

  public int getCurrentHeight() {
    return frames[index].getHeight();
  }
}
