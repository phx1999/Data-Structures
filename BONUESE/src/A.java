
import java.util.Scanner;

public class A {
    public static void main(String args[]) {
        Scanner input =new Scanner(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt()-1;
            int i=input.nextInt();
            while (n > 0){
                int a=input.nextInt();
                if (i<a){
                    i=a;
                }
                n--;
            }
            System.out.println(i);
        }
    }
}