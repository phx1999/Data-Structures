import java.util.ArrayList;

import java.util.Scanner;

public class C {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int num=0;
            int n=input.nextInt();
            int m=input.nextInt();
            ArrayList<Integer> a=new ArrayList<>();
            int []b=new int[n];
            for (int j=0;j<n;j++){
                a.add(input.nextInt());
                b[j]=m-a.get(j);
            }
            for (int j=0;j<n;j++){
                if (a.contains(b[j])){
                    num++;
                }
            }
            System.out.println(num/2);
        }
    }
}