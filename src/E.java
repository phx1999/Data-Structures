import java.util.Scanner;

public class E {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int n = input.nextInt();
            int[] ai = new int[n];
            int max=0;
            int []diff=new int[n];
            for (int z = 0; z < n; z++) {
                ai[z] = input.nextInt();
                if (z==0){
                    max=ai[0];
                    continue;
                }
                if (max<ai[z-1]){
                    max=ai[z-1];
                }
                diff[z]=max-ai[z];
                if (z==1){
                    continue;
                }
                if (diff[z]<diff[z-1]){
                    diff[z]=diff[z-1];
                }
            }
            System.out.println(diff[n-1]);
        }
    }
}