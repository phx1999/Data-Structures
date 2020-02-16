import java.io.*;
import java.util.*;

public class C {
    static PrintWriter out;
    static Reader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new Reader();
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int s = input.nextInt();
            ArrayList<Integer> nod1[] = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                nod1[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                nod1[a].add(b);
                nod1[b].add(a);
            }
            int[] x = len(s, nod1, n);
            for (int i = 1; i < n + 1; i++) {
                if (x[i] != 0) {
                    out.print(x[i] + " ");
                    out.flush();
                }else {
                    if (i==s){
                        out.print("0 ");
                        out.flush();
                    }else {
                        out.print("-1 ");
                        out.flush();
                    }
                }
            }
            out.println();
            out.flush();
        }
    }

    public static int[] len(int a, ArrayList<Integer> node[], int n) {
        Queue<Integer> x = new LinkedList<>();
        int[] col = new int[n + 1];
        col[a] = 1;
        x.add(a);
        int[] l = new int[n + 1];
        int len = 0;
        while (!x.isEmpty()) {
            len++;
            int size = x.size();
            for (int i = 0; i < size; i++) {
                int b = x.poll();
                int shi = node[b].size();
                for (int j = 0; j < shi; j++) {
                    int c = node[b].get(j);
                    if (col[c] == 0) {
                        col[c] = 1;
                        x.add(c);
                        l[c] = len;
                    }
                }
            }
        }
        return l;
    }
}


