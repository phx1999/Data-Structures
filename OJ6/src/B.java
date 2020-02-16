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
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            int[][] node = new int[n + 1][2];
            int[] father = new int[n + 1];
            for (int i = 0; i < n - 1; i++) {
                String s = input.readLine();
                int a = Integer.parseInt(s.split(" ")[0]);
                int b = Integer.parseInt(s.split(" ")[1]);
                if (node[a][0] == 0) {
                    node[a][0] = b;
                    father[b] = a;
                    continue;
                }
                node[a][1] = b;
                father[b] = a;
            }
            int a = 1;
            for (int i=1;i<n+1;i++){
                if (father[i]==0){
                    a=i;
                    break;
                }
            }
            int x=a;
            Stack<Integer> right = new Stack<>();
            while (node[x][0] != 0 || right.size() != 0) {
                if (node[x][1] != 0)
                    right.push(node[x][1]);
                out.print(x + " ");
                out.flush();
                if (node[x][0] != 0) {
                    x = node[x][0];
                    continue;
                }
                x = right.pop();
            }
            out.print(x + " ");
            out.flush();
            out.println();
            out.flush();


            Stack<Integer> left = new Stack<>();
            x = a;
            while (node[x][0] != 0 || right.size() != 0 || left.size() != 0) {
                if (node[x][1] != 0)
                    right.push(node[x][1]);
                left.push(x);
                if (node[x][0] != 0) {
                    x = node[x][0];
                    continue;
                }
                while (left.size() != 0) {
                    out.print(left.pop() + " ");
                    out.flush();
                }
                if (right.size() != 0)
                    x = right.pop();
            }
            out.println();
            out.flush();


            Stack<Integer> root = new Stack<>();
            x = a;
            while (node[x][0] != 0 || right.size() != 0 || left.size() != 0) {
                if (node[x][1] != 0) {
                    right.push(node[x][1]);
                    root.push(x);
                    left.push(0);
                    x = node[x][0];
                    continue;
                }
                left.push(x);
                if (node[x][0] != 0) {
                    x = node[x][0];
                    continue;
                }
                while (left.size() != 0 && left.peek() != 0) {
                    out.print(left.pop() + " ");
                    out.flush();
                }
                if (left.size() != 0)
                    left.pop();
                if (right.size()==0) {
                    out.print(root.pop() + " ");
                    out.flush();
                }
                if (right.size() != 0)
                    x = right.pop();
            }
            while (root.size() != 0) {
                out.print(root.pop() + " ");
                out.flush();
            }
            out.println();
            out.flush();
        }
    }
}