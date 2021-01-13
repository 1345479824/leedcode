package leedcode;

import java.util.Arrays;

public class LeedCode684 {

    public void initParent(int parent[]){
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }
    public int findRoot(int parent[], int ver){
        int root = ver;
        while(root != parent[root]){
            root = parent[root];
        }
        return root;
    }
    public boolean uninVer(int x, int y, int parent[], int res[]){
        int xRoot = findRoot(parent, x);
        int yRoot = findRoot(parent, y);
        if (xRoot == yRoot){
            res[0] = x + 1;
            res[1] = y + 1;
            return true;
        }
        parent[xRoot] = y;
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[2];
        int len = edges.length;
        int parent[] = new int[len];
        initParent(parent);
        for (int[] edge:edges){
            boolean status = uninVer(edge[0] - 1, edge[1] - 1, parent, res);
            if (status){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeedCode684 leedCode684 = new LeedCode684();
        int arr[][] = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        System.out.println(Arrays.toString(leedCode684.findRedundantConnection(arr)));
    }

}
