import java.util.Scanner;

public class B {
    public static double hanshu(double b) {
        double a = 35 * Math.pow(b, 6) + 36 * Math.pow(b, 5) + 9 * Math.pow(b, 2) + 8 * b;
        return a;
    }
    public static double zhi(double b) {
        double a = 5 * Math.pow(b, 7) + 6 * Math.pow(b, 6) + 3 * Math.pow(b, 3) + 4 * Math.pow(b, 2);
        return a;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        double zhi;
        for (int i = 0; i < T; i++) {
            double Y = input.nextInt();
            double max=100.0;
            double min=0.0;
            for (int j = 0; j < 10000; j++) {
                double a =(max+min)/2;
                zhi=zhi(a)-2*a*Y;
                if (max-min<=0.0000001){
                    System.out.println(String.format("Case %d: %.4f",i+1, zhi));
                    break;
                }
                if (hanshu(a) - 2 * Y > 0) {
                    max=a;
                    continue;
                }
                if (hanshu(a) - 2 * Y < 0){
                    min=a;
                    continue;
                }
            }
        }
    }
}