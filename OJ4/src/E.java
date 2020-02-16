import java.beans.IntrospectionException;
import java.io.*;
import java.util.*;

public class E {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int[] shu = new int[n];
            ArrayList<Integer> min = new ArrayList<>();
            ArrayList<Integer> po = new ArrayList<>();
            Stack<Integer> num = new Stack<>();
            for (int i = 0; i < n; i++) {
                shu[i] = input.nextInt();
            }
            for (int i = n - 1; i >= 0; i--) {
                if (i == n - 1) {
                    min.add(shu[i]);
                    po.add(i);
                    continue;
                } else if (shu[i] < min.get(min.size() - 1)) {
                    min.add(shu[i]);
                    po.add(i);
                }
            }
            int msi = min.size();
            int s = 0;
            for (int j = msi - 1; j >= 0; j--) {
                for (int i = s; i <= po.get(j); i++) {
                    num.push(shu[i]);
                }
                out.print(num.pop() + " ");
                out.flush();
                while (num.size() > 0 &&j-1>=0 &&num.peek() < min.get(j-1)) {
                    out.print(num.pop() + " ");
                    out.flush();
                }
                if (j > 0) {
                    s = po.get(j) + 1;
                }
            }
            while (num.size() > 0 ){
                out.print(num.pop() + " ");
                out.flush();
            }
            out.println();
            out.flush();
        }
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
