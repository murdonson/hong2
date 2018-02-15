
public class MaxHeap<Item extends Comparable> {
    private Item []data;
    private int count;
    private int capacity;

    public MaxHeap(Item []arr)
    {
        int n=arr.length;
        data= (Item[]) new Comparable[n+1];
        capacity=n;
        count=n;
        for(int i=0;i<arr.length;i++)
        {
            data[i+1]=arr[i];
        }
        // k=count/2 ���һ�������εĶ��� Ȼ�����α���ǰ���������
        for(int k=count/2;k>=1;k--)
        {
            shiftdown(k);
        }

    }


    // ͷ������ӽ��Ƚ�
    public void shiftdown(int k)
    {
        //  2*k<=count  ��֤��k�ڵ��к���
        while(2*k<=count)
        {
            int j=k*2;
            // j+1<=count k�ڵ�����Һ���
            if(j+1<=count&&data[j+1].compareTo(data[j])>0)
                j++;
            if(data[k].compareTo(data[j])>=0)  // ˵����kΪ�����������ok
                break;
            Util.swap(data,k,j);
            k=j;  // k����ӽ��
        }
    }

    public void shiftUp(int k)
    {
        //  k/2>=1  ��֤���и��ڵ�
        while (k/2>=1)
        {
            if(data[k].compareTo(data[k/2])>0)
            {
                Util.swap(data,k,k/2);
                k/=2;
            }
            else {
                break;
            }

        }
    }

    public Item extractMax()
    {
        Item max=data[1];
        Util.swap(data,1,count);
        count--;
        shiftdown(1);
        return max;
    }

    public void insert(Item item)
    {
        System.out.println("hehe");
        count++;
        if(count+1>capacity)
        {
            capacity=capacity+1;
            Item []newdata= (Item[]) new Comparable[capacity+1];
            System.arraycopy(data,1,newdata,1,capacity-1);
            data=newdata;
        }
        data[count]=item;
        shiftUp(count);
    }

    public  void print(Comparable []arr)
    {
        for (int i=0;i<=count;i++) {
            if(arr[i]==null)
            {
                continue;
            }
            System.out.print(arr[i]+" ");

        }
    }


    public static void main(String[] args) {
        Integer []a= Util.generateRandomArray(10,1,20);
        MaxHeap<Integer> maxHeap=new MaxHeap<>(a);
        maxHeap.print(maxHeap.data);
        System.out.println();
        System.out.println("---------ȥ�����Ԫ�غ󱣳�����ƽṹ----------");
        maxHeap.extractMax();
        maxHeap.print(maxHeap.data);
    }


}
