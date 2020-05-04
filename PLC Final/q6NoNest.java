import java.util.*;

class Main
{
public static void main(String[] args) 
  {
  
    int a;
    int b;
    int c;

    int min = 0;
    int mid = 0;
    int max = 0;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter three integer values: ");

    a = scan.nextInt();
    b = scan.nextInt();
    c = scan.nextInt();

    if(a > b && a > c && b > c)
    {
      max = a;
      min = c;
      mid = b;
    }

    else if(a > b && a > c && b < c)
    {
      max = a;
      min = b;
      mid = c;
    }

    else if( b> c && b > a && a > c)
    {
      max = b;
      min = c;
      mid = a;
    }

    else if(b > c && b > a && c > a)
    {
      max = b;
      min = a;
      mid = c;
    }

    else if(c > a && c > b && a > b)
    {
      max = c;
      min = b;
      mid = a;
    }

    else
    {
      max = c;
      min = a;
      mid = b;
    }

      System.out.println("Min: "+ min);
      System.out.println("Mid: "+ mid);
      System.out.println("Max: "+ max);

      scan.close();
  }
  
}
