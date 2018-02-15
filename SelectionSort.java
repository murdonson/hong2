

public class SelectionSort {
    // 插入排序
     public static void sort(Comparable []arr)
     {
         int size=arr.length;
         for(int i=0;i<size-1;i++)
         {
             int minindex=i;
             for(int j=i+1;j<size;j++)
             {
                 if(arr[minindex].compareTo(arr[j])>0)
                 {
                     minindex=j;
                 }
             }
             if(minindex!=i)
               Util.swap(arr,i,minindex);
         }
     }



}
