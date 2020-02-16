import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class E {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            String a = input.readLine();
            int n = Integer.parseInt(a.split(" ")[0]);
            int m = Integer.parseInt(a.split(" ")[1]);
            String t = input.readLine();
            String t2 = input.readLine();
            String s = t + t2;
            char[] cha = s.toCharArray();
            int[] next = getnext(cha);
            int b = next[next.length - 1];
            while (b>n||b>m){
                b=next[b];
            }
            String an = t.substring(0, b);
            out.println(b + " " + an);
            out.flush();
        }
    }


    public static int[] getnext(char[] t) {
        int[] next = new int[t.length + 1];
        next[0] = -1;
        if (t.length > 1)
            next[1] = 0;
        int k;
        for (int j = 2; j <= t.length; j++) {
            k = next[j - 1];
            while (k != -1) {
                if (t[j - 1] == t[k]) {
                    next[j] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;
            }
        }
        return next;
    }

}