import java.util.*;
public class queues{

    static class stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isempty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }
        public static int pop(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }

            }
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;

        }
        public static int peek(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            int top = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    
                    q2.add(top);
                }

            }
            else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    
                    q1.add(top);
                }

            }
            return top;

        }
            
        
    }
    /*static class queue{

    
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isempty(){
        return s1.isEmpty();
    }

    public static void add(int data){
        while(!s1.isEmpty()){
            int ele = s1.pop();
            s2.push(ele);
        }
        s1.push(data);
        while(!s2.isEmpty()){
            int eles = s2.pop();
            s1.push(eles);
        }
    }
    public static int remove(){
        if(isempty()){
            System.out.println("empty");
            return -1;
        }
        return s1.pop();
    }
    public static int peek(){
        if(isempty()){
            System.out.println("empty");
            return -1;
        }
        return s1.peek();
    }
    /*static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static class queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isempty(){
            return head == null && tail == null;
        }
        public static void add(int data){
            Node newnode =  new Node(data);
            if(head == null){
                head = tail = newnode;
                return;
            }
            tail.next = newnode;
            tail = newnode;

        }
        public static int remove(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            int front = head.data;
            if(tail == head){
                tail = head = null;
            }
            else{
                head = head.next;

            }
            
            return front;

        }
        public static int peek(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            return head.data;
        }
        /*static int arr[];
        static int size;
        static int rear;
        static int front;
        

        queue(int n){
            arr = new int[n];
            size  = n;
            rear = -1;
            front = -1; 
        }
        public static boolean isempty(){
            return rear == -1 && front == -1;
        }
        public static boolean isfull(){
            return (rear +1)%size ==front;
        }
        public static void add(int data){
            if(isfull() ){
                System.out.println("completlt filled");
                return;
                
            }
            if(front == -1){
                front = 0;
            }
            
            
            rear = (rear+1)%size;
            arr[rear]  = data;
        }
        public static int remove(){
            if(isempty()){
                System.out.println("no elements present");
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear= front = -1;
            }
            else{
                front = (front+1)%size;

            }
            
            
            /*for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            //rear--;
            return result;
        }
        public static int peek(){
            if(isempty()){
                System.out.println("empty hai ");
                return -1;
            }
            return arr[front];
        }*/



    public static void main(String args[]){
        /*queue q = new queue();
        //Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        //System.out.println(q.peek());
        //System.out.println(q.arr[q.rear]);
        System.out.println(q.remove());
        q.add(0);
        while(!q.isempty()){
            System.out.println(q.peek());
            q.remove();

        }*/
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isempty()){
            System.out.println(s.peek());
            s.pop();

        }
        

        



    }
}
