import java.util.Scanner;

public class D {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] abc = new int[3];
        for (int i = 0; i < T; i++) {
            abc[0] = input.nextInt();
            abc[1] = input.nextInt();
            abc[2] = input.nextInt();
            String s1 = "+";
            String s2 = "/";
            String s3 = "";
            for (int j = 0; j < abc[0]; j++) {
                s1 = s1 + "-+";
                s2 = s2 + "./";
                s3 = s3 + "|.";
            }
            if (abc[2] >= abc[1]) {
                int num = 2 * abc[1];
                for (int j = 0; j < 2 * abc[2] + 1; j++) {
                    String dian = "";
                    for (int c = 0; c < num; c++) {
                        dian = dian + ".";
                    }
                    if (j % 2 == 0) {
                        String jia = "";
                        for (int c = 0; c < (2 * abc[1] - num) / 2; c++) {
                            jia = jia + ".+";
                        }
                        System.out.println(dian + s1 + jia);
                    }
                    if (j % 2 == 1) {
                        String shu = "|";
                        for (int c = 0; c < (2 * abc[1] - num) / 2; c++) {
                            shu = shu + "/|";
                        }
                        if (j <= 2 * abc[1]) {
                            System.out.println(dian + s2 + shu);
                        } else {
                            System.out.println(dian + s3 + shu);
                        }
                    }
                    if (num > 0) {
                        num = num - 1;
                    }
                }
                num = num + 1;
                for (int j = 0; j < 2 * abc[1]; j++) {
                    String dian = "";
                    for (int c = 0; c < num; c++) {
                        dian = dian + ".";
                    }
                    if (j % 2 == 0) {
                        String s4 = "|";
                        for (int x = 0; x < abc[0]; x++) {
                            s4 = s4 + ".|";
                        }
                        String shu = "/";
                        for (int c = 0; c < (2 * abc[1] - num) / 2; c++) {
                            shu = shu + "|/";
                        }
                        System.out.println(s4 + shu + dian);
                    }
                    if (j % 2 == 1) {
                        String jia = "";
                        for (int c = 0; c < (2 * abc[1] - num) / 2; c++) {
                            jia = jia + ".+";
                        }
                        System.out.println(s1 + jia + dian);
                    }
                    num = num + 1;
                }
                continue;
            } else {
                int num = 2 * abc[1];
                for (int j = 0; j < 2 * abc[2] + 1; j++) {
                    String dian = "";
                    for (int x = 0; x < num; x++) {
                        dian = dian + ".";
                    }
                    if (j % 2 == 0) {
                        String jia = "";
                        for (int c = 0; c < (2 * abc[1] - num) / 2; c++) {
                            jia = jia + ".+";
                        }
                        System.out.println(dian + s1 + jia);
                    }
                    if (j % 2 == 1) {
                        String shu = "|";
                        for (int c = 0; c < (2 * abc[1] - num - 1) / 2; c++) {
                            shu = shu + "/|";
                        }
                        System.out.println(dian + s2 + shu);
                    }
                    num = num - 1;
                }
                int x=(2 * abc[1] - num - 1) / 2;
                for (int j = 0; j < 2 * (abc[1] - abc[2]) - 1; j++) {
                    String dian1 = "";
                    for (int q = 0; q < num; q++) {
                        dian1 = dian1 + ".";
                    }
                    String dian2 ="";
                    for (int q = 0; q < 2*abc[1]-num-2*x; q++) {
                        dian2 = dian2 + ".";
                    }
                    if (j%2==0){
                        String shu="";
                        for (int c = 0; c < x; c++) {
                            shu = shu + "|/";
                        }
                        System.out.println(dian1+s2+shu+dian2);
                    }
                    if (j%2==1){
                        String jia="";
                        for (int c = 0; c < x; c++) {
                            jia = jia + ".+";
                        }
                        System.out.println(dian1+s1+jia+dian2);
                    }
                    num=num-1;
                }
                int a=x;
                int b=2*abc[1]-num-2*x;
                for (int j=0;j<2*abc[2]+1;j++){
                    String dian ="";
                    for (int q = 0; q < b; q++) {
                        dian = dian + ".";
                    }
                    b=b+1;
                    if (j%2==0){
                        String jia="";
                        for (int c = 0; c < a; c++) {
                            jia = jia + ".+";
                        }
                        System.out.println(s1+jia+dian);
                        a=a-1;
                    }
                    if (j%2==1){
                        String shu="";
                        for (int c = 0; c < x; c++) {
                            shu = shu + "|/";
                        }
                        System.out.println(s3+shu+dian);
                        x=x-1;
                    }
            }
        }
    }
}}