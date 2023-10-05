//import java.util.*;
public class linkedlist2 {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addfirst(int data){
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;

        }
    }
    public static void main(String args[]){
        /*LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(2);
        System.out.println(ll);*/
        linkedlist2 ll2 = new linkedlist2();
        ll2.addfirst(1);
        ll2.addfirst(2);
        ll2.addfirst(3);
        System.out.println(ll2.head.next.prev.data);
        ll2.print();

    }
    
}
