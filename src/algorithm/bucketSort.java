package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class bucketSort {
    public static void bucketSort(int[] nums){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int val:nums){
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        int buketCnt = (max - min) / 5 + 1;
        List<List<Integer>> buckets = new ArrayList<>(buketCnt);
        for(int i = 0; i < buketCnt; i++){ // 初始化buketCnt个桶
            buckets.add(new ArrayList<>());
        }
        //往桶里面塞元素
        for(int val:nums){
            buckets.get((val - min) / 5).add(val);
        }
        //每个桶进行排序
        for(List<Integer> bucket:buckets){
            Collections.sort(bucket);
        }
        //把桶里的元素依次放到nums数组里，即已完成排序
        int i = 0;
        for(List<Integer> bucket:buckets){
            for(Integer val:bucket) {
                nums[i++] = val;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,3,2,6,4,0,3,4,33,1,3,6,7,8,9};
        bucketSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
