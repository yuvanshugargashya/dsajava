import java.util.*;
public class hashing{

    public static boolean isanagram(String s , String t){
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch , map.getOrDefault(ch, 0)+1);

        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch , map.get(ch)-1);
                }
            }
            else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String args[]){
        /*HashMap<String , Integer> hm = new HashMap<>();
        hm.put("india", 100);
        hm.put("china", 115);
        hm.put("us", 50);

        System.out.println(hm);
        //hm.clear();
        //System.out.println(hm.get("us"));
        //System.out.println(hm.remove("china"));
        //System.out.println(hm);
        Set<String> s = hm.keySet();
        System.out.println(s);
        for (String s1 : s) {
            System.out.println(s1 + " ," + hm.get(s1));
            
        }*/

        /*int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer , Integer> freq = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(freq.containsKey(num)){
                freq.put(num , freq.get(num)+1);
            }
            else{
                freq.put(num , 1);
            }
        }
        Set<Integer> s = freq.keySet();
        for(Integer i : s){
            if(freq.get(i)>arr.length/3){
                System.out.println(i);
            }
        }*/

        //System.out.println(isanagram("earth", "heart"));

        /*HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        //System.out.print(hs);
        Iterator it = hs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(Integer i : hs){
            System.out.println(i);
        }*/

        //intersection

        int arr1[] = {1,2,3,4,5};
        int arr2[] = {2,5,6,7,8};
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);

        }
        for(int i=0;i<arr2.length;i++){
            if(hs.contains(arr2[i])){
                System.out.print(arr2[i] + " ");
                hs.remove(arr2[i]);
            }
        }

    }
}
