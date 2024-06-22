package test.com.concept;
import java.util.Arrays;
import java.util.List;
 
public class CheckStringStartsWithDigit 
{
    public static void main(String[] args) 
    {
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        
        
        listOfStrings.stream().filter(v -> Character.isDigit(v.charAt(0))).forEach(System.out::println);
         
        listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
    }
}