import java.util.*;
public class graphs {
    static class edge{
        int src;
        int dest;
        int weight;

        public edge(int s ,int d , int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void creategraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,3,7));

        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,3));

        
        graph[3].add(new edge(3,5,1));
        

        
        graph[4].add(new edge(4,5,5));
        graph[4].add(new edge(4,3,2));

        




    }
    public static void bfs(ArrayList<edge> graph[]){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr+ " ");
                vis[curr] = true;
                for(int i=0;i<graph[curr].size();i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

    }
    public static void dfs(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            
            if(!vis[i]){
            dfsutil(graph, i, vis);
        }
        }

    }



    public static void dfsutil(ArrayList<edge> graph[] , int curr , boolean vis[]){
        System.out.print(curr+ " ");
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsutil(graph , e.dest , vis);
            }
        }
    }
    public static boolean haspath(ArrayList<edge> graph[] , int src  ,int dest , boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!vis[e.dest] && haspath(graph, e.dest, dest, vis)){
                return true;
            }

        }
        return false;
    }

    public static boolean detectcycle(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectcycleutil(graph , vis , i , -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectcycleutil(ArrayList<edge> graph[] , boolean vis[] , int curr , int parent){
        vis[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest] && detectcycleutil(graph , vis , e.dest , curr)){
                return true;
            }
            else if(vis[e.dest] && e.dest != parent){
                return true;
            }
        }

        return false;
    }

    public static boolean isbarpartite(ArrayList<edge> graph[]){
        int col[] = new int[graph.length];

        for(int i=0;i<col.length;i++){
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i] ==-1){
                q.add(i);
                col[i] = 0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextcol = col[curr]== 0? 1 : 0;
                            col[e.dest] = nextcol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    public static boolean iscycle(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i =0;i<graph.length;i++){
            if(!vis[i]){
                if(iscycleutil(graph , vis , stack , i)){
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean iscycleutil(ArrayList<edge> graph[] , boolean vis[] , boolean stack[] , int curr){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && iscycleutil(graph , vis , stack , e.dest)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topsort(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topsortutil(graph , i , vis ,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.peek());
            s.pop();
        }
    }
    public static void topsortutil(ArrayList<edge> graph[] , int curr , boolean vis[] , Stack<Integer> s){
        vis[curr] = true;
        for(int i = 0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topsortutil(graph , e.dest ,vis ,s);
            }
        }
        s.push(curr);
    }

    public static void printallpath(ArrayList<edge> graph[] , int src , int dest , String path){
        if(src == dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            printallpath(graph, e.dest, dest, path+src);

        }
    }

    static class pair implements Comparable<pair>{
        int n;
        int path;
        public pair(int n , int path){
            this.n = n;
            this.path = path;
        }
        @Override

        public int compareTo(pair p2){
            return this.path - p2.path;
        }
    }


    public static void dijkastra(ArrayList<edge> graph[] , int src){
        int dist[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i  != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];

        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src , 0));
        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n] = true;
                for(int i=0;i<graph[curr.n].size();i++){
                    edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if((dist[u] + wt) < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new pair(v , dist[v]));

                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }

    }
    

    public static void bellmanford(ArrayList<edge> graph[] , int src ){
        int dist[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if( i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V= graph.length;
        for(int i=0;i<V-1;i++){
            for(int j=0;j<graph.length;j++){
                for(int k=0;k<graph[j].size();k++){
                    edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if( dist[u] != Integer.MAX_VALUE && dist[u]+ wt < dist[v]){
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+ " ");
        }
    }

    static class pairr implements Comparable<pairr>{
        int v;
        int cost;

        public pairr(int v , int c){
            this.v = v;
            this.cost = c;
        }
        @Override

        public int compareTo(pairr p2){
            return this.cost - p2.cost;
        }
    }

    public static void primsalgo(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pairr> pq = new PriorityQueue<>();

        pq.add(new pairr(0,0));
        int finalcost = 0;

        while(!pq.isEmpty()){
            pairr curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalcost+= curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    edge e = graph[curr.v].get(i);
                    pq.add(new pairr(e.dest , e.weight));

                }
            }

        }
        System.out.println(finalcost);





    }
    public static void createcitigraph(int arr[][] , ArrayList<edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            int src = arr[i][0];
            int dest = arr[i][1];
            int wt =arr[i][2];

            edge e = new edge(src, dest, wt);
            graph[src].add(e);
        }
    }
    static class infoo{
        int v;
        int cost;
        int k;
        public infoo(int v , int c,int k){
            this.v= v;
            this.cost=c;
            this.k = k;
        }
    }
    public static void cheapestpath(int n , int cities[][] , int src , int dest , int k){
        ArrayList<edge> graph[] = new ArrayList[n];
        createcitigraph(cities, graph);
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<infoo> q = new LinkedList<>();
        q.add(new infoo(src ,0,0));
        while(!q.isEmpty()){
            infoo curr = q.remove();
            if(curr.k > k){
                break;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                if(dist[u] != Integer.MAX_VALUE && dist[u]+ wt <dist[v] && curr.k<=k){
                    dist[v] = dist[u]+wt;
                    q.add(new infoo(v , dist[v] , curr.k+1));
                } 
            }
        }
        if(dist[dest] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dist[dest]);
        }


    }
    public static void addedge(ArrayList<Integer> graph[] , int u,int v){
        graph[u].add(v);
        graph[v].add(u);
    }
    public static boolean cyclee(ArrayList<Integer> graph[]){ //cycle using bfs
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
    
    public static void main(String args[]){

        /*int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0,1,5));

        graph[1].add(new edge(1,2,1));
        graph[1].add(new edge(1,3,3));
        graph[1].add(new edge(1,0,5));

        graph[2].add(new edge(2,3,1));
        graph[2].add(new edge(2,4,2));
        graph[2].add(new edge(2,1,1));

        graph[3].add(new edge(3,1,3));
        graph[3].add(new edge(3,2,1));

        graph[4].add(new edge(4,2,2));


        for(int i=0;i<graph[2].size();i++){
            edge e = graph[2].get(i);
            System.out.println(e.dest);
        }*/

        /*int v = 7;
        ArrayList<edge> graph[] = new ArrayList[v];
        creategraph(graph);*/
        //bfs(graph);
        //dfs(graph , 0 , new boolean[v]);
        //System.out.println(haspath(graph , 0,5, new boolean[v]));
        //System.out.println(detectcycle(graph));

        //System.out.println(isbarpartite(graph));
        //System.out.println(iscycle(graph));
        //primsalgo(graph);
        int n=4;
        int cities[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0,dest=3,k=1;
        cheapestpath(n, cities, src, dest, k);
        

        
        



        
    }
    
}
