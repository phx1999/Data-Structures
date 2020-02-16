import java.util.Scanner;

public class D {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int a = 0;
            int n = input.nextInt();
            int m = input.nextInt();
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = input.nextInt();
            }
            int room = 0;
            int day1 = 0;
            int day2 = 0;
            go:
            for (int i = 0; i < m; i++) {
                if (a == 1) {
                    input.nextInt();
                    input.nextInt();
                    input.nextInt();
                    continue;
                }
                room = input.nextInt();
                day1 = input.nextInt();
                day2 = input.nextInt();
                for (int j = day1 - 1; j <= day2 - 1; j++) {
                    r[j] = r[j] - room;
                    if (r[j] < 0) {
                        a = 1;
                        System.out.println("-1");
                        System.out.println(i + 1);
                        continue go;
                    }
                }
            }
            if (a == 0) {
                System.out.println("0");
            }
        }
    }
}