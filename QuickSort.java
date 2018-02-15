
public class QuickSort {
    public static void sort(Comparable []arr)
    {
        insort(arr,0,arr.length-1);
    }
    private static void insort(Comparable []arr,int low,int high)
    {
        if(low>=high)
            return;
        int p=partition1(arr,low,high);
        insort(arr,low,p-1);
        insort(arr,p+1,high);
    }
    //a[hig] pivot
    private static int partition(Comparable []arr,int low,int high)
    {
        int storeindex=low;
        for(int i=low;i<high;i++)
        {
            if(arr[i].compareTo(arr[high])<0)
            {
               Util.swap(arr,storeindex++,i);
            }
        }
        Util.swap(arr,storeindex,high);
        return storeindex;
    }
    // a[low] pivot
    private static int partition1(Comparable []arr,int low,int high){
        int storeindex=low+1;
        for(int i=low+1;i<=high;i++)
        {
            if(arr[i].compareTo(arr[low])<0)
            {
                Util.swap(arr,storeindex,i);
                storeindex++;
            }
        }
        Util.swap(arr,storeindex-1,low);
        return storeindex-1;
    }


    public static void main(String[] args)
    {
        Integer[] a=new Integer[]{4,7,6,3};
        sort(a);
    }
}
