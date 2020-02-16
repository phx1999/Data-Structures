import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class main {
    static class Node {
        int key;
        ArrayList<Long> len;
        int father = 0;
        ArrayList<Node> kid;
    }

    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            Node[] node = new Node[n + 1];
            long[] len = new long[n + 1];
            Queue<Node> x = new LinkedList<Node>();
            for (int i = 1; i < n + 1; i++) {
                node[i] = new Node();
                node[i].key = i;
                node[i].kid = new ArrayList<Node>();
                node[i].len = new ArrayList<Long>();
            }
            for (int j = 0; j < m; j++) {
                int a = input.nextInt();
                int b = input.nextInt();
                long mid = input.nextLong();
                node[a].kid.add(node[b]);
                node[b].father++;
                node[a].len.add(mid);
            }
            for (int i = 1; i < n + 1; i++) {
                if (node[i].father == 0) {
                    x.add(node[i]);
                }
            }
            while (!x.isEmpty()) {
                Node a = x.poll();
                for (int i = 0; i < a.kid.size(); i++) {
                    a.kid.get(i).father--;

                }
                for (int i = 0; i < a.kid.size(); i++) {
                    if (a.kid.get(i).father == 0) {
                        x.add(a.kid.get(i));
                    }
                    long l = a.len.get(i);
                    if (len[a.kid.get(i).key] < l + len[a.key]) {
                        len[a.kid.get(i).key] = l + len[a.key];
                    }
                }
            }
            long ans = 0;
            for (int i = 1; i < n + 1; i++) {
                if (len[i] > ans)
                    ans = len[i];
            }
            out.println(ans);
            out.flush();
        }
    }
}
