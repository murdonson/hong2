

/**
 * Created by Administrator on 2017/7/21 0021.
 *
 */
public class Main {
    public static void main(String[] args) {
        Integer b[]= Util.generateRandomArray(9,1,4);

        Integer c[]= (Integer[]) Util.arraycopy(b);
        Integer d[]= (Integer[]) Util.arraycopy(b);
        Integer e[]= (Integer[]) Util.arraycopy(b);
        Integer f[]= (Integer[]) Util.arraycopy(b);
        Integer g[]=new Integer[]{3,4,2,1};


//        Util.testsort("InsertionSort",b);
//        Util.testsort("SelectionSort",c);
//        Util.testsort("ShellSort",d);
//        Util.testsort("MergeSort",e);
//        Util.testsort("QuickSort3ways",f);



   Util.testsort("HeapSort2",b);
     //   Util.testsort("BubbleSort1",b);
//        Util.testsort("BubbleSort1",c);
//        Util.testsort("BinaryInsertionSort",d);
//        Util.testsort("MergeSort1",b);
        Util.show(b);
    }
}
