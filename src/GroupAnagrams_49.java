import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class GroupAnagrams_49 {

    /**
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     * @param args
     */
    public static void main(String[] args){
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Long start = System.currentTimeMillis();
        groupAnagrams2(test);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(groupAnagrams1(test));
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] sum = strs[i].toCharArray();
            Arrays.sort(sum);
            String sumn = String.valueOf(sum);
            if(map.containsKey(sumn)){
                map.get(sumn).add(strs[i]);
                continue;
            }
            List<String> l = new ArrayList<>();
            l.add(strs[i]);
            map.put(sumn,l);
        }
        for(List value:map.values()){
            list.add(value);
        }
        return list;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List> map = new HashMap<>();
        for(String str:strs){
            char[] as = new char[26];
            str.chars().forEach(sc-> as[sc-97]++);
            String sumstr = new String(as);
            List<String> l =map.getOrDefault(sumstr,new ArrayList());
            l.add(str);
            map.put(sumstr,l);
        }
        for(List value:map.values()){
            list.add(value);
        }
        return list;
    }
}
