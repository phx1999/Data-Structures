import java.io.*;
import java.util.*;

public class C {
    static PrintWriter out;
    static InputReader input;

    public static long A(int up, int bellow) {
        long result = 1;
        for (int i = up; i > 0; i--) {
            result *= bellow;
            bellow--;
        }
        return result;
    }

    public static long C(int up, int below) {
        int helf = below / 2;
        if (up > helf) {
            up = below - up;
        }
        long denominator = A(up, up);
        long numerator = A(up, below);
        return numerator / denominator;
    }

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            if (n == 1) {
                input.nextInt();
                out.println(0);
                out.flush();
                continue;
            }
            if (n == 2) {
                input.nextInt();
                input.nextInt();
                out.println(0);
                out.flush();
                continue;
            }
            long ans = 0;
            int fuck=0;
            int shit=0;
            Queue<Integer> qq = new LinkedList<>();
            qq.offer(input.nextInt());
            qq.offer(input.nextInt());
            go:
            for (int i = 2; i < n; i++) {
                int a = input.nextInt();
                if (i == n - 1) {
                    if (a - qq.peek() <= m) {
                        qq.add(a);
                        ans += C(3, qq.size());
                        if (shit-fuck>=2){
                            ans-=C(3, shit-fuck+1);
                        }
                        break;
                    }
                }
                if (a - qq.peek() <= m) {
                    qq.add(a);
                } else if (qq.size() == 2) {
                    qq.remove();
                    fuck++;
                    qq.add(a);
                } else {
                    ans += C(3, qq.size());
                    if (shit-fuck>=2){
                        ans-=C(3, shit-fuck+1);
                    }
                    qq.remove();
                    fuck++;
                    shit=i-1;
                    while (qq.size() >= 2) {
                        if (a - qq.peek() <= m) {
                            qq.add(a);
                            if (i == n - 1) {
                                ans += C(3, qq.size());
                                if (shit-fuck>=2){
                                    ans-=C(3, shit-fuck+1);
                                }
                            }
                            continue go;
                        } else {
                            qq.remove();
                            fuck++;
                        }
                    }
                    qq.add(a);
                }
            }
            out.println(ans);
            out.flush();
        }
    }
}
