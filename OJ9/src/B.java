import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class B {
    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            node[] nodes = new node[n + 1];
            for (int i = 1; i < n + 1; i++) {
                nodes[i] = new node();
                nodes[i].key = i;
                nodes[i].nei = new ArrayList<node>();
                nodes[i].wei = new ArrayList<Long>();
            }
            int x = 0;
            int y = 0;
            long z = 1001;
            int l = 0;
            int[] col = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                long c = input.nextLong();
                if (c < z) {
                    x = a;
                    y = b;
                    z = c;
                    l = 2;
                }
                nodes[a].degree++;
                nodes[b].degree++;
                nodes[a].nei.add(nodes[b]);
                nodes[b].nei.add(nodes[a]);
                nodes[a].wei.add(c);
                nodes[b].wei.add(c);
            }
            col[x] = 1;
            col[y] = 1;
            while (l < n) {
                long min = 1001;
                int dian = 0;
                for (int i = 1; i < n + 1; i++) {
                    if (col[i] == 0) {
                        for (int j = 0; j < nodes[i].degree; j++) {
                            if (col[nodes[i].nei.get(j).key] == 1) {
                                if (nodes[i].wei.get(j) < min) {
                                    min = nodes[i].wei.get(j);
                                    dian = i;
                                }
                            }
                        }
                    }
                }
                col[dian] = 1;
                z+=min;
                l++;
            }
            out.println(z);
            out.flush();
        }
    }


    static class node {
        int key;
        int degree;
        ArrayList<node> nei;
        ArrayList<Long> wei;
    }
}
