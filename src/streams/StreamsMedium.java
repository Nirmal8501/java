package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMedium {
    public static void main(String[] args) {
        question3();
    }

    /*Q1
    Flatten Nested Lists
    Given List<List<Integer>>, flatten into a single sorted List<Integer>.
    */
    public static List<List<Integer>> numbers = Arrays.asList(
            Arrays.asList(5, 12, -3, 7),
            Arrays.asList(10, 2, 14, 2),
            Arrays.asList(8, 19, 0),
            Arrays.asList(25, 18, 5, -7),
            Arrays.asList(3, 15, 6, 6)
    );

    public static void question1(){
        List<Integer> allNums = numbers.stream()
                .flatMap(numStream -> numStream.stream())
                .peek(num -> System.out.print(num + " -> "))
                .toList();
    }

    /*Q2
    Map to Set
    Given List<Employee> with department, name, return Map<String, Set<String>> mapping department → employee names.
    */
    public record Employee(String department, String name, int salary) {}

    public static List<Employee> employees = List.of(
            new Employee("Engineering", "Alice", 120000),
            new Employee("Engineering", "Bob", 95000),
            new Employee("Engineering", "Charlie", 110000),
            new Employee("HR", "Diana", 60000),
            new Employee("HR", "Eve", 65000),
            new Employee("Finance", "Frank", 200000),   // high salary
            new Employee("Finance", "Grace", 75000),
            new Employee("Finance", "Hank", 80000),
            new Employee("Finance", "Alice", 120000),   // Alice appears in another dept
            new Employee("Sales", "Ivy", 55000),
            new Employee("Sales", "Jack", 58000),
            new Employee("Sales", "Alice", 120000),     // Alice again in Sales
            new Employee("Engineering", "Alice", 120000), // duplicate in Engineering
            new Employee("Engineering", "Alice", 120000), // exact duplicate
            new Employee("Finance", "Frank", 200000)     // exact duplicate
    );

    public static void question2(){
        Map<String, Set<String>> groupEmpByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                employee -> employee.department,
                                Collectors.mapping(employee -> employee.name, Collectors.toSet())
                        ));
        System.out.println(groupEmpByDept);
    }

    /*Q3
    Group by Age
    Given List<Person> with age, return Map<Integer, List<Person>> grouped by age.
    */
    public record Person(String name, int age) {}
    public static List<Person> people = List.of(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 25),
            new Person("Diana", 35),
            new Person("Eve", 30),
            new Person("Frank", 40),
            new Person("Grace", 25),
            new Person("Hank", 35),
            new Person("Ivy", 40),
            new Person("Jack", 30)
    );

    public static void question3(){
        Map<Integer, List<Person>> groupByAge =
                people.stream()
                        .collect(Collectors.groupingBy(
                                person -> person.age,
                                Collectors.mapping(
                                        person -> person,
                                        Collectors.toList()
                                )
                        ));
        System.out.println(groupByAge);
    }



    /*Q4
    Top 3 Highest Salaries
    Given List<Employee>, return top 3 salaries.
    */

    public static void question4(){
        List<Integer> salaries = employees.stream()
                .map(employee -> employee.salary)
                .sorted()
                .limit(3)
                .toList();

    }

}













