
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class B {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            String num = input.readLine();
            int n = Integer.parseInt(num.split(" ")[0]);
            int m = Integer.parseInt(num.split(" ")[1]);
            String s = input.readLine();
            String t = input.readLine();
            if (s.contains("*")) {
                if (s.length()==1){
                    out.println("YES");
                    out.flush();
                    continue;
                }
                int po = s.indexOf("*");
                String s1 = s.substring(0, po);
                String s2 = s.substring(po + 1);
                if (s1.length()==0){
                    if (find(t, s2) >= 0) {
                        out.println("YES");
                        out.flush();
                    } else {
                        out.println("NO");
                        out.flush();
                    }
                    continue;
                }
                if (s2.length()==0){
                    if (find(t, s1) >= 0) {
                        out.println("YES");
                        out.flush();
                    } else {
                        out.println("NO");
                        out.flush();
                    }
                    continue;
                }
                int a = find(t, s1);
                if (a == -1) {
                    out.println("NO");
                    out.flush();
                    continue;
                }
                int b = -1;
                if (a >= 0) {
                    String s3 = t.substring(a + s1.length());
                    b = find(s3, s2);
                }
                if (b >= 0) {
                    out.println("YES");
                    out.flush();

                } else {
                    out.println("NO");
                    out.flush();
                }
            } else {
                if (find(t, s) >= 0) {
                    out.println("YES");
                    out.flush();
                } else {
                    out.println("NO");
                    out.flush();
                }
            }
        }
    }
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
