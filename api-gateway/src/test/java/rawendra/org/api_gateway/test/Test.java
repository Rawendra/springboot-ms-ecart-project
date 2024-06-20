package rawendra.org.api_gateway.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

  public static void main(String[] args) {
    String string= "How are you doing today?";

    List<Map.Entry<String, Long>> collect = Arrays.stream(string.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList());



    int l=collect.size();
    String key=collect.get(l-1).getKey();
    System.out.println(key);

  }


}
