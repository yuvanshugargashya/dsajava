import java.util.*;
public class bitsm {
    public static void geti(int n , int i){
        if((n & (1<<i)) == 0){
            System.out.println("0");
        }
        else{
            System.out.println("1");
        }
    }
    public static int countset(int n){
        int count =0;
        while(n>0){
            if((n & 1 )== 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void fastexpo(int  a , int n){
        int ans = 1;
        while(n>0){
            if( (n& 1) == 1){
                ans =  ans *a;
            }
            a = a*a;
            n = n>>1;
        }
        System.out.println(ans);
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        /*int  n = sc.nextInt();
        int bit = 1;
        if((n & bit)== 0){
            System.out.println("even");
        }
        else{
            System.out.print("odd");
        }*/
        //geti(5,1);
        //System.out.print(countset(5));
        fastexpo(3,5);

    }
}
