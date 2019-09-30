import java.lang.reflect.Array;

public class MedianofTwoSortedArrays_4 {
    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     */
    public static void main(String[] args){
        int a1[] = {};
        int a2[] = {1};
        System.out.println(findMedianSortedArrays(a1,a2));
    }

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int nSum = n1 + n2;

        int arr[] = new int[nSum];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i<n1 && j <n2){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                i++;
            }else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        if((nSum & 1) != 0){
            return arr[nSum>>1];
        }else{
            return (arr[(nSum>>1)-1] + arr[nSum>>1])/2.0;
        }
    }

}
