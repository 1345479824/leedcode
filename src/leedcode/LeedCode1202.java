package leedcode;

import java.util.*;

/**
  交换字符串中的元素
 **/
public class LeedCode1202 {
    public void init(int parent[]){
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }
    public int find(int vex, int parent[]){
        int root = vex;
        while(parent[root] != root){
            root = parent[root];
        }
        return root;
    }
    public void uninVex(int x, int y, int parent[], int rank[]){
        int xRoot = find(x, parent);
        int yRoot = find(y, parent);
        if (xRoot == yRoot) return; //说明有环，直接退出，否则可能会出现parent[0]=1 parent[1]=2 parent[2]=0的情况
        if (rank[xRoot] > rank[yRoot]){//x节点的高度大于y节点的高度，把y接入x
            parent[yRoot] = xRoot;
        }else if (rank[yRoot] > rank[xRoot]){
            parent[xRoot] = yRoot;
        }else if (rank[yRoot] == rank[xRoot]){
            parent[xRoot] = yRoot;
            rank[yRoot]++;
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        StringBuilder res = new StringBuilder();
        char[] s1 = s.toCharArray();
        int len = s1.length;
        HashMap<Integer, Queue<Character>> map = new HashMap<>();
        int parent[] = new int[len];
        int rank[] = new int[len];
        init(parent);
        for (List<Integer> var : pairs) {
            uninVex(var.get(0), var.get(1), parent, rank);
        }
        for (int i = 0; i < len; i++){
            int iParent = find(i, parent);
            if (!map.containsKey(iParent)){
                map.put(iParent, new PriorityQueue<>());
            }
            map.get(iParent).add(s1[i]);
        }
        for (int i = 0; i < len; i++){
            res.append(map.get(find(i, parent)).remove());
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
        LeedCode1202 adt = new LeedCode1202();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(0).add(0);
        list.get(1).add(7);
        list.get(1).add(1);
        list.get(2).add(9);
        list.get(2).add(1);
        list.get(3).add(3);
        list.get(3).add(0);
        list.get(4).add(7);
        list.get(4).add(1);
        list.get(5).add(0);
        list.get(5).add(4);
        list.get(6).add(6);
        list.get(6).add(5);
        list.get(7).add(2);
        list.get(7).add(6);
        list.get(8).add(6);
        list.get(8).add(4);
        list.get(9).add(6);
        list.get(9).add(0);
        System.out.println(adt.smallestStringWithSwaps("zbxxxdgmbz", list));
    }
}
