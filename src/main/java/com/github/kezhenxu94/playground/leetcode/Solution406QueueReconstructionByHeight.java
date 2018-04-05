package com.github.kezhenxu94.playground.leetcode;

/**
 * <pre>
 *
 * 406. Queue Reconstruction by Height
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * </pre>
 *
 * TODU unfinished
 *
 * @author Ke Zhenxu
 */
public class Solution406QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        boolean[] visited = new boolean[people.length];
        for (int i = 0; i < result.length; i++) {
            int minIdx = 0;
            for (int j = 0; j < people.length; j++) {
                if (!visited[j]) {
                    if (people[j][0] < people[minIdx][0]) {
                        minIdx = j;
                    } else if (people[j][0] == people[minIdx][0] && people[j][1] < people[minIdx][1]) {
                        minIdx = j;
                    }
                }
            }
            visited[minIdx] = true;
        }
        return result;
    }
}
