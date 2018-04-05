package com.github.kezhenxu94.playground.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 *
 * Given  an  arbitrary  ransom  note  string  and  another  string
 * containing  letters from  all  the  magazines,  write  a  function
 * that  will  return  true  if  the  ransom   note  can  be  constructed
 * from  the  magazines ;  otherwise,  it  will  return  false.
 *
 * Each  letter  in  the  magazine  string  can  only  be  used  once
 * in  your  ransom  note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c : magazine.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        for (char c : ransomNote.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) - 1);
        for (int cnt : counts.values())
            if (cnt < 0)
                return false;
        return true;
    }
}
