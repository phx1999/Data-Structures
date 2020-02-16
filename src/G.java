import java.util.Scanner;

public class G {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        go:
        for (int i = 0; i < T; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int n = input.nextInt();
            int m = input.nextInt();
            int[][] bian = new int[][]{{a, b, c}, {a, c, b}, {b, a, c}, {b, c, a}, {c, a, b}, {c, b, a}};
            int[][] kuang = new int[][]{{n, m}, {m, n}};
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 2; k++) {
                    if (bian[j][0] + 2 * bian[j][2] <= kuang[k][0] && 2 * (bian[j][1] + bian[j][2]) <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if (bian[j][0] + 2 * bian[j][1] <= kuang[k][0] && 2 * (bian[j][1] + bian[j][2]) <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if (bian[j][0] + bian[j][1]+bian[j][2] <= kuang[k][0] && 2 * (bian[j][1] + bian[j][2]) <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if (bian[j][0] + 2 * bian[j][1] +bian[j][2]<= kuang[k][0] && bian[j][1] + bian[j][2]+bian[j][0] <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if (bian[j][0]*3 +bian[j][1]+bian[j][2] <= kuang[k][0] &&bian[j][1] + bian[j][2] <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if (bian[j][0] + bian[j][1]+bian[j][2] <= kuang[k][0] && 2 * (bian[j][0] + bian[j][1]) <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                    if ((bian[j][0] + bian[j][1])*2 <= kuang[k][0] && 2 * bian[j][1] + bian[j][2] <= kuang[k][1]){
                        System.out.println("Yes");
                        continue go;
                    }
                }
            }
            System.out.println("No");
        }
    }
}
