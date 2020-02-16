
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;


public class C {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        go:
        for (int T = Integer.parseInt(input.readLine()); 0 < T; T--) {
            int n = Integer.parseInt(input.readLine().split(" ")[0]);
            String[] v = input.readLine().split(" ");
            int[] value = new int[n + 1];
            int[][] node = new int[n + 1][2];
            int[] father = new int[n + 1];
            boolean tt = false;
            for (int i = 1; i < n + 1; i++) {
                value[i] = Integer.parseInt(v[i - 1]);
            }
            for (int i = 1; i < n + 1; i++) {
                String[] s = input.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                node[i][0] = a;
                node[i][1] = b;
                father[a] = i;
                father[b] = i;
                if (a == 0 && b == 0)
                    continue;
                else if (a == 0) {
                    if (value[b] <= value[i])
                        tt = true;
                } else if (b == 0) {
                    if (value[a] >= value[i])
                        tt = true;
                } else if (value[a] >= value[i] || value[b] <= value[i])
                    tt = true;
            }
            if (tt) {
                out.println("No");
                out.flush();
                continue;
            }
            int x = 0;
            for (int i = 1; i < n + 1; i++) {
                if (father[i] == 0)
                    x = i;
            }
            if (ST(node, x, value, n)) {
                out.println("Yes");
                out.flush();
            } else {
                out.println("No");
                out.flush();
            }
        }
    }

    public static int[] getd(int k, int[][] node) {
        int len = 1;
        int lenmax = 0;
        int lenleft = 0;
        int lenright = 0;
        Stack<Integer> right = new Stack<>();
        Stack<Integer> num = new Stack<>();
        int x = node[k][0];
        int cishu = 2;
        if (node[k][0] == 0) {
            cishu--;
            x = node[k][1];
            lenleft = 1;
        }
        if (node[k][1] == 0) {
            lenright = 1;
            cishu--;
        }
        while (node[x][0] != 0 || node[x][1] != 0 || !right.isEmpty() || cishu > 0) {
            len++;
            if (node[x][1] != 0) {
                right.push(node[x][1]);
                num.push(len);
            }
            if (node[x][0] == 0 && node[x][1] == 0 && right.isEmpty()) {
                if (lenmax < len)
                    lenmax = len;
                if (lenleft == 0)
                    lenleft = lenmax;
                else
                    lenright = lenmax;
                x = node[k][1];
                lenmax=0;
                cishu--;
                len = 1;
            } else if (node[x][0] == 0 && node[x][1] == 0) {
                if (lenmax < len)
                    lenmax = len;
                x = right.pop();
                len = num.pop();
            } else
                x = node[x][0];
        }

        int[] a = new int[2];
        a[0] = lenleft;
        a[1] = lenright;
        return a;
    }

    public static boolean ST(int[][] node, int x, int[] value, int n) {
        ArrayList<Integer> a = new ArrayList<>();
        Stack<Integer> put = new Stack<>();
        while (a.size() < n) {
            put.push(x);
            int zuo = getd(x, node)[0];
            int you = getd(x, node)[1];
            if (zuo - you > 1 || you - zuo > 1)
                return false;
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
            if (y <= x) {
                return false;
            } else {
                x = y;
            }
        }
        return true;
    }
}