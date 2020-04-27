import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Streams {
    public static void main(String[] args) {
        String[] stringInts = new String[]{"9", "3", "1", "4", "5", "8", "11"};
        Character[] charInts = new Character[]{'9', '3', '1', '4', '5', '8', '7'};
        //ex1 - Stream array of chars
        System.out.println("ex1: Stream char -> ints - All odd numbers");
        Stream.of(charInts)
                .filter(x -> x.charValue() % 2 !=0)
                .forEach(System.out::println);
        System.out.println();
        //ex2 - Stream array of strings
        System.out.println("ex2: Stream string -> ints - All odd numbers");
        Stream.of(stringInts)
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 != 0)
                .forEach(s -> System.out.println(s));
        System.out.println();
        //ex3 - Stream list of characters
        System.out.println("ex3: Stream List -> flatmap - All odd numbers");
//        List<Character> test3 = Arrays.stream(charInts).collect(Collectors.toList());
        List<Character> test3 = new ArrayList<>(Arrays.asList(charInts));
        Stream.of(test3)
                .flatMap(l -> l.stream())
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
        System.out.println();
        //ex4 - Stream list of characters w/o creating variable
        System.out.println("ex4: Stream list -> flatmap - All odd numbers");
        Stream.of(Arrays.stream(charInts).collect(Collectors.toList()))
                .flatMap(l -> l.stream())
                .filter(x -> x % 2 != 0)
                .forEach(System.out::println);
        System.out.println();
        //ex5 - Return an array of ints
        System.out.println("ex5: Steam list -> int[] - All odd numbers");
        List<String> test4 = Arrays.stream(stringInts).collect(Collectors.toList());
        int[] retArr = Stream.of(test4)
                .flatMap(l -> l.stream())
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 != 0)
                .toArray();
        for(int i : retArr){
            System.out.println(i);
        }
        System.out.println();
        //ex6 - Return an array of ints
        System.out.println("ex6: Steam strings -> int[] - All odd numbers");
        int[] retArr2 = Stream.of(stringInts)
                .mapToInt(Integer::parseInt)
                .filter(x -> x % 2 != 0)
                .toArray();
        for(int i : retArr2){
            System.out.println(i);
        }
        System.out.println();
        //ex7 - Return an array of Integers
        System.out.println("ex7: Steam list -> Integer[] - All odd numbers");
        Integer[] retArr3 = Stream.of(stringInts)
                .map(Integer::parseInt)
                .filter(x -> x % 2 != 0)
                .toArray(Integer[]::new);
        for(int i : retArr3){
            System.out.println(i);
        }
    }
}
