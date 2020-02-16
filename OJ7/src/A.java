import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class A {
    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        go:
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            int n = Integer.parseInt(input.readLine());
            int [][]node=new int[n+1][2];
            int[] father = new int[n + 1];
            for (int i=1;i<n+1;i++){
                String s=input.readLine();
                String [] a=s.split(" ");
                node[i][0]=Integer.parseInt(a[0]);
                node[i][1]=Integer.parseInt(a[1]);
                father[node[i][0]]=i;
                father[node[i][1]]=i;
            }
            int root=0;
            for (int i=1;i<n+1;i++){
                if (father[i]==0)
                    root=i;
            }
            Queue<Integer> tong = new LinkedList<>();
            tong.add(root);
            boolean a=false;
            int num=2*n;
            while (num>0) {
                int size = tong.size();
                for (int i=0;i<size;i++){
                    int x=tong.poll();
                    num--;
                    if (x==0)
                        a=true;
                    if (x!=0&&a){
                        out.println("No");
                        out.flush();
                        continue go;
                    }
                    tong.add(node[x][0]);
                    tong.add(node[x][1]);
                }
            }
            out.println("Yes");
            out.flush();
        }
    }
}
