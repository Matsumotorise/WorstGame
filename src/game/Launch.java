package game;

public class Launch {

  private static final String TITLE = "Game";
  private static final int WIDTH = 600, HEIGHT = 400;

  public static void main(String... args) {
    Game g = new Game(TITLE, WIDTH, HEIGHT);
    g.start();
  }

}

