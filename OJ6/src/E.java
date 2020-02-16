import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class E {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            int m = Integer.parseInt(input.readLine());

        }
    }
}

class heap {
    int x[];
    int num = 0;

    public heap(int n) {
        int[] x = new int[n + 1];
        this.x = x;
    }

    public void add(int a) {
        x[++num] = a;
        swim(num);
    }

    public void swim(int a) {
        if (x[a] > x[a / 2] && a % 2 == 0) {
            int b = x[a];
            x[a] = x[a / 2];
            x[a / 2] = b;
            swim(a / 2);
        } else if (x[a] < x[a / 2] && a % 2 == 1) {
            int b = x[a];
            x[a] = x[a / 2];
            x[a / 2] = b;
            swim(a / 2);
        }else
            sink(a);
    }

    public void sink(int a) {
        if (x[a] < x[2 * a]) {
            int b = x[a];
            x[a] = x[a * 2];
            x[a * 2] = b;
            sink(a * 2);
        } else if (x[a] > x[2 * a + 1]) {
            int b = x[a];
            x[a] = x[2 * a + 1];
            x[2 * a + 1] = b;
            sink(2 * a + 1);
        }else
            sink(a);
    }

    public int meet(int a) {
        int start = 1;
        boolean b = true;
        while (start <= num) {
            if (a > start)
                start = 2 * start + 1;
            else if (a < start)
                start = 2 * start;
            else {
                b=false;
                break;
            }
        }
        if (b)
            return 0;
        else
            return start;
    }
    public void change(int a,int b){
        x[a]=b;
        sink(a);
    }
}