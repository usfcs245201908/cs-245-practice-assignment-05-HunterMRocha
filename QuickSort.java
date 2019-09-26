public class QuickSort implements SortingAlgorithm {

    public QuickSort(){
        return; 
    }

    public int partition(int arr[], int low, int high) { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 


    public void sort(int arr[]){
        sort1(arr, 0, arr.length-1);
    }
  
  
    public void sort1(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
           
            int pi = partition(arr, low, high); 
  
            sort1(arr, low, pi-1); 
            sort1(arr, pi+1, high); 
        } 
    } 

} 