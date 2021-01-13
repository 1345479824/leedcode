package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 线段树
 * 需求：1、求数组的第i位到第j位的和 2、更新这个数组的某一个元素
 */
public class SegTree {

    //构建线段树
    public void buildTree(int tree[], int arr[], int left, int right, int parent){
        if (left == right) {
            tree[parent] = arr[left];
            return;
        }
        int treeLeft = parent * 2 + 1;
        int treeRight = parent * 2 + 2;
        int mid = (left + right) / 2;
        buildTree(tree, arr, left, mid, treeLeft);
        buildTree(tree, arr, mid + 1, right, treeRight);
        tree[parent] = tree[treeLeft] + tree[treeRight];
    }
    //获取某一段的和
    public int sum(int tree[], int treeLeft, int treeRight, int left, int right, int parent){
        int mid = (left + right) / 2;
        int leftChild = parent * 2 + 1;
        int righdChild = parent * 2 + 2;
        if (treeLeft < left || treeRight > right) return 0;
        if (left >= treeLeft && right <= treeRight){
            return tree[parent];
        }
        int lSum = sum(tree, treeLeft, treeRight, left, mid, leftChild);
        int rSum = sum(tree, treeLeft, treeRight, mid + 1, right, righdChild);
        return lSum + rSum;
    }
    //更新某一个值
    public void update(int tree[], int arr[], int index, int date, int left, int right, int parent){
        if (left == right) {
            arr[index] = date;
            tree[parent] = date;
            return;
        }
        int mid = (left + right) / 2;
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        if (index <= mid) {
            update(tree, arr, index, date, left, mid, leftChild);
        }else {
            update(tree, arr, index, date, mid + 1, right, rightChild);
        }
        tree[parent] = tree[leftChild] + tree[rightChild];
    }
//    public int update(int tree[], int arr[], int index, int date, int left, int right, int parent){
//        if (left == right) {
//            arr[index] = date;
//            tree[parent] = date;
//            return date;
//        }
//        int mid = (left + right) / 2;
//        int leftChild = parent * 2 + 1;
//        int rightChild = parent * 2 + 2;
//        int lSum = tree[leftChild], rSum = tree[rightChild];
//        if (index <= mid) {
//            lSum = update(tree, arr, index, date, left, mid, leftChild);
//        }else {
//            rSum = update(tree, arr, index, date, mid + 1, right, rightChild);
//        }
//        tree[parent] = lSum + rSum;
//        return tree[parent];
//    }

    public static void main(String[] args) {
        SegTree segTree = new SegTree();
        int arr[] = new int[]{1,2,3,4,5};
        int tree[] = new int[20];
        segTree.buildTree(tree, arr, 0, arr.length - 1, 0);
        int m = segTree.sum(tree, 0, 0, 0, arr.length - 1, 0);
        System.out.println(Arrays.toString(tree));
        System.out.println(m);
        segTree.update(tree, arr, 0, 2, 0, 4, 0);
        System.out.println(Arrays.toString(tree));
    }
}
