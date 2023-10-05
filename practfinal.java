import java.util.*;



public class practfinal {
   /*  public static int knap(int p[] , int w[] , int wt , int n){

        int dp[][] = new int[n+1][wt+1];

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(w[i-1]<=j){
                    dp[i][j] = Math.max(p[i-1] + dp[i-1][j-w[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][wt];
    }
    public static int edit(String s1 , String s2){
        int dp[][] = new int [s1.length()][s2.length()];
        for(int i=1;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<dp.length;i++){
            dp[0][1] = i;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp.length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1] +1;
                    int delete = dp[i-1][j]+1;
                    int rep = dp[i-1][j-1]+1;
                }
            }
        }
    }*/
   

    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void bfs(ArrayList<edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr =q.remove();
            if(!vis[curr]){
                System.out.print(curr);
                vis[curr]=true;
            }
            for(int i=0;i<graph[curr].size();i++){
                edge e = graph[curr].get(i);
                q.add(e.dest);
            }

        }
    }
    public static void dfs(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsutil(graph , i , vis);
            }
        }

    }
    public static void dfsutil(ArrayList<edge> graph[] , int curr , boolean vis[]){
        System.out.print(curr);
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph, e.dest, vis);
            }
        }
    }

    public static boolean cycle(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(cycleutil(graph , vis , i ,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleutil(ArrayList<edge> graph[] , boolean vis[], int curr, int parent){
        
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest] && cycleutil(graph , vis , e.dest ,curr)){
                return true;
            }
            else if(vis[e.dest] && e.dest != parent){
                return true;
            }
        }
        return false;
    }
    static class interval{
        int start;
        int end;
        public interval(int s,int e){
            this.start=s;
            this.end=e;
        }
    }
    public static void over(int arr[][]){
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        Stack<interval> s = new Stack<>();
        s.push(new interval(arr[0][0], arr[0][1]));
        for(int i=1;i<arr.length;i++){
            interval in =s.peek();
            if(in.end >= arr[i][0]){
                int last = Math.max(in.end , arr[i][1]);
                s.pop();
                s.push(new interval(in.start, last));

            }
            else{
                s.push(new interval(arr[i][0], arr[i][1]));
            }
            

        }
        while(!s.isEmpty()){
            interval i = s.peek();
            System.out.println(i.start + " " + i.end);
            s.pop();
        }
    }
    public static int min(int arr[] , int s,int e){
        if(s>=e){
            return 0;
        }
        if(arr[s]==arr[e]){
            return min(arr,s+1,e-1);
        }
        else{
            return min(arr,s+1,e-1) +1;
        }
    }
    public static int merge(int arr[]){
        int s=0;
        int e=arr.length-1;
        int ans =0;
        while(s<=e){
            if(arr[s]==arr[e]){
                s++;
                e--;
            }
            else if(arr[s]<arr[e]){
                s++;
                arr[s] += arr[s-1];
                ans++;
            }
            else{
                e--;
                arr[e]+=arr[e+1];
                ans++;
            }
        }
        return ans;
    }
    public static void rep(int arr[]){
        HashMap<Integer , Integer> map = new HashMap<>();
        int ans[] = new int[2];
        int t=0;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i] , map.getOrDefault(arr[i], 0)+1);

        }
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])>1){
                
                System.out.println("repeat is" + arr[i]);
            
                
            }
            if(!map.containsKey(i) && i !=0){
                
                System.out.println("missing is"+ i);
            
            }
        }
        
    }
    public static void addedge(ArrayList<Integer> graph[] , int u,int v){
        graph[u].add(v);
        graph[v].add(u);
    }
    public static boolean cyclee(ArrayList<Integer> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(cycleutil(graph,vis,i)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean cycleutil(ArrayList<Integer> graph[] , boolean vis[] , int curr){
        int parent[] = new int[graph.length];
        Arrays.fill(parent,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        while(!q.isEmpty()){
            int ele= q.remove();
            
                for(int i=0;i<graph[ele].size();i++){
                    int j = graph[ele].get(i);
                    if(!vis[j]){
                        vis[j]=true;
                        parent[j] = ele;
                        q.add(j);
                    }
                    else if(parent[ele] != j){
                        return true;
                    }
                }
            

        }
        return false;
    }
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data = d;
            this.left= this.right=null;
        }
    }
    public static int mindepth(Node root){
        if(root==null){
            return 0;
        }
        if(root.left ==null && root.right==null){
            return 1;
        }
        if(root.left==null){
            return mindepth(root.right)+1;
        }
        if(root.right ==null){
            return mindepth(root.left)+1;
        }
        return Math.min(mindepth(root.right) ,mindepth(root.left)) +1;

    }
    public static boolean issafe(int arr[][], int i , int j){
        if(i>=0 && i<arr.length && j>=0 && j<arr[0].length){
            return true;
        }
        return false;
    }
    public static int mintime(int arr[][]){
        boolean changed =false;
        int time=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                if(issafe(arr, i+1, j) && arr[i+1][j] == 1){
                    arr[i+1][j]=2;
                    changed = true;

                }
                if(issafe(arr, i, j+1) && arr[i][j+1] == 1){
                    arr[i][j+1]=2;
                    changed = true;

                }
                if(issafe(arr, i-1, j) && arr[i-1][j] == 1){
                    arr[i-1][j]=2;
                    changed = true;

                }
                if(issafe(arr, i, j-1) && arr[i][j-1] == 1){
                    arr[i][j-1]=2;
                    changed = true;

                }
               
            }
                

            }
             
                if(changed==true){
                changed = false;
                time++;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    System.out.println("can not rot all");
                    return -1;
                }
            }
        }
        return time;


    }
    static int count;
    public static boolean issafe(int i , int j ,int arr[][] , boolean vis[][]){
        return (i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]==1 && !vis[i][j]);
    }
    public static void larestregion(int arr[][]){
        boolean vis[][] = new boolean[arr.length][arr[0].length];
        int res =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!vis[i][j] && arr[i][j]==1){
                    count =1;
                    dfss(arr, vis, i,j);

                    res = Math.max(res,count);
                }
            }
        }
    }
    public static void dfss(int arr[][] , boolean vis[][] , int row , int col){
        int rowm[] = {};
    }

       
    
    public static void main(String args[]){
        /*ArrayList<edge> graph[] = new ArrayList[5];
        for(int i=0;i<5;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new edge(0,1,5));*/
        //int arr[][]={{6,8},{1,9},{2,4},{4,7}};
        //over(arr);
        //int arr[] = {11,14,15,99};
        //System.out.println(merge(arr));
        //int arr[] = {3,1,2,5,3};
        //rep(arr);
        /*ArrayList<Integer> graph[] = new ArrayList[5];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        addedge(graph,0,1);
        //addedge(graph, 0, 2);
        addedge(graph, 1, 2);
        addedge(graph, 2, 3);
        addedge(graph, 3, 4);
        addedge(graph, 0, 3);
        System.out.println(cyclee(graph));*/
        //Node root = new Node(1);root.left = new Node(2);root.right = new Node(3);root.left.left = new Node(4);root.left.right = new Node(5);
        //System.out.println(mindepth(root));
        int v[][] = { { 2, 1, 0, 2, 1 },
        { 2, 0, 2, 2, 2 },
        { 2, 0, 0, 2, 2} };

                      System.out.println(mintime(v));
        
        
        
        
    }
    
}
