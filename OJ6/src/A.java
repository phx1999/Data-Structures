import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class A {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int node = Integer.parseInt(input.readLine());
            int[] line = new int[node + 1];
            for (int i = 0; i < node - 1; i++) {
                String s=input.readLine();
                int a = Integer.parseInt(s.split(" ")[0]);
                int b = Integer.parseInt(s.split(" ")[1]);
                line[a]++;
                line[b]++;
            }
            for (int i = 2; i < node+1; i++) {
                if (line[i] == 1) {
                    out.print(i+" ");
                    out.flush();
                }
            }
            out.println();
            out.flush();
        }
    }
}
