import java.io.*;
import java.util.*;

public class G {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            Comparator<Integer> cmp1;
            cmp1 = new Comparator<Integer>() {
                public int compare(Integer e1, Integer e2) {
                    return e1 - e2;
                }
            };
            Queue<Integer> q2 = new PriorityQueue<Integer>(n, cmp1);
            Comparator<Integer> cmp2;
            cmp2 = new Comparator<Integer>() {
                public int compare(Integer e1, Integer e2) {
                    return e2 - e1;
                }
            };
            Queue<Integer> q1 = new PriorityQueue<Integer>(n, cmp2);
            for (int i = 0; i < n / 2 + 1; i++) {
                if (i == 0) {
                    q1.add(input.nextInt());
                    out.print(q1.peek() + " ");
                    out.flush();
                    continue;
                }
                 else {
                    int b = input.nextInt();
                    int c = input.nextInt();
                    int d;
                    if (b>c){
                        d=b;
                        b=c;
                        c=d;
                    }
                    if (b > q1.peek() && q1.peek() < c) {
                        q2.add(b);
                        q2.add(c);
                        q1.add(q2.poll());
                        out.print(q1.peek() + " ");
                        out.flush();
                        continue;
                    } else if (c < q1.peek() && q1.peek() > b) {
                        q1.add(c);
                        q1.add(b);
                        q2.add(q1.poll());
                        out.print(q1.peek() + " ");
                        out.flush();
                        continue;
                    } else {
                        q1.add(b);
                        q2.add(c);
                        out.print(q1.peek() + " ");
                        out.flush();
                        continue;
                    }
                }
            }
            out.print("\n");
            out.flush();
        }
    }
}

