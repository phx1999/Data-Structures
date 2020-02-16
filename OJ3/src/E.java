import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class E {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            if (n == 1) {
                out.println("Yes");
                out.flush();
                continue;
            }
            int m = input.nextInt();
            int e = input.nextInt();
            LinkedList<Integer> ple = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                ple.add(i);
            }
            int x = n;
            for (int i = 0; i < n; i++) {
                int shan = (m + 1) % x;
                if (shan == 0) {
                    shan = x;
                }
                if (ple.get(shan - 1) == e) {
                    out.println("No");
                    out.flush();
                    break;
                }
                ple.remove(shan - 1);
                x--;
                if (x == 1) {
                    out.println("Yes");
                    out.flush();
                    break;
                }
                if (shan - 1 != 0) {
                    for (int j = x - 1; j > shan - 2; j--) {
                        ple.addFirst(ple.get(x-1));
                        ple.remove(x);
                    }
                }
            }
        }
    }
}

