import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class F {
    static Reader input;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            ArrayList<long[]> nod1[] = new ArrayList[n + 1];
            long[] len = new long[n + 1];
            int[] fa = new int[n + 1];
            for (int i = 0; i < n + 1; i++)
                nod1[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                long b = input.nextInt();
                long t = input.nextLong();
                long[] xx = new long[2];
                if (a != b) {
                    xx[0] = b;
                    xx[1] = t;
                    nod1[a].add(xx);
                    int c=(int)b;
                    fa[c]++;
                }
            }
            Queue<Integer> x = new LinkedList<>();
            for (int i = 1; i < n + 1; i++) {
                if (fa[i] == 0) {
                    x.add(i);
                }
            }
            long ans = 0;
            while (!x.isEmpty()) {
                int a = x.poll();
                int size = nod1[a].size();
                for (int i = 0; i < size; i++) {
                    long b = nod1[a].get(i)[0];
                    int c = (int) b;
                    fa[c]--;
                }
                for (int i = 0; i < size; i++) {
                    long b = nod1[a].get(i)[0];
                    int c = (int) b;
                    if (fa[c] == 0)
                        x.add(c);
                    long l = nod1[a].get(i)[1];
                    if (len[c] <= l + len[a])
                        len[c] = l + len[a];
                }
            }
            for (int i = 1; i < n + 1; i++) {
                if (len[i] >= ans)
                    ans = len[i];
            }
            System.out.print(ans);
        }
    }
}
