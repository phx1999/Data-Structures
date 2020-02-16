
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int t = input.nextInt(); t > 0; t--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = input.nextInt();
            }
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = input.nextInt();
            }
            int ns = 0;
            int ms = 0;

            for (int j = 0; j < m + n; j++) {
                if (ns < n && ms < m) {
                    if (a[ns] > b[ms]) {
                        out.print( b[ms]+" ");
                        ms++;
                        continue;
                    } else {
                        out.print( a[ns]+" ");
                        ns++;
                        continue;
                    }
                } else if (ns == n) {
                    out.print( b[ms]+" ");
                    ms++;
                    continue;
                } else {
                    out.print( a[ns]+" ");
                    ns++;
                }
            }
            out.print("\n");
            out.flush();
        }
    }
}

