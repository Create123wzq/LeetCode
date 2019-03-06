import java.util.Arrays;

public class sort {

    public static void insertSort(int[] A){
        int n = A.length;
        int i,j;
        int key;
        for(i=1;i<n;i++){
            key = A[i];
            for(j=i-1;j>=0;j--){
                if(A[j]>key){
                    A[j+1] = A[j];
                }else{
                    break;
                }
            }
            A[j+1] = key;
        }
    }

    public static void shellSort(int[] A){
        int n = A.length;
        int temp = 0;
        int j;
        for(int increment = n/2;increment>0;increment/=2){
            for(int i=increment;i<n;i++){
                temp = A[i];
                for(j=i-increment;j>=0;j-=increment){
                    if(temp<A[j]){
                        A[j+increment] = A[j];
                    }else{
                        break;
                    }
                }
                A[j+increment] = temp;
            }
        }
    }

    public static void bubbleSort(int[] A){
        int n = A.length;
        int temp;
        for(int i=0;i<n-1;i++){
            for(int j=n-1;j>i;j--){
                if(A[j]<A[j-1]){
                    temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] A, int low, int high){
        if(low<high){
            int pivotpos = partition(A, low, high);
            quickSort(A, low, pivotpos-1);
            quickSort(A, pivotpos+1, high);
        }
    }

    public static int partition(int[]A, int low, int high){
        int pivot = A[low];
        while (low<high){
            while (low<high && A[high]>=pivot) high--;
            A[low] = A[high];
            while (low<high && A[low]<=pivot) low++;
            A[high] = A[low];
        }
        A[low] = pivot;
        return low;
    }

    public static void selectSort(int[] A){
        int n = A.length;
        int minIndex;
        for(int i=0;i<n;i++){
            minIndex = i;
            for(int j=i+1;j<n;j++){
                if(A[j]<A[minIndex]){
                    minIndex = j;
                }
            }
            int temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }
    }

    public static void mergeSort(int[] A, int low ,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(A, low, mid);
            mergeSort(A, mid+1, high);
            merge(A, low, mid, high);
        }
    }

    public static void merge(int[] A, int low, int mid, int high){
        int[] B = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=high){
            if(A[i]<A[j]){
                B[k++] = A[i++];
            }else{
                B[k++] = A[j++];
            }
        }
        while(i<=mid){B[k++] = A[i++];}
        while(j<=high){B[k++] = A[j++];}

        for(int m=0;m<B.length;m++){
            A[m+low] = B[m];
        }
    }

    public static void main(String[] args) {
        int[] A = {4,6,2,1,5,9};
        mergeSort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));
    }
}
