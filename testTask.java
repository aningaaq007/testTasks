import java.util.Arrays;
import java.util.function.Function;
import java.util.Map;
import java.util.stream.Collectors;
 
public class Test {
    public static void main(String args[]) {
        
        Map<Integer, Long> result = Arrays.stream(new Integer[]{1, 3, 4, 5, 1, 5, 4})
                                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      
        System.out.println("result: " + result);
    }
}