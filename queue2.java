import java.util.*;
public class queue2 {

    static class stack{
        Deque<Integer> d = new LinkedList<>();

        public void push(int data){
            d.addLast(data);
        }
        public int pop(){
            return d.removeLast();

        }
        public int peek(){
            return d.getLast();
        }
    }
    public static void firstnonrepeating(String str){
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);
            while( !q.isEmpty() && freq[q.peek() - 'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(q.peek()+ " ");
            }
            

        }
        System.out.println();
        System.out.println();
    }

    public static void interleave(Queue<Integer> q){
        Queue<Integer> q2 = new LinkedList<>();
        int size = q.size();
        
        for(int i = 0;i<size/2;i++){
            q2.add(q.remove());
            

        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());

        }
    }
    
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void reversek(Queue<Integer> q , int k){
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<k;i++){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        for(int i=0;i<q.size()-k;i++){
            q.add(q.remove());
        }
    }
    public static void sliding(int arr[] , int k){
        for(int i=0;i<arr.length-k+1;i++){
            int max = arr[i];
            for(int j=i;j<i+k;j++){
                max = Math.max(max , arr[j]);


            }
            System.out.print(max+ " ");
        }
    }
    public static void slidingwindow(int arr[] , int k){
        Deque<Integer> q = new LinkedList<>();
        int i=0;
        for(;i<k;i++){
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for(;i<arr.length;i++){
            System.out.print(arr[q.peek()] + " ");
            while(!q.isEmpty() && arr[q.peekLast()]<=arr[i]){
                q.removeLast();
            }
            q.addLast(i);
            
        }
        System.out.print(arr[q.peek()]);
    }
    public static void lexio(int n , int k){
        char ch[] = new char[n];
        Arrays.fill(ch , 'a');
        k -= n;
        while(k>0){
            ch[n-1] += Math.min(25 , k);
            k-= Math.min(25 , k);
            n--;
        }
        System.out.println(String.valueOf(ch));
    }
    public static void generatebinary(int n){
        Queue<String> q= new LinkedList<>();
        q.add("1");
        while(n-->0){
            String s1= q.peek();
            q.remove();
            System.out.println(s1);
            String s2= s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
    }
    public static void main(String args[]){
        String str = "aabccxb";
        firstnonrepeating(str);

        Queue<Integer> q = new LinkedList<>();
        //for(int i=1;i<=10;i++){
        //    q.add(i);
        //}
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);


        
        
        //interleave(q);
        /*reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }*/
        /*reversek(q,5);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }*/
        /*System.out.println();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        sliding(arr, 4);
        System.out.println();
        slidingwindow(arr , 4);*/
        generatebinary(5);


    }
}
