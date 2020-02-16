import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
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
            char[][] road = new char[n][m];
            int c=0;
            int v=0;
            for (int i = 0; i < n; i++) {
                String s=input.next();
                if (s.indexOf('S')>=0){
                    c=i;v=s.indexOf('S');
                }
                road[i] = s.toCharArray();
            }
            char[] num = input.next().toCharArray();
            int ans=0;
            for (int s = 0; s < 4; s++) {
                for (int x = 0; x < 4; x++) {
                    if (x==s){
                        continue;
                    }
                    for (int z = 0; z < 4; z++) {
                        if (z==x||z==s){
                            continue;
                        }
                        go:
                        for (int y = 0; y < 4; y++) {
                            if (y==z||y==s||y==x){
                                continue;
                            }
                            int q=c;
                            int p=v;
                            for (int i = 0; i < num.length; i++) {
                                if (Integer.parseInt(String.valueOf(num[i]))==s){
                                    q-=1;
                                    if (q<0){
                                        continue go;
                                    }
                                    if (road[q][p]=='#'){
                                        continue go;
                                    }
                                    if (road[q][p]=='E'){
                                        ans+=1;
                                        continue go;
                                    }
                                } else if (Integer.parseInt(String.valueOf(num[i]))==x){
                                    q+=1;
                                    if (q==n){
                                        continue go;
                                    }
                                    if (road[q][p]=='#'){
                                        continue go;
                                    }
                                    if (road[q][p]=='E'){
                                        ans+=1;
                                        continue go;
                                    }
                                } else if (Integer.parseInt(String.valueOf(num[i]))==z){
                                    p-=1;
                                    if (p<0){
                                        continue go;
                                    }
                                    if (road[q][p]=='#'){
                                        continue go;
                                    }
                                    if (road[q][p]=='E'){
                                        ans+=1;
                                        continue go;
                                    }
                                } else if (Integer.parseInt(String.valueOf(num[i]))==y){
                                    p+=1;
                                    if (p==m){
                                        continue go;
                                    }
                                    if (road[q][p]=='#'){
                                        continue go;
                                    }
                                    if (road[q][p]=='E'){
                                        ans+=1;
                                        continue go;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            out.println(ans);
            out.flush();
        }
    }
}

