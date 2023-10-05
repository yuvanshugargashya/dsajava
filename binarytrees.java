import java.util.*;

public class binarytrees {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*static class Binarytree {
        *
        static int idx = -1;*

       public static Node buildtree(int node[]){
     * 
     * idx++;
     * if(node[idx] == -1){
     * return null;
     * }
     * Node newnode = new Node(node[idx]);
     * 
     * newnode.left = buildtree(node);
     * newnode.right = buildtree(node);
     * 
     * return newnode;
     * }**

       public static void preorder(Node root){
     * 
     * if(root == null){
     * //System.out.print(-1+" ");
     * return;
     * }
     * System.out.print(root.data + " ");
     * preorder(root.left);
     * preorder(root.right);
     * }*

       public static void inorder(Node root){
     * 
     * if(root == null){
     * //System.out.print(-1+" ");
     * return;
     * }
     * 
     * inorder(root.left);
     * System.out.print(root.data + " ");
     * inorder(root.right);
     * }*

       public static void postorder(Node root){
     * 
     * if(root == null){
     * //System.out.print(-1+" ");
     * return;
     * }
     * 
     * postorder(root.left);
     * 
     * postorder(root.right);
     * System.out.print(root.data + " ");
     * }*

       public static void levelorder(Node root){
     * if(root == null){
     * return;
     * }
     * Queue<Node> q = new LinkedList<>();
     * q.add(root);
     * q.add(null);
     * while(!q.isEmpty()){
     * Node curr = q.remove();
     * if(curr == null){
     * System.out.println();
     * if(q.isEmpty()){
     * break;
     * }
     * else{
     * q.add(null);
     * }
     * }
     * else{
     * System.out.print(curr.data + " ");
     * if(curr.left != null){
     * q.add(curr.left);
     * }
     * if(curr.right != null){
     * q.add(curr.right);
     * }
     * }
     * }
     * 
     * 
     * }*

       public static int height(Node root){
     * if(root == null){
     * return 0;
     * }
     * 
     * int lh = height(root.left);
     * int rh = height(root.left);
     * 
     * return Math.max(lh , rh) +1;
     * }*
    }*/

    

    /*public static int height1(Node root){
     * if(root == null){
     * return 0;
     * }
     * 
     * int lh = height1(root.left);
     * int rh = height1(root.right);
     * 
     * return Math.max(lh , rh) +1;
     * }*

    public static int count(Node root){
     * if(root == null){
     * return 0;
     * }
     * 
     * int lh = count(root.left);
     * int rh = count(root.right);
     * 
     * return lh + rh +1;
     * }*

    public static int sum(Node root){
     * if(root == null){
     * return 0;
     * }
     * 
     * int ls = sum(root.left);
     * int rs = sum(root.right);
     * 
     * return ls + rs + root.data;
     * }**

    public static int diameter(Node root){
     * if(root == null){
     * return 0;
     * }
     * int leftdia = diameter(root.left);
     * int lefth = height1(root.left);
     * int rightdia = diameter(root.right);
     * int righth = height1(root.right);
     * 
     * int selfdia = lefth + righth +1 ;
     * 
     * return Math.max(selfdia ,Math.max(leftdia , rightdia)) ;
     * }*

    static class info {
        *
        int diam;*
        int ht;*

       public info(int d , int h){
     * this.diam = d;
     * this.ht = h;
     * }*
    }**

    public static info diameter2(Node root){
     * if(root == null){
     * return new info(0,0);
     * 
     * }
     * info leftinfo = diameter2(root.left);
     * info rightinfo= diameter2(root.right);
     * 
     * int dia = Math.max(Math.max(leftinfo.diam , rightinfo.diam) , leftinfo.ht +
     * rightinfo.ht+1);
     * int ht = Math.max(leftinfo.ht , rightinfo.ht) +1;
     * 
     * return new info(dia , ht);
     * 
     * }

    public static boolean isidentical(Node root , Node subroot){
     * if(root == null && subroot == null){
     * return true;
     * }
     * else if(root == null || subroot == null || root.data != subroot.data){
     * return false;
     * }
     * if(!isidentical(root.left, subroot.left)){
     * return false;
     * }
     * if(!isidentical(root.right, subroot.right)){
     * return false;
     * }
     * 
     * return true;
     * }**

    public static boolean issubtree(Node root , Node subroot){
     * if(root == null){
     * return false;
     * }
     * if(root.data== subroot.data){
     * if(isidentical(root , subroot)){
     * return true;
     * }
     * }
     * 
     * return issubtree(root.left, subroot) || issubtree(root.right, subroot);
     * }*/

    static class infoo {
        Node node;
        int hd;

        public infoo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root) {
        Queue<infoo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new infoo(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            infoo curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);//
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new infoo(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new infoo(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }

            }

        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data);
        }

    }
    public static void bottomview(Node root){
        Queue<infoo> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min=0,max=0;
        q.add(new infoo(root , 0));
        q.add(null);
        while(!q.isEmpty()){
            infoo curr = q.remove();
            if(curr ==null){
                if(q.isEmpty()){
                    break;

                }
                else{
                    q.add(null);

                }
                
            }
            else{
                map.put(curr.hd , curr.node);
                if (curr.node.left != null) {
                    q.add(new infoo(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new infoo(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
            
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data);
        }

    }
    public static void leftviewutil(Node root , ArrayList<Node> list , int level){
        if(root==null){
            return;
        }
        if(list.size()<=level){
            list.add(level , root);
        }
        else{
            if(list.get(level)==null){
                list.add(root);
            }
        }
        
        
        leftviewutil(root.left,list,level+1);
        leftviewutil(root.right, list,level+1);
        //for right swap left , rightcall
        
    }
    public static void leftview(Node root){
        ArrayList<Node> list = new ArrayList<>();
        leftviewutil(root , list , 0);
        for(Node n : list){
            System.out.print(n.data+ " ");
        }
    }

    public static void kthlevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        kthlevel(root.left, level + 1, k);
        kthlevel(root.right, level + 1, k);
    }

    public static boolean getpath(Node root, ArrayList<Node> list, int n) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundleft = getpath(root.left, list, n);
        boolean foundright = getpath(root.right, list, n);
        if (foundleft || foundright) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;

    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getpath(root, path1, n1);
        getpath(root, path2, n2);
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if (root == null) {
            return root;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static int lcadist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        } else if (leftdist == -1) {
            return rightdist + 1;
        } else {
            return leftdist + 1;
        }

    }

    public static int mindistance(Node root, int n1, int n2) {

        Node lca = lca2(root, n1, n2);
        int dist1 = lcadist(lca, n1);
        int dist2 = lcadist(lca, n2);
        return dist1 + dist2;

    }

    public static int kthancestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdist = kthancestor(root.left, n, k);
        int rightdist = kthancestor(root.right, n, k);
        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }
        int max = Math.max(leftdist, rightdist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static int sumtree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftchild = sumtree(root.left);
        int rightchild = sumtree(root.right);
        int data = root.data;

        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = newleft + leftchild + newright + rightchild;
        return data;
    }

    public static void preorder(Node root) {

        if (root == null) {
            // System.out.print(-1+" ");
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    static HashMap<String , Integer> map= new HashMap<>();

    public static String findduplicate(Node root){
        if(root==null){
            return "";
        }
        String str = "(";
        str += findduplicate(root.left);
        str+= Integer.toString(root.data);
        str += findduplicate(root.right);
        str+= ")";

        if(map.get(str) != null && map.get(str)==1){
            System.out.println(root.data);
        }
        map.put(str , map.getOrDefault(str ,0)+1);

        return str;


        
    }
    static int max= Integer.MIN_VALUE;
    public static int maxpathsum(Node root){
        if(root==null){
            return 0;
        }
        int ls= maxpathsum(root.left);
        int rs = maxpathsum(root.right);

        int onpath = Math.max(Math.max(ls,rs)+root.data , root.data);
        int isrootofmax = Math.max(onpath , ls+rs+root.data);
        max = Math.max(max , isrootofmax);
        return onpath;

    }

    public static void main(String args[]) {
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        //// Binarytree tree = new Binarytree();
        // Node root = tree.buildtree(nodes);
        // System.out.println(root.data);
        Node root1 = new Node(1);

        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        /*
         * Node subroot = new Node(2);
         * subroot.left = new Node(4);
         * subroot.right = new Node(5);
         */

        /*
         * tree.preorder(root);
         * System.out.println();
         * tree.inorder(root);
         * System.out.println();
         * tree.postorder(root);
         * System.out.println();
         * tree.levelorder(root);
         */

        // System.out.println(tree.height(root));
        // System.out.println(height1(root1));
        // System.out.println(count(root1));
        // System.out.println(sum(root1));
        // System.out.println(diameter(root1));
        // System.out.println(diameter2(root1).diam);
        /*
         * System.out.println(issubtree(root1, subroot));
         * HashMap<String , Integer> map = new HashMap<>();
         * map.put("india", 100);
         * System.out.println(map);
         * System.out.println(map.get("india"));
         */

         /*topview(root1);
         System.out.println();
         bottomview(root1);
         System.out.println();
         leftview(root1);*/
        // kthlevel(root1, 1, 3);
        // System.out.println(lca(root1, 4, 5).data);
        // System.out.println(lca2(root1, 4, 5).data);
        // System.out.println(mindistance(root1, 4, 5));
        // kthancestor(root1, 5, 1);
        //sumtree(root1);
        //preorder(root1);
        //Node root = null;root = new Node(1);root.left = new Node(2);root.right = new Node(3);root.left.left = new Node(4);root.right.left = new Node(2);root.right.left.left = new Node(4);root.right.right = new Node(4);
        //findduplicate(root);
        maxpathsum(root1);
        System.out.println(max);
    }

}
