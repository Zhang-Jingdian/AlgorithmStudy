import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer>{

    //动态数组

    private int size=0;//逻辑大小
    private int capacity=8;//容量
    private int[] array = {};//ArrayList初始容量为10//懒惰初始化，利用时才有值，不用时默认值

    //添加元素
    public void addLast(int element){
    //  array[size]=element;
    //  size++;
        checkAndGrow();
        add(size,element);
    }
    //插入和添加元素
    public void add(int index,int element){
        checkAndGrow();
        //插入
        if(index>=0&&index<size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        //添加,若index==size
        //以下两行代码在添加与插入功能重复，将其提取到函数最后
        array[index]=element;
        size++;
    }

    private void checkAndGrow() {
        //容量检查
        if(size==0){
            array=new int[capacity];
        } else if (size == capacity) {
            //进行扩容，1.5倍
            capacity+=capacity>>1;
            //拷贝
            int[]newArray=new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array=newArray;
        }
    }

    //按索引查询
    public int get(int index){//[0,size)
        return array[index];
    }
    //遍历
    public void foreach(Consumer<Integer> consumer){
        for(int i=0;i<size;i++){
            //提供array[i]
            //返回void
            consumer.accept(array[i]);
        }
    }
    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i=0;
            @Override
            public boolean hasNext() {//有没有下一个元素
                return i<size;
            }

            @Override
            public Integer next() {//返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }
    //流遍历
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }
    //删除
    public int remove(int index){//[0,size)
        int removed = array[index];
        if(index<size-1){
            System.arraycopy(array,index+1,array,index,size-index-1);
        }
        //若删除最后一个元素
        size--;
        return removed;
    }
}
