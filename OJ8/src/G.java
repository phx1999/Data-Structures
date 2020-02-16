import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class G {
    static Reader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new Reader();
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] fa = new int[n + 1];
            ArrayList<Integer> nod1[] = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++)
                nod1[i] = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                nod1[b].add(a);
                fa[a] = b;
            }
            int[] col = new int[n + 1];
            int[][] shu = new int[n + 1][2];
            Stack<Integer> x = new Stack<>();
            for (int i = 1; i < n + 1; i++) {
                if (fa[i] == 0) {
                    x.add(i);
                    shu[i][0] = 1;
                }
            }
            int num = 1;
            go:
            while (!x.isEmpty()) {
                int a = x.peek();
                int size = nod1[a].size();
                for (int i = 0; i < size; i++) {
                    if (col[nod1[a].get(i)] == 0) {
                        col[nod1[a].get(i)] = 1;
                        x.add(nod1[a].get(i));
                        shu[nod1[a].get(i)][0] = ++num;
                        continue go;
                    }
                }
                int c = x.pop();
                shu[c][1] = ++num;
            }
            for (int i = 0; i < m; i++) {
                int a = input.nextInt();
                int b = input.nextInt();
                if (a == b) {
                    out.println("Yes");
                    out.flush();
                } else if (shu[b][0] < shu[a][0] && shu[b][1] > shu[a][1]) {
                    out.println("Yes");
                    out.flush();
                }else {
                    out.println("No");
                    out.flush();
                }
            }
        }
    }
}

class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}