package algorithm;

import java.util.Arrays;

public class ADT {

    public void init(int parent[]){
        for(int i = 0; i < parent.length; i++){
            parent[i] = -1; //-1表示i节点暂时没有父节点
        }
    }
    //寻找该节点的根节点，若未找到，则返回-1，找到则返回根节点的值
    public int findRoot(int ver, int parent[]){
        int root = ver;
        while(parent[root] != -1){
            root = parent[root];
        }
        return root;
    }

    //联合两个节点
    public int uninVer(int x, int y, int parent[], int rank[]) {
        int xRoot = findRoot(x, parent);
        int yRoot = findRoot(y, parent);
        if (xRoot == yRoot){
            return 0;
        }else{
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            }else if (rank[yRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
            }else{
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        ADT adt = new ADT();
        int[][] adjVer = new int[][]{{0,1},{1,2},{2,3},{3,4},{4,0}};
        int[] parent = new int[5];
        int[] rank = new int[5];//int[] rank :记录某个节点形成的树的高度，1的父节点是2，那么2的高度是1，1的高度是0
        adt.init(parent);
        for (int i = 0; i < adjVer.length; i++){
            if (adt.uninVer(adjVer[i][0], adjVer[i][1], parent, rank) == 0){
                System.out.println("存在环");
            }
        }
        System.out.println(Arrays.toString(parent));
    }
}
