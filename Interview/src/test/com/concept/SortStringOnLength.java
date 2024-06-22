package test.com.concept;
import java.util.Comparator;
import java.util.List;
 
public class SortStringOnLength 
{
    public static void main(String[] args) 
    {
        List<String> listOfStrings = List.of("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }
}