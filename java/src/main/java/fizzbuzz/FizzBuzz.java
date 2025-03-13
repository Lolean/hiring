package fizzbuzz;

public class FizzBuzz
{

    public String pickOne(int input)
	{
        
        String result = Integer.toString(input);

        if( input % 3 == 0 )
		{
            result = "fizz";
        }

        if( input % 5 == 0) 
		{
			if(result == "fizz")
				return "fizzbuzz";
			
			result = "buzz";
        }

        return result;


    }

}
