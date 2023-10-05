public class recursion {
    public static void rec(int n){
        
        System.out.print(n);
        if(n ==0){
            return;
        }
        rec(n-1);
    }
    public static int fact(int n){
        if(n ==1){
            return 1;
        }
        return n*fact(n-1);
    }
    public static void check(int n){
        if(n==0){
            return ;
        }
        System.out.println(n);
        check(n-1);
        System.out.println(n);


    }
    public static int fabonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fab = fabonacci(n-1)+ fabonacci(n-2);
        
        return fab;
    }
    public static boolean issorted(int arr[] , int i ){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return issorted(arr, i+1);

    }
    public static int firstocc(int arr[] , int i , int key){
        if(arr[i] == key){
            return i;
        }
        if(i == arr.length){
            return -1;
        }
        return firstocc(arr , i+1,key);
    }
    public static int lastocc(int arr[] , int key , int i){
        if(i == arr.length){
            return -1;
        }
        int temp = lastocc(arr, key, i+1);
        if(temp == -1 && arr[i] == key){
            return i;
        }
        return temp;
    }
    public static int optipower(int a , int n){
        if(n==0){
            return 1;
        }
        int halfpow = optipower(a , n/2);
        int halfpowsq = halfpow*halfpow;
        if(n%2 != 0 ){
            halfpowsq = a*halfpowsq;
        }
        return halfpowsq;

    }
    public static int tiling(int n){
        if(n ==1 || n ==0){
            return 1;
        }
        int vertical = tiling(n-1);
        int horizontal = tiling(n-2);
        int total = vertical + horizontal;
        return total;
    }
    public static void removeduplicate(String str , int idx , StringBuilder sb , boolean map[]){
        if(idx == str.length()){
            System.out.println(sb);
            return;
        }
        char curr = str.charAt(idx);
        if(map[curr - 'a'] == true){
            removeduplicate(str,idx+1,sb,map);
        }
        else{
            map[curr - 'a'] = true;
            removeduplicate(str,idx+1,sb.append(curr),map);
            


        }
    }
    public static int pairing(int n){
        if(n ==1 || n==2){
            return n;
        }
        int single = pairing(n-1);
        int doubble = (n-1)*pairing(n-2);
        int total = single + doubble;
        return total;

    }
    public static void binarystring(int n , int lastplace , String sb){
        if(n==0){
            System.out.println(sb);
            return;
        }
        binarystring(n-1, 0, sb+ "0");
        if(lastplace ==0){
            binarystring(n-1, 1, sb+ "1");
        }
    }
    public static int same(String str, int i , int j , int n){//starting and ending with same characters
        if(n==1){
            return 1;

        }
        if(n<=0){
            return 0;
        }
        int res = same(str , i+1,j,n-1)+same(str,i,j-1,n-1)-same(str,i+1,j-1,n-2);
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }
        return res;

    }
    public static void towerofhanoi(int n , String src , String help , String dest){
        if(n==1){
            System.out.println("transfer disk from "+ src + " to " + dest);
            return;
        }
        towerofhanoi(n-1, src, dest, help);
        System.out.println("transfer disk n from" + " "+ src +" to" + " "+ dest );
        towerofhanoi(n-1, help, src, dest);
    }
   public static void main(String args[]){
        //rec(5);
        //System.out.print(fact(4));
        //check(5);
        //System.out.println(fabonacci(6));
        //int arr[] = {1,2,3,4,5,6};
        //System.out.print(issorted(arr, 0));
        //System.out.println(firstocc(arr, 0, 3));
        //System.out.println(lastocc(arr, 6, 0));
        //System.out.println(optipower(2 ,3));
        //System.out.println(tiling(3));
        //String str = "aappnaccoolleegge";
        //removeduplicate(str , 0, new StringBuilder(""), new boolean [26]);
        //System.out.println(pairing(4));
        //binarystring(9, 0, "");
        towerofhanoi(3, "s", "h", "d");

    }
    
}
