#include <stdio.h>

void prog(int input)
{
  int i = 0;
}

int main()
{
    int j = -3;
    int i = 0;

    two:
        j--;
    
    zero:
        j+=2;

    one:
        j = 0;

    three:
        j = 3 - i;

    for(i = 0; i < 3; i++)
    {
        if((j + 2 == 2) || (j + 2 == 3))
            goto two;

        if(j + 2 == 0)
            goto zero;

        else
            goto one;
        
        if(j > 0)
            break;

        else
            goto three;
        
    }
    printf("%d", j);
}