
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;


public class B {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        go:
        for (int w = 0; w < T; w++) {
            int n = Integer.parseInt(input.readLine());
            String[] v = input.readLine().split(" ");
            int[] value = new int[n + 1];
            int[][] node = new int[n + 1][2];
            int[] father = new int[n + 1];
            boolean tt = false;
            for (int i = 1; i < n + 1; i++) {
                value[i] = Integer.parseInt(v[i - 1]);
            }
            for (int i = 1; i < n; i++) {
                String[] s = input.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                father[b] = a;
                if (value[b] > value[a] && node[a][1] == 0) {
                    node[a][1] = b;
                } else if (node[a][0] == 0 && value[b] < value[a]) {
                    node[a][0] = b;
                } else {
                    tt = true;
                }

            }
            if (tt) {
                out.println("Case #" + (w + 1) + ": NO");
                out.flush();
                continue;
            }
            int x = 0;
            for (int i = 1; i < n + 1; i++) {
                if (father[i] == 0)
                    x = i;
            }
            ArrayList<Integer> a = new ArrayList<>();
            Stack<Integer> put = new Stack<>();
            while (a.size() < n) {
                put.push(x);
                if (node[x][0] != 0) {
                    x = node[x][0];
                    continue;
                }
                while (!put.isEmpty()) {
                    int l = put.pop();
                    a.add(l);
                    if (node[l][1] != 0) {
                        x = node[l][1];
                        break;
                    }
                }
            }
            int size = a.size();
            x = value[a.get(0)];
            int y = 0;
            for (int i = 1; i < size; i++) {
                y = value[a.get(i)];
                if (y < x) {
                    out.println("Case #" + (w + 1) + ": NO");
                    out.flush();
                    continue go;
                } else {
                    x = y;
                }
            }
            out.println("Case #" + (w + 1) + ": YES");
            out.flush();
        }
    }

    public static ArrayList<Integer> inorder(int[][] node, int x, ArrayList<Integer> a) {
        if (node[x][0] != 0)
            inorder(node, node[x][0], a);
        a.add(x);
        if (node[x][1] != 0)
            inorder(node, node[x][1], a);
        return a;
    }
}