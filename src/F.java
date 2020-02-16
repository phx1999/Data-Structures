

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class F {
    public static void main(String args[]) {
        String cha = "bcdfghjklmnpqrstvxz";
        String ch = "";
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            String s = input.next();
            char[] chara = s.toCharArray();
            int aa = 0;
            ArrayList<Character> fuck = new ArrayList<>();
            a:
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < j; k++) {
                    if (chara[j] == chara[k]) {
                        continue a;
                    }
                }
                aa++;
                fuck.add(chara[j]);

            }
            ArrayList s1 = new ArrayList();
            int cout = 0;
            int sb = s.length() - 1;
            for (int j = 0; j < sb; j++) {
                s1.add(s.substring(j, j + 2));
                if (s1.get(j - cout).toString().contains("a") || s1.get(j - cout).toString().contains("e") || s1.get(j - cout).toString().contains("i") || s1.get(j - cout).toString().contains("o") || s1.get(j - cout).toString().contains("u") || s1.get(j - cout).toString().contains("w") || s1.get(j - cout).toString().contains("y")) {
                    s1.remove(j - cout);
                    cout = cout + 1;
                    continue;
                }
            }
            Collections.sort(s1);
            int s1size = s1.size();
            cout = 1;
            ArrayList pair = new ArrayList<>();
            ArrayList<Integer> num = new ArrayList<>();
            for (int j = 1; j < s1size; j++) {
                if (s1.get(j).toString().equals(s1.get(j - 1).toString())) {
                    cout++;
                    if (j == s1size - 1) {
                        pair.add(s1.get(j));
                        num.add(cout);
                    }
                    continue;
                }
                if (j != s1size - 1) {
                    pair.add(s1.get(j - 1));
                    num.add(cout);
                    continue;
                }
                pair.add(s1.get(j - 1));
                num.add(cout);
                pair.add(s1.get(j));
                num.add(cout);
            }
            int pasize = pair.size();

            int Ans = 0;
            for (int j = 1; j <= Math.pow(2, aa); j++) {
                int tmp = j;
                int[] ww = new int[30];
                int smjb = 0;
                while (tmp != 0) {
                    ww[smjb] = tmp % 2;
                    tmp = tmp / 2;
                    smjb++;
                }
                int a = 0;
                for (int k = 0; k < pasize; k++) {
                    int q = fuck.indexOf(pair.get(k).toString().charAt(0));
                    int w = fuck.indexOf(pair.get(k).toString().charAt(1));
                    if (ww[q] != ww[w]) {
                        a = a + num.get(k);
                    }
                }
                if (a > Ans) Ans = a;
            }
            System.out.println(Ans);
        }
    }
}