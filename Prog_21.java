import java.util.*;// Проверка на магический квадрат
public class Prog_21 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum1=0,x=1,sum2=0;
        int [][] a = new int [n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                a[i][j]= sc.nextInt();
                }
        }
        for(int i=0;i<n;i++){
            sum1+=a[i][i];
        }


        for (int i=0;i<n;i++){
            sum2=0;
            for (int j=0;j<n;j++){
                sum2+=a[i][j];
            }
            if (sum1 !=sum2)
                x=0;
        }
        for (int j=0;j<n;j++){
            sum2=0;
            for (int i=0;i<n;i++){
                sum2+=a[i][j];
            }
            if (sum1 !=sum2)
                x=0;
        }
        for (int i=0;i<n;i++){
            sum2+=a[i][n-1-i];
        }
        if (sum1!=sum2)
            x=0;

           if (x==1)
               System.out.print("Yes");
        else
               System.out.print("No");
    }
}
