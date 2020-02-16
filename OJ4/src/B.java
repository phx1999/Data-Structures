import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        go:
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            char[] s = input.next().toCharArray();
            if (n % 2 == 1) {
                out.println("NO");
                out.flush();
                continue;
            }
            Stack<Character> cha = new Stack<>();
            if (s[0] == ')' || s[0] == ']' || s[0] == '}') {
                out.println("NO");
                out.flush();
                continue;
            } else {
                cha.push(s[0]);
            }
            for (int i = 1; i < n; i++) {
                if (cha.empty() && (s[i] == ')' || s[i] == ']' || s[i] == '}')) {
                    out.println("NO");
                    out.flush();
                    continue go;
                } else if (s[i] == ')') {
                    s[i] = '(';
                    if (s[i] == cha.peek()) {
                        cha.remove(cha.size() - 1);
                    } else {
                        out.println("NO");
                        out.flush();
                        continue go;
                    }
                } else if (s[i] == ']') {
                    s[i] = '[';
                    if (s[i] == cha.peek()) {
                        cha.remove(cha.size() - 1);
                    } else {
                        out.println("NO");
                        out.flush();
                        continue go;
                    }
                } else if (s[i] == '}') {
                    s[i] = '{';
                    if (s[i] == cha.peek()) {
                        cha.remove(cha.size() - 1);
                    } else {
                        out.println("NO");
                        out.flush();
                        continue go;
                    }
                } else if (cha.empty()) {
                    cha.push(s[i]);
                } else {
                    cha.push(s[i]);
                }
            }
            if (cha.size() == 0) {
                out.println("YES");
                out.flush();
            } else {
                out.println("NO");
                out.flush();
            }
        }
    }
}

