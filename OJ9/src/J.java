import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class J {
    static class Node {
        int key;
        int father = 0;
        ArrayList<Node> kid;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            Node[] vill = new Node[n + 1];
            HashMap<Integer,Integer> wol=new HashMap<>();
            for (int i = 1; i < n + 1; i++) {
                vill[i] = new Node();
                vill[i].key = i;
                vill[i].kid = new ArrayList<Node>();
            }
            UnionFind u=new UnionFind(n+1);
            for (int i=1;i<n+1;i++){
                String s=input.readLine();
                int a=Integer.parseInt(s.split(" ")[0]);
                String s1=s.split(" ")[1];
                if (s1.equals("werewolf")){
                    wol.put(i,a);
                }else {
                    vill[a].kid.add(vill[i]);
                    vill[i].father=a;
                    u.union(a,i);
                }
            }
            ArrayList<Integer> root=new ArrayList<>();
            for (int i=1;i<n+1;i++){
                if (vill[i]==null)
                    continue;
                else {
                    if (vill[i].father==0){
                        root.add(i);
                    }
                }
            }
            int ans=0;
            for (int i=0;i<root.size();i++){
                int a=root.get(i);
                if (u.isConnected(a,wol.get(a))){
                    ans+=get(vill,wol.get(a));
                }
            }
            System.out.println(ans);
        }
    }
    public static int get(Node[] vill,int a){
        Queue<Integer> x=new LinkedList<>();
        x.add(a);
        int num=0;
        while (!x.isEmpty()){
            int b=x.poll();
            num++;
            for (int i=0;i<vill[b].kid.size();i++)
                x.add(vill[b].kid.get(i).key);
        }
        return num;
    }
}
class UnionFind {

    private int[] parent;

    private int[] rank;

    private int size;

    public UnionFind(int size) {
        this.size = size;
        parent = new int[size];
        rank = new int[size];
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean unconnect() {
        int a = 0;
        for (int i = 1; i < size; i++) {
            if (parent[i] == i) {
                a++;
            }
            if (a == 2) {
                return true;
            }
        }
        return false;
    }

    public int find(int target) {
        if (target >= size)
            throw new ArrayIndexOutOfBoundsException();
        if (target == parent[target])
            return target;
        return find(parent[target]);
    }


    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
