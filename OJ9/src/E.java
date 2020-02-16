import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class E {
    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        go:
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            Node[] nodes = new Node[n + 1];
            for (int i = 1; i < n + 1; i++) {
                nodes[i] = new Node();
                nodes[i].key = i;
                nodes[i].kid = new ArrayList<Node>();
            }
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                nodes[a].kid.add(nodes[b]);
                nodes[b].father++;
            }
            PriorityQueue<Integer> x = new PriorityQueue<>();
            for (int i = 1; i < n + 1; i++) {
                if (nodes[i].father == 0) {
                    x.add(i);
                }
            }
            ArrayList<Integer> num=new ArrayList<>();
            while (!x.isEmpty()) {
                int i = x.poll();
                num.add(i);
                for (int j = 0; j < nodes[i].kid.size(); j++) {
                    nodes[i].kid.get(j).father--;
                    if (nodes[i].kid.get(j).father == 0)
                        x.add(nodes[i].kid.get(j).key);
                }
            }
            if (num.size()<n){
                out.println("impossible");
                out.flush();
            }else {
                for (int i=0;i<n;i++){
                    out.print(num.get(i)+" ");
                    out.flush();
                }
            }
            out.println();
            out.flush();
        }
    }
}

class Node {
    int key;
    int father;
    ArrayList<Node> kid;
}

