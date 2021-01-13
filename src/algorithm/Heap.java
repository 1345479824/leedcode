package algorithm;

import java.util.Arrays;

/**
 * 构建堆、堆排序  heap（堆的意思）
 * 堆的插入操作是一个上浮的过程，堆的删除操作是一个下沉的过程
 */
public class Heap {
    //交换
    public void swap(int heap[], int parent, int child){
        int temp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = temp;
    }
    //下沉操作,将前n个数（n代表个数）进行下沉操作
    public void shutDown(int heap[], int parent, int n){
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int min = parent;
        if (leftChild < n && heap[min] > heap[leftChild]){
            min = leftChild;
        }
        if (rightChild < n && heap[min] > heap[rightChild]){
            min = rightChild;
        }
        if (min == parent) return;
        swap(heap, parent, min);
        shutDown(heap, min, n);
    }
    //小根堆的构建，n代表个数
    public void heapBuild(int heap[], int n){
        int parent = (n - 1) / 2;
        for (int i = parent - 1; i >= 0; i--){
            shutDown(heap, i, n);
        }
    }
    //堆排序
    public void heapSort(int heap[], int n){
        for (int i = n - 1; i > 0; i--){
            swap(heap, 0, i);
            shutDown(heap, 0, i);
        }
    }

    public static void main(String[] args) {
        Heap heapBuild = new Heap();
        int heap[] = new int[]{10,28,1,34,59,23,123,3};
        heapBuild.heapBuild(heap, 8);
        System.out.println(Arrays.toString(heap));
        heapBuild.heapSort(heap,8);
        System.out.println(Arrays.toString(heap));
    }
}
