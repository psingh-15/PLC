class Main 
{
  public static void main(String[] args) 
  {
    for (i = 1; i <= n; i++) 
    {
      for (j = 1; j <= n; j++)
      {
        if (x[i][j] != 0)
          break;
        else if (j == n)
          System.out.println("First all-zero row is: " + i);
      }
    }
  }
}
