package test.com.concept;
import java.util.Arrays;
 
public class AverageArray 
{
    public static void main(String[] args) 
    {
        int[] a = {45, 12, 56, 15, 24, 75, 31, 89};
         
        int sum = Arrays.stream(a).sum();
         
        System.out.println("Sum = "+sum);
         
        double average = Arrays.stream(a).average().getAsDouble();
         
        System.out.println("Average = "+average);
    }	
}