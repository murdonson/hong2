

public class MergeSort {
    public static void sort(Comparable []arr)
    {
        insort(arr,0,arr.length-1);
    }


    private static  void insort(Comparable []arr,int l,int r)
    {
        if(r-l<=15) {
           InsertionSort.sort(arr, l, r);
            return;
        }
        int mid=(l+r)/2;
        insort(arr,l,mid);
        insort(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
             mergesort(arr,l,mid,r);
    }
    private static void mergesort(Comparable []arr,int l,int mid,int r)
    {
        Comparable []a=new Comparable[r-l+1];
        System.arraycopy(arr,l,a,0,r-l+1);
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++)
        {
            if(i>mid)
            {
                arr[k]=a[j-l];j++;
            }
            else if(j>r)
            {
                arr[k]=a[i-l];i++;
            }
            else if(a[i-l].compareTo(a[j-l])>0)
            {
                arr[k]=a[j-l];j++;
            }
            else if(a[i-l].compareTo(a[j-l])<=0)
            {
                arr[k]=a[i-l];i++;
            }
        }

    }

}
