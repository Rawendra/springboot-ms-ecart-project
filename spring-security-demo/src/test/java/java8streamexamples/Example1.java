package java8streamexamples;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example1 {
  public static void main(String[] args) {

    String input="rawendrasinghkushwaha";
// question 1: printing the string and occurence of
    Map<String, Long> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    System.out.println(collect);

// question 2: find the duplicate elements in the string

    List<String> collect1 = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
    System.out.println(collect1);

    // question 3: find the unique elements in the string

    List<String> collect2 = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());

    System.out.println(collect2);

    int[] numbers={1,2,3,4,5,6,7,8,8,9,7,5,4,23};

    // question 4: find the second highest number in the array

    Integer i = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
    System.out.println(i);


    //question 5: find the second lowest number in the array
    Integer i1 = Arrays.stream(numbers).boxed().sorted().skip(1).findFirst().get();
    System.out.println(i1);


    // question 6: find the second largest string from the array
    String [] arr2= {"A","AS","ASD","ASD TYU"};
    String s2 = Arrays.stream(arr2).reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2).get();
    System.out.println("printing the largest string in the array"+ s2);
    // question 7: find the numbers that start with 1
    int[] numbers2={1,2,3,4,5,6,7,8,8,9,7,15,14,23};

    List<Integer> collect3 = Arrays.stream(numbers2).boxed().filter(s -> (s + "").startsWith("1")).toList();
    System.out.println(collect3);

    // question 8: add a de limiter betweem the string

    String s3="ASD";

    String s5=String.join("-", s3.split(""));

  }
}
