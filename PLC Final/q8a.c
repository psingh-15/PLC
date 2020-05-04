#include <stdio.h>

int main()
{
  int j = 1;
  int i = 0;
  for (i = 0; i < 3; i++)
  {
    if((j + 2 == 2) || (j + 2 == 3))
      j--;

    if(j + 2 == 0)
      j+=2;

    else
      j = 0;
        
    if(j > 0);

    else
      j = 3 - i;

  }
    printf("%d", j);
}