/*import java.util.*;
public class basics2{
    public static void first(){
        System.out.println("first fun");
    }
    public static void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a + " and" +  b);
    }
    //public static int sum(int x , int y){
    //    System.out.println(x+y);
    //    return (x+y);
    //}
    //public static float sum(int x , int y){
    //    System.out.println(x+y);
    //    return (int)(x+y);
    //}
    public static void dtb(int n){
        int bin = 0;
        int p =0;
        while(n>0){
            int rem = n%2;
            bin = bin + (rem * (int)Math.pow(10 , p));
            p++;
            n = n/2;
        }
        System.out.println(bin);
    }
    public static void btd(int n){
        int dec = 0;
        int p=0;
        while(n>0){
            int rem = n%10;
            dec = rem* (int)Math.pow(2,p);
            p++;
            n = n/10;


        }
        System.out.println(dec);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*first();
        int a = 2;
        int b = 5;
        swap(a,b);
        System.out.println(a + " and" + b);

        int n  =  sc.nextInt();
        while(n>0){
            int remainder = n%2;
            System.out.print(remainder);
            n = n/2;
        }
        System.out.println();
        dtb(16);
        btd(10000);
    }
}*/
import java.util.*;
public class basics2{
    public static void swap(int a , int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.print(a + " " + b);


    }
    public static void dtb(int n){
        int bin = 0;
        int pow = 0;
        while(n>0){
            int rem = n%2;
            bin = bin + (int)(rem*Math.pow(10,pow));
            pow++;
            n = n/2;
        }
        System.out.print(bin);
    }
    public static void btd(int n){
        int dec = 0;
        int p = 0;
        while(n>0){
            int ld = n%10;
            dec = dec + (int)(ld*Math.pow(2,p));
            p++;
            n = n/10;

        }
        System.out.println(dec);
    }
    public static void main(String args[]){
        /*int a= 9;
        int b=8;
        swap(a,b);
        System.out.print(a + " " + b);*/
        dtb(11);
        btd(1011);



    }
}
