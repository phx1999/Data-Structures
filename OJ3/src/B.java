
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int n = input.nextInt();
            int[] nc = new int[n];
            int[] ne = new int[n];
            for (int j = 0; j < n; j++) {
                nc[j] = input.nextInt();
                ne[j] = input.nextInt();
            }
            int m = input.nextInt();
            int[] mc = new int[n];
            int[] me = new int[n];
            for (int j = 0; j < m; j++) {
                mc[j] = input.nextInt();
                me[j] = input.nextInt();
            }
            int ns = 0;
            int ms = 0;
            int num = 0;
            int co = 0;
            int eo = 0;
            boolean a=false;
            while (ms < m || ns < n) {
                if (ns < n && ms < m) {
                    if (ne[ns] < me[ms]) {
                        co = nc[ns];
                        eo = ne[ns];
                        ns++;
                    } else if (ne[ns] == me[ms]) {
                        co = nc[ns] + mc[ms];
                        eo = ne[ns];
                        ns++;
                        ms++;
                    } else {
                        co = mc[ms];
                        eo = me[ms];
                        ms++;
                    }
                } else if (ns == n) {
                    co = mc[ms];
                    eo = me[ms];
                    ms++;
                } else {
                    co = nc[ns];
                    eo = ne[ns];
                    ns++;
                }
                if (co==0){
                    continue;
                }
                if (num == 0 || co < 0) {
                    if (eo == 0) {
                        out.print(String.format("%d", co));
                        a=true;
                        num = 1;
                    } else if (eo == 1 && co != 1 && co != -1) {
                        out.print(String.format("%dx", co));
                        a=true;
                        num = 1;
                    } else if (eo == 1 && co == 1) {
                        out.print("x");
                        a=true;
                        num = 1;
                    } else if (eo == 1 && co == -1) {
                        out.print("-x");
                        a=true;
                        num = 1;
                    } else if (eo != 1 && co == 1) {
                        out.print(String.format("x^%d", eo));
                        a=true;
                        num = 1;
                    }else if (eo != 1 && co == -1) {
                        out.print(String.format("-x^%d", eo));
                        a=true;
                        num = 1;
                    } else {
                        out.print(String.format("%dx^%d", co, eo));
                        a=true;
                        num = 1;
                    }
                } else if (num != 0 && co!=0) {
                    if (eo == 0) {
                        out.print(String.format("+%d", co));
                        a=true;
                    } else if (eo == 1 && co != 1) {
                        out.print(String.format("+%dx", co));
                        a=true;
                    } else if (eo == 1 && co == 1) {
                        out.print("+x");
                        a=true;
                    } else if (eo != 1 && co == 1) {
                        out.print(String.format("+x^%d", eo));
                        a=true;
                    } else {
                        out.print(String.format("+%dx^%d", co, eo));
                        a=true;
                    }
                }
            }
            if (a==false){
                out.print("0");
            }
            out.print("\n");
            out.flush();
        }
    }
}

