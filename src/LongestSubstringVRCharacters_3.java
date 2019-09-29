import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringVRCharacters_3 {
    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param args
     */
    public static void main(String[] args){
        String s = "aabccabdcbdb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static  int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int lv = 0;
        int lv_l = 0;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<len;i++){
            Character t = s.charAt(i);
            if(!map.containsKey(t)){
                map.put(t,i);
                lv_l++;
            }else{
                Iterator<Character> iter = map.keySet().iterator();
                while (iter.hasNext()){
                    lv_l--;
                    if(!iter.next().equals(t)){
                        iter.remove();
                    }else{
                        iter.remove();
                        map.put(t,i);
                        lv_l++;
                        break;
                    }
                }
            }
            if(lv_l > lv )lv = lv_l;
        }
        return lv;
    }

}
