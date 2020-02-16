import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class F {
    static class Node {
        int key;
        ArrayList<Long> len;
        int father = 0;
        ArrayList<Node> kid;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            String s = input.readLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            Node[] node = new Node[n + 1];
            for (int i = 1; i < n + 1; i++) {
                node[i] = new Node();
                node[i].key = i;
                node[i].kid = new ArrayList<Node>();
                node[i].len = new ArrayList<Long>();
            }
            for (int j = 0; j < m; j++) {
                String[] ss = input.readLine().split(" ");
                int a = Integer.parseInt(ss[0]);
                int b = Integer.parseInt(ss[1]);
                long mid = Long.parseLong(ss[2]);
                node[a].kid.add(node[b]);
                node[b].kid.add(node[a]);
                node[b].father++;
                node[a].father++;
                node[a].len.add(mid);
                node[b].len.add(mid);
            }
            String[] sss = input.readLine().split(" ");
            int a1 = Integer.parseInt(sss[0]);
            int a2 = Integer.parseInt(sss[1]);
            long[] l1 = dijk(a1, node, n);
            long[] l2 = dijk(a2, node, n);
            long ans = Long.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                long max = Math.max(l1[i], l2[i]);
                if (max < ans)
                    ans = max;
            }
            System.out.println(ans);
        }
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
                        x.insert(len[a.kid.get(i).key],a.kid.get(i).key);
                    }
                }
            }
        }
        return len;
    }
}

