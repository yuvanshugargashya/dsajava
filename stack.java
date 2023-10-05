import java.util.*;
public class stack {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class stack1{
        static Node head = null;

        public static boolean isempty(){
            return head == null;
        }
        public static void push(int data){
            Node newnode = new Node(data);
            if(isempty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }
        public static int pop(){
            if(isempty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;

        }
        public static int peek(){
            if(isempty()){
                return -1;
            }
            return head.data;
        }
        public static void pushatbottom(stack1 st , int val){
            if(st.isempty()){
                st.push(val);
                return;
            }
            int top = head.data;
            st.pop();
            pushatbottom(st , val);
            st.push(top);

        }
        public static void reversestack(stack1 st){
            if(isempty()){
                return;
            }
            int top = st.pop();
            reversestack(st);
            pushatbottom(st, top);

        }
        public static void reversestring(String str , stack1 st){
            for(int i=0;i<str.length();i++){
                st.push(str.charAt(i));
            }
            while(!st.isempty()){
                System.out.print((char)st.peek());
                st.pop();

            }

        }
        /*static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isempty(){
            if(list.size() == 0){
                //System.out.println("emoty");
                return true;
            }
            //System.out.println("not empty");
            return false;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;

        }
        public static int peek(){
            return list.get(list.size()-1);
        }*/

    }
    public static void main(String args[]){
        //stack1 st = new stack1();
        //st.push(1);
        //st.push(2);
        //st.push(3);
        //System.out.println(st.peek());
        //st.pop();
        //System.out.println(st.peek());
        //st.isempty();
        /*while(!st.isempty()) {
            System.out.println(st.peek());
            st.pop();
            
        } ;
        /*do{
            System.out.println(st.peek());
        }while(!st.isempty());*/
        /*st.pushatbottom(st, 4);
        while(!st.isempty()) {
            System.out.println(st.peek());
            st.pop();
            
        } ;*/
        //stack1 st1 = new stack1();
        //st1.reversestring("abc", st1);
        stack1 st = new stack1();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.reversestack(st);
        while(!st.isempty()){
            System.out.println(st.peek());
            st.pop();
        }
        
        



            

        
        
        

    }
    
}
