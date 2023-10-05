public class linkedlist {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addfirst(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            size++;
            return;
        }
        newnode.next = head;
        head = newnode;
        size++;

    }
    public void addlast(int data){
        Node newnode = new Node(data);
        if(head == null){
            head = tail = newnode;
            size++;
            return;
        }
        tail.next = newnode;
        tail = newnode;
        size++;
    }
    public void addmiddle(int data  , int idx){
        int i =0;
        Node newnode = new Node(data);
        Node temp = head;
        while(i<idx-1){
            temp = temp.next;
            i++;

        }
        newnode.next = temp.next;
        temp.next = newnode;
        size++;
    }
    public void removefirst(){
        head = head.next;
        size--;
    }
    public void removelast(){
        Node temp = head;
        for(int i=0;i<size-2;i++){
            temp = temp.next;

        }
        temp.next = null;
        tail= temp;
        size--;
    }
    
    

    public void printll(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }

    }
    public boolean search(int key){
        Node temp = head;
        while(temp != null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int helper(Node head , int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next ,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }
    public int recursivesearch(int key){
        return helper(head , key);

    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        head = prev;
    }
    public void nfromend(int n){
        int sz=0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        Node hh = head;
        for(int i=1;i<sz-n;i++){
            hh= hh.next;

        }
        hh.next = hh.next.next;
    }
    public Node findmid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkpallindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node midnode = findmid(head);
        Node prev = null;
        Node curr = midnode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean iscycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public void removecycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null  & fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;

    }
    public Node merge(Node head1 , Node head2){
        Node mergell = new Node(-1);
        Node temp = mergell;
        while(head1 != null && head2!= null){
            if(head1.data<head2.data){
                temp.next = head1;
                head1= head1.next;
                temp  =temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergell.next;
    }
    public Node findmid2(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergesort(Node head){
        if(head == null || head.next== null){
            return head;
        }
        Node mid = findmid2(head);
        Node righthead = mid.next;
        mid.next = null;

        Node newlefthead = mergesort(head);
        Node newrighthead = mergesort(righthead);

        return merge(newlefthead , newrighthead);
    }
    public void zigzag(){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node curr = mid.next;
        mid.next  = null;
        Node prev = null;
        
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        Node lhead = head;
        Node rhead = prev;
        Node nextl , nextr;
        while(lhead != null && rhead != null){
            nextl = lhead.next;
            lhead.next = rhead;
            nextr = rhead.next;
            rhead.next = nextl;

            lhead =nextl;
            rhead  = nextr;

        }
                

    }
    public static Node deleten(Node head , int m , int n){
        Node temp = head;
        
        while(temp != null){
            int i = 1;
        while(i<m){
            temp = temp.next;
            i++;
        }
        int ni = 1;
        Node temp2 = temp;
        while(ni<=n){
            temp2 = temp2.next;
            ni++;

        }
        temp.next = temp2.next;
        temp2 = temp2.next;
        temp = temp2;
    }
        return head;
    }
    public static void printll2(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
    public static void swap(Node head , int k1 , int k2){
        /*if(k1==k2){
            return;
        }*/
        Node temp1 = head;
        Node temp2 = head;
        int idx1 = 1 , idx2 = 1;
        while(idx1<k1-1){
            temp1  =temp1.next;
            idx1++;
        }
        Node temp3 = temp1.next;
        
        Node temp5 = temp1.next.next;

        while(idx2<k2-1){
            temp2 = temp2.next;
            idx2++;
        }
        Node temp4 = temp2.next;
        Node temp6 = temp2.next.next;
        if(k2 != k1+1){
        temp1.next  = temp4;
        temp1.next.next = temp5;
        temp2.next = temp3;
        temp2.next.next = temp6;
    }
    else{
        temp1.next = temp4;
        temp1.next.next = temp2;
        temp1.next.next.next = temp6;
    }
        

    }
    public static Node odd(Node head){
        Node even = new Node(-1);
        Node odd = new Node(-1);
        Node temp = head;
        Node temp1= even;
        Node temp2 = odd;
        while(temp != null){
            if((temp.data)%2==0){
                temp1.next = temp;
                temp = temp.next;
                temp1 = temp1.next;
                
            }
            else{
                temp2.next = temp;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        temp2.next = null;
        temp1.next = odd.next;
        return even.next;

    }
    public static void main(String args[]){
        linkedlist ll = new linkedlist();
        //ll.head = new Node(1);
        //ll.head.next = new Node(2);
        ll.addfirst(1);
        ll.addfirst(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);

        /*ll.addmiddle(6,2);
        ll.removefirst();
        ll.removelast();
        System.out.println(ll.size);
        ll.printll();
        System.out.println();
        System.out.print(ll.head.next.next.data);
        //System.out.println(ll.search(3));
        //System.out.println(ll.recursivesearch(3));
        ll.reverse();
        ll.printll();*/
        //ll.nfromend(2);
        //ll.printll();
        //System.out.println(ll.checkpallindrome());
        //tail.next = head.next.next;
        //System.out.println(ll.iscycle());
        //ll.removecycle();
        //ll.printll();
        /*ll.head = ll.mergesort(ll.head);
        ll.printll();
        ll.zigzag();
        System.out.println();
        ll.printll();*/

        Node nh = new Node(1);
        nh.next = new Node(2);
        nh.next.next = new Node(3);
        nh.next.next.next = new Node(4);
        nh.next.next.next.next = new Node(5);
        nh.next.next.next.next.next = new Node(6);
        nh.next.next.next.next.next.next = new Node(7);
        nh.next.next.next.next.next.next.next = new Node(8);
        nh.next.next.next.next.next.next.next.next = new Node(9);
        nh.next.next.next.next.next.next.next.next.next = new Node(10);
        //deleten(nh, 3, 2);
        printll2(nh);
        System.out.println();

        //swap(nh ,4,4);
        
        Node nll = odd(nh);
        printll2(nll);
        
        


    }
    
}
