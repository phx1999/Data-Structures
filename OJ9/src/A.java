import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;

public class A {
    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int[][] co = new int[n + 1][2];
            for (int i = 1; i < n + 1; i++) {
                co[i][0] = input.nextInt();
                co[i][1] = input.nextInt();
            }
            int q = input.nextInt();
            for (int i = 0; i < q; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                out.println(Math.max(co[x][0], co[y][0]) - Math.min(co[x][0], co[y][0]) + Math.max(co[x][1], co[y][1]) - Math.min(co[x][1], co[y][1]));
                out.flush();
            }
        }
    }
}

