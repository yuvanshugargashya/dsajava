/*import java.util.*;
public class array{
    public static int ls(int arr[] , int key){
        for(int i =0;i<arr.length ;i++){
            if(arr[i] == key){
                return 1;
            }

        }
        return -1;
    }
    public static int bs(int arr[] , int key){
        int  s=0;
        int e = arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                return 1;
            }
            else if(arr[mid]>key){
                e = mid-1;
            }
            else{
                s = mid+1;
            }


        }
        return -1;
    }
    public static void reverse(int arr[]){
        for(int i =0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length -1 -i];
            arr[arr.length -1 -i] = temp;

        }
    }
    public static void pair(int arr[] ){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }
    public static void subarray(int arr[]){
        int maxsum =0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum =0;
                for(int k=i;k<=j;k++){
                    //System.out.print(arr[k]);
                    sum = sum + arr[k];
                }
                //System.out.println();
                System.out.println(sum);
                maxsum = Math.max(maxsum , sum);
            }
        }
        System.out.println(maxsum);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        /*int marks[] = new int[5];
        for(int  i=0;i<5;i++){
            marks[i] = sc.nextInt();
        }
        for(int  i=0;i<5;i++){
            System.out.println(marks[i]);
        }
        int marks[] = {1,2,3,4,5,6,7};
        //System.out.println(ls(marks , 7));
        //System.out.println(bs(marks , 7));
        /*reverse(marks);
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]);
        }
        //pair(marks);
        subarray(marks);


    }
}*/

import java.util.*;
public class array{
    public static int linear(int arr[] , int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return i;
            }
        }
        return -1;

    }
    public static int largest(int arr[]){
        //int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public static int binary(int arr[] ,int key){
        int s =0;
        int e= arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                e = mid-1;
            }
            else{
                s= mid+1;
            }

        }
        return -1;
    }
    public static void reverse(int arr[]){
        for(int i=0;i<(arr.length/2);i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;

        }
    }
    public static void pair(int arr[]){
        for(int i =0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.println(arr[i]+ " " + arr[j]);
            }
        }
    }
    public static void pairs(int arr[] ){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }
    public static void subarray(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
        }
    }
    public static void maxsubarray(int arr[]){
        int mm = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int max = 0;
                for(int k=i;k<=j;k++){
                    //System.out.print(arr[k]);
                    max = max+ arr[k];
                }
                if(max>mm){
                    mm = max;
                }
                //System.out.println();
            }
        }
        System.out.println(mm);
    }
    public static void prefix(int arr[]){
        int currsum =0;
        int maxsum = Integer.MIN_VALUE;
        int prefixarr[] = new int[arr.length];
        prefixarr[0] = arr[0];
        for(int i=1;i<prefixarr.length;i++){
            prefixarr[i] = arr[i] + prefixarr[i-1];
        }

        for(int i=0;i<arr.length;i++){
            int start = i;
            for(int j=i;j<arr.length;j++){
                int end =j;
                currsum = (start ==0)? prefixarr[end]:prefixarr[end]-prefixarr[start-1];
                if(currsum>maxsum){
                    maxsum = currsum;
                }
            }
        }
        System.out.println(maxsum);
    }
    public static void kadens(int arr[]){
        int max = Integer.MIN_VALUE;
        int curr = 0;
        for(int i=0;i<arr.length;i++){
            curr = curr + arr[i];
            if(curr<0){
                curr = 0;

            }
            if(curr>max){
                max = curr;
            }
        }
        System.out.println(max);
    }
    public static void trappingwater(int arr[]){
        
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int lm =0;
        for(int i=0;i<arr.length;i++){
            if(lm<arr[i]){
                left[i] = arr[i];
                lm = left[i];
            }
            else{
                left[i] = lm;


            }
        }
        int rm=0;
        for(int i=arr.length-1;i>=0;i--){
            if(rm<arr[i]){
                right[i] = arr[i];
                rm = right[i];
            }
            else{
                right[i] = rm;
            }
        }
        int waterstored= 0;
        for(int i=0;i<arr.length;i++){
            int level = Math.min(right[i] , left[i]);
            waterstored += (level - arr[i]);
        }
        System.out.println(waterstored);
    }
    public static int stocks(int arr[]){
        int buyp = arr[0];
        int maxp = 0;
        for(int i=0;i<arr.length;i++){
            buyp = Math.min(buyp , arr[i]);
            int sp = arr[i];
            
            int profit = sp - buyp;
            if(profit<0){
                return 0;
            }
            maxp = Math.max(maxp, profit);


            

        }
        return maxp;
    }
    public static void threesum(int arr[] , int t){
        Arrays.sort(arr);
        int s;
        int e;
        
        for(int i=0;i<arr.length-2;i++){
            int first = arr[i];
            s = i+1;
            e = arr.length-1;
            while(s<e){
            int summ = first + arr[s]+arr[e];
            if(summ==t){
                System.out.println(arr[i] + " "+ arr[s] + " "+arr[e]);
                break;
                

            }
            else if(summ>t){
                e--;

            }
            else{
                s++;
            }
        }
        }
    }
    public static void  main(String args[]){

        /*int arr[] = new int[5];
        int num[] = {1,2,3,4,5};
        for(int i =0;i<5;i++){
            arr[i] = i;
        }*/
        //System.out.println(arr.length);
        //System.out.println(arr[4]);
        //int srch = linear(arr,0);
        //System.out.println(srch);
        //System.out.println(largest(arr));
        //System.out.println(binary(arr ,4));
        //reverse(arr);
        //for(int i=0;i<arr.length;i++){
        //    System.out.print(arr[i]);
        //}
        //pair(arr);
        //subarray(arr);
        //maxsubarray(arr);
        //prefix(arr);
        //kadens(arr);
        //int building[] = {4,2,0,6,3,2,5};
        //trappingwater(building);
        int arr[] = {7,1,5,3,6,4};
        System.out.println(stocks(arr));

    }
}
