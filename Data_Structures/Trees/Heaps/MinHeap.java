import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int heapSize;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heapSize = 0;
        heap = new int[this.capacity + 1];
        heap[0] = Integer.MIN_VALUE;
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

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int left = leftChild(pos);
            int right = rightChild(pos);
            int smallest = pos;

            if (left <= heapSize && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right <= heapSize && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != pos) {
                swap(pos, smallest);
                minHeapify(smallest);
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
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void display() {
        System.out.println("PARENT NODE" + "\t" + "LEFT NODE" + "\t" + "RIGHT NODE");
        for (int i = 1; i <= heapSize / 2; i++) {
            System.out.print(" " + heap[i] + "\t\t" + (2 * i <= heapSize ? heap[2 * i] : "")
                    + "\t\t" + (2 * i + 1 <= heapSize ? heap[2 * i + 1] : ""));
            System.out.println();
        }
    }

    // build min heap
    public void minHeap() {
        for (int pos = heapSize / 2; pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(12); 
        minHeap.insert(15); 
        minHeap.insert(30); 
        minHeap.insert(40); 
        minHeap.insert(50); 
        minHeap.insert(90); 
        minHeap.insert(45); 
        minHeap.minHeap();
        minHeap.display();
    }
}
