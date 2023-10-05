import java.util.*;
public class greedyalgo {
    static class job{
        int id;
        int deadline;
        int profit;

        public  job(int i , int d , int p){
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
    public static void balanced(String str , int n){
        if(n==0){
            return;
        }
        int r =0, l=0;
        int ans =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='R'){
                r++;
            }
            if(str.charAt(i)=='L'){
                l++;
            }
            if(r==l){
                ans++;
            }
        }
        System.out.println(ans);
    }
    public static void kthlargest(int arr[] , int k){
        int j=0;
        for(int i=arr[1];i>=arr[0];i--){
            if(i%2!=0){
                j++;
            }
            if(j==k){
                System.out.println(i);
                return;
            }

        }
        if(j !=k){
            System.out.println("not exist");
        }
    }
    public static String minstr(int n , int k){
        char res[] = new char[n];
        Arrays.fill(res, 'a');
        k -= n;
        
        while(k > 0){
            res[n-1] += Math.min(25, k);
            k -= Math.min(25, k);
            n--;
        }
        return String.valueOf(res);


    }
    public static void main(String args[]){
        /*int start[] = {3,1,5,0,5,8};
        int end[] = {4,2,7,6,9,9};
        int activities[][] = new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));


        ArrayList<Integer> list = new ArrayList<>();
        //list.add(0);
        list.add(activities[0][0]);
        int maxactivities = 1;
        int lastend = activities[0][2];
        for(int i=1;i<end.length;i++){
            /*if(start[i] >= lastend){
                list.add(i);
                maxactivities++;
                lastend = end[i];
            }
            if(activities[i][1] >= lastend){
                list.add(activities[i][0]);
                maxactivities++;
                lastend = activities[i][2];
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }*/

        /*int weight[] = {10,20,30};
        int value[] = {60,100,120};
        int w = 50;

        double ratio[][] = new double[value.length][2];

        for(int i=0;i<value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(ratio , Comparator.comparingDouble( o -> o[1]));

        int capacity = w;
        int finalvalue = 0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                finalvalue += value[idx];
                capacity -= weight[idx];
            }
            else{
                finalvalue += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println(finalvalue);*/

        /*int A[] = {4,1,8,7};
        int B[] = {2,3,6,5};
        Arrays.sort(A);
        Arrays.sort(B);

        int mindiff = 0;
        for(int i=0;i<A.length;i++){
            mindiff += Math.abs(A[i] - B[i]);
        }
        System.out.println(mindiff);*/

        /*int pairs[][] = {{5,24} , {39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pairs , Comparator.comparingDouble(o -> o[1]));
        
        int maxpair = 1;
        int pairend = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>= pairend){
                maxpair++;
                pairend = pairs[i][1];
            }
            
        }
        System.out.println(maxpair);*/

        /*Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        int amount = 9567;
        Arrays.sort(coins , Comparator.reverseOrder());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int countofcoins = 0;
        for(int i=0;i<coins.length;i++){
            if(coins[i] <=amount){
                int thatc = 0;
                while(coins[i]<=amount){
                    countofcoins++;
                    thatc++;
                    list.add(coins[i]);
                    
                    amount -= coins[i];
                }
                list2.add(thatc);
                System.out.println(thatc + " notes of " + coins[i]);
            }
        }
        //System.out.println(countofcoins);
        //System.out.println(list);
        //System.out.println(list2);*/

        /*int jobsinfo[][] = {{4,20} , {1,10},{1,40},{1,30}};

        ArrayList<job> list  = new ArrayList<>();
        
        for(int i=0;i<jobsinfo.length;i++){
            list.add(new job( i , jobsinfo[i][0] , jobsinfo[i][1]));

        }
        Collections.sort(list , (obj1 , obj2) -> obj2.profit-obj1.profit);
        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i=0;i<list.size();i++){
            job curr = list.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }
        System.out.println(seq);*/

        int n=4 , m =6;
        Integer costver[] = {2,1,3,1,4};
        Integer costhor[] = {4,1,2};

        Arrays.sort(costver , Collections.reverseOrder());
        Arrays.sort(costhor , Collections.reverseOrder());

        int v= 0 , h=0;
        int vp =1 , hp =1;
        int cost = 0;
        while(v < costver.length && h<costhor.length){
            if(costver[v] <= costhor[h]){
                cost += (costhor[h]*vp);
                h++;
                hp++;
                

            }
            else{
                cost+= (costver[v]*hp);
                v++;
                vp++;
                
            }
        }

        while(v<costver.length){
            cost+= (costver[v]*hp);
                v++;
                vp++;

        }
        while(h<costhor.length){
            cost += (costhor[h]*vp);
                h++;
                hp++;

        }
        //System.out.println(cost);
        //balanced("LRRRRLLRLLRL", 12);
        int arr[] = {-3,3};
        
        //kthlargest(arr,1);
        System.out.println(minstr(3, 27));
        char ch[] = new char[3];
        Arrays.fill(ch , 'a');
        


        







        
    }
    
}
