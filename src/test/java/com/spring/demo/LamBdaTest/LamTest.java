package com.spring.demo.LamBdaTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LamTest {

    @Test
    public void addTest() {
        Addition addition = (int a, int b) -> a + b;
        System.out.println(addition.additionx(1, 2));

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        strings.stream().filter(string -> !string.isEmpty()).sorted().collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        numbers.stream().map( i -> i*i).distinct().sorted().collect(Collectors.toList()).forEach(System.out::println);

        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }


}

interface Addition {
    int additionx(int a, int b);
}

