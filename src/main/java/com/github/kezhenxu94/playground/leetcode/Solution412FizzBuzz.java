package com.github.kezhenxu94.playground.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <pre>
 *
 * 412. Fizz Buzz
 *
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number
 * and for the multiples of five output “Buzz”. For numbers which are multiples
 * of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 *
 * </pre>
 *
 * @author kezhenxu
 */
public class Solution412FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        IntStream.range(1, n + 1).forEach(i -> {
            if (i % 15 == 0)
                result.add("FizzBuzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else if (i % 5 == 0)
                result.set(i, result.get(i - 1) + "Buzz");
            if (i % 3 != 0 && i % 5 != 0)
                result.add(String.valueOf(i));
        });
        return result;
    }
}
