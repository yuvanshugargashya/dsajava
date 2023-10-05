public class backtracking {
    public static void changearr(int arr[] , int i , int val){
        if(i==arr.length){
            print(arr);
            return;
        }
        arr[i] = val;
        changearr(arr,i+1,val+1);
        arr[i] = val-2;
    }
    public static void subset(String str , int i , String ans){
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
                return;
            }
            else{
                System.out.println(ans);
                return;
            }
        }
        subset(str,i+1,ans+str.charAt(i));
        subset(str,i+1,ans);
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void permutations(String str , String abc){
        if(str.length()==0){
            System.out.println(abc);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String newstr = str.substring(0,i) + str.substring(i+1);
            permutations(newstr , abc+curr);
        }
    }
    public static boolean issafe(char board[][] , int row ,int col){
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'q'){
                return false;
            }
        }
        for(int i =row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]== 'q'){
                return false;
            }

        }
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]== 'q'){
                return false;
            }
        }
        return true;
    }
    static int count = 0;
    public static void nqueen(char board[][] , int row ){
        
        if(row == board.length){
            printboard(board);
            System.out.println();
            count++;
            
            return;
        }
        for(int i = 0;i<board.length;i++){
            if(issafe(board, row, i)){
            board[row][i] = 'q';
            nqueen(board , row+1);
            board[row][i] = 'x';}
        }
        
    }
    public static void printboard(char board[][]){
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static int gridways(int i , int j , int n , int m){
        if(i==n-1 && j ==m-1){
            return 1;
        }
        if(i==n ||j==m){
            return 0;
        }
        int w1 = gridways(i, j+1, n, m);
        int w2 = gridways(i+1, j, n, m);
        return w1 +w2;
    }
    public static boolean issafe(int maze[][] , int x , int y){///rat in maze
        return(x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);
    }
    public static boolean solve(int maze[][]){
        int sol[][] = new int[maze.length][maze.length];
        if(solveutil(maze , sol , 0,0)==false){
            System.out.println("not exist");
            return false;
        }
        printsol(sol);
        return true;

    }
    public static void printsol(int sol[][]){
        for(int i=0;i<sol.length;i++){
            for(int j=0;j<sol.length;j++){
                System.out.print(sol[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static boolean solveutil(int maze[][] , int sol[][] , int x , int y){
        if(x==maze.length-1 && y== maze.length-1 && maze[x][y]==1){
            sol[x][y] =1;
            return true;
        }
        if(issafe(maze, x, y)){
            if(sol[x][y]==1){
                return false;
            }
            sol[x][y] = 1;
            if(solveutil(maze , sol , x+1 , y)){
                return true;
            }
            if(solveutil(maze , sol , x , y+1)){
                return true;
            }
            sol[x][y] = 0;
            return false;
        }

        return false;

    }
    public static boolean issafee(int sol[][] , int x , int y){//knight tour
        return (x>=0 && x<sol.length && y>=0 &&y<sol.length && sol[x][y] == -1);
    }
    public static boolean solve(int n){
        int sol[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sol[i][j] = -1;
            }
        }
        int xmove[] = {2,2,1,1,-2,-2,-1,-1};
        int ymove[] = {1,-1,2,-2,1,-1,-2,2};
        if(solveutil(0 , 0 ,1, xmove , ymove , sol)==false){
            System.out.println("not exist");
            return false;
        }
        printsoll(sol);
        return true;
    }
    public static void printsoll(int sol[][])
    {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol.length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    public static boolean solveutil(int x  , int y , int movei , int xmove[] , int ymove[] , int sol[][]){
        int nextx, nexty;
        if(movei == sol.length*sol.length){
            return true;
        }
        for(int k=0;k<8;k++){
            nextx = x + xmove[k];
            nexty = y+ ymove[k];
            if(issafe(sol, nextx, nexty)){
                sol[nextx][nexty] = movei;
                if(solveutil(nextx , nexty , movei+1,xmove,ymove,sol)){
                    return true;
                }
                else{
                    sol[nextx][nexty] = -1;
                }
            }

        }
        return false;

    }

    public static void main(String args[]){
        //int arr[] = new int[5];
        //changearr(arr, 0, 1);
        //print(arr);
        //subset("abc" , 0 , "");
        //permutations("abc" , "");

        /*int n = 5; 
        char board[][] = new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = 'x';
            }
        }
        nqueen(board, 0);
        System.out.println(count);*/
        System.out.println(gridways(0,0,3,3));

    }
    
}
