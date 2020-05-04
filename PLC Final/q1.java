import java.util.*;

public class Final_1 
{
    private static String type;

    public static void main(String[] args)
    {
        System.out.println("Reconizing an input is a Floating Point Literal, String Literal, or a Variable Name");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter any value and I will tell you what it is");

        String input = scan.nextLine();
        scan.close();

        if(validString(input))
        {
            type = "A  Sting Literal";
        }

        else if(validIdentifier(input))
        {
            type = "A Variable Name";
        }

        else if(validFloat(input))
        {
            type = "A Floating Point Literal";
        }

        else if(validInt(input))
        {
            type = "A Integer Literal";
        }

        else
        {
            type = "You entred something that is not any of the checking types";
        }

        System.out.println("Your input of " + input + " is a " + type);

    }

    private static boolean validString(String input)
    {
        String strRegex = "^\"{1}[^\"]*\"{1}$";

        if(input.matches(strRegex))
            return true;

        else
            return false;
    }

    private static boolean validInt(String input)
    {
        String intRegex = "^[-+]?[0-9]+$";

        if(input.matches(intRegex))
            return true;

        else
            return false;
    }

    private static boolean validIdentifier(String input)
    {
        String identifierRegex = "^[a-zA-Z_$][a-zA-Z0-9_$]*$";

        if(input.matches(identifierRegex))
            return true;
        else
            return false;
    }

    private static boolean validFloat(String input)
    {
        String floatRegex = "[+-]?([0-9]*[.])?[0-9]+[fFlL]?[+]?[eE]?[0-9]*";

        if(input.matches(floatRegex))
            return true;
            
        else
            return false;
    }

}