import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class K {
    static InputReader input;
    static PrintWriter out;

    public static void main(String args[]) throws IOException {
        input = new InputReader(System.in);
        out = new PrintWriter(System.out);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int[] station = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                station[i] = input.nextInt();
            }
            int[] col = new int[n + 1];
            PriorityQueue<Integer> huan = new PriorityQueue<Integer>(new Comparator<Integer>(){
                @Override
                public int compare(Integer i1,Integer i2){
                    return i2-i1;
                }
            });
            for (int i = 1; i < n + 1; i++) {
                if (col[i] == 0) {
                    int a = i;
                    col[a] = 1;
                    int num=1;
                    while (col[station[a]]==0) {
                            a=station[a];
                           col[a] = 1;
                            num++;
                    }
                    huan.add(num);
                }
            }
            if (huan.size()==0){
                out.println(0);
                out.flush();
            }else if (huan.size()==1){
                int ans=huan.poll();
                out.println(ans*ans);
                out.flush();
            }else {
                int a=huan.poll()+huan.poll();
                a=a*a;
                while (!huan.isEmpty()){
                    int b=huan.poll();
                    a+=b*b;
                }
                out.println(a);
                out.flush();
            }
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
