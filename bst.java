import java.util.*;
public class bst {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root  , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }
        else{
            root.right = insert(root.right , val);
        }

        return root;

    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left , key);
        }
        else{
            return search(root.right , key);
        }

    }
    public static Node delete(Node root , int val){
        if(root.data<val){
            root.right = delete(root.right , val);
        }
        else if(root.data>val){
            root.left = delete(root.left , val);
        }
        else{
            if(root.right == null && root.left==null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            Node IS = inordersuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right , IS.data);

        }
        return root;
    }
    public static Node inordersuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void printinrange(Node root , int k1 , int k2){
        if(root == null){
            return;
        }
        if(root.data >=k1 && root.data<=k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinrange(root.right, k1, k2);
        }
        else if(root.data >k2){
            printinrange(root.left, k1, k2);
        }
        else{
            printinrange(root.right, k1, k2);
        }
    }
    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i));
        }
        System.out.println();
    }

    public static void path2leaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right == null){
            printpath(path);
        }
        path2leaf(root.left, path);
        path2leaf(root.right, path);
        path.remove(path.size()-1);
    }
    public static boolean isvalidate(Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(max!= null && root.data>=max.data){
            return false;
        }
        else if(min != null && root.data<=min.data){
            return false;
        }

        return isvalidate(root.left, min, root) && isvalidate(root.right, root, max);

    }
    public static Node mirror(Node root){
        if(root == null){
            return null;
        }
        Node leftsub = mirror(root.left);
        Node rightsub= mirror(root.right);
        root.left = rightsub;
        root.right = leftsub;
        return root;
    }
    public static Node createbstfromsortedarray(int arr[] , int start , int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createbstfromsortedarray(arr, start, mid-1);
        root.right = createbstfromsortedarray(arr, mid+1, end);

        return root;
    }

    static class isbstinfo{
        boolean isbst;
        int size;
        int min;
        int max;

        public isbstinfo(boolean isbst , int size , int min , int max){
            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxbst = 0;
    public static Node maxbstroot = null;
    public static isbstinfo largerstbst(Node root){
        if(root == null){
            return new isbstinfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        isbstinfo leftinfo = largerstbst(root.left);
        isbstinfo rightinfo = largerstbst(root.right);
        int size = leftinfo.size + rightinfo.size +1;
        int min = Math.min(root.data , Math.min(leftinfo.min , rightinfo.min));
        int max = Math.max(root.data , Math.max(leftinfo.max , rightinfo.max));  

        if(root.data <= leftinfo.max || root.data >= rightinfo.min){
            return new isbstinfo(false, size, min, max);
        }
        if(leftinfo.isbst && rightinfo.isbst){
            if(size>maxbst){
            maxbst = Math.max(size , maxbst);
            maxbstroot = root;

            }
            
            return new isbstinfo(true, size, min, max);
        }

        return new isbstinfo(false, size, min, max);

    }
    public static void main(String args[]){
        /*int values[] = {8,5,3,1,4,6,10,11,14};
        Node root= null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }

        inorder(root);
        //System.out.println(search(root , 7));
        //delete(root, 8);
        //inorder(root);
        System.out.println();
        //printinrange(root, 9, 12);
        //ArrayList<Integer> path = new ArrayList<>();
        //path2leaf(root, path);
        //System.out.println(isvalidate(root, null, null));
        mirror(root);
        inorder(root);

        int arr[] = {3,5,6,8,10,11,12};
        Node root = createbstfromsortedarray(arr, 0, arr.length-1);
        inorder(root);*/
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right= new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right= new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);



        isbstinfo infooo = largerstbst(root);
        System.out.println(maxbst);
        inorder(maxbstroot);

    }
    
}
