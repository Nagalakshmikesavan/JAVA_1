import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class non_repeating_integer_Array {

    public static void main(String[] args)

    {
        int arr[] = {23,4,14,4,23,22,3,56,3};
        Map<Integer,Integer> map = new LinkedHashMap<>();

         List<Integer> res = Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().
                 stream().filter(entry->entry.getValue()==1).map(entry->entry.getKey()).collect(Collectors.toList());
         System.out.println(res);

         List<Integer> res1 =Arrays.stream(arr).boxed().distinct().collect(Collectors.toList());
        System.out.println(res1);

        String str = "Hello geeks for geeks";
        String[] arrs = str.split(" ");
        HashMap<Character,Long> map1 = str.chars().mapToObj(ch->(char)ch).filter(x->!x.equals("")).collect(Collectors.groupingBy(Function.identity(),HashMap::new,
                Collectors.counting()));
        System.out.println(map1);

        HashMap<String,Long> map2 = Arrays.asList(str.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(),HashMap::new,
                Collectors.counting()));
        System.out.println(map2);

        //print distinct vowels present in the string
        List<Character> list = str.chars().mapToObj(x->(char)x).filter(x->x=='a'||x=='e'||x=='i'||x=='o'||x=='u').distinct().collect(Collectors.toList());

        System.out.println(list);
    }
}
