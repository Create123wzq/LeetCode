package algorithm;

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

    public static void heapSort(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    public static void adjustHeap(int[] A, int i, int length){
        int temp = A[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && A[k]<A[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(A[k]>temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                A[i] = A[k];
                i = k;
            }else{
                break;
            }
        }
        A[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {4,6,2,1,5,9};
        heapSort(A);
        System.out.println(Arrays.toString(A));
    }
}
