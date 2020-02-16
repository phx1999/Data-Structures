import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            String s1 = input.readLine();
            int n = Integer.parseInt(s1.split(" ")[0]);
            int k = Integer.parseInt(s1.split(" ")[1]);
            String[] s = input.readLine().split(" ");
            if (k <= 5000) {
                SHeap x = new SHeap();
                for (int i = 0; i < n; i++)
                    x.insert(Integer.parseInt(s[i]));
                out.println(x.getmin());
                out.flush();
            } else {
                BHeap x = new BHeap(n - k + 1);
                for (int i = 0; i < n; i++)
                    x.insert(Integer.parseInt(s[i]));
                out.println(x.getmax());
                out.flush();
            }
        }
    }
}


class BHeap {
    int x[];
    int num = 0;
    int len = 0;

    public BHeap(int k) {
        int[] x = new int[10000000];
        this.x = x;
        this.len = k;
    }

    public void insert(int i) {
        if (num < len) {
            x[++num] = i;
            swim(num);
        }else {
            if (i<x[1]){
                delet();
                insert(i);
            }
        }
    }

    public int getmax() {
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
        if (x[i] < x[j]) {
            return true;
        } else
            return false;
    }
}