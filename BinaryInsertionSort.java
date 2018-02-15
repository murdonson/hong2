

public class BinaryInsertionSort {

    public static void sort(Comparable []arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int insertindex= BinarySearch.Search(arr,0,i-1,arr[i]); //在有序区找到要插入的位置
            int temp= (int) arr[i];// 要插入的元素
            if(i!=insertindex)
            {
                for(int k=i-1;k>=insertindex;k--)
                {
                    arr[k+1]=arr[k]; //无序区的元素都往后移动一位
                }
                arr[insertindex]=temp; // 插入的元素放在适合的位置
            }


        }
    }

}
