import java.util.*;

public class quesarr {
    public static void all(int arr[] , int i,int key){
        if(i==arr.length){
            return;
        }
        if(arr[i] == key){
            System.out.print(i + " ");
        }
        all(arr,i+1,key);
    }
    public static void sub(int n , String src , String help , String dest){
        if(n==1){
            System.out.println("transfer from"+ src + "to" + dest);
            return;
        }
        sub(n-1 , src, dest  , help);
        System.out.println("transfer n from" + src + "to"+ dest);
        sub(n-1 , help , src , dest);
        

    }
    public static boolean issafe(int arr[][] , int x , int y){
        if(x>=0 && x<arr.length && y>=0 && y<arr.length && arr[x][y]==1){
            return true;
        }
        return false;
    }
    public static boolean mazeutil(int arr[][] , int x , int y , int sol[][]){
        if(x==arr.length-1 && y==arr.length-1 && arr[x][y]==1 ){
            sol[x][y] =1;
            return true;
        }
        if(issafe(arr, x, y)){
            sol[x][y] = 1;
            if(mazeutil(arr, x+1 , y ,sol)){
                return true;
            }
            if(mazeutil(arr, x,y+1,sol)){
                return true;
            }
            

            
            sol[x][y]=0;
            return false;
        
        }
        return false;
    }
    public static boolean maze(int arr[][]){
        int sol[][] = new int[arr.length][arr.length];

        if(!mazeutil(arr , 0,0,sol)){
            System.out.println("not exist");
            return false;
        }
        print(sol);
        return true;

    }
    public static void print(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void lonely(ArrayList<Integer> list){
        Collections.sort(list);
        if(list.get(0)+1 != list.get(1) && list.get(0) != list.get(1)){
            System.out.println(list.get(0));
        }
        if(list.get(list.size()-1)-1 != list.get(list.size()-2) && list.get(list.size()-1) != list.get(list.size()-2)){
            System.out.println(list.get(list.size()-1));
        }
        for(int i=1;i<list.size()-1;i++){
            if(list.get(i)!=list.get(i+1) && list.get(i)+1 != list.get(i+1) && list.get(i-1)+1 != list.get(i)){
                System.out.println(list.get(i));
            }
        }

    }

    public static void follow(ArrayList<Integer> list , int key){
        Integer num[] = new Integer[300];
        Arrays.fill(num , 0);
        List<Integer> ans = Arrays.asList(num);
        for(int i=0;i<list.size()-1;i++ ){
            if(list.get(i)==key){
                ans.set(list.get(i+1) , ans.get(list.get(i+1))+1);
            }

        }
         
        int anss = 0;
        int max = 0;
        for(int i=0;i<ans.size()-1;i++){
            if(ans.get(i)>max){
                max = ans.get(i);
                anss= i;
            }

        }
        System.out.println(anss);
    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        follow(list, 2);
   
    }
    
}

