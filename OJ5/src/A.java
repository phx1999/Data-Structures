import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int ans1 = 1;
            int ans2 = 1;
            boolean b=true;
            char ly = ' ';
            int n = Integer.parseInt(input.readLine());
            for (int i = n; i > 0; i--) {
                String s = input.readLine();
                int l = s.length() - 1;
                if (i == n) {
                    ly = s.charAt(l);
                    continue;
                }
                if(ly == s.charAt(l)){
                    ans1 ++;
                }else if (ly != s.charAt(l)&&b){
                    ans2 =ans1;
                    ans1=1;
                    ly=s.charAt(l);
                    b=false;
                }else {
                    if (ans2>ans1){
                        ans1=1;
                    }else {
                        ans2=ans1;
                        ans1=1;
                    }
                    ly=s.charAt(l);
                }
            }
            out.println(ans2);
            out.flush();
        }
    }
}