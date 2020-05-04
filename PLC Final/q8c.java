class Main
{
    public static void main(String[] args)
    {
        int j = -3;
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
        
        System.out.println(j);
    }
}