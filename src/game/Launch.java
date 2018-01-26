package game;

public class Launch {

  private static final String TITLE = "Game";
  private static final int WIDTH = 600, HEIGHT = 400;

  public static void main(String... args) {
    Game g = new Game(TITLE, WIDTH, HEIGHT);
    g.start();
  }
}
//package game;
//import java.util.Scanner;


//public class Launch{
//  public static void main(String[] args) {
//    Scanner s = new Scanner(System.in);
//    System.out.println("Enter terms");
//
//    System.out.println(calculatePI(s.nextDouble()));
//
//  }
//
//  private static double calculatePI(double a){
//
//    double sum = 0;
//    double z = a;
//    for(double i = 0; i < 10000; i++){
//      if(i % 2 == 0)
//        sum -= 1 / (2 * z -1);
//      else
//        sum += 1 / (2 * z -1);
//    }
//
//    return(sum);
//  }
//
//
//}