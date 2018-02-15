

/**
 * Created by Administrator on 2017/7/23 0023.
 */
public class QuickSort3ways {
    public static void sort(Comparable []arr)
    {
        insort(arr,0,arr.length-1);
    }
    private static void insort(Comparable []arr,int l,int r)
    {
        if(l>=r)
            return;
       Util.swap(arr,l,(int)Math.random()*(r-l+1)+l);
        Comparable v = arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while(i<gt)
        {
            if(arr[i].compareTo(v)<0)
            {
                Util.swap(arr,i,lt+1);
                i++;
                lt++;
            }
            else if(arr[i].compareTo(v)>0)
            {
                Util.swap(arr,i,gt-1);
                gt--;
            }
            else{
                i++;
            }
        }
        Util.swap(arr,l,lt);
        insort(arr,l,lt-1);
        insort(arr,gt,r);

    }


}
