import java.sql.Array;
import java.util.*;
public class heapspriorityqueue {
    /*static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name , int rank){
            this.name= name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank;
        }

    }*/
    static class heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){

            arr.add(data);
            int child = arr.size()-1;
            int parent = (child - 1)/2;

            while(arr.get(child)<arr.get(parent)){
            int temp = arr.get(child);
            arr.set(child , arr.get(parent));
            arr.set(parent, temp);
            
            
            child = parent;
            parent = (child-1)/2;
            }

        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
            int left = 2*i +1;
            int right = 2*i+2;
            int min = i;

            if(left <arr.size() && arr.get(left)<arr.get(min)){
                min = left;
            }
            if(right <arr.size() && arr.get(right)<arr.get(min)){
                min = right;
            }

            if(min != i){
                int temp = arr.get(i);
                
                arr.set(i , arr.get(min));
                arr.set(min , temp);

                heapify(min);
            }
        }
        public int Remove(){
            int data = arr.get(0);
            int temp = arr.get(0);
        
            
            arr.set(0 , arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);
            arr.remove(arr.size()-1);
            heapify(0);
            return data;

        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
        
    }
    public static void heapify1(int arr[] , int i, int size){
        int left = 2*i +1;
        int right = 2*i +2;
        int max = i;

        if(left<size && arr[left]>arr[max]){
            max = left;
        }
        if(right<size && arr[right]>arr[max]){
            max = right;
        }
        if(max != i){
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            heapify1(arr, max, size);
        }

    }


    public static void heapsort(int arr[]){
        int n = arr.length;
        for(int i = n/2;i>=0;i--){
            heapify1(arr , i , n);

        }
        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify1(arr , 0 , i);

        }
    }
    static class soldiers implements Comparable<soldiers>{
        int count ;
        int row;
        public soldiers(int cout , int row){
            this.count = cout;
            this.row = row;
        }

        @Override
        public int compareTo(soldiers s2){
            if(this.count ==  s2.count){
                return this.row - s2.row;
            }
            else{
                return this.count - s2.count;
            }
            
        }

        
    }

    static class pair implements Comparable<pair>{
        int val;
        int idx;
        public pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p2){
            return p2.val - this.val;
        }
    }
    public static class car implements Comparable<car>{
        int idx;
        int dist;
        public car(int i , int d){
            this.idx = i;
            this.dist = d;
        }

        @Override
        public int compareTo(car c2){
            return this.dist-c2.dist;
        }
    }

    public static ArrayList<Integer> kthlargest(int arr[] , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer>  ans = new ArrayList<>();
        for(int val : arr){
            if(pq.size()<k){
                pq.add(val);
            }
            else{
                if(val > pq.peek()){
                    pq.remove();
                    pq.add(val);
                }
            }
            if(pq.size()>=k){
            ans.add(pq.peek());
            }
            else{
                ans.add(-1);
            }
            
        }
        return ans;
        

    }
    
    public static void main(String args[]){
        /*PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("a" , 4));
        pq.add(new Student("b" , 2));
        pq.add(new Student("c" , 7));
        pq.add(new Student("d" , 1));
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " " + pq.peek().rank);
            pq.remove();
        }*/

        /*heap h = new heap();
        h.add(1);
        h.add(4);
        h.add(2);
        h.add(5);
        h.add(3);
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.Remove();
        }*/

        /*int arr[] = {1,2,4,5,3};
        heapsort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }*/

        //min cost ropes
        /*int arr[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost = 0;
        while(pq.size()>1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost+= min1+min2;
            pq.add(min1+min2);
        }
        System.out.println(cost);*/

        //weakest soldier
        /*int army[][] ={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int k =2;

        PriorityQueue<soldiers> pq = new PriorityQueue<>();

        for(int i=0;i<army.length;i++){
            int count = 0;
            for(int j=0;j<army[0].length;j++){
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new soldiers(count, i));
        }
        for(int i=1;i<=k;i++){
            System.out.println(pq.remove().row);
        }*/

        /*int arr[] = {1,3,-1,-3,5,3,6,7};
        int k =3;
        int resultarray[] = new int[arr.length-k+1];

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.add(new pair(arr[i], i));

        }
        resultarray[0] = pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();

            }
            pq.add(new pair(arr[i], i));
            resultarray[i-k+1] = pq.peek().val;
        }

        for(int i=0;i<resultarray.length;i++){
            System.out.print(resultarray[i] + " ");
        }*/
        /*int cars[][] = {{3,3},{0,0},{-2,4}};

        PriorityQueue<car> p = new PriorityQueue<>();
        for(int i=0;i<cars.length;i++){
            p.add(new car(i , cars[i][1]*cars[i][1]+cars[i][0]*cars[i][0]));
        }
        System.out.println(p.remove().idx);*/
        int arr[] = {1,2,3,4,5,6};
        ArrayList<Integer> iss = kthlargest(arr, 3);
        for(int val:iss){
            System.out.print(val + " ");
        }



    }
    
}
