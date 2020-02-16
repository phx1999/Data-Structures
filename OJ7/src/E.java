import java.io.*;
import java.util.StringTokenizer;

public class E {
    static PrintWriter out;
    static InputReader input;
    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int k = input.nextInt();
            SHeap x = new SHeap();
            for (int i = 0; i < k; i++) {
                x.insert(input.nextInt());
            }
            for (int i = k; i < n; i++) {
                int a = input.nextInt();
                if (a > x.getmin()) {
                    out.print(x.getmin() + " ");
                    out.flush();
                    x.delet();
                    x.insert(a);
                } else {
                    out.print(a + " ");
                    out.flush();
                }
            }
            while (x.getmin() != 0) {
                out.print(x.getmin() + " ");
                x.delet();
                out.flush();
            }
            out.println();
            out.flush();
        }
    }
}

class SHeap {
    int x[];
    int num = 0;

    public SHeap() {
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

class InputReader {
    public BufferedReader br;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(stream), 327680);
        tokenizer = null;
    }

    public boolean hasNext() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        try {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            int x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        } catch (IOException e) {
            return -1;
        }
    }

    public long nextLong() {
        try {
            int c = br.read();
            while (c <= 32) {
                c = br.read();
            }
            boolean negative = false;
            if (c == '-') {
                negative = true;
                c = br.read();
            }
            long x = 0;
            while (c > 32) {
                x = x * 10 + c - '0';
                c = br.read();
            }
            return negative ? -x : x;
        } catch (IOException e) {
            return -1;
        }
    }

}