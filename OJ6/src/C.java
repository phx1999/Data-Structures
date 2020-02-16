import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            Heap x = new Heap();
            String s = input.readLine();
            String [] a=s.split(" ");
            for (int i = 0; i < n; i++)
                x.insert(Integer.parseInt(a[i]));
            int m = Integer.parseInt(input.readLine());
            for (int i = 0; i < m; i++) {
                String op = input.readLine();
                if (Integer.parseInt(op.split(" ")[0]) == 2)
                    x.delet();
                else if (Integer.parseInt(op.split(" ")[0]) == 3) {
                    out.println(x.getmin());
                    out.flush();
                } else
                    x.insert(Integer.parseInt(op.split(" ")[1]));
            }
        }
    }
}

class Heap {
    int x[];
    int num = 0;

    public Heap() {
        int[] x = new int[10000000];
        this.x = x;
    }

    public void insert(int i) {
        x[++num] = i;
        swim(num);
    }

    public int getmin() {
        return x[1];
    }

    public void delet() {
        exch(1, num--);
        x[num + 1] = 0;
        sink(1);
    }

    private void swim(int k) {
        while (k > 1 && compare(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= num) {
            int j = 2 * k;
            if (j < num && compare(j, j + 1))
                j++;
            if (!compare(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    private boolean compare(int i, int j) {
        if (x[i] > x[j]) {
            return true;
        } else
            return false;
    }
}