public class Str_28 {
    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Example 1:
     *
     * Input: haystack = "hello", needle = "ll"
     * Output: 2
     * Example 2:
     *"mississippi"
     * "issip"
     * Input: haystack = "aaaaa", needle = "bba"
     * Output: -1
     * @param args
     */

    public static void main(String[] args){

        System.out.println(strStr("hello","ll"));
    }

    /**
     * KMP
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = new int[needle.length()+1];
        next = cal_next(needle,next);
        while (i<haystack.length() && j <needle.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j==needle.length()){
            return i-j;
        }else{
            return  -1;
        }
    }
    public static  int[] cal_next(String h,int[] next){
        next[0] = -1;
        int i=0,j=-1;
        while (i<h.length()){
            if(j == -1||h.charAt(i)==h.charAt(j)){
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return  next;
    }
}
