import java.util.Arrays;
import java.util.HashSet;

public class dynamic {
    public static int fib(int n , int f[]){
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!= 0){
            return f[n];
        }

        f[n] = fib(n-1 , f) + fib(n-2 ,f);
        return f[n];
    }

    public static int climbingstairs(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbingstairs(n-1) + climbingstairs(n-2);
    }
    public static int climbingmemoisation(int n , int m[]){
        if(n ==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        
        if(m[n] != 0){
            return m[n];
        }

        m[n] = climbingmemoisation(n-1, m) + climbingmemoisation(n-2, m);
        return m[n];
    }
    public static void climbingtabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }

        System.out.println(dp[n]);

    }
    public static int knapsack(int val[] , int wt[] , int w , int n){
        if(w == 0 || n ==0){
            return 0;
        }

        if(wt[n-1]<=w){
            int ans1 =  val[n-1] + knapsack(val, wt, w-wt[n-1], n-1);
            int ans2 = knapsack(val, wt, w, n-1);

            return Math.max(ans1, ans2);

        }
        else{
            return knapsack(val, wt, w, n-1);
        }
    }
    public static int knapsackmemoisation(int val[] , int wt[] , int w , int n , int dp[][]){
        if(w == 0 || n ==0){
            return 0;
        }
        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(wt[n-1]<=w){
            int ans1 =  val[n-1] + knapsackmemoisation(val, wt, w-wt[n-1], n-1 , dp);
            int ans2 = knapsackmemoisation(val, wt, w, n-1 ,dp);

            dp[n][w] =  Math.max(ans1, ans2);
            return dp[n][w];

        }
        else{
            dp[n][w] = knapsackmemoisation(val, wt, w, n-1 , dp);
            return dp[n][w];
        }
    }

    public static int knapsaktabular(int val[] , int wt[] , int W){
        int dp[][] = new int[val.length+1][W+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }

        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v = val[i-1];
                int w = wt[i-1];

                if(w <= j){
                    int includeprofit = v + dp[i-1][j-w];
                    int excludeprofit = dp[i-1][j];

                    dp[i][j] = Math.max(includeprofit , excludeprofit);

                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[val.length][W];
    }

    public static boolean subsetsum(int arr[] , int targetsum){
        boolean dp[][] = new boolean[arr.length+1][targetsum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = true;

        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i] = false;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int num = arr[i-1];

                if(num <= j && dp[i-1][j-num]== true){
                    dp[i][j] = true;
                    


                }
                else if(dp[i-1][j]){
                    dp[i][j] = true;

                }
                
            }
        }
        
            return dp[arr.length][targetsum];
        

        

    }

    public static int coinchangetabulation(int coin[] , int sum){
        int dp[][] = new int[coin.length+1][sum+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coin[i-1] <= j){
                    dp[i][j] = dp[i][j-coin[i-1]] + dp[i-1][j]; 
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coin.length][sum];
    }
    public static int longestcommonsubsequence(String s1 , String s2 , int n , int m){
        if(n ==0 || m==0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return longestcommonsubsequence(s1, s2 , n-1 , m-1) +1;
        }
        else{
            int ans1 = longestcommonsubsequence(s1 , s2 , n-1 , m);
            int ans2 = longestcommonsubsequence(s1 , s2 , n , m-1);
            return Math.max(ans1, ans2);
        }
    }
    public static int longestcommonsubsequencememoisation(String s1 , String s2 , int n , int m , int dp[][]){
        if(n ==0 || m==0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = longestcommonsubsequencememoisation(s1, s2 , n-1 , m-1 , dp) +1;
        }
        else{
            int ans1 = longestcommonsubsequencememoisation(s1 , s2 , n-1 , m , dp);
            int ans2 = longestcommonsubsequencememoisation(s1 , s2 , n , m-1 , dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static int lcstabulation(String s1 , String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static int lcs(int arr[] , int arr2[]){
        int dp[][] = new int[arr.length+1][arr2.length+1];
        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[arr.length][arr2.length];

    }
    public static int lcsubstring(String s1 , String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int ans = 0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans , dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static int lis(int arr[]){
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i =0;
        for(int n : set){
            arr2[i] = n;
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr , arr2);

    }

    public static int editdistance(String s1 , String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<dp.length;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<dp.length;i++){
            dp[0][1] = i;
        }
        

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1;
                    int replace = dp[i-1][j-1]+1;

                    dp[i][j] = Math.min(Math.min(add, delete) , replace);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static boolean wildcard(String s1, String s2){
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        for(int i=1;i<dp.length;i++){
            dp[i][0] = false;
        }
        for(int i=1;i<dp[0].length;i++){
            if(s2.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1) || s2.charAt(j-1)== '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s2.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    public static int catalan(int n , int dp[]){
        if(n ==0 || n ==1){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans += catalan(i , dp)*catalan(n-i-1 , dp);
        }
        return dp[n] = ans;
    }

    public static int catalantabulation(int n ){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    
    public static int countbst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static int mountain(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];

    }
    public static int matrixchainmul(int arr[] , int i , int j , int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int cost1 = matrixchainmul(arr, i, k , dp);
            int cost2 = matrixchainmul(arr, k+1, j , dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalcost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalcost);
        }
        return dp[i][j] = ans;
    }

    public static int minpartitioning(int arr[]){
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];

        }
        int w = sum/2;
        int dp[][] = new int[arr.length+1][w+1];
        for(int i =1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1] <= j){
                    dp[i][j] =  Math.max(arr[i-1] + dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[arr.length][w];

        return Math.abs(sum - sum1 - sum1);
    }
    public static int minjumps(int arr[]){
        int dp[] = new int[arr.length];
        Arrays.fill(dp , -1);
        dp[arr.length-1] = 0;
        for(int i=dp.length-2;i>=0;i--){
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j= i+1;j<=i+steps && j<arr.length;j++){
                if(dp[j] != -1){
                    ans = Math.min(ans , dp[j]+1);
                }


            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }

        }
        return dp[0];
    }
    public static void main(String args[]){
        //int n = 5;
        /*int f[] = new int[n+1];
        System.out.println(fib(n , f));*/
        /*System.out.println(climbingstairs(n));
        int m[] = new int[n+1];
        System.out.println(climbingmemoisation(n , m));
        climbingtabulation(n);*/

        /*int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7;
        //System.out.println(knapsack(val, wt, w, 5));
        int dp[][] = new int[val.length+1][w+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }

        }
        //System.out.println(knapsackmemoisation(val, wt, w, 5 , dp));
        //System.out.println(knapsaktabular(val , wt ,7));

        /*int arr[] = {4,2,1,7,3};

        System.out.println(subsetsum(arr, 10));*/

        /*int coin[] = {1,2,3};
        int sum = 4;
        System.out.println(coinchangetabulation(coin, sum));*/
        /*String s = "abcdge";
        String s2 = "abedg";
        System.out.println(longestcommonsubsequence(s, s2, s.length(), s2.length()));
        int n = s.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j= 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(longestcommonsubsequencememoisation(s , s2 , n , m , dp));
        System.out.println(lcstabulation(s, s2));*/

        //int arr[] = {50,3,10,7,40,80};
        //System.out.println(lis(arr));
        //String s1 = "intention";
        //String s2 = "execution";
        //System.out.println(editdistance(s1, s2));

        /*String s1 = "baaabab";
        String s2 = "*****ba*****ab";
        System.out.println(wildcard(s1, s2));*/

        //System.out.println(catalan(4));
        /*int n = 4;
        int dp[] = new int[n+1];
        System.out.println(catalan(4 ,dp));
        System.out.println(catalantabulation(4));
        System.out.println(countbst(4));*/

        //int arr[] = {1,2,3,4,3};
        //System.out.println(matrixchainmul(arr, 1, 4));
        /*int n = arr.length;
        int dp[][] =  new int[n][n];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i] , -1);
        }*/
        //System.out.println(matrixchainmul(arr, 1, n-1, dp));
        //int arr[] = {1,6,11,5};
        //System.out.println(minpartitioning(arr));

        int num[] = {2,3,1,1,4};
        System.out.println(minjumps(num));






    }
    
}
