import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
    public static int[] getnext(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        if (t.length > 1)
            next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
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
        char[] tm = new char[ta.length + 1];
        for (int i = 0; i < ta.length; i++) {
            tm[i] = ta[i];
        }
        tm[ta.length] = 1;
        int[] next = getnext(tm);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < sa.length && j < ta.length) {
            if (j == -1 || sa[i] == ta[j]) {
                i++;
                j++;
                if (j == ta.length) {
                    ans++;
                    i = i - next[ta.length];
                    j = 0;
                }
            } else
                j = next[j];
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            String s = input.readLine();
            int m = Integer.parseInt(input.readLine());
            String t = input.readLine();
            out.println(find(s, t));
            out.flush();
        }
    }
}