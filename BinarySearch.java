

public class BinarySearch {


    public static int Search(Comparable []arr,int i,int j,Comparable comparable)
    {
        int middle=0;
        while (i<=j)
        {
            middle=(i+j)/2;
            if(comparable.compareTo(arr[middle])>0)
            {
                i=middle+1;
            }
            else {

                j=middle-1;
            }
        }
        return i;

    }


}
