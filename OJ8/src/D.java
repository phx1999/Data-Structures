import java.io.*;
import java.util.StringTokenizer;

public class D {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int m = input.nextInt();
            int [][]node =new int[n+1][n+1];
            for (int i=0;i<m;i++){
                int x = input.nextInt();
                int y = input.nextInt();
                node[x][y]=1;
                node[y][x]=1;
                node[x][x]=1;
                node[y][y]=1;
            }
            int ans=0;
            for (int i=1;i<n-2;i++){
                for (int j=i+1;j<n-1;j++){
                    for (int k=j+1;k<n;k++){
                        for (int w=k+1;w<n+1;w++){
                            if (node[i][j]==1&&node[i][k]==1&&node[i][w]==1&&node[j][k]==1&&node[j][w]==1&&node[k][w]==1)
                                ans++;
                        }
                    }
                }
            }
            out.println(ans);
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
