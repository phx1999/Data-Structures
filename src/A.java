import java.util.Scanner;

public class A {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        go:
        for (int j=0;j<T;j++) {
            int n = input.nextInt();
            String[] S = new String[n];
            for (int i = 0; i < n; i++) {
                S[i] = input.next().toLowerCase();
                System.out.println(S[i]);
            }
            int m = input.nextInt();
            String [] words=new String[m];
            for (int i=0;i<m;i++){
                words[i]=input.next().toLowerCase();
                System.out.println(words[i]);
            }
            for (int i=0;i<m;i++){
                for (int x=0;x<n;x++){
                    if (words[i].equals(S[x])){
                        System.out.println("Appeared");
                        j=j+1;
                        continue go;
                    }
                }
            }
            System.out.println("Not appeared");
        }
    }
}
