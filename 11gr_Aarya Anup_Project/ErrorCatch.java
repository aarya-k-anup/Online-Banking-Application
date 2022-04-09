import java.util.*;
public class ErrorCatch
{
    public static boolean isInteger(String input)
    {
        int test=0;
        try
        {
            test = Integer.parseInt(input);
            if(test<0)
                throw new ArithmeticException("negative number");
            return true;
        }
        catch(Exception e)
        {
           return false;
        }
    }
}