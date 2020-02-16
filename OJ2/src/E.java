import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int L = input.nextInt();
            int n = input.nextInt();
            int m = input.nextInt();
            int[] N = new int[n + 2];
            N[0] = 0;
            N[n + 1] = L;
            for (int i = 1; i < n + 1; i++) {
                N[i] = input.nextInt();
            }
            Arrays.sort(N);
            int min = 0;
            int max = L;
            go:
            while (min < max) {
                int a = (max + min) / 2;
                int b = 0;
                int c = 1;
                for (int j = 1; j < n + 2; j++) {
                    if (N[j] - b > a) {
                        b = N[j - 1];
                        c++;
                        if (N[j] - b > a) {
                            min = a + 1;
                            continue go;
                        }
                    }
                }
                if (c <= m) {
                    max = a;
                } else {
                    min = a + 1;
                }
            }
            System.out.println(min);
        }
    }
}