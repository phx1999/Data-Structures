import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        int a = input.nextInt();
        while (a != 0) {
            String c = input.next();
            char[] co = c.toCharArray();
            ArrayList<Character> put = new ArrayList<>();
            ArrayList<Character> wait = new ArrayList<>();
            int num = 0;
            go:
            for (int i = 0; i < c.length(); i++) {
                if (i == 0) {
                    put.add(co[0]);
                    a--;
                    continue go;
                }
                if (wait.size() == 0) {
                    for (int j = 0; j < put.size(); j++) {
                        if (co[i] == put.get(j)) {
                            a++;
                            put.remove(j);
                            continue go;
                        }
                    }
                    if (a > 0) {
                        put.add(co[i]);
                        a--;
                        continue go;
                    }
                    if (a == 0) {
                        wait.add(co[i]);
                        num++;
                    }
                } else {
                    for (int k = 0; k < wait.size(); k++) {
                        if (co[i] == wait.get(k)) {
                            wait.remove(k);
                            continue go;
                        }
                    }
                    for (int j = 0; j < put.size(); j++) {
                        if (co[i] == put.get(j)) {
                            a++;
                            put.remove(j);
                            continue go;
                        }
                    }
                    if (a > 0) {
                        put.add(co[i]);
                        a--;
                        continue go;
                    }
                    if (a == 0) {
                        wait.add(co[i]);
                        num++;
                    }
                }
            }
            out.println(num);
            a=input.nextInt();
            out.flush();
        }
    }
}
