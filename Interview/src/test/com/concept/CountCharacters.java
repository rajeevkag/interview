package test.com.concept;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
 
public class CountCharacters 
{
    public static void main(String[] args) 
    {
        String inputString = "Java Concept Of The Day";
         
        inputString.chars().mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        
        Map<Character, Long> charCountMap = 
                    inputString.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         
        System.out.println(charCountMap);
    }
}