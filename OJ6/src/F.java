import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class F {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        go:
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            ArrayList<Integer> node[] = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                node[i] = new ArrayList<>();
            int[] father = new int[n + 1];
            String shit = input.readLine();
            String[] fuck = shit.split(" ");
            int[] hb = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if (fuck[i - 1].length() > 0)
                    hb[i] = Integer.parseInt(fuck[i - 1]);
            }
            if (n == 1 && hb[1] == 1) {
                out.println("YES");
                out.flush();
                continue go;
            } else if (n == 1 && hb[1] == 0) {
                out.println("NO");
                out.flush();
                continue go;
            }
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
            if (hb[x] == 1) {
                out.println("YES");
                out.flush();
                continue;
            }
            Queue<Integer> tong = new LinkedList<>();
            tong.add(x);
            int num = 0;
            while (!tong.isEmpty()) {
                int size = tong.size();
                for (int i = 0; i < size; i++) {
                    tong.addAll(node[tong.peek()]);
                    num += geshu(tong.poll(), node, hb);
                }
                if (num % 2 == 1) {
                    out.println("YES");
                    out.flush();
                    continue go;
                }
                num = 0;
            }
            out.println("NO");
            out.flush();
        }
    }

    public static int geshu(int x, ArrayList<Integer> node[], int[] hb) {
        int num = 0;
        for (int i = 0; i < node[x].size(); i++) {
            if (hb[node[x].get(i)] == 1)
                num++;
        }
        return num;
    }
}