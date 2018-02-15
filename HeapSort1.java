

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class HeapSort1 {

    //

    public static void sort(Comparable []arr)
    {
        MaxHeap maxHeap=new MaxHeap(arr);
        for(int i=arr.length-1;i>=0;i--)
        {
            arr[i]=maxHeap.extractMax();
        }
    }
}
