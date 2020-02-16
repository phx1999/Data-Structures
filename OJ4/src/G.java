import java.io.*;
import java.util.Stack;

public class G {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            Stack<Integer> min = new Stack<>();
            Stack<Integer> put = new Stack<>();
            Stack<Integer> max = new Stack<>();
            for (int i = 0; i < n; i++) {
                String s = input.readLine();
                if (s.equals("pop")) {
                    if (put.size() <= 1) {
                        out.println(0);
                        out.flush();
                        if (put.size() == 1) {
                            min.pop();
                            max.pop();
                            put.pop();
                        }
                        continue;
                    }
                    if (min.peek().equals(put.peek())) {
                        min.pop();
                    }
                    if (max.peek().equals(put.peek())) {
                        max.pop();
                    }
                    put.pop();
                    out.println(max.peek() - min.peek());
                    out.flush();
                } else {
                    int num = Integer.parseInt(s.split(" ")[1]);
                    put.push(num);
                    if (min.empty() || num <= min.peek()) {
                        min.push(num);
                    }
                    if (max.empty() || num >= max.peek()) {
                        max.push(num);
                    }
                }
            }
        }
    }
}


