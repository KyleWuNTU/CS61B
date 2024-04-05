package Data_Structures.Queues;

public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    
    public Queue(){
        first = null;
        last = null;
    }

    public class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void addElement(T data){
        Queue<T>.Node<T> newNode = new Queue<T>.Node<>(data);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
    }

    public void removeElement(){
        if(isEmpty()){
            System.out.println("Cannot remove element from a blank queue.");
        }
        else{
            first = first.next;
        }
    }

    public void printFirst(){
        System.out.println(first.data);
    }

    public void printLast(){
        System.out.println(last.data);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.addElement(10);
        queue.addElement(20);
        queue.addElement(30);
        queue.removeElement();
        queue.printFirst();
        queue.printLast();
    }
}

