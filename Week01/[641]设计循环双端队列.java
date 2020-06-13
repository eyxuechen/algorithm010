//设计实现双端队列。 
//你的实现需要支持以下操作： 
//
// 
// MyCircularDeque(k)：构造函数,双端队列的大小为k。 
// insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。 
// insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 
// deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。 
// deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 
// getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。 
// getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 
// isEmpty()：检查双端队列是否为空。 
// isFull()：检查双端队列是否满了。 
// 
//
// 示例： 
//
// MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
//circularDeque.insertLast(1);			        // 返回 true
//circularDeque.insertLast(2);			        // 返回 true
//circularDeque.insertFront(3);			        // 返回 true
//circularDeque.insertFront(4);			        // 已经满了，返回 false
//circularDeque.getRear();  				// 返回 2
//circularDeque.isFull();				        // 返回 true
//circularDeque.deleteLast();			        // 返回 true
//circularDeque.insertFront(4);			        // 返回 true
//circularDeque.getFront();				// 返回 4
//  
//
// 
//
// 提示： 
//
// 
// 所有值的范围为 [1, 1000] 
// 操作次数的范围为 [1, 1000] 
// 请不要使用内置的双端队列库。 
// 
// Related Topics 设计 队列


//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque {
    //因为存数，我就用数组模拟内部存储结构了
    int size=0;
    int maxsize;
    int firstIx;
    int lastIx;
    private int[] array;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    //这个难点在于空时，firstIx=lastIx,非空时则firstIx<lastIx.
    //当k较大时，我这个数组有点浪费，可以考虑只多一个空地，姑且起名叫战略用地
    public MyCircularDeque(int k) {

        this.maxsize=k;
        //为了防止somebody一直前插或后插,默认第一个元素放置在中间，程序本身维护指针
        array=new int[k*2-1];
        firstIx=k-1;//数组中间的位置
        lastIx=k-1;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
       if(size>=0&&size<maxsize) {
           if(size==0) {
               array[firstIx] = value;
           }else {
               array[--firstIx] = value;
           }
           size++;
           return true;
       }
       return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size>=0&&size<maxsize) {
            if(size==0) {
                array[lastIx] = value;
            }else {
                array[++lastIx] =value;
            }
            size++;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size>0) {
            array[firstIx]=0;
            size--;
            if(lastIx>firstIx)firstIx++;
            return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(size>0) {
            array[lastIx]=0;
            if(lastIx>firstIx)lastIx--;
            size--;

            return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return size>0?array[firstIx]:-1;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return size>0?array[lastIx]:-1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size>=maxsize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
