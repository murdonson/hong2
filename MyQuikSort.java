public class MyQuikSort
{
    public static void sort(int[] arr)
    {
        insort(arr,0,arr.length-1);
    }

    private static void insort(int[] arr, int low, int high)
    {

        if(low>=high) return;

        int p=partition(arr,low,high);

        insort(arr,low,p-1);
        insort(arr,p+1,high);
    }

    private static int partition(int[] arr, int low, int high)
    {
        int j=low+1;
        for(int i=low+1;i<=high;i++)
        {
            if(arr[i]<arr[low])
            {
                swap(arr,i,j);
                j++;
            }
        }

        swap(arr,low,j-1);

        return j-1;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    private static int[] getNumbers(int n)
    {
        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]= (int) (Math.random()*100);
        }
        return arr;
    }

    private static void show(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] numbers = getNumbers(20);
        show(numbers);
        sort(numbers);
        show(numbers);

    }
}
