package test.com.concept;
import java.util.Arrays;
import java.util.stream.IntStream;
 
public class MergeTwoUnsortedArray 
{
    public static void main(String[] args) 
    {
        int[] a = new int[] {4, 2, 7, 1,2,3};
         
        int[] b = new int[] {8, 3, 9, 5};
        
         
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).distinct().sorted().toArray();
         
        System.out.println(Arrays.toString(c));
    }
}