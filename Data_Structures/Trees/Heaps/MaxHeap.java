package Data_Structures.Trees.Heaps;

public class MaxHeap {
    private int[] heap;
    private int heapSize;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heapSize = 0;
        heap = new int[this.capacity + 1];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private boolean isLeaf(int i) {
        return (heapSize / 2 <= i) && (i <= heapSize);
    }

    private void swap(int f, int s) {
        int tmp = heap[f];
        heap[f] = heap[s];
        heap[s] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int largest = pos;
    
            if (left <= heapSize && heap[left] > heap[largest]) {
                largest = left;
            }
    
            if (right <= heapSize && heap[right] > heap[largest]) {
                largest = right;
            }
    
            if (largest != pos) {
                swap(pos, largest);
                maxHeapify(largest);
            }
        }
    }
    

    public void insert(int num) {
        if (heapSize >= capacity) {
            return;
        }
        heapSize++;
        heap[heapSize] = num;
        int current = heapSize;
        while (heap[current] > heap[parent(current)]) { // Compare with parent and swap if necessary
            swap(current, parent(current));
            current = parent(current);
        }
        maxHeapify(current); // After insertion, ensure heap property is maintained
    }
    

    public void display() {
        System.out.println("PARENT NODE" + "\t" + "LEFT NODE" + "\t" + "RIGHT NODE");
        for (int i = 1; i <= heapSize / 2; i++) {
            System.out.print(" " + heap[i] + "\t\t" + (2 * i <= heapSize ? heap[2 * i] : "")
                    + "\t\t" + (2 * i + 1 <= heapSize ? heap[2 * i + 1] : ""));
            System.out.println();
        }
    }

    // build max heap
    public void maxHeap() {
        for (int pos = heapSize / 2; pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(12); 
        maxHeap.insert(15); 
        maxHeap.insert(30); 
        maxHeap.insert(40); 
        maxHeap.insert(50); 
        maxHeap.insert(90); 
        maxHeap.insert(45); 
        maxHeap.maxHeap();
        maxHeap.display();
    }
}
