import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        go:
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            String s = input.readLine();
            char[] cha = s.toCharArray();
            int[] next = getnext(cha);
            int a = next[n];
            while (a > 0) {
                while (a > n / 3)
                    a = next[a];
                String pa = s.substring(0, a);
                String s2 = s.substring(a, n - a);
                int b=find(s2,pa);
                if (b >= 0) {
                    out.println(a);
                    out.flush();
                    continue go;
                }
                a=next[a];
            }
            out.println(0);
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

    public static int find(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int[] next = getnext(ta);
        int i = 0;
        int j = 0;
        while (i < sa.length && j < ta.length) {
            if (j == -1 || sa[i] == ta[j]) {
                i++;
                j++;
            } else
                j = next[j];
        }
        if (j == ta.length)
            return i - j;
        else
            return -1;
    }
}