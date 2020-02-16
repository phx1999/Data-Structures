import java.util.Scanner;

public class C {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int T =input.nextInt();
        String [] xy=new String[2];
        for (int i=0;i<T;i++){
            xy[0]=input.next();
            xy[1]=input.next();
        if (xy[0].equals("1")&&xy[1].equals("1")){
            System.out.println("Bob");
        }else {
            System.out.println("Alice");
        }
    }}
}
