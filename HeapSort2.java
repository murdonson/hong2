

/**
 * Created by Administrator on 2017/7/24 0024.
 * 最大堆的构建过程就是小的树往下降
 */
public class HeapSort2 {
    public static void sort(Comparable []arr) {
        int n = arr.length;
        for (int i = (n - 1 - 1) / 2; i >= 0; i--)
        {
            shiftdown(arr, n, i);
        }
        for(int i=n-1;i>0;i--)
        {
            Util.swap(arr,0,i);
            shiftdown(arr,i,0);
        }
    }
    public static void shiftdown(Comparable []arr,int n,int k)
    {
        while(2*k+1<n)   // ������ӽ��
        {
            int j=2*k+1;
            if(j+1<n&&arr[j].compareTo(arr[j+1])<0)
                j++;
            if(arr[k].compareTo(arr[j])>0)
                break;
            Util.swap(arr,k,j);
            k=j;
        }


    }


    public static void main(String[] args)
    {
        Integer a[]={3,2,1,7};
        sort(a);
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }



}
