package game.gfx;

import java.awt.image.BufferedImage;

public class SpriteLoader extends ImageLoader {

  private BufferedImage sprite;

  public SpriteLoader(String path) {

    sprite = loadImage(path);

  }

  public BufferedImage crop(int x, int y, int width, int height) {

    return sprite.getSubimage(x, y, width, height);

  }

}
