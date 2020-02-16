import java.io.*;

public class B {

    public static void main(String args[]) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        for (int T = Integer.parseInt(input.readLine()); T > 0; T--) {
            String line=input.readLine();
            int n =Integer.parseInt(line.split(" ")[0]);
            int k =Integer.parseInt(line.split(" ")[1]);
            String [] lin=input.readLine().split(" ");
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(lin[i]);
            }
            int[] num1 = num;
            boolean b = true;
            int size=n;
            while (b) {
                int a = size/2;
                int[] ans1 = new int[size];
                int[] ans2 = new int[size];
                int i = 0;
                int j = 0;
                for (int l = 0; l < size; l++) {
                    if (num1[l] < num1[a]) {
                        ans1[i] = num1[l];
                        i++;
                    } else {
                        ans2[j] = num1[l];
                        j++;
                    }
                }
                if (i == k - 1) {
                    out.println(num1[a]);
                    out.flush();
                    break;
                } else if (i < k - 1) {
                    k = k - i;
                    num1=ans2;
                    size-=i;
                } else {
                    num1=ans1;
                    size-=j;
                }
            }
        }
    }
}

