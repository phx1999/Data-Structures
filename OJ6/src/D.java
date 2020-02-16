import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

public class D {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            ArrayList<Integer> node[] = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                node[i] = new ArrayList<>();
            int[] father = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                String s = input.readLine();
                int a = Integer.parseInt(s.split(" ")[0]);
                int b = Integer.parseInt(s.split(" ")[1]);
                if (father[b] != 0) {
                    node[b].add(a);
                    father[a] = b;
                } else {
                    node[a].add(b);
                    father[b] = a;
                }
            }
            int x = 0;
            for (int i = 1; i < node.length; i++) {
                if (father[i] == 0) {
                    x = i;
                    break;
                }
            }
            int len = 0;
            int dis = 0;
            int ans = 0;
            Stack<Integer> kids = new Stack<>();
            Stack<Integer> num = new Stack<>();
            boolean t = true;
            while (!node[x].isEmpty() || kids.size() != 0) {
                len++;
                if (node[x].size() > 1) {
                    t = false;
                    int a = getd(x, node)[0] + getd(x, node)[1] - 2;
                    int b = getd(x, node)[1] + len - 2;
                    int c = getd(x, node)[0] + len - 2;
                    dis = Math.max(a, b);
                    dis = Math.max(dis, c);
                    ans = Math.max(dis, ans);
                    for (int i = 1; i < node[x].size(); i++) {
                        kids.push(node[x].get(i));
                        num.push(len);
                    }
                }
                if (node[x].isEmpty()) {
                    x = kids.pop();
                    len = num.pop();
                } else
                    x = node[x].get(0);
            }
            if (t)
                ans = len++;
            out.println(ans);
            out.flush();
        }
    }

    public static int[] getd(int x, ArrayList<Integer> node[]) {
        int len = 0;
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        Stack<Integer> kids = new Stack<>();
        Stack<Integer> road = new Stack<>();
        Stack<Integer> num = new Stack<>();
        boolean b = true;
        while (!node[x].isEmpty() || !kids.isEmpty() || !road.isEmpty()) {
            len++;
            if (node[x].size() > 1 && b) {
                for (int i = 1; i < node[x].size(); i++) {
                    road.push(node[x].get(i));
                    num.push(len);
                }
                b = false;
            } else if (node[x].size() > 1) {
                for (int i = 1; i < node[x].size(); i++) {
                    kids.push(node[x].get(i));
                    num.push(len);
                }
            }
            if (node[x].isEmpty() && kids.isEmpty()) {
                if (len1 < len)
                    len1 = len;
                if (len1 > len3) {
                    len2 = len3;
                    len3 = len1;
                } else if (len2 < len1)
                    len2 = len1;
                len1 = 0;
                x = road.pop();
                len = num.pop();
            } else if (node[x].isEmpty()) {
                if (len1 < len)
                    len1 = len;
                x = kids.pop();
                len = num.pop();
            } else
                x = node[x].get(0);
        }
        len++;
        if (len1 < len)
            len1 = len;
        if (len1 > len3) {
            len2 = len3;
            len3 = len1;
        } else if (len2 < len1)
            len2 = len1;
        int[] a = new int[2];
        a[0] = len2;
        a[1] = len3;
        return a;
    }
}