
import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class B {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            ArrayList<Integer> nod1[] = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                nod1[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                nod1[a].add(b);
            }
            int Q = input.nextInt();
            for (int i = 0; i < Q; i++) {
                ArrayList<Integer> node[] = new ArrayList[n + 1];
                for (int k = 0; k < n + 1; k++) {
                    node[k] = new ArrayList<>();
                    node[k].addAll(nod1[k]);
                }
                if (reach(input.nextInt(), input.nextInt(), node)) {
                    out.println("YES");
                    out.flush();
                } else {
                    out.println("NO");
                    out.flush();
                }
            }
        }
    }

    public static boolean reach(int a, int b, ArrayList<Integer> node[]) {
        Stack<Integer> x = new Stack<>();
        while (node[a].size() != 0 || !x.isEmpty()) {
            int size = node[a].size();
            if (size > 1) {
                for (int i = 1; i < size; i++) {
                    int shu = node[a].get(i);
                    if (shu == b)
                        return true;
                    else
                        x.push(shu);
                }
            }
            if (size > 0) {
                if (node[a].get(0) == b)
                    return true;
                else {
                    int ll = node[a].get(0);
                    node[a].clear();
                    a=ll;
                }
            } else {
                a = x.pop();
            }
        }
        return false;
    }
}


