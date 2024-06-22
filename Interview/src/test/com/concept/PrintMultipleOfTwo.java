package test.com.concept;
import java.util.stream.IntStream;
 
public class PrintMultipleOfTwo 
{
    public static void main(String[] args) 
    {
        IntStream.rangeClosed(1, 10).map(i -> i * 2).forEach(System.out::println);
    }
}