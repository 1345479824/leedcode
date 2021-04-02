package algorithm;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums, int left, int right){
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        int s = nums[i];
        while(i < j){
            while(i < j && nums[j] >= s){
                j--;
            }
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            while(i < j && nums[i] <= s){
                i++;
            }
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        System.out.println(i + " " + j);
        nums[i] = s;
        sort(nums, left, i - 1);
        sort(nums, i + 1, right);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[]{8,5,3,4,-1,6,4,3,6,56,99,46};
        quickSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }
}
