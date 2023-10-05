import java.util.*;
public class q {
    static class info{
        int s;
        int e;
        public info(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
    public static void mergeoverlapping(int arr[][]){
        Arrays.sort(arr, Comparator.comparingDouble(o->o[0]));
        Stack<info> s = new Stack<>();
        s.push(new info(arr[0][0] , arr[0][1]));
        for(int i=1;i<arr.length;i++){
            info p = s.peek();
            if(arr[i][0]<=p.e){
                s.pop();
                s.push(new info(p.s , Math.max(p.e , arr[i][1])));
            }
            else{
                s.push(new info(arr[i][0] , arr[i][1]));

            }

        }
        while(!s.isEmpty()){
            info p = s.peek();
            System.out.println(p.s + " " + p.e);
            s.pop();
        }
    }
    
    public static void longestsubarraysumdivisiblebyk(int arr[] , int k){
        int maxl = 0;
        int sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int rem = ((sum%k) +k)%k;

            if(rem==0){
                maxl = i+1;
            }
            else if(!map.containsKey(rem)){
                map.put(rem , i);
            }
            else{
                int sz = map.get(rem);
                maxl = Math.max(maxl , i-sz);
            }
        }
        System.out.println(maxl);
    }
    public static void subset(String str , String ans , int idx){
        if(idx==str.length()){
            if(ans.length()==2){
            System.out.println(ans);
        }
            return;
        }
        char ch = str.charAt(idx);
        subset(str , ans+ch ,idx+1);
        subset(str,ans,idx+1);
        
    }
    static ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
    
    public static void subset(int arr[] , int k , int idx,int n, ArrayList<Integer> list){
        if(list.size()==k){
            list1.add(new ArrayList(list));
            return;
        

        }
        for(int i=idx;i<arr.length;i++){
            list.add(arr[i]);
            subset(arr,k,i+1,n,list);
            list.remove(list.size()-1);
        }
        
    





    }
    public static void main(String args[]){
        //int arr[][] = {{6,8},{1,9},{2,4},{4,7}};

        //mergeoverlapping(arr);
        //int arr[] = {-2, 2, -5, 12, -11, -1, 7};
        //longestsubarraysumdivisiblebyk(arr, 3);

        //subset("abc", "", 0);
        int arr[] = {1,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        subset(arr, 3, 0,5, list);
        System.out.println(list1);

    }
    
}
