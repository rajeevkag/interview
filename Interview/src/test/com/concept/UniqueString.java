package test.com.concept;
import java.util.List;
import java.util.stream.Collectors;
 
public class UniqueString 
{
    public static void main(String[] args) 
    {
        List<String> listOfStrings = List.of("Java", "Python", "C#", "Java", "Kotlin", "Python");
         
        List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());
         
        System.out.println(uniqueStrngs);
    }
}