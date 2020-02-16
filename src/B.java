import java.util.Scanner;

public class B {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        for (int i=0;i<T;i++){
            int n=input.nextInt();
            double a=1;
            for (int j=0;j<n;j++){
              a= a*3 % 1000000007;
            }
            System.out.printf("%.0f\n",a-1);
        }
    }
}
