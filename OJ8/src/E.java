import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class E {
    static PrintWriter out;
    static Reader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new Reader();
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] node = new int[n + 2][m + 2];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    node[i][j] = input.nextInt();
                }
            }
            Queue<Integer> row = new LinkedList<>();
            Queue<Integer> clo = new LinkedList<>();
            int ans = 0;
            int[][] col = new int[n + 2][m + 2];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (col[i][j] == 0) {
                        int num = node[i][j];
                        ans++;
                        row.add(i);
                        clo.add(j);
                        col[i][j] = 1;
                        while (!row.isEmpty()) {
                            int x = row.poll();
                            int y = clo.poll();
                            if (y == 1) {
                                if (node[x][m] == num && col[x][m] == 0) {
                                    col[x][m] = 1;
                                    row.add(x);
                                    clo.add(m);
                                }
                                if (node[x + 1][y] == num && col[x + 1][y] == 0) {
                                    col[x + 1][y] = 1;
                                    row.add(x + 1);
                                    clo.add(y);
                                }
                                if (node[x - 1][y] == num && col[x - 1][y] == 0) {
                                    col[x - 1][y] = 1;
                                    row.add(x - 1);
                                    clo.add(y);
                                }
                                if (node[x][y + 1] == num && col[x][y + 1] == 0) {
                                    col[x][y + 1] = 1;
                                    row.add(x);
                                    clo.add(y + 1);
                                }
                            } else if (y == m) {
                                if (node[x][y - 1] == num && col[x][y - 1] == 0) {
                                    col[x][y - 1] = 1;
                                    row.add(x);
                                    clo.add(y - 1);
                                }
                                if (node[x + 1][y] == num && col[x + 1][y] == 0) {
                                    col[x + 1][y] = 1;
                                    row.add(x + 1);
                                    clo.add(y);
                                }
                                if (node[x - 1][y] == num && col[x - 1][y] == 0) {
                                    col[x - 1][y] = 1;
                                    row.add(x - 1);
                                    clo.add(y);
                                }
                                if (node[x][1] == num && col[x][1] == 0) {
                                    col[x][1] = 1;
                                    row.add(x);
                                    clo.add(1);
                                }
                            } else {
                                if (node[x][y - 1] == num && col[x][y - 1] == 0) {
                                    col[x][y - 1] = 1;
                                    row.add(x);
                                    clo.add(y - 1);
                                }
                                if (node[x + 1][y] == num && col[x + 1][y] == 0) {
                                    col[x + 1][y] = 1;
                                    row.add(x + 1);
                                    clo.add(y);
                                }
                                if (node[x - 1][y] == num && col[x - 1][y] == 0) {
                                    col[x - 1][y] = 1;
                                    row.add(x - 1);
                                    clo.add(y);
                                }
                                if (node[x][y + 1] == num && col[x][y + 1] == 0) {
                                    col[x][y + 1] = 1;
                                    row.add(x);
                                    clo.add(y + 1);
                                }
                            }
                        }
                    }
                }
            }
            out.println(ans);
            out.flush();
        }
    }
}

