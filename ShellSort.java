

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class ShellSort {
    public static void sort(Comparable []arr)
    {
        int n=arr.length;
        for(int gap=n/2;gap>0;gap/=2)
        {
            for(int i=gap;i<n;i++)
            {
                for(int j = i; j>=gap&& Util.less(arr[j],arr[j-gap]); j-=gap)
                {
                    Util.swap(arr,j,j-gap);
                }
            }
        }
    }


}
