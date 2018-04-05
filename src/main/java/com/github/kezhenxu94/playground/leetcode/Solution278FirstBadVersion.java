package com.github.kezhenxu94.playground.leetcode;

/**
 * 278. First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * @author Ke Zhenxu
 */
public class Solution278FirstBadVersion extends VersionControl {

    public int firstBadVersionV1(int n) {
        int from = 1;
        int to = n;
        while (from < to) {
            /*
             * TODO TRICK:
             * This may cause (from + to) > MAX_INT
             * int mid = (from + to) / 2;
             *
             * TODO TRICK:
             * In binary search, when you do more checkings,
             * it will be more close to linear time.
             */
            int mid = from + (to - from) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1))
                    return mid;
                else
                    to = mid - 1;
            } else {
                if (isBadVersion(mid + 1))
                    return mid + 1;
                else
                    from = mid + 1;
            }
        }
        return from;
    }

    public int firstBadVersionV2(int n) {
        int from = 1;
        int to = n;
        while (from < to) {
            int mid = from + (to - from) / 2;
            if (isBadVersion(mid))
                to = mid;
            else
                from = mid + 1;
        }
        return to;
    }

}

class VersionControl {
    // DUMMY
    public boolean isBadVersion(int n) {
        return false;
    }
}