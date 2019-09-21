import java.util.Scanner;


public class Main{
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter terms");

    double i = s.nextDouble();
    System.out.println(calculatePI(i));

  }

  private static double calculatePI(double a){
    double sum = 0;

    for(int i = 0; i < 10000; i++){
      if(i % 2 == 0)
        sum -= 1 / (2 * i -1);
      else
        sum += 1 / (2* i -1);
      }
    return(sum);
  }


}
