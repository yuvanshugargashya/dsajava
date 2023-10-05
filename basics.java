/*import java.util.*;
public class basics{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*int a = 0;
        int b = 4;
        int c = a+b;
        System.out.println(c);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        int m  = sc.nextInt();
        System.out.println(m);
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(s);*/
        /*float f = 3.1f;
        int a = (int)f;
        System.out.println(a);
        char c = 'a';
        int n = c*2;
        System.out.print(n);
        int p = 7;
        int e = p/3;
        System.out.println(e);
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int larger = (a>b) ? a : b;
        System.out.println(larger);*/

        /*int n = sc.nextInt();
        if(n%100 != 0  && n%4 ==0){
            System.out.println("leap");
        }                                        leap year
        else if(n%100 == 0 && n%400 ==0){
            System.out.println("leap");
        }
        else{
            System.out.println("leap non");
        }*/

        //int n  = sc.nextInt();
        /*while(n>0){
            int lastd = n%10;
            System.out.print(lastd);
            n = n/10;
        }
        int rev =0;
        while(n>0){
            int ld = n%10;
         rev =  (rev*10) +ld  ;
            n = n/10;
        }
        System.out.println(rev);

        int n =  sc.nextInt();
        boolean isprime = true;
        for(int i =2; i<= Math.sqrt(n); i++){
            if(n %i == 0){
                isprime = false;
            }

        }
        if(isprime == true){
            System.out.println("prime");


        }
        else{
            System.out.println("nonprime");
        }





    }
}*/
import java.util.*;
public class basics{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        /*int a = 0;
        boolean f = true;
        float  fl = 1.2f;
        char c = 'c';
        System.out.println(a);
        int a = sc.nextInt();
        System.out.println(a);
        //char c = sc.next().charAt(0);
        //System.out.println(a +  c);
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(s);

        int a = sc.nextInt();
        String check = (a%2==0)? "even": "odd";
        System.out.println(check);
        int year = sc.nextInt();
        if(year%100 == 0 && year%400 == 0){
            System.out.println("leap");
        }
        else if(year%100 != 0 && year%4 ==0){
            System.out.println("leap");
        }
        else{
            System.out.println("not leap");
        }
        int n = sc.nextInt();
        while(n>0){
            int ld = n%10;
            n = n/10;
            System.out.print(ld);
        }
        int n = sc.nextInt();
        int rev = 0;
        while(n>0){
            int ld = n%10;
            n = n/10;

            rev  = rev*10 + ld;
        }
        System.out.println(rev);*/
        int n =  sc.nextInt();
        int i = 2;
        boolean isprime = true;
        while(i<n){
            if(n%i == 0){
                isprime = false;
                System.out.println("np");
                break;
            }
            i++;
            if(i> Math.sqrt(n)){
                break;
            }
        }
        if(isprime == true){
            System.out.println("prime");
        }

        


    }
}