package game;

import game.gfx.Assets;
import game.gfx.GameCamera;
import game.gfx.display.Display;
import game.utils.input.KeyManager;
import game.utils.input.MouseManager;
import game.world.state.GameState;
import game.world.state.State;
import game.world.state.TitleMenuState;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

  //Misc
  private boolean running = false;
  private int width, height;
  private String title;
  private Thread thread;

  //Screen
  private Display display;
  private Graphics graphics;
  private BufferStrategy bs;

  //States
  private State gameState, menuState;

  //Inputs
  private KeyManager keyManager;
  private MouseManager mouseManager;

  //Camera
  private GameCamera gameCamera;

  //Handler
  private Handler handler;

  public Game(String title, int width, int height) {
    this.width = width;
    this.height = height;
    this.title = title;

    //Input
    keyManager = new KeyManager();
    mouseManager = new MouseManager();
  }

  private void init() {
    //JFrame
    display = new Display(title, width, height);
    display.getFrame().addKeyListener(keyManager);

    display.getFrame().addMouseListener(mouseManager);
    display.getFrame().addMouseMotionListener(mouseManager);

    display.getCanvas().addMouseListener(mouseManager);
    display.getCanvas().addMouseMotionListener(mouseManager);

    Assets.init();

    //Handler
    handler = new Handler(this);

    //States
    menuState = new TitleMenuState(handler);
    gameState = new GameState(handler);
    State.setState(menuState);

    //Camera
    gameCamera = new GameCamera(handler, 0, 0);
  }

  public synchronized void start() {
    if (running) {
      return;
    }

    running = true;
    thread = new Thread(this);
    //calls run()
    thread.start();
  }

  public synchronized void stop() {
    if (!running) {
      return;
    }

    running = false;
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void update() {
    keyManager.update();

    if (State.getState() != null) {
      State.getState().update();
    }
  }

  private void render() {
    bs = display.getCanvas().getBufferStrategy();

    if (bs == null) {
      display.getCanvas().createBufferStrategy(2);
      return;
    }

    graphics = bs.getDrawGraphics();
    clearScreen(graphics);
    ////////////////////////////////
    //Drawing start
    //
    if (State.getState() != null) {
      State.getState().render(graphics);
    }
    //
    //Drawing end
    ////////////////////////////////

    bs.show();
    graphics.dispose();
  }

  private void clearScreen(Graphics g) {
    g.clearRect(0, 0, width, height);
  }

  public KeyManager getKeyManager() {
    return keyManager;
  }

  public MouseManager getMouseManager() {
    return mouseManager;
  }

  public State getGameState() {
    return gameState;
  }

  public State getMenuState() {
    return menuState;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public GameCamera getGameCamera() {
    return gameCamera;
  }

  ///////////////////////////////////////////////////////
// GAME LOOP
  @Override
  public void run() {
    init();

    int fps = 60;
    double timePerTick = 1000000000 / fps;
    double delta = 0;
    long fin;       //////fin = final
    long initial = System.nanoTime();
    long timer = 0;
    int ticks = 0;

    while (running) {

      fin = System.nanoTime();
      delta += (fin - initial) / timePerTick;
      timer += (fin - initial);

      initial = fin;

      if (delta >= 1) {
        update();
        ticks++;
        delta = 0;
      }
      render();
      //FPS COUNTER ** 1 sec = 10^9 nanosecs
      if (timer >= 1000000000) {

        System.out.printf("Fps: %d\n", ticks);
        ticks = 0;
        timer = 0;

      }
    }

    stop();
  }

}
