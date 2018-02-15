


/*
*  冒泡排序最开始是0到N-1比较
* */

public class BubbleSort {
    public static void sort(Comparable []arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++)
            {
                // 假设 arr[i]此时最小
                if(arr[j].compareTo(arr[j+1])<0)
                {
                   Util.swap(arr,j,j+1);
                }
            }
            System.out.println("冒出来的最小数"+arr[n-1-i]);
        }
    }


}
