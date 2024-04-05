package Data_Structures.Stacks;

public class Stack<T>{
    public Node first;
    public Node last;

    public Stack(){
        first = null;
        last = null;    
    }

    private static class Node<T> {
        private T data;
        private Node next;
        private Node prev;
        
        public Node(T data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void addElement(T data){
        Node<T> newNode = new Node<>(data);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }
        else{
            first.prev = newNode;
            newNode.next = first;
            first = newNode;
        }
    }

    public void removeElement(){
        if(isEmpty()){
            System.out.println("Cannot remove elment in a blank stack");
        }
        else{
            first = first.next;
            first.prev = null;
        }
    }

    public void printFirst(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(first.data);
        }
    }
    
    public void printLast(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(last.data);
        } 
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addElement(10);
        stack.addElement(20);
        stack.printFirst();
        stack.removeElement();
        stack.printFirst();
    }
}
