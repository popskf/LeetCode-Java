package com.github.kezhenxu94.playground.leetcode;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 204. Count Primes
 *
 * Description:
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author ke.zhen.xu
 */
public class Solution204CountPrimes {

    /**
     * Time Limit Exceeded
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = n > 2 ? 1 : 0;
        for (int i = 3; i < n; i += 2)
            if (isPrime(i))
                count++;
        return count;
    }

    /**
     * Sieve of Eratosthenes
     *
     * @param n
     * @return
     */
    public int countPrimesV2(int n) {
        BitSet bs = new BitSet(n);
        for (int i = 2; i < n; i++) {
            while (bs.get(i))
                i++;
            for (int j = 2; i * j < n; j++)
                bs.set(i * j);
        }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (!bs.get(i))
                count++;
        return count;
    }

    private Map<Integer, Boolean> cache = new HashMap<Integer, Boolean>();

    private boolean isPrime(int num) {
        if (cache.containsKey(num))
            return cache.get(num);
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                cache.put(num, false);
                cache.put(num / i, false);
                return false;
            }
        }
        cache.put(num, true);
        return true;
    }
}
