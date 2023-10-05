import java.util.*;
public class twod {
    public static void diagonalsum(int matrix[][]){
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            sum += matrix[i][i];

            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-1-i];

            }

        }
        System.out.println(sum);
    }

    public static void spiral(int matrix[][]){
        int sr = 0;
        int er = matrix.length-1;
        int sc = 0;
        int ec = matrix[0].length-1;

        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                System.out.print(matrix[sr][i]);

            }
            sr++;
            for(int i=sr;i<=er;i++){
                System.out.print(matrix[i][ec]);
            }
            ec--;
            for(int i=ec;i>=sc;i--){
                System.out.print(matrix[er][i]);
            }
            er--;
            for(int i=er;i>=sr;i--){
                System.out.print(matrix[i][sc]);
            }
            sc++;

        }
    }
    public static void staircasesearch(int matrix[][] , int key){
        int i = 0;
        int j= matrix.length-1;
        while(i<matrix.length && j>=0){
            if(matrix[i][j] == key){
                System.out.print(i + " " + j);
                return;
            }
            else if(key < matrix[i][j]){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("not found");
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int matrix[][] = new int[3][3];
        int n = matrix.length;
        //System.out.println(n);
        int m = matrix[0].length;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }//System.out.println();
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(matrix[i][j]);
            }System.out.println();
        }
        spiral(matrix);
        diagonalsum(matrix);
        staircasesearch(matrix  , 10);
    }
    
}
