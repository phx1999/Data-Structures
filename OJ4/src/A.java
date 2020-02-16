import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class A {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        go:
        for (int T = input.nextInt(); T > 0; T--) {
            Stack<Character> cha=new Stack<>();
            cha.push('n');cha.push('a');cha.push('r');cha.push('n');cha.push('a');cha.push('l');
            char [] s=input.next().toCharArray();
            for (int i=0;i<s.length;i++){
                if (s[i]==cha.peek()){
                    cha.remove(cha.size()-1);
                }
                if (cha.size()==0){
                    out.println("YES");
                    out.flush();
                    continue go;
                }
            }
            out.println("NO");
            out.flush();
        }
    }
}
