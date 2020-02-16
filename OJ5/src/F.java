import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;

public class F {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        nex:
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            String[] s = new String[n];
            s[0] = input.readLine();
            int len = s[0].length();
            int k = 0;
            for (int i = 1; i < n; i++) {
                s[i] = input.readLine();
                if (s[i].length() < len) {
                    k = i;
                    len = s[i].length();
                }
            }
            String p = s[0];
            s[0] = s[k];
            s[k] = p;
            int ansl = 0;
            ArrayList<String> ans=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                go:
                for (int j = len; j > i; j--) {
                    String t = s[0].substring(i, j);
                    char [] c=t.toCharArray();
                    int [] next=getnext(c);
                    for (int l = 1; l < n; l++) {
                        if (find(s[l], c,next) < 0)
                            continue go;
                    }
                    if (t.length() > ansl) {
                        ansl=t.length();
                        ans.clear();
                        ans.add(t);
                    } else if (t.length()==ansl){
                        ans.add(t);
                    }
                }
            }
            if (!ans.isEmpty()) {
                Collections.sort(ans);
                out.println(ans.get(0));
                out.flush();
            } else {
                out.println("Hong");
                out.flush();
            }
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

    public static int find(String s, char [] ta ,int [] next) {
        char[] sa = s.toCharArray();
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