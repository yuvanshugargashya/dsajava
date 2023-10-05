public class divide {
    public static void mergesort(int arr[] , int si , int ei){
        if(si>=ei){
            return;
        }
        int mid = si +(ei-si)/2;
        mergesort(arr,si,mid);
        mergesort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
        
    }
    public static void merge(int arr[] , int si , int mid , int ei){
        int i = si;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[ei-si+1];
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                k++;i++;
            }
            else{
                temp[k] = arr[j];
                k++;j++;
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for( k =0,i=si;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
    public static int rotatedsearch(int arr[], int si, int ei , int key){
        if(si>ei){
            return -1;
        }
        int mid= si + (ei-si)/2;
        if(arr[mid]==key){
            return mid;
        }
        if(arr[si]<=arr[mid]){
            if(arr[si]<=key && key<=arr[mid]){
                return rotatedsearch(arr,si,mid-1,key);
            }
            else{
                return rotatedsearch(arr,mid+1,ei , key);
            }
        }
        else{
            if(arr[mid]<=key && key<=arr[ei]){
                return rotatedsearch(arr,mid+1,ei,key);
            }
            else{
                return rotatedsearch(arr,si,mid-1,key);
            }
        }
    }
    public static void main(String args[]){
        /*int arr[] = {6,3,9,5,2,8};
        mergesort(arr, 0, arr.length-1);
        print(arr);*/
        int arr[] = {4,5,7,8,0,2,3};
        System.out.println(rotatedsearch(arr,0,6,0));


    }
    
}
