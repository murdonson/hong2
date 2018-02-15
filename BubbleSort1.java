

public class BubbleSort1 {

    public static void sort(Comparable []arr)
    {
        int n=arr.length;
        boolean exchange=true;
        for (int i = 0; i < n-1&&exchange; i++) {
            exchange=false;
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j].compareTo(arr[j+1])>0)
                {
                    Util.swap(arr,j,j+1);
                    exchange=true;
                }
            }


        }
    }
}
