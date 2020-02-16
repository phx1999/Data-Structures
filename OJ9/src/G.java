import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.logging.LogManager;

public class G {
    static class Node {
        int key;
        ArrayList<Long> len;
        int father = 0;
        ArrayList<Node> kid;
    }

    static InputReader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new InputReader(System.in);
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();
            Node[] node = new Node[n + 1];
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
                node[b].kid.add(node[a]);
                node[b].father++;
                node[a].father++;
                node[a].len.add(mid);
                node[b].len.add(mid);
            }
            int[] kk = new int[k];
            int[] num = new int[k];
            long[][] l = new long[k][n + 1];
            for (int i = 0; i < k; i++) {
                num[i] = i;
                kk[i] = input.nextInt();
                l[i] = dijk(kk[i], node, n);
            }
            ArrayList<Long> a=new ArrayList<Long>();
            a= sq(num, 0, n, l, kk,a);
            out.println(a.get(0));
            out.flush();
        }
    }

    public static ArrayList<Long> sq(int[] data, int k, int n, long[][] l, int[] kk,ArrayList<Long> a) {
        if (k == data.length) {
            long min = l[data[0]][1] + l[data[data.length - 1]][n];
            for (int i = 0; i < data.length - 1; i++) {
                min += l[data[i]][kk[data[i + 1]]];
            }
            if (a.size()!=0){
                if (min<a.get(0)){
                    a.remove(0);
                    a.add(min);
                }
            }else {
                a.add(min);
            }
        }
        for (int i = k; i < data.length; i++) {
            int temp = data[k];
            data[k] = data[i];
            data[i] = temp;
            sq(data, k + 1, n, l, kk,a);
            temp = data[k];
            data[k] = data[i];
            data[i] = temp;
        }
        return a;
    }

    public static long[] dijk(int b, Node[] node, int n) {
        long[] len = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            len[i] = Long.MAX_VALUE;
        }
        len[b] = 0;
        ss x = new ss();
        x.insert(0, b);
        int[] col = new int[n + 1];
        while (!x.isempty()) {
            Node a = node[x.getmin()];
            col[a.key] = 1;
            for (int i = 0; i < a.kid.size(); i++) {
                if (col[a.kid.get(i).key] == 0) {
                    long l = a.len.get(i);
                    if (len[a.kid.get(i).key] > l + len[a.key]) {
                        len[a.kid.get(i).key] = l + len[a.key];
                        x.insert(len[a.kid.get(i).key], a.kid.get(i).key);
                    }
                }
            }
        }
        return len;
    }
}


