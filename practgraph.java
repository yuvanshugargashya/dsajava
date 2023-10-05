import java.util.*;
public class practgraph {
    static class edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src =s;
            this.dest=d;
            this.wt=w;

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
        Queue<Integer> q=new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr]=true;
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
                dfsutil(graph,vis,i);
            }
        }

    }
    public static void dfsutil(ArrayList<edge> graph[] , boolean vis[],int curr){
        System.out.print(curr);
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            
            edge e=graph[curr].get(i);
            if( !vis[e.dest]){
                dfsutil(graph, vis, e.dest);
            }
        
        }
    }
    public static boolean haspath(ArrayList<edge>graph[],int src,int dest , boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            edge e = graph[src].get(i);
            if(!vis[e.dest] && haspath(graph, e.dest, dest, vis)){
                return true;
            }
        }
        return false;


    }
    public static boolean detect(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectutil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectutil(ArrayList<edge> graph[], boolean vis[],int curr,int parent){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            edge e = graph[curr].get(i);
            if(!vis[e.dest] && detectutil(graph,vis,e.dest,curr)){
                return true;
            }
            else if(vis[e.dest] && e.dest !=parent){
                return true;
            }
        }
        return false;
    }
    public static boolean bipar(ArrayList<edge> graph[]){
        int col[] = new int[graph.length];
        Arrays.fill(col,-1);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(col[i] == -1){
                q.add(i);
                col[i]=0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0;i<graph[curr].size();j++){
                        edge e= graph[curr].get(j);
                        if(col[e.dest]==-1){
                            col[e.dest] = (col[curr]==0)? 1:0;

                        }
                        else if(col[curr]==col[e.dest]){
                            return false;
                        }

                    }
                }
            }
        }
        return true;

    }
    public static void topsort(ArrayList<edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                //topsortutil(graph, i,vis,s);
            }
        }
        for(int i:s){
            System.out.println(i);
        }
    }
    static class pair implements Comparable<pair>{
        int n;
        int path;
        public pair(int n,int p){
            this.n =n;
            this.path=p;
        }

        @Override
        public int compareTo(pair p2){
            return this.path - p2.path;
        }
    }
    public static void dij(ArrayList<edge> graph[] , int src){
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for(int i =0;i<dist.length;i++){
            if( i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src,0));
        while(!pq.isEmpty()){
            pair curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;
                for(int i=0;i<graph[curr.n].size();i++){
                    edge e = graph[curr.n].get(i);
                    int u=e.src;
                    int v =e.dest;
                    int wt =e.wt;
                    if(dist[u]+wt<dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new pair(e.dest,dist[v]));
                    }
                }
            }

        }
    }
    
    public static void main(String args[]){
        ArrayList<edge> graph[] = new ArrayList[5];
        
        creategraph(graph);
        bfs(graph);
        //dfs(graph);

    }
    
}
