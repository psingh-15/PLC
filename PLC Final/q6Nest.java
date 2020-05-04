import java.util.Scanner;

public class Main 
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
  
    if(a > b)
    {
      if(a > c)
      {
        if(b > c)
        {
          max = a;
          min = c;
          mid = b;
        }

        else
        {
          max = a;
          min = b;
          mid = c;
        }

      }

      else
      {
        max = c;
        min = b;
        mid = a;
      }
  
    }

    else
    {

      if(b < c)
      {
        max = c;
        min = a;
        mid = b;
      }

    else
      {
        if(a < c)
        {
          max = b;
          min = a;
          mid = c;  
        }

    else
        {
          max = b;
          min = c;
          mid = a;
        }

      }
 
    }
  
    System.out.println("Min is "+ min);
    System.out.println("Mid is "+ mid);
    System.out.println("Max is "+ max);

    scan.close();
  }
  
}
