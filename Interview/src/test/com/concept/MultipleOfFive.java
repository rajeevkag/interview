package test.com.concept;
import java.util.Arrays;
 
public class MultipleOfFive 
{
    public static void main(String[] args) 
    {
    	int[] intArr = {45, 12, 56, 15, 24, 75, 31, 89};
    
        Arrays.stream(intArr).boxed().filter(i -> i % 5 == 0).forEach(System.out::println);
    }
}