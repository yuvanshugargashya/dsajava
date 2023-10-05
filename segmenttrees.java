public class segmenttrees {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
    }
    public static int createsegmentree(int arr[] , int i , int start ,int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }
        int mid = (start+end)/2;
        createsegmentree(arr, 2*i+1, start, mid);
        createsegmentree(arr, 2*i+2, mid+1, end);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];

    }
    public static int getsumutil(int i , int si , int sj , int qi , int qj){
        if(qj <= si || qi>= sj){
            return 0;
        }
        else if(si>= qi && qj>= sj){
            return tree[i];
        }
        else{
            int mid= (si + sj)/2;
            return getsumutil(2*i+1 , si , mid , qi , qj) + getsumutil(2*i+2 , mid+1 , sj , qi , qj);
        }
    }
    public static int getsum(int arr[] , int qi , int qj){
        int n = arr.length;
        return getsumutil(0, 0, n-1, qi, qj);

    }
    public static void updateutil(int i , int si , int sj ,int idx,  int diff ){
        if(si> idx || sj<  idx){
            return ;
        }
        tree[i] += diff;
        if(si != sj){
            int mid = (si+sj)/2;
            updateutil(2*i+1 , si , mid , idx , diff);
            updateutil(2*i+2 , mid+1,sj,idx,diff);
        }

    }

    public static void update(int arr[] , int idx , int val){
        int n = arr.length;
        int diff = val - arr[idx];
        arr[idx] = val;
        updateutil(0 , 0 , n-1, idx , diff);
    }

    public static int maxsubarraycreation( int arr[] ,int i , int si , int sj){
        if(si == sj){
            tree[i] = arr[si];
            return tree[i];
        }
        int mid = (si+sj)/2;
        maxsubarraycreation(arr, 2*i+1, si, mid);
        maxsubarraycreation(arr, 2*i+2, mid+1, sj);
        tree[i] = Math.max(tree[2*i+1] , tree[2*i+2]);
        return tree[i];
    }
    public static void main(String args[]){
        /*int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        createsegmentree(arr, 0, 0, n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+ " ");
        }
        System.out.println();

        System.out.println(getsum(arr, 2, 5));
        update(arr, 2, 2);
        System.out.println(getsum(arr, 2, 5));*/
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n =arr.length;
        init(n);
        maxsubarraycreation(arr, 0, 0, n-1);
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+ " ");
        }
        System.out.println();



    }
    
}
