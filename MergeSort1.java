
/*
* 原地归并排序
* */

public class MergeSort1 {
    public static void sort(Comparable []arr)
    {
        Comparable []aux=new Comparable[arr.length];
        System.arraycopy(arr,0,aux,0,arr.length);
        insort(arr,aux,0,arr.length-1);
    }
    public static void insort(Comparable []arr,Comparable []aux,int lo,int hi)
    {
        if(lo>=hi)
            return;
        int mid=(lo+hi)/2;
        insort(arr,aux,lo,mid);
        insort(arr,aux,mid+1,hi);
        mergesort(arr,aux,lo,mid,hi);
    }

    public static void mergesort(Comparable []arr,Comparable []aux,int lo,int mid,int hi)
    {

        int i=lo;
        int j=mid+1;
        System.arraycopy(arr,lo,aux,lo,hi-lo+1);
        for(int k=lo;k<=hi;k++)
        {
            if(i>mid)
                arr[k]=aux[j++];
            else if(j>hi)
                arr[k]=aux[i++];
            else if(aux[i].compareTo(aux[j])>0)
                arr[k]=aux[j++];
            else
                arr[k]=aux[i++];
        }


    }
}
