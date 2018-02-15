

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class Util {
    public static  void swap(Comparable []arr,int i,int minindex)
    {
        Comparable temp=arr[i];
        arr[i]=arr[minindex];
        arr[minindex]=temp;
    }


    public static void show(Comparable []arr)
    {
        for (Comparable comparable : arr) {
            if(comparable==null)
                continue;
            System.out.print(comparable+" ");
        }
    }

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ )
            if( arr[i].compareTo(arr[i+1]) > 0 )
                return false;
        return true;
    }



    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        return arr;
    }
    // a<b 为真
    public static boolean less(Comparable a,Comparable b)
    {
        return a.compareTo(b)<0;
    }



    // 依据反射机制测试
    public static void testsort(String name,Comparable []arr)  {
        Class sortclass= null;
        try {
            sortclass = Class.forName(name);
            Method sortmethod=sortclass.getDeclaredMethod("sort",Comparable[].class);
            Object []params=new Object[]{arr};
            long start=System.currentTimeMillis();
            sortmethod.invoke(null,params); // 调用静态方法不需要传参数
            long end=System.currentTimeMillis();
            assert isSorted( arr ):"Not ordered.Buddy!";
            System.out.println(sortclass.getSimpleName()+" "+(end-start)+"ms");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    public static Comparable[] arraycopy(Comparable arr[])
    {
        Comparable c[]=new Integer[arr.length];
        System.arraycopy(arr,0,c,0,arr.length);
        return c;
    }

}
