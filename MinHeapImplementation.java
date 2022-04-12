class MinHeapImplmentation {
 
    private int[] Heap;
    private int size;
    private int maxsize;
 
    private static final int FRONT = 1;
 
    public MinHeapImplmentation(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new int[this.maxsize ];
    }
    
    private int parent(int pos) {
    	return pos / 2;
    }
 
    private int lChild(int pos) { 
    	return (2 * pos);
    }

    private int rChild(int pos)
    {
        return (2 * pos) + 1;
    }
    
    private boolean isLeaf(int pos)
    {
 
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
 
        return false;
    }

    private void swap(int fpos, int spos)
    {
 
        int tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
 
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[lChild(pos)]
                || Heap[pos] > Heap[rChild(pos)]) {
                if (Heap[lChild(pos)]
                    < Heap[rChild(pos)]) {
                    swap(pos, lChild(pos));
                    minHeapify(lChild(pos));
                }
                else {
                    swap(pos, rChild(pos));
                    minHeapify(rChild(pos));
                }
            }
        }
    }
 
    public void insert(int element)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
       
        
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    public void print()
    {
        for(int i=1;i<=size;i++) {
        	System.out.print(Heap[i]+" ");
        }
    }

    public int remove()
    {
 
        int pop = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return pop;
    }

    public static void main(String[] arg)
    {
 
        System.out.println("The Min Heap is ");
        MinHeapImplmentation minHeap = new MinHeapImplmentation(15);
 
        minHeap.insert(7);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(23);
        minHeap.insert(18);
        minHeap.insert(6);
        minHeap.insert(19);
        minHeap.insert(2);
 
        minHeap.print();
        System.out.println();
        System.out.println("The Min val is "
                           + minHeap.remove());
        System.out.println("The Min Heap is ");
        minHeap.print();
    }
}
