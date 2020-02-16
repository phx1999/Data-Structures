import java.util.Arrays;
import java.util.Scanner;

public class G {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] s = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = input.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = input.nextInt();
            }
            double min = 0.0;
            double max = 1000.0;
            while (max - min > 0.000001) {
                double gpa = (min + max) / 2;
                double[] sum = new double[n];
                for (int i = 0; i < n; i++) {
                    sum[i] = s[i] * (c[i] - gpa);
                }
                Arrays.sort(sum);
                double shit = 0.0;
                for (int i = k; i < n; i++) {
                    shit = shit + sum[i];
                }
                if (shit >= 0) {
                    min = gpa;
                } else {
                    max = gpa;
                }
            }
            if (max == 4.0) {
                System.out.println(String.format("%.3f", max));
            } else {
                System.out.println(String.format("%.3f", min));
            }
        }
    }
}