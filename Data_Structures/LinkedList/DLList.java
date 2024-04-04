package Data_Structures.LinkedList;

public class DLList {
    private class IntNode {
        private int data;
        private IntNode prev;
        private IntNode next;

        private IntNode(int i, IntNode p, IntNode n) {
            data = i;
            prev = p;
            next = n;
        }    
    }
    
    private IntNode first;
    private IntNode last;

    public DLList(int x){
        last = new IntNode(x, null, null);
        first = new IntNode(x, null, last);
        last.prev = first;
    }

    public void addFirst(int num){
        IntNode newNode = new IntNode(num, null, first);
        first.prev = newNode;
        first = newNode;
    }

    public void addLast(int num){
        IntNode newNode = new IntNode(num, last, null);
        last.next = newNode;
        last = newNode;
    }

    public int getFirst(){
        return first.data;
    }

    public int getLast(){
        return last.data;
    }

    public static void main(String[] args) {
        DLList newlist = new DLList(10);
        newlist.addLast(20);
        System.out.println(newlist.getLast());
    }
}
