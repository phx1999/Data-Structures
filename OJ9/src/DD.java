import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DD {
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
            edge[] e = new edge[m + k];
            s s = new s();
            for (int i = 0; i < m + k; i++) {
                e[i] = new edge();
                e[i].key = i;
                e[i].from = input.nextInt();
                e[i].to = input.nextInt();
                e[i].wei = input.nextLong();
                s.insert(e[i]);
            }
            int l = 0;
            int ans = 0;
            UnionFind u = new UnionFind(n + 1);
            while (l < n - 1) {
                edge x = s.getmin();
                if (x == null) {
                    out.println("-1");
                    out.flush();
                    continue go;
                }
                if (!u.isConnected(x.from, x.to)) {
                    u.union(x.from, x.to);
                    ans += x.wei;
                    l++;
                }
            }
            out.println(ans);
            out.flush();
        }
    }
}

class edge {
    int key;
    int from;
    int to;
    long wei;
}


class s {
    edge[] x;
    int num = 0;

    public s() {
        edge[] x = new edge[100001];
        this.x = x;
    }

    public void insert(edge a) {
        x[++num] = a;
        swim(num);
    }

    public edge getmin() {
        edge a = x[1];
        delet();
        return a;
    }

    public void delet() {
        exch(1, num--);
        x[num + 1] = null;
        sink(1);
    }


    private void swim(int k) {
        while (k > 1 && compare(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= num) {
            int j = 2 * k;
            if (j < num && compare(j, j + 1))
                j++;
            if (!compare(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        edge t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    private boolean compare(int i, int j) {
        if (x[i].wei > x[j].wei) {
            return true;
        } else
            return false;
    }
}
