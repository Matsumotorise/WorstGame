package game.gfx.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display extends JFrame {

  private int height, width;
  private Canvas c;

  public Display(String title, int width, int height) {
    super(title);

    this.height = height;
    this.width = width;
    //////////////////////////////
    //JFrame setup
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, width, height);
    setLocationRelativeTo(null);
    setVisible(true);

    //////////////////////////////
    //Canvas
    c = new Canvas();
    c.setPreferredSize(new Dimension(width, height));
    c.setMaximumSize(new Dimension(width, height));
    c.setMinimumSize(new Dimension(width, height));
    c.setFocusable(false);

    ////////////////////
    //Finishing touches
    add(c);
    pack();

  }

  public Canvas getCanvas() {
    return c;
  }

  public JFrame getFrame() {
    return this;
  }

}

