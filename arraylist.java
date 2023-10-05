import java.util.*;

public class arraylist{
    public static void maxwatercont(ArrayList<Integer> container){
        int water = 0;
        for(int i=0;i<container.size();i++){
            for(int j=i+1;j<container.size();j++){
                int ht = Math.min(container.get(i), container.get(j));
                water = Math.max(water , ht*(j-i));

            }
        }
        System.out.println(water);
    }
    public static void storedwater(ArrayList<Integer> container){
        int lp = 0;
        int rp = container.size()-1;
        int maxwater = 0;
        while(lp<rp){
            int ht = Math.min(container.get(lp) , container.get(rp));
            maxwater = Math.max(maxwater , (ht*(rp-lp)));
            if(container.get(lp)<container.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        System.out.println(maxwater);


    }
    public static boolean pairsum(ArrayList<Integer> array , int target){
        int lp  = 0;
        int rp = array.size()-1;
        while(lp<rp){
            if(lp+rp == target){
                return true;
            }
            if(lp+rp> target){
                rp--;
            }
            else{
                lp++;
            }
        }
        return false;
    }
    public static void count(int arr[] , int key){//most frequent element following key
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]==key){
                map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
            }


        }
        int ans=0;
        int re=0;
        for(int i: map.keySet()){
            if(map.get(i)>ans){
                re = i;
                ans = map.get(i);
            }
        }
        System.out.println(re);
    }
    public static ArrayList<Integer> beautifularraylist(int n){
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(1);
        for(int i=2;i<=n;i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(Integer e :ans){
                if(2*e <=n){
                    temp.add(2*e);
                }

            }
            for(Integer e: ans){
                if(2*e-1 <= n){
                    temp.add(2*e-1);
                }
            }
            ans = temp;
        }
        return ans;
    }
    public static void main(String args[]){
        /*ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        for(int i=0;i<5;i++){
            System.out.print(list.get(i));
        }
        Collections.sort(list , Collections.reverseOrder());
        System.out.print(list);*/
        /*ArrayList<ArrayList<Integer>> main = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for(int i=0;i<5;i++){
            list1.add(i);
            list2.add(i*2);
            list3.add(i*3);
        }
        main.add(list1);
        main.add(list2);
        main.add(list3);
        System.out.print(main);*/
        ArrayList<Integer> container = new ArrayList<>();
        container.add(1);
        container.add(8);
        container.add(6);
        container.add(2);
        container.add(5);
        container.add(4);
        container.add(8);
        container.add(3);
        container.add(7);
        //maxwatercont(container);
        //storedwater(container);
        System.out.println(pairsum(container , 10));


    }
}
