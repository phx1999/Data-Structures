import javax.print.attribute.standard.SheetCollate;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class D {
    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        go:
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();
            node[] nodes = new node[n + 1];
            for (int i = 1; i < n + 1; i++) {
                nodes[i] = new node();
                nodes[i].key = i;
                nodes[i].nei = new ArrayList<node>();
                nodes[i].wei = new ArrayList<Long>();
            }
            int x = 0;
            int y = 0;
            long z = 10001;
            int l = 0;
            int[] col = new int[n + 1];
            for (int i = 0; i < m + k; i++) {
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
            HashMap<Integer, Long> dis = new HashMap<>();
            int dian = 0;
            long mmin = 10001;
            for (int i = 1; i < n + 1; i++) {
                if (col[i] == 0) {
                    long min = 10001;
                    for (int j = 0; j < nodes[i].degree; j++) {
                        if (col[nodes[i].nei.get(j).key] == 1) {
                            if (nodes[i].wei.get(j) < min) {
                                min = nodes[i].wei.get(j);
                            }
                            if (min < mmin) {
                                dian = i;
                                mmin = min;
                            }
                        }
                    }
                    dis.put(i, min);
                }
            }
            while (l < n) {
                l++;
                z += mmin;
                col[dian] = 1;
                dis.remove(dian);
                if (l == n) {
                    break;
                }
                for (int j = 0; j < nodes[dian].degree; j++) {
                    if (col[nodes[dian].nei.get(j).key] == 0 && nodes[dian].wei.get(j) < dis.get(nodes[dian].nei.get(j).key)) {
                        dis.put(nodes[dian].nei.get(j).key, nodes[dian].wei.get(j));
                    }
                }
                SHeap ss = new SHeap();
                for (int key : dis.keySet()) {
                    ss.insert(dis.get(key), key);
                }
                mmin = ss.getmin()[0];
                if (mmin == 10001) {
                    out.println("-1");
                    out.flush();
                    continue go;
                }
                dian = (int) ss.getmin()[1];
            }
            out.println(z);
            out.flush();
        }
    }
}

class SHeap {
    long x[][];
    int num = 0;

    public SHeap() {
        long[][] x = new long[10000][2];
        this.x = x;
    }

    public void insert(long i, int j) {
        ++num;
        x[num][0] = i;
        x[num][1] = j;
        swim(num);
    }

    public long[] getmin() {
        long[] ss = new long[2];
        ss[0] = x[1][0];
        ss[1] = x[1][1];
        return ss;
    }


    private void swim(int k) {
        while (k > 1 && compare(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        long b = x[i][0];
        long a = x[i][1];
        x[i][0] = x[j][0];
        x[i][1] = x[j][1];
        x[j][0] = b;
        x[j][1] = a;
    }

    private boolean compare(int i, int j) {
        if (x[i][0] > x[j][0]) {
            return true;
        } else
            return false;
    }
}

class node {
    int key;
    int degree;
    ArrayList<node> nei;
    ArrayList<Long> wei;
}

