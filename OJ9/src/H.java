import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class H {
    static InputReader input;
    static PrintWriter out;

    static class Node {
        int key;
        int[] po;
        ArrayList<Double> len;
        int father = 0;
        ArrayList<Node> kid;
    }

    public static void main(String args[]) throws IOException {
        input = new InputReader(System.in);
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            Node[] node = new Node[n + 3];
            for (int i = 1; i < n + 3; i++) {
                node[i] = new Node();
                node[i].po = new int[4];
                node[i].key = i;
                node[i].kid = new ArrayList<Node>();
                node[i].len = new ArrayList<Double>();
            }
            for (int i = 1; i < n + 1; i++) {
                node[i].po[0] = input.nextInt();
                node[i].po[1] = input.nextInt();
                node[i].po[2] = input.nextInt();
                node[i].po[3] = input.nextInt();
            }
            node[n + 1].po[0] = input.nextInt();
            node[n + 1].po[1] = input.nextInt();
            node[n + 1].po[2] = input.nextInt();
            node[n + 2].po[0] = input.nextInt();
            node[n + 2].po[1] = input.nextInt();
            node[n + 2].po[2] = input.nextInt();
            for (int i = 1; i < n + 3; i++) {
                for (int j = 1; j < n + 3; j++) {
                    if (i != j) {
                        double dis = getdis(node[i], node[j]);
                        node[i].kid.add(node[j]);
                        node[i].len.add(dis);
                    }
                }
            }
            double[] len = dijk(n + 1, node, n + 3);
            out.println(Math.round(len[n + 2] * 100));
            out.flush();
        }
    }

    public static double getdis(Node a, Node b) {
        long dis = (a.po[0] - b.po[0]) * (a.po[0] - b.po[0]) + (a.po[1] - b.po[1]) * (a.po[1] - b.po[1]) + (a.po[2] - b.po[2]) * (a.po[2] - b.po[2]);
        double x = Math.sqrt(dis) - a.po[3] - b.po[3];
        if (x < 0)
            x = 0;
        return x;
    }

    public static double[] dijk(int b, Node[] node, int n) {
        double[] len = new double[n + 1];
        for (int i = 1; i < n + 1; i++) {
            len[i] = Double.MAX_VALUE;
        }
        len[b] = 0.0;
        ss x = new ss();
        x.insert(0, b);
        int[] col = new int[n + 1];
        while (!x.isempty()) {
            Node a = node[x.getmin()];
            col[a.key] = 1;
            for (int i = 0; i < a.kid.size(); i++) {
                if (col[a.kid.get(i).key] == 0) {
                    double l = a.len.get(i);
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


class ss {
    double x[][];
    int num = 0;

    public ss() {
        double[][] x = new double[10000][2];
        this.x = x;
    }

    public void insert(double i, double j) {
        num++;
        x[num][0] = i;
        x[num][1] = j;
        swim(num);
    }

    public boolean isempty() {
        if (num == 0)
            return true;
        else
            return false;
    }

    public int getmin() {
        int ss = (int) x[1][1];
        delet();
        return ss;
    }

    public void delet() {
        exch(1, num--);
        x[num + 1] = new double[2];
        sink(1);
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


    private void swim(int k) {
        while (k > 1 && compare(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void exch(int i, int j) {
        double b = x[i][0];
        double a = x[i][1];
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