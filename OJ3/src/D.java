import javax.print.DocFlavor;
import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class D {
    static PrintWriter out;
    static InputReader input;

    public static void main(String args[]) throws IOException {
        out = new PrintWriter(System.out);
        input = new InputReader(System.in);
        for (int T = input.nextInt(); T > 0; T--) {
            int n = input.nextInt();
            int num = 0;
            int l = 0;
            List<User> users = new ArrayList<User>();
            boolean a = false;
            for (int j = 0; j < n; j++) {
                users.add(new User(input.nextInt(),input.nextInt()));
            }
            Collections.sort(users);
            int [][]nn=new int[n][2];
            for (int j = 0; j < n; j++) {
                nn[j][0]=users.get(j).getScore();
                nn[j][1]=users.get(j).getAge();
            }
            ArrayList<Integer> ncn = new ArrayList<>();
            ArrayList<Integer> nen = new ArrayList<>();
            for (int j = l; j < n; j++) {
                if (nn[l][1] != nn[j][1]) {
                    int fuck = 0;
                    for (int k = l; k < j; k++) {
                        fuck += nn[k][0];
                    }
                    ncn.add(fuck);
                    nen.add(nn[l][1]);
                    if (j == n - 1) {
                        ncn.add(nn[j][0]);
                        nen.add(nn[j][1]);
                        break;
                    }
                    l = j;
                    continue;
                }
                if (j == n - 1) {
                    int fuck = 0;
                    for (int k = l; k < j + 1; k++) {
                        fuck += nn[k][0];
                    }
                    ncn.add(fuck);
                    nen.add(nn[l][1]);
                    break;
                }
            }
            for (int j = 0; j < ncn.size(); j++) {

                int co = ncn.get(j) * nen.get(j);
                int eo = nen.get(j) - 1;
                if (co == 0) {
                    continue;
                }
                if (num == 0 || co < 0) {
                    if (eo == 0) {
                        out.print(String.format("%d", co));
                        a = true;
                        num = 1;
                    } else if (eo == 1 && co != 1 && co != -1) {
                        out.print(String.format("%dx", co));
                        a = true;
                        num = 1;
                    } else if (eo == 1 && co == 1) {
                        out.print("x");
                        a = true;
                        num = 1;
                    } else if (eo == 1 && co == -1) {
                        out.print("-x");
                        a = true;
                        num = 1;
                    } else if (eo != 1 && co == 1) {
                        out.print(String.format("x^%d", eo));
                        a = true;
                        num = 1;
                    } else if (eo != 1 && co == -1) {
                        out.print(String.format("-x^%d", eo));
                        a = true;
                        num = 1;
                    } else {
                        out.print(String.format("%dx^%d", co, eo));
                        a = true;
                        num = 1;
                    }
                } else if (num != 0 && co != 0) {
                    if (eo == 0) {
                        out.print(String.format("+%d", co));
                        a = true;
                    } else if (eo == 1 && co != 1) {
                        out.print(String.format("+%dx", co));
                        a = true;
                    } else if (eo == 1 && co == 1) {
                        out.print("+x");
                        a = true;
                    } else if (eo != 1 && co == 1) {
                        out.print(String.format("+x^%d", eo));
                        a = true;
                    } else {
                        out.print(String.format("+%dx^%d", co, eo));
                        a = true;
                    }
                }
            }
            if (a == false) {
                out.print("0");
            }
            out.print("\n");
            out.flush();
        }
    }
}
     class User implements Comparable<User> {

        private int score;

        private int age;

        public User(int score, int age) {
            super();
            this.score = score;
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            int i = this.getAge() - o.getAge();//先按照年龄排序
            if (i == 0) {
                return this.score - o.getScore();//如果年龄相等了再用分数进行排序
            }
            return i;
        }

    }

