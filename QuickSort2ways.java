

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class QuickSort2ways {

    public static void sort(Comparable []arr)
    {
        insort(arr,0,arr.length-1);
    }
    private static void insort(Comparable []arr,int low,int high)
    {
        if(low>=high)
            return;
        int p=partition(arr,low,high);
        insort(arr,low,p-1);
        insort(arr,p+1,high);
    }
    private static int partition(Comparable[] arr, int l, int r){
        // �����arr[l...r]�ķ�Χ��, ѡ��һ����ֵ��Ϊ�궨��pivot
        Util.swap(arr,l,(int)Math.random()*(r-l+1)+1);
        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            while( i <= r && arr[i].compareTo(v) < 0 )
                i ++;
            while( j >= l+1 && arr[j].compareTo(v) > 0 )
                j --;

            if( i > j )
                break;
            Util.swap( arr, i, j );
            i ++;
            j --;
        }
        Util.swap(arr, l, j);
        return j;
    }
}
