import java.util.*;

public class ThreeSum_15 {
    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example:
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     *  [-4 -1 -1 0 1 2]
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param args
     */
    public static void main(String[] args){
//        int[] nums = {-2,0,0,2,2};
        int[] nums = {-1, 0, 1, 2, -1,-1,-1, -4,0,0,0};
        System.out.println(threeSum(nums));
    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> tl = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length==0 || nums[0]>0 || nums[nums.length-1]<0) return tl;
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        int tmp = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) low.add(nums[i]);
            else high.add(nums[i]);
            if(nums[i]==0) tmp++;
        }
        if(tmp>=3) tl.add(Arrays.asList(0,0,0));
        tmp = -1;
        forSum(high,low,tl,tmp);
        tmp = 0;
        forSum(low,high,tl,tmp);
        return tl;
    }

    public static void forSum(List<Integer> value,List<Integer> rValue, List<List<Integer>> tl,int tmp){
        for(int Value:value){
            if(Value==tmp) continue;
            List<List> sum = twoSum(rValue,-Value);
            if(sum.size()!=0){
                sum.forEach(i-> tl.add(i));
            }
            tmp = Value;
        }
    }

    public static  List<List> twoSum(List<Integer> nums, int target) {
        Set<List> list = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums.get(i);
            if (map.containsKey(complement)) {
                if(nums.get(0)<0)
                    list.add(Arrays.asList( complement, nums.get(i),-target ));
                else
                    list.add(Arrays.asList( -target ,complement, nums.get(i)));
            }
            map.put(nums.get(i),i);
        }
        return new ArrayList<>(list);
    }
}
