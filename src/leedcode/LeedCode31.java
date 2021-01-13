package leedcode;

import java.util.Arrays;

public class LeedCode31 {
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        for(int i = len - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                int temp = i - 1, j = i;
                while(j < len && nums[j] > nums[temp]){
                    j++;
                }
                j--; //j定位到最小的一个比nums【temp】大的元素
                swap(nums, temp, j);
                int left = i, right = len - 1;
                while(left < right){ //翻转即可，因为后面的几个数一定是有序的
                    swap(nums, left, right);
                    left++;
                    right--;
                }
                flag = true;
                break;
            }
        }
        if(!flag){
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        LeedCode31 leedCode31 = new LeedCode31();
        int[] a = new int[]{1,2,3};
        leedCode31.nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}
