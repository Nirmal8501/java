package streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsEasy {
    public static void main(String[] args) {
        question9();
    }

    /*   Easy
     Q1.
     Filter Employees by Salary
     Given List<Employee> with name, salary, return names of employees earning more than 50,000 in a List<String> sorted alphabetically. */
    record Employee(String name, Integer salary){}
    public static void question1(){
        List<Employee> employees = List.of(new Employee("Raj", 15000), new Employee("Shweta", 60000),
                new Employee("NJ", 100000), new Employee("Bruh", -10000));

        List<Employee> result = employees.stream()
                .filter(employee -> employee.salary() > 50000)
                .sorted(Comparator.comparing(Employee::name).reversed())      // or Comparator.reverseOrder() this just reverses the key comparison and not the comparator, or .thenComparing for multiple, .reversed() // this reverses the comparator
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(result);
    }

    /* Q2.
    Uppercase Names
    Given List<String> names, return a list of names in uppercase without duplicates. */
    public static List<String> names = List.of(
            "Raj",
            "Shweta",
            "NJ",
            "Raj",
            "Mia",
            "Shweta",
            "alex",
            "arman",
            "ayush",
            "NJ", "Mani", "Mani"
    );

    public static void question2(){
        Set<String> result = names.stream()
                .map(names -> names.toUpperCase(Locale.ENGLISH))
                .collect(Collectors.toSet());   // Collectors.toCollection(TreeSet::new) toCollection is used when we want a specifc implementation of any collection

        System.out.println(result);
    }

  /*  Q3
    Find Even Numbers
    Given List<Integer> numbers, return even numbers in ascending order. */
    public static List<Integer> nums = List.of(1,2,3,44,55,33,22,66,78,453,23,543,4544,322,33,3,3,36,56,19);
    public static void question3(){
     List<Integer> result = nums.stream()
             .filter(number -> number%2 == 0)
             .sorted()
             .toList();

        System.out.println(result);
    }

    /* Q4
    Join Strings
    Given List<String> words, join them into a single string separated by commas. */
    public static void question4(){
        String joinedString = names.stream()
                .collect(Collectors.joining(","));
        // alternative  ->  String.join(",", names)
        // alternative .stream().reduce((a, b) -> a + "," + b) but use optional<string> here

        System.out.println(joinedString);
    }

    /* Q5
     Find First Matching Element
     Given List<String> items, return the first element that starts with "A", or "Not Found" if none exist.
    */
    public static void question5(){
        String firstOccurance = names.stream()
                .filter(names -> names.startsWith("A"))
                .findFirst()
                .orElse("NOT FOUND");
    }


    /* Q6
    Count Items Matching Condition
    Given List<String> cities, count how many start with "New".
    */

    public static List<String> cities = Arrays.asList(
            "New York",
            "New Delhi",
            "New Orleans",
            "Newark",
            "Newcastle",
            "New Brunswick",
            "Los Angeles",
            "Chicago",
            "Houston",
            "Mumbai",
            "New Plymouth",
            "Tokyo",
            "New Haven",
            "London",
            "Sydney",
            "Paris",
            "New Bedford",
            "Newport",
            "Berlin",
            "Cape Town",
            "Toronto",
            "New Albany",
            "Singapore"
    );

    public static void question6(){
        long citiesWithNew = cities.stream()
                .filter(city -> city.startsWith("New "))
                .count();
        System.out.println("Cities with new: " + citiesWithNew);
    }

    /*Q7
    Square Numbers
    Given List<Integer> numbers, return a list of squares of each number.
    */

    public static void question7(){
        List<Long> squares = nums.stream()
                .map(nums -> (long) nums * nums)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(squares);
    }

    /* Q8
    * Get Distinct Lengths
    Given List<String> words, return a sorted list of distinct word lengths.
    */

    public static void question8(){
        List<Integer> wordLength = cities.stream()
                .map(String::length)
                .distinct()
                .sorted()
                .toList();

        System.out.println(wordLength);
    }

    /* Q9
    * Sum of Positive Numbers
    Given List<Integer> numbers, find the sum of positive numbers.
    */


    public static void question9(){
        List<Integer> nums = List.of(1,2,3,4,5,-5,-5,-5,-5,-55, 100);
        var x = nums.stream()
                .filter(num -> num>=0)
                .reduce((num1, num2) -> num1 + num2);  // lambda can be replaced with Integer::sum

        System.out.println(x.get());
    }

    /* Q10
    * Any Match Check
    Given List<String> names, check if any name equals "John" (case-insensitive).
    */


}
