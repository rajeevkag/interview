package test.com.concept;
import java.util.Arrays;
import java.util.stream.IntStream;
 
public class ReverseIntArray 
{
    public static void main(String[] args) 
    {
        int[] array = {5, 1, 7, 3, 9, 6};
         
        IntStream.rangeClosed(1, array.length).map(i -> array[array.length-i]).toArray();
        
        int[] reversedArray = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
         
        System.out.println(Arrays.toString(reversedArray));
    }
}