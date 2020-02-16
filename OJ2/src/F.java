import java.util.Scanner;

public class F {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i=0;i<T;i++){
            int n=input.nextInt();
            double x[]=new double[n];
            double w[]=new double[n];
            for (int j=0;j<n;j++){
                x[j]=input.nextDouble();
                w[j]=input.nextDouble();
            }
            double min=-Math.pow(10,6);
            double max=Math.pow(10,6);
            double p=0;
            while (max-min>0.0000000001){
                double sum=0;
                p=(max+min)/2;
                for (int j=0;j<n;j++){
                    if (x[j]<=p){
                        sum=sum+Math.pow((p-x[j]),2)*w[j];
                    }else {
                        sum=sum-Math.pow((p-x[j]),2)*w[j];
                    }
                }
                if (Math.abs(sum)<=0.00000000001){
                    min=p;
                    break;
                }
                if (sum>0){
                    max=p;
                }else {
                    min=p;
                }
            }
            double dis=0;
            for (int j=0;j<n;j++){
                dis=dis+Math.pow(Math.abs(min-x[j]),3)*w[j];
            }
            System.out.println(String.format("Case #%d: %.0f",i+1,dis));
        }
    }
}