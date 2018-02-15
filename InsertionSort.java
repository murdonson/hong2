
/**
 * Created by Administrator on 2017/7/18 0018.
 */
public class InsertionSort {
    // 插入排序
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 从索引为1 到索引为n-1开始比较
        for (int i = 1; i < n; i++) {
            //  arr[j]<arr[j-1] 为真 进入for循环
            for (int j = i; j > 0 && Util.less(arr[j], arr[j - 1]); j--) {
                Util.swap(arr, j, j - 1);
            }
        }

    }

    public static void sort(Comparable[] arr,int l,int r) {
        int n = arr.length;
        for (int i = l+1; i <=r; i++) {
            //  arr[j]<arr[j-1] 为真 进入for循环
            for (int j = i; j > l && Util.less(arr[j], arr[j - 1]); j--) {
                Util.swap(arr, j, j - 1);
            }
        }

    }




}
